package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.ProcesoSfl;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProcesoSflDao extends CrudRepository<ProcesoSfl, Long> {

    @Query(value = "SELECT * FROM pershing.fn_proceso_sfl(:_process_date, :_process_stamp, :_message)", nativeQuery = true)
    public ProcesoSfl procesaFtp(@Param("_process_date") String processDate, @Param("_process_stamp") String processStamp, @Param("_message") String message);

    @Query(value = "UPDATE pershing.proceso_sfl p SET info_log=info_log||'||'||:_message, last_step_timestamp=now(), id_estado_proceso_sfl=:_estado WHERE p.process_date=:_process_date AND p.process_stamp=:_process_stamp", nativeQuery = true)
    @Modifying
    @Transactional
    public void cambiaEstadoProceso(@Param("_process_date") String processDate, @Param("_process_stamp") String processStamp, @Param("_message") String message, @Param("_estado") int estado);

    public List<ProcesoSfl> findByProcessDateBetween (String processDateFrom, String processDateTo);

    @Query(value = "SELECT public.fn_es_habil_pershing_by_process_date(:_process_date) as es_habil", nativeQuery = true)
    public boolean esHabil(@Param("_process_date") String processDate);

}