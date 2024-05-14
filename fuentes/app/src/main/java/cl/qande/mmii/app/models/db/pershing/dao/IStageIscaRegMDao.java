package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegM;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegMDao extends CrudRepository<StageIscaRegM, Long> {
    List<StageIscaRegM> findByProcessDate(String processDate);
}