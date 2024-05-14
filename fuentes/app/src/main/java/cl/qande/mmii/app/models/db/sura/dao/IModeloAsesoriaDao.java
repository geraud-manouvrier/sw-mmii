package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.ModeloAsesoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IModeloAsesoriaDao extends CrudRepository<ModeloAsesoria, String> {
    List<ModeloAsesoria> findAll();
    Optional<ModeloAsesoria> findById(String id);
}