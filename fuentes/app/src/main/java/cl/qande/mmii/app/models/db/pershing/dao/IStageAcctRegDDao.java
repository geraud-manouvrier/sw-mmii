package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegD;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegDDao extends CrudRepository<StageAcctRegD, Long> {
    List<StageAcctRegD> findByProcessDate(String processDate);
}