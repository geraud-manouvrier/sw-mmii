package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegL;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegLDao extends CrudRepository<StageIscaRegL, Long> {
    List<StageIscaRegL> findByProcessDate(String processDate);
}