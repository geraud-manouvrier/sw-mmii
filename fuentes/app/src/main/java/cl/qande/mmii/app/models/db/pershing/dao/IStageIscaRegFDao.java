package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegF;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegFDao extends CrudRepository<StageIscaRegF, Long> {
    List<StageIscaRegF> findByProcessDate(String processDate);
}