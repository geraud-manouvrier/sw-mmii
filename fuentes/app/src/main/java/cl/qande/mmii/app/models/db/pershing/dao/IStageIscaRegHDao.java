package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegH;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegHDao extends CrudRepository<StageIscaRegH, Long> {
    List<StageIscaRegH> findByProcessDate(String processDate);
}