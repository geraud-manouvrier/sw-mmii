package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_acct_reg_a", schema = "stage_pershing")
public class StageAcctRegA {
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
    @Column(name = "record_indicator_value", length = 100)
    private String recordIndicatorValue;

    @Column(name = "record_id_sequence_number")
    private Integer recordIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "account_number", length = 100)
    private String accountNumber;

    @Size(max = 100)
    @Column(name = "ibd_number", length = 100)
    private String ibdNumber;

    @Size(max = 100)
    @Column(name = "campo_6", length = 100)
    private String campo6;

    @Size(max = 100)
    @Column(name = "ip_number", length = 100)
    private String ipNumber;

    @Size(max = 100)
    @Column(name = "account_short_name", length = 100)
    private String accountShortName;

    @Size(max = 100)
    @Column(name = "campo_9", length = 100)
    private String campo9;

    @Size(max = 100)
    @Column(name = "transaction_type", length = 100)
    private String transactionType;

    @Size(max = 100)
    @Column(name = "autotitled_usertitled_account", length = 100)
    private String autotitledUsertitledAccount;

    @Size(max = 100)
    @Column(name = "account_type_code", length = 100)
    private String accountTypeCode;

    @Size(max = 100)
    @Column(name = "registration_type", length = 100)
    private String registrationType;

    @Size(max = 100)
    @Column(name = "campo_14", length = 100)
    private String campo14;

    @Size(max = 100)
    @Column(name = "number_of_account_title_lines", length = 100)
    private String numberOfAccountTitleLines;

    @Size(max = 100)
    @Column(name = "account_registration_line_1", length = 100)
    private String accountRegistrationLine1;

    @Size(max = 100)
    @Column(name = "account_registration_line_2", length = 100)
    private String accountRegistrationLine2;

    @Size(max = 100)
    @Column(name = "account_registration_line_3", length = 100)
    private String accountRegistrationLine3;

    @Size(max = 100)
    @Column(name = "account_registration_line_4", length = 100)
    private String accountRegistrationLine4;

    @Size(max = 100)
    @Column(name = "account_registration_line_5", length = 100)
    private String accountRegistrationLine5;

    @Size(max = 100)
    @Column(name = "account_registration_line_6", length = 100)
    private String accountRegistrationLine6;

    @Size(max = 100)
    @Column(name = "registration_type_detail", length = 100)
    private String registrationTypeDetail;

    @Column(name = "date_account_opened")
    private LocalDate dateAccountOpened;

    @Column(name = "date_account_information_updated")
    private LocalDate dateAccountInformationUpdated;

    @Size(max = 100)
    @Column(name = "account_status_indicator", length = 100)
    private String accountStatusIndicator;

    @Column(name = "pending_closed_date")
    private LocalDate pendingClosedDate;

    @Column(name = "date_account_closed")
    private LocalDate dateAccountClosed;

    @Column(name = "closing_notice_date")
    private LocalDate closingNoticeDate;

    @Column(name = "account_reactivated_date")
    private LocalDate accountReactivatedDate;

    @Column(name = "date_account_reopened")
    private LocalDate dateAccountReopened;

    @Size(max = 100)
    @Column(name = "proceeds", length = 100)
    private String proceeds;

    @Size(max = 100)
    @Column(name = "transfer_instructions", length = 100)
    private String transferInstructions;

    @Size(max = 100)
    @Column(name = "income_isntructions", length = 100)
    private String incomeIsntructions;

    @Size(max = 100)
    @Column(name = "number_of_confirms_for_thi_account", length = 100)
    private String numberOfConfirmsForThiAccount;

    @Size(max = 100)
    @Column(name = "number_of_statements_for_this_account", length = 100)
    private String numberOfStatementsForThisAccount;

    @Size(max = 100)
    @Column(name = "investment_objetive_trans_code", length = 100)
    private String investmentObjetiveTransCode;

    @Size(max = 100)
    @Column(name = "comments_act", length = 100)
    private String commentsAct;

    @Size(max = 100)
    @Column(name = "employer_shotname", length = 100)
    private String employerShotname;

    @Size(max = 100)
    @Column(name = "employers_cusip", length = 100)
    private String employersCusip;

    @Size(max = 100)
    @Column(name = "employers_symbol", length = 100)
    private String employersSymbol;

    @Size(max = 100)
    @Column(name = "margin_privileges_revoked", length = 100)
    private String marginPrivilegesRevoked;

    @Column(name = "statement_review_date")
    private LocalDate statementReviewDate;

    @Size(max = 100)
    @Column(name = "margin_papers_on_file", length = 100)
    private String marginPapersOnFile;

    @Size(max = 100)
    @Column(name = "option_papers_on_file", length = 100)
    private String optionPapersOnFile;

    @Size(max = 100)
    @Column(name = "campo_45", length = 100)
    private String campo45;

    @Size(max = 100)
    @Column(name = "good_faith_margin", length = 100)
    private String goodFaithMargin;

    @Size(max = 100)
    @Column(name = "ip_discretion_granted", length = 100)
    private String ipDiscretionGranted;

    @Size(max = 100)
    @Column(name = "invest_advisor_discretion_granted", length = 100)
    private String investAdvisorDiscretionGranted;

    @Size(max = 100)
    @Column(name = "third_party_discretion_granted", length = 100)
    private String thirdPartyDiscretionGranted;

    @Size(max = 100)
    @Column(name = "third_party_name", length = 100)
    private String thirdPartyName;

    @Size(max = 100)
    @Column(name = "risk_factor_code", length = 100)
    private String riskFactorCode;

    @Size(max = 100)
    @Column(name = "investment_objetive_code", length = 100)
    private String investmentObjetiveCode;

    @Size(max = 100)
    @Column(name = "option_equities", length = 100)
    private String optionEquities;

    @Size(max = 100)
    @Column(name = "option_index", length = 100)
    private String optionIndex;

    @Size(max = 100)
    @Column(name = "option_debt", length = 100)
    private String optionDebt;

    @Size(max = 100)
    @Column(name = "option_currency", length = 100)
    private String optionCurrency;

    @Size(max = 100)
    @Column(name = "option_level_1", length = 100)
    private String optionLevel1;

    @Size(max = 100)
    @Column(name = "option_level_2", length = 100)
    private String optionLevel2;

    @Size(max = 100)
    @Column(name = "option_level_3", length = 100)
    private String optionLevel3;

    @Size(max = 100)
    @Column(name = "option_level_4", length = 100)
    private String optionLevel4;

    @Column(name = "option_call_limits")
    private Integer optionCallLimits;

    @Column(name = "option_put_limits")
    private Integer optionPutLimits;

    @Column(name = "option_total_limits_of_puts_and_calls")
    private Integer optionTotalLimitsOfPutsAndCalls;

    @Size(max = 100)
    @Column(name = "non_us_dollar_trading", length = 100)
    private String nonUsDollarTrading;

    @Size(max = 100)
    @Column(name = "campo_65", length = 100)
    private String campo65;

    @Size(max = 100)
    @Column(name = "non_customer_indicator", length = 100)
    private String nonCustomerIndicator;

    @Size(max = 100)
    @Column(name = "third_party_fee_indicator", length = 100)
    private String thirdPartyFeeIndicator;

    @Column(name = "third_party_fee_approval_date")
    private LocalDate thirdPartyFeeApprovalDate;

    @Size(max = 100)
    @Column(name = "intermediary_account_ind", length = 100)
    private String intermediaryAccountInd;

    @Size(max = 100)
    @Column(name = "commission_schedule", length = 100)
    private String commissionSchedule;

    @Size(max = 100)
    @Column(name = "group_index", length = 100)
    private String groupIndex;

    @Size(max = 100)
    @Column(name = "money_manager_id", length = 100)
    private String moneyManagerId;

    @Size(max = 100)
    @Column(name = "money_manager_objective_id", length = 100)
    private String moneyManagerObjectiveId;

    @Size(max = 100)
    @Column(name = "dtc_id_confirm_number", length = 100)
    private String dtcIdConfirmNumber;

    @Size(max = 100)
    @Column(name = "caps_master_mnemonic", length = 100)
    private String capsMasterMnemonic;

    @Size(max = 100)
    @Column(name = "employee_id", length = 100)
    private String employeeId;

    @Size(max = 100)
    @Column(name = "prime_broker_free_fund_indicator", length = 100)
    private String primeBrokerFreeFundIndicator;

    @Size(max = 100)
    @Column(name = "fee_based_account_indicator", length = 100)
    private String feeBasedAccountIndicator;

    @Size(max = 100)
    @Column(name = "campo_79", length = 100)
    private String campo79;

    @Column(name = "fee_based_termination_date")
    private LocalDate feeBasedTerminationDate;

    @Size(max = 100)
    @Column(name = "campo_81", length = 100)
    private String campo81;

    @Size(max = 100)
    @Column(name = "plan_name", length = 100)
    private String planName;

    @Size(max = 100)
    @Column(name = "self_directed_401_k_account_type", length = 100)
    private String selfDirected401KAccountType;

    @Size(max = 100)
    @Column(name = "plan_type", length = 100)
    private String planType;

    @Size(max = 100)
    @Column(name = "plan_number", length = 100)
    private String planNumber;

    @Size(max = 100)
    @Column(name = "employee_or_employee_relative", length = 100)
    private String employeeOrEmployeeRelative;

    @Column(name = "commission_percent_discount", precision = 45, scale = 20)
    private BigDecimal commissionPercentDiscount;

    @Size(max = 100)
    @Column(name = "ind_12_b_1_fee_blocking", length = 100)
    private String ind12B1FeeBlocking;

    @Size(max = 100)
    @Column(name = "name_of_ip_signed_new_account_form", length = 100)
    private String nameOfIpSignedNewAccountForm;

    @Column(name = "date_of_ip_signed_new_account_form")
    private LocalDate dateOfIpSignedNewAccountForm;

    @Size(max = 100)
    @Column(name = "name_of_principal_signed_new_account_form", length = 100)
    private String nameOfPrincipalSignedNewAccountForm;

    @Column(name = "date_of_principal_signed_new_account_form")
    private LocalDate dateOfPrincipalSignedNewAccountForm;

    @Size(max = 100)
    @Column(name = "politically_exposed_person", length = 100)
    private String politicallyExposedPerson;

    @Size(max = 100)
    @Column(name = "private_banking_account", length = 100)
    private String privateBankingAccount;

    @Size(max = 100)
    @Column(name = "foreign_bank_account", length = 100)
    private String foreignBankAccount;

    @Size(max = 100)
    @Column(name = "initial_source_of_funds", length = 100)
    private String initialSourceOfFunds;

    @Size(max = 100)
    @Column(name = "usa_patriot_act_exempt_reason", length = 100)
    private String usaPatriotActExemptReason;

    @Size(max = 100)
    @Column(name = "primary_country_of_citizenship", length = 100)
    private String primaryCountryOfCitizenship;

    @Size(max = 100)
    @Column(name = "country_of_residence", length = 100)
    private String countryOfResidence;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(max = 100)
    @Column(name = "age_based_fund_roll_exempt", length = 100)
    private String ageBasedFundRollExempt;

    @Size(max = 100)
    @Column(name = "money_fundreform_retail", length = 100)
    private String moneyFundreformRetail;

    @Size(max = 100)
    @Column(name = "trusted_contact_status", length = 100)
    private String trustedContactStatus;

    @Size(max = 100)
    @Column(name = "regulatory_account_type_category", length = 100)
    private String regulatoryAccountTypeCategory;

    @Size(max = 100)
    @Column(name = "account_managed_by_trust_comp_id", length = 100)
    private String accountManagedByTrustCompId;

    @Size(max = 100)
    @Column(name = "voting_auth", length = 100)
    private String votingAuth;

    @Size(max = 100)
    @Column(name = "campo_107", length = 100)
    private String campo107;

    @Size(max = 100)
    @Column(name = "campo_108", length = 100)
    private String campo108;

    @Size(max = 100)
    @Column(name = "campo_109", length = 100)
    private String campo109;

    @Size(max = 100)
    @Column(name = "campo_110", length = 100)
    private String campo110;

    @Size(max = 100)
    @Column(name = "customer_type", length = 100)
    private String customerType;

    @Size(max = 100)
    @Column(name = "campo_112", length = 100)
    private String campo112;

    @Size(max = 100)
    @Column(name = "campo_113", length = 100)
    private String campo113;

    @Size(max = 100)
    @Column(name = "campo_114", length = 100)
    private String campo114;

    @Size(max = 100)
    @Column(name = "campo_115", length = 100)
    private String campo115;

    @Size(max = 100)
    @Column(name = "campo_116", length = 100)
    private String campo116;

    @Size(max = 100)
    @Column(name = "fulfillment_method", length = 100)
    private String fulfillmentMethod;

    @Size(max = 100)
    @Column(name = "credit_interest_indicator", length = 100)
    private String creditInterestIndicator;

    @Size(max = 100)
    @Column(name = "ama_indicator", length = 100)
    private String amaIndicator;

    @Size(max = 100)
    @Column(name = "campo_120", length = 100)
    private String campo120;

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

    public String getRecordIndicatorValue() {
        return recordIndicatorValue;
    }

    public void setRecordIndicatorValue(String recordIndicatorValue) {
        this.recordIndicatorValue = recordIndicatorValue;
    }

    public Integer getRecordIdSequenceNumber() {
        return recordIdSequenceNumber;
    }

    public void setRecordIdSequenceNumber(Integer recordIdSequenceNumber) {
        this.recordIdSequenceNumber = recordIdSequenceNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIbdNumber() {
        return ibdNumber;
    }

    public void setIbdNumber(String ibdNumber) {
        this.ibdNumber = ibdNumber;
    }

    public String getCampo6() {
        return campo6;
    }

    public void setCampo6(String campo6) {
        this.campo6 = campo6;
    }

    public String getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(String ipNumber) {
        this.ipNumber = ipNumber;
    }

    public String getAccountShortName() {
        return accountShortName;
    }

    public void setAccountShortName(String accountShortName) {
        this.accountShortName = accountShortName;
    }

    public String getCampo9() {
        return campo9;
    }

    public void setCampo9(String campo9) {
        this.campo9 = campo9;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAutotitledUsertitledAccount() {
        return autotitledUsertitledAccount;
    }

    public void setAutotitledUsertitledAccount(String autotitledUsertitledAccount) {
        this.autotitledUsertitledAccount = autotitledUsertitledAccount;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getCampo14() {
        return campo14;
    }

    public void setCampo14(String campo14) {
        this.campo14 = campo14;
    }

    public String getNumberOfAccountTitleLines() {
        return numberOfAccountTitleLines;
    }

    public void setNumberOfAccountTitleLines(String numberOfAccountTitleLines) {
        this.numberOfAccountTitleLines = numberOfAccountTitleLines;
    }

    public String getAccountRegistrationLine1() {
        return accountRegistrationLine1;
    }

    public void setAccountRegistrationLine1(String accountRegistrationLine1) {
        this.accountRegistrationLine1 = accountRegistrationLine1;
    }

    public String getAccountRegistrationLine2() {
        return accountRegistrationLine2;
    }

    public void setAccountRegistrationLine2(String accountRegistrationLine2) {
        this.accountRegistrationLine2 = accountRegistrationLine2;
    }

    public String getAccountRegistrationLine3() {
        return accountRegistrationLine3;
    }

    public void setAccountRegistrationLine3(String accountRegistrationLine3) {
        this.accountRegistrationLine3 = accountRegistrationLine3;
    }

    public String getAccountRegistrationLine4() {
        return accountRegistrationLine4;
    }

    public void setAccountRegistrationLine4(String accountRegistrationLine4) {
        this.accountRegistrationLine4 = accountRegistrationLine4;
    }

    public String getAccountRegistrationLine5() {
        return accountRegistrationLine5;
    }

    public void setAccountRegistrationLine5(String accountRegistrationLine5) {
        this.accountRegistrationLine5 = accountRegistrationLine5;
    }

    public String getAccountRegistrationLine6() {
        return accountRegistrationLine6;
    }

    public void setAccountRegistrationLine6(String accountRegistrationLine6) {
        this.accountRegistrationLine6 = accountRegistrationLine6;
    }

    public String getRegistrationTypeDetail() {
        return registrationTypeDetail;
    }

    public void setRegistrationTypeDetail(String registrationTypeDetail) {
        this.registrationTypeDetail = registrationTypeDetail;
    }

    public LocalDate getDateAccountOpened() {
        return dateAccountOpened;
    }

    public void setDateAccountOpened(LocalDate dateAccountOpened) {
        this.dateAccountOpened = dateAccountOpened;
    }

    public LocalDate getDateAccountInformationUpdated() {
        return dateAccountInformationUpdated;
    }

    public void setDateAccountInformationUpdated(LocalDate dateAccountInformationUpdated) {
        this.dateAccountInformationUpdated = dateAccountInformationUpdated;
    }

    public String getAccountStatusIndicator() {
        return accountStatusIndicator;
    }

    public void setAccountStatusIndicator(String accountStatusIndicator) {
        this.accountStatusIndicator = accountStatusIndicator;
    }

    public LocalDate getPendingClosedDate() {
        return pendingClosedDate;
    }

    public void setPendingClosedDate(LocalDate pendingClosedDate) {
        this.pendingClosedDate = pendingClosedDate;
    }

    public LocalDate getDateAccountClosed() {
        return dateAccountClosed;
    }

    public void setDateAccountClosed(LocalDate dateAccountClosed) {
        this.dateAccountClosed = dateAccountClosed;
    }

    public LocalDate getClosingNoticeDate() {
        return closingNoticeDate;
    }

    public void setClosingNoticeDate(LocalDate closingNoticeDate) {
        this.closingNoticeDate = closingNoticeDate;
    }

    public LocalDate getAccountReactivatedDate() {
        return accountReactivatedDate;
    }

    public void setAccountReactivatedDate(LocalDate accountReactivatedDate) {
        this.accountReactivatedDate = accountReactivatedDate;
    }

    public LocalDate getDateAccountReopened() {
        return dateAccountReopened;
    }

    public void setDateAccountReopened(LocalDate dateAccountReopened) {
        this.dateAccountReopened = dateAccountReopened;
    }

    public String getProceeds() {
        return proceeds;
    }

    public void setProceeds(String proceeds) {
        this.proceeds = proceeds;
    }

    public String getTransferInstructions() {
        return transferInstructions;
    }

    public void setTransferInstructions(String transferInstructions) {
        this.transferInstructions = transferInstructions;
    }

    public String getIncomeIsntructions() {
        return incomeIsntructions;
    }

    public void setIncomeIsntructions(String incomeIsntructions) {
        this.incomeIsntructions = incomeIsntructions;
    }

    public String getNumberOfConfirmsForThiAccount() {
        return numberOfConfirmsForThiAccount;
    }

    public void setNumberOfConfirmsForThiAccount(String numberOfConfirmsForThiAccount) {
        this.numberOfConfirmsForThiAccount = numberOfConfirmsForThiAccount;
    }

    public String getNumberOfStatementsForThisAccount() {
        return numberOfStatementsForThisAccount;
    }

    public void setNumberOfStatementsForThisAccount(String numberOfStatementsForThisAccount) {
        this.numberOfStatementsForThisAccount = numberOfStatementsForThisAccount;
    }

    public String getInvestmentObjetiveTransCode() {
        return investmentObjetiveTransCode;
    }

    public void setInvestmentObjetiveTransCode(String investmentObjetiveTransCode) {
        this.investmentObjetiveTransCode = investmentObjetiveTransCode;
    }

    public String getCommentsAct() {
        return commentsAct;
    }

    public void setCommentsAct(String commentsAct) {
        this.commentsAct = commentsAct;
    }

    public String getEmployerShotname() {
        return employerShotname;
    }

    public void setEmployerShotname(String employerShotname) {
        this.employerShotname = employerShotname;
    }

    public String getEmployersCusip() {
        return employersCusip;
    }

    public void setEmployersCusip(String employersCusip) {
        this.employersCusip = employersCusip;
    }

    public String getEmployersSymbol() {
        return employersSymbol;
    }

    public void setEmployersSymbol(String employersSymbol) {
        this.employersSymbol = employersSymbol;
    }

    public String getMarginPrivilegesRevoked() {
        return marginPrivilegesRevoked;
    }

    public void setMarginPrivilegesRevoked(String marginPrivilegesRevoked) {
        this.marginPrivilegesRevoked = marginPrivilegesRevoked;
    }

    public LocalDate getStatementReviewDate() {
        return statementReviewDate;
    }

    public void setStatementReviewDate(LocalDate statementReviewDate) {
        this.statementReviewDate = statementReviewDate;
    }

    public String getMarginPapersOnFile() {
        return marginPapersOnFile;
    }

    public void setMarginPapersOnFile(String marginPapersOnFile) {
        this.marginPapersOnFile = marginPapersOnFile;
    }

    public String getOptionPapersOnFile() {
        return optionPapersOnFile;
    }

    public void setOptionPapersOnFile(String optionPapersOnFile) {
        this.optionPapersOnFile = optionPapersOnFile;
    }

    public String getCampo45() {
        return campo45;
    }

    public void setCampo45(String campo45) {
        this.campo45 = campo45;
    }

    public String getGoodFaithMargin() {
        return goodFaithMargin;
    }

    public void setGoodFaithMargin(String goodFaithMargin) {
        this.goodFaithMargin = goodFaithMargin;
    }

    public String getIpDiscretionGranted() {
        return ipDiscretionGranted;
    }

    public void setIpDiscretionGranted(String ipDiscretionGranted) {
        this.ipDiscretionGranted = ipDiscretionGranted;
    }

    public String getInvestAdvisorDiscretionGranted() {
        return investAdvisorDiscretionGranted;
    }

    public void setInvestAdvisorDiscretionGranted(String investAdvisorDiscretionGranted) {
        this.investAdvisorDiscretionGranted = investAdvisorDiscretionGranted;
    }

    public String getThirdPartyDiscretionGranted() {
        return thirdPartyDiscretionGranted;
    }

    public void setThirdPartyDiscretionGranted(String thirdPartyDiscretionGranted) {
        this.thirdPartyDiscretionGranted = thirdPartyDiscretionGranted;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getRiskFactorCode() {
        return riskFactorCode;
    }

    public void setRiskFactorCode(String riskFactorCode) {
        this.riskFactorCode = riskFactorCode;
    }

    public String getInvestmentObjetiveCode() {
        return investmentObjetiveCode;
    }

    public void setInvestmentObjetiveCode(String investmentObjetiveCode) {
        this.investmentObjetiveCode = investmentObjetiveCode;
    }

    public String getOptionEquities() {
        return optionEquities;
    }

    public void setOptionEquities(String optionEquities) {
        this.optionEquities = optionEquities;
    }

    public String getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(String optionIndex) {
        this.optionIndex = optionIndex;
    }

    public String getOptionDebt() {
        return optionDebt;
    }

    public void setOptionDebt(String optionDebt) {
        this.optionDebt = optionDebt;
    }

    public String getOptionCurrency() {
        return optionCurrency;
    }

    public void setOptionCurrency(String optionCurrency) {
        this.optionCurrency = optionCurrency;
    }

    public String getOptionLevel1() {
        return optionLevel1;
    }

    public void setOptionLevel1(String optionLevel1) {
        this.optionLevel1 = optionLevel1;
    }

    public String getOptionLevel2() {
        return optionLevel2;
    }

    public void setOptionLevel2(String optionLevel2) {
        this.optionLevel2 = optionLevel2;
    }

    public String getOptionLevel3() {
        return optionLevel3;
    }

    public void setOptionLevel3(String optionLevel3) {
        this.optionLevel3 = optionLevel3;
    }

    public String getOptionLevel4() {
        return optionLevel4;
    }

    public void setOptionLevel4(String optionLevel4) {
        this.optionLevel4 = optionLevel4;
    }

    public Integer getOptionCallLimits() {
        return optionCallLimits;
    }

    public void setOptionCallLimits(Integer optionCallLimits) {
        this.optionCallLimits = optionCallLimits;
    }

    public Integer getOptionPutLimits() {
        return optionPutLimits;
    }

    public void setOptionPutLimits(Integer optionPutLimits) {
        this.optionPutLimits = optionPutLimits;
    }

    public Integer getOptionTotalLimitsOfPutsAndCalls() {
        return optionTotalLimitsOfPutsAndCalls;
    }

    public void setOptionTotalLimitsOfPutsAndCalls(Integer optionTotalLimitsOfPutsAndCalls) {
        this.optionTotalLimitsOfPutsAndCalls = optionTotalLimitsOfPutsAndCalls;
    }

    public String getNonUsDollarTrading() {
        return nonUsDollarTrading;
    }

    public void setNonUsDollarTrading(String nonUsDollarTrading) {
        this.nonUsDollarTrading = nonUsDollarTrading;
    }

    public String getCampo65() {
        return campo65;
    }

    public void setCampo65(String campo65) {
        this.campo65 = campo65;
    }

    public String getNonCustomerIndicator() {
        return nonCustomerIndicator;
    }

    public void setNonCustomerIndicator(String nonCustomerIndicator) {
        this.nonCustomerIndicator = nonCustomerIndicator;
    }

    public String getThirdPartyFeeIndicator() {
        return thirdPartyFeeIndicator;
    }

    public void setThirdPartyFeeIndicator(String thirdPartyFeeIndicator) {
        this.thirdPartyFeeIndicator = thirdPartyFeeIndicator;
    }

    public LocalDate getThirdPartyFeeApprovalDate() {
        return thirdPartyFeeApprovalDate;
    }

    public void setThirdPartyFeeApprovalDate(LocalDate thirdPartyFeeApprovalDate) {
        this.thirdPartyFeeApprovalDate = thirdPartyFeeApprovalDate;
    }

    public String getIntermediaryAccountInd() {
        return intermediaryAccountInd;
    }

    public void setIntermediaryAccountInd(String intermediaryAccountInd) {
        this.intermediaryAccountInd = intermediaryAccountInd;
    }

    public String getCommissionSchedule() {
        return commissionSchedule;
    }

    public void setCommissionSchedule(String commissionSchedule) {
        this.commissionSchedule = commissionSchedule;
    }

    public String getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(String groupIndex) {
        this.groupIndex = groupIndex;
    }

    public String getMoneyManagerId() {
        return moneyManagerId;
    }

    public void setMoneyManagerId(String moneyManagerId) {
        this.moneyManagerId = moneyManagerId;
    }

    public String getMoneyManagerObjectiveId() {
        return moneyManagerObjectiveId;
    }

    public void setMoneyManagerObjectiveId(String moneyManagerObjectiveId) {
        this.moneyManagerObjectiveId = moneyManagerObjectiveId;
    }

    public String getDtcIdConfirmNumber() {
        return dtcIdConfirmNumber;
    }

    public void setDtcIdConfirmNumber(String dtcIdConfirmNumber) {
        this.dtcIdConfirmNumber = dtcIdConfirmNumber;
    }

    public String getCapsMasterMnemonic() {
        return capsMasterMnemonic;
    }

    public void setCapsMasterMnemonic(String capsMasterMnemonic) {
        this.capsMasterMnemonic = capsMasterMnemonic;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPrimeBrokerFreeFundIndicator() {
        return primeBrokerFreeFundIndicator;
    }

    public void setPrimeBrokerFreeFundIndicator(String primeBrokerFreeFundIndicator) {
        this.primeBrokerFreeFundIndicator = primeBrokerFreeFundIndicator;
    }

    public String getFeeBasedAccountIndicator() {
        return feeBasedAccountIndicator;
    }

    public void setFeeBasedAccountIndicator(String feeBasedAccountIndicator) {
        this.feeBasedAccountIndicator = feeBasedAccountIndicator;
    }

    public String getCampo79() {
        return campo79;
    }

    public void setCampo79(String campo79) {
        this.campo79 = campo79;
    }

    public LocalDate getFeeBasedTerminationDate() {
        return feeBasedTerminationDate;
    }

    public void setFeeBasedTerminationDate(LocalDate feeBasedTerminationDate) {
        this.feeBasedTerminationDate = feeBasedTerminationDate;
    }

    public String getCampo81() {
        return campo81;
    }

    public void setCampo81(String campo81) {
        this.campo81 = campo81;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getSelfDirected401KAccountType() {
        return selfDirected401KAccountType;
    }

    public void setSelfDirected401KAccountType(String selfDirected401KAccountType) {
        this.selfDirected401KAccountType = selfDirected401KAccountType;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getEmployeeOrEmployeeRelative() {
        return employeeOrEmployeeRelative;
    }

    public void setEmployeeOrEmployeeRelative(String employeeOrEmployeeRelative) {
        this.employeeOrEmployeeRelative = employeeOrEmployeeRelative;
    }

    public BigDecimal getCommissionPercentDiscount() {
        return commissionPercentDiscount;
    }

    public void setCommissionPercentDiscount(BigDecimal commissionPercentDiscount) {
        this.commissionPercentDiscount = commissionPercentDiscount;
    }

    public String getInd12B1FeeBlocking() {
        return ind12B1FeeBlocking;
    }

    public void setInd12B1FeeBlocking(String ind12B1FeeBlocking) {
        this.ind12B1FeeBlocking = ind12B1FeeBlocking;
    }

    public String getNameOfIpSignedNewAccountForm() {
        return nameOfIpSignedNewAccountForm;
    }

    public void setNameOfIpSignedNewAccountForm(String nameOfIpSignedNewAccountForm) {
        this.nameOfIpSignedNewAccountForm = nameOfIpSignedNewAccountForm;
    }

    public LocalDate getDateOfIpSignedNewAccountForm() {
        return dateOfIpSignedNewAccountForm;
    }

    public void setDateOfIpSignedNewAccountForm(LocalDate dateOfIpSignedNewAccountForm) {
        this.dateOfIpSignedNewAccountForm = dateOfIpSignedNewAccountForm;
    }

    public String getNameOfPrincipalSignedNewAccountForm() {
        return nameOfPrincipalSignedNewAccountForm;
    }

    public void setNameOfPrincipalSignedNewAccountForm(String nameOfPrincipalSignedNewAccountForm) {
        this.nameOfPrincipalSignedNewAccountForm = nameOfPrincipalSignedNewAccountForm;
    }

    public LocalDate getDateOfPrincipalSignedNewAccountForm() {
        return dateOfPrincipalSignedNewAccountForm;
    }

    public void setDateOfPrincipalSignedNewAccountForm(LocalDate dateOfPrincipalSignedNewAccountForm) {
        this.dateOfPrincipalSignedNewAccountForm = dateOfPrincipalSignedNewAccountForm;
    }

    public String getPoliticallyExposedPerson() {
        return politicallyExposedPerson;
    }

    public void setPoliticallyExposedPerson(String politicallyExposedPerson) {
        this.politicallyExposedPerson = politicallyExposedPerson;
    }

    public String getPrivateBankingAccount() {
        return privateBankingAccount;
    }

    public void setPrivateBankingAccount(String privateBankingAccount) {
        this.privateBankingAccount = privateBankingAccount;
    }

    public String getForeignBankAccount() {
        return foreignBankAccount;
    }

    public void setForeignBankAccount(String foreignBankAccount) {
        this.foreignBankAccount = foreignBankAccount;
    }

    public String getInitialSourceOfFunds() {
        return initialSourceOfFunds;
    }

    public void setInitialSourceOfFunds(String initialSourceOfFunds) {
        this.initialSourceOfFunds = initialSourceOfFunds;
    }

    public String getUsaPatriotActExemptReason() {
        return usaPatriotActExemptReason;
    }

    public void setUsaPatriotActExemptReason(String usaPatriotActExemptReason) {
        this.usaPatriotActExemptReason = usaPatriotActExemptReason;
    }

    public String getPrimaryCountryOfCitizenship() {
        return primaryCountryOfCitizenship;
    }

    public void setPrimaryCountryOfCitizenship(String primaryCountryOfCitizenship) {
        this.primaryCountryOfCitizenship = primaryCountryOfCitizenship;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAgeBasedFundRollExempt() {
        return ageBasedFundRollExempt;
    }

    public void setAgeBasedFundRollExempt(String ageBasedFundRollExempt) {
        this.ageBasedFundRollExempt = ageBasedFundRollExempt;
    }

    public String getMoneyFundreformRetail() {
        return moneyFundreformRetail;
    }

    public void setMoneyFundreformRetail(String moneyFundreformRetail) {
        this.moneyFundreformRetail = moneyFundreformRetail;
    }

    public String getTrustedContactStatus() {
        return trustedContactStatus;
    }

    public void setTrustedContactStatus(String trustedContactStatus) {
        this.trustedContactStatus = trustedContactStatus;
    }

    public String getRegulatoryAccountTypeCategory() {
        return regulatoryAccountTypeCategory;
    }

    public void setRegulatoryAccountTypeCategory(String regulatoryAccountTypeCategory) {
        this.regulatoryAccountTypeCategory = regulatoryAccountTypeCategory;
    }

    public String getAccountManagedByTrustCompId() {
        return accountManagedByTrustCompId;
    }

    public void setAccountManagedByTrustCompId(String accountManagedByTrustCompId) {
        this.accountManagedByTrustCompId = accountManagedByTrustCompId;
    }

    public String getVotingAuth() {
        return votingAuth;
    }

    public void setVotingAuth(String votingAuth) {
        this.votingAuth = votingAuth;
    }

    public String getCampo107() {
        return campo107;
    }

    public void setCampo107(String campo107) {
        this.campo107 = campo107;
    }

    public String getCampo108() {
        return campo108;
    }

    public void setCampo108(String campo108) {
        this.campo108 = campo108;
    }

    public String getCampo109() {
        return campo109;
    }

    public void setCampo109(String campo109) {
        this.campo109 = campo109;
    }

    public String getCampo110() {
        return campo110;
    }

    public void setCampo110(String campo110) {
        this.campo110 = campo110;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCampo112() {
        return campo112;
    }

    public void setCampo112(String campo112) {
        this.campo112 = campo112;
    }

    public String getCampo113() {
        return campo113;
    }

    public void setCampo113(String campo113) {
        this.campo113 = campo113;
    }

    public String getCampo114() {
        return campo114;
    }

    public void setCampo114(String campo114) {
        this.campo114 = campo114;
    }

    public String getCampo115() {
        return campo115;
    }

    public void setCampo115(String campo115) {
        this.campo115 = campo115;
    }

    public String getCampo116() {
        return campo116;
    }

    public void setCampo116(String campo116) {
        this.campo116 = campo116;
    }

    public String getFulfillmentMethod() {
        return fulfillmentMethod;
    }

    public void setFulfillmentMethod(String fulfillmentMethod) {
        this.fulfillmentMethod = fulfillmentMethod;
    }

    public String getCreditInterestIndicator() {
        return creditInterestIndicator;
    }

    public void setCreditInterestIndicator(String creditInterestIndicator) {
        this.creditInterestIndicator = creditInterestIndicator;
    }

    public String getAmaIndicator() {
        return amaIndicator;
    }

    public void setAmaIndicator(String amaIndicator) {
        this.amaIndicator = amaIndicator;
    }

    public String getCampo120() {
        return campo120;
    }

    public void setCampo120(String campo120) {
        this.campo120 = campo120;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}