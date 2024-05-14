package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class TaxlCsvBean extends CsvBean {


    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "open_tax_lot_id")private String openTaxLotId;
    @CsvBindByName(column = "close_tax_lot_id")private String closeTaxLotId;
    @CsvBindByName(column = "open_close_ind")private String openCloseInd;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "add_tms")private String addTms;
    @CsvBindByName(column = "add_user_id")private String addUserId;
    @CsvBindByName(column = "add_who_code")private String addWhoCode;
    @CsvBindByName(column = "add_term")private String addTerm;
    @CsvBindByName(column = "change_user_tms")private String changeUserTms;
    @CsvBindByName(column = "change_sys_tms")private String changeSysTms;
    @CsvBindByName(column = "change_user_who_code")private String changeUserWhoCode;
    @CsvBindByName(column = "change_user_term")private String changeUserTerm;
    @CsvBindByName(column = "change_user_id")private String changeUserId;
    @CsvBindByName(column = "change_sys_job_id")private String changeSysJobId;
    @CsvBindByName(column = "change_sys_progrm_id")private String changeSysProgrmId;
    @CsvBindByName(column = "tax_lot_qty")private String taxLotQty;
    @CsvBindByName(column = "held_away_ind")private String heldAwayInd;
    @CsvBindByName(column = "repo_tran_ind")private String repoTranInd;
    @CsvBindByName(column = "repo_reverse_ind")private String repoReverseInd;
    @CsvBindByName(column = "level_4_ind")private String level4Ind;
    @CsvBindByName(column = "annuity_pstn_ind")private String annuityPstnInd;
    @CsvBindByName(column = "acat_cbrs_ind")private String acatCbrsInd;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "control_no")private String controlNo;
    @CsvBindByName(column = "apply_principal_uit_ind")private String applyPrincipalUitInd;
    @CsvBindByName(column = "apply_principal_mlp_ind")private String applyPrincipalMlpInd;
    @CsvBindByName(column = "apply_liquidation_ind")private String applyLiquidationInd;
    @CsvBindByName(column = "apply_factor_ind")private String applyFactorInd;
    @CsvBindByName(column = "apply_oid_ind")private String applyOidInd;
    @CsvBindByName(column = "optn_proceed_amt")private String optnProceedAmt;
    @CsvBindByName(column = "paydown_amt")private String paydownAmt;
    @CsvBindByName(column = "liquidation_amt")private String liquidationAmt;
    @CsvBindByName(column = "oid_accrued_amt")private String oidAccruedAmt;
    @CsvBindByName(column = "crncy_type")private String crncyType;
    @CsvBindByName(column = "auto_trade_code")private String autoTradeCode;
    @CsvBindByName(column = "yield_rate")private String yieldRate;
    @CsvBindByName(column = "yield_code")private String yieldCode;
    @CsvBindByName(column = "yield_ovrd_code")private String yieldOvrdCode;
    @CsvBindByName(column = "oid_yield_maturity_rate")private String oidYieldMaturityRate;
    @CsvBindByName(column = "addl_user_desc")private String addlUserDesc;
    @CsvBindByName(column = "order_no")private String orderNo;
    @CsvBindByName(column = "annuity_contract_id")private String annuityContractId;
    @CsvBindByName(column = "adj_basis_ind")private String adjBasisInd;
    @CsvBindByName(column = "open_cymd")private String openCymd;
    @CsvBindByName(column = "open_srce_code")private String openSrceCode;
    @CsvBindByName(column = "last_activ_srce_code")private String lastActivSrceCode;
    @CsvBindByName(column = "last_activ_srce_code_adj_sw")private String lastActivSrceCodeAdjSw;
    @CsvBindByName(column = "open_entry_frozen_ind")private String openEntryFrozenInd;
    @CsvBindByName(column = "open_srce_code_adj_ind")private String openSrceCodeAdjInd;
    @CsvBindByName(column = "no_open_cost_ind")private String noOpenCostInd;
    @CsvBindByName(column = "open_cost_amt")private String openCostAmt;
    @CsvBindByName(column = "no_open_price_ind")private String noOpenPriceInd;
    @CsvBindByName(column = "open_prx")private String openPrx;
    @CsvBindByName(column = "no_open_factor_ind")private String noOpenFactorInd;
    @CsvBindByName(column = "open_factor")private String openFactor;
    @CsvBindByName(column = "pend_dist_ind")private String pendDistInd;
    @CsvBindByName(column = "open_adj_cost_amt")private String openAdjCostAmt;
    @CsvBindByName(column = "open_mkt_amt")private String openMktAmt;
    @CsvBindByName(column = "unrealized_gain_loss_amt")private String unrealizedGainLossAmt;
    @CsvBindByName(column = "open_gain_loss_term_ind")private String openGainLossTermInd;
    @CsvBindByName(column = "daily_accretion_rate")private String dailyAccretionRate;
    @CsvBindByName(column = "daily_amort_rate")private String dailyAmortRate;
    @CsvBindByName(column = "open_settle_cymd")private String openSettleCymd;
    @CsvBindByName(column = "close_cymd")private String closeCymd;
    @CsvBindByName(column = "close_srce_code")private String closeSrceCode;
    @CsvBindByName(column = "close_adj_srce_code_ind")private String closeAdjSrceCodeInd;
    @CsvBindByName(column = "desc")private String descField;
    @CsvBindByName(column = "no_close_cost_ind")private String noCloseCostInd;
    @CsvBindByName(column = "close_cost_amt")private String closeCostAmt;
    @CsvBindByName(column = "no_close_price_ind")private String noClosePriceInd;
    @CsvBindByName(column = "close_prx")private String closePrx;
    @CsvBindByName(column = "no_close_factor_ind")private String noCloseFactorInd;
    @CsvBindByName(column = "close_factor")private String closeFactor;
    @CsvBindByName(column = "close_adj_cost_amt")private String closeAdjCostAmt;
    @CsvBindByName(column = "no_stk_rec_pos_ind")private String noStkRecPosInd;
    @CsvBindByName(column = "sale_by_tax_lot_ind")private String saleByTaxLotInd;
    @CsvBindByName(column = "box_cymd")private String boxCymd;
    @CsvBindByName(column = "suppress_tax_lot_ind")private String suppressTaxLotInd;
    @CsvBindByName(column = "realized_gain_loss_amt")private String realizedGainLossAmt;
    @CsvBindByName(column = "close_gain_loss_term_code")private String closeGainLossTermCode;
    @CsvBindByName(column = "close_entry_frozen_ind")private String closeEntryFrozenInd;
    @CsvBindByName(column = "close_settle_cymd")private String closeSettleCymd;
    @CsvBindByName(column = "user_xref_id")private String userXrefId;
    @CsvBindByName(column = "add_trans_cymd")private String addTransCymd;
    @CsvBindByName(column = "add_job_id")private String addJobId;
    @CsvBindByName(column = "de_minimis_ind")private String deMinimisInd;
    @CsvBindByName(column = "oid_error_ind")private String oidErrorInd;
    @CsvBindByName(column = "amort_amt")private String amortAmt;
    @CsvBindByName(column = "sys_chg_tran_cymd")private String sysChgTranCymd;
    @CsvBindByName(column = "user_chg_tran_cymd")private String userChgTranCymd;
    @CsvBindByName(column = "mkt_yld_mat_rate")private String mktYldMatRate;
    @CsvBindByName(column = "mkt_diff_id")private String mktDiffId;
    @CsvBindByName(column = "acquisition_accreted_amt")private String acquisitionAccretedAmt;
    @CsvBindByName(column = "tax_lot_id")private String taxLotId;
    @CsvBindByName(column = "prev_ind")private String prevInd;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "adj_gain_loss_amt")private String adjGainLossAmt;
    @CsvBindByName(column = "adj_prx")private String adjPrx;
    @CsvBindByName(column = "cost_alloc_code")private String costAllocCode;
    @CsvBindByName(column = "avg_prx")private String avgPrx;
    @CsvBindByName(column = "wash_sale_amt")private String washSaleAmt;
    @CsvBindByName(column = "undst_ltrm_cap_amt")private String undstLtrmCapAmt;
    @CsvBindByName(column = "tax_lot_cover_ind")private String taxLotCoverInd;
    @CsvBindByName(column = "tax_lot_xfer_cymd")private String taxLotXferCymd;
    @CsvBindByName(column = "cbrs_dlvr_ctrl_no")private String cbrsDlvrCtrlNo;
    @CsvBindByName(column = "cbrs_recv_ctrl_no")private String cbrsRecvCtrlNo;
    @CsvBindByName(column = "cbrs_alt_ctrl_no")private String cbrsAltCtrlNo;
    @CsvBindByName(column = "recv_cbrs_partic_no")private String recvCbrsParticNo;
    @CsvBindByName(column = "dlvr_cbrs_partic_no")private String dlvrCbrsParticNo;
    @CsvBindByName(column = "cert_no")private String certNo;
    @CsvBindByName(column = "gain_loss_amt_known_ind")private String gainLossAmtKnownInd;
    @CsvBindByName(column = "tax_lot_open_xfer_code")private String taxLotOpenXferCode;
    @CsvBindByName(column = "tax_lot_open_fmv_amt")private String taxLotOpenFmvAmt;
    @CsvBindByName(column = "open_wash_sale_cymd")private String openWashSaleCymd;
    @CsvBindByName(column = "tax_lot_close_xfer_code")private String taxLotCloseXferCode;
    @CsvBindByName(column = "tax_lot_close_fmv_amt")private String taxLotCloseFmvAmt;
    @CsvBindByName(column = "close_wash_sale_cymd")private String closeWashSaleCymd;
    @CsvBindByName(column = "atd_unique_key")private String atdUniqueKey;
    @CsvBindByName(column = "stloss_to_ltloss_amt")private String stlossToLtlossAmt;
    @CsvBindByName(column = "taxl_avg_cost_code")private String taxlAvgCostCode;
    @CsvBindByName(column = "taxl_drp_ind")private String taxlDrpInd;
    @CsvBindByName(column = "open_avg_cost_amt")private String openAvgCostAmt;
    @CsvBindByName(column = "clos_disallow_loss_amt")private String closDisallowLossAmt;
    @CsvBindByName(column = "no_orig_open_cost_ind")private String noOrigOpenCostInd;
    @CsvBindByName(column = "clos_orig_open_cost_amt")private String closOrigOpenCostAmt;
    @CsvBindByName(column = "clos_opt_proc_amt")private String closOptProcAmt;
    @CsvBindByName(column = "clos_firm_lvl_4_ind")private String closFirmLvl4Ind;
    @CsvBindByName(column = "hold_start_cymd")private String holdStartCymd;
    @CsvBindByName(column = "holding_period_days")private String holdingPeriodDays;
    @CsvBindByName(column = "from_acct_no_jnl")private String fromAcctNoJnl;
    @CsvBindByName(column = "to_acct_no_jnl")private String toAcctNoJnl;
    @CsvBindByName(column = "cb_setup_ind")private String cbSetupInd;
    @CsvBindByName(column = "xchg_rate_fmv")private String xchgRateFmv;
    @CsvBindByName(column = "adj_issue_prx")private String adjIssuePrx;
    @CsvBindByName(column = "acq_prem_amt")private String acqPremAmt;
    @CsvBindByName(column = "mkt_disc_amt")private String mktDiscAmt;
    @CsvBindByName(column = "mkt_disc_calc_code")private String mktDiscCalcCode;
    @CsvBindByName(column = "oid_taxable_ind")private String oidTaxableInd;
    @CsvBindByName(column = "prem_amort_ind")private String premAmortInd;
    @CsvBindByName(column = "mkt_disc_accret_ind")private String mktDiscAccretInd;
    @CsvBindByName(column = "spot_rate_ind")private String spotRateInd;
    @CsvBindByName(column = "acat_adj_cost_amt")private String acatAdjCostAmt;
    @CsvBindByName(column = "acat_change_cymd")private String acatChangeCymd;
    @CsvBindByName(column = "calc_to_cymd")private String calcToCymd;
    @CsvBindByName(column = "mkt_disc_daily_rate")private String mktDiscDailyRate;
    @CsvBindByName(column = "acq_prem_daily_rate")private String acqPremDailyRate;
    @CsvBindByName(column = "corp_action_code")private String corpActionCode;
    @CsvBindByName(column = "no_debt_cost_ind")private String noDebtCostInd;
    @CsvBindByName(column = "debt_cost_amt")private String debtCostAmt;
    @CsvBindByName(column = "deflation_adj_amt")private String deflationAdjAmt;
    @CsvBindByName(column = "cpdi_net_adj_amt")private String cpdiNetAdjAmt;
    @CsvBindByName(column = "nqsi_daily_rate")private String nqsiDailyRate;
    @CsvBindByName(column = "nqsi_tot_amt")private String nqsiTotAmt;
    @CsvBindByName(column = "orig_yield")private String origYield;
    @CsvBindByName(column = "purch_yield")private String purchYield;
    @CsvBindByName(column = "inclusion_frac")private String inclusionFrac;

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
