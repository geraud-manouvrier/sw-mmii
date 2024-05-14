package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_a", schema = "stage_pershing")
public class StageIscaRegA {
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
    @Column(name = "security_type", length = 100)
    private String securityType;

    @Size(max = 100)
    @Column(name = "security_modifier", length = 100)
    private String securityModifier;

    @Size(max = 100)
    @Column(name = "security_calculation_code", length = 100)
    private String securityCalculationCode;

    @Size(max = 100)
    @Column(name = "primary_exchange", length = 100)
    private String primaryExchange;

    @Column(name = "coupon_rate_fis_or_indicated_dividend_eq", precision = 45, scale = 20)
    private BigDecimal couponRateFisOrIndicatedDividendEq;

    @Column(name = "maturity_option_expire_date")
    private LocalDate maturityOptionExpireDate;

    @Size(max = 100)
    @Column(name = "underlying_security_cusip", length = 100)
    private String underlyingSecurityCusip;

    @Column(name = "first_call_price_fix_inc_or_strike_price_option", precision = 45, scale = 20)
    private BigDecimal firstCallPriceFixIncOrStrikePriceOption;

    @Column(name = "first_par_call_price_fix_inc_or_units_option", precision = 45, scale = 20)
    private BigDecimal firstParCallPriceFixIncOrUnitsOption;

    @Size(max = 100)
    @Column(name = "primary_symbol", length = 100)
    private String primarySymbol;

    @Size(max = 100)
    @Column(name = "interest_frequency", length = 100)
    private String interestFrequency;

    @Size(max = 100)
    @Column(name = "bond_class", length = 100)
    private String bondClass;

    @Size(max = 100)
    @Column(name = "first_coupon_day", length = 100)
    private String firstCouponDay;

    @Size(max = 100)
    @Column(name = "call_indicator", length = 100)
    private String callIndicator;

    @Size(max = 100)
    @Column(name = "put_indicator", length = 100)
    private String putIndicator;

    @Column(name = "next_par_call_date")
    private LocalDate nextParCallDate;

    @Column(name = "prerefunded_date")
    private LocalDate prerefundedDate;

    @Column(name = "next_premium_call_date")
    private LocalDate nextPremiumCallDate;

    @Column(name = "dated_date_for_fix_inc_or_ex_dividend_date_eq")
    private LocalDate datedDateForFixIncOrExDividendDateEq;

    @Column(name = "first_coupon_fix_inc_or_payable_date_eq")
    private LocalDate firstCouponFixIncOrPayableDateEq;

    @Size(max = 100)
    @Column(name = "campo_24", length = 100)
    private String campo24;

    @Size(max = 100)
    @Column(name = "federal_marginable_ind", length = 100)
    private String federalMarginableInd;

    @Size(max = 100)
    @Column(name = "cns_eligible_code", length = 100)
    private String cnsEligibleCode;

    @Size(max = 100)
    @Column(name = "dtcc_eligible_code", length = 100)
    private String dtccEligibleCode;

    @Size(max = 100)
    @Column(name = "nscc_eligible_code", length = 100)
    private String nsccEligibleCode;

    @Size(max = 100)
    @Column(name = "foreign_security", length = 100)
    private String foreignSecurity;

    @Size(max = 100)
    @Column(name = "second_coupon_day", length = 100)
    private String secondCouponDay;

    @Size(max = 100)
    @Column(name = "dividend_interest_payment_method", length = 100)
    private String dividendInterestPaymentMethod;

    @Size(max = 100)
    @Column(name = "minor_product_code", length = 100)
    private String minorProductCode;

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

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getSecurityModifier() {
        return securityModifier;
    }

    public void setSecurityModifier(String securityModifier) {
        this.securityModifier = securityModifier;
    }

    public String getSecurityCalculationCode() {
        return securityCalculationCode;
    }

    public void setSecurityCalculationCode(String securityCalculationCode) {
        this.securityCalculationCode = securityCalculationCode;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public BigDecimal getCouponRateFisOrIndicatedDividendEq() {
        return couponRateFisOrIndicatedDividendEq;
    }

    public void setCouponRateFisOrIndicatedDividendEq(BigDecimal couponRateFisOrIndicatedDividendEq) {
        this.couponRateFisOrIndicatedDividendEq = couponRateFisOrIndicatedDividendEq;
    }

    public LocalDate getMaturityOptionExpireDate() {
        return maturityOptionExpireDate;
    }

    public void setMaturityOptionExpireDate(LocalDate maturityOptionExpireDate) {
        this.maturityOptionExpireDate = maturityOptionExpireDate;
    }

    public String getUnderlyingSecurityCusip() {
        return underlyingSecurityCusip;
    }

    public void setUnderlyingSecurityCusip(String underlyingSecurityCusip) {
        this.underlyingSecurityCusip = underlyingSecurityCusip;
    }

    public BigDecimal getFirstCallPriceFixIncOrStrikePriceOption() {
        return firstCallPriceFixIncOrStrikePriceOption;
    }

    public void setFirstCallPriceFixIncOrStrikePriceOption(BigDecimal firstCallPriceFixIncOrStrikePriceOption) {
        this.firstCallPriceFixIncOrStrikePriceOption = firstCallPriceFixIncOrStrikePriceOption;
    }

    public BigDecimal getFirstParCallPriceFixIncOrUnitsOption() {
        return firstParCallPriceFixIncOrUnitsOption;
    }

    public void setFirstParCallPriceFixIncOrUnitsOption(BigDecimal firstParCallPriceFixIncOrUnitsOption) {
        this.firstParCallPriceFixIncOrUnitsOption = firstParCallPriceFixIncOrUnitsOption;
    }

    public String getPrimarySymbol() {
        return primarySymbol;
    }

    public void setPrimarySymbol(String primarySymbol) {
        this.primarySymbol = primarySymbol;
    }

    public String getInterestFrequency() {
        return interestFrequency;
    }

    public void setInterestFrequency(String interestFrequency) {
        this.interestFrequency = interestFrequency;
    }

    public String getBondClass() {
        return bondClass;
    }

    public void setBondClass(String bondClass) {
        this.bondClass = bondClass;
    }

    public String getFirstCouponDay() {
        return firstCouponDay;
    }

    public void setFirstCouponDay(String firstCouponDay) {
        this.firstCouponDay = firstCouponDay;
    }

    public String getCallIndicator() {
        return callIndicator;
    }

    public void setCallIndicator(String callIndicator) {
        this.callIndicator = callIndicator;
    }

    public String getPutIndicator() {
        return putIndicator;
    }

    public void setPutIndicator(String putIndicator) {
        this.putIndicator = putIndicator;
    }

    public LocalDate getNextParCallDate() {
        return nextParCallDate;
    }

    public void setNextParCallDate(LocalDate nextParCallDate) {
        this.nextParCallDate = nextParCallDate;
    }

    public LocalDate getPrerefundedDate() {
        return prerefundedDate;
    }

    public void setPrerefundedDate(LocalDate prerefundedDate) {
        this.prerefundedDate = prerefundedDate;
    }

    public LocalDate getNextPremiumCallDate() {
        return nextPremiumCallDate;
    }

    public void setNextPremiumCallDate(LocalDate nextPremiumCallDate) {
        this.nextPremiumCallDate = nextPremiumCallDate;
    }

    public LocalDate getDatedDateForFixIncOrExDividendDateEq() {
        return datedDateForFixIncOrExDividendDateEq;
    }

    public void setDatedDateForFixIncOrExDividendDateEq(LocalDate datedDateForFixIncOrExDividendDateEq) {
        this.datedDateForFixIncOrExDividendDateEq = datedDateForFixIncOrExDividendDateEq;
    }

    public LocalDate getFirstCouponFixIncOrPayableDateEq() {
        return firstCouponFixIncOrPayableDateEq;
    }

    public void setFirstCouponFixIncOrPayableDateEq(LocalDate firstCouponFixIncOrPayableDateEq) {
        this.firstCouponFixIncOrPayableDateEq = firstCouponFixIncOrPayableDateEq;
    }

    public String getCampo24() {
        return campo24;
    }

    public void setCampo24(String campo24) {
        this.campo24 = campo24;
    }

    public String getFederalMarginableInd() {
        return federalMarginableInd;
    }

    public void setFederalMarginableInd(String federalMarginableInd) {
        this.federalMarginableInd = federalMarginableInd;
    }

    public String getCnsEligibleCode() {
        return cnsEligibleCode;
    }

    public void setCnsEligibleCode(String cnsEligibleCode) {
        this.cnsEligibleCode = cnsEligibleCode;
    }

    public String getDtccEligibleCode() {
        return dtccEligibleCode;
    }

    public void setDtccEligibleCode(String dtccEligibleCode) {
        this.dtccEligibleCode = dtccEligibleCode;
    }

    public String getNsccEligibleCode() {
        return nsccEligibleCode;
    }

    public void setNsccEligibleCode(String nsccEligibleCode) {
        this.nsccEligibleCode = nsccEligibleCode;
    }

    public String getForeignSecurity() {
        return foreignSecurity;
    }

    public void setForeignSecurity(String foreignSecurity) {
        this.foreignSecurity = foreignSecurity;
    }

    public String getSecondCouponDay() {
        return secondCouponDay;
    }

    public void setSecondCouponDay(String secondCouponDay) {
        this.secondCouponDay = secondCouponDay;
    }

    public String getDividendInterestPaymentMethod() {
        return dividendInterestPaymentMethod;
    }

    public void setDividendInterestPaymentMethod(String dividendInterestPaymentMethod) {
        this.dividendInterestPaymentMethod = dividendInterestPaymentMethod;
    }

    public String getMinorProductCode() {
        return minorProductCode;
    }

    public void setMinorProductCode(String minorProductCode) {
        this.minorProductCode = minorProductCode;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}