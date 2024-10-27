package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.ParFeeSegmentoDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IMantenedoresParametrosService;
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
import java.math.BigDecimal;

@Controller
@RequestMapping("/mantenedores/parametros")
public class ParametrosController {
    public static final String ERROR_SUMA_TASAS = "Suma de Tasas deben ser igual a Annual Fee. ";
    private static final String PREFIS_ERROR_DTO    = "error.";
    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String REDIRECT = "redirect:";
    private static final String ERROR_ES_OBLIG = "es obligatorio.";
    private static final String ERROR_NO_VALIDO = "no válido.";
    private static final String PREFIX_ERROR_VALID = "Error al guardar registro";
    private static final String MSG_APPEND_USER = "] Usuario: [";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    private static final String CAMPO_MODIFICAR_CLIENTE = "clienteDto";
    private static final String ERROR_DTO_FEE_SEGMENTO = PREFIS_ERROR_DTO+CAMPO_MODIFICAR_CLIENTE;
    //Fee Segmento
    private static final String CAMPO_MODIFICAR_FEE_SEGMENTO = "parFeeSegmentoDto";
    private static final String TITULO_FEE_SEGMENTO = "Mantenedor Fee Segmentos";
    private static final String URL_FEE_SEGMENTO = "/mantenedores/parametros/fee_segmento";

    private final IMantenedoresParametrosService mantenedoresParametrosService;
    private final SesionWeb sesionWeb;

    @Autowired
    public ParametrosController(IMantenedoresParametrosService mantenedoresParametrosService, SesionWeb sesionWeb) {
        this.mantenedoresParametrosService = mantenedoresParametrosService;
        this.sesionWeb = sesionWeb;
    }

