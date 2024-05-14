package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_gcus_reg_a", schema = "stage_pershing")
public class StageGcusRegA {
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
    @Column(name = "cusip_number", length = 100)
    private String cusipNumber;

    @Size(max = 100)
    @Column(name = "portfolio_currency", length = 100)
    private String portfolioCurrency;

    @Size(max = 100)
    @Column(name = "campo_7", length = 100)
    private String campo7;

    @Size(max = 100)
    @Column(name = "underlying_cusip_number", length = 100)
    private String underlyingCusipNumber;

    @Size(max = 100)
    @Column(name = "country_code", length = 100)
    private String countryCode;

    @Size(max = 100)
    @Column(name = "campo_10", length = 100)
    private String campo10;

    @Size(max = 100)
    @Column(name = "ip_record_number", length = 100)
    private String ipRecordNumber;

    @Size(max = 100)
    @Column(name = "ibd_number", length = 100)
    private String ibdNumber;

    @Size(max = 100)
    @Column(name = "currency_security_indicator", length = 100)
    private String currencySecurityIndicator;

    @Size(max = 100)
    @Column(name = "issue_currency", length = 100)
    private String issueCurrency;

    @Column(name = "datestamp_trade_date")
    private LocalDate datestampTradeDate;

    @Column(name = "datestamp_settlement_date")
    private LocalDate datestampSettlementDate;

    @Column(name = "trade_date_quantity", precision = 45, scale = 20)
    private BigDecimal tradeDateQuantity;

    @Size(max = 100)
    @Column(name = "trade_date_quantity_sign", length = 100)
    private String tradeDateQuantitySign;

    @Column(name = "settlement_date_quantity", precision = 45, scale = 20)
    private BigDecimal settlementDateQuantity;

    @Size(max = 100)
    @Column(name = "settlement_date_quantity_sign", length = 100)
    private String settlementDateQuantitySign;

    @Column(name = "seg_quantity", precision = 45, scale = 20)
    private BigDecimal segQuantity;

    @Size(max = 100)
    @Column(name = "seg_quantity_sign", length = 100)
    private String segQuantitySign;

    @Column(name = "safekeeping_quantity", precision = 45, scale = 20)
    private BigDecimal safekeepingQuantity;

    @Size(max = 100)
    @Column(name = "safekeeping_sign", length = 100)
    private String safekeepingSign;

    @Column(name = "transfer_quantity", precision = 45, scale = 20)
    private BigDecimal transferQuantity;

    @Size(max = 100)
    @Column(name = "transfer_quantity_sign", length = 100)
    private String transferQuantitySign;

    @Column(name = "pending_transfer_quantity", precision = 45, scale = 20)
    private BigDecimal pendingTransferQuantity;

    @Size(max = 100)
    @Column(name = "pending_transfer_quantity_sign", length = 100)
    private String pendingTransferQuantitySign;

    @Column(name = "legal_transfer_quantity", precision = 45, scale = 20)
    private BigDecimal legalTransferQuantity;

    @Size(max = 100)
    @Column(name = "legal_transfer_quantity_sign", length = 100)
    private String legalTransferQuantitySign;

    @Column(name = "tendered_quantity", precision = 45, scale = 20)
    private BigDecimal tenderedQuantity;

    @Size(max = 100)
    @Column(name = "tendered_quantity_sign", length = 100)
    private String tenderedQuantitySign;

    @Column(name = "pending_papers", precision = 45, scale = 20)
    private BigDecimal pendingPapers;

    @Size(max = 100)
    @Column(name = "pending_papers_sign", length = 100)
    private String pendingPapersSign;

    @Column(name = "short_against_the_box_quantity", precision = 45, scale = 20)
    private BigDecimal shortAgainstTheBoxQuantity;

    @Size(max = 100)
    @Column(name = "short_against_the_box_quantity_sign", length = 100)
    private String shortAgainstTheBoxQuantitySign;

    @Column(name = "networked_quantity", precision = 45, scale = 20)
    private BigDecimal networkedQuantity;

    @Size(max = 100)
    @Column(name = "networked_quantity_sign", length = 100)
    private String networkedQuantitySign;

