package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.PersonaRelacionada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface IPersonaRelacionadaDao extends JpaRepository<PersonaRelacionada, Integer> {

    @Transactional (readOnly = true)
    public Optional<PersonaRelacionada> findByIdentificadorAndIdCliente(String id, Integer idCliente);

    @Transactional (readOnly = true)
    @Query(value = "SELECT rel FROM PersonaRelacionada rel where rel.idCliente = :idCliente and rel.flagHabilitado = :flagHabilitado")
    public List<PersonaRelacionada> listarRelacionadosPorIdCliente(@Param("idCliente") Integer idCliente, @Param("flagHabilitado") boolean flagHabilitado);

    @Transactional
    public PersonaRelacionada save(PersonaRelacionada personaRelacionada);

    @Modifying
    @Transactional
    @Query("UPDATE PersonaRelacionada rel SET rel.flagHabilitado = :newFlag, rel.modificacionTs=:ts, rel.modificacionUser=:user WHERE rel.idCliente = :idCliente")
    public void cambiaFlagHabilitadoRelacionadosPorIdCliente(@Param("idCliente") Integer idCliente, @Param("newFlag") boolean newFlag, @Param("ts") Instant ts, @Param("user") String user);
}