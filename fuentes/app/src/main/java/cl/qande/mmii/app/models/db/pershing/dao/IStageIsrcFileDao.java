package cl.qande.mmii.app.models.db.pershing.dao;

import cl.qande.mmii.app.models.db.pershing.entity.StageIsrcFile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IStageIsrcFileDao extends CrudRepository<StageIsrcFile, Long> {
    @Transactional
    @Modifying
    @Query(value = "CALL stage_pershing.pa_parse_isrc(:_id_proceso)", nativeQuery = true)
    public void parseSfl(@Param("_id_proceso") Long idProceso);
    @Transactional
    @Modifying
    @Query(value = "CALL pershing.pa_procesa_isrc(:_id_proceso)", nativeQuery = true)
    public void procesaSfl(@Param("_id_proceso") Long idProceso);
}