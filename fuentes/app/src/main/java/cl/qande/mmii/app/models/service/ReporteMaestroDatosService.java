package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.datasources.CoreDataSourceConfiguration;
import cl.qande.mmii.app.models.api.MaestroCuentasApiDto;
import cl.qande.mmii.app.models.api.MaestroMovimientosApiDto;
import cl.qande.mmii.app.models.api.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosMovimientosDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.core.entity.*;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosClienteMapper;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosMovimientoMapper;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosSaldoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReporteMaestroDatosService {


    private final IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao;
    private final IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao;
    private final IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao;
    private final VwReporteMaestroDatosSaldoMapper vwReporteMaestroDatosSaldoMapper;
    private final VwReporteMaestroDatosMovimientoMapper vwReporteMaestroDatosMovimientoMapper;
    private final VwReporteMaestroDatosClienteMapper vwReporteMaestroDatosClienteMapper;
    private final EntityManager entityManager;

    @Autowired
    public ReporteMaestroDatosService(IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao, IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao, IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao, VwReporteMaestroDatosSaldoMapper vwReporteMaestroDatosSaldoMapper, VwReporteMaestroDatosMovimientoMapper vwReporteMaestroDatosMovimientoMapper, VwReporteMaestroDatosClienteMapper vwReporteMaestroDatosClienteMapper, @Qualifier(CoreDataSourceConfiguration.ENTITY_MANAGER) EntityManager entityManager) {
        this.reporteMaestroDatosClientesDao = reporteMaestroDatosClientesDao;
        this.reporteMaestroDatosMovimientosDao = reporteMaestroDatosMovimientosDao;
        this.reporteMaestroDatosSaldoDao = reporteMaestroDatosSaldoDao;
        this.vwReporteMaestroDatosSaldoMapper = vwReporteMaestroDatosSaldoMapper;
        this.vwReporteMaestroDatosMovimientoMapper = vwReporteMaestroDatosMovimientoMapper;
        this.vwReporteMaestroDatosClienteMapper = vwReporteMaestroDatosClienteMapper;
        this.entityManager = entityManager;
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
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate) {
        return reporteMaestroDatosSaldoDao.generaReporte(processDate);
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
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> findClientesByProcessDateBetween(String processDateFrom, String processDateTo) {
        return reporteMaestroDatosClientesDao.findByProcessDateBetween(processDateFrom, processDateTo);
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
}
