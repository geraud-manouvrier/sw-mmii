package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IClienteDao extends CrudRepository<Cliente, String> {

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(String id);
    @Transactional(readOnly = true)
    @Query("select tbCliente from Cliente tbCliente")
    public List<Cliente> findAll();
}