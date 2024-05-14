package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.Parametro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParametroDao extends CrudRepository<Parametro,Long> {

    public Parametro findByIdParametroAndAndSubIdParametro(String idParametro, String subIdParametro);
    public List<Parametro> findByIdParametro(String idParametro);
    public Parametro findByIdParametroAndSubIdParametro(String idParametro, String subIdParametro);
}
