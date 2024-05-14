package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.IngresosEgresos;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.reportes.IngresosEgresosDiarioExcel;
import cl.qande.mmii.app.util.reportes.IngresosEgresosMensualExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class ReportesIngresosEgresosService {

    private static final String FORMATO_FECHA_PROCESO   = "yyyyMMdd";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IngresosEgresosMensualExcel ingresosEgresosMensualExcel;
    @Autowired
    private IngresosEgresosDiarioExcel ingresosEgresosDiarioExcel;

    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private IReporteIngresosEgresosService reporteIngresosEgresosService;
    public boolean generaReportesIngresosEgresos(Date processDate) throws QandeMmiiException {
        boolean estadoGeneracion    = true;

        try {
            appConfig.customLog.info("Iniciando Excel mensual Ingresos/Egresos con fecha proceso ["+processDate+"]...");
            ingresosEgresosMensualExcel.generaReportesExcel(processDate);
            appConfig.customLog.info("Iniciando Excel diario Ingresos/Egresos con fecha proceso ["+processDate+"]...");
            ingresosEgresosDiarioExcel.generaReportesExcel(processDate);
            appConfig.customLog.info("Reporte Excel Ingresos/Egresos con fecha proceso ["+processDate+"] generado.");
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al generar Reporte Excel con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorReportesIngresosEgresos(calendarioHelper.convierteDateToString(processDate), "Error generación Excel Ingresos/Egresos");
            estadoGeneracion    = false;
        }
        return estadoGeneracion;
    }

    public boolean generaReportesIngresosEgresos(String processDate) throws ParseException, QandeMmiiException {
        return generaReportesIngresosEgresos(processDate, FORMATO_FECHA_PROCESO);
    }
    public boolean generaReportesIngresosEgresos(String processDate, String formatFechaStr) throws ParseException, QandeMmiiException {
        return generaReportesIngresosEgresos(calendarioHelper.convierteFechaStrToDateWithFormat(processDate, formatFechaStr));
    }

    public List<IngresosEgresos> calculaReporteIngresosEgresos(Date processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando cálculo de datos Ingresos/Egresos con fecha proceso ["+processDate+"]...");
        try {
            return reporteIngresosEgresosService.calculaReportePorDia(calendarioHelper.convierteDateToString(processDate));
        } catch (Exception e) {
            notificacionEmail.notificarErrorReportesIngresosEgresos(calendarioHelper.convierteDateToString(processDate), "Error cálculo datos Ingresos/Egresos");
            return null;
        }
    }

    public List<IngresosEgresos> calculaReporteIngresosEgresos(String processDate) throws ParseException, QandeMmiiException {
        return calculaReporteIngresosEgresos(calendarioHelper.convierteFechaStrToDateWithFormat(processDate, FORMATO_FECHA_PROCESO));
    }
}