    @Column(name = "pending_split_quantity", precision = 45, scale = 20)
    private BigDecimal pendingSplitQuantity;

    @Size(max = 100)
    @Column(name = "pending_split_quantity_sign", length = 100)
    private String pendingSplitQuantitySign;

    @Column(name = "quantity_covering_options", precision = 45, scale = 20)
    private BigDecimal quantityCoveringOptions;

    @Size(max = 100)
    @Column(name = "quantity_covering_options_sign", length = 100)
    private String quantityCoveringOptionsSign;

    @Column(name = "trade_date_quantity_bought", precision = 45, scale = 20)
    private BigDecimal tradeDateQuantityBought;

    @Size(max = 100)
    @Column(name = "trade_date_quantity_bought_sign", length = 100)
    private String tradeDateQuantityBoughtSign;

    @Column(name = "trade_date_quantity_sold", precision = 45, scale = 20)
    private BigDecimal tradeDateQuantitySold;

    @Size(max = 100)
    @Column(name = "trade_date_quantity_sold_sign", length = 100)
    private String tradeDateQuantitySoldSign;

    @Column(name = "fed_rquirement", precision = 45, scale = 20)
    private BigDecimal fedRquirement;

    @Size(max = 100)
    @Column(name = "fed_rquirement_sign", length = 100)
    private String fedRquirementSign;

    @Column(name = "house_margin_requirement", precision = 45, scale = 20)
    private BigDecimal houseMarginRequirement;

    @Size(max = 100)
    @Column(name = "house_margin_requirement_sign", length = 100)
    private String houseMarginRequirementSign;

    @Column(name = "nyse_requirement", precision = 45, scale = 20)
    private BigDecimal nyseRequirement;

    @Size(max = 100)
    @Column(name = "nyse_requirement_sign", length = 100)
    private String nyseRequirementSign;

    @Column(name = "equity_requirment", precision = 45, scale = 20)
    private BigDecimal equityRequirment;

    @Size(max = 100)
    @Column(name = "equity_requirment_sign", length = 100)
    private String equityRequirmentSign;

    @Size(max = 100)
    @Column(name = "security_symbol", length = 100)
    private String securitySymbol;

    @Size(max = 100)
    @Column(name = "security_type", length = 100)
    private String securityType;

    @Size(max = 100)
    @Column(name = "security_mod", length = 100)
    private String securityMod;

    @Size(max = 100)
    @Column(name = "security_calc", length = 100)
    private String securityCalc;

    @Size(max = 100)
    @Column(name = "minor_product_code", length = 100)
    private String minorProductCode;

    @Size(max = 100)
    @Column(name = "network_eligibility_indicator", length = 100)
    private String networkEligibilityIndicator;

    @Column(name = "strike_price", precision = 45, scale = 20)
    private BigDecimal strikePrice;

    @Size(max = 100)
    @Column(name = "strike_price_sign", length = 100)
    private String strikePriceSign;

    @Column(name = "expiration_maturity_date")
    private LocalDate expirationMaturityDate;

    @Column(name = "contract_size", precision = 45, scale = 20)
    private BigDecimal contractSize;

    @Column(name = "conversion_ratio", precision = 45, scale = 20)
    private BigDecimal conversionRatio;

    @Size(max = 100)
    @Column(name = "account_short_name", length = 100)
    private String accountShortName;

    @Size(max = 100)
    @Column(name = "state_code", length = 100)
    private String stateCode;

    @Size(max = 100)
    @Column(name = "country_code_account", length = 100)
    private String countryCodeAccount;

    @Size(max = 100)
    @Column(name = "campo_69", length = 100)
    private String campo69;

    @Column(name = "number_security_description_lines")
    private Integer numberSecurityDescriptionLines;

    @Size(max = 100)
    @Column(name = "security_description_line_1", length = 100)
    private String securityDescriptionLine1;

    @Size(max = 100)
    @Column(name = "security_description_line_2", length = 100)
    private String securityDescriptionLine2;

    @Size(max = 100)
    @Column(name = "security_description_line_3", length = 100)
    private String securityDescriptionLine3;

    @Size(max = 100)
    @Column(name = "security_description_line_4", length = 100)
    private String securityDescriptionLine4;

    @Size(max = 100)
    @Column(name = "security_description_line_5", length = 100)
    private String securityDescriptionLine5;

    @Size(max = 100)
    @Column(name = "security_description_line_6", length = 100)
    private String securityDescriptionLine6;

    @Size(max = 100)
    @Column(name = "dividend_option", length = 100)
    private String dividendOption;

    @Size(max = 100)
    @Column(name = "long_term_capital_gains_option", length = 100)
    private String longTermCapitalGainsOption;

    @Size(max = 100)
    @Column(name = "short_term_capital_gains_option", length = 100)
    private String shortTermCapitalGainsOption;

    @Size(max = 100)
    @Column(name = "firm_trading_indicator", length = 100)
    private String firmTradingIndicator;

    @Size(max = 100)
    @Column(name = "position_currency_security", length = 100)
    private String positionCurrencySecurity;

    @Column(name = "trade_date_liquidating_value", precision = 45, scale = 20)
    private BigDecimal tradeDateLiquidatingValue;

    @Size(max = 100)
    @Column(name = "trade_date_liquidating_value_sign", length = 100)
    private String tradeDateLiquidatingValueSign;

    @Column(name = "pool_factor", precision = 45, scale = 20)
    private BigDecimal poolFactor;

    @Size(max = 100)
    @Column(name = "pool_factor_sign", length = 100)
    private String poolFactorSign;

    @Column(name = "exchange_rate", precision = 45, scale = 20)
    private BigDecimal exchangeRate;

    @Size(max = 100)
    @Column(name = "exchange_rate_sign", length = 100)
    private String exchangeRateSign;

    @Column(name = "settlement_date_liquidating_value", precision = 45, scale = 20)
    private BigDecimal settlementDateLiquidatingValue;

    @Size(max = 100)
    @Column(name = "settlement_date_liquidating_value_sign", length = 100)
    private String settlementDateLiquidatingValueSign;

    @Size(max = 100)
    @Column(name = "campo_90", length = 100)
    private String campo90;

    @Size(max = 100)
    @Column(name = "alternate_security_id_type", length = 100)
    private String alternateSecurityIdType;

    @Size(max = 100)
    @Column(name = "alternate_security_id", length = 100)
    private String alternateSecurityId;

    @Size(max = 100)
    @Column(name = "campo_93", length = 100)
    private String campo93;

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

    public String getCusipNumber() {
        return cusipNumber;
    }

    public void setCusipNumber(String cusipNumber) {
        this.cusipNumber = cusipNumber;
    }

    public String getPortfolioCurrency() {
        return portfolioCurrency;
    }

