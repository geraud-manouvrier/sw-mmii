package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppApiProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IParametroCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiHelper {

    @Autowired
    private IParametroCoreService parametroCoreService;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private AppApiProperties appApiProperties;

    public void validateApiKey(String apiKey, String idAppCliente) throws QandeMmiiException {
        appConfig.customLog.info("Validando Api Key Cliente ["+idAppCliente+"]: ["+apiKey+"]");
        var paramApiKey = parametroCoreService.valorParametroCore("api.api_key",idAppCliente);
        if (paramApiKey==null || ! paramApiKey.equals(apiKey)) {
            appConfig.customLog.error("Error Api Key Cliente ["+idAppCliente+"]: ["+apiKey+"]");
            throw new QandeMmiiException("Api Key inválido");
        }
    }
    public boolean isEnabledApiArchivos() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledArchivos() );
    }
}
