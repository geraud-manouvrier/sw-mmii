package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.reportes.MaestroDatosCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportesMaestrosService {

    private final MaestroDatosCsv maestroDatosCsv;
    private final NotificacionEmail notificacionEmail;
    private final ArchivosHelper archivosHelper;
    private final ReporteMaestroDatosService reporteMaestroDatosService;
    private final CalendarioHelper calendarioHelper;

    @Autowired
    public ReportesMaestrosService(MaestroDatosCsv maestroDatosCsv, NotificacionEmail notificacionEmail, ArchivosHelper archivosHelper, ReporteMaestroDatosService reporteMaestroDatosService, CalendarioHelper calendarioHelper) {
        this.maestroDatosCsv = maestroDatosCsv;
        this.notificacionEmail = notificacionEmail;
        this.archivosHelper = archivosHelper;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
        this.calendarioHelper = calendarioHelper;
    }


    public boolean generaReportesMaestros(String startProcessDate, String endProcessDate, boolean materializaData, boolean generarClientes, boolean generarMovimientos, boolean generarSaldos, boolean generarRelacionados, boolean borrarArchivosExistentes) {
        try {
            var listaProcessDate = calendarioHelper.processDateRangeToList(startProcessDate, endProcessDate);
            for (var processDate : listaProcessDate) {
                if (!generaReportesMaestros(processDate, materializaData, generarClientes, generarMovimientos, generarSaldos, generarRelacionados, borrarArchivosExistentes)) {
                    CustomLog.getInstance().error("Error Reportes Maestros con rango de fechas ["+startProcessDate+" - "+endProcessDate+"]: en fecha: "+processDate);
                    return false;
                }
            }
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error Reportes Maestros con rango de fechas ["+startProcessDate+" - "+endProcessDate+"]: "+e.getMessage());
            return false;
        }
        return true;
    }
    public boolean generaReportesMaestros(String processDate, boolean materializaData, boolean generarClientes, boolean generarMovimientos, boolean generarSaldos, boolean generarRelacionados, boolean borrarArchivosExistentes) throws QandeMmiiException {
        boolean estadoGeneracion    = true;
        CustomLog.getInstance().info("Se generarán reportes Maestros con fecha proceso ["+processDate+"]");
        if (borrarArchivosExistentes) {
            archivosHelper.borraListadoDeArchivosMaestros(processDate);
            CustomLog.getInstance().info("Archivos existentes borrados");
        }
        if (materializaData) {
            this.materializaDatos(processDate);
        }

        try {
            CustomLog.getInstance().info("Iniciando generación reporte CSV con fecha proceso ["+processDate+"]");
            maestroDatosCsv.generaReportesCsv(processDate, generarClientes, generarMovimientos, generarSaldos, generarRelacionados);
            CustomLog.getInstance().info("Reporte CSV con fecha proceso ["+processDate+"] generado.");
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error al generar Reporte CSV con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorReportesMaestros(processDate, "Error generación Maestro CSV");
            estadoGeneracion    = false;
        }
        return estadoGeneracion;
    }

    public void materializaDatos(String processDate) {
        CustomLog.getInstance().info("Iniciando materialización de datos Clientes con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosCliente(processDate);
        CustomLog.getInstance().info("Iniciando materialización de datos Movimientos con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosMovimiento(processDate);
        CustomLog.getInstance().info("Iniciando materialización de datos Saldos con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosSaldo(processDate);
        CustomLog.getInstance().info("Materialización de datos finalizada");
        CustomLog.getInstance().info("Iniciando materialización de datos Relacionados con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosRelacionado(processDate);
        CustomLog.getInstance().info("Materialización de datos finalizada");
    }
}
