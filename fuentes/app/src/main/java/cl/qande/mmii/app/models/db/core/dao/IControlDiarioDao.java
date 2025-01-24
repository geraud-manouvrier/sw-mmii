package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IControlDiarioDao extends JpaRepository<ControlDiario, Long> {

    @Query(value = "SELECT * FROM public.fn_control_diario(:_process_date, :_username)", nativeQuery = true)
    public List<ControlDiario> ejecutaControlDiario(@Param("_process_date") String processDate, @Param("_username") String username);

    @Query(value = "SELECT * FROM public.fn_control_diario_reporte_listado(:_process_date_from, :_process_date_to, :_correlativo)", nativeQuery = true)
    public List<ControlDiario> reporteListadoDiario(@Param("_process_date_from") String processDateFrom, @Param("_process_date_to") String processDateTo, @Param("_correlativo") Integer correlativo);

    @Query(value = "SELECT estado FROM public.jobs_estado WHERE id_job=:_id_job and id_proceso=:_id_proceso AND sub_id_proceso=:_sub_id_proceso", nativeQuery = true)
    public Integer resultadoJobs(@Param("_id_job") Integer idJob, @Param("_id_proceso") String idProceso, @Param("_sub_id_proceso") String subIdProceso);

    @Query(value = "SELECT id_proceso FROM public.jobs_estado WHERE id_job=:_id_job AND estado<>0 ORDER BY id_proceso DESC LIMIT :_limite", nativeQuery = true)
    public List<String> lastErrors(@Param("_id_job") Integer idJob, @Param("_limite") Integer limite);
}