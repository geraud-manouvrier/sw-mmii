package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class BalCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "crncy_type")private String crncyType;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "last_seq_no")private String lastSeqNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "long_mkt_value_amt")private String longMktValueAmt;
    @CsvBindByName(column = "shrt_mkt_value_amt")private String shrtMktValueAmt;
    @CsvBindByName(column = "dividend_bal_amt")private String dividendBalAmt;
    @CsvBindByName(column = "cash_rcvd_amt")private String cashRcvdAmt;
    @CsvBindByName(column = "chk_today_amt")private String chkTodayAmt;
    @CsvBindByName(column = "free_cred_misc_deb")private String freeCredMiscDeb;
    @CsvBindByName(column = "pend_mat_amt")private String pendMatAmt;
    @CsvBindByName(column = "acct_bal_amt")private String acctBalAmt;
    @CsvBindByName(column = "trade_activity")private String tradeActivity;
    @CsvBindByName(column = "cash_activity")private String cashActivity;
    @CsvBindByName(column = "stock_activity")private String stockActivity;
    @CsvBindByName(column = "other_activity")private String otherActivity;
    @CsvBindByName(column = "mfp_ind")private String mfpInd;
    @CsvBindByName(column = "mfp_value_amt")private String mfpValueAmt;
    @CsvBindByName(column = "aip_value_amt")private String aipValueAmt;
    @CsvBindByName(column = "with_held_amt")private String withHeldAmt;
    @CsvBindByName(column = "mm_code")private String mmCode;
    @CsvBindByName(column = "mkt_value_amt")private String mktValueAmt;
    @CsvBindByName(column = "daily_cr_int")private String dailyCrInt;
    @CsvBindByName(column = "mtd_cr_int")private String mtdCrInt;
    @CsvBindByName(column = "proj_sd_amt")private String projSdAmt;
    @CsvBindByName(column = "yesterday_checks")private String yesterdayChecks;
    @CsvBindByName(column = "frozen_amt")private String frozenAmt;
    @CsvBindByName(column = "ach_today_amt")private String achTodayAmt;
    @CsvBindByName(column = "ach_inc_today_amt")private String achIncTodayAmt;
    @CsvBindByName(column = "ach_dist_sw")private String achDistSw;
    @CsvBindByName(column = "cash_mgn_mkt_val")private String cashMgnMktVal;
    @CsvBindByName(column = "cash_mgn_cash_av")private String cashMgnCashAv;
    @CsvBindByName(column = "proj_sd_free_amt")private String projSdFreeAmt;
    @CsvBindByName(column = "cash_avail_prv_amt")private String cashAvailPrvAmt;
    @CsvBindByName(column = "sma_change_prv_amt")private String smaChangePrvAmt;
    @CsvBindByName(column = "equity_amt")private String equityAmt;
    @CsvBindByName(column = "cash_avail_amt")private String cashAvailAmt;
    @CsvBindByName(column = "buy_pwr_amt")private String buyPwrAmt;
    @CsvBindByName(column = "fed_call_amt")private String fedCallAmt;
    @CsvBindByName(column = "accum_fed_amt")private String accumFedAmt;
    @CsvBindByName(column = "maint_call_amt")private String maintCallAmt;
    @CsvBindByName(column = "sma_change_amt")private String smaChangeAmt;
    @CsvBindByName(column = "sma_bal_amt")private String smaBalAmt;
    @CsvBindByName(column = "daily_int2_amt")private String dailyInt2Amt;
    @CsvBindByName(column = "mtd_int2_amt")private String mtdInt2Amt;
    @CsvBindByName(column = "optn_req_amt")private String optnReqAmt;
    @CsvBindByName(column = "optn_mkt_loss_amt")private String optnMktLossAmt;
    @CsvBindByName(column = "percent_eqty")private String percentEqty;
    @CsvBindByName(column = "price_err")private String priceErr;
    @CsvBindByName(column = "need_mrg_agrmt")private String needMrgAgrmt;
    @CsvBindByName(column = "oplev_err")private String oplevErr;
    @CsvBindByName(column = "pctcap_sw")private String pctcapSw;
    @CsvBindByName(column = "ammo_entity")private String ammoEntity;
    @CsvBindByName(column = "bopmv_eqty")private String bopmvEqty;
    @CsvBindByName(column = "shrt_liq_value_amt")private String shrtLiqValueAmt;
    @CsvBindByName(column = "long_liq_value_amt")private String longLiqValueAmt;
    @CsvBindByName(column = "usd_equivalent")private String usdEquivalent;
    @CsvBindByName(column = "currency_factor")private String currencyFactor;
    @CsvBindByName(column = "exc_equ_ovr_50_amt")private String excEquOvr50Amt;
    @CsvBindByName(column = "optn_addtl_req_amt")private String optnAddtlReqAmt;
    @CsvBindByName(column = "exch_call")private String exchCall;
    @CsvBindByName(column = "accum_fed_prev")private String accumFedPrev;
    @CsvBindByName(column = "sma_or_call_prev")private String smaOrCallPrev;
    @CsvBindByName(column = "maint_prev")private String maintPrev;
    @CsvBindByName(column = "marv_ind")private String marvInd;
    @CsvBindByName(column = "mgn_sweep_amt")private String mgnSweepAmt;
    @CsvBindByName(column = "avail_cr_code")private String availCrCode;
    @CsvBindByName(column = "avail_cr_amt")private String availCrAmt;

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
