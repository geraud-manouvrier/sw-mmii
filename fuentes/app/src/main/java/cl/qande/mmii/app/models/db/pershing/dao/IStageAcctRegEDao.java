package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegE;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegEDao extends CrudRepository<StageAcctRegE, Long> {
    List<StageAcctRegE> findByProcessDate(String processDate);
}