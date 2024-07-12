package cl.qande.mmii.app.models.db.clientes.dao;

import cl.qande.mmii.app.models.db.clientes.entity.ParFeeSegmento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IParFeeSegmentoDao extends CrudRepository<ParFeeSegmento, Integer> {

    public Optional<ParFeeSegmento> findById(Integer id);
    public List<ParFeeSegmento> findAll();
    public List<ParFeeSegmento> findAllByOrderByMontoMinAsc();

    public ParFeeSegmento save(ParFeeSegmento parFeeSegmento);

    @Query("select par_fee from ParFeeSegmento par_fee " +
            " WHERE par_fee.id<>COALESCE(:id,-1)" +
            " AND ( (par_fee.montoMin<:monto_min AND par_fee.montoMax>:monto_min) OR (par_fee.montoMin<:monto_max AND par_fee.montoMax>:monto_max) )")
    public List<ParFeeSegmento> validaSegmento(@Param("id") Integer id, @Param("monto_min") BigDecimal montoMin, @Param("monto_max") BigDecimal montoMax);

}