package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_gact_reg_a", schema = "stage_pershing")
public class StageGactRegA {
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
    @Column(name = "campo_6", length = 100)
    private String campo6;

    @Size(max = 100)
    @Column(name = "underlying_cusip", length = 100)
    private String underlyingCusip;

    @Size(max = 100)
    @Column(name = "campo_8", length = 100)
    private String campo8;

    @Size(max = 100)
    @Column(name = "security_symbol", length = 100)
    private String securitySymbol;

    @Size(max = 100)
    @Column(name = "investment_professional_of_record", length = 100)
    private String investmentProfessionalOfRecord;

    @Size(max = 100)
    @Column(name = "executing_investment_professional", length = 100)
    private String executingInvestmentProfessional;

    @Size(max = 100)
    @Column(name = "transaction_type", length = 100)
    private String transactionType;

    @Size(max = 100)
    @Column(name = "buy_sell_code", length = 100)
    private String buySellCode;

    @Size(max = 100)
    @Column(name = "open_close_indicator", length = 100)
    private String openCloseIndicator;

    @Size(max = 100)
    @Column(name = "par_key_code", length = 100)
    private String parKeyCode;

    @Size(max = 100)
    @Column(name = "source_code", length = 100)
    private String sourceCode;

    @Column(name = "maxx_key_code")
    private Integer maxxKeyCode;

    @Column(name = "process_date_sfl")
    private LocalDate processDateSfl;

    @Column(name = "trade_date")
    private LocalDate tradeDate;

    @Column(name = "settlement_entry_date")
    private LocalDate settlementEntryDate;

    @Size(max = 100)
    @Column(name = "campo_21", length = 100)
    private String campo21;

    @Size(max = 100)
    @Column(name = "source_of_input", length = 100)
    private String sourceOfInput;

    @Size(max = 100)
    @Column(name = "reference_number", length = 100)
    private String referenceNumber;

    @Size(max = 100)
    @Column(name = "batch_code", length = 100)
    private String batchCode;

    @Size(max = 100)
    @Column(name = "same_day_settlement", length = 100)
    private String sameDaySettlement;

    @Size(max = 100)
    @Column(name = "contra_account", length = 100)
    private String contraAccount;

    @Size(max = 100)
    @Column(name = "market_code", length = 100)
    private String marketCode;

    @Size(max = 100)
    @Column(name = "blotter_code", length = 100)
    private String blotterCode;

    @Size(max = 100)
    @Column(name = "cancel_code", length = 100)
    private String cancelCode;

    @Size(max = 100)
    @Column(name = "correction_code", length = 100)
    private String correctionCode;

    @Size(max = 100)
    @Column(name = "merket_limit_indicator", length = 100)
    private String merketLimitIndicator;

    @Size(max = 100)
    @Column(name = "legend_code_1", length = 100)
    private String legendCode1;

    @Size(max = 100)
    @Column(name = "legend_code_2", length = 100)
    private String legendCode2;

    @Size(max = 100)
    @Column(name = "campo_34", length = 100)
    private String campo34;

    @Column(name = "quantity", precision = 45, scale = 20)
    private BigDecimal quantity;

    @Size(max = 100)
    @Column(name = "quantity_sign", length = 100)
    private String quantitySign;

    @Column(name = "price_in_trade_currency", precision = 45, scale = 20)
    private BigDecimal priceInTradeCurrency;

    @Size(max = 100)
    @Column(name = "campo_38", length = 100)
    private String campo38;

    @Size(max = 100)
    @Column(name = "price_in_trade_currency_sign", length = 100)
    private String priceInTradeCurrencySign;

    @Size(max = 100)
    @Column(name = "currency_indicator_for_price", length = 100)
    private String currencyIndicatorForPrice;

    @Column(name = "net_amount_in_usd", precision = 45, scale = 20)
    private BigDecimal netAmountInUsd;

    @Size(max = 100)
    @Column(name = "net_amount_in_usd_sign", length = 100)
    private String netAmountInUsdSign;

