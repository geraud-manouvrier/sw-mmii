package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershing;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingId;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICuentasNoMapeadasPershingDao extends JpaRepository<VwCuentasNoMapeadasPershing, VwCuentasNoMapeadasPershingId> {


    @Query("SELECT DISTINCT c.id.processDate as processDate, c.clientName AS clientName, c.id.accountNo AS accountNo FROM VwCuentasNoMapeadasPershing c WHERE c.id.processDate = :processDate")
    List<VwCuentasNoMapeadasPershingProjection> listaCuentasNoMapeadasByProcessDate(@Param("processDate") String processDate);

}