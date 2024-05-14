package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosMovimientosDao extends CrudRepository<VwReporteMaestroDatosMovimiento, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_movimientos(:_process_date, :_variante) WHERE (aplica_flujo_neto=:_aplica_flujo_neto OR :_aplica_flujo_neto IS NULL) AND NOT public.fn_excluir_cuenta_de_maestro(custodian, account_no)", nativeQuery = true)
    public List<VwReporteMaestroDatosMovimiento> generaReporte(@Param("_process_date") String processDate, @Param("_aplica_flujo_neto") Integer aplicaFlujoNeto, @Param("_variante") String varianteReporte);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_movimientos(:_process_date, :_variante) WHERE (aplica_flujo_neto=:_aplica_flujo_neto OR :_aplica_flujo_neto IS NULL) AND NOT public.fn_excluir_cuenta_de_maestro_paises(custodian, account_no)", nativeQuery = true)
    public List<VwReporteMaestroDatosMovimiento> generaReportePaises(@Param("_process_date") String processDate, @Param("_aplica_flujo_neto") Integer aplicaFlujoNeto, @Param("_variante") String varianteReporte);

    public List<VwReporteMaestroDatosMovimiento> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'MOV', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosMovimientosPershing(@Param("_process_date") String processDate);
    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'MOV', 'STONEX')", nativeQuery = true)
    public Long materializaDatosMovimientosStonex(@Param("_process_date") String processDate);
}