package cl.qande.mmii.app.controllers.retornos;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.rep_inv.ReporteInversionesService;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.EnrolamientoClientesService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/retornos")
public class ReporteInversionesController {
    private static final String CAMPO_LISTA_CLIENTES    = "lista_clientes";
    private static final String CAMPO_LISTA_CUENTAS    = "lista_cuentas";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    private static final String CAMPO_CLIENTE_DEFAULT    = "clienteDefault";
    private static final String CAMPO_CUENTA_DEFAULT    = "cuentaDefault";
    private static final String CAMPO_START_DATE    = "startProcessDate";
    private static final String CAMPO_END_DATE    = "endProcessDate";
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String OK_MSG    = "Detalle ok";
    private static final String OK_DET    = "Detalle listado correctamente";
    private final ReporteInversionesService reporteInversionesService;
    private final EnrolamientoClientesService enrolamientoClientesService;
    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;

    @Autowired
    public ReporteInversionesController(ReporteInversionesService reporteInversionesService, EnrolamientoClientesService enrolamientoClientesService, SesionWeb sesionWeb, CalendarioHelper calendarioHelper) {
        this.reporteInversionesService = reporteInversionesService;
        this.enrolamientoClientesService = enrolamientoClientesService;
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
    }


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_BASE))")
    @GetMapping({"/base-consolidada"})
    public String verBaseConsolidada(
            Model model
    ) throws QandeMmiiException {

        model.addAttribute(CAMPO_TITULO, "Base Cálculo");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        this.setDefaultModelAttributes(model);
        this.setClientAccountModelAttributes(model);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_INV_BASE, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_BASE))")
    @PostMapping({"/base-consolidada"})
    public String consultarBaseConsolidada(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta", required = false) String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
        if (cliente == null || cliente.isEmpty()) {
            estadoPeticion.setEstadoWarning("Campo Cliente obligatorio", "Debe elegir un Cliente");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            model.addAttribute(CAMPO_START_DATE, fechaDesde);
            model.addAttribute(CAMPO_END_DATE, fechaHasta);
            return verBaseConsolidada(model);
        }
        if (cuenta == null || cuenta.isEmpty()) {
            cuenta=null;
        }
        try {
            var salida	= reporteInversionesService.listaBaseConsolidadaPorClienteCuenta(fechaDesde, fechaHasta, cliente, cuenta);
            model.addAttribute(CAMPO_LISTA_REGISTROS, salida);
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
        } catch (Exception e) {
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
            estadoPeticion.setEstadoError("Error al obtener base cálculo");
            CustomLog.getInstance().info("Error al obtener base cálculo: " + e.getMessage(), false);
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verBaseConsolidada(model);
    }


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_PRECALC))")
    @GetMapping({"/base-agregada"})
    public String verBaseAgregada(
            Model model
    ) throws QandeMmiiException {

        model.addAttribute(CAMPO_TITULO, "Base Agregada");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        this.setDefaultModelAttributes(model);
        this.setClientAccountModelAttributes(model);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_INV_PRECALC, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_PRECALC))")
    @PostMapping({"/base-agregada"})
    public String consultarBaseAgregada(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta", required = false) String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
        if (cliente == null || cliente.isEmpty()) {
            estadoPeticion.setEstadoWarning("Campo Cliente obligatorio", "Debe elegir un Cliente");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            model.addAttribute(CAMPO_START_DATE, fechaDesde);
            model.addAttribute(CAMPO_END_DATE, fechaHasta);
            return verBaseAgregada(model);
        }
        if (cuenta == null || cuenta.isEmpty()) {
            cuenta=null;
        }

        try {
            var salidaNivel1	= reporteInversionesService.listaConsolidadoAgregadoPorcliente(fechaDesde, fechaHasta, cliente);
            var salidaNivel2	= reporteInversionesService.listaConsolidadoAgregadoPorclienteCuenta(fechaDesde, fechaHasta, cliente, cuenta);
            model.addAttribute("lista_registros_nivel1", salidaNivel1);
            model.addAttribute("lista_registros_nivel2", salidaNivel2);
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
        } catch (Exception e) {
            model.addAttribute("lista_registros_nivel1", null);
            model.addAttribute("lista_registros_nivel2", null);
            estadoPeticion.setEstadoError("Error al obtener base agregada");
            CustomLog.getInstance().info("Error al obtener base agregada: " + e.getMessage(), false);
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verBaseAgregada(model);
    }



    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_RENT))")
    @GetMapping({"/detalle-rentabilidad-cliente"})
    public String verDetalleRentabilidadCliente(
            Model model
    ) throws QandeMmiiException {

        model.addAttribute(CAMPO_TITULO, "Detalle Rentabilidad Cliente");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        this.setDefaultModelAttributes(model);
        this.setClientAccountModelAttributes(model);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_INV_RENT, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_RENT))")
    @PostMapping({"/detalle-rentabilidad-cliente"})
    public String consultarDetalleRentabilidadCliente(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta", required = false) String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
        try {
            var salida	= reporteInversionesService.calculaRentabilidad(cliente, cuenta, null, null, fechaDesde, fechaHasta, true);
            model.addAttribute(CAMPO_LISTA_REGISTROS, salida);
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
        } catch (Exception e) {
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
            estadoPeticion.setEstadoError("Error al obtener rentabilidad");
            CustomLog.getInstance().info("Error al obtener rentabilidad: " + e.getMessage(), false);
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verDetalleRentabilidadCliente(model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_INV_CONTRL))")
    @GetMapping({"/controles", "/controles/{processDate}/{execMonthly}"})
    public String consultarResultadoControl(
            Model model,
            @PathVariable(value="processDate", required = false) String processDate,
            @PathVariable(value="execMonthly", required = false) Boolean execMonthly
    ) throws QandeMmiiException {
        var estadoPeticion  = new EstadoPeticion();
        if (processDate == null || processDate.isEmpty()) {
            processDate = calendarioHelper.defaultProcessDate();
        }

        try {
            var salida	= reporteInversionesService.resultadoControl(processDate, execMonthly, true);
            model.addAttribute(CAMPO_LISTA_REGISTROS, salida);
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
        } catch (Exception e) {
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
            estadoPeticion.setEstadoError("Error al consultar controles");
            CustomLog.getInstance().info("Error al consultar controles: " + e.getMessage(), false);
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("processDate", processDate);
        model.addAttribute(CAMPO_TITULO, "Controles Retornos");
        model.addAttribute(CAMPO_SESION, sesionWeb);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_INV_CONTRL, false);
    }


    private Model setDefaultModelAttributes(Model model) {
        if (model.getAttribute(CAMPO_START_DATE)==null || model.getAttribute(CAMPO_END_DATE)==null) {
            model.addAttribute(CAMPO_START_DATE, calendarioHelper.defaultProcessDate());
            model.addAttribute(CAMPO_END_DATE, calendarioHelper.defaultProcessDate());
            model.addAttribute(CAMPO_CLIENTE_DEFAULT, null);
            model.addAttribute(CAMPO_CUENTA_DEFAULT, null);
        }
        return model;
    }

    private Model setClientAccountModelAttributes(Model model) {
        var resultadoClientes = enrolamientoClientesService.listaUniversoClientes(null);
        model.addAttribute(CAMPO_LISTA_CLIENTES, resultadoClientes);

        var resultadoCuentas = enrolamientoClientesService.listaUniversoCuentas(null);
        model.addAttribute(CAMPO_LISTA_CUENTAS, resultadoCuentas);

        return model;
    }

}
