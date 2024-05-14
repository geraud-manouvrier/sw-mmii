package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class TrdOsiCsvBean extends CsvBean {

    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "acct_class_code")private String acctClassCode;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "cusip")private String cusip;
    @CsvBindByName(column = "sec_type")private String secType;
    @CsvBindByName(column = "class_code")private String classCode;
    @CsvBindByName(column = "symbol")private String symbol;
    @CsvBindByName(column = "mgn_code")private String mgnCode;
    @CsvBindByName(column = "std_instruc_code")private String stdInstrucCode;
    @CsvBindByName(column = "trade_cymd")private String tradeCymd;
    @CsvBindByName(column = "asof_cymd")private String asofCymd;
    @CsvBindByName(column = "settle_cymd")private String settleCymd;
    @CsvBindByName(column = "origin_code")private String originCode;
    @CsvBindByName(column = "tran_id")private String tranId;
    @CsvBindByName(column = "control_no")private String controlNo;
    @CsvBindByName(column = "big_qty")private String bigQty;
    @CsvBindByName(column = "big_prx")private String bigPrx;
    @CsvBindByName(column = "buy_sell_ind")private String buySellInd;
    @CsvBindByName(column = "big_exch_type")private String bigExchType;
    @CsvBindByName(column = "net_amt")private String netAmt;
    @CsvBindByName(column = "offset_acct_no")private String offsetAcctNo;
    @CsvBindByName(column = "offset_type")private String offsetType;
    @CsvBindByName(column = "generic_user_field_type")private String genericUserFieldType;
    @CsvBindByName(column = "tag_no")private String tagNo;
    @CsvBindByName(column = "crncy_type")private String crncyType;
    @CsvBindByName(column = "broker_no")private String brokerNo;
    @CsvBindByName(column = "noncustomer_ind")private String noncustomerInd;
    @CsvBindByName(column = "desc")private String desc1;
    @CsvBindByName(column = "desc_2")private String desc2;
    @CsvBindByName(column = "desc_3")private String desc3;
    @CsvBindByName(column = "desc_4")private String desc4;
    @CsvBindByName(column = "desc_5")private String desc5;
    @CsvBindByName(column = "desc_6")private String desc6;
    @CsvBindByName(column = "mlp_ind")private String mlpInd;
    @CsvBindByName(column = "firm_capacity_code")private String firmCapacityCode;
    @CsvBindByName(column = "div_reinvest_code")private String divReinvestCode;
    @CsvBindByName(column = "muni_cb_code")private String muniCbCode;
    @CsvBindByName(column = "bond_class_code")private String bondClassCode;
    @CsvBindByName(column = "coupon_rate")private String couponRate;
    @CsvBindByName(column = "conv_factor")private String convFactor;
    @CsvBindByName(column = "tto_ind")private String ttoInd;
    @CsvBindByName(column = "tto_rep")private String ttoRep;
    @CsvBindByName(column = "state_code")private String stateCode;
    @CsvBindByName(column = "tax_id")private String taxId;
    @CsvBindByName(column = "order_no")private String orderNo;
    @CsvBindByName(column = "limit_market_ind")private String limitMarketInd;
    @CsvBindByName(column = "reported_trd_prx")private String reportedTrdPrx;
    @CsvBindByName(column = "price_factor")private String priceFactor;
    @CsvBindByName(column = "basis_prx")private String basisPrx;
    @CsvBindByName(column = "basis_yield_pct")private String basisYieldPct;
    @CsvBindByName(column = "hand_fig_ind")private String handFigInd;
    @CsvBindByName(column = "use_net_amt_ind")private String useNetAmtInd;
    @CsvBindByName(column = "principal_amt")private String principalAmt;
    @CsvBindByName(column = "interest_amt")private String interestAmt;
    @CsvBindByName(column = "sec_fee_amt")private String secFeeAmt;
    @CsvBindByName(column = "comm_amt")private String commAmt;
    @CsvBindByName(column = "gross_comm_pct")private String grossCommPct;
    @CsvBindByName(column = "gross_pcnt_ind")private String grossPcntInd;
    @CsvBindByName(column = "concession_amt")private String concessionAmt;
    @CsvBindByName(column = "handle_fee_amt")private String handleFeeAmt;
    @CsvBindByName(column = "lal_comm_amt")private String lalCommAmt;
    @CsvBindByName(column = "equiv_disc_pct")private String equivDiscPct;
    @CsvBindByName(column = "comm_disc_code")private String commDiscCode;
    @CsvBindByName(column = "disc_rate")private String discRate;
    @CsvBindByName(column = "total_ord_qty")private String totalOrdQty;
    @CsvBindByName(column = "total_ord_comm_amt")private String totalOrdCommAmt;
    @CsvBindByName(column = "postage_amt")private String postageAmt;
    @CsvBindByName(column = "sec_class_code")private String secClassCode;
    @CsvBindByName(column = "cancel_ind")private String cancelInd;
    @CsvBindByName(column = "rebill_ind")private String rebillInd;
    @CsvBindByName(column = "cancel_reason_type")private String cancelReasonType;
    @CsvBindByName(column = "spcl_type_code")private String spclTypeCode;
    @CsvBindByName(column = "spcl_type_code_2")private String spclTypeCode2;
    @CsvBindByName(column = "spcl_type_code_3")private String spclTypeCode3;
    @CsvBindByName(column = "confirm_note")private String confirmNote;
    @CsvBindByName(column = "syndicate_ind")private String syndicateInd;
    @CsvBindByName(column = "execution_time")private String executionTime;
    @CsvBindByName(column = "comm_sched_no")private String commSchedNo;
    @CsvBindByName(column = "euroclear_id")private String euroclearId;
    @CsvBindByName(column = "product_type")private String productType;
    @CsvBindByName(column = "order_srce_code")private String orderSrceCode;
    @CsvBindByName(column = "dealer_no")private String dealerNo;
    @CsvBindByName(column = "nasdaq_symbol")private String nasdaqSymbol;
    @CsvBindByName(column = "ncc_contra_brkr_no")private String nccContraBrkrNo;
    @CsvBindByName(column = "odd_lot_diff_code")private String oddLotDiffCode;
    @CsvBindByName(column = "auto_exch_code")private String autoExchCode;
    @CsvBindByName(column = "occ_ind")private String occInd;
    @CsvBindByName(column = "auto_trade_code")private String autoTradeCode;
    @CsvBindByName(column = "atd_unique_key")private String atdUniqueKey;
    @CsvBindByName(column = "program_no")private String programNo;
    @CsvBindByName(column = "net_fee_amt")private String netFeeAmt;
    @CsvBindByName(column = "trd_exec_tms")private String trdExecTms;
    @CsvBindByName(column = "adj_ind")private String adjInd;
    @CsvBindByName(column = "reinvest_ind")private String reinvestInd;
    @CsvBindByName(column = "free_credit_ind")private String freeCreditInd;
    @CsvBindByName(column = "exec_count")private String execCount;
    @CsvBindByName(column = "tax_lot_ind")private String taxLotInd;
    @CsvBindByName(column = "originator_id")private String originatorId;
    @CsvBindByName(column = "tto_sub_no")private String ttoSubNo;
    @CsvBindByName(column = "tto_branch")private String ttoBranch;
    @CsvBindByName(column = "internet_order_ind")private String internetOrderInd;
    @CsvBindByName(column = "frgn_exch_ind")private String frgnExchInd;
    @CsvBindByName(column = "yield_ovrd_ind")private String yieldOvrdInd;
    @CsvBindByName(column = "prime_brkr_code")private String primeBrkrCode;
    @CsvBindByName(column = "avg_price_ind")private String avgPriceInd;
    @CsvBindByName(column = "inst_id")private String instId;
    @CsvBindByName(column = "yield_to_mat_rate")private String yieldToMatRate;
    @CsvBindByName(column = "maturity_cymd")private String maturityCymd;
    @CsvBindByName(column = "new_sec_type")private String newSecType;
    @CsvBindByName(column = "sort_group_code")private String sortGroupCode;
    @CsvBindByName(column = "sort_alpha_key")private String sortAlphaKey;
    @CsvBindByName(column = "branch")private String branch;
    @CsvBindByName(column = "rept_avg_trd_prx")private String reptAvgTrdPrx;
    @CsvBindByName(column = "sec_var_rate_code")private String secVarRateCode;
    @CsvBindByName(column = "skip_handle_ind")private String skipHandleInd;
    @CsvBindByName(column = "contra_sub_no")private String contraSubNo;
    @CsvBindByName(column = "memo_inv_int_amt")private String memoInvIntAmt;
    @CsvBindByName(column = "internal_uid")private String internalUid;
    @CsvBindByName(column = "internal_rid")private String internalRid;
    @CsvBindByName(column = "trailer_rid")private String trailerRid;
    @CsvBindByName(column = "internal_aid")private String internalAid;
    @CsvBindByName(column = "internal_oid")private String internalOid;
    @CsvBindByName(column = "pfd_int_amt")private String pfdIntAmt;
    @CsvBindByName(column = "tpd_ind")private String tpdInd;
    @CsvBindByName(column = "app_type_code")private String appTypeCode;
    @CsvBindByName(column = "spcl_type_new_code")private String spclTypeNewCode;
    @CsvBindByName(column = "spcl_type_new_code_2")private String spclTypeNewCode2;
    @CsvBindByName(column = "spcl_type_new_code_3")private String spclTypeNewCode3;
    @CsvBindByName(column = "spcl_type_new_code_4")private String spclTypeNewCode4;
    @CsvBindByName(column = "spcl_type_new_code_5")private String spclTypeNewCode5;
    @CsvBindByName(column = "sec_fee_amt_ind")private String secFeeAmtInd;
    @CsvBindByName(column = "lal_amt_ind")private String lalAmtInd;
    @CsvBindByName(column = "basis_ind")private String basisInd;
    @CsvBindByName(column = "factor_ind")private String factorInd;
    @CsvBindByName(column = "handle_amt_ind")private String handleAmtInd;
    @CsvBindByName(column = "exp_gross_ind")private String expGrossInd;
    @CsvBindByName(column = "comm_cps_ind")private String commCpsInd;
    @CsvBindByName(column = "comm_disc_ind")private String commDiscInd;
    @CsvBindByName(column = "postage_amt_ind")private String postageAmtInd;
    @CsvBindByName(column = "state_tax2_amt_ind")private String stateTax2AmtInd;
    @CsvBindByName(column = "sort_acct_no")private String sortAcctNo;
    @CsvBindByName(column = "wire_code")private String wireCode;
    @CsvBindByName(column = "wire_seq_no")private String wireSeqNo;
    @CsvBindByName(column = "cripple_ind")private String crippleInd;
    @CsvBindByName(column = "full_comm_amt")private String fullCommAmt;
    @CsvBindByName(column = "total_full_ord_comm_amt")private String totalFullOrdCommAmt;
    @CsvBindByName(column = "accr_unit_int_qty")private String accrUnitIntQty;
    @CsvBindByName(column = "est_par_value_amt")private String estParValueAmt;
    @CsvBindByName(column = "current_yld_amt")private String currentYldAmt;
    @CsvBindByName(column = "est_long_term_yld_rate")private String estLongTermYldRate;
    @CsvBindByName(column = "asof_mkt_value_amt")private String asofMktValueAmt;
    @CsvBindByName(column = "payout_code")private String payoutCode;
    @CsvBindByName(column = "nscc_ctrl_id")private String nsccCtrlId;
    @CsvBindByName(column = "tmkt_exp_prx")private String tmktExpPrx;
    @CsvBindByName(column = "tst_exp_prx")private String tstExpPrx;
    @CsvBindByName(column = "short_sale_review_code")private String shortSaleReviewCode;
    @CsvBindByName(column = "investor_code")private String investorCode;
    @CsvBindByName(column = "oats_otc_exch_code")private String oatsOtcExchCode;
    @CsvBindByName(column = "spcl_type_code_4")private String spclTypeCode4;
    @CsvBindByName(column = "spcl_type_code_5")private String spclTypeCode5;
    @CsvBindByName(column = "ttrailer_ind")private String ttrailerInd;
    @CsvBindByName(column = "current_vary_rate")private String currentVaryRate;
    @CsvBindByName(column = "mult_exch_ind")private String multExchInd;
    @CsvBindByName(column = "taway_market")private String tawayMarket;
    @CsvBindByName(column = "ppt_override_ind")private String pptOverrideInd;
    @CsvBindByName(column = "input_srce_code")private String inputSrceCode;
    @CsvBindByName(column = "put_call_ind")private String putCallInd;
    @CsvBindByName(column = "osi_ul_symbol")private String osiUlSymbol;
    @CsvBindByName(column = "expire_cymd")private String expireCymd;
    @CsvBindByName(column = "sec_strike_prx")private String secStrikePrx;
    @CsvBindByName(column = "mult_capacity_ind")private String multCapacityInd;
    @CsvBindByName(column = "repo_hold_ind")private String repoHoldInd;
    @CsvBindByName(column = "trace_symbol")private String traceSymbol;
    @CsvBindByName(column = "acct_mkt_value_amt")private String acctMktValueAmt;
    @CsvBindByName(column = "option_reg_fee_amt")private String optionRegFeeAmt;
    @CsvBindByName(column = "network_matrix_code")private String networkMatrixCode;
    @CsvBindByName(column = "margin_code")private String marginCode;
    @CsvBindByName(column = "large_trder_id")private String largeTrderId;
    @CsvBindByName(column = "non_listed_code")private String nonListedCode;
    @CsvBindByName(column = "min_prx_var_code")private String minPrxVarCode;
    @CsvBindByName(column = "tbasis_feat_code")private String tbasisFeatCode;
    @CsvBindByName(column = "tbasis_feat_cymd")private String tbasisFeatCymd;
    @CsvBindByName(column = "tbasis_feat_price")private String tbasisFeatPrice;
    @CsvBindByName(column = "tbasis_feat_code2")private String tbasisFeatCode2;
    @CsvBindByName(column = "tbasis_feat_cymd2")private String tbasisFeatCymd2;
    @CsvBindByName(column = "tbasis_yield2")private String tbasisYield2;
    @CsvBindByName(column = "tbasis_feat_price2")private String tbasisFeatPrice2;
    @CsvBindByName(column = "tenter_firm_mpid")private String tenterFirmMpid;
    @CsvBindByName(column = "exch_code")private String exchCode;
    @CsvBindByName(column = "pfd_int_not_incl_amt")private String pfdIntNotInclAmt;
    @CsvBindByName(column = "rebalance_ind")private String rebalanceInd;
    @CsvBindByName(column = "trace_report_ind")private String traceReportInd;
    @CsvBindByName(column = "trace_mod_code")private String traceModCode;
    @CsvBindByName(column = "trace_mod_code_2")private String traceModCode2;
    @CsvBindByName(column = "trace_mod_code_3")private String traceModCode3;
    @CsvBindByName(column = "trace_mod_code_4")private String traceModCode4;
    @CsvBindByName(column = "al_breakpt_lvl")private String alBreakptLvl;
    @CsvBindByName(column = "embedd_comm_disc")private String embeddCommDisc;
    @CsvBindByName(column = "embedd_comm_disc_code")private String embeddCommDiscCode;
    @CsvBindByName(column = "trans_ind")private String transInd;
    @CsvBindByName(column = "trade_fee")private String tradeFee;
    @CsvBindByName(column = "usd_conv_rate")private String usdConvRate;
    @CsvBindByName(column = "usd_equivalent")private String usdEquivalent;
    @CsvBindByName(column = "cx_exch_rate")private String cxExchRate;
    @CsvBindByName(column = "cx_ind")private String cxInd;
    @CsvBindByName(column = "prevail_mkt_prx")private String prevailMktPrx;
    @CsvBindByName(column = "mark_updn_amt")private String markUpdnAmt;
    @CsvBindByName(column = "mark_updn_amt_ind")private String markUpdnAmtInd;
    @CsvBindByName(column = "mark_updn_pct")private String markUpdnPct;
    @CsvBindByName(column = "mark_updn_pct_ind")private String markUpdnPctInd;
    @CsvBindByName(column = "exec_timestamp")private String execTimestamp;
    @CsvBindByName(column = "prior_ref_point_ts")private String priorRefPointTs;
    @CsvBindByName(column = "oats_assoc_ord_ind")private String oatsAssocOrdInd;
    @CsvBindByName(column = "waterfall_level")private String waterfallLevel;
    @CsvBindByName(column = "cat_report_ind")private String catReportInd;

    public String getBaReccode() {
        return baReccode;
    }

    public void setBaReccode(String baReccode) {
        this.baReccode = baReccode;
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

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctClassCode() {
        return acctClassCode;
    }

    public void setAcctClassCode(String acctClassCode) {
        this.acctClassCode = acctClassCode;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMgnCode() {
        return mgnCode;
    }

    public void setMgnCode(String mgnCode) {
        this.mgnCode = mgnCode;
    }

    public String getStdInstrucCode() {
        return stdInstrucCode;
    }

    public void setStdInstrucCode(String stdInstrucCode) {
        this.stdInstrucCode = stdInstrucCode;
    }

    public String getTradeCymd() {
        return tradeCymd;
    }

    public void setTradeCymd(String tradeCymd) {
        this.tradeCymd = tradeCymd;
    }

    public String getAsofCymd() {
        return asofCymd;
    }

    public void setAsofCymd(String asofCymd) {
        this.asofCymd = asofCymd;
    }

    public String getSettleCymd() {
        return settleCymd;
    }

    public void setSettleCymd(String settleCymd) {
        this.settleCymd = settleCymd;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }

    public String getBigQty() {
        return bigQty;
    }

    public void setBigQty(String bigQty) {
        this.bigQty = bigQty;
    }

    public String getBigPrx() {
        return bigPrx;
    }

    public void setBigPrx(String bigPrx) {
        this.bigPrx = bigPrx;
    }

    public String getBuySellInd() {
        return buySellInd;
    }

    public void setBuySellInd(String buySellInd) {
        this.buySellInd = buySellInd;
    }

    public String getBigExchType() {
        return bigExchType;
    }

    public void setBigExchType(String bigExchType) {
        this.bigExchType = bigExchType;
    }

    public String getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(String netAmt) {
        this.netAmt = netAmt;
    }

    public String getOffsetAcctNo() {
        return offsetAcctNo;
    }

    public void setOffsetAcctNo(String offsetAcctNo) {
        this.offsetAcctNo = offsetAcctNo;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }

    public String getGenericUserFieldType() {
        return genericUserFieldType;
    }

    public void setGenericUserFieldType(String genericUserFieldType) {
        this.genericUserFieldType = genericUserFieldType;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getCrncyType() {
        return crncyType;
    }

    public void setCrncyType(String crncyType) {
        this.crncyType = crncyType;
    }

    public String getBrokerNo() {
        return brokerNo;
    }

    public void setBrokerNo(String brokerNo) {
        this.brokerNo = brokerNo;
    }

    public String getNoncustomerInd() {
        return noncustomerInd;
    }

    public void setNoncustomerInd(String noncustomerInd) {
        this.noncustomerInd = noncustomerInd;
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

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4;
    }

    public String getDesc5() {
        return desc5;
    }

    public void setDesc5(String desc5) {
        this.desc5 = desc5;
    }

    public String getDesc6() {
        return desc6;
    }

    public void setDesc6(String desc6) {
        this.desc6 = desc6;
    }

    public String getMlpInd() {
        return mlpInd;
    }

    public void setMlpInd(String mlpInd) {
        this.mlpInd = mlpInd;
    }

    public String getFirmCapacityCode() {
        return firmCapacityCode;
    }

    public void setFirmCapacityCode(String firmCapacityCode) {
        this.firmCapacityCode = firmCapacityCode;
    }

    public String getDivReinvestCode() {
        return divReinvestCode;
    }

    public void setDivReinvestCode(String divReinvestCode) {
        this.divReinvestCode = divReinvestCode;
    }

    public String getMuniCbCode() {
        return muniCbCode;
    }

    public void setMuniCbCode(String muniCbCode) {
        this.muniCbCode = muniCbCode;
    }

    public String getBondClassCode() {
        return bondClassCode;
    }

    public void setBondClassCode(String bondClassCode) {
        this.bondClassCode = bondClassCode;
    }

    public String getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(String couponRate) {
        this.couponRate = couponRate;
    }

    public String getConvFactor() {
        return convFactor;
    }

    public void setConvFactor(String convFactor) {
        this.convFactor = convFactor;
    }

    public String getTtoInd() {
        return ttoInd;
    }

    public void setTtoInd(String ttoInd) {
        this.ttoInd = ttoInd;
    }

    public String getTtoRep() {
        return ttoRep;
    }

    public void setTtoRep(String ttoRep) {
        this.ttoRep = ttoRep;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLimitMarketInd() {
        return limitMarketInd;
    }

    public void setLimitMarketInd(String limitMarketInd) {
        this.limitMarketInd = limitMarketInd;
    }

    public String getReportedTrdPrx() {
        return reportedTrdPrx;
    }

    public void setReportedTrdPrx(String reportedTrdPrx) {
        this.reportedTrdPrx = reportedTrdPrx;
    }

    public String getPriceFactor() {
        return priceFactor;
    }

    public void setPriceFactor(String priceFactor) {
        this.priceFactor = priceFactor;
    }

    public String getBasisPrx() {
        return basisPrx;
    }

    public void setBasisPrx(String basisPrx) {
        this.basisPrx = basisPrx;
    }

    public String getBasisYieldPct() {
        return basisYieldPct;
    }

    public void setBasisYieldPct(String basisYieldPct) {
        this.basisYieldPct = basisYieldPct;
    }

    public String getHandFigInd() {
        return handFigInd;
    }

    public void setHandFigInd(String handFigInd) {
        this.handFigInd = handFigInd;
    }

    public String getUseNetAmtInd() {
        return useNetAmtInd;
    }

    public void setUseNetAmtInd(String useNetAmtInd) {
        this.useNetAmtInd = useNetAmtInd;
    }

    public String getPrincipalAmt() {
        return principalAmt;
    }

    public void setPrincipalAmt(String principalAmt) {
        this.principalAmt = principalAmt;
    }

    public String getInterestAmt() {
        return interestAmt;
    }

    public void setInterestAmt(String interestAmt) {
        this.interestAmt = interestAmt;
    }

    public String getSecFeeAmt() {
        return secFeeAmt;
    }

    public void setSecFeeAmt(String secFeeAmt) {
        this.secFeeAmt = secFeeAmt;
    }

    public String getCommAmt() {
        return commAmt;
    }

    public void setCommAmt(String commAmt) {
        this.commAmt = commAmt;
    }

    public String getGrossCommPct() {
        return grossCommPct;
    }

    public void setGrossCommPct(String grossCommPct) {
        this.grossCommPct = grossCommPct;
    }

    public String getGrossPcntInd() {
        return grossPcntInd;
    }

    public void setGrossPcntInd(String grossPcntInd) {
        this.grossPcntInd = grossPcntInd;
    }

    public String getConcessionAmt() {
        return concessionAmt;
    }

    public void setConcessionAmt(String concessionAmt) {
        this.concessionAmt = concessionAmt;
    }

    public String getHandleFeeAmt() {
        return handleFeeAmt;
    }

    public void setHandleFeeAmt(String handleFeeAmt) {
        this.handleFeeAmt = handleFeeAmt;
    }

    public String getLalCommAmt() {
        return lalCommAmt;
    }

    public void setLalCommAmt(String lalCommAmt) {
        this.lalCommAmt = lalCommAmt;
    }

    public String getEquivDiscPct() {
        return equivDiscPct;
    }

    public void setEquivDiscPct(String equivDiscPct) {
        this.equivDiscPct = equivDiscPct;
    }

    public String getCommDiscCode() {
        return commDiscCode;
    }

    public void setCommDiscCode(String commDiscCode) {
        this.commDiscCode = commDiscCode;
    }

    public String getDiscRate() {
        return discRate;
    }

    public void setDiscRate(String discRate) {
        this.discRate = discRate;
    }

    public String getTotalOrdQty() {
        return totalOrdQty;
    }

    public void setTotalOrdQty(String totalOrdQty) {
        this.totalOrdQty = totalOrdQty;
    }

    public String getTotalOrdCommAmt() {
        return totalOrdCommAmt;
    }

    public void setTotalOrdCommAmt(String totalOrdCommAmt) {
        this.totalOrdCommAmt = totalOrdCommAmt;
    }

    public String getPostageAmt() {
        return postageAmt;
    }

    public void setPostageAmt(String postageAmt) {
        this.postageAmt = postageAmt;
    }

    public String getSecClassCode() {
        return secClassCode;
    }

    public void setSecClassCode(String secClassCode) {
        this.secClassCode = secClassCode;
    }

    public String getCancelInd() {
        return cancelInd;
    }

    public void setCancelInd(String cancelInd) {
        this.cancelInd = cancelInd;
    }

    public String getRebillInd() {
        return rebillInd;
    }

    public void setRebillInd(String rebillInd) {
        this.rebillInd = rebillInd;
    }

    public String getCancelReasonType() {
        return cancelReasonType;
    }

    public void setCancelReasonType(String cancelReasonType) {
        this.cancelReasonType = cancelReasonType;
    }

    public String getSpclTypeCode() {
        return spclTypeCode;
    }

    public void setSpclTypeCode(String spclTypeCode) {
        this.spclTypeCode = spclTypeCode;
    }

    public String getSpclTypeCode2() {
        return spclTypeCode2;
    }

    public void setSpclTypeCode2(String spclTypeCode2) {
        this.spclTypeCode2 = spclTypeCode2;
    }

    public String getSpclTypeCode3() {
        return spclTypeCode3;
    }

    public void setSpclTypeCode3(String spclTypeCode3) {
        this.spclTypeCode3 = spclTypeCode3;
    }

    public String getConfirmNote() {
        return confirmNote;
    }

    public void setConfirmNote(String confirmNote) {
        this.confirmNote = confirmNote;
    }

    public String getSyndicateInd() {
        return syndicateInd;
    }

    public void setSyndicateInd(String syndicateInd) {
        this.syndicateInd = syndicateInd;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getCommSchedNo() {
        return commSchedNo;
    }

    public void setCommSchedNo(String commSchedNo) {
        this.commSchedNo = commSchedNo;
    }

    public String getEuroclearId() {
        return euroclearId;
    }

    public void setEuroclearId(String euroclearId) {
        this.euroclearId = euroclearId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getOrderSrceCode() {
        return orderSrceCode;
    }

    public void setOrderSrceCode(String orderSrceCode) {
        this.orderSrceCode = orderSrceCode;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo;
    }

    public String getNasdaqSymbol() {
        return nasdaqSymbol;
    }

    public void setNasdaqSymbol(String nasdaqSymbol) {
        this.nasdaqSymbol = nasdaqSymbol;
    }

    public String getNccContraBrkrNo() {
        return nccContraBrkrNo;
    }

    public void setNccContraBrkrNo(String nccContraBrkrNo) {
        this.nccContraBrkrNo = nccContraBrkrNo;
    }

    public String getOddLotDiffCode() {
        return oddLotDiffCode;
    }

    public void setOddLotDiffCode(String oddLotDiffCode) {
        this.oddLotDiffCode = oddLotDiffCode;
    }

    public String getAutoExchCode() {
        return autoExchCode;
    }

    public void setAutoExchCode(String autoExchCode) {
        this.autoExchCode = autoExchCode;
    }

    public String getOccInd() {
        return occInd;
    }

    public void setOccInd(String occInd) {
        this.occInd = occInd;
    }

    public String getAutoTradeCode() {
        return autoTradeCode;
    }

    public void setAutoTradeCode(String autoTradeCode) {
        this.autoTradeCode = autoTradeCode;
    }

    public String getAtdUniqueKey() {
        return atdUniqueKey;
    }

    public void setAtdUniqueKey(String atdUniqueKey) {
        this.atdUniqueKey = atdUniqueKey;
    }

    public String getProgramNo() {
        return programNo;
    }

    public void setProgramNo(String programNo) {
        this.programNo = programNo;
    }

    public String getNetFeeAmt() {
        return netFeeAmt;
    }

    public void setNetFeeAmt(String netFeeAmt) {
        this.netFeeAmt = netFeeAmt;
    }

    public String getTrdExecTms() {
        return trdExecTms;
    }

    public void setTrdExecTms(String trdExecTms) {
        this.trdExecTms = trdExecTms;
    }

    public String getAdjInd() {
        return adjInd;
    }

    public void setAdjInd(String adjInd) {
        this.adjInd = adjInd;
    }

    public String getReinvestInd() {
        return reinvestInd;
    }

    public void setReinvestInd(String reinvestInd) {
        this.reinvestInd = reinvestInd;
    }

    public String getFreeCreditInd() {
        return freeCreditInd;
    }

    public void setFreeCreditInd(String freeCreditInd) {
        this.freeCreditInd = freeCreditInd;
    }

    public String getExecCount() {
        return execCount;
    }

    public void setExecCount(String execCount) {
        this.execCount = execCount;
    }

    public String getTaxLotInd() {
        return taxLotInd;
    }

    public void setTaxLotInd(String taxLotInd) {
        this.taxLotInd = taxLotInd;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getTtoSubNo() {
        return ttoSubNo;
    }

    public void setTtoSubNo(String ttoSubNo) {
        this.ttoSubNo = ttoSubNo;
    }

    public String getTtoBranch() {
        return ttoBranch;
    }

    public void setTtoBranch(String ttoBranch) {
        this.ttoBranch = ttoBranch;
    }

    public String getInternetOrderInd() {
        return internetOrderInd;
    }

    public void setInternetOrderInd(String internetOrderInd) {
        this.internetOrderInd = internetOrderInd;
    }

    public String getFrgnExchInd() {
        return frgnExchInd;
    }

    public void setFrgnExchInd(String frgnExchInd) {
        this.frgnExchInd = frgnExchInd;
    }

    public String getYieldOvrdInd() {
        return yieldOvrdInd;
    }

    public void setYieldOvrdInd(String yieldOvrdInd) {
        this.yieldOvrdInd = yieldOvrdInd;
    }

    public String getPrimeBrkrCode() {
        return primeBrkrCode;
    }

    public void setPrimeBrkrCode(String primeBrkrCode) {
        this.primeBrkrCode = primeBrkrCode;
    }

    public String getAvgPriceInd() {
        return avgPriceInd;
    }

    public void setAvgPriceInd(String avgPriceInd) {
        this.avgPriceInd = avgPriceInd;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }

    public String getYieldToMatRate() {
        return yieldToMatRate;
    }

    public void setYieldToMatRate(String yieldToMatRate) {
        this.yieldToMatRate = yieldToMatRate;
    }

    public String getMaturityCymd() {
        return maturityCymd;
    }

    public void setMaturityCymd(String maturityCymd) {
        this.maturityCymd = maturityCymd;
    }

    public String getNewSecType() {
        return newSecType;
    }

    public void setNewSecType(String newSecType) {
        this.newSecType = newSecType;
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getReptAvgTrdPrx() {
        return reptAvgTrdPrx;
    }

    public void setReptAvgTrdPrx(String reptAvgTrdPrx) {
        this.reptAvgTrdPrx = reptAvgTrdPrx;
    }

    public String getSecVarRateCode() {
        return secVarRateCode;
    }

    public void setSecVarRateCode(String secVarRateCode) {
        this.secVarRateCode = secVarRateCode;
    }

    public String getSkipHandleInd() {
        return skipHandleInd;
    }

    public void setSkipHandleInd(String skipHandleInd) {
        this.skipHandleInd = skipHandleInd;
    }

    public String getContraSubNo() {
        return contraSubNo;
    }

    public void setContraSubNo(String contraSubNo) {
        this.contraSubNo = contraSubNo;
    }

    public String getMemoInvIntAmt() {
        return memoInvIntAmt;
    }

    public void setMemoInvIntAmt(String memoInvIntAmt) {
        this.memoInvIntAmt = memoInvIntAmt;
    }

    public String getInternalUid() {
        return internalUid;
    }

    public void setInternalUid(String internalUid) {
        this.internalUid = internalUid;
    }

    public String getInternalRid() {
        return internalRid;
    }

    public void setInternalRid(String internalRid) {
        this.internalRid = internalRid;
    }

    public String getTrailerRid() {
        return trailerRid;
    }

    public void setTrailerRid(String trailerRid) {
        this.trailerRid = trailerRid;
    }

    public String getInternalAid() {
        return internalAid;
    }

    public void setInternalAid(String internalAid) {
        this.internalAid = internalAid;
    }

    public String getInternalOid() {
        return internalOid;
    }

    public void setInternalOid(String internalOid) {
        this.internalOid = internalOid;
    }

    public String getPfdIntAmt() {
        return pfdIntAmt;
    }

    public void setPfdIntAmt(String pfdIntAmt) {
        this.pfdIntAmt = pfdIntAmt;
    }

    public String getTpdInd() {
        return tpdInd;
    }

    public void setTpdInd(String tpdInd) {
        this.tpdInd = tpdInd;
    }

    public String getAppTypeCode() {
        return appTypeCode;
    }

    public void setAppTypeCode(String appTypeCode) {
        this.appTypeCode = appTypeCode;
    }

    public String getSpclTypeNewCode() {
        return spclTypeNewCode;
    }

    public void setSpclTypeNewCode(String spclTypeNewCode) {
        this.spclTypeNewCode = spclTypeNewCode;
    }

    public String getSpclTypeNewCode2() {
        return spclTypeNewCode2;
    }

    public void setSpclTypeNewCode2(String spclTypeNewCode2) {
        this.spclTypeNewCode2 = spclTypeNewCode2;
    }

    public String getSpclTypeNewCode3() {
        return spclTypeNewCode3;
    }

    public void setSpclTypeNewCode3(String spclTypeNewCode3) {
        this.spclTypeNewCode3 = spclTypeNewCode3;
    }

    public String getSpclTypeNewCode4() {
        return spclTypeNewCode4;
    }

    public void setSpclTypeNewCode4(String spclTypeNewCode4) {
        this.spclTypeNewCode4 = spclTypeNewCode4;
    }

    public String getSpclTypeNewCode5() {
        return spclTypeNewCode5;
    }

    public void setSpclTypeNewCode5(String spclTypeNewCode5) {
        this.spclTypeNewCode5 = spclTypeNewCode5;
    }

    public String getSecFeeAmtInd() {
        return secFeeAmtInd;
    }

    public void setSecFeeAmtInd(String secFeeAmtInd) {
        this.secFeeAmtInd = secFeeAmtInd;
    }

    public String getLalAmtInd() {
        return lalAmtInd;
    }

    public void setLalAmtInd(String lalAmtInd) {
        this.lalAmtInd = lalAmtInd;
    }

    public String getBasisInd() {
        return basisInd;
    }

    public void setBasisInd(String basisInd) {
        this.basisInd = basisInd;
    }

    public String getFactorInd() {
        return factorInd;
    }

    public void setFactorInd(String factorInd) {
        this.factorInd = factorInd;
    }

    public String getHandleAmtInd() {
        return handleAmtInd;
    }

    public void setHandleAmtInd(String handleAmtInd) {
        this.handleAmtInd = handleAmtInd;
    }

    public String getExpGrossInd() {
        return expGrossInd;
    }

    public void setExpGrossInd(String expGrossInd) {
        this.expGrossInd = expGrossInd;
    }

    public String getCommCpsInd() {
        return commCpsInd;
    }

    public void setCommCpsInd(String commCpsInd) {
        this.commCpsInd = commCpsInd;
    }

    public String getCommDiscInd() {
        return commDiscInd;
    }

    public void setCommDiscInd(String commDiscInd) {
        this.commDiscInd = commDiscInd;
    }

    public String getPostageAmtInd() {
        return postageAmtInd;
    }

    public void setPostageAmtInd(String postageAmtInd) {
        this.postageAmtInd = postageAmtInd;
    }

    public String getStateTax2AmtInd() {
        return stateTax2AmtInd;
    }

    public void setStateTax2AmtInd(String stateTax2AmtInd) {
        this.stateTax2AmtInd = stateTax2AmtInd;
    }

    public String getSortAcctNo() {
        return sortAcctNo;
    }

    public void setSortAcctNo(String sortAcctNo) {
        this.sortAcctNo = sortAcctNo;
    }

    public String getWireCode() {
        return wireCode;
    }

    public void setWireCode(String wireCode) {
        this.wireCode = wireCode;
    }

    public String getWireSeqNo() {
        return wireSeqNo;
    }

    public void setWireSeqNo(String wireSeqNo) {
        this.wireSeqNo = wireSeqNo;
    }

    public String getCrippleInd() {
        return crippleInd;
    }

    public void setCrippleInd(String crippleInd) {
        this.crippleInd = crippleInd;
    }

    public String getFullCommAmt() {
        return fullCommAmt;
    }

    public void setFullCommAmt(String fullCommAmt) {
        this.fullCommAmt = fullCommAmt;
    }

    public String getTotalFullOrdCommAmt() {
        return totalFullOrdCommAmt;
    }

    public void setTotalFullOrdCommAmt(String totalFullOrdCommAmt) {
        this.totalFullOrdCommAmt = totalFullOrdCommAmt;
    }

    public String getAccrUnitIntQty() {
        return accrUnitIntQty;
    }

    public void setAccrUnitIntQty(String accrUnitIntQty) {
        this.accrUnitIntQty = accrUnitIntQty;
    }

    public String getEstParValueAmt() {
        return estParValueAmt;
    }

    public void setEstParValueAmt(String estParValueAmt) {
        this.estParValueAmt = estParValueAmt;
    }

    public String getCurrentYldAmt() {
        return currentYldAmt;
    }

    public void setCurrentYldAmt(String currentYldAmt) {
        this.currentYldAmt = currentYldAmt;
    }

    public String getEstLongTermYldRate() {
        return estLongTermYldRate;
    }

    public void setEstLongTermYldRate(String estLongTermYldRate) {
        this.estLongTermYldRate = estLongTermYldRate;
    }

    public String getAsofMktValueAmt() {
        return asofMktValueAmt;
    }

    public void setAsofMktValueAmt(String asofMktValueAmt) {
        this.asofMktValueAmt = asofMktValueAmt;
    }

    public String getPayoutCode() {
        return payoutCode;
    }

    public void setPayoutCode(String payoutCode) {
        this.payoutCode = payoutCode;
    }

    public String getNsccCtrlId() {
        return nsccCtrlId;
    }

    public void setNsccCtrlId(String nsccCtrlId) {
        this.nsccCtrlId = nsccCtrlId;
    }

    public String getTmktExpPrx() {
        return tmktExpPrx;
    }

    public void setTmktExpPrx(String tmktExpPrx) {
        this.tmktExpPrx = tmktExpPrx;
    }

    public String getTstExpPrx() {
        return tstExpPrx;
    }

    public void setTstExpPrx(String tstExpPrx) {
        this.tstExpPrx = tstExpPrx;
    }

    public String getShortSaleReviewCode() {
        return shortSaleReviewCode;
    }

    public void setShortSaleReviewCode(String shortSaleReviewCode) {
        this.shortSaleReviewCode = shortSaleReviewCode;
    }

    public String getInvestorCode() {
        return investorCode;
    }

    public void setInvestorCode(String investorCode) {
        this.investorCode = investorCode;
    }

    public String getOatsOtcExchCode() {
        return oatsOtcExchCode;
    }

    public void setOatsOtcExchCode(String oatsOtcExchCode) {
        this.oatsOtcExchCode = oatsOtcExchCode;
    }

    public String getSpclTypeCode4() {
        return spclTypeCode4;
    }

    public void setSpclTypeCode4(String spclTypeCode4) {
        this.spclTypeCode4 = spclTypeCode4;
    }

    public String getSpclTypeCode5() {
        return spclTypeCode5;
    }

    public void setSpclTypeCode5(String spclTypeCode5) {
        this.spclTypeCode5 = spclTypeCode5;
    }

    public String getTtrailerInd() {
        return ttrailerInd;
    }

    public void setTtrailerInd(String ttrailerInd) {
        this.ttrailerInd = ttrailerInd;
    }

    public String getCurrentVaryRate() {
        return currentVaryRate;
    }

    public void setCurrentVaryRate(String currentVaryRate) {
        this.currentVaryRate = currentVaryRate;
    }

    public String getMultExchInd() {
        return multExchInd;
    }

    public void setMultExchInd(String multExchInd) {
        this.multExchInd = multExchInd;
    }

    public String getTawayMarket() {
        return tawayMarket;
    }

    public void setTawayMarket(String tawayMarket) {
        this.tawayMarket = tawayMarket;
    }

    public String getPptOverrideInd() {
        return pptOverrideInd;
    }

    public void setPptOverrideInd(String pptOverrideInd) {
        this.pptOverrideInd = pptOverrideInd;
    }

    public String getInputSrceCode() {
        return inputSrceCode;
    }

    public void setInputSrceCode(String inputSrceCode) {
        this.inputSrceCode = inputSrceCode;
    }

    public String getPutCallInd() {
        return putCallInd;
    }

    public void setPutCallInd(String putCallInd) {
        this.putCallInd = putCallInd;
    }

    public String getOsiUlSymbol() {
        return osiUlSymbol;
    }

    public void setOsiUlSymbol(String osiUlSymbol) {
        this.osiUlSymbol = osiUlSymbol;
    }

    public String getExpireCymd() {
        return expireCymd;
    }

    public void setExpireCymd(String expireCymd) {
        this.expireCymd = expireCymd;
    }

    public String getSecStrikePrx() {
        return secStrikePrx;
    }

    public void setSecStrikePrx(String secStrikePrx) {
        this.secStrikePrx = secStrikePrx;
    }

    public String getMultCapacityInd() {
        return multCapacityInd;
    }

    public void setMultCapacityInd(String multCapacityInd) {
        this.multCapacityInd = multCapacityInd;
    }

    public String getRepoHoldInd() {
        return repoHoldInd;
    }

    public void setRepoHoldInd(String repoHoldInd) {
        this.repoHoldInd = repoHoldInd;
    }

    public String getTraceSymbol() {
        return traceSymbol;
    }

    public void setTraceSymbol(String traceSymbol) {
        this.traceSymbol = traceSymbol;
    }

    public String getAcctMktValueAmt() {
        return acctMktValueAmt;
    }

    public void setAcctMktValueAmt(String acctMktValueAmt) {
        this.acctMktValueAmt = acctMktValueAmt;
    }

    public String getOptionRegFeeAmt() {
        return optionRegFeeAmt;
    }

    public void setOptionRegFeeAmt(String optionRegFeeAmt) {
        this.optionRegFeeAmt = optionRegFeeAmt;
    }

    public String getNetworkMatrixCode() {
        return networkMatrixCode;
    }

    public void setNetworkMatrixCode(String networkMatrixCode) {
        this.networkMatrixCode = networkMatrixCode;
    }

    public String getMarginCode() {
        return marginCode;
    }

    public void setMarginCode(String marginCode) {
        this.marginCode = marginCode;
    }

    public String getLargeTrderId() {
        return largeTrderId;
    }

    public void setLargeTrderId(String largeTrderId) {
        this.largeTrderId = largeTrderId;
    }

    public String getNonListedCode() {
        return nonListedCode;
    }

    public void setNonListedCode(String nonListedCode) {
        this.nonListedCode = nonListedCode;
    }

    public String getMinPrxVarCode() {
        return minPrxVarCode;
    }

    public void setMinPrxVarCode(String minPrxVarCode) {
        this.minPrxVarCode = minPrxVarCode;
    }

    public String getTbasisFeatCode() {
        return tbasisFeatCode;
    }

    public void setTbasisFeatCode(String tbasisFeatCode) {
        this.tbasisFeatCode = tbasisFeatCode;
    }

    public String getTbasisFeatCymd() {
        return tbasisFeatCymd;
    }

    public void setTbasisFeatCymd(String tbasisFeatCymd) {
        this.tbasisFeatCymd = tbasisFeatCymd;
    }

    public String getTbasisFeatPrice() {
        return tbasisFeatPrice;
    }

    public void setTbasisFeatPrice(String tbasisFeatPrice) {
        this.tbasisFeatPrice = tbasisFeatPrice;
    }

    public String getTbasisFeatCode2() {
        return tbasisFeatCode2;
    }

    public void setTbasisFeatCode2(String tbasisFeatCode2) {
        this.tbasisFeatCode2 = tbasisFeatCode2;
    }

    public String getTbasisFeatCymd2() {
        return tbasisFeatCymd2;
    }

    public void setTbasisFeatCymd2(String tbasisFeatCymd2) {
        this.tbasisFeatCymd2 = tbasisFeatCymd2;
    }

    public String getTbasisYield2() {
        return tbasisYield2;
    }

    public void setTbasisYield2(String tbasisYield2) {
        this.tbasisYield2 = tbasisYield2;
    }

    public String getTbasisFeatPrice2() {
        return tbasisFeatPrice2;
    }

    public void setTbasisFeatPrice2(String tbasisFeatPrice2) {
        this.tbasisFeatPrice2 = tbasisFeatPrice2;
    }

    public String getTenterFirmMpid() {
        return tenterFirmMpid;
    }

    public void setTenterFirmMpid(String tenterFirmMpid) {
        this.tenterFirmMpid = tenterFirmMpid;
    }

    public String getExchCode() {
        return exchCode;
    }

    public void setExchCode(String exchCode) {
        this.exchCode = exchCode;
    }

    public String getPfdIntNotInclAmt() {
        return pfdIntNotInclAmt;
    }

    public void setPfdIntNotInclAmt(String pfdIntNotInclAmt) {
        this.pfdIntNotInclAmt = pfdIntNotInclAmt;
    }

    public String getRebalanceInd() {
        return rebalanceInd;
    }

    public void setRebalanceInd(String rebalanceInd) {
        this.rebalanceInd = rebalanceInd;
    }

    public String getTraceReportInd() {
        return traceReportInd;
    }

    public void setTraceReportInd(String traceReportInd) {
        this.traceReportInd = traceReportInd;
    }

    public String getTraceModCode() {
        return traceModCode;
    }

    public void setTraceModCode(String traceModCode) {
        this.traceModCode = traceModCode;
    }

    public String getTraceModCode2() {
        return traceModCode2;
    }

    public void setTraceModCode2(String traceModCode2) {
        this.traceModCode2 = traceModCode2;
    }

    public String getTraceModCode3() {
        return traceModCode3;
    }

    public void setTraceModCode3(String traceModCode3) {
        this.traceModCode3 = traceModCode3;
    }

    public String getTraceModCode4() {
        return traceModCode4;
    }

    public void setTraceModCode4(String traceModCode4) {
        this.traceModCode4 = traceModCode4;
    }

    public String getAlBreakptLvl() {
        return alBreakptLvl;
    }

    public void setAlBreakptLvl(String alBreakptLvl) {
        this.alBreakptLvl = alBreakptLvl;
    }

    public String getEmbeddCommDisc() {
        return embeddCommDisc;
    }

    public void setEmbeddCommDisc(String embeddCommDisc) {
        this.embeddCommDisc = embeddCommDisc;
    }

    public String getEmbeddCommDiscCode() {
        return embeddCommDiscCode;
    }

    public void setEmbeddCommDiscCode(String embeddCommDiscCode) {
        this.embeddCommDiscCode = embeddCommDiscCode;
    }

    public String getTransInd() {
        return transInd;
    }

    public void setTransInd(String transInd) {
        this.transInd = transInd;
    }

    public String getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(String tradeFee) {
        this.tradeFee = tradeFee;
    }

    public String getUsdConvRate() {
        return usdConvRate;
    }

    public void setUsdConvRate(String usdConvRate) {
        this.usdConvRate = usdConvRate;
    }

    public String getUsdEquivalent() {
        return usdEquivalent;
    }

    public void setUsdEquivalent(String usdEquivalent) {
        this.usdEquivalent = usdEquivalent;
    }

    public String getCxExchRate() {
        return cxExchRate;
    }

    public void setCxExchRate(String cxExchRate) {
        this.cxExchRate = cxExchRate;
    }

    public String getCxInd() {
        return cxInd;
    }

    public void setCxInd(String cxInd) {
        this.cxInd = cxInd;
    }

    public String getPrevailMktPrx() {
        return prevailMktPrx;
    }

    public void setPrevailMktPrx(String prevailMktPrx) {
        this.prevailMktPrx = prevailMktPrx;
    }

    public String getMarkUpdnAmt() {
        return markUpdnAmt;
    }

    public void setMarkUpdnAmt(String markUpdnAmt) {
        this.markUpdnAmt = markUpdnAmt;
    }

    public String getMarkUpdnAmtInd() {
        return markUpdnAmtInd;
    }

    public void setMarkUpdnAmtInd(String markUpdnAmtInd) {
        this.markUpdnAmtInd = markUpdnAmtInd;
    }

    public String getMarkUpdnPct() {
        return markUpdnPct;
    }

    public void setMarkUpdnPct(String markUpdnPct) {
        this.markUpdnPct = markUpdnPct;
    }

    public String getMarkUpdnPctInd() {
        return markUpdnPctInd;
    }

    public void setMarkUpdnPctInd(String markUpdnPctInd) {
        this.markUpdnPctInd = markUpdnPctInd;
    }

    public String getExecTimestamp() {
        return execTimestamp;
    }

    public void setExecTimestamp(String execTimestamp) {
        this.execTimestamp = execTimestamp;
    }

    public String getPriorRefPointTs() {
        return priorRefPointTs;
    }

    public void setPriorRefPointTs(String priorRefPointTs) {
        this.priorRefPointTs = priorRefPointTs;
    }

    public String getOatsAssocOrdInd() {
        return oatsAssocOrdInd;
    }

    public void setOatsAssocOrdInd(String oatsAssocOrdInd) {
        this.oatsAssocOrdInd = oatsAssocOrdInd;
    }

    public String getWaterfallLevel() {
        return waterfallLevel;
    }

    public void setWaterfallLevel(String waterfallLevel) {
        this.waterfallLevel = waterfallLevel;
    }

    public String getCatReportInd() {
        return catReportInd;
    }

    public void setCatReportInd(String catReportInd) {
        this.catReportInd = catReportInd;
    }
}
