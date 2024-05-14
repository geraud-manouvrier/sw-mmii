package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_j", schema = "stage_pershing")
public class StageIscaRegJ {
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

    @Column(name = "latest_price", precision = 45, scale = 20)
    private BigDecimal latestPrice;

    @Column(name = "latest_price_date")
    private LocalDate latestPriceDate;

    @Column(name = "factored_market_value_multiplier", precision = 45, scale = 20)
    private BigDecimal factoredMarketValueMultiplier;

    @Column(name = "current_yield", precision = 45, scale = 20)
    private BigDecimal currentYield;

    @Column(name = "yield", precision = 45, scale = 20)
    private BigDecimal yieldBd;

    @Size(max = 100)
    @Column(name = "price_source", length = 100)
    private String priceSource;

    @Size(max = 100)
    @Column(name = "country_of_origin", length = 100)
    private String countryOfOrigin;

    @Size(max = 100)
    @Column(name = "retricted_security_code", length = 100)
    private String retrictedSecurityCode;

    @Size(max = 100)
    @Column(name = "international_non_dollar_symbol", length = 100)
    private String internationalNonDollarSymbol;

    @Size(max = 100)
    @Column(name = "international_exchange", length = 100)
    private String internationalExchange;

    @Size(max = 100)
    @Column(name = "variable_rate_category_code", length = 100)
    private String variableRateCategoryCode;

    @Size(max = 100)
    @Column(name = "interest_rate_completion_ind", length = 100)
    private String interestRateCompletionInd;

    @Size(max = 100)
    @Column(name = "campo_17", length = 100)
    private String campo17;

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

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(BigDecimal latestPrice) {
        this.latestPrice = latestPrice;
    }

    public LocalDate getLatestPriceDate() {
        return latestPriceDate;
    }

    public void setLatestPriceDate(LocalDate latestPriceDate) {
        this.latestPriceDate = latestPriceDate;
    }

    public BigDecimal getFactoredMarketValueMultiplier() {
        return factoredMarketValueMultiplier;
    }

    public void setFactoredMarketValueMultiplier(BigDecimal factoredMarketValueMultiplier) {
        this.factoredMarketValueMultiplier = factoredMarketValueMultiplier;
    }

    public BigDecimal getCurrentYield() {
        return currentYield;
    }

    public void setCurrentYield(BigDecimal currentYield) {
        this.currentYield = currentYield;
    }

    public BigDecimal getYield() {
        return yieldBd;
    }

    public void setYield(BigDecimal yieldIn) {
        this.yieldBd = yieldIn;
    }

    public String getPriceSource() {
        return priceSource;
    }

    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getRetrictedSecurityCode() {
        return retrictedSecurityCode;
    }

    public void setRetrictedSecurityCode(String retrictedSecurityCode) {
        this.retrictedSecurityCode = retrictedSecurityCode;
    }

    public String getInternationalNonDollarSymbol() {
        return internationalNonDollarSymbol;
    }

    public void setInternationalNonDollarSymbol(String internationalNonDollarSymbol) {
        this.internationalNonDollarSymbol = internationalNonDollarSymbol;
    }

    public String getInternationalExchange() {
        return internationalExchange;
    }

    public void setInternationalExchange(String internationalExchange) {
        this.internationalExchange = internationalExchange;
    }

    public String getVariableRateCategoryCode() {
        return variableRateCategoryCode;
    }

    public void setVariableRateCategoryCode(String variableRateCategoryCode) {
        this.variableRateCategoryCode = variableRateCategoryCode;
    }

    public String getInterestRateCompletionInd() {
        return interestRateCompletionInd;
    }

    public void setInterestRateCompletionInd(String interestRateCompletionInd) {
        this.interestRateCompletionInd = interestRateCompletionInd;
    }

    public String getCampo17() {
        return campo17;
    }

    public void setCampo17(String campo17) {
        this.campo17 = campo17;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}