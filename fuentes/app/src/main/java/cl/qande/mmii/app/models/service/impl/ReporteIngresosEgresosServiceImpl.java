package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.*;
import cl.qande.mmii.app.models.db.core.entity.*;
import cl.qande.mmii.app.models.service.IReporteIngresosEgresosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReporteIngresosEgresosServiceImpl implements IReporteIngresosEgresosService {

    @Autowired
    private IIngresosEgresosDao ingresosEgresosDao;
    @Autowired
    private IReporteIngresosEgresosMensualDao reporteIngresosEgresosMensualDao;
    @Autowired
    private IReporteIngresosEgresosMensualTotalDao reporteIngresosEgresosMensualTotalDao;
    @Autowired
    private IReporteIngresosEgresosDiarioDao reporteIngresosEgresosDiarioDao;
    @Autowired
    private IReporteIngresosEgresosDiarioTotalDao reporteIngresosEgresosDiarioTotalDao;
    @Autowired
    private IOficinaStonexDao oficinaStonexDao;
    @Autowired
    private CalendarioHelper calendarioHelper;

    @Override
    @Transactional
    public List<IngresosEgresos>  calculaReportePorDia(String strCalcDate) {
        return ingresosEgresosDao.calculaReporteIngresosEgresos(strCalcDate);
    }
    @Override
    @Transactional(readOnly = true)
    public List<IngresosEgresos> reporteDiario(String custodio, Date dateFrom, Date dateTo) {
        return ingresosEgresosDao.reporteDiarioByCustodioAndRangeDate(custodio, dateFrom, dateTo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VwReporteIngresosEgresosMensual> reporteMensual(String custodio, Date dateTo) {
        int mes    = calendarioHelper.getDatePart(dateTo, Calendar.MONTH);
        int anio    = calendarioHelper.getDatePart(dateTo, Calendar.YEAR);

        return reporteIngresosEgresosMensualDao.reporteMensualByCustodioAndPeriodo(custodio, anio, mes);
    }
    @Override
    @Transactional(readOnly = true)
    public List<VwReporteIngresosEgresosDiario> reporteDiario(String custodio, Date dateTo) {
        int mes    = calendarioHelper.getDatePart(dateTo, Calendar.MONTH);
        int anio    = calendarioHelper.getDatePart(dateTo, Calendar.YEAR);

        return reporteIngresosEgresosDiarioDao.reporteDiarioByCustodioAndFecha(custodio, anio, mes);
    }

    @Override
    @Transactional(readOnly = true)
    public String[] listaOficinas(String custodio, Date dateTo) {
        int mes    = calendarioHelper.getDatePart(dateTo, Calendar.MONTH);
        int anio    = calendarioHelper.getDatePart(dateTo, Calendar.YEAR);

        return reporteIngresosEgresosMensualDao.listaOficinasPorPeriodo(custodio, anio, mes);
    }
    @Override
    @Transactional(readOnly = true)
    public VwReporteIngresosEgresosDiarioTotal totalReporteDiarioByCustodioAndPeriodo(String custodio, Integer anio, Integer mes, Integer dia) {

        return reporteIngresosEgresosDiarioTotalDao.totalReporteDiarioByCustodioAndFecha(custodio, calendarioHelper.makeDateFromParts(anio, mes, dia));
    }
    @Override
    @Transactional(readOnly = true)
    public VwReporteIngresosEgresosMensualTotal totalReporteMensualByCustodioAndPeriodo(String custodio, Integer anio, Integer mes) {
        return reporteIngresosEgresosMensualTotalDao.totalReporteMensualByCustodioAndPeriodo(custodio, anio, mes);
    }

    @Override
    @Transactional(readOnly = true)
    public String nombreOficina(String idOficina) {
        var listaOficinas   = this.getOficina(idOficina);
        if (listaOficinas   == null) {
            return null;
        }
        return listaOficinas.getNombre();
    }
    @Override
    @Transactional(readOnly = true)
    public OficinaStonex getOficina(String idOficina) {
        return oficinaStonexDao.findById(idOficina).orElse(null);
    }
}
