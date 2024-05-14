package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegADao extends CrudRepository<StageAcctRegA, Long> {
    List<StageAcctRegA> findByProcessDate(String processDate);
}