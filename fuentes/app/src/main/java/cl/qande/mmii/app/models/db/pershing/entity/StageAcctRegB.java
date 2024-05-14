package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_acct_reg_b", schema = "stage_pershing")
public class StageAcctRegB {
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
    @Column(name = "tax_id_type", length = 100)
    private String taxIdType;

    @Size(max = 100)
    @Column(name = "tax_id_number", length = 100)
    private String taxIdNumber;

    @Column(name = "date_tax_id_applied_for")
    private LocalDate dateTaxIdAppliedFor;

    @Size(max = 100)
    @Column(name = "w_8_w_9_indicator", length = 100)
    private String w8W9Indicator;

    @Column(name = "w_8_w_9_date_signed")
    private LocalDate w8W9DateSigned;

    @Column(name = "w_8_w_9_effective_date")
    private LocalDate w8W9EffectiveDate;

    @Size(max = 100)
    @Column(name = "w_8_w_9_document_type", length = 100)
    private String w8W9DocumentType;

    @Size(max = 100)
    @Column(name = "tax_status", length = 100)
    private String taxStatus;

    @Size(max = 100)
    @Column(name = "b_notice_reason_code", length = 100)
    private String bNoticeReasonCode;

    @Size(max = 100)
    @Column(name = "first_b_notice_status", length = 100)
    private String firstBNoticeStatus;

    @Column(name = "date_first_b_notice_status_issued_enforced")
    private LocalDate dateFirstBNoticeStatusIssuedEnforced;

    @Size(max = 100)
    @Column(name = "campo_21", length = 100)
    private String campo21;

    @Column(name = "date_first_notice_status_satisfied")
    private LocalDate dateFirstNoticeStatusSatisfied;

    @Size(max = 100)
    @Column(name = "second_b_notice_status", length = 100)
    private String secondBNoticeStatus;

    @Column(name = "date_second_b_notice_status_issued_enforced")
    private LocalDate dateSecondBNoticeStatusIssuedEnforced;

    @Size(max = 100)
    @Column(name = "campo_25", length = 100)
    private String campo25;

    @Column(name = "date_second_b_notice_status_satisfied")
    private LocalDate dateSecondBNoticeStatusSatisfied;

    @Size(max = 100)
    @Column(name = "c_notice_status", length = 100)
    private String cNoticeStatus;

    @Column(name = "date_c_notice_status_issued_enforced")
    private LocalDate dateCNoticeStatusIssuedEnforced;

    @Column(name = "date_c_notice_status_satisfied")
    private LocalDate dateCNoticeStatusSatisfied;

    @Size(max = 100)
    @Column(name = "old_account_number", length = 100)
    private String oldAccountNumber;

    @Column(name = "original_account_open_date")
    private LocalDate originalAccountOpenDate;

    @Size(max = 100)
    @Column(name = "unidentified_large_trader_id", length = 100)
    private String unidentifiedLargeTraderId;

    @Size(max = 100)
    @Column(name = "campo_33", length = 100)
    private String campo33;

    @Size(max = 100)
    @Column(name = "large_trader_type_code", length = 100)
    private String largeTraderTypeCode;

    @Column(name = "large_trader_type_last_change_date")
    private LocalDate largeTraderTypeLastChangeDate;

    @Size(max = 100)
    @Column(name = "campo_36", length = 100)
    private String campo36;

    @Size(max = 100)
    @Column(name = "campo_37", length = 100)
    private String campo37;

    @Size(max = 100)
    @Column(name = "initial_source_of_funds_other", length = 100)
    private String initialSourceOfFundsOther;

    @Size(max = 100)
    @Column(name = "finance_away", length = 100)
    private String financeAway;

    @Column(name = "account_funding_date")
    private LocalDate accountFundingDate;

    @Size(max = 100)
    @Column(name = "campo_41", length = 100)
    private String campo41;

    @Size(max = 100)
    @Column(name = "statement_currency_code", length = 100)
    private String statementCurrencyCode;

    @Size(max = 100)
    @Column(name = "future_statement_currency_code", length = 100)
    private String futureStatementCurrencyCode;

    @Column(name = "future_statement_currency_code_effective_date")
    private LocalDate futureStatementCurrencyCodeEffectiveDate;

    @Size(max = 100)
    @Column(name = "account_level_routing_code_1", length = 100)
    private String accountLevelRoutingCode1;

    @Size(max = 100)
    @Column(name = "account_level_routing_code_2", length = 100)
    private String accountLevelRoutingCode2;

    @Size(max = 100)
    @Column(name = "account_level_routing_code_3", length = 100)
    private String accountLevelRoutingCode3;

