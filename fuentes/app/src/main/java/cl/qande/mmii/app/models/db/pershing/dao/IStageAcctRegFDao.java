package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegF;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegFDao extends CrudRepository<StageAcctRegF, Long> {
    List<StageAcctRegF> findByProcessDate(String processDate);
}