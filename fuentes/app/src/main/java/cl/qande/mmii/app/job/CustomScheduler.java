package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomScheduler {

    public static final int DESFASE_DIAS = -1;
    public static final String USUARIO_JOB = "jobAppUser";
    public static final String CRON_NEVER_EXEC = "0 44 21 1 5 *";

    private final AppConfig appConfig;
    private final ThreadPoolTaskScheduler taskScheduler;
    private final CronTrigger cronReportesMaestros;
    private final CronTrigger cronControlDiario;
    private final CronTrigger cronFtpPershing;
    private final CronTrigger cronMallaDiaria;
    private final CronTrigger cronCuentasNoMapeadas;
    private final CronTrigger cronParametrosSuraCorp;
    private final JobReportesMaestros jobReportesMaestros;
    private final JobControlDiario jobControlDiario;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobMallaProcesos jobMallaProcesos;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;

    @Autowired
    public CustomScheduler(AppConfig appConfig, ThreadPoolTaskScheduler taskScheduler, CronTrigger cronReportesMaestros, CronTrigger cronControlDiario, CronTrigger cronFtpPershing, CronTrigger cronMallaDiaria, CronTrigger cronCuentasNoMapeadas, CronTrigger cronParametrosSuraCorp, JobReportesMaestros jobReportesMaestros, JobControlDiario jobControlDiario, JobGetFromFtpPershing jobGetFromFtpPershing, JobMallaProcesos jobMallaProcesos, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp) {
        this.appConfig = appConfig;
        this.taskScheduler = taskScheduler;
        this.cronReportesMaestros = cronReportesMaestros;
        this.cronControlDiario = cronControlDiario;
        this.cronFtpPershing = cronFtpPershing;
        this.cronMallaDiaria = cronMallaDiaria;
        this.cronCuentasNoMapeadas = cronCuentasNoMapeadas;
        this.cronParametrosSuraCorp = cronParametrosSuraCorp;
        this.jobReportesMaestros = jobReportesMaestros;
        this.jobControlDiario = jobControlDiario;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobMallaProcesos = jobMallaProcesos;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
    }


    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {

        this.registraTarea(jobReportesMaestros, cronReportesMaestros, "Reportes Maestros");

        this.registraTarea(jobControlDiario, cronControlDiario, "Control Diario");

        this.registraTarea(jobGetFromFtpPershing, cronFtpPershing, "Descarga FTP Pershing");

        this.registraTarea(jobMallaProcesos, cronMallaDiaria, "Malla Procesos");

        this.registraTarea(jobCuentasNoMapeadas, cronCuentasNoMapeadas, "Cuentas No Mapeadas");

        this.registraTarea(jobParametrosFromSuracorp, cronParametrosSuraCorp, "Parámetros SuraCorp");

    }

    private void registraTarea(Runnable taskOrJob, Trigger triggerOrCron, String nombreTarea) {
        if (triggerOrCron.toString().equals(CRON_NEVER_EXEC)) {
            CustomLog.getInstance().info("Tarea " + nombreTarea+" no registrada (ejecución desactivada)");
        } else {
            taskScheduler.schedule(taskOrJob, triggerOrCron);
            CustomLog.getInstance().info("Tarea " + nombreTarea + " registrada");
        }

    }
}
