package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IEnrolamientoClientesService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Comparator;
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
    private static final String TITULO_COMIS_CTA = "Excepciones Comerciales a comisión";
    private static final String PREFIX_ERROR_VALID = "Error al modificar registro";
    private static final String PREFIX_ERROR_SAVE = "Error al guardar registro";
    private static final String REDIRECT = "redirect:";
    private static final String URL_CLIENTE = "/mantenedores/enrolamiento/cliente";
    private static final String URL_COMIS_CTA = "/mantenedores/enrolamiento/comision_cuenta";
    public static final String CONCAT_MSG_USER = "] por usuario [";
    public static final String CONCAT_MSG_VALOR = "]: Valor [";

    private final SesionWeb sesionWeb;
    private final AppConfig appConfig;
    private final IEnrolamientoClientesService enrolamientoClientesService;

    @Autowired
    public MantenedorEnrolamientoController(SesionWeb sesionWeb, AppConfig appConfig, IEnrolamientoClientesService enrolamientoClientesService) {
        this.sesionWeb = sesionWeb;
        this.appConfig = appConfig;
        this.enrolamientoClientesService = enrolamientoClientesService;
    }

    //-----------------------------------------------------------------------------------------------------
    //Clientes
    //-----------------------------------------------------------------------------------------------------

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_ENROL_CLIENTE))")
    @GetMapping({"/cliente"})
    public String listaCliente(
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_TITULO, TITULO_CLIENTE);
        model.addAttribute(CAMPO_SESION, sesionWeb);

        model.addAttribute(CAMPO_LISTA_REGISTROS, enrolamientoClientesService.listaClienteMaestro());
        model.addAttribute(CAMPO_LISTA_TIPOS_ID, enrolamientoClientesService.listarTiposIdentificador());
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_CLIENTE, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_ENROL_CLIENTE))")
    @GetMapping({"/cliente/editar/{id}"})
    public String formularioEditarCliente(
            @PathVariable("id") Integer id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            clienteDto    = enrolamientoClientesService.listarClientePorId(id);
            model.addAttribute(CAMPO_MODIFICAR_CLIENTE, clienteDto);
            var listaCuentasCliente  = enrolamientoClientesService.listarCuentasPorIdCliente(id, ",");

            model.addAttribute("listaCuentasCliente", listaCuentasCliente);
        }
        return listaCliente(clienteDto, result, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_ENROL_CLIENTE))")
    @PostMapping({"/cliente/guardar", "/cliente/guardar/{id}"})
    public String modificaCliente(
            @PathVariable(value = "id", required = false) Integer id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model,
            @RequestParam(value= "cuenta") String cuenta) throws QandeMmiiException {
        var estadoPeticion  = new EstadoPeticion();
        var esClienteNuevo  = (id==null || id==0);
        if (clienteDto.getIdentificador()==null || clienteDto.getIdentificador().isBlank()) {
            result.rejectValue("identificador", "error.clienteDto", "ID Cliente es obligatorio.");
        }
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            CustomLog.getInstance().error(PREFIX_ERROR_VALID +" ID Cliente  ["+id+ CONCAT_MSG_USER +sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ");
            this.addNotificationsOfErrors(result.getFieldErrors());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }
        if ( (cuenta==null || cuenta.isBlank()) && (esClienteNuevo) ) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID+": Cuenta obligatoria.");
            CustomLog.getInstance().error(PREFIX_ERROR_VALID +": Cuenta no ingresada ID Cliente  ["+id+ CONCAT_MSG_USER +sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }

        CustomLog.getInstance().info("Actualizando registro ID Cliente  ["+id+"] cliente por usuario ["+sesionWeb.getUsuario()+ CONCAT_MSG_VALOR +clienteDto.toString()+"] ");
        try {
            var clienteGuardado = enrolamientoClientesService.guardarCliente(clienteDto);
            CustomLog.getInstance().info("Guardado Cliente ID  ["+id+ CONCAT_MSG_USER +sesionWeb.getUsuario()+ CONCAT_MSG_VALOR +clienteDto.toString()+"] ");
            if (esClienteNuevo) {
                var cuentaDto = new CuentaDto();
                cuentaDto.setIdCliente(clienteGuardado.getId());
                cuentaDto.setIdCuentaCustodio(cuenta);
                cuentaDto.setIdCustodio("pershing");
                cuentaDto.setHabilitado(true);
                CustomLog.getInstance().info("Guardando Cuenta Cliente ID  ["+id+ CONCAT_MSG_USER +sesionWeb.getUsuario()+ CONCAT_MSG_VALOR +cuentaDto+"] ");
                enrolamientoClientesService.guardarCuenta(cuentaDto);
            }
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE+": "+e.getMessage());
            } else {
                estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            }
            CustomLog.getInstance().error(PREFIX_ERROR_SAVE+" ID Cliente  ["+id+ CONCAT_MSG_USER +sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCliente(id, clienteDto, result, model);
        }
        return REDIRECT+ URL_CLIENTE;
    }

    //-----------------------------------------------------------------------------------------------------
    //Comision Cuenta
    //-----------------------------------------------------------------------------------------------------

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_COMIS_CTA))")
    @GetMapping({"/comision_cuenta"})
    public String listarComisionCuenta(@Valid ComisionCuentaDto comisionCuentaDto,
                                       BindingResult result,
                                       Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_TITULO, TITULO_COMIS_CTA);
        model.addAttribute(CAMPO_SESION, sesionWeb);

        var listaClientes   = enrolamientoClientesService.listarClienteCuentaMaestro();
        listaClientes.sort(Comparator.comparing(ClienteCuentaMaestroDto::getNombreCliente));

        model.addAttribute("lista_clientes", listaClientes);
        var listaComisiones = enrolamientoClientesService.listarComisionCuenta();
        listaComisiones.sort(Comparator.comparing(ComisionMaestroDto::getNombreCliente)
                               .thenComparing(Comparator.comparing(ComisionMaestroDto::getFechaInicioVigencia).reversed()));
        model.addAttribute(CAMPO_LISTA_REGISTROS, listaComisiones);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_COMIS_CTA, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_COMIS_CTA))")
    @PostMapping({"/comision_cuenta"})
    public String guardarComisionCuenta(@Valid ComisionCuentaDto comisionCuentaDto,
                                       BindingResult result,
                                       Model model) throws QandeMmiiException {
        var estadoPeticion  = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            CustomLog.getInstance().error(PREFIX_ERROR_SAVE +" ID cuenta  ["+comisionCuentaDto.getIdCuenta()+ CONCAT_MSG_USER +sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ");
            this.addNotificationsOfErrors(result.getFieldErrors());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listarComisionCuenta(comisionCuentaDto, result, model);
        }
        //Siempre es nuevo registro
        comisionCuentaDto.setId(null);
        comisionCuentaDto.setLogUsuarioCreacion(sesionWeb.getUsuario());
        comisionCuentaDto.setLogFechaCreacion(Instant.now());
        try {
            var resultado   = enrolamientoClientesService.guardarComisionCuenta(comisionCuentaDto);
            CustomLog.getInstance().info("Guardado Comisión Cuenta ID  ["+resultado.getIdCuenta()+ CONCAT_MSG_USER +sesionWeb.getUsuario()+ CONCAT_MSG_VALOR +resultado.toString()+"] ");
            estadoPeticion.setEstadoOk("Registro guardado correctamente (ID: "+resultado.getId()+")");
        } catch (Exception e) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            CustomLog.getInstance().error(PREFIX_ERROR_SAVE+" ID cuenta  ["+comisionCuentaDto.getIdCuenta()+ CONCAT_MSG_USER +sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listarComisionCuenta(comisionCuentaDto, result, model);
        }
        return REDIRECT+ URL_COMIS_CTA;
    }


    //-----------------------------------------------------------------------------------------------------
    //Auxiliares
    //-----------------------------------------------------------------------------------------------------

    private void addNotificationsOfErrors(List<FieldError> listOfErrors) {
        for ( var error : listOfErrors ) {
            var rejectedVal = error.getRejectedValue();
            if (rejectedVal!=null)
                sesionWeb.addNotification("Campo "+error.getField()+" no admite valor ["+rejectedVal.toString()+"]");
            else
                sesionWeb.addNotification("Campo "+error.getField()+" es obligatorio]");
        }
    }



}
