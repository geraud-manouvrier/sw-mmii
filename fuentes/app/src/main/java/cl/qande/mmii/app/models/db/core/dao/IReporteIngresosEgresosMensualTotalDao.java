package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteIngresosEgresosMensualTotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IReporteIngresosEgresosMensualTotalDao extends CrudRepository<VwReporteIngresosEgresosMensualTotal, Long> {
    @Query(value = "SELECT vw_rm.* FROM public.vw_reporte_ingresos_egresos_mensual_total vw_rm where vw_rm.custodian=:_custodio " +
            "and vw_rm.anio = :_anio and vw_rm.mes = :_mes " +
            "ORDER BY vw_rm.row_id ASC", nativeQuery = true)
    public VwReporteIngresosEgresosMensualTotal totalReporteMensualByCustodioAndPeriodo(@Param("_custodio") String custodio, @Param("_anio") Integer anio, @Param("_mes") Integer mes);


}