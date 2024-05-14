package cl.qande.mmii.app.controllers.mantenedores;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.db.sura.dao.IAuxiliarMovimientoDao;
import cl.qande.mmii.app.models.db.sura.dao.IBaseInstrumentoDao;
import cl.qande.mmii.app.models.db.sura.dao.IBaseUcitDao;
import cl.qande.mmii.app.models.db.sura.entity.AuxiliarMovimiento;
import cl.qande.mmii.app.models.db.sura.entity.BaseInstrumento;
import cl.qande.mmii.app.models.db.sura.entity.BaseUcit;
import cl.qande.mmii.app.models.dto.ParHomologacionSourceCodeStonexDto;
import cl.qande.mmii.app.models.dto.ParSourceCodeDto;
import cl.qande.mmii.app.models.exception.DaoException;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IMantenedoresInstrumentosService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/mantenedores/parametros_instrumentos")
public class ParametrosInstrumentosController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_LISTA_REGISTROS    = "lista_registros";
    private static final String CAMPO_MODIFICAR_AUXMOVTO = "auxiliarMovimiento";
    private static final String CAMPO_MODIFICAR_SRCCOD_PER = "parSourceCodeDto";
    private static final String CAMPO_MODIFICAR_SRCCOD_STNX = "parHomologacionSourceCodeStonexDto";
    private static final String CAMPO_MODIFICAR_BUCIT = "baseUcit";
    private static final String CAMPO_MODIFICAR_BINSTR = "baseInstrumento";
    private static final String TITULO_AUXMOVTO = "Mantenedor Auxiliar Movimientos";
    private static final String TITULO_SRCCOD_PER = "Mantenedor Source Code Pershing";
    private static final String TITULO_SRCCOD_STNX = "Mantenedor Source Code Stonex";
    private static final String TITULO_BUCIT = "Mantenedor Base UCIT";
    private static final String TITULO_BINSTR = "Mantenedor Base Instrumentos";
    private static final String URL_BASE_AUXMOVTO = "/mantenedores/parametros_instrumentos/auxiliar_movimiento/crear";
    private static final String URL_BASE_BUCIT = "/mantenedores/parametros_instrumentos/base_ucit/crear";
    private static final String URL_BASE_BINSTR = "/mantenedores/parametros_instrumentos/base_instrumento/crear";
    private static final String URL_BASE_SRCCOD_PER = "/mantenedores/parametros_instrumentos/source_code_pershing/crear";
    private static final String URL_BASE_SRCCOD_STNX = "/mantenedores/parametros_instrumentos/source_code_stonex/crear";
    private static final String ERROR_AGREGAR = "Error al agregar registro.";
    private static final String ERROR_MODIFICAR = "Error al modificar registro.";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IAuxiliarMovimientoDao auxiliarMovimientoDao;
    @Autowired
    private IBaseInstrumentoDao baseInstrumentoDao;
    @Autowired
    private IBaseUcitDao baseUcitDao;
    @Autowired
    private IMantenedoresInstrumentosService mantenedoresInstrumentosService;

    @GetMapping({"/source_code_stonex/crear"})
    public String listaSourceCodeStonex(
            @Valid ParHomologacionSourceCodeStonexDto parHomologacionSourceCodeStonexDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute("lista_source_code", mantenedoresInstrumentosService.listaSourceCode(true));
        model.addAttribute(CAMPO_LISTA_REGISTROS, mantenedoresInstrumentosService.listaSourceCodeStonex());
        model.addAttribute(CAMPO_TITULO, TITULO_SRCCOD_STNX);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_SRC_COD_STNX, false);
    }

    @GetMapping({"/source_code_stonex/editar/{id}"})
    public String formularioEditarSourceCodeStonex(
            @PathVariable("id") Long id,
            @Valid ParHomologacionSourceCodeStonexDto parHomologacionSourceCodeStonexDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            parHomologacionSourceCodeStonexDto    = mantenedoresInstrumentosService.sourceCodeStonexById(id);
            model.addAttribute(CAMPO_MODIFICAR_SRCCOD_STNX, parHomologacionSourceCodeStonexDto);
        }
        return listaSourceCodeStonex(parHomologacionSourceCodeStonexDto, result, model);
    }

    @PostMapping({"/source_code_stonex/guardar", "/source_code_stonex/guardar/{id}"})
    public String agregaSourceCodeStonex(
            @PathVariable(value = "id", required = false) Long id,
            @Valid ParHomologacionSourceCodeStonexDto parHomologacionSourceCodeStonexDto,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        parHomologacionSourceCodeStonexDto.setId(id);
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCodeStonex(parHomologacionSourceCodeStonexDto, result, model);
        }
        appConfig.customLog.info("Guardando registro Source Code Stonex por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parHomologacionSourceCodeStonexDto+"] ");
        try {
            mantenedoresInstrumentosService.save(parHomologacionSourceCodeStonexDto);
        } catch (DaoException daoException) {
            appConfig.customLog.error("Error agregando registro Source Code Stonex por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parHomologacionSourceCodeStonexDto+"]; Error: "+daoException.getMessage());
            estadoPeticion.setEstadoError(ERROR_AGREGAR, daoException.getMessage());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCodeStonex(parHomologacionSourceCodeStonexDto, result, model);
        } catch (Exception e) {
            appConfig.customLog.error("Error no controlado agregando registro Source Code Stonex por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parHomologacionSourceCodeStonexDto+"]; Error: "+e);
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCodeStonex(parHomologacionSourceCodeStonexDto, result, model);
        }
        return "redirect:"+ URL_BASE_SRCCOD_STNX;
    }
    //--------------------------------------------------------------



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
        appConfig.customLog.info("Agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parSourceCodeDto+"] ");
        try {
            mantenedoresInstrumentosService.save(parSourceCodeDto);
        } catch (DaoException daoException) {
            appConfig.customLog.error("Error agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parSourceCodeDto+"]; Error: "+daoException.getMessage());
            estadoPeticion.setEstadoError(ERROR_AGREGAR, daoException.getMessage());
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCode(parSourceCodeDto, result, model);
        } catch (Exception e) {
            appConfig.customLog.error("Error no controlado agregando registro Source Code Pershing por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+parSourceCodeDto+"]; Error: "+e);
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaSourceCode(parSourceCodeDto, result, model);
        }
        return "redirect:"+ URL_BASE_SRCCOD_PER;
    }
    //--------------------------------------------------------------



    @GetMapping({"/auxiliar_movimiento/crear"})
    public String listaAuxiliarMovimiento(
            @Valid AuxiliarMovimiento auxiliarMovimiento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, auxiliarMovimientoDao.findAll());
        model.addAttribute(CAMPO_TITULO, TITULO_AUXMOVTO);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_INSTR_AUXMOVTO, false);
    }

    @GetMapping({"/auxiliar_movimiento/editar/{id}"})
    public String formularioEditarAuxiliarMovimiento(
            @PathVariable("id") long id,
            @Valid AuxiliarMovimiento auxiliarMovimiento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            auxiliarMovimiento    = auxiliarMovimientoDao.findById(id).orElse(null);
            model.addAttribute(CAMPO_MODIFICAR_AUXMOVTO, auxiliarMovimiento);
        }
        return listaAuxiliarMovimiento(auxiliarMovimiento, result, model);
    }

    @PostMapping({"/auxiliar_movimiento/guardar"})
    public String agregaAuxiliarMovimiento(
            @Valid AuxiliarMovimiento auxiliarMovimiento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaAuxiliarMovimiento(auxiliarMovimiento, result, model);
        }
        if (auxiliarMovimiento.getObservacionesInternas().isBlank()) {
            auxiliarMovimiento.setObservacionesInternas(null);
        }
        appConfig.customLog.info("Guardando registro Auxiliar Movimiento por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+auxiliarMovimiento.toString()+"] ");
        auxiliarMovimientoDao.save(auxiliarMovimiento);
        return "redirect:"+ URL_BASE_AUXMOVTO;
    }

    @PostMapping({"/auxiliar_movimiento/guardar/{id}"})
    public String modificaAuxiliarMovimiento(
            @PathVariable("id") long id,
            @Valid AuxiliarMovimiento auxiliarMovimiento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_MODIFICAR, ERROR_MODIFICAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarAuxiliarMovimiento(id, auxiliarMovimiento, result, model);
        }
        if (auxiliarMovimiento.getObservacionesInternas().isBlank()) {
            auxiliarMovimiento.setObservacionesInternas(null);
        }
        appConfig.customLog.info("Actualizando registro ID ["+id+"] Auxiliar Movimiento por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+auxiliarMovimiento.toString()+"] ");
        auxiliarMovimientoDao.save(auxiliarMovimiento);
        return "redirect:"+ URL_BASE_AUXMOVTO;
    }
    //--------------------------------------------------------------

    @GetMapping({"/base_instrumento/crear"})
    public String listaBaseInstrumento(
            @Valid BaseInstrumento baseInstrumento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, baseInstrumentoDao.findAll());
        model.addAttribute(CAMPO_TITULO, TITULO_BINSTR);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_INSTR_BINSTR, false);
    }

    @GetMapping({"/base_instrumento/editar/{id}"})
    public String formularioEditarBaseInstrumento(
            @PathVariable("id") long id,
            @Valid BaseInstrumento baseInstrumento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            baseInstrumento    = baseInstrumentoDao.findById(id).orElse(null);
            model.addAttribute(CAMPO_MODIFICAR_BINSTR, baseInstrumento);
        }
        return listaBaseInstrumento(baseInstrumento, result, model);
    }

    @PostMapping({"/base_instrumento/guardar"})
    public String agregaBaseInstrumento(
            @Valid BaseInstrumento baseInstrumento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaBaseInstrumento(baseInstrumento, result, model);
        }
        if (baseInstrumento.getSecId().isBlank()) {
            baseInstrumento.setSecId(null);
        }
        if (baseInstrumento.getTicker().isBlank()) {
            baseInstrumento.setTicker(null);
        }
        if (baseInstrumento.getIdSubSubTipoActivo().isBlank()) {
            baseInstrumento.setIdSubSubTipoActivo(null);
        }
        if (baseInstrumento.getIdSubTipoActivo().isBlank()) {
            baseInstrumento.setIdSubTipoActivo(null);
        }
        if (baseInstrumento.getIdTipoActivo().isBlank()) {
            baseInstrumento.setIdTipoActivo(null);
        }
        if (baseInstrumento.getNombreSubSubTipoActivo().isBlank()) {
            baseInstrumento.setNombreSubSubTipoActivo(null);
        }
        if (baseInstrumento.getProductType().isBlank()) {
            baseInstrumento.setProductType(null);
        }
        appConfig.customLog.info("Guardando registro Base Instrumento por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+baseInstrumento.toString()+"] ");
        baseInstrumentoDao.save(baseInstrumento);
        return "redirect:"+ URL_BASE_BINSTR;
    }

    @PostMapping({"/base_instrumento/guardar/{id}"})
    public String modificaBaseInstrumento(
            @PathVariable("id") long id,
            @Valid BaseInstrumento baseInstrumento,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_MODIFICAR, ERROR_MODIFICAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarBaseInstrumento(id, baseInstrumento, result, model);
        }
        if (baseInstrumento.getSecId().isBlank()) {
            baseInstrumento.setSecId(null);
        }
        if (baseInstrumento.getTicker().isBlank()) {
            baseInstrumento.setTicker(null);
        }
        if (baseInstrumento.getIdSubSubTipoActivo().isBlank()) {
            baseInstrumento.setIdSubSubTipoActivo(null);
        }
        if (baseInstrumento.getIdSubTipoActivo().isBlank()) {
            baseInstrumento.setIdSubTipoActivo(null);
        }
        if (baseInstrumento.getIdTipoActivo().isBlank()) {
            baseInstrumento.setIdTipoActivo(null);
        }
        if (baseInstrumento.getNombreSubSubTipoActivo().isBlank()) {
            baseInstrumento.setNombreSubSubTipoActivo(null);
        }
        if (baseInstrumento.getProductType().isBlank()) {
            baseInstrumento.setProductType(null);
        }
        appConfig.customLog.info("Actualizando registro ID ["+id+"] Base Instrumento por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+baseInstrumento.toString()+"] ");
        baseInstrumentoDao.save(baseInstrumento);
        return "redirect:"+ URL_BASE_BINSTR;
    }
    //--------------------------------------------------------------

    @GetMapping({"/base_ucit/crear"})
    public String listaBaseUcit(
            @Valid BaseUcit baseUcit,
            BindingResult result,
            Model model) throws QandeMmiiException {
        model.addAttribute(CAMPO_LISTA_REGISTROS, baseUcitDao.findAll());
        model.addAttribute(CAMPO_TITULO, TITULO_BUCIT);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.MANT_INSTR_BUCIT, false);
    }

    @GetMapping({"/base_ucit/editar/{id}"})
    public String formularioEditarBaseUcit(
            @PathVariable("id") long id,
            @Valid BaseUcit baseUcit,
            BindingResult result,
            Model model) throws QandeMmiiException {
        if(model.getAttribute(CAMPO_STATUS)==null) {
            baseUcit    = baseUcitDao.findById(id).orElse(null);
            model.addAttribute(CAMPO_MODIFICAR_BUCIT, baseUcit);
        }
        return listaBaseUcit(baseUcit, result, model);
    }

    @PostMapping({"/base_ucit/guardar"})
    public String agregaBaseUcit(
            @Valid BaseUcit baseUcit,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_AGREGAR, ERROR_AGREGAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return listaBaseUcit(baseUcit, result, model);
        }
        appConfig.customLog.info("Guardando registro Base UCIT por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+baseUcit.toString()+"] ");
        baseUcitDao.save(baseUcit);
        return "redirect:"+ URL_BASE_BUCIT;
    }

    @PostMapping({"/base_ucit/guardar/{id}"})
    public String modificaBaseUcit(
            @PathVariable("id") long id,
            @Valid BaseUcit baseUcit,
            BindingResult result,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        if (result.hasErrors()) {
            estadoPeticion.setEstadoError(ERROR_MODIFICAR, ERROR_MODIFICAR);
            model.addAttribute(CAMPO_STATUS, estadoPeticion);
            return formularioEditarBaseUcit(id, baseUcit, result, model);
        }
        appConfig.customLog.info("Actualizando registro ID ["+id+"] Base UCIT por usuario ["+sesionWeb.getUsuario()+"]: Valor registro ["+baseUcit.toString()+"] ");
        baseUcitDao.save(baseUcit);
        return "redirect:"+ URL_BASE_BUCIT;
    }
}