    @Size(max = 100)
    @Column(name = "account_level_routing_code_4", length = 100)
    private String accountLevelRoutingCode4;

    @Size(max = 100)
    @Column(name = "campo_49", length = 100)
    private String campo49;

    @Size(max = 100)
    @Column(name = "self_directed_ind", length = 100)
    private String selfDirectedInd;

    @Size(max = 100)
    @Column(name = "digital_advice_ind", length = 100)
    private String digitalAdviceInd;

    @Size(max = 100)
    @Column(name = "pte_account_ind", length = 100)
    private String pteAccountInd;

    @Size(max = 100)
    @Column(name = "campo_53", length = 100)
    private String campo53;

    @Size(max = 100)
    @Column(name = "first_ip", length = 100)
    private String firstIp;

    @Size(max = 100)
    @Column(name = "second_ip", length = 100)
    private String secondIp;

    @Size(max = 100)
    @Column(name = "third_ip", length = 100)
    private String thirdIp;

    @Size(max = 100)
    @Column(name = "fourth_ip", length = 100)
    private String fourthIp;

    @Size(max = 100)
    @Column(name = "fifth_ip", length = 100)
    private String fifthIp;

    @Size(max = 100)
    @Column(name = "sixth_ip", length = 100)
    private String sixthIp;

    @Size(max = 100)
    @Column(name = "seventh_ip", length = 100)
    private String seventhIp;

    @Size(max = 100)
    @Column(name = "eighth_ip", length = 100)
    private String eighthIp;

    @Size(max = 100)
    @Column(name = "ninth_ip", length = 100)
    private String ninthIp;

    @Size(max = 100)
    @Column(name = "tenth_ip", length = 100)
    private String tenthIp;

    @Size(max = 100)
    @Column(name = "alert_im_acornym", length = 100)
    private String alertImAcornym;

    @Size(max = 100)
    @Column(name = "alert_im_access_code", length = 100)
    private String alertImAccessCode;

    @Size(max = 100)
    @Column(name = "broker_acronym", length = 100)
    private String brokerAcronym;

    @Size(max = 100)
    @Column(name = "cross_reference_indicator", length = 100)
    private String crossReferenceIndicator;

    @Size(max = 100)
    @Column(name = "bny_trust_indicator", length = 100)
    private String bnyTrustIndicator;

    @Size(max = 100)
    @Column(name = "source_of_asset_at_acct_opening", length = 100)
    private String sourceOfAssetAtAcctOpening;

    @Size(max = 100)
    @Column(name = "commission_doscount_code", length = 100)
    private String commissionDoscountCode;

    @Size(max = 100)
    @Column(name = "external_account_number", length = 100)
    private String externalAccountNumber;

    @Size(max = 100)
    @Column(name = "confirmation_suppression_indicator", length = 100)
    private String confirmationSuppressionIndicator;

    @Column(name = "date_last_mail_sent")
    private LocalDate dateLastMailSent;

    @Column(name = "date_last_mail_sent_outside")
    private LocalDate dateLastMailSentOutside;

    @Size(max = 100)
    @Column(name = "campo_75", length = 100)
    private String campo75;

    @Size(max = 100)
    @Column(name = "fully_paid_lending_agreement_indicator", length = 100)
    private String fullyPaidLendingAgreementIndicator;

    @Column(name = "fully_paid_lending_agreement_date")
    private LocalDate fullyPaidLendingAgreementDate;

    @Size(max = 100)
    @Column(name = "custodian_account_type", length = 100)
    private String custodianAccountType;

    @Size(max = 100)
    @Column(name = "mifid_customer_categorization", length = 100)
    private String mifidCustomerCategorization;

    @Size(max = 100)
    @Column(name = "cash_management_tran_code", length = 100)
    private String cashManagementTranCode;

    @Size(max = 100)
    @Column(name = "sweep_status_indicator", length = 100)
    private String sweepStatusIndicator;

    @Column(name = "date_sweep_activated")
    private LocalDate dateSweepActivated;

    @Column(name = "date_sweep_details_changed")
    private LocalDate dateSweepDetailsChanged;

    @Size(max = 100)
    @Column(name = "cober_margin_debit_indicator", length = 100)
    private String coberMarginDebitIndicator;

    @Size(max = 100)
    @Column(name = "campo_85", length = 100)
    private String campo85;

    @Size(max = 100)
    @Column(name = "first_fund_sweep_account_id", length = 100)
    private String firstFundSweepAccountId;

    @Column(name = "firstfund_sweep_account_percent", precision = 45, scale = 20)
    private BigDecimal firstfundSweepAccountPercent;

    @Size(max = 100)
    @Column(name = "first_fundsweep_account_redemption_priority", length = 100)
    private String firstFundsweepAccountRedemptionPriority;

