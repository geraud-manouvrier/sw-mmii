package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_sec_osi", schema = "stage_stonex")
public class StageSecOsi {
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
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "alpha_key", nullable = false, length = 100)
    private String alphaKey;

    @Size(max = 100)
    @NotNull
    @Column(name = "alpha_key_2", nullable = false, length = 100)
    private String alphaKey2;

    @Size(max = 100)
    @NotNull
    @Column(name = "alpha_key_5", nullable = false, length = 100)
    private String alphaKey5;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_1", nullable = false, length = 100)
    private String desc1;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_2", nullable = false, length = 100)
    private String desc2;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_3", nullable = false, length = 100)
    private String desc3;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_type", nullable = false, length = 100)
    private String secType;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_close_prx", nullable = false, length = 100)
    private String lastClosePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx_change_cymd", nullable = false, length = 100)
    private String prxChangeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prx_change_term", nullable = false, length = 100)
    private String prxChangeTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "month_end_prx", nullable = false, length = 100)
    private String monthEndPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "month_end_prx_cymd", nullable = false, length = 100)
    private String monthEndPrxCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "month_end_term", nullable = false, length = 100)
    private String monthEndTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "year_end_prx", nullable = false, length = 100)
    private String yearEndPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "year_end_cymd", nullable = false, length = 100)
    private String yearEndCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "eoy_prx_term", nullable = false, length = 100)
    private String eoyPrxTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_change_cymd", nullable = false, length = 100)
    private String descChangeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_term", nullable = false, length = 100)
    private String changeTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_cymd", nullable = false, length = 100)
    private String addCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_term", nullable = false, length = 100)
    private String addTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_cusip_ind", nullable = false, length = 100)
    private String noCusipInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "exp_symbol_desc", nullable = false, length = 100)
    private String expSymbolDesc;

    @Size(max = 100)
    @NotNull
    @Column(name = "min_prx_var_code", nullable = false, length = 100)
    private String minPrxVarCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "annual_div_rate", nullable = false, length = 100)
    private String annualDivRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "drs_elig_code", nullable = false, length = 100)
    private String drsEligCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "day_count_code", nullable = false, length = 100)
    private String dayCountCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "catchup_ind", nullable = false, length = 100)
    private String catchupInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "arb_conv_factor", nullable = false, length = 100)
    private String arbConvFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "industry_grp_no", nullable = false, length = 100)
    private String industryGrpNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "round_lot_qty", nullable = false, length = 100)
    private String roundLotQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "oats_otc_exch_code", nullable = false, length = 100)
    private String oatsOtcExchCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "earnings_per_shr_amt", nullable = false, length = 100)
    private String earningsPerShrAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_note", nullable = false, length = 100)
    private String secNote;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_note_2", nullable = false, length = 100)
    private String secNote2;

    @Size(max = 100)
    @NotNull
    @Column(name = "muller_cymd", nullable = false, length = 100)
    private String mullerCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "muller_qty", nullable = false, length = 100)
    private String mullerQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "non_listed_code", nullable = false, length = 100)
    private String nonListedCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "fed_tax_code", nullable = false, length = 100)
    private String fedTaxCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_factor", nullable = false, length = 100)
    private String bondFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "sandp_code", nullable = false, length = 100)
    private String sandpCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "call_bonds_code", nullable = false, length = 100)
    private String callBondsCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "day_calc_code", nullable = false, length = 100)
    private String dayCalcCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_type_code", nullable = false, length = 100)
    private String bondTypeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "feature_cymd", nullable = false, length = 100)
    private String featureCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "feature_prx", nullable = false, length = 100)
    private String featurePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "feature_cymd_2", nullable = false, length = 100)
    private String featureCymd2;

    @Size(max = 100)
    @NotNull
    @Column(name = "feature_prx_2", nullable = false, length = 100)
    private String featurePrx2;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_cymd", nullable = false, length = 100)
    private String putCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "pref_cymd", nullable = false, length = 100)
    private String prefCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_prx", nullable = false, length = 100)
    private String putPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "prerefund_prx", nullable = false, length = 100)
    private String prerefundPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "state_code", nullable = false, length = 100)
    private String stateCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "int_pmt_cymd", nullable = false, length = 100)
    private String intPmtCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "maturity_exp_cymd", nullable = false, length = 100)
    private String maturityExpCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "coupon_rate", nullable = false, length = 100)
    private String couponRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "first_cpn_cymd", nullable = false, length = 100)
    private String firstCpnCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "int_accrual_cymd", nullable = false, length = 100)
    private String intAccrualCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "kis_ind", nullable = false, length = 100)
    private String kisInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "kis_cymd", nullable = false, length = 100)
    private String kisCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prc_cymd", nullable = false, length = 100)
    private String prcCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "frc_cymd", nullable = false, length = 100)
    private String frcCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "factor_cymd", nullable = false, length = 100)
    private String factorCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "current_factor", nullable = false, length = 100)
    private String currentFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "prev_factor", nullable = false, length = 100)
    private String prevFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "issue_disc_code", nullable = false, length = 100)
    private String issueDiscCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_notify_days", nullable = false, length = 100)
    private String putNotifyDays;

    @Size(max = 100)
    @NotNull
    @Column(name = "skip_kenny_ind", nullable = false, length = 100)
    private String skipKennyInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "year_end_rpt_code", nullable = false, length = 100)
    private String yearEndRptCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "cmo_agent_code", nullable = false, length = 100)
    private String cmoAgentCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_sub_code", nullable = false, length = 100)
    private String bondSubCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "specific_pool_code", nullable = false, length = 100)
    private String specificPoolCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "rann_upd_src_ind", nullable = false, length = 100)
    private String rannUpdSrcInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "rann_upd_cymd", nullable = false, length = 100)
    private String rannUpdCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_fri_me_cymd", nullable = false, length = 100)
    private String lastFriMeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_fri_me_prx", nullable = false, length = 100)
    private String lastFriMePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "ipo_prx", nullable = false, length = 100)
    private String ipoPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_qual_ind", nullable = false, length = 100)
    private String taxQualInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "foreign_sedol_no", nullable = false, length = 100)
    private String foreignSedolNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "type_class_code", nullable = false, length = 100)
    private String typeClassCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "uit_accrued_amt", nullable = false, length = 100)
    private String uitAccruedAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "expire_cymd", nullable = false, length = 100)
    private String expireCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_code", nullable = false, length = 100)
    private String optnCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "underlying_sec_no", nullable = false, length = 100)
    private String underlyingSecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "strike_prx", nullable = false, length = 100)
    private String strikePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "whole_conv_factor", nullable = false, length = 100)
    private String wholeConvFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "dec_conv_factor", nullable = false, length = 100)
    private String decConvFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "underlying_opt_sec_no", nullable = false, length = 100)
    private String underlyingOptSecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cap_interval_no", nullable = false, length = 100)
    private String capIntervalNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_frac_cusip", nullable = false, length = 100)
    private String dtcFracCusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "ccs_code", nullable = false, length = 100)
    private String ccsCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ncc_code", nullable = false, length = 100)
    private String nccCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "hand_fig_ind", nullable = false, length = 100)
    private String handFigInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "flat_code", nullable = false, length = 100)
    private String flatCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_pay_freq_code", nullable = false, length = 100)
    private String divPayFreqCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "rgst_code", nullable = false, length = 100)
    private String rgstCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_deposit_ind", nullable = false, length = 100)
    private String dtcChillDepositInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_ind", nullable = false, length = 100)
    private String dtcChillInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_wt_ind", nullable = false, length = 100)
    private String dtcChillWtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_do_ind", nullable = false, length = 100)
    private String dtcChillDoInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_pledge_ind", nullable = false, length = 100)
    private String dtcChillPledgeInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_chill_seg_ind", nullable = false, length = 100)
    private String dtcChillSegInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_frozen_ind", nullable = false, length = 100)
    private String dtcFrozenInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "foreign_code", nullable = false, length = 100)
    private String foreignCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mstr_limit_partner_ind", nullable = false, length = 100)
    private String mstrLimitPartnerInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "nra_exempt_ind", nullable = false, length = 100)
    private String nraExemptInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_fed_fund_ind", nullable = false, length = 100)
    private String dtcFedFundInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "margin_code", nullable = false, length = 100)
    private String marginCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "pros_end_cymd", nullable = false, length = 100)
    private String prosEndCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "unit_qty", nullable = false, length = 100)
    private String unitQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "mbscc_code", nullable = false, length = 100)
    private String mbsccCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinvest_elig_ind", nullable = false, length = 100)
    private String reinvestEligInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bid_prx", nullable = false, length = 100)
    private String bidPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "ask_prx", nullable = false, length = 100)
    private String askPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_code", nullable = false, length = 100)
    private String crncyCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_type", nullable = false, length = 100)
    private String crncyType;

    @Size(max = 100)
    @NotNull
    @Column(name = "euroclr_id", nullable = false, length = 100)
    private String euroclrId;

    @Size(max = 100)
    @NotNull
    @Column(name = "reissue_cymd", nullable = false, length = 100)
    private String reissueCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_div_rate", nullable = false, length = 100)
    private String lastDivRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_div_cymd", nullable = false, length = 100)
    private String lastDivCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_payments_qty", nullable = false, length = 100)
    private String divPaymentsQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_sec_no", nullable = false, length = 100)
    private String crncySecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "country_code", nullable = false, length = 100)
    private String countryCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "defered_sales_ind", nullable = false, length = 100)
    private String deferedSalesInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "gov_proc_code", nullable = false, length = 100)
    private String govProcCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "build_bond_ind", nullable = false, length = 100)
    private String buildBondInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "fund_code", nullable = false, length = 100)
    private String fundCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "moodys_code", nullable = false, length = 100)
    private String moodysCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mf_share_class_id", nullable = false, length = 100)
    private String mfShareClassId;

    @Size(max = 100)
    @NotNull
    @Column(name = "variable_rate", nullable = false, length = 100)
    private String variableRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "new_sec_code", nullable = false, length = 100)
    private String newSecCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "sort_group_code", nullable = false, length = 100)
    private String sortGroupCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "sort_alpha_key", nullable = false, length = 100)
    private String sortAlphaKey;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_reg_code", nullable = false, length = 100)
    private String bondRegCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "call_frequency_code", nullable = false, length = 100)
    private String callFrequencyCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "escrow_code", nullable = false, length = 100)
    private String escrowCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "insured_status_code", nullable = false, length = 100)
    private String insuredStatusCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "int_payment_code", nullable = false, length = 100)
    private String intPaymentCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "partial_redeem_code", nullable = false, length = 100)
    private String partialRedeemCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_frequency_code", nullable = false, length = 100)
    private String putFrequencyCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "adjustable_rate_code", nullable = false, length = 100)
    private String adjustableRateCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "conv_factor_code", nullable = false, length = 100)
    private String convFactorCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "zero_coupon_code", nullable = false, length = 100)
    private String zeroCouponCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "guarantee_code", nullable = false, length = 100)
    private String guaranteeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ny_post_no", nullable = false, length = 100)
    private String nyPostNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "non_transfer_ind", nullable = false, length = 100)
    private String nonTransferInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_or_call_ind", nullable = false, length = 100)
    private String putOrCallInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "osi_ul_symbol", nullable = false, length = 100)
    private String osiUlSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "expiration_cymd", nullable = false, length = 100)
    private String expirationCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "strike_prx_exp", nullable = false, length = 100)
    private String strikePrxExp;

    @Size(max = 100)
    @NotNull
    @Column(name = "taxlot_cover_cymd", nullable = false, length = 100)
    private String taxlotCoverCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "des2_change_term", nullable = false, length = 100)
    private String des2ChangeTerm;

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

    public String getAlphaKey() {
        return alphaKey;
    }

    public void setAlphaKey(String alphaKey) {
        this.alphaKey = alphaKey;
    }

    public String getAlphaKey2() {
        return alphaKey2;
    }

    public void setAlphaKey2(String alphaKey2) {
        this.alphaKey2 = alphaKey2;
    }

    public String getAlphaKey5() {
        return alphaKey5;
    }

    public void setAlphaKey5(String alphaKey5) {
        this.alphaKey5 = alphaKey5;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getLastClosePrx() {
        return lastClosePrx;
    }

    public void setLastClosePrx(String lastClosePrx) {
        this.lastClosePrx = lastClosePrx;
    }

    public String getPrxChangeCymd() {
        return prxChangeCymd;
    }

    public void setPrxChangeCymd(String prxChangeCymd) {
        this.prxChangeCymd = prxChangeCymd;
    }

    public String getPrxChangeTerm() {
        return prxChangeTerm;
    }

    public void setPrxChangeTerm(String prxChangeTerm) {
        this.prxChangeTerm = prxChangeTerm;
    }

    public String getMonthEndPrx() {
        return monthEndPrx;
    }

    public void setMonthEndPrx(String monthEndPrx) {
        this.monthEndPrx = monthEndPrx;
    }

    public String getMonthEndPrxCymd() {
        return monthEndPrxCymd;
    }

    public void setMonthEndPrxCymd(String monthEndPrxCymd) {
        this.monthEndPrxCymd = monthEndPrxCymd;
    }

    public String getMonthEndTerm() {
        return monthEndTerm;
    }

    public void setMonthEndTerm(String monthEndTerm) {
        this.monthEndTerm = monthEndTerm;
    }

    public String getYearEndPrx() {
        return yearEndPrx;
    }

    public void setYearEndPrx(String yearEndPrx) {
        this.yearEndPrx = yearEndPrx;
    }

    public String getYearEndCymd() {
        return yearEndCymd;
    }

    public void setYearEndCymd(String yearEndCymd) {
        this.yearEndCymd = yearEndCymd;
    }

    public String getEoyPrxTerm() {
        return eoyPrxTerm;
    }

    public void setEoyPrxTerm(String eoyPrxTerm) {
        this.eoyPrxTerm = eoyPrxTerm;
    }

    public String getDescChangeCymd() {
        return descChangeCymd;
    }

    public void setDescChangeCymd(String descChangeCymd) {
        this.descChangeCymd = descChangeCymd;
    }

    public String getChangeTerm() {
        return changeTerm;
    }

    public void setChangeTerm(String changeTerm) {
        this.changeTerm = changeTerm;
    }

    public String getAddCymd() {
        return addCymd;
    }

    public void setAddCymd(String addCymd) {
        this.addCymd = addCymd;
    }

    public String getAddTerm() {
        return addTerm;
    }

    public void setAddTerm(String addTerm) {
        this.addTerm = addTerm;
    }

    public String getNoCusipInd() {
        return noCusipInd;
    }

    public void setNoCusipInd(String noCusipInd) {
        this.noCusipInd = noCusipInd;
    }

    public String getExpSymbolDesc() {
        return expSymbolDesc;
    }

    public void setExpSymbolDesc(String expSymbolDesc) {
        this.expSymbolDesc = expSymbolDesc;
    }

    public String getMinPrxVarCode() {
        return minPrxVarCode;
    }

    public void setMinPrxVarCode(String minPrxVarCode) {
        this.minPrxVarCode = minPrxVarCode;
    }

    public String getAnnualDivRate() {
        return annualDivRate;
    }

    public void setAnnualDivRate(String annualDivRate) {
        this.annualDivRate = annualDivRate;
    }

    public String getDrsEligCode() {
        return drsEligCode;
    }

    public void setDrsEligCode(String drsEligCode) {
        this.drsEligCode = drsEligCode;
    }

    public String getDayCountCode() {
        return dayCountCode;
    }

    public void setDayCountCode(String dayCountCode) {
        this.dayCountCode = dayCountCode;
    }

    public String getCatchupInd() {
        return catchupInd;
    }

    public void setCatchupInd(String catchupInd) {
        this.catchupInd = catchupInd;
    }

    public String getArbConvFactor() {
        return arbConvFactor;
    }

    public void setArbConvFactor(String arbConvFactor) {
        this.arbConvFactor = arbConvFactor;
    }

    public String getIndustryGrpNo() {
        return industryGrpNo;
    }

    public void setIndustryGrpNo(String industryGrpNo) {
        this.industryGrpNo = industryGrpNo;
    }

    public String getRoundLotQty() {
        return roundLotQty;
    }

    public void setRoundLotQty(String roundLotQty) {
        this.roundLotQty = roundLotQty;
    }

    public String getOatsOtcExchCode() {
        return oatsOtcExchCode;
    }

    public void setOatsOtcExchCode(String oatsOtcExchCode) {
        this.oatsOtcExchCode = oatsOtcExchCode;
    }

    public String getEarningsPerShrAmt() {
        return earningsPerShrAmt;
    }

    public void setEarningsPerShrAmt(String earningsPerShrAmt) {
        this.earningsPerShrAmt = earningsPerShrAmt;
    }

    public String getSecNote() {
        return secNote;
    }

    public void setSecNote(String secNote) {
        this.secNote = secNote;
    }

    public String getSecNote2() {
        return secNote2;
    }

    public void setSecNote2(String secNote2) {
        this.secNote2 = secNote2;
    }

    public String getMullerCymd() {
        return mullerCymd;
    }

    public void setMullerCymd(String mullerCymd) {
        this.mullerCymd = mullerCymd;
    }

    public String getMullerQty() {
        return mullerQty;
    }

    public void setMullerQty(String mullerQty) {
        this.mullerQty = mullerQty;
    }

    public String getNonListedCode() {
        return nonListedCode;
    }

    public void setNonListedCode(String nonListedCode) {
        this.nonListedCode = nonListedCode;
    }

    public String getFedTaxCode() {
        return fedTaxCode;
    }

    public void setFedTaxCode(String fedTaxCode) {
        this.fedTaxCode = fedTaxCode;
    }

    public String getBondFactor() {
        return bondFactor;
    }

    public void setBondFactor(String bondFactor) {
        this.bondFactor = bondFactor;
    }

    public String getSandpCode() {
        return sandpCode;
    }

    public void setSandpCode(String sandpCode) {
        this.sandpCode = sandpCode;
    }

    public String getCallBondsCode() {
        return callBondsCode;
    }

    public void setCallBondsCode(String callBondsCode) {
        this.callBondsCode = callBondsCode;
    }

    public String getDayCalcCode() {
        return dayCalcCode;
    }

    public void setDayCalcCode(String dayCalcCode) {
        this.dayCalcCode = dayCalcCode;
    }

    public String getBondTypeCode() {
        return bondTypeCode;
    }

    public void setBondTypeCode(String bondTypeCode) {
        this.bondTypeCode = bondTypeCode;
    }

    public String getFeatureCymd() {
        return featureCymd;
    }

    public void setFeatureCymd(String featureCymd) {
        this.featureCymd = featureCymd;
    }

    public String getFeaturePrx() {
        return featurePrx;
    }

    public void setFeaturePrx(String featurePrx) {
        this.featurePrx = featurePrx;
    }

    public String getFeatureCymd2() {
        return featureCymd2;
    }

    public void setFeatureCymd2(String featureCymd2) {
        this.featureCymd2 = featureCymd2;
    }

    public String getFeaturePrx2() {
        return featurePrx2;
    }

    public void setFeaturePrx2(String featurePrx2) {
        this.featurePrx2 = featurePrx2;
    }

    public String getPutCymd() {
        return putCymd;
    }

    public void setPutCymd(String putCymd) {
        this.putCymd = putCymd;
    }

    public String getPrefCymd() {
        return prefCymd;
    }

    public void setPrefCymd(String prefCymd) {
        this.prefCymd = prefCymd;
    }

    public String getPutPrx() {
        return putPrx;
    }

    public void setPutPrx(String putPrx) {
        this.putPrx = putPrx;
    }

    public String getPrerefundPrx() {
        return prerefundPrx;
    }

    public void setPrerefundPrx(String prerefundPrx) {
        this.prerefundPrx = prerefundPrx;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getIntPmtCymd() {
        return intPmtCymd;
    }

    public void setIntPmtCymd(String intPmtCymd) {
        this.intPmtCymd = intPmtCymd;
    }

    public String getMaturityExpCymd() {
        return maturityExpCymd;
    }

    public void setMaturityExpCymd(String maturityExpCymd) {
        this.maturityExpCymd = maturityExpCymd;
    }

    public String getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(String couponRate) {
        this.couponRate = couponRate;
    }

    public String getFirstCpnCymd() {
        return firstCpnCymd;
    }

    public void setFirstCpnCymd(String firstCpnCymd) {
        this.firstCpnCymd = firstCpnCymd;
    }

    public String getIntAccrualCymd() {
        return intAccrualCymd;
    }

    public void setIntAccrualCymd(String intAccrualCymd) {
        this.intAccrualCymd = intAccrualCymd;
    }

    public String getKisInd() {
        return kisInd;
    }

    public void setKisInd(String kisInd) {
        this.kisInd = kisInd;
    }

    public String getKisCymd() {
        return kisCymd;
    }

    public void setKisCymd(String kisCymd) {
        this.kisCymd = kisCymd;
    }

    public String getPrcCymd() {
        return prcCymd;
    }

    public void setPrcCymd(String prcCymd) {
        this.prcCymd = prcCymd;
    }

    public String getFrcCymd() {
        return frcCymd;
    }

    public void setFrcCymd(String frcCymd) {
        this.frcCymd = frcCymd;
    }

    public String getFactorCymd() {
        return factorCymd;
    }

    public void setFactorCymd(String factorCymd) {
        this.factorCymd = factorCymd;
    }

    public String getCurrentFactor() {
        return currentFactor;
    }

    public void setCurrentFactor(String currentFactor) {
        this.currentFactor = currentFactor;
    }

    public String getPrevFactor() {
        return prevFactor;
    }

    public void setPrevFactor(String prevFactor) {
        this.prevFactor = prevFactor;
    }

    public String getIssueDiscCode() {
        return issueDiscCode;
    }

    public void setIssueDiscCode(String issueDiscCode) {
        this.issueDiscCode = issueDiscCode;
    }

    public String getPutNotifyDays() {
        return putNotifyDays;
    }

    public void setPutNotifyDays(String putNotifyDays) {
        this.putNotifyDays = putNotifyDays;
    }

    public String getSkipKennyInd() {
        return skipKennyInd;
    }

    public void setSkipKennyInd(String skipKennyInd) {
        this.skipKennyInd = skipKennyInd;
    }

    public String getYearEndRptCode() {
        return yearEndRptCode;
    }

    public void setYearEndRptCode(String yearEndRptCode) {
        this.yearEndRptCode = yearEndRptCode;
    }

    public String getCmoAgentCode() {
        return cmoAgentCode;
    }

    public void setCmoAgentCode(String cmoAgentCode) {
        this.cmoAgentCode = cmoAgentCode;
    }

    public String getBondSubCode() {
        return bondSubCode;
    }

    public void setBondSubCode(String bondSubCode) {
        this.bondSubCode = bondSubCode;
    }

    public String getSpecificPoolCode() {
        return specificPoolCode;
    }

    public void setSpecificPoolCode(String specificPoolCode) {
        this.specificPoolCode = specificPoolCode;
    }

    public String getRannUpdSrcInd() {
        return rannUpdSrcInd;
    }

    public void setRannUpdSrcInd(String rannUpdSrcInd) {
        this.rannUpdSrcInd = rannUpdSrcInd;
    }

    public String getRannUpdCymd() {
        return rannUpdCymd;
    }

    public void setRannUpdCymd(String rannUpdCymd) {
        this.rannUpdCymd = rannUpdCymd;
    }

    public String getLastFriMeCymd() {
        return lastFriMeCymd;
    }

    public void setLastFriMeCymd(String lastFriMeCymd) {
        this.lastFriMeCymd = lastFriMeCymd;
    }

    public String getLastFriMePrx() {
        return lastFriMePrx;
    }

    public void setLastFriMePrx(String lastFriMePrx) {
        this.lastFriMePrx = lastFriMePrx;
    }

    public String getIpoPrx() {
        return ipoPrx;
    }

    public void setIpoPrx(String ipoPrx) {
        this.ipoPrx = ipoPrx;
    }

    public String getTaxQualInd() {
        return taxQualInd;
    }

    public void setTaxQualInd(String taxQualInd) {
        this.taxQualInd = taxQualInd;
    }

    public String getForeignSedolNo() {
        return foreignSedolNo;
    }

    public void setForeignSedolNo(String foreignSedolNo) {
        this.foreignSedolNo = foreignSedolNo;
    }

    public String getTypeClassCode() {
        return typeClassCode;
    }

    public void setTypeClassCode(String typeClassCode) {
        this.typeClassCode = typeClassCode;
    }

    public String getUitAccruedAmt() {
        return uitAccruedAmt;
    }

    public void setUitAccruedAmt(String uitAccruedAmt) {
        this.uitAccruedAmt = uitAccruedAmt;
    }

    public String getExpireCymd() {
        return expireCymd;
    }

    public void setExpireCymd(String expireCymd) {
        this.expireCymd = expireCymd;
    }

    public String getOptnCode() {
        return optnCode;
    }

    public void setOptnCode(String optnCode) {
        this.optnCode = optnCode;
    }

    public String getUnderlyingSecNo() {
        return underlyingSecNo;
    }

    public void setUnderlyingSecNo(String underlyingSecNo) {
        this.underlyingSecNo = underlyingSecNo;
    }

    public String getStrikePrx() {
        return strikePrx;
    }

    public void setStrikePrx(String strikePrx) {
        this.strikePrx = strikePrx;
    }

    public String getWholeConvFactor() {
        return wholeConvFactor;
    }

    public void setWholeConvFactor(String wholeConvFactor) {
        this.wholeConvFactor = wholeConvFactor;
    }

    public String getDecConvFactor() {
        return decConvFactor;
    }

    public void setDecConvFactor(String decConvFactor) {
        this.decConvFactor = decConvFactor;
    }

    public String getUnderlyingOptSecNo() {
        return underlyingOptSecNo;
    }

    public void setUnderlyingOptSecNo(String underlyingOptSecNo) {
        this.underlyingOptSecNo = underlyingOptSecNo;
    }

    public String getCapIntervalNo() {
        return capIntervalNo;
    }

    public void setCapIntervalNo(String capIntervalNo) {
        this.capIntervalNo = capIntervalNo;
    }

    public String getDtcFracCusip() {
        return dtcFracCusip;
    }

    public void setDtcFracCusip(String dtcFracCusip) {
        this.dtcFracCusip = dtcFracCusip;
    }

    public String getCcsCode() {
        return ccsCode;
    }

    public void setCcsCode(String ccsCode) {
        this.ccsCode = ccsCode;
    }

    public String getNccCode() {
        return nccCode;
    }

    public void setNccCode(String nccCode) {
        this.nccCode = nccCode;
    }

    public String getHandFigInd() {
        return handFigInd;
    }

    public void setHandFigInd(String handFigInd) {
        this.handFigInd = handFigInd;
    }

    public String getFlatCode() {
        return flatCode;
    }

    public void setFlatCode(String flatCode) {
        this.flatCode = flatCode;
    }

    public String getDivPayFreqCode() {
        return divPayFreqCode;
    }

    public void setDivPayFreqCode(String divPayFreqCode) {
        this.divPayFreqCode = divPayFreqCode;
    }

    public String getRgstCode() {
        return rgstCode;
    }

    public void setRgstCode(String rgstCode) {
        this.rgstCode = rgstCode;
    }

    public String getDtcChillDepositInd() {
        return dtcChillDepositInd;
    }

    public void setDtcChillDepositInd(String dtcChillDepositInd) {
        this.dtcChillDepositInd = dtcChillDepositInd;
    }

    public String getDtcChillInd() {
        return dtcChillInd;
    }

    public void setDtcChillInd(String dtcChillInd) {
        this.dtcChillInd = dtcChillInd;
    }

    public String getDtcChillWtInd() {
        return dtcChillWtInd;
    }

    public void setDtcChillWtInd(String dtcChillWtInd) {
        this.dtcChillWtInd = dtcChillWtInd;
    }

    public String getDtcChillDoInd() {
        return dtcChillDoInd;
    }

    public void setDtcChillDoInd(String dtcChillDoInd) {
        this.dtcChillDoInd = dtcChillDoInd;
    }

    public String getDtcChillPledgeInd() {
        return dtcChillPledgeInd;
    }

    public void setDtcChillPledgeInd(String dtcChillPledgeInd) {
        this.dtcChillPledgeInd = dtcChillPledgeInd;
    }

    public String getDtcChillSegInd() {
        return dtcChillSegInd;
    }

    public void setDtcChillSegInd(String dtcChillSegInd) {
        this.dtcChillSegInd = dtcChillSegInd;
    }

    public String getDtcFrozenInd() {
        return dtcFrozenInd;
    }

    public void setDtcFrozenInd(String dtcFrozenInd) {
        this.dtcFrozenInd = dtcFrozenInd;
    }

    public String getForeignCode() {
        return foreignCode;
    }

    public void setForeignCode(String foreignCode) {
        this.foreignCode = foreignCode;
    }

    public String getMstrLimitPartnerInd() {
        return mstrLimitPartnerInd;
    }

    public void setMstrLimitPartnerInd(String mstrLimitPartnerInd) {
        this.mstrLimitPartnerInd = mstrLimitPartnerInd;
    }

    public String getNraExemptInd() {
        return nraExemptInd;
    }

    public void setNraExemptInd(String nraExemptInd) {
        this.nraExemptInd = nraExemptInd;
    }

    public String getDtcFedFundInd() {
        return dtcFedFundInd;
    }

    public void setDtcFedFundInd(String dtcFedFundInd) {
        this.dtcFedFundInd = dtcFedFundInd;
    }

    public String getMarginCode() {
        return marginCode;
    }

    public void setMarginCode(String marginCode) {
        this.marginCode = marginCode;
    }

    public String getProsEndCymd() {
        return prosEndCymd;
    }

    public void setProsEndCymd(String prosEndCymd) {
        this.prosEndCymd = prosEndCymd;
    }

    public String getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(String unitQty) {
        this.unitQty = unitQty;
    }

    public String getMbsccCode() {
        return mbsccCode;
    }

    public void setMbsccCode(String mbsccCode) {
        this.mbsccCode = mbsccCode;
    }

    public String getReinvestEligInd() {
        return reinvestEligInd;
    }

    public void setReinvestEligInd(String reinvestEligInd) {
        this.reinvestEligInd = reinvestEligInd;
    }

    public String getBidPrx() {
        return bidPrx;
    }

    public void setBidPrx(String bidPrx) {
        this.bidPrx = bidPrx;
    }

    public String getAskPrx() {
        return askPrx;
    }

    public void setAskPrx(String askPrx) {
        this.askPrx = askPrx;
    }

    public String getCrncyCode() {
        return crncyCode;
    }

    public void setCrncyCode(String crncyCode) {
        this.crncyCode = crncyCode;
    }

    public String getCrncyType() {
        return crncyType;
    }

    public void setCrncyType(String crncyType) {
        this.crncyType = crncyType;
    }

    public String getEuroclrId() {
        return euroclrId;
    }

    public void setEuroclrId(String euroclrId) {
        this.euroclrId = euroclrId;
    }

    public String getReissueCymd() {
        return reissueCymd;
    }

    public void setReissueCymd(String reissueCymd) {
        this.reissueCymd = reissueCymd;
    }

    public String getLastDivRate() {
        return lastDivRate;
    }

    public void setLastDivRate(String lastDivRate) {
        this.lastDivRate = lastDivRate;
    }

    public String getLastDivCymd() {
        return lastDivCymd;
    }

    public void setLastDivCymd(String lastDivCymd) {
        this.lastDivCymd = lastDivCymd;
    }

    public String getDivPaymentsQty() {
        return divPaymentsQty;
    }

    public void setDivPaymentsQty(String divPaymentsQty) {
        this.divPaymentsQty = divPaymentsQty;
    }

    public String getCrncySecNo() {
        return crncySecNo;
    }

    public void setCrncySecNo(String crncySecNo) {
        this.crncySecNo = crncySecNo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDeferedSalesInd() {
        return deferedSalesInd;
    }

    public void setDeferedSalesInd(String deferedSalesInd) {
        this.deferedSalesInd = deferedSalesInd;
    }

    public String getGovProcCode() {
        return govProcCode;
    }

    public void setGovProcCode(String govProcCode) {
        this.govProcCode = govProcCode;
    }

    public String getBuildBondInd() {
        return buildBondInd;
    }

    public void setBuildBondInd(String buildBondInd) {
        this.buildBondInd = buildBondInd;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getMoodysCode() {
        return moodysCode;
    }

    public void setMoodysCode(String moodysCode) {
        this.moodysCode = moodysCode;
    }

    public String getMfShareClassId() {
        return mfShareClassId;
    }

    public void setMfShareClassId(String mfShareClassId) {
        this.mfShareClassId = mfShareClassId;
    }

    public String getVariableRate() {
        return variableRate;
    }

    public void setVariableRate(String variableRate) {
        this.variableRate = variableRate;
    }

    public String getNewSecCode() {
        return newSecCode;
    }

    public void setNewSecCode(String newSecCode) {
        this.newSecCode = newSecCode;
    }

    public String getSortGroupCode() {
        return sortGroupCode;
    }

    public void setSortGroupCode(String sortGroupCode) {
        this.sortGroupCode = sortGroupCode;
    }

    public String getSortAlphaKey() {
        return sortAlphaKey;
    }

    public void setSortAlphaKey(String sortAlphaKey) {
        this.sortAlphaKey = sortAlphaKey;
    }

    public String getBondRegCode() {
        return bondRegCode;
    }

    public void setBondRegCode(String bondRegCode) {
        this.bondRegCode = bondRegCode;
    }

    public String getCallFrequencyCode() {
        return callFrequencyCode;
    }

    public void setCallFrequencyCode(String callFrequencyCode) {
        this.callFrequencyCode = callFrequencyCode;
    }

    public String getEscrowCode() {
        return escrowCode;
    }

    public void setEscrowCode(String escrowCode) {
        this.escrowCode = escrowCode;
    }

    public String getInsuredStatusCode() {
        return insuredStatusCode;
    }

    public void setInsuredStatusCode(String insuredStatusCode) {
        this.insuredStatusCode = insuredStatusCode;
    }

    public String getIntPaymentCode() {
        return intPaymentCode;
    }

    public void setIntPaymentCode(String intPaymentCode) {
        this.intPaymentCode = intPaymentCode;
    }

    public String getPartialRedeemCode() {
        return partialRedeemCode;
    }

    public void setPartialRedeemCode(String partialRedeemCode) {
        this.partialRedeemCode = partialRedeemCode;
    }

    public String getPutFrequencyCode() {
        return putFrequencyCode;
    }

    public void setPutFrequencyCode(String putFrequencyCode) {
        this.putFrequencyCode = putFrequencyCode;
    }

    public String getAdjustableRateCode() {
        return adjustableRateCode;
    }

    public void setAdjustableRateCode(String adjustableRateCode) {
        this.adjustableRateCode = adjustableRateCode;
    }

    public String getConvFactorCode() {
        return convFactorCode;
    }

    public void setConvFactorCode(String convFactorCode) {
        this.convFactorCode = convFactorCode;
    }

    public String getZeroCouponCode() {
        return zeroCouponCode;
    }

    public void setZeroCouponCode(String zeroCouponCode) {
        this.zeroCouponCode = zeroCouponCode;
    }

    public String getGuaranteeCode() {
        return guaranteeCode;
    }

    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode;
    }

    public String getNyPostNo() {
        return nyPostNo;
    }

    public void setNyPostNo(String nyPostNo) {
        this.nyPostNo = nyPostNo;
    }

    public String getNonTransferInd() {
        return nonTransferInd;
    }

    public void setNonTransferInd(String nonTransferInd) {
        this.nonTransferInd = nonTransferInd;
    }

    public String getPutOrCallInd() {
        return putOrCallInd;
    }

    public void setPutOrCallInd(String putOrCallInd) {
        this.putOrCallInd = putOrCallInd;
    }

    public String getOsiUlSymbol() {
        return osiUlSymbol;
    }

    public void setOsiUlSymbol(String osiUlSymbol) {
        this.osiUlSymbol = osiUlSymbol;
    }

    public String getExpirationCymd() {
        return expirationCymd;
    }

    public void setExpirationCymd(String expirationCymd) {
        this.expirationCymd = expirationCymd;
    }

    public String getStrikePrxExp() {
        return strikePrxExp;
    }

    public void setStrikePrxExp(String strikePrxExp) {
        this.strikePrxExp = strikePrxExp;
    }

    public String getTaxlotCoverCymd() {
        return taxlotCoverCymd;
    }

    public void setTaxlotCoverCymd(String taxlotCoverCymd) {
        this.taxlotCoverCymd = taxlotCoverCymd;
    }

    public String getDes2ChangeTerm() {
        return des2ChangeTerm;
    }

    public void setDes2ChangeTerm(String des2ChangeTerm) {
        this.des2ChangeTerm = des2ChangeTerm;
    }

}