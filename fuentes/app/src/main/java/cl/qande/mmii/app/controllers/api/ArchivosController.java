package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.ApiResponse;
import cl.qande.mmii.app.models.api.Archivo;
import cl.qande.mmii.app.models.api.ArchivosMaestrosResponseError;
import cl.qande.mmii.app.models.api.ArchivosMaestrosResponseOk;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/archivos")
public class ArchivosController {

    private final AppConfig appConfig;
    private final ApiHelper apiHelper;
    private final ArchivosHelper archivosHelper;
    private final ControlDiarioService controlDiarioService;

    @Autowired
    public ArchivosController(AppConfig appConfig, ApiHelper apiHelper, ArchivosHelper archivosHelper, ControlDiarioService controlDiarioService) {
        this.appConfig = appConfig;
        this.apiHelper = apiHelper;
        this.archivosHelper = archivosHelper;
        this.controlDiarioService = controlDiarioService;
    }


    @GetMapping("/reportes-maestros/{process-date}")
    public ResponseEntity<ApiResponse> listaArchivosReporteMaestros(
            @RequestHeader(value = ApiHelper.HEADER_API_KEY, required = true) String apiKey,
            @RequestHeader(value = ApiHelper.HEADER_CLIENT_ID, required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(ApiHelper.HEADER_JSON_KEY, ApiHelper.HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiArchivos()) {
            CustomLog.getInstance().error("Error en método REST [Api Archivos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosMaestrosResponseError(3, "Api Archivos no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId, ApiHelper.ID_API_ARCHIVOS);
            apiHelper.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            CustomLog.getInstance().error("Error en método REST Obtener Archivos Reportes Maestros ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosMaestrosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }
        var resultado   = controlDiarioService.resultadoJobs(processDate);
        if (resultado==null || resultado!=0) {
            return new ResponseEntity<>(new ArchivosMaestrosResponseError(4, "Error en validación de datos: no han sido validados o no superan validación diaria. Re intente más tarde."), responseHeaders, HttpStatus.OK);
        }
        List<Archivo> listaArchivosApi = new ArrayList<>();
        var listaArchivos = archivosHelper.listadoDeArchivosMaestros(processDate);
        for(var archivo : listaArchivos) {
            Archivo archivoApi = new Archivo();
            archivoApi.setNombreOriginal(archivo);
            archivoApi.setExtension(archivosHelper.obtieneExtension(archivo));
            try {
                archivoApi.setArchivoBase64(archivosHelper.serializaBase64(appConfig.appConfigProperties.getReportesMaestrosFolder(), archivo));
            } catch (QandeMmiiException e) {
                CustomLog.getInstance().error("Error al serializar archivos Maestros para fecha proceso ["+processDate+"]: "+e.getMessage());
                return new ResponseEntity<>(new ArchivosMaestrosResponseError(2, "Error al serializar archivos Maestros"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            listaArchivosApi.add(archivoApi);
        }

        return new ResponseEntity<>(new ArchivosMaestrosResponseOk(listaArchivosApi), responseHeaders, HttpStatus.OK);

    }


}
