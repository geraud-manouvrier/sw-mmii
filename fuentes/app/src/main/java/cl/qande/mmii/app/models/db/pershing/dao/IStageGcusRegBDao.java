package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGcusRegB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGcusRegBDao extends CrudRepository<StageGcusRegB, Long> {
    List<StageGcusRegB> findByProcessDate(String processDate);
}