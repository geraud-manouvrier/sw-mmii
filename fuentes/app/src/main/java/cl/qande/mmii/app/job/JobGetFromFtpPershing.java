package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.PershingService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobGetFromFtpPershing implements Runnable {

    private static final int DESFASE_DIAS = -1;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private PershingService pershingService;

    public boolean processByProcessDate(String processDate, boolean useDownloadedFiles) throws QandeMmiiException {
        try {
            pershingService.processByDate(processDate, useDownloadedFiles, "*");
            notificacionEmail.notificarOkProcesoSflFtpPershing(processDate);
            appConfig.customLog.info("Mail FTP Pershing con fecha [" + processDate + "] enviado OK");
            return true;

        } catch (Exception e) {
            appConfig.customLog.error("Errores al realizar FTP Pershing con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorProcesoSflFtpPershing(processDate, "Error Job FTP Pershing: ["+e.getMessage()+"]");
            return false;
        }
    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.processByProcessDate(processDate, false);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al realizar tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        appConfig.customLog.info("Finalizando tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
