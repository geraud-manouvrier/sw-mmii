package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestro;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestroId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteCuentaMaestroDao extends JpaRepository<ClienteCuentaMaestro, ClienteCuentaMaestroId> {
    public List<ClienteCuentaMaestro> findAll();
    public List<ClienteCuentaMaestro> findById_IdInternoClienteIsNotNullAndId_IdInternoCuentaIsNotNullAndHabilitadoIsTrue();
    public ClienteCuentaMaestro findById_IdInternoCuenta(Integer idInternoCuenta);
}