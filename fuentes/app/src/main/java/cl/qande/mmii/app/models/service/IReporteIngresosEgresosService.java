package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface IReporteIngresosEgresosService {

    @Transactional
    public List<IngresosEgresos>  calculaReportePorDia(String strCalcDate);
    @Transactional(readOnly = true)
    public List<IngresosEgresos>  reporteDiario(String custodio, Date dateFrom, Date dateTo);
    @Transactional(readOnly = true)
    public List<VwReporteIngresosEgresosMensual>  reporteMensual(String custodio, Date dateTo);

    @Transactional(readOnly = true)
    List<VwReporteIngresosEgresosDiario> reporteDiario(String custodio, Date dateTo);

    @Transactional(readOnly = true)
    public String[] listaOficinas(String custodio, Date dateTo);

    @Transactional(readOnly = true)
    VwReporteIngresosEgresosDiarioTotal totalReporteDiarioByCustodioAndPeriodo(String custodio, Integer anio, Integer mes, Integer dia);

    @Transactional(readOnly = true)
    public VwReporteIngresosEgresosMensualTotal totalReporteMensualByCustodioAndPeriodo(String custodio, Integer anio, Integer mes);

    @Transactional(readOnly = true)
    public String nombreOficina(String idOficina);

    @Transactional(readOnly = true)
    public OficinaStonex getOficina(String idOficina);
}
