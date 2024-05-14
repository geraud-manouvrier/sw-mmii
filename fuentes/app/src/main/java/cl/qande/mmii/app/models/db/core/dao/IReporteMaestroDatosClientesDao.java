package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.UniversoClienteProjection;
import cl.qande.mmii.app.models.db.core.entity.UniversoCuentaProjection;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosClientesDao extends CrudRepository<VwReporteMaestroDatosCliente, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_clientes(:_process_date, :_variante) WHERE NOT public.fn_excluir_cuenta_de_maestro(custodian, account_no) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosCliente> generaReporte(@Param("_process_date") String processDate, @Param("_variante") String varianteReporte);
    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_clientes(:_process_date, :_variante) WHERE NOT public.fn_excluir_cuenta_de_maestro_paises(custodian, account_no) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosCliente> generaReportePaises(@Param("_process_date") String processDate, @Param("_variante") String varianteReporte);

    public List<VwReporteMaestroDatosCliente> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'CTA', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosClientePershing(@Param("_process_date") String processDate);
    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'CTA', 'STONEX')", nativeQuery = true)
    public Long materializaDatosClienteStonex(@Param("_process_date") String processDate);

    @Query(value = "select variante from public.reportes_segmentacion ORDER BY orden_archivos", nativeQuery = true)
    public List<String> listaVariantes();
    @Query(value = "select distinct sufijo_archivo from public.reportes_segmentacion WHERE variante=:_variante LIMIT 1", nativeQuery = true)
    public String sufijoArchivo(@Param("_variante") String variante);

    @Query(value = "SELECT cte.id as id, cte.id||' ('||cte.nombre||')' as value, CAST('Clientes' as VARCHAR(100)) as grouper " +
            "    FROM sura.cliente cte" +
            "    order by id", nativeQuery = true)
    public List<UniversoClienteProjection> listaUniversoClientes(@Param("_process_date") String processDate);
    @Query(value = "SELECT cte.id as parent, CAST(UPPER( cta.custodio) as VARCHAR(100))||'||'||cta.id_cuenta_custodio as id, cta.id_cuenta_custodio as value, CAST(UPPER( cta.custodio) as VARCHAR(100)) as grouper " +
            "FROM sura.cuenta cta " +
            "INNER JOIN sura.contrato cto ON cto.id=cta.id_contrato " +
            "INNER JOIN sura.cliente cte ON cte.id=cto.id_cliente " +
            "order by cte.id, cta.custodio, cta.id_cuenta_custodio", nativeQuery = true)
    public List<UniversoCuentaProjection> listaUniversoCuentas(@Param("_process_date") String processDate);

    @Query(value = "SELECT DISTINCT ctas.client_id as id, ctas.client_id||' ('||ctas.name||')' as value, CAST('Clientes' as VARCHAR(100)) as grouper " +
            "    FROM public.vw_reporte_maestro_datos_clientes ctas " +
            "    WHERE ctas.client_id IS NOT NULL AND ctas.process_date=COALESCE(:_process_date, ctas.process_date) " +
            "    ORDER BY ctas.client_id", nativeQuery = true)
    public List<UniversoClienteProjection> listaUniversoClientesFromMaestro(@Param("_process_date") String processDate);
    @Query(value = "SELECT DISTINCT ctas.client_id as parent, ctas.id_cuenta_custodio as id, ctas.id_cuenta_custodio as value, ctas.custodian as grouper " +
            "FROM public.vw_reporte_maestro_datos_clientes ctas " +
            "WHERE ctas.client_id IS NOT NULL AND ctas.process_date=COALESCE(:_process_date, ctas.process_date) " +
            "ORDER BY ctas.client_id, ctas.custodian, ctas.id_cuenta_custodio", nativeQuery = true)
    public List<UniversoCuentaProjection> listaUniversoCuentasFromMaestro(@Param("_process_date") String processDate);



}