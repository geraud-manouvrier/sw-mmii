package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosSaldoDao extends CrudRepository<VwReporteMaestroDatosSaldo, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_saldos(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosSaldo> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'SLD', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosSaldosPershing(@Param("_process_date") String processDate);
}