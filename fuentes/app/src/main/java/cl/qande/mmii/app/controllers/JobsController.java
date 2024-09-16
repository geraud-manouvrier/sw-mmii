package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.job.JobControlDiario;
import cl.qande.mmii.app.job.JobCuentasNoMapeadas;
import cl.qande.mmii.app.job.JobGetFromFtpPershing;
import cl.qande.mmii.app.job.JobParametrosFromSuracorp;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.pershing.dao.IProcesoSflDao;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ReportesMaestrosService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/jobs")
public class JobsController {
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String PRE_DET_ERROR = "Hubo un error al ejecutar el Job: ";
    private static final String MSG_OK    = "Job ejecutado correctamente";
    private static final String MSG_SIN_MAIL = "(sin mail)";

    private final SesionWeb sesionWeb;
    private final AppConfig appConfig;
    private final CalendarioHelper calendarioHelper;
    private final ReportesMaestrosService reportesMaestrosService;
    private final IProcesoSflDao procesoSflPershingDao;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobControlDiario jobControlDiario;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;

    @Autowired
    public JobsController(SesionWeb sesionWeb, AppConfig appConfig, CalendarioHelper calendarioHelper, ReportesMaestrosService reportesMaestrosService, IProcesoSflDao procesoSflPershingDao, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp) {
        this.sesionWeb = sesionWeb;
        this.appConfig = appConfig;
        this.calendarioHelper = calendarioHelper;
        this.reportesMaestrosService = reportesMaestrosService;
        this.procesoSflPershingDao = procesoSflPershingDao;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"", "/"})
    public String inicioJobs(Model model) throws QandeMmiiException {

        var processDate		= calendarioHelper.defaultProcessDate();
        appConfig.customLog.info("Pasando por método /jobs: ["+sesionWeb.getUsuario()+"]");
        return inicioJobsConFecha(processDate, model);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/fecha/{processDate}"})
    public String inicioJobsConFecha(
            @PathVariable(value = "processDate", required = false) String processDate,
            Model model) throws QandeMmiiException {

        appConfig.customLog.info("Pasando por método /jobs/{processDate}: ["+processDate+"]");
        model.addAttribute(CAMPO_TITULO, "Ejecución Jobs");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute("processDate", processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.ADMIN_JOBS, false);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/fecha/{processDate}/reporte_maestros"})
    public String jobsReporteMaestros(
            @PathVariable(value = "processDate") String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            if (reportesMaestrosService.generaReportesMaestros(processDate)) {
                appConfig.customLog.info("Job Reportes Maestros Excel con fecha [" + processDate + "] finalizado OK");
                estadoPeticion.setEstadoOk("Job Reportes Maestros OK", "Jobs ejecutado correctamente.");
            } else {
                appConfig.customLog.error("Errores al generar Reportes Maestros Excel con fecha [" + processDate + "]");
                estadoPeticion.setEstadoError("Error Job Reportes Maestros", "No se pudo ejecutar el job.");
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job Reportes Maestros", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/fecha/{processDate}/control_diario_segmentado", "/fecha/{processDate}/control_diario_segmentado_sin_mail"})
    public String jobsControlDiarioSegmentado(
            @PathVariable(value = "processDate") String processDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var flagEnviarMail=true;
            if(request.getRequestURI().contains("control_diario_segmentado_sin_mail")) {
                appConfig.customLog.info("Job Control Diario Segmentado invocado sin envío de email");
                flagEnviarMail=false;
            }
            jobControlDiario.realizaControlDiarioSegmentado(processDate, sesionWeb.getUsuario(), flagEnviarMail);
            appConfig.customLog.info("Job Control Diario Segmentado con fecha [" + processDate + "] OK");
            estadoPeticion.setEstadoOk("Job Control Diario Segmentado OK", "Job ejecutado correctamente.");

        } catch (Exception e) {
            appConfig.customLog.error("Errores al realizar control diario con fecha ["+processDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Errores al realizar control diario con fecha ["+processDate+"]", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/fecha/{processDate}/ftp_pershing_con_descarga"})
    public String jobsFtpPershingConDescarga(
            @PathVariable(value = "processDate") String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            if (jobGetFromFtpPershing.processByProcessDate(processDate, false)) {
                estadoPeticion.setEstadoOk(MSG_OK, "Job FTP Pershing (con descarga) OK");
            } else {
                estadoPeticion.setEstadoError("Error Job FTP Pershing (con descarga)", PRE_DET_ERROR+" Ver log");
            }

        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job FTP Pershing (con descarga)", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/fecha/{processDate}/ftp_pershing_sin_descarga"})
    public String jobsFtpPershingSinDescarga(
            @PathVariable(value = "processDate") String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            jobGetFromFtpPershing.processByProcessDate(processDate, true);
            estadoPeticion.setEstadoOk(MSG_OK, "Job FTP Pershing (sin descarga) OK");
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job FTP Pershing (sin descarga)", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/reportes/proceso_ftp_pershing"})
    public String reporteFtpPershing(
            Model model) {

        return "redirect:/jobs/reportes/proceso_ftp_pershing/fecha_desde/"+calendarioHelper.defaultProcessDate()+"/fecha_hasta/"+calendarioHelper.defaultProcessDate();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/reportes/proceso_ftp_pershing/fecha_desde/{startProcessDate}/fecha_hasta/{endProcessDate}"})
    public String reporteFtpPershingPorFecha(
            @PathVariable String startProcessDate,
            @PathVariable String endProcessDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var salidaReporte   = procesoSflPershingDao.findByProcessDateBetween(startProcessDate, endProcessDate);
            estadoPeticion.setEstadoOk("Reporte FTP OK", "Listado de estados generado correctamente");
            model.addAttribute("salidaReporte", salidaReporte);
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar reporte FTP Pershing con rango fechas [" + startProcessDate + " - "+endProcessDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar reporte", "Se producjo un error al listar los registros");
            model.addAttribute("salidaReporte", null);
        }
        model.addAttribute(CAMPO_TITULO, "Reporte FTP Pershing");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("startProcessDate", startProcessDate);
        model.addAttribute("endProcessDate", endProcessDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.PERSHING_ETDO_FTP, false);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({
            "/fecha/{processDate}/cuenta_no_mapeadas"})
    public String jobsCuentasNoMapeadas(
            @PathVariable(value = "processDate") String processDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion  = new EstadoPeticion();
        try {
            jobCuentasNoMapeadas.ejecutaJob(processDate, sesionWeb.getUsuario(), true);
            estadoPeticion.setEstadoOk(MSG_OK, "Job Cuentas No mapeadas OK");
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job Cuentas No Mapeadas", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({
            "/fecha/{processDate}/parametros_suracorp",
            "/fecha/{processDate}/parametros_suracorp_sin_mail"})
    public String jobsParametrosSuracorp(
            @PathVariable(value = "processDate") String processDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var processName     = getProcessFromUrl(request.getRequestURI());
        var flagEnviarMail  = ! processName.contains("sin_mail");
        var estadoPeticion  = new EstadoPeticion();
        try {
            var resultadoJob    = jobParametrosFromSuracorp.ejecutaJob(sesionWeb.getUsuario(), flagEnviarMail);
            if (resultadoJob) {
                estadoPeticion.setEstadoOk(MSG_OK, "Job Parámetros "+(flagEnviarMail ? "" : MSG_SIN_MAIL)+" OK");
            } else {
                estadoPeticion.setEstadoError("Error Job Parámetros "+(flagEnviarMail ? "" : MSG_SIN_MAIL), "Ver log");
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job Parámetros "+(flagEnviarMail ? "" : MSG_SIN_MAIL), PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    private String getProcessFromUrl(String url) {
        var ini         = url.indexOf("/fecha/")+7+8+1;  //Primer caracter luego del / terminando la fecha
        var finProcess  = url.indexOf("/", ini);
        if (finProcess>0) {
            return url.substring(ini, finProcess);
        }
        return url.substring(ini);



    }

}
