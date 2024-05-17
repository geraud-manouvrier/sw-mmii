package cl.qande.mmii.app.controllers.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.pershing.dao.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
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

@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping("/reportes/sfl_pershing")
public class SflPershingController {
    private static final String TITULO_CTRL_DIARIO = "Contenido SFL";

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_PROCESS_DATE    = "processDate";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IStageAcctRegADao stageAcctRegADao;
    @Autowired
    private IStageAcctRegBDao stageAcctRegBDao;
    @Autowired
    private IStageAcctRegCDao stageAcctRegCDao;
    @Autowired
    private IStageAcctRegDDao stageAcctRegDDao;
    @Autowired
    private IStageAcctRegEDao stageAcctRegEDao;
    @Autowired
    private IStageAcctRegFDao stageAcctRegFDao;
    @Autowired
    private IStageAcctRegWDao stageAcctRegWDao;
    @Autowired
    private IStageGactRegADao stageGactRegADao;
    @Autowired
    private IStageGactRegBDao stageGactRegBDao;
    @Autowired
    private IStageGcusRegADao stageGcusRegADao;
    @Autowired
    private IStageGcusRegBDao stageGcusRegBDao;
    @Autowired
    private IStageGmonRegADao stageGmonRegADao;
    @Autowired
    private IStageGmonRegBDao stageGmonRegBDao;
    @Autowired
    private IStageIscaRegADao stageIscaRegADao;
    @Autowired
    private IStageIscaRegBDao stageIscaRegBDao;
    @Autowired
    private IStageIscaRegCDao stageIscaRegCDao;
    @Autowired
    private IStageIscaRegDDao stageIscaRegDDao;
    @Autowired
    private IStageIscaRegEDao stageIscaRegEDao;
    @Autowired
    private IStageIscaRegFDao stageIscaRegFDao;
    @Autowired
    private IStageIscaRegGDao stageIscaRegGDao;
    @Autowired
    private IStageIscaRegHDao stageIscaRegHDao;
    @Autowired
    private IStageIscaRegIDao stageIscaRegIDao;
    @Autowired
    private IStageIscaRegJDao stageIscaRegJDao;
    @Autowired
    private IStageIscaRegKDao stageIscaRegKDao;
    @Autowired
    private IStageIscaRegLDao stageIscaRegLDao;
    @Autowired
    private IStageIscaRegMDao stageIscaRegMDao;
    @Autowired
    private IStageIscaRegNDao stageIscaRegNDao;
    @Autowired
    private IStageIscaRegODao stageIscaRegODao;
    @Autowired
    private IStageIsrcRegADao stageIsrcRegADao;

    @GetMapping({"/{idSflLower}"})
    public String gcus(
            @PathVariable String idSflLower,
            Model model) {

        return "redirect:/reportes/sfl_pershing/"+idSflLower+"/"+calendarioHelper.defaultProcessDate();
    }
    @GetMapping({"/acct/{processDate}"})
    public String acctPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "ACCT";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageAcctRegADao.findByProcessDate(processDate));
            model.addAttribute("listaRegB", stageAcctRegBDao.findByProcessDate(processDate));
            model.addAttribute("listaRegC", stageAcctRegCDao.findByProcessDate(processDate));
            model.addAttribute("listaRegD", stageAcctRegDDao.findByProcessDate(processDate));
            model.addAttribute("listaRegE", stageAcctRegEDao.findByProcessDate(processDate));
            model.addAttribute("listaRegF", stageAcctRegFDao.findByProcessDate(processDate));
            model.addAttribute("listaRegW", stageAcctRegWDao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ACCT, false);
    }
    @GetMapping({"/gact/{processDate}"})
    public String gactPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "GACT";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageGactRegADao.findByProcessDate(processDate));
            model.addAttribute("listaRegB", stageGactRegBDao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GACT, false);
    }
    @GetMapping({"/gcus/{processDate}"})
    public String gcusPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "GCUS";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageGcusRegADao.findByProcessDate(processDate));
            model.addAttribute("listaRegB", stageGcusRegBDao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GCUS, false);
    }
    @GetMapping({"/gmon/{processDate}"})
    public String gmonPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "GMON";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageGmonRegADao.findByProcessDate(processDate));
            model.addAttribute("listaRegB", stageGmonRegBDao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GMON, false);
    }
    @GetMapping({"/isca/{processDate}"})
    public String iscaPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "ISCA";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageIscaRegADao.findByProcessDate(processDate));
            model.addAttribute("listaRegB", stageIscaRegBDao.findByProcessDate(processDate));
            model.addAttribute("listaRegC", stageIscaRegCDao.findByProcessDate(processDate));
            model.addAttribute("listaRegD", stageIscaRegDDao.findByProcessDate(processDate));
            model.addAttribute("listaRegE", stageIscaRegEDao.findByProcessDate(processDate));
            model.addAttribute("listaRegF", stageIscaRegFDao.findByProcessDate(processDate));
            model.addAttribute("listaRegG", stageIscaRegGDao.findByProcessDate(processDate));
            model.addAttribute("listaRegH", stageIscaRegHDao.findByProcessDate(processDate));
            model.addAttribute("listaRegI", stageIscaRegIDao.findByProcessDate(processDate));
            model.addAttribute("listaRegJ", stageIscaRegJDao.findByProcessDate(processDate));
            model.addAttribute("listaRegK", stageIscaRegKDao.findByProcessDate(processDate));
            model.addAttribute("listaRegL", stageIscaRegLDao.findByProcessDate(processDate));
            model.addAttribute("listaRegM", stageIscaRegMDao.findByProcessDate(processDate));
            model.addAttribute("listaRegN", stageIscaRegNDao.findByProcessDate(processDate));
            model.addAttribute("listaRegO", stageIscaRegODao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ISCA, false);
    }
    @GetMapping({"/isrc/{processDate}"})
    public String isrcPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var idSfl = "ISRC";
        var estadoPeticion   = new EstadoPeticion();
        try {
            model.addAttribute("listaRegA", stageIsrcRegADao.findByProcessDate(processDate));
            estadoPeticion.setEstadoOk("Datos SFL OK", "Datos SFL listado correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ISRC, false);
    }
}
