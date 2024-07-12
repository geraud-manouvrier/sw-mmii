package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {
    List<Cuenta> findAll();

    Optional<Cuenta> findById(Integer integer);

    List<Cuenta> findByIdCliente(Integer idCliente);
    List<Cuenta> findByIdCuentaCustodio(String idCuentaCustodio);

    Cuenta save(Cuenta cliente);
}