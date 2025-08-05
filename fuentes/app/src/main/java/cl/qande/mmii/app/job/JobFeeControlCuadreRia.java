package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ApiRestClientService;
import cl.qande.mmii.app.models.service.EnrolamientoClientesService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobFeeControlCuadreRia extends CustomJob {

    private final ApiRestClientService mainService;
    private final EnrolamientoClientesService enrolamientoClientesService;
    private final ReporteMaestroDatosService reporteMaestroDatosService;

    @Autowired
    public JobFeeControlCuadreRia(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ApiRestClientService apiRestClientService, EnrolamientoClientesService enrolamientoClientesService, ReporteMaestroDatosService reporteMaestroDatosService) {
        super("Control Cuadre Fee", appConfig, calendarioHelper, notificacionEmail);
        this.mainService        = apiRestClientService;
        this.enrolamientoClientesService = enrolamientoClientesService;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        FeeControlResponse resultadoApi    = null;
        var listaCuentas    = enrolamientoClientesService.listarClienteCuentaMaestroAsAccountFee(ApiRestClientService.CUSTODIAN_PERSHING, true);
        var msgRes    = "";
        try {
            resultadoApi    = mainService.getFeeControl(listaCuentas, ApiRestClientService.CUSTODIAN_PERSHING);
            resultadoApi    = reporteMaestroDatosService.populateNameAndSaldo(resultadoApi, processDate);

            logInfoJob("Control finalizado, se generará mail: "+resultadoApi.toString());
            //Asignamos nombre y saldo valorizado

        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control: "+ e.getMessage();
        }
        getNotificacionEmail().notificaJob(msgRes.isEmpty(), processDate, processDate, getJobName(), resultadoApi, msgRes, getMailConfiguration());
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
