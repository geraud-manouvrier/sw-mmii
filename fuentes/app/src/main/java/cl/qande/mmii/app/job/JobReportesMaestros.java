package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.ReportesMaestrosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobReportesMaestros implements Runnable {

    private static final int DESFASE_DIAS = -1;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;

    @Autowired
    private ReportesMaestrosService reportesMaestrosService;
    @Autowired
    private NotificacionEmail notificacionEmail;

    public boolean generaReportesByProcessDate(String processDate) throws QandeMmiiException {

        if (reportesMaestrosService.generaReportesMaestros(processDate)) {
            appConfig.customLog.info("Generación Reportes Maestros Excel con fecha ["+processDate+"] finalizada OK");
            return true;
        } else {
            appConfig.customLog.error("Errores al generar Reportes Maestros Excel con fecha ["+processDate+"]");
            notificacionEmail.notificarErrorReportesMaestros(processDate, "Error Job Reportes Maestros");
            return false;
        }

    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea Reportes Maestros: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.generaReportesByProcessDate(processDate);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error tarea Reportes Maestros: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        appConfig.customLog.info("Finalizando tarea Reportes Maestros: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
