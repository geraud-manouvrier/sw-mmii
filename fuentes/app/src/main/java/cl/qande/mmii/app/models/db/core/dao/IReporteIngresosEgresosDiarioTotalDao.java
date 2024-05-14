package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.VwReporteIngresosEgresosDiarioTotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IReporteIngresosEgresosDiarioTotalDao extends CrudRepository<VwReporteIngresosEgresosDiarioTotal, Long> {
    @Query(value = "SELECT vw_rd.* FROM public.vw_reporte_ingresos_egresos_diario_total vw_rd where vw_rd.custodian=:_custodio " +
            "and vw_rd.dia = :_dia " +
            "ORDER BY vw_rd.row_id ASC", nativeQuery = true)
    public VwReporteIngresosEgresosDiarioTotal totalReporteDiarioByCustodioAndFecha(@Param("_custodio") String custodio, @Param("_dia") Date fecha);

}