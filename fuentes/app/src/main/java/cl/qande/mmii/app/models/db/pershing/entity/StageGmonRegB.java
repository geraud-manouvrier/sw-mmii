package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_gmon_reg_b", schema = "stage_pershing")
public class StageGmonRegB {
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
    @Column(name = "transaction_code", length = 100)
    private String transactionCode;

    @Size(max = 100)
    @Column(name = "record_indicator_value", length = 100)
    private String recordIndicatorValue;

    @Column(name = "record_id_sequence_number")
    private Integer recordIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "account_number", length = 100)
    private String accountNumber;

    @Size(max = 100)
    @Column(name = "campo_5", length = 100)
    private String campo5;

    @Size(max = 100)
    @Column(name = "ip_number", length = 100)
    private String ipNumber;

    @Size(max = 100)
    @Column(name = "ibd_number", length = 100)
    private String ibdNumber;

    @Column(name = "usde_sd_balance", precision = 45, scale = 20)
    private BigDecimal usdeSdBalance;

    @Size(max = 100)
    @Column(name = "usde_sd_balance_sign", length = 100)
    private String usdeSdBalanceSign;

    @Column(name = "usd_sd_balance", precision = 45, scale = 20)
    private BigDecimal usdSdBalance;

    @Size(max = 100)
    @Column(name = "usd_sd_balance_sign", length = 100)
    private String usdSdBalanceSign;

    @Column(name = "long_sd_market", precision = 45, scale = 20)
    private BigDecimal longSdMarket;

    @Size(max = 100)
    @Column(name = "long_sd_market_sign", length = 100)
    private String longSdMarketSign;

    @Column(name = "short_sd_market", precision = 45, scale = 20)
    private BigDecimal shortSdMarket;

    @Size(max = 100)
    @Column(name = "short_sd_market_sign", length = 100)
    private String shortSdMarketSign;

    @Column(name = "sma_date_stamp")
    private LocalDate smaDateStamp;

    @Column(name = "sma_balance", precision = 45, scale = 20)
    private BigDecimal smaBalance;

    @Size(max = 100)
    @Column(name = "sma_balance_sign", length = 100)
    private String smaBalanceSign;

    @Column(name = "margin_buying_power", precision = 45, scale = 20)
    private BigDecimal marginBuyingPower;

    @Size(max = 100)
    @Column(name = "margin_buying_power_sign", length = 100)
    private String marginBuyingPowerSign;

    @Column(name = "technical_short_value", precision = 45, scale = 20)
    private BigDecimal technicalShortValue;

    @Size(max = 100)
    @Column(name = "technical_short_value_sign", length = 100)
    private String technicalShortValueSign;

    @Column(name = "total_fed_requirement", precision = 45, scale = 20)
    private BigDecimal totalFedRequirement;

    @Size(max = 100)
    @Column(name = "total_fed_requirement_sign", length = 100)
    private String totalFedRequirementSign;

    @Column(name = "total_options_requirement", precision = 45, scale = 20)
    private BigDecimal totalOptionsRequirement;

    @Size(max = 100)
    @Column(name = "total_options_requirement_sign", length = 100)
    private String totalOptionsRequirementSign;

    @Size(max = 100)
    @Column(name = "base_currency", length = 100)
    private String baseCurrency;

    @Size(max = 100)
    @Column(name = "non_usd_currency", length = 100)
    private String nonUsdCurrency;

    @Column(name = "masked_house_call", precision = 45, scale = 20)
    private BigDecimal maskedHouseCall;

    @Size(max = 100)
    @Column(name = "masked_house_call_sign", length = 100)
    private String maskedHouseCallSign;

    @Size(max = 100)
    @Column(name = "campo_31", length = 100)
    private String campo31;

    @Column(name = "date_of_data")
    private LocalDate dateOfData;

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

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getRecordIndicatorValue() {
        return recordIndicatorValue;
    }

    public void setRecordIndicatorValue(String recordIndicatorValue) {
        this.recordIndicatorValue = recordIndicatorValue;
    }

    public Integer getRecordIdSequenceNumber() {
        return recordIdSequenceNumber;
    }

    public void setRecordIdSequenceNumber(Integer recordIdSequenceNumber) {
        this.recordIdSequenceNumber = recordIdSequenceNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public String getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(String ipNumber) {
        this.ipNumber = ipNumber;
    }

    public String getIbdNumber() {
        return ibdNumber;
    }

    public void setIbdNumber(String ibdNumber) {
        this.ibdNumber = ibdNumber;
    }

    public BigDecimal getUsdeSdBalance() {
        return usdeSdBalance;
    }

    public void setUsdeSdBalance(BigDecimal usdeSdBalance) {
        this.usdeSdBalance = usdeSdBalance;
    }

    public String getUsdeSdBalanceSign() {
        return usdeSdBalanceSign;
    }

    public void setUsdeSdBalanceSign(String usdeSdBalanceSign) {
        this.usdeSdBalanceSign = usdeSdBalanceSign;
    }

    public BigDecimal getUsdSdBalance() {
        return usdSdBalance;
    }

    public void setUsdSdBalance(BigDecimal usdSdBalance) {
        this.usdSdBalance = usdSdBalance;
    }

    public String getUsdSdBalanceSign() {
        return usdSdBalanceSign;
    }

    public void setUsdSdBalanceSign(String usdSdBalanceSign) {
        this.usdSdBalanceSign = usdSdBalanceSign;
    }

    public BigDecimal getLongSdMarket() {
        return longSdMarket;
    }

    public void setLongSdMarket(BigDecimal longSdMarket) {
        this.longSdMarket = longSdMarket;
    }

    public String getLongSdMarketSign() {
        return longSdMarketSign;
    }

    public void setLongSdMarketSign(String longSdMarketSign) {
        this.longSdMarketSign = longSdMarketSign;
    }

    public BigDecimal getShortSdMarket() {
        return shortSdMarket;
    }

    public void setShortSdMarket(BigDecimal shortSdMarket) {
        this.shortSdMarket = shortSdMarket;
    }

    public String getShortSdMarketSign() {
        return shortSdMarketSign;
    }

    public void setShortSdMarketSign(String shortSdMarketSign) {
        this.shortSdMarketSign = shortSdMarketSign;
    }

    public LocalDate getSmaDateStamp() {
        return smaDateStamp;
    }

    public void setSmaDateStamp(LocalDate smaDateStamp) {
        this.smaDateStamp = smaDateStamp;
    }

    public BigDecimal getSmaBalance() {
        return smaBalance;
    }

    public void setSmaBalance(BigDecimal smaBalance) {
        this.smaBalance = smaBalance;
    }

    public String getSmaBalanceSign() {
        return smaBalanceSign;
    }

    public void setSmaBalanceSign(String smaBalanceSign) {
        this.smaBalanceSign = smaBalanceSign;
    }

    public BigDecimal getMarginBuyingPower() {
        return marginBuyingPower;
    }

    public void setMarginBuyingPower(BigDecimal marginBuyingPower) {
        this.marginBuyingPower = marginBuyingPower;
    }

    public String getMarginBuyingPowerSign() {
        return marginBuyingPowerSign;
    }

    public void setMarginBuyingPowerSign(String marginBuyingPowerSign) {
        this.marginBuyingPowerSign = marginBuyingPowerSign;
    }

    public BigDecimal getTechnicalShortValue() {
        return technicalShortValue;
    }

    public void setTechnicalShortValue(BigDecimal technicalShortValue) {
        this.technicalShortValue = technicalShortValue;
    }

    public String getTechnicalShortValueSign() {
        return technicalShortValueSign;
    }

    public void setTechnicalShortValueSign(String technicalShortValueSign) {
        this.technicalShortValueSign = technicalShortValueSign;
    }

    public BigDecimal getTotalFedRequirement() {
        return totalFedRequirement;
    }

    public void setTotalFedRequirement(BigDecimal totalFedRequirement) {
        this.totalFedRequirement = totalFedRequirement;
    }

    public String getTotalFedRequirementSign() {
        return totalFedRequirementSign;
    }

    public void setTotalFedRequirementSign(String totalFedRequirementSign) {
        this.totalFedRequirementSign = totalFedRequirementSign;
    }

    public BigDecimal getTotalOptionsRequirement() {
        return totalOptionsRequirement;
    }

    public void setTotalOptionsRequirement(BigDecimal totalOptionsRequirement) {
        this.totalOptionsRequirement = totalOptionsRequirement;
    }

    public String getTotalOptionsRequirementSign() {
        return totalOptionsRequirementSign;
    }

    public void setTotalOptionsRequirementSign(String totalOptionsRequirementSign) {
        this.totalOptionsRequirementSign = totalOptionsRequirementSign;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getNonUsdCurrency() {
        return nonUsdCurrency;
    }

    public void setNonUsdCurrency(String nonUsdCurrency) {
        this.nonUsdCurrency = nonUsdCurrency;
    }

    public BigDecimal getMaskedHouseCall() {
        return maskedHouseCall;
    }

    public void setMaskedHouseCall(BigDecimal maskedHouseCall) {
        this.maskedHouseCall = maskedHouseCall;
    }

    public String getMaskedHouseCallSign() {
        return maskedHouseCallSign;
    }

    public void setMaskedHouseCallSign(String maskedHouseCallSign) {
        this.maskedHouseCallSign = maskedHouseCallSign;
    }

    public String getCampo31() {
        return campo31;
    }

    public void setCampo31(String campo31) {
        this.campo31 = campo31;
    }

    public LocalDate getDateOfData() {
        return dateOfData;
    }

    public void setDateOfData(LocalDate dateOfData) {
        this.dateOfData = dateOfData;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}