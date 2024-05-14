package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "rectificacion_cuentas_no_informadas")
public class RectificacionCuentasNoInformada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Size(max = 100)
    @Column(name = "firm_no", length = 100)
    private String firmNo;

    @Size(max = 100)
    @Column(name = "sub_no", length = 100)
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

    @Size(max = 100)
    @Column(name = "full_name", length = 100)
    private String fullName;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(max = 100)
    @Column(name = "short_name", length = 100)
    private String shortName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Size(max = 100)
    @Column(name = "acct_status_value", length = 100)
    private String acctStatusValue;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 100)
    @Column(name = "country_code_value", length = 100)
    private String countryCodeValue;

    @Size(max = 100)
    @Column(name = "country", length = 100)
    private String country;

    @Size(max = 100)
    @Column(name = "w8_date", length = 100)
    private String w8Date;

    @Column(name = "w9_date")
    private LocalDate w9Date;

    @Size(max = 100)
    @Column(name = "w8_status_value", length = 100)
    private String w8StatusValue;

    @Size(max = 100)
    @Column(name = "w9_status_value", length = 100)
    private String w9StatusValue;

    @Size(max = 100)
    @Column(name = "discr_trading_code_value", length = 100)
    private String discrTradingCodeValue;

    @Size(max = 100)
    @Column(name = "account_type", length = 100)
    private String accountType;

    @Size(max = 100)
    @Column(name = "contratos_pa", length = 100)
    private String contratosPa;

    @Size(max = 100)
    @Column(name = "cash_margin_account", length = 100)
    private String cashMarginAccount;

    @Size(max = 100)
    @Column(name = "modelo_relacionamiento", length = 100)
    private String modeloRelacionamiento;

    @Size(max = 100)
    @Column(name = "debit_card_indicator", length = 100)
    private String debitCardIndicator;

    @Size(max = 100)
    @Column(name = "open_date", length = 100)
    private String openDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @Size(max = 100)
    @Column(name = "participant_type", length = 100)
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
    private LocalDate lastStatementDate;

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
    private LocalDate lastActivityMonth;

    @Size(max = 100)
    @Column(name = "institution_code", length = 100)
    private String institutionCode;

    @Size(max = 100)
    @Column(name = "restriction_date", length = 100)
    private String restrictionDate;

    @Column(name = "fondeo", precision = 45, scale = 20)
    private BigDecimal fondeo;

    @Column(name = "monto_comprometido", precision = 45, scale = 20)
    private BigDecimal montoComprometido;

    @Size(max = 100)
    @Column(name = "process_stamp", length = 100)
    private String processStamp;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
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

    @Size(max = 100)
    @NotNull
    @Column(name = "registrador_user", nullable = false, length = 100)
    private String registradorUser;

    @NotNull
    @Column(name = "registrador_timestamp", nullable = false)
    private Instant registradorTimestamp;

    @Size(max = 100)
    @Column(name = "modificador_user", length = 100)
    private String modificadorUser;

    @Column(name = "modificador_timestamp")
    private Instant modificadorTimestamp;

    @Column(name = "id_estado_rectificacion")
    private Integer idEstadoRectificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public void setTipoReg(String tipoReg) {
        this.tipoReg = tipoReg;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getRepNo() {
        return repNo;
    }

    public void setRepNo(String repNo) {
        this.repNo = repNo;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAcctStatusValue() {
        return acctStatusValue;
    }

    public void setAcctStatusValue(String acctStatusValue) {
        this.acctStatusValue = acctStatusValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCodeValue() {
        return countryCodeValue;
    }

    public void setCountryCodeValue(String countryCodeValue) {
        this.countryCodeValue = countryCodeValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getW8Date() {
        return w8Date;
    }

    public void setW8Date(String w8Date) {
        this.w8Date = w8Date;
    }

    public LocalDate getW9Date() {
        return w9Date;
    }

    public void setW9Date(LocalDate w9Date) {
        this.w9Date = w9Date;
    }

    public String getW8StatusValue() {
        return w8StatusValue;
    }

    public void setW8StatusValue(String w8StatusValue) {
        this.w8StatusValue = w8StatusValue;
    }

    public String getW9StatusValue() {
        return w9StatusValue;
    }

    public void setW9StatusValue(String w9StatusValue) {
        this.w9StatusValue = w9StatusValue;
    }

    public String getDiscrTradingCodeValue() {
        return discrTradingCodeValue;
    }

    public void setDiscrTradingCodeValue(String discrTradingCodeValue) {
        this.discrTradingCodeValue = discrTradingCodeValue;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getContratosPa() {
        return contratosPa;
    }

    public void setContratosPa(String contratosPa) {
        this.contratosPa = contratosPa;
    }

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public void setCashMarginAccount(String cashMarginAccount) {
        this.cashMarginAccount = cashMarginAccount;
    }

    public String getModeloRelacionamiento() {
        return modeloRelacionamiento;
    }

    public void setModeloRelacionamiento(String modeloRelacionamiento) {
        this.modeloRelacionamiento = modeloRelacionamiento;
    }

    public String getDebitCardIndicator() {
        return debitCardIndicator;
    }

    public void setDebitCardIndicator(String debitCardIndicator) {
        this.debitCardIndicator = debitCardIndicator;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    public String getClientInvestmentProfile() {
        return clientInvestmentProfile;
    }

    public void setClientInvestmentProfile(String clientInvestmentProfile) {
        this.clientInvestmentProfile = clientInvestmentProfile;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public BigDecimal getAdvisoryFeeAnnualPct() {
        return advisoryFeeAnnualPct;
    }

    public void setAdvisoryFeeAnnualPct(BigDecimal advisoryFeeAnnualPct) {
        this.advisoryFeeAnnualPct = advisoryFeeAnnualPct;
    }

    public LocalDate getLastStatementDate() {
        return lastStatementDate;
    }

    public void setLastStatementDate(LocalDate lastStatementDate) {
        this.lastStatementDate = lastStatementDate;
    }

    public String getMainAdvisor() {
        return mainAdvisor;
    }

    public void setMainAdvisor(String mainAdvisor) {
        this.mainAdvisor = mainAdvisor;
    }

    public String getSecondaryAdvisor() {
        return secondaryAdvisor;
    }

    public void setSecondaryAdvisor(String secondaryAdvisor) {
        this.secondaryAdvisor = secondaryAdvisor;
    }

    public String getEmailMainAdvisor() {
        return emailMainAdvisor;
    }

    public void setEmailMainAdvisor(String emailMainAdvisor) {
        this.emailMainAdvisor = emailMainAdvisor;
    }

    public String getEmailSecondaryAdvisor() {
        return emailSecondaryAdvisor;
    }

    public void setEmailSecondaryAdvisor(String emailSecondaryAdvisor) {
        this.emailSecondaryAdvisor = emailSecondaryAdvisor;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public LocalDate getLastActivityMonth() {
        return lastActivityMonth;
    }

    public void setLastActivityMonth(LocalDate lastActivityMonth) {
        this.lastActivityMonth = lastActivityMonth;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getRestrictionDate() {
        return restrictionDate;
    }

    public void setRestrictionDate(String restrictionDate) {
        this.restrictionDate = restrictionDate;
    }

    public BigDecimal getFondeo() {
        return fondeo;
    }

    public void setFondeo(BigDecimal fondeo) {
        this.fondeo = fondeo;
    }

    public BigDecimal getMontoComprometido() {
        return montoComprometido;
    }

    public void setMontoComprometido(BigDecimal montoComprometido) {
        this.montoComprometido = montoComprometido;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getLastProcessDate() {
        return lastProcessDate;
    }

    public void setLastProcessDate(String lastProcessDate) {
        this.lastProcessDate = lastProcessDate;
    }

    public String getLastProcessStamp() {
        return lastProcessStamp;
    }

    public void setLastProcessStamp(String lastProcessStamp) {
        this.lastProcessStamp = lastProcessStamp;
    }

    public Boolean getIsLastInfo() {
        return isLastInfo;
    }

    public void setIsLastInfo(Boolean isLastInfo) {
        this.isLastInfo = isLastInfo;
    }

    public String getAcctTypeInd() {
        return acctTypeInd;
    }

    public void setAcctTypeInd(String acctTypeInd) {
        this.acctTypeInd = acctTypeInd;
    }

    public Long getRankOrder() {
        return rankOrder;
    }

    public void setRankOrder(Long rankOrder) {
        this.rankOrder = rankOrder;
    }

    public Boolean getIsLastSchemaByAccountNo() {
        return isLastSchemaByAccountNo;
    }

    public void setIsLastSchemaByAccountNo(Boolean isLastSchemaByAccountNo) {
        this.isLastSchemaByAccountNo = isLastSchemaByAccountNo;
    }

    public Boolean getCuentaAbierta() {
        return cuentaAbierta;
    }

    public void setCuentaAbierta(Boolean cuentaAbierta) {
        this.cuentaAbierta = cuentaAbierta;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public void setIdCuentaCustodio(String idCuentaCustodio) {
        this.idCuentaCustodio = idCuentaCustodio;
    }

    public Integer getNamelines() {
        return namelines;
    }

    public void setNamelines(Integer namelines) {
        this.namelines = namelines;
    }

    public String getNameLine1() {
        return nameLine1;
    }

    public void setNameLine1(String nameLine1) {
        this.nameLine1 = nameLine1;
    }

    public String getNameLine2() {
        return nameLine2;
    }

    public void setNameLine2(String nameLine2) {
        this.nameLine2 = nameLine2;
    }

    public String getNameLine3() {
        return nameLine3;
    }

    public void setNameLine3(String nameLine3) {
        this.nameLine3 = nameLine3;
    }

    public String getNameLine4() {
        return nameLine4;
    }

    public void setNameLine4(String nameLine4) {
        this.nameLine4 = nameLine4;
    }

    public String getNameLine5() {
        return nameLine5;
    }

    public void setNameLine5(String nameLine5) {
        this.nameLine5 = nameLine5;
    }

    public String getNameLine6() {
        return nameLine6;
    }

    public void setNameLine6(String nameLine6) {
        this.nameLine6 = nameLine6;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getW8Status() {
        return w8Status;
    }

    public void setW8Status(String w8Status) {
        this.w8Status = w8Status;
    }

    public String getW9Status() {
        return w9Status;
    }

    public void setW9Status(String w9Status) {
        this.w9Status = w9Status;
    }

    public String getDiscrTradingCode() {
        return discrTradingCode;
    }

    public void setDiscrTradingCode(String discrTradingCode) {
        this.discrTradingCode = discrTradingCode;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getCma() {
        return cma;
    }

    public void setCma(String cma) {
        this.cma = cma;
    }

    public String getLastStmtCym() {
        return lastStmtCym;
    }

    public void setLastStmtCym(String lastStmtCym) {
        this.lastStmtCym = lastStmtCym;
    }

    public String getLastActivityCym() {
        return lastActivityCym;
    }

    public void setLastActivityCym(String lastActivityCym) {
        this.lastActivityCym = lastActivityCym;
    }

    public String getMarginSi1() {
        return marginSi1;
    }

    public void setMarginSi1(String marginSi1) {
        this.marginSi1 = marginSi1;
    }

    public String getMarginSi2() {
        return marginSi2;
    }

    public void setMarginSi2(String marginSi2) {
        this.marginSi2 = marginSi2;
    }

    public String getRestrictionCode() {
        return restrictionCode;
    }

    public void setRestrictionCode(String restrictionCode) {
        this.restrictionCode = restrictionCode;
    }

    public String getRestrictionCodeValue() {
        return restrictionCodeValue;
    }

    public void setRestrictionCodeValue(String restrictionCodeValue) {
        this.restrictionCodeValue = restrictionCodeValue;
    }

    public String getAccountRestriction() {
        return accountRestriction;
    }

    public void setAccountRestriction(String accountRestriction) {
        this.accountRestriction = accountRestriction;
    }

    public String getRegistradorUser() {
        return registradorUser;
    }

    public void setRegistradorUser(String registradorUser) {
        this.registradorUser = registradorUser;
    }

    public Instant getRegistradorTimestamp() {
        return registradorTimestamp;
    }

    public void setRegistradorTimestamp(Instant registradorTimestamp) {
        this.registradorTimestamp = registradorTimestamp;
    }

    public String getModificadorUser() {
        return modificadorUser;
    }

    public void setModificadorUser(String modificadorUser) {
        this.modificadorUser = modificadorUser;
    }

    public Instant getModificadorTimestamp() {
        return modificadorTimestamp;
    }

    public void setModificadorTimestamp(Instant modificadorTimestamp) {
        this.modificadorTimestamp = modificadorTimestamp;
    }

    public Integer getIdEstadoRectificacion() {
        return idEstadoRectificacion;
    }

    public void setIdEstadoRectificacion(Integer idEstadoRectificacion) {
        this.idEstadoRectificacion = idEstadoRectificacion;
    }

}