    @Column(name = "principal_in_usd", precision = 45, scale = 20)
    private BigDecimal principalInUsd;

    @Size(max = 100)
    @Column(name = "principal_in_usd_sign", length = 100)
    private String principalInUsdSign;

    @Column(name = "interest_in_usd", precision = 45, scale = 20)
    private BigDecimal interestInUsd;

    @Size(max = 100)
    @Column(name = "interest_in_usd_sign", length = 100)
    private String interestInUsdSign;

    @Column(name = "commision_in_usd", precision = 45, scale = 20)
    private BigDecimal commisionInUsd;

    @Size(max = 100)
    @Column(name = "commision_in_usd_sign", length = 100)
    private String commisionInUsdSign;

    @Column(name = "tax_in_usd", precision = 45, scale = 20)
    private BigDecimal taxInUsd;

    @Size(max = 100)
    @Column(name = "tax_in_usd_sign", length = 100)
    private String taxInUsdSign;

    @Column(name = "transaction_fee_in_usd", precision = 45, scale = 20)
    private BigDecimal transactionFeeInUsd;

    @Size(max = 100)
    @Column(name = "transaction_fee_in_usd_sign", length = 100)
    private String transactionFeeInUsdSign;

    @Column(name = "misc_fee_in_usd", precision = 45, scale = 20)
    private BigDecimal miscFeeInUsd;

    @Size(max = 100)
    @Column(name = "misc_fee_in_usd_sign", length = 100)
    private String miscFeeInUsdSign;

    @Column(name = "other_fee_in_usd", precision = 45, scale = 20)
    private BigDecimal otherFeeInUsd;

    @Size(max = 100)
    @Column(name = "other_fee_in_usd_sign", length = 100)
    private String otherFeeInUsdSign;

    @Column(name = "tefra_wh_amount_in_usd", precision = 45, scale = 20)
    private BigDecimal tefraWhAmountInUsd;

    @Size(max = 100)
    @Column(name = "tefra_wh_amount_in_usd_sign", length = 100)
    private String tefraWhAmountInUsdSign;

    @Column(name = "pershing_charge_in_usd", precision = 45, scale = 20)
    private BigDecimal pershingChargeInUsd;

    @Size(max = 100)
    @Column(name = "pershing_charge_in_usd_sign", length = 100)
    private String pershingChargeInUsdSign;

    @Column(name = "brokerage_charge_in_usd", precision = 45, scale = 20)
    private BigDecimal brokerageChargeInUsd;

    @Size(max = 100)
    @Column(name = "brokerage_charge_in_usd_sign", length = 100)
    private String brokerageChargeInUsdSign;

    @Column(name = "sales_credit_in_usd", precision = 45, scale = 20)
    private BigDecimal salesCreditInUsd;

    @Size(max = 100)
    @Column(name = "sales_credit_in_usd_sign", length = 100)
    private String salesCreditInUsdSign;

    @Column(name = "settlement_fee_in_usd", precision = 45, scale = 20)
    private BigDecimal settlementFeeInUsd;

    @Size(max = 100)
    @Column(name = "settlement_fee_in_usd_sign", length = 100)
    private String settlementFeeInUsdSign;

    @Column(name = "service_charge_in_usd", precision = 45, scale = 20)
    private BigDecimal serviceChargeInUsd;

    @Size(max = 100)
    @Column(name = "service_charge_in_usd_sign", length = 100)
    private String serviceChargeInUsdSign;

    @Column(name = "markup_markdown_amount_in_usd", precision = 45, scale = 20)
    private BigDecimal markupMarkdownAmountInUsd;

    @Size(max = 100)
    @Column(name = "markup_markdown_amount_in_usd_sign", length = 100)
    private String markupMarkdownAmountInUsdSign;

    @Size(max = 100)
    @Column(name = "campo_71", length = 100)
    private String campo71;

    @Column(name = "dividend_payable_date")
    private LocalDate dividendPayableDate;