    @Size(max = 100)
    @Column(name = "second_fund_sweep_account_id", length = 100)
    private String secondFundSweepAccountId;

    @Column(name = "second_fund_sweep_account_percent", precision = 45, scale = 20)
    private BigDecimal secondFundSweepAccountPercent;

    @Size(max = 100)
    @Column(name = "second_fundsweep_account_redemption_priority", length = 100)
    private String secondFundsweepAccountRedemptionPriority;

    @Size(max = 100)
    @Column(name = "type_of_bank_account", length = 100)
    private String typeOfBankAccount;

    @Size(max = 100)
    @Column(name = "banklink_aba_number", length = 100)
    private String banklinkAbaNumber;

    @Size(max = 100)
    @Column(name = "banklink_dda_number", length = 100)
    private String banklinkDdaNumber;

    @Size(max = 100)
    @Column(name = "campo_95", length = 100)
    private String campo95;

    @Size(max = 100)
    @Column(name = "fund_bank_indicator", length = 100)
    private String fundBankIndicator;

    @Size(max = 100)
    @Column(name = "campo_97", length = 100)
    private String campo97;

    @Size(max = 100)
    @Column(name = "w_9_corp_tax_classification_code", length = 100)
    private String w9CorpTaxClassificationCode;

    @Size(max = 100)
    @Column(name = "campo_99", length = 100)
    private String campo99;

    @Size(max = 100)
    @Column(name = "combined_margin_acct_indicator", length = 100)
    private String combinedMarginAcctIndicator;

    @Size(max = 100)
    @Column(name = "pledge_collateral_account_indicator", length = 100)
    private String pledgeCollateralAccountIndicator;

    @Size(max = 100)
    @Column(name = "finra_institutional_account_code", length = 100)
    private String finraInstitutionalAccountCode;

    @Size(max = 100)
    @Column(name = "proposed_account_reference_id", length = 100)
    private String proposedAccountReferenceId;

    @Size(max = 100)
    @Column(name = "advisor_model_id", length = 100)
    private String advisorModelId;

    @Size(max = 100)
    @Column(name = "firm_model_style_id", length = 100)
    private String firmModelStyleId;

    @Size(max = 100)
    @Column(name = "campo_106", length = 100)
    private String campo106;

    @Size(max = 100)
    @Column(name = "campo_107", length = 100)
    private String campo107;

    @Size(max = 100)
    @Column(name = "campo_108", length = 100)
    private String campo108;

    @Size(max = 100)
    @Column(name = "dvp_restriction_code", length = 100)
    private String dvpRestrictionCode;

    @Column(name = "dvp_restriction_exp_date")
    private LocalDate dvpRestrictionExpDate;

    @Size(max = 100)
    @Column(name = "escheatment_withholding_ind", length = 100)
    private String escheatmentWithholdingInd;

    @Size(max = 100)
    @Column(name = "campo_112", length = 100)
    private String campo112;

    @Size(max = 100)
    @Column(name = "source_of_origination", length = 100)
    private String sourceOfOrigination;

    @Size(max = 100)
    @Column(name = "source_of_persona", length = 100)
    private String sourceOfPersona;

    @Size(max = 100)
    @Column(name = "client_onboarding_method", length = 100)
    private String clientOnboardingMethod;

    @Size(max = 100)
    @Column(name = "tax_filing_code", length = 100)
    private String taxFilingCode;

    @Size(max = 100)
    @Column(name = "campo_117", length = 100)
    private String campo117;

    @Size(max = 100)
    @Column(name = "campo_118", length = 100)
    private String campo118;

    @Size(max = 100)
    @Column(name = "nor_purpose_collateral_acct_ind", length = 100)
    private String norPurposeCollateralAcctInd;

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

    public String getTaxIdType() {
        return taxIdType;
    }

