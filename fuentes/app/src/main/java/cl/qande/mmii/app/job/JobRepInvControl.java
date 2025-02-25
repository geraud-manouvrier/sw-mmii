package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.db.rep_inv.ReporteInversionesService;
import cl.qande.mmii.app.models.db.rep_inv.entity.ResultadoControl;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobRepInvControl extends CustomJob {
    private final ReporteInversionesService mainService;

    @Autowired
    public JobRepInvControl(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ReporteInversionesService mainService) {
        super("Controles Rentabilidades", appConfig, calendarioHelper, notificacionEmail);
        this.mainService = mainService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        List<ResultadoControl> resultado    = null;
        var msgRes    = "";
        try {
            resultado   = mainService.resultadoControl(processDate, null, true);
            logInfoJob("Control finalizado, se generará mail: "+resultado.toString());
        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control";
        }
        getNotificacionEmail().notificaJobControlRepInv(msgRes.isEmpty(), processDate, processDate, getJobName(), resultado, msgRes);
        return true;
    }

    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        //Sin vlidaciones para este job
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration() {
        return getNotificacionEmail().getAppNotificacionMailProperties().getRepinvControl();
    }

}
