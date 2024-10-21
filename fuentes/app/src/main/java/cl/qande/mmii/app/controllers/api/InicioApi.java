package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.ApiResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
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

    private final ApiHelper apiHelper;

    @Autowired
    public InicioApi(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    @GetMapping(value= {"/status"})
    public ResponseEntity<ApiResponse> statusApi(
            @RequestHeader(value = ApiHelper.HEADER_API_KEY, required = true) String apiKey,
            @RequestHeader(value = ApiHelper.HEADER_CLIENT_ID, required = true) String appClientId) {
        CustomLog.getInstance().info("Iniciando método rest status...");
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);

        try {
            apiHelper.validateApiKey(apiKey, appClientId, ApiHelper.ID_API_STATUS);
            CustomLog.getInstance().info("Método REST finalizado");
            return new ResponseEntity<>(new ApiResponseOk(), responseHeaders, HttpStatus.OK);
        } catch (QandeMmiiException qandeMmiiException) {
            return new ResponseEntity<>(new ApiResponse(1, qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            CustomLog.getInstance().error("Error en método REST ["+e.getMessage()+"]");
            return new ResponseEntity<>(new ApiResponse(2, "Error: "+e.getMessage()), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
