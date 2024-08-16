package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.Cliente;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteMaestro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {


    @Query(value = "SELECT cte FROM Cliente cte where cte.id = :id")
    public Optional<Cliente> listarClientePorId(@Param("id") Integer id);

    public Cliente save(Cliente cliente);

    @Query(value = "SELECT cte FROM ClienteMaestro cte ")
    public List<ClienteMaestro> listarClientesMaestros();
}