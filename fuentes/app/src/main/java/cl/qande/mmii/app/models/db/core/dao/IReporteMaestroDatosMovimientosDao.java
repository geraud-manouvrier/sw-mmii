package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosMovimientosDao extends CrudRepository<VwReporteMaestroDatosMovimiento, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_movimientos(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosMovimiento> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT *" +
            "FROM public.vw_reporte_maestro_datos_movimientos vw_mov " +
            "where vw_mov.process_date>=:_start_process_date AND vw_mov.process_date<=:_end_process_date " +
            "and vw_mov.client_id=:_client_id " +
            "and vw_mov.account_no=COALESCE(:_account_no, vw_mov.account_no) " +
            "ORDER BY vw_mov.account_no, vw_mov.cusip", nativeQuery = true)
    public List<VwReporteMaestroDatosMovimiento> movimientosCliente(@Param("_start_process_date") String startProcessDate, @Param("_end_process_date") String endProcessDate, @Param("_client_id") String clientId, @Param("_account_no") String accountNo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'MOV', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosMovimientosPershing(@Param("_process_date") String processDate);
}