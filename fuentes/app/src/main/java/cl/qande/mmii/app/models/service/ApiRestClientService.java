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
    private static final String REST_NAME = "SuraCorp";
    private static final String STR_FORMAT_URL = "%s%s%s";
    private final AppApiClientSuraCorpProperties apiClientSuraCorpProperties;

    @Autowired
    public ApiRestClientService(AppApiClientSuraCorpProperties apiClientSuraCorpProperties) {
        this.apiClientSuraCorpProperties = apiClientSuraCorpProperties;
    }

    private MultiValueMap<String, String> getHeaderForMmiiSuracorp() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(ApiHelper.HEADER_API_KEY, apiClientSuraCorpProperties.getXApiKey());
        headers.add(ApiHelper.HEADER_CLIENT_ID, apiClientSuraCorpProperties.getXClientId());
        headers.add("Content-Type", "application/json");
        return headers;
    }

    private HttpHeaders getHttpHeaderForMmiiSuracorp() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(ApiHelper.HEADER_API_KEY, apiClientSuraCorpProperties.getXApiKey());
        headers.add(ApiHelper.HEADER_CLIENT_ID, apiClientSuraCorpProperties.getXClientId());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private void logStartApi(String method) {
        CustomLog.getInstance().info("Invocando API ["+REST_NAME+"] para obtener "+method);
    }

    private void logResponse(ResponseEntity<?> response) {
        CustomLog.getInstance().info("Response API ["+REST_NAME+"]: " + response);
    }

    private String makeUrlRestRia(String method) {
        String url = String.format(STR_FORMAT_URL, apiClientSuraCorpProperties.getServer(), apiClientSuraCorpProperties.getPath(), method);
        CustomLog.getInstance().info("URL Rest ["+REST_NAME+"]: " + url);
        return url;
    }

    public ParSourceCodeResponse getListSourceCode() throws QandeMmiiException {
        logStartApi("Lista de códigos de fuente");
        RestTemplate restTemplate = new RestTemplate();
        String url = makeUrlRestRia(apiClientSuraCorpProperties.getMethodSourceCode() );

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(getHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ParSourceCodeResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, ParSourceCodeResponse.class);
            logResponse(response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: "+e.getMessage());
        }
    }

    public ClientFeeResponse getClientFee(String accountNumber) throws QandeMmiiException {
        logStartApi("Fee Cliente");
        RestTemplate restTemplate = new RestTemplate();
        String url = makeUrlRestRia(apiClientSuraCorpProperties.getMethodClientFee() );

        var clientFeeRequest = new ClientFeeRequest(CUSTODIAN_PERSHING, accountNumber);

        HttpEntity<ClientFeeRequest> request = new HttpEntity<>(clientFeeRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ClientFeeResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, ClientFeeResponse.class);
            logResponse(response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: "+e.getMessage());
        }
    }

    public ListFeeResponse getListClientsFee(List<String> accountsList, String processDate, String custodian) throws QandeMmiiException {
        logStartApi("Lista de Fee Clientes");
        RestTemplate restTemplate = new RestTemplate();
        String url = makeUrlRestRia(apiClientSuraCorpProperties.getMethodClientFeeList() );

        var listFeeRequest = new ListFeeRequest(processDate, custodian, accountsList);
        HttpEntity<ListFeeRequest> request = new HttpEntity<>(listFeeRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ListFeeResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, ListFeeResponse.class);
            logResponse(response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: "+e.getMessage());
        }
    }

    public ListPortfolioResponse getListClientsPortfolio(List<String> accountsList, String processDate, String custodian) throws QandeMmiiException {
        logStartApi("Lista de Portfolios Clientes");
        RestTemplate restTemplate = new RestTemplate();
        String url = makeUrlRestRia(apiClientSuraCorpProperties.getMethodClientPortfolioList() );

        var listPortfolioRequest = new ListPortfolioRequest(processDate, custodian, accountsList);
        HttpEntity<ListPortfolioRequest> request = new HttpEntity<>(listPortfolioRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<ListPortfolioResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, ListPortfolioResponse.class);
            logResponse(response);
            return response.getBody();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: "+e.getMessage());
        }
    }

    public FeeControlResponse getFeeControl(List<AccountFee> accountsFees, String custodian) throws QandeMmiiException {
        logStartApi("Control de Fee Clientes");
        RestTemplate restTemplate = new RestTemplate();
        String url = makeUrlRestRia(apiClientSuraCorpProperties.getMethodClientFeeControl() );

        var bodyRequest = new FeeControlRequest(custodian, accountsFees);

        HttpEntity<FeeControlRequest> request = new HttpEntity<>(bodyRequest, getHttpHeaderForMmiiSuracorp());

        try {
            ResponseEntity<FeeControlResponse> response = restTemplate.exchange(url, HttpMethod.POST, request, FeeControlResponse.class);
            logResponse(response);
            return response.getBody();
        } catch (HttpStatusCodeException e) {
            String errorBody = e.getResponseBodyAsString();
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new QandeMmiiException(e, "Error controlado llamando API MMII ["+REST_NAME+"] HTTP 400: " + errorBody);
            }
            CustomLog.getInstance().error("Error no controlado llamando API MMII ["+REST_NAME+"] HTTP: " + e.getStatusCode() + " - Body: " + errorBody);
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: " + errorBody);
        }  catch (Exception e) {
            throw new QandeMmiiException(e, "Error en la invocación a API ["+REST_NAME+"]: "+e.getMessage());
        }
    }

}
