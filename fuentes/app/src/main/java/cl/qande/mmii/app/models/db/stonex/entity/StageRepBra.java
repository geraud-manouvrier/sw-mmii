package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_rep_bra", schema = "stage_stonex")
public class StageRepBra {
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
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep_bra_cd", nullable = false, length = 100)
    private String repBraCd;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "employee_no", nullable = false, length = 100)
    private String employeeNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "employee_code", nullable = false, length = 100)
    private String employeeCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep_bra_name_desc", nullable = false, length = 100)
    private String repBraNameDesc;

    @Size(max = 100)
    @NotNull
    @Column(name = "home_phone_no", nullable = false, length = 100)
    private String homePhoneNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "bus_phone_no", nullable = false, length = 100)
    private String busPhoneNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "conv_rep", nullable = false, length = 100)
    private String convRep;

    @Size(max = 100)
    @NotNull
    @Column(name = "department", nullable = false, length = 100)
    private String department;

    @Size(max = 100)
    @NotNull
    @Column(name = "region", nullable = false, length = 100)
    private String region;

    @Size(max = 100)
    @NotNull
    @Column(name = "class", nullable = false, length = 100)
    private String classField;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_dr_gl", nullable = false, length = 100)
    private String cashDrGl;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_dr_ovrd", nullable = false, length = 100)
    private String cashDrOvrd;

    @Size(max = 100)
    @NotNull
    @Column(name = "reg_cymd", nullable = false, length = 100)
    private String regCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "pay_group", nullable = false, length = 100)
    private String payGroup;

    @Size(max = 100)
    @NotNull
    @Column(name = "prt_on_cnfrms", nullable = false, length = 100)
    private String prtOnCnfrms;

    @Size(max = 100)
    @NotNull
    @Column(name = "pay_term", nullable = false, length = 100)
    private String payTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "doc_remote_prt_sw", nullable = false, length = 100)
    private String docRemotePrtSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "field_3x5_sets", nullable = false, length = 100)
    private String field3x5Sets;

    @Size(max = 100)
    @NotNull
    @Column(name = "qtrly_fee_exempt", nullable = false, length = 100)
    private String qtrlyFeeExempt;

    @Size(max = 100)
    @NotNull
    @Column(name = "matcall_rpt_seq", nullable = false, length = 100)
    private String matcallRptSeq;

    @Size(max = 100)
    @NotNull
    @Column(name = "distr_agent_code", nullable = false, length = 100)
    private String distrAgentCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "distr_agent_no", nullable = false, length = 100)
    private String distrAgentNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "field_agent_no", nullable = false, length = 100)
    private String fieldAgentNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "general_agent_code", nullable = false, length = 100)
    private String generalAgentCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "general_agent_no", nullable = false, length = 100)
    private String generalAgentNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_mode", nullable = false, length = 100)
    private String regtMode;

    @Size(max = 100)
    @NotNull
    @Column(name = "link_no", nullable = false, length = 100)
    private String linkNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "is_own_branch_sw", nullable = false, length = 100)
    private String isOwnBranchSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep_bra_chg_cymd", nullable = false, length = 100)
    private String repBraChgCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "ml_mgr_sw", nullable = false, length = 100)
    private String mlMgrSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_group_no", nullable = false, length = 100)
    private String internalGroupNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "group_no", nullable = false, length = 100)
    private String groupNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "send_book_ind", nullable = false, length = 100)
    private String sendBookInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "send_cust_ind", nullable = false, length = 100)
    private String sendCustInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "send_mony_ind", nullable = false, length = 100)
    private String sendMonyInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "send_posi_ind", nullable = false, length = 100)
    private String sendPosiInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "send_clos_ind", nullable = false, length = 100)
    private String sendClosInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "bq_controller", nullable = false, length = 100)
    private String bqController;

    @Size(max = 100)
    @NotNull
    @Column(name = "bq_session", nullable = false, length = 100)
    private String bqSession;

    @Size(max = 100)
    @NotNull
    @Column(name = "bq_exec_msg", nullable = false, length = 100)
    private String bqExecMsg;

    @Size(max = 100)
    @NotNull
    @Column(name = "start_cym", nullable = false, length = 100)
    private String startCym;

    @Size(max = 100)
    @NotNull
    @Column(name = "statement_line1", nullable = false, length = 100)
    private String statementLine1;

    @Size(max = 100)
    @NotNull
    @Column(name = "statement_line2", nullable = false, length = 100)
    private String statementLine2;

    @Size(max = 100)
    @NotNull
    @Column(name = "statement_line3", nullable = false, length = 100)
    private String statementLine3;

    @Size(max = 100)
    @NotNull
    @Column(name = "regular_pay", nullable = false, length = 100)
    private String regularPay;

    @Size(max = 100)
    @NotNull
    @Column(name = "bonus_pay", nullable = false, length = 100)
    private String bonusPay;

    @Size(max = 100)
    @NotNull
    @Column(name = "total_comm", nullable = false, length = 100)
    private String totalComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "bonus_comm", nullable = false, length = 100)
    private String bonusComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "today_regular_pay", nullable = false, length = 100)
    private String todayRegularPay;

    @Size(max = 100)
    @NotNull
    @Column(name = "today_bonus_pay", nullable = false, length = 100)
    private String todayBonusPay;

    @Size(max = 100)
    @NotNull
    @Column(name = "today_total_comm", nullable = false, length = 100)
    private String todayTotalComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "today_bonus_comm", nullable = false, length = 100)
    private String todayBonusComm;

    @Size(max = 100)
    @NotNull
    @Column(name = "commission_limit", nullable = false, length = 100)
    private String commissionLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "comm_equity_limit", nullable = false, length = 100)
    private String commEquityLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "pct_loss_limit", nullable = false, length = 100)
    private String pctLossLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "trades_limit", nullable = false, length = 100)
    private String tradesLimit;

    @Size(max = 100)
    @NotNull
    @Column(name = "stk_sched", nullable = false, length = 100)
    private String stkSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "bnd_sched", nullable = false, length = 100)
    private String bndSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_sched", nullable = false, length = 100)
    private String optSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "fut_sched", nullable = false, length = 100)
    private String futSched;

    @Size(max = 100)
    @NotNull
    @Column(name = "printer_dest", nullable = false, length = 100)
    private String printerDest;

    @Size(max = 100)
    @NotNull
    @Column(name = "alternate_printer1", nullable = false, length = 100)
    private String alternatePrinter1;

    @Size(max = 100)
    @NotNull
    @Column(name = "alternate_printer2", nullable = false, length = 100)
    private String alternatePrinter2;

    @Size(max = 100)
    @NotNull
    @Column(name = "alternate_printer3", nullable = false, length = 100)
    private String alternatePrinter3;

    @Size(max = 100)
    @NotNull
    @Column(name = "postage_amt", nullable = false, length = 100)
    private String postageAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_postage", nullable = false, length = 100)
    private String noPostage;

    @Size(max = 100)
    @NotNull
    @Column(name = "download_pos", nullable = false, length = 100)
    private String downloadPos;

    @Size(max = 100)
    @NotNull
    @Column(name = "ledger_break_rep", nullable = false, length = 100)
    private String ledgerBreakRep;

    @Size(max = 100)
    @NotNull
    @Column(name = "journal_appr_sw", nullable = false, length = 100)
    private String journalApprSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "addr_line1", nullable = false, length = 100)
    private String addrLine1;

    @Size(max = 100)
    @NotNull
    @Column(name = "addr_line2", nullable = false, length = 100)
    private String addrLine2;

    @Size(max = 100)
    @NotNull
    @Column(name = "addr_line3", nullable = false, length = 100)
    private String addrLine3;

    @Size(max = 100)
    @NotNull
    @Column(name = "addr_line4", nullable = false, length = 100)
    private String addrLine4;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep1", nullable = false, length = 100)
    private String splitRep1;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct1", nullable = false, length = 100)
    private String splitPct1;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep2", nullable = false, length = 100)
    private String splitRep2;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct2", nullable = false, length = 100)
    private String splitPct2;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep3", nullable = false, length = 100)
    private String splitRep3;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct3", nullable = false, length = 100)
    private String splitPct3;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep4", nullable = false, length = 100)
    private String splitRep4;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct4", nullable = false, length = 100)
    private String splitPct4;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep5", nullable = false, length = 100)
    private String splitRep5;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct5", nullable = false, length = 100)
    private String splitPct5;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep6", nullable = false, length = 100)
    private String splitRep6;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct6", nullable = false, length = 100)
    private String splitPct6;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep7", nullable = false, length = 100)
    private String splitRep7;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct7", nullable = false, length = 100)
    private String splitPct7;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep8", nullable = false, length = 100)
    private String splitRep8;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct8", nullable = false, length = 100)
    private String splitPct8;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep9", nullable = false, length = 100)
    private String splitRep9;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct9", nullable = false, length = 100)
    private String splitPct9;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_rep10", nullable = false, length = 100)
    private String splitRep10;

    @Size(max = 100)
    @NotNull
    @Column(name = "split_pct10", nullable = false, length = 100)
    private String splitPct10;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_level1", nullable = false, length = 100)
    private String regtLevel1;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_charge1", nullable = false, length = 100)
    private String regtCharge1;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_level2", nullable = false, length = 100)
    private String regtLevel2;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_charge2", nullable = false, length = 100)
    private String regtCharge2;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_level3", nullable = false, length = 100)
    private String regtLevel3;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_charge3", nullable = false, length = 100)
    private String regtCharge3;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_level4", nullable = false, length = 100)
    private String regtLevel4;

    @Size(max = 100)
    @NotNull
    @Column(name = "regt_charge4", nullable = false, length = 100)
    private String regtCharge4;

    @Size(max = 100)
    @NotNull
    @Column(name = "conv_office", nullable = false, length = 100)
    private String convOffice;

    @Size(max = 100)
    @NotNull
    @Column(name = "postage_ovrd", nullable = false, length = 100)
    private String postageOvrd;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep_reccode", nullable = false, length = 100)
    private String repReccode;

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

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getRepBraCd() {
        return repBraCd;
    }

    public void setRepBraCd(String repBraCd) {
        this.repBraCd = repBraCd;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getRepBraNameDesc() {
        return repBraNameDesc;
    }

    public void setRepBraNameDesc(String repBraNameDesc) {
        this.repBraNameDesc = repBraNameDesc;
    }

    public String getHomePhoneNo() {
        return homePhoneNo;
    }

    public void setHomePhoneNo(String homePhoneNo) {
        this.homePhoneNo = homePhoneNo;
    }

    public String getBusPhoneNo() {
        return busPhoneNo;
    }

    public void setBusPhoneNo(String busPhoneNo) {
        this.busPhoneNo = busPhoneNo;
    }

    public String getConvRep() {
        return convRep;
    }

    public void setConvRep(String convRep) {
        this.convRep = convRep;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public String getCashDrGl() {
        return cashDrGl;
    }

    public void setCashDrGl(String cashDrGl) {
        this.cashDrGl = cashDrGl;
    }

    public String getCashDrOvrd() {
        return cashDrOvrd;
    }

    public void setCashDrOvrd(String cashDrOvrd) {
        this.cashDrOvrd = cashDrOvrd;
    }

    public String getRegCymd() {
        return regCymd;
    }

    public void setRegCymd(String regCymd) {
        this.regCymd = regCymd;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public String getPrtOnCnfrms() {
        return prtOnCnfrms;
    }

    public void setPrtOnCnfrms(String prtOnCnfrms) {
        this.prtOnCnfrms = prtOnCnfrms;
    }

    public String getPayTerm() {
        return payTerm;
    }

    public void setPayTerm(String payTerm) {
        this.payTerm = payTerm;
    }

    public String getDocRemotePrtSw() {
        return docRemotePrtSw;
    }

    public void setDocRemotePrtSw(String docRemotePrtSw) {
        this.docRemotePrtSw = docRemotePrtSw;
    }

    public String getField3x5Sets() {
        return field3x5Sets;
    }

    public void setField3x5Sets(String field3x5Sets) {
        this.field3x5Sets = field3x5Sets;
    }

    public String getQtrlyFeeExempt() {
        return qtrlyFeeExempt;
    }

    public void setQtrlyFeeExempt(String qtrlyFeeExempt) {
        this.qtrlyFeeExempt = qtrlyFeeExempt;
    }

    public String getMatcallRptSeq() {
        return matcallRptSeq;
    }

    public void setMatcallRptSeq(String matcallRptSeq) {
        this.matcallRptSeq = matcallRptSeq;
    }

    public String getDistrAgentCode() {
        return distrAgentCode;
    }

    public void setDistrAgentCode(String distrAgentCode) {
        this.distrAgentCode = distrAgentCode;
    }

    public String getDistrAgentNo() {
        return distrAgentNo;
    }

    public void setDistrAgentNo(String distrAgentNo) {
        this.distrAgentNo = distrAgentNo;
    }

    public String getFieldAgentNo() {
        return fieldAgentNo;
    }

    public void setFieldAgentNo(String fieldAgentNo) {
        this.fieldAgentNo = fieldAgentNo;
    }

    public String getGeneralAgentCode() {
        return generalAgentCode;
    }

    public void setGeneralAgentCode(String generalAgentCode) {
        this.generalAgentCode = generalAgentCode;
    }

    public String getGeneralAgentNo() {
        return generalAgentNo;
    }

    public void setGeneralAgentNo(String generalAgentNo) {
        this.generalAgentNo = generalAgentNo;
    }

    public String getRegtMode() {
        return regtMode;
    }

    public void setRegtMode(String regtMode) {
        this.regtMode = regtMode;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }

    public String getIsOwnBranchSw() {
        return isOwnBranchSw;
    }

    public void setIsOwnBranchSw(String isOwnBranchSw) {
        this.isOwnBranchSw = isOwnBranchSw;
    }

    public String getRepBraChgCymd() {
        return repBraChgCymd;
    }

    public void setRepBraChgCymd(String repBraChgCymd) {
        this.repBraChgCymd = repBraChgCymd;
    }

    public String getMlMgrSw() {
        return mlMgrSw;
    }

    public void setMlMgrSw(String mlMgrSw) {
        this.mlMgrSw = mlMgrSw;
    }

    public String getInternalGroupNo() {
        return internalGroupNo;
    }

    public void setInternalGroupNo(String internalGroupNo) {
        this.internalGroupNo = internalGroupNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getSendBookInd() {
        return sendBookInd;
    }

    public void setSendBookInd(String sendBookInd) {
        this.sendBookInd = sendBookInd;
    }

    public String getSendCustInd() {
        return sendCustInd;
    }

    public void setSendCustInd(String sendCustInd) {
        this.sendCustInd = sendCustInd;
    }

    public String getSendMonyInd() {
        return sendMonyInd;
    }

    public void setSendMonyInd(String sendMonyInd) {
        this.sendMonyInd = sendMonyInd;
    }

    public String getSendPosiInd() {
        return sendPosiInd;
    }

    public void setSendPosiInd(String sendPosiInd) {
        this.sendPosiInd = sendPosiInd;
    }

    public String getSendClosInd() {
        return sendClosInd;
    }

    public void setSendClosInd(String sendClosInd) {
        this.sendClosInd = sendClosInd;
    }

    public String getBqController() {
        return bqController;
    }

    public void setBqController(String bqController) {
        this.bqController = bqController;
    }

    public String getBqSession() {
        return bqSession;
    }

    public void setBqSession(String bqSession) {
        this.bqSession = bqSession;
    }

    public String getBqExecMsg() {
        return bqExecMsg;
    }

    public void setBqExecMsg(String bqExecMsg) {
        this.bqExecMsg = bqExecMsg;
    }

    public String getStartCym() {
        return startCym;
    }

    public void setStartCym(String startCym) {
        this.startCym = startCym;
    }

    public String getStatementLine1() {
        return statementLine1;
    }

    public void setStatementLine1(String statementLine1) {
        this.statementLine1 = statementLine1;
    }

    public String getStatementLine2() {
        return statementLine2;
    }

    public void setStatementLine2(String statementLine2) {
        this.statementLine2 = statementLine2;
    }

    public String getStatementLine3() {
        return statementLine3;
    }

    public void setStatementLine3(String statementLine3) {
        this.statementLine3 = statementLine3;
    }

    public String getRegularPay() {
        return regularPay;
    }

    public void setRegularPay(String regularPay) {
        this.regularPay = regularPay;
    }

    public String getBonusPay() {
        return bonusPay;
    }

    public void setBonusPay(String bonusPay) {
        this.bonusPay = bonusPay;
    }

    public String getTotalComm() {
        return totalComm;
    }

    public void setTotalComm(String totalComm) {
        this.totalComm = totalComm;
    }

    public String getBonusComm() {
        return bonusComm;
    }

    public void setBonusComm(String bonusComm) {
        this.bonusComm = bonusComm;
    }

    public String getTodayRegularPay() {
        return todayRegularPay;
    }

    public void setTodayRegularPay(String todayRegularPay) {
        this.todayRegularPay = todayRegularPay;
    }

    public String getTodayBonusPay() {
        return todayBonusPay;
    }

    public void setTodayBonusPay(String todayBonusPay) {
        this.todayBonusPay = todayBonusPay;
    }

    public String getTodayTotalComm() {
        return todayTotalComm;
    }

    public void setTodayTotalComm(String todayTotalComm) {
        this.todayTotalComm = todayTotalComm;
    }

    public String getTodayBonusComm() {
        return todayBonusComm;
    }

    public void setTodayBonusComm(String todayBonusComm) {
        this.todayBonusComm = todayBonusComm;
    }

    public String getCommissionLimit() {
        return commissionLimit;
    }

    public void setCommissionLimit(String commissionLimit) {
        this.commissionLimit = commissionLimit;
    }

    public String getCommEquityLimit() {
        return commEquityLimit;
    }

    public void setCommEquityLimit(String commEquityLimit) {
        this.commEquityLimit = commEquityLimit;
    }

    public String getPctLossLimit() {
        return pctLossLimit;
    }

    public void setPctLossLimit(String pctLossLimit) {
        this.pctLossLimit = pctLossLimit;
    }

    public String getTradesLimit() {
        return tradesLimit;
    }

    public void setTradesLimit(String tradesLimit) {
        this.tradesLimit = tradesLimit;
    }

    public String getStkSched() {
        return stkSched;
    }

    public void setStkSched(String stkSched) {
        this.stkSched = stkSched;
    }

    public String getBndSched() {
        return bndSched;
    }

    public void setBndSched(String bndSched) {
        this.bndSched = bndSched;
    }

    public String getOptSched() {
        return optSched;
    }

    public void setOptSched(String optSched) {
        this.optSched = optSched;
    }

    public String getFutSched() {
        return futSched;
    }

    public void setFutSched(String futSched) {
        this.futSched = futSched;
    }

    public String getPrinterDest() {
        return printerDest;
    }

    public void setPrinterDest(String printerDest) {
        this.printerDest = printerDest;
    }

    public String getAlternatePrinter1() {
        return alternatePrinter1;
    }

    public void setAlternatePrinter1(String alternatePrinter1) {
        this.alternatePrinter1 = alternatePrinter1;
    }

    public String getAlternatePrinter2() {
        return alternatePrinter2;
    }

    public void setAlternatePrinter2(String alternatePrinter2) {
        this.alternatePrinter2 = alternatePrinter2;
    }

    public String getAlternatePrinter3() {
        return alternatePrinter3;
    }

    public void setAlternatePrinter3(String alternatePrinter3) {
        this.alternatePrinter3 = alternatePrinter3;
    }

    public String getPostageAmt() {
        return postageAmt;
    }

    public void setPostageAmt(String postageAmt) {
        this.postageAmt = postageAmt;
    }

    public String getNoPostage() {
        return noPostage;
    }

    public void setNoPostage(String noPostage) {
        this.noPostage = noPostage;
    }

    public String getDownloadPos() {
        return downloadPos;
    }

    public void setDownloadPos(String downloadPos) {
        this.downloadPos = downloadPos;
    }

    public String getLedgerBreakRep() {
        return ledgerBreakRep;
    }

    public void setLedgerBreakRep(String ledgerBreakRep) {
        this.ledgerBreakRep = ledgerBreakRep;
    }

    public String getJournalApprSw() {
        return journalApprSw;
    }

    public void setJournalApprSw(String journalApprSw) {
        this.journalApprSw = journalApprSw;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getAddrLine3() {
        return addrLine3;
    }

    public void setAddrLine3(String addrLine3) {
        this.addrLine3 = addrLine3;
    }

    public String getAddrLine4() {
        return addrLine4;
    }

    public void setAddrLine4(String addrLine4) {
        this.addrLine4 = addrLine4;
    }

    public String getSplitRep1() {
        return splitRep1;
    }

    public void setSplitRep1(String splitRep1) {
        this.splitRep1 = splitRep1;
    }

    public String getSplitPct1() {
        return splitPct1;
    }

    public void setSplitPct1(String splitPct1) {
        this.splitPct1 = splitPct1;
    }

    public String getSplitRep2() {
        return splitRep2;
    }

    public void setSplitRep2(String splitRep2) {
        this.splitRep2 = splitRep2;
    }

    public String getSplitPct2() {
        return splitPct2;
    }

    public void setSplitPct2(String splitPct2) {
        this.splitPct2 = splitPct2;
    }

    public String getSplitRep3() {
        return splitRep3;
    }

    public void setSplitRep3(String splitRep3) {
        this.splitRep3 = splitRep3;
    }

    public String getSplitPct3() {
        return splitPct3;
    }

    public void setSplitPct3(String splitPct3) {
        this.splitPct3 = splitPct3;
    }

    public String getSplitRep4() {
        return splitRep4;
    }

    public void setSplitRep4(String splitRep4) {
        this.splitRep4 = splitRep4;
    }

    public String getSplitPct4() {
        return splitPct4;
    }

    public void setSplitPct4(String splitPct4) {
        this.splitPct4 = splitPct4;
    }

    public String getSplitRep5() {
        return splitRep5;
    }

    public void setSplitRep5(String splitRep5) {
        this.splitRep5 = splitRep5;
    }

    public String getSplitPct5() {
        return splitPct5;
    }

    public void setSplitPct5(String splitPct5) {
        this.splitPct5 = splitPct5;
    }

    public String getSplitRep6() {
        return splitRep6;
    }

    public void setSplitRep6(String splitRep6) {
        this.splitRep6 = splitRep6;
    }

    public String getSplitPct6() {
        return splitPct6;
    }

    public void setSplitPct6(String splitPct6) {
        this.splitPct6 = splitPct6;
    }

    public String getSplitRep7() {
        return splitRep7;
    }

    public void setSplitRep7(String splitRep7) {
        this.splitRep7 = splitRep7;
    }

    public String getSplitPct7() {
        return splitPct7;
    }

    public void setSplitPct7(String splitPct7) {
        this.splitPct7 = splitPct7;
    }

    public String getSplitRep8() {
        return splitRep8;
    }

    public void setSplitRep8(String splitRep8) {
        this.splitRep8 = splitRep8;
    }

    public String getSplitPct8() {
        return splitPct8;
    }

    public void setSplitPct8(String splitPct8) {
        this.splitPct8 = splitPct8;
    }

    public String getSplitRep9() {
        return splitRep9;
    }

    public void setSplitRep9(String splitRep9) {
        this.splitRep9 = splitRep9;
    }

    public String getSplitPct9() {
        return splitPct9;
    }

    public void setSplitPct9(String splitPct9) {
        this.splitPct9 = splitPct9;
    }

    public String getSplitRep10() {
        return splitRep10;
    }

    public void setSplitRep10(String splitRep10) {
        this.splitRep10 = splitRep10;
    }

    public String getSplitPct10() {
        return splitPct10;
    }

    public void setSplitPct10(String splitPct10) {
        this.splitPct10 = splitPct10;
    }

    public String getRegtLevel1() {
        return regtLevel1;
    }

    public void setRegtLevel1(String regtLevel1) {
        this.regtLevel1 = regtLevel1;
    }

    public String getRegtCharge1() {
        return regtCharge1;
    }

    public void setRegtCharge1(String regtCharge1) {
        this.regtCharge1 = regtCharge1;
    }

    public String getRegtLevel2() {
        return regtLevel2;
    }

    public void setRegtLevel2(String regtLevel2) {
        this.regtLevel2 = regtLevel2;
    }

    public String getRegtCharge2() {
        return regtCharge2;
    }

    public void setRegtCharge2(String regtCharge2) {
        this.regtCharge2 = regtCharge2;
    }

    public String getRegtLevel3() {
        return regtLevel3;
    }

    public void setRegtLevel3(String regtLevel3) {
        this.regtLevel3 = regtLevel3;
    }

    public String getRegtCharge3() {
        return regtCharge3;
    }

    public void setRegtCharge3(String regtCharge3) {
        this.regtCharge3 = regtCharge3;
    }

    public String getRegtLevel4() {
        return regtLevel4;
    }

    public void setRegtLevel4(String regtLevel4) {
        this.regtLevel4 = regtLevel4;
    }

    public String getRegtCharge4() {
        return regtCharge4;
    }

    public void setRegtCharge4(String regtCharge4) {
        this.regtCharge4 = regtCharge4;
    }

    public String getConvOffice() {
        return convOffice;
    }

    public void setConvOffice(String convOffice) {
        this.convOffice = convOffice;
    }

    public String getPostageOvrd() {
        return postageOvrd;
    }

    public void setPostageOvrd(String postageOvrd) {
        this.postageOvrd = postageOvrd;
    }

    public String getRepReccode() {
        return repReccode;
    }

    public void setRepReccode(String repReccode) {
        this.repReccode = repReccode;
    }

}