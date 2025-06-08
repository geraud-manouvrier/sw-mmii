package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ParCargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParCargoDao extends JpaRepository<ParCargo, String> {

    public List<ParCargo> findAllByFlagHabilitadoRelacionadoTrueOrderByGlosa();
}