    @Size(max = 100)
    @Column(name = "campo_73", length = 100)
    private String campo73;

    @Column(name = "dividend_record_date")
    private LocalDate dividendRecordDate;

    @Column(name = "dividend_type")
    private Integer dividendType;

    @Size(max = 100)
    @Column(name = "campo_76", length = 100)
    private String campo76;

    @Column(name = "shares_of_record_quantity_for_dividends", precision = 45, scale = 20)
    private BigDecimal sharesOfRecordQuantityForDividends;

    @Column(name = "order_size_quantity", precision = 45, scale = 20)
    private BigDecimal orderSizeQuantity;

    @Size(max = 100)
    @Column(name = "campo_79", length = 100)
    private String campo79;

    @Column(name = "pool_factor", precision = 45, scale = 20)
    private BigDecimal poolFactor;

    @Size(max = 100)
    @Column(name = "parsed_customer_account_number", length = 100)
    private String parsedCustomerAccountNumber;

    @Size(max = 100)
    @Column(name = "ibd_number", length = 100)
    private String ibdNumber;

    @Size(max = 100)
    @Column(name = "security_type_code", length = 100)
    private String securityTypeCode;

    @Size(max = 100)
    @Column(name = "security_modifier_code", length = 100)
    private String securityModifierCode;

    @Size(max = 100)
    @Column(name = "security_calculation_code", length = 100)
    private String securityCalculationCode;

    @Size(max = 100)
    @Column(name = "minor_product_code", length = 100)
    private String minorProductCode;

    @Size(max = 100)
    @Column(name = "foreign_product_indicator", length = 100)
    private String foreignProductIndicator;

    @Size(max = 100)
    @Column(name = "with_due_bill_indicator", length = 100)
    private String withDueBillIndicator;

    @Size(max = 100)
    @Column(name = "taxable_municipal_bond_indicator", length = 100)
    private String taxableMunicipalBondIndicator;

    @Size(max = 100)
    @Column(name = "omnibus_indicator", length = 100)
    private String omnibusIndicator;

    @Size(max = 100)
    @Column(name = "external_order_id", length = 100)
    private String externalOrderId;

    @Size(max = 100)
    @Column(name = "campo_92", length = 100)
    private String campo92;

    @Column(name = "market_value_of_transaction", precision = 45, scale = 20)
    private BigDecimal marketValueOfTransaction;

    @Size(max = 100)
    @Column(name = "ip_number_parsed", length = 100)
    private String ipNumberParsed;

    @Column(name = "reported_price", precision = 45, scale = 20)
    private BigDecimal reportedPrice;

    @Size(max = 100)
    @Column(name = "reported_price_sign", length = 100)
    private String reportedPriceSign;

    @Column(name = "previous_day_market_value_of_transaction", precision = 45, scale = 20)
    private BigDecimal previousDayMarketValueOfTransaction;

    @Column(name = "price_in_usd", precision = 45, scale = 20)
    private BigDecimal priceInUsd;

    @Size(max = 100)
    @Column(name = "option_root_id", length = 100)
    private String optionRootId;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Size(max = 100)
    @Column(name = "put_call_code", length = 100)
    private String putCallCode;

    @Column(name = "strike_price", precision = 45, scale = 20)
    private BigDecimal strikePrice;

    @Size(max = 100)
    @Column(name = "repo_identifier", length = 100)
    private String repoIdentifier;

    @Size(max = 100)
    @Column(name = "taxable", length = 100)
    private String taxable;

    @Size(max = 100)
    @Column(name = "qualified", length = 100)
    private String qualified;

    @Size(max = 100)
    @Column(name = "expanded_ip_number", length = 100)
    private String expandedIpNumber;

    @Size(max = 100)
    @Column(name = "expanded_exec_ip_number", length = 100)
    private String expandedExecIpNumber;

    @Size(max = 100)
    @Column(name = "expanded_legacy_ip_number", length = 100)
    private String expandedLegacyIpNumber;

