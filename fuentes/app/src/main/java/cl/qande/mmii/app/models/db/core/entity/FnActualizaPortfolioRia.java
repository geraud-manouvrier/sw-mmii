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

@Entity
@Immutable
@NamedNativeQuery(
        name = FnActualizaPortfolioRia.ACTUALIZA_PORTFOLIO_FROM_RIA,
        query = "SELECT * FROM public.fn_actualiza_portfolio_ria(:_custodian, :_account_no, :_process_date, :_new_portfolio)",
        resultClass = FnActualizaPortfolioRia.class
)
@Setter
@Getter
@ToString
public class FnActualizaPortfolioRia implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String ACTUALIZA_PORTFOLIO_FROM_RIA     = "FnActualizaPortfolioRia.actualizaPortfolioRia";

    @Id
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Id
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Id
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "new_portfolio", length = 100)
    private String newPortfolio;

    @Column(name = "modelo_clientes_rows_updated")
    private Integer modeloClientesRowsUpdated;

    @Column(name = "maestro_cuentas_rows_match")
    private Integer maestroCuentasRowsMatch;

    @Column(name = "maestro_cuentas_rows_updated")
    private Integer maestroCuentasRowsUpdated;

    @Column(name = "maestro_cuentas_old_portfolio", length = 100)
    private String maestroCuentasOldPortfolio;

    @Column(name = "maestro_cuentas_new_portfolio", length = 100)
    private String maestroCuentasNewPortfolio;

    @Column(name = "status_code")
    private Integer statusCode;

    @Column(name = "status_msg", length = 1000)
    private String statusMsg;


}
