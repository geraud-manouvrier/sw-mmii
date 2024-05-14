package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_adm", schema = "stage_stonex")
public class StageAdm {
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
    @Column(name = "bday_cymd", nullable = false, length = 100)
    private String bdayCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sex", nullable = false, length = 100)
    private String sex;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_name", nullable = false, length = 100)
    private String employerName;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_addr", nullable = false, length = 100)
    private String employerAddr;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_city", nullable = false, length = 100)
    private String employerCity;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_state", nullable = false, length = 100)
    private String employerState;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_zip", nullable = false, length = 100)
    private String employerZip;

    @Size(max = 100)
    @NotNull
    @Column(name = "employer_zip4", nullable = false, length = 100)
    private String employerZip4;

    @Size(max = 100)
    @NotNull
    @Column(name = "business_nature", nullable = false, length = 100)
    private String businessNature;

    @Size(max = 100)
    @NotNull
    @Column(name = "occupation", nullable = false, length = 100)
    private String occupation;

    @Size(max = 100)
    @NotNull
    @Column(name = "years_employed", nullable = false, length = 100)
    private String yearsEmployed;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_bday_cymd", nullable = false, length = 100)
    private String spseBdayCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_name", nullable = false, length = 100)
    private String spseEmpName;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_addr", nullable = false, length = 100)
    private String spseEmpAddr;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_city", nullable = false, length = 100)
    private String spseEmpCity;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_state", nullable = false, length = 100)
    private String spseEmpState;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_zip", nullable = false, length = 100)
    private String spseEmpZip;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_emp_zip4", nullable = false, length = 100)
    private String spseEmpZip4;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_bus_nature", nullable = false, length = 100)
    private String spseBusNature;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_occupation", nullable = false, length = 100)
    private String spseOccupation;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_yrs_employ", nullable = false, length = 100)
    private String spseYrsEmploy;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_net_income", nullable = false, length = 100)
    private String spseNetIncome;

    @Size(max = 100)
    @NotNull
    @Column(name = "spse_bus_phone", nullable = false, length = 100)
    private String spseBusPhone;

    @Size(max = 100)
    @NotNull
    @Column(name = "marital_status", nullable = false, length = 100)
    private String maritalStatus;

    @Size(max = 100)
    @NotNull
    @Column(name = "home_own_rent", nullable = false, length = 100)
    private String homeOwnRent;

    @Size(max = 100)
    @NotNull
    @Column(name = "dependents", nullable = false, length = 100)
    private String dependents;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_bracket", nullable = false, length = 100)
    private String taxBracket;

    @Size(max = 100)
    @NotNull
    @Column(name = "adm_references", nullable = false, length = 100)
    private String admReferences;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_acquired", nullable = false, length = 100)
    private String acctAcquired;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_income", nullable = false, length = 100)
    private String netIncome;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_net", nullable = false, length = 100)
    private String liqNet;

    @Size(max = 100)
    @NotNull
    @Column(name = "invest_exp_stk", nullable = false, length = 100)
    private String investExpStk;

    @Size(max = 100)
    @NotNull
    @Column(name = "invest_exp_opt", nullable = false, length = 100)
    private String investExpOpt;

    @Size(max = 100)
    @NotNull
    @Column(name = "invest_exp_mmf", nullable = false, length = 100)
    private String investExpMmf;

    @Size(max = 100)
    @NotNull
    @Column(name = "invest_exp_ann", nullable = false, length = 100)
    private String investExpAnn;

    @Size(max = 100)
    @NotNull
    @Column(name = "initial_trans", nullable = false, length = 100)
    private String initialTrans;

    @Size(max = 100)
    @NotNull
    @Column(name = "plan_invest_amt", nullable = false, length = 100)
    private String planInvestAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_worth", nullable = false, length = 100)
    private String netWorth;

    @Size(max = 100)
    @NotNull
    @Column(name = "client_met", nullable = false, length = 100)
    private String clientMet;

    @Size(max = 100)
    @NotNull
    @Column(name = "corp_officer", nullable = false, length = 100)
    private String corpOfficer;

    @Size(max = 100)
    @NotNull
    @Column(name = "edu_level", nullable = false, length = 100)
    private String eduLevel;

    @Size(max = 100)
    @NotNull
    @Column(name = "retired", nullable = false, length = 100)
    private String retired;

