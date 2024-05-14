package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_trd_osi", schema = "stage_stonex")
public class StageTrdOsi {
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
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 100)
    private String acctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_class_code", nullable = false, length = 100)
    private String acctClassCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_no", nullable = false, length = 100)
    private String secNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_type", nullable = false, length = 100)
    private String secType;

    @Size(max = 100)
    @NotNull
    @Column(name = "class_code", nullable = false, length = 100)
    private String classCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_code", nullable = false, length = 100)
    private String mgnCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "std_instruc_code", nullable = false, length = 100)
    private String stdInstrucCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_cymd", nullable = false, length = 100)
    private String tradeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "asof_cymd", nullable = false, length = 100)
    private String asofCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "settle_cymd", nullable = false, length = 100)
    private String settleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "origin_code", nullable = false, length = 100)
    private String originCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tran_id", nullable = false, length = 100)
    private String tranId;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_no", nullable = false, length = 100)
    private String controlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "big_qty", nullable = false, length = 100)
    private String bigQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "big_prx", nullable = false, length = 100)
    private String bigPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "buy_sell_ind", nullable = false, length = 100)
    private String buySellInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "big_exch_type", nullable = false, length = 100)
    private String bigExchType;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_amt", nullable = false, length = 100)
    private String netAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "offset_acct_no", nullable = false, length = 100)
    private String offsetAcctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "offset_type", nullable = false, length = 100)
    private String offsetType;

    @Size(max = 100)
    @NotNull
    @Column(name = "generic_user_field_type", nullable = false, length = 100)
    private String genericUserFieldType;

    @Size(max = 100)
    @NotNull
    @Column(name = "tag_no", nullable = false, length = 100)
    private String tagNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "crncy_type", nullable = false, length = 100)
    private String crncyType;

    @Size(max = 100)
    @NotNull
    @Column(name = "broker_no", nullable = false, length = 100)
    private String brokerNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "noncustomer_ind", nullable = false, length = 100)
    private String noncustomerInd;

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
    @Column(name = "desc_4", nullable = false, length = 100)
    private String desc4;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_5", nullable = false, length = 100)
    private String desc5;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc_6", nullable = false, length = 100)
    private String desc6;

    @Size(max = 100)
    @NotNull
    @Column(name = "mlp_ind", nullable = false, length = 100)
    private String mlpInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_capacity_code", nullable = false, length = 100)
    private String firmCapacityCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_reinvest_code", nullable = false, length = 100)
    private String divReinvestCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "muni_cb_code", nullable = false, length = 100)
    private String muniCbCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_class_code", nullable = false, length = 100)
    private String bondClassCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "coupon_rate", nullable = false, length = 100)
    private String couponRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "conv_factor", nullable = false, length = 100)
    private String convFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "tto_ind", nullable = false, length = 100)
    private String ttoInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tto_rep", nullable = false, length = 100)
    private String ttoRep;

    @Size(max = 100)
    @NotNull
    @Column(name = "state_code", nullable = false, length = 100)
    private String stateCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_id", nullable = false, length = 100)
    private String taxId;

    @Size(max = 100)
    @NotNull
    @Column(name = "order_no", nullable = false, length = 100)
    private String orderNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "limit_market_ind", nullable = false, length = 100)
    private String limitMarketInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "reported_trd_prx", nullable = false, length = 100)
    private String reportedTrdPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "price_factor", nullable = false, length = 100)
    private String priceFactor;

    @Size(max = 100)
    @NotNull
    @Column(name = "basis_prx", nullable = false, length = 100)
    private String basisPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "basis_yield_pct", nullable = false, length = 100)
    private String basisYieldPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "hand_fig_ind", nullable = false, length = 100)
    private String handFigInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "use_net_amt_ind", nullable = false, length = 100)
    private String useNetAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "principal_amt", nullable = false, length = 100)
    private String principalAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "interest_amt", nullable = false, length = 100)
    private String interestAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_fee_amt", nullable = false, length = 100)
    private String secFeeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_amt", nullable = false, length = 100)
    private String commAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "gross_comm_pct", nullable = false, length = 100)
    private String grossCommPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "gross_pcnt_ind", nullable = false, length = 100)
    private String grossPcntInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "concession_amt", nullable = false, length = 100)
    private String concessionAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "handle_fee_amt", nullable = false, length = 100)
    private String handleFeeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "lal_comm_amt", nullable = false, length = 100)
    private String lalCommAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "equiv_disc_pct", nullable = false, length = 100)
    private String equivDiscPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_disc_code", nullable = false, length = 100)
    private String commDiscCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "disc_rate", nullable = false, length = 100)
    private String discRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "total_ord_qty", nullable = false, length = 100)
    private String totalOrdQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "total_ord_comm_amt", nullable = false, length = 100)
    private String totalOrdCommAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "postage_amt", nullable = false, length = 100)
    private String postageAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_class_code", nullable = false, length = 100)
    private String secClassCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "cancel_ind", nullable = false, length = 100)
    private String cancelInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "rebill_ind", nullable = false, length = 100)
    private String rebillInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "cancel_reason_type", nullable = false, length = 100)
    private String cancelReasonType;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_code", nullable = false, length = 100)
    private String spclTypeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_code_2", nullable = false, length = 100)
    private String spclTypeCode2;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_code_3", nullable = false, length = 100)
    private String spclTypeCode3;

    @Size(max = 100)
    @NotNull
    @Column(name = "confirm_note", nullable = false, length = 100)
    private String confirmNote;

    @Size(max = 100)
    @NotNull
    @Column(name = "syndicate_ind", nullable = false, length = 100)
    private String syndicateInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "execution_time", nullable = false, length = 100)
    private String executionTime;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_sched_no", nullable = false, length = 100)
    private String commSchedNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "euroclear_id", nullable = false, length = 100)
    private String euroclearId;

    @Size(max = 100)
    @NotNull
    @Column(name = "product_type", nullable = false, length = 100)
    private String productType;

    @Size(max = 100)
    @NotNull
    @Column(name = "order_srce_code", nullable = false, length = 100)
    private String orderSrceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "dealer_no", nullable = false, length = 100)
    private String dealerNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "nasdaq_symbol", nullable = false, length = 100)
    private String nasdaqSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "ncc_contra_brkr_no", nullable = false, length = 100)
    private String nccContraBrkrNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "odd_lot_diff_code", nullable = false, length = 100)
    private String oddLotDiffCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "auto_exch_code", nullable = false, length = 100)
    private String autoExchCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "occ_ind", nullable = false, length = 100)
    private String occInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "auto_trade_code", nullable = false, length = 100)
    private String autoTradeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "atd_unique_key", nullable = false, length = 100)
    private String atdUniqueKey;

    @Size(max = 100)
    @NotNull
    @Column(name = "program_no", nullable = false, length = 100)
    private String programNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_fee_amt", nullable = false, length = 100)
    private String netFeeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "trd_exec_tms", nullable = false, length = 100)
    private String trdExecTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "adj_ind", nullable = false, length = 100)
    private String adjInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinvest_ind", nullable = false, length = 100)
    private String reinvestInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "free_credit_ind", nullable = false, length = 100)
    private String freeCreditInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "exec_count", nullable = false, length = 100)
    private String execCount;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_lot_ind", nullable = false, length = 100)
    private String taxLotInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "originator_id", nullable = false, length = 100)
    private String originatorId;

    @Size(max = 100)
    @NotNull
    @Column(name = "tto_sub_no", nullable = false, length = 100)
    private String ttoSubNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "tto_branch", nullable = false, length = 100)
    private String ttoBranch;

    @Size(max = 100)
    @NotNull
    @Column(name = "internet_order_ind", nullable = false, length = 100)
    private String internetOrderInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "frgn_exch_ind", nullable = false, length = 100)
    private String frgnExchInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "yield_ovrd_ind", nullable = false, length = 100)
    private String yieldOvrdInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prime_brkr_code", nullable = false, length = 100)
    private String primeBrkrCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "avg_price_ind", nullable = false, length = 100)
    private String avgPriceInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "inst_id", nullable = false, length = 100)
    private String instId;

    @Size(max = 100)
    @NotNull
    @Column(name = "yield_to_mat_rate", nullable = false, length = 100)
    private String yieldToMatRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "maturity_cymd", nullable = false, length = 100)
    private String maturityCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "new_sec_type", nullable = false, length = 100)
    private String newSecType;

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
    @Column(name = "branch", nullable = false, length = 100)
    private String branch;

    @Size(max = 100)
    @NotNull
    @Column(name = "rept_avg_trd_prx", nullable = false, length = 100)
    private String reptAvgTrdPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_var_rate_code", nullable = false, length = 100)
    private String secVarRateCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "skip_handle_ind", nullable = false, length = 100)
    private String skipHandleInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "contra_sub_no", nullable = false, length = 100)
    private String contraSubNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "memo_inv_int_amt", nullable = false, length = 100)
    private String memoInvIntAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_uid", nullable = false, length = 100)
    private String internalUid;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_rid", nullable = false, length = 100)
    private String internalRid;

    @Size(max = 100)
    @NotNull
    @Column(name = "trailer_rid", nullable = false, length = 100)
    private String trailerRid;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_aid", nullable = false, length = 100)
    private String internalAid;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_oid", nullable = false, length = 100)
    private String internalOid;

    @Size(max = 100)
    @NotNull
    @Column(name = "pfd_int_amt", nullable = false, length = 100)
    private String pfdIntAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tpd_ind", nullable = false, length = 100)
    private String tpdInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "app_type_code", nullable = false, length = 100)
    private String appTypeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_new_code", nullable = false, length = 100)
    private String spclTypeNewCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_new_code_2", nullable = false, length = 100)
    private String spclTypeNewCode2;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_new_code_3", nullable = false, length = 100)
    private String spclTypeNewCode3;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_new_code_4", nullable = false, length = 100)
    private String spclTypeNewCode4;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_new_code_5", nullable = false, length = 100)
    private String spclTypeNewCode5;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_fee_amt_ind", nullable = false, length = 100)
    private String secFeeAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "lal_amt_ind", nullable = false, length = 100)
    private String lalAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "basis_ind", nullable = false, length = 100)
    private String basisInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "factor_ind", nullable = false, length = 100)
    private String factorInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "handle_amt_ind", nullable = false, length = 100)
    private String handleAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "exp_gross_ind", nullable = false, length = 100)
    private String expGrossInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_cps_ind", nullable = false, length = 100)
    private String commCpsInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_disc_ind", nullable = false, length = 100)
    private String commDiscInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "postage_amt_ind", nullable = false, length = 100)
    private String postageAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "state_tax2_amt_ind", nullable = false, length = 100)
    private String stateTax2AmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sort_acct_no", nullable = false, length = 100)
    private String sortAcctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "wire_code", nullable = false, length = 100)
    private String wireCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "wire_seq_no", nullable = false, length = 100)
    private String wireSeqNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cripple_ind", nullable = false, length = 100)
    private String crippleInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "full_comm_amt", nullable = false, length = 100)
    private String fullCommAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "total_full_ord_comm_amt", nullable = false, length = 100)
    private String totalFullOrdCommAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "accr_unit_int_qty", nullable = false, length = 100)
    private String accrUnitIntQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "est_par_value_amt", nullable = false, length = 100)
    private String estParValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "current_yld_amt", nullable = false, length = 100)
    private String currentYldAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "est_long_term_yld_rate", nullable = false, length = 100)
    private String estLongTermYldRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "asof_mkt_value_amt", nullable = false, length = 100)
    private String asofMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "payout_code", nullable = false, length = 100)
    private String payoutCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "nscc_ctrl_id", nullable = false, length = 100)
    private String nsccCtrlId;

    @Size(max = 100)
    @NotNull
    @Column(name = "tmkt_exp_prx", nullable = false, length = 100)
    private String tmktExpPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "tst_exp_prx", nullable = false, length = 100)
    private String tstExpPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "short_sale_review_code", nullable = false, length = 100)
    private String shortSaleReviewCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "investor_code", nullable = false, length = 100)
    private String investorCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "oats_otc_exch_code", nullable = false, length = 100)
    private String oatsOtcExchCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_code_4", nullable = false, length = 100)
    private String spclTypeCode4;

    @Size(max = 100)
    @NotNull
    @Column(name = "spcl_type_code_5", nullable = false, length = 100)
    private String spclTypeCode5;

    @Size(max = 100)
    @NotNull
    @Column(name = "ttrailer_ind", nullable = false, length = 100)
    private String ttrailerInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "current_vary_rate", nullable = false, length = 100)
    private String currentVaryRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "mult_exch_ind", nullable = false, length = 100)
    private String multExchInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "taway_market", nullable = false, length = 100)
    private String tawayMarket;

    @Size(max = 100)
    @NotNull
    @Column(name = "ppt_override_ind", nullable = false, length = 100)
    private String pptOverrideInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "input_srce_code", nullable = false, length = 100)
    private String inputSrceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "put_call_ind", nullable = false, length = 100)
    private String putCallInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "osi_ul_symbol", nullable = false, length = 100)
    private String osiUlSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "expire_cymd", nullable = false, length = 100)
    private String expireCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_strike_prx", nullable = false, length = 100)
    private String secStrikePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "mult_capacity_ind", nullable = false, length = 100)
    private String multCapacityInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "repo_hold_ind", nullable = false, length = 100)
    private String repoHoldInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_symbol", nullable = false, length = 100)
    private String traceSymbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_mkt_value_amt", nullable = false, length = 100)
    private String acctMktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "option_reg_fee_amt", nullable = false, length = 100)
    private String optionRegFeeAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "network_matrix_code", nullable = false, length = 100)
    private String networkMatrixCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "margin_code", nullable = false, length = 100)
    private String marginCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "large_trder_id", nullable = false, length = 100)
    private String largeTrderId;

    @Size(max = 100)
    @NotNull
    @Column(name = "non_listed_code", nullable = false, length = 100)
    private String nonListedCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "min_prx_var_code", nullable = false, length = 100)
    private String minPrxVarCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_code", nullable = false, length = 100)
    private String tbasisFeatCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_cymd", nullable = false, length = 100)
    private String tbasisFeatCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_price", nullable = false, length = 100)
    private String tbasisFeatPrice;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_code2", nullable = false, length = 100)
    private String tbasisFeatCode2;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_cymd2", nullable = false, length = 100)
    private String tbasisFeatCymd2;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_yield2", nullable = false, length = 100)
    private String tbasisYield2;

    @Size(max = 100)
    @NotNull
    @Column(name = "tbasis_feat_price2", nullable = false, length = 100)
    private String tbasisFeatPrice2;

    @Size(max = 100)
    @NotNull
    @Column(name = "tenter_firm_mpid", nullable = false, length = 100)
    private String tenterFirmMpid;

    @Size(max = 100)
    @NotNull
    @Column(name = "exch_code", nullable = false, length = 100)
    private String exchCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "pfd_int_not_incl_amt", nullable = false, length = 100)
    private String pfdIntNotInclAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "rebalance_ind", nullable = false, length = 100)
    private String rebalanceInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_report_ind", nullable = false, length = 100)
    private String traceReportInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_mod_code", nullable = false, length = 100)
    private String traceModCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_mod_code_2", nullable = false, length = 100)
    private String traceModCode2;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_mod_code_3", nullable = false, length = 100)
    private String traceModCode3;

    @Size(max = 100)
    @NotNull
    @Column(name = "trace_mod_code_4", nullable = false, length = 100)
    private String traceModCode4;

    @Size(max = 100)
    @NotNull
    @Column(name = "al_breakpt_lvl", nullable = false, length = 100)
    private String alBreakptLvl;

    @Size(max = 100)
    @NotNull
    @Column(name = "embedd_comm_disc", nullable = false, length = 100)
    private String embeddCommDisc;

    @Size(max = 100)
    @NotNull
    @Column(name = "embedd_comm_disc_code", nullable = false, length = 100)
    private String embeddCommDiscCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "trans_ind", nullable = false, length = 100)
    private String transInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_fee", nullable = false, length = 100)
    private String tradeFee;

    @Size(max = 100)
    @NotNull
    @Column(name = "usd_conv_rate", nullable = false, length = 100)
    private String usdConvRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "usd_equivalent", nullable = false, length = 100)
    private String usdEquivalent;

    @Size(max = 100)
    @NotNull
    @Column(name = "cx_exch_rate", nullable = false, length = 100)
    private String cxExchRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "cx_ind", nullable = false, length = 100)
    private String cxInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prevail_mkt_prx", nullable = false, length = 100)
    private String prevailMktPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "mark_updn_amt", nullable = false, length = 100)
    private String markUpdnAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mark_updn_amt_ind", nullable = false, length = 100)
    private String markUpdnAmtInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mark_updn_pct", nullable = false, length = 100)
    private String markUpdnPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "mark_updn_pct_ind", nullable = false, length = 100)
    private String markUpdnPctInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "exec_timestamp", nullable = false, length = 100)
    private String execTimestamp;

    @Size(max = 100)
    @NotNull
    @Column(name = "prior_ref_point_ts", nullable = false, length = 100)
    private String priorRefPointTs;

    @Size(max = 100)
    @NotNull
    @Column(name = "oats_assoc_ord_ind", nullable = false, length = 100)
    private String oatsAssocOrdInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "waterfall_level", nullable = false, length = 100)
    private String waterfallLevel;

    @Size(max = 100)
    @NotNull
    @Column(name = "cat_report_ind", nullable = false, length = 100)
    private String catReportInd;

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