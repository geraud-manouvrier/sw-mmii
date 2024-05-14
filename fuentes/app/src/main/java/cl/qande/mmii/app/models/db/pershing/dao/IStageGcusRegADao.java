package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGcusRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGcusRegADao extends CrudRepository<StageGcusRegA, Long> {
    List<StageGcusRegA> findByProcessDate(String processDate);
}