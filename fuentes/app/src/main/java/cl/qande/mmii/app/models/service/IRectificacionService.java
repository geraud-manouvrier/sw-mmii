package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.RectificacionCuentasNoInformadaDto;
import cl.qande.mmii.app.models.dto.RectificacionMovimientosNoInformadoDto;
import cl.qande.mmii.app.models.dto.RectificacionSaldosNoInformadoDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRectificacionService {


    @Transactional
    void guardaRectificacionCuentaNoInformada(RectificacionCuentasNoInformadaDto rectificacionCuentasNoInformadaDto);

    @Transactional
    void guardaListaRectificacionCuentasNoInformada(List<RectificacionCuentasNoInformadaDto> listaRectificacionCuentasNoInformadaDto);

    @Transactional
    void guardaListaRectificacionSaldosNoInformado(List<RectificacionSaldosNoInformadoDto> listaRectificacionSaldosNoInformadaDto);

    @Transactional
    void guardaListaRectificacionMovimientosNoInformado(List<RectificacionMovimientosNoInformadoDto> listaRectificacionMovimientosNoInformadaDto);

    @Transactional(readOnly = true)
    List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasPendientes();

    @Transactional(readOnly = true)
    List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasAprobadas(String optionalProcessDate);

    @Transactional(readOnly = true)
    List<RectificacionCuentasNoInformadaDto> listaRectificacionesCuentasRechazadas();

    @Transactional
    int aprobacionMasivaCuentas(String usuarioModificador);

    @Transactional
    int aprobacionPorIdCuenta(String usuarioModificador, Long idRectificacion);

    @Transactional
    int aprobacionPorSeleccionCuenta(String usuarioModificador, String[] idsCuentas);

    @Transactional
    int rechazoMasivaCuentas(String usuarioModificador);

    @Transactional
    int rechazoPorIdCuenta(String usuarioModificador, Long idRectificacion);

    @Transactional
    int rechazoPorSeleccionCuenta(String usuarioModificador, String[] idsCuentas);

    @Transactional
    int anularRegistroCuenta(String usuarioModificador, Long idRectificacion);

    @Transactional
    int reversarRegistroCuenta(String usuarioModificador, Long idRectificacion);

    @Transactional(readOnly = true)
    List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosPendientes();

    @Transactional(readOnly = true)
    List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosAprobadas(String optionalProcessDate);

    @Transactional(readOnly = true)
    List<RectificacionSaldosNoInformadoDto> listaRectificacionesSaldosRechazadas();

    @Transactional
    int aprobacionMasivaSaldos(String usuarioModificador);

    @Transactional
    int aprobacionPorIdSaldo(String usuarioModificador, Long idRectificacion);

    @Transactional
    int aprobacionPorSeleccionSaldos(String usuarioModificador, String[] idsSaldos);

    @Transactional
    int rechazoMasivaSaldos(String usuarioModificador);

    @Transactional
    int rechazoPorIdSaldos(String usuarioModificador, Long idRectificacion);

    @Transactional
    int rechazoPorSeleccionSaldos(String usuarioModificador, String[] idsSaldos);

    @Transactional
    int anularRegistroSaldo(String usuarioModificador, Long idRectificacion);

    @Transactional
    int reversarRegistroSaldo(String usuarioModificador, Long idRectificacion);

    @Transactional(readOnly = true)
    List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosPendientes();

    @Transactional(readOnly = true)
    List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosAprobadas(String optionalProcessDate);

    @Transactional(readOnly = true)
    List<RectificacionMovimientosNoInformadoDto> listaRectificacionesMovimientosRechazadas();

    @Transactional
    int aprobacionMasivaMovimientos(String usuarioModificador);

    @Transactional
    int aprobacionPorIdMovimiento(String usuarioModificador, Long idRectificacion);

    @Transactional
    int aprobacionPorSeleccionMovimientos(String usuarioModificador, String[] idsMovimientos);

    @Transactional
    int rechazoMasivaMovimientos(String usuarioModificador);

    @Transactional
    int rechazoPorIdMovimiento(String usuarioModificador, Long idRectificacion);

    @Transactional
    int rechazoPorSeleccionMovimientos(String usuarioModificador, String[] idsMovimientos);

    @Transactional
    int anularRegistroMovimiento(String usuarioModificador, Long idRectificacion);

    @Transactional
    int reversarRegistroMovimiento(String usuarioModificador, Long idRectificacion);
}
