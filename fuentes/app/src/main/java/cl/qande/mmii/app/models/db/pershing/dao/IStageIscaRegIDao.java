package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegI;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegIDao extends CrudRepository<StageIscaRegI, Long> {
    List<StageIscaRegI> findByProcessDate(String processDate);
}