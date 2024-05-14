package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegBDao extends CrudRepository<StageAcctRegB, Long> {
    List<StageAcctRegB> findByProcessDate(String processDate);
}