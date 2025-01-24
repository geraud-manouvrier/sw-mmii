package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.ParametrosFromMmiiSuraCorp;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobParametrosFromSuracorp implements Runnable {


    private static final int DESFASE_DIAS = -1;
    public static final String JOB_NAME = "Tarea Parámetros From SuraCorp";
    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;
    private final ParametrosFromMmiiSuraCorp mainService;

    @Autowired
    public JobParametrosFromSuracorp(CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ParametrosFromMmiiSuraCorp mainService) {
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
        this.mainService = mainService;
    }

    public boolean ejecutaJob(String usuario, boolean flagSendMail) throws QandeMmiiException {
        var processDate	= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        var resultado   = false;
        var msg         = "";
        ParSourceCode[][] resultadoCarga    = null;

        try {
            resultadoCarga = mainService.actualizaParametrosFromMmiiSuraCorp();
            resultado    = (resultadoCarga.length==2 && resultadoCarga[1].length==0);
        } catch (QandeMmiiException e) {
            this.logError(" Obtener valores desde API REST Parámetros por "+usuario, e.getMessage());
            msg = e.getMessage();
        } catch (Exception e) {
            this.logError(" Ejecución por "+usuario, e.getMessage());
            msg = e.getMessage();
        }

        if(flagSendMail) {
            notificacionEmail.notificarJobParametrosFromSuracorp(resultado, processDate, processDate, JOB_NAME, resultadoCarga, msg);
            return resultado;
        } else {
            this.logMessage(" Enviar mail por "+usuario+" desactivado");
            return resultado;
        }


    }


    public boolean ejecutaJob() {
        try {
            CustomLog.getInstance().info("Iniciando Job "+JOB_NAME+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
            return this.ejecutaJob(CustomScheduler.USUARIO_JOB, true);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al realizar tarea "+JOB_NAME+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
            return false;
        }
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }


    private void logMessage(String message) {
        CustomLog.getInstance().info(JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }
    private void logError(String message, String errorDescr) {
        CustomLog.getInstance().info("Error "+JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+errorDescr+"]");
    }
}
