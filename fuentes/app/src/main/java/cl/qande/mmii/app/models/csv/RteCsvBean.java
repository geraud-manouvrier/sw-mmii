package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class RteCsvBean extends CsvBean {


    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "symbol")private String symbol;
    @CsvBindByName(column = "cusip")private String cusip;
    @CsvBindByName(column = "exch1")private String exch1;
    @CsvBindByName(column = "qty1")private String qty1;
    @CsvBindByName(column = "exch2")private String exch2;
    @CsvBindByName(column = "qty2")private String qty2;
    @CsvBindByName(column = "exch3")private String exch3;
    @CsvBindByName(column = "qty3")private String qty3;
    @CsvBindByName(column = "exch4")private String exch4;
    @CsvBindByName(column = "qty4")private String qty4;
    @CsvBindByName(column = "exch5")private String exch5;
    @CsvBindByName(column = "qty5")private String qty5;
    @CsvBindByName(column = "special1")private String special1;
    @CsvBindByName(column = "special2")private String special2;
    @CsvBindByName(column = "special3")private String special3;
    @CsvBindByName(column = "special4")private String special4;
    @CsvBindByName(column = "special5")private String special5;
    @CsvBindByName(column = "trading_region")private String tradingRegion;
    @CsvBindByName(column = "prx_secno")private String prxSecno;
    @CsvBindByName(column = "prx")private String prx;
    @CsvBindByName(column = "prx_cymd")private String prxCymd;
    @CsvBindByName(column = "prx_init")private String prxInit;
    @CsvBindByName(column = "me_prx")private String mePrx;
    @CsvBindByName(column = "me_prx_cymd")private String mePrxCymd;
    @CsvBindByName(column = "me_prx_init")private String mePrxInit;
    @CsvBindByName(column = "ye_prx")private String yePrx;
    @CsvBindByName(column = "ye_prx_cymd")private String yePrxCymd;
    @CsvBindByName(column = "ye_prx_init")private String yePrxInit;
    @CsvBindByName(column = "chg_cymd")private String chgCymd;
    @CsvBindByName(column = "chg_init")private String chgInit;
    @CsvBindByName(column = "fund_dealer")private String fundDealer;
    @CsvBindByName(column = "oid")private String oid;
    @CsvBindByName(column = "money_avail_sw")private String moneyAvailSw;
    @CsvBindByName(column = "trf_agent")private String trfAgent;
    @CsvBindByName(column = "trf_fee")private String trfFee;
    @CsvBindByName(column = "trf_state")private String trfState;
    @CsvBindByName(column = "manual_trf")private String manualTrf;
    @CsvBindByName(column = "no_loan")private String noLoan;
    @CsvBindByName(column = "no_alloc")private String noAlloc;
    @CsvBindByName(column = "mgn_code")private String mgnCode;
    @CsvBindByName(column = "nrm")private String nrm;
    @CsvBindByName(column = "auto_app_ind")private String autoAppInd;
    @CsvBindByName(column = "no_trades")private String noTrades;
    @CsvBindByName(column = "synd_symbol")private String syndSymbol;
    @CsvBindByName(column = "note")private String note;
    @CsvBindByName(column = "est_maturity_cymd")private String estMaturityCymd;
    @CsvBindByName(column = "reorg_app_ind")private String reorgAppInd;
    @CsvBindByName(column = "market_maker")private String marketMaker;
    @CsvBindByName(column = "specialist")private String specialist;
    @CsvBindByName(column = "director_sw")private String directorSw;
    @CsvBindByName(column = "no_print_msrb")private String noPrintMsrb;
    @CsvBindByName(column = "no_print_ytm")private String noPrintYtm;
    @CsvBindByName(column = "controller")private String controller;
    @CsvBindByName(column = "user_prx")private String userPrx;
    @CsvBindByName(column = "product_code")private String productCode;
    @CsvBindByName(column = "mf_loc")private String mfLoc;
    @CsvBindByName(column = "box_type")private String boxType;
    @CsvBindByName(column = "fs_code")private String fsCode;
    @CsvBindByName(column = "mfbo_code")private String mfboCode;
    @CsvBindByName(column = "cur_yld")private String curYld;
    @CsvBindByName(column = "cur_yld_cymd")private String curYldCymd;
    @CsvBindByName(column = "effective_yld")private String effectiveYld;
    @CsvBindByName(column = "effective_yld_cymd")private String effectiveYldCymd;
    @CsvBindByName(column = "cash_dr_override")private String cashDrOverride;
    @CsvBindByName(column = "div_reinv")private String divReinv;
    @CsvBindByName(column = "cash_fund_acct")private String cashFundAcct;
    @CsvBindByName(column = "cash_loc")private String cashLoc;
    @CsvBindByName(column = "reinv_fund_acct")private String reinvFundAcct;
    @CsvBindByName(column = "reinv_loc")private String reinvLoc;
    @CsvBindByName(column = "sdiv_ind")private String sdivInd;
    @CsvBindByName(column = "build_divws_cymd")private String buildDivwsCymd;
    @CsvBindByName(column = "rein_a_prch_sw")private String reinAPrchSw;
    @CsvBindByName(column = "lp_loc")private String lpLoc;
    @CsvBindByName(column = "no_frac")private String noFrac;
    @CsvBindByName(column = "rte_cusip")private String rteCusip;
    @CsvBindByName(column = "net_level1")private String netLevel1;
    @CsvBindByName(column = "net_level2")private String netLevel2;
    @CsvBindByName(column = "net_level3")private String netLevel3;
    @CsvBindByName(column = "net_level4")private String netLevel4;
    @CsvBindByName(column = "xref_old_sec_no")private String xrefOldSecNo;
    @CsvBindByName(column = "xref_new_sec_no")private String xrefNewSecNo;
    @CsvBindByName(column = "bond_subtype")private String bondSubtype;
    @CsvBindByName(column = "first_trade_cymd")private String firstTradeCymd;
    @CsvBindByName(column = "purch_only_sw")private String purchOnlySw;
    @CsvBindByName(column = "ind_grp")private String indGrp;
    @CsvBindByName(column = "lvl3_reg_override")private String lvl3RegOverride;
    @CsvBindByName(column = "research_code")private String researchCode;
    @CsvBindByName(column = "net_or_gross")private String netOrGross;
    @CsvBindByName(column = "sls_credit")private String slsCredit;
    @CsvBindByName(column = "vender_prx_req")private String venderPrxReq;
    @CsvBindByName(column = "sd_code")private String sdCode;
    @CsvBindByName(column = "ipo_1st_stl_cymd")private String ipo1stStlCymd;
    @CsvBindByName(column = "ipo_end_pnlt_cymd")private String ipoEndPnltCymd;
    @CsvBindByName(column = "qr_io")private String qrIo;
    @CsvBindByName(column = "acct_lvl3_override")private String acctLvl3Override;
    @CsvBindByName(column = "mfi_code")private String mfiCode;
    @CsvBindByName(column = "opt_position_limit")private String optPositionLimit;
    @CsvBindByName(column = "mf_comm_sw")private String mfCommSw;
    @CsvBindByName(column = "navr_sw")private String navrSw;
    @CsvBindByName(column = "rotational_route")private String rotationalRoute;
    @CsvBindByName(column = "evd")private String evd;
    @CsvBindByName(column = "evs")private String evs;
    @CsvBindByName(column = "evm")private String evm;
    @CsvBindByName(column = "mf_no_prospectus")private String mfNoProspectus;
    @CsvBindByName(column = "sec_type")private String secType;
    @CsvBindByName(column = "new_sec_type")private String newSecType;
    @CsvBindByName(column = "div_chg_cymd")private String divChgCymd;
    @CsvBindByName(column = "div_chg_init")private String divChgInit;
    @CsvBindByName(column = "est_ann_div")private String estAnnDiv;
    @CsvBindByName(column = "features")private String features;
    @CsvBindByName(column = "gics")private String gics;
    @CsvBindByName(column = "naics")private String naics;
    @CsvBindByName(column = "oid_type")private String oidType;
    @CsvBindByName(column = "trading_status")private String tradingStatus;
    @CsvBindByName(column = "unit_size")private String unitSize;
    @CsvBindByName(column = "uit_wrap_ind")private String uitWrapInd;
    @CsvBindByName(column = "when_issue_dis_code")private String whenIssueDisCode;
    @CsvBindByName(column = "action_ovrd_text")private String actionOvrdText;
    @CsvBindByName(column = "action_ovrd_text_2")private String actionOvrdText2;
    @CsvBindByName(column = "corpact_who_code")private String corpactWhoCode;
    @CsvBindByName(column = "corpact_cymd")private String corpactCymd;
    @CsvBindByName(column = "when_issue_prx")private String whenIssuePrx;
    @CsvBindByName(column = "when_issue_who_code")private String whenIssueWhoCode;
    @CsvBindByName(column = "when_issue_cymd")private String whenIssueCymd;
    @CsvBindByName(column = "prospectus_end_cymd")private String prospectusEndCymd;
    @CsvBindByName(column = "div_pay_mmdd")private String divPayMmdd;
    @CsvBindByName(column = "splc_div_pay_mmdd")private String splcDivPayMmdd;
    @CsvBindByName(column = "splc_div_freq_code")private String splcDivFreqCode;
    @CsvBindByName(column = "change_term")private String changeTerm;
    @CsvBindByName(column = "change_source_id")private String changeSourceId;
    @CsvBindByName(column = "change_source")private String changeSource;
    @CsvBindByName(column = "pfd_sec_cpn_rate")private String pfdSecCpnRate;
    @CsvBindByName(column = "eff_mat_cymd")private String effMatCymd;
    @CsvBindByName(column = "prop_prod_ind")private String propProdInd;
    @CsvBindByName(column = "sell_agmt_ind")private String sellAgmtInd;
    @CsvBindByName(column = "sec_ex")private String secEx;
    @CsvBindByName(column = "wrap")private String wrap;
    @CsvBindByName(column = "acret_amort_ovrd_cd")private String acretAmortOvrdCd;
    @CsvBindByName(column = "qual_div_ind")private String qualDivInd;
    @CsvBindByName(column = "acces_dlvr_orvr_ind")private String accesDlvrOrvrInd;
    @CsvBindByName(column = "firm_product_code")private String firmProductCode;
    @CsvBindByName(column = "frac_shr_liq_ind")private String fracShrLiqInd;
    @CsvBindByName(column = "euro_cal_ind")private String euroCalInd;
    @CsvBindByName(column = "sub_issue_ovrd_cd")private String subIssueOvrdCd;
    @CsvBindByName(column = "cpd_ovrd_ind")private String cpdOvrdInd;
    @CsvBindByName(column = "etf_addl_margin_pct")private String etfAddlMarginPct;
    @CsvBindByName(column = "firm_sec_group_cd")private String firmSecGroupCd;
    @CsvBindByName(column = "taxlot_ovrd_cover_cymd")private String taxlotOvrdCoverCymd;
    @CsvBindByName(column = "mut_fund_postage_ind")private String mutFundPostageInd;
    @CsvBindByName(column = "trail_stop_ind")private String trailStopInd;
    @CsvBindByName(column = "trail_stop_who")private String trailStopWho;
    @CsvBindByName(column = "trail_stop_cymd")private String trailStopCymd;
    @CsvBindByName(column = "wave_10_id")private String wave10Id;
    @CsvBindByName(column = "settle_date_ovrd_code")private String settleDateOvrdCode;
    @CsvBindByName(column = "schk_ind")private String schkInd;
    @CsvBindByName(column = "aip_elig_ind")private String aipEligInd;
    @CsvBindByName(column = "avgc_ind")private String avgcInd;
    @CsvBindByName(column = "sensitive_code")private String sensitiveCode;
    @CsvBindByName(column = "mgn_ovrd_code")private String mgnOvrdCode;
    @CsvBindByName(column = "fatca_ovrd_code")private String fatcaOvrdCode;
    @CsvBindByName(column = "pref_accrued_ind")private String prefAccruedInd;
    @CsvBindByName(column = "rev_man_rate")private String revManRate;

    public String getBaReccode() {
        return baReccode;
    }

    public void setBaReccode(String baReccode) {
        this.baReccode = baReccode;
    }

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getExch1() {
        return exch1;
    }

    public void setExch1(String exch1) {
        this.exch1 = exch1;
    }

    public String getQty1() {
        return qty1;
    }

    public void setQty1(String qty1) {
        this.qty1 = qty1;
    }

    public String getExch2() {
        return exch2;
    }

    public void setExch2(String exch2) {
        this.exch2 = exch2;
    }

    public String getQty2() {
        return qty2;
    }

    public void setQty2(String qty2) {
        this.qty2 = qty2;
    }

    public String getExch3() {
        return exch3;
    }

    public void setExch3(String exch3) {
        this.exch3 = exch3;
    }

    public String getQty3() {
        return qty3;
    }

    public void setQty3(String qty3) {
        this.qty3 = qty3;
    }

    public String getExch4() {
        return exch4;
    }

    public void setExch4(String exch4) {
        this.exch4 = exch4;
    }

    public String getQty4() {
        return qty4;
    }

    public void setQty4(String qty4) {
        this.qty4 = qty4;
    }

    public String getExch5() {
        return exch5;
    }

    public void setExch5(String exch5) {
        this.exch5 = exch5;
    }

    public String getQty5() {
        return qty5;
    }

    public void setQty5(String qty5) {
        this.qty5 = qty5;
    }

    public String getSpecial1() {
        return special1;
    }

    public void setSpecial1(String special1) {
        this.special1 = special1;
    }

    public String getSpecial2() {
        return special2;
    }

    public void setSpecial2(String special2) {
        this.special2 = special2;
    }

    public String getSpecial3() {
        return special3;
    }

    public void setSpecial3(String special3) {
        this.special3 = special3;
    }

    public String getSpecial4() {
        return special4;
    }

    public void setSpecial4(String special4) {
        this.special4 = special4;
    }

    public String getSpecial5() {
        return special5;
    }

    public void setSpecial5(String special5) {
        this.special5 = special5;
    }

    public String getTradingRegion() {
        return tradingRegion;
    }

    public void setTradingRegion(String tradingRegion) {
        this.tradingRegion = tradingRegion;
    }

    public String getPrxSecno() {
        return prxSecno;
    }

    public void setPrxSecno(String prxSecno) {
        this.prxSecno = prxSecno;
    }

    public String getPrx() {
        return prx;
    }

    public void setPrx(String prx) {
        this.prx = prx;
    }

    public String getPrxCymd() {
        return prxCymd;
    }

    public void setPrxCymd(String prxCymd) {
        this.prxCymd = prxCymd;
    }

    public String getPrxInit() {
        return prxInit;
    }

    public void setPrxInit(String prxInit) {
        this.prxInit = prxInit;
    }

    public String getMePrx() {
        return mePrx;
    }

    public void setMePrx(String mePrx) {
        this.mePrx = mePrx;
    }

    public String getMePrxCymd() {
        return mePrxCymd;
    }

    public void setMePrxCymd(String mePrxCymd) {
        this.mePrxCymd = mePrxCymd;
    }

    public String getMePrxInit() {
        return mePrxInit;
    }

    public void setMePrxInit(String mePrxInit) {
        this.mePrxInit = mePrxInit;
    }

    public String getYePrx() {
        return yePrx;
    }

    public void setYePrx(String yePrx) {
        this.yePrx = yePrx;
    }

    public String getYePrxCymd() {
        return yePrxCymd;
    }

    public void setYePrxCymd(String yePrxCymd) {
        this.yePrxCymd = yePrxCymd;
    }

    public String getYePrxInit() {
        return yePrxInit;
    }

    public void setYePrxInit(String yePrxInit) {
        this.yePrxInit = yePrxInit;
    }

    public String getChgCymd() {
        return chgCymd;
    }

    public void setChgCymd(String chgCymd) {
        this.chgCymd = chgCymd;
    }

    public String getChgInit() {
        return chgInit;
    }

    public void setChgInit(String chgInit) {
        this.chgInit = chgInit;
    }

    public String getFundDealer() {
        return fundDealer;
    }

    public void setFundDealer(String fundDealer) {
        this.fundDealer = fundDealer;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMoneyAvailSw() {
        return moneyAvailSw;
    }

    public void setMoneyAvailSw(String moneyAvailSw) {
        this.moneyAvailSw = moneyAvailSw;
    }

    public String getTrfAgent() {
        return trfAgent;
    }

    public void setTrfAgent(String trfAgent) {
        this.trfAgent = trfAgent;
    }

    public String getTrfFee() {
        return trfFee;
    }

    public void setTrfFee(String trfFee) {
        this.trfFee = trfFee;
    }

    public String getTrfState() {
        return trfState;
    }

    public void setTrfState(String trfState) {
        this.trfState = trfState;
    }

    public String getManualTrf() {
        return manualTrf;
    }

    public void setManualTrf(String manualTrf) {
        this.manualTrf = manualTrf;
    }

    public String getNoLoan() {
        return noLoan;
    }

    public void setNoLoan(String noLoan) {
        this.noLoan = noLoan;
    }

    public String getNoAlloc() {
        return noAlloc;
    }

    public void setNoAlloc(String noAlloc) {
        this.noAlloc = noAlloc;
    }

    public String getMgnCode() {
        return mgnCode;
    }

    public void setMgnCode(String mgnCode) {
        this.mgnCode = mgnCode;
    }

    public String getNrm() {
        return nrm;
    }

    public void setNrm(String nrm) {
        this.nrm = nrm;
    }

    public String getAutoAppInd() {
        return autoAppInd;
    }

    public void setAutoAppInd(String autoAppInd) {
        this.autoAppInd = autoAppInd;
    }

    public String getNoTrades() {
        return noTrades;
    }

    public void setNoTrades(String noTrades) {
        this.noTrades = noTrades;
    }

    public String getSyndSymbol() {
        return syndSymbol;
    }

    public void setSyndSymbol(String syndSymbol) {
        this.syndSymbol = syndSymbol;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEstMaturityCymd() {
        return estMaturityCymd;
    }

    public void setEstMaturityCymd(String estMaturityCymd) {
        this.estMaturityCymd = estMaturityCymd;
    }

    public String getReorgAppInd() {
        return reorgAppInd;
    }

    public void setReorgAppInd(String reorgAppInd) {
        this.reorgAppInd = reorgAppInd;
    }

    public String getMarketMaker() {
        return marketMaker;
    }

    public void setMarketMaker(String marketMaker) {
        this.marketMaker = marketMaker;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getDirectorSw() {
        return directorSw;
    }

    public void setDirectorSw(String directorSw) {
        this.directorSw = directorSw;
    }

    public String getNoPrintMsrb() {
        return noPrintMsrb;
    }

    public void setNoPrintMsrb(String noPrintMsrb) {
        this.noPrintMsrb = noPrintMsrb;
    }

    public String getNoPrintYtm() {
        return noPrintYtm;
    }

    public void setNoPrintYtm(String noPrintYtm) {
        this.noPrintYtm = noPrintYtm;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getUserPrx() {
        return userPrx;
    }

    public void setUserPrx(String userPrx) {
        this.userPrx = userPrx;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMfLoc() {
        return mfLoc;
    }

    public void setMfLoc(String mfLoc) {
        this.mfLoc = mfLoc;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public String getFsCode() {
        return fsCode;
    }

    public void setFsCode(String fsCode) {
        this.fsCode = fsCode;
    }

    public String getMfboCode() {
        return mfboCode;
    }

    public void setMfboCode(String mfboCode) {
        this.mfboCode = mfboCode;
    }

    public String getCurYld() {
        return curYld;
    }

    public void setCurYld(String curYld) {
        this.curYld = curYld;
    }

    public String getCurYldCymd() {
        return curYldCymd;
    }

    public void setCurYldCymd(String curYldCymd) {
        this.curYldCymd = curYldCymd;
    }

    public String getEffectiveYld() {
        return effectiveYld;
    }

    public void setEffectiveYld(String effectiveYld) {
        this.effectiveYld = effectiveYld;
    }

    public String getEffectiveYldCymd() {
        return effectiveYldCymd;
    }

    public void setEffectiveYldCymd(String effectiveYldCymd) {
        this.effectiveYldCymd = effectiveYldCymd;
    }

    public String getCashDrOverride() {
        return cashDrOverride;
    }

    public void setCashDrOverride(String cashDrOverride) {
        this.cashDrOverride = cashDrOverride;
    }

    public String getDivReinv() {
        return divReinv;
    }

    public void setDivReinv(String divReinv) {
        this.divReinv = divReinv;
    }

    public String getCashFundAcct() {
        return cashFundAcct;
    }

    public void setCashFundAcct(String cashFundAcct) {
        this.cashFundAcct = cashFundAcct;
    }

    public String getCashLoc() {
        return cashLoc;
    }

    public void setCashLoc(String cashLoc) {
        this.cashLoc = cashLoc;
    }

    public String getReinvFundAcct() {
        return reinvFundAcct;
    }

    public void setReinvFundAcct(String reinvFundAcct) {
        this.reinvFundAcct = reinvFundAcct;
    }

    public String getReinvLoc() {
        return reinvLoc;
    }

    public void setReinvLoc(String reinvLoc) {
        this.reinvLoc = reinvLoc;
    }

    public String getSdivInd() {
        return sdivInd;
    }

    public void setSdivInd(String sdivInd) {
        this.sdivInd = sdivInd;
    }

    public String getBuildDivwsCymd() {
        return buildDivwsCymd;
    }

    public void setBuildDivwsCymd(String buildDivwsCymd) {
        this.buildDivwsCymd = buildDivwsCymd;
    }

    public String getReinAPrchSw() {
        return reinAPrchSw;
    }

    public void setReinAPrchSw(String reinAPrchSw) {
        this.reinAPrchSw = reinAPrchSw;
    }

    public String getLpLoc() {
        return lpLoc;
    }

    public void setLpLoc(String lpLoc) {
        this.lpLoc = lpLoc;
    }

    public String getNoFrac() {
        return noFrac;
    }

    public void setNoFrac(String noFrac) {
        this.noFrac = noFrac;
    }

    public String getRteCusip() {
        return rteCusip;
    }

    public void setRteCusip(String rteCusip) {
        this.rteCusip = rteCusip;
    }

    public String getNetLevel1() {
        return netLevel1;
    }

    public void setNetLevel1(String netLevel1) {
        this.netLevel1 = netLevel1;
    }

    public String getNetLevel2() {
        return netLevel2;
    }

    public void setNetLevel2(String netLevel2) {
        this.netLevel2 = netLevel2;
    }

    public String getNetLevel3() {
        return netLevel3;
    }

    public void setNetLevel3(String netLevel3) {
        this.netLevel3 = netLevel3;
    }

    public String getNetLevel4() {
        return netLevel4;
    }

    public void setNetLevel4(String netLevel4) {
        this.netLevel4 = netLevel4;
    }

    public String getXrefOldSecNo() {
        return xrefOldSecNo;
    }

    public void setXrefOldSecNo(String xrefOldSecNo) {
        this.xrefOldSecNo = xrefOldSecNo;
    }

    public String getXrefNewSecNo() {
        return xrefNewSecNo;
    }

    public void setXrefNewSecNo(String xrefNewSecNo) {
        this.xrefNewSecNo = xrefNewSecNo;
    }

    public String getBondSubtype() {
        return bondSubtype;
    }

    public void setBondSubtype(String bondSubtype) {
        this.bondSubtype = bondSubtype;
    }

    public String getFirstTradeCymd() {
        return firstTradeCymd;
    }

    public void setFirstTradeCymd(String firstTradeCymd) {
        this.firstTradeCymd = firstTradeCymd;
    }

    public String getPurchOnlySw() {
        return purchOnlySw;
    }

    public void setPurchOnlySw(String purchOnlySw) {
        this.purchOnlySw = purchOnlySw;
    }

    public String getIndGrp() {
        return indGrp;
    }

    public void setIndGrp(String indGrp) {
        this.indGrp = indGrp;
    }

    public String getLvl3RegOverride() {
        return lvl3RegOverride;
    }

    public void setLvl3RegOverride(String lvl3RegOverride) {
        this.lvl3RegOverride = lvl3RegOverride;
    }

    public String getResearchCode() {
        return researchCode;
    }

    public void setResearchCode(String researchCode) {
        this.researchCode = researchCode;
    }

    public String getNetOrGross() {
        return netOrGross;
    }

    public void setNetOrGross(String netOrGross) {
        this.netOrGross = netOrGross;
    }

    public String getSlsCredit() {
        return slsCredit;
    }

    public void setSlsCredit(String slsCredit) {
        this.slsCredit = slsCredit;
    }

    public String getVenderPrxReq() {
        return venderPrxReq;
    }

    public void setVenderPrxReq(String venderPrxReq) {
        this.venderPrxReq = venderPrxReq;
    }

    public String getSdCode() {
        return sdCode;
    }

    public void setSdCode(String sdCode) {
        this.sdCode = sdCode;
    }

    public String getIpo1stStlCymd() {
        return ipo1stStlCymd;
    }

    public void setIpo1stStlCymd(String ipo1stStlCymd) {
        this.ipo1stStlCymd = ipo1stStlCymd;
    }

    public String getIpoEndPnltCymd() {
        return ipoEndPnltCymd;
    }

    public void setIpoEndPnltCymd(String ipoEndPnltCymd) {
        this.ipoEndPnltCymd = ipoEndPnltCymd;
    }

    public String getQrIo() {
        return qrIo;
    }

    public void setQrIo(String qrIo) {
        this.qrIo = qrIo;
    }

    public String getAcctLvl3Override() {
        return acctLvl3Override;
    }

    public void setAcctLvl3Override(String acctLvl3Override) {
        this.acctLvl3Override = acctLvl3Override;
    }

    public String getMfiCode() {
        return mfiCode;
    }

    public void setMfiCode(String mfiCode) {
        this.mfiCode = mfiCode;
    }

    public String getOptPositionLimit() {
        return optPositionLimit;
    }

    public void setOptPositionLimit(String optPositionLimit) {
        this.optPositionLimit = optPositionLimit;
    }

    public String getMfCommSw() {
        return mfCommSw;
    }

    public void setMfCommSw(String mfCommSw) {
        this.mfCommSw = mfCommSw;
    }

    public String getNavrSw() {
        return navrSw;
    }

    public void setNavrSw(String navrSw) {
        this.navrSw = navrSw;
    }

    public String getRotationalRoute() {
        return rotationalRoute;
    }

    public void setRotationalRoute(String rotationalRoute) {
        this.rotationalRoute = rotationalRoute;
    }

    public String getEvd() {
        return evd;
    }

    public void setEvd(String evd) {
        this.evd = evd;
    }

    public String getEvs() {
        return evs;
    }

    public void setEvs(String evs) {
        this.evs = evs;
    }

    public String getEvm() {
        return evm;
    }

    public void setEvm(String evm) {
        this.evm = evm;
    }

    public String getMfNoProspectus() {
        return mfNoProspectus;
    }

    public void setMfNoProspectus(String mfNoProspectus) {
        this.mfNoProspectus = mfNoProspectus;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getNewSecType() {
        return newSecType;
    }

    public void setNewSecType(String newSecType) {
        this.newSecType = newSecType;
    }

    public String getDivChgCymd() {
        return divChgCymd;
    }

    public void setDivChgCymd(String divChgCymd) {
        this.divChgCymd = divChgCymd;
    }

    public String getDivChgInit() {
        return divChgInit;
    }

    public void setDivChgInit(String divChgInit) {
        this.divChgInit = divChgInit;
    }

    public String getEstAnnDiv() {
        return estAnnDiv;
    }

    public void setEstAnnDiv(String estAnnDiv) {
        this.estAnnDiv = estAnnDiv;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getGics() {
        return gics;
    }

    public void setGics(String gics) {
        this.gics = gics;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public String getOidType() {
        return oidType;
    }

    public void setOidType(String oidType) {
        this.oidType = oidType;
    }

    public String getTradingStatus() {
        return tradingStatus;
    }

    public void setTradingStatus(String tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

    public String getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(String unitSize) {
        this.unitSize = unitSize;
    }

    public String getUitWrapInd() {
        return uitWrapInd;
    }

    public void setUitWrapInd(String uitWrapInd) {
        this.uitWrapInd = uitWrapInd;
    }

    public String getWhenIssueDisCode() {
        return whenIssueDisCode;
    }

    public void setWhenIssueDisCode(String whenIssueDisCode) {
        this.whenIssueDisCode = whenIssueDisCode;
    }

    public String getActionOvrdText() {
        return actionOvrdText;
    }

    public void setActionOvrdText(String actionOvrdText) {
        this.actionOvrdText = actionOvrdText;
    }

    public String getActionOvrdText2() {
        return actionOvrdText2;
    }

    public void setActionOvrdText2(String actionOvrdText2) {
        this.actionOvrdText2 = actionOvrdText2;
    }

    public String getCorpactWhoCode() {
        return corpactWhoCode;
    }

    public void setCorpactWhoCode(String corpactWhoCode) {
        this.corpactWhoCode = corpactWhoCode;
    }

    public String getCorpactCymd() {
        return corpactCymd;
    }

    public void setCorpactCymd(String corpactCymd) {
        this.corpactCymd = corpactCymd;
    }

    public String getWhenIssuePrx() {
        return whenIssuePrx;
    }

    public void setWhenIssuePrx(String whenIssuePrx) {
        this.whenIssuePrx = whenIssuePrx;
    }

    public String getWhenIssueWhoCode() {
        return whenIssueWhoCode;
    }

    public void setWhenIssueWhoCode(String whenIssueWhoCode) {
        this.whenIssueWhoCode = whenIssueWhoCode;
    }

    public String getWhenIssueCymd() {
        return whenIssueCymd;
    }

    public void setWhenIssueCymd(String whenIssueCymd) {
        this.whenIssueCymd = whenIssueCymd;
    }

    public String getProspectusEndCymd() {
        return prospectusEndCymd;
    }

    public void setProspectusEndCymd(String prospectusEndCymd) {
        this.prospectusEndCymd = prospectusEndCymd;
    }

    public String getDivPayMmdd() {
        return divPayMmdd;
    }

    public void setDivPayMmdd(String divPayMmdd) {
        this.divPayMmdd = divPayMmdd;
    }

    public String getSplcDivPayMmdd() {
        return splcDivPayMmdd;
    }

    public void setSplcDivPayMmdd(String splcDivPayMmdd) {
        this.splcDivPayMmdd = splcDivPayMmdd;
    }

    public String getSplcDivFreqCode() {
        return splcDivFreqCode;
    }

    public void setSplcDivFreqCode(String splcDivFreqCode) {
        this.splcDivFreqCode = splcDivFreqCode;
    }

    public String getChangeTerm() {
        return changeTerm;
    }

    public void setChangeTerm(String changeTerm) {
        this.changeTerm = changeTerm;
    }

    public String getChangeSourceId() {
        return changeSourceId;
    }

    public void setChangeSourceId(String changeSourceId) {
        this.changeSourceId = changeSourceId;
    }

    public String getChangeSource() {
        return changeSource;
    }

    public void setChangeSource(String changeSource) {
        this.changeSource = changeSource;
    }

    public String getPfdSecCpnRate() {
        return pfdSecCpnRate;
    }

    public void setPfdSecCpnRate(String pfdSecCpnRate) {
        this.pfdSecCpnRate = pfdSecCpnRate;
    }

    public String getEffMatCymd() {
        return effMatCymd;
    }

    public void setEffMatCymd(String effMatCymd) {
        this.effMatCymd = effMatCymd;
    }

    public String getPropProdInd() {
        return propProdInd;
    }

    public void setPropProdInd(String propProdInd) {
        this.propProdInd = propProdInd;
    }

    public String getSellAgmtInd() {
        return sellAgmtInd;
    }

    public void setSellAgmtInd(String sellAgmtInd) {
        this.sellAgmtInd = sellAgmtInd;
    }

    public String getSecEx() {
        return secEx;
    }

    public void setSecEx(String secEx) {
        this.secEx = secEx;
    }

    public String getWrap() {
        return wrap;
    }

    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    public String getAcretAmortOvrdCd() {
        return acretAmortOvrdCd;
    }

    public void setAcretAmortOvrdCd(String acretAmortOvrdCd) {
        this.acretAmortOvrdCd = acretAmortOvrdCd;
    }

    public String getQualDivInd() {
        return qualDivInd;
    }

    public void setQualDivInd(String qualDivInd) {
        this.qualDivInd = qualDivInd;
    }

    public String getAccesDlvrOrvrInd() {
        return accesDlvrOrvrInd;
    }

    public void setAccesDlvrOrvrInd(String accesDlvrOrvrInd) {
        this.accesDlvrOrvrInd = accesDlvrOrvrInd;
    }

    public String getFirmProductCode() {
        return firmProductCode;
    }

    public void setFirmProductCode(String firmProductCode) {
        this.firmProductCode = firmProductCode;
    }

    public String getFracShrLiqInd() {
        return fracShrLiqInd;
    }

    public void setFracShrLiqInd(String fracShrLiqInd) {
        this.fracShrLiqInd = fracShrLiqInd;
    }

    public String getEuroCalInd() {
        return euroCalInd;
    }

    public void setEuroCalInd(String euroCalInd) {
        this.euroCalInd = euroCalInd;
    }

    public String getSubIssueOvrdCd() {
        return subIssueOvrdCd;
    }

    public void setSubIssueOvrdCd(String subIssueOvrdCd) {
        this.subIssueOvrdCd = subIssueOvrdCd;
    }

    public String getCpdOvrdInd() {
        return cpdOvrdInd;
    }

    public void setCpdOvrdInd(String cpdOvrdInd) {
        this.cpdOvrdInd = cpdOvrdInd;
    }

    public String getEtfAddlMarginPct() {
        return etfAddlMarginPct;
    }

    public void setEtfAddlMarginPct(String etfAddlMarginPct) {
        this.etfAddlMarginPct = etfAddlMarginPct;
    }

    public String getFirmSecGroupCd() {
        return firmSecGroupCd;
    }

    public void setFirmSecGroupCd(String firmSecGroupCd) {
        this.firmSecGroupCd = firmSecGroupCd;
    }

    public String getTaxlotOvrdCoverCymd() {
        return taxlotOvrdCoverCymd;
    }

    public void setTaxlotOvrdCoverCymd(String taxlotOvrdCoverCymd) {
        this.taxlotOvrdCoverCymd = taxlotOvrdCoverCymd;
    }

    public String getMutFundPostageInd() {
        return mutFundPostageInd;
    }

    public void setMutFundPostageInd(String mutFundPostageInd) {
        this.mutFundPostageInd = mutFundPostageInd;
    }

    public String getTrailStopInd() {
        return trailStopInd;
    }

    public void setTrailStopInd(String trailStopInd) {
        this.trailStopInd = trailStopInd;
    }

    public String getTrailStopWho() {
        return trailStopWho;
    }

    public void setTrailStopWho(String trailStopWho) {
        this.trailStopWho = trailStopWho;
    }

    public String getTrailStopCymd() {
        return trailStopCymd;
    }

    public void setTrailStopCymd(String trailStopCymd) {
        this.trailStopCymd = trailStopCymd;
    }

    public String getWave10Id() {
        return wave10Id;
    }

    public void setWave10Id(String wave10Id) {
        this.wave10Id = wave10Id;
    }

    public String getSettleDateOvrdCode() {
        return settleDateOvrdCode;
    }

    public void setSettleDateOvrdCode(String settleDateOvrdCode) {
        this.settleDateOvrdCode = settleDateOvrdCode;
    }

    public String getSchkInd() {
        return schkInd;
    }

    public void setSchkInd(String schkInd) {
        this.schkInd = schkInd;
    }

    public String getAipEligInd() {
        return aipEligInd;
    }

    public void setAipEligInd(String aipEligInd) {
        this.aipEligInd = aipEligInd;
    }

    public String getAvgcInd() {
        return avgcInd;
    }

    public void setAvgcInd(String avgcInd) {
        this.avgcInd = avgcInd;
    }

    public String getSensitiveCode() {
        return sensitiveCode;
    }

    public void setSensitiveCode(String sensitiveCode) {
        this.sensitiveCode = sensitiveCode;
    }

    public String getMgnOvrdCode() {
        return mgnOvrdCode;
    }

    public void setMgnOvrdCode(String mgnOvrdCode) {
        this.mgnOvrdCode = mgnOvrdCode;
    }

    public String getFatcaOvrdCode() {
        return fatcaOvrdCode;
    }

    public void setFatcaOvrdCode(String fatcaOvrdCode) {
        this.fatcaOvrdCode = fatcaOvrdCode;
    }

    public String getPrefAccruedInd() {
        return prefAccruedInd;
    }

    public void setPrefAccruedInd(String prefAccruedInd) {
        this.prefAccruedInd = prefAccruedInd;
    }

    public String getRevManRate() {
        return revManRate;
    }

    public void setRevManRate(String revManRate) {
        this.revManRate = revManRate;
    }
}
