package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMallaProcesos implements Runnable {

    private static final int DESFASE_DIAS = -1;

    private final CalendarioHelper calendarioHelper;
    private final JobControlDiario jobControlDiario;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;
    private final JobReportesMaestros jobReportesMaestros;

    @Autowired
    public JobMallaProcesos(CalendarioHelper calendarioHelper, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobReportesMaestros jobReportesMaestros, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp) {
        this.calendarioHelper = calendarioHelper;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobReportesMaestros = jobReportesMaestros;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
    }

    public boolean mallaProcesosByProcessDate(String processDateAsString) throws QandeMmiiException {
        CustomLog.getInstance().info("Ejecutando Malla Procesos");
        if (
                //Job Parametros Sura Corp
                jobParametrosFromSuracorp.ejecutaJob(CustomScheduler.USUARIO_JOB, true) &&
                //Job Pershing
                jobGetFromFtpPershing.processByProcessDate(processDateAsString, false) &&
                //Job Reportes Maestros
                jobReportesMaestros.generaReportesByProcessDate(processDateAsString, true, true, true, true, true) &&
                //Job Control Diario
                jobControlDiario.realizaControlDiario(processDateAsString, CustomScheduler.USUARIO_JOB, true) &&
                //Job Cuenta no mapeadas
                jobCuentasNoMapeadas.ejecutaJob(processDateAsString, CustomScheduler.USUARIO_JOB, true)
        ) {
                CustomLog.getInstance().info("Malla Procesos finalizada OK");
                return true;
            }
        CustomLog.getInstance().info("Malla Procesos finalizada con errores");
        return false;
    }

    public void tarea() {
        CustomLog.getInstance().info("Iniciando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.mallaProcesosByProcessDate(processDate);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        CustomLog.getInstance().info("Finalizando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
