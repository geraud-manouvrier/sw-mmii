package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosSaldoDao extends CrudRepository<VwReporteMaestroDatosSaldo, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_saldos(:_process_date, :_variante) WHERE NOT public.fn_excluir_cuenta_de_maestro(custodian, account_no)", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> generaReporte(@Param("_process_date") String processDate, @Param("_variante") String varianteReporte);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_saldos(:_process_date, :_variante) WHERE NOT public.fn_excluir_cuenta_de_maestro_paises(custodian, account_no)", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> generaReportePaises(@Param("_process_date") String processDate, @Param("_variante") String varianteReporte);

    public List<VwReporteMaestroDatosSaldo> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'SLD', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosSaldosPershing(@Param("_process_date") String processDate);
    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'SLD', 'STONEX')", nativeQuery = true)
    public Long materializaDatosSaldosStonex(@Param("_process_date") String processDate);
}