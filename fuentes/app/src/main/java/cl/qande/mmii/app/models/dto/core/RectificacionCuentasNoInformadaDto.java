package cl.qande.mmii.app.models.dto.core;

import cl.qande.mmii.app.models.db.core.entity.RectificacionCuentasNoInformada;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link RectificacionCuentasNoInformada}
 */
public class RectificacionCuentasNoInformadaDto implements Serializable {
    private Long id;
    @Size(max = 100)
    private String tipoReg;
    @Size(max = 100)
    private String custodian;
    @Size(max = 100)
    private String clientId;
    @Size(max = 100)
    private String firmNo;
    @Size(max = 100)
    private String subNo;
    @Size(max = 100)
    private String repNo;
    @Size(max = 100)
    private String officeId;
    @Size(max = 100)
    private String accountNo;
    @Size(max = 100)
    private String name;
    @Size(max = 100)
    private String fullName;
    @Size(max = 100)
    private String address;
    @Size(max = 100)
    private String shortName;
    private LocalDate dateOfBirth;
    @Size(max = 100)
    private String acctStatusValue;
    @Size(max = 100)
    private String email;
    @Size(max = 100)
    private String countryCodeValue;
    @Size(max = 100)
    private String country;
    @Size(max = 100)
    private String w8Date;
    private LocalDate w9Date;
    @Size(max = 100)
    private String w8StatusValue;
    @Size(max = 100)
    private String w9StatusValue;
    @Size(max = 100)
    private String discrTradingCodeValue;
    @Size(max = 100)
    private String accountType;
    @Size(max = 100)
    private String contratosPa;
    @Size(max = 100)
    private String cashMarginAccount;
    @Size(max = 100)
    private String modeloRelacionamiento;
    @Size(max = 100)
    private String debitCardIndicator;
    @Size(max = 100)
    private String openDate;
    private LocalDate closeDate;
    @Size(max = 100)
    private String participantType;
    @Size(max = 100)
    private String clientInvestmentProfile;
    @Size(max = 100)
    private String portfolio;
    @Size(max = 100)
    private String tipoServicio;
    private BigDecimal advisoryFeeAnnualPct;
    private LocalDate lastStatementDate;
    @Size(max = 100)
    private String mainAdvisor;
    @Size(max = 100)
    private String secondaryAdvisor;
    @Size(max = 100)
    private String emailMainAdvisor;
    @Size(max = 100)
    private String emailSecondaryAdvisor;
    @Size(max = 100)
    private String taxId;
    private LocalDate lastActivityMonth;
    @Size(max = 100)
    private String institutionCode;
    @Size(max = 100)
    private String restrictionDate;
    private BigDecimal fondeo;
    private BigDecimal montoComprometido;
    @Size(max = 100)
    private String processStamp;
    @Size(max = 100)
    private String processDate;
    @Size(max = 100)
    private String lastProcessDate;
    @Size(max = 100)
    private String lastProcessStamp;
    private Boolean isLastInfo;
    @Size(max = 100)
    private String acctTypeInd;
    private Long rankOrder;
    private Boolean isLastSchemaByAccountNo;
    private Boolean cuentaAbierta;
    @Size(max = 100)
    private String rep;
    @Size(max = 100)
    private String branch;
    @Size(max = 100)
    private String idCuentaCustodio;
    private Integer namelines;
    @Size(max = 100)
    private String nameLine1;
    @Size(max = 100)
    private String nameLine2;
    @Size(max = 100)
    private String nameLine3;
    @Size(max = 100)
    private String nameLine4;
    @Size(max = 100)
    private String nameLine5;
    @Size(max = 100)
    private String nameLine6;
    @Size(max = 100)
    private String acctStatus;
    @Size(max = 100)
    private String countryCode;
    @Size(max = 100)
    private String w8Status;
    @Size(max = 100)
    private String w9Status;
    @Size(max = 100)
    private String discrTradingCode;
    @Size(max = 100)
    private String socialCode;
    @Size(max = 100)
    private String instCode;
    @Size(max = 100)
    private String cma;
    @Size(max = 100)
    private String lastStmtCym;
    @Size(max = 100)
    private String lastActivityCym;
    @Size(max = 100)
    private String marginSi1;
    @Size(max = 100)
    private String marginSi2;
    @Size(max = 100)
    private String restrictionCode;
    @Size(max = 1000)
    private String restrictionCodeValue;
    @Size(max = 100)
    private String accountRestriction;
    @NotNull
    @Size(max = 100)
    private String registradorUser;
    @NotNull
    private Instant registradorTimestamp;
    @Size(max = 100)
    private String modificadorUser;
    private Instant modificadorTimestamp;
    private Integer idEstadoRectificacion;

