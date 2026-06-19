package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.api.reportes_maestros.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ListFeeResponse;
import cl.qande.mmii.app.models.db.core.entity.FnActualizaFeeRia;
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
public class JobFeeImportaDesdeRia extends CustomJob {

    private final ApiRestClientService mainService;
    private final EnrolamientoClientesService enrolamientoClientesService;
    private final ReporteMaestroDatosService reporteMaestroDatosService;

    @Autowired
    public JobFeeImportaDesdeRia(AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ApiRestClientService apiRestClientService, EnrolamientoClientesService enrolamientoClientesService, ReporteMaestroDatosService reporteMaestroDatosService) {
        super("Update FEE from RIA", appConfig, calendarioHelper, notificacionEmail);
        this.mainService        = apiRestClientService;
        this.enrolamientoClientesService = enrolamientoClientesService;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
    }


    @Override
    public boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciando job");
        ListFeeResponse resultadoApi    = null;
        List<FnActualizaFeeRia> resultado   = null;
        var listaCuentas    = reporteMaestroDatosService.reporteMaestroSaldosApi(processDate).stream()
                .filter(saldo -> ApiRestClientService.CUSTODIAN_PERSHING.equalsIgnoreCase(saldo.getCustodian()))
                .map(MaestroSaldosApiDto::getAccountNo)
                .distinct()
                .collect(Collectors.toList());
        logInfoJob("Se procesarán ["+listaCuentas.size()+"] cuentas: "+listaCuentas.toString());
        var msgRes    = "";
        try {
            resultadoApi    = mainService.getListClientsFee(listaCuentas, processDate, ApiRestClientService.CUSTODIAN_PERSHING);
            resultado   = enrolamientoClientesService.updateFeeFromApiRia(processDate, listaCuentas, resultadoApi.getAccountsFees());
            logInfoJob("Resultado Actualización: "+resultado.toString());
        } catch (Exception e) {
            logErrorJob("Error generando control:" + e.getMessage());
            msgRes  = "Error generando control: "+ e.getMessage();
        }
        getNotificacionEmail().notificaJobUpdateFeeFromRia(msgRes.isEmpty(), processDate, processDate, getJobName(), resultado, msgRes, getMailConfiguration());
        return true;
    }

    @Override
    protected void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        //Sin vlidaciones para este job
    }

    @Override
    protected AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration(){
        var config  = getNotificacionEmail().getAppNotificacionMailProperties().getFeeUpdateFromRia();
        if (config == null) {
            CustomLog.getInstance().error("No se encontró configuración de notificación para job "+getJobName());
        }
        return config;

    }

}
