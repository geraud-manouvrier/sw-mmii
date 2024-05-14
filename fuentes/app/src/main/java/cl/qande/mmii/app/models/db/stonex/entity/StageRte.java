package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_rte", schema = "stage_stonex")
public class StageRte {
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
    @Column(name = "sec_no", nullable = false, length = 100)
    private String secNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch1", nullable = false, length = 100)
    private String exch1;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty1", nullable = false, length = 100)
    private String qty1;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch2", nullable = false, length = 100)
    private String exch2;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty2", nullable = false, length = 100)
    private String qty2;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch3", nullable = false, length = 100)
    private String exch3;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty3", nullable = false, length = 100)
    private String qty3;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch4", nullable = false, length = 100)
    private String exch4;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty4", nullable = false, length = 100)
    private String qty4;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch5", nullable = false, length = 100)
    private String exch5;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty5", nullable = false, length = 100)
    private String qty5;

    @Size(max = 100)
    @NotNull
    @Column(name = "special1", nullable = false, length = 100)
    private String special1;

    @Size(max = 100)
    @NotNull
    @Column(name = "special2", nullable = false, length = 100)
    private String special2;

    @Size(max = 100)
    @NotNull
    @Column(name = "special3", nullable = false, length = 100)
    private String special3;

    @Size(max = 100)
    @NotNull
    @Column(name = "special4", nullable = false, length = 100)
    private String special4;

    @Size(max = 100)
    @NotNull
    @Column(name = "special5", nullable = false, length = 100)
    private String special5;

    @Size(max = 100)
    @NotNull
    @Column(name = "trading_region", nullable = false, length = 100)
    private String tradingRegion;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx_secno", nullable = false, length = 100)
    private String prxSecno;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx", nullable = false, length = 100)
    private String prx;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx_cymd", nullable = false, length = 100)
    private String prxCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx_init", nullable = false, length = 100)
    private String prxInit;

