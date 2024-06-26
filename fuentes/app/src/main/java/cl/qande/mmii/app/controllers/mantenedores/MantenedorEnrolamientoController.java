package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IEnrolamientoClientesService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/mantenedores/enrolamiento")
public class MantenedorEnrolamientoController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    private static final String CAMPO_MODIFICAR_CLIENTE = "clienteDto";
    private static final String CAMPO_LISTA_TIPOS_ID = "listaTiposId";
    private static final String TITULO_CLIENTE = "Mantenedor Clientes";
    private static final String PREFIX_ERROR_VALID = "Error al modificar registro";
    private static final String PREFIX_ERROR_SAVE = "Error al guardar registro";
    private static final String REDIRECT = "redirect:";
    private static final String URL_CLIENTE = "/mantenedores/enrolamiento/cliente";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IEnrolamientoClientesService enrolamientoClientesService;

    //-----------------------------------------------------------------------------------------------------
    //Clientes
    //-----------------------------------------------------------------------------------------------------

    @GetMapping({"/cliente"})
    public String listaCliente(
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_TITULO, TITULO_CLIENTE);
        model.addAttribute(CAMPO_SESION, sesionWeb);

        model.addAttribute(CAMPO_LISTA_REGISTROS, enrolamientoClientesService.listarClientes());
        model.addAttribute(CAMPO_LISTA_TIPOS_ID, enrolamientoClientesService.listarTiposIdentificador());
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_CLIENTE, false);
    }

    @GetMapping({"/cliente/editar/{id}"})
    public String formularioEditarCliente(
            @PathVariable("id") Integer id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            clienteDto    = enrolamientoClientesService.listarClientePorId(id);
            model.addAttribute(CAMPO_MODIFICAR_CLIENTE, clienteDto);
        }
        return listaCliente(clienteDto, result, model);
    }

    @PostMapping({"/cliente/guardar", "/cliente/guardar/{id}"})
    public String modificaCliente(
            @PathVariable(value = "id", required = false) Integer id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model,
            @RequestParam(value= "cuenta") String cuenta) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (clienteDto.getIdentificador()==null || clienteDto.getIdentificador().isBlank()) {
            result.rejectValue("identificador", "error.clienteDto", "ID Cliente es obligatorio.");
        } else if (enrolamientoClientesService.listarClientePorIdentificador(clienteDto.getIdentificador()) != null) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID+": Ya existe el Identificador.");
            appConfig.customLog.error(PREFIX_ERROR_VALID +": Identificador de Cliente ya existe ["+clienteDto.getIdentificador()+"] ID Cliente  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }
        if (cuenta==null || cuenta.isBlank()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID+": Cuenta obligatoria.");
            appConfig.customLog.error(PREFIX_ERROR_VALID +": Cuenta no ingresada ID Cliente  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            appConfig.customLog.error(PREFIX_ERROR_VALID +" ID Cliente  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            this.addNotificationsOfErrors(result.getFieldErrors());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }

        appConfig.customLog.info("Actualizando registro ID Cliente  ["+id+"] cliente por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+clienteDto.toString()+"] ");
        try {
            var clienteGuardado = enrolamientoClientesService.guardarCliente(clienteDto);
            appConfig.customLog.info("Guardado Cliente ID  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+clienteDto.toString()+"] ");
            var cuentaDto = new CuentaDto();
            cuentaDto.setIdCliente(clienteGuardado.getId());
            cuentaDto.setIdCuentaCustodio(cuenta);
            cuentaDto.setIdCustodio("pershing");
            cuentaDto.setHabilitado(true);
            appConfig.customLog.info("Guardando Cuenta Cliente ID  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+cuentaDto.toString()+"] ");
            enrolamientoClientesService.guardarCuenta(cuentaDto);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE+": "+e.getMessage());
            } else {
                estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            }
            appConfig.customLog.error(PREFIX_ERROR_SAVE+" ID Cliente  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }
        return REDIRECT+ URL_CLIENTE;
    }
    private void addNotificationsOfErrors(List<FieldError> listOfErrors) {
        for ( var error : listOfErrors ) {
            var rejectedVal = error.getRejectedValue();
            if (rejectedVal!=null)
                appConfig.customLog.addNotification("Campo "+error.getField()+" no admite valor ["+rejectedVal.toString()+"]");
            else
                appConfig.customLog.addNotification("Campo "+error.getField()+" es obligatorio]");
        }
    }



}
