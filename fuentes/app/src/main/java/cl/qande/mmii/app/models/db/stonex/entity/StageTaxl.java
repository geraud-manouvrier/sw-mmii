package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_taxl", schema = "stage_stonex")
public class StageTaxl {
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
    @Column(name = "sec_no", nullable = false, length = 100)
    private String secNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_tax_lot_id", nullable = false, length = 100)
    private String openTaxLotId;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_tax_lot_id", nullable = false, length = 100)
    private String closeTaxLotId;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_close_ind", nullable = false, length = 100)
    private String openCloseInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_tms", nullable = false, length = 100)
    private String addTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_user_id", nullable = false, length = 100)
    private String addUserId;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_who_code", nullable = false, length = 100)
    private String addWhoCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_term", nullable = false, length = 100)
    private String addTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_user_tms", nullable = false, length = 100)
    private String changeUserTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_sys_tms", nullable = false, length = 100)
    private String changeSysTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_user_who_code", nullable = false, length = 100)
    private String changeUserWhoCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_user_term", nullable = false, length = 100)
    private String changeUserTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_user_id", nullable = false, length = 100)
    private String changeUserId;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_sys_job_id", nullable = false, length = 100)
    private String changeSysJobId;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_sys_progrm_id", nullable = false, length = 100)
    private String changeSysProgrmId;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_qty", nullable = false, length = 100)
    private String taxLotQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "held_away_ind", nullable = false, length = 100)
    private String heldAwayInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "repo_tran_ind", nullable = false, length = 100)
    private String repoTranInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "repo_reverse_ind", nullable = false, length = 100)
    private String repoReverseInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "level_4_ind", nullable = false, length = 100)
    private String level4Ind;

    @Size(max = 100)
    @NotNull
    @Column(name = "annuity_pstn_ind", nullable = false, length = 100)
    private String annuityPstnInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "acat_cbrs_ind", nullable = false, length = 100)
    private String acatCbrsInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_no", nullable = false, length = 100)
    private String controlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "apply_principal_uit_ind", nullable = false, length = 100)
    private String applyPrincipalUitInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "apply_principal_mlp_ind", nullable = false, length = 100)
    private String applyPrincipalMlpInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "apply_liquidation_ind", nullable = false, length = 100)
    private String applyLiquidationInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "apply_factor_ind", nullable = false, length = 100)
    private String applyFactorInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "apply_oid_ind", nullable = false, length = 100)
    private String applyOidInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_proceed_amt", nullable = false, length = 100)
    private String optnProceedAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "paydown_amt", nullable = false, length = 100)
    private String paydownAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "liquidation_amt", nullable = false, length = 100)
    private String liquidationAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid_accrued_amt", nullable = false, length = 100)
    private String oidAccruedAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_type", nullable = false, length = 100)
    private String crncyType;

    @Size(max = 100)
    @NotNull
    @Column(name = "auto_trade_code", nullable = false, length = 100)
    private String autoTradeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "yield_rate", nullable = false, length = 100)
    private String yieldRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "yield_code", nullable = false, length = 100)
    private String yieldCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "yield_ovrd_code", nullable = false, length = 100)
    private String yieldOvrdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid_yield_maturity_rate", nullable = false, length = 100)
    private String oidYieldMaturityRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "addl_user_desc", nullable = false, length = 100)
    private String addlUserDesc;

    @Size(max = 100)
    @NotNull
    @Column(name = "order_no", nullable = false, length = 100)
    private String orderNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "annuity_contract_id", nullable = false, length = 100)
    private String annuityContractId;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_basis_ind", nullable = false, length = 100)
    private String adjBasisInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_cymd", nullable = false, length = 100)
    private String openCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_srce_code", nullable = false, length = 100)
    private String openSrceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_activ_srce_code", nullable = false, length = 100)
    private String lastActivSrceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_activ_srce_code_adj_sw", nullable = false, length = 100)
    private String lastActivSrceCodeAdjSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_entry_frozen_ind", nullable = false, length = 100)
    private String openEntryFrozenInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_srce_code_adj_ind", nullable = false, length = 100)
    private String openSrceCodeAdjInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_open_cost_ind", nullable = false, length = 100)
    private String noOpenCostInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_cost_amt", nullable = false, length = 100)
    private String openCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_open_price_ind", nullable = false, length = 100)
    private String noOpenPriceInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_prx", nullable = false, length = 100)
    private String openPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_open_factor_ind", nullable = false, length = 100)
    private String noOpenFactorInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_factor", nullable = false, length = 100)
    private String openFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "pend_dist_ind", nullable = false, length = 100)
    private String pendDistInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_adj_cost_amt", nullable = false, length = 100)
    private String openAdjCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_mkt_amt", nullable = false, length = 100)
    private String openMktAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "unrealized_gain_loss_amt", nullable = false, length = 100)
    private String unrealizedGainLossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_gain_loss_term_ind", nullable = false, length = 100)
    private String openGainLossTermInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "daily_accretion_rate", nullable = false, length = 100)
    private String dailyAccretionRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "daily_amort_rate", nullable = false, length = 100)
    private String dailyAmortRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_settle_cymd", nullable = false, length = 100)
    private String openSettleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_cymd", nullable = false, length = 100)
    private String closeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_srce_code", nullable = false, length = 100)
    private String closeSrceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_adj_srce_code_ind", nullable = false, length = 100)
    private String closeAdjSrceCodeInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_field", nullable = false, length = 100)
    private String descField;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_close_cost_ind", nullable = false, length = 100)
    private String noCloseCostInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_cost_amt", nullable = false, length = 100)
    private String closeCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_close_price_ind", nullable = false, length = 100)
    private String noClosePriceInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_prx", nullable = false, length = 100)
    private String closePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_close_factor_ind", nullable = false, length = 100)
    private String noCloseFactorInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_factor", nullable = false, length = 100)
    private String closeFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_adj_cost_amt", nullable = false, length = 100)
    private String closeAdjCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_stk_rec_pos_ind", nullable = false, length = 100)
    private String noStkRecPosInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sale_by_tax_lot_ind", nullable = false, length = 100)
    private String saleByTaxLotInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "box_cymd", nullable = false, length = 100)
    private String boxCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "suppress_tax_lot_ind", nullable = false, length = 100)
    private String suppressTaxLotInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "realized_gain_loss_amt", nullable = false, length = 100)
    private String realizedGainLossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_gain_loss_term_code", nullable = false, length = 100)
    private String closeGainLossTermCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_entry_frozen_ind", nullable = false, length = 100)
    private String closeEntryFrozenInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_settle_cymd", nullable = false, length = 100)
    private String closeSettleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "user_xref_id", nullable = false, length = 100)
    private String userXrefId;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_trans_cymd", nullable = false, length = 100)
    private String addTransCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_job_id", nullable = false, length = 100)
    private String addJobId;

    @Size(max = 100)
    @NotNull
    @Column(name = "de_minimis_ind", nullable = false, length = 100)
    private String deMinimisInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid_error_ind", nullable = false, length = 100)
    private String oidErrorInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "amort_amt", nullable = false, length = 100)
    private String amortAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sys_chg_tran_cymd", nullable = false, length = 100)
    private String sysChgTranCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "user_chg_tran_cymd", nullable = false, length = 100)
    private String userChgTranCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_yld_mat_rate", nullable = false, length = 100)
    private String mktYldMatRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_diff_id", nullable = false, length = 100)
    private String mktDiffId;

    @Size(max = 100)
    @NotNull
    @Column(name = "acquisition_accreted_amt", nullable = false, length = 100)
    private String acquisitionAccretedAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_id", nullable = false, length = 100)
    private String taxLotId;

    @Size(max = 100)
    @NotNull
    @Column(name = "prev_ind", nullable = false, length = 100)
    private String prevInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_gain_loss_amt", nullable = false, length = 100)
    private String adjGainLossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_prx", nullable = false, length = 100)
    private String adjPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "cost_alloc_code", nullable = false, length = 100)
    private String costAllocCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "avg_prx", nullable = false, length = 100)
    private String avgPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "wash_sale_amt", nullable = false, length = 100)
    private String washSaleAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "undst_ltrm_cap_amt", nullable = false, length = 100)
    private String undstLtrmCapAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_cover_ind", nullable = false, length = 100)
    private String taxLotCoverInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_xfer_cymd", nullable = false, length = 100)
    private String taxLotXferCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "cbrs_dlvr_ctrl_no", nullable = false, length = 100)
    private String cbrsDlvrCtrlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cbrs_recv_ctrl_no", nullable = false, length = 100)
    private String cbrsRecvCtrlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cbrs_alt_ctrl_no", nullable = false, length = 100)
    private String cbrsAltCtrlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "recv_cbrs_partic_no", nullable = false, length = 100)
    private String recvCbrsParticNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "dlvr_cbrs_partic_no", nullable = false, length = 100)
    private String dlvrCbrsParticNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cert_no", nullable = false, length = 100)
    private String certNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "gain_loss_amt_known_ind", nullable = false, length = 100)
    private String gainLossAmtKnownInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_open_xfer_code", nullable = false, length = 100)
    private String taxLotOpenXferCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_open_fmv_amt", nullable = false, length = 100)
    private String taxLotOpenFmvAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_wash_sale_cymd", nullable = false, length = 100)
    private String openWashSaleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_close_xfer_code", nullable = false, length = 100)
    private String taxLotCloseXferCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_close_fmv_amt", nullable = false, length = 100)
    private String taxLotCloseFmvAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "close_wash_sale_cymd", nullable = false, length = 100)
    private String closeWashSaleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "atd_unique_key", nullable = false, length = 100)
    private String atdUniqueKey;

    @Size(max = 100)
    @NotNull
    @Column(name = "stloss_to_ltloss_amt", nullable = false, length = 100)
    private String stlossToLtlossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "taxl_avg_cost_code", nullable = false, length = 100)
    private String taxlAvgCostCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "taxl_drp_ind", nullable = false, length = 100)
    private String taxlDrpInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_avg_cost_amt", nullable = false, length = 100)
    private String openAvgCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "clos_disallow_loss_amt", nullable = false, length = 100)
    private String closDisallowLossAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_orig_open_cost_ind", nullable = false, length = 100)
    private String noOrigOpenCostInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "clos_orig_open_cost_amt", nullable = false, length = 100)
    private String closOrigOpenCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "clos_opt_proc_amt", nullable = false, length = 100)
    private String closOptProcAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "clos_firm_lvl_4_ind", nullable = false, length = 100)
    private String closFirmLvl4Ind;

    @Size(max = 100)
    @NotNull
    @Column(name = "hold_start_cymd", nullable = false, length = 100)
    private String holdStartCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "holding_period_days", nullable = false, length = 100)
    private String holdingPeriodDays;

    @Size(max = 100)
    @NotNull
    @Column(name = "from_acct_no_jnl", nullable = false, length = 100)
    private String fromAcctNoJnl;

    @Size(max = 100)
    @NotNull
    @Column(name = "to_acct_no_jnl", nullable = false, length = 100)
    private String toAcctNoJnl;

    @Size(max = 100)
    @NotNull
    @Column(name = "cb_setup_ind", nullable = false, length = 100)
    private String cbSetupInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "xchg_rate_fmv", nullable = false, length = 100)
    private String xchgRateFmv;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_issue_prx", nullable = false, length = 100)
    private String adjIssuePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "acq_prem_amt", nullable = false, length = 100)
    private String acqPremAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_disc_amt", nullable = false, length = 100)
    private String mktDiscAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_disc_calc_code", nullable = false, length = 100)
    private String mktDiscCalcCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "oid_taxable_ind", nullable = false, length = 100)
    private String oidTaxableInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prem_amort_ind", nullable = false, length = 100)
    private String premAmortInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_disc_accret_ind", nullable = false, length = 100)
    private String mktDiscAccretInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "spot_rate_ind", nullable = false, length = 100)
    private String spotRateInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "acat_adj_cost_amt", nullable = false, length = 100)
    private String acatAdjCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "acat_change_cymd", nullable = false, length = 100)
    private String acatChangeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "calc_to_cymd", nullable = false, length = 100)
    private String calcToCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_disc_daily_rate", nullable = false, length = 100)
    private String mktDiscDailyRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "acq_prem_daily_rate", nullable = false, length = 100)
    private String acqPremDailyRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "corp_action_code", nullable = false, length = 100)
    private String corpActionCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_debt_cost_ind", nullable = false, length = 100)
    private String noDebtCostInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "debt_cost_amt", nullable = false, length = 100)
    private String debtCostAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "deflation_adj_amt", nullable = false, length = 100)
    private String deflationAdjAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cpdi_net_adj_amt", nullable = false, length = 100)
    private String cpdiNetAdjAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "nqsi_daily_rate", nullable = false, length = 100)
    private String nqsiDailyRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "nqsi_tot_amt", nullable = false, length = 100)
    private String nqsiTotAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "orig_yield", nullable = false, length = 100)
    private String origYield;

    @Size(max = 100)
    @NotNull
    @Column(name = "purch_yield", nullable = false, length = 100)
    private String purchYield;

    @Size(max = 100)
    @NotNull
    @Column(name = "inclusion_frac", nullable = false, length = 100)
    private String inclusionFrac;

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

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getOpenTaxLotId() {
        return openTaxLotId;
    }

    public void setOpenTaxLotId(String openTaxLotId) {
        this.openTaxLotId = openTaxLotId;
    }

    public String getCloseTaxLotId() {
        return closeTaxLotId;
    }

    public void setCloseTaxLotId(String closeTaxLotId) {
        this.closeTaxLotId = closeTaxLotId;
    }

    public String getOpenCloseInd() {
        return openCloseInd;
    }

    public void setOpenCloseInd(String openCloseInd) {
        this.openCloseInd = openCloseInd;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getAddTms() {
        return addTms;
    }

    public void setAddTms(String addTms) {
        this.addTms = addTms;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getAddWhoCode() {
        return addWhoCode;
    }

    public void setAddWhoCode(String addWhoCode) {
        this.addWhoCode = addWhoCode;
    }

    public String getAddTerm() {
        return addTerm;
    }

    public void setAddTerm(String addTerm) {
        this.addTerm = addTerm;
    }

    public String getChangeUserTms() {
        return changeUserTms;
    }

    public void setChangeUserTms(String changeUserTms) {
        this.changeUserTms = changeUserTms;
    }

    public String getChangeSysTms() {
        return changeSysTms;
    }

    public void setChangeSysTms(String changeSysTms) {
        this.changeSysTms = changeSysTms;
    }

    public String getChangeUserWhoCode() {
        return changeUserWhoCode;
    }

    public void setChangeUserWhoCode(String changeUserWhoCode) {
        this.changeUserWhoCode = changeUserWhoCode;
    }

    public String getChangeUserTerm() {
        return changeUserTerm;
    }

    public void setChangeUserTerm(String changeUserTerm) {
        this.changeUserTerm = changeUserTerm;
    }

    public String getChangeUserId() {
        return changeUserId;
    }

    public void setChangeUserId(String changeUserId) {
        this.changeUserId = changeUserId;
    }

    public String getChangeSysJobId() {
        return changeSysJobId;
    }

    public void setChangeSysJobId(String changeSysJobId) {
        this.changeSysJobId = changeSysJobId;
    }

    public String getChangeSysProgrmId() {
        return changeSysProgrmId;
    }

    public void setChangeSysProgrmId(String changeSysProgrmId) {
        this.changeSysProgrmId = changeSysProgrmId;
    }

    public String getTaxLotQty() {
        return taxLotQty;
    }

    public void setTaxLotQty(String taxLotQty) {
        this.taxLotQty = taxLotQty;
    }

    public String getHeldAwayInd() {
        return heldAwayInd;
    }

    public void setHeldAwayInd(String heldAwayInd) {
        this.heldAwayInd = heldAwayInd;
    }

    public String getRepoTranInd() {
        return repoTranInd;
    }

    public void setRepoTranInd(String repoTranInd) {
        this.repoTranInd = repoTranInd;
    }

    public String getRepoReverseInd() {
        return repoReverseInd;
    }

    public void setRepoReverseInd(String repoReverseInd) {
        this.repoReverseInd = repoReverseInd;
    }

    public String getLevel4Ind() {
        return level4Ind;
    }

    public void setLevel4Ind(String level4Ind) {
        this.level4Ind = level4Ind;
    }

    public String getAnnuityPstnInd() {
        return annuityPstnInd;
    }

    public void setAnnuityPstnInd(String annuityPstnInd) {
        this.annuityPstnInd = annuityPstnInd;
    }

    public String getAcatCbrsInd() {
        return acatCbrsInd;
    }

    public void setAcatCbrsInd(String acatCbrsInd) {
        this.acatCbrsInd = acatCbrsInd;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }

    public String getApplyPrincipalUitInd() {
        return applyPrincipalUitInd;
    }

    public void setApplyPrincipalUitInd(String applyPrincipalUitInd) {
        this.applyPrincipalUitInd = applyPrincipalUitInd;
    }

    public String getApplyPrincipalMlpInd() {
        return applyPrincipalMlpInd;
    }

    public void setApplyPrincipalMlpInd(String applyPrincipalMlpInd) {
        this.applyPrincipalMlpInd = applyPrincipalMlpInd;
    }

    public String getApplyLiquidationInd() {
        return applyLiquidationInd;
    }

    public void setApplyLiquidationInd(String applyLiquidationInd) {
        this.applyLiquidationInd = applyLiquidationInd;
    }

    public String getApplyFactorInd() {
        return applyFactorInd;
    }

    public void setApplyFactorInd(String applyFactorInd) {
        this.applyFactorInd = applyFactorInd;
    }

    public String getApplyOidInd() {
        return applyOidInd;
    }

    public void setApplyOidInd(String applyOidInd) {
        this.applyOidInd = applyOidInd;
    }

    public String getOptnProceedAmt() {
        return optnProceedAmt;
    }

    public void setOptnProceedAmt(String optnProceedAmt) {
        this.optnProceedAmt = optnProceedAmt;
    }

    public String getPaydownAmt() {
        return paydownAmt;
    }

    public void setPaydownAmt(String paydownAmt) {
        this.paydownAmt = paydownAmt;
    }

    public String getLiquidationAmt() {
        return liquidationAmt;
    }

    public void setLiquidationAmt(String liquidationAmt) {
        this.liquidationAmt = liquidationAmt;
    }

    public String getOidAccruedAmt() {
        return oidAccruedAmt;
    }

    public void setOidAccruedAmt(String oidAccruedAmt) {
        this.oidAccruedAmt = oidAccruedAmt;
    }

    public String getCrncyType() {
        return crncyType;
    }

    public void setCrncyType(String crncyType) {
        this.crncyType = crncyType;
    }

    public String getAutoTradeCode() {
        return autoTradeCode;
    }

    public void setAutoTradeCode(String autoTradeCode) {
        this.autoTradeCode = autoTradeCode;
    }

    public String getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(String yieldRate) {
        this.yieldRate = yieldRate;
    }

    public String getYieldCode() {
        return yieldCode;
    }

    public void setYieldCode(String yieldCode) {
        this.yieldCode = yieldCode;
    }

    public String getYieldOvrdCode() {
        return yieldOvrdCode;
    }

    public void setYieldOvrdCode(String yieldOvrdCode) {
        this.yieldOvrdCode = yieldOvrdCode;
    }

    public String getOidYieldMaturityRate() {
        return oidYieldMaturityRate;
    }

    public void setOidYieldMaturityRate(String oidYieldMaturityRate) {
        this.oidYieldMaturityRate = oidYieldMaturityRate;
    }

    public String getAddlUserDesc() {
        return addlUserDesc;
    }

    public void setAddlUserDesc(String addlUserDesc) {
        this.addlUserDesc = addlUserDesc;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAnnuityContractId() {
        return annuityContractId;
    }

    public void setAnnuityContractId(String annuityContractId) {
        this.annuityContractId = annuityContractId;
    }

    public String getAdjBasisInd() {
        return adjBasisInd;
    }

    public void setAdjBasisInd(String adjBasisInd) {
        this.adjBasisInd = adjBasisInd;
    }

    public String getOpenCymd() {
        return openCymd;
    }

    public void setOpenCymd(String openCymd) {
        this.openCymd = openCymd;
    }

    public String getOpenSrceCode() {
        return openSrceCode;
    }

    public void setOpenSrceCode(String openSrceCode) {
        this.openSrceCode = openSrceCode;
    }

    public String getLastActivSrceCode() {
        return lastActivSrceCode;
    }

    public void setLastActivSrceCode(String lastActivSrceCode) {
        this.lastActivSrceCode = lastActivSrceCode;
    }

    public String getLastActivSrceCodeAdjSw() {
        return lastActivSrceCodeAdjSw;
    }

    public void setLastActivSrceCodeAdjSw(String lastActivSrceCodeAdjSw) {
        this.lastActivSrceCodeAdjSw = lastActivSrceCodeAdjSw;
    }

    public String getOpenEntryFrozenInd() {
        return openEntryFrozenInd;
    }

    public void setOpenEntryFrozenInd(String openEntryFrozenInd) {
        this.openEntryFrozenInd = openEntryFrozenInd;
    }

    public String getOpenSrceCodeAdjInd() {
        return openSrceCodeAdjInd;
    }

    public void setOpenSrceCodeAdjInd(String openSrceCodeAdjInd) {
        this.openSrceCodeAdjInd = openSrceCodeAdjInd;
    }

    public String getNoOpenCostInd() {
        return noOpenCostInd;
    }

    public void setNoOpenCostInd(String noOpenCostInd) {
        this.noOpenCostInd = noOpenCostInd;
    }

    public String getOpenCostAmt() {
        return openCostAmt;
    }

    public void setOpenCostAmt(String openCostAmt) {
        this.openCostAmt = openCostAmt;
    }

    public String getNoOpenPriceInd() {
        return noOpenPriceInd;
    }

    public void setNoOpenPriceInd(String noOpenPriceInd) {
        this.noOpenPriceInd = noOpenPriceInd;
    }

    public String getOpenPrx() {
        return openPrx;
    }

    public void setOpenPrx(String openPrx) {
        this.openPrx = openPrx;
    }

    public String getNoOpenFactorInd() {
        return noOpenFactorInd;
    }

    public void setNoOpenFactorInd(String noOpenFactorInd) {
        this.noOpenFactorInd = noOpenFactorInd;
    }

    public String getOpenFactor() {
        return openFactor;
    }

    public void setOpenFactor(String openFactor) {
        this.openFactor = openFactor;
    }

    public String getPendDistInd() {
        return pendDistInd;
    }

    public void setPendDistInd(String pendDistInd) {
        this.pendDistInd = pendDistInd;
    }

    public String getOpenAdjCostAmt() {
        return openAdjCostAmt;
    }

    public void setOpenAdjCostAmt(String openAdjCostAmt) {
        this.openAdjCostAmt = openAdjCostAmt;
    }

    public String getOpenMktAmt() {
        return openMktAmt;
    }

    public void setOpenMktAmt(String openMktAmt) {
        this.openMktAmt = openMktAmt;
    }

    public String getUnrealizedGainLossAmt() {
        return unrealizedGainLossAmt;
    }

    public void setUnrealizedGainLossAmt(String unrealizedGainLossAmt) {
        this.unrealizedGainLossAmt = unrealizedGainLossAmt;
    }

    public String getOpenGainLossTermInd() {
        return openGainLossTermInd;
    }

    public void setOpenGainLossTermInd(String openGainLossTermInd) {
        this.openGainLossTermInd = openGainLossTermInd;
    }

    public String getDailyAccretionRate() {
        return dailyAccretionRate;
    }

    public void setDailyAccretionRate(String dailyAccretionRate) {
        this.dailyAccretionRate = dailyAccretionRate;
    }

    public String getDailyAmortRate() {
        return dailyAmortRate;
    }

    public void setDailyAmortRate(String dailyAmortRate) {
        this.dailyAmortRate = dailyAmortRate;
    }

    public String getOpenSettleCymd() {
        return openSettleCymd;
    }

    public void setOpenSettleCymd(String openSettleCymd) {
        this.openSettleCymd = openSettleCymd;
    }

    public String getCloseCymd() {
        return closeCymd;
    }

    public void setCloseCymd(String closeCymd) {
        this.closeCymd = closeCymd;
    }

    public String getCloseSrceCode() {
        return closeSrceCode;
    }

    public void setCloseSrceCode(String closeSrceCode) {
        this.closeSrceCode = closeSrceCode;
    }

    public String getCloseAdjSrceCodeInd() {
        return closeAdjSrceCodeInd;
    }

    public void setCloseAdjSrceCodeInd(String closeAdjSrceCodeInd) {
        this.closeAdjSrceCodeInd = closeAdjSrceCodeInd;
    }

    public String getDescField() {
        return descField;
    }

    public void setDescField(String descField) {
        this.descField = descField;
    }

    public String getNoCloseCostInd() {
        return noCloseCostInd;
    }

    public void setNoCloseCostInd(String noCloseCostInd) {
        this.noCloseCostInd = noCloseCostInd;
    }

    public String getCloseCostAmt() {
        return closeCostAmt;
    }

    public void setCloseCostAmt(String closeCostAmt) {
        this.closeCostAmt = closeCostAmt;
    }

    public String getNoClosePriceInd() {
        return noClosePriceInd;
    }

    public void setNoClosePriceInd(String noClosePriceInd) {
        this.noClosePriceInd = noClosePriceInd;
    }

    public String getClosePrx() {
        return closePrx;
    }

    public void setClosePrx(String closePrx) {
        this.closePrx = closePrx;
    }

    public String getNoCloseFactorInd() {
        return noCloseFactorInd;
    }

    public void setNoCloseFactorInd(String noCloseFactorInd) {
        this.noCloseFactorInd = noCloseFactorInd;
    }

    public String getCloseFactor() {
        return closeFactor;
    }

    public void setCloseFactor(String closeFactor) {
        this.closeFactor = closeFactor;
    }

    public String getCloseAdjCostAmt() {
        return closeAdjCostAmt;
    }

    public void setCloseAdjCostAmt(String closeAdjCostAmt) {
        this.closeAdjCostAmt = closeAdjCostAmt;
    }

    public String getNoStkRecPosInd() {
        return noStkRecPosInd;
    }

    public void setNoStkRecPosInd(String noStkRecPosInd) {
        this.noStkRecPosInd = noStkRecPosInd;
    }

    public String getSaleByTaxLotInd() {
        return saleByTaxLotInd;
    }

    public void setSaleByTaxLotInd(String saleByTaxLotInd) {
        this.saleByTaxLotInd = saleByTaxLotInd;
    }

    public String getBoxCymd() {
        return boxCymd;
    }

    public void setBoxCymd(String boxCymd) {
        this.boxCymd = boxCymd;
    }

    public String getSuppressTaxLotInd() {
        return suppressTaxLotInd;
    }

    public void setSuppressTaxLotInd(String suppressTaxLotInd) {
        this.suppressTaxLotInd = suppressTaxLotInd;
    }

    public String getRealizedGainLossAmt() {
        return realizedGainLossAmt;
    }

    public void setRealizedGainLossAmt(String realizedGainLossAmt) {
        this.realizedGainLossAmt = realizedGainLossAmt;
    }

    public String getCloseGainLossTermCode() {
        return closeGainLossTermCode;
    }

    public void setCloseGainLossTermCode(String closeGainLossTermCode) {
        this.closeGainLossTermCode = closeGainLossTermCode;
    }

    public String getCloseEntryFrozenInd() {
        return closeEntryFrozenInd;
    }

    public void setCloseEntryFrozenInd(String closeEntryFrozenInd) {
        this.closeEntryFrozenInd = closeEntryFrozenInd;
    }

    public String getCloseSettleCymd() {
        return closeSettleCymd;
    }

    public void setCloseSettleCymd(String closeSettleCymd) {
        this.closeSettleCymd = closeSettleCymd;
    }

    public String getUserXrefId() {
        return userXrefId;
    }

    public void setUserXrefId(String userXrefId) {
        this.userXrefId = userXrefId;
    }

    public String getAddTransCymd() {
        return addTransCymd;
    }

    public void setAddTransCymd(String addTransCymd) {
        this.addTransCymd = addTransCymd;
    }

    public String getAddJobId() {
        return addJobId;
    }

    public void setAddJobId(String addJobId) {
        this.addJobId = addJobId;
    }

    public String getDeMinimisInd() {
        return deMinimisInd;
    }

    public void setDeMinimisInd(String deMinimisInd) {
        this.deMinimisInd = deMinimisInd;
    }

    public String getOidErrorInd() {
        return oidErrorInd;
    }

    public void setOidErrorInd(String oidErrorInd) {
        this.oidErrorInd = oidErrorInd;
    }

    public String getAmortAmt() {
        return amortAmt;
    }

    public void setAmortAmt(String amortAmt) {
        this.amortAmt = amortAmt;
    }

    public String getSysChgTranCymd() {
        return sysChgTranCymd;
    }

    public void setSysChgTranCymd(String sysChgTranCymd) {
        this.sysChgTranCymd = sysChgTranCymd;
    }

    public String getUserChgTranCymd() {
        return userChgTranCymd;
    }

    public void setUserChgTranCymd(String userChgTranCymd) {
        this.userChgTranCymd = userChgTranCymd;
    }

    public String getMktYldMatRate() {
        return mktYldMatRate;
    }

    public void setMktYldMatRate(String mktYldMatRate) {
        this.mktYldMatRate = mktYldMatRate;
    }

    public String getMktDiffId() {
        return mktDiffId;
    }

    public void setMktDiffId(String mktDiffId) {
        this.mktDiffId = mktDiffId;
    }

    public String getAcquisitionAccretedAmt() {
        return acquisitionAccretedAmt;
    }

    public void setAcquisitionAccretedAmt(String acquisitionAccretedAmt) {
        this.acquisitionAccretedAmt = acquisitionAccretedAmt;
    }

    public String getTaxLotId() {
        return taxLotId;
    }

    public void setTaxLotId(String taxLotId) {
        this.taxLotId = taxLotId;
    }

    public String getPrevInd() {
        return prevInd;
    }

    public void setPrevInd(String prevInd) {
        this.prevInd = prevInd;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getAdjGainLossAmt() {
        return adjGainLossAmt;
    }

    public void setAdjGainLossAmt(String adjGainLossAmt) {
        this.adjGainLossAmt = adjGainLossAmt;
    }

    public String getAdjPrx() {
        return adjPrx;
    }

    public void setAdjPrx(String adjPrx) {
        this.adjPrx = adjPrx;
    }

    public String getCostAllocCode() {
        return costAllocCode;
    }

    public void setCostAllocCode(String costAllocCode) {
        this.costAllocCode = costAllocCode;
    }

    public String getAvgPrx() {
        return avgPrx;
    }

    public void setAvgPrx(String avgPrx) {
        this.avgPrx = avgPrx;
    }

    public String getWashSaleAmt() {
        return washSaleAmt;
    }

    public void setWashSaleAmt(String washSaleAmt) {
        this.washSaleAmt = washSaleAmt;
    }

    public String getUndstLtrmCapAmt() {
        return undstLtrmCapAmt;
    }

    public void setUndstLtrmCapAmt(String undstLtrmCapAmt) {
        this.undstLtrmCapAmt = undstLtrmCapAmt;
    }

    public String getTaxLotCoverInd() {
        return taxLotCoverInd;
    }

    public void setTaxLotCoverInd(String taxLotCoverInd) {
        this.taxLotCoverInd = taxLotCoverInd;
    }

    public String getTaxLotXferCymd() {
        return taxLotXferCymd;
    }

    public void setTaxLotXferCymd(String taxLotXferCymd) {
        this.taxLotXferCymd = taxLotXferCymd;
    }

    public String getCbrsDlvrCtrlNo() {
        return cbrsDlvrCtrlNo;
    }

    public void setCbrsDlvrCtrlNo(String cbrsDlvrCtrlNo) {
        this.cbrsDlvrCtrlNo = cbrsDlvrCtrlNo;
    }

    public String getCbrsRecvCtrlNo() {
        return cbrsRecvCtrlNo;
    }

    public void setCbrsRecvCtrlNo(String cbrsRecvCtrlNo) {
        this.cbrsRecvCtrlNo = cbrsRecvCtrlNo;
    }

    public String getCbrsAltCtrlNo() {
        return cbrsAltCtrlNo;
    }

    public void setCbrsAltCtrlNo(String cbrsAltCtrlNo) {
        this.cbrsAltCtrlNo = cbrsAltCtrlNo;
    }

    public String getRecvCbrsParticNo() {
        return recvCbrsParticNo;
    }

    public void setRecvCbrsParticNo(String recvCbrsParticNo) {
        this.recvCbrsParticNo = recvCbrsParticNo;
    }

    public String getDlvrCbrsParticNo() {
        return dlvrCbrsParticNo;
    }

    public void setDlvrCbrsParticNo(String dlvrCbrsParticNo) {
        this.dlvrCbrsParticNo = dlvrCbrsParticNo;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getGainLossAmtKnownInd() {
        return gainLossAmtKnownInd;
    }

    public void setGainLossAmtKnownInd(String gainLossAmtKnownInd) {
        this.gainLossAmtKnownInd = gainLossAmtKnownInd;
    }

    public String getTaxLotOpenXferCode() {
        return taxLotOpenXferCode;
    }

    public void setTaxLotOpenXferCode(String taxLotOpenXferCode) {
        this.taxLotOpenXferCode = taxLotOpenXferCode;
    }

    public String getTaxLotOpenFmvAmt() {
        return taxLotOpenFmvAmt;
    }

    public void setTaxLotOpenFmvAmt(String taxLotOpenFmvAmt) {
        this.taxLotOpenFmvAmt = taxLotOpenFmvAmt;
    }

    public String getOpenWashSaleCymd() {
        return openWashSaleCymd;
    }

    public void setOpenWashSaleCymd(String openWashSaleCymd) {
        this.openWashSaleCymd = openWashSaleCymd;
    }

    public String getTaxLotCloseXferCode() {
        return taxLotCloseXferCode;
    }

    public void setTaxLotCloseXferCode(String taxLotCloseXferCode) {
        this.taxLotCloseXferCode = taxLotCloseXferCode;
    }

    public String getTaxLotCloseFmvAmt() {
        return taxLotCloseFmvAmt;
    }

    public void setTaxLotCloseFmvAmt(String taxLotCloseFmvAmt) {
        this.taxLotCloseFmvAmt = taxLotCloseFmvAmt;
    }

    public String getCloseWashSaleCymd() {
        return closeWashSaleCymd;
    }

    public void setCloseWashSaleCymd(String closeWashSaleCymd) {
        this.closeWashSaleCymd = closeWashSaleCymd;
    }

    public String getAtdUniqueKey() {
        return atdUniqueKey;
    }

    public void setAtdUniqueKey(String atdUniqueKey) {
        this.atdUniqueKey = atdUniqueKey;
    }

    public String getStlossToLtlossAmt() {
        return stlossToLtlossAmt;
    }

    public void setStlossToLtlossAmt(String stlossToLtlossAmt) {
        this.stlossToLtlossAmt = stlossToLtlossAmt;
    }

    public String getTaxlAvgCostCode() {
        return taxlAvgCostCode;
    }

    public void setTaxlAvgCostCode(String taxlAvgCostCode) {
        this.taxlAvgCostCode = taxlAvgCostCode;
    }

    public String getTaxlDrpInd() {
        return taxlDrpInd;
    }

    public void setTaxlDrpInd(String taxlDrpInd) {
        this.taxlDrpInd = taxlDrpInd;
    }

    public String getOpenAvgCostAmt() {
        return openAvgCostAmt;
    }

    public void setOpenAvgCostAmt(String openAvgCostAmt) {
        this.openAvgCostAmt = openAvgCostAmt;
    }

    public String getClosDisallowLossAmt() {
        return closDisallowLossAmt;
    }

    public void setClosDisallowLossAmt(String closDisallowLossAmt) {
        this.closDisallowLossAmt = closDisallowLossAmt;
    }

    public String getNoOrigOpenCostInd() {
        return noOrigOpenCostInd;
    }

    public void setNoOrigOpenCostInd(String noOrigOpenCostInd) {
        this.noOrigOpenCostInd = noOrigOpenCostInd;
    }

    public String getClosOrigOpenCostAmt() {
        return closOrigOpenCostAmt;
    }

    public void setClosOrigOpenCostAmt(String closOrigOpenCostAmt) {
        this.closOrigOpenCostAmt = closOrigOpenCostAmt;
    }

    public String getClosOptProcAmt() {
        return closOptProcAmt;
    }

    public void setClosOptProcAmt(String closOptProcAmt) {
        this.closOptProcAmt = closOptProcAmt;
    }

    public String getClosFirmLvl4Ind() {
        return closFirmLvl4Ind;
    }

    public void setClosFirmLvl4Ind(String closFirmLvl4Ind) {
        this.closFirmLvl4Ind = closFirmLvl4Ind;
    }

    public String getHoldStartCymd() {
        return holdStartCymd;
    }

    public void setHoldStartCymd(String holdStartCymd) {
        this.holdStartCymd = holdStartCymd;
    }

    public String getHoldingPeriodDays() {
        return holdingPeriodDays;
    }

    public void setHoldingPeriodDays(String holdingPeriodDays) {
        this.holdingPeriodDays = holdingPeriodDays;
    }

    public String getFromAcctNoJnl() {
        return fromAcctNoJnl;
    }

    public void setFromAcctNoJnl(String fromAcctNoJnl) {
        this.fromAcctNoJnl = fromAcctNoJnl;
    }

    public String getToAcctNoJnl() {
        return toAcctNoJnl;
    }

    public void setToAcctNoJnl(String toAcctNoJnl) {
        this.toAcctNoJnl = toAcctNoJnl;
    }

    public String getCbSetupInd() {
        return cbSetupInd;
    }

    public void setCbSetupInd(String cbSetupInd) {
        this.cbSetupInd = cbSetupInd;
    }

    public String getXchgRateFmv() {
        return xchgRateFmv;
    }

    public void setXchgRateFmv(String xchgRateFmv) {
        this.xchgRateFmv = xchgRateFmv;
    }

    public String getAdjIssuePrx() {
        return adjIssuePrx;
    }

    public void setAdjIssuePrx(String adjIssuePrx) {
        this.adjIssuePrx = adjIssuePrx;
    }

    public String getAcqPremAmt() {
        return acqPremAmt;
    }

    public void setAcqPremAmt(String acqPremAmt) {
        this.acqPremAmt = acqPremAmt;
    }

    public String getMktDiscAmt() {
        return mktDiscAmt;
    }

    public void setMktDiscAmt(String mktDiscAmt) {
        this.mktDiscAmt = mktDiscAmt;
    }

    public String getMktDiscCalcCode() {
        return mktDiscCalcCode;
    }

    public void setMktDiscCalcCode(String mktDiscCalcCode) {
        this.mktDiscCalcCode = mktDiscCalcCode;
    }

    public String getOidTaxableInd() {
        return oidTaxableInd;
    }

    public void setOidTaxableInd(String oidTaxableInd) {
        this.oidTaxableInd = oidTaxableInd;
    }

    public String getPremAmortInd() {
        return premAmortInd;
    }

    public void setPremAmortInd(String premAmortInd) {
        this.premAmortInd = premAmortInd;
    }

    public String getMktDiscAccretInd() {
        return mktDiscAccretInd;
    }

    public void setMktDiscAccretInd(String mktDiscAccretInd) {
        this.mktDiscAccretInd = mktDiscAccretInd;
    }

    public String getSpotRateInd() {
        return spotRateInd;
    }

    public void setSpotRateInd(String spotRateInd) {
        this.spotRateInd = spotRateInd;
    }

    public String getAcatAdjCostAmt() {
        return acatAdjCostAmt;
    }

    public void setAcatAdjCostAmt(String acatAdjCostAmt) {
        this.acatAdjCostAmt = acatAdjCostAmt;
    }

    public String getAcatChangeCymd() {
        return acatChangeCymd;
    }

    public void setAcatChangeCymd(String acatChangeCymd) {
        this.acatChangeCymd = acatChangeCymd;
    }

    public String getCalcToCymd() {
        return calcToCymd;
    }

    public void setCalcToCymd(String calcToCymd) {
        this.calcToCymd = calcToCymd;
    }

    public String getMktDiscDailyRate() {
        return mktDiscDailyRate;
    }

    public void setMktDiscDailyRate(String mktDiscDailyRate) {
        this.mktDiscDailyRate = mktDiscDailyRate;
    }

    public String getAcqPremDailyRate() {
        return acqPremDailyRate;
    }

    public void setAcqPremDailyRate(String acqPremDailyRate) {
        this.acqPremDailyRate = acqPremDailyRate;
    }

    public String getCorpActionCode() {
        return corpActionCode;
    }

    public void setCorpActionCode(String corpActionCode) {
        this.corpActionCode = corpActionCode;
    }

    public String getNoDebtCostInd() {
        return noDebtCostInd;
    }

    public void setNoDebtCostInd(String noDebtCostInd) {
        this.noDebtCostInd = noDebtCostInd;
    }

    public String getDebtCostAmt() {
        return debtCostAmt;
    }

    public void setDebtCostAmt(String debtCostAmt) {
        this.debtCostAmt = debtCostAmt;
    }

    public String getDeflationAdjAmt() {
        return deflationAdjAmt;
    }

    public void setDeflationAdjAmt(String deflationAdjAmt) {
        this.deflationAdjAmt = deflationAdjAmt;
    }

    public String getCpdiNetAdjAmt() {
        return cpdiNetAdjAmt;
    }

    public void setCpdiNetAdjAmt(String cpdiNetAdjAmt) {
        this.cpdiNetAdjAmt = cpdiNetAdjAmt;
    }

    public String getNqsiDailyRate() {
        return nqsiDailyRate;
    }

    public void setNqsiDailyRate(String nqsiDailyRate) {
        this.nqsiDailyRate = nqsiDailyRate;
    }

    public String getNqsiTotAmt() {
        return nqsiTotAmt;
    }

    public void setNqsiTotAmt(String nqsiTotAmt) {
        this.nqsiTotAmt = nqsiTotAmt;
    }

    public String getOrigYield() {
        return origYield;
    }

    public void setOrigYield(String origYield) {
        this.origYield = origYield;
    }

    public String getPurchYield() {
        return purchYield;
    }

    public void setPurchYield(String purchYield) {
        this.purchYield = purchYield;
    }

    public String getInclusionFrac() {
        return inclusionFrac;
    }

    public void setInclusionFrac(String inclusionFrac) {
        this.inclusionFrac = inclusionFrac;
    }

}