package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegG;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegGDao extends CrudRepository<StageIscaRegG, Long> {
    List<StageIscaRegG> findByProcessDate(String processDate);
}