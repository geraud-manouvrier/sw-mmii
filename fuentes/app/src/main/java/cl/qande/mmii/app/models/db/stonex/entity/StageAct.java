package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_act", schema = "stage_stonex")
public class StageAct {
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
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

    @Size(max = 100)
    @NotNull
    @Column(name = "old_acct_no", nullable = false, length = 100)
    private String oldAcctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "zip", nullable = false, length = 100)
    private String zip;

    @Size(max = 100)
    @NotNull
    @Column(name = "zip_plus4", nullable = false, length = 100)
    private String zipPlus4;

    @Size(max = 100)
    @NotNull
    @Column(name = "foreign_zip", nullable = false, length = 100)
    private String foreignZip;

    @Size(max = 100)
    @NotNull
    @Column(name = "namelines", nullable = false, length = 100)
    private String namelines;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line1", nullable = false, length = 100)
    private String nameLine1;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line2", nullable = false, length = 100)
    private String nameLine2;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line3", nullable = false, length = 100)
    private String nameLine3;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line4", nullable = false, length = 100)
    private String nameLine4;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line5", nullable = false, length = 100)
    private String nameLine5;

    @Size(max = 100)
    @NotNull
    @Column(name = "name_line6", nullable = false, length = 100)
    private String nameLine6;

    @Size(max = 100)
    @NotNull
    @Column(name = "key1", nullable = false, length = 100)
    private String key1;

    @Size(max = 100)
    @NotNull
    @Column(name = "key2", nullable = false, length = 100)
    private String key2;

    @Size(max = 100)
    @NotNull
    @Column(name = "key3", nullable = false, length = 100)
    private String key3;

    @Size(max = 100)
    @NotNull
    @Column(name = "key4", nullable = false, length = 100)
    private String key4;

    @Size(max = 100)
    @NotNull
    @Column(name = "key5", nullable = false, length = 100)
    private String key5;

    @Size(max = 100)
    @NotNull
    @Column(name = "home_phone", nullable = false, length = 100)
    private String homePhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "work_phone", nullable = false, length = 100)
    private String workPhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "alt_phone", nullable = false, length = 100)
    private String altPhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "state_code", nullable = false, length = 100)
    private String stateCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "country_code", nullable = false, length = 100)
    private String countryCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "province_code", nullable = false, length = 100)
    private String provinceCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "withhold_cntry", nullable = false, length = 100)
    private String withholdCntry;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_auto_cancel_sw", nullable = false, length = 100)
    private String noAutoCancelSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "noid_withhold_code", nullable = false, length = 100)
    private String noidWithholdCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_id_format", nullable = false, length = 100)
    private String taxIdFormat;

    @Size(max = 100)
    @NotNull
    @Column(name = "w8_mailing_cy", nullable = false, length = 100)
    private String w8MailingCy;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_id", nullable = false, length = 100)
    private String taxId;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_activity_cym", nullable = false, length = 100)
    private String lastActivityCym;

    @Size(max = 100)
    @NotNull
    @Column(name = "open_cymd", nullable = false, length = 100)
    private String openCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_cymd", nullable = false, length = 100)
    private String changeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_si1", nullable = false, length = 100)
    private String cashSi1;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_si2", nullable = false, length = 100)
    private String cashSi2;

    @Size(max = 100)
    @NotNull
    @Column(name = "margin_si1", nullable = false, length = 100)
    private String marginSi1;

    @Size(max = 100)
    @NotNull
    @Column(name = "margin_si2", nullable = false, length = 100)
    private String marginSi2;

    @Size(max = 100)
    @NotNull
    @Column(name = "dividen_si", nullable = false, length = 100)
    private String dividenSi;

    @Size(max = 100)
    @NotNull
    @Column(name = "second_cash_si", nullable = false, length = 100)
    private String secondCashSi;

    @Size(max = 100)
    @NotNull
    @Column(name = "withhold_sw", nullable = false, length = 100)
    private String withholdSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "w9_request_status", nullable = false, length = 100)
    private String w9RequestStatus;

    @Size(max = 100)
    @NotNull
    @Column(name = "w8_request_status", nullable = false, length = 100)
    private String w8RequestStatus;

    @Size(max = 100)
    @NotNull
    @Column(name = "tefra_exempt_sw", nullable = false, length = 100)
    private String tefraExemptSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "principal_code", nullable = false, length = 100)
    private String principalCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "f1001_status", nullable = false, length = 100)
    private String f1001Status;

    @Size(max = 100)
    @NotNull
    @Column(name = "inst_code", nullable = false, length = 100)
    private String instCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ny_tax_sw", nullable = false, length = 100)
    private String nyTaxSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "inv_obj", nullable = false, length = 100)
    private String invObj;

    @Size(max = 100)
    @NotNull
    @Column(name = "class", nullable = false, length = 100)
    private String classField;

    @Size(max = 100)
    @NotNull
    @Column(name = "network_elig_fl", nullable = false, length = 100)
    private String networkEligFl;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc7", nullable = false, length = 100)
    private String misc7;

    @Size(max = 100)
    @NotNull
    @Column(name = "cma", nullable = false, length = 100)
    private String cma;

    @Size(max = 100)
    @NotNull
    @Column(name = "viol_code", nullable = false, length = 100)
    private String violCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "hist_code", nullable = false, length = 100)
    private String histCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "director_sw", nullable = false, length = 100)
    private String directorSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "proxy_discl_code", nullable = false, length = 100)
    private String proxyDisclCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "discr_trading_code", nullable = false, length = 100)
    private String discrTradingCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "optn_i_o_code", nullable = false, length = 100)
    private String optnIOCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "avg_price", nullable = false, length = 100)
    private String avgPrice;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc1", nullable = false, length = 100)
    private String misc1;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc2", nullable = false, length = 100)
    private String misc2;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc3", nullable = false, length = 100)
    private String misc3;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc4", nullable = false, length = 100)
    private String misc4;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc5", nullable = false, length = 100)
    private String misc5;

    @Size(max = 100)
    @NotNull
    @Column(name = "misc6", nullable = false, length = 100)
    private String misc6;

    @Size(max = 100)
    @NotNull
    @Column(name = "sweep_code", nullable = false, length = 100)
    private String sweepCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mmf_init_purch_sw", nullable = false, length = 100)
    private String mmfInitPurchSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_div_sw", nullable = false, length = 100)
    private String cashDivSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "mmf_cash_only", nullable = false, length = 100)
    private String mmfCashOnly;

    @Size(max = 100)
    @NotNull
    @Column(name = "marg_int_rate", nullable = false, length = 100)
    private String margIntRate;

    @Size(max = 100)
    @NotNull
    @Column(name = "marg_int_chg", nullable = false, length = 100)
    private String margIntChg;

    @Size(max = 100)
    @NotNull
    @Column(name = "segregation_sw", nullable = false, length = 100)
    private String segregationSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "credit_int_code", nullable = false, length = 100)
    private String creditIntCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "option_loss_limit", nullable = false, length = 100)
    private String optionLossLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "erisa_code", nullable = false, length = 100)
    private String erisaCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "cred_int_nopost_sw", nullable = false, length = 100)
    private String credIntNopostSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "foreign_si1", nullable = false, length = 100)
    private String foreignSi1;

    @Size(max = 100)
    @NotNull
    @Column(name = "foreign_si2", nullable = false, length = 100)
    private String foreignSi2;

    @Size(max = 100)
    @NotNull
    @Column(name = "stk_discount", nullable = false, length = 100)
    private String stkDiscount;

    @Size(max = 100)
    @NotNull
    @Column(name = "bnd_discount", nullable = false, length = 100)
    private String bndDiscount;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_discount", nullable = false, length = 100)
    private String optDiscount;

    @Size(max = 100)
    @NotNull
    @Column(name = "confirm_copy", nullable = false, length = 100)
    private String confirmCopy;

    @Size(max = 100)
    @NotNull
    @Column(name = "reverse_rep", nullable = false, length = 100)
    private String reverseRep;

    @Size(max = 100)
    @NotNull
    @Column(name = "acat_term_fee_sw", nullable = false, length = 100)
    private String acatTermFeeSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "withhold_cymd", nullable = false, length = 100)
    private String withholdCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_stmt_cym", nullable = false, length = 100)
    private String lastStmtCym;

    @Size(max = 100)
    @NotNull
    @Column(name = "mano", nullable = false, length = 100)
    private String mano;

    @Size(max = 100)
    @NotNull
    @Column(name = "manox", nullable = false, length = 100)
    private String manox;

    @Size(max = 100)
    @NotNull
    @Column(name = "restriction_cymd", nullable = false, length = 100)
    private String restrictionCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mst_brkr", nullable = false, length = 100)
    private String mstBrkr;

    @Size(max = 100)
    @NotNull
    @Column(name = "company_merge_code", nullable = false, length = 100)
    private String companyMergeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "restriction_code", nullable = false, length = 100)
    private String restrictionCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_journal_ind", nullable = false, length = 100)
    private String noJournalInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "mmf_scvc_fee_sw", nullable = false, length = 100)
    private String mmfScvcFeeSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "excl_mail_line1_sw", nullable = false, length = 100)
    private String exclMailLine1Sw;

    @Size(max = 100)
    @NotNull
    @Column(name = "excl_mail_line2_sw", nullable = false, length = 100)
    private String exclMailLine2Sw;

    @Size(max = 100)
    @NotNull
    @Column(name = "excl_mail_line3_sw", nullable = false, length = 100)
    private String exclMailLine3Sw;

    @Size(max = 100)
    @NotNull
    @Column(name = "use_code1_sw", nullable = false, length = 100)
    private String useCode1Sw;

    @Size(max = 100)
    @NotNull
    @Column(name = "download_code", nullable = false, length = 100)
    private String downloadCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "inst_override_sw", nullable = false, length = 100)
    private String instOverrideSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "remic_cmo_sw", nullable = false, length = 100)
    private String remicCmoSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "account_doc_cat", nullable = false, length = 100)
    private String accountDocCat;

    @Size(max = 100)
    @NotNull
    @Column(name = "doc_tran_lvl", nullable = false, length = 100)
    private String docTranLvl;

    @Size(max = 100)
    @NotNull
    @Column(name = "prime_broker_code", nullable = false, length = 100)
    private String primeBrokerCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "coll_loan_ac_sw", nullable = false, length = 100)
    private String collLoanAcSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type_ind", nullable = false, length = 100)
    private String acctTypeInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_withholding_rt", nullable = false, length = 100)
    private String taxWithholdingRt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_withholding_cd", nullable = false, length = 100)
    private String taxWithholdingCd;

    @Size(max = 100)
    @NotNull
    @Column(name = "fax_phone", nullable = false, length = 100)
    private String faxPhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "rest_balance", nullable = false, length = 100)
    private String restBalance;

    @Size(max = 100)
    @NotNull
    @Column(name = "bar_code", nullable = false, length = 100)
    private String barCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "bar_code_chk", nullable = false, length = 100)
    private String barCodeChk;

    @Size(max = 100)
    @NotNull
    @Column(name = "management_group", nullable = false, length = 100)
    private String managementGroup;

    @Size(max = 100)
    @NotNull
    @Column(name = "rein_label_sent_sw", nullable = false, length = 100)
    private String reinLabelSentSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "divert_code", nullable = false, length = 100)
    private String divertCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "prev_prin_trds_sw", nullable = false, length = 100)
    private String prevPrinTrdsSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "tpa_number", nullable = false, length = 100)
    private String tpaNumber;

    @Size(max = 100)
    @NotNull
    @Column(name = "car_rt", nullable = false, length = 100)
    private String carRt;

    @Size(max = 100)
    @NotNull
    @Column(name = "product_class", nullable = false, length = 100)
    private String productClass;

    @Size(max = 100)
    @NotNull
    @Column(name = "cmta_no", nullable = false, length = 100)
    private String cmtaNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "upd_term", nullable = false, length = 100)
    private String updTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "dlr_firm_no", nullable = false, length = 100)
    private String dlrFirmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "dlr_broker_no", nullable = false, length = 100)
    private String dlrBrokerNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "lrate", nullable = false, length = 100)
    private String lrate;

    @Size(max = 100)
    @NotNull
    @Column(name = "sell_comm", nullable = false, length = 100)
    private String sellComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "brate", nullable = false, length = 100)
    private String brate;

    @Size(max = 100)
    @NotNull
    @Column(name = "buy_comm", nullable = false, length = 100)
    private String buyComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "nscc_no", nullable = false, length = 100)
    private String nsccNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtc_fbo_code", nullable = false, length = 100)
    private String dtcFboCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "nasdaq_firm_no", nullable = false, length = 100)
    private String nasdaqFirmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "dlr_nasdaq_sym", nullable = false, length = 100)
    private String dlrNasdaqSym;

    @Size(max = 100)
    @NotNull
    @Column(name = "idcfm", nullable = false, length = 100)
    private String idcfm;

    @Size(max = 100)
    @NotNull
    @Column(name = "generic_user_field", nullable = false, length = 100)
    private String genericUserField;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_cfm_code", nullable = false, length = 100)
    private String noCfmCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "flip_exch", nullable = false, length = 100)
    private String flipExch;

    @Size(max = 100)
    @NotNull
    @Column(name = "corr_clear", nullable = false, length = 100)
    private String corrClear;

    @Size(max = 100)
    @NotNull
    @Column(name = "stk_comm_sched", nullable = false, length = 100)
    private String stkCommSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "bnd_comm_sched", nullable = false, length = 100)
    private String bndCommSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_comm_sched", nullable = false, length = 100)
    private String optCommSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "postage_amt", nullable = false, length = 100)
    private String postageAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "muni_cns_part", nullable = false, length = 100)
    private String muniCnsPart;

    @Size(max = 100)
    @NotNull
    @Column(name = "non_customer_sw", nullable = false, length = 100)
    private String nonCustomerSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "nasdaq_sym", nullable = false, length = 100)
    private String nasdaqSym;

    @Size(max = 100)
    @NotNull
    @Column(name = "purge_ind", nullable = false, length = 100)
    private String purgeInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bill_bypass", nullable = false, length = 100)
    private String billBypass;

    @Size(max = 100)
    @NotNull
    @Column(name = "order_only", nullable = false, length = 100)
    private String orderOnly;

    @Size(max = 100)
    @NotNull
    @Column(name = "ira_term_cymd", nullable = false, length = 100)
    private String iraTermCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinvest_code", nullable = false, length = 100)
    private String reinvestCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_dr_ovrd", nullable = false, length = 100)
    private String cashDrOvrd;

    @Size(max = 100)
    @NotNull
    @Column(name = "term_reason", nullable = false, length = 100)
    private String termReason;

    @Size(max = 100)
    @NotNull
    @Column(name = "irs_name_line1", nullable = false, length = 100)
    private String irsNameLine1;

    @Size(max = 100)
    @NotNull
    @Column(name = "irs_name_line2", nullable = false, length = 100)
    private String irsNameLine2;

    @Size(max = 100)
    @NotNull
    @Column(name = "ncc_firm_no", nullable = false, length = 100)
    private String nccFirmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_inc", nullable = false, length = 100)
    private String achInc;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_cr", nullable = false, length = 100)
    private String achCr;

    @Size(max = 100)
    @NotNull
    @Column(name = "ach_dr", nullable = false, length = 100)
    private String achDr;

    @Size(max = 100)
    @NotNull
    @Column(name = "outside_mmf", nullable = false, length = 100)
    private String outsideMmf;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep_b4_acats", nullable = false, length = 100)
    private String repB4Acats;

    @Size(max = 100)
    @NotNull
    @Column(name = "f121_status_code", nullable = false, length = 100)
    private String f121StatusCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "gscc_firm_no", nullable = false, length = 100)
    private String gsccFirmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "gscc_no", nullable = false, length = 100)
    private String gsccNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "mbscc_firm_no", nullable = false, length = 100)
    private String mbsccFirmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "mbscc_no", nullable = false, length = 100)
    private String mbsccNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "emp_class_code", nullable = false, length = 100)
    private String empClassCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_review_code", nullable = false, length = 100)
    private String lastReviewCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_review_cymd", nullable = false, length = 100)
    private String lastReviewCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "doc_restrict_code", nullable = false, length = 100)
    private String docRestrictCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "doc_restrict_cymd", nullable = false, length = 100)
    private String docRestrictCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "group_no", nullable = false, length = 100)
    private String groupNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form1", nullable = false, length = 100)
    private String actForm1;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form2", nullable = false, length = 100)
    private String actForm2;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form3", nullable = false, length = 100)
    private String actForm3;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form4", nullable = false, length = 100)
    private String actForm4;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form5", nullable = false, length = 100)
    private String actForm5;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form6", nullable = false, length = 100)
    private String actForm6;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form7", nullable = false, length = 100)
    private String actForm7;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form8", nullable = false, length = 100)
    private String actForm8;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form9", nullable = false, length = 100)
    private String actForm9;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form10", nullable = false, length = 100)
    private String actForm10;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_form11", nullable = false, length = 100)
    private String actForm11;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_rebate", nullable = false, length = 100)
    private String noRebate;

    @Size(max = 100)
    @NotNull
    @Column(name = "alternate_state", nullable = false, length = 100)
    private String alternateState;

    @Size(max = 100)
    @NotNull
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Size(max = 100)
    @NotNull
    @Column(name = "nav", nullable = false, length = 100)
    private String nav;

    @Size(max = 100)
    @NotNull
    @Column(name = "navr_sw", nullable = false, length = 100)
    private String navrSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "wrap_plan", nullable = false, length = 100)
    private String wrapPlan;

    @Size(max = 100)
    @NotNull
    @Column(name = "mmf_sec_no", nullable = false, length = 100)
    private String mmfSecNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "mmf_sell_first", nullable = false, length = 100)
    private String mmfSellFirst;

    @Size(max = 100)
    @NotNull
    @Column(name = "acats_auto_valid", nullable = false, length = 100)
    private String acatsAutoValid;

    @Size(max = 100)
    @NotNull
    @Column(name = "brr_eligible", nullable = false, length = 100)
    private String brrEligible;

    @Size(max = 100)
    @NotNull
    @Column(name = "repo_request", nullable = false, length = 100)
    private String repoRequest;

    @Size(max = 100)
    @NotNull
    @Column(name = "branch", nullable = false, length = 100)
    private String branch;

    @Size(max = 100)
    @NotNull
    @Column(name = "branch_b4_acats", nullable = false, length = 100)
    private String branchB4Acats;

    @Size(max = 100)
    @NotNull
    @Column(name = "reverse_branch", nullable = false, length = 100)
    private String reverseBranch;

    @Size(max = 100)
    @NotNull
    @Column(name = "ds_exempt_sw", nullable = false, length = 100)
    private String dsExemptSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_status", nullable = false, length = 100)
    private String acctStatus;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_override", nullable = false, length = 100)
    private String commOverride;

    @Size(max = 100)
    @NotNull
    @Column(name = "bolt_ind", nullable = false, length = 100)
    private String boltInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "investor_code", nullable = false, length = 100)
    private String investorCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "ipo_eligible", nullable = false, length = 100)
    private String ipoEligible;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_source", nullable = false, length = 100)
    private String changeSource;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_source_id", nullable = false, length = 100)
    private String changeSourceId;

    @Size(max = 100)
    @NotNull
    @Column(name = "st_reg_exempt", nullable = false, length = 100)
    private String stRegExempt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_tran_fee_ind", nullable = false, length = 100)
    private String noTranFeeInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_avg_price_ind", nullable = false, length = 100)
    private String acctAvgPriceInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "prevent_stock_loan_ind", nullable = false, length = 100)
    private String preventStockLoanInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "access_deliver_ind", nullable = false, length = 100)
    private String accessDeliverInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "social_code", nullable = false, length = 100)
    private String socialCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "dflt_crncy_type", nullable = false, length = 100)
    private String dfltCrncyType;

    @Size(max = 100)
    @NotNull
    @Column(name = "inst_acct_ind", nullable = false, length = 100)
    private String instAcctInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "investor_option_code", nullable = false, length = 100)
    private String investorOptionCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_tier_sched_code", nullable = false, length = 100)
    private String mgnTierSchedCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "natural_person_code", nullable = false, length = 100)
    private String naturalPersonCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "multi_curr_ind", nullable = false, length = 100)
    private String multiCurrInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_cmp_rvw_ind", nullable = false, length = 100)
    private String actCmpRvwInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "act_mst_ind", nullable = false, length = 100)
    private String actMstInd;

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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getOldAcctNo() {
        return oldAcctNo;
    }

    public void setOldAcctNo(String oldAcctNo) {
        this.oldAcctNo = oldAcctNo;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZipPlus4() {
        return zipPlus4;
    }

    public void setZipPlus4(String zipPlus4) {
        this.zipPlus4 = zipPlus4;
    }

    public String getForeignZip() {
        return foreignZip;
    }

    public void setForeignZip(String foreignZip) {
        this.foreignZip = foreignZip;
    }

    public String getNamelines() {
        return namelines;
    }

    public void setNamelines(String namelines) {
        this.namelines = namelines;
    }

    public String getNameLine1() {
        return nameLine1;
    }

    public void setNameLine1(String nameLine1) {
        this.nameLine1 = nameLine1;
    }

    public String getNameLine2() {
        return nameLine2;
    }

    public void setNameLine2(String nameLine2) {
        this.nameLine2 = nameLine2;
    }

    public String getNameLine3() {
        return nameLine3;
    }

    public void setNameLine3(String nameLine3) {
        this.nameLine3 = nameLine3;
    }

    public String getNameLine4() {
        return nameLine4;
    }

    public void setNameLine4(String nameLine4) {
        this.nameLine4 = nameLine4;
    }

    public String getNameLine5() {
        return nameLine5;
    }

    public void setNameLine5(String nameLine5) {
        this.nameLine5 = nameLine5;
    }

    public String getNameLine6() {
        return nameLine6;
    }

    public void setNameLine6(String nameLine6) {
        this.nameLine6 = nameLine6;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getWithholdCntry() {
        return withholdCntry;
    }

    public void setWithholdCntry(String withholdCntry) {
        this.withholdCntry = withholdCntry;
    }

    public String getNoAutoCancelSw() {
        return noAutoCancelSw;
    }

    public void setNoAutoCancelSw(String noAutoCancelSw) {
        this.noAutoCancelSw = noAutoCancelSw;
    }

    public String getNoidWithholdCode() {
        return noidWithholdCode;
    }

    public void setNoidWithholdCode(String noidWithholdCode) {
        this.noidWithholdCode = noidWithholdCode;
    }

    public String getTaxIdFormat() {
        return taxIdFormat;
    }

    public void setTaxIdFormat(String taxIdFormat) {
        this.taxIdFormat = taxIdFormat;
    }

    public String getW8MailingCy() {
        return w8MailingCy;
    }

    public void setW8MailingCy(String w8MailingCy) {
        this.w8MailingCy = w8MailingCy;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getLastActivityCym() {
        return lastActivityCym;
    }

    public void setLastActivityCym(String lastActivityCym) {
        this.lastActivityCym = lastActivityCym;
    }

    public String getOpenCymd() {
        return openCymd;
    }

    public void setOpenCymd(String openCymd) {
        this.openCymd = openCymd;
    }

    public String getChangeCymd() {
        return changeCymd;
    }

    public void setChangeCymd(String changeCymd) {
        this.changeCymd = changeCymd;
    }

    public String getCashSi1() {
        return cashSi1;
    }

    public void setCashSi1(String cashSi1) {
        this.cashSi1 = cashSi1;
    }

    public String getCashSi2() {
        return cashSi2;
    }

    public void setCashSi2(String cashSi2) {
        this.cashSi2 = cashSi2;
    }

    public String getMarginSi1() {
        return marginSi1;
    }

    public void setMarginSi1(String marginSi1) {
        this.marginSi1 = marginSi1;
    }

    public String getMarginSi2() {
        return marginSi2;
    }

    public void setMarginSi2(String marginSi2) {
        this.marginSi2 = marginSi2;
    }

    public String getDividenSi() {
        return dividenSi;
    }

    public void setDividenSi(String dividenSi) {
        this.dividenSi = dividenSi;
    }

    public String getSecondCashSi() {
        return secondCashSi;
    }

    public void setSecondCashSi(String secondCashSi) {
        this.secondCashSi = secondCashSi;
    }

    public String getWithholdSw() {
        return withholdSw;
    }

    public void setWithholdSw(String withholdSw) {
        this.withholdSw = withholdSw;
    }

    public String getW9RequestStatus() {
        return w9RequestStatus;
    }

    public void setW9RequestStatus(String w9RequestStatus) {
        this.w9RequestStatus = w9RequestStatus;
    }

    public String getW8RequestStatus() {
        return w8RequestStatus;
    }

    public void setW8RequestStatus(String w8RequestStatus) {
        this.w8RequestStatus = w8RequestStatus;
    }

    public String getTefraExemptSw() {
        return tefraExemptSw;
    }

    public void setTefraExemptSw(String tefraExemptSw) {
        this.tefraExemptSw = tefraExemptSw;
    }

    public String getPrincipalCode() {
        return principalCode;
    }

    public void setPrincipalCode(String principalCode) {
        this.principalCode = principalCode;
    }

    public String getF1001Status() {
        return f1001Status;
    }

    public void setF1001Status(String f1001Status) {
        this.f1001Status = f1001Status;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getNyTaxSw() {
        return nyTaxSw;
    }

    public void setNyTaxSw(String nyTaxSw) {
        this.nyTaxSw = nyTaxSw;
    }

    public String getInvObj() {
        return invObj;
    }

    public void setInvObj(String invObj) {
        this.invObj = invObj;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public String getNetworkEligFl() {
        return networkEligFl;
    }

    public void setNetworkEligFl(String networkEligFl) {
        this.networkEligFl = networkEligFl;
    }

    public String getMisc7() {
        return misc7;
    }

    public void setMisc7(String misc7) {
        this.misc7 = misc7;
    }

    public String getCma() {
        return cma;
    }

    public void setCma(String cma) {
        this.cma = cma;
    }

    public String getViolCode() {
        return violCode;
    }

    public void setViolCode(String violCode) {
        this.violCode = violCode;
    }

    public String getHistCode() {
        return histCode;
    }

    public void setHistCode(String histCode) {
        this.histCode = histCode;
    }

    public String getDirectorSw() {
        return directorSw;
    }

    public void setDirectorSw(String directorSw) {
        this.directorSw = directorSw;
    }

    public String getProxyDisclCode() {
        return proxyDisclCode;
    }

    public void setProxyDisclCode(String proxyDisclCode) {
        this.proxyDisclCode = proxyDisclCode;
    }

    public String getDiscrTradingCode() {
        return discrTradingCode;
    }

    public void setDiscrTradingCode(String discrTradingCode) {
        this.discrTradingCode = discrTradingCode;
    }

    public String getOptnIOCode() {
        return optnIOCode;
    }

    public void setOptnIOCode(String optnIOCode) {
        this.optnIOCode = optnIOCode;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getMisc1() {
        return misc1;
    }

    public void setMisc1(String misc1) {
        this.misc1 = misc1;
    }

    public String getMisc2() {
        return misc2;
    }

    public void setMisc2(String misc2) {
        this.misc2 = misc2;
    }

    public String getMisc3() {
        return misc3;
    }

    public void setMisc3(String misc3) {
        this.misc3 = misc3;
    }

    public String getMisc4() {
        return misc4;
    }

    public void setMisc4(String misc4) {
        this.misc4 = misc4;
    }

    public String getMisc5() {
        return misc5;
    }

    public void setMisc5(String misc5) {
        this.misc5 = misc5;
    }

    public String getMisc6() {
        return misc6;
    }

    public void setMisc6(String misc6) {
        this.misc6 = misc6;
    }

    public String getSweepCode() {
        return sweepCode;
    }

    public void setSweepCode(String sweepCode) {
        this.sweepCode = sweepCode;
    }

    public String getMmfInitPurchSw() {
        return mmfInitPurchSw;
    }

    public void setMmfInitPurchSw(String mmfInitPurchSw) {
        this.mmfInitPurchSw = mmfInitPurchSw;
    }

    public String getCashDivSw() {
        return cashDivSw;
    }

    public void setCashDivSw(String cashDivSw) {
        this.cashDivSw = cashDivSw;
    }

    public String getMmfCashOnly() {
        return mmfCashOnly;
    }

    public void setMmfCashOnly(String mmfCashOnly) {
        this.mmfCashOnly = mmfCashOnly;
    }

    public String getMargIntRate() {
        return margIntRate;
    }

    public void setMargIntRate(String margIntRate) {
        this.margIntRate = margIntRate;
    }

    public String getMargIntChg() {
        return margIntChg;
    }

    public void setMargIntChg(String margIntChg) {
        this.margIntChg = margIntChg;
    }

    public String getSegregationSw() {
        return segregationSw;
    }

    public void setSegregationSw(String segregationSw) {
        this.segregationSw = segregationSw;
    }

    public String getCreditIntCode() {
        return creditIntCode;
    }

    public void setCreditIntCode(String creditIntCode) {
        this.creditIntCode = creditIntCode;
    }

    public String getOptionLossLimit() {
        return optionLossLimit;
    }

    public void setOptionLossLimit(String optionLossLimit) {
        this.optionLossLimit = optionLossLimit;
    }

    public String getErisaCode() {
        return erisaCode;
    }

    public void setErisaCode(String erisaCode) {
        this.erisaCode = erisaCode;
    }

    public String getCredIntNopostSw() {
        return credIntNopostSw;
    }

    public void setCredIntNopostSw(String credIntNopostSw) {
        this.credIntNopostSw = credIntNopostSw;
    }

    public String getForeignSi1() {
        return foreignSi1;
    }

    public void setForeignSi1(String foreignSi1) {
        this.foreignSi1 = foreignSi1;
    }

    public String getForeignSi2() {
        return foreignSi2;
    }

    public void setForeignSi2(String foreignSi2) {
        this.foreignSi2 = foreignSi2;
    }

    public String getStkDiscount() {
        return stkDiscount;
    }

    public void setStkDiscount(String stkDiscount) {
        this.stkDiscount = stkDiscount;
    }

    public String getBndDiscount() {
        return bndDiscount;
    }

    public void setBndDiscount(String bndDiscount) {
        this.bndDiscount = bndDiscount;
    }

    public String getOptDiscount() {
        return optDiscount;
    }

    public void setOptDiscount(String optDiscount) {
        this.optDiscount = optDiscount;
    }

    public String getConfirmCopy() {
        return confirmCopy;
    }

    public void setConfirmCopy(String confirmCopy) {
        this.confirmCopy = confirmCopy;
    }

    public String getReverseRep() {
        return reverseRep;
    }

    public void setReverseRep(String reverseRep) {
        this.reverseRep = reverseRep;
    }

    public String getAcatTermFeeSw() {
        return acatTermFeeSw;
    }

    public void setAcatTermFeeSw(String acatTermFeeSw) {
        this.acatTermFeeSw = acatTermFeeSw;
    }

    public String getWithholdCymd() {
        return withholdCymd;
    }

    public void setWithholdCymd(String withholdCymd) {
        this.withholdCymd = withholdCymd;
    }

    public String getLastStmtCym() {
        return lastStmtCym;
    }

    public void setLastStmtCym(String lastStmtCym) {
        this.lastStmtCym = lastStmtCym;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getManox() {
        return manox;
    }

    public void setManox(String manox) {
        this.manox = manox;
    }

    public String getRestrictionCymd() {
        return restrictionCymd;
    }

    public void setRestrictionCymd(String restrictionCymd) {
        this.restrictionCymd = restrictionCymd;
    }

    public String getMstBrkr() {
        return mstBrkr;
    }

    public void setMstBrkr(String mstBrkr) {
        this.mstBrkr = mstBrkr;
    }

    public String getCompanyMergeCode() {
        return companyMergeCode;
    }

    public void setCompanyMergeCode(String companyMergeCode) {
        this.companyMergeCode = companyMergeCode;
    }

    public String getRestrictionCode() {
        return restrictionCode;
    }

    public void setRestrictionCode(String restrictionCode) {
        this.restrictionCode = restrictionCode;
    }

    public String getNoJournalInd() {
        return noJournalInd;
    }

    public void setNoJournalInd(String noJournalInd) {
        this.noJournalInd = noJournalInd;
    }

    public String getMmfScvcFeeSw() {
        return mmfScvcFeeSw;
    }

    public void setMmfScvcFeeSw(String mmfScvcFeeSw) {
        this.mmfScvcFeeSw = mmfScvcFeeSw;
    }

    public String getExclMailLine1Sw() {
        return exclMailLine1Sw;
    }

    public void setExclMailLine1Sw(String exclMailLine1Sw) {
        this.exclMailLine1Sw = exclMailLine1Sw;
    }

    public String getExclMailLine2Sw() {
        return exclMailLine2Sw;
    }

    public void setExclMailLine2Sw(String exclMailLine2Sw) {
        this.exclMailLine2Sw = exclMailLine2Sw;
    }

    public String getExclMailLine3Sw() {
        return exclMailLine3Sw;
    }

    public void setExclMailLine3Sw(String exclMailLine3Sw) {
        this.exclMailLine3Sw = exclMailLine3Sw;
    }

    public String getUseCode1Sw() {
        return useCode1Sw;
    }

    public void setUseCode1Sw(String useCode1Sw) {
        this.useCode1Sw = useCode1Sw;
    }

    public String getDownloadCode() {
        return downloadCode;
    }

    public void setDownloadCode(String downloadCode) {
        this.downloadCode = downloadCode;
    }

    public String getInstOverrideSw() {
        return instOverrideSw;
    }

    public void setInstOverrideSw(String instOverrideSw) {
        this.instOverrideSw = instOverrideSw;
    }

    public String getRemicCmoSw() {
        return remicCmoSw;
    }

    public void setRemicCmoSw(String remicCmoSw) {
        this.remicCmoSw = remicCmoSw;
    }

    public String getAccountDocCat() {
        return accountDocCat;
    }

    public void setAccountDocCat(String accountDocCat) {
        this.accountDocCat = accountDocCat;
    }

    public String getDocTranLvl() {
        return docTranLvl;
    }

    public void setDocTranLvl(String docTranLvl) {
        this.docTranLvl = docTranLvl;
    }

    public String getPrimeBrokerCode() {
        return primeBrokerCode;
    }

    public void setPrimeBrokerCode(String primeBrokerCode) {
        this.primeBrokerCode = primeBrokerCode;
    }

    public String getCollLoanAcSw() {
        return collLoanAcSw;
    }

    public void setCollLoanAcSw(String collLoanAcSw) {
        this.collLoanAcSw = collLoanAcSw;
    }

    public String getAcctTypeInd() {
        return acctTypeInd;
    }

    public void setAcctTypeInd(String acctTypeInd) {
        this.acctTypeInd = acctTypeInd;
    }

    public String getTaxWithholdingRt() {
        return taxWithholdingRt;
    }

    public void setTaxWithholdingRt(String taxWithholdingRt) {
        this.taxWithholdingRt = taxWithholdingRt;
    }

    public String getTaxWithholdingCd() {
        return taxWithholdingCd;
    }

    public void setTaxWithholdingCd(String taxWithholdingCd) {
        this.taxWithholdingCd = taxWithholdingCd;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    public String getRestBalance() {
        return restBalance;
    }

    public void setRestBalance(String restBalance) {
        this.restBalance = restBalance;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCodeChk() {
        return barCodeChk;
    }

    public void setBarCodeChk(String barCodeChk) {
        this.barCodeChk = barCodeChk;
    }

    public String getManagementGroup() {
        return managementGroup;
    }

    public void setManagementGroup(String managementGroup) {
        this.managementGroup = managementGroup;
    }

    public String getReinLabelSentSw() {
        return reinLabelSentSw;
    }

    public void setReinLabelSentSw(String reinLabelSentSw) {
        this.reinLabelSentSw = reinLabelSentSw;
    }

    public String getDivertCode() {
        return divertCode;
    }

    public void setDivertCode(String divertCode) {
        this.divertCode = divertCode;
    }

    public String getPrevPrinTrdsSw() {
        return prevPrinTrdsSw;
    }

    public void setPrevPrinTrdsSw(String prevPrinTrdsSw) {
        this.prevPrinTrdsSw = prevPrinTrdsSw;
    }

    public String getTpaNumber() {
        return tpaNumber;
    }

    public void setTpaNumber(String tpaNumber) {
        this.tpaNumber = tpaNumber;
    }

    public String getCarRt() {
        return carRt;
    }

    public void setCarRt(String carRt) {
        this.carRt = carRt;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getCmtaNo() {
        return cmtaNo;
    }

    public void setCmtaNo(String cmtaNo) {
        this.cmtaNo = cmtaNo;
    }

    public String getUpdTerm() {
        return updTerm;
    }

    public void setUpdTerm(String updTerm) {
        this.updTerm = updTerm;
    }

    public String getDlrFirmNo() {
        return dlrFirmNo;
    }

    public void setDlrFirmNo(String dlrFirmNo) {
        this.dlrFirmNo = dlrFirmNo;
    }

    public String getDlrBrokerNo() {
        return dlrBrokerNo;
    }

    public void setDlrBrokerNo(String dlrBrokerNo) {
        this.dlrBrokerNo = dlrBrokerNo;
    }

    public String getLrate() {
        return lrate;
    }

    public void setLrate(String lrate) {
        this.lrate = lrate;
    }

    public String getSellComm() {
        return sellComm;
    }

    public void setSellComm(String sellComm) {
        this.sellComm = sellComm;
    }

    public String getBrate() {
        return brate;
    }

    public void setBrate(String brate) {
        this.brate = brate;
    }

    public String getBuyComm() {
        return buyComm;
    }

    public void setBuyComm(String buyComm) {
        this.buyComm = buyComm;
    }

    public String getNsccNo() {
        return nsccNo;
    }

    public void setNsccNo(String nsccNo) {
        this.nsccNo = nsccNo;
    }

    public String getDtcFboCode() {
        return dtcFboCode;
    }

    public void setDtcFboCode(String dtcFboCode) {
        this.dtcFboCode = dtcFboCode;
    }

    public String getNasdaqFirmNo() {
        return nasdaqFirmNo;
    }

    public void setNasdaqFirmNo(String nasdaqFirmNo) {
        this.nasdaqFirmNo = nasdaqFirmNo;
    }

    public String getDlrNasdaqSym() {
        return dlrNasdaqSym;
    }

    public void setDlrNasdaqSym(String dlrNasdaqSym) {
        this.dlrNasdaqSym = dlrNasdaqSym;
    }

    public String getIdcfm() {
        return idcfm;
    }

    public void setIdcfm(String idcfm) {
        this.idcfm = idcfm;
    }

    public String getGenericUserField() {
        return genericUserField;
    }

    public void setGenericUserField(String genericUserField) {
        this.genericUserField = genericUserField;
    }

    public String getNoCfmCode() {
        return noCfmCode;
    }

    public void setNoCfmCode(String noCfmCode) {
        this.noCfmCode = noCfmCode;
    }

    public String getFlipExch() {
        return flipExch;
    }

    public void setFlipExch(String flipExch) {
        this.flipExch = flipExch;
    }

    public String getCorrClear() {
        return corrClear;
    }

    public void setCorrClear(String corrClear) {
        this.corrClear = corrClear;
    }

    public String getStkCommSched() {
        return stkCommSched;
    }

    public void setStkCommSched(String stkCommSched) {
        this.stkCommSched = stkCommSched;
    }

    public String getBndCommSched() {
        return bndCommSched;
    }

    public void setBndCommSched(String bndCommSched) {
        this.bndCommSched = bndCommSched;
    }

    public String getOptCommSched() {
        return optCommSched;
    }

    public void setOptCommSched(String optCommSched) {
        this.optCommSched = optCommSched;
    }

    public String getPostageAmt() {
        return postageAmt;
    }

    public void setPostageAmt(String postageAmt) {
        this.postageAmt = postageAmt;
    }

    public String getMuniCnsPart() {
        return muniCnsPart;
    }

    public void setMuniCnsPart(String muniCnsPart) {
        this.muniCnsPart = muniCnsPart;
    }

    public String getNonCustomerSw() {
        return nonCustomerSw;
    }

    public void setNonCustomerSw(String nonCustomerSw) {
        this.nonCustomerSw = nonCustomerSw;
    }

    public String getNasdaqSym() {
        return nasdaqSym;
    }

    public void setNasdaqSym(String nasdaqSym) {
        this.nasdaqSym = nasdaqSym;
    }

    public String getPurgeInd() {
        return purgeInd;
    }

    public void setPurgeInd(String purgeInd) {
        this.purgeInd = purgeInd;
    }

    public String getBillBypass() {
        return billBypass;
    }

    public void setBillBypass(String billBypass) {
        this.billBypass = billBypass;
    }

    public String getOrderOnly() {
        return orderOnly;
    }

    public void setOrderOnly(String orderOnly) {
        this.orderOnly = orderOnly;
    }

    public String getIraTermCymd() {
        return iraTermCymd;
    }

    public void setIraTermCymd(String iraTermCymd) {
        this.iraTermCymd = iraTermCymd;
    }

    public String getReinvestCode() {
        return reinvestCode;
    }

    public void setReinvestCode(String reinvestCode) {
        this.reinvestCode = reinvestCode;
    }

    public String getCashDrOvrd() {
        return cashDrOvrd;
    }

    public void setCashDrOvrd(String cashDrOvrd) {
        this.cashDrOvrd = cashDrOvrd;
    }

    public String getTermReason() {
        return termReason;
    }

    public void setTermReason(String termReason) {
        this.termReason = termReason;
    }

    public String getIrsNameLine1() {
        return irsNameLine1;
    }

    public void setIrsNameLine1(String irsNameLine1) {
        this.irsNameLine1 = irsNameLine1;
    }

    public String getIrsNameLine2() {
        return irsNameLine2;
    }

    public void setIrsNameLine2(String irsNameLine2) {
        this.irsNameLine2 = irsNameLine2;
    }

    public String getNccFirmNo() {
        return nccFirmNo;
    }

    public void setNccFirmNo(String nccFirmNo) {
        this.nccFirmNo = nccFirmNo;
    }

    public String getAchInc() {
        return achInc;
    }

    public void setAchInc(String achInc) {
        this.achInc = achInc;
    }

    public String getAchCr() {
        return achCr;
    }

    public void setAchCr(String achCr) {
        this.achCr = achCr;
    }

    public String getAchDr() {
        return achDr;
    }

    public void setAchDr(String achDr) {
        this.achDr = achDr;
    }

    public String getOutsideMmf() {
        return outsideMmf;
    }

    public void setOutsideMmf(String outsideMmf) {
        this.outsideMmf = outsideMmf;
    }

    public String getRepB4Acats() {
        return repB4Acats;
    }

    public void setRepB4Acats(String repB4Acats) {
        this.repB4Acats = repB4Acats;
    }

    public String getF121StatusCode() {
        return f121StatusCode;
    }

    public void setF121StatusCode(String f121StatusCode) {
        this.f121StatusCode = f121StatusCode;
    }

    public String getGsccFirmNo() {
        return gsccFirmNo;
    }

    public void setGsccFirmNo(String gsccFirmNo) {
        this.gsccFirmNo = gsccFirmNo;
    }

    public String getGsccNo() {
        return gsccNo;
    }

    public void setGsccNo(String gsccNo) {
        this.gsccNo = gsccNo;
    }

    public String getMbsccFirmNo() {
        return mbsccFirmNo;
    }

    public void setMbsccFirmNo(String mbsccFirmNo) {
        this.mbsccFirmNo = mbsccFirmNo;
    }

    public String getMbsccNo() {
        return mbsccNo;
    }

    public void setMbsccNo(String mbsccNo) {
        this.mbsccNo = mbsccNo;
    }

    public String getEmpClassCode() {
        return empClassCode;
    }

    public void setEmpClassCode(String empClassCode) {
        this.empClassCode = empClassCode;
    }

    public String getLastReviewCode() {
        return lastReviewCode;
    }

    public void setLastReviewCode(String lastReviewCode) {
        this.lastReviewCode = lastReviewCode;
    }

    public String getLastReviewCymd() {
        return lastReviewCymd;
    }

    public void setLastReviewCymd(String lastReviewCymd) {
        this.lastReviewCymd = lastReviewCymd;
    }

    public String getDocRestrictCode() {
        return docRestrictCode;
    }

    public void setDocRestrictCode(String docRestrictCode) {
        this.docRestrictCode = docRestrictCode;
    }

    public String getDocRestrictCymd() {
        return docRestrictCymd;
    }

    public void setDocRestrictCymd(String docRestrictCymd) {
        this.docRestrictCymd = docRestrictCymd;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getActForm1() {
        return actForm1;
    }

    public void setActForm1(String actForm1) {
        this.actForm1 = actForm1;
    }

    public String getActForm2() {
        return actForm2;
    }

    public void setActForm2(String actForm2) {
        this.actForm2 = actForm2;
    }

    public String getActForm3() {
        return actForm3;
    }

    public void setActForm3(String actForm3) {
        this.actForm3 = actForm3;
    }

    public String getActForm4() {
        return actForm4;
    }

    public void setActForm4(String actForm4) {
        this.actForm4 = actForm4;
    }

    public String getActForm5() {
        return actForm5;
    }

    public void setActForm5(String actForm5) {
        this.actForm5 = actForm5;
    }

    public String getActForm6() {
        return actForm6;
    }

    public void setActForm6(String actForm6) {
        this.actForm6 = actForm6;
    }

    public String getActForm7() {
        return actForm7;
    }

    public void setActForm7(String actForm7) {
        this.actForm7 = actForm7;
    }

    public String getActForm8() {
        return actForm8;
    }

    public void setActForm8(String actForm8) {
        this.actForm8 = actForm8;
    }

    public String getActForm9() {
        return actForm9;
    }

    public void setActForm9(String actForm9) {
        this.actForm9 = actForm9;
    }

    public String getActForm10() {
        return actForm10;
    }

    public void setActForm10(String actForm10) {
        this.actForm10 = actForm10;
    }

    public String getActForm11() {
        return actForm11;
    }

    public void setActForm11(String actForm11) {
        this.actForm11 = actForm11;
    }

    public String getNoRebate() {
        return noRebate;
    }

    public void setNoRebate(String noRebate) {
        this.noRebate = noRebate;
    }

    public String getAlternateState() {
        return alternateState;
    }

    public void setAlternateState(String alternateState) {
        this.alternateState = alternateState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getNavrSw() {
        return navrSw;
    }

    public void setNavrSw(String navrSw) {
        this.navrSw = navrSw;
    }

    public String getWrapPlan() {
        return wrapPlan;
    }

    public void setWrapPlan(String wrapPlan) {
        this.wrapPlan = wrapPlan;
    }

    public String getMmfSecNo() {
        return mmfSecNo;
    }

    public void setMmfSecNo(String mmfSecNo) {
        this.mmfSecNo = mmfSecNo;
    }

    public String getMmfSellFirst() {
        return mmfSellFirst;
    }

    public void setMmfSellFirst(String mmfSellFirst) {
        this.mmfSellFirst = mmfSellFirst;
    }

    public String getAcatsAutoValid() {
        return acatsAutoValid;
    }

    public void setAcatsAutoValid(String acatsAutoValid) {
        this.acatsAutoValid = acatsAutoValid;
    }

    public String getBrrEligible() {
        return brrEligible;
    }

    public void setBrrEligible(String brrEligible) {
        this.brrEligible = brrEligible;
    }

    public String getRepoRequest() {
        return repoRequest;
    }

    public void setRepoRequest(String repoRequest) {
        this.repoRequest = repoRequest;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranchB4Acats() {
        return branchB4Acats;
    }

    public void setBranchB4Acats(String branchB4Acats) {
        this.branchB4Acats = branchB4Acats;
    }

    public String getReverseBranch() {
        return reverseBranch;
    }

    public void setReverseBranch(String reverseBranch) {
        this.reverseBranch = reverseBranch;
    }

    public String getDsExemptSw() {
        return dsExemptSw;
    }

    public void setDsExemptSw(String dsExemptSw) {
        this.dsExemptSw = dsExemptSw;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getCommOverride() {
        return commOverride;
    }

    public void setCommOverride(String commOverride) {
        this.commOverride = commOverride;
    }

    public String getBoltInd() {
        return boltInd;
    }

    public void setBoltInd(String boltInd) {
        this.boltInd = boltInd;
    }

    public String getInvestorCode() {
        return investorCode;
    }

    public void setInvestorCode(String investorCode) {
        this.investorCode = investorCode;
    }

    public String getIpoEligible() {
        return ipoEligible;
    }

    public void setIpoEligible(String ipoEligible) {
        this.ipoEligible = ipoEligible;
    }

    public String getChangeSource() {
        return changeSource;
    }

    public void setChangeSource(String changeSource) {
        this.changeSource = changeSource;
    }

    public String getChangeSourceId() {
        return changeSourceId;
    }

    public void setChangeSourceId(String changeSourceId) {
        this.changeSourceId = changeSourceId;
    }

    public String getStRegExempt() {
        return stRegExempt;
    }

    public void setStRegExempt(String stRegExempt) {
        this.stRegExempt = stRegExempt;
    }

    public String getNoTranFeeInd() {
        return noTranFeeInd;
    }

    public void setNoTranFeeInd(String noTranFeeInd) {
        this.noTranFeeInd = noTranFeeInd;
    }

    public String getAcctAvgPriceInd() {
        return acctAvgPriceInd;
    }

    public void setAcctAvgPriceInd(String acctAvgPriceInd) {
        this.acctAvgPriceInd = acctAvgPriceInd;
    }

    public String getPreventStockLoanInd() {
        return preventStockLoanInd;
    }

    public void setPreventStockLoanInd(String preventStockLoanInd) {
        this.preventStockLoanInd = preventStockLoanInd;
    }

    public String getAccessDeliverInd() {
        return accessDeliverInd;
    }

    public void setAccessDeliverInd(String accessDeliverInd) {
        this.accessDeliverInd = accessDeliverInd;
    }

    public String getSocialCode() {
        return socialCode;
    }

    public void setSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }

    public String getDfltCrncyType() {
        return dfltCrncyType;
    }

    public void setDfltCrncyType(String dfltCrncyType) {
        this.dfltCrncyType = dfltCrncyType;
    }

    public String getInstAcctInd() {
        return instAcctInd;
    }

    public void setInstAcctInd(String instAcctInd) {
        this.instAcctInd = instAcctInd;
    }

    public String getInvestorOptionCode() {
        return investorOptionCode;
    }

    public void setInvestorOptionCode(String investorOptionCode) {
        this.investorOptionCode = investorOptionCode;
    }

    public String getMgnTierSchedCode() {
        return mgnTierSchedCode;
    }

    public void setMgnTierSchedCode(String mgnTierSchedCode) {
        this.mgnTierSchedCode = mgnTierSchedCode;
    }

    public String getNaturalPersonCode() {
        return naturalPersonCode;
    }

    public void setNaturalPersonCode(String naturalPersonCode) {
        this.naturalPersonCode = naturalPersonCode;
    }

    public String getMultiCurrInd() {
        return multiCurrInd;
    }

    public void setMultiCurrInd(String multiCurrInd) {
        this.multiCurrInd = multiCurrInd;
    }

    public String getActCmpRvwInd() {
        return actCmpRvwInd;
    }

    public void setActCmpRvwInd(String actCmpRvwInd) {
        this.actCmpRvwInd = actCmpRvwInd;
    }

    public String getActMstInd() {
        return actMstInd;
    }

    public void setActMstInd(String actMstInd) {
        this.actMstInd = actMstInd;
    }

}