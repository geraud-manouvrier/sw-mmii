package cl.qande.mmii.app.controllers;

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
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/jobs")
public class JobsController {
    private static final String CAMPO_TITULO                = "titulo";
    private static final String CAMPO_STATUS                = "status";
    private static final String CAMPO_END_PROCESS_DATE      = "endProcessDate";
    private static final String CAMPO_START_PROCESS_DATE    = "startProcessDate";
    private static final String CAMPO_SESION                = "sesionWeb";

    private static final int DESFASE_DIAS           = -1;
    private static final int MAX_DESFASE_DIAS       = 7;
    private static final int MAX_DESFASE_DIAS_ADMIN = 1000;

    private static final String ERROR_RANGO_FECHAS  = "Error en el rango de fechas";
    private static final String TITULO_JOBS_MAIN    = "Ejecución Jobs";
    private static final String MSG_REPROCESO_OK    = "Re proceso correcto";
    private static final String PRE_DET_ERROR       = "Hubo un error al ejecutar el Job: ";
    private static final String MSG_OK              = "Job ejecutado correctamente";
    private static final String MSG_SIN_MAIL        = "(sin mail)";
    private static final String MSG_JOB_ERR         = "Error Job";
    private static final String MSG_APPEND_USER     = "]; usuario: [";

    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;
    private final ReportesMaestrosService reportesMaestrosService;
    private final IProcesoSflDao procesoSflPershingDao;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobControlDiario jobControlDiario;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;

    @Autowired
    public JobsController(SesionWeb sesionWeb, CalendarioHelper calendarioHelper, ReportesMaestrosService reportesMaestrosService, IProcesoSflDao procesoSflPershingDao, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp) {
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
        this.reportesMaestrosService = reportesMaestrosService;
        this.procesoSflPershingDao = procesoSflPershingDao;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"", "/"})
    public String inicioJobs(Model model) throws QandeMmiiException {

        var processDate		= calendarioHelper.defaultProcessDate();
        CustomLog.getInstance().info("Pasando por método /jobs: ["+sesionWeb.getUsuario()+"]");
        return inicioJobsConFecha(processDate, model);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/fecha/{processDate}"})
    public String inicioJobsConFecha(
            @PathVariable(value = "processDate", required = false) String processDate,
            Model model) throws QandeMmiiException {

        CustomLog.getInstance().info("Pasando por método /jobs/{processDate}: ["+processDate+"]");
        model.addAttribute(CAMPO_TITULO, TITULO_JOBS_MAIN);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute("processDate", processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.ADMIN_JOBS, false);
    }


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/fecha/{processDate}/reporte_maestros"})
    public String jobsReporteMaestros(
            @PathVariable(value = "processDate") String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            if (reportesMaestrosService.generaReportesMaestros(processDate)) {
                CustomLog.getInstance().info("Job Reportes Maestros Excel con fecha [" + processDate + "] finalizado OK");
                estadoPeticion.setEstadoOk("Job Reportes Maestros OK", "Jobs ejecutado correctamente.");
            } else {
                CustomLog.getInstance().error("Errores al generar Reportes Maestros Excel con fecha [" + processDate + "]");
                estadoPeticion.setEstadoError("Error Job Reportes Maestros", "No se pudo ejecutar el job.");
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job Reportes Maestros", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/fecha/{processDate}/control_diario_segmentado", "/fecha/{processDate}/control_diario_segmentado_sin_mail"})
    public String jobsControlDiarioSegmentado(
            @PathVariable(value = "processDate") String processDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var flagEnviarMail=true;
            if(request.getRequestURI().contains("control_diario_segmentado_sin_mail")) {
                CustomLog.getInstance().info("Job Control Diario Segmentado invocado sin envío de email");
                flagEnviarMail=false;
            }
            jobControlDiario.realizaControlDiarioSegmentado(processDate, sesionWeb.getUsuario(), flagEnviarMail);
            CustomLog.getInstance().info("Job Control Diario Segmentado con fecha [" + processDate + "] OK");
            estadoPeticion.setEstadoOk("Job Control Diario Segmentado OK", "Job ejecutado correctamente.");

        } catch (Exception e) {
            CustomLog.getInstance().error("Errores al realizar control diario con fecha ["+processDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Errores al realizar control diario con fecha ["+processDate+"]", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConFecha(processDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
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

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
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


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/reportes/proceso_ftp_pershing"})
    public String reporteFtpPershing(
            Model model) {

        return "redirect:/jobs/reportes/proceso_ftp_pershing/fecha_desde/"+calendarioHelper.defaultProcessDate()+"/fecha_hasta/"+calendarioHelper.defaultProcessDate();
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
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
            CustomLog.getInstance().error("Error al listar reporte FTP Pershing con rango fechas [" + startProcessDate + " - "+endProcessDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar reporte", "Se producjo un error al listar los registros");
            model.addAttribute("salidaReporte", null);
        }
        model.addAttribute(CAMPO_TITULO, "Reporte FTP Pershing");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_START_PROCESS_DATE, startProcessDate);
        model.addAttribute(CAMPO_END_PROCESS_DATE, endProcessDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.PERSHING_ETDO_FTP, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
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

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
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



    /****************************************************
     * Panel de admin jobs para usuarios
     ****************************************************/
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS_BY_USER))")
    @GetMapping({ "/jobs_por_usuario"})
    public String inicioJobsPorUsuario(Model model) throws QandeMmiiException {

        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        return inicioJobsPorUsuarioConRangoFechas(processDate, processDate, model);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS_BY_USER))")
    @GetMapping({"/jobs_por_usuario/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String inicioJobsPorUsuarioConRangoFechas(
            @PathVariable(value = CAMPO_START_PROCESS_DATE, required = true) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE, required = true) String endProcessDate,
            Model model) throws QandeMmiiException {

        model.addAttribute(CAMPO_TITULO, TITULO_JOBS_MAIN);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_START_PROCESS_DATE, startProcessDate);
        model.addAttribute(CAMPO_END_PROCESS_DATE, endProcessDate);
        model.addAttribute("maxDiasDesfase", getMaxDesfaseDias());
        return inicioJobsComun(false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS_BY_USER))")
    @GetMapping({"/jobs_por_usuario/process/reporte_maestros/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsReporteMaestrosPorUsuario(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        estadoPeticion.setEstadoOk(MSG_REPROCESO_OK, this.setJobMsg("Reportes Maestros", "OK", sesionWeb.getUsuario(), startProcessDate, endProcessDate));
        CustomLog.getInstance().info("Iniciando Job Reportes Maestros y Control diario con rango fecha [" + startProcessDate + " - "+endProcessDate + MSG_APPEND_USER + sesionWeb.getUsuario() + "]...");
        if (isValidDiffDiasProcessDate(startProcessDate, endProcessDate)) {

            if ( reportesMaestrosService.generaReportesMaestros(startProcessDate, endProcessDate) ) {
                sesionWeb.addNotification("Reportes Maestros re-procesados correctamente: ["+startProcessDate+" - "+endProcessDate+"]");
                return inicioJobsPorUsuarioConRangoFechas(startProcessDate, endProcessDate, model);
            } else {
                sesionWeb.addNotification("Reportes Maestros no pudieron ser re-procesados: ["+startProcessDate+" - "+endProcessDate+"]");
                estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en re-proceso Reportes Maestros");
            }
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
        } else {
            estadoPeticion.setEstadoError(ERROR_RANGO_FECHAS);
        }
        return inicioJobsPorUsuarioConRangoFechas(startProcessDate, endProcessDate, model);
    }





    /****************************************************
     * Funciones auxiliares
     ****************************************************/
    private String inicioJobsComun(boolean isAdmin) throws QandeMmiiException {
        var opcionMenu  = isAdmin ? Menu.ADMIN_JOBS : Menu.ADMIN_JOBS_BY_USER;
        return sesionWeb.getAppMenu().cambiaNavegacion(opcionMenu, false);
    }

    private String getProcessFromUrl(String url) {
        var ini         = url.indexOf("/fecha/")+7+8+1;  //Primer caracter luego del / terminando la fecha
        var finProcess  = url.indexOf("/", ini);
        if (finProcess>0) {
            return url.substring(ini, finProcess);
        }
        return url.substring(ini);
    }

    private int diferenciaDias(String startProcessDate, String endProcessDate) throws ParseException {
        Date startDate  = calendarioHelper.convierteFechaStrToDateWithFormat(startProcessDate, "yyyyMMdd");
        Date endDate    = calendarioHelper.convierteFechaStrToDateWithFormat(endProcessDate, "yyyyMMdd");
        return calendarioHelper.getDiasEntreFechas(startDate, endDate);
    }
    private boolean isValidDiffDiasProcessDate(String startProcessDate, String endProcessDate, int minDias, int maxDias) {
        try {
            var diffDias = diferenciaDias(startProcessDate, endProcessDate);
            sesionWeb.addNotification("Fecha proceso tiene "+diffDias+" días de diferencia (máx. "+maxDias+")");
            var salida = (diffDias >= minDias && diffDias <= maxDias);
            CustomLog.getInstance().info("Diferencia días de Process Date validado: ["+salida+"] - Diff: "+diffDias+" días.");
            return salida;
        } catch (ParseException e) {
            sesionWeb.addNotification("Error calculando diferencia de días entre Process Date: "+startProcessDate+" y "+endProcessDate);
            CustomLog.getInstance().error("Error calculando diferencia de días entre Process Date: "+startProcessDate+" y "+endProcessDate+": "+e.getMessage());
            return false;
        }
    }
    private boolean isValidDiffDiasProcessDate(String startProcessDate, String endProcessDate) {
        var maxDias = getMaxDesfaseDias()-1;
        if (! isValidDiffDiasStartProcessDate(startProcessDate)) {
            sesionWeb.addNotification("Start Process Date no válida: ["+startProcessDate+"]");
            return false;
        }
        if (! isValidDiffDiasEndProcessDate(endProcessDate)) {
            sesionWeb.addNotification("End Process Date no válida: ["+endProcessDate+"]");
            return false;
        }
        return isValidDiffDiasProcessDate(startProcessDate, endProcessDate, 0, maxDias);
    }
    private boolean isValidDiffDiasStartProcessDate(String startProcessDate) {
        var hoyProcessDate  = calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.hoyConDesfaseDias(0), CalendarioHelper.FORMATO_PROCESS_DATE);
        return isValidDiffDiasProcessDate(startProcessDate, hoyProcessDate, 1, getMaxDesfaseDias());
    }
    private boolean isValidDiffDiasEndProcessDate(String endProcessDate) {
        var hoyProcessDate  = calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.hoyConDesfaseDias(0), CalendarioHelper.FORMATO_PROCESS_DATE);
        return isValidDiffDiasProcessDate(hoyProcessDate, endProcessDate, -(getMaxDesfaseDias()-1), -1);
    }
    private int getMaxDesfaseDias() {
        if (sesionWeb.tieneRol("ROLE_ADMIN")) {
            return MAX_DESFASE_DIAS_ADMIN;
        }
        return MAX_DESFASE_DIAS;
    }

    private String setJobMsg(String jobName, String etdo, String user, String startProcessDate, String endProcessDate) {
        return "Job "+jobName+" "+etdo+" por usuario ["+user+"] fechas ["+startProcessDate+" - "+endProcessDate+"]"+etdo;
    }

}
