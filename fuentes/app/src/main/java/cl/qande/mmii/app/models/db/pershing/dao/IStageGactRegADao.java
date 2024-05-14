package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGactRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGactRegADao extends CrudRepository<StageGactRegA, Long> {
    List<StageGactRegA> findByProcessDate(String processDate);
}