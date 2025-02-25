package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestro;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestroId;
import cl.qande.mmii.app.models.db.core.entity.UniversoClienteProjection;
import cl.qande.mmii.app.models.db.core.entity.UniversoCuentaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClienteCuentaMaestroDao extends JpaRepository<ClienteCuentaMaestro, ClienteCuentaMaestroId> {
    public List<ClienteCuentaMaestro> findAll();
    public List<ClienteCuentaMaestro> findById_IdInternoClienteIsNotNullAndId_IdInternoCuentaIsNotNullAndHabilitadoIsTrue();
    public ClienteCuentaMaestro findById_IdInternoCuenta(Integer idInternoCuenta);

    //Para combo box de clientes
    @Query(value = "SELECT mstr.identificador_cliente as id, mstr.tipo_identificador_cliente||'-'||mstr.identificador_cliente||' ('||mstr.nombre_cliente||')' as value, CAST('Clientes' as VARCHAR(100)) as grouper " +
            "    FROM clientes.vw_maestro_clientes_cuentas mstr WHERE mstr.habilitado " +
            "    ORDER BY mstr.nombre_cliente", nativeQuery = true)
    public List<UniversoClienteProjection> listaUniversoClientes(@Param("_process_date") String processDate);
    //Para combo box de cuentas
    @Query(value = "SELECT mstr.identificador_cliente as parent, CAST(UPPER( mstr.id_custodio) as VARCHAR(100))||'||'||mstr.id_cuenta_custodio as id, mstr.id_cuenta_custodio as value, CAST(UPPER( mstr.id_custodio) as VARCHAR(100)) as grouper " +
            "FROM clientes.vw_maestro_clientes_cuentas mstr WHERE mstr.habilitado " +
            "order by mstr.id_cuenta_custodio", nativeQuery = true)
    public List<UniversoCuentaProjection> listaUniversoCuentas(@Param("_process_date") String processDate);


}