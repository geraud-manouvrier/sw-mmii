package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.MailException;
import cl.qande.mmii.app.models.service.ControlDatosService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobCuentasNoMapeadas implements Runnable {


    private static final int DESFASE_DIAS = -1;
    private static final String USUARIO_JOB = "jobAppUser";
    private static final String JOB_NAME = "Tarea Cuentas No Mapeadas";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private ControlDatosService controlDatosService;

    private void ejecutaJob() throws MailException {
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        ejecutaJob(processDate, USUARIO_JOB, true);
    }
    public void ejecutaJob(String processDate, String usuario, boolean flagSendMail) throws MailException {
        if(flagSendMail) {
            try {
                var lisaCuentasNoMapeadas = controlDatosService.listaCuentasNoMapeadas(processDate);
                notificacionEmail.notificarJobCuentasNoMapeadas(processDate, true, lisaCuentasNoMapeadas);
            } catch (MailException e) {
                this.logError(" Enviar mail por "+usuario, e.getMessage());
            } catch (Exception e) {
                this.logError(" Ejecución por "+usuario, e.getMessage());
                notificacionEmail.notificarJobCuentasNoMapeadas(processDate, false, null);
            }
        } else {
            this.logMessage(" Enviar mail por "+usuario+" desactivado");
        }
    }
    private void logMessage(String message) {
        appConfig.customLog.info(JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }
    private void logError(String message, String errorDescr) {
        appConfig.customLog.info("Error "+JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+errorDescr+"]");
    }
    public void tarea() {
        this.logMessage(" Iniciando");
        try {
            this.ejecutaJob();
        } catch (Exception e) {
            this.logError("Error al realizar ", e.getMessage());
        }
        this.logMessage(" Finalizando");
    }

    @Override
    public void run() {
        this.tarea();
    }
}
