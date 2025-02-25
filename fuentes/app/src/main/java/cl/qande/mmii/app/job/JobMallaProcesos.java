package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMallaProcesos implements Runnable {

    private static final int DESFASE_DIAS = -1;
    private static final String NOMBRE_JOB = "Malla Diaria";

    private final CalendarioHelper calendarioHelper;
    private final JobControlDiario jobControlDiario;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;
    private final JobReportesMaestros jobReportesMaestros;
    private final JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario;
    private final JobRepInvControl jobRepInvControl;
    private final NotificacionEmail notificacionEmail;

    @Autowired
    public JobMallaProcesos(CalendarioHelper calendarioHelper, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobReportesMaestros jobReportesMaestros, JobParametrosFromSuracorp jobParametrosFromSuracorp, JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario, JobRepInvControl jobRepInvControl, NotificacionEmail notificacionEmail) {
        this.calendarioHelper = calendarioHelper;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobReportesMaestros = jobReportesMaestros;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
        this.jobRepInvPrecalculoDiario = jobRepInvPrecalculoDiario;
        this.jobRepInvControl = jobRepInvControl;
        this.notificacionEmail = notificacionEmail;
    }

    public boolean mallaProcesosByProcessDate() throws QandeMmiiException {
        CustomLog.getInstance().info("Ejecutando Malla Procesos");
        if (
                //Job Parametros Sura Corp
                jobParametrosFromSuracorp.ejecutaJob() &&
                //Job Pershing
                jobGetFromFtpPershing.ejecutaJob() &&
                //Job Reportes Maestros
                jobReportesMaestros.ejecutaJob() &&
                //Job Control Diario
                jobControlDiario.ejecutaJob() &&
                //Job Rentabilidades
                jobRepInvPrecalculoDiario.ejecutaJob() &&
                //Controles rentabilidades
                jobRepInvControl.ejecutaJob()
        ) {
                CustomLog.getInstance().info("Malla Procesos finalizada OK");
                return true;
            }
        CustomLog.getInstance().info("Malla Procesos finalizada con errores");
        return false;
    }

    public void ejecutaJob() {
        CustomLog.getInstance().info("Iniciando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            var resultado   = this.mallaProcesosByProcessDate();
            notificacionEmail.notificarJobMallaDiaria(resultado, processDate, processDate, NOMBRE_JOB, "");
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
            notificacionEmail.notificarJobMallaDiaria(false, processDate, processDate, NOMBRE_JOB, "Error no controlado en Malla Diaria: "+e.getMessage());
        }
        CustomLog.getInstance().info("Finalizando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }
}