    public void setTaxIdType(String taxIdType) {
        this.taxIdType = taxIdType;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public LocalDate getDateTaxIdAppliedFor() {
        return dateTaxIdAppliedFor;
    }

    public void setDateTaxIdAppliedFor(LocalDate dateTaxIdAppliedFor) {
        this.dateTaxIdAppliedFor = dateTaxIdAppliedFor;
    }

    public String getW8W9Indicator() {
        return w8W9Indicator;
    }

    public void setW8W9Indicator(String w8W9Indicator) {
        this.w8W9Indicator = w8W9Indicator;
    }

    public LocalDate getW8W9DateSigned() {
        return w8W9DateSigned;
    }

    public void setW8W9DateSigned(LocalDate w8W9DateSigned) {
        this.w8W9DateSigned = w8W9DateSigned;
    }

    public LocalDate getW8W9EffectiveDate() {
        return w8W9EffectiveDate;
    }

    public void setW8W9EffectiveDate(LocalDate w8W9EffectiveDate) {
        this.w8W9EffectiveDate = w8W9EffectiveDate;
    }

    public String getW8W9DocumentType() {
        return w8W9DocumentType;
    }

    public void setW8W9DocumentType(String w8W9DocumentType) {
        this.w8W9DocumentType = w8W9DocumentType;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public String getBNoticeReasonCode() {
        return bNoticeReasonCode;
    }

    public void setBNoticeReasonCode(String bNoticeReasonCode) {
        this.bNoticeReasonCode = bNoticeReasonCode;
    }

    public String getFirstBNoticeStatus() {
        return firstBNoticeStatus;
    }

    public void setFirstBNoticeStatus(String firstBNoticeStatus) {
        this.firstBNoticeStatus = firstBNoticeStatus;
    }

    public LocalDate getDateFirstBNoticeStatusIssuedEnforced() {
        return dateFirstBNoticeStatusIssuedEnforced;
    }

    public void setDateFirstBNoticeStatusIssuedEnforced(LocalDate dateFirstBNoticeStatusIssuedEnforced) {
        this.dateFirstBNoticeStatusIssuedEnforced = dateFirstBNoticeStatusIssuedEnforced;
    }

    public String getCampo21() {
        return campo21;
    }

    public void setCampo21(String campo21) {
        this.campo21 = campo21;
    }

    public LocalDate getDateFirstNoticeStatusSatisfied() {
        return dateFirstNoticeStatusSatisfied;
    }

    public void setDateFirstNoticeStatusSatisfied(LocalDate dateFirstNoticeStatusSatisfied) {
        this.dateFirstNoticeStatusSatisfied = dateFirstNoticeStatusSatisfied;
    }

    public String getSecondBNoticeStatus() {
        return secondBNoticeStatus;
    }

    public void setSecondBNoticeStatus(String secondBNoticeStatus) {
        this.secondBNoticeStatus = secondBNoticeStatus;
    }

    public LocalDate getDateSecondBNoticeStatusIssuedEnforced() {
        return dateSecondBNoticeStatusIssuedEnforced;
    }

    public void setDateSecondBNoticeStatusIssuedEnforced(LocalDate dateSecondBNoticeStatusIssuedEnforced) {
        this.dateSecondBNoticeStatusIssuedEnforced = dateSecondBNoticeStatusIssuedEnforced;
    }

    public String getCampo25() {
        return campo25;
    }

    public void setCampo25(String campo25) {
        this.campo25 = campo25;
    }

    public LocalDate getDateSecondBNoticeStatusSatisfied() {
        return dateSecondBNoticeStatusSatisfied;
    }

    public void setDateSecondBNoticeStatusSatisfied(LocalDate dateSecondBNoticeStatusSatisfied) {
        this.dateSecondBNoticeStatusSatisfied = dateSecondBNoticeStatusSatisfied;
    }

    public String getCNoticeStatus() {
        return cNoticeStatus;
    }

    public void setCNoticeStatus(String cNoticeStatus) {
        this.cNoticeStatus = cNoticeStatus;
    }

    public LocalDate getDateCNoticeStatusIssuedEnforced() {
        return dateCNoticeStatusIssuedEnforced;
    }

    public void setDateCNoticeStatusIssuedEnforced(LocalDate dateCNoticeStatusIssuedEnforced) {
        this.dateCNoticeStatusIssuedEnforced = dateCNoticeStatusIssuedEnforced;
    }

    public LocalDate getDateCNoticeStatusSatisfied() {
        return dateCNoticeStatusSatisfied;
    }

    public void setDateCNoticeStatusSatisfied(LocalDate dateCNoticeStatusSatisfied) {
        this.dateCNoticeStatusSatisfied = dateCNoticeStatusSatisfied;
    }

    public String getOldAccountNumber() {
        return oldAccountNumber;
    }

    public void setOldAccountNumber(String oldAccountNumber) {
        this.oldAccountNumber = oldAccountNumber;
    }

    public LocalDate getOriginalAccountOpenDate() {
        return originalAccountOpenDate;
    }

    public void setOriginalAccountOpenDate(LocalDate originalAccountOpenDate) {
        this.originalAccountOpenDate = originalAccountOpenDate;
    }

    public String getUnidentifiedLargeTraderId() {
        return unidentifiedLargeTraderId;
    }

    public void setUnidentifiedLargeTraderId(String unidentifiedLargeTraderId) {
        this.unidentifiedLargeTraderId = unidentifiedLargeTraderId;
    }

    public String getCampo33() {
        return campo33;
    }

    public void setCampo33(String campo33) {
        this.campo33 = campo33;
    }

    public String getLargeTraderTypeCode() {
        return largeTraderTypeCode;
    }

    public void setLargeTraderTypeCode(String largeTraderTypeCode) {
        this.largeTraderTypeCode = largeTraderTypeCode;
    }

    public LocalDate getLargeTraderTypeLastChangeDate() {
        return largeTraderTypeLastChangeDate;
    }

    public void setLargeTraderTypeLastChangeDate(LocalDate largeTraderTypeLastChangeDate) {
        this.largeTraderTypeLastChangeDate = largeTraderTypeLastChangeDate;
    }

    public String getCampo36() {
        return campo36;
    }

    public void setCampo36(String campo36) {
        this.campo36 = campo36;
    }

    public String getCampo37() {
        return campo37;
    }

    public void setCampo37(String campo37) {
        this.campo37 = campo37;
    }

    public String getInitialSourceOfFundsOther() {
        return initialSourceOfFundsOther;
    }

    public void setInitialSourceOfFundsOther(String initialSourceOfFundsOther) {
        this.initialSourceOfFundsOther = initialSourceOfFundsOther;
    }

    public String getFinanceAway() {
        return financeAway;
    }

    public void setFinanceAway(String financeAway) {
        this.financeAway = financeAway;
    }

    public LocalDate getAccountFundingDate() {
        return accountFundingDate;
    }

    public void setAccountFundingDate(LocalDate accountFundingDate) {
        this.accountFundingDate = accountFundingDate;
    }

    public String getCampo41() {
        return campo41;
    }

    public void setCampo41(String campo41) {
        this.campo41 = campo41;
    }

    public String getStatementCurrencyCode() {
        return statementCurrencyCode;
    }

    public void setStatementCurrencyCode(String statementCurrencyCode) {
        this.statementCurrencyCode = statementCurrencyCode;
    }

    public String getFutureStatementCurrencyCode() {
        return futureStatementCurrencyCode;
    }

    public void setFutureStatementCurrencyCode(String futureStatementCurrencyCode) {
        this.futureStatementCurrencyCode = futureStatementCurrencyCode;
    }

    public LocalDate getFutureStatementCurrencyCodeEffectiveDate() {
        return futureStatementCurrencyCodeEffectiveDate;
    }

    public void setFutureStatementCurrencyCodeEffectiveDate(LocalDate futureStatementCurrencyCodeEffectiveDate) {
        this.futureStatementCurrencyCodeEffectiveDate = futureStatementCurrencyCodeEffectiveDate;
    }

    public String getAccountLevelRoutingCode1() {
        return accountLevelRoutingCode1;
    }

    public void setAccountLevelRoutingCode1(String accountLevelRoutingCode1) {
        this.accountLevelRoutingCode1 = accountLevelRoutingCode1;
    }

    public String getAccountLevelRoutingCode2() {
        return accountLevelRoutingCode2;
    }

    public void setAccountLevelRoutingCode2(String accountLevelRoutingCode2) {
        this.accountLevelRoutingCode2 = accountLevelRoutingCode2;
    }

    public String getAccountLevelRoutingCode3() {
        return accountLevelRoutingCode3;
    }

    public void setAccountLevelRoutingCode3(String accountLevelRoutingCode3) {
        this.accountLevelRoutingCode3 = accountLevelRoutingCode3;
    }

    public String getAccountLevelRoutingCode4() {
        return accountLevelRoutingCode4;
    }

    public void setAccountLevelRoutingCode4(String accountLevelRoutingCode4) {
        this.accountLevelRoutingCode4 = accountLevelRoutingCode4;
    }

    public String getCampo49() {
        return campo49;
    }

    public void setCampo49(String campo49) {
        this.campo49 = campo49;
    }

    public String getSelfDirectedInd() {
        return selfDirectedInd;
    }

    public void setSelfDirectedInd(String selfDirectedInd) {
        this.selfDirectedInd = selfDirectedInd;
    }

    public String getDigitalAdviceInd() {
        return digitalAdviceInd;
    }

    public void setDigitalAdviceInd(String digitalAdviceInd) {
        this.digitalAdviceInd = digitalAdviceInd;
    }

    public String getPteAccountInd() {
        return pteAccountInd;
    }

    public void setPteAccountInd(String pteAccountInd) {
        this.pteAccountInd = pteAccountInd;
    }

    public String getCampo53() {
        return campo53;
    }

    public void setCampo53(String campo53) {
        this.campo53 = campo53;
    }

    public String getFirstIp() {
        return firstIp;
    }

    public void setFirstIp(String firstIp) {
        this.firstIp = firstIp;
    }

    public String getSecondIp() {
        return secondIp;
    }

    public void setSecondIp(String secondIp) {
        this.secondIp = secondIp;
    }

    public String getThirdIp() {
        return thirdIp;
    }

    public void setThirdIp(String thirdIp) {
        this.thirdIp = thirdIp;
    }

    public String getFourthIp() {
        return fourthIp;
    }

    public void setFourthIp(String fourthIp) {
        this.fourthIp = fourthIp;
    }

    public String getFifthIp() {
        return fifthIp;
    }

    public void setFifthIp(String fifthIp) {
        this.fifthIp = fifthIp;
    }

    public String getSixthIp() {
        return sixthIp;
    }

    public void setSixthIp(String sixthIp) {
        this.sixthIp = sixthIp;
    }

    public String getSeventhIp() {
        return seventhIp;
    }

    public void setSeventhIp(String seventhIp) {
        this.seventhIp = seventhIp;
    }

    public String getEighthIp() {
        return eighthIp;
    }

    public void setEighthIp(String eighthIp) {
        this.eighthIp = eighthIp;
    }

    public String getNinthIp() {
        return ninthIp;
    }

    public void setNinthIp(String ninthIp) {
        this.ninthIp = ninthIp;
    }

    public String getTenthIp() {
        return tenthIp;
    }

    public void setTenthIp(String tenthIp) {
        this.tenthIp = tenthIp;
    }

    public String getAlertImAcornym() {
        return alertImAcornym;
    }

    public void setAlertImAcornym(String alertImAcornym) {
        this.alertImAcornym = alertImAcornym;
    }

    public String getAlertImAccessCode() {
        return alertImAccessCode;
    }

    public void setAlertImAccessCode(String alertImAccessCode) {
        this.alertImAccessCode = alertImAccessCode;
    }

    public String getBrokerAcronym() {
        return brokerAcronym;
    }

    public void setBrokerAcronym(String brokerAcronym) {
        this.brokerAcronym = brokerAcronym;
    }

    public String getCrossReferenceIndicator() {
        return crossReferenceIndicator;
    }

    public void setCrossReferenceIndicator(String crossReferenceIndicator) {
        this.crossReferenceIndicator = crossReferenceIndicator;
    }

    public String getBnyTrustIndicator() {
        return bnyTrustIndicator;
    }

    public void setBnyTrustIndicator(String bnyTrustIndicator) {
        this.bnyTrustIndicator = bnyTrustIndicator;
    }

    public String getSourceOfAssetAtAcctOpening() {
        return sourceOfAssetAtAcctOpening;
    }

    public void setSourceOfAssetAtAcctOpening(String sourceOfAssetAtAcctOpening) {
        this.sourceOfAssetAtAcctOpening = sourceOfAssetAtAcctOpening;
    }

    public String getCommissionDoscountCode() {
        return commissionDoscountCode;
    }

    public void setCommissionDoscountCode(String commissionDoscountCode) {
        this.commissionDoscountCode = commissionDoscountCode;
    }

    public String getExternalAccountNumber() {
        return externalAccountNumber;
    }

    public void setExternalAccountNumber(String externalAccountNumber) {
        this.externalAccountNumber = externalAccountNumber;
    }

    public String getConfirmationSuppressionIndicator() {
        return confirmationSuppressionIndicator;
    }

    public void setConfirmationSuppressionIndicator(String confirmationSuppressionIndicator) {
        this.confirmationSuppressionIndicator = confirmationSuppressionIndicator;
    }

    public LocalDate getDateLastMailSent() {
        return dateLastMailSent;
    }

    public void setDateLastMailSent(LocalDate dateLastMailSent) {
        this.dateLastMailSent = dateLastMailSent;
    }

    public LocalDate getDateLastMailSentOutside() {
        return dateLastMailSentOutside;
    }

    public void setDateLastMailSentOutside(LocalDate dateLastMailSentOutside) {
        this.dateLastMailSentOutside = dateLastMailSentOutside;
    }

    public String getCampo75() {
        return campo75;
    }

    public void setCampo75(String campo75) {
        this.campo75 = campo75;
    }

    public String getFullyPaidLendingAgreementIndicator() {
        return fullyPaidLendingAgreementIndicator;
    }

    public void setFullyPaidLendingAgreementIndicator(String fullyPaidLendingAgreementIndicator) {
        this.fullyPaidLendingAgreementIndicator = fullyPaidLendingAgreementIndicator;
    }

    public LocalDate getFullyPaidLendingAgreementDate() {
        return fullyPaidLendingAgreementDate;
    }

    public void setFullyPaidLendingAgreementDate(LocalDate fullyPaidLendingAgreementDate) {
        this.fullyPaidLendingAgreementDate = fullyPaidLendingAgreementDate;
    }

    public String getCustodianAccountType() {
        return custodianAccountType;
    }

    public void setCustodianAccountType(String custodianAccountType) {
        this.custodianAccountType = custodianAccountType;
    }

    public String getMifidCustomerCategorization() {
        return mifidCustomerCategorization;
    }

    public void setMifidCustomerCategorization(String mifidCustomerCategorization) {
        this.mifidCustomerCategorization = mifidCustomerCategorization;
    }

    public String getCashManagementTranCode() {
        return cashManagementTranCode;
    }

    public void setCashManagementTranCode(String cashManagementTranCode) {
        this.cashManagementTranCode = cashManagementTranCode;
    }

    public String getSweepStatusIndicator() {
        return sweepStatusIndicator;
    }

    public void setSweepStatusIndicator(String sweepStatusIndicator) {
        this.sweepStatusIndicator = sweepStatusIndicator;
    }

    public LocalDate getDateSweepActivated() {
        return dateSweepActivated;
    }

    public void setDateSweepActivated(LocalDate dateSweepActivated) {
        this.dateSweepActivated = dateSweepActivated;
    }

    public LocalDate getDateSweepDetailsChanged() {
        return dateSweepDetailsChanged;
    }

    public void setDateSweepDetailsChanged(LocalDate dateSweepDetailsChanged) {
        this.dateSweepDetailsChanged = dateSweepDetailsChanged;
    }

    public String getCoberMarginDebitIndicator() {
        return coberMarginDebitIndicator;
    }

    public void setCoberMarginDebitIndicator(String coberMarginDebitIndicator) {
        this.coberMarginDebitIndicator = coberMarginDebitIndicator;
    }

    public String getCampo85() {
        return campo85;
    }

    public void setCampo85(String campo85) {
        this.campo85 = campo85;
    }

    public String getFirstFundSweepAccountId() {
        return firstFundSweepAccountId;
    }

    public void setFirstFundSweepAccountId(String firstFundSweepAccountId) {
        this.firstFundSweepAccountId = firstFundSweepAccountId;
    }

    public BigDecimal getFirstfundSweepAccountPercent() {
        return firstfundSweepAccountPercent;
    }

    public void setFirstfundSweepAccountPercent(BigDecimal firstfundSweepAccountPercent) {
        this.firstfundSweepAccountPercent = firstfundSweepAccountPercent;
    }

    public String getFirstFundsweepAccountRedemptionPriority() {
        return firstFundsweepAccountRedemptionPriority;
    }

    public void setFirstFundsweepAccountRedemptionPriority(String firstFundsweepAccountRedemptionPriority) {
        this.firstFundsweepAccountRedemptionPriority = firstFundsweepAccountRedemptionPriority;
    }

    public String getSecondFundSweepAccountId() {
        return secondFundSweepAccountId;
    }

    public void setSecondFundSweepAccountId(String secondFundSweepAccountId) {
        this.secondFundSweepAccountId = secondFundSweepAccountId;
    }

    public BigDecimal getSecondFundSweepAccountPercent() {
        return secondFundSweepAccountPercent;
    }

    public void setSecondFundSweepAccountPercent(BigDecimal secondFundSweepAccountPercent) {
        this.secondFundSweepAccountPercent = secondFundSweepAccountPercent;
    }

    public String getSecondFundsweepAccountRedemptionPriority() {
        return secondFundsweepAccountRedemptionPriority;
    }

    public void setSecondFundsweepAccountRedemptionPriority(String secondFundsweepAccountRedemptionPriority) {
        this.secondFundsweepAccountRedemptionPriority = secondFundsweepAccountRedemptionPriority;
    }

    public String getTypeOfBankAccount() {
        return typeOfBankAccount;
    }

    public void setTypeOfBankAccount(String typeOfBankAccount) {
        this.typeOfBankAccount = typeOfBankAccount;
    }

    public String getBanklinkAbaNumber() {
        return banklinkAbaNumber;
    }

    public void setBanklinkAbaNumber(String banklinkAbaNumber) {
        this.banklinkAbaNumber = banklinkAbaNumber;
    }

    public String getBanklinkDdaNumber() {
        return banklinkDdaNumber;
    }

    public void setBanklinkDdaNumber(String banklinkDdaNumber) {
        this.banklinkDdaNumber = banklinkDdaNumber;
    }

    public String getCampo95() {
        return campo95;
    }

    public void setCampo95(String campo95) {
        this.campo95 = campo95;
    }

    public String getFundBankIndicator() {
        return fundBankIndicator;
    }

    public void setFundBankIndicator(String fundBankIndicator) {
        this.fundBankIndicator = fundBankIndicator;
    }

    public String getCampo97() {
        return campo97;
    }

    public void setCampo97(String campo97) {
        this.campo97 = campo97;
    }

    public String getW9CorpTaxClassificationCode() {
        return w9CorpTaxClassificationCode;
    }

    public void setW9CorpTaxClassificationCode(String w9CorpTaxClassificationCode) {
        this.w9CorpTaxClassificationCode = w9CorpTaxClassificationCode;
    }

    public String getCampo99() {
        return campo99;
    }

    public void setCampo99(String campo99) {
        this.campo99 = campo99;
    }

    public String getCombinedMarginAcctIndicator() {
        return combinedMarginAcctIndicator;
    }

    public void setCombinedMarginAcctIndicator(String combinedMarginAcctIndicator) {
        this.combinedMarginAcctIndicator = combinedMarginAcctIndicator;
    }

    public String getPledgeCollateralAccountIndicator() {
        return pledgeCollateralAccountIndicator;
    }

    public void setPledgeCollateralAccountIndicator(String pledgeCollateralAccountIndicator) {
        this.pledgeCollateralAccountIndicator = pledgeCollateralAccountIndicator;
    }

    public String getFinraInstitutionalAccountCode() {
        return finraInstitutionalAccountCode;
    }

    public void setFinraInstitutionalAccountCode(String finraInstitutionalAccountCode) {
        this.finraInstitutionalAccountCode = finraInstitutionalAccountCode;
    }

    public String getProposedAccountReferenceId() {
        return proposedAccountReferenceId;
    }

    public void setProposedAccountReferenceId(String proposedAccountReferenceId) {
        this.proposedAccountReferenceId = proposedAccountReferenceId;
    }

    public String getAdvisorModelId() {
        return advisorModelId;
    }

    public void setAdvisorModelId(String advisorModelId) {
        this.advisorModelId = advisorModelId;
    }

    public String getFirmModelStyleId() {
        return firmModelStyleId;
    }

    public void setFirmModelStyleId(String firmModelStyleId) {
        this.firmModelStyleId = firmModelStyleId;
    }

    public String getCampo106() {
        return campo106;
    }

    public void setCampo106(String campo106) {
        this.campo106 = campo106;
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

    public String getDvpRestrictionCode() {
        return dvpRestrictionCode;
    }

    public void setDvpRestrictionCode(String dvpRestrictionCode) {
        this.dvpRestrictionCode = dvpRestrictionCode;
    }

    public LocalDate getDvpRestrictionExpDate() {
        return dvpRestrictionExpDate;
    }

    public void setDvpRestrictionExpDate(LocalDate dvpRestrictionExpDate) {
        this.dvpRestrictionExpDate = dvpRestrictionExpDate;
    }

    public String getEscheatmentWithholdingInd() {
        return escheatmentWithholdingInd;
    }

    public void setEscheatmentWithholdingInd(String escheatmentWithholdingInd) {
        this.escheatmentWithholdingInd = escheatmentWithholdingInd;
    }

    public String getCampo112() {
        return campo112;
    }

    public void setCampo112(String campo112) {
        this.campo112 = campo112;
    }

    public String getSourceOfOrigination() {
        return sourceOfOrigination;
    }

    public void setSourceOfOrigination(String sourceOfOrigination) {
        this.sourceOfOrigination = sourceOfOrigination;
    }

    public String getSourceOfPersona() {
        return sourceOfPersona;
    }

    public void setSourceOfPersona(String sourceOfPersona) {
        this.sourceOfPersona = sourceOfPersona;
    }

    public String getClientOnboardingMethod() {
        return clientOnboardingMethod;
    }

    public void setClientOnboardingMethod(String clientOnboardingMethod) {
        this.clientOnboardingMethod = clientOnboardingMethod;
    }

    public String getTaxFilingCode() {
        return taxFilingCode;
    }

    public void setTaxFilingCode(String taxFilingCode) {
        this.taxFilingCode = taxFilingCode;
    }

    public String getCampo117() {
        return campo117;
    }

    public void setCampo117(String campo117) {
        this.campo117 = campo117;
    }

    public String getCampo118() {
        return campo118;
    }

    public void setCampo118(String campo118) {
        this.campo118 = campo118;
    }

    public String getNorPurposeCollateralAcctInd() {
        return norPurposeCollateralAcctInd;
    }

    public void setNorPurposeCollateralAcctInd(String norPurposeCollateralAcctInd) {
        this.norPurposeCollateralAcctInd = norPurposeCollateralAcctInd;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}