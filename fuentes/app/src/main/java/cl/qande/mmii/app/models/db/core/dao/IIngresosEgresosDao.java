package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.IngresosEgresos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IIngresosEgresosDao extends CrudRepository<IngresosEgresos, Long> {
    @Query(value = "SELECT * FROM public.fn_reporte_ingresos_egresos_calculo(:_str_calc_date)", nativeQuery = true)
    public List<IngresosEgresos> calculaReporteIngresosEgresos(@Param("_str_calc_date") String strCalcDate);

    @Query(value = "SELECT * FROM public.ingresos_egresos tb_ie where tb_ie.custodio=:_custodio and tb_ie.fecha between :_date_from and :_date_to ORDER BY tb_ie.fecha ASC, tb_ie.id_oficina ASC", nativeQuery = true)
    public List<IngresosEgresos> reporteDiarioByCustodioAndRangeDate(@Param("_custodio") String custodio, @Param("_date_from") Date dateFrom, @Param("_date_to") Date dateTo);


}