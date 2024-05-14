package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegN;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegNDao extends CrudRepository<StageIscaRegN, Long> {
    List<StageIscaRegN> findByProcessDate(String processDate);
}