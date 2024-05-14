package cl.qande.mmii.app.models.db.rep_inv.dao;

import cl.qande.mmii.app.models.db.rep_inv.entity.VwBaseConsolidado;
import cl.qande.mmii.app.models.db.rep_inv.entity.VwBaseConsolidadoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVwBaseConsolidadoDao extends CrudRepository<VwBaseConsolidado, VwBaseConsolidadoId> {


    @Query(value = "SELECT * FROM rep_inv.vw_base_consolidado vw_base " +
            "WHERE vw_base.process_date>= :_fecha_desde AND vw_base.process_date<= :_fecha_hasta " +
            "AND vw_base.client_id=:_client_id AND vw_base.account_no=COALESCE(:_account_number, vw_base.account_no)" +
            "ORDER BY client_id, account_no, process_date ", nativeQuery = true)
    public List<VwBaseConsolidado> listaBaseConsolidadaPorClienteCuenta(@Param("_fecha_desde") String fechaDesde, @Param("_fecha_hasta") String fechaHasta,
                                                                        @Param("_client_id") String clientId, @Param("_account_number") String accountNumber);

    @Query(value = "SELECT DISTINCT vw_base.client_id FROM rep_inv.vw_base_consolidado vw_base", nativeQuery = true)
    public List<String> listaClientes();

    @Query(value = "SELECT DISTINCT vw_base.account_no FROM rep_inv.vw_base_consolidado vw_base", nativeQuery = true)
    public List<String> listaCuentas();


}