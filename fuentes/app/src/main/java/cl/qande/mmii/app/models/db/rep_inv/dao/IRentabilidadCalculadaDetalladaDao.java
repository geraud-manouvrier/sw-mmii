package cl.qande.mmii.app.models.db.rep_inv.dao;

import cl.qande.mmii.app.models.db.rep_inv.entity.RentabilidadCalculadaDetallada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRentabilidadCalculadaDetalladaDao extends CrudRepository<RentabilidadCalculadaDetallada, String> {

    @Query(value = "SELECT * FROM rep_inv.fn_rentabilidad(:_agregador_n1, :_agregador_n2, :_agregador_n3, :_agregador_n4, :_fecha_desde, :_fecha_hasta) order by nivel, agregador_n1, agregador_n2, process_date_as_date", nativeQuery = true)
    public List<RentabilidadCalculadaDetallada> calculaRentabilidadDetallada(@Param("_agregador_n1") String agregadorN1, @Param("_agregador_n2") String agregadorN2, @Param("_agregador_n3") String agregadorN3, @Param("_agregador_n4") String agregadorN4, @Param("_fecha_desde") String fechaDesde, @Param("_fecha_hasta") String fechaHasta);

}