    public RectificacionCuentasNoInformadaDto() {
    }

    @SuppressWarnings("squid:S00107")
    public RectificacionCuentasNoInformadaDto(Long id, String tipoReg, String custodian, String clientId, String firmNo, String subNo, String repNo, String officeId, String accountNo, String name, String fullName, String address, String shortName, LocalDate dateOfBirth, String acctStatusValue, String email, String countryCodeValue, String country, String w8Date, LocalDate w9Date, String w8StatusValue, String w9StatusValue, String discrTradingCodeValue, String accountType, String contratosPa, String cashMarginAccount, String modeloRelacionamiento, String debitCardIndicator, String openDate, LocalDate closeDate, String participantType, String clientInvestmentProfile, String portfolio, String tipoServicio, BigDecimal advisoryFeeAnnualPct, LocalDate lastStatementDate, String mainAdvisor, String secondaryAdvisor, String emailMainAdvisor, String emailSecondaryAdvisor, String taxId, LocalDate lastActivityMonth, String institutionCode, String restrictionDate, BigDecimal fondeo, BigDecimal montoComprometido, String processStamp, String processDate, String lastProcessDate, String lastProcessStamp, Boolean isLastInfo, String acctTypeInd, Long rankOrder, Boolean isLastSchemaByAccountNo, Boolean cuentaAbierta, String rep, String branch, String idCuentaCustodio, Integer namelines, String nameLine1, String nameLine2, String nameLine3, String nameLine4, String nameLine5, String nameLine6, String acctStatus, String countryCode, String w8Status, String w9Status, String discrTradingCode, String socialCode, String instCode, String cma, String lastStmtCym, String lastActivityCym, String marginSi1, String marginSi2, String restrictionCode, String restrictionCodeValue, String accountRestriction, String registradorUser, Instant registradorTimestamp, String modificadorUser, Instant modificadorTimestamp, Integer idEstadoRectificacion) {
        this.id = id;
        this.tipoReg = tipoReg;
        this.custodian = custodian;
        this.clientId = clientId;
        this.firmNo = firmNo;
        this.subNo = subNo;
        this.repNo = repNo;
        this.officeId = officeId;
        this.accountNo = accountNo;
        this.name = name;
        this.fullName = fullName;
        this.address = address;
        this.shortName = shortName;
        this.dateOfBirth = dateOfBirth;
        this.acctStatusValue = acctStatusValue;
        this.email = email;
        this.countryCodeValue = countryCodeValue;
        this.country = country;
        this.w8Date = w8Date;
        this.w9Date = w9Date;
        this.w8StatusValue = w8StatusValue;
        this.w9StatusValue = w9StatusValue;
        this.discrTradingCodeValue = discrTradingCodeValue;
        this.accountType = accountType;
        this.contratosPa = contratosPa;
        this.cashMarginAccount = cashMarginAccount;
        this.modeloRelacionamiento = modeloRelacionamiento;
        this.debitCardIndicator = debitCardIndicator;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.participantType = participantType;
        this.clientInvestmentProfile = clientInvestmentProfile;
        this.portfolio = portfolio;
        this.tipoServicio = tipoServicio;
        this.advisoryFeeAnnualPct = advisoryFeeAnnualPct;
        this.lastStatementDate = lastStatementDate;
        this.mainAdvisor = mainAdvisor;
        this.secondaryAdvisor = secondaryAdvisor;
        this.emailMainAdvisor = emailMainAdvisor;
        this.emailSecondaryAdvisor = emailSecondaryAdvisor;
        this.taxId = taxId;
        this.lastActivityMonth = lastActivityMonth;
        this.institutionCode = institutionCode;
        this.restrictionDate = restrictionDate;
        this.fondeo = fondeo;
        this.montoComprometido = montoComprometido;
        this.processStamp = processStamp;
        this.processDate = processDate;
        this.lastProcessDate = lastProcessDate;
        this.lastProcessStamp = lastProcessStamp;
        this.isLastInfo = isLastInfo;
        this.acctTypeInd = acctTypeInd;
        this.rankOrder = rankOrder;
        this.isLastSchemaByAccountNo = isLastSchemaByAccountNo;
        this.cuentaAbierta = cuentaAbierta;
        this.rep = rep;
        this.branch = branch;
        this.idCuentaCustodio = idCuentaCustodio;
        this.namelines = namelines;
        this.nameLine1 = nameLine1;
        this.nameLine2 = nameLine2;
        this.nameLine3 = nameLine3;
        this.nameLine4 = nameLine4;
        this.nameLine5 = nameLine5;
        this.nameLine6 = nameLine6;
        this.acctStatus = acctStatus;
        this.countryCode = countryCode;
        this.w8Status = w8Status;
        this.w9Status = w9Status;
        this.discrTradingCode = discrTradingCode;
        this.socialCode = socialCode;
        this.instCode = instCode;
        this.cma = cma;
        this.lastStmtCym = lastStmtCym;
        this.lastActivityCym = lastActivityCym;
        this.marginSi1 = marginSi1;
        this.marginSi2 = marginSi2;
        this.restrictionCode = restrictionCode;
        this.restrictionCodeValue = restrictionCodeValue;
        this.accountRestriction = accountRestriction;
        this.registradorUser = registradorUser;
        this.registradorTimestamp = registradorTimestamp;
        this.modificadorUser = modificadorUser;
        this.modificadorTimestamp = modificadorTimestamp;
        this.idEstadoRectificacion = idEstadoRectificacion;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectificacionCuentasNoInformadaDto entity = (RectificacionCuentasNoInformadaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipoReg, entity.tipoReg) &&
                Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.firmNo, entity.firmNo) &&
                Objects.equals(this.subNo, entity.subNo) &&
                Objects.equals(this.repNo, entity.repNo) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.fullName, entity.fullName) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.shortName, entity.shortName) &&
                Objects.equals(this.dateOfBirth, entity.dateOfBirth) &&
                Objects.equals(this.acctStatusValue, entity.acctStatusValue) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.countryCodeValue, entity.countryCodeValue) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.w8Date, entity.w8Date) &&
                Objects.equals(this.w9Date, entity.w9Date) &&
                Objects.equals(this.w8StatusValue, entity.w8StatusValue) &&
                Objects.equals(this.w9StatusValue, entity.w9StatusValue) &&
                Objects.equals(this.discrTradingCodeValue, entity.discrTradingCodeValue) &&
                Objects.equals(this.accountType, entity.accountType) &&
                Objects.equals(this.contratosPa, entity.contratosPa) &&
                Objects.equals(this.cashMarginAccount, entity.cashMarginAccount) &&
                Objects.equals(this.modeloRelacionamiento, entity.modeloRelacionamiento) &&
                Objects.equals(this.debitCardIndicator, entity.debitCardIndicator) &&
                Objects.equals(this.openDate, entity.openDate) &&
                Objects.equals(this.closeDate, entity.closeDate) &&
                Objects.equals(this.participantType, entity.participantType) &&
                Objects.equals(this.clientInvestmentProfile, entity.clientInvestmentProfile) &&
                Objects.equals(this.portfolio, entity.portfolio) &&
                Objects.equals(this.tipoServicio, entity.tipoServicio) &&
                Objects.equals(this.advisoryFeeAnnualPct, entity.advisoryFeeAnnualPct) &&
                Objects.equals(this.lastStatementDate, entity.lastStatementDate) &&
                Objects.equals(this.mainAdvisor, entity.mainAdvisor) &&
                Objects.equals(this.secondaryAdvisor, entity.secondaryAdvisor) &&
                Objects.equals(this.emailMainAdvisor, entity.emailMainAdvisor) &&
                Objects.equals(this.emailSecondaryAdvisor, entity.emailSecondaryAdvisor) &&
                Objects.equals(this.taxId, entity.taxId) &&
                Objects.equals(this.lastActivityMonth, entity.lastActivityMonth) &&
                Objects.equals(this.institutionCode, entity.institutionCode) &&
                Objects.equals(this.restrictionDate, entity.restrictionDate) &&
                Objects.equals(this.fondeo, entity.fondeo) &&
                Objects.equals(this.montoComprometido, entity.montoComprometido) &&
                Objects.equals(this.processStamp, entity.processStamp) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.lastProcessDate, entity.lastProcessDate) &&
                Objects.equals(this.lastProcessStamp, entity.lastProcessStamp) &&
                Objects.equals(this.isLastInfo, entity.isLastInfo) &&
                Objects.equals(this.acctTypeInd, entity.acctTypeInd) &&
                Objects.equals(this.rankOrder, entity.rankOrder) &&
                Objects.equals(this.isLastSchemaByAccountNo, entity.isLastSchemaByAccountNo) &&
                Objects.equals(this.cuentaAbierta, entity.cuentaAbierta) &&
                Objects.equals(this.rep, entity.rep) &&
                Objects.equals(this.branch, entity.branch) &&
                Objects.equals(this.idCuentaCustodio, entity.idCuentaCustodio) &&
                Objects.equals(this.namelines, entity.namelines) &&
                Objects.equals(this.nameLine1, entity.nameLine1) &&
                Objects.equals(this.nameLine2, entity.nameLine2) &&
                Objects.equals(this.nameLine3, entity.nameLine3) &&
                Objects.equals(this.nameLine4, entity.nameLine4) &&
                Objects.equals(this.nameLine5, entity.nameLine5) &&
                Objects.equals(this.nameLine6, entity.nameLine6) &&
                Objects.equals(this.acctStatus, entity.acctStatus) &&
                Objects.equals(this.countryCode, entity.countryCode) &&
                Objects.equals(this.w8Status, entity.w8Status) &&
                Objects.equals(this.w9Status, entity.w9Status) &&
                Objects.equals(this.discrTradingCode, entity.discrTradingCode) &&
                Objects.equals(this.socialCode, entity.socialCode) &&
                Objects.equals(this.instCode, entity.instCode) &&
                Objects.equals(this.cma, entity.cma) &&
                Objects.equals(this.lastStmtCym, entity.lastStmtCym) &&
                Objects.equals(this.lastActivityCym, entity.lastActivityCym) &&
                Objects.equals(this.marginSi1, entity.marginSi1) &&
                Objects.equals(this.marginSi2, entity.marginSi2) &&
                Objects.equals(this.restrictionCode, entity.restrictionCode) &&
                Objects.equals(this.restrictionCodeValue, entity.restrictionCodeValue) &&
                Objects.equals(this.accountRestriction, entity.accountRestriction) &&
                Objects.equals(this.registradorUser, entity.registradorUser) &&
                Objects.equals(this.registradorTimestamp, entity.registradorTimestamp) &&
                Objects.equals(this.modificadorUser, entity.modificadorUser) &&
                Objects.equals(this.modificadorTimestamp, entity.modificadorTimestamp) &&
                Objects.equals(this.idEstadoRectificacion, entity.idEstadoRectificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoReg, custodian, clientId, firmNo, subNo, repNo, officeId, accountNo, name, fullName, address, shortName, dateOfBirth, acctStatusValue, email, countryCodeValue, country, w8Date, w9Date, w8StatusValue, w9StatusValue, discrTradingCodeValue, accountType, contratosPa, cashMarginAccount, modeloRelacionamiento, debitCardIndicator, openDate, closeDate, participantType, clientInvestmentProfile, portfolio, tipoServicio, advisoryFeeAnnualPct, lastStatementDate, mainAdvisor, secondaryAdvisor, emailMainAdvisor, emailSecondaryAdvisor, taxId, lastActivityMonth, institutionCode, restrictionDate, fondeo, montoComprometido, processStamp, processDate, lastProcessDate, lastProcessStamp, isLastInfo, acctTypeInd, rankOrder, isLastSchemaByAccountNo, cuentaAbierta, rep, branch, idCuentaCustodio, namelines, nameLine1, nameLine2, nameLine3, nameLine4, nameLine5, nameLine6, acctStatus, countryCode, w8Status, w9Status, discrTradingCode, socialCode, instCode, cma, lastStmtCym, lastActivityCym, marginSi1, marginSi2, restrictionCode, restrictionCodeValue, accountRestriction, registradorUser, registradorTimestamp, modificadorUser, modificadorTimestamp, idEstadoRectificacion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipoReg = " + tipoReg + ", " +
                "custodian = " + custodian + ", " +
                "clientId = " + clientId + ", " +
                "firmNo = " + firmNo + ", " +
                "subNo = " + subNo + ", " +
                "repNo = " + repNo + ", " +
                "officeId = " + officeId + ", " +
                "accountNo = " + accountNo + ", " +
                "name = " + name + ", " +
                "fullName = " + fullName + ", " +
                "address = " + address + ", " +
                "shortName = " + shortName + ", " +
                "dateOfBirth = " + dateOfBirth + ", " +
                "acctStatusValue = " + acctStatusValue + ", " +
                "email = " + email + ", " +
                "countryCodeValue = " + countryCodeValue + ", " +
                "country = " + country + ", " +
                "w8Date = " + w8Date + ", " +
                "w9Date = " + w9Date + ", " +
                "w8StatusValue = " + w8StatusValue + ", " +
                "w9StatusValue = " + w9StatusValue + ", " +
                "discrTradingCodeValue = " + discrTradingCodeValue + ", " +
                "accountType = " + accountType + ", " +
                "contratosPa = " + contratosPa + ", " +
                "cashMarginAccount = " + cashMarginAccount + ", " +
                "modeloRelacionamiento = " + modeloRelacionamiento + ", " +
                "debitCardIndicator = " + debitCardIndicator + ", " +
                "openDate = " + openDate + ", " +
                "closeDate = " + closeDate + ", " +
                "participantType = " + participantType + ", " +
                "clientInvestmentProfile = " + clientInvestmentProfile + ", " +
                "portfolio = " + portfolio + ", " +
                "tipoServicio = " + tipoServicio + ", " +
                "advisoryFeeAnnualPct = " + advisoryFeeAnnualPct + ", " +
                "lastStatementDate = " + lastStatementDate + ", " +
                "mainAdvisor = " + mainAdvisor + ", " +
                "secondaryAdvisor = " + secondaryAdvisor + ", " +
                "emailMainAdvisor = " + emailMainAdvisor + ", " +
                "emailSecondaryAdvisor = " + emailSecondaryAdvisor + ", " +
                "taxId = " + taxId + ", " +
                "lastActivityMonth = " + lastActivityMonth + ", " +
                "institutionCode = " + institutionCode + ", " +
                "restrictionDate = " + restrictionDate + ", " +
                "fondeo = " + fondeo + ", " +
                "montoComprometido = " + montoComprometido + ", " +
                "processStamp = " + processStamp + ", " +
                "processDate = " + processDate + ", " +
                "lastProcessDate = " + lastProcessDate + ", " +
                "lastProcessStamp = " + lastProcessStamp + ", " +
                "isLastInfo = " + isLastInfo + ", " +
                "acctTypeInd = " + acctTypeInd + ", " +
                "rankOrder = " + rankOrder + ", " +
                "isLastSchemaByAccountNo = " + isLastSchemaByAccountNo + ", " +
                "cuentaAbierta = " + cuentaAbierta + ", " +
                "rep = " + rep + ", " +
                "branch = " + branch + ", " +
                "idCuentaCustodio = " + idCuentaCustodio + ", " +
                "namelines = " + namelines + ", " +
                "nameLine1 = " + nameLine1 + ", " +
                "nameLine2 = " + nameLine2 + ", " +
                "nameLine3 = " + nameLine3 + ", " +
                "nameLine4 = " + nameLine4 + ", " +
                "nameLine5 = " + nameLine5 + ", " +
                "nameLine6 = " + nameLine6 + ", " +
                "acctStatus = " + acctStatus + ", " +
                "countryCode = " + countryCode + ", " +
                "w8Status = " + w8Status + ", " +
                "w9Status = " + w9Status + ", " +
                "discrTradingCode = " + discrTradingCode + ", " +
                "socialCode = " + socialCode + ", " +
                "instCode = " + instCode + ", " +
                "cma = " + cma + ", " +
                "lastStmtCym = " + lastStmtCym + ", " +
                "lastActivityCym = " + lastActivityCym + ", " +
                "marginSi1 = " + marginSi1 + ", " +
                "marginSi2 = " + marginSi2 + ", " +
                "restrictionCode = " + restrictionCode + ", " +
                "restrictionCodeValue = " + restrictionCodeValue + ", " +
                "accountRestriction = " + accountRestriction + ", " +
                "registradorUser = " + registradorUser + ", " +
                "registradorTimestamp = " + registradorTimestamp + ", " +
                "modificadorUser = " + modificadorUser + ", " +
                "modificadorTimestamp = " + modificadorTimestamp + ", " +
                "idEstadoRectificacion = " + idEstadoRectificacion + ")";
    }
}