package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class ActSumCsvBean extends CsvBean {


    @CsvBindByName(column = "ba_reccode")
    private String baReccode;

    @CsvBindByName(column = "acct_no")
    private String acctNo;

    @CsvBindByName(column = "firm_no")
    private String firmNo;

    @CsvBindByName(column = "sub_no")
    private String subNo;

    @CsvBindByName(column = "acct_bal")
    private String acctBal;

    @CsvBindByName(column = "total_mv")
    private String totalMv;

    @CsvBindByName(column = "money_market_bal")
    private String moneyMarketBal;

    @CsvBindByName(column = "total_av")
    private String totalAv;

    @CsvBindByName(column = "fund_avail_amt")
    private String fundAvailAmt;

    @CsvBindByName(column = "cash_bal")
    private String cashBal;

    @CsvBindByName(column = "type1_mv")
    private String type1Mv;

    @CsvBindByName(column = "fed_call")
    private String fedCall;

    @CsvBindByName(column = "usd_eq")
    private String usdEq;

    @CsvBindByName(column = "foreign_mv")
    private String foreignMv;

    @CsvBindByName(column = "maint_call")
    private String maintCall;

    @CsvBindByName(column = "total_cv")
    private String totalCv;

    @CsvBindByName(column = "type2_lmv")
    private String type2Lmv;

    @CsvBindByName(column = "dr_int_amt")
    private String drIntAmt;

    @CsvBindByName(column = "margin_bal")
    private String marginBal;

    @CsvBindByName(column = "type2_smv")
    private String type2Smv;

    @CsvBindByName(column = "mtd_db_int")
    private String mtdDbInt;

    @CsvBindByName(column = "other_bal")
    private String otherBal;

    @CsvBindByName(column = "other_mmv")
    private String otherMmv;

    @CsvBindByName(column = "equity_pct")
    private String equityPct;

    @CsvBindByName(column = "div_int")
    private String divInt;

    @CsvBindByName(column = "other_cmv")
    private String otherCmv;

    @CsvBindByName(column = "equity_amt")
    private String equityAmt;

    @CsvBindByName(column = "type1_ca")
    private String type1Ca;

    @CsvBindByName(column = "cash_avail")
    private String cashAvail;

    @CsvBindByName(column = "sma_bal")
    private String smaBal;

    @CsvBindByName(column = "mgn_sec_t1")
    private String mgnSecT1;

    @CsvBindByName(column = "buy_power")
    private String buyPower;

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

    public String getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(String acctBal) {
        this.acctBal = acctBal;
    }

    public String getTotalMv() {
        return totalMv;
    }

    public void setTotalMv(String totalMv) {
        this.totalMv = totalMv;
    }

    public String getMoneyMarketBal() {
        return moneyMarketBal;
    }

    public void setMoneyMarketBal(String moneyMarketBal) {
        this.moneyMarketBal = moneyMarketBal;
    }

    public String getTotalAv() {
        return totalAv;
    }

    public void setTotalAv(String totalAv) {
        this.totalAv = totalAv;
    }

    public String getFundAvailAmt() {
        return fundAvailAmt;
    }

    public void setFundAvailAmt(String fundAvailAmt) {
        this.fundAvailAmt = fundAvailAmt;
    }

    public String getCashBal() {
        return cashBal;
    }

    public void setCashBal(String cashBal) {
        this.cashBal = cashBal;
    }

    public String getType1Mv() {
        return type1Mv;
    }

    public void setType1Mv(String type1Mv) {
        this.type1Mv = type1Mv;
    }

    public String getFedCall() {
        return fedCall;
    }

    public void setFedCall(String fedCall) {
        this.fedCall = fedCall;
    }

    public String getUsdEq() {
        return usdEq;
    }

    public void setUsdEq(String usdEq) {
        this.usdEq = usdEq;
    }

    public String getForeignMv() {
        return foreignMv;
    }

    public void setForeignMv(String foreignMv) {
        this.foreignMv = foreignMv;
    }

    public String getMaintCall() {
        return maintCall;
    }

    public void setMaintCall(String maintCall) {
        this.maintCall = maintCall;
    }

    public String getTotalCv() {
        return totalCv;
    }

    public void setTotalCv(String totalCv) {
        this.totalCv = totalCv;
    }

    public String getType2Lmv() {
        return type2Lmv;
    }

    public void setType2Lmv(String type2Lmv) {
        this.type2Lmv = type2Lmv;
    }

    public String getDrIntAmt() {
        return drIntAmt;
    }

    public void setDrIntAmt(String drIntAmt) {
        this.drIntAmt = drIntAmt;
    }

    public String getMarginBal() {
        return marginBal;
    }

    public void setMarginBal(String marginBal) {
        this.marginBal = marginBal;
    }

    public String getType2Smv() {
        return type2Smv;
    }

    public void setType2Smv(String type2Smv) {
        this.type2Smv = type2Smv;
    }

    public String getMtdDbInt() {
        return mtdDbInt;
    }

    public void setMtdDbInt(String mtdDbInt) {
        this.mtdDbInt = mtdDbInt;
    }

    public String getOtherBal() {
        return otherBal;
    }

    public void setOtherBal(String otherBal) {
        this.otherBal = otherBal;
    }

    public String getOtherMmv() {
        return otherMmv;
    }

    public void setOtherMmv(String otherMmv) {
        this.otherMmv = otherMmv;
    }

    public String getEquityPct() {
        return equityPct;
    }

    public void setEquityPct(String equityPct) {
        this.equityPct = equityPct;
    }

    public String getDivInt() {
        return divInt;
    }

    public void setDivInt(String divInt) {
        this.divInt = divInt;
    }

    public String getOtherCmv() {
        return otherCmv;
    }

    public void setOtherCmv(String otherCmv) {
        this.otherCmv = otherCmv;
    }

    public String getEquityAmt() {
        return equityAmt;
    }

    public void setEquityAmt(String equityAmt) {
        this.equityAmt = equityAmt;
    }

    public String getType1Ca() {
        return type1Ca;
    }

    public void setType1Ca(String type1Ca) {
        this.type1Ca = type1Ca;
    }

    public String getCashAvail() {
        return cashAvail;
    }

    public void setCashAvail(String cashAvail) {
        this.cashAvail = cashAvail;
    }

    public String getSmaBal() {
        return smaBal;
    }

    public void setSmaBal(String smaBal) {
        this.smaBal = smaBal;
    }

    public String getMgnSecT1() {
        return mgnSecT1;
    }

    public void setMgnSecT1(String mgnSecT1) {
        this.mgnSecT1 = mgnSecT1;
    }

    public String getBuyPower() {
        return buyPower;
    }

    public void setBuyPower(String buyPower) {
        this.buyPower = buyPower;
    }
}