    @Size(max = 100)
    @NotNull
    @Column(name = "policy_owner", nullable = false, length = 100)
    private String policyOwner;

    @Size(max = 100)
    @NotNull
    @Column(name = "update_who", nullable = false, length = 100)
    private String updateWho;

    @Size(max = 100)
    @NotNull
    @Column(name = "update_term", nullable = false, length = 100)
    private String updateTerm;

    @Size(max = 100)
    @NotNull
    @Column(name = "update_cymd", nullable = false, length = 100)
    private String updateCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_cymd", nullable = false, length = 100)
    private String addCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "note1", nullable = false, length = 100)
    private String note1;

    @Size(max = 100)
    @NotNull
    @Column(name = "note2", nullable = false, length = 100)
    private String note2;

    @Size(max = 100)
    @NotNull
    @Column(name = "note3", nullable = false, length = 100)
    private String note3;

    @Size(max = 100)
    @NotNull
    @Column(name = "note4", nullable = false, length = 100)
    private String note4;

    @Size(max = 100)
    @NotNull
    @Column(name = "note5", nullable = false, length = 100)
    private String note5;

    @Size(max = 100)
    @NotNull
    @Column(name = "note6", nullable = false, length = 100)
    private String note6;

    @Size(max = 100)
    @NotNull
    @Column(name = "bdate_estimated", nullable = false, length = 100)
    private String bdateEstimated;

    @Size(max = 100)
    @NotNull
    @Column(name = "email_addr", nullable = false, length = 100)
    private String emailAddr;

    @Size(max = 100)
    @NotNull
    @Column(name = "risk_tolerance", nullable = false, length = 100)
    private String riskTolerance;

    @Size(max = 100)
    @NotNull
    @Column(name = "option_objective", nullable = false, length = 100)
    private String optionObjective;

    @Size(max = 100)
    @NotNull
    @Column(name = "first_opt_trd_cymd", nullable = false, length = 100)
    private String firstOptTrdCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_prospect_cymd", nullable = false, length = 100)
    private String optProspectCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_net_worth", nullable = false, length = 100)
    private String liqNetWorth;

    @Size(max = 100)
    @NotNull
    @Column(name = "email_addr2", nullable = false, length = 100)
    private String emailAddr2;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_cusip1", nullable = false, length = 100)
    private String controlCusip1;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_cusip2", nullable = false, length = 100)
    private String controlCusip2;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_cusip3", nullable = false, length = 100)
    private String controlCusip3;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_obj1", nullable = false, length = 100)
    private String secObj1;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_obj2", nullable = false, length = 100)
    private String secObj2;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_obj3", nullable = false, length = 100)
    private String secObj3;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_obj4", nullable = false, length = 100)
    private String secObj4;

    @Size(max = 100)
    @NotNull
    @Column(name = "show_discount_sw", nullable = false, length = 100)
    private String showDiscountSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "conf_trailer", nullable = false, length = 100)
    private String confTrailer;

    @Size(max = 100)
    @NotNull
    @Column(name = "perf_rpt", nullable = false, length = 100)
    private String perfRpt;

    @Size(max = 100)
    @NotNull
    @Column(name = "invest_exp_bond", nullable = false, length = 100)
    private String investExpBond;

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

    public String getBdayCymd() {
        return bdayCymd;
    }

    public void setBdayCymd(String bdayCymd) {
        this.bdayCymd = bdayCymd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddr() {
        return employerAddr;
    }

    public void setEmployerAddr(String employerAddr) {
        this.employerAddr = employerAddr;
    }

    public String getEmployerCity() {
        return employerCity;
    }

    public void setEmployerCity(String employerCity) {
        this.employerCity = employerCity;
    }

    public String getEmployerState() {
        return employerState;
    }

    public void setEmployerState(String employerState) {
        this.employerState = employerState;
    }

    public String getEmployerZip() {
        return employerZip;
    }

    public void setEmployerZip(String employerZip) {
        this.employerZip = employerZip;
    }

    public String getEmployerZip4() {
        return employerZip4;
    }

    public void setEmployerZip4(String employerZip4) {
        this.employerZip4 = employerZip4;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getYearsEmployed() {
        return yearsEmployed;
    }

    public void setYearsEmployed(String yearsEmployed) {
        this.yearsEmployed = yearsEmployed;
    }

    public String getSpseBdayCymd() {
        return spseBdayCymd;
    }

    public void setSpseBdayCymd(String spseBdayCymd) {
        this.spseBdayCymd = spseBdayCymd;
    }

    public String getSpseEmpName() {
        return spseEmpName;
    }

    public void setSpseEmpName(String spseEmpName) {
        this.spseEmpName = spseEmpName;
    }

    public String getSpseEmpAddr() {
        return spseEmpAddr;
    }

    public void setSpseEmpAddr(String spseEmpAddr) {
        this.spseEmpAddr = spseEmpAddr;
    }

    public String getSpseEmpCity() {
        return spseEmpCity;
    }

    public void setSpseEmpCity(String spseEmpCity) {
        this.spseEmpCity = spseEmpCity;
    }

    public String getSpseEmpState() {
        return spseEmpState;
    }

    public void setSpseEmpState(String spseEmpState) {
        this.spseEmpState = spseEmpState;
    }

    public String getSpseEmpZip() {
        return spseEmpZip;
    }

    public void setSpseEmpZip(String spseEmpZip) {
        this.spseEmpZip = spseEmpZip;
    }

    public String getSpseEmpZip4() {
        return spseEmpZip4;
    }

    public void setSpseEmpZip4(String spseEmpZip4) {
        this.spseEmpZip4 = spseEmpZip4;
    }

    public String getSpseBusNature() {
        return spseBusNature;
    }

    public void setSpseBusNature(String spseBusNature) {
        this.spseBusNature = spseBusNature;
    }

    public String getSpseOccupation() {
        return spseOccupation;
    }

    public void setSpseOccupation(String spseOccupation) {
        this.spseOccupation = spseOccupation;
    }

    public String getSpseYrsEmploy() {
        return spseYrsEmploy;
    }

    public void setSpseYrsEmploy(String spseYrsEmploy) {
        this.spseYrsEmploy = spseYrsEmploy;
    }

    public String getSpseNetIncome() {
        return spseNetIncome;
    }

    public void setSpseNetIncome(String spseNetIncome) {
        this.spseNetIncome = spseNetIncome;
    }

    public String getSpseBusPhone() {
        return spseBusPhone;
    }

    public void setSpseBusPhone(String spseBusPhone) {
        this.spseBusPhone = spseBusPhone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHomeOwnRent() {
        return homeOwnRent;
    }

    public void setHomeOwnRent(String homeOwnRent) {
        this.homeOwnRent = homeOwnRent;
    }

    public String getDependents() {
        return dependents;
    }

    public void setDependents(String dependents) {
        this.dependents = dependents;
    }

    public String getTaxBracket() {
        return taxBracket;
    }

    public void setTaxBracket(String taxBracket) {
        this.taxBracket = taxBracket;
    }

    public String getAdmReferences() {
        return admReferences;
    }

    public void setAdmReferences(String admReferences) {
        this.admReferences = admReferences;
    }

    public String getAcctAcquired() {
        return acctAcquired;
    }

    public void setAcctAcquired(String acctAcquired) {
        this.acctAcquired = acctAcquired;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public String getLiqNet() {
        return liqNet;
    }

    public void setLiqNet(String liqNet) {
        this.liqNet = liqNet;
    }

    public String getInvestExpStk() {
        return investExpStk;
    }

    public void setInvestExpStk(String investExpStk) {
        this.investExpStk = investExpStk;
    }

    public String getInvestExpOpt() {
        return investExpOpt;
    }

    public void setInvestExpOpt(String investExpOpt) {
        this.investExpOpt = investExpOpt;
    }

    public String getInvestExpMmf() {
        return investExpMmf;
    }

    public void setInvestExpMmf(String investExpMmf) {
        this.investExpMmf = investExpMmf;
    }

    public String getInvestExpAnn() {
        return investExpAnn;
    }

    public void setInvestExpAnn(String investExpAnn) {
        this.investExpAnn = investExpAnn;
    }

    public String getInitialTrans() {
        return initialTrans;
    }

    public void setInitialTrans(String initialTrans) {
        this.initialTrans = initialTrans;
    }

    public String getPlanInvestAmt() {
        return planInvestAmt;
    }

    public void setPlanInvestAmt(String planInvestAmt) {
        this.planInvestAmt = planInvestAmt;
    }

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
    }

    public String getClientMet() {
        return clientMet;
    }

    public void setClientMet(String clientMet) {
        this.clientMet = clientMet;
    }

    public String getCorpOfficer() {
        return corpOfficer;
    }

    public void setCorpOfficer(String corpOfficer) {
        this.corpOfficer = corpOfficer;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
        this.retired = retired;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public String getUpdateWho() {
        return updateWho;
    }

    public void setUpdateWho(String updateWho) {
        this.updateWho = updateWho;
    }

    public String getUpdateTerm() {
        return updateTerm;
    }

    public void setUpdateTerm(String updateTerm) {
        this.updateTerm = updateTerm;
    }

    public String getUpdateCymd() {
        return updateCymd;
    }

    public void setUpdateCymd(String updateCymd) {
        this.updateCymd = updateCymd;
    }

    public String getAddCymd() {
        return addCymd;
    }

    public void setAddCymd(String addCymd) {
        this.addCymd = addCymd;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public String getNote3() {
        return note3;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    public String getNote4() {
        return note4;
    }

    public void setNote4(String note4) {
        this.note4 = note4;
    }

    public String getNote5() {
        return note5;
    }

    public void setNote5(String note5) {
        this.note5 = note5;
    }

    public String getNote6() {
        return note6;
    }

    public void setNote6(String note6) {
        this.note6 = note6;
    }

    public String getBdateEstimated() {
        return bdateEstimated;
    }

    public void setBdateEstimated(String bdateEstimated) {
        this.bdateEstimated = bdateEstimated;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public String getOptionObjective() {
        return optionObjective;
    }

    public void setOptionObjective(String optionObjective) {
        this.optionObjective = optionObjective;
    }

    public String getFirstOptTrdCymd() {
        return firstOptTrdCymd;
    }

    public void setFirstOptTrdCymd(String firstOptTrdCymd) {
        this.firstOptTrdCymd = firstOptTrdCymd;
    }

    public String getOptProspectCymd() {
        return optProspectCymd;
    }

    public void setOptProspectCymd(String optProspectCymd) {
        this.optProspectCymd = optProspectCymd;
    }

    public String getLiqNetWorth() {
        return liqNetWorth;
    }

    public void setLiqNetWorth(String liqNetWorth) {
        this.liqNetWorth = liqNetWorth;
    }

    public String getEmailAddr2() {
        return emailAddr2;
    }

    public void setEmailAddr2(String emailAddr2) {
        this.emailAddr2 = emailAddr2;
    }

    public String getControlCusip1() {
        return controlCusip1;
    }

    public void setControlCusip1(String controlCusip1) {
        this.controlCusip1 = controlCusip1;
    }

    public String getControlCusip2() {
        return controlCusip2;
    }

    public void setControlCusip2(String controlCusip2) {
        this.controlCusip2 = controlCusip2;
    }

    public String getControlCusip3() {
        return controlCusip3;
    }

    public void setControlCusip3(String controlCusip3) {
        this.controlCusip3 = controlCusip3;
    }

    public String getSecObj1() {
        return secObj1;
    }

    public void setSecObj1(String secObj1) {
        this.secObj1 = secObj1;
    }

    public String getSecObj2() {
        return secObj2;
    }

    public void setSecObj2(String secObj2) {
        this.secObj2 = secObj2;
    }

    public String getSecObj3() {
        return secObj3;
    }

    public void setSecObj3(String secObj3) {
        this.secObj3 = secObj3;
    }

    public String getSecObj4() {
        return secObj4;
    }

    public void setSecObj4(String secObj4) {
        this.secObj4 = secObj4;
    }

    public String getShowDiscountSw() {
        return showDiscountSw;
    }

    public void setShowDiscountSw(String showDiscountSw) {
        this.showDiscountSw = showDiscountSw;
    }

    public String getConfTrailer() {
        return confTrailer;
    }

    public void setConfTrailer(String confTrailer) {
        this.confTrailer = confTrailer;
    }

    public String getPerfRpt() {
        return perfRpt;
    }

    public void setPerfRpt(String perfRpt) {
        this.perfRpt = perfRpt;
    }

    public String getInvestExpBond() {
        return investExpBond;
    }

    public void setInvestExpBond(String investExpBond) {
        this.investExpBond = investExpBond;
    }

}