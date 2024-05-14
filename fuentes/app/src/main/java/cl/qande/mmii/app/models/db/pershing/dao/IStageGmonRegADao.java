package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGmonRegA;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGmonRegADao extends CrudRepository<StageGmonRegA, Long> {
    List<StageGmonRegA> findByProcessDate(String processDate);
}