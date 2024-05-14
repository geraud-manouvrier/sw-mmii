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
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate, String varianteReporte) {
        return reporteMaestroDatosSaldoDao.generaReporte(processDate, varianteReporte);
    }
    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldosPaises(String processDate, String varianteReporte) {
        return reporteMaestroDatosSaldoDao.generaReportePaises(processDate, varianteReporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> generaReporteClientes(String processDate, String varianteReporte) {
        return reporteMaestroDatosClientesDao.generaReporte(processDate, varianteReporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> generaReporteClientesPaises(String processDate, String varianteReporte) {
        return reporteMaestroDatosClientesDao.generaReportePaises(processDate, varianteReporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientos(String processDate, Integer aplicaFlujoNeto, String varianteReporte) {
        return reporteMaestroDatosMovimientosDao.generaReporte(processDate, aplicaFlujoNeto, varianteReporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientosPaises(String processDate, Integer aplicaFlujoNeto, String varianteReporte) {
        return reporteMaestroDatosMovimientosDao.generaReportePaises(processDate, aplicaFlujoNeto, varianteReporte);
    }

    @Override
    @Transactional
    public void materializaDatosCliente(String processDate) {
        reporteMaestroDatosClientesDao.materializaDatosClientePershing(processDate);
        reporteMaestroDatosClientesDao.materializaDatosClienteStonex(processDate);
    }
    @Override
    @Transactional
    public void materializaDatosMovimiento(String processDate) {
        reporteMaestroDatosMovimientosDao.materializaDatosMovimientosPershing(processDate);
        reporteMaestroDatosMovimientosDao.materializaDatosMovimientosStonex(processDate);
    }
    @Override
    @Transactional
    public void materializaDatosSaldo(String processDate) {
        reporteMaestroDatosSaldoDao.materializaDatosSaldosPershing(processDate);
        reporteMaestroDatosSaldoDao.materializaDatosSaldosStonex(processDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> listaVariantes() {
        return reporteMaestroDatosClientesDao.listaVariantes();
    }

    @Override
    @Transactional(readOnly = true)
    public String sufijoArchivo(String variante) {
        return reporteMaestroDatosClientesDao.sufijoArchivo(variante);
    }
}
