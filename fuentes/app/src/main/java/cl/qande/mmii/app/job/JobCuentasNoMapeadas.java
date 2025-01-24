package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import cl.qande.mmii.app.models.exception.MailException;
import cl.qande.mmii.app.models.service.ControlDatosService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobCuentasNoMapeadas implements Runnable {


    private static final int DESFASE_DIAS = -1;
    public static final String JOB_NAME = "Tarea Cuentas No Mapeadas";
    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;
    private final ControlDatosService controlDatosService;

    @Autowired
    public JobCuentasNoMapeadas(CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ControlDatosService controlDatosService) {
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
        this.controlDatosService = controlDatosService;
    }

    public boolean ejecutaJob(String processDate, String usuario, boolean flagSendMail) throws MailException {
        boolean estado;
        List<VwCuentasNoMapeadasPershingProjection> listaCuentasNoMapeadas = new ArrayList<>();
            try {
                listaCuentasNoMapeadas = controlDatosService.listaCuentasNoMapeadas(processDate);
                estado=true;
            } catch (Exception e) {
                listaCuentasNoMapeadas=null;
                estado=false;
                this.logError(" Ejecución por "+usuario, e.getMessage());
            }
        if(flagSendMail) {
            notificacionEmail.notificarJobCuentasNoMapeadas(processDate, estado, listaCuentasNoMapeadas);
        } else {
            this.logMessage(" Enviar mail por "+usuario+" desactivado");
        }
        return true;
    }
    private void logMessage(String message) {
        CustomLog.getInstance().info(JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }
    private void logError(String message, String errorDescr) {
        CustomLog.getInstance().info("Error "+JOB_NAME+message+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+errorDescr+"]");
    }
    public boolean ejecutaJob() {
        this.logMessage(" Iniciando");
        try {
            var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
            return ejecutaJob(processDate, CustomScheduler.USUARIO_JOB, true);
        } catch (Exception e) {
            this.logError("Error al realizar ", e.getMessage());
            return false;
        }
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }
}
