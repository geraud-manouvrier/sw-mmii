package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

    public List<Cliente> findAll();

    public Optional<Cliente> findById(Integer integer);
    public Optional<Cliente> findByIdentificador(String identificador);
    public Cliente save(Cliente cliente);
}