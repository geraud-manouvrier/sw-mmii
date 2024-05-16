package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ControlDiarioReporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IControlDiarioReporteDao extends CrudRepository<ControlDiarioReporte, Long> {

    @Query(value = "SELECT * FROM public.fn_control_diario_reporte_listado(:_process_date_from, :_process_date_to, :_correlativo)", nativeQuery = true)
    public List<ControlDiarioReporte> reporteListadoDiario(@Param("_process_date_from") String processDateFrom, @Param("_process_date_to") String processDateTo, @Param("_correlativo") Integer correlativo);
    @Query(value = "SELECT * FROM public.fn_control_diario_reporte_listado(:_process_date_from, :_process_date_to, :_correlativo) WHERE id_segmentacion=:_id_segmentacion", nativeQuery = true)
    public List<ControlDiarioReporte> reporteListadoDiarioPorSegmento(@Param("_process_date_from") String processDateFrom, @Param("_process_date_to") String processDateTo, @Param("_correlativo") Integer correlativo, @Param("_id_segmentacion") Integer idSegmentacion);


    @Query(value = "SELECT * FROM public.fn_control_diario(:_process_date, :_username)", nativeQuery = true)
    public List<ControlDiarioReporte> ejecutaControlDiarioSegmentado(@Param("_process_date") String processDate, @Param("_username") String username);

}