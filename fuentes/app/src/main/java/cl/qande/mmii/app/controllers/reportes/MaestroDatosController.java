package cl.qande.mmii.app.controllers.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosMovimientosDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes/maestro_datos")
public class MaestroDatosController {
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String HTML_SALIDA_REPORTE    = "salidaReporte";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IReporteMaestroDatosClientesDao maestroDatosClientesDao;
    @Autowired
    private IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao;
    @Autowired
    private IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao;

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_CLIENTE))")
    @GetMapping({"/clientes"})
    public String clientes(
            Model model) {

        return "redirect:/reportes/maestro_datos/clientes/fecha/"+calendarioHelper.defaultProcessDate();
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_CLIENTE))")
    @GetMapping({"/clientes/fecha/{processDate}"})
    public String clientesPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var salidaReporte   = maestroDatosClientesDao.findByProcessDateBetween(processDate, processDate);
            estadoPeticion.setEstadoOk("Listado clientes OK", "Listado de Clientes generado correctamente");
            model.addAttribute(HTML_SALIDA_REPORTE, salidaReporte);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al listar reporte Maestro Clientes con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar Clientes", "Se produjo un error al listar los clientes");
            model.addAttribute(HTML_SALIDA_REPORTE, null);
        }
        model.addAttribute(CAMPO_TITULO, "Maestro Datos - Clientes");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("processDate", processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_MAESTRO_CLIENTE, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_SALDOS))")
    @GetMapping({"/saldos"})
    public String saldos(
            Model model) {

        return "redirect:/reportes/maestro_datos/saldos/fecha_desde/"+calendarioHelper.defaultProcessDate()+"/fecha_hasta/"+calendarioHelper.defaultProcessDate();
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_SALDOS))")
    @GetMapping({"/saldos/fecha_desde/{startProcessDate}/fecha_hasta/{endProcessDate}"})
    public String saldosPorRangoDeFechas(
            @PathVariable String startProcessDate,
            @PathVariable String endProcessDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var salidaReporte   = reporteMaestroDatosSaldoDao.findByProcessDateBetween(startProcessDate, endProcessDate);
            estadoPeticion.setEstadoOk("Listado saldos OK", "Listado de Saldos generado correctamente");
            model.addAttribute(HTML_SALIDA_REPORTE, salidaReporte);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al listar reporte Maestro Saldos con rango fechas [" + startProcessDate + " - "+endProcessDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar Saldos", "Se producjo un error al listar los saldos");
            model.addAttribute(HTML_SALIDA_REPORTE, null);
        }
        model.addAttribute(CAMPO_TITULO, "Maestro Datos - Saldos");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("startProcessDate", startProcessDate);
        model.addAttribute("endProcessDate", endProcessDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_MAESTRO_SALDOS, false);
    }



    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_MOVTOS))")
    @GetMapping({"/movimientos"})
    public String movimientos(
            Model model) {

        return "redirect:/reportes/maestro_datos/movimientos/fecha_desde/"+calendarioHelper.defaultProcessDate()+"/fecha_hasta/"+calendarioHelper.defaultProcessDate();
    }


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).REP_MAESTRO_MOVTOS))")
    @GetMapping({"/movimientos/fecha_desde/{startProcessDate}/fecha_hasta/{endProcessDate}"})
    public String movimientosPorRangoDeFechas(
            @PathVariable String startProcessDate,
            @PathVariable String endProcessDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var salidaReporte   = reporteMaestroDatosMovimientosDao.findByProcessDateBetween(startProcessDate, endProcessDate);
            estadoPeticion.setEstadoOk("Listado Movimientos OK", "Listado de Movimientos generado correctamente");
            model.addAttribute(HTML_SALIDA_REPORTE, salidaReporte);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al listar reporte Maestro Movimientos con rango fechas [" + startProcessDate + " - "+endProcessDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar Movimientos", "Se producjo un error al listar los saldos");
            model.addAttribute(HTML_SALIDA_REPORTE, null);
        }
        model.addAttribute(CAMPO_TITULO, "Maestro Datos - Movimientos");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("startProcessDate", startProcessDate);
        model.addAttribute("endProcessDate", endProcessDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.REP_MAESTRO_MOVTOS, false);
    }
}
