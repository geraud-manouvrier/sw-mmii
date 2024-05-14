package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class BalActCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "currency_sequence")private String currencySequence;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "buy_pwr_amt")private String buyPwrAmt;
    @CsvBindByName(column = "cash_avail_amt")private String cashAvailAmt;
    @CsvBindByName(column = "cash_mgn_cash_av")private String cashMgnCashAv;
    @CsvBindByName(column = "equity_amt")private String equityAmt;
    @CsvBindByName(column = "div_int_amt")private String divIntAmt;
    @CsvBindByName(column = "mkt_val_amt")private String mktValAmt;
    @CsvBindByName(column = "trade_dt_bal")private String tradeDtBal;
    @CsvBindByName(column = "settle_dt_bal")private String settleDtBal;
    @CsvBindByName(column = "long_mkt_value_amt")private String longMktValueAmt;
    @CsvBindByName(column = "shrt_mkt_value_amt")private String shrtMktValueAmt;
    @CsvBindByName(column = "fed_call_amt")private String fedCallAmt;
    @CsvBindByName(column = "accum_fed_amt")private String accumFedAmt;
    @CsvBindByName(column = "accum_fed_prev")private String accumFedPrev;
    @CsvBindByName(column = "maint_call_amt")private String maintCallAmt;
    @CsvBindByName(column = "maint_prev")private String maintPrev;
    @CsvBindByName(column = "sma_change_amt")private String smaChangeAmt;
    @CsvBindByName(column = "sma_change_prv_amt")private String smaChangePrvAmt;
    @CsvBindByName(column = "sma_bal_amt")private String smaBalAmt;
    @CsvBindByName(column = "sma_or_call_prev")private String smaOrCallPrev;
    @CsvBindByName(column = "currency_factor")private String currencyFactor;
    @CsvBindByName(column = "free_cred_misc_deb")private String freeCredMiscDeb;
    @CsvBindByName(column = "dly_credit_int")private String dlyCreditInt;
    @CsvBindByName(column = "mtd_credit_int")private String mtdCreditInt;
    @CsvBindByName(column = "mtd_mgn_int")private String mtdMgnInt;
    @CsvBindByName(column = "exch_call")private String exchCall;
    @CsvBindByName(column = "percent_eqty")private String percentEqty;
    @CsvBindByName(column = "money_mkt_bal")private String moneyMktBal;
    @CsvBindByName(column = "cash_free_cr")private String cashFreeCr;
    @CsvBindByName(column = "bal_long_sd")private String balLongSd;
    @CsvBindByName(column = "bal_short_sd")private String balShortSd;
    @CsvBindByName(column = "bal_short_td")private String balShortTd;
    @CsvBindByName(column = "bal_long_td")private String balLongTd;
    @CsvBindByName(column = "opt_req")private String optReq;
    @CsvBindByName(column = "fed_call_prev")private String fedCallPrev;
    @CsvBindByName(column = "cash_free_cr_prev")private String cashFreeCrPrev;
    @CsvBindByName(column = "daily_int_prev")private String dailyIntPrev;
    @CsvBindByName(column = "mtd_int_prev")private String mtdIntPrev;
    @CsvBindByName(column = "bal_pct_eqty_prev")private String balPctEqtyPrev;
    @CsvBindByName(column = "opt_val_long")private String optValLong;
    @CsvBindByName(column = "opt_val_short")private String optValShort;
    @CsvBindByName(column = "curr_code")private String currCode;
    @CsvBindByName(column = "adj_bal")private String adjBal;
    @CsvBindByName(column = "avail_cr_amt")private String availCrAmt;

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
