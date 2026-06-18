package cl.qande.mmii.app.models.db.core.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Immutable
@NamedNativeQuery(
        name = FnActualizaFeeRia.ACTUALIZA_FEE_FROM_RIA,
        query = "SELECT * FROM public.fn_actualiza_fee_ria(:_custodian, :_account_no, :_process_date, :_new_annual_percent_fee)",
        resultClass = FnActualizaFeeRia.class
)
@Setter
@Getter
@ToString
public class FnActualizaFeeRia implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ACTUALIZA_FEE_FROM_RIA     = "FnActualizaFeeRia.actualizaFeeRia";

    @Id
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Id
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Id
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "new_annual_percent_fee", precision = 45, scale = 20)
    private BigDecimal newAnnualPercentFee;

    @Column(name = "modelo_clientes_rows_updated")
    private Integer modeloClientesRowsUpdated;

    @Column(name = "maestro_saldos_rows_match")
    private Integer maestroSaldosRowsMatch;

    @Column(name = "maestro_saldos_rows_updated")
    private Integer maestroSaldosRowsUpdated;

    @Column(name = "maestro_saldos_old_annual_fee_min", precision = 45, scale = 20)
    private BigDecimal maestroSaldosOldAnnualFeeMin;

    @Column(name = "maestro_saldos_old_annual_fee_max", precision = 45, scale = 20)
    private BigDecimal maestroSaldosOldAnnualFeeMax;

    @Column(name = "maestro_saldos_new_annual_fee", precision = 45, scale = 20)
    private BigDecimal maestroSaldosNewAnnualFee;

    @Column(name = "maestro_cuentas_rows_match")
    private Integer maestroCuentasRowsMatch;

    @Column(name = "maestro_cuentas_rows_updated")
    private Integer maestroCuentasRowsUpdated;

    @Column(name = "maestro_cuentas_old_fee_min", precision = 45, scale = 20)
    private BigDecimal maestroCuentasOldFeeMin;

    @Column(name = "maestro_cuentas_old_fee_max", precision = 45, scale = 20)
    private BigDecimal maestroCuentasOldFeeMax;

    @Column(name = "maestro_cuentas_new_fee", precision = 45, scale = 20)
    private BigDecimal maestroCuentasNewFee;

    @Column(name = "status_code")
    private Integer statusCode;

    @Column(name = "status_msg", length = 1000)
    private String statusMsg;


}
