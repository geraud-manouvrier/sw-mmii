package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_gcus_reg_b", schema = "stage_pershing")
public class StageGcusRegB {
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

    @Column(name = "recor_id_sequence_number")
    private Integer recorIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "account_number", length = 100)
    private String accountNumber;

    @Size(max = 100)
    @Column(name = "cusip_number", length = 100)
    private String cusipNumber;

    @Size(max = 100)
    @Column(name = "position_currency", length = 100)
    private String positionCurrency;

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

    @Column(name = "fully_paid_lending_quantity", precision = 45, scale = 20)
    private BigDecimal fullyPaidLendingQuantity;

    @Size(max = 100)
    @Column(name = "fully_paid_lending_quantity_sign", length = 100)
    private String fullyPaidLendingQuantitySign;

    @Column(name = "fully_paid_lending_quantity_collateral_amount", precision = 45, scale = 20)
    private BigDecimal fullyPaidLendingQuantityCollateralAmount;

    @Size(max = 100)
    @Column(name = "fully_paid_lending_quantity_collateral_amount_sign", length = 100)
    private String fullyPaidLendingQuantityCollateralAmountSign;

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

    @Column(name = "trade_date_repo_quantity", precision = 45, scale = 20)
    private BigDecimal tradeDateRepoQuantity;

    @Size(max = 100)
    @Column(name = "trade_date_repo_quantity_sign", length = 100)
    private String tradeDateRepoQuantitySign;

    @Column(name = "settlement_date_repo_quantity", precision = 45, scale = 20)
    private BigDecimal settlementDateRepoQuantity;

    @Size(max = 100)
    @Column(name = "settlement_date_repo_quantity_sign", length = 100)
    private String settlementDateRepoQuantitySign;

    @Column(name = "trade_date_reverse_repo_quantity", precision = 45, scale = 20)
    private BigDecimal tradeDateReverseRepoQuantity;

    @Size(max = 100)
    @Column(name = "trade_date_reverse_repo_quantity_sign", length = 100)
    private String tradeDateReverseRepoQuantitySign;

    @Column(name = "settlement_date_reverse_repo_quantity", precision = 45, scale = 20)
    private BigDecimal settlementDateReverseRepoQuantity;

    @Size(max = 100)
    @Column(name = "settlement_date_reverse_repo_quantity_sign", length = 100)
    private String settlementDateReverseRepoQuantitySign;

    @Column(name = "collateral_pledge_quantity", precision = 45, scale = 20)
    private BigDecimal collateralPledgeQuantity;

    @Size(max = 100)
    @Column(name = "collateral_pledge_quantity_sign", length = 100)
    private String collateralPledgeQuantitySign;

    @Column(name = "corporate_exec_serv_collateral_pledge_quantity", precision = 45, scale = 20)
    private BigDecimal corporateExecServCollateralPledgeQuantity;

    @Size(max = 100)
    @Column(name = "corporate_exec_serv_collateral_pledge_quantity_sign", length = 100)
    private String corporateExecServCollateralPledgeQuantitySign;

    @Column(name = "trade_date_repo_liquidating_value", precision = 45, scale = 20)
    private BigDecimal tradeDateRepoLiquidatingValue;

    @Size(max = 100)
    @Column(name = "trade_date_repo_liquidating_value_sign", length = 100)
    private String tradeDateRepoLiquidatingValueSign;

    @Column(name = "settlement_date_repo_liquidating_value", precision = 45, scale = 20)
    private BigDecimal settlementDateRepoLiquidatingValue;

    @Size(max = 100)
    @Column(name = "settlement_date_repo_liquidating_value_sign", length = 100)
    private String settlementDateRepoLiquidatingValueSign;

    @Column(name = "trade_date_reverse_repo_liquidating_value", precision = 45, scale = 20)
    private BigDecimal tradeDateReverseRepoLiquidatingValue;

    @Size(max = 100)
    @Column(name = "trade_date_reverse_repo_liquidating_value_sign", length = 100)
    private String tradeDateReverseRepoLiquidatingValueSign;

    @Column(name = "settlement_date_reverse_repo_liquidating_value", precision = 45, scale = 20)
    private BigDecimal settlementDateReverseRepoLiquidatingValue;

    @Size(max = 100)
    @Column(name = "settlement_date_reverse_repo_liquidating_value_sign", length = 100)
    private String settlementDateReverseRepoLiquidatingValueSign;

    @Column(name = "collateral_pledge_liquidating_value", precision = 45, scale = 20)
    private BigDecimal collateralPledgeLiquidatingValue;

    @Size(max = 100)
    @Column(name = "collateral_pledge_liquidating_value_sign", length = 100)
    private String collateralPledgeLiquidatingValueSign;

    @Column(name = "corporate_exec_serv_collateral_pledge_liquidating_value", precision = 45, scale = 20)
    private BigDecimal corporateExecServCollateralPledgeLiquidatingValue;

    @Size(max = 100)
    @Column(name = "corporate_exec_serv_collateral_pledge_liquidating_value_sign", length = 100)
    private String corporateExecServCollateralPledgeLiquidatingValueSign;

    @Column(name = "trade_date_repo_loan_amount", precision = 45, scale = 20)
    private BigDecimal tradeDateRepoLoanAmount;

    @Size(max = 100)
    @Column(name = "trade_date_repo_loan_amount_sign", length = 100)
    private String tradeDateRepoLoanAmountSign;

    @Column(name = "settlement_date_repo_loan_amount", precision = 45, scale = 20)
    private BigDecimal settlementDateRepoLoanAmount;

    @Size(max = 100)
    @Column(name = "settlement_date_repo_loan_amount_sign", length = 100)
    private String settlementDateRepoLoanAmountSign;

    @Column(name = "trade_date_reverse_repo_loan_amount", precision = 45, scale = 20)
    private BigDecimal tradeDateReverseRepoLoanAmount;

    @Size(max = 100)
    @Column(name = "trade_date_reverse_repo_loan_amount_sign", length = 100)
    private String tradeDateReverseRepoLoanAmountSign;

    @Column(name = "settlement_date_reverse_repo_loan_amount", precision = 45, scale = 20)
    private BigDecimal settlementDateReverseRepoLoanAmount;

    @Size(max = 100)
    @Column(name = "settlement_date_reverse_repo_loan_amount_sign", length = 100)
    private String settlementDateReverseRepoLoanAmountSign;

    @Column(name = "accrued_interes_value", precision = 45, scale = 20)
    private BigDecimal accruedInteresValue;

    @Size(max = 100)
    @Column(name = "accrued_interes_value_sign", length = 100)
    private String accruedInteresValueSign;

    @Column(name = "dividend_or_coupon_rate", precision = 45, scale = 20)
    private BigDecimal dividendOrCouponRate;

    @Column(name = "pending_split_quantity_liquidating_value", precision = 45, scale = 20)
    private BigDecimal pendingSplitQuantityLiquidatingValue;

    @Size(max = 100)
    @Column(name = "pending_split_quantity_liquidating_value_sign", length = 100)
    private String pendingSplitQuantityLiquidatingValueSign;

    @Size(max = 100)
    @Column(name = "campo_58", length = 100)
    private String campo58;

    @Size(max = 100)
    @Column(name = "internal_non_dollar_symbol", length = 100)
    private String internalNonDollarSymbol;

    @Column(name = "pledged_quantity", precision = 45, scale = 20)
    private BigDecimal pledgedQuantity;

    @Size(max = 100)
    @Column(name = "pledged_quantity_sign", length = 100)
    private String pledgedQuantitySign;

    @Size(max = 100)
    @Column(name = "campo_62", length = 100)
    private String campo62;

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

    public Integer getRecorIdSequenceNumber() {
        return recorIdSequenceNumber;
    }

    public void setRecorIdSequenceNumber(Integer recorIdSequenceNumber) {
        this.recorIdSequenceNumber = recorIdSequenceNumber;
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

    public String getPositionCurrency() {
        return positionCurrency;
    }

    public void setPositionCurrency(String positionCurrency) {
        this.positionCurrency = positionCurrency;
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

    public BigDecimal getFullyPaidLendingQuantity() {
        return fullyPaidLendingQuantity;
    }

    public void setFullyPaidLendingQuantity(BigDecimal fullyPaidLendingQuantity) {
        this.fullyPaidLendingQuantity = fullyPaidLendingQuantity;
    }

    public String getFullyPaidLendingQuantitySign() {
        return fullyPaidLendingQuantitySign;
    }

    public void setFullyPaidLendingQuantitySign(String fullyPaidLendingQuantitySign) {
        this.fullyPaidLendingQuantitySign = fullyPaidLendingQuantitySign;
    }

    public BigDecimal getFullyPaidLendingQuantityCollateralAmount() {
        return fullyPaidLendingQuantityCollateralAmount;
    }

    public void setFullyPaidLendingQuantityCollateralAmount(BigDecimal fullyPaidLendingQuantityCollateralAmount) {
        this.fullyPaidLendingQuantityCollateralAmount = fullyPaidLendingQuantityCollateralAmount;
    }

    public String getFullyPaidLendingQuantityCollateralAmountSign() {
        return fullyPaidLendingQuantityCollateralAmountSign;
    }

    public void setFullyPaidLendingQuantityCollateralAmountSign(String fullyPaidLendingQuantityCollateralAmountSign) {
        this.fullyPaidLendingQuantityCollateralAmountSign = fullyPaidLendingQuantityCollateralAmountSign;
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

    public BigDecimal getTradeDateRepoQuantity() {
        return tradeDateRepoQuantity;
    }

    public void setTradeDateRepoQuantity(BigDecimal tradeDateRepoQuantity) {
        this.tradeDateRepoQuantity = tradeDateRepoQuantity;
    }

    public String getTradeDateRepoQuantitySign() {
        return tradeDateRepoQuantitySign;
    }

    public void setTradeDateRepoQuantitySign(String tradeDateRepoQuantitySign) {
        this.tradeDateRepoQuantitySign = tradeDateRepoQuantitySign;
    }

    public BigDecimal getSettlementDateRepoQuantity() {
        return settlementDateRepoQuantity;
    }

    public void setSettlementDateRepoQuantity(BigDecimal settlementDateRepoQuantity) {
        this.settlementDateRepoQuantity = settlementDateRepoQuantity;
    }

    public String getSettlementDateRepoQuantitySign() {
        return settlementDateRepoQuantitySign;
    }

    public void setSettlementDateRepoQuantitySign(String settlementDateRepoQuantitySign) {
        this.settlementDateRepoQuantitySign = settlementDateRepoQuantitySign;
    }

    public BigDecimal getTradeDateReverseRepoQuantity() {
        return tradeDateReverseRepoQuantity;
    }

    public void setTradeDateReverseRepoQuantity(BigDecimal tradeDateReverseRepoQuantity) {
        this.tradeDateReverseRepoQuantity = tradeDateReverseRepoQuantity;
    }

    public String getTradeDateReverseRepoQuantitySign() {
        return tradeDateReverseRepoQuantitySign;
    }

    public void setTradeDateReverseRepoQuantitySign(String tradeDateReverseRepoQuantitySign) {
        this.tradeDateReverseRepoQuantitySign = tradeDateReverseRepoQuantitySign;
    }

    public BigDecimal getSettlementDateReverseRepoQuantity() {
        return settlementDateReverseRepoQuantity;
    }

    public void setSettlementDateReverseRepoQuantity(BigDecimal settlementDateReverseRepoQuantity) {
        this.settlementDateReverseRepoQuantity = settlementDateReverseRepoQuantity;
    }

    public String getSettlementDateReverseRepoQuantitySign() {
        return settlementDateReverseRepoQuantitySign;
    }

    public void setSettlementDateReverseRepoQuantitySign(String settlementDateReverseRepoQuantitySign) {
        this.settlementDateReverseRepoQuantitySign = settlementDateReverseRepoQuantitySign;
    }

    public BigDecimal getCollateralPledgeQuantity() {
        return collateralPledgeQuantity;
    }

    public void setCollateralPledgeQuantity(BigDecimal collateralPledgeQuantity) {
        this.collateralPledgeQuantity = collateralPledgeQuantity;
    }

    public String getCollateralPledgeQuantitySign() {
        return collateralPledgeQuantitySign;
    }

    public void setCollateralPledgeQuantitySign(String collateralPledgeQuantitySign) {
        this.collateralPledgeQuantitySign = collateralPledgeQuantitySign;
    }

    public BigDecimal getCorporateExecServCollateralPledgeQuantity() {
        return corporateExecServCollateralPledgeQuantity;
    }

    public void setCorporateExecServCollateralPledgeQuantity(BigDecimal corporateExecServCollateralPledgeQuantity) {
        this.corporateExecServCollateralPledgeQuantity = corporateExecServCollateralPledgeQuantity;
    }

    public String getCorporateExecServCollateralPledgeQuantitySign() {
        return corporateExecServCollateralPledgeQuantitySign;
    }

    public void setCorporateExecServCollateralPledgeQuantitySign(String corporateExecServCollateralPledgeQuantitySign) {
        this.corporateExecServCollateralPledgeQuantitySign = corporateExecServCollateralPledgeQuantitySign;
    }

    public BigDecimal getTradeDateRepoLiquidatingValue() {
        return tradeDateRepoLiquidatingValue;
    }

    public void setTradeDateRepoLiquidatingValue(BigDecimal tradeDateRepoLiquidatingValue) {
        this.tradeDateRepoLiquidatingValue = tradeDateRepoLiquidatingValue;
    }

    public String getTradeDateRepoLiquidatingValueSign() {
        return tradeDateRepoLiquidatingValueSign;
    }

    public void setTradeDateRepoLiquidatingValueSign(String tradeDateRepoLiquidatingValueSign) {
        this.tradeDateRepoLiquidatingValueSign = tradeDateRepoLiquidatingValueSign;
    }

    public BigDecimal getSettlementDateRepoLiquidatingValue() {
        return settlementDateRepoLiquidatingValue;
    }

    public void setSettlementDateRepoLiquidatingValue(BigDecimal settlementDateRepoLiquidatingValue) {
        this.settlementDateRepoLiquidatingValue = settlementDateRepoLiquidatingValue;
    }

    public String getSettlementDateRepoLiquidatingValueSign() {
        return settlementDateRepoLiquidatingValueSign;
    }

    public void setSettlementDateRepoLiquidatingValueSign(String settlementDateRepoLiquidatingValueSign) {
        this.settlementDateRepoLiquidatingValueSign = settlementDateRepoLiquidatingValueSign;
    }

    public BigDecimal getTradeDateReverseRepoLiquidatingValue() {
        return tradeDateReverseRepoLiquidatingValue;
    }

    public void setTradeDateReverseRepoLiquidatingValue(BigDecimal tradeDateReverseRepoLiquidatingValue) {
        this.tradeDateReverseRepoLiquidatingValue = tradeDateReverseRepoLiquidatingValue;
    }

    public String getTradeDateReverseRepoLiquidatingValueSign() {
        return tradeDateReverseRepoLiquidatingValueSign;
    }

    public void setTradeDateReverseRepoLiquidatingValueSign(String tradeDateReverseRepoLiquidatingValueSign) {
        this.tradeDateReverseRepoLiquidatingValueSign = tradeDateReverseRepoLiquidatingValueSign;
    }

    public BigDecimal getSettlementDateReverseRepoLiquidatingValue() {
        return settlementDateReverseRepoLiquidatingValue;
    }

    public void setSettlementDateReverseRepoLiquidatingValue(BigDecimal settlementDateReverseRepoLiquidatingValue) {
        this.settlementDateReverseRepoLiquidatingValue = settlementDateReverseRepoLiquidatingValue;
    }

    public String getSettlementDateReverseRepoLiquidatingValueSign() {
        return settlementDateReverseRepoLiquidatingValueSign;
    }

    public void setSettlementDateReverseRepoLiquidatingValueSign(String settlementDateReverseRepoLiquidatingValueSign) {
        this.settlementDateReverseRepoLiquidatingValueSign = settlementDateReverseRepoLiquidatingValueSign;
    }

    public BigDecimal getCollateralPledgeLiquidatingValue() {
        return collateralPledgeLiquidatingValue;
    }

    public void setCollateralPledgeLiquidatingValue(BigDecimal collateralPledgeLiquidatingValue) {
        this.collateralPledgeLiquidatingValue = collateralPledgeLiquidatingValue;
    }

    public String getCollateralPledgeLiquidatingValueSign() {
        return collateralPledgeLiquidatingValueSign;
    }

    public void setCollateralPledgeLiquidatingValueSign(String collateralPledgeLiquidatingValueSign) {
        this.collateralPledgeLiquidatingValueSign = collateralPledgeLiquidatingValueSign;
    }

    public BigDecimal getCorporateExecServCollateralPledgeLiquidatingValue() {
        return corporateExecServCollateralPledgeLiquidatingValue;
    }

    public void setCorporateExecServCollateralPledgeLiquidatingValue(BigDecimal corporateExecServCollateralPledgeLiquidatingValue) {
        this.corporateExecServCollateralPledgeLiquidatingValue = corporateExecServCollateralPledgeLiquidatingValue;
    }

    public String getCorporateExecServCollateralPledgeLiquidatingValueSign() {
        return corporateExecServCollateralPledgeLiquidatingValueSign;
    }

    public void setCorporateExecServCollateralPledgeLiquidatingValueSign(String corporateExecServCollateralPledgeLiquidatingValueSign) {
        this.corporateExecServCollateralPledgeLiquidatingValueSign = corporateExecServCollateralPledgeLiquidatingValueSign;
    }

    public BigDecimal getTradeDateRepoLoanAmount() {
        return tradeDateRepoLoanAmount;
    }

    public void setTradeDateRepoLoanAmount(BigDecimal tradeDateRepoLoanAmount) {
        this.tradeDateRepoLoanAmount = tradeDateRepoLoanAmount;
    }

    public String getTradeDateRepoLoanAmountSign() {
        return tradeDateRepoLoanAmountSign;
    }

    public void setTradeDateRepoLoanAmountSign(String tradeDateRepoLoanAmountSign) {
        this.tradeDateRepoLoanAmountSign = tradeDateRepoLoanAmountSign;
    }

    public BigDecimal getSettlementDateRepoLoanAmount() {
        return settlementDateRepoLoanAmount;
    }

    public void setSettlementDateRepoLoanAmount(BigDecimal settlementDateRepoLoanAmount) {
        this.settlementDateRepoLoanAmount = settlementDateRepoLoanAmount;
    }

    public String getSettlementDateRepoLoanAmountSign() {
        return settlementDateRepoLoanAmountSign;
    }

    public void setSettlementDateRepoLoanAmountSign(String settlementDateRepoLoanAmountSign) {
        this.settlementDateRepoLoanAmountSign = settlementDateRepoLoanAmountSign;
    }

    public BigDecimal getTradeDateReverseRepoLoanAmount() {
        return tradeDateReverseRepoLoanAmount;
    }

    public void setTradeDateReverseRepoLoanAmount(BigDecimal tradeDateReverseRepoLoanAmount) {
        this.tradeDateReverseRepoLoanAmount = tradeDateReverseRepoLoanAmount;
    }

    public String getTradeDateReverseRepoLoanAmountSign() {
        return tradeDateReverseRepoLoanAmountSign;
    }

    public void setTradeDateReverseRepoLoanAmountSign(String tradeDateReverseRepoLoanAmountSign) {
        this.tradeDateReverseRepoLoanAmountSign = tradeDateReverseRepoLoanAmountSign;
    }

    public BigDecimal getSettlementDateReverseRepoLoanAmount() {
        return settlementDateReverseRepoLoanAmount;
    }

    public void setSettlementDateReverseRepoLoanAmount(BigDecimal settlementDateReverseRepoLoanAmount) {
        this.settlementDateReverseRepoLoanAmount = settlementDateReverseRepoLoanAmount;
    }

    public String getSettlementDateReverseRepoLoanAmountSign() {
        return settlementDateReverseRepoLoanAmountSign;
    }

    public void setSettlementDateReverseRepoLoanAmountSign(String settlementDateReverseRepoLoanAmountSign) {
        this.settlementDateReverseRepoLoanAmountSign = settlementDateReverseRepoLoanAmountSign;
    }

    public BigDecimal getAccruedInteresValue() {
        return accruedInteresValue;
    }

    public void setAccruedInteresValue(BigDecimal accruedInteresValue) {
        this.accruedInteresValue = accruedInteresValue;
    }

    public String getAccruedInteresValueSign() {
        return accruedInteresValueSign;
    }

    public void setAccruedInteresValueSign(String accruedInteresValueSign) {
        this.accruedInteresValueSign = accruedInteresValueSign;
    }

    public BigDecimal getDividendOrCouponRate() {
        return dividendOrCouponRate;
    }

    public void setDividendOrCouponRate(BigDecimal dividendOrCouponRate) {
        this.dividendOrCouponRate = dividendOrCouponRate;
    }

    public BigDecimal getPendingSplitQuantityLiquidatingValue() {
        return pendingSplitQuantityLiquidatingValue;
    }

    public void setPendingSplitQuantityLiquidatingValue(BigDecimal pendingSplitQuantityLiquidatingValue) {
        this.pendingSplitQuantityLiquidatingValue = pendingSplitQuantityLiquidatingValue;
    }

    public String getPendingSplitQuantityLiquidatingValueSign() {
        return pendingSplitQuantityLiquidatingValueSign;
    }

    public void setPendingSplitQuantityLiquidatingValueSign(String pendingSplitQuantityLiquidatingValueSign) {
        this.pendingSplitQuantityLiquidatingValueSign = pendingSplitQuantityLiquidatingValueSign;
    }

    public String getCampo58() {
        return campo58;
    }

    public void setCampo58(String campo58) {
        this.campo58 = campo58;
    }

    public String getInternalNonDollarSymbol() {
        return internalNonDollarSymbol;
    }

    public void setInternalNonDollarSymbol(String internalNonDollarSymbol) {
        this.internalNonDollarSymbol = internalNonDollarSymbol;
    }

    public BigDecimal getPledgedQuantity() {
        return pledgedQuantity;
    }

    public void setPledgedQuantity(BigDecimal pledgedQuantity) {
        this.pledgedQuantity = pledgedQuantity;
    }

    public String getPledgedQuantitySign() {
        return pledgedQuantitySign;
    }

    public void setPledgedQuantitySign(String pledgedQuantitySign) {
        this.pledgedQuantitySign = pledgedQuantitySign;
    }

    public String getCampo62() {
        return campo62;
    }

    public void setCampo62(String campo62) {
        this.campo62 = campo62;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}