    @Size(max = 100)
    @NotNull
    @Column(name = "me_prx", nullable = false, length = 100)
    private String mePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "me_prx_cymd", nullable = false, length = 100)
    private String mePrxCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "me_prx_init", nullable = false, length = 100)
    private String mePrxInit;

    @Size(max = 100)
    @NotNull
    @Column(name = "ye_prx", nullable = false, length = 100)
    private String yePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "ye_prx_cymd", nullable = false, length = 100)
    private String yePrxCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "ye_prx_init", nullable = false, length = 100)
    private String yePrxInit;

    @Size(max = 100)
    @NotNull
    @Column(name = "chg_cymd", nullable = false, length = 100)
    private String chgCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "chg_init", nullable = false, length = 100)
    private String chgInit;

    @Size(max = 100)
    @NotNull
    @Column(name = "fund_dealer", nullable = false, length = 100)
    private String fundDealer;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid", nullable = false, length = 100)
    private String oid;

    @Size(max = 100)
    @NotNull
    @Column(name = "money_avail_sw", nullable = false, length = 100)
    private String moneyAvailSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "trf_agent", nullable = false, length = 100)
    private String trfAgent;

    @Size(max = 100)
    @NotNull
    @Column(name = "trf_fee", nullable = false, length = 100)
    private String trfFee;

    @Size(max = 100)
    @NotNull
    @Column(name = "trf_state", nullable = false, length = 100)
    private String trfState;

    @Size(max = 100)
    @NotNull
    @Column(name = "manual_trf", nullable = false, length = 100)
    private String manualTrf;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_loan", nullable = false, length = 100)
    private String noLoan;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_alloc", nullable = false, length = 100)
    private String noAlloc;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_code", nullable = false, length = 100)
    private String mgnCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "nrm", nullable = false, length = 100)
    private String nrm;

    @Size(max = 100)
    @NotNull
    @Column(name = "auto_app_ind", nullable = false, length = 100)
    private String autoAppInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_trades", nullable = false, length = 100)
    private String noTrades;

    @Size(max = 100)
    @NotNull
    @Column(name = "synd_symbol", nullable = false, length = 100)
    private String syndSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "note", nullable = false, length = 100)
    private String note;

    @Size(max = 100)
    @NotNull
    @Column(name = "est_maturity_cymd", nullable = false, length = 100)
    private String estMaturityCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "reorg_app_ind", nullable = false, length = 100)
    private String reorgAppInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "market_maker", nullable = false, length = 100)
    private String marketMaker;

    @Size(max = 100)
    @NotNull
    @Column(name = "specialist", nullable = false, length = 100)
    private String specialist;

    @Size(max = 100)
    @NotNull
    @Column(name = "director_sw", nullable = false, length = 100)
    private String directorSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_print_msrb", nullable = false, length = 100)
    private String noPrintMsrb;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_print_ytm", nullable = false, length = 100)
    private String noPrintYtm;

    @Size(max = 100)
    @NotNull
    @Column(name = "controller", nullable = false, length = 100)
    private String controller;

    @Size(max = 100)
    @NotNull
    @Column(name = "user_prx", nullable = false, length = 100)
    private String userPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "product_code", nullable = false, length = 100)
    private String productCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mf_loc", nullable = false, length = 100)
    private String mfLoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "box_type", nullable = false, length = 100)
    private String boxType;

    @Size(max = 100)
    @NotNull
    @Column(name = "fs_code", nullable = false, length = 100)
    private String fsCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mfbo_code", nullable = false, length = 100)
    private String mfboCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_yld", nullable = false, length = 100)
    private String curYld;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_yld_cymd", nullable = false, length = 100)
    private String curYldCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "effective_yld", nullable = false, length = 100)
    private String effectiveYld;

    @Size(max = 100)
    @NotNull
    @Column(name = "effective_yld_cymd", nullable = false, length = 100)
    private String effectiveYldCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_dr_override", nullable = false, length = 100)
    private String cashDrOverride;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_reinv", nullable = false, length = 100)
    private String divReinv;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_fund_acct", nullable = false, length = 100)
    private String cashFundAcct;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_loc", nullable = false, length = 100)
    private String cashLoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinv_fund_acct", nullable = false, length = 100)
    private String reinvFundAcct;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinv_loc", nullable = false, length = 100)
    private String reinvLoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "sdiv_ind", nullable = false, length = 100)
    private String sdivInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "build_divws_cymd", nullable = false, length = 100)
    private String buildDivwsCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "rein_a_prch_sw", nullable = false, length = 100)
    private String reinAPrchSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "lp_loc", nullable = false, length = 100)
    private String lpLoc;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_frac", nullable = false, length = 100)
    private String noFrac;

    @Size(max = 100)
    @NotNull
    @Column(name = "rte_cusip", nullable = false, length = 100)
    private String rteCusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_level1", nullable = false, length = 100)
    private String netLevel1;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_level2", nullable = false, length = 100)
    private String netLevel2;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_level3", nullable = false, length = 100)
    private String netLevel3;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_level4", nullable = false, length = 100)
    private String netLevel4;

    @Size(max = 100)
    @NotNull
    @Column(name = "xref_old_sec_no", nullable = false, length = 100)
    private String xrefOldSecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "xref_new_sec_no", nullable = false, length = 100)
    private String xrefNewSecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_subtype", nullable = false, length = 100)
    private String bondSubtype;

    @Size(max = 100)
    @NotNull
    @Column(name = "first_trade_cymd", nullable = false, length = 100)
    private String firstTradeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "purch_only_sw", nullable = false, length = 100)
    private String purchOnlySw;

    @Size(max = 100)
    @NotNull
    @Column(name = "ind_grp", nullable = false, length = 100)
    private String indGrp;

    @Size(max = 100)
    @NotNull
    @Column(name = "lvl3_reg_override", nullable = false, length = 100)
    private String lvl3RegOverride;

    @Size(max = 100)
    @NotNull
    @Column(name = "research_code", nullable = false, length = 100)
    private String researchCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_or_gross", nullable = false, length = 100)
    private String netOrGross;

    @Size(max = 100)
    @NotNull
    @Column(name = "sls_credit", nullable = false, length = 100)
    private String slsCredit;

    @Size(max = 100)
    @NotNull
    @Column(name = "vender_prx_req", nullable = false, length = 100)
    private String venderPrxReq;

    @Size(max = 100)
    @NotNull
    @Column(name = "sd_code", nullable = false, length = 100)
    private String sdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ipo_1st_stl_cymd", nullable = false, length = 100)
    private String ipo1stStlCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "ipo_end_pnlt_cymd", nullable = false, length = 100)
    private String ipoEndPnltCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "qr_io", nullable = false, length = 100)
    private String qrIo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_lvl3_override", nullable = false, length = 100)
    private String acctLvl3Override;

    @Size(max = 100)
    @NotNull
    @Column(name = "mfi_code", nullable = false, length = 100)
    private String mfiCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_position_limit", nullable = false, length = 100)
    private String optPositionLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "mf_comm_sw", nullable = false, length = 100)
    private String mfCommSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "navr_sw", nullable = false, length = 100)
    private String navrSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "rotational_route", nullable = false, length = 100)
    private String rotationalRoute;

    @Size(max = 100)
    @NotNull
    @Column(name = "evd", nullable = false, length = 100)
    private String evd;

    @Size(max = 100)
    @NotNull
    @Column(name = "evs", nullable = false, length = 100)
    private String evs;

    @Size(max = 100)
    @NotNull
    @Column(name = "evm", nullable = false, length = 100)
    private String evm;

    @Size(max = 100)
    @NotNull
    @Column(name = "mf_no_prospectus", nullable = false, length = 100)
    private String mfNoProspectus;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_type", nullable = false, length = 100)
    private String secType;

    @Size(max = 100)
    @NotNull
    @Column(name = "new_sec_type", nullable = false, length = 100)
    private String newSecType;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_chg_cymd", nullable = false, length = 100)
    private String divChgCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_chg_init", nullable = false, length = 100)
    private String divChgInit;

    @Size(max = 100)
    @NotNull
    @Column(name = "est_ann_div", nullable = false, length = 100)
    private String estAnnDiv;

    @Size(max = 100)
    @NotNull
    @Column(name = "features", nullable = false, length = 100)
    private String features;

    @Size(max = 100)
    @NotNull
    @Column(name = "gics", nullable = false, length = 100)
    private String gics;

    @Size(max = 100)
    @NotNull
    @Column(name = "naics", nullable = false, length = 100)
    private String naics;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid_type", nullable = false, length = 100)
    private String oidType;

    @Size(max = 100)
    @NotNull
    @Column(name = "trading_status", nullable = false, length = 100)
    private String tradingStatus;

    @Size(max = 100)
    @NotNull
    @Column(name = "unit_size", nullable = false, length = 100)
    private String unitSize;

    @Size(max = 100)
    @NotNull
    @Column(name = "uit_wrap_ind", nullable = false, length = 100)
    private String uitWrapInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "when_issue_dis_code", nullable = false, length = 100)
    private String whenIssueDisCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "action_ovrd_text", nullable = false, length = 100)
    private String actionOvrdText;

    @Size(max = 100)
    @NotNull
    @Column(name = "action_ovrd_text_2", nullable = false, length = 100)
    private String actionOvrdText2;

    @Size(max = 100)
    @NotNull
    @Column(name = "corpact_who_code", nullable = false, length = 100)
    private String corpactWhoCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "corpact_cymd", nullable = false, length = 100)
    private String corpactCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "when_issue_prx", nullable = false, length = 100)
    private String whenIssuePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "when_issue_who_code", nullable = false, length = 100)
    private String whenIssueWhoCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "when_issue_cymd", nullable = false, length = 100)
    private String whenIssueCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prospectus_end_cymd", nullable = false, length = 100)
    private String prospectusEndCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_pay_mmdd", nullable = false, length = 100)
    private String divPayMmdd;

    @Size(max = 100)
    @NotNull
    @Column(name = "splc_div_pay_mmdd", nullable = false, length = 100)
    private String splcDivPayMmdd;

    @Size(max = 100)
    @NotNull
    @Column(name = "splc_div_freq_code", nullable = false, length = 100)
    private String splcDivFreqCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_term", nullable = false, length = 100)
    private String changeTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_source_id", nullable = false, length = 100)
    private String changeSourceId;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_source", nullable = false, length = 100)
    private String changeSource;

    @Size(max = 100)
    @NotNull
    @Column(name = "pfd_sec_cpn_rate", nullable = false, length = 100)
    private String pfdSecCpnRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "eff_mat_cymd", nullable = false, length = 100)
    private String effMatCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prop_prod_ind", nullable = false, length = 100)
    private String propProdInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sell_agmt_ind", nullable = false, length = 100)
    private String sellAgmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_ex", nullable = false, length = 100)
    private String secEx;

    @Size(max = 100)
    @NotNull
    @Column(name = "wrap", nullable = false, length = 100)
    private String wrap;

    @Size(max = 100)
    @NotNull
    @Column(name = "acret_amort_ovrd_cd", nullable = false, length = 100)
    private String acretAmortOvrdCd;

    @Size(max = 100)
    @NotNull
    @Column(name = "qual_div_ind", nullable = false, length = 100)
    private String qualDivInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "acces_dlvr_orvr_ind", nullable = false, length = 100)
    private String accesDlvrOrvrInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_product_code", nullable = false, length = 100)
    private String firmProductCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "frac_shr_liq_ind", nullable = false, length = 100)
    private String fracShrLiqInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "euro_cal_ind", nullable = false, length = 100)
    private String euroCalInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_issue_ovrd_cd", nullable = false, length = 100)
    private String subIssueOvrdCd;

    @Size(max = 100)
    @NotNull
    @Column(name = "cpd_ovrd_ind", nullable = false, length = 100)
    private String cpdOvrdInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "etf_addl_margin_pct", nullable = false, length = 100)
    private String etfAddlMarginPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_sec_group_cd", nullable = false, length = 100)
    private String firmSecGroupCd;

    @Size(max = 100)
    @NotNull
    @Column(name = "taxlot_ovrd_cover_cymd", nullable = false, length = 100)
    private String taxlotOvrdCoverCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mut_fund_postage_ind", nullable = false, length = 100)
    private String mutFundPostageInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trail_stop_ind", nullable = false, length = 100)
    private String trailStopInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trail_stop_who", nullable = false, length = 100)
    private String trailStopWho;

    @Size(max = 100)
    @NotNull
    @Column(name = "trail_stop_cymd", nullable = false, length = 100)
    private String trailStopCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "wave_10_id", nullable = false, length = 100)
    private String wave10Id;

    @Size(max = 100)
    @NotNull
    @Column(name = "settle_date_ovrd_code", nullable = false, length = 100)
    private String settleDateOvrdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "schk_ind", nullable = false, length = 100)
    private String schkInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "aip_elig_ind", nullable = false, length = 100)
    private String aipEligInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "avgc_ind", nullable = false, length = 100)
    private String avgcInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sensitive_code", nullable = false, length = 100)
    private String sensitiveCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_ovrd_code", nullable = false, length = 100)
    private String mgnOvrdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "fatca_ovrd_code", nullable = false, length = 100)
    private String fatcaOvrdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "pref_accrued_ind", nullable = false, length = 100)
    private String prefAccruedInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "rev_man_rate", nullable = false, length = 100)
    private String revManRate;

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