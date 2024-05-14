package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegW;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegWDao extends CrudRepository<StageAcctRegW, Long> {
    List<StageAcctRegW> findByProcessDate(String processDate);
}