package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.Custodio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICustodioDao extends CrudRepository<Custodio, String> {
    List<Custodio> findAll();
    Optional<Custodio> findById(String id);
}