package cl.qande.mmii.app.models.db.rep_inv.dao;

import cl.qande.mmii.app.models.db.rep_inv.entity.RentabilidadCalculada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRentabilidadCalculadaDao extends CrudRepository<RentabilidadCalculada, Long> {

    @Query(value = "SELECT * FROM rep_inv.fn_calcula_rentabilidad" +
            "(:_agregador_n1, :_agregador_n2, :_agregador_n3, :_agregador_n4, :_start_process_date, :_end_process_date) fn_rent " +
            "WHERE CASE WHEN :_todos_niveles then true ELSE fn_rent.agregador_n1=:_agregador_n1 and COALESCE(fn_rent.agregador_n2,'')=COALESCE(:_agregador_n2,'') END " +
            "order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4", nativeQuery = true)
    public List<RentabilidadCalculada> calculaRentabilidad(
            @Param("_agregador_n1") String agregadorN1, @Param("_agregador_n2") String agregadorN2, @Param("_agregador_n3") String agregadorN3, @Param("_agregador_n4") String agregadorN4,
            @Param("_start_process_date") String startProcessDate, @Param("_end_process_date") String endProcessDate, @Param("_todos_niveles") boolean todosNiveles);

    @Query(value = "SELECT * FROM rep_inv.fn_calcula_rentabilidad" +
            "(null, null, null, null, :_process_date, :_process_date) fn_rent WHERE fn_rent.nivel='N2'" +
            "order by fn_rent.nivel, fn_rent.process_date, fn_rent.agregador_n1, fn_rent.agregador_n2, fn_rent.agregador_n3, fn_rent.agregador_n4", nativeQuery = true)
    public List<RentabilidadCalculada> calculaRentabilidadPorCuentaUniversoClientes( @Param("_process_date") String processDate);


    @Query(value = "select * from rep_inv.fn_precalculo_diario(:_process_date_from)", nativeQuery = true)
    public String calculoDiario(@Param("_process_date_from") String processDateFrom);
}