package cl.qande.mmii.app.models.db.stonex.dao;

import cl.qande.mmii.app.models.db.stonex.entity.ProcesoFtpStonex;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProcesoFtpStonexDao extends CrudRepository<ProcesoFtpStonex, Long> {

    @Query(value = "SELECT * FROM stonex.fn_proceso_ftp(:_process_date, :_process_stamp, :_message)", nativeQuery = true)
    public ProcesoFtpStonex procesaFtp(@Param("_process_date") String processDate, @Param("_process_stamp") String processStamp, @Param("_message") String message);

    @Query(value = "UPDATE stonex.proceso_ftp p SET info_log=info_log||'||'||:_message, last_step_timestamp=now(), id_estado_proceso_ftp=:_estado WHERE p.process_date=:_process_date AND p.process_stamp=:_process_stamp", nativeQuery = true)
    @Modifying
    @Transactional
    public void cambiaEstadoProceso(@Param("_process_date") String processDate, @Param("_process_stamp") String processStamp, @Param("_message") String message, @Param("_estado") int estado);

    public List<ProcesoFtpStonex> findByProcessDateBetween (String processDateFrom, String processDateTo);

    @Query(value = "SELECT public.fn_es_habil_stonex_by_process_date(:_process_date) as es_habil", nativeQuery = true)
    public boolean esHabil(@Param("_process_date") String processDate);
}
