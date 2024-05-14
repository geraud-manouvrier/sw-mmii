package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.core.entity.ParPaisAtencion;
import cl.qande.mmii.app.models.db.sura.dao.IContratoDao;
import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IClienteService;
import cl.qande.mmii.app.models.service.ICuentaService;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import cl.qande.mmii.app.models.service.IPerfilCuentaService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping("/mantenedores/enrolamiento")
public class MantenedorEnrolamientoController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";

    private static final String CAMPO_MODIFICAR_CLIENTE = "clienteDto";
    private static final String CAMPO_MODIFICAR_CONTRATO = "contrato";
    private static final String CAMPO_MODIFICAR_CUENTA = "cuenta";
    private static final String CAMPO_MODIFICAR_PERFIL = "perfilCuenta";
    private static final String CAMPO_LISTA_PAISES_ATEN = "listaPaisesAtencion";
    private static final String CAMPO_LISTA_PAISES_RES = "listaPaisesResidencia";

    private static final String TITULO_CLIENTE = "Mantenedor Clientes";
    private static final String TITULO_CONTRATO = "Mantenedor Contratos";
    private static final String TITULO_CUENTA = "Mantenedor Cuentas";
    private static final String TITULO_PERFIL = "Mantenedor Perfiles";
    private static final String PREFIX_ERROR_VALID = "Error al modificar registro";
    private static final String PREFIX_ERROR_SAVE = "Error al guardar registro";

    private static final String REDIRECT = "redirect:";
    private static final String URL_CLIENTE = "/mantenedores/enrolamiento/cliente";
    private static final String URL_CONTRATO = "/mantenedores/enrolamiento/contrato";
    private static final String URL_CUENTA = "/mantenedores/enrolamiento/cuenta";
    private static final String URL_PERFIL = "/mantenedores/enrolamiento/perfil_cuenta";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IEnrolamientoClienteParService enrolamientoClienteParService;
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IContratoDao contratoDao;
    @Autowired
    private ICuentaService cuentaService;
    @Autowired
    private IPerfilCuentaService perfilCuentaService;

    //-----------------------------------------------------------------------------------------------------
    //Clientes
    //-----------------------------------------------------------------------------------------------------

    @GetMapping({"/cliente"})
    public String listaCliente(
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, clienteService.listaClientes());
        model.addAttribute(CAMPO_TITULO, TITULO_CLIENTE);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_LISTA_PAISES_ATEN, this.listaPaisAtencion(true, "Seleccione uno"));
        model.addAttribute(CAMPO_LISTA_PAISES_RES, this.listaPaisResidencia(true, "Seleccione uno"));
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_CLIENTE, false);
    }

    @GetMapping({"/cliente/editar/{id}"})
    public String formularioEditarCliente(
            @PathVariable("id") String id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            clienteDto    = clienteService.clienteById(id);
            model.addAttribute(CAMPO_MODIFICAR_CLIENTE, clienteDto);
        }
        return listaCliente(clienteDto, result, model);
    }
    @PostMapping({"/cliente/guardar", "/cliente/guardar/{id}"})
    public String modificaCliente(
            @PathVariable(value = "id", required = false) String id,
            @Valid ClienteDto clienteDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (id==null || id.isBlank()) {
            result.rejectValue("id", "error.clienteDto", "ID cliente es obligatorio.");
        }
         if (clienteDto.getCodPaisResidencia()==null || clienteDto.getCodPaisResidencia().isBlank()) {
            result.rejectValue("codPaisResidencia", "error.clienteDto", "Pais de residencia no válido.");
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
            clienteService.isValid(clienteDto);
            clienteService.save(clienteDto);
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

    //-----------------------------------------------------------------------------------------------------
    //Contratos
    //-----------------------------------------------------------------------------------------------------

    @GetMapping({"/contrato"})
    public String listaContrato(
            @Valid Contrato contrato,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, contratoDao.findAll());
        model.addAttribute(CAMPO_TITULO, TITULO_CONTRATO);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_CONTRATO, false);
    }

    @GetMapping({"/contrato/editar/{id}"})
    public String formularioEditarContrato(
            @PathVariable("id") String id,
            @Valid Contrato contrato,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            contrato    = contratoDao.findById(id).orElse(null);
            model.addAttribute(CAMPO_MODIFICAR_CONTRATO, contrato);
        }
        return listaContrato(contrato, result, model);
    }
    @PostMapping({"/contrato/guardar/{id}"})
    public String modificaContrato(
            @PathVariable("id") String id,
            @Valid Contrato contrato,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            appConfig.customLog.error(PREFIX_ERROR_VALID +" ID Contrato  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarContrato(id, contrato, result, model);
        }
        appConfig.customLog.info("Actualizando registro ID Contrato  ["+id+"] contrato por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+contrato.toString()+"] ");
        try {
            contratoDao.save(contrato);
        } catch (Exception e) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            appConfig.customLog.error(PREFIX_ERROR_SAVE+" ID Contrato  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarContrato(id, contrato, result, model);
        }
        return REDIRECT+ URL_CONTRATO;
    }

    //-----------------------------------------------------------------------------------------------------
    //Cuentas
    //-----------------------------------------------------------------------------------------------------
    @GetMapping({"/cuenta"})
    public String listaCuenta(
            @Valid Cuenta cuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, cuentaService.listaCuentas());
        model.addAttribute(CAMPO_TITULO, TITULO_CUENTA);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_LISTA_PAISES_ATEN, this.listaPaisAtencion(true, "Sin asignar"));
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_CUENTA, false);
    }

    @GetMapping({"/cuenta/editar/{idCuentaSura}"})
    public String formularioEditarCuenta(
            @PathVariable("idCuentaSura") String idCuentaSura,
            @Valid Cuenta cuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            cuenta    = cuentaService.cuentaById(idCuentaSura);
            model.addAttribute(CAMPO_MODIFICAR_CUENTA, cuenta);
        }
        return listaCuenta(cuenta, result, model);
    }

    @PostMapping({"/cuenta/guardar/{idCuentaSura}"})
    public String modificaCuenta(
            @PathVariable("idCuentaSura") String idCuentaSura,
            @Valid Cuenta cuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            appConfig.customLog.error(PREFIX_ERROR_VALID+" ID Cta. SURA  ["+idCuentaSura+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCuenta(idCuentaSura, cuenta, result, model);
        }
        appConfig.customLog.info("Actualizando registro ID Cta. SURA  ["+idCuentaSura+"] cuenta por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+cuenta.toString()+"] ");
        try {
            cuentaService.save(cuenta);
        } catch (Exception e) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            appConfig.customLog.error(PREFIX_ERROR_SAVE+" ID Cta. SURA  ["+idCuentaSura+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarCuenta(idCuentaSura, cuenta, result, model);
        }
        return REDIRECT+ URL_CUENTA;
    }

    //-----------------------------------------------------------------------------------------------------
    //Perfiles
    //-----------------------------------------------------------------------------------------------------

    @GetMapping({"/perfil_cuenta"})
    public String listaPerfilCuenta(
            @Valid PerfilCuenta perfilCuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, perfilCuentaService.listaPerfilCuenta());
        model.addAttribute(CAMPO_TITULO, TITULO_PERFIL);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_ENROL_PERFIL, false);
    }

    @GetMapping({"/perfil_cuenta/editar/{id}"})
    public String formularioEditarPerfilCuenta(
            @PathVariable("id") Long id,
            @Valid PerfilCuenta perfilCuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            perfilCuenta    = perfilCuentaService.perfilCuentaById(id);
            model.addAttribute(CAMPO_MODIFICAR_PERFIL, perfilCuenta);
        }
        return listaPerfilCuenta(perfilCuenta, result, model);
    }
    @PostMapping({"/perfil_cuenta/guardar", "/perfil_cuenta/guardar/{id}"})
    public String modificaPerfilCuenta(
            @PathVariable("id") Long id,
            @Valid PerfilCuenta perfilCuenta,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        //Omitimos los errores de la fecha, ya que se auto-calculará
        if (result.hasErrors() && result.getFieldErrorCount("fechaVigencia")!=result.getFieldErrorCount()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            appConfig.customLog.error(PREFIX_ERROR_VALID+" ID PerfilCuenta  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+result.getAllErrors()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarPerfilCuenta(id, perfilCuenta, result, model);
        }
        appConfig.customLog.info("Actualizando registro ID PerfilCuenta  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: Valor ["+perfilCuenta.toString()+"] ");
        try {
            var nuevoPerfilCuenta        = new PerfilCuenta();
            nuevoPerfilCuenta.setIdPerfil(perfilCuenta.getIdPerfil());
            nuevoPerfilCuenta.setIdCuentaSura(perfilCuenta.getIdCuentaSura());
            nuevoPerfilCuenta.setPortfolio(perfilCuenta.getPortfolio());
            nuevoPerfilCuenta.setMontoComprometido(perfilCuenta.getMontoComprometido());
            nuevoPerfilCuenta.setFechaVigencia(calendarioHelper.hoyConDesfaseDias(0));
            nuevoPerfilCuenta.setHorizonteObjetivo(perfilCuenta.getHorizonteObjetivo());
            nuevoPerfilCuenta.setExencionResponsabilidad(perfilCuenta.getExencionResponsabilidad());
            perfilCuentaService.add(nuevoPerfilCuenta);
        } catch (Exception e) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_SAVE, PREFIX_ERROR_SAVE);
            appConfig.customLog.error(PREFIX_ERROR_SAVE+" ID PerfilCuenta  ["+id+"] por usuario ["+sesionWeb.getUsuario()+"]: ["+e.getMessage()+"] ", estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarPerfilCuenta(id, perfilCuenta, result, model);
        }
        return REDIRECT+ URL_PERFIL;
    }

    public List<ParPaisAtencion> listaPaisAtencion(boolean withNull, String glosaNull) {
        List<ParPaisAtencion> listaFinal = new ArrayList<>();
        if (withNull) {
            ParPaisAtencion paisNulo    = new ParPaisAtencion();
            paisNulo.setId(null);
            paisNulo.setGlosa(glosaNull);
            listaFinal.add(paisNulo);
        }

        var listaPaises = enrolamientoClienteParService.listaPaisAtencion();
        listaFinal.addAll(listaPaises);
        return listaFinal;
    }

    public List<ParPaisAtencion> listaPaisResidencia(boolean withNull, String glosaNull) {
        List<ParPaisAtencion> listaFinal = new ArrayList<>();
        if (withNull) {
            ParPaisAtencion paisNulo    = new ParPaisAtencion();
            paisNulo.setId(null);
            paisNulo.setGlosa(glosaNull);
            listaFinal.add(paisNulo);
        }

        var listaPaises = enrolamientoClienteParService.listaPaisResidencia();
        listaFinal.addAll(listaPaises);
        return listaFinal;
    }

}
