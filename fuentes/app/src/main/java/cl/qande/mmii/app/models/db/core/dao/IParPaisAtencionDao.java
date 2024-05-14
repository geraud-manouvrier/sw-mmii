package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.ParPaisAtencion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParPaisAtencionDao extends CrudRepository<ParPaisAtencion, Integer> {

    @Query("select p from ParPaisAtencion p order by p.glosa")
    public List<ParPaisAtencion> listaPaisesOrdenada();
}