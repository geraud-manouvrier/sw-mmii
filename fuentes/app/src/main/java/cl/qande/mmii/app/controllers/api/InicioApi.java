package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.ApiResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InicioApi {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ApiHelper apiHelper;

    private static final String HEADER_JSON_KEY    = "Content-Type";
    private static final String HEADER_JSON_VAL    = "application/json";
    @GetMapping(value= {"/status"})
    public ResponseEntity<ApiResponse> statusApi(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId) {
        appConfig.customLog.info("Iniciando método rest status...");
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);

        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            appConfig.customLog.info("Método REST finalizado");
            return new ResponseEntity<>(new ApiResponseOk(), responseHeaders, HttpStatus.OK);
        } catch (QandeMmiiException qandeMmiiException) {
            return new ResponseEntity<>(new ApiResponse(1, qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            appConfig.customLog.error("Error en método REST ["+e.getMessage()+"]");
            return new ResponseEntity<>(new ApiResponse(2, "Error: "+e.getMessage()), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
