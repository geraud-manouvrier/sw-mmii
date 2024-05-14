package cl.qande.mmii.app.models.db.stonex.dao;

import cl.qande.mmii.app.models.db.stonex.entity.StageActSum;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IStageActSumDao extends CrudRepository<StageActSum,Long> {

    @Transactional
    @Modifying
    @Query(value = "CALL stonex.pa_procesa_act_sum(:_process_stamp)", nativeQuery = true)
    public void procesaSchema(@Param("_process_stamp") String processStamp);

}
