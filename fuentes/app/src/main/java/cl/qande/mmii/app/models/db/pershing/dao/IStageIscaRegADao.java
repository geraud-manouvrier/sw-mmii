package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegADao extends CrudRepository<StageIscaRegA, Long> {
    List<StageIscaRegA> findByProcessDate(String processDate);
}