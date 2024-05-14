package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;
public class SecOsiCsvBean extends CsvBean {


    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "symbol")private String symbol;
    @CsvBindByName(column = "cusip")private String cusip;
    @CsvBindByName(column = "alpha_key")private String alphaKey;
    @CsvBindByName(column = "alpha_key_2")private String alphaKey2;
    @CsvBindByName(column = "alpha_key_5")private String alphaKey5;
    @CsvBindByName(column = "desc")private String desc1;
    @CsvBindByName(column = "desc_2")private String desc2;
    @CsvBindByName(column = "desc_3")private String desc3;
    @CsvBindByName(column = "sec_type")private String secType;
    @CsvBindByName(column = "last_close_prx")private String lastClosePrx;
    @CsvBindByName(column = "prx_change_cymd")private String prxChangeCymd;
    @CsvBindByName(column = "prx_change_term")private String prxChangeTerm;
    @CsvBindByName(column = "month_end_prx")private String monthEndPrx;
    @CsvBindByName(column = "month_end_prx_cymd")private String monthEndPrxCymd;
    @CsvBindByName(column = "month_end_term")private String monthEndTerm;
    @CsvBindByName(column = "year_end_prx")private String yearEndPrx;
    @CsvBindByName(column = "year_end_cymd")private String yearEndCymd;
    @CsvBindByName(column = "eoy_prx_term")private String eoyPrxTerm;
    @CsvBindByName(column = "desc_change_cymd")private String descChangeCymd;
    @CsvBindByName(column = "change_term")private String changeTerm;
    @CsvBindByName(column = "add_cymd")private String addCymd;
    @CsvBindByName(column = "add_term")private String addTerm;
    @CsvBindByName(column = "no_cusip_ind")private String noCusipInd;
    @CsvBindByName(column = "exp_symbol_desc")private String expSymbolDesc;
    @CsvBindByName(column = "min_prx_var_code")private String minPrxVarCode;
    @CsvBindByName(column = "annual_div_rate")private String annualDivRate;
    @CsvBindByName(column = "drs_elig_code")private String drsEligCode;
    @CsvBindByName(column = "day_count_code")private String dayCountCode;
    @CsvBindByName(column = "catchup_ind")private String catchupInd;
    @CsvBindByName(column = "arb_conv_factor")private String arbConvFactor;
    @CsvBindByName(column = "industry_grp_no")private String industryGrpNo;
    @CsvBindByName(column = "round_lot_qty")private String roundLotQty;
    @CsvBindByName(column = "oats_otc_exch_code")private String oatsOtcExchCode;
    @CsvBindByName(column = "earnings_per_shr_amt")private String earningsPerShrAmt;
    @CsvBindByName(column = "sec_note")private String secNote;
    @CsvBindByName(column = "sec_note_2")private String secNote2;
    @CsvBindByName(column = "muller_cymd")private String mullerCymd;
    @CsvBindByName(column = "muller_qty")private String mullerQty;
    @CsvBindByName(column = "non_listed_code")private String nonListedCode;
    @CsvBindByName(column = "fed_tax_code")private String fedTaxCode;
    @CsvBindByName(column = "bond_factor")private String bondFactor;
    @CsvBindByName(column = "sandp_code")private String sandpCode;
    @CsvBindByName(column = "call_bonds_code")private String callBondsCode;
    @CsvBindByName(column = "day_calc_code")private String dayCalcCode;
    @CsvBindByName(column = "bond_type_code")private String bondTypeCode;
    @CsvBindByName(column = "feature_cymd")private String featureCymd;
    @CsvBindByName(column = "feature_prx")private String featurePrx;
    @CsvBindByName(column = "feature_cymd_2")private String featureCymd2;
    @CsvBindByName(column = "feature_prx_2")private String featurePrx2;
    @CsvBindByName(column = "put_cymd")private String putCymd;
    @CsvBindByName(column = "pref_cymd")private String prefCymd;
    @CsvBindByName(column = "put_prx")private String putPrx;
    @CsvBindByName(column = "prerefund_prx")private String prerefundPrx;
    @CsvBindByName(column = "state_code")private String stateCode;
    @CsvBindByName(column = "int_pmt_cymd")private String intPmtCymd;
    @CsvBindByName(column = "maturity_exp_cymd")private String maturityExpCymd;
    @CsvBindByName(column = "coupon_rate")private String couponRate;
    @CsvBindByName(column = "first_cpn_cymd")private String firstCpnCymd;
    @CsvBindByName(column = "int_accrual_cymd")private String intAccrualCymd;
    @CsvBindByName(column = "kis_ind")private String kisInd;
    @CsvBindByName(column = "kis_cymd")private String kisCymd;
    @CsvBindByName(column = "prc_cymd")private String prcCymd;
    @CsvBindByName(column = "frc_cymd")private String frcCymd;
    @CsvBindByName(column = "factor_cymd")private String factorCymd;
    @CsvBindByName(column = "current_factor")private String currentFactor;
    @CsvBindByName(column = "prev_factor")private String prevFactor;
    @CsvBindByName(column = "issue_disc_code")private String issueDiscCode;
    @CsvBindByName(column = "put_notify_days")private String putNotifyDays;
    @CsvBindByName(column = "skip_kenny_ind")private String skipKennyInd;
    @CsvBindByName(column = "year_end_rpt_code")private String yearEndRptCode;
    @CsvBindByName(column = "cmo_agent_code")private String cmoAgentCode;
    @CsvBindByName(column = "bond_sub_code")private String bondSubCode;
    @CsvBindByName(column = "specific_pool_code")private String specificPoolCode;
    @CsvBindByName(column = "rann_upd_src_ind")private String rannUpdSrcInd;
    @CsvBindByName(column = "rann_upd_cymd")private String rannUpdCymd;
    @CsvBindByName(column = "last_fri_me_cymd")private String lastFriMeCymd;
    @CsvBindByName(column = "last_fri_me_prx")private String lastFriMePrx;
    @CsvBindByName(column = "ipo_prx")private String ipoPrx;
    @CsvBindByName(column = "tax_qual_ind")private String taxQualInd;
    @CsvBindByName(column = "foreign_sedol_no")private String foreignSedolNo;
    @CsvBindByName(column = "type_class_code")private String typeClassCode;
    @CsvBindByName(column = "uit_accrued_amt")private String uitAccruedAmt;
    @CsvBindByName(column = "expire_cymd")private String expireCymd;
    @CsvBindByName(column = "optn_code")private String optnCode;
    @CsvBindByName(column = "underlying_sec_no")private String underlyingSecNo;
    @CsvBindByName(column = "strike_prx")private String strikePrx;
    @CsvBindByName(column = "whole_conv_factor")private String wholeConvFactor;
    @CsvBindByName(column = "dec_conv_factor")private String decConvFactor;
    @CsvBindByName(column = "underlying_opt_sec_no")private String underlyingOptSecNo;
    @CsvBindByName(column = "cap_interval_no")private String capIntervalNo;
    @CsvBindByName(column = "dtc_frac_cusip")private String dtcFracCusip;
    @CsvBindByName(column = "ccs_code")private String ccsCode;
    @CsvBindByName(column = "ncc_code")private String nccCode;
    @CsvBindByName(column = "hand_fig_ind")private String handFigInd;
    @CsvBindByName(column = "flat_code")private String flatCode;
    @CsvBindByName(column = "div_pay_freq_code")private String divPayFreqCode;
    @CsvBindByName(column = "rgst_code")private String rgstCode;
    @CsvBindByName(column = "dtc_chill_deposit_ind")private String dtcChillDepositInd;
    @CsvBindByName(column = "dtc_chill_ind")private String dtcChillInd;
    @CsvBindByName(column = "dtc_chill_wt_ind")private String dtcChillWtInd;
    @CsvBindByName(column = "dtc_chill_do_ind")private String dtcChillDoInd;
    @CsvBindByName(column = "dtc_chill_pledge_ind")private String dtcChillPledgeInd;
    @CsvBindByName(column = "dtc_chill_seg_ind")private String dtcChillSegInd;
    @CsvBindByName(column = "dtc_frozen_ind")private String dtcFrozenInd;
    @CsvBindByName(column = "foreign_code")private String foreignCode;
    @CsvBindByName(column = "mstr_limit_partner_ind")private String mstrLimitPartnerInd;
    @CsvBindByName(column = "nra_exempt_ind")private String nraExemptInd;
    @CsvBindByName(column = "dtc_fed_fund_ind")private String dtcFedFundInd;
    @CsvBindByName(column = "margin_code")private String marginCode;
    @CsvBindByName(column = "pros_end_cymd")private String prosEndCymd;
    @CsvBindByName(column = "unit_qty")private String unitQty;
    @CsvBindByName(column = "mbscc_code")private String mbsccCode;
    @CsvBindByName(column = "reinvest_elig_ind")private String reinvestEligInd;
    @CsvBindByName(column = "bid_prx")private String bidPrx;
    @CsvBindByName(column = "ask_prx")private String askPrx;
    @CsvBindByName(column = "crncy_code")private String crncyCode;
    @CsvBindByName(column = "crncy_type")private String crncyType;
    @CsvBindByName(column = "euroclr_id")private String euroclrId;
    @CsvBindByName(column = "reissue_cymd")private String reissueCymd;
    @CsvBindByName(column = "last_div_rate")private String lastDivRate;
    @CsvBindByName(column = "last_div_cymd")private String lastDivCymd;
    @CsvBindByName(column = "div_payments_qty")private String divPaymentsQty;
    @CsvBindByName(column = "crncy_sec_no")private String crncySecNo;
    @CsvBindByName(column = "country_code")private String countryCode;
    @CsvBindByName(column = "defered_sales_ind")private String deferedSalesInd;
    @CsvBindByName(column = "gov_proc_code")private String govProcCode;
    @CsvBindByName(column = "build_bond_ind")private String buildBondInd;
    @CsvBindByName(column = "fund_code")private String fundCode;
    @CsvBindByName(column = "moodys_code")private String moodysCode;
    @CsvBindByName(column = "mf_share_class_id")private String mfShareClassId;
    @CsvBindByName(column = "variable_rate")private String variableRate;
    @CsvBindByName(column = "new_sec_code")private String newSecCode;
    @CsvBindByName(column = "sort_group_code")private String sortGroupCode;
    @CsvBindByName(column = "sort_alpha_key")private String sortAlphaKey;
    @CsvBindByName(column = "bond_reg_code")private String bondRegCode;
    @CsvBindByName(column = "call_frequency_code")private String callFrequencyCode;
    @CsvBindByName(column = "escrow_code")private String escrowCode;
    @CsvBindByName(column = "insured_status_code")private String insuredStatusCode;
    @CsvBindByName(column = "int_payment_code")private String intPaymentCode;
    @CsvBindByName(column = "partial_redeem_code")private String partialRedeemCode;
    @CsvBindByName(column = "put_frequency_code")private String putFrequencyCode;
    @CsvBindByName(column = "adjustable_rate_code")private String adjustableRateCode;
    @CsvBindByName(column = "conv_factor_code")private String convFactorCode;
    @CsvBindByName(column = "zero_coupon_code")private String zeroCouponCode;
    @CsvBindByName(column = "guarantee_code")private String guaranteeCode;
    @CsvBindByName(column = "ny_post_no")private String nyPostNo;
    @CsvBindByName(column = "non_transfer_ind")private String nonTransferInd;
    @CsvBindByName(column = "put_or_call_ind")private String putOrCallInd;
    @CsvBindByName(column = "osi_ul_symbol")private String osiUlSymbol;
    @CsvBindByName(column = "expiration_cymd")private String expirationCymd;
    @CsvBindByName(column = "strike_prx_exp")private String strikePrxExp;
    @CsvBindByName(column = "taxlot_cover_cymd")private String taxlotCoverCymd;
    @CsvBindByName(column = "des2_change_term")private String des2ChangeTerm;

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
