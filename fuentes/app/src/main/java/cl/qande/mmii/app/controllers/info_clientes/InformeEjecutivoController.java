package cl.qande.mmii.app.controllers.info_clientes;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.rep_inv.ReporteInversionesService;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.EnrolamientoClientesService;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.Supplier;

@Controller
@RequestMapping("/info_clientes/informe_ejecutivo")
public class InformeEjecutivoController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_LISTA_CLIENTES    = "lista_clientes";
    private static final String CAMPO_LISTA_CUENTAS    = "lista_cuentas";
    private static final String CAMPO_CLIENTE_DEFAULT    = "clienteDefault";
    private static final String CAMPO_CUENTA_DEFAULT    = "cuentaDefault";
    private static final String CAMPO_START_DATE    = "startProcessDate";
    private static final String CAMPO_END_DATE    = "endProcessDate";
    private static final String SALDO_INICIAL = "saldo_inicial";
    private static final String SALDO_FINAL = "saldo_final";
    private static final String LISTA_MOVIMIENTOS = "lista_movimientos";
    private static final String ULTIMOS_RECAUDOS = "ultimos_recaudos";
    private static final String FECHAS_RECAUDOS = "fechas_recaudos";
    private static final String DETALLE_SALDO = "detalle_saldo";
    private static final String DETALLE_SALDO_PERIODO = "detalle_saldo_periodo";
    private static final String DETALLE_CLIENTE = "detalle_cliente";
    private static final String DETALLE_RETORNOS = "detalle_retornos";
    private static final String RETORNO_ACTUAL = "retorno_actual";
    private static final String INFORME_EJECUTIVO_CIENTE = "Informe Ejecutivo Ciente";
    private static final int LIMIT_ULT_RECAUDOS = 10;

    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;
    private final ReporteMaestroDatosService reporteMaestroDatosService;
    private final EnrolamientoClientesService enrolamientoClientesService;
    private final ReporteInversionesService reporteInversionesService;

    public InformeEjecutivoController(SesionWeb sesionWeb, CalendarioHelper calendarioHelper, ReporteMaestroDatosService reporteMaestroDatosService, EnrolamientoClientesService enrolamientoClientesService, ReporteInversionesService reporteInversionesService) {
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
        this.enrolamientoClientesService = enrolamientoClientesService;
        this.reporteInversionesService = reporteInversionesService;
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CTES_INFOREJEC))")
    @GetMapping({"/", ""})
    public String resultadoInformeEjecutivo(Model model) throws QandeMmiiException {
        var currentProceesDate =calendarioHelper.defaultProcessDate();

        cargaDatosCliente(model, null, null, null, null, null);
        cargarCombos(model, null, null);

        model.addAttribute(CAMPO_STATUS, new EstadoPeticion(0, "Página cargada correctamente", "Ingrese criterios de búsqueda"));
        model.addAttribute(CAMPO_START_DATE, currentProceesDate);
        model.addAttribute(CAMPO_END_DATE, currentProceesDate);
        model.addAttribute(CAMPO_TITULO, INFORME_EJECUTIVO_CIENTE);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CTES_INFOREJEC, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CTES_INFOREJEC))")
    @PostMapping({"/", ""})
    public String resultadoInformeEjecutivo(
            Model model,
            @RequestParam(value= "fecha_desde") String startProcessDate,
            @RequestParam(value= "fecha_hasta") String endProcessDate,
            @RequestParam(value= "cliente") String cliente,
            @RequestParam(value= "cuenta", required = false, defaultValue = "") String cuenta
    ) throws QandeMmiiException {
        var estadoPeticion      = new EstadoPeticion(0, "Página cargada correctamente", "Datos consultados correctamente");
        var currentProceesDate  = calendarioHelper.defaultProcessDate();
        var cuentaNormalizada   = normalizarCuenta(cuenta);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);

        try {
            cargaDatosCliente(model, currentProceesDate, startProcessDate, endProcessDate, cliente, cuentaNormalizada);
        } catch (Exception e) {
            estadoPeticion.setEstadoError( "Error al cargar datos del cliente");
            cargaDatosCliente(model, null, null, null, null, null);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
        }

        cargarCombos(model, cliente, cuenta);

        model.addAttribute(CAMPO_START_DATE, startProcessDate);
        model.addAttribute(CAMPO_END_DATE, endProcessDate);
        model.addAttribute(CAMPO_TITULO, INFORME_EJECUTIVO_CIENTE);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CTES_INFOREJEC, false);
    }

    /****************************************
    * Métodos auxiliares
    ****************************************/
    private String normalizarCuenta(String cuenta) {
        if (cuenta == null)
            return null;
        if (cuenta.isBlank())
            return null;
        var cuentaSplit = cuenta.split("\\|\\|");
        if (cuentaSplit.length > 1) {
            return cuentaSplit[1];
        }
        return null;
    }

    private void cargarCombos(Model model, String defaultCliente, String defaultCuenta) {
        var resultadoClientes = enrolamientoClientesService.listaUniversoClientes(null);
        model.addAttribute(CAMPO_LISTA_CLIENTES, resultadoClientes);
        model.addAttribute(CAMPO_CLIENTE_DEFAULT, defaultCliente);

        var resultadoCuentas = enrolamientoClientesService.listaUniversoCuentas(null);
        model.addAttribute(CAMPO_LISTA_CUENTAS, resultadoCuentas);
        model.addAttribute(CAMPO_CUENTA_DEFAULT, defaultCuenta);
    }

    private void cargaDatosCliente(Model model, String currentProceesDate, String startProcessDate, String endProcessDate, String clientId, String accountNo) {
        if (currentProceesDate==null || startProcessDate==null || endProcessDate==null || clientId==null) {
            model.addAttribute(SALDO_INICIAL, null);
            model.addAttribute(SALDO_FINAL, null);
            model.addAttribute(LISTA_MOVIMIENTOS, null);
            model.addAttribute(DETALLE_SALDO, null);
            model.addAttribute(DETALLE_SALDO_PERIODO, null);
            model.addAttribute(DETALLE_CLIENTE, null);
            return;
        }

        //Saldo consolidado inicial a la fecha start por cada cuenta
        safeAddToModel(() -> reporteMaestroDatosService.resumenSaldoPorCuenta(startProcessDate, clientId, accountNo), "saldo inicial", model, SALDO_INICIAL);
        //Saldo consolidado final a la fecha end por cada cuenta
        safeAddToModel(() -> reporteMaestroDatosService.resumenSaldoPorCuenta(endProcessDate, clientId, accountNo), "saldo final", model, SALDO_FINAL);
        //Detalle de saldos a la fecha actual (hoy) por cada cuenta
        safeAddToModel(() -> reporteMaestroDatosService.saldoCliente(currentProceesDate, currentProceesDate, clientId, accountNo, true), "detalle saldo actual", model, DETALLE_SALDO);
        //Detalle de saldos al inicio/término del rango de búsqueda
        safeAddToModel(() -> reporteMaestroDatosService.saldoCliente(startProcessDate, endProcessDate, clientId, accountNo,true), "detalle saldo periodo", model, DETALLE_SALDO_PERIODO);

        //Obtenemos movimientos para el rango de fechas por cada cuenta
        safeAddToModel(() -> reporteMaestroDatosService.movimientosCliente(startProcessDate, endProcessDate, clientId, accountNo), "movimientos del periodo", model, LISTA_MOVIMIENTOS);
        safeAddToModel(() -> reporteMaestroDatosService.ultimosRecaudos(clientId, accountNo, LIMIT_ULT_RECAUDOS), "últimos recaudos", model, ULTIMOS_RECAUDOS);
        safeAddToModel(() -> reporteMaestroDatosService.fechasFirstLastRecaudos(clientId, accountNo), "primer y último recuado", model, FECHAS_RECAUDOS);

        //Obtenemos datos demográficos del cliente (nombre)
        safeAddToModel(() -> reporteMaestroDatosService.datosCliente(currentProceesDate, clientId, accountNo), "información del cliente", model, DETALLE_CLIENTE);

        //Obtenemos Retornos
        safeAddToModel(() -> reporteInversionesService.calculaRentabilidad(clientId, accountNo, null, null, endProcessDate, endProcessDate, true), "retornos del periodo", model, DETALLE_RETORNOS);
        safeAddToModel(() -> reporteInversionesService.calculaRentabilidad(clientId, accountNo, null, null, currentProceesDate, currentProceesDate, true), "retorno actual", model, RETORNO_ACTUAL);

    }

    private <T> void safeAddToModel(Supplier<T> supplier, String nombreOperacion, Model model, String atrributeName) {
        try {
            model.addAttribute(atrributeName, supplier.get());
            sesionWeb.addNotification("Datos " + nombreOperacion + " obtenidos correctamente");
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al obtener " + nombreOperacion + ":" + e.getMessage(), false);
            sesionWeb.addNotification("Error al obtener " + nombreOperacion);
            model.addAttribute(CAMPO_STATUS, new EstadoPeticion(true, "Error al obtener datos", "No se pudieron cargar algunos datos del cliente"));
            model.addAttribute(atrributeName, null);
        }
    }
}
