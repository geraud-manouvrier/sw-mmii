package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosRelacionado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosRelacionadoDao extends JpaRepository<VwReporteMaestroDatosRelacionado, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_relacionados(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosRelacionado> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosRelacionado> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'REL', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosRelacionadoPershing(@Param("_process_date") String processDate);
}