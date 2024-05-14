package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_isrc_reg_a", schema = "stage_pershing")
public class StageIsrcRegA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_proceso")
    private Long idProceso;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "transaction_code", length = 100)
    private String transactionCode;

    @Size(max = 100)
    @Column(name = "record_secuence_id", length = 100)
    private String recordSecuenceId;

    @Column(name = "record_id_number")
    private Integer recordIdNumber;

    @Size(max = 100)
    @Column(name = "change_id", length = 100)
    private String changeId;

    @Size(max = 100)
    @Column(name = "source_code", length = 100)
    private String sourceCode;

    @Size(max = 100)
    @Column(name = "source_code_desc_line_1", length = 100)
    private String sourceCodeDescLine1;

    @Size(max = 100)
    @Column(name = "source_code_desc_line_2", length = 100)
    private String sourceCodeDescLine2;

    @Size(max = 100)
    @Column(name = "source_code_desc_line_3", length = 100)
    private String sourceCodeDescLine3;

    @Size(max = 100)
    @Column(name = "tax_status", length = 100)
    private String taxStatus;

    @Size(max = 100)
    @Column(name = "campo_10", length = 100)
    private String campo10;

    @Size(max = 100)
    @Column(name = "user_id", length = 100)
    private String userId;

    @Size(max = 100)
    @Column(name = "date_added", length = 100)
    private String dateAdded;

    @Size(max = 100)
    @Column(name = "date_updated", length = 100)
    private String dateUpdated;

    @Size(max = 100)
    @Column(name = "ira_income_eligible", length = 100)
    private String iraIncomeEligible;

    @Size(max = 100)
    @Column(name = "retail_income_eligible", length = 100)
    private String retailIncomeEligible;

    @Size(max = 100)
    @Column(name = "customer_firm", length = 100)
    private String customerFirm;

    @Size(max = 100)
    @Column(name = "cerdit_debit", length = 100)
    private String cerditDebit;

    @Size(max = 100)
    @Column(name = "statement_ind", length = 100)
    private String statementInd;

    @Size(max = 100)
    @Column(name = "statement_act_sum_ind", length = 100)
    private String statementActSumInd;

    @Size(max = 100)
    @Column(name = "statement_act_sum_number", length = 100)
    private String statementActSumNumber;

    @Size(max = 100)
    @Column(name = "statement_trx_sum_ind", length = 100)
    private String statementTrxSumInd;

    @Size(max = 100)
    @Column(name = "statement_trx_sum_number", length = 100)
    private String statementTrxSumNumber;

    @Size(max = 100)
    @Column(name = "statement_distrib_ind", length = 100)
    private String statementDistribInd;

    @Size(max = 100)
    @Column(name = "statement_distrib_number", length = 100)
    private String statementDistribNumber;

    @Size(max = 100)
    @Column(name = "statement_distrib_tax_ind", length = 100)
    private String statementDistribTaxInd;

    @Size(max = 100)
    @Column(name = "statement_div_ind", length = 100)
    private String statementDivInd;

    @Size(max = 100)
    @Column(name = "statement_div_number", length = 100)
    private String statementDivNumber;

    @Size(max = 100)
    @Column(name = "statement_div_tax_ind", length = 100)
    private String statementDivTaxInd;

    @Size(max = 100)
    @Column(name = "pershing_depart", length = 100)
    private String pershingDepart;

    @Size(max = 100)
    @Column(name = "pershing_grp", length = 100)
    private String pershingGrp;

    @Size(max = 100)
    @Column(name = "campo_31", length = 100)
    private String campo31;

    @Size(max = 100)
    @Column(name = "user_id_added", length = 100)
    private String userIdAdded;

    @Size(max = 100)
    @Column(name = "user_id_updated", length = 100)
    private String userIdUpdated;

    @Size(max = 100)
    @Column(name = "campo_34", length = 100)
    private String campo34;

    @Size(max = 100)
    @Column(name = "portfolio_eligible_ind", length = 100)
    private String portfolioEligibleInd;

    @Size(max = 100)
    @Column(name = "reinvest_ind", length = 100)
    private String reinvestInd;

    @Size(max = 100)
    @Column(name = "campo_37", length = 100)
    private String campo37;

    @Size(max = 100)
    @Column(name = "eor", length = 100)
    private String eor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getRecordSecuenceId() {
        return recordSecuenceId;
    }

    public void setRecordSecuenceId(String recordSecuenceId) {
        this.recordSecuenceId = recordSecuenceId;
    }

    public Integer getRecordIdNumber() {
        return recordIdNumber;
    }

    public void setRecordIdNumber(Integer recordIdNumber) {
        this.recordIdNumber = recordIdNumber;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSourceCodeDescLine1() {
        return sourceCodeDescLine1;
    }

    public void setSourceCodeDescLine1(String sourceCodeDescLine1) {
        this.sourceCodeDescLine1 = sourceCodeDescLine1;
    }

    public String getSourceCodeDescLine2() {
        return sourceCodeDescLine2;
    }

    public void setSourceCodeDescLine2(String sourceCodeDescLine2) {
        this.sourceCodeDescLine2 = sourceCodeDescLine2;
    }

    public String getSourceCodeDescLine3() {
        return sourceCodeDescLine3;
    }

    public void setSourceCodeDescLine3(String sourceCodeDescLine3) {
        this.sourceCodeDescLine3 = sourceCodeDescLine3;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getIraIncomeEligible() {
        return iraIncomeEligible;
    }

    public void setIraIncomeEligible(String iraIncomeEligible) {
        this.iraIncomeEligible = iraIncomeEligible;
    }

    public String getRetailIncomeEligible() {
        return retailIncomeEligible;
    }

    public void setRetailIncomeEligible(String retailIncomeEligible) {
        this.retailIncomeEligible = retailIncomeEligible;
    }

    public String getCustomerFirm() {
        return customerFirm;
    }

    public void setCustomerFirm(String customerFirm) {
        this.customerFirm = customerFirm;
    }

    public String getCerditDebit() {
        return cerditDebit;
    }

    public void setCerditDebit(String cerditDebit) {
        this.cerditDebit = cerditDebit;
    }

    public String getStatementInd() {
        return statementInd;
    }

    public void setStatementInd(String statementInd) {
        this.statementInd = statementInd;
    }

    public String getStatementActSumInd() {
        return statementActSumInd;
    }

    public void setStatementActSumInd(String statementActSumInd) {
        this.statementActSumInd = statementActSumInd;
    }

    public String getStatementActSumNumber() {
        return statementActSumNumber;
    }

    public void setStatementActSumNumber(String statementActSumNumber) {
        this.statementActSumNumber = statementActSumNumber;
    }

    public String getStatementTrxSumInd() {
        return statementTrxSumInd;
    }

    public void setStatementTrxSumInd(String statementTrxSumInd) {
        this.statementTrxSumInd = statementTrxSumInd;
    }

    public String getStatementTrxSumNumber() {
        return statementTrxSumNumber;
    }

    public void setStatementTrxSumNumber(String statementTrxSumNumber) {
        this.statementTrxSumNumber = statementTrxSumNumber;
    }

    public String getStatementDistribInd() {
        return statementDistribInd;
    }

    public void setStatementDistribInd(String statementDistribInd) {
        this.statementDistribInd = statementDistribInd;
    }

    public String getStatementDistribNumber() {
        return statementDistribNumber;
    }

    public void setStatementDistribNumber(String statementDistribNumber) {
        this.statementDistribNumber = statementDistribNumber;
    }

    public String getStatementDistribTaxInd() {
        return statementDistribTaxInd;
    }

    public void setStatementDistribTaxInd(String statementDistribTaxInd) {
        this.statementDistribTaxInd = statementDistribTaxInd;
    }

    public String getStatementDivInd() {
        return statementDivInd;
    }

    public void setStatementDivInd(String statementDivInd) {
        this.statementDivInd = statementDivInd;
    }

    public String getStatementDivNumber() {
        return statementDivNumber;
    }

    public void setStatementDivNumber(String statementDivNumber) {
        this.statementDivNumber = statementDivNumber;
    }

    public String getStatementDivTaxInd() {
        return statementDivTaxInd;
    }

    public void setStatementDivTaxInd(String statementDivTaxInd) {
        this.statementDivTaxInd = statementDivTaxInd;
    }

    public String getPershingDepart() {
        return pershingDepart;
    }

    public void setPershingDepart(String pershingDepart) {
        this.pershingDepart = pershingDepart;
    }

    public String getPershingGrp() {
        return pershingGrp;
    }

    public void setPershingGrp(String pershingGrp) {
        this.pershingGrp = pershingGrp;
    }

    public String getCampo31() {
        return campo31;
    }

    public void setCampo31(String campo31) {
        this.campo31 = campo31;
    }

    public String getUserIdAdded() {
        return userIdAdded;
    }

    public void setUserIdAdded(String userIdAdded) {
        this.userIdAdded = userIdAdded;
    }

    public String getUserIdUpdated() {
        return userIdUpdated;
    }

    public void setUserIdUpdated(String userIdUpdated) {
        this.userIdUpdated = userIdUpdated;
    }

    public String getCampo34() {
        return campo34;
    }

    public void setCampo34(String campo34) {
        this.campo34 = campo34;
    }

    public String getPortfolioEligibleInd() {
        return portfolioEligibleInd;
    }

    public void setPortfolioEligibleInd(String portfolioEligibleInd) {
        this.portfolioEligibleInd = portfolioEligibleInd;
    }

    public String getReinvestInd() {
        return reinvestInd;
    }

    public void setReinvestInd(String reinvestInd) {
        this.reinvestInd = reinvestInd;
    }

    public String getCampo37() {
        return campo37;
    }

    public void setCampo37(String campo37) {
        this.campo37 = campo37;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}