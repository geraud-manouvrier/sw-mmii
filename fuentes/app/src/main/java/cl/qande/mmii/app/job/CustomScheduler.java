package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
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

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;
    @Autowired
    private CronTrigger cronReportesMaestros;
    @Autowired
    private CronTrigger cronControlDiario;
    @Autowired
    private CronTrigger cronFtpPershing;
    @Autowired
    private CronTrigger cronMallaDiaria;
    @Autowired
    private CronTrigger cronCuentasNoMapeadas;
    @Autowired
    private JobReportesMaestros jobReportesMaestros;
    @Autowired
    private JobControlDiario jobControlDiario;
    @Autowired
    private JobGetFromFtpPershing jobGetFromFtpPershing;
    @Autowired
    private JobMallaProcesos jobMallaProcesos;
    @Autowired
    private JobCuentasNoMapeadas jobCuentasNoMapeadas;

    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {

        this.registraTarea(jobReportesMaestros, cronReportesMaestros, "Reportes Maestros");

        this.registraTarea(jobControlDiario, cronControlDiario, "Control Diario");

        this.registraTarea(jobGetFromFtpPershing, cronFtpPershing, "Descarga FTP Pershing");

        this.registraTarea(jobMallaProcesos, cronMallaDiaria, "Malla Procesos");

        this.registraTarea(jobCuentasNoMapeadas, cronCuentasNoMapeadas, "Cuentas No Mapeadas");

    }

    private void registraTarea(Runnable taskOrJob, Trigger triggerOrCron, String nombreTarea) {
        if (triggerOrCron.toString().equals(CRON_NEVER_EXEC)) {
            appConfig.customLog.info("Tarea " + nombreTarea+" no registrada (ejecución desactivada)");
        } else {
            taskScheduler.schedule(taskOrJob, triggerOrCron);
            appConfig.customLog.info("Tarea " + nombreTarea + " registrada");
        }

    }
}
