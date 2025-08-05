package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.datasources.CoreDataSourceConfiguration;
import cl.qande.mmii.app.models.api.reportes_maestros.MaestroCuentasApiDto;
import cl.qande.mmii.app.models.api.reportes_maestros.MaestroMovimientosApiDto;
import cl.qande.mmii.app.models.api.reportes_maestros.MaestroRelacionadosApiDto;
import cl.qande.mmii.app.models.api.reportes_maestros.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.AccountFeeValidated;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosMovimientosDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosRelacionadoDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.core.entity.*;
import cl.qande.mmii.app.util.mapper.core.VwReporteMaestroDatosClienteMapper;
import cl.qande.mmii.app.util.mapper.core.VwReporteMaestroDatosMovimientoMapper;
import cl.qande.mmii.app.util.mapper.core.VwReporteMaestroDatosRelacionadoMapper;
import cl.qande.mmii.app.util.mapper.core.VwReporteMaestroDatosSaldoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReporteMaestroDatosService {


    private final IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao;
    private final IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao;
    private final IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao;
    private final IReporteMaestroDatosRelacionadoDao reporteMaestroDatosRelacionadoDao;
    private final VwReporteMaestroDatosSaldoMapper vwReporteMaestroDatosSaldoMapper;
    private final VwReporteMaestroDatosMovimientoMapper vwReporteMaestroDatosMovimientoMapper;
    private final VwReporteMaestroDatosClienteMapper vwReporteMaestroDatosClienteMapper;
    private final EntityManager entityManager;
    private final VwReporteMaestroDatosRelacionadoMapper vwReporteMaestroDatosRelacionadoMapper;

    @Autowired
    public ReporteMaestroDatosService(IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao, IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao, IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao, IReporteMaestroDatosRelacionadoDao reporteMaestroDatosRelacionadoDao, VwReporteMaestroDatosSaldoMapper vwReporteMaestroDatosSaldoMapper, VwReporteMaestroDatosMovimientoMapper vwReporteMaestroDatosMovimientoMapper, VwReporteMaestroDatosClienteMapper vwReporteMaestroDatosClienteMapper, @Qualifier(CoreDataSourceConfiguration.ENTITY_MANAGER) EntityManager entityManager,
                                      VwReporteMaestroDatosRelacionadoMapper vwReporteMaestroDatosRelacionadoMapper) {
        this.reporteMaestroDatosClientesDao = reporteMaestroDatosClientesDao;
        this.reporteMaestroDatosMovimientosDao = reporteMaestroDatosMovimientosDao;
        this.reporteMaestroDatosSaldoDao = reporteMaestroDatosSaldoDao;
        this.reporteMaestroDatosRelacionadoDao = reporteMaestroDatosRelacionadoDao;
        this.vwReporteMaestroDatosSaldoMapper = vwReporteMaestroDatosSaldoMapper;
        this.vwReporteMaestroDatosMovimientoMapper = vwReporteMaestroDatosMovimientoMapper;
        this.vwReporteMaestroDatosClienteMapper = vwReporteMaestroDatosClienteMapper;
        this.entityManager = entityManager;
        this.vwReporteMaestroDatosRelacionadoMapper = vwReporteMaestroDatosRelacionadoMapper;
    }

    @Transactional(readOnly = true)
    public List<MaestroCuentasApiDto> reporteMaestroCuentasApi(String processDate) {
        return vwReporteMaestroDatosClienteMapper.toDto(this.generaReporteClientes(processDate));

    }

    @Transactional(readOnly = true)
    public List<MaestroSaldosApiDto> reporteMaestroSaldosApi(String processDate) {
        return vwReporteMaestroDatosSaldoMapper.toDto(this.generaReporteSaldos(processDate));

    }

    @Transactional(readOnly = true)
    public List<MaestroMovimientosApiDto> reporteMaestroMovimientosApi(String processDate) {
        return vwReporteMaestroDatosMovimientoMapper.toDto(this.generaReporteMovimientos(processDate));

    }

    @Transactional(readOnly = true)
    public List<MaestroRelacionadosApiDto> reporteMaestroRelacionadosApi(String processDate) {
        return vwReporteMaestroDatosRelacionadoMapper.toDto(this.generaReporteRelacionados(processDate));

    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate) {
        return reporteMaestroDatosSaldoDao.generaReporte(processDate);
    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosRelacionado> generaReporteRelacionados(String processDate) {
        return reporteMaestroDatosRelacionadoDao.generaReporte(processDate);
    }

    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> generaReporteClientes(String processDate) {
        return reporteMaestroDatosClientesDao.generaReporte(processDate);
    }

    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientos(String processDate) {
        return reporteMaestroDatosMovimientosDao.generaReporte(processDate);
    }

    @Transactional
    public void materializaDatosCliente(String processDate) {
        reporteMaestroDatosClientesDao.materializaDatosClientePershing(processDate);
    }
    @Transactional
    public void materializaDatosMovimiento(String processDate) {
        reporteMaestroDatosMovimientosDao.materializaDatosMovimientosPershing(processDate);
    }
    @Transactional
    public void materializaDatosSaldo(String processDate) {
        reporteMaestroDatosSaldoDao.materializaDatosSaldosPershing(processDate);
    }
    @Transactional
    public void materializaDatosRelacionado(String processDate) {
        reporteMaestroDatosRelacionadoDao.materializaDatosRelacionadoPershing(processDate);
    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> findClientesByProcessDateBetween(String processDateFrom, String processDateTo) {
        return reporteMaestroDatosClientesDao.findByProcessDateBetween(processDateFrom, processDateTo);
    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosRelacionado> findRelacionadosByProcessDateBetween(String processDateFrom, String processDateTo) {
        return reporteMaestroDatosRelacionadoDao.findByProcessDateBetween(processDateFrom, processDateTo);
    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosSaldo> findSaldosByProcessDateBetween(String processDateFrom, String processDateTo) {
        return reporteMaestroDatosSaldoDao.findByProcessDateBetween(processDateFrom, processDateTo);
    }
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> findMovimientosByProcessDateBetween(String processDateFrom, String processDateTo) {
        return reporteMaestroDatosMovimientosDao.findByProcessDateBetween(processDateFrom, processDateTo);
    }

    @Transactional(readOnly = true)
    public List<VwReporteConsolidadoMovimiento> reporteConsolidadoMovimientos() {
        return entityManager.createNamedQuery(VwReporteConsolidadoMovimiento.FIND_ALL, VwReporteConsolidadoMovimiento.class)
                .getResultList();
    }
    @Transactional(readOnly = true)
    public List<VwReporteConsolidadoSaldo> reporteConsolidadoSaldos() {
        return entityManager.createNamedQuery(VwReporteConsolidadoSaldo.FIND_ALL, VwReporteConsolidadoSaldo.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<IndicadoresBasePeriodoProjection> indicadoresBasePorPeriodo(String processDate) {
        return reporteMaestroDatosSaldoDao.indicadoresBasePorPeriodo(processDate);
    }

    @Transactional(readOnly = true)
    public FeeControlResponse populateNameAndSaldo(FeeControlResponse apiResponse, String processDate) {

        List<String> accountNumbers = apiResponse.getAccountsFeesValidated().stream().map(AccountFeeValidated::getAccountNumber).collect(Collectors.toList());
        var saldoDiario = reporteMaestroDatosSaldoDao.findSaldoDiarioByProcessDateAndAccountNoIn(processDate, accountNumbers);
        // Mapa accountNo → SaldoDiarioProjection
        Map<String, MaestroDatosSaldoDiarioProjection> saldoMap = saldoDiario.stream()
                .collect(Collectors.toMap(
                        MaestroDatosSaldoDiarioProjection::getAccountNumber,
                        Function.identity()
                ));

        // Relleno name y saldoDiario en cada AccountFeeValidated
        apiResponse.getAccountsFeesValidated().forEach(v -> {
            var p = saldoMap.get(v.getAccountNumber());
            if (p != null) {
                v.setName        (p.getClientName());
                v.setSaldoDiario(p.getSaldoDiario());
            }
        });
        return apiResponse;
    }
}
