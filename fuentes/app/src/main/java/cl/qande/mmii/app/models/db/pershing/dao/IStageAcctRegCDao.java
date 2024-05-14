package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageAcctRegC;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageAcctRegCDao extends CrudRepository<StageAcctRegC, Long> {
    List<StageAcctRegC> findByProcessDate(String processDate);
}