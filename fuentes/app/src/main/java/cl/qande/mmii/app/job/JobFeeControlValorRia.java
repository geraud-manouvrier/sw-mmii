package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ApiRestClientService;
import cl.qande.mmii.app.models.service.EnrolamientoClientesService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobFeeControlValorRia extends CustomJob {

    private final ApiRestClientService mainService;
    private final EnrolamientoClientesService enrolamientoClientesService;

    @Autowired
    public JobFeeControlValorRia(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ApiRestClientService apiRestClientService, EnrolamientoClientesService enrolamientoClientesService) {
        super("Control Cuadre Fee", appConfig, calendarioHelper, notificacionEmail);
        this.mainService        = apiRestClientService;
        this.enrolamientoClientesService = enrolamientoClientesService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        FeeControlResponse resultado    = null;
        var listaCuentas    = enrolamientoClientesService.listarClienteCuentaMaestroAsAccountFee(ApiRestClientService.CUSTODIAN_PERSHING, true);
        var msgRes    = "";
        try {
            resultado   = mainService.getFeeControl(listaCuentas, ApiRestClientService.CUSTODIAN_PERSHING);
            logInfoJob("Control finalizado, se generará mail: "+resultado.toString());
        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control: "+ e.getMessage();
        }
        getNotificacionEmail().notificaJob(msgRes.isEmpty(), processDate, processDate, getJobName(), resultado, msgRes, getMailConfiguration());
        return true;
    }

    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        if ( ! startProcessDate.equals(endProcessDate)) {
            throw new QandeMmiiException("El job "+this.getJobName()+" debe ejecutarse con la misma fecha de inicio y fin");
        }
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration(){
        var config  = getNotificacionEmail().getAppNotificacionMailProperties().getFeeControlCuadre();
        if (config == null) {
            CustomLog.getInstance().error("No se encontró configuración de notificación para job "+getJobName());
        }
        return config;

    }

}
