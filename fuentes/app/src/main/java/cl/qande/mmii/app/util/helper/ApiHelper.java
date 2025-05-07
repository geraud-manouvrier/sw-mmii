package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.properties.AppApiProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IParametroCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApiHelper {


    public static final String ID_API_STATUS        = "API_PUB_STATUS";
    public static final String ID_API_CLIENTES      = "API_PUB_CLIENTES";
    public static final String ID_API_CONTRATOS     = "API_PUB_CONTRATOS";
    public static final String ID_API_ARCHIVOS      = "API_PUB_ARCHIVOS";
    public static final String ID_API_REP_MAESTROS  = "API_PUB_REP_MAESTROS";
    public static final String ID_API_RET           = "API_PUB_RET";
    public static final String ID_API_JOBS          = "API_INT_JOBS";
    public static final String ID_API_PARAMS        = "API_INT_PARAM";

    public static final String HEADER_CLIENT_ID = "x-client_id";
    public static final String HEADER_API_KEY   = "x-api_key";

    public static final String HEADER_JSON_KEY = "Content-Type";
    public static final String HEADER_JSON_VAL = "application/json";

    private final IParametroCoreService parametroCoreService;
    private final AppApiProperties appApiProperties;

    @Autowired
    public ApiHelper(IParametroCoreService parametroCoreService, AppApiProperties appApiProperties) {
        this.parametroCoreService = parametroCoreService;
        this.appApiProperties = appApiProperties;
    }

    public void validateApiKey(String apiKey, String idAppCliente, String idApi) throws QandeMmiiException {
        CustomLog.getInstance().info("Validando Api Key Cliente ["+idAppCliente+"]");
        var paramApiKey = parametroCoreService.valorParametroCore("api.api_key",idAppCliente);
        if (paramApiKey==null || ! paramApiKey.equals(apiKey)) {
            CustomLog.getInstance().error("Error Api Key Cliente ["+idAppCliente+"]: ["+apiKey+"]");
            throw new QandeMmiiException("Api Key inválido");
        }
        //TODO: Implementar validacón desde BD de enabled
    }
    public boolean isEnabledApiArchivos() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledArchivos() );
    }
    public boolean isEnabledApiReportesMaestros() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledReportesMaestros() );
    }
    public boolean isEnabledApiRetornos() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledRetornos() );
    }

    public void validaProcessDate(String processDate)  throws QandeMmiiException {
        if ( ! (processDate != null && processDate.length()==8 && processDate.matches("[\\d]+") ) ) {
            CustomLog.getInstance().error("Error Process Date ["+processDate+"]");
            throw new QandeMmiiException("Process Date inválido");
        }
    }
}
