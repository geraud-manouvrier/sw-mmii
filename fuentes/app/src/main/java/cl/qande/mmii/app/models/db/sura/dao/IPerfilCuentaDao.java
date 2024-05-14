package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IPerfilCuentaDao extends CrudRepository<PerfilCuenta, Long> {

    @Transactional(readOnly = true)
    public List<PerfilCuenta> findByIdCuentaSura(String idCuentaInterno);

    @Transactional(readOnly = true)
    public PerfilCuenta findFirstByIdCuentaSuraOrderByFechaVigenciaDesc(String idCuentaInterno);
    @Transactional(readOnly = true)
    public Optional<PerfilCuenta> findById(Long id);
    @Transactional(readOnly = true)
    @Query("select tbPerfilCuenta from PerfilCuenta tbPerfilCuenta")
    public List<PerfilCuenta> findAll();
}