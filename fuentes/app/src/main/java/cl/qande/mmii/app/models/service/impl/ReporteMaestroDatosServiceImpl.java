package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.api.MaestroCuentasApiDto;
import cl.qande.mmii.app.models.api.MaestroMovimientosApiDto;
import cl.qande.mmii.app.models.api.MaestroSaldosApiDto;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosMovimientosDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosClienteMapper;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosMovimientoMapper;
import cl.qande.mmii.app.util.helper.mapper.VwReporteMaestroDatosSaldoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReporteMaestroDatosServiceImpl implements IReporteMaestroDatosService {

    @Autowired
    private IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao;
    @Autowired
    private IReporteMaestroDatosMovimientosDao reporteMaestroDatosMovimientosDao;
    @Autowired
    private IReporteMaestroDatosSaldoDao reporteMaestroDatosSaldoDao;
    @Autowired
    private VwReporteMaestroDatosSaldoMapper vwReporteMaestroDatosSaldoMapper;
    @Autowired
    private VwReporteMaestroDatosMovimientoMapper vwReporteMaestroDatosMovimientoMapper;
    @Autowired
    private VwReporteMaestroDatosClienteMapper vwReporteMaestroDatosClienteMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MaestroCuentasApiDto> reporteMaestroCuentasApi(String processDate) {
        return vwReporteMaestroDatosClienteMapper.toDto(this.generaReporteClientes(processDate));

    }

    @Override
    @Transactional(readOnly = true)
    public List<MaestroSaldosApiDto> reporteMaestroSaldosApi(String processDate) {
        return vwReporteMaestroDatosSaldoMapper.toDto(this.generaReporteSaldos(processDate));

    }

    @Override
    @Transactional(readOnly = true)
    public List<MaestroMovimientosApiDto> reporteMaestroMovimientosApi(String processDate) {
        return vwReporteMaestroDatosMovimientoMapper.toDto(this.generaReporteMovimientos(processDate));

    }
    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate) {
        return reporteMaestroDatosSaldoDao.generaReporte(processDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> generaReporteClientes(String processDate) {
        return reporteMaestroDatosClientesDao.generaReporte(processDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientos(String processDate) {
        return reporteMaestroDatosMovimientosDao.generaReporte(processDate);
    }

    @Override
    @Transactional
    public void materializaDatosCliente(String processDate) {
        reporteMaestroDatosClientesDao.materializaDatosClientePershing(processDate);
    }
    @Override
    @Transactional
    public void materializaDatosMovimiento(String processDate) {
        reporteMaestroDatosMovimientosDao.materializaDatosMovimientosPershing(processDate);
    }
    @Override
    @Transactional
    public void materializaDatosSaldo(String processDate) {
        reporteMaestroDatosSaldoDao.materializaDatosSaldosPershing(processDate);
    }

}
