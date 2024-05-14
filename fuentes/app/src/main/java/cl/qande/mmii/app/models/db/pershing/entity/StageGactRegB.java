package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "stage_gact_reg_b", schema = "stage_pershing")
public class StageGactRegB {
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
    @Column(name = "security_currency_of_issuance", length = 100)
    private String securityCurrencyOfIssuance;

    @Size(max = 100)
    @Column(name = "trade_currency_code", length = 100)
    private String tradeCurrencyCode;

    @Size(max = 100)
    @Column(name = "settlement_currency_code", length = 100)
    private String settlementCurrencyCode;

    @Column(name = "settlement_usd_currency_fx_rate", precision = 45, scale = 20)
    private BigDecimal settlementUsdCurrencyFxRate;

    @Size(max = 100)
    @Column(name = "settlement_usd_multiply_divide_code", length = 100)
    private String settlementUsdMultiplyDivideCode;

    @Column(name = "cross_currency_fx_rate", precision = 45, scale = 20)
    private BigDecimal crossCurrencyFxRate;

    @Size(max = 100)
    @Column(name = "currency_multiply_divide_code", length = 100)
    private String currencyMultiplyDivideCode;

    @Column(name = "accrued_interest_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal accruedInterestInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "accrued_interest_in_settlement_currency_sign", length = 100)
    private String accruedInterestInSettlementCurrencySign;

    @Size(max = 100)
    @Column(name = "market_code", length = 100)
    private String marketCode;

    @Size(max = 100)
    @Column(name = "internal_reference_for_gloss", length = 100)
    private String internalReferenceForGloss;

    @Size(max = 100)
    @Column(name = "ibd_version", length = 100)
    private String ibdVersion;

    @Column(name = "net_amount_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal netAmountInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "net_amount_in_settlement_currency_sign", length = 100)
    private String netAmountInSettlementCurrencySign;

    @Column(name = "principal_amount_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal principalAmountInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "principal_amount_in_settlement_currency_sign", length = 100)
    private String principalAmountInSettlementCurrencySign;

    @Column(name = "interest_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal interestInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "interest_in_settlement_currency_sign", length = 100)
    private String interestInSettlementCurrencySign;

    @Column(name = "commission_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal commissionInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "commission_in_settlement_currency_sign", length = 100)
    private String commissionInSettlementCurrencySign;

    @Column(name = "tax_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal taxInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "tax_in_settlement_currency_sign", length = 100)
    private String taxInSettlementCurrencySign;

    @Column(name = "transaction_fee_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal transactionFeeInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "transaction_fee_in_settlement_currency_sign", length = 100)
    private String transactionFeeInSettlementCurrencySign;

    @Column(name = "miscellaneous_fee_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal miscellaneousFeeInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "miscellaneous_fee_in_settlement_currency_sign", length = 100)
    private String miscellaneousFeeInSettlementCurrencySign;

    @Column(name = "other_fee_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal otherFeeInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "other_fee_in_settlement_currency_sign", length = 100)
    private String otherFeeInSettlementCurrencySign;

    @Column(name = "sales_credit_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal salesCreditInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "sales_credit_in_settlement_currency_sign", length = 100)
    private String salesCreditInSettlementCurrencySign;

    @Column(name = "settlement_fee_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal settlementFeeInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "settlement_fee_in_settlement_currency_sign", length = 100)
    private String settlementFeeInSettlementCurrencySign;

    @Column(name = "service_charge_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal serviceChargeInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "service_charge_in_settlement_currency_sign", length = 100)
    private String serviceChargeInSettlementCurrencySign;

    @Column(name = "markup_markdown_in_settlement_currency", precision = 45, scale = 20)
    private BigDecimal markupMarkdownInSettlementCurrency;

    @Size(max = 100)
    @Column(name = "markup_markdown_in_settlement_currency_sign", length = 100)
    private String markupMarkdownInSettlementCurrencySign;

    @Size(max = 100)
    @Column(name = "global_exchange", length = 100)
    private String globalExchange;

    @Column(name = "number_of_description_lines")
    private Integer numberOfDescriptionLines;

    @Column(name = "last_description_line")
    private Integer lastDescriptionLine;

    @Size(max = 100)
    @Column(name = "description_line_1", length = 100)
    private String descriptionLine1;

    @Size(max = 100)
    @Column(name = "description_line_2", length = 100)
    private String descriptionLine2;

    @Size(max = 100)
    @Column(name = "description_line_3", length = 100)
    private String descriptionLine3;

    @Size(max = 100)
    @Column(name = "description_line_4", length = 100)
    private String descriptionLine4;

    @Size(max = 100)
    @Column(name = "description_line_5", length = 100)
    private String descriptionLine5;

    @Size(max = 100)
    @Column(name = "description_line_6", length = 100)
    private String descriptionLine6;

    @Size(max = 100)
    @Column(name = "description_line_7", length = 100)
    private String descriptionLine7;

    @Size(max = 100)
    @Column(name = "description_line_8", length = 100)
    private String descriptionLine8;

    @Size(max = 100)
    @Column(name = "description_line_9", length = 100)
    private String descriptionLine9;

    @Size(max = 100)
    @Column(name = "description_line_10", length = 100)
    private String descriptionLine10;

    @Size(max = 100)
    @Column(name = "description_line_11", length = 100)
    private String descriptionLine11;

    @Size(max = 100)
    @Column(name = "description_line_12", length = 100)
    private String descriptionLine12;

    @Size(max = 100)
    @Column(name = "security_currency_indicator", length = 100)
    private String securityCurrencyIndicator;

    @Size(max = 100)
    @Column(name = "market_mnemonic_code", length = 100)
    private String marketMnemonicCode;

    @Column(name = "ccy_of_issuance_usd_ccy_fx_rate", precision = 45, scale = 20)
    private BigDecimal ccyOfIssuanceUsdCcyFxRate;

    @Size(max = 100)
    @Column(name = "ccy_of_issuance_usd_multiply_divide_code", length = 100)
    private String ccyOfIssuanceUsdMultiplyDivideCode;

    @Size(max = 100)
    @Column(name = "alternate_security_id_type", length = 100)
    private String alternateSecurityIdType;

    @Size(max = 100)
    @Column(name = "alternate_security_id", length = 100)
    private String alternateSecurityId;

    @Size(max = 100)
    @Column(name = "alternate_security_id_type_2", length = 100)
    private String alternateSecurityIdType2;

    @Size(max = 100)
    @Column(name = "alternate_security_id_2", length = 100)
    private String alternateSecurityId2;

    @Size(max = 100)
    @Column(name = "international_non_dollar_symbol", length = 100)
    private String internationalNonDollarSymbol;

    @Size(max = 100)
    @Column(name = "confirmation_code_1", length = 100)
    private String confirmationCode1;

    @Size(max = 100)
    @Column(name = "confirmation_code_2", length = 100)
    private String confirmationCode2;

    @Size(max = 100)
    @Column(name = "confirmation_code_3", length = 100)
    private String confirmationCode3;

    @Size(max = 100)
    @Column(name = "confirmation_code_4", length = 100)
    private String confirmationCode4;

    @Column(name = "pmp", precision = 45, scale = 20)
    private BigDecimal pmp;

    @Column(name = "total_amount_mark_up_down", precision = 45, scale = 20)
    private BigDecimal totalAmountMarkUpDown;

    @Size(max = 100)
    @Column(name = "total_amount_mark_up_down_sign", length = 100)
    private String totalAmountMarkUpDownSign;

    @Column(name = "pmp_percent", precision = 45, scale = 20)
    private BigDecimal pmpPercent;

    @Size(max = 100)
    @Column(name = "campo_73", length = 100)
    private String campo73;

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

    public String getSecurityCurrencyOfIssuance() {
        return securityCurrencyOfIssuance;
    }

    public void setSecurityCurrencyOfIssuance(String securityCurrencyOfIssuance) {
        this.securityCurrencyOfIssuance = securityCurrencyOfIssuance;
    }

    public String getTradeCurrencyCode() {
        return tradeCurrencyCode;
    }

    public void setTradeCurrencyCode(String tradeCurrencyCode) {
        this.tradeCurrencyCode = tradeCurrencyCode;
    }

    public String getSettlementCurrencyCode() {
        return settlementCurrencyCode;
    }

    public void setSettlementCurrencyCode(String settlementCurrencyCode) {
        this.settlementCurrencyCode = settlementCurrencyCode;
    }

    public BigDecimal getSettlementUsdCurrencyFxRate() {
        return settlementUsdCurrencyFxRate;
    }

    public void setSettlementUsdCurrencyFxRate(BigDecimal settlementUsdCurrencyFxRate) {
        this.settlementUsdCurrencyFxRate = settlementUsdCurrencyFxRate;
    }

    public String getSettlementUsdMultiplyDivideCode() {
        return settlementUsdMultiplyDivideCode;
    }

    public void setSettlementUsdMultiplyDivideCode(String settlementUsdMultiplyDivideCode) {
        this.settlementUsdMultiplyDivideCode = settlementUsdMultiplyDivideCode;
    }

    public BigDecimal getCrossCurrencyFxRate() {
        return crossCurrencyFxRate;
    }

    public void setCrossCurrencyFxRate(BigDecimal crossCurrencyFxRate) {
        this.crossCurrencyFxRate = crossCurrencyFxRate;
    }

    public String getCurrencyMultiplyDivideCode() {
        return currencyMultiplyDivideCode;
    }

    public void setCurrencyMultiplyDivideCode(String currencyMultiplyDivideCode) {
        this.currencyMultiplyDivideCode = currencyMultiplyDivideCode;
    }

    public BigDecimal getAccruedInterestInSettlementCurrency() {
        return accruedInterestInSettlementCurrency;
    }

    public void setAccruedInterestInSettlementCurrency(BigDecimal accruedInterestInSettlementCurrency) {
        this.accruedInterestInSettlementCurrency = accruedInterestInSettlementCurrency;
    }

    public String getAccruedInterestInSettlementCurrencySign() {
        return accruedInterestInSettlementCurrencySign;
    }

    public void setAccruedInterestInSettlementCurrencySign(String accruedInterestInSettlementCurrencySign) {
        this.accruedInterestInSettlementCurrencySign = accruedInterestInSettlementCurrencySign;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getInternalReferenceForGloss() {
        return internalReferenceForGloss;
    }

    public void setInternalReferenceForGloss(String internalReferenceForGloss) {
        this.internalReferenceForGloss = internalReferenceForGloss;
    }

    public String getIbdVersion() {
        return ibdVersion;
    }

    public void setIbdVersion(String ibdVersion) {
        this.ibdVersion = ibdVersion;
    }

    public BigDecimal getNetAmountInSettlementCurrency() {
        return netAmountInSettlementCurrency;
    }

    public void setNetAmountInSettlementCurrency(BigDecimal netAmountInSettlementCurrency) {
        this.netAmountInSettlementCurrency = netAmountInSettlementCurrency;
    }

    public String getNetAmountInSettlementCurrencySign() {
        return netAmountInSettlementCurrencySign;
    }

    public void setNetAmountInSettlementCurrencySign(String netAmountInSettlementCurrencySign) {
        this.netAmountInSettlementCurrencySign = netAmountInSettlementCurrencySign;
    }

    public BigDecimal getPrincipalAmountInSettlementCurrency() {
        return principalAmountInSettlementCurrency;
    }

    public void setPrincipalAmountInSettlementCurrency(BigDecimal principalAmountInSettlementCurrency) {
        this.principalAmountInSettlementCurrency = principalAmountInSettlementCurrency;
    }

    public String getPrincipalAmountInSettlementCurrencySign() {
        return principalAmountInSettlementCurrencySign;
    }

    public void setPrincipalAmountInSettlementCurrencySign(String principalAmountInSettlementCurrencySign) {
        this.principalAmountInSettlementCurrencySign = principalAmountInSettlementCurrencySign;
    }

    public BigDecimal getInterestInSettlementCurrency() {
        return interestInSettlementCurrency;
    }

    public void setInterestInSettlementCurrency(BigDecimal interestInSettlementCurrency) {
        this.interestInSettlementCurrency = interestInSettlementCurrency;
    }

    public String getInterestInSettlementCurrencySign() {
        return interestInSettlementCurrencySign;
    }

    public void setInterestInSettlementCurrencySign(String interestInSettlementCurrencySign) {
        this.interestInSettlementCurrencySign = interestInSettlementCurrencySign;
    }

    public BigDecimal getCommissionInSettlementCurrency() {
        return commissionInSettlementCurrency;
    }

    public void setCommissionInSettlementCurrency(BigDecimal commissionInSettlementCurrency) {
        this.commissionInSettlementCurrency = commissionInSettlementCurrency;
    }

    public String getCommissionInSettlementCurrencySign() {
        return commissionInSettlementCurrencySign;
    }

    public void setCommissionInSettlementCurrencySign(String commissionInSettlementCurrencySign) {
        this.commissionInSettlementCurrencySign = commissionInSettlementCurrencySign;
    }

    public BigDecimal getTaxInSettlementCurrency() {
        return taxInSettlementCurrency;
    }

    public void setTaxInSettlementCurrency(BigDecimal taxInSettlementCurrency) {
        this.taxInSettlementCurrency = taxInSettlementCurrency;
    }

    public String getTaxInSettlementCurrencySign() {
        return taxInSettlementCurrencySign;
    }

    public void setTaxInSettlementCurrencySign(String taxInSettlementCurrencySign) {
        this.taxInSettlementCurrencySign = taxInSettlementCurrencySign;
    }

    public BigDecimal getTransactionFeeInSettlementCurrency() {
        return transactionFeeInSettlementCurrency;
    }

    public void setTransactionFeeInSettlementCurrency(BigDecimal transactionFeeInSettlementCurrency) {
        this.transactionFeeInSettlementCurrency = transactionFeeInSettlementCurrency;
    }

    public String getTransactionFeeInSettlementCurrencySign() {
        return transactionFeeInSettlementCurrencySign;
    }

    public void setTransactionFeeInSettlementCurrencySign(String transactionFeeInSettlementCurrencySign) {
        this.transactionFeeInSettlementCurrencySign = transactionFeeInSettlementCurrencySign;
    }

    public BigDecimal getMiscellaneousFeeInSettlementCurrency() {
        return miscellaneousFeeInSettlementCurrency;
    }

    public void setMiscellaneousFeeInSettlementCurrency(BigDecimal miscellaneousFeeInSettlementCurrency) {
        this.miscellaneousFeeInSettlementCurrency = miscellaneousFeeInSettlementCurrency;
    }

    public String getMiscellaneousFeeInSettlementCurrencySign() {
        return miscellaneousFeeInSettlementCurrencySign;
    }

    public void setMiscellaneousFeeInSettlementCurrencySign(String miscellaneousFeeInSettlementCurrencySign) {
        this.miscellaneousFeeInSettlementCurrencySign = miscellaneousFeeInSettlementCurrencySign;
    }

    public BigDecimal getOtherFeeInSettlementCurrency() {
        return otherFeeInSettlementCurrency;
    }

    public void setOtherFeeInSettlementCurrency(BigDecimal otherFeeInSettlementCurrency) {
        this.otherFeeInSettlementCurrency = otherFeeInSettlementCurrency;
    }

    public String getOtherFeeInSettlementCurrencySign() {
        return otherFeeInSettlementCurrencySign;
    }

    public void setOtherFeeInSettlementCurrencySign(String otherFeeInSettlementCurrencySign) {
        this.otherFeeInSettlementCurrencySign = otherFeeInSettlementCurrencySign;
    }

    public BigDecimal getSalesCreditInSettlementCurrency() {
        return salesCreditInSettlementCurrency;
    }

    public void setSalesCreditInSettlementCurrency(BigDecimal salesCreditInSettlementCurrency) {
        this.salesCreditInSettlementCurrency = salesCreditInSettlementCurrency;
    }

    public String getSalesCreditInSettlementCurrencySign() {
        return salesCreditInSettlementCurrencySign;
    }

    public void setSalesCreditInSettlementCurrencySign(String salesCreditInSettlementCurrencySign) {
        this.salesCreditInSettlementCurrencySign = salesCreditInSettlementCurrencySign;
    }

    public BigDecimal getSettlementFeeInSettlementCurrency() {
        return settlementFeeInSettlementCurrency;
    }

    public void setSettlementFeeInSettlementCurrency(BigDecimal settlementFeeInSettlementCurrency) {
        this.settlementFeeInSettlementCurrency = settlementFeeInSettlementCurrency;
    }

    public String getSettlementFeeInSettlementCurrencySign() {
        return settlementFeeInSettlementCurrencySign;
    }

    public void setSettlementFeeInSettlementCurrencySign(String settlementFeeInSettlementCurrencySign) {
        this.settlementFeeInSettlementCurrencySign = settlementFeeInSettlementCurrencySign;
    }

    public BigDecimal getServiceChargeInSettlementCurrency() {
        return serviceChargeInSettlementCurrency;
    }

    public void setServiceChargeInSettlementCurrency(BigDecimal serviceChargeInSettlementCurrency) {
        this.serviceChargeInSettlementCurrency = serviceChargeInSettlementCurrency;
    }

    public String getServiceChargeInSettlementCurrencySign() {
        return serviceChargeInSettlementCurrencySign;
    }

    public void setServiceChargeInSettlementCurrencySign(String serviceChargeInSettlementCurrencySign) {
        this.serviceChargeInSettlementCurrencySign = serviceChargeInSettlementCurrencySign;
    }

    public BigDecimal getMarkupMarkdownInSettlementCurrency() {
        return markupMarkdownInSettlementCurrency;
    }

    public void setMarkupMarkdownInSettlementCurrency(BigDecimal markupMarkdownInSettlementCurrency) {
        this.markupMarkdownInSettlementCurrency = markupMarkdownInSettlementCurrency;
    }

    public String getMarkupMarkdownInSettlementCurrencySign() {
        return markupMarkdownInSettlementCurrencySign;
    }

    public void setMarkupMarkdownInSettlementCurrencySign(String markupMarkdownInSettlementCurrencySign) {
        this.markupMarkdownInSettlementCurrencySign = markupMarkdownInSettlementCurrencySign;
    }

    public String getGlobalExchange() {
        return globalExchange;
    }

    public void setGlobalExchange(String globalExchange) {
        this.globalExchange = globalExchange;
    }

    public Integer getNumberOfDescriptionLines() {
        return numberOfDescriptionLines;
    }

    public void setNumberOfDescriptionLines(Integer numberOfDescriptionLines) {
        this.numberOfDescriptionLines = numberOfDescriptionLines;
    }

    public Integer getLastDescriptionLine() {
        return lastDescriptionLine;
    }

    public void setLastDescriptionLine(Integer lastDescriptionLine) {
        this.lastDescriptionLine = lastDescriptionLine;
    }

    public String getDescriptionLine1() {
        return descriptionLine1;
    }

    public void setDescriptionLine1(String descriptionLine1) {
        this.descriptionLine1 = descriptionLine1;
    }

    public String getDescriptionLine2() {
        return descriptionLine2;
    }

    public void setDescriptionLine2(String descriptionLine2) {
        this.descriptionLine2 = descriptionLine2;
    }

    public String getDescriptionLine3() {
        return descriptionLine3;
    }

    public void setDescriptionLine3(String descriptionLine3) {
        this.descriptionLine3 = descriptionLine3;
    }

    public String getDescriptionLine4() {
        return descriptionLine4;
    }

    public void setDescriptionLine4(String descriptionLine4) {
        this.descriptionLine4 = descriptionLine4;
    }

    public String getDescriptionLine5() {
        return descriptionLine5;
    }

    public void setDescriptionLine5(String descriptionLine5) {
        this.descriptionLine5 = descriptionLine5;
    }

    public String getDescriptionLine6() {
        return descriptionLine6;
    }

    public void setDescriptionLine6(String descriptionLine6) {
        this.descriptionLine6 = descriptionLine6;
    }

    public String getDescriptionLine7() {
        return descriptionLine7;
    }

    public void setDescriptionLine7(String descriptionLine7) {
        this.descriptionLine7 = descriptionLine7;
    }

    public String getDescriptionLine8() {
        return descriptionLine8;
    }

    public void setDescriptionLine8(String descriptionLine8) {
        this.descriptionLine8 = descriptionLine8;
    }

    public String getDescriptionLine9() {
        return descriptionLine9;
    }

    public void setDescriptionLine9(String descriptionLine9) {
        this.descriptionLine9 = descriptionLine9;
    }

    public String getDescriptionLine10() {
        return descriptionLine10;
    }

    public void setDescriptionLine10(String descriptionLine10) {
        this.descriptionLine10 = descriptionLine10;
    }

    public String getDescriptionLine11() {
        return descriptionLine11;
    }

    public void setDescriptionLine11(String descriptionLine11) {
        this.descriptionLine11 = descriptionLine11;
    }

    public String getDescriptionLine12() {
        return descriptionLine12;
    }

    public void setDescriptionLine12(String descriptionLine12) {
        this.descriptionLine12 = descriptionLine12;
    }

    public String getSecurityCurrencyIndicator() {
        return securityCurrencyIndicator;
    }

    public void setSecurityCurrencyIndicator(String securityCurrencyIndicator) {
        this.securityCurrencyIndicator = securityCurrencyIndicator;
    }

    public String getMarketMnemonicCode() {
        return marketMnemonicCode;
    }

    public void setMarketMnemonicCode(String marketMnemonicCode) {
        this.marketMnemonicCode = marketMnemonicCode;
    }

    public BigDecimal getCcyOfIssuanceUsdCcyFxRate() {
        return ccyOfIssuanceUsdCcyFxRate;
    }

    public void setCcyOfIssuanceUsdCcyFxRate(BigDecimal ccyOfIssuanceUsdCcyFxRate) {
        this.ccyOfIssuanceUsdCcyFxRate = ccyOfIssuanceUsdCcyFxRate;
    }

    public String getCcyOfIssuanceUsdMultiplyDivideCode() {
        return ccyOfIssuanceUsdMultiplyDivideCode;
    }

    public void setCcyOfIssuanceUsdMultiplyDivideCode(String ccyOfIssuanceUsdMultiplyDivideCode) {
        this.ccyOfIssuanceUsdMultiplyDivideCode = ccyOfIssuanceUsdMultiplyDivideCode;
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

    public String getAlternateSecurityIdType2() {
        return alternateSecurityIdType2;
    }

    public void setAlternateSecurityIdType2(String alternateSecurityIdType2) {
        this.alternateSecurityIdType2 = alternateSecurityIdType2;
    }

    public String getAlternateSecurityId2() {
        return alternateSecurityId2;
    }

    public void setAlternateSecurityId2(String alternateSecurityId2) {
        this.alternateSecurityId2 = alternateSecurityId2;
    }

    public String getInternationalNonDollarSymbol() {
        return internationalNonDollarSymbol;
    }

    public void setInternationalNonDollarSymbol(String internationalNonDollarSymbol) {
        this.internationalNonDollarSymbol = internationalNonDollarSymbol;
    }

    public String getConfirmationCode1() {
        return confirmationCode1;
    }

    public void setConfirmationCode1(String confirmationCode1) {
        this.confirmationCode1 = confirmationCode1;
    }

    public String getConfirmationCode2() {
        return confirmationCode2;
    }

    public void setConfirmationCode2(String confirmationCode2) {
        this.confirmationCode2 = confirmationCode2;
    }

    public String getConfirmationCode3() {
        return confirmationCode3;
    }

    public void setConfirmationCode3(String confirmationCode3) {
        this.confirmationCode3 = confirmationCode3;
    }

    public String getConfirmationCode4() {
        return confirmationCode4;
    }

    public void setConfirmationCode4(String confirmationCode4) {
        this.confirmationCode4 = confirmationCode4;
    }

    public BigDecimal getPmp() {
        return pmp;
    }

    public void setPmp(BigDecimal pmp) {
        this.pmp = pmp;
    }

    public BigDecimal getTotalAmountMarkUpDown() {
        return totalAmountMarkUpDown;
    }

    public void setTotalAmountMarkUpDown(BigDecimal totalAmountMarkUpDown) {
        this.totalAmountMarkUpDown = totalAmountMarkUpDown;
    }

    public String getTotalAmountMarkUpDownSign() {
        return totalAmountMarkUpDownSign;
    }

    public void setTotalAmountMarkUpDownSign(String totalAmountMarkUpDownSign) {
        this.totalAmountMarkUpDownSign = totalAmountMarkUpDownSign;
    }

    public BigDecimal getPmpPercent() {
        return pmpPercent;
    }

    public void setPmpPercent(BigDecimal pmpPercent) {
        this.pmpPercent = pmpPercent;
    }

    public String getCampo73() {
        return campo73;
    }

    public void setCampo73(String campo73) {
        this.campo73 = campo73;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}