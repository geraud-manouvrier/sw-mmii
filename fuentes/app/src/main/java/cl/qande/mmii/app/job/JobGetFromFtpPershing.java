package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.PershingService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobGetFromFtpPershing implements Runnable {

    private static final int DESFASE_DIAS = -1;

    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;
    private final PershingService pershingService;

    @Autowired
    public JobGetFromFtpPershing(CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, PershingService pershingService) {
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
        this.pershingService = pershingService;
    }

    public boolean processByProcessDate(String processDate, boolean useDownloadedFiles) throws QandeMmiiException {
        try {
            pershingService.processByDate(processDate, useDownloadedFiles, "*");
            notificacionEmail.notificarOkProcesoSflFtpPershing(processDate);
            CustomLog.getInstance().info("Mail FTP Pershing con fecha [" + processDate + "] enviado OK");
            return true;

        } catch (Exception e) {
            CustomLog.getInstance().error("Errores al realizar FTP Pershing con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorProcesoSflFtpPershing(processDate, "Error Job FTP Pershing: ["+e.getMessage()+"]");
            return false;
        }
    }

    public void tarea() {
        CustomLog.getInstance().info("Iniciando tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.processByProcessDate(processDate, false);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error al realizar tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        CustomLog.getInstance().info("Finalizando tarea FTP Pershing: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