    public void setPortfolioCurrency(String portfolioCurrency) {
        this.portfolioCurrency = portfolioCurrency;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public String getUnderlyingCusipNumber() {
        return underlyingCusipNumber;
    }

    public void setUnderlyingCusipNumber(String underlyingCusipNumber) {
        this.underlyingCusipNumber = underlyingCusipNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public String getIpRecordNumber() {
        return ipRecordNumber;
    }

    public void setIpRecordNumber(String ipRecordNumber) {
        this.ipRecordNumber = ipRecordNumber;
    }

    public String getIbdNumber() {
        return ibdNumber;
    }

    public void setIbdNumber(String ibdNumber) {
        this.ibdNumber = ibdNumber;
    }

    public String getCurrencySecurityIndicator() {
        return currencySecurityIndicator;
    }

    public void setCurrencySecurityIndicator(String currencySecurityIndicator) {
        this.currencySecurityIndicator = currencySecurityIndicator;
    }

    public String getIssueCurrency() {
        return issueCurrency;
    }

    public void setIssueCurrency(String issueCurrency) {
        this.issueCurrency = issueCurrency;
    }

    public LocalDate getDatestampTradeDate() {
        return datestampTradeDate;
    }

    public void setDatestampTradeDate(LocalDate datestampTradeDate) {
        this.datestampTradeDate = datestampTradeDate;
    }

    public LocalDate getDatestampSettlementDate() {
        return datestampSettlementDate;
    }

    public void setDatestampSettlementDate(LocalDate datestampSettlementDate) {
        this.datestampSettlementDate = datestampSettlementDate;
    }

    public BigDecimal getTradeDateQuantity() {
        return tradeDateQuantity;
    }

    public void setTradeDateQuantity(BigDecimal tradeDateQuantity) {
        this.tradeDateQuantity = tradeDateQuantity;
    }

    public String getTradeDateQuantitySign() {
        return tradeDateQuantitySign;
    }

    public void setTradeDateQuantitySign(String tradeDateQuantitySign) {
        this.tradeDateQuantitySign = tradeDateQuantitySign;
    }

    public BigDecimal getSettlementDateQuantity() {
        return settlementDateQuantity;
    }

    public void setSettlementDateQuantity(BigDecimal settlementDateQuantity) {
        this.settlementDateQuantity = settlementDateQuantity;
    }

    public String getSettlementDateQuantitySign() {
        return settlementDateQuantitySign;
    }

    public void setSettlementDateQuantitySign(String settlementDateQuantitySign) {
        this.settlementDateQuantitySign = settlementDateQuantitySign;
    }

    public BigDecimal getSegQuantity() {
        return segQuantity;
    }

    public void setSegQuantity(BigDecimal segQuantity) {
        this.segQuantity = segQuantity;
    }

    public String getSegQuantitySign() {
        return segQuantitySign;
    }

    public void setSegQuantitySign(String segQuantitySign) {
        this.segQuantitySign = segQuantitySign;
    }

    public BigDecimal getSafekeepingQuantity() {
        return safekeepingQuantity;
    }

    public void setSafekeepingQuantity(BigDecimal safekeepingQuantity) {
        this.safekeepingQuantity = safekeepingQuantity;
    }

    public String getSafekeepingSign() {
        return safekeepingSign;
    }

    public void setSafekeepingSign(String safekeepingSign) {
        this.safekeepingSign = safekeepingSign;
    }

    public BigDecimal getTransferQuantity() {
        return transferQuantity;
    }

    public void setTransferQuantity(BigDecimal transferQuantity) {
        this.transferQuantity = transferQuantity;
    }

    public String getTransferQuantitySign() {
        return transferQuantitySign;
    }

    public void setTransferQuantitySign(String transferQuantitySign) {
        this.transferQuantitySign = transferQuantitySign;
    }

    public BigDecimal getPendingTransferQuantity() {
        return pendingTransferQuantity;
    }

    public void setPendingTransferQuantity(BigDecimal pendingTransferQuantity) {
        this.pendingTransferQuantity = pendingTransferQuantity;
    }

    public String getPendingTransferQuantitySign() {
        return pendingTransferQuantitySign;
    }

    public void setPendingTransferQuantitySign(String pendingTransferQuantitySign) {
        this.pendingTransferQuantitySign = pendingTransferQuantitySign;
    }

    public BigDecimal getLegalTransferQuantity() {
        return legalTransferQuantity;
    }

    public void setLegalTransferQuantity(BigDecimal legalTransferQuantity) {
        this.legalTransferQuantity = legalTransferQuantity;
    }

    public String getLegalTransferQuantitySign() {
        return legalTransferQuantitySign;
    }

    public void setLegalTransferQuantitySign(String legalTransferQuantitySign) {
        this.legalTransferQuantitySign = legalTransferQuantitySign;
    }

    public BigDecimal getTenderedQuantity() {
        return tenderedQuantity;
    }

    public void setTenderedQuantity(BigDecimal tenderedQuantity) {
        this.tenderedQuantity = tenderedQuantity;
    }

    public String getTenderedQuantitySign() {
        return tenderedQuantitySign;
    }

    public void setTenderedQuantitySign(String tenderedQuantitySign) {
        this.tenderedQuantitySign = tenderedQuantitySign;
    }

    public BigDecimal getPendingPapers() {
        return pendingPapers;
    }

    public void setPendingPapers(BigDecimal pendingPapers) {
        this.pendingPapers = pendingPapers;
    }

    public String getPendingPapersSign() {
        return pendingPapersSign;
    }

    public void setPendingPapersSign(String pendingPapersSign) {
        this.pendingPapersSign = pendingPapersSign;
    }

    public BigDecimal getShortAgainstTheBoxQuantity() {
        return shortAgainstTheBoxQuantity;
    }

    public void setShortAgainstTheBoxQuantity(BigDecimal shortAgainstTheBoxQuantity) {
        this.shortAgainstTheBoxQuantity = shortAgainstTheBoxQuantity;
    }

    public String getShortAgainstTheBoxQuantitySign() {
        return shortAgainstTheBoxQuantitySign;
    }

    public void setShortAgainstTheBoxQuantitySign(String shortAgainstTheBoxQuantitySign) {
        this.shortAgainstTheBoxQuantitySign = shortAgainstTheBoxQuantitySign;
    }

    public BigDecimal getNetworkedQuantity() {
        return networkedQuantity;
    }

    public void setNetworkedQuantity(BigDecimal networkedQuantity) {
        this.networkedQuantity = networkedQuantity;
    }

    public String getNetworkedQuantitySign() {
        return networkedQuantitySign;
    }

    public void setNetworkedQuantitySign(String networkedQuantitySign) {
        this.networkedQuantitySign = networkedQuantitySign;
    }

    public BigDecimal getPendingSplitQuantity() {
        return pendingSplitQuantity;
    }

    public void setPendingSplitQuantity(BigDecimal pendingSplitQuantity) {
        this.pendingSplitQuantity = pendingSplitQuantity;
    }

    public String getPendingSplitQuantitySign() {
        return pendingSplitQuantitySign;
    }

    public void setPendingSplitQuantitySign(String pendingSplitQuantitySign) {
        this.pendingSplitQuantitySign = pendingSplitQuantitySign;
    }

    public BigDecimal getQuantityCoveringOptions() {
        return quantityCoveringOptions;
    }

    public void setQuantityCoveringOptions(BigDecimal quantityCoveringOptions) {
        this.quantityCoveringOptions = quantityCoveringOptions;
    }

    public String getQuantityCoveringOptionsSign() {
        return quantityCoveringOptionsSign;
    }

    public void setQuantityCoveringOptionsSign(String quantityCoveringOptionsSign) {
        this.quantityCoveringOptionsSign = quantityCoveringOptionsSign;
    }

    public BigDecimal getTradeDateQuantityBought() {
        return tradeDateQuantityBought;
    }

    public void setTradeDateQuantityBought(BigDecimal tradeDateQuantityBought) {
        this.tradeDateQuantityBought = tradeDateQuantityBought;
    }

    public String getTradeDateQuantityBoughtSign() {
        return tradeDateQuantityBoughtSign;
    }

    public void setTradeDateQuantityBoughtSign(String tradeDateQuantityBoughtSign) {
        this.tradeDateQuantityBoughtSign = tradeDateQuantityBoughtSign;
    }

    public BigDecimal getTradeDateQuantitySold() {
        return tradeDateQuantitySold;
    }

    public void setTradeDateQuantitySold(BigDecimal tradeDateQuantitySold) {
        this.tradeDateQuantitySold = tradeDateQuantitySold;
    }

    public String getTradeDateQuantitySoldSign() {
        return tradeDateQuantitySoldSign;
    }

    public void setTradeDateQuantitySoldSign(String tradeDateQuantitySoldSign) {
        this.tradeDateQuantitySoldSign = tradeDateQuantitySoldSign;
    }

    public BigDecimal getFedRquirement() {
        return fedRquirement;
    }

    public void setFedRquirement(BigDecimal fedRquirement) {
        this.fedRquirement = fedRquirement;
    }

    public String getFedRquirementSign() {
        return fedRquirementSign;
    }

    public void setFedRquirementSign(String fedRquirementSign) {
        this.fedRquirementSign = fedRquirementSign;
    }

    public BigDecimal getHouseMarginRequirement() {
        return houseMarginRequirement;
    }

    public void setHouseMarginRequirement(BigDecimal houseMarginRequirement) {
        this.houseMarginRequirement = houseMarginRequirement;
    }

    public String getHouseMarginRequirementSign() {
        return houseMarginRequirementSign;
    }

    public void setHouseMarginRequirementSign(String houseMarginRequirementSign) {
        this.houseMarginRequirementSign = houseMarginRequirementSign;
    }

    public BigDecimal getNyseRequirement() {
        return nyseRequirement;
    }

    public void setNyseRequirement(BigDecimal nyseRequirement) {
        this.nyseRequirement = nyseRequirement;
    }

    public String getNyseRequirementSign() {
        return nyseRequirementSign;
    }

    public void setNyseRequirementSign(String nyseRequirementSign) {
        this.nyseRequirementSign = nyseRequirementSign;
    }

    public BigDecimal getEquityRequirment() {
        return equityRequirment;
    }

    public void setEquityRequirment(BigDecimal equityRequirment) {
        this.equityRequirment = equityRequirment;
    }

    public String getEquityRequirmentSign() {
        return equityRequirmentSign;
    }

    public void setEquityRequirmentSign(String equityRequirmentSign) {
        this.equityRequirmentSign = equityRequirmentSign;
    }

    public String getSecuritySymbol() {
        return securitySymbol;
    }

    public void setSecuritySymbol(String securitySymbol) {
        this.securitySymbol = securitySymbol;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getSecurityMod() {
        return securityMod;
    }

    public void setSecurityMod(String securityMod) {
        this.securityMod = securityMod;
    }

    public String getSecurityCalc() {
        return securityCalc;
    }

    public void setSecurityCalc(String securityCalc) {
        this.securityCalc = securityCalc;
    }

    public String getMinorProductCode() {
        return minorProductCode;
    }

    public void setMinorProductCode(String minorProductCode) {
        this.minorProductCode = minorProductCode;
    }

    public String getNetworkEligibilityIndicator() {
        return networkEligibilityIndicator;
    }

    public void setNetworkEligibilityIndicator(String networkEligibilityIndicator) {
        this.networkEligibilityIndicator = networkEligibilityIndicator;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getStrikePriceSign() {
        return strikePriceSign;
    }

    public void setStrikePriceSign(String strikePriceSign) {
        this.strikePriceSign = strikePriceSign;
    }

    public LocalDate getExpirationMaturityDate() {
        return expirationMaturityDate;
    }

    public void setExpirationMaturityDate(LocalDate expirationMaturityDate) {
        this.expirationMaturityDate = expirationMaturityDate;
    }

    public BigDecimal getContractSize() {
        return contractSize;
    }

    public void setContractSize(BigDecimal contractSize) {
        this.contractSize = contractSize;
    }

    public BigDecimal getConversionRatio() {
        return conversionRatio;
    }

    public void setConversionRatio(BigDecimal conversionRatio) {
        this.conversionRatio = conversionRatio;
    }

    public String getAccountShortName() {
        return accountShortName;
    }

    public void setAccountShortName(String accountShortName) {
        this.accountShortName = accountShortName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCodeAccount() {
        return countryCodeAccount;
    }

    public void setCountryCodeAccount(String countryCodeAccount) {
        this.countryCodeAccount = countryCodeAccount;
    }

    public String getCampo69() {
        return campo69;
    }

    public void setCampo69(String campo69) {
        this.campo69 = campo69;
    }

    public Integer getNumberSecurityDescriptionLines() {
        return numberSecurityDescriptionLines;
    }

    public void setNumberSecurityDescriptionLines(Integer numberSecurityDescriptionLines) {
        this.numberSecurityDescriptionLines = numberSecurityDescriptionLines;
    }

    public String getSecurityDescriptionLine1() {
        return securityDescriptionLine1;
    }

    public void setSecurityDescriptionLine1(String securityDescriptionLine1) {
        this.securityDescriptionLine1 = securityDescriptionLine1;
    }

    public String getSecurityDescriptionLine2() {
        return securityDescriptionLine2;
    }

    public void setSecurityDescriptionLine2(String securityDescriptionLine2) {
        this.securityDescriptionLine2 = securityDescriptionLine2;
    }

    public String getSecurityDescriptionLine3() {
        return securityDescriptionLine3;
    }

    public void setSecurityDescriptionLine3(String securityDescriptionLine3) {
        this.securityDescriptionLine3 = securityDescriptionLine3;
    }

    public String getSecurityDescriptionLine4() {
        return securityDescriptionLine4;
    }

    public void setSecurityDescriptionLine4(String securityDescriptionLine4) {
        this.securityDescriptionLine4 = securityDescriptionLine4;
    }

    public String getSecurityDescriptionLine5() {
        return securityDescriptionLine5;
    }

    public void setSecurityDescriptionLine5(String securityDescriptionLine5) {
        this.securityDescriptionLine5 = securityDescriptionLine5;
    }

    public String getSecurityDescriptionLine6() {
        return securityDescriptionLine6;
    }

    public void setSecurityDescriptionLine6(String securityDescriptionLine6) {
        this.securityDescriptionLine6 = securityDescriptionLine6;
    }

    public String getDividendOption() {
        return dividendOption;
    }

    public void setDividendOption(String dividendOption) {
        this.dividendOption = dividendOption;
    }

    public String getLongTermCapitalGainsOption() {
        return longTermCapitalGainsOption;
    }

    public void setLongTermCapitalGainsOption(String longTermCapitalGainsOption) {
        this.longTermCapitalGainsOption = longTermCapitalGainsOption;
    }

    public String getShortTermCapitalGainsOption() {
        return shortTermCapitalGainsOption;
    }

    public void setShortTermCapitalGainsOption(String shortTermCapitalGainsOption) {
        this.shortTermCapitalGainsOption = shortTermCapitalGainsOption;
    }

    public String getFirmTradingIndicator() {
        return firmTradingIndicator;
    }

    public void setFirmTradingIndicator(String firmTradingIndicator) {
        this.firmTradingIndicator = firmTradingIndicator;
    }

    public String getPositionCurrencySecurity() {
        return positionCurrencySecurity;
    }

    public void setPositionCurrencySecurity(String positionCurrencySecurity) {
        this.positionCurrencySecurity = positionCurrencySecurity;
    }

    public BigDecimal getTradeDateLiquidatingValue() {
        return tradeDateLiquidatingValue;
    }

    public void setTradeDateLiquidatingValue(BigDecimal tradeDateLiquidatingValue) {
        this.tradeDateLiquidatingValue = tradeDateLiquidatingValue;
    }

    public String getTradeDateLiquidatingValueSign() {
        return tradeDateLiquidatingValueSign;
    }

    public void setTradeDateLiquidatingValueSign(String tradeDateLiquidatingValueSign) {
        this.tradeDateLiquidatingValueSign = tradeDateLiquidatingValueSign;
    }

    public BigDecimal getPoolFactor() {
        return poolFactor;
    }

    public void setPoolFactor(BigDecimal poolFactor) {
        this.poolFactor = poolFactor;
    }

    public String getPoolFactorSign() {
        return poolFactorSign;
    }

    public void setPoolFactorSign(String poolFactorSign) {
        this.poolFactorSign = poolFactorSign;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getExchangeRateSign() {
        return exchangeRateSign;
    }

    public void setExchangeRateSign(String exchangeRateSign) {
        this.exchangeRateSign = exchangeRateSign;
    }

    public BigDecimal getSettlementDateLiquidatingValue() {
        return settlementDateLiquidatingValue;
    }

    public void setSettlementDateLiquidatingValue(BigDecimal settlementDateLiquidatingValue) {
        this.settlementDateLiquidatingValue = settlementDateLiquidatingValue;
    }

    public String getSettlementDateLiquidatingValueSign() {
        return settlementDateLiquidatingValueSign;
    }

    public void setSettlementDateLiquidatingValueSign(String settlementDateLiquidatingValueSign) {
        this.settlementDateLiquidatingValueSign = settlementDateLiquidatingValueSign;
    }

    public String getCampo90() {
        return campo90;
    }

    public void setCampo90(String campo90) {
        this.campo90 = campo90;
    }

    public String getAlternateSecurityIdType() {
        return alternateSecurityIdType;
    }

    public void setAlternateSecurityIdType(String alternateSecurityIdType) {
        this.alternateSecurityIdType = alternateSecurityIdType;
    }

    public String getAlternateSecurityId() {
        return alternateSecurityId;
    }

    public void setAlternateSecurityId(String alternateSecurityId) {
        this.alternateSecurityId = alternateSecurityId;
    }

    public String getCampo93() {
        return campo93;
    }

    public void setCampo93(String campo93) {
        this.campo93 = campo93;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}