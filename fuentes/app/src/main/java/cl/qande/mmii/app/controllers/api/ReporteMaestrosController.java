package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.ReporteMaestrosResponseError;
import cl.qande.mmii.app.models.api.ReporteMaestrosResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes-maestros")
public class ReporteMaestrosController {
    private final ApiHelper apiHelper;
    private final IReporteMaestroDatosService reporteMaestroDatosService;

    private static final String ERROR_PREFIX    = "Error en método REST Reportes Maestros";

    @Autowired
    public ReporteMaestrosController(ApiHelper apiHelper, IReporteMaestroDatosService reporteMaestroDatosService) {
        this.apiHelper = apiHelper;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
    }


    @GetMapping("/{process-date}")
    public ResponseEntity<ApiResponse> reportesMaestros(
            @RequestHeader(value = ApiHelper.HEADER_API_KEY, required = true) String apiKey,
            @RequestHeader(value = ApiHelper.HEADER_CLIENT_ID, required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiReportesMaestros()) {
            CustomLog.getInstance().error(ERROR_PREFIX+" [Api Archivos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(3, "Api Reportes Maestros no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId, ApiHelper.ID_API_REP_MAESTROS);
            this.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            CustomLog.getInstance().error(ERROR_PREFIX+" ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var respuesta = new ReporteMaestrosResponseOk();

        try {
            respuesta.setMaestroMovimientos( reporteMaestroDatosService.reporteMaestroMovimientosApi(processDate) );
            respuesta.setMaestroSaldos( reporteMaestroDatosService.reporteMaestroSaldosApi(processDate) );
        } catch (Exception e) {
            CustomLog.getInstance().error(ERROR_PREFIX+" Obtener registros Reportes Maestros para fecha proceso ["+processDate+"]: "+e.getMessage());
            return new ResponseEntity<>(new ReporteMaestrosResponseError(2, "Error al obtener registros Reportes Maestros"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(respuesta, responseHeaders, HttpStatus.OK);

    }

    public void validaProcessDate(String processDate)  throws QandeMmiiException {
        if ( ! (processDate != null && processDate.length()==8 && processDate.matches("[\\d]+") ) ) {
            CustomLog.getInstance().error("Error Process Date ["+processDate+"]");
            throw new QandeMmiiException("Process Date inválido");
        }
    }


}