    //-----------------------------------------------------------------------------------------------------
    //Fee Segmento
    //-----------------------------------------------------------------------------------------------------

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_FEE_SEGMENTO))")
    @GetMapping({"/fee_segmento"})
    public String inicioFeeSegmento(
            @Valid ParFeeSegmentoDto parFeeSegmentoDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, mantenedoresParametrosService.listaRegistrosOrdenadorPorMonto());
        model.addAttribute(CAMPO_TITULO, TITULO_FEE_SEGMENTO);
        model.addAttribute(CAMPO_SESION, sesionWeb);

        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_FEE_SEGMENTO, false);
    }

    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_FEE_SEGMENTO))")
    @GetMapping({"/fee_segmento/editar/{id}"})
    public String inicioFeeSegmentoPorId(
            @PathVariable("id") Integer id,
            @Valid ParFeeSegmentoDto parFeeSegmentoDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            parFeeSegmentoDto    = mantenedoresParametrosService.registroPorId(id);
            model.addAttribute(CAMPO_MODIFICAR_FEE_SEGMENTO, parFeeSegmentoDto);
        }
        return inicioFeeSegmento(parFeeSegmentoDto, result, model);
    }
    @PreAuthorize("hasAnyRole(T(cl.qande.mmii.app.util.navegacion.Menu).roleOp(T(cl.qande.mmii.app.util.navegacion.Menu).MANT_FEE_SEGMENTO))")
    @PostMapping({"/fee_segmento/guardar", "/fee_segmento/guardar/{id}"})
    public String guardarFeeSegmento(
            @PathVariable(value = "id", required = false) Integer id,
            @Valid ParFeeSegmentoDto parFeeSegmentoDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion      = new EstadoPeticion();
        var usuario             = sesionWeb.getUsuario();
        parFeeSegmentoDto.setId(id);
        parFeeSegmentoDto.setModificacionUsuario(usuario);

        this.validateDto(parFeeSegmentoDto, result);

        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, "Campos tienen errores");
            CustomLog.getInstance().error(PREFIX_ERROR_VALID +" ID ["+id+MSG_APPEND_USER +usuario+"]: ["+result.getAllErrors()+"] ");
            sesionWeb.addNotification(estadoPeticion.getDetalle());
            sesionWeb.addNotification(result.getFieldErrors());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return inicioFeeSegmentoPorId(id, parFeeSegmentoDto, result, model);
        }
        CustomLog.getInstance().info("Guardando registro ID ["+id+MSG_APPEND_USER+usuario+ parFeeSegmentoDto.toString()+"] ");
        try {
            mantenedoresParametrosService.guardarRegistro(parFeeSegmentoDto);
        } catch (Exception e) {
            estadoPeticion.setEstadoError(PREFIX_ERROR_VALID, PREFIX_ERROR_VALID);
            CustomLog.getInstance().error(PREFIX_ERROR_VALID+" ID ["+id+MSG_APPEND_USER+usuario+"]: ["+e.getMessage()+"] ");
            sesionWeb.addNotification(estadoPeticion.getDetalle());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return inicioFeeSegmentoPorId(id, parFeeSegmentoDto, result, model);
        }
        return REDIRECT+ URL_FEE_SEGMENTO;
    }

    //-----------------------------------------------------------------------------------------------------
    //Validadores DTOs
    //-----------------------------------------------------------------------------------------------------

    private BindingResult validateDto(ParFeeSegmentoDto parFeeSegmentoDto, BindingResult result) {
        String objectName    = " Segmento Fee ";
        if (parFeeSegmentoDto.getGlosa()==null || parFeeSegmentoDto.getGlosa().isBlank()) {
            result.rejectValue("glosa", ERROR_DTO_FEE_SEGMENTO, "Glosa "+objectName+ERROR_ES_OBLIG);
        }
        if (parFeeSegmentoDto.getMontoMin()==null || parFeeSegmentoDto.getMontoMin().compareTo(BigDecimal.ZERO)<0) {
            result.rejectValue("montoMin", ERROR_DTO_FEE_SEGMENTO, "Monto mínimo "+objectName+ERROR_NO_VALIDO);
        }
        if (parFeeSegmentoDto.getMontoMax()==null || parFeeSegmentoDto.getMontoMax().compareTo(BigDecimal.ZERO)<0) {
            result.rejectValue("montoMax", ERROR_DTO_FEE_SEGMENTO, "Monto máximo "+objectName+ERROR_NO_VALIDO);
        }
        if (parFeeSegmentoDto.getAnnualFee()==null || parFeeSegmentoDto.getAnnualFee().compareTo(BigDecimal.ZERO)<0) {
            result.rejectValue("annualFee", ERROR_DTO_FEE_SEGMENTO, "Annual Fee "+objectName+ERROR_NO_VALIDO);
        }
        if (parFeeSegmentoDto.getTasaProteccion()==null || parFeeSegmentoDto.getTasaProteccion().compareTo(BigDecimal.ZERO)<0) {
            result.rejectValue("tasaProteccion", ERROR_DTO_FEE_SEGMENTO, "Tasa Protección "+objectName+ERROR_NO_VALIDO);
        }
        if (parFeeSegmentoDto.getTasaSuracorp()==null || parFeeSegmentoDto.getTasaSuracorp().compareTo(BigDecimal.ZERO)<0) {
            result.rejectValue("tasaSuracorp", ERROR_DTO_FEE_SEGMENTO, "Tasa SURA Corp "+objectName+ERROR_NO_VALIDO);
        }
        if(parFeeSegmentoDto.getAnnualFee()!=null
                && parFeeSegmentoDto.getTasaProteccion()!=null
                && parFeeSegmentoDto.getTasaSuracorp()!=null
                && parFeeSegmentoDto.getAnnualFee().compareTo(parFeeSegmentoDto.getTasaProteccion().add( parFeeSegmentoDto.getTasaSuracorp()))!=0
        ) {
            result.rejectValue("annualFee", ERROR_DTO_FEE_SEGMENTO, ERROR_SUMA_TASAS +objectName+ERROR_NO_VALIDO);
            result.rejectValue("tasaProteccion", ERROR_DTO_FEE_SEGMENTO, ERROR_SUMA_TASAS +objectName+ERROR_NO_VALIDO);
            result.rejectValue("tasaSuracorp", ERROR_DTO_FEE_SEGMENTO, ERROR_SUMA_TASAS +objectName+ERROR_NO_VALIDO);
        }
        if (! mantenedoresParametrosService.isValidSegmentoFee(parFeeSegmentoDto.getId(), parFeeSegmentoDto.getMontoMin(), parFeeSegmentoDto.getMontoMax())) {
            result.rejectValue("montoMin", ERROR_DTO_FEE_SEGMENTO, "Monto mínimo ya existe en un segmento. "+objectName+ERROR_NO_VALIDO);
            result.rejectValue("montoMax", ERROR_DTO_FEE_SEGMENTO, "Monto máximo ya existe en un segmento. "+objectName+ERROR_NO_VALIDO);
        }
        return result;
    }

}
