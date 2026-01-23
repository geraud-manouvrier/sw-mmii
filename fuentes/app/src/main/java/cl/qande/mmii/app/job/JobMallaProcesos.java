package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobMallaProcesos extends CustomJob {

    private final JobControlDiario jobControlDiario;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;
    private final JobReportesMaestros jobReportesMaestros;
    private final JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario;
    private final JobRepInvControl jobRepInvControl;
    private final JobFeeControlTramos jobFeeControlTramos;
    private final JobFeeControlCuadreRia jobFeeControlCuadreRia;

    @Autowired
    public JobMallaProcesos(AppConfig appConfig, CalendarioHelper calendarioHelper, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobReportesMaestros jobReportesMaestros, JobParametrosFromSuracorp jobParametrosFromSuracorp, JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario, JobRepInvControl jobRepInvControl, JobFeeControlTramos jobFeeControlTramos, JobFeeControlCuadreRia jobFeeControlCuadreRia, NotificacionEmail notificacionEmail) {
        super("Malla Procesos Diarios", appConfig, calendarioHelper, notificacionEmail);
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobReportesMaestros = jobReportesMaestros;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
        this.jobRepInvPrecalculoDiario = jobRepInvPrecalculoDiario;
        this.jobRepInvControl = jobRepInvControl;
        this.jobFeeControlTramos = jobFeeControlTramos;
        this.jobFeeControlCuadreRia = jobFeeControlCuadreRia;
    }

    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        try {
            if (
                //Job Parametros Sura Corp
                jobParametrosFromSuracorp.ejecutaJob() &&
                //Job Pershing
                jobGetFromFtpPershing.processByProcessDate(processDate, false) &&
                //Job Reportes Maestros
                jobReportesMaestros.generaReportesByProcessDate(processDate, true, true, true, true, true, true) &&
                //Job Control Diario
                jobControlDiario.realizaControlDiario(processDate, CustomScheduler.USUARIO_JOB, true) &&
                //Job Rentabilidades
                jobRepInvPrecalculoDiario.ejecutaJob(processDate) &&
                //Controles rentabilidades
                jobRepInvControl.ejecutaJob(processDate, processDate, sesionWeb) &&
                //Controles tramos Fee según ingresos/egresos
                jobFeeControlTramos.ejecutaJob(processDate, processDate, sesionWeb) &&
                //Controles Fee versus Fee contrato RIA
                jobFeeControlCuadreRia.ejecutaJob(processDate, processDate, sesionWeb)
            ) {
                logInfoJob("Malla Procesos finalizada OK");
                getNotificacionEmail().notificarJobMallaDiaria(true, processDate, processDate, this.getJobName(), "");
                return true;
            }
            logInfoJob("Malla Procesos finalizada con errores");
            getNotificacionEmail().notificarJobMallaDiaria(false, processDate, processDate, this.getJobName(), "Error en Malla Diaria");
            return false;
        } catch (Exception e) {
            logErrorJob("Error generando Malla Procesos:" + e.getMessage());
            getNotificacionEmail().notificarJobMallaDiaria(false, processDate, processDate, this.getJobName(), "Error no controlado en Malla Diaria: "+e.getMessage());
            return false;
        }
    }


    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        //Sin validaciones para este job
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration() {
        return getNotificacionEmail().getAppNotificacionMailProperties().getMallaDiaria();
    }
}
