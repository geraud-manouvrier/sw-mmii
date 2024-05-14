package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class ActCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "old_acct_no")private String oldAcctNo;
    @CsvBindByName(column = "zip")private String zip;
    @CsvBindByName(column = "zip_plus4")private String zipPlus4;
    @CsvBindByName(column = "foreign_zip")private String foreignZip;
    @CsvBindByName(column = "namelines")private String namelines;
    @CsvBindByName(column = "name_line1")private String nameLine1;
    @CsvBindByName(column = "name_line2")private String nameLine2;
    @CsvBindByName(column = "name_line3")private String nameLine3;
    @CsvBindByName(column = "name_line4")private String nameLine4;
    @CsvBindByName(column = "name_line5")private String nameLine5;
    @CsvBindByName(column = "name_line6")private String nameLine6;
    @CsvBindByName(column = "key1")private String key1;
    @CsvBindByName(column = "key2")private String key2;
    @CsvBindByName(column = "key3")private String key3;
    @CsvBindByName(column = "key4")private String key4;
    @CsvBindByName(column = "key5")private String key5;
    @CsvBindByName(column = "home_phone")private String homePhone;
    @CsvBindByName(column = "work_phone")private String workPhone;
    @CsvBindByName(column = "alt_phone")private String altPhone;
    @CsvBindByName(column = "state_code")private String stateCode;
    @CsvBindByName(column = "country_code")private String countryCode;
    @CsvBindByName(column = "province_code")private String provinceCode;
    @CsvBindByName(column = "withhold_cntry")private String withholdCntry;
    @CsvBindByName(column = "no_auto_cancel_sw")private String noAutoCancelSw;
    @CsvBindByName(column = "noid_withhold_code")private String noidWithholdCode;
    @CsvBindByName(column = "tax_id_format")private String taxIdFormat;
    @CsvBindByName(column = "w8_mailing_cy")private String w8MailingCy;
    @CsvBindByName(column = "tax_id")private String taxId;
    @CsvBindByName(column = "last_activity_cym")private String lastActivityCym;
    @CsvBindByName(column = "open_cymd")private String openCymd;
    @CsvBindByName(column = "change_cymd")private String changeCymd;
    @CsvBindByName(column = "cash_si1")private String cashSi1;
    @CsvBindByName(column = "cash_si2")private String cashSi2;
    @CsvBindByName(column = "margin_si1")private String marginSi1;
    @CsvBindByName(column = "margin_si2")private String marginSi2;
    @CsvBindByName(column = "dividen_si")private String dividenSi;
    @CsvBindByName(column = "second_cash_si")private String secondCashSi;
    @CsvBindByName(column = "withhold_sw")private String withholdSw;
    @CsvBindByName(column = "w9_request_status")private String w9RequestStatus;
    @CsvBindByName(column = "w8_request_status")private String w8RequestStatus;
    @CsvBindByName(column = "tefra_exempt_sw")private String tefraExemptSw;
    @CsvBindByName(column = "principal_code")private String principalCode;
    @CsvBindByName(column = "f1001_status")private String f1001Status;
    @CsvBindByName(column = "inst_code")private String instCode;
    @CsvBindByName(column = "ny_tax_sw")private String nyTaxSw;
    @CsvBindByName(column = "inv_obj")private String invObj;
    @CsvBindByName(column = "class")private String classField;
    @CsvBindByName(column = "network_elig_fl")private String networkEligFl;
    @CsvBindByName(column = "misc7")private String misc7;
    @CsvBindByName(column = "cma")private String cma;
    @CsvBindByName(column = "viol_code")private String violCode;
    @CsvBindByName(column = "hist_code")private String histCode;
    @CsvBindByName(column = "director_sw")private String directorSw;
    @CsvBindByName(column = "proxy_discl_code")private String proxyDisclCode;
    @CsvBindByName(column = "discr_trading_code")private String discrTradingCode;
    @CsvBindByName(column = "optn_i_o_code")private String optnIOCode;
    @CsvBindByName(column = "avg_price")private String avgPrice;
    @CsvBindByName(column = "misc1")private String misc1;
    @CsvBindByName(column = "misc2")private String misc2;
    @CsvBindByName(column = "misc3")private String misc3;
    @CsvBindByName(column = "misc4")private String misc4;
    @CsvBindByName(column = "misc5")private String misc5;
    @CsvBindByName(column = "misc6")private String misc6;
    @CsvBindByName(column = "sweep_code")private String sweepCode;
    @CsvBindByName(column = "mmf_init_purch_sw")private String mmfInitPurchSw;
    @CsvBindByName(column = "cash_div_sw")private String cashDivSw;
    @CsvBindByName(column = "mmf_cash_only")private String mmfCashOnly;
    @CsvBindByName(column = "marg_int_rate")private String margIntRate;
    @CsvBindByName(column = "marg_int_chg")private String margIntChg;
    @CsvBindByName(column = "segregation_sw")private String segregationSw;
    @CsvBindByName(column = "credit_int_code")private String creditIntCode;
    @CsvBindByName(column = "option_loss_limit")private String optionLossLimit;
    @CsvBindByName(column = "erisa_code")private String erisaCode;
    @CsvBindByName(column = "cred_int_nopost_sw")private String credIntNopostSw;
    @CsvBindByName(column = "foreign_si1")private String foreignSi1;
    @CsvBindByName(column = "foreign_si2")private String foreignSi2;
    @CsvBindByName(column = "stk_discount")private String stkDiscount;
    @CsvBindByName(column = "bnd_discount")private String bndDiscount;
    @CsvBindByName(column = "opt_discount")private String optDiscount;
    @CsvBindByName(column = "confirm_copy")private String confirmCopy;
    @CsvBindByName(column = "reverse_rep")private String reverseRep;
    @CsvBindByName(column = "acat_term_fee_sw")private String acatTermFeeSw;
    @CsvBindByName(column = "withhold_cymd")private String withholdCymd;
    @CsvBindByName(column = "last_stmt_cym")private String lastStmtCym;
    @CsvBindByName(column = "mano")private String mano;
    @CsvBindByName(column = "manox")private String manox;
    @CsvBindByName(column = "restriction_cymd")private String restrictionCymd;
    @CsvBindByName(column = "mst_brkr")private String mstBrkr;
    @CsvBindByName(column = "company_merge_code")private String companyMergeCode;
    @CsvBindByName(column = "restriction_code")private String restrictionCode;
    @CsvBindByName(column = "no_journal_ind")private String noJournalInd;
    @CsvBindByName(column = "mmf_scvc_fee_sw")private String mmfScvcFeeSw;
    @CsvBindByName(column = "excl_mail_line1_sw")private String exclMailLine1Sw;
    @CsvBindByName(column = "excl_mail_line2_sw")private String exclMailLine2Sw;
    @CsvBindByName(column = "excl_mail_line3_sw")private String exclMailLine3Sw;
    @CsvBindByName(column = "use_code1_sw")private String useCode1Sw;
    @CsvBindByName(column = "download_code")private String downloadCode;
    @CsvBindByName(column = "inst_override_sw")private String instOverrideSw;
    @CsvBindByName(column = "remic_cmo_sw")private String remicCmoSw;
    @CsvBindByName(column = "account_doc_cat")private String accountDocCat;
    @CsvBindByName(column = "doc_tran_lvl")private String docTranLvl;
    @CsvBindByName(column = "prime_broker_code")private String primeBrokerCode;
    @CsvBindByName(column = "coll_loan_ac_sw")private String collLoanAcSw;
    @CsvBindByName(column = "acct_type_ind")private String acctTypeInd;
    @CsvBindByName(column = "tax_withholding_rt")private String taxWithholdingRt;
    @CsvBindByName(column = "tax_withholding_cd")private String taxWithholdingCd;
    @CsvBindByName(column = "fax_phone")private String faxPhone;
    @CsvBindByName(column = "rest_balance")private String restBalance;
    @CsvBindByName(column = "bar_code")private String barCode;
    @CsvBindByName(column = "bar_code_chk")private String barCodeChk;
    @CsvBindByName(column = "management_group")private String managementGroup;
    @CsvBindByName(column = "rein_label_sent_sw")private String reinLabelSentSw;
    @CsvBindByName(column = "divert_code")private String divertCode;
    @CsvBindByName(column = "prev_prin_trds_sw")private String prevPrinTrdsSw;
    @CsvBindByName(column = "tpa_number")private String tpaNumber;
    @CsvBindByName(column = "car_rt")private String carRt;
    @CsvBindByName(column = "product_class")private String productClass;
    @CsvBindByName(column = "cmta_no")private String cmtaNo;
    @CsvBindByName(column = "upd_term")private String updTerm;
    @CsvBindByName(column = "dlr_firm_no")private String dlrFirmNo;
    @CsvBindByName(column = "dlr_broker_no")private String dlrBrokerNo;
    @CsvBindByName(column = "lrate")private String lrate;
    @CsvBindByName(column = "sell_comm")private String sellComm;
    @CsvBindByName(column = "brate")private String brate;
    @CsvBindByName(column = "buy_comm")private String buyComm;
    @CsvBindByName(column = "nscc_no")private String nsccNo;
    @CsvBindByName(column = "dtc_fbo_code")private String dtcFboCode;
    @CsvBindByName(column = "nasdaq_firm_no")private String nasdaqFirmNo;
    @CsvBindByName(column = "dlr_nasdaq_sym")private String dlrNasdaqSym;
    @CsvBindByName(column = "idcfm")private String idcfm;
    @CsvBindByName(column = "generic_user_field")private String genericUserField;
    @CsvBindByName(column = "no_cfm_code")private String noCfmCode;
    @CsvBindByName(column = "flip_exch")private String flipExch;
    @CsvBindByName(column = "corr_clear")private String corrClear;
    @CsvBindByName(column = "stk_comm_sched")private String stkCommSched;
    @CsvBindByName(column = "bnd_comm_sched")private String bndCommSched;
    @CsvBindByName(column = "opt_comm_sched")private String optCommSched;
    @CsvBindByName(column = "postage_amt")private String postageAmt;
    @CsvBindByName(column = "muni_cns_part")private String muniCnsPart;
    @CsvBindByName(column = "non_customer_sw")private String nonCustomerSw;
    @CsvBindByName(column = "nasdaq_sym")private String nasdaqSym;
    @CsvBindByName(column = "purge_ind")private String purgeInd;
    @CsvBindByName(column = "bill_bypass")private String billBypass;
    @CsvBindByName(column = "order_only")private String orderOnly;
    @CsvBindByName(column = "ira_term_cymd")private String iraTermCymd;
    @CsvBindByName(column = "reinvest_code")private String reinvestCode;
    @CsvBindByName(column = "cash_dr_ovrd")private String cashDrOvrd;
    @CsvBindByName(column = "term_reason")private String termReason;
    @CsvBindByName(column = "irs_name_line1")private String irsNameLine1;
    @CsvBindByName(column = "irs_name_line2")private String irsNameLine2;
    @CsvBindByName(column = "ncc_firm_no")private String nccFirmNo;
    @CsvBindByName(column = "ach_inc")private String achInc;
    @CsvBindByName(column = "ach_cr")private String achCr;
    @CsvBindByName(column = "ach_dr")private String achDr;
    @CsvBindByName(column = "outside_mmf")private String outsideMmf;
    @CsvBindByName(column = "rep_b4_acats")private String repB4Acats;
    @CsvBindByName(column = "f121_status_code")private String f121StatusCode;
    @CsvBindByName(column = "gscc_firm_no")private String gsccFirmNo;
    @CsvBindByName(column = "gscc_no")private String gsccNo;
    @CsvBindByName(column = "mbscc_firm_no")private String mbsccFirmNo;
    @CsvBindByName(column = "mbscc_no")private String mbsccNo;
    @CsvBindByName(column = "emp_class_code")private String empClassCode;
    @CsvBindByName(column = "last_review_code")private String lastReviewCode;
    @CsvBindByName(column = "last_review_cymd")private String lastReviewCymd;
    @CsvBindByName(column = "doc_restrict_code")private String docRestrictCode;
    @CsvBindByName(column = "doc_restrict_cymd")private String docRestrictCymd;
    @CsvBindByName(column = "group_no")private String groupNo;
    @CsvBindByName(column = "act_form1")private String actForm1;
    @CsvBindByName(column = "act_form2")private String actForm2;
    @CsvBindByName(column = "act_form3")private String actForm3;
    @CsvBindByName(column = "act_form4")private String actForm4;
    @CsvBindByName(column = "act_form5")private String actForm5;
    @CsvBindByName(column = "act_form6")private String actForm6;
    @CsvBindByName(column = "act_form7")private String actForm7;
    @CsvBindByName(column = "act_form8")private String actForm8;
    @CsvBindByName(column = "act_form9")private String actForm9;
    @CsvBindByName(column = "act_form10")private String actForm10;
    @CsvBindByName(column = "act_form11")private String actForm11;
    @CsvBindByName(column = "no_rebate")private String noRebate;
    @CsvBindByName(column = "alternate_state")private String alternateState;
    @CsvBindByName(column = "city")private String city;
    @CsvBindByName(column = "nav")private String nav;
    @CsvBindByName(column = "navr_sw")private String navrSw;
    @CsvBindByName(column = "wrap_plan")private String wrapPlan;
    @CsvBindByName(column = "mmf_sec_no")private String mmfSecNo;
    @CsvBindByName(column = "mmf_sell_first")private String mmfSellFirst;
    @CsvBindByName(column = "acats_auto_valid")private String acatsAutoValid;
    @CsvBindByName(column = "brr_eligible")private String brrEligible;
    @CsvBindByName(column = "repo_request")private String repoRequest;
    @CsvBindByName(column = "branch")private String branch;
    @CsvBindByName(column = "branch_b4_acats")private String branchB4Acats;
    @CsvBindByName(column = "reverse_branch")private String reverseBranch;
    @CsvBindByName(column = "ds_exempt_sw")private String dsExemptSw;
    @CsvBindByName(column = "acct_status")private String acctStatus;
    @CsvBindByName(column = "comm_override")private String commOverride;
    @CsvBindByName(column = "bolt_ind")private String boltInd;
    @CsvBindByName(column = "investor_code")private String investorCode;
    @CsvBindByName(column = "ipo_eligible")private String ipoEligible;
    @CsvBindByName(column = "change_source")private String changeSource;
    @CsvBindByName(column = "change_source_id")private String changeSourceId;
    @CsvBindByName(column = "st_reg_exempt")private String stRegExempt;
    @CsvBindByName(column = "no_tran_fee_ind")private String noTranFeeInd;
    @CsvBindByName(column = "acct_avg_price_ind")private String acctAvgPriceInd;
    @CsvBindByName(column = "prevent_stock_loan_ind")private String preventStockLoanInd;
    @CsvBindByName(column = "access_deliver_ind")private String accessDeliverInd;
    @CsvBindByName(column = "social_code")private String socialCode;
    @CsvBindByName(column = "dflt_crncy_type")private String dfltCrncyType;
    @CsvBindByName(column = "inst_acct_ind")private String instAcctInd;
    @CsvBindByName(column = "investor_option_code")private String investorOptionCode;
    @CsvBindByName(column = "mgn_tier_sched_code")private String mgnTierSchedCode;
    @CsvBindByName(column = "natural_person_code")private String naturalPersonCode;
    @CsvBindByName(column = "multi_curr_ind")private String multiCurrInd;
    @CsvBindByName(column = "act_cmp_rvw_ind")private String actCmpRvwInd;
    @CsvBindByName(column = "act_mst_ind")private String actMstInd;

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
