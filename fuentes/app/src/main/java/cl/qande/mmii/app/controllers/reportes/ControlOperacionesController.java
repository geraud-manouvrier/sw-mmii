package cl.qande.mmii.app.controllers.reportes;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
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

@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping("/reportes/controles")
public class ControlOperacionesController {
    private static final String TITULO_CTRL_DIARIO = "Control Diario";

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    public static final String CAMPO_ULTIMOS_ERRORES = "last_errors";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private ControlDiarioService controlDiarioService;
    @Autowired
    private CalendarioHelper calendarioHelper;

    @GetMapping({"/control_diario"})
    public String controlDiario(
            Model model) {

        return "redirect:/reportes/controles/control_diario/"+calendarioHelper.defaultProcessDate();
    }
    @GetMapping({"/control_diario/{processDate}"})
    public String controlDiarioPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            estadoPeticion.setEstadoOk("Resultado control OK", "Resultado del control listado correctamente");
            model.addAttribute(CAMPO_LISTA_REGISTROS, controlDiarioService.resultadoVigenteDelDia(processDate));
            model.addAttribute(CAMPO_ULTIMOS_ERRORES, controlDiarioService.lastErrors(10));
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al listar resultado control con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar resultado", "Se produjo un error al listar resultado del control");
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("processDate", processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CTRL_OPER_DIARIO, false);
    }
}
