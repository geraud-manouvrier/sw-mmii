package cl.qande.mmii.app.models.db.core.dao;

import cl.qande.mmii.app.models.db.core.entity.IndicadoresBasePeriodoProjection;
import cl.qande.mmii.app.models.db.core.entity.MaestroDatosSaldoDiarioProjection;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.dto.core.SaldoCuentaResumenDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporteMaestroDatosSaldoDao extends CrudRepository<VwReporteMaestroDatosSaldo, Long> {

    @Query(value = "SELECT * FROM public.fn_reporte_maestro_datos_saldos(:_process_date) ORDER BY account_no", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> generaReporte(@Param("_process_date") String processDate);

    public List<VwReporteMaestroDatosSaldo> findByProcessDateBetween(String processDateFrom, String processDateTo);

    @Query(value = "SELECT *" +
            "FROM public.vw_reporte_maestro_datos_saldos vw_sld " +
            "where vw_sld.process_date=:_process_date " +
            "and vw_sld.client_id=:_client_id " +
            "and vw_sld.account_no=COALESCE(:_account_no, vw_sld.account_no) " +
            "ORDER BY vw_sld.account_no, vw_sld.cusip", nativeQuery = true)
    public List<VwReporteMaestroDatosSaldo> saldoCliente(@Param("_process_date") String processDate, @Param("_client_id") String clientId, @Param("_account_no") String accountNo);

    @Query(
            "SELECT new cl.qande.mmii.app.models.dto.core.SaldoCuentaResumenDto(" +
                    " SUM(v.usdeMarketValue), " +
                    " v.accountNo " +
                    ") " +
                    "FROM VwReporteMaestroDatosSaldo v " +
                    "WHERE v.processDate = :_process_date " +
                    "AND v.clientId = :_client_id " +
                    "and v.accountNo=COALESCE(:_account_no, v.accountNo) " +
                    "GROUP BY v.accountNo " +
                    "ORDER BY v.accountNo"
    )
    List<SaldoCuentaResumenDto> resumenSaldoPorCuenta(
            @Param("_process_date") String processDate,
            @Param("_client_id") String clientId,
            @Param("_account_no") String accountNo);

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