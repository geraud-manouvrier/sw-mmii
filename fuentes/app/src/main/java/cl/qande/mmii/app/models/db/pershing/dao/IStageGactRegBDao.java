package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGactRegB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGactRegBDao extends CrudRepository<StageGactRegB, Long> {
    List<StageGactRegB> findByProcessDate(String processDate);
}