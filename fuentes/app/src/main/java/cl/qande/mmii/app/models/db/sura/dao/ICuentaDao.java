package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ICuentaDao extends CrudRepository<Cuenta, String> {

    public Cuenta findCuentaByIdCuentaCustodioAndCustodio(String idCuentaCustodio, String custodio);

    @Transactional(readOnly = true)
    public List<Cuenta> findByIdContrato(String idContrato);
    @Transactional(readOnly = true)
    public Optional<Cuenta> findById(String id);
    @Transactional(readOnly = true)
    @Query("select tbCuenta from Cuenta tbCuenta")
    public List<Cuenta> findAll();

}