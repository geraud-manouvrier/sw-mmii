package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.ReportesMaestrosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobReportesMaestros implements Runnable {

    private static final int DESFASE_DIAS = -1;

    private final CalendarioHelper calendarioHelper;
    private final ReportesMaestrosService reportesMaestrosService;
    private final NotificacionEmail notificacionEmail;

    @Autowired
    public JobReportesMaestros(CalendarioHelper calendarioHelper, ReportesMaestrosService reportesMaestrosService, NotificacionEmail notificacionEmail) {
        this.calendarioHelper = calendarioHelper;
        this.reportesMaestrosService = reportesMaestrosService;
        this.notificacionEmail = notificacionEmail;
    }

    public boolean generaReportesByProcessDate(String processDate, boolean materializaData, boolean generarClientes, boolean generarMovimientos, boolean generarSaldos, boolean generarRelacionados, boolean borrarArchivosExistentes) throws QandeMmiiException {

        if (reportesMaestrosService.generaReportesMaestros(processDate, materializaData, generarClientes, generarMovimientos, generarSaldos, generarRelacionados, borrarArchivosExistentes)) {
            CustomLog.getInstance().info("Generación Reportes Maestros Excel con fecha ["+processDate+"] finalizada OK");
            return true;
        } else {
            CustomLog.getInstance().error("Errores al generar Reportes Maestros Excel con fecha ["+processDate+"]");
            notificacionEmail.notificarErrorReportesMaestros(processDate, "Error Job Reportes Maestros");
            return false;
        }

    }

    public boolean ejecutaJob() {
        CustomLog.getInstance().info("Iniciando tarea Reportes Maestros: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            return this.generaReportesByProcessDate(processDate, true, true, true, true, true, true);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error tarea Reportes Maestros: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
            return false;
        }
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }
}
