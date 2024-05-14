package cl.qande.mmii.app.models.db.stonex.dao;

import cl.qande.mmii.app.models.db.stonex.entity.StageSecOsi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IStageSecOsiDao extends CrudRepository<StageSecOsi, Long> {

    @Transactional
    @Modifying
    @Query(value = "CALL stonex.pa_procesa_sec_osi(:_process_stamp)", nativeQuery = true)
    public void procesaSchema(@Param("_process_stamp") String processStamp);
}