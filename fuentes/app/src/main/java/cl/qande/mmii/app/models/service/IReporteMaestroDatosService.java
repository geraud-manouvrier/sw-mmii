package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IReporteMaestroDatosService {


    @Transactional(readOnly = true)
    List<VwReporteMaestroDatosSaldo> generaReporteSaldosPaises(String processDate, String varianteReporte);

    public List<VwReporteMaestroDatosCliente> generaReporteClientes(String processDate, String varianteReporte);

    @Transactional(readOnly = true)
    List<VwReporteMaestroDatosCliente> generaReporteClientesPaises(String processDate, String varianteReporte);

    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientos(String processDate, Integer aplicaFlujoNeto, String varianteReporte);
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate, String varianteReporte);

    @Transactional(readOnly = true)
    List<VwReporteMaestroDatosMovimiento> generaReporteMovimientosPaises(String processDate, Integer aplicaFlujoNeto, String varianteReporte);

    public void materializaDatosCliente(String processDate);
    public void materializaDatosMovimiento(String processDate);
    public void materializaDatosSaldo(String processDate);

    @Transactional(readOnly = true)
    List<String> listaVariantes();

    @Transactional(readOnly = true)
    String sufijoArchivo(String variante);
}
