package cl.qande.mmii.app.models.db.rep_inv.dao;

import cl.qande.mmii.app.models.db.rep_inv.entity.ConsolidadoAgregadoN1;
import cl.qande.mmii.app.models.db.rep_inv.entity.ConsolidadoAgregadoN1Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConsolidadoAgregadoN1Dao extends CrudRepository<ConsolidadoAgregadoN1, ConsolidadoAgregadoN1Id> {
    @Query(value = "SELECT * FROM rep_inv.consolidado_agregado_n1 tb_n1 " +
            "WHERE tb_n1.process_date>= :_fecha_desde AND tb_n1.process_date<= :_fecha_hasta " +
            "AND tb_n1.agregador_n1=:_client_id " +
            "ORDER BY agregador_n1, process_date ", nativeQuery = true)
    public List<ConsolidadoAgregadoN1> listaConsolidadoAgregado(@Param("_fecha_desde") String fechaDesde, @Param("_fecha_hasta") String fechaHasta,
                                                                        @Param("_client_id") String clientId);

}