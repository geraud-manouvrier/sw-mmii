package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_act_sum", schema = "stage_stonex")
public class StageActSum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_stamp", nullable = false, length = 100)
    private String processStamp;

    @Size(max = 300)
    @NotNull
    @Column(name = "ba_reccode", nullable = false, length = 300)
    private String baReccode;

    @Size(max = 300)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 300)
    private String acctNo;

    @Size(max = 300)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 300)
    private String firmNo;

    @Size(max = 300)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 300)
    private String subNo;

    @Size(max = 300)
    @NotNull
    @Column(name = "acct_bal", nullable = false, length = 300)
    private String acctBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "total_mv", nullable = false, length = 300)
    private String totalMv;

    @Size(max = 300)
    @NotNull
    @Column(name = "money_market_bal", nullable = false, length = 300)
    private String moneyMarketBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "total_av", nullable = false, length = 300)
    private String totalAv;

    @Size(max = 300)
    @NotNull
    @Column(name = "fund_avail_amt", nullable = false, length = 300)
    private String fundAvailAmt;

    @Size(max = 300)
    @NotNull
    @Column(name = "cash_bal", nullable = false, length = 300)
    private String cashBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "type1_mv", nullable = false, length = 300)
    private String type1Mv;

    @Size(max = 300)
    @NotNull
    @Column(name = "fed_call", nullable = false, length = 300)
    private String fedCall;

    @Size(max = 300)
    @NotNull
    @Column(name = "usd_eq", nullable = false, length = 300)
    private String usdEq;

    @Size(max = 300)
    @NotNull
    @Column(name = "foreign_mv", nullable = false, length = 300)
    private String foreignMv;

    @Size(max = 300)
    @NotNull
    @Column(name = "maint_call", nullable = false, length = 300)
    private String maintCall;

    @Size(max = 300)
    @NotNull
    @Column(name = "total_cv", nullable = false, length = 300)
    private String totalCv;

    @Size(max = 300)
    @NotNull
    @Column(name = "type2_lmv", nullable = false, length = 300)
    private String type2Lmv;

    @Size(max = 300)
    @NotNull
    @Column(name = "dr_int_amt", nullable = false, length = 300)
    private String drIntAmt;

    @Size(max = 300)
    @NotNull
    @Column(name = "margin_bal", nullable = false, length = 300)
    private String marginBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "type2_smv", nullable = false, length = 300)
    private String type2Smv;

    @Size(max = 300)
    @NotNull
    @Column(name = "mtd_db_int", nullable = false, length = 300)
    private String mtdDbInt;

    @Size(max = 300)
    @NotNull
    @Column(name = "other_bal", nullable = false, length = 300)
    private String otherBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "other_mmv", nullable = false, length = 300)
    private String otherMmv;

    @Size(max = 300)
    @NotNull
    @Column(name = "equity_pct", nullable = false, length = 300)
    private String equityPct;

    @Size(max = 300)
    @NotNull
    @Column(name = "div_int", nullable = false, length = 300)
    private String divInt;

    @Size(max = 300)
    @NotNull
    @Column(name = "other_cmv", nullable = false, length = 300)
    private String otherCmv;

    @Size(max = 300)
    @NotNull
    @Column(name = "equity_amt", nullable = false, length = 300)
    private String equityAmt;

    @Size(max = 300)
    @NotNull
    @Column(name = "type1_ca", nullable = false, length = 300)
    private String type1Ca;

    @Size(max = 300)
    @NotNull
    @Column(name = "cash_avail", nullable = false, length = 300)
    private String cashAvail;

    @Size(max = 300)
    @NotNull
    @Column(name = "sma_bal", nullable = false, length = 300)
    private String smaBal;

    @Size(max = 300)
    @NotNull
    @Column(name = "mgn_sec_t1", nullable = false, length = 300)
    private String mgnSecT1;

    @Size(max = 300)
    @NotNull
    @Column(name = "buy_power", nullable = false, length = 300)
    private String buyPower;

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