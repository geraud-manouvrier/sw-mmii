package cl.qande.mmii.app.controllers.indicadores_negocio;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
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
@RequestMapping("/indicadores-negocio")
public class IndicadoresNegocioController {
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_START_DATE    = "startProcessDate";

    private final ReporteMaestroDatosService reporteMaestroDatosService;
    private final SesionWeb sesionWeb;
    private final CalendarioHelper calendarioHelper;

    @Autowired
    public IndicadoresNegocioController(ReporteMaestroDatosService reporteMaestroDatosService, SesionWeb sesionWeb, CalendarioHelper calendarioHelper) {
        this.reporteMaestroDatosService = reporteMaestroDatosService;
        this.sesionWeb = sesionWeb;
        this.calendarioHelper = calendarioHelper;
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).NEGOCIO_COMDEV))")
    @GetMapping({"/ingresos/indicadores-base", "/ingresos/indicadores-base/{startProcessDate}"})
    public String indicadoresBasePeriodo(
            Model model,
            @PathVariable(value="startProcessDate", required = false) String startProcessDate
    ) throws QandeMmiiException {
        if (startProcessDate == null || startProcessDate.isEmpty()) {
            startProcessDate    = String.valueOf(Integer.valueOf(calendarioHelper.defaultProcessDate().substring(0,4))-1).concat("0101");
        }

        model.addAttribute(CAMPO_TITULO, "Comisión Devengada por Periodo");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_START_DATE, startProcessDate);
        model.addAttribute("lista_registros", reporteMaestroDatosService.indicadoresBasePorPeriodo(startProcessDate));

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.NEGOCIO_COMDEV, false);
    }




}
