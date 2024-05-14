package cl.qande.mmii.app.models.db.rep_inv.dao;

import cl.qande.mmii.app.models.db.rep_inv.entity.ConsolidadoAgregadoN2;
import cl.qande.mmii.app.models.db.rep_inv.entity.ConsolidadoAgregadoN2Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConsolidadoAgregadoN2Dao extends CrudRepository<ConsolidadoAgregadoN2, ConsolidadoAgregadoN2Id> {
    @Query(value = "SELECT * FROM rep_inv.consolidado_agregado_n2 tb_n2 " +
            "WHERE tb_n2.process_date>= :_fecha_desde AND tb_n2.process_date<= :_fecha_hasta " +
            "AND tb_n2.agregador_n1=:_client_id AND tb_n2.agregador_n2=COALESCE(:_account_no, tb_n2.agregador_n2) " +
            "ORDER BY agregador_n1, tb_n2.agregador_n2, process_date ", nativeQuery = true)
    public List<ConsolidadoAgregadoN2> listaConsolidadoAgregado(@Param("_fecha_desde") String fechaDesde, @Param("_fecha_hasta") String fechaHasta,
                                                                            @Param("_client_id") String clientId, @Param("_account_no") String accountNo);
}