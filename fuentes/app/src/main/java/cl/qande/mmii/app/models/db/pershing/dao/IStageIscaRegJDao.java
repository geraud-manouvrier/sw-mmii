package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegJ;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegJDao extends CrudRepository<StageIscaRegJ, Long> {
    List<StageIscaRegJ> findByProcessDate(String processDate);
}