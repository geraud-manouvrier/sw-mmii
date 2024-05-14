package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomScheduler {

    public static final int DESFASE_DIAS = -1;
    public static final String USUARIO_JOB = "jobAppUser";

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
    private JobReportesMaestros jobReportesMaestros;
    @Autowired
    private JobControlDiario jobControlDiario;
    @Autowired
    private JobGetFromFtpPershing jobGetFromFtpPershing;
    @Autowired
    private JobMallaProcesos jobMallaProcesos;

    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {

        appConfig.customLog.info("Registrando tarea Reportes Maestros");
        taskScheduler.schedule(jobReportesMaestros, cronReportesMaestros);
        appConfig.customLog.info("Tarea Reportes Maestros registrada");


        appConfig.customLog.info("Registrando tarea Control Diario");
        taskScheduler.schedule(jobControlDiario, cronControlDiario);
        appConfig.customLog.info("Tarea Control Diario registrada");


        appConfig.customLog.info("Registrando tarea Descarga FTP Pershing");
        taskScheduler.schedule(jobGetFromFtpPershing, cronFtpPershing);
        appConfig.customLog.info("Tarea Descarga FTP Pershing registrada");


        appConfig.customLog.info("Registrando tarea Malla Procesos");
        taskScheduler.schedule(jobMallaProcesos, cronMallaDiaria);
        appConfig.customLog.info("Tarea Malla Procesos registrada");

    }
}
