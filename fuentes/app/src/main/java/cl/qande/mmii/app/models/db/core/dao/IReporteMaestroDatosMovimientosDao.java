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

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'MOV', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosMovimientosPershing(@Param("_process_date") String processDate);
}