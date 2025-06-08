package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.job.*;
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
    private static final String PRE_DET_ERROR       = "Hubo un error al ejecutar el Job: ";
    private static final String MSG_OK              = "Job ejecutado correctamente";
    private static final String MSG_SIN_MAIL        = "(sin mail)";
    private static final String MSG_JOB_ERR         = "Error Job";
    private static final String MSG_APPEND_USER     = "]; usuario: [";
    private static final String MSG_APPEND_ERROR_CTRL_DIARIO = "Errores al realizar control diario con fecha [";

    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;
    private final ReportesMaestrosService reportesMaestrosService;
    private final IProcesoSflDao procesoSflPershingDao;
    private final JobGetFromFtpPershing jobGetFromFtpPershing;
    private final JobControlDiario jobControlDiario;
    private final JobCuentasNoMapeadas jobCuentasNoMapeadas;
    private final JobParametrosFromSuracorp jobParametrosFromSuracorp;
    private final JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario;
    private final JobRepInvControl jobRepInvControl;

    @Autowired
    public JobsController(SesionWeb sesionWeb, CalendarioHelper calendarioHelper, ReportesMaestrosService reportesMaestrosService, IProcesoSflDao procesoSflPershingDao, JobGetFromFtpPershing jobGetFromFtpPershing, JobControlDiario jobControlDiario, JobCuentasNoMapeadas jobCuentasNoMapeadas, JobParametrosFromSuracorp jobParametrosFromSuracorp, JobRepInvPrecalculoDiario jobRepInvPrecalculoDiario, JobRepInvControl jobRepInvControl) {
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
        this.reportesMaestrosService = reportesMaestrosService;
        this.procesoSflPershingDao = procesoSflPershingDao;
        this.jobGetFromFtpPershing = jobGetFromFtpPershing;
        this.jobControlDiario = jobControlDiario;
        this.jobCuentasNoMapeadas = jobCuentasNoMapeadas;
        this.jobParametrosFromSuracorp = jobParametrosFromSuracorp;
        this.jobRepInvPrecalculoDiario = jobRepInvPrecalculoDiario;
        this.jobRepInvControl = jobRepInvControl;
    }

    /****************************************************
     * Raiz endpoint panel admin jobs
     ****************************************************/
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"", "/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String inicioJobsConRangoFechas(
            @PathVariable(value = CAMPO_START_PROCESS_DATE, required = false) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE, required = false) String endProcessDate,
            Model model) throws QandeMmiiException {
        if (startProcessDate == null || startProcessDate.isEmpty() || endProcessDate == null || endProcessDate.isEmpty() ) {
            startProcessDate	= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
            endProcessDate      = startProcessDate;
        }
        return inicioJobsConRangoFechasHandler(startProcessDate, endProcessDate, model, true);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS_BY_USER))")
    @GetMapping({"/jobs_por_usuario",
            "/jobs_por_usuario/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String inicioJobsPorUsuarioConRangoFechas(
            @PathVariable(value = CAMPO_START_PROCESS_DATE, required = false) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE, required = false) String endProcessDate,
            Model model) throws QandeMmiiException {
        if (startProcessDate == null || startProcessDate.isEmpty() || endProcessDate == null || endProcessDate.isEmpty() ) {
            startProcessDate	= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
            endProcessDate      = startProcessDate;
        }
        return inicioJobsConRangoFechasHandler(startProcessDate, endProcessDate, model, false);
    }

    /****************************************************
     * Panel admin jobs
     ****************************************************/


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/process/control_diario/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/control_diario_sin_mail/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsControlDiario(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            var flagEnviarMail=true;
            if(request.getRequestURI().contains("control_diario_sin_mail")) {
                CustomLog.getInstance().info("Job Control Diario invocado sin envío de email");
                flagEnviarMail=false;
            }
            jobControlDiario.realizaControlDiario(startProcessDate, endProcessDate, sesionWeb.getUsuario(), flagEnviarMail);
            CustomLog.getInstance().info("Job Control Diario con fecha [" + startProcessDate+" -"+endProcessDate + "] OK");
            estadoPeticion.setEstadoOk("Job Control Diario OK", MSG_OK);

        } catch (Exception e) {
            CustomLog.getInstance().error(MSG_APPEND_ERROR_CTRL_DIARIO +startProcessDate+" -"+endProcessDate+"]: "+e.getMessage());
            estadoPeticion.setEstadoError(MSG_APPEND_ERROR_CTRL_DIARIO +startProcessDate+" -"+endProcessDate+"]", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConRangoFechas(startProcessDate, endProcessDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/process/ftp_pershing_con_descarga/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/ftp_pershing_sin_descarga/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsFtpPershingConDescarga(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        var flagUseDownloadedFiles=false;
        if(request.getRequestURI().contains("ftp_pershing_sin_descarga")) {
            flagUseDownloadedFiles=true;
        }
        try {
            var listaProcessDate = calendarioHelper.processDateRangeToList(startProcessDate, endProcessDate);
            for (var processDate : listaProcessDate) {
                if (jobGetFromFtpPershing.processByProcessDate(processDate, flagUseDownloadedFiles)) {
                    estadoPeticion.setEstadoOk(MSG_OK, "Job FTP Pershing (use downloaded: "+flagUseDownloadedFiles+") OK");
                } else {
                    estadoPeticion.setEstadoError("Error Job FTP Pershing (use downloaded: "+flagUseDownloadedFiles+")", PRE_DET_ERROR+" Ver log");
                }
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job FTP Pershing (con descarga)", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConRangoFechas(startProcessDate, endProcessDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({
            "/process/cuenta_no_mapeadas/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsCuentasNoMapeadas(
            @PathVariable String startProcessDate,
            @PathVariable String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var estadoPeticion  = new EstadoPeticion();
        try {
            var listaProcessDate = calendarioHelper.processDateRangeToList(startProcessDate, endProcessDate);
            for (var processDate : listaProcessDate) {
                jobCuentasNoMapeadas.ejecutaJob(processDate, sesionWeb.getUsuario(), true);
            }
            estadoPeticion.setEstadoOk(MSG_OK, "Job Cuentas No mapeadas OK");
        } catch (Exception e) {
            estadoPeticion.setEstadoError("Error Job Cuentas No Mapeadas", PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConRangoFechas(startProcessDate, endProcessDate, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({
            "/process/parametros_suracorp/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/parametros_suracorp_sin_mail/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsParametrosSuracorp(
            @PathVariable String startProcessDate,
            @PathVariable String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {
        var processName     = getMethodFromUrl(request.getRequestURI());
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
        return inicioJobsConRangoFechas(startProcessDate, endProcessDate, model);
    }


    /*************************************************************************************
     * Nueva forma de paneles y manejo de URLs (pendiente centralizar el getmapping)
     *************************************************************************************/

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/process/reporte_maestros/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_materializa/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_cuentas/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_cuentas_materializa/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_movimientos/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_movimientos_materializa/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_saldos/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_saldos_materializa/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_relacionados/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/reporte_maestros_relacionados/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"
    })
    public String jobsReporteMaestros(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {

        var materializaData         = request.getRequestURI().contains("_materializa");
        var generaTodos             = request.getRequestURI().contains("reporte_maestros/") || request.getRequestURI().contains("reporte_maestros_materializa/");
        var generarClientes         = request.getRequestURI().contains("reporte_maestros_cuentas") || generaTodos;
        var generarMovimientos      = request.getRequestURI().contains("reporte_maestros_movimientos") || generaTodos;
        var generarSaldos           = request.getRequestURI().contains("reporte_maestros_saldos") || generaTodos;
        var generarRelacionados     = request.getRequestURI().contains("reporte_maestros_relacionados") || generaTodos;

        var borraArchivosExistentes = request.getRequestURI().contains("reporte_maestros_cuentas") ||
                                        request.getRequestURI().contains("reporte_maestros_movimientos") ||
                                        request.getRequestURI().contains("reporte_maestros_saldos") ||
                                        request.getRequestURI().contains("reporte_maestros_relacionados");

        return jobMaestrosHandler(startProcessDate, endProcessDate, materializaData, generarClientes, generarMovimientos, generarSaldos, generarRelacionados, borraArchivosExistentes, false, model, true);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS_BY_USER))")
    @GetMapping({"/jobs_por_usuario/process/reporte_maestros/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
    public String jobsReporteMaestrosPorUsuario(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model) throws QandeMmiiException {
        var materializaData = true;
        var generarClientes     = true;
        var generarMovimientos  = true;
        var generarSaldos       = true;
        var generarRelacionados       = true;
        var borraArchivosExistentes = true;

        return jobMaestrosHandler(startProcessDate, endProcessDate, materializaData, generarClientes, generarMovimientos, generarSaldos, generarRelacionados, borraArchivosExistentes, true, model, false);
    }

    private String jobMaestrosHandler(
            String startProcessDate, String endProcessDate,
            boolean materializaData, boolean generarClientes, boolean generarMovimientos, boolean generarSaldos, boolean generarRelacionados, boolean borraArchivosExistentes,
            boolean mailControlDiario,
            Model model, boolean isAdmin) throws QandeMmiiException {
        var estadoPeticion          = new EstadoPeticion();
        try {
            CustomLog.getInstance().info("Iniciando Job Reportes Maestros y Control diario con rango fecha [" + startProcessDate + " - "+endProcessDate + MSG_APPEND_USER + sesionWeb.getUsuario() + "]...");
            if (isValidDiffDiasProcessDate(startProcessDate, endProcessDate)) {
                if ( reportesMaestrosService.generaReportesMaestros(startProcessDate, endProcessDate, materializaData, generarClientes, generarMovimientos, generarSaldos, generarRelacionados, borraArchivosExistentes) ) {
                    sesionWeb.addNotification("Reportes Maestros re-procesados correctamente: ["+startProcessDate+" - "+endProcessDate+"]");
                    if (jobControlDiario.realizaControlDiario(startProcessDate, endProcessDate, sesionWeb.getUsuario(), mailControlDiario)) {
                        sesionWeb.addNotification("Control diario finalizado correctamente: ["+startProcessDate+" - "+endProcessDate+"]");
                        if (jobRepInvPrecalculoDiario.ejecutaJob(startProcessDate)) {
                            sesionWeb.addNotification("Pre cálculo retornos finalizado correctamente: ["+startProcessDate+" en adelante]");
                            estadoPeticion.setEstadoOk(MSG_OK, this.setJobMsg("Reportes Maestros", "OK", sesionWeb.getUsuario(), startProcessDate, endProcessDate));
                        } else {
                            sesionWeb.addNotification("Pre cálculo retornos finalizado correctamente: ["+startProcessDate+" en adelante]");
                            estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en Reportes Maestros al ejecutar Pre cálculo retornos");
                        }
                    } else {
                        estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en Reportes Maestros al ejecutar control diario");
                        sesionWeb.addNotification("Control diario finalizado con errores: ["+startProcessDate+" - "+endProcessDate+"]");
                    }
                } else {
                    sesionWeb.addNotification("Reportes Maestros no pudieron ser re-procesados: ["+startProcessDate+" - "+endProcessDate+"]");
                    estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en re-proceso Reportes Maestros");
                }
            } else {
                estadoPeticion.setEstadoError(ERROR_RANGO_FECHAS);
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError(MSG_JOB_ERR, PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConRangoFechasHandler(startProcessDate, endProcessDate, model, isAdmin);
    }


    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/process/pre_calculo_rentabilidad_sin_control/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}",
            "/process/pre_calculo_rentabilidad_con_control/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"
    })
    public String jobsRepInv(
            @PathVariable(value = CAMPO_START_PROCESS_DATE) String startProcessDate,
            @PathVariable(value = CAMPO_END_PROCESS_DATE) String endProcessDate,
            Model model,
            HttpServletRequest request) throws QandeMmiiException {

        var ejecutaControl      = request.getRequestURI().contains("pre_calculo_rentabilidad_con_control");
        return jobRepInvHandler(startProcessDate, endProcessDate, ejecutaControl, model, true);
    }

    private String jobRepInvHandler(
            String startProcessDate, String endProcessDate,
            boolean ejecutarControl,
            Model model, boolean isAdmin) throws QandeMmiiException {
        var estadoPeticion          = new EstadoPeticion();
        try {
            CustomLog.getInstance().info("Iniciando Job Pre cálculo retornos con fecha [" + startProcessDate + " - "+ MSG_APPEND_USER + sesionWeb.getUsuario() + "]...");
            if (isValidDiffDiasProcessDate(startProcessDate, endProcessDate)) {
                if (jobRepInvPrecalculoDiario.ejecutaJob(startProcessDate)) {
                    sesionWeb.addNotification("Pre cálculo retornos finalizado correctamente: ["+startProcessDate+" en adelante]");
                    if (ejecutarControl) {
                        if (jobRepInvControl.ejecutaJob(startProcessDate, endProcessDate, sesionWeb)) {
                            sesionWeb.addNotification("Controles retornos finalizados correctamente: ["+startProcessDate+" - "+endProcessDate+"]");
                            estadoPeticion.setEstadoOk(MSG_OK, this.setJobMsg("Pre Cálculo Retornos", "OK", sesionWeb.getUsuario(), startProcessDate, endProcessDate));
                        } else {
                            sesionWeb.addNotification("Controles retornos finalizado con errores: ["+startProcessDate+" - "+endProcessDate+"]");
                            estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en Controles al ejecutar Pre cálculo retornos");
                        }
                    } else {
                        sesionWeb.addNotification("Controles retornos omitidos");
                        estadoPeticion.setEstadoOk(MSG_OK, this.setJobMsg("Pre Cálculo Retornos", "OK", sesionWeb.getUsuario(), startProcessDate, endProcessDate));
                    }
                } else {
                    sesionWeb.addNotification("Pre cálculo retornos finalizado correctamente: ["+startProcessDate+" en adelante]");
                    estadoPeticion.setEstadoError(MSG_JOB_ERR, "Error en al ejecutar Pre cálculo retornos");
                }
            } else {
                estadoPeticion.setEstadoError(ERROR_RANGO_FECHAS);
            }
        } catch (Exception e) {
            estadoPeticion.setEstadoError(MSG_JOB_ERR, PRE_DET_ERROR +e.getMessage());
        }
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return inicioJobsConRangoFechasHandler(startProcessDate, endProcessDate, model, isAdmin);
    }



    /****************************************************
     * Panel de Estado procesos FTP Custodios
     ****************************************************/

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/proceso_ftp_pershing"})
    public String reporteFtpPershing(
            Model model) throws QandeMmiiException {
        return reporteFtpPershingPorFecha(calendarioHelper.defaultProcessDate(), calendarioHelper.defaultProcessDate(), model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).ADMIN_JOBS))")
    @GetMapping({"/proceso_ftp_pershing/startProcessDate/{startProcessDate}/endProcessDate/{endProcessDate}"})
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



    /****************************************************
     * Funciones auxiliares
     ****************************************************/


    private String inicioJobsConRangoFechasHandler(
            String startProcessDate, String endProcessDate,
            Model model, boolean isAdmin) throws QandeMmiiException {
        model.addAttribute(CAMPO_TITULO, TITULO_JOBS_MAIN);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_START_PROCESS_DATE, startProcessDate);
        model.addAttribute(CAMPO_END_PROCESS_DATE, endProcessDate);
        model.addAttribute("maxDiasDesfase", getMaxDesfaseDias());
        var opcionMenu  = isAdmin ? Menu.ADMIN_JOBS : Menu.ADMIN_JOBS_BY_USER;
        return sesionWeb.getAppMenu().cambiaNavegacion(opcionMenu, false);
    }

    private String getMethodFromUrl(String requestUri) {
        return requestUri.substring(requestUri.indexOf("/process/")+9, requestUri.indexOf("/", requestUri.indexOf("/process/")+9));
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
