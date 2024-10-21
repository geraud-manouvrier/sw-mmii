package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppApiClientSuraCorpProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCodeResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiRestClientService {

    private final AppConfig appConfig;
    private final AppApiClientSuraCorpProperties apiClientSuraCorpProperties;

    @Autowired
    public ApiRestClientService(AppConfig appConfig, AppApiClientSuraCorpProperties apiClientSuraCorpProperties) {
        this.appConfig = appConfig;
        this.apiClientSuraCorpProperties = apiClientSuraCorpProperties;
    }

    private MultiValueMap<String, String> getHeaderForMmiiSuracorp() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(ApiHelper.HEADER_API_KEY, apiClientSuraCorpProperties.getxApiKey());
        headers.add(ApiHelper.HEADER_CLIENT_ID, apiClientSuraCorpProperties.getxClientId());
        headers.add("Content-Type", "application/json");
        return headers;
    }

    public ParSourceCodeResponse getListSourceCode() throws QandeMmiiException {
        CustomLog.getInstance().info("Invocando API SuraCorp para obtener lista de códigos de fuente");
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s%s%s",
                apiClientSuraCorpProperties.getServer(),
                apiClientSuraCorpProperties.getPath(),
                apiClientSuraCorpProperties.getMethodSourceCode() );
        CustomLog.getInstance().info("URL Rest SuraCorp Pre: " + url);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(getHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ParSourceCodeResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, ParSourceCodeResponse.class);
            CustomLog.getInstance().info("Respuesta API MMII SURACorp: " + response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: "+e.getMessage());
        }
    }

}
