package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_bal", schema = "stage_stonex")
public class StageBal {
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
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 100)
    private String acctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_type", nullable = false, length = 100)
    private String crncyType;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_seq_no", nullable = false, length = 100)
    private String lastSeqNo;

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
    @Column(name = "long_mkt_value_amt", nullable = false, length = 100)
    private String longMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "shrt_mkt_value_amt", nullable = false, length = 100)
    private String shrtMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "dividend_bal_amt", nullable = false, length = 100)
    private String dividendBalAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_rcvd_amt", nullable = false, length = 100)
    private String cashRcvdAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "chk_today_amt", nullable = false, length = 100)
    private String chkTodayAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "free_cred_misc_deb", nullable = false, length = 100)
    private String freeCredMiscDeb;

    @Size(max = 100)
    @NotNull
    @Column(name = "pend_mat_amt", nullable = false, length = 100)
    private String pendMatAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_bal_amt", nullable = false, length = 100)
    private String acctBalAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_activity", nullable = false, length = 100)
    private String tradeActivity;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_activity", nullable = false, length = 100)
    private String cashActivity;

    @Size(max = 100)
    @NotNull
    @Column(name = "stock_activity", nullable = false, length = 100)
    private String stockActivity;

    @Size(max = 100)
    @NotNull
    @Column(name = "other_activity", nullable = false, length = 100)
    private String otherActivity;

    @Size(max = 100)
    @NotNull
    @Column(name = "mfp_ind", nullable = false, length = 100)
    private String mfpInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mfp_value_amt", nullable = false, length = 100)
    private String mfpValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "aip_value_amt", nullable = false, length = 100)
    private String aipValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "with_held_amt", nullable = false, length = 100)
    private String withHeldAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mm_code", nullable = false, length = 100)
    private String mmCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_value_amt", nullable = false, length = 100)
    private String mktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "daily_cr_int", nullable = false, length = 100)
    private String dailyCrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mtd_cr_int", nullable = false, length = 100)
    private String mtdCrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "proj_sd_amt", nullable = false, length = 100)
    private String projSdAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "yesterday_checks", nullable = false, length = 100)
    private String yesterdayChecks;

    @Size(max = 100)
    @NotNull
    @Column(name = "frozen_amt", nullable = false, length = 100)
    private String frozenAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_today_amt", nullable = false, length = 100)
    private String achTodayAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_inc_today_amt", nullable = false, length = 100)
    private String achIncTodayAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_dist_sw", nullable = false, length = 100)
    private String achDistSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_mgn_mkt_val", nullable = false, length = 100)
    private String cashMgnMktVal;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_mgn_cash_av", nullable = false, length = 100)
    private String cashMgnCashAv;

    @Size(max = 100)
    @NotNull
    @Column(name = "proj_sd_free_amt", nullable = false, length = 100)
    private String projSdFreeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_avail_prv_amt", nullable = false, length = 100)
    private String cashAvailPrvAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_change_prv_amt", nullable = false, length = 100)
    private String smaChangePrvAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "equity_amt", nullable = false, length = 100)
    private String equityAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_avail_amt", nullable = false, length = 100)
    private String cashAvailAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "buy_pwr_amt", nullable = false, length = 100)
    private String buyPwrAmt;

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
    @Column(name = "maint_call_amt", nullable = false, length = 100)
    private String maintCallAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_change_amt", nullable = false, length = 100)
    private String smaChangeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_bal_amt", nullable = false, length = 100)
    private String smaBalAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "daily_int2_amt", nullable = false, length = 100)
    private String dailyInt2Amt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mtd_int2_amt", nullable = false, length = 100)
    private String mtdInt2Amt;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_req_amt", nullable = false, length = 100)
    private String optnReqAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_mkt_loss_amt", nullable = false, length = 100)
    private String optnMktLossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "percent_eqty", nullable = false, length = 100)
    private String percentEqty;

    @Size(max = 100)
    @NotNull
    @Column(name = "price_err", nullable = false, length = 100)
    private String priceErr;

    @Size(max = 100)
    @NotNull
    @Column(name = "need_mrg_agrmt", nullable = false, length = 100)
    private String needMrgAgrmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "oplev_err", nullable = false, length = 100)
    private String oplevErr;

    @Size(max = 100)
    @NotNull
    @Column(name = "pctcap_sw", nullable = false, length = 100)
    private String pctcapSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "ammo_entity", nullable = false, length = 100)
    private String ammoEntity;

    @Size(max = 100)
    @NotNull
    @Column(name = "bopmv_eqty", nullable = false, length = 100)
    private String bopmvEqty;

    @Size(max = 100)
    @NotNull
    @Column(name = "shrt_liq_value_amt", nullable = false, length = 100)
    private String shrtLiqValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "long_liq_value_amt", nullable = false, length = 100)
    private String longLiqValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "usd_equivalent", nullable = false, length = 100)
    private String usdEquivalent;

    @Size(max = 100)
    @NotNull
    @Column(name = "currency_factor", nullable = false, length = 100)
    private String currencyFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "exc_equ_ovr_50_amt", nullable = false, length = 100)
    private String excEquOvr50Amt;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_addtl_req_amt", nullable = false, length = 100)
    private String optnAddtlReqAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch_call", nullable = false, length = 100)
    private String exchCall;

    @Size(max = 100)
    @NotNull
    @Column(name = "accum_fed_prev", nullable = false, length = 100)
    private String accumFedPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "sma_or_call_prev", nullable = false, length = 100)
    private String smaOrCallPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "maint_prev", nullable = false, length = 100)
    private String maintPrev;

    @Size(max = 100)
    @NotNull
    @Column(name = "marv_ind", nullable = false, length = 100)
    private String marvInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_sweep_amt", nullable = false, length = 100)
    private String mgnSweepAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "avail_cr_code", nullable = false, length = 100)
    private String availCrCode;

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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getCrncyType() {
        return crncyType;
    }

    public void setCrncyType(String crncyType) {
        this.crncyType = crncyType;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getLastSeqNo() {
        return lastSeqNo;
    }

    public void setLastSeqNo(String lastSeqNo) {
        this.lastSeqNo = lastSeqNo;
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

    public String getDividendBalAmt() {
        return dividendBalAmt;
    }

    public void setDividendBalAmt(String dividendBalAmt) {
        this.dividendBalAmt = dividendBalAmt;
    }

    public String getCashRcvdAmt() {
        return cashRcvdAmt;
    }

    public void setCashRcvdAmt(String cashRcvdAmt) {
        this.cashRcvdAmt = cashRcvdAmt;
    }

    public String getChkTodayAmt() {
        return chkTodayAmt;
    }

    public void setChkTodayAmt(String chkTodayAmt) {
        this.chkTodayAmt = chkTodayAmt;
    }

    public String getFreeCredMiscDeb() {
        return freeCredMiscDeb;
    }

    public void setFreeCredMiscDeb(String freeCredMiscDeb) {
        this.freeCredMiscDeb = freeCredMiscDeb;
    }

    public String getPendMatAmt() {
        return pendMatAmt;
    }

    public void setPendMatAmt(String pendMatAmt) {
        this.pendMatAmt = pendMatAmt;
    }

    public String getAcctBalAmt() {
        return acctBalAmt;
    }

    public void setAcctBalAmt(String acctBalAmt) {
        this.acctBalAmt = acctBalAmt;
    }

    public String getTradeActivity() {
        return tradeActivity;
    }

    public void setTradeActivity(String tradeActivity) {
        this.tradeActivity = tradeActivity;
    }

    public String getCashActivity() {
        return cashActivity;
    }

    public void setCashActivity(String cashActivity) {
        this.cashActivity = cashActivity;
    }

    public String getStockActivity() {
        return stockActivity;
    }

    public void setStockActivity(String stockActivity) {
        this.stockActivity = stockActivity;
    }

    public String getOtherActivity() {
        return otherActivity;
    }

    public void setOtherActivity(String otherActivity) {
        this.otherActivity = otherActivity;
    }

    public String getMfpInd() {
        return mfpInd;
    }

    public void setMfpInd(String mfpInd) {
        this.mfpInd = mfpInd;
    }

    public String getMfpValueAmt() {
        return mfpValueAmt;
    }

    public void setMfpValueAmt(String mfpValueAmt) {
        this.mfpValueAmt = mfpValueAmt;
    }

    public String getAipValueAmt() {
        return aipValueAmt;
    }

    public void setAipValueAmt(String aipValueAmt) {
        this.aipValueAmt = aipValueAmt;
    }

    public String getWithHeldAmt() {
        return withHeldAmt;
    }

    public void setWithHeldAmt(String withHeldAmt) {
        this.withHeldAmt = withHeldAmt;
    }

    public String getMmCode() {
        return mmCode;
    }

    public void setMmCode(String mmCode) {
        this.mmCode = mmCode;
    }

    public String getMktValueAmt() {
        return mktValueAmt;
    }

    public void setMktValueAmt(String mktValueAmt) {
        this.mktValueAmt = mktValueAmt;
    }

    public String getDailyCrInt() {
        return dailyCrInt;
    }

    public void setDailyCrInt(String dailyCrInt) {
        this.dailyCrInt = dailyCrInt;
    }

    public String getMtdCrInt() {
        return mtdCrInt;
    }

    public void setMtdCrInt(String mtdCrInt) {
        this.mtdCrInt = mtdCrInt;
    }

    public String getProjSdAmt() {
        return projSdAmt;
    }

    public void setProjSdAmt(String projSdAmt) {
        this.projSdAmt = projSdAmt;
    }

    public String getYesterdayChecks() {
        return yesterdayChecks;
    }

    public void setYesterdayChecks(String yesterdayChecks) {
        this.yesterdayChecks = yesterdayChecks;
    }

    public String getFrozenAmt() {
        return frozenAmt;
    }

    public void setFrozenAmt(String frozenAmt) {
        this.frozenAmt = frozenAmt;
    }

    public String getAchTodayAmt() {
        return achTodayAmt;
    }

    public void setAchTodayAmt(String achTodayAmt) {
        this.achTodayAmt = achTodayAmt;
    }

    public String getAchIncTodayAmt() {
        return achIncTodayAmt;
    }

    public void setAchIncTodayAmt(String achIncTodayAmt) {
        this.achIncTodayAmt = achIncTodayAmt;
    }

    public String getAchDistSw() {
        return achDistSw;
    }

    public void setAchDistSw(String achDistSw) {
        this.achDistSw = achDistSw;
    }

    public String getCashMgnMktVal() {
        return cashMgnMktVal;
    }

    public void setCashMgnMktVal(String cashMgnMktVal) {
        this.cashMgnMktVal = cashMgnMktVal;
    }

    public String getCashMgnCashAv() {
        return cashMgnCashAv;
    }

    public void setCashMgnCashAv(String cashMgnCashAv) {
        this.cashMgnCashAv = cashMgnCashAv;
    }

    public String getProjSdFreeAmt() {
        return projSdFreeAmt;
    }

    public void setProjSdFreeAmt(String projSdFreeAmt) {
        this.projSdFreeAmt = projSdFreeAmt;
    }

    public String getCashAvailPrvAmt() {
        return cashAvailPrvAmt;
    }

    public void setCashAvailPrvAmt(String cashAvailPrvAmt) {
        this.cashAvailPrvAmt = cashAvailPrvAmt;
    }

    public String getSmaChangePrvAmt() {
        return smaChangePrvAmt;
    }

    public void setSmaChangePrvAmt(String smaChangePrvAmt) {
        this.smaChangePrvAmt = smaChangePrvAmt;
    }

    public String getEquityAmt() {
        return equityAmt;
    }

    public void setEquityAmt(String equityAmt) {
        this.equityAmt = equityAmt;
    }

    public String getCashAvailAmt() {
        return cashAvailAmt;
    }

    public void setCashAvailAmt(String cashAvailAmt) {
        this.cashAvailAmt = cashAvailAmt;
    }

    public String getBuyPwrAmt() {
        return buyPwrAmt;
    }

    public void setBuyPwrAmt(String buyPwrAmt) {
        this.buyPwrAmt = buyPwrAmt;
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

    public String getMaintCallAmt() {
        return maintCallAmt;
    }

    public void setMaintCallAmt(String maintCallAmt) {
        this.maintCallAmt = maintCallAmt;
    }

    public String getSmaChangeAmt() {
        return smaChangeAmt;
    }

    public void setSmaChangeAmt(String smaChangeAmt) {
        this.smaChangeAmt = smaChangeAmt;
    }

    public String getSmaBalAmt() {
        return smaBalAmt;
    }

    public void setSmaBalAmt(String smaBalAmt) {
        this.smaBalAmt = smaBalAmt;
    }

    public String getDailyInt2Amt() {
        return dailyInt2Amt;
    }

    public void setDailyInt2Amt(String dailyInt2Amt) {
        this.dailyInt2Amt = dailyInt2Amt;
    }

    public String getMtdInt2Amt() {
        return mtdInt2Amt;
    }

    public void setMtdInt2Amt(String mtdInt2Amt) {
        this.mtdInt2Amt = mtdInt2Amt;
    }

    public String getOptnReqAmt() {
        return optnReqAmt;
    }

    public void setOptnReqAmt(String optnReqAmt) {
        this.optnReqAmt = optnReqAmt;
    }

    public String getOptnMktLossAmt() {
        return optnMktLossAmt;
    }

    public void setOptnMktLossAmt(String optnMktLossAmt) {
        this.optnMktLossAmt = optnMktLossAmt;
    }

    public String getPercentEqty() {
        return percentEqty;
    }

    public void setPercentEqty(String percentEqty) {
        this.percentEqty = percentEqty;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getNeedMrgAgrmt() {
        return needMrgAgrmt;
    }

    public void setNeedMrgAgrmt(String needMrgAgrmt) {
        this.needMrgAgrmt = needMrgAgrmt;
    }

    public String getOplevErr() {
        return oplevErr;
    }

    public void setOplevErr(String oplevErr) {
        this.oplevErr = oplevErr;
    }

    public String getPctcapSw() {
        return pctcapSw;
    }

    public void setPctcapSw(String pctcapSw) {
        this.pctcapSw = pctcapSw;
    }

    public String getAmmoEntity() {
        return ammoEntity;
    }

    public void setAmmoEntity(String ammoEntity) {
        this.ammoEntity = ammoEntity;
    }

    public String getBopmvEqty() {
        return bopmvEqty;
    }

    public void setBopmvEqty(String bopmvEqty) {
        this.bopmvEqty = bopmvEqty;
    }

    public String getShrtLiqValueAmt() {
        return shrtLiqValueAmt;
    }

    public void setShrtLiqValueAmt(String shrtLiqValueAmt) {
        this.shrtLiqValueAmt = shrtLiqValueAmt;
    }

    public String getLongLiqValueAmt() {
        return longLiqValueAmt;
    }

    public void setLongLiqValueAmt(String longLiqValueAmt) {
        this.longLiqValueAmt = longLiqValueAmt;
    }

    public String getUsdEquivalent() {
        return usdEquivalent;
    }

    public void setUsdEquivalent(String usdEquivalent) {
        this.usdEquivalent = usdEquivalent;
    }

    public String getCurrencyFactor() {
        return currencyFactor;
    }

    public void setCurrencyFactor(String currencyFactor) {
        this.currencyFactor = currencyFactor;
    }

    public String getExcEquOvr50Amt() {
        return excEquOvr50Amt;
    }

    public void setExcEquOvr50Amt(String excEquOvr50Amt) {
        this.excEquOvr50Amt = excEquOvr50Amt;
    }

    public String getOptnAddtlReqAmt() {
        return optnAddtlReqAmt;
    }

    public void setOptnAddtlReqAmt(String optnAddtlReqAmt) {
        this.optnAddtlReqAmt = optnAddtlReqAmt;
    }

    public String getExchCall() {
        return exchCall;
    }

    public void setExchCall(String exchCall) {
        this.exchCall = exchCall;
    }

    public String getAccumFedPrev() {
        return accumFedPrev;
    }

    public void setAccumFedPrev(String accumFedPrev) {
        this.accumFedPrev = accumFedPrev;
    }

    public String getSmaOrCallPrev() {
        return smaOrCallPrev;
    }

    public void setSmaOrCallPrev(String smaOrCallPrev) {
        this.smaOrCallPrev = smaOrCallPrev;
    }

    public String getMaintPrev() {
        return maintPrev;
    }

    public void setMaintPrev(String maintPrev) {
        this.maintPrev = maintPrev;
    }

    public String getMarvInd() {
        return marvInd;
    }

    public void setMarvInd(String marvInd) {
        this.marvInd = marvInd;
    }

    public String getMgnSweepAmt() {
        return mgnSweepAmt;
    }

    public void setMgnSweepAmt(String mgnSweepAmt) {
        this.mgnSweepAmt = mgnSweepAmt;
    }

    public String getAvailCrCode() {
        return availCrCode;
    }

    public void setAvailCrCode(String availCrCode) {
        this.availCrCode = availCrCode;
    }

    public String getAvailCrAmt() {
        return availCrAmt;
    }

    public void setAvailCrAmt(String availCrAmt) {
        this.availCrAmt = availCrAmt;
    }

}