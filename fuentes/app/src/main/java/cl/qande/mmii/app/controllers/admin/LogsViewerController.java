package cl.qande.mmii.app.controllers.admin;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMINQANDE_LOGS_VIEWER))")
@RequestMapping("/admin/logs")
public class LogsViewerController {

    private static final int DESFASE_DIAS = -1;
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_START_PROCESS_DATE = "startProcessDate";
    private static final String CAMPO_END_PROCESS_DATE = "endProcessDate";

    private final SesionWeb sesionWeb;
    private final AppConfig appConfig;
    private final CalendarioHelper calendarioHelper;
    private final ArchivosHelper archivosHelper;

    @Autowired
    public LogsViewerController(SesionWeb sesionWeb, AppConfig appConfig, CalendarioHelper calendarioHelper, ArchivosHelper archivosHelper) {
        this.sesionWeb = sesionWeb;
        this.appConfig = appConfig;
        this.calendarioHelper = calendarioHelper;
        this.archivosHelper = archivosHelper;
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMINQANDE_LOGS_VIEWER))")
    @GetMapping({"listar", "listar/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String listaArchivos(
            @PathVariable(value = CAMPO_START_PROCESS_DATE, required = false) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE, required = false) String endProcessDate,
            Model model
    ) throws QandeMmiiException {
        if (startProcessDate==null || startProcessDate.isEmpty())
            startProcessDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        if (endProcessDate==null || endProcessDate.isEmpty())
            endProcessDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        return inicioJobsConRangoFechasHandler(startProcessDate, endProcessDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMINQANDE_LOGS_VIEWER))")
    @GetMapping({"ver", "ver/{nombreArchivoLog}"})
    public ResponseEntity<Resource> abrirLog(
            @PathVariable(value = "nombreArchivoLog", required = true) String nombreArchivoLog
    ) throws QandeMmiiException {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + nombreArchivoLog + "\"")
                .header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=UTF-8")
                .body(archivosHelper.getFileAsResource(appConfig.appConfigProperties.getLogFolder(), nombreArchivoLog));
    }


    /****************************************************
     * Funciones comunes
     ****************************************************/


    private String inicioJobsConRangoFechasHandler(
            String startProcessDate, String endProcessDate,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_TITULO, "Visor de Logs");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_START_PROCESS_DATE, startProcessDate);
        model.addAttribute(CAMPO_END_PROCESS_DATE, endProcessDate);
        var archivosLogHistoricos = ArchivosHelper.listaArchivosPorExtension(appConfig.appConfigProperties.getLogFolder(), ".log", false);
        List<String> archivosLogActuales = List.of(
                "qande-mmii.log",
                "qande-mmii-api.log",
                "qande-mmii-job.log"
        );
        model.addAttribute("archivosLogHistoricos", filterLogFiles(archivosLogHistoricos, startProcessDate, endProcessDate));
        model.addAttribute("archivosLogActuales", archivosLogActuales);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.ADMINQANDE_LOGS_VIEWER, false);
    }

    public static List<String> filterLogFiles(List<String> logFiles, String startDate, String endDate) {
        // Formato para las fechas de entrada sin guiones (YYYYMMDD)
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // Formato para las fechas en los nombres de archivo (YYYY-MM-DD)
        DateTimeFormatter fileFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Convertir las fechas de inicio y fin a LocalDate
        LocalDate start = LocalDate.parse(startDate, inputFormatter);
        LocalDate end = LocalDate.parse(endDate, inputFormatter);

        // Filtrar los archivos
        return logFiles.stream()
                .filter(file -> {
                    // Extraer la fecha del nombre del archivo
                    String datePart = extractDateFromFileName(file);
                    if (datePart == null) {
                        return false; // Ignorar archivos que no tienen fecha válida
                    }

                    LocalDate fileDate = LocalDate.parse(datePart, fileFormatter);
                    return !fileDate.isBefore(start) && !fileDate.isAfter(end);
                })
                .collect(Collectors.toList());
    }

    private static String extractDateFromFileName(String fileName) {
        // Expresión regular para buscar el patrón de fecha YYYY-MM-DD
        Pattern datePattern = Pattern.compile("\\b\\d{4}-\\d{2}-\\d{2}\\b");
        Matcher matcher = datePattern.matcher(fileName);
        if (matcher.find()) {
            return matcher.group(); // Devolver la fecha encontrada
        }
        return null; // No se encontró una fecha válida
    }

}
