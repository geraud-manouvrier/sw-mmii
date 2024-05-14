package cl.qande.mmii.app.controllers.api;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.api.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ApiHelper;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
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


    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ApiHelper apiHelper;
    @Autowired
    private ArchivosHelper archivosHelper;
    private static final String HEADER_JSON_KEY    = "Content-Type";
    private static final String HEADER_JSON_VAL    = "application/json";

    @GetMapping("/reportes-ingresos-egresos/{process-date}")
    public ResponseEntity<ApiResponse> listaArchivosReporteIngresosEgresos(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiArchivos()) {
            appConfig.customLog.error("Error en método REST [Api Archivos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosIngresosEgresosResponseError(3, "Api Archivos no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            this.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            appConfig.customLog.error("Error en método REST Obtener Archivos Reportes Ingresos/Egresos ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosIngresosEgresosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        List<Archivo> listaArchivosApi = new ArrayList<>();
        var listaArchivos = archivosHelper.listadoDeArchivosIngresosEgresos(processDate);
        for(var archivo : listaArchivos) {
            Archivo archivoApi = new Archivo();
            archivoApi.setNombreOriginal(archivo);
            archivoApi.setExtension(archivosHelper.obtieneExtension(archivo));
            try {
                archivoApi.setArchivoBase64(archivosHelper.serializaBase64(appConfig.appConfigProperties.getReportesIngresosegresosFolder(), archivo));
            } catch (QandeMmiiException e) {
                appConfig.customLog.error("Error al serializar archivos Ingresos/Egresos para fecha proceso ["+processDate+"]: "+e.getMessage());
                return new ResponseEntity<>(new ArchivosIngresosEgresosResponseError(2, "Error al serializar archivos"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            listaArchivosApi.add(archivoApi);
        }

        return new ResponseEntity<>(new ArchivosIngresosEgresosResponseOk(listaArchivosApi), responseHeaders, HttpStatus.OK);

    }

    @GetMapping("/reportes-maestros/{process-date}")
    public ResponseEntity<ApiResponse> listaArchivosReporteMaestros(
            @RequestHeader(value = "x-api_key", required = true) String apiKey,
            @RequestHeader(value = "x-client_id", required = true) String appClientId,
            @PathVariable("process-date") String processDate) {
        var responseHeaders	= new HttpHeaders();
        responseHeaders.set(HEADER_JSON_KEY, HEADER_JSON_VAL);

        if (! apiHelper.isEnabledApiArchivos()) {
            appConfig.customLog.error("Error en método REST [Api Archivos no habilitada] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosMaestrosResponseError(3, "Api Archivos no habilitada"), responseHeaders, HttpStatus.BAD_REQUEST);
        }

        try {
            apiHelper.validateApiKey(apiKey, appClientId);
            this.validaProcessDate(processDate);
        } catch (QandeMmiiException qandeMmiiException) {
            appConfig.customLog.error("Error en método REST Obtener Archivos Reportes Ingresos/Egresos ["+qandeMmiiException.getMessage()+"] Cod. "+HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new ArchivosMaestrosResponseError(1, "Error al validar llamada: "+qandeMmiiException.getMessage()), responseHeaders, HttpStatus.BAD_REQUEST);
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
                appConfig.customLog.error("Error al serializar archivos Maestros para fecha proceso ["+processDate+"]: "+e.getMessage());
                return new ResponseEntity<>(new ArchivosMaestrosResponseError(2, "Error al serializar archivos Maestros"), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            listaArchivosApi.add(archivoApi);
        }

        return new ResponseEntity<>(new ArchivosMaestrosResponseOk(listaArchivosApi), responseHeaders, HttpStatus.OK);

    }

    public void validaProcessDate(String processDate)  throws QandeMmiiException {
        if ( ! (processDate != null && processDate.length()==8 && processDate.matches("[\\d]+") ) ) {
            appConfig.customLog.error("Error Process Date ["+processDate+"]");
            throw new QandeMmiiException("Process Date inválido");
        }
    }


}
