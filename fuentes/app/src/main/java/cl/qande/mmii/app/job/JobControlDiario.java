package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobControlDiario implements Runnable {

    public static final Integer ID_JOB = 1;
    private static final String NOMBRE_JOB = "Control Diario";
    private static final int DESFASE_DIAS = -1;

    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;
    private final ControlDiarioService controlDiarioService;

    @Autowired
    public JobControlDiario(CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ControlDiarioService controlDiarioService) {
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
        this.controlDiarioService = controlDiarioService;
    }


    public boolean realizaControlDiario(String startProcessDate, String endProcessDate, String username, boolean flagEnviarMail) {
        try {
            var listaProcessDate = calendarioHelper.processDateRangeToList(startProcessDate, endProcessDate);
            for (var processDate : listaProcessDate) {
                if (! this.realizaControlDiario(processDate, username, flagEnviarMail) ) {
                    CustomLog.getInstance().error("Error Job "+NOMBRE_JOB+" con rango de fechas ["+startProcessDate+" - "+endProcessDate+"] en fecha: "+processDate);
                    return false;
                }
            }
        } catch (Exception e) {
            CustomLog.getInstance().error("Error Job "+NOMBRE_JOB+" con rango de fechas ["+startProcessDate+" - "+endProcessDate+"]: "+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean realizaControlDiario(String processDate, String usuario, boolean flagEnviarMail) throws QandeMmiiException {

        try {
            var resultadoProceso = controlDiarioService.ejecutaControlDiario(processDate, usuario);
            CustomLog.getInstance().info("Generación control diario con fecha [" + processDate + "] finalizado OK");
            if (flagEnviarMail) {
                notificacionEmail.notificarOkControlDiario(processDate, resultadoProceso);
                CustomLog.getInstance().info("Mail control diario con fecha [" + processDate + "] enviado OK");
            } else {
                CustomLog.getInstance().info("Flag Mail control diario con fecha [" + processDate + "] desactivado");
            }
            return true;
        } catch (Exception e) {
            CustomLog.getInstance().error("Errores al realizar control diario con fecha ["+processDate+"]: "+e.getMessage());
            if (flagEnviarMail) {
                notificacionEmail.notificarErrorControlDiario(processDate, "Error Job Control Diario: ["+e.getMessage()+"]");
            }
            return false;
        }
    }

    public boolean ejecutaJob() {
        CustomLog.getInstance().info("Iniciando tarea Control Diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            return this.realizaControlDiario(processDate, CustomScheduler.USUARIO_JOB, true);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error al realizar tarea control diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
            return false;
        }
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }
}
