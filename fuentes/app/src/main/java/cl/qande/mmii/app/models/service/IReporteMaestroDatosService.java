package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IReporteMaestroDatosService {


    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosCliente> generaReporteClientes(String processDate);
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporteMovimientos(String processDate);
    @Transactional(readOnly = true)
    public List<VwReporteMaestroDatosSaldo> generaReporteSaldos(String processDate);

    public void materializaDatosCliente(String processDate);
    public void materializaDatosMovimiento(String processDate);
    public void materializaDatosSaldo(String processDate);
}
