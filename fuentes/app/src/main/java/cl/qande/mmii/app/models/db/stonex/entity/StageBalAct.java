package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_bal_act", schema = "stage_stonex")
public class StageBalAct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_stamp", nullable = false, length = 100)
    private String processStamp;

    @Size(max = 100)
    @NotNull
    @Column(name = "ba_reccode", nullable = false, length = 100)
    private String baReccode;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 100)
    private String acctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

    @Size(max = 100)
    @NotNull
    @Column(name = "currency_sequence", nullable = false, length = 100)
    private String currencySequence;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "buy_pwr_amt", nullable = false, length = 100)
    private String buyPwrAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_avail_amt", nullable = false, length = 100)
    private String cashAvailAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_mgn_cash_av", nullable = false, length = 100)
    private String cashMgnCashAv;

    @Size(max = 100)
    @NotNull
    @Column(name = "equity_amt", nullable = false, length = 100)
    private String equityAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_int_amt", nullable = false, length = 100)
    private String divIntAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_val_amt", nullable = false, length = 100)
    private String mktValAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_dt_bal", nullable = false, length = 100)
    private String tradeDtBal;

    @Size(max = 100)
    @NotNull
    @Column(name = "settle_dt_bal", nullable = false, length = 100)
    private String settleDtBal;

    @Size(max = 100)
    @NotNull
    @Column(name = "long_mkt_value_amt", nullable = false, length = 100)
    private String longMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "shrt_mkt_value_amt", nullable = false, length = 100)
    private String shrtMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "fed_call_amt", nullable = false, length = 100)
    private String fedCallAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "accum_fed_amt", nullable = false, length = 100)
    private String accumFedAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "accum_fed_prev", nullable = false, length = 100)
    private String accumFedPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "maint_call_amt", nullable = false, length = 100)
    private String maintCallAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "maint_prev", nullable = false, length = 100)
    private String maintPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_change_amt", nullable = false, length = 100)
    private String smaChangeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_change_prv_amt", nullable = false, length = 100)
    private String smaChangePrvAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_bal_amt", nullable = false, length = 100)
    private String smaBalAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_or_call_prev", nullable = false, length = 100)
    private String smaOrCallPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "currency_factor", nullable = false, length = 100)
    private String currencyFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "free_cred_misc_deb", nullable = false, length = 100)
    private String freeCredMiscDeb;

    @Size(max = 100)
    @NotNull
    @Column(name = "dly_credit_int", nullable = false, length = 100)
    private String dlyCreditInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mtd_credit_int", nullable = false, length = 100)
    private String mtdCreditInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mtd_mgn_int", nullable = false, length = 100)
    private String mtdMgnInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch_call", nullable = false, length = 100)
    private String exchCall;

    @Size(max = 100)
    @NotNull
    @Column(name = "percent_eqty", nullable = false, length = 100)
    private String percentEqty;

    @Size(max = 100)
    @NotNull
    @Column(name = "money_mkt_bal", nullable = false, length = 100)
    private String moneyMktBal;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_free_cr", nullable = false, length = 100)
    private String cashFreeCr;

    @Size(max = 100)
    @NotNull
    @Column(name = "bal_long_sd", nullable = false, length = 100)
    private String balLongSd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bal_short_sd", nullable = false, length = 100)
    private String balShortSd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bal_short_td", nullable = false, length = 100)
    private String balShortTd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bal_long_td", nullable = false, length = 100)
    private String balLongTd;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_req", nullable = false, length = 100)
    private String optReq;

    @Size(max = 100)
    @NotNull
    @Column(name = "fed_call_prev", nullable = false, length = 100)
    private String fedCallPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_free_cr_prev", nullable = false, length = 100)
    private String cashFreeCrPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "daily_int_prev", nullable = false, length = 100)
    private String dailyIntPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "mtd_int_prev", nullable = false, length = 100)
    private String mtdIntPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "bal_pct_eqty_prev", nullable = false, length = 100)
    private String balPctEqtyPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_val_long", nullable = false, length = 100)
    private String optValLong;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_val_short", nullable = false, length = 100)
    private String optValShort;

    @Size(max = 100)
    @NotNull
    @Column(name = "curr_code", nullable = false, length = 100)
    private String currCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_bal", nullable = false, length = 100)
    private String adjBal;

    @Size(max = 100)
    @NotNull
    @Column(name = "avail_cr_amt", nullable = false, length = 100)
    private String availCrAmt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

    public String getBaReccode() {
        return baReccode;
    }

    public void setBaReccode(String baReccode) {
        this.baReccode = baReccode;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getCurrencySequence() {
        return currencySequence;
    }

    public void setCurrencySequence(String currencySequence) {
        this.currencySequence = currencySequence;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getBuyPwrAmt() {
        return buyPwrAmt;
    }

    public void setBuyPwrAmt(String buyPwrAmt) {
        this.buyPwrAmt = buyPwrAmt;
    }

    public String getCashAvailAmt() {
        return cashAvailAmt;
    }

    public void setCashAvailAmt(String cashAvailAmt) {
        this.cashAvailAmt = cashAvailAmt;
    }

    public String getCashMgnCashAv() {
        return cashMgnCashAv;
    }

    public void setCashMgnCashAv(String cashMgnCashAv) {
        this.cashMgnCashAv = cashMgnCashAv;
    }

    public String getEquityAmt() {
        return equityAmt;
    }

    public void setEquityAmt(String equityAmt) {
        this.equityAmt = equityAmt;
    }

    public String getDivIntAmt() {
        return divIntAmt;
    }

    public void setDivIntAmt(String divIntAmt) {
        this.divIntAmt = divIntAmt;
    }

    public String getMktValAmt() {
        return mktValAmt;
    }

    public void setMktValAmt(String mktValAmt) {
        this.mktValAmt = mktValAmt;
    }

    public String getTradeDtBal() {
        return tradeDtBal;
    }

    public void setTradeDtBal(String tradeDtBal) {
        this.tradeDtBal = tradeDtBal;
    }

    public String getSettleDtBal() {
        return settleDtBal;
    }

    public void setSettleDtBal(String settleDtBal) {
        this.settleDtBal = settleDtBal;
    }

    public String getLongMktValueAmt() {
        return longMktValueAmt;
    }

    public void setLongMktValueAmt(String longMktValueAmt) {
        this.longMktValueAmt = longMktValueAmt;
    }

    public String getShrtMktValueAmt() {
        return shrtMktValueAmt;
    }

    public void setShrtMktValueAmt(String shrtMktValueAmt) {
        this.shrtMktValueAmt = shrtMktValueAmt;
    }

    public String getFedCallAmt() {
        return fedCallAmt;
    }

    public void setFedCallAmt(String fedCallAmt) {
        this.fedCallAmt = fedCallAmt;
    }

    public String getAccumFedAmt() {
        return accumFedAmt;
    }

    public void setAccumFedAmt(String accumFedAmt) {
        this.accumFedAmt = accumFedAmt;
    }

    public String getAccumFedPrev() {
        return accumFedPrev;
    }

    public void setAccumFedPrev(String accumFedPrev) {
        this.accumFedPrev = accumFedPrev;
    }

    public String getMaintCallAmt() {
        return maintCallAmt;
    }

    public void setMaintCallAmt(String maintCallAmt) {
        this.maintCallAmt = maintCallAmt;
    }

    public String getMaintPrev() {
        return maintPrev;
    }

    public void setMaintPrev(String maintPrev) {
        this.maintPrev = maintPrev;
    }

    public String getSmaChangeAmt() {
        return smaChangeAmt;
    }

    public void setSmaChangeAmt(String smaChangeAmt) {
        this.smaChangeAmt = smaChangeAmt;
    }

    public String getSmaChangePrvAmt() {
        return smaChangePrvAmt;
    }

    public void setSmaChangePrvAmt(String smaChangePrvAmt) {
        this.smaChangePrvAmt = smaChangePrvAmt;
    }

    public String getSmaBalAmt() {
        return smaBalAmt;
    }

    public void setSmaBalAmt(String smaBalAmt) {
        this.smaBalAmt = smaBalAmt;
    }

    public String getSmaOrCallPrev() {
        return smaOrCallPrev;
    }

    public void setSmaOrCallPrev(String smaOrCallPrev) {
        this.smaOrCallPrev = smaOrCallPrev;
    }

    public String getCurrencyFactor() {
        return currencyFactor;
    }

    public void setCurrencyFactor(String currencyFactor) {
        this.currencyFactor = currencyFactor;
    }

    public String getFreeCredMiscDeb() {
        return freeCredMiscDeb;
    }

    public void setFreeCredMiscDeb(String freeCredMiscDeb) {
        this.freeCredMiscDeb = freeCredMiscDeb;
    }

    public String getDlyCreditInt() {
        return dlyCreditInt;
    }

    public void setDlyCreditInt(String dlyCreditInt) {
        this.dlyCreditInt = dlyCreditInt;
    }

    public String getMtdCreditInt() {
        return mtdCreditInt;
    }

    public void setMtdCreditInt(String mtdCreditInt) {
        this.mtdCreditInt = mtdCreditInt;
    }

    public String getMtdMgnInt() {
        return mtdMgnInt;
    }

    public void setMtdMgnInt(String mtdMgnInt) {
        this.mtdMgnInt = mtdMgnInt;
    }

    public String getExchCall() {
        return exchCall;
    }

    public void setExchCall(String exchCall) {
        this.exchCall = exchCall;
    }

    public String getPercentEqty() {
        return percentEqty;
    }

    public void setPercentEqty(String percentEqty) {
        this.percentEqty = percentEqty;
    }

    public String getMoneyMktBal() {
        return moneyMktBal;
    }

    public void setMoneyMktBal(String moneyMktBal) {
        this.moneyMktBal = moneyMktBal;
    }

    public String getCashFreeCr() {
        return cashFreeCr;
    }

    public void setCashFreeCr(String cashFreeCr) {
        this.cashFreeCr = cashFreeCr;
    }

    public String getBalLongSd() {
        return balLongSd;
    }

    public void setBalLongSd(String balLongSd) {
        this.balLongSd = balLongSd;
    }

    public String getBalShortSd() {
        return balShortSd;
    }

    public void setBalShortSd(String balShortSd) {
        this.balShortSd = balShortSd;
    }

    public String getBalShortTd() {
        return balShortTd;
    }

    public void setBalShortTd(String balShortTd) {
        this.balShortTd = balShortTd;
    }

    public String getBalLongTd() {
        return balLongTd;
    }

    public void setBalLongTd(String balLongTd) {
        this.balLongTd = balLongTd;
    }

    public String getOptReq() {
        return optReq;
    }

    public void setOptReq(String optReq) {
        this.optReq = optReq;
    }

    public String getFedCallPrev() {
        return fedCallPrev;
    }

    public void setFedCallPrev(String fedCallPrev) {
        this.fedCallPrev = fedCallPrev;
    }

    public String getCashFreeCrPrev() {
        return cashFreeCrPrev;
    }

    public void setCashFreeCrPrev(String cashFreeCrPrev) {
        this.cashFreeCrPrev = cashFreeCrPrev;
    }

    public String getDailyIntPrev() {
        return dailyIntPrev;
    }

    public void setDailyIntPrev(String dailyIntPrev) {
        this.dailyIntPrev = dailyIntPrev;
    }

    public String getMtdIntPrev() {
        return mtdIntPrev;
    }

    public void setMtdIntPrev(String mtdIntPrev) {
        this.mtdIntPrev = mtdIntPrev;
    }

    public String getBalPctEqtyPrev() {
        return balPctEqtyPrev;
    }

    public void setBalPctEqtyPrev(String balPctEqtyPrev) {
        this.balPctEqtyPrev = balPctEqtyPrev;
    }

    public String getOptValLong() {
        return optValLong;
    }

    public void setOptValLong(String optValLong) {
        this.optValLong = optValLong;
    }

    public String getOptValShort() {
        return optValShort;
    }

    public void setOptValShort(String optValShort) {
        this.optValShort = optValShort;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public String getAdjBal() {
        return adjBal;
    }

    public void setAdjBal(String adjBal) {
        this.adjBal = adjBal;
    }

    public String getAvailCrAmt() {
        return availCrAmt;
    }

    public void setAvailCrAmt(String availCrAmt) {
        this.availCrAmt = availCrAmt;
    }

}