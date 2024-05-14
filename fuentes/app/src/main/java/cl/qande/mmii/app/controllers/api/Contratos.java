package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.ApiResponseErrorContratos;
import cl.qande.mmii.app.models.api.ApiResponseOk;
import cl.qande.mmii.app.models.api.Contrato;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class Contratos {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ApiHelper apiHelper;

    private static final String HEADER_JSON_KEY    = "Content-Type";
    private static final String HEADER_JSON_VAL    = "application/json";
    @PostMapping(value= {"/contrato"})
    public ResponseEntity<ApiResponse> crearContratoByPost(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId,
            @RequestBody cl.qande.mmii.app.models.api.ContratoRequest contratoRequest) {
        appConfig.customLog.info("Iniciando método rest [crearContratoByPost]. Request recibido: "+contratoRequest.toString());
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);
        List<Contrato> contratosConError = new ArrayList<>();

        if (! apiHelper.isEnabledApiContratos()) {
            appConfig.customLog.error("Error en método REST [Api Contratos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ApiResponseErrorContratos(5, "Api Contratos no habilitada", contratosConError), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            if (! apiHelper.creaContrato(contratoRequest.getContrato(), contratoRequest.getIdCliente())) {
                appConfig.customLog.error("Error en método REST [crearContratoByPost] Cod. "+HttpStatus.BAD_REQUEST);
                contratosConError.add(contratoRequest.getContrato());
                return new ResponseEntity<>(new ApiResponseErrorContratos(3, "Error al procesar contrato", contratosConError), responseHeaders, HttpStatus.BAD_REQUEST);
            }
        } catch (QandeMmiiException qandeMmiiException) {
            appConfig.customLog.error("Error en método REST [crearContratoByPost] ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            contratosConError.add(contratoRequest.getContrato());
            return new ResponseEntity<>(new ApiResponseErrorContratos(1, qandeMmiiException.getMessage(), contratosConError), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            appConfig.customLog.error("Error en método REST [crearContratoByPost] ["+e.getMessage()+"] Cod. "+HttpStatus.INTERNAL_SERVER_ERROR);
            contratosConError.add(contratoRequest.getContrato());
            return new ResponseEntity<>(new ApiResponseErrorContratos(4, e.getMessage(), contratosConError), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if ( contratosConError.isEmpty()) {
            appConfig.customLog.info("Método REST [crearContratoByPost] finalizado Cod. "+HttpStatus.OK);
            return new ResponseEntity<>(new ApiResponseOk(), responseHeaders, HttpStatus.OK);
        } else {
            appConfig.customLog.info("Método REST [crearContratoByPost] finalizado Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ApiResponseErrorContratos(2, "Error al procesar contrato", contratosConError), responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }
}
