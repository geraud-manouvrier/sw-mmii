package cl.qande.mmii.app.models.db.rep_inv;

import cl.qande.mmii.app.config.datasources.AuxiliarDataSourceConfiguration;
import cl.qande.mmii.app.models.db.rep_inv.dao.IConsolidadoAgregadoN1Dao;
import cl.qande.mmii.app.models.db.rep_inv.dao.IConsolidadoAgregadoN2Dao;
import cl.qande.mmii.app.models.db.rep_inv.dao.IRentabilidadCalculadaDao;
import cl.qande.mmii.app.models.db.rep_inv.dao.IVwBaseConsolidadoDao;
import cl.qande.mmii.app.models.db.rep_inv.entity.*;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReporteInversionesService {
    private final IRentabilidadCalculadaDao rentabilidadCalculadaDao;
    private final IVwBaseConsolidadoDao vwBaseConsolidadoDao;
    private final IConsolidadoAgregadoN1Dao consolidadoAgregadoN1Dao;
    private final IConsolidadoAgregadoN2Dao consolidadoAgregadoN2Dao;
    private final EntityManager entityManager;

    @Autowired
    public ReporteInversionesService(IRentabilidadCalculadaDao rentabilidadCalculadaDao, IVwBaseConsolidadoDao vwBaseConsolidadoDao, IConsolidadoAgregadoN1Dao consolidadoAgregadoN1Dao, IConsolidadoAgregadoN2Dao consolidadoAgregadoN2Dao, @Qualifier(AuxiliarDataSourceConfiguration.ENTITY_MANAGER) EntityManager entityManager) {

        this.rentabilidadCalculadaDao = rentabilidadCalculadaDao;
        this.vwBaseConsolidadoDao = vwBaseConsolidadoDao;
        this.consolidadoAgregadoN1Dao = consolidadoAgregadoN1Dao;
        this.consolidadoAgregadoN2Dao = consolidadoAgregadoN2Dao;
        this.entityManager = entityManager;
    }

    @Transactional
    //Proceso diario que calcula métricas necesarias
    public void calculoDiario(String processDateFrom) {
        rentabilidadCalculadaDao.calculoDiario(processDateFrom);
    }


    @Transactional
    public List<ResultadoControl> resultadoControl(String processDate, Boolean execMonthly, Boolean execDaily) {
        if (execMonthly==null)
            execMonthly=Boolean.FALSE;
        var salida = entityManager.createNamedQuery(ResultadoControl.FIND_BY_PROCESS_DATE, ResultadoControl.class)
                .setParameter("_process_date", processDate)
                .setParameter("_exec_monthly", execMonthly)
                .setParameter("_exec_daily", execDaily)
                .getResultList();
        CustomLog.getInstance().info("Control Retornos generado: ["+salida.size()+"] registros", true);
        return salida;
    }
    @Transactional(readOnly = true)
    //Retorna primer nivel de cálculo de datos consolidados
    public List<VwBaseConsolidado> listaBaseConsolidadaPorClienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber) {
        if (accountNumber != null && accountNumber.isBlank()) {
            accountNumber = null;
        }
        return vwBaseConsolidadoDao.listaBaseConsolidadaPorClienteCuenta(fechaDesde, fechaHasta, clientId, accountNumber);
    }


    @Transactional(readOnly = true)
    //Retorna segundo nivel de cálculo de datos consolidados: agregados
    public List<ConsolidadoAgregadoN1> listaConsolidadoAgregadoPorcliente(String fechaDesde, String fechaHasta, String clientId) {
        return consolidadoAgregadoN1Dao.listaConsolidadoAgregado(fechaDesde, fechaHasta, clientId);
    }

    @Transactional(readOnly = true)
    //Retorna segundo nivel de cálculo de datos consolidados: agregados
    public List<ConsolidadoAgregadoN2> listaConsolidadoAgregadoPorclienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber) {
        if (accountNumber != null && accountNumber.isBlank()) {
            accountNumber = null;
        }
        return consolidadoAgregadoN2Dao.listaConsolidadoAgregado(fechaDesde, fechaHasta, clientId, accountNumber);
    }

    @Transactional
    //Calcula y retorna rentabilidades a mostrar
    public List<RentabilidadCalculada> calculaRentabilidad(String agregadorN1, String agregadorN2, String agregadorN3, String agregadorN4, String startProcessDate, String endProcessDate, boolean todosNiveles) {
        if (agregadorN2 != null && agregadorN2.isBlank()) {
            agregadorN2 = null;
        }
        if (agregadorN3 != null && agregadorN3.isBlank()) {
            agregadorN3 = null;
        }
        if (agregadorN4 != null && agregadorN4.isBlank()) {
            agregadorN4 = null;
        }
        return rentabilidadCalculadaDao.calculaRentabilidad(agregadorN1, agregadorN2, agregadorN3, agregadorN4, startProcessDate, endProcessDate, todosNiveles);
    }

}
