package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class AdmCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "bday_cymd")private String bdayCymd;
    @CsvBindByName(column = "sex")private String sex;
    @CsvBindByName(column = "employer_name")private String employerName;
    @CsvBindByName(column = "employer_addr")private String employerAddr;
    @CsvBindByName(column = "employer_city")private String employerCity;
    @CsvBindByName(column = "employer_state")private String employerState;
    @CsvBindByName(column = "employer_zip")private String employerZip;
    @CsvBindByName(column = "employer_zip4")private String employerZip4;
    @CsvBindByName(column = "business_nature")private String businessNature;
    @CsvBindByName(column = "occupation")private String occupation;
    @CsvBindByName(column = "years_employed")private String yearsEmployed;
    @CsvBindByName(column = "spse_bday_cymd")private String spseBdayCymd;
    @CsvBindByName(column = "spse_emp_name")private String spseEmpName;
    @CsvBindByName(column = "spse_emp_addr")private String spseEmpAddr;
    @CsvBindByName(column = "spse_emp_city")private String spseEmpCity;
    @CsvBindByName(column = "spse_emp_state")private String spseEmpState;
    @CsvBindByName(column = "spse_emp_zip")private String spseEmpZip;
    @CsvBindByName(column = "spse_emp_zip4")private String spseEmpZip4;
    @CsvBindByName(column = "spse_bus_nature")private String spseBusNature;
    @CsvBindByName(column = "spse_occupation")private String spseOccupation;
    @CsvBindByName(column = "spse_yrs_employ")private String spseYrsEmploy;
    @CsvBindByName(column = "spse_net_income")private String spseNetIncome;
    @CsvBindByName(column = "spse_bus_phone")private String spseBusPhone;
    @CsvBindByName(column = "marital_status")private String maritalStatus;
    @CsvBindByName(column = "home_own_rent")private String homeOwnRent;
    @CsvBindByName(column = "dependents")private String dependents;
    @CsvBindByName(column = "tax_bracket")private String taxBracket;
    @CsvBindByName(column = "references")private String admReferences;
    @CsvBindByName(column = "acct_acquired")private String acctAcquired;
    @CsvBindByName(column = "net_income")private String netIncome;
    @CsvBindByName(column = "liq_net")private String liqNet;
    @CsvBindByName(column = "invest_exp_stk")private String investExpStk;
    @CsvBindByName(column = "invest_exp_opt")private String investExpOpt;
    @CsvBindByName(column = "invest_exp_mmf")private String investExpMmf;
    @CsvBindByName(column = "invest_exp_ann")private String investExpAnn;
    @CsvBindByName(column = "initial_trans")private String initialTrans;
    @CsvBindByName(column = "plan_invest_amt")private String planInvestAmt;
    @CsvBindByName(column = "net_worth")private String netWorth;
    @CsvBindByName(column = "client_met")private String clientMet;
    @CsvBindByName(column = "corp_officer")private String corpOfficer;
    @CsvBindByName(column = "edu_level")private String eduLevel;
    @CsvBindByName(column = "retired")private String retired;
    @CsvBindByName(column = "policy_owner")private String policyOwner;
    @CsvBindByName(column = "update_who")private String updateWho;
    @CsvBindByName(column = "update_term")private String updateTerm;
    @CsvBindByName(column = "update_cymd")private String updateCymd;
    @CsvBindByName(column = "add_cymd")private String addCymd;
    @CsvBindByName(column = "note1")private String note1;
    @CsvBindByName(column = "note2")private String note2;
    @CsvBindByName(column = "note3")private String note3;
    @CsvBindByName(column = "note4")private String note4;
    @CsvBindByName(column = "note5")private String note5;
    @CsvBindByName(column = "note6")private String note6;
    @CsvBindByName(column = "bdate_estimated")private String bdateEstimated;
    @CsvBindByName(column = "email_addr")private String emailAddr;
    @CsvBindByName(column = "risk_tolerance")private String riskTolerance;
    @CsvBindByName(column = "option_objective")private String optionObjective;
    @CsvBindByName(column = "first_opt_trd_cymd")private String firstOptTrdCymd;
    @CsvBindByName(column = "opt_prospect_cymd")private String optProspectCymd;
    @CsvBindByName(column = "liq_net_worth")private String liqNetWorth;
    @CsvBindByName(column = "email_addr2")private String emailAddr2;
    @CsvBindByName(column = "control_cusip1")private String controlCusip1;
    @CsvBindByName(column = "control_cusip2")private String controlCusip2;
    @CsvBindByName(column = "control_cusip3")private String controlCusip3;
    @CsvBindByName(column = "sec_obj1")private String secObj1;
    @CsvBindByName(column = "sec_obj2")private String secObj2;
    @CsvBindByName(column = "sec_obj3")private String secObj3;
    @CsvBindByName(column = "sec_obj4")private String secObj4;
    @CsvBindByName(column = "show_discount_sw")private String showDiscountSw;
    @CsvBindByName(column = "conf_trailer")private String confTrailer;
    @CsvBindByName(column = "perf_rpt")private String perfRpt;
    @CsvBindByName(column = "invest_exp_bond")private String investExpBond;

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
