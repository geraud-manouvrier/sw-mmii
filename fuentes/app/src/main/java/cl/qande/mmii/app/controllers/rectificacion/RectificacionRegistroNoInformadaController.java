package cl.qande.mmii.app.controllers.rectificacion;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.dto.RectificacionCuentasNoInformadaDto;
import cl.qande.mmii.app.models.dto.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.models.dto.RectificacionSaldosNoInformadoDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IRectificacionService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.mapper.HtmlToDto;
import cl.qande.mmii.app.util.navegacion.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/rectificacion/registros_no_informados")
public class RectificacionRegistroNoInformadaController {
    private static final String TITULO_REG_NO_INF = "Ingreso de Cuentas, Saldos y Movimientos";
    private static final String TITULO_APROB_REG_NO_INF = "Aprobación/rechazo de Cuentas, Saldos y Movimientos no informados";
    private static final String TITULO_ANUL_REG_NO_INF = "Aprobación/rechazo de Cuentas, Saldos y Movimientos no informados";

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String CAMPO_PROCESS_DATE    = "processDate";
    private static final String CAMPO_LISTA_REGISTROS_CUENTAS    = "lista_registros_cuentas";
    private static final String CAMPO_LISTA_REGISTROS_SALDOS    = "lista_registros_saldos";
    private static final String CAMPO_LISTA_REGISTROS_MOVTOS    = "lista_registros_movtos";
    private static final int ID_ETDO_CREACION   = -1;
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IRectificacionService rectificacionService;


