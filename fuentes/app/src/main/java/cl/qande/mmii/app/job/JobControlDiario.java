package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobControlDiario implements Runnable {

    private static final int DESFASE_DIAS = -1;
    private static final String USUARIO_JOB = "jobAppUser";

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private ControlDiarioService controlDiarioService;



    public void realizaControlDiario(String processDate, String usuario) throws QandeMmiiException {

        try {
            var resultadoProceso = controlDiarioService.ejecutaControlDiarioSegmentado(processDate, usuario);
            appConfig.customLog.info("Generación control diario con fecha [" + processDate + "] finalizado OK");
            notificacionEmail.notificarOkControlDiarioSegmentado(processDate, resultadoProceso);
            appConfig.customLog.info("Mail control diario con fecha [" + processDate + "] enviado OK");

        } catch (Exception e) {
            appConfig.customLog.error("Errores al realizar control diario con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorControlDiarioSegmentado(processDate, "Error Job Control Diario: ["+e.getMessage()+"]");
        }

    }

    public boolean realizaControlDiarioSegmentado(String processDate) throws QandeMmiiException {
        return realizaControlDiarioSegmentado(processDate, USUARIO_JOB, true);
    }

    public boolean realizaControlDiarioSegmentado(String processDate, String usuario, boolean flagEnviarMail) throws QandeMmiiException {

        try {
            var resultadoProceso = controlDiarioService.ejecutaControlDiarioSegmentado(processDate, usuario);
            appConfig.customLog.info("Generación control diario segmentado con fecha [" + processDate + "] finalizado OK");
            if (flagEnviarMail) {
                notificacionEmail.notificarOkControlDiarioSegmentado(processDate, resultadoProceso);
                appConfig.customLog.info("Mail control diario segmentado con fecha [" + processDate + "] enviado OK");
            } else {
                appConfig.customLog.info("Flag Mail control diario segmentado con fecha [" + processDate + "] desactivado");
            }
            return true;
        } catch (Exception e) {
            appConfig.customLog.error("Errores al realizar control diario segmentado con fecha ["+processDate+"]: "+e.getMessage());
            if (flagEnviarMail) {
                notificacionEmail.notificarErrorControlDiarioSegmentado(processDate, "Error Job Control Diario Segmentado: ["+e.getMessage()+"]");
            }
            return false;
        }
    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea Control Diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.realizaControlDiarioSegmentado(processDate);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al realizar tarea control diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        appConfig.customLog.info("Finalizando tarea control diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
