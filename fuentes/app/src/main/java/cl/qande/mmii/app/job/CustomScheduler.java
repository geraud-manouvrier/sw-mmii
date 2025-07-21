package cl.qande.mmii.app.job;

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

    private final ThreadPoolTaskScheduler taskScheduler;
    private final CronTrigger cronReportesMaestros;
    private final CronTrigger cronControlDiario;
    private final CronTrigger cronFtpPershing;
    private final CronTrigger cronMallaDiaria;
    private final CronTrigger cronCuentasNoMapeadas;
    private final CronTrigger cronParametrosSuraCorp;
    private final CronTrigger cronReporteInversiones;
    private final CronTrigger cronReporteInversionesControles;
    private final CronTrigger cronTramosFeeControl;
    private final CronTrigger cronFeeControlCuadre;

    private final JobReportesMaestros jobReportesMaestros;
    private final JobControlDiario jobControlDiario;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobMallaProcesos jobMallaProcesos;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;
    private final JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario;
    private final JobRepInvControl jobRepInvControl;
    private final JobFeeControlTramos jobFeeControlTramos;
    private final JobFeeControlCuadreRia jobFeeControlCuadreRia;

    @Autowired
    public CustomScheduler(ThreadPoolTaskScheduler taskScheduler, CronTrigger cronReportesMaestros, CronTrigger cronControlDiario, CronTrigger cronFtpPershing, CronTrigger cronMallaDiaria, CronTrigger cronCuentasNoMapeadas, CronTrigger cronParametrosSuraCorp, CronTrigger cronReporteInversiones, CronTrigger cronReporteInversionesControles, CronTrigger cronTramosFeeControl, CronTrigger cronFeeControlCuadre, JobReportesMaestros jobReportesMaestros, JobControlDiario jobControlDiario, JobGetFromFtpPershing jobGetFromFtpPershing, JobMallaProcesos jobMallaProcesos, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp, JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario, JobRepInvControl jobRepInvControl, JobFeeControlTramos jobFeeControlTramos, JobFeeControlCuadreRia jobFeeControlCuadreRia) {
        this.taskScheduler = taskScheduler;
        this.cronReportesMaestros = cronReportesMaestros;
        this.cronControlDiario = cronControlDiario;
        this.cronFtpPershing = cronFtpPershing;
        this.cronMallaDiaria = cronMallaDiaria;
        this.cronCuentasNoMapeadas = cronCuentasNoMapeadas;
        this.cronParametrosSuraCorp = cronParametrosSuraCorp;
        this.cronReporteInversiones = cronReporteInversiones;
        this.cronReporteInversionesControles = cronReporteInversionesControles;
        this.cronTramosFeeControl = cronTramosFeeControl;
        this.cronFeeControlCuadre = cronFeeControlCuadre;
        this.jobReportesMaestros = jobReportesMaestros;
        this.jobControlDiario = jobControlDiario;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobMallaProcesos = jobMallaProcesos;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
        this.jobRepInvPrecalculoDiario = jobRepInvPrecalculoDiario;
        this.jobRepInvControl = jobRepInvControl;
        this.jobFeeControlTramos = jobFeeControlTramos;
        this.jobFeeControlCuadreRia = jobFeeControlCuadreRia;
    }


    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {

        this.registraTarea(jobReportesMaestros, cronReportesMaestros, "Reportes Maestros");

        this.registraTarea(jobControlDiario, cronControlDiario, "Control Diario");

        this.registraTarea(jobGetFromFtpPershing, cronFtpPershing, "Descarga FTP Pershing");

        this.registraTarea(jobMallaProcesos, cronMallaDiaria, "Malla Procesos");

        this.registraTarea(jobCuentasNoMapeadas, cronCuentasNoMapeadas, "Cuentas No Mapeadas");

        this.registraTarea(jobParametrosFromSuracorp, cronParametrosSuraCorp, "Parámetros SuraCorp");

        this.registraTarea(jobRepInvPrecalculoDiario, cronReporteInversiones, jobRepInvPrecalculoDiario.getNombreJob());

        this.registraTarea(jobRepInvControl, cronReporteInversionesControles, jobRepInvControl.getJobName());

        this.registraTarea(jobFeeControlTramos, cronTramosFeeControl);

        this.registraTarea(jobFeeControlCuadreRia, cronFeeControlCuadre);

    }

    private void registraTarea(Runnable taskOrJob, Trigger triggerOrCron, String nombreTarea) {
        if (triggerOrCron.toString().equals(CRON_NEVER_EXEC)) {
            CustomLog.getInstance().info("Tarea " + nombreTarea+" no registrada (ejecución desactivada)");
        } else {
            taskScheduler.schedule(taskOrJob, triggerOrCron);
            CustomLog.getInstance().info("Tarea " + nombreTarea + " registrada");
        }
    }

    private void registraTarea(CustomJob taskOrJob, Trigger triggerOrCron) {
        this.registraTarea(taskOrJob, triggerOrCron, taskOrJob.getJobName());
    }
}
