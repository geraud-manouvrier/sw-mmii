package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIsrcRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIsrcRegADao extends CrudRepository<StageIsrcRegA, Long> {
    List<StageIsrcRegA> findByProcessDate(String processDate);
}