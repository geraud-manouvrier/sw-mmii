package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.ReporteMaestrosResponseError;
import cl.qande.mmii.app.models.api.ReporteMaestrosResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.ApiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes-maestros")
public class ReporteMaestrosController {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ApiHelper apiHelper;
    @Autowired
    private IReporteMaestroDatosService reporteMaestroDatosService;
    private static final String HEADER_JSON_KEY    = "Content-Type";
    private static final String HEADER_JSON_VAL    = "application/json";
    private static final String ERROR_PREFIX    = "Error en método REST Reportes Maestros";


    @GetMapping("/{process-date}")
    public ResponseEntity<ApiResponse> reportesMaestros(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiReportesMaestros()) {
            appConfig.customLog.error(ERROR_PREFIX+" [Api Archivos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(3, "Api Reportes Maestros no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            this.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            appConfig.customLog.error(ERROR_PREFIX+" ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var respuesta = new ReporteMaestrosResponseOk();

        try {
            respuesta.setMaestroMovimientos( reporteMaestroDatosService.reporteMaestroMovimientosApi(processDate) );
            respuesta.setMaestroSaldos( reporteMaestroDatosService.reporteMaestroSaldosApi(processDate) );
        } catch (Exception e) {
            appConfig.customLog.error(ERROR_PREFIX+" Obtener registros Reportes Maestros para fecha proceso ["+processDate+"]: "+e.getMessage());
            return new ResponseEntity<>(new ReporteMaestrosResponseError(2, "Error al obtener registros Reportes Maestros"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(respuesta, responseHeaders, HttpStatus.OK);

    }

    public void validaProcessDate(String processDate)  throws QandeMmiiException {
        if ( ! (processDate != null && processDate.length()==8 && processDate.matches("[\\d]+") ) ) {
            appConfig.customLog.error("Error Process Date ["+processDate+"]");
            throw new QandeMmiiException("Process Date inválido");
        }
    }


}
