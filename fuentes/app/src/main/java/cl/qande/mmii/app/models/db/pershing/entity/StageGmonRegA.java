package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_gmon_reg_a", schema = "stage_pershing")
public class StageGmonRegA {
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

    @Column(name = "usde_td_balance", precision = 45, scale = 20)
    private BigDecimal usdeTdBalance;

    @Size(max = 100)
    @Column(name = "usde_td_balance_sign", length = 100)
    private String usdeTdBalanceSign;

    @Column(name = "usd_td_balance", precision = 45, scale = 20)
    private BigDecimal usdTdBalance;

    @Size(max = 100)
    @Column(name = "usd_td_balance_sign", length = 100)
    private String usdTdBalanceSign;

    @Column(name = "long_td_market", precision = 45, scale = 20)
    private BigDecimal longTdMarket;

    @Size(max = 100)
    @Column(name = "long_td_market_sign", length = 100)
    private String longTdMarketSign;

    @Column(name = "short_td_market", precision = 45, scale = 20)
    private BigDecimal shortTdMarket;

    @Size(max = 100)
    @Column(name = "short_td_market_sign", length = 100)
    private String shortTdMarketSign;

    @Column(name = "td_liquidating_equity", precision = 45, scale = 20)
    private BigDecimal tdLiquidatingEquity;

    @Size(max = 100)
    @Column(name = "td_liquidating_equity_sign", length = 100)
    private String tdLiquidatingEquitySign;

    @Column(name = "total_usde_td_balance", precision = 45, scale = 20)
    private BigDecimal totalUsdeTdBalance;

    @Size(max = 100)
    @Column(name = "total_usde_td_balance_sign", length = 100)
    private String totalUsdeTdBalanceSign;

    @Column(name = "total_equity", precision = 45, scale = 20)
    private BigDecimal totalEquity;

    @Size(max = 100)
    @Column(name = "total_equity_sign", length = 100)
    private String totalEquitySign;

    @Column(name = "trade_date_net_worth", precision = 45, scale = 20)
    private BigDecimal tradeDateNetWorth;

    @Size(max = 100)
    @Column(name = "trade_date_net_worth_sign", length = 100)
    private String tradeDateNetWorthSign;

    @Column(name = "mmf_principal_balance", precision = 45, scale = 20)
    private BigDecimal mmfPrincipalBalance;

    @Size(max = 100)
    @Column(name = "mmf_principal_balance_sign", length = 100)
    private String mmfPrincipalBalanceSign;

    @Column(name = "mmf_dividend", precision = 45, scale = 20)
    private BigDecimal mmfDividend;

    @Size(max = 100)
    @Column(name = "mmf_dividend_sign", length = 100)
    private String mmfDividendSign;

    @Column(name = "cash_available", precision = 45, scale = 20)
    private BigDecimal cashAvailable;

    @Size(max = 100)
    @Column(name = "cash_available_sign", length = 100)
    private String cashAvailableSign;

    @Size(max = 100)
    @Column(name = "campo_30", length = 100)
    private String campo30;

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

    public BigDecimal getUsdeTdBalance() {
        return usdeTdBalance;
    }

    public void setUsdeTdBalance(BigDecimal usdeTdBalance) {
        this.usdeTdBalance = usdeTdBalance;
    }

    public String getUsdeTdBalanceSign() {
        return usdeTdBalanceSign;
    }

    public void setUsdeTdBalanceSign(String usdeTdBalanceSign) {
        this.usdeTdBalanceSign = usdeTdBalanceSign;
    }

    public BigDecimal getUsdTdBalance() {
        return usdTdBalance;
    }

    public void setUsdTdBalance(BigDecimal usdTdBalance) {
        this.usdTdBalance = usdTdBalance;
    }

    public String getUsdTdBalanceSign() {
        return usdTdBalanceSign;
    }

    public void setUsdTdBalanceSign(String usdTdBalanceSign) {
        this.usdTdBalanceSign = usdTdBalanceSign;
    }

    public BigDecimal getLongTdMarket() {
        return longTdMarket;
    }

