package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosMovimientosDao;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosSaldoDao;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
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
