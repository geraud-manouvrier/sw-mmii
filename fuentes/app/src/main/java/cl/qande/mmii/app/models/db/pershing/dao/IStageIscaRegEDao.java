package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegE;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegEDao extends CrudRepository<StageIscaRegE, Long> {
    List<StageIscaRegE> findByProcessDate(String processDate);
}