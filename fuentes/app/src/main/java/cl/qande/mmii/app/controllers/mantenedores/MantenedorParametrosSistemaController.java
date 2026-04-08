package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.core.ParFeriadoDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ParametrosSistemaService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mantenedores/parametros-sistema")
public class MantenedorParametrosSistemaController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_MODIFICAR = "parFeriadoDto";
    private static final String LISTA_REGISTROS    = "lista_registros";
    private static final String TITULO_FERIADO = "Mantenedor Feriados";
    private final SesionWeb sesionWeb;
    private final ParametrosSistemaService parametrosSistemaService;

    public MantenedorParametrosSistemaController(SesionWeb sesionWeb, ParametrosSistemaService parametrosSistemaService) {
        this.sesionWeb = sesionWeb;
        this.parametrosSistemaService = parametrosSistemaService;
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).PARAMETROS_FERIADOS))")
    @GetMapping({"/feriados"})
    public String listaFeriados(
            @Valid ParFeriadoDto parFeriadoDto,
            BindingResult result,
            Model model) throws QandeMmiiException {

        model.addAttribute(CAMPO_TITULO, TITULO_FERIADO);
        model.addAttribute(LISTA_REGISTROS, parametrosSistemaService.listaFeriado());
        model.addAttribute(CAMPO_MODIFICAR, parFeriadoDto);
        if (model.getAttribute(CAMPO_STATUS) == null) {
            model.addAttribute(CAMPO_STATUS, new EstadoPeticion(0, "Página cargada", "Proceso terminado correctamente."));
        }
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.PARAMETROS_FERIADOS, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).PARAMETROS_FERIADOS))")
    @PostMapping({"/feriados/guardar", "/feriados/guardar/{id}"})
    public String guardaFeriado(
            @PathVariable(value = "id", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") java.time.LocalDate id,
            @Valid ParFeriadoDto parFeriadoDto,
            BindingResult result,
            Model model) throws QandeMmiiException {

        var estadoPeticion = new EstadoPeticion();
        if (id != null) {
            parFeriadoDto.setId(id);
            if (parametrosSistemaService.listaFeriado(id)!=null) {
                result.rejectValue("id", "error.parFeriadoDto", "Ya existe un Feriado para la fecha indicada.");
            }
        }
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError("Error al guardar registro.", "Error de validación.");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaFeriados(parFeriadoDto, result, model);
        }
        CustomLog.getInstance().info("Guardando feriado por usuario [" + sesionWeb.getUsuario() + "] - " + parFeriadoDto, false);
        try {
            parametrosSistemaService.guardaFeriado(parFeriadoDto);
            estadoPeticion.setEstadoOk("Feriado agregado correctamente.");
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error guardando feriado por usuario [" + sesionWeb.getUsuario() + "]: " + e.getMessage(), false);
            estadoPeticion.setEstadoError("Error al guardar registro.", e.getMessage());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
        }
        return listaFeriados(parFeriadoDto, result, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).PARAMETROS_FERIADOS))")
    @PostMapping({"/feriados/toggle-pershing/{dia}"})
    public String toggleFeriadoPershing(@PathVariable("dia") @DateTimeFormat(pattern = "yyyy-MM-dd") java.time.LocalDate dia,
                                        Model model) throws QandeMmiiException {
        try {
            parametrosSistemaService.toggleFeriadoPershing(dia);
        } catch (Exception e) {
            model.addAttribute(CAMPO_STATUS, new EstadoPeticion(true, "Error", "Error al cambiar estado Pershing."));
            CustomLog.getInstance().error("Error cambiando estado Pershing feriado [" + dia + "]: " + e.getMessage(), false);
        }
        return listaFeriados(new ParFeriadoDto(), null, model);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).PARAMETROS_FERIADOS))")
    @PostMapping({"/feriados/toggle-stonex/{dia}"})
    public String toggleFeriadoStonex(@PathVariable("dia") @DateTimeFormat(pattern = "yyyy-MM-dd") java.time.LocalDate dia,
                                      Model model) throws QandeMmiiException {
        try {
            parametrosSistemaService.toggleFeriadoStonex(dia);
        } catch (Exception e) {
            model.addAttribute(CAMPO_STATUS, new EstadoPeticion(true, "Error", "Error al cambiar estado Stonex."));
            CustomLog.getInstance().error("Error cambiando estado Stonex feriado [" + dia + "]: " + e.getMessage(), false);
        }
        return listaFeriados(new ParFeriadoDto(), null, model);
    }


}
