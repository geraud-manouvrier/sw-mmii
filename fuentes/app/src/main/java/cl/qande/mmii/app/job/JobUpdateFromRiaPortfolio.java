package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ListPortfolioResponse;
import cl.qande.mmii.app.models.db.core.entity.FnActualizaPortfolioRia;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
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

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JobUpdateFromRiaPortfolio extends CustomJob {

    private final ApiRestClientService mainService;
    private final EnrolamientoClientesService enrolamientoClientesService;
    private final ReporteMaestroDatosService reporteMaestroDatosService;

    @Autowired
    public JobUpdateFromRiaPortfolio(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ApiRestClientService apiRestClientService, EnrolamientoClientesService enrolamientoClientesService, ReporteMaestroDatosService reporteMaestroDatosService) {
        super("Update Portfolio from RIA", appConfig, calendarioHelper, notificacionEmail);
        this.mainService        = apiRestClientService;
        this.enrolamientoClientesService = enrolamientoClientesService;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        ListPortfolioResponse resultadoApi    = null;
        List<FnActualizaPortfolioRia> resultado   = null;
        var listaCuentas    = reporteMaestroDatosService.generaReporteClientes(processDate).stream()
                .filter(saldo -> ApiRestClientService.CUSTODIAN_PERSHING.equalsIgnoreCase(saldo.getCustodian()))
                .map(VwReporteMaestroDatosCliente::getAccountNo)
                .distinct()
                .collect(Collectors.toList());
        logInfoJob("Se procesarán ["+listaCuentas.size()+"] cuentas: "+listaCuentas.toString());
        var msgRes    = "";
        try {
            resultadoApi    = mainService.getListClientsPortfolio(listaCuentas, processDate, ApiRestClientService.CUSTODIAN_PERSHING);
            resultado   = enrolamientoClientesService.updatePortfolioFromApiRia(processDate, listaCuentas, resultadoApi.getAccountsPortfolios());
            logInfoJob("Resultado Actualización: "+resultado.toString());
        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control: "+ e.getMessage();
        }
        getNotificacionEmail().notificaJobUpdatePortfolioFromRia(msgRes.isEmpty(), processDate, processDate, getJobName(), resultado, msgRes, getMailConfiguration());
        return true;
    }

    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        //Sin vlidaciones para este job
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration(){
        var config  = getNotificacionEmail().getAppNotificacionMailProperties().getPortfolioUpdateFromRia();
        if (config == null) {
            CustomLog.getInstance().error("No se encontró configuración de notificación para job "+getJobName());
        }
        return config;

    }

}
