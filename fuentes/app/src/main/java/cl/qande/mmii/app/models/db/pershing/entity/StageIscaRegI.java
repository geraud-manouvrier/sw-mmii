package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_i", schema = "stage_pershing")
public class StageIscaRegI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_proceso")
    private Long idProceso;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "record_indicator", length = 100)
    private String recordIndicator;

    @Column(name = "record_id_sequence_number")
    private Integer recordIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "cusip_number", length = 100)
    private String cusipNumber;

    @Size(max = 100)
    @Column(name = "campo_4", length = 100)
    private String campo4;

    @Size(max = 100)
    @Column(name = "option_root_id", length = 100)
    private String optionRootId;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Size(max = 100)
    @Column(name = "call_put_indicator", length = 100)
    private String callPutIndicator;

    @Column(name = "strike_price", precision = 45, scale = 20)
    private BigDecimal strikePrice;

    @Size(max = 100)
    @Column(name = "fund_type", length = 100)
    private String fundType;

    @Size(max = 100)
    @Column(name = "broad_narrow_indicator", length = 100)
    private String broadNarrowIndicator;

    @Column(name = "leverage_factor", precision = 45, scale = 20)
    private BigDecimal leverageFactor;

    @Size(max = 100)
    @Column(name = "leverage_factor_sign", length = 100)
    private String leverageFactorSign;

    @Column(name = "outstanding_shares_update_date")
    private LocalDate outstandingSharesUpdateDate;

    @Size(max = 100)
    @Column(name = "expanded_symbol", length = 100)
    private String expandedSymbol;

    @Size(max = 100)
    @Column(name = "state_of_issuance", length = 100)
    private String stateOfIssuance;

    @Size(max = 100)
    @Column(name = "option_excercise_pricing_model_code", length = 100)
    private String optionExcercisePricingModelCode;

    @Column(name = "first_accrual_date")
    private LocalDate firstAccrualDate;

    @Size(max = 100)
    @Column(name = "tranche_code", length = 100)
    private String trancheCode;

    @Size(max = 100)
    @Column(name = "campo_19", length = 100)
    private String campo19;

    @Size(max = 100)
    @Column(name = "worthless_security_indicator", length = 100)
    private String worthlessSecurityIndicator;

    @Column(name = "uit_termination_code")
    private Integer uitTerminationCode;

    @Size(max = 100)
    @Column(name = "fdic_certification_number", length = 100)
    private String fdicCertificationNumber;

    @Size(max = 100)
    @Column(name = "revenue_stream", length = 100)
    private String revenueStream;

    @Size(max = 100)
    @Column(name = "restricted_marijuana_ind", length = 100)
    private String restrictedMarijuanaInd;

    @Size(max = 100)
    @Column(name = "campo_25", length = 100)
    private String campo25;

    @Size(max = 100)
    @Column(name = "eor", length = 100)
    private String eor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getRecordIndicator() {
        return recordIndicator;
    }

    public void setRecordIndicator(String recordIndicator) {
        this.recordIndicator = recordIndicator;
    }

    public Integer getRecordIdSequenceNumber() {
        return recordIdSequenceNumber;
    }

    public void setRecordIdSequenceNumber(Integer recordIdSequenceNumber) {
        this.recordIdSequenceNumber = recordIdSequenceNumber;
    }

    public String getCusipNumber() {
        return cusipNumber;
    }

    public void setCusipNumber(String cusipNumber) {
        this.cusipNumber = cusipNumber;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getOptionRootId() {
        return optionRootId;
    }

    public void setOptionRootId(String optionRootId) {
        this.optionRootId = optionRootId;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCallPutIndicator() {
        return callPutIndicator;
    }

    public void setCallPutIndicator(String callPutIndicator) {
        this.callPutIndicator = callPutIndicator;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getBroadNarrowIndicator() {
        return broadNarrowIndicator;
    }

    public void setBroadNarrowIndicator(String broadNarrowIndicator) {
        this.broadNarrowIndicator = broadNarrowIndicator;
    }

    public BigDecimal getLeverageFactor() {
        return leverageFactor;
    }

    public void setLeverageFactor(BigDecimal leverageFactor) {
        this.leverageFactor = leverageFactor;
    }

    public String getLeverageFactorSign() {
        return leverageFactorSign;
    }

    public void setLeverageFactorSign(String leverageFactorSign) {
        this.leverageFactorSign = leverageFactorSign;
    }

    public LocalDate getOutstandingSharesUpdateDate() {
        return outstandingSharesUpdateDate;
    }

    public void setOutstandingSharesUpdateDate(LocalDate outstandingSharesUpdateDate) {
        this.outstandingSharesUpdateDate = outstandingSharesUpdateDate;
    }

    public String getExpandedSymbol() {
        return expandedSymbol;
    }

    public void setExpandedSymbol(String expandedSymbol) {
        this.expandedSymbol = expandedSymbol;
    }

    public String getStateOfIssuance() {
        return stateOfIssuance;
    }

    public void setStateOfIssuance(String stateOfIssuance) {
        this.stateOfIssuance = stateOfIssuance;
    }

    public String getOptionExcercisePricingModelCode() {
        return optionExcercisePricingModelCode;
    }

    public void setOptionExcercisePricingModelCode(String optionExcercisePricingModelCode) {
        this.optionExcercisePricingModelCode = optionExcercisePricingModelCode;
    }

    public LocalDate getFirstAccrualDate() {
        return firstAccrualDate;
    }

    public void setFirstAccrualDate(LocalDate firstAccrualDate) {
        this.firstAccrualDate = firstAccrualDate;
    }

    public String getTrancheCode() {
        return trancheCode;
    }

    public void setTrancheCode(String trancheCode) {
        this.trancheCode = trancheCode;
    }

    public String getCampo19() {
        return campo19;
    }

    public void setCampo19(String campo19) {
        this.campo19 = campo19;
    }

    public String getWorthlessSecurityIndicator() {
        return worthlessSecurityIndicator;
    }

    public void setWorthlessSecurityIndicator(String worthlessSecurityIndicator) {
        this.worthlessSecurityIndicator = worthlessSecurityIndicator;
    }

    public Integer getUitTerminationCode() {
        return uitTerminationCode;
    }

    public void setUitTerminationCode(Integer uitTerminationCode) {
        this.uitTerminationCode = uitTerminationCode;
    }

    public String getFdicCertificationNumber() {
        return fdicCertificationNumber;
    }

    public void setFdicCertificationNumber(String fdicCertificationNumber) {
        this.fdicCertificationNumber = fdicCertificationNumber;
    }

    public String getRevenueStream() {
        return revenueStream;
    }

    public void setRevenueStream(String revenueStream) {
        this.revenueStream = revenueStream;
    }

    public String getRestrictedMarijuanaInd() {
        return restrictedMarijuanaInd;
    }

    public void setRestrictedMarijuanaInd(String restrictedMarijuanaInd) {
        this.restrictedMarijuanaInd = restrictedMarijuanaInd;
    }

    public String getCampo25() {
        return campo25;
    }

    public void setCampo25(String campo25) {
        this.campo25 = campo25;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}