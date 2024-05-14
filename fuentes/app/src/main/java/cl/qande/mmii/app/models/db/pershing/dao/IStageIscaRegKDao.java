package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIscaRegK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageIscaRegKDao extends CrudRepository<StageIscaRegK, Long> {
    List<StageIscaRegK> findByProcessDate(String processDate);
}