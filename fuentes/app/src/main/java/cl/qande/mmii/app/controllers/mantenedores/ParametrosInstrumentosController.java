package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.core.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.MantenedoresInstrumentosService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
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
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@RequestMapping("/mantenedores/parametros_instrumentos")
public class ParametrosInstrumentosController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    private static final String CAMPO_MODIFICAR_SRCCOD_PER = "parSourceCodeDto";
    private static final String TITULO_SRCCOD_PER = "Mantenedor Source Code Pershing";
    private static final String URL_BASE_SRCCOD_PER = "/mantenedores/parametros_instrumentos/source_code_pershing/crear";
    private static final String ERROR_AGREGAR = "Error al agregar registro.";
    public static final String CONCAT_MSG_VALUE = "]: Valor registro [";

    private final SesionWeb sesionWeb;
    private final MantenedoresInstrumentosService mantenedoresInstrumentosService;

    @Autowired
    public ParametrosInstrumentosController(SesionWeb sesionWeb, MantenedoresInstrumentosService mantenedoresInstrumentosService) {
        this.sesionWeb = sesionWeb;
        this.mantenedoresInstrumentosService = mantenedoresInstrumentosService;
    }


    @GetMapping({"/source_code_pershing/crear"})
    public String listaSourceCode(
            @Valid ParSourceCodeDto parSourceCodeDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, mantenedoresInstrumentosService.listaSourceCode(true));
        model.addAttribute(CAMPO_TITULO, TITULO_SRCCOD_PER);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        if (model.getAttribute(CAMPO_STATUS)==null) {
            model.addAttribute(CAMPO_STATUS, new EstadoPeticion(0, "Página cargada", "Proceso terminado correctamente."));
        }
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_SRC_COD_PER, false);
    }

    @GetMapping({"/source_code_pershing/editar/{id}"})
    public String formularioEditarSourceCode(
            @PathVariable("id") Long id,
            @Valid ParSourceCodeDto parSourceCodeDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            parSourceCodeDto    = mantenedoresInstrumentosService.sourceCodeById(id);
            model.addAttribute(CAMPO_MODIFICAR_SRCCOD_PER, parSourceCodeDto);
        }
        return listaSourceCode(parSourceCodeDto, result, model);
    }

    @PostMapping({"/source_code_pershing/guardar", "/source_code_pershing/guardar/{id}"})
    public String agregaSourceCode(
            @PathVariable(value = "id", required = false) Long id,
            @Valid ParSourceCodeDto parSourceCodeDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        parSourceCodeDto.setId(id);
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCode(parSourceCodeDto, result, model);
        }
        CustomLog.getInstance().info("Agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+ CONCAT_MSG_VALUE +parSourceCodeDto+"] ");
        try {
            mantenedoresInstrumentosService.save(parSourceCodeDto);
        } catch (DaoException daoException) {
            CustomLog.getInstance().error("Error agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+ CONCAT_MSG_VALUE +parSourceCodeDto+"]; Error: "+daoException.getMessage());
            estadoPeticion.setEstadoError(ERROR_AGREGAR, daoException.getMessage());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCode(parSourceCodeDto, result, model);
        } catch (Exception e) {
            CustomLog.getInstance().error("Error no controlado agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+ CONCAT_MSG_VALUE +parSourceCodeDto+"]; Error: "+e);
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCode(parSourceCodeDto, result, model);
        }
        return "redirect:"+ URL_BASE_SRCCOD_PER;
    }
    //--------------------------------------------------------------


}
