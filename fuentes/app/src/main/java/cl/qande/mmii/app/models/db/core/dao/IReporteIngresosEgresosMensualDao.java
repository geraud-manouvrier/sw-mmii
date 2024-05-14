package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteIngresosEgresosMensual;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteIngresosEgresosMensualDao extends CrudRepository<VwReporteIngresosEgresosMensual, Long> {
    @Query(value = "SELECT tb_ie.* FROM public.vw_reporte_ingresos_egresos_mensual tb_ie where tb_ie.custodian=:_custodio " +
            "AND ( (tb_ie.anio<:_anio) OR (tb_ie.anio=:_anio and tb_ie.mes<=:_mes) ) " +
            "ORDER BY tb_ie.anio, tb_ie.mes, tb_ie.office_id ASC", nativeQuery = true)
    public List<VwReporteIngresosEgresosMensual> reporteMensualByCustodioAndPeriodo(@Param("_custodio") String custodio, @Param("_anio") int anio, @Param("_mes") int mes);

    @Query(value = "SELECT distinct tb_ie.office_id FROM public.vw_reporte_ingresos_egresos_mensual tb_ie where tb_ie.custodian=:_custodio " +
            "and ( (tb_ie.anio<:_anio) OR (tb_ie.anio=:_anio and tb_ie.mes<=:_mes) ) " +
            " ORDER BY tb_ie.office_id ASC", nativeQuery = true)
    public String[] listaOficinasPorPeriodo(@Param("_custodio") String custodio, @Param("_anio") int anio, @Param("_mes") int mes);


}