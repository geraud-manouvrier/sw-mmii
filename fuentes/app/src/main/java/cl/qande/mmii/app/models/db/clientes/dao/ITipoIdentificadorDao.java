package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.TipoIdentificador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ITipoIdentificadorDao extends CrudRepository<TipoIdentificador, Integer> {

    public List<TipoIdentificador> findAllByOrderByTipoIdentificadorAsc();

    public Optional<TipoIdentificador> findById(Integer id);
}