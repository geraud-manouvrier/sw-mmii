package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.retornos.RetornosResponseError;
import cl.qande.mmii.app.models.api.retornos.RetornosResponseOk;
import cl.qande.mmii.app.models.db.rep_inv.ReporteInversionesService;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.mapper.rep_inv.RentabilidadCalculadaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/retornos")
public class RetornosController {
    private final ApiHelper apiHelper;
    private final ReporteInversionesService mainService;
    private final ControlDiarioService controlDiarioService;

    private static final String ERROR_PREFIX    = "Error en método REST Retornos";
    private final RentabilidadCalculadaMapper rentabilidadCalculadaMapper;

    @Autowired
    public RetornosController(ApiHelper apiHelper, ReporteInversionesService mainService, ControlDiarioService controlDiarioService,
                              RentabilidadCalculadaMapper rentabilidadCalculadaMapper) {
        this.apiHelper = apiHelper;
        this.mainService = mainService;
        this.controlDiarioService = controlDiarioService;
        this.rentabilidadCalculadaMapper = rentabilidadCalculadaMapper;
    }


    @GetMapping("/{periodo}/{dia}")
    public ResponseEntity<ApiResponse> retornos(
            @RequestHeader(value = ApiHelper.HEADER_API_KEY, required = true) String apiKey,
            @RequestHeader(value = ApiHelper.HEADER_CLIENT_ID, required = true) String appClientId,
            @PathVariable("periodo") Integer periodo,
            @PathVariable("dia") Integer dia
            ) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiRetornos()) {
            CustomLog.getInstance().error(ERROR_PREFIX+" [Api Retornos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new RetornosResponseError(3, "Api Retornos no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var processDate = "";

        try {
            apiHelper.validateApiKey(apiKey, appClientId, ApiHelper.ID_API_RET);
            processDate = this.buildProcessDate(periodo, dia);
            apiHelper.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            CustomLog.getInstance().error(ERROR_PREFIX+" ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new RetornosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var resultado   = controlDiarioService.resultadoJobs(processDate);
        if (resultado==null || resultado!=0) {
            return new ResponseEntity<>(new RetornosResponseError(4, "Error en validación de datos: no han sido validados o no superan validación diaria. Re intente más tarde."), responseHeaders, HttpStatus.OK);
        }

        var respuesta = new RetornosResponseOk();

        try {
            respuesta.setRetornoCuentas(rentabilidadCalculadaMapper.toDto(mainService.calculaRentabilidadPorCuentaUniversoClientes(processDate)));
        } catch (Exception e) {
            CustomLog.getInstance().error(ERROR_PREFIX+" Obtener retornos para fecha proceso ["+processDate+"]: "+e.getMessage());
            return new ResponseEntity<>(new RetornosResponseError(2, "Error al obtener retornos"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(respuesta, responseHeaders, HttpStatus.OK);

    }

    public String buildProcessDate(Integer periodo, Integer dia) throws QandeMmiiException {
        var processDate = String.valueOf(periodo);
        if (dia>9) {
            processDate = processDate.concat(String.valueOf(dia));
        } else {
            processDate = processDate.concat("0").concat(String.valueOf(dia==0 ? 1 : dia));
            if (dia==0) {
                try {
                    processDate = CalendarioHelper.processDateConDesfase(processDate, -1);
                } catch (ParseException e) {
                    throw new QandeMmiiException(e, "Error al generar process date con periodo ["+periodo+"] y día ["+dia+"]");
                }
            }
        }
        return processDate;
    }


}
