package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageGmonRegB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStageGmonRegBDao extends CrudRepository<StageGmonRegB, Long> {
    List<StageGmonRegB> findByProcessDate(String processDate);
}