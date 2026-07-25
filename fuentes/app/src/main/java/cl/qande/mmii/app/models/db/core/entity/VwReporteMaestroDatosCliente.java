package cl.qande.mmii.app.models.db.core.entity;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_reporte_maestro_datos_clientes")
@Getter
@ToString
public class VwReporteMaestroDatosCliente {
    @Id
    @Column(name = "row_id")
    private Long rowId;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Column(name = "firm_no")
    private String firmNo;

    @Column(name = "sub_no")
    private String subNo;

    @Size(max = 100)
    @Column(name = "rep_no", length = 100)
    private String repNo;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Size(max = 100)
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 1000)
    @Column(name = "full_name", length = 1000)
    private String fullName;

    @Size(max = 1000)
    @Column(name = "address", length = 1000)
    private String address;

    @Size(max = 100)
    @Column(name = "short_name", length = 100)
    private String shortName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Size(max = 100)
    @Column(name = "acct_status_value", length = 100)
    private String acctStatusValue;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 1000)
    @Column(name = "country_code_value", length = 1000)
    private String countryCodeValue;

    @Size(max = 100)
    @Column(name = "country", length = 100)
    private String country;

    @Size(max = 100)
    @Column(name = "w8_date", length = 100)
    private String w8Date;

    @Column(name = "w9_date")
    private Date w9Date;

    @Size(max = 1000)
    @Column(name = "w8_status_value", length = 1000)
    private String w8StatusValue;

    @Size(max = 1000)
    @Column(name = "w9_status_value", length = 1000)
    private String w9StatusValue;

    @Size(max = 1000)
    @Column(name = "discr_trading_code_value", length = 1000)
    private String discrTradingCodeValue;

    @Size(max = 1000)
    @Column(name = "account_type", length = 1000)
    private String accountType;

    @Size(max = 1000)
    @Column(name = "cash_margin_account", length = 1000)
    private String cashMarginAccount;

    @Size(max = 1000)
    @Column(name = "debit_card_indicator", length = 1000)
    private String debitCardIndicator;

    @Size(max = 100)
    @Column(name = "open_date", length = 100)
    private String openDate;

    @Column(name = "close_date")
    private Date closeDate;

    @Size(max = 1000)
    @Column(name = "participant_type", length = 1000)
    private String participantType;

    @Column(name = "last_statement_date")
    private Date lastStatementDate;

    @Size(max = 100)
    @Column(name = "tax_id", length = 100)
    private String taxId;

    @Column(name = "process_date")
    private String processDate;

    @Column(name = "is_last_info")
    private Boolean isLastInfo;

    @Column(name = "is_last_schema_by_account_no")
    private Boolean isLastSchemaByAccountNo;
    @Column(name = "id_reg")
    private Long idReg;

    @Size(max = 100)
    @Column(name = "tipo_identificador_cliente", length = 100)
    private String tipoIdentificadorCliente;

    @Column(name = "id_interno_cliente")
    private Integer idInternoCliente;

    @Size(max = 100)
    @Column(name = "glosa_identificador_cliente", length = 100)
    private String glosaIdentificadorCliente;

    @Column(name = "fee", precision = 45, scale = 20)
    private BigDecimal fee;

    @Size(max = 100)
    @Column(name = "estado_cuenta", length = 100)
    private String estadoCuenta;

    @Size(max = 100)
    @Column(name = "portfolio", length = 100)
    private String portfolio;

}