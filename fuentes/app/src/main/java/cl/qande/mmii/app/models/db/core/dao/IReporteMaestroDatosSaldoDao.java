package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.db.core.entity.IndicadoresBasePeriodoProjection;
import cl.qande.mmii.app.models.db.core.entity.MaestroDatosSaldoDiarioProjection;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public interface IReporteMaestroDatosSaldoDao extends CrudRepository<VwReporteMaestroDatosSaldo, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_saldos(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosSaldo> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_materializa_data(:_process_date, 'SLD', 'PERSHING')", nativeQuery = true)
    public Long materializaDatosSaldosPershing(@Param("_process_date") String processDate);

    @Query(value="SELECT * FROM public.fn_indicadores_cia_base(:_processDate)", nativeQuery = true)
    public List<IndicadoresBasePeriodoProjection> indicadoresBasePorPeriodo(@Param("_processDate") String processDate);


    @Query(
            value = "SELECT process_date as processDate, name as clientName, account_no as accountNumber, sum(usde_market_value) as saldoDiario FROM public.fn_reporte_maestro_datos_saldos(:_process_date) " +
                    "WHERE account_no IN (:_account_numbers) " +
                    "GROUP BY process_date, name, account_no " +
                    "ORDER BY process_date, name, account_no ",
            nativeQuery = true
    )
    List<MaestroDatosSaldoDiarioProjection> findSaldoDiarioByProcessDateAndAccountNoIn(
            @Param("_process_date")      String processDate,
            @Param("_account_numbers")   List<String> accountNumbers
    );
}