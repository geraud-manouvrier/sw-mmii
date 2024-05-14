package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.UniversoClienteProjection;
import cl.qande.mmii.app.models.db.core.entity.UniversoCuentaProjection;
import cl.qande.mmii.app.models.db.rep_inv.entity.*;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.ContratoDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.PerfilCuentaDto;
import cl.qande.mmii.app.models.dto.reporte_inversiones.ReporteInversionesClienteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IReporteInversionesService {
    @Transactional(readOnly = true)
    public List<RentabilidadCalculadaDetallada> calculaRentabilidadDetallada(String agregadorN1, String agregadorN2, String agregadorN3, String agregadorN4, String fechaDesde, String fechaHasta);

    @Transactional(readOnly = true)
    List<RentabilidadCalculada> calculaRentabilidad(String agregadorN1, String agregadorN2, String agregadorN3, String agregadorN4, String startProcessDate, String endProcessDate, boolean todosNiveles);

    List<RentabilidadCalculada> rentabilidadAnualBase100(String agregadorN1, String endProcessDate);

    List<VwBaseConsolidado> listaBaseConsolidadaPorClienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber);

    List<ConsolidadoAgregadoN1> listaConsolidadoAgregadoPorcliente(String fechaDesde, String fechaHasta, String clientId);

    List<ConsolidadoAgregadoN2> listaConsolidadoAgregadoPorclienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber);

    List<UniversoClienteProjection> listaUniversoClientes(String processDate);

    List<UniversoCuentaProjection> listaUniversoCuentas(String processDate);

    List<String> listaBaseClientes();

    List<String> listaBaseCuentas();

    ClienteDto getCliente(String clientId);

    List<ContratoDto> getContratos(String clientId);

    List<CuentaDto> getCuentasPorCliente(String clientId);

    List<CuentaDto> getCuentasPorContrato(String idContrato);

    List<PerfilCuentaDto> getCuentasPerfilPorCliente(String clientId);

    PerfilCuentaDto getCuentaPerfilPorCuenta(String idInternoCuenta);

    ReporteInversionesClienteDto generaReporteInversionesCliente(String idCliente, String processDate);

    String preCalculoDiarioRentabilidad(String startProcessDate, String endProcessDate);
}
