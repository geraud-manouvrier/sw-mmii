package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.db.core.CoreDataService;
import cl.qande.mmii.app.models.db.core.entity.VwReporteDiferenciasFee;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobFeeControlTramos extends CustomJob {
    private final CoreDataService mainService;

    @Autowired
    public JobFeeControlTramos(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, CoreDataService mainService) {
        super("Control Tramos Fee", appConfig, calendarioHelper, notificacionEmail);
        this.mainService = mainService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        List<VwReporteDiferenciasFee> resultado    = null;
        var msgRes    = "";
        try {
            resultado   = mainService.reporteDiferenciasFee(false);
            logInfoJob("Control finalizado, se generará mail: "+resultado.toString());
        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control";
        }
        getNotificacionEmail().notificaJob(msgRes.isEmpty(), processDate, processDate, getJobName(), resultado, msgRes, getMailConfiguration());
        return true;
    }

    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        //Sin vlidaciones para este job
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration() {
        return getNotificacionEmail().getAppNotificacionMailProperties().getTramosFeeControl();
    }

}
