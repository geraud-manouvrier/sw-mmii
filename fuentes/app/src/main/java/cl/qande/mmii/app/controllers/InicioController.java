package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppSchedulingProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CronHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InicioController {

	protected final Log logger = LogFactory.getLog(this.getClass());


	private static final String CAMPO_TITULO    = "titulo";
	private static final String CAMPO_SESION    = "sesionWeb";

	private final SesionWeb sesionWeb;
	private final CalendarioHelper calendarioHelper;
	private final CronHelper cronHelper;
	private final AppSchedulingProperties appSchedulingProperties;
	private final AppConfig appConfig;
	private final ArchivosHelper archivosHelper;

	@Autowired
	public InicioController(SesionWeb sesionWeb, CalendarioHelper calendarioHelper, CronHelper cronHelper, AppSchedulingProperties appSchedulingProperties, AppConfig appConfig, ArchivosHelper archivosHelper) {
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
        this.cronHelper = cronHelper;
        this.appSchedulingProperties = appSchedulingProperties;
        this.appConfig = appConfig;
        this.archivosHelper = archivosHelper;
    }

    @PreAuthorize("isAuthenticated()")
	@GetMapping({"/", "/index", "/home"})
	public String sesionIniciada(Model model,
                                 Authentication authentication,
                                 HttpServletRequest request) throws QandeMmiiException {
		if (authentication != null) {
			logger.info("Ingreso de usuario "+authentication.getName());
		}
		
		Authentication auth	= SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			logger.info("(Usando context) Hola usuario autenticado, tu usuario es: "+auth.getName());
		}

        SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "ROLE_");
        if(securityContext.isUserInRole("ADMIN")) {
            logger.info("(Usando securityContext) Hola usuario autenticado, tu usuario es: "+securityContext.getUserPrincipal().getName());
        }

        if(request.isUserInRole("ROLE_ADMIN")) {
            logger.info("(Usando request) Hola usuario autenticado, tu usuario es: "+request.getUserPrincipal().getName());
        }
		if (sesionWeb==null || sesionWeb.getUsuario() == null) {
			return "login";
		}
		List<String> listaDescripcionesCron = new ArrayList<>();
		listaDescripcionesCron.add("SFL FTP Pershing: "+descriptionCron(appSchedulingProperties.getCronFtpPershing()));
		listaDescripcionesCron.add("Generación Reportes Maestros: "+descriptionCron(appSchedulingProperties.getCronReportesMaestros()));
		listaDescripcionesCron.add("Validaciones Control Diario: "+descriptionCron(appSchedulingProperties.getCronControlDiario()));
		model.addAttribute("listaDescripcionesCron", listaDescripcionesCron);
		model.addAttribute(CAMPO_TITULO, "Inicio");
		model.addAttribute(CAMPO_SESION, sesionWeb);
		sesionWeb.getAppMenu().cambiaNavegacion("", false);
		return "home";
	}

	private String descriptionCron(String cronFormat) {
		String formatoFecha	= "HH:mm:ss (YYYY-MM-dd)";
		return calendarioHelper.convierteDateToStringWithFormat(Date.from(cronHelper.getNextExecution(cronFormat).toInstant()), formatoFecha)+" ["+cronHelper.humanDescriptionEs(cronFormat)+"]";
	}

	@GetMapping({"/help/ppt"})
	public ResponseEntity<Resource> descargaPptAyuda() throws QandeMmiiException {
		var filename	= appConfig.appConfigProperties.getPptHelp();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
				.body(archivosHelper.getFileAsResource(appConfig.appConfigProperties.getDownloadableFolder(), filename));
	}

}
