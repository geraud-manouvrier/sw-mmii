package cl.qande.mmii.app.models.db.core.entity;

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

    @Size(max = 100)
    @Column(name = "contratos_pa", length = 100)
    private String contratosPa;

    @Size(max = 1000)
    @Column(name = "cash_margin_account", length = 1000)
    private String cashMarginAccount;

    @Size(max = 100)
    @Column(name = "modelo_relacionamiento", length = 100)
    private String modeloRelacionamiento;

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

    @Size(max = 100)
    @Column(name = "client_investment_profile", length = 100)
    private String clientInvestmentProfile;

    @Size(max = 100)
    @Column(name = "portfolio", length = 100)
    private String portfolio;

    @Size(max = 100)
    @Column(name = "tipo_servicio", length = 100)
    private String tipoServicio;

    @Column(name = "advisory_fee_annual_pct", precision = 45, scale = 20)
    private BigDecimal advisoryFeeAnnualPct;

    @Column(name = "last_statement_date")
    private Date lastStatementDate;

    @Size(max = 100)
    @Column(name = "main_advisor", length = 100)
    private String mainAdvisor;

    @Size(max = 100)
    @Column(name = "secondary_advisor", length = 100)
    private String secondaryAdvisor;

    @Size(max = 100)
    @Column(name = "email_main_advisor", length = 100)
    private String emailMainAdvisor;

    @Size(max = 100)
    @Column(name = "email_secondary_advisor", length = 100)
    private String emailSecondaryAdvisor;

    @Size(max = 100)
    @Column(name = "tax_id", length = 100)
    private String taxId;

    @Column(name = "last_activity_month")
    private Date lastActivityMonth;

    @Size(max = 1000)
    @Column(name = "institution_code", length = 1000)
    private String institutionCode;

    @Size(max = 100)
    @Column(name = "restriction_date", length = 100)
    private String restrictionDate;

    @Column(name = "fondeo", precision = 45, scale = 20)
    private BigDecimal fondeo;

    @Column(name = "monto_comprometido", precision = 45, scale = 20)
    private BigDecimal montoComprometido;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Size(max = 100)
    @Column(name = "process_stamp", length = 100)
    private String processStamp;

    @Column(name = "process_date")
    private String processDate;

    @Size(max = 100)
    @Column(name = "last_process_date", length = 100)
    private String lastProcessDate;

    @Size(max = 100)
    @Column(name = "last_process_stamp", length = 100)
    private String lastProcessStamp;

    @Column(name = "is_last_info")
    private Boolean isLastInfo;

    @Size(max = 100)
    @Column(name = "acct_type_ind", length = 100)
    private String acctTypeInd;

    @Column(name = "rank_order")
    private Long rankOrder;

    @Column(name = "is_last_schema_by_account_no")
    private Boolean isLastSchemaByAccountNo;

    @Column(name = "cuenta_abierta")
    private Boolean cuentaAbierta;

    @Size(max = 100)
    @Column(name = "rep", length = 100)
    private String rep;

    @Size(max = 100)
    @Column(name = "branch", length = 100)
    private String branch;

    @Size(max = 100)
    @Column(name = "id_cuenta_custodio", length = 100)
    private String idCuentaCustodio;

    @Column(name = "namelines")
    private Integer namelines;

    @Size(max = 100)
    @Column(name = "name_line1", length = 100)
    private String nameLine1;

    @Size(max = 100)
    @Column(name = "name_line2", length = 100)
    private String nameLine2;

    @Size(max = 100)
    @Column(name = "name_line3", length = 100)
    private String nameLine3;

    @Size(max = 100)
    @Column(name = "name_line4", length = 100)
    private String nameLine4;

    @Size(max = 100)
    @Column(name = "name_line5", length = 100)
    private String nameLine5;

    @Size(max = 100)
    @Column(name = "name_line6", length = 100)
    private String nameLine6;

    @Size(max = 100)
    @Column(name = "acct_status", length = 100)
    private String acctStatus;

    @Size(max = 100)
    @Column(name = "country_code", length = 100)
    private String countryCode;

    @Size(max = 100)
    @Column(name = "w8_status", length = 100)
    private String w8Status;

    @Size(max = 100)
    @Column(name = "w9_status", length = 100)
    private String w9Status;

    @Size(max = 100)
    @Column(name = "discr_trading_code", length = 100)
    private String discrTradingCode;

    @Size(max = 100)
    @Column(name = "social_code", length = 100)
    private String socialCode;

    @Size(max = 100)
    @Column(name = "inst_code", length = 100)
    private String instCode;

    @Size(max = 100)
    @Column(name = "cma", length = 100)
    private String cma;

    @Size(max = 100)
    @Column(name = "last_stmt_cym", length = 100)
    private String lastStmtCym;

    @Size(max = 100)
    @Column(name = "last_activity_cym", length = 100)
    private String lastActivityCym;

    @Size(max = 100)
    @Column(name = "margin_si1", length = 100)
    private String marginSi1;

    @Size(max = 100)
    @Column(name = "margin_si2", length = 100)
    private String marginSi2;

    @Size(max = 100)
    @Column(name = "restriction_code", length = 100)
    private String restrictionCode;

    @Size(max = 1000)
    @Column(name = "restriction_code_value", length = 1000)
    private String restrictionCodeValue;

    @Size(max = 100)
    @Column(name = "account_restriction", length = 100)
    private String accountRestriction;
    @Column(name = "id_reg")
    private Long idReg;

    public Long getIdReg() {
        return idReg;
    }

    public Long getRowId() {
        return rowId;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public String getRepNo() {
        return repNo;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getShortName() {
        return shortName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAcctStatusValue() {
        return acctStatusValue;
    }

    public String getEmail() {
        return email;
    }

    public String getCountryCodeValue() {
        return countryCodeValue;
    }

    public String getCountry() {
        return country;
    }

    public String getW8Date() {
        return w8Date;
    }

    public Date getW9Date() {
        return w9Date;
    }

    public String getW8StatusValue() {
        return w8StatusValue;
    }

    public String getW9StatusValue() {
        return w9StatusValue;
    }

    public String getDiscrTradingCodeValue() {
        return discrTradingCodeValue;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getContratosPa() {
        return contratosPa;
    }

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public String getModeloRelacionamiento() {
        return modeloRelacionamiento;
    }

    public String getDebitCardIndicator() {
        return debitCardIndicator;
    }

    public String getOpenDate() {
        return openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public String getParticipantType() {
        return participantType;
    }

    public String getClientInvestmentProfile() {
        return clientInvestmentProfile;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public BigDecimal getAdvisoryFeeAnnualPct() {
        return advisoryFeeAnnualPct;
    }

    public Date getLastStatementDate() {
        return lastStatementDate;
    }

    public String getMainAdvisor() {
        return mainAdvisor;
    }

    public String getSecondaryAdvisor() {
        return secondaryAdvisor;
    }

    public String getEmailMainAdvisor() {
        return emailMainAdvisor;
    }

    public String getEmailSecondaryAdvisor() {
        return emailSecondaryAdvisor;
    }

    public String getTaxId() {
        return taxId;
    }

    public Date getLastActivityMonth() {
        return lastActivityMonth;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public String getRestrictionDate() {
        return restrictionDate;
    }

    public BigDecimal getFondeo() {
        return fondeo;
    }

    public BigDecimal getMontoComprometido() {
        return montoComprometido;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getLastProcessDate() {
        return lastProcessDate;
    }

    public String getLastProcessStamp() {
        return lastProcessStamp;
    }

    public Boolean getIsLastInfo() {
        return isLastInfo;
    }

    public String getAcctTypeInd() {
        return acctTypeInd;
    }

    public Long getRankOrder() {
        return rankOrder;
    }

    public Boolean getIsLastSchemaByAccountNo() {
        return isLastSchemaByAccountNo;
    }

    public Boolean getCuentaAbierta() {
        return cuentaAbierta;
    }

    public String getRep() {
        return rep;
    }

    public String getBranch() {
        return branch;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public Integer getNamelines() {
        return namelines;
    }

    public String getNameLine1() {
        return nameLine1;
    }

    public String getNameLine2() {
        return nameLine2;
    }

    public String getNameLine3() {
        return nameLine3;
    }

    public String getNameLine4() {
        return nameLine4;
    }

    public String getNameLine5() {
        return nameLine5;
    }

    public String getNameLine6() {
        return nameLine6;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getW8Status() {
        return w8Status;
    }

    public String getW9Status() {
        return w9Status;
    }

    public String getDiscrTradingCode() {
        return discrTradingCode;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public String getInstCode() {
        return instCode;
    }

    public String getCma() {
        return cma;
    }

    public String getLastStmtCym() {
        return lastStmtCym;
    }

    public String getLastActivityCym() {
        return lastActivityCym;
    }

    public String getMarginSi1() {
        return marginSi1;
    }

    public String getMarginSi2() {
        return marginSi2;
    }

    public String getRestrictionCode() {
        return restrictionCode;
    }

    public String getRestrictionCodeValue() {
        return restrictionCodeValue;
    }

    public String getAccountRestriction() {
        return accountRestriction;
    }

}