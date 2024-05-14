package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegC;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegCDao extends CrudRepository<StageIscaRegC, Long> {
    List<StageIscaRegC> findByProcessDate(String processDate);
}