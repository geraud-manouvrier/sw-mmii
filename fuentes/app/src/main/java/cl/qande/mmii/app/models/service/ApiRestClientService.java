package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.AppApiClientSuraCorpProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ClientFeeRequest;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ClientFeeResponse;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCodeResponse;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiRestClientService {

    private static final String CUSTODIAN_PERSHING = "PERSHING";
    private final AppApiClientSuraCorpProperties apiClientSuraCorpProperties;

    @Autowired
    public ApiRestClientService(AppApiClientSuraCorpProperties apiClientSuraCorpProperties) {
        this.apiClientSuraCorpProperties = apiClientSuraCorpProperties;
    }

    private MultiValueMap<String, String> getHeaderForMmiiSuracorp() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(ApiHelper.HEADER_API_KEY, apiClientSuraCorpProperties.getxApiKey());
        headers.add(ApiHelper.HEADER_CLIENT_ID, apiClientSuraCorpProperties.getxClientId());
        headers.add("Content-Type", "application/json");
        return headers;
    }

    private HttpHeaders getHttpHeaderForMmiiSuracorp() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(ApiHelper.HEADER_API_KEY, apiClientSuraCorpProperties.getxApiKey());
        headers.add(ApiHelper.HEADER_CLIENT_ID, apiClientSuraCorpProperties.getxClientId());
        headers.setContentType(MediaType.APPLICATION_JSON);
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

    public ClientFeeResponse getClientFee(String accountNumber) throws QandeMmiiException {
        CustomLog.getInstance().info("Invocando API SuraCorp para obtener Fee Cliente");
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s%s%s",
                apiClientSuraCorpProperties.getServer(),
                apiClientSuraCorpProperties.getPath(),
                apiClientSuraCorpProperties.getMethodClientFee() );
        CustomLog.getInstance().info("URL Rest SuraCorp Pre: " + url);

        var clientFeeRequest = new ClientFeeRequest(CUSTODIAN_PERSHING, accountNumber);

        HttpEntity<ClientFeeRequest> request = new HttpEntity<>(clientFeeRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ClientFeeResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, ClientFeeResponse.class);
            CustomLog.getInstance().info("Respuesta API MMII SURACorp: " + response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: "+e.getMessage());
        }
    }

}
