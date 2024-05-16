package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import cl.qande.mmii.app.util.reportes.MaestroDatosCsv;
import cl.qande.mmii.app.util.reportes.MaestroDatosExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportesMaestrosService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private MaestroDatosExcel maestroDatosExcel;
    @Autowired
    private MaestroDatosCsv maestroDatosCsv;
    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private ArchivosHelper archivosHelper;
    @Autowired
    private IReporteMaestroDatosService reporteMaestroDatosService;
    public boolean generaReportesMaestros(String processDate) throws QandeMmiiException {
        boolean estadoGeneracion    = true;
        appConfig.customLog.info("Se generarán reportes Maestros con fecha proceso ["+processDate+"]");

        archivosHelper.borraListadoDeArchivosMaestros(processDate);
        appConfig.customLog.info("Archivos existentes borrados");
        this.materializaDatos(processDate);

        try {
            appConfig.customLog.info("Iniciando generación reporte CSV con fecha proceso ["+processDate+"]");
            maestroDatosCsv.generaReportesCsv(processDate);
            appConfig.customLog.info("Reporte CSV con fecha proceso ["+processDate+"] generado.");
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al generar Reporte CSV con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorReportesMaestros(processDate, "Error generación Maestro CSV");
            estadoGeneracion    = false;
        }
        return estadoGeneracion;
    }

    public void materializaDatos(String processDate) {
        appConfig.customLog.info("Iniciando materialización de datos Clientes con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosCliente(processDate);
        appConfig.customLog.info("Iniciando materialización de datos Movimientos con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosMovimiento(processDate);
        appConfig.customLog.info("Iniciando materialización de datos Saldos con fecha proceso ["+processDate+"]");
        reporteMaestroDatosService.materializaDatosSaldo(processDate);
        appConfig.customLog.info("Materialización de datos finalizada");
    }
}