    public void setLongTdMarket(BigDecimal longTdMarket) {
        this.longTdMarket = longTdMarket;
    }

    public String getLongTdMarketSign() {
        return longTdMarketSign;
    }

    public void setLongTdMarketSign(String longTdMarketSign) {
        this.longTdMarketSign = longTdMarketSign;
    }

    public BigDecimal getShortTdMarket() {
        return shortTdMarket;
    }

    public void setShortTdMarket(BigDecimal shortTdMarket) {
        this.shortTdMarket = shortTdMarket;
    }

    public String getShortTdMarketSign() {
        return shortTdMarketSign;
    }

    public void setShortTdMarketSign(String shortTdMarketSign) {
        this.shortTdMarketSign = shortTdMarketSign;
    }

    public BigDecimal getTdLiquidatingEquity() {
        return tdLiquidatingEquity;
    }

    public void setTdLiquidatingEquity(BigDecimal tdLiquidatingEquity) {
        this.tdLiquidatingEquity = tdLiquidatingEquity;
    }

    public String getTdLiquidatingEquitySign() {
        return tdLiquidatingEquitySign;
    }

    public void setTdLiquidatingEquitySign(String tdLiquidatingEquitySign) {
        this.tdLiquidatingEquitySign = tdLiquidatingEquitySign;
    }

    public BigDecimal getTotalUsdeTdBalance() {
        return totalUsdeTdBalance;
    }

    public void setTotalUsdeTdBalance(BigDecimal totalUsdeTdBalance) {
        this.totalUsdeTdBalance = totalUsdeTdBalance;
    }

    public String getTotalUsdeTdBalanceSign() {
        return totalUsdeTdBalanceSign;
    }

    public void setTotalUsdeTdBalanceSign(String totalUsdeTdBalanceSign) {
        this.totalUsdeTdBalanceSign = totalUsdeTdBalanceSign;
    }

    public BigDecimal getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(BigDecimal totalEquity) {
        this.totalEquity = totalEquity;
    }

    public String getTotalEquitySign() {
        return totalEquitySign;
    }

    public void setTotalEquitySign(String totalEquitySign) {
        this.totalEquitySign = totalEquitySign;
    }

    public BigDecimal getTradeDateNetWorth() {
        return tradeDateNetWorth;
    }

    public void setTradeDateNetWorth(BigDecimal tradeDateNetWorth) {
        this.tradeDateNetWorth = tradeDateNetWorth;
    }

    public String getTradeDateNetWorthSign() {
        return tradeDateNetWorthSign;
    }

    public void setTradeDateNetWorthSign(String tradeDateNetWorthSign) {
        this.tradeDateNetWorthSign = tradeDateNetWorthSign;
    }

    public BigDecimal getMmfPrincipalBalance() {
        return mmfPrincipalBalance;
    }

    public void setMmfPrincipalBalance(BigDecimal mmfPrincipalBalance) {
        this.mmfPrincipalBalance = mmfPrincipalBalance;
    }

    public String getMmfPrincipalBalanceSign() {
        return mmfPrincipalBalanceSign;
    }

    public void setMmfPrincipalBalanceSign(String mmfPrincipalBalanceSign) {
        this.mmfPrincipalBalanceSign = mmfPrincipalBalanceSign;
    }

    public BigDecimal getMmfDividend() {
        return mmfDividend;
    }

    public void setMmfDividend(BigDecimal mmfDividend) {
        this.mmfDividend = mmfDividend;
    }

    public String getMmfDividendSign() {
        return mmfDividendSign;
    }

    public void setMmfDividendSign(String mmfDividendSign) {
        this.mmfDividendSign = mmfDividendSign;
    }

    public BigDecimal getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(BigDecimal cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public String getCashAvailableSign() {
        return cashAvailableSign;
    }

    public void setCashAvailableSign(String cashAvailableSign) {
        this.cashAvailableSign = cashAvailableSign;
    }

    public String getCampo30() {
        return campo30;
    }

    public void setCampo30(String campo30) {
        this.campo30 = campo30;
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