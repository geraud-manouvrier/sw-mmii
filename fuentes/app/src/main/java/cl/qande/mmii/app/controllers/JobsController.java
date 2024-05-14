package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.job.JobControlDiario;
import cl.qande.mmii.app.job.JobGetFromFtpPershing;
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
    private static final int DESFASE_DIAS = -1;
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String PRE_DET_ERROR = "Hubo un error al ejecutar el Job: ";
    private static final String MSG_OK    = "Job ejecutado correctamente";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private ReportesMaestrosService reportesMaestrosService;
    @Autowired
    private IProcesoSflDao procesoSflPershingDao;
    @Autowired
    private JobGetFromFtpPershing jobGetFromFtpPershing;
    @Autowired
    private JobControlDiario jobControlDiario;

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

}
