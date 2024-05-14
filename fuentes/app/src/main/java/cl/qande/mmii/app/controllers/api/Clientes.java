package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class Clientes {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ApiHelper apiHelper;

    private static final String HEADER_JSON_KEY    = "Content-Type";
    private static final String HEADER_JSON_VAL    = "application/json";
    @PostMapping(value= {"/", ""})
    public ResponseEntity<ApiResponse> crearListaClientesByPost(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId,
            @RequestBody ClientesRequest clientesRequest) {
        appConfig.customLog.info("Iniciando método rest Crear Clientes. Request recibido: "+ clientesRequest.toString());
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiClientes()) {
            appConfig.customLog.error("Error en método REST [Api Clientes no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ApiResponseErrorClientes(3, "Api Clientes no habilitada", clientesRequest.getClientes()), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        var clientesConError    = new ClientesRequest();
        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            for(Cliente clienteApi : clientesRequest.getClientes()) {
                if (! apiHelper.creaCliente(clienteApi)) {
                    clientesConError.getClientes().add(clienteApi);
                }
            }
        } catch (QandeMmiiException qandeMmiiException) {
            appConfig.customLog.error("Error en método REST ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ApiResponseErrorClientes(1, qandeMmiiException.getMessage(), clientesRequest.getClientes()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            appConfig.customLog.error("Error en método REST ["+e.getMessage()+"] Cod. "+HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(new ApiResponseErrorClientes(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if ( clientesConError.getClientes().isEmpty()) {
            appConfig.customLog.info("Método REST finalizado Cod. "+HttpStatus.OK);
            return new ResponseEntity<>(new ApiResponseOk(), responseHeaders, HttpStatus.OK);
        } else {
            appConfig.customLog.info("Método REST finalizado Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ApiResponseErrorClientes(2, "Error al procesar Clientes", clientesConError.getClientes()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
    }
}