    @Size(max = 100)
    @Column(name = "campo_109", length = 100)
    private String campo109;

    @Size(max = 100)
    @Column(name = "campo_110", length = 100)
    private String campo110;

    @Size(max = 100)
    @Column(name = "campo_111", length = 100)
    private String campo111;

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

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getUnderlyingCusip() {
        return underlyingCusip;
    }

    public void setUnderlyingCusip(String underlyingCusip) {
        this.underlyingCusip = underlyingCusip;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getSecuritySymbol() {
        return securitySymbol;
    }

    public void setSecuritySymbol(String securitySymbol) {
        this.securitySymbol = securitySymbol;
    }

    public String getInvestmentProfessionalOfRecord() {
        return investmentProfessionalOfRecord;
    }

    public void setInvestmentProfessionalOfRecord(String investmentProfessionalOfRecord) {
        this.investmentProfessionalOfRecord = investmentProfessionalOfRecord;
    }

    public String getExecutingInvestmentProfessional() {
        return executingInvestmentProfessional;
    }

    public void setExecutingInvestmentProfessional(String executingInvestmentProfessional) {
        this.executingInvestmentProfessional = executingInvestmentProfessional;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBuySellCode() {
        return buySellCode;
    }

    public void setBuySellCode(String buySellCode) {
        this.buySellCode = buySellCode;
    }

    public String getOpenCloseIndicator() {
        return openCloseIndicator;
    }

    public void setOpenCloseIndicator(String openCloseIndicator) {
        this.openCloseIndicator = openCloseIndicator;
    }

    public String getParKeyCode() {
        return parKeyCode;
    }

    public void setParKeyCode(String parKeyCode) {
        this.parKeyCode = parKeyCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Integer getMaxxKeyCode() {
        return maxxKeyCode;
    }

    public void setMaxxKeyCode(Integer maxxKeyCode) {
        this.maxxKeyCode = maxxKeyCode;
    }

    public LocalDate getProcessDateSfl() {
        return processDateSfl;
    }

    public void setProcessDateSfl(LocalDate processDateSfl) {
        this.processDateSfl = processDateSfl;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getSettlementEntryDate() {
        return settlementEntryDate;
    }

    public void setSettlementEntryDate(LocalDate settlementEntryDate) {
        this.settlementEntryDate = settlementEntryDate;
    }

    public String getCampo21() {
        return campo21;
    }

    public void setCampo21(String campo21) {
        this.campo21 = campo21;
    }

    public String getSourceOfInput() {
        return sourceOfInput;
    }

    public void setSourceOfInput(String sourceOfInput) {
        this.sourceOfInput = sourceOfInput;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getSameDaySettlement() {
        return sameDaySettlement;
    }

    public void setSameDaySettlement(String sameDaySettlement) {
        this.sameDaySettlement = sameDaySettlement;
    }

    public String getContraAccount() {
        return contraAccount;
    }

    public void setContraAccount(String contraAccount) {
        this.contraAccount = contraAccount;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getBlotterCode() {
        return blotterCode;
    }

    public void setBlotterCode(String blotterCode) {
        this.blotterCode = blotterCode;
    }

    public String getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(String cancelCode) {
        this.cancelCode = cancelCode;
    }

    public String getCorrectionCode() {
        return correctionCode;
    }

    public void setCorrectionCode(String correctionCode) {
        this.correctionCode = correctionCode;
    }

    public String getMerketLimitIndicator() {
        return merketLimitIndicator;
    }

    public void setMerketLimitIndicator(String merketLimitIndicator) {
        this.merketLimitIndicator = merketLimitIndicator;
    }

    public String getLegendCode1() {
        return legendCode1;
    }

    public void setLegendCode1(String legendCode1) {
        this.legendCode1 = legendCode1;
    }

    public String getLegendCode2() {
        return legendCode2;
    }

    public void setLegendCode2(String legendCode2) {
        this.legendCode2 = legendCode2;
    }

    public String getCampo34() {
        return campo34;
    }

    public void setCampo34(String campo34) {
        this.campo34 = campo34;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getQuantitySign() {
        return quantitySign;
    }

    public void setQuantitySign(String quantitySign) {
        this.quantitySign = quantitySign;
    }

    public BigDecimal getPriceInTradeCurrency() {
        return priceInTradeCurrency;
    }

    public void setPriceInTradeCurrency(BigDecimal priceInTradeCurrency) {
        this.priceInTradeCurrency = priceInTradeCurrency;
    }

    public String getCampo38() {
        return campo38;
    }

    public void setCampo38(String campo38) {
        this.campo38 = campo38;
    }

    public String getPriceInTradeCurrencySign() {
        return priceInTradeCurrencySign;
    }

    public void setPriceInTradeCurrencySign(String priceInTradeCurrencySign) {
        this.priceInTradeCurrencySign = priceInTradeCurrencySign;
    }

    public String getCurrencyIndicatorForPrice() {
        return currencyIndicatorForPrice;
    }

    public void setCurrencyIndicatorForPrice(String currencyIndicatorForPrice) {
        this.currencyIndicatorForPrice = currencyIndicatorForPrice;
    }

    public BigDecimal getNetAmountInUsd() {
        return netAmountInUsd;
    }

    public void setNetAmountInUsd(BigDecimal netAmountInUsd) {
        this.netAmountInUsd = netAmountInUsd;
    }

    public String getNetAmountInUsdSign() {
        return netAmountInUsdSign;
    }

    public void setNetAmountInUsdSign(String netAmountInUsdSign) {
        this.netAmountInUsdSign = netAmountInUsdSign;
    }

    public BigDecimal getPrincipalInUsd() {
        return principalInUsd;
    }

    public void setPrincipalInUsd(BigDecimal principalInUsd) {
        this.principalInUsd = principalInUsd;
    }

    public String getPrincipalInUsdSign() {
        return principalInUsdSign;
    }

    public void setPrincipalInUsdSign(String principalInUsdSign) {
        this.principalInUsdSign = principalInUsdSign;
    }

    public BigDecimal getInterestInUsd() {
        return interestInUsd;
    }

    public void setInterestInUsd(BigDecimal interestInUsd) {
        this.interestInUsd = interestInUsd;
    }

    public String getInterestInUsdSign() {
        return interestInUsdSign;
    }

    public void setInterestInUsdSign(String interestInUsdSign) {
        this.interestInUsdSign = interestInUsdSign;
    }

    public BigDecimal getCommisionInUsd() {
        return commisionInUsd;
    }

    public void setCommisionInUsd(BigDecimal commisionInUsd) {
        this.commisionInUsd = commisionInUsd;
    }

    public String getCommisionInUsdSign() {
        return commisionInUsdSign;
    }

    public void setCommisionInUsdSign(String commisionInUsdSign) {
        this.commisionInUsdSign = commisionInUsdSign;
    }

    public BigDecimal getTaxInUsd() {
        return taxInUsd;
    }

    public void setTaxInUsd(BigDecimal taxInUsd) {
        this.taxInUsd = taxInUsd;
    }

    public String getTaxInUsdSign() {
        return taxInUsdSign;
    }

    public void setTaxInUsdSign(String taxInUsdSign) {
        this.taxInUsdSign = taxInUsdSign;
    }

    public BigDecimal getTransactionFeeInUsd() {
        return transactionFeeInUsd;
    }

    public void setTransactionFeeInUsd(BigDecimal transactionFeeInUsd) {
        this.transactionFeeInUsd = transactionFeeInUsd;
    }

    public String getTransactionFeeInUsdSign() {
        return transactionFeeInUsdSign;
    }

    public void setTransactionFeeInUsdSign(String transactionFeeInUsdSign) {
        this.transactionFeeInUsdSign = transactionFeeInUsdSign;
    }

    public BigDecimal getMiscFeeInUsd() {
        return miscFeeInUsd;
    }

    public void setMiscFeeInUsd(BigDecimal miscFeeInUsd) {
        this.miscFeeInUsd = miscFeeInUsd;
    }

    public String getMiscFeeInUsdSign() {
        return miscFeeInUsdSign;
    }

    public void setMiscFeeInUsdSign(String miscFeeInUsdSign) {
        this.miscFeeInUsdSign = miscFeeInUsdSign;
    }

    public BigDecimal getOtherFeeInUsd() {
        return otherFeeInUsd;
    }

    public void setOtherFeeInUsd(BigDecimal otherFeeInUsd) {
        this.otherFeeInUsd = otherFeeInUsd;
    }

    public String getOtherFeeInUsdSign() {
        return otherFeeInUsdSign;
    }

    public void setOtherFeeInUsdSign(String otherFeeInUsdSign) {
        this.otherFeeInUsdSign = otherFeeInUsdSign;
    }

    public BigDecimal getTefraWhAmountInUsd() {
        return tefraWhAmountInUsd;
    }

    public void setTefraWhAmountInUsd(BigDecimal tefraWhAmountInUsd) {
        this.tefraWhAmountInUsd = tefraWhAmountInUsd;
    }

    public String getTefraWhAmountInUsdSign() {
        return tefraWhAmountInUsdSign;
    }

    public void setTefraWhAmountInUsdSign(String tefraWhAmountInUsdSign) {
        this.tefraWhAmountInUsdSign = tefraWhAmountInUsdSign;
    }

    public BigDecimal getPershingChargeInUsd() {
        return pershingChargeInUsd;
    }

    public void setPershingChargeInUsd(BigDecimal pershingChargeInUsd) {
        this.pershingChargeInUsd = pershingChargeInUsd;
    }

    public String getPershingChargeInUsdSign() {
        return pershingChargeInUsdSign;
    }

    public void setPershingChargeInUsdSign(String pershingChargeInUsdSign) {
        this.pershingChargeInUsdSign = pershingChargeInUsdSign;
    }

    public BigDecimal getBrokerageChargeInUsd() {
        return brokerageChargeInUsd;
    }

    public void setBrokerageChargeInUsd(BigDecimal brokerageChargeInUsd) {
        this.brokerageChargeInUsd = brokerageChargeInUsd;
    }

    public String getBrokerageChargeInUsdSign() {
        return brokerageChargeInUsdSign;
    }

    public void setBrokerageChargeInUsdSign(String brokerageChargeInUsdSign) {
        this.brokerageChargeInUsdSign = brokerageChargeInUsdSign;
    }

    public BigDecimal getSalesCreditInUsd() {
        return salesCreditInUsd;
    }

    public void setSalesCreditInUsd(BigDecimal salesCreditInUsd) {
        this.salesCreditInUsd = salesCreditInUsd;
    }

    public String getSalesCreditInUsdSign() {
        return salesCreditInUsdSign;
    }

    public void setSalesCreditInUsdSign(String salesCreditInUsdSign) {
        this.salesCreditInUsdSign = salesCreditInUsdSign;
    }

    public BigDecimal getSettlementFeeInUsd() {
        return settlementFeeInUsd;
    }

    public void setSettlementFeeInUsd(BigDecimal settlementFeeInUsd) {
        this.settlementFeeInUsd = settlementFeeInUsd;
    }

    public String getSettlementFeeInUsdSign() {
        return settlementFeeInUsdSign;
    }

    public void setSettlementFeeInUsdSign(String settlementFeeInUsdSign) {
        this.settlementFeeInUsdSign = settlementFeeInUsdSign;
    }

    public BigDecimal getServiceChargeInUsd() {
        return serviceChargeInUsd;
    }

    public void setServiceChargeInUsd(BigDecimal serviceChargeInUsd) {
        this.serviceChargeInUsd = serviceChargeInUsd;
    }

    public String getServiceChargeInUsdSign() {
        return serviceChargeInUsdSign;
    }

    public void setServiceChargeInUsdSign(String serviceChargeInUsdSign) {
        this.serviceChargeInUsdSign = serviceChargeInUsdSign;
    }

    public BigDecimal getMarkupMarkdownAmountInUsd() {
        return markupMarkdownAmountInUsd;
    }

    public void setMarkupMarkdownAmountInUsd(BigDecimal markupMarkdownAmountInUsd) {
        this.markupMarkdownAmountInUsd = markupMarkdownAmountInUsd;
    }

    public String getMarkupMarkdownAmountInUsdSign() {
        return markupMarkdownAmountInUsdSign;
    }

    public void setMarkupMarkdownAmountInUsdSign(String markupMarkdownAmountInUsdSign) {
        this.markupMarkdownAmountInUsdSign = markupMarkdownAmountInUsdSign;
    }

    public String getCampo71() {
        return campo71;
    }

    public void setCampo71(String campo71) {
        this.campo71 = campo71;
    }

    public LocalDate getDividendPayableDate() {
        return dividendPayableDate;
    }

    public void setDividendPayableDate(LocalDate dividendPayableDate) {
        this.dividendPayableDate = dividendPayableDate;
    }

    public String getCampo73() {
        return campo73;
    }

    public void setCampo73(String campo73) {
        this.campo73 = campo73;
    }

    public LocalDate getDividendRecordDate() {
        return dividendRecordDate;
    }

    public void setDividendRecordDate(LocalDate dividendRecordDate) {
        this.dividendRecordDate = dividendRecordDate;
    }

    public Integer getDividendType() {
        return dividendType;
    }

    public void setDividendType(Integer dividendType) {
        this.dividendType = dividendType;
    }

    public String getCampo76() {
        return campo76;
    }

    public void setCampo76(String campo76) {
        this.campo76 = campo76;
    }

    public BigDecimal getSharesOfRecordQuantityForDividends() {
        return sharesOfRecordQuantityForDividends;
    }

    public void setSharesOfRecordQuantityForDividends(BigDecimal sharesOfRecordQuantityForDividends) {
        this.sharesOfRecordQuantityForDividends = sharesOfRecordQuantityForDividends;
    }

    public BigDecimal getOrderSizeQuantity() {
        return orderSizeQuantity;
    }

    public void setOrderSizeQuantity(BigDecimal orderSizeQuantity) {
        this.orderSizeQuantity = orderSizeQuantity;
    }

    public String getCampo79() {
        return campo79;
    }

    public void setCampo79(String campo79) {
        this.campo79 = campo79;
    }

    public BigDecimal getPoolFactor() {
        return poolFactor;
    }

    public void setPoolFactor(BigDecimal poolFactor) {
        this.poolFactor = poolFactor;
    }

    public String getParsedCustomerAccountNumber() {
        return parsedCustomerAccountNumber;
    }

    public void setParsedCustomerAccountNumber(String parsedCustomerAccountNumber) {
        this.parsedCustomerAccountNumber = parsedCustomerAccountNumber;
    }

    public String getIbdNumber() {
        return ibdNumber;
    }

    public void setIbdNumber(String ibdNumber) {
        this.ibdNumber = ibdNumber;
    }

    public String getSecurityTypeCode() {
        return securityTypeCode;
    }

    public void setSecurityTypeCode(String securityTypeCode) {
        this.securityTypeCode = securityTypeCode;
    }

    public String getSecurityModifierCode() {
        return securityModifierCode;
    }

    public void setSecurityModifierCode(String securityModifierCode) {
        this.securityModifierCode = securityModifierCode;
    }

    public String getSecurityCalculationCode() {
        return securityCalculationCode;
    }

    public void setSecurityCalculationCode(String securityCalculationCode) {
        this.securityCalculationCode = securityCalculationCode;
    }

    public String getMinorProductCode() {
        return minorProductCode;
    }

    public void setMinorProductCode(String minorProductCode) {
        this.minorProductCode = minorProductCode;
    }

    public String getForeignProductIndicator() {
        return foreignProductIndicator;
    }

    public void setForeignProductIndicator(String foreignProductIndicator) {
        this.foreignProductIndicator = foreignProductIndicator;
    }

    public String getWithDueBillIndicator() {
        return withDueBillIndicator;
    }

    public void setWithDueBillIndicator(String withDueBillIndicator) {
        this.withDueBillIndicator = withDueBillIndicator;
    }

    public String getTaxableMunicipalBondIndicator() {
        return taxableMunicipalBondIndicator;
    }

    public void setTaxableMunicipalBondIndicator(String taxableMunicipalBondIndicator) {
        this.taxableMunicipalBondIndicator = taxableMunicipalBondIndicator;
    }

    public String getOmnibusIndicator() {
        return omnibusIndicator;
    }

    public void setOmnibusIndicator(String omnibusIndicator) {
        this.omnibusIndicator = omnibusIndicator;
    }

    public String getExternalOrderId() {
        return externalOrderId;
    }

    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId;
    }

    public String getCampo92() {
        return campo92;
    }

    public void setCampo92(String campo92) {
        this.campo92 = campo92;
    }

    public BigDecimal getMarketValueOfTransaction() {
        return marketValueOfTransaction;
    }

    public void setMarketValueOfTransaction(BigDecimal marketValueOfTransaction) {
        this.marketValueOfTransaction = marketValueOfTransaction;
    }

    public String getIpNumberParsed() {
        return ipNumberParsed;
    }

    public void setIpNumberParsed(String ipNumberParsed) {
        this.ipNumberParsed = ipNumberParsed;
    }

    public BigDecimal getReportedPrice() {
        return reportedPrice;
    }

    public void setReportedPrice(BigDecimal reportedPrice) {
        this.reportedPrice = reportedPrice;
    }

    public String getReportedPriceSign() {
        return reportedPriceSign;
    }

    public void setReportedPriceSign(String reportedPriceSign) {
        this.reportedPriceSign = reportedPriceSign;
    }

    public BigDecimal getPreviousDayMarketValueOfTransaction() {
        return previousDayMarketValueOfTransaction;
    }

    public void setPreviousDayMarketValueOfTransaction(BigDecimal previousDayMarketValueOfTransaction) {
        this.previousDayMarketValueOfTransaction = previousDayMarketValueOfTransaction;
    }

    public BigDecimal getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUsd(BigDecimal priceInUsd) {
        this.priceInUsd = priceInUsd;
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

    public String getPutCallCode() {
        return putCallCode;
    }

    public void setPutCallCode(String putCallCode) {
        this.putCallCode = putCallCode;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(BigDecimal strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getRepoIdentifier() {
        return repoIdentifier;
    }

    public void setRepoIdentifier(String repoIdentifier) {
        this.repoIdentifier = repoIdentifier;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }

    public String getExpandedIpNumber() {
        return expandedIpNumber;
    }

    public void setExpandedIpNumber(String expandedIpNumber) {
        this.expandedIpNumber = expandedIpNumber;
    }

    public String getExpandedExecIpNumber() {
        return expandedExecIpNumber;
    }

    public void setExpandedExecIpNumber(String expandedExecIpNumber) {
        this.expandedExecIpNumber = expandedExecIpNumber;
    }

    public String getExpandedLegacyIpNumber() {
        return expandedLegacyIpNumber;
    }

    public void setExpandedLegacyIpNumber(String expandedLegacyIpNumber) {
        this.expandedLegacyIpNumber = expandedLegacyIpNumber;
    }

    public String getCampo109() {
        return campo109;
    }

    public void setCampo109(String campo109) {
        this.campo109 = campo109;
    }

    public String getCampo110() {
        return campo110;
    }

    public void setCampo110(String campo110) {
        this.campo110 = campo110;
    }

    public String getCampo111() {
        return campo111;
    }

    public void setCampo111(String campo111) {
        this.campo111 = campo111;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}