package cl.qande.mmii.app.controllers.reportes;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.pershing.dao.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes/sfl_pershing")
public class SflPershingController {
    private static final String TITULO_CTRL_DIARIO = "Contenido SFL";

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_PROCESS_DATE    = "processDate";
    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;
    private final IStageAcctRegADao stageAcctRegADao;
    private final IStageAcctRegBDao stageAcctRegBDao;
    private final IStageAcctRegCDao stageAcctRegCDao;
    private final IStageAcctRegDDao stageAcctRegDDao;
    private final IStageAcctRegEDao stageAcctRegEDao;
    private final IStageAcctRegFDao stageAcctRegFDao;
    private final IStageAcctRegWDao stageAcctRegWDao;
    private final IStageGactRegADao stageGactRegADao;
    private final IStageGactRegBDao stageGactRegBDao;
    private final IStageGcusRegADao stageGcusRegADao;
    private final IStageGcusRegBDao stageGcusRegBDao;
    private final IStageGmonRegADao stageGmonRegADao;
    private final IStageGmonRegBDao stageGmonRegBDao;
    private final IStageIscaRegADao stageIscaRegADao;
    private final IStageIscaRegBDao stageIscaRegBDao;
    private final IStageIscaRegCDao stageIscaRegCDao;
    private final IStageIscaRegDDao stageIscaRegDDao;
    private final IStageIscaRegEDao stageIscaRegEDao;
    private final IStageIscaRegFDao stageIscaRegFDao;
    private final IStageIscaRegGDao stageIscaRegGDao;
    private final IStageIscaRegHDao stageIscaRegHDao;
    private final IStageIscaRegIDao stageIscaRegIDao;
    private final IStageIscaRegJDao stageIscaRegJDao;
    private final IStageIscaRegKDao stageIscaRegKDao;
    private final IStageIscaRegLDao stageIscaRegLDao;
    private final IStageIscaRegMDao stageIscaRegMDao;
    private final IStageIscaRegNDao stageIscaRegNDao;
    private final IStageIscaRegODao stageIscaRegODao;
    private final IStageIsrcRegADao stageIsrcRegADao;

    public SflPershingController(SesionWeb sesionWeb, CalendarioHelper calendarioHelper, IStageAcctRegADao stageAcctRegADao, IStageAcctRegBDao stageAcctRegBDao, IStageAcctRegCDao stageAcctRegCDao, IStageAcctRegDDao stageAcctRegDDao, IStageAcctRegEDao stageAcctRegEDao, IStageAcctRegFDao stageAcctRegFDao, IStageAcctRegWDao stageAcctRegWDao, IStageGactRegADao stageGactRegADao, IStageGactRegBDao stageGactRegBDao, IStageGcusRegADao stageGcusRegADao, IStageGcusRegBDao stageGcusRegBDao, IStageGmonRegADao stageGmonRegADao, IStageGmonRegBDao stageGmonRegBDao, IStageIscaRegADao stageIscaRegADao, IStageIscaRegBDao stageIscaRegBDao, IStageIscaRegCDao stageIscaRegCDao, IStageIscaRegDDao stageIscaRegDDao, IStageIscaRegEDao stageIscaRegEDao, IStageIscaRegFDao stageIscaRegFDao, IStageIscaRegGDao stageIscaRegGDao, IStageIscaRegHDao stageIscaRegHDao, IStageIscaRegIDao stageIscaRegIDao, IStageIscaRegJDao stageIscaRegJDao, IStageIscaRegKDao stageIscaRegKDao, IStageIscaRegLDao stageIscaRegLDao, IStageIscaRegMDao stageIscaRegMDao, IStageIscaRegNDao stageIscaRegNDao, IStageIscaRegODao stageIscaRegODao, IStageIsrcRegADao stageIsrcRegADao) {
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
        this.stageAcctRegADao = stageAcctRegADao;
        this.stageAcctRegBDao = stageAcctRegBDao;
        this.stageAcctRegCDao = stageAcctRegCDao;
        this.stageAcctRegDDao = stageAcctRegDDao;
        this.stageAcctRegEDao = stageAcctRegEDao;
        this.stageAcctRegFDao = stageAcctRegFDao;
        this.stageAcctRegWDao = stageAcctRegWDao;
        this.stageGactRegADao = stageGactRegADao;
        this.stageGactRegBDao = stageGactRegBDao;
        this.stageGcusRegADao = stageGcusRegADao;
        this.stageGcusRegBDao = stageGcusRegBDao;
        this.stageGmonRegADao = stageGmonRegADao;
        this.stageGmonRegBDao = stageGmonRegBDao;
        this.stageIscaRegADao = stageIscaRegADao;
        this.stageIscaRegBDao = stageIscaRegBDao;
        this.stageIscaRegCDao = stageIscaRegCDao;
        this.stageIscaRegDDao = stageIscaRegDDao;
        this.stageIscaRegEDao = stageIscaRegEDao;
        this.stageIscaRegFDao = stageIscaRegFDao;
        this.stageIscaRegGDao = stageIscaRegGDao;
        this.stageIscaRegHDao = stageIscaRegHDao;
        this.stageIscaRegIDao = stageIscaRegIDao;
        this.stageIscaRegJDao = stageIscaRegJDao;
        this.stageIscaRegKDao = stageIscaRegKDao;
        this.stageIscaRegLDao = stageIscaRegLDao;
        this.stageIscaRegMDao = stageIscaRegMDao;
        this.stageIscaRegNDao = stageIscaRegNDao;
        this.stageIscaRegODao = stageIscaRegODao;
        this.stageIsrcRegADao = stageIsrcRegADao;
    }

    @GetMapping({"/{idSflLower}"})
    public String sflIndex(
            @PathVariable String idSflLower,
            Model model) {

        return "redirect:/reportes/sfl_pershing/"+idSflLower+"/"+calendarioHelper.defaultProcessDate();
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_ACCT))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ACCT, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_GACT))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GACT, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_GCUS))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GCUS, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_GMON))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_GMON, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_ISCA))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ISCA, false);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).CONT_SFL_ISRC))")
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
            CustomLog.getInstance().error("Error al listar contenido SFL con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar contenido SFL", "Se produjo un error al listar contenido SFL");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO+" ["+idSfl+"]");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CONT_SFL_ISRC, false);
    }
}
