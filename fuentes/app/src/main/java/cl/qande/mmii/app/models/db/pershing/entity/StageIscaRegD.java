package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_d", schema = "stage_pershing")
public class StageIscaRegD {
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
    @Column(name = "secutiry_description_line_6", length = 100)
    private String secutiryDescriptionLine6;

    @Column(name = "put_price", precision = 45, scale = 20)
    private BigDecimal putPrice;

    @Column(name = "put_date")
    private LocalDate putDate;

    @Column(name = "second_premium_call_price", precision = 45, scale = 20)
    private BigDecimal secondPremiumCallPrice;

    @Column(name = "second_premium_call_date")
    private LocalDate secondPremiumCallDate;

    @Column(name = "called_date")
    private LocalDate calledDate;

    @Size(max = 100)
    @Column(name = "pool_number", length = 100)
    private String poolNumber;

    @Column(name = "factor", precision = 45, scale = 20)
    private BigDecimal factor;

    @Column(name = "factor_date")
    private LocalDate factorDate;

    @Size(max = 100)
    @Column(name = "previous_factor", length = 100)
    private String previousFactor;

    @Column(name = "previous_factor_date")
    private LocalDate previousFactorDate;

    @Size(max = 100)
    @Column(name = "variable_rate_indicator", length = 100)
    private String variableRateIndicator;

    @Column(name = "next_last_coupon_date")
    private LocalDate nextLastCouponDate;

    @Size(max = 100)
    @Column(name = "structured_product_ind", length = 100)
    private String structuredProductInd;

    @Size(max = 100)
    @Column(name = "perpetual_bond_indicator", length = 100)
    private String perpetualBondIndicator;

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

    public String getSecutiryDescriptionLine6() {
        return secutiryDescriptionLine6;
    }

    public void setSecutiryDescriptionLine6(String secutiryDescriptionLine6) {
        this.secutiryDescriptionLine6 = secutiryDescriptionLine6;
    }

    public BigDecimal getPutPrice() {
        return putPrice;
    }

    public void setPutPrice(BigDecimal putPrice) {
        this.putPrice = putPrice;
    }

    public LocalDate getPutDate() {
        return putDate;
    }

    public void setPutDate(LocalDate putDate) {
        this.putDate = putDate;
    }

    public BigDecimal getSecondPremiumCallPrice() {
        return secondPremiumCallPrice;
    }

    public void setSecondPremiumCallPrice(BigDecimal secondPremiumCallPrice) {
        this.secondPremiumCallPrice = secondPremiumCallPrice;
    }

    public LocalDate getSecondPremiumCallDate() {
        return secondPremiumCallDate;
    }

    public void setSecondPremiumCallDate(LocalDate secondPremiumCallDate) {
        this.secondPremiumCallDate = secondPremiumCallDate;
    }

    public LocalDate getCalledDate() {
        return calledDate;
    }

    public void setCalledDate(LocalDate calledDate) {
        this.calledDate = calledDate;
    }

    public String getPoolNumber() {
        return poolNumber;
    }

    public void setPoolNumber(String poolNumber) {
        this.poolNumber = poolNumber;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public LocalDate getFactorDate() {
        return factorDate;
    }

    public void setFactorDate(LocalDate factorDate) {
        this.factorDate = factorDate;
    }

    public String getPreviousFactor() {
        return previousFactor;
    }

    public void setPreviousFactor(String previousFactor) {
        this.previousFactor = previousFactor;
    }

    public LocalDate getPreviousFactorDate() {
        return previousFactorDate;
    }

    public void setPreviousFactorDate(LocalDate previousFactorDate) {
        this.previousFactorDate = previousFactorDate;
    }

    public String getVariableRateIndicator() {
        return variableRateIndicator;
    }

    public void setVariableRateIndicator(String variableRateIndicator) {
        this.variableRateIndicator = variableRateIndicator;
    }

    public LocalDate getNextLastCouponDate() {
        return nextLastCouponDate;
    }

    public void setNextLastCouponDate(LocalDate nextLastCouponDate) {
        this.nextLastCouponDate = nextLastCouponDate;
    }

    public String getStructuredProductInd() {
        return structuredProductInd;
    }

    public void setStructuredProductInd(String structuredProductInd) {
        this.structuredProductInd = structuredProductInd;
    }

    public String getPerpetualBondIndicator() {
        return perpetualBondIndicator;
    }

    public void setPerpetualBondIndicator(String perpetualBondIndicator) {
        this.perpetualBondIndicator = perpetualBondIndicator;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}