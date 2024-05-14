package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.RectificacionSaldosNoInformado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface IRectificacionSaldosNoInformadoDao extends CrudRepository<RectificacionSaldosNoInformado, Long> {

    public List<RectificacionSaldosNoInformado> findByIdEstadoRectificacionGreaterThan(Integer idEstado);
    public List<RectificacionSaldosNoInformado> findByIdEstadoRectificacionLessThan(Integer idEstado);
    public List<RectificacionSaldosNoInformado> findByIdEstadoRectificacionEquals(Integer idEstado);

    @Transactional (readOnly = true)
    @Query("select r from RectificacionSaldosNoInformado r where r.idEstadoRectificacion = :idEstado and r.processDate = coalesce(:optionalProcessDate, r.processDate)")
    public List<RectificacionSaldosNoInformado> findByIdEstadoAndOptionalProcessDate(@Param("idEstado") Integer idEstado, @Param("optionalProcessDate") String optionalProcessDate);

    @Modifying
    @Transactional
    @Query("update RectificacionSaldosNoInformado r set r.idEstadoRectificacion = :nuevoEstado, r.modificadorUser=:usuarioModificador, r.modificadorTimestamp=:timestampModificador where r.idEstadoRectificacion = :antiguoEstado")
    public int updateEstadoRectificacionByIdQuery(@Param("nuevoEstado") Integer nuevoEstado, @Param("antiguoEstado") Integer antiguoEstado, @Param("usuarioModificador") String usuarioModificador, @Param("timestampModificador") Instant timestampModificador);
    @Modifying
    @Transactional
    @Query("update RectificacionSaldosNoInformado r set r.idEstadoRectificacion = :nuevoEstado, r.modificadorUser=:usuarioModificador, r.modificadorTimestamp=:timestampModificador where r.id = :idRectificacion")
    public int updateEstadoRectificacionByIdQuery(@Param("idRectificacion") Long idRectificacion, @Param("nuevoEstado") Integer nuevoEstado, @Param("usuarioModificador") String usuarioModificador, @Param("timestampModificador") Instant timestampModificador);
    @Modifying
    @Transactional
    @Query("update RectificacionSaldosNoInformado r set r.idEstadoRectificacion = :nuevoEstado, r.modificadorUser=:usuarioModificador, r.modificadorTimestamp=:timestampModificador where r.id = :idRectificacion AND r.idEstadoRectificacion = :antiguoEstado")
    public int updateEstadoRectificacionByIdQuery(@Param("idRectificacion") Long idRectificacion, @Param("nuevoEstado") Integer nuevoEstado, @Param("antiguoEstado") Integer antiguoEstado, @Param("usuarioModificador") String usuarioModificador, @Param("timestampModificador") Instant timestampModificador);

}