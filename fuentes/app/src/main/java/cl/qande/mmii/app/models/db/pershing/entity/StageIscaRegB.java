package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_b", schema = "stage_pershing")
public class StageIscaRegB {
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
    @Column(name = "etf_indicator", length = 100)
    private String etfIndicator;

    @Column(name = "bid_price", precision = 45, scale = 20)
    private BigDecimal bidPrice;

    @Column(name = "ask_price", precision = 45, scale = 20)
    private BigDecimal askPrice;

    @Column(name = "previous_day_price", precision = 45, scale = 20)
    private BigDecimal previousDayPrice;

    @Column(name = "latest_price", precision = 45, scale = 20)
    private BigDecimal latestPrice;

    @Column(name = "end_of_month_price", precision = 45, scale = 20)
    private BigDecimal endOfMonthPrice;

    @Column(name = "round_lot_quantity")
    private Integer roundLotQuantity;

    @Size(max = 100)
    @Column(name = "dividend_reinvestment_eligibility_indicator", length = 100)
    private String dividendReinvestmentEligibilityIndicator;

    @Column(name = "previous_price_date")
    private LocalDate previousPriceDate;

    @Column(name = "latest_price_date")
    private LocalDate latestPriceDate;

    @Column(name = "end_of_month_price_date")
    private LocalDate endOfMonthPriceDate;

    @Column(name = "record_date")
    private LocalDate recordDate;

    @Size(max = 100)
    @Column(name = "fundvest_ind", length = 100)
    private String fundvestInd;

    @Size(max = 100)
    @Column(name = "country_code", length = 100)
    private String countryCode;

    @Size(max = 100)
    @Column(name = "standard_poor_rating", length = 100)
    private String standardPoorRating;

    @Size(max = 100)
    @Column(name = "moodys_rating", length = 100)
    private String moodysRating;

    @Size(max = 100)
    @Column(name = "bond_sub_class", length = 100)
    private String bondSubClass;

    @Size(max = 100)
    @Column(name = "restriction_indicator", length = 100)
    private String restrictionIndicator;

    @Size(max = 100)
    @Column(name = "trace_indicator", length = 100)
    private String traceIndicator;

    @Size(max = 100)
    @Column(name = "new_interest_calculation_code", length = 100)
    private String newInterestCalculationCode;

    @Size(max = 100)
    @Column(name = "sic_code", length = 100)
    private String sicCode;

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

    public String getEtfIndicator() {
        return etfIndicator;
    }

    public void setEtfIndicator(String etfIndicator) {
        this.etfIndicator = etfIndicator;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {
        this.askPrice = askPrice;
    }

    public BigDecimal getPreviousDayPrice() {
        return previousDayPrice;
    }

    public void setPreviousDayPrice(BigDecimal previousDayPrice) {
        this.previousDayPrice = previousDayPrice;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(BigDecimal latestPrice) {
        this.latestPrice = latestPrice;
    }

    public BigDecimal getEndOfMonthPrice() {
        return endOfMonthPrice;
    }

    public void setEndOfMonthPrice(BigDecimal endOfMonthPrice) {
        this.endOfMonthPrice = endOfMonthPrice;
    }

    public Integer getRoundLotQuantity() {
        return roundLotQuantity;
    }

    public void setRoundLotQuantity(Integer roundLotQuantity) {
        this.roundLotQuantity = roundLotQuantity;
    }

    public String getDividendReinvestmentEligibilityIndicator() {
        return dividendReinvestmentEligibilityIndicator;
    }

    public void setDividendReinvestmentEligibilityIndicator(String dividendReinvestmentEligibilityIndicator) {
        this.dividendReinvestmentEligibilityIndicator = dividendReinvestmentEligibilityIndicator;
    }

    public LocalDate getPreviousPriceDate() {
        return previousPriceDate;
    }

    public void setPreviousPriceDate(LocalDate previousPriceDate) {
        this.previousPriceDate = previousPriceDate;
    }

    public LocalDate getLatestPriceDate() {
        return latestPriceDate;
    }

    public void setLatestPriceDate(LocalDate latestPriceDate) {
        this.latestPriceDate = latestPriceDate;
    }

    public LocalDate getEndOfMonthPriceDate() {
        return endOfMonthPriceDate;
    }

    public void setEndOfMonthPriceDate(LocalDate endOfMonthPriceDate) {
        this.endOfMonthPriceDate = endOfMonthPriceDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getFundvestInd() {
        return fundvestInd;
    }

    public void setFundvestInd(String fundvestInd) {
        this.fundvestInd = fundvestInd;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStandardPoorRating() {
        return standardPoorRating;
    }

    public void setStandardPoorRating(String standardPoorRating) {
        this.standardPoorRating = standardPoorRating;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getBondSubClass() {
        return bondSubClass;
    }

    public void setBondSubClass(String bondSubClass) {
        this.bondSubClass = bondSubClass;
    }

    public String getRestrictionIndicator() {
        return restrictionIndicator;
    }

    public void setRestrictionIndicator(String restrictionIndicator) {
        this.restrictionIndicator = restrictionIndicator;
    }

    public String getTraceIndicator() {
        return traceIndicator;
    }

    public void setTraceIndicator(String traceIndicator) {
        this.traceIndicator = traceIndicator;
    }

    public String getNewInterestCalculationCode() {
        return newInterestCalculationCode;
    }

    public void setNewInterestCalculationCode(String newInterestCalculationCode) {
        this.newInterestCalculationCode = newInterestCalculationCode;
    }

    public String getSicCode() {
        return sicCode;
    }

    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}