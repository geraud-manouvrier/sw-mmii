package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.reportes_maestros.ReporteMaestrosResponseError;
import cl.qande.mmii.app.models.api.reportes_maestros.ReporteMaestrosResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
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
    private final ReporteMaestroDatosService reporteMaestroDatosService;
    private final ControlDiarioService controlDiarioService;

    private static final String ERROR_PREFIX    = "Error en método REST Reportes Maestros";

    @Autowired
    public ReporteMaestrosController(ApiHelper apiHelper, ReporteMaestroDatosService reporteMaestroDatosService, ControlDiarioService controlDiarioService) {
        this.apiHelper = apiHelper;
        this.reporteMaestroDatosService = reporteMaestroDatosService;
        this.controlDiarioService = controlDiarioService;
    }


    @GetMapping("/{process-date}")
    public ResponseEntity<ApiResponse> reportesMaestros(
            @RequestHeader(value = ApiHelper.HEADER_API_KEY, required = true) String apiKey,
            @RequestHeader(value = ApiHelper.HEADER_CLIENT_ID, required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiReportesMaestros()) {
            CustomLog.getInstance().error(ERROR_PREFIX+" [Api Reportes Maestros no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(3, "Api Reportes Maestros no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId, ApiHelper.ID_API_REP_MAESTROS);
            apiHelper.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            CustomLog.getInstance().error(ERROR_PREFIX+" ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ReporteMaestrosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var resultado   = controlDiarioService.resultadoJobs(processDate);
        if (resultado==null || resultado!=0) {
            return new ResponseEntity<>(new ReporteMaestrosResponseError(4, "Error en validación de datos: no han sido validados o no superan validación diaria. Re intente más tarde."), responseHeaders, HttpStatus.OK);
        }

        var respuesta = new ReporteMaestrosResponseOk();

        try {
            respuesta.setMaestroMovimientos( reporteMaestroDatosService.reporteMaestroMovimientosApi(processDate) );
            respuesta.setMaestroSaldos( reporteMaestroDatosService.reporteMaestroSaldosApi(processDate) );
            respuesta.setMaestroRelacionados( reporteMaestroDatosService.reporteMaestroRelacionadosApi(processDate) );
        } catch (Exception e) {
            CustomLog.getInstance().error(ERROR_PREFIX+" Obtener registros Reportes Maestros para fecha proceso ["+processDate+"]: "+e.getMessage());
            return new ResponseEntity<>(new ReporteMaestrosResponseError(2, "Error al obtener registros Reportes Maestros"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(respuesta, responseHeaders, HttpStatus.OK);

    }


}
