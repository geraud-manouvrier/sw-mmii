package cl.qande.mmii.app.models.db.stonex.dao;

import cl.qande.mmii.app.models.db.stonex.entity.StagePos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IStagePosDao extends CrudRepository<StagePos,Long> {

    @Transactional
    @Modifying
    @Query(value = "CALL stonex.pa_procesa_pos(:_process_stamp)", nativeQuery = true)
    public void procesaSchema(@Param("_process_stamp") String processStamp);

}
