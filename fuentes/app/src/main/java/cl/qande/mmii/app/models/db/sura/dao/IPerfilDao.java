package cl.qande.mmii.app.models.db.sura.dao;

import cl.qande.mmii.app.models.db.sura.entity.Perfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IPerfilDao extends CrudRepository<Perfil, String> {
    @Transactional(readOnly = true)
    public Optional<Perfil> findById(String id);
    @Transactional(readOnly = true)
    @Query("select tbPerfil from Perfil tbPerfil")
    public List<Perfil> findAll();
}