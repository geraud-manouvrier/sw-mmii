package cl.qande.mmii.app.controllers.reporte_inversiones;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteInversionesService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reporte-inversiones")
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
    @Autowired
    private IReporteInversionesService reporteInversionesService;
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;


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
    @PostMapping({"/base-consolidada"})
    public String consultarBaseConsolidada(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta") String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
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
            appConfig.customLog.info("Error al obtener base cálculo: " + e.getMessage());
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verBaseConsolidada(model);
    }


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
    @PostMapping({"/base-agregada"})
    public String consultarBaseAgregada(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta") String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
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
            appConfig.customLog.info("Error al obtener base agregada: " + e.getMessage());
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verBaseAgregada(model);
    }



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

    @PostMapping({"/detalle-rentabilidad-cliente"})
    public String consultarDetalleRentabilidadCliente(
            Model model,
            @RequestParam(value= "fecha_desde") String fechaDesde,
            @RequestParam(value= "fecha_hasta") String fechaHasta,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta") String cuenta
    ) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
        try {
            var salida	= reporteInversionesService.calculaRentabilidad(cliente, cuenta, null, null, fechaDesde, fechaHasta, true);
            model.addAttribute(CAMPO_LISTA_REGISTROS, salida);
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
        } catch (Exception e) {
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
            estadoPeticion.setEstadoError("Error al obtener rentabilidad");
            appConfig.customLog.info("Error al obtener rentabilidad: " + e.getMessage());
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_DATE, fechaDesde);
        model.addAttribute(CAMPO_END_DATE, fechaHasta);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, cliente);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, cuenta);

        return verDetalleRentabilidadCliente(model);
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
        var resultadoClientes = reporteInversionesService.listaUniversoClientes(null);
        model.addAttribute(CAMPO_LISTA_CLIENTES, resultadoClientes);
        resultadoClientes.forEach(item -> appConfig.customLog.info("Salida Clientes: " + item.getProjectionAsString()));

        var resultadoCuentas = reporteInversionesService.listaUniversoCuentas(null);
        model.addAttribute(CAMPO_LISTA_CUENTAS, resultadoCuentas);
        resultadoCuentas.forEach(item -> appConfig.customLog.info("Salida Cuentas: " + item.getProjectionAsString()));

        return model;
    }

}