    @GetMapping({"/nuevo"})
    public String ingresarNuevosRegistros(
            Model model) throws QandeMmiiException {
        var listaCuentasPendientes  = rectificacionService.listaRectificacionesCuentasPendientes();
        var listaSaldosPendientes  = rectificacionService.listaRectificacionesSaldosPendientes();
        var listaMovtosPendientes  = rectificacionService.listaRectificacionesMovimientosPendientes();

        model.addAttribute(CAMPO_LISTA_REGISTROS_CUENTAS, listaCuentasPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_SALDOS, listaSaldosPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_MOVTOS, listaMovtosPendientes);

        model.addAttribute(CAMPO_TITULO, TITULO_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_PROCESS_DATE, calendarioHelper.defaultProcessDate());
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.RECT_NO_INF, false);
    }

    @PostMapping({"/guardar"})
    public String guardarNuevosRegistros(
            Model model,
            @RequestParam(value= "valor_cuentas") String valorCuentas,
            @RequestParam(value= "valor_saldos") String valorSaldos,
            @RequestParam(value= "valor_movimientos") String valorMovimientos,
            @RequestParam(value= CAMPO_PROCESS_DATE) String processDate
    ) throws QandeMmiiException {
        processDate = processDate.replace("-", "");
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        var fechaCreacion = Instant.now();
         List<RectificacionCuentasNoInformadaDto> listaCuentasDto = new ArrayList<>();
         List<RectificacionSaldosNoInformadoDto> listaSaldosDto = new ArrayList<>();
         List<RectificacionMovimientosNoInformadoDto> listaMovimientosDto = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            var listaGenericaCuentas = (ArrayList) objectMapper.readValue(valorCuentas, Object.class);
            var listaGenericaSaldos = (ArrayList) objectMapper.readValue(valorSaldos, Object.class);
            var listaGenericaMovimientos = (ArrayList) objectMapper.readValue(valorMovimientos, Object.class);

            listaCuentasDto = HtmlToDto.listaRectificacionCuentasNoInformadaDtoFromHtml(listaGenericaCuentas, ID_ETDO_CREACION, usuarioCreacion, fechaCreacion, processDate);
            listaSaldosDto = HtmlToDto.listaRectificacionSaldosNoInformadaDtoFromHtml(listaGenericaSaldos, ID_ETDO_CREACION, usuarioCreacion, fechaCreacion, processDate);
            listaMovimientosDto = HtmlToDto.listaRectificacionMovimientosNoInformadaDtoFromHtml(listaGenericaMovimientos, ID_ETDO_CREACION, usuarioCreacion, fechaCreacion, processDate);

            estadoPeticion.setEstadoOk("Carga registros OK", "Registros cargados (" + (listaCuentasDto.size() + listaSaldosDto.size() + listaMovimientosDto.size()) + ") y pendientes de aprobar.");

        } catch (Exception e) {
            appConfig.customLog.error("Error al procesar registros por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            appConfig.customLog.info("Detalle Cuentas: [" + valorCuentas + "]");
            appConfig.customLog.info("Detalle Saldos: [" + valorSaldos + "]");
            appConfig.customLog.info("Detalle Movimientos: [" + valorMovimientos + "]");
            estadoPeticion.setEstadoError("Error al procesar registros", "Verifique valores y formatos de datos no registrados.");
        }
        String detalleError = null;
        try {
            detalleError = "Cuentas, Saldos y Movimientos";
            rectificacionService.guardaListaRectificacionCuentasNoInformada(listaCuentasDto);
            detalleError = "Saldos y Movimientos";
            rectificacionService.guardaListaRectificacionSaldosNoInformado(listaSaldosDto);
            detalleError = "Movimientos";
            rectificacionService.guardaListaRectificacionMovimientosNoInformado(listaMovimientosDto);

            appConfig.customLog.info("Registros guardados OK por usuario [" + sesionWeb.getUsuario() + "]");
            appConfig.customLog.info("Cuentas guardadas: [" + listaCuentasDto + "]");
            appConfig.customLog.info("Saldos guardados: [" + listaSaldosDto + "]");
            appConfig.customLog.info("Movimientos guardados: [" + listaMovimientosDto + "]");

        } catch (Exception e) {
            appConfig.customLog.error("Error al guardar registros por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al guardar registros", "No se pudieron guardar algunos registros de " + detalleError + ".");
        }

        var listaCuentasPendientes  = rectificacionService.listaRectificacionesCuentasPendientes();
        var listaSaldosPendientes  = rectificacionService.listaRectificacionesSaldosPendientes();
        var listaMovtosPendientes  = rectificacionService.listaRectificacionesMovimientosPendientes();

        model.addAttribute(CAMPO_LISTA_REGISTROS_CUENTAS, listaCuentasPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_SALDOS, listaSaldosPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_MOVTOS, listaMovtosPendientes);

        model.addAttribute(CAMPO_TITULO, TITULO_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, calendarioHelper.defaultProcessDate());
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.RECT_NO_INF, false);
    }

    @GetMapping({"/{tipo}/eliminar/{id}"})
    public String anularRegistro(
            @PathVariable String tipo,
            @PathVariable Long id,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipo) {
                case "cuentas":
                    rectificacionService.anularRegistroCuenta(usuarioCreacion, id);
                    break;
                case "saldos":
                    rectificacionService.anularRegistroSaldo(usuarioCreacion, id);
                    break;
                case "movimientos":
                    rectificacionService.anularRegistroMovimiento(usuarioCreacion, id);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoOk("Eliminación de registro OK", "Registro anulado correctamente.");
            appConfig.customLog.info("Anulación de registro de tipo ["+tipo+"] ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al eliminar registro de tipo ["+tipo+"] ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al eliminar registro ID ["+id+"]", "No se pudo eliminar el registro de tipo ["+tipo+"].");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, calendarioHelper.defaultProcessDate());
        return ingresarNuevosRegistros(model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/aprobacion"})
    public String aprobacionNuevosRegistros(
            Model model) throws QandeMmiiException {
        var listaCuentasPendientes  = rectificacionService.listaRectificacionesCuentasPendientes();
        var listaSaldosPendientes  = rectificacionService.listaRectificacionesSaldosPendientes();
        var listaMovtosPendientes  = rectificacionService.listaRectificacionesMovimientosPendientes();

        model.addAttribute(CAMPO_LISTA_REGISTROS_CUENTAS, listaCuentasPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_SALDOS, listaSaldosPendientes);
        model.addAttribute(CAMPO_LISTA_REGISTROS_MOVTOS, listaMovtosPendientes);

        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.RECT_NO_INF_APR, false);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/aprobacion/aprobar"})
    public String aprobacionMasiva(
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            rectificacionService.aprobacionMasivaCuentas(usuarioCreacion);
            rectificacionService.aprobacionMasivaSaldos(usuarioCreacion);
            rectificacionService.aprobacionMasivaMovimientos(usuarioCreacion);
            estadoPeticion.setEstadoOk("Aprobación masiva de registros OK", "Registros aprobados correctamente.");
            appConfig.customLog.info("Aprobación masiva por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al aprobar registros por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al aprobar registros", "No se pudieron aprobar los registros.");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/{tipo}/aprobar/{id}"})
    public String aprobacionPorTipoId(
            @PathVariable String tipo,
            @PathVariable Long id,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipo) {
                case "cuentas":
                    rectificacionService.aprobacionPorIdCuenta(usuarioCreacion, id);
                    break;
                case "saldos":
                    rectificacionService.aprobacionPorIdSaldo(usuarioCreacion, id);
                    break;
                case "movimientos":
                    rectificacionService.aprobacionPorIdMovimiento(usuarioCreacion, id);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoOk("Aprobación de registro OK", "Registros aprobado correctamente ID ["+id+"].");
            appConfig.customLog.info("Aprobación ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al aprobar registro ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al aprobar registro", "No se pudo aprobar el registro ID ["+id+"].");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @PostMapping({"/{tipoReg}/aprobar/seleccion/"})
    public String aprobarPorTipoSeleccion(
            @PathVariable String tipoReg,
            @RequestParam(value= "idsCuentas", required = false) String[] idsCuentas,
            @RequestParam(value= "idsSaldos", required = false) String[] idsSaldos,
            @RequestParam(value= "idsMovimientos", required = false) String[] idsMovimientos,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipoReg) {
                case "cuentas":
                    rectificacionService.aprobacionPorSeleccionCuenta(usuarioCreacion, idsCuentas);
                    break;
                case "saldos":
                    rectificacionService.aprobacionPorSeleccionSaldos(usuarioCreacion, idsSaldos);
                    break;
                case "movimientos":
                    rectificacionService.aprobacionPorSeleccionMovimientos(usuarioCreacion, idsMovimientos);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoOk("Modificacion de registros OK", "Registros modificados correctamente.");
            appConfig.customLog.info("Modificacion seleccion por usuario [" + sesionWeb.getUsuario() + "]: ID cuentas ["+Arrays.toString(idsCuentas)+"] ID saldos ["+Arrays.toString(idsSaldos)+"] ID movimientos ["+Arrays.toString(idsMovimientos)+"]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al modificar registros accion ID cuentas ["+Arrays.toString(idsCuentas)+"] ID saldos ["+Arrays.toString(idsSaldos)+"] ID movimientos ["+Arrays.toString(idsMovimientos)+"]] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al modificar registros", "No se pudo modificar el registros.");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @PostMapping({"/{tipoReg}/rechazar/seleccion/"})
    public String rechazarPorTipoSeleccion(
            @PathVariable String tipoReg,
            @RequestParam(value= "idsCuentas", required = false) String[] idsCuentas,
            @RequestParam(value= "idsSaldos", required = false) String[] idsSaldos,
            @RequestParam(value= "idsMovimientos", required = false) String[] idsMovimientos,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipoReg) {
                case "cuentas":
                    rectificacionService.rechazoPorSeleccionCuenta(usuarioCreacion, idsCuentas);
                    break;
                case "saldos":
                    rectificacionService.rechazoPorSeleccionSaldos(usuarioCreacion, idsSaldos);
                    break;
                case "movimientos":
                    rectificacionService.rechazoPorSeleccionMovimientos(usuarioCreacion, idsMovimientos);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoOk("Modificacion de registros OK", "Registros modificados correctamente.");
            appConfig.customLog.info("Modificacion seleccion por usuario [" + sesionWeb.getUsuario() + "]: ID cuentas ["+Arrays.toString(idsCuentas)+"] ID saldos ["+Arrays.toString(idsSaldos)+"] ID movimientos ["+ Arrays.toString(idsMovimientos)+"]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al modificar registros accion ID cuentas ["+Arrays.toString(idsCuentas)+"] ID saldos ["+Arrays.toString(idsSaldos)+"] ID movimientos ["+Arrays.toString(idsMovimientos)+"]] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al modificar registros", "No se pudo modificar el registros.");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/aprobacion/rechazar"})
    public String rechazoMasiva(
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            rectificacionService.rechazoMasivaCuentas(usuarioCreacion);
            rectificacionService.rechazoMasivaSaldos(usuarioCreacion);
            rectificacionService.rechazoMasivaMovimientos(usuarioCreacion);
            estadoPeticion.setEstadoOk("Rechazo masiva de registros OK", "Registros rechazados correctamente.");
            appConfig.customLog.info("Rechazo masivo por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al rechazar registros por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al rechazar registros", "No se pudieron rechazar los registros.");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/{tipo}/rechazar/{id}"})
    public String rechazoPorTipoId(
            @PathVariable String tipo,
            @PathVariable Long id,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipo) {
                case "cuentas":
                    rectificacionService.rechazoPorIdCuenta(usuarioCreacion, id);
                    break;
                case "saldos":
                    rectificacionService.rechazoPorIdSaldos(usuarioCreacion, id);
                    break;
                case "movimientos":
                    rectificacionService.rechazoPorIdMovimiento(usuarioCreacion, id);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoOk("Rechazo de registro OK", "Registros rechazado correctamente ID ["+id+"].");
            appConfig.customLog.info("Rechazo ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al rechazar registro ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al rechazar registro", "No se pudo rechazar el registro ID ["+id+"].");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_APROB_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return aprobacionNuevosRegistros(model);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/reversa"})
    public String listaReversa(
            Model model) {
        return "redirect:/rectificacion/registros_no_informados/reversa/fecha/"+calendarioHelper.defaultProcessDate();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/reversa/fecha/{processDate}"})
    public String listaReversaByProcessDate(
            @PathVariable String processDate,
            Model model) throws QandeMmiiException {
        var listaCuentasAprobadas  = rectificacionService.listaRectificacionesCuentasAprobadas(processDate);
        var listaSaldosAprobadas  = rectificacionService.listaRectificacionesSaldosAprobadas(processDate);
        var listaMovtosAprobadas  = rectificacionService.listaRectificacionesMovimientosAprobadas(processDate);

        model.addAttribute(CAMPO_LISTA_REGISTROS_CUENTAS, listaCuentasAprobadas);
        model.addAttribute(CAMPO_LISTA_REGISTROS_SALDOS, listaSaldosAprobadas);
        model.addAttribute(CAMPO_LISTA_REGISTROS_MOVTOS, listaMovtosAprobadas);

        model.addAttribute(CAMPO_TITULO, TITULO_ANUL_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_PROCESS_DATE, processDate);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.RECT_NO_INF_REVER, false);
    }



    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER')")
    @GetMapping({"/{tipo}/reversar/{id}"})
    public String reversaRegistro(
            @PathVariable String tipo,
            @PathVariable Long id,
            Model model
    ) throws QandeMmiiException {
        var estadoPeticion = new EstadoPeticion();
        var usuarioCreacion = sesionWeb.getUsuario();
        try {
            switch (tipo) {
                case "cuentas":
                    rectificacionService.reversarRegistroCuenta(usuarioCreacion, id);
                    break;
                case "saldos":
                    rectificacionService.reversarRegistroSaldo(usuarioCreacion, id);
                    break;
                case "movimientos":
                    rectificacionService.reversarRegistroMovimiento(usuarioCreacion, id);
                    break;
                default:
                    throw new QandeMmiiException("Tipo de registro no válido");
            }
            estadoPeticion.setEstadoWarning("Reversa de registro OK", "Recuerde re procesar.");
            appConfig.customLog.info("Reversa de registro de tipo ["+tipo+"] ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]");
        } catch (Exception e) {
            appConfig.customLog.error("Error al reversar registro de tipo ["+tipo+"] ID ["+id+"] por usuario [" + sesionWeb.getUsuario() + "]: [" + e.getMessage() + "] ");
            estadoPeticion.setEstadoError("Error al reversar registro ID ["+id+"]", "No se pudo reversar el registro de tipo ["+tipo+"].");
        }
        model.addAttribute(CAMPO_TITULO, TITULO_REG_NO_INF);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        model.addAttribute(CAMPO_PROCESS_DATE, calendarioHelper.defaultProcessDate());
        return listaReversa(model);
    }


}
