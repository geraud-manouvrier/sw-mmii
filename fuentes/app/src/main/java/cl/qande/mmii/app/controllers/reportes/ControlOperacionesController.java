package cl.qande.mmii.app.controllers.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.sura.dao.IClienteDao;
import cl.qande.mmii.app.models.db.sura.dao.IContratoDao;
import cl.qande.mmii.app.models.db.sura.dao.ICuentaDao;
import cl.qande.mmii.app.models.db.sura.dao.IPerfilCuentaDao;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ControlDiarioService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes/controles")
public class ControlOperacionesController {
    private static final int DESFASE_DIAS = -1;
    private static final String TITULO_CTRL_DIARIO = "Control Diario";

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ControlDiarioService controlDiarioService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IContratoDao contratoDao;
    @Autowired
    private ICuentaDao cuentaDao;
    @Autowired
    private IPerfilCuentaDao perfilCuentaDao;

    @GetMapping({"/control_diario"})
    public String controlDiario(
            Model model) {

        return "redirect:/reportes/controles/control_diario/"+defaultProcessDate();
    }
    @GetMapping({"/control_diario/{processDate}"})
    public String controlDiarioPorFecha(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        try {
            estadoPeticion.setEstadoOk("Resultado control OK", "Resultado del control listado correctamente");
            model.addAttribute(CAMPO_LISTA_REGISTROS, controlDiarioService.resultadoVigenteDelDia(processDate));
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar resultado control con fecha [" + processDate + "]: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar resultado", "Se produjo un error al listar resultado del control");
            model.addAttribute(CAMPO_LISTA_REGISTROS, null);
        }
        model.addAttribute(CAMPO_TITULO, TITULO_CTRL_DIARIO);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute("processDate", processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.CTRL_OPER_DIARIO, false);
    }

    @GetMapping({"/datos_enrolamiento"})
    public String datosEnrolamiento(
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        model.addAttribute(CAMPO_TITULO, "Datos Enrolamiento");
        try {
            var listaClientes   = clienteDao.findAll();
            var listaContratos  = contratoDao.findAll();
            var listaCuentas    = cuentaDao.findAll();
            var listaPerfiles   = perfilCuentaDao.findAll();
            model.addAttribute("listaClientes", listaClientes);
            model.addAttribute("listaContratos", listaContratos);
            model.addAttribute("listaCuentas", listaCuentas);
            model.addAttribute("listaPerfiles", listaPerfiles);
            estadoPeticion.setEstadoOk("Listado de datos OK", "Registros listados enrolamiento correctamente");
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar registros enrolamiento: "+e.getMessage());
            estadoPeticion.setEstadoError("Error al listar resultado", "Error al listar registros enrolamiento");
        }
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.DATOS_ENROL, false);
    }



    private String defaultProcessDate() {
        return calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
    }
}
