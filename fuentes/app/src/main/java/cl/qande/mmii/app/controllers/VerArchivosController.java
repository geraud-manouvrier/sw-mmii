package cl.qande.mmii.app.controllers;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/archivos")
public class VerArchivosController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String URL_BASE    = "lista_archivos";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private ArchivosHelper archivosHelper;
    @GetMapping({"/maestro_datos/listar"})
    public String listaMaestroDatos(Model model) {
        return "redirect:/archivos/maestro_datos/listar/fecha/"+calendarioHelper.defaultProcessDate();
    }
    @GetMapping({"/maestro_datos/listar/fecha/{processDate}"})
    public String listaMaestroDatosPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {

        var listaArchivosFiltrado	= archivosHelper.listadoDeArchivosMaestros(processDate);
        model.addAttribute("listaArchivos", listaArchivosFiltrado);
        model.addAttribute(CAMPO_TITULO, "Maestro Datos");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute("processDate", processDate);
        model.addAttribute("tipoArchivo", "maestro_datos");
        sesionWeb.getAppMenu().cambiaNavegacion(Menu.ARCHIVOS_MAESTROS, false);
        return URL_BASE;
    }

    @GetMapping({"/maestro_datos/ver/{filename}"})
    public ResponseEntity<Resource> descargaMaestroDatos(@PathVariable String filename) throws QandeMmiiException {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(archivosHelper.getFileAsResource(appConfig.appConfigProperties.getReportesMaestrosFolder(), filename));
    }
}
