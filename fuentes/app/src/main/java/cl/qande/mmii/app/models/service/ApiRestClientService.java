package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.AppApiClientSuraCorpProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiRestClientService {

    public static final String CUSTODIAN_PERSHING = "PERSHING";
    private static final String STR_FORMAT_URL = "%s%s%s";
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
        String url = String.format(STR_FORMAT_URL,
                apiClientSuraCorpProperties.getServer(),
                apiClientSuraCorpProperties.getPath(),
                apiClientSuraCorpProperties.getMethodSourceCode() );
        CustomLog.getInstance().info("URL Rest SuraCorp: " + url);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(getHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ParSourceCodeResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, ParSourceCodeResponse.class);
            CustomLog.getInstance().info("Response API: " + response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: "+e.getMessage());
        }
    }

    public ClientFeeResponse getClientFee(String accountNumber) throws QandeMmiiException {
        CustomLog.getInstance().info("Invocando API SuraCorp para obtener Fee Cliente");
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(STR_FORMAT_URL,
                apiClientSuraCorpProperties.getServer(),
                apiClientSuraCorpProperties.getPath(),
                apiClientSuraCorpProperties.getMethodClientFee() );
        CustomLog.getInstance().info("URL Rest SuraCorp: " + url);

        var clientFeeRequest = new ClientFeeRequest(CUSTODIAN_PERSHING, accountNumber);

        HttpEntity<ClientFeeRequest> request = new HttpEntity<>(clientFeeRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ClientFeeResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, ClientFeeResponse.class);
            CustomLog.getInstance().info("Response API: " + response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: "+e.getMessage());
        }
    }

    public FeeControlResponse getFeeControl(List<AccountFee> accountsFees, String custodian) throws QandeMmiiException {
        CustomLog.getInstance().info("Invocando API SuraCorp para validar Fees de Clientes");
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(STR_FORMAT_URL,
                apiClientSuraCorpProperties.getServer(),
                apiClientSuraCorpProperties.getPath(),
                apiClientSuraCorpProperties.getMethodClientFeeControl() );
        CustomLog.getInstance().info("URL Rest SuraCorp Pre: " + url);

        var bodyRequest = new FeeControlRequest(custodian, accountsFees);

        HttpEntity<FeeControlRequest> request = new HttpEntity<>(bodyRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<FeeControlResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, FeeControlResponse.class);
            CustomLog.getInstance().info("Respuesta API MMII SURACorp: " + response);
            return response.getBody();
        } catch (HttpStatusCodeException e) {
            String errorBody = e.getResponseBodyAsString();
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new QandeMmiiException(e, "Error controlado llamando API MMII SURACorp HTTP 400: " + errorBody);
            }
            CustomLog.getInstance().error("Error no controlado llamando API MMII SuraCorp HTTP: " + e.getStatusCode() + " - Body: " + errorBody);
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: " + errorBody);
        }  catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API SuraCorp: "+e.getMessage());
        }
    }

}
