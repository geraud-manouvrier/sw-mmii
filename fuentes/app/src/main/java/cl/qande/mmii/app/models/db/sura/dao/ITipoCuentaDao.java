package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.TipoCuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ITipoCuentaDao extends CrudRepository<TipoCuenta, String> {
    List<TipoCuenta> findAll();
    Optional<TipoCuenta> findById(String id);
}