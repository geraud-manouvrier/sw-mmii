package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.TipoServicio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ITipoServicioDao extends CrudRepository<TipoServicio, String> {
    List<TipoServicio> findAll();
    Optional<TipoServicio> findById(String id);
}