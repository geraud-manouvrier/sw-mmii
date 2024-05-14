package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegODao extends CrudRepository<StageIscaRegO, Long> {
    List<StageIscaRegO> findByProcessDate(String processDate);
}