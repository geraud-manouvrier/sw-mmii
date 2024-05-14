package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegD;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegDDao extends CrudRepository<StageIscaRegD, Long> {
    List<StageIscaRegD> findByProcessDate(String processDate);
}