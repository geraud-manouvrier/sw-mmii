package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ComisionMaestro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IComisionMaestroDao extends JpaRepository<ComisionMaestro, Long> {
    public List<ComisionMaestro> findAll();
    public Optional<ComisionMaestro> findById(Long id);
    public Optional<ComisionMaestro> findByIdCuentaAndFechaInicioVigencia(Integer idCuenta, Date fechaInicioVigencia);
    public List<ComisionMaestro> findByIdCuenta(Integer idCuenta);



}