package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {
    public List<Cuenta> findAll();

    public Optional<Cuenta> findById(Integer integer);

    public List<Cuenta> findByIdCliente(Integer idCliente);
    public List<Cuenta> findByIdCuentaCustodio(Integer idCuentaCustodio);

    public Cuenta save(Cuenta cliente);
}