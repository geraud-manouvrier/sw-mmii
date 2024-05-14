package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegBDao extends CrudRepository<StageIscaRegB, Long> {
    List<StageIscaRegB> findByProcessDate(String processDate);
}