package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwMaestroSaldosPershing;
import cl.qande.mmii.app.models.db.core.entity.VwMaestroSaldosPershingId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVwMaestroSaldosPershingDao extends CrudRepository<VwMaestroSaldosPershing, VwMaestroSaldosPershingId> {
    List<VwMaestroSaldosPershing> findByIdProcessDate(String processDate);

}