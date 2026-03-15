package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosClientesDao extends CrudRepository<VwReporteMaestroDatosCliente, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_clientes(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosCliente> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosCliente> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT *" +
            "FROM public.vw_reporte_maestro_datos_clientes vw_cte " +
            "where vw_cte.process_date=:_process_date " +
            "and vw_cte.client_id=:_client_id " +
            "and vw_cte.account_no=COALESCE(:_account_no, vw_cte.account_no) " +
            "ORDER BY vw_cte.account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosCliente> datosCliente(@Param("_process_date") String processDate, @Param("_client_id") String clientId, @Param("_account_no") String accountNo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'CTA', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosClientePershing(@Param("_process_date") String processDate);


}