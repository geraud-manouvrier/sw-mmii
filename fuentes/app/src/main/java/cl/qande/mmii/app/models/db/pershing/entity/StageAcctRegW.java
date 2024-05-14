package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "stage_acct_reg_w", schema = "stage_pershing")
public class StageAcctRegW {
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
    @Column(name = "record_transaction_code", length = 100)
    private String recordTransactionCode;

    @Size(max = 100)
    @Column(name = "non_us_dollar_trading", length = 100)
    private String nonUsDollarTrading;

    @Size(max = 100)
    @Column(name = "base_currency", length = 100)
    private String baseCurrency;

    @Size(max = 100)
    @Column(name = "income_currency", length = 100)
    private String incomeCurrency;

    @Size(max = 100)
    @Column(name = "statement_language", length = 100)
    private String statementLanguage;

    @Size(max = 100)
    @Column(name = "statement_format_code", length = 100)
    private String statementFormatCode;

    @Size(max = 100)
    @Column(name = "msrb_statement_ind", length = 100)
    private String msrbStatementInd;

    @Size(max = 100)
    @Column(name = "campo_17", length = 100)
    private String campo17;

    @Size(max = 100)
    @Column(name = "pep", length = 100)
    private String pep;

    @Size(max = 100)
    @Column(name = "first_name_pep", length = 100)
    private String firstNamePep;

    @Size(max = 100)
    @Column(name = "last_name_pep", length = 100)
    private String lastNamePep;

    @Size(max = 100)
    @Column(name = "suffix_pep", length = 100)
    private String suffixPep;

    @Size(max = 100)
    @Column(name = "political_office_held", length = 100)
    private String politicalOfficeHeld;

    @Size(max = 100)
    @Column(name = "country_of_office", length = 100)
    private String countryOfOffice;

    @Size(max = 100)
    @Column(name = "foreign_bank_account_ind", length = 100)
    private String foreignBankAccountInd;

    @Column(name = "foreign_bank_cert_date")
    private LocalDate foreignBankCertDate;

    @Column(name = "foreign_bank_cert_exp_date")
    private LocalDate foreignBankCertExpDate;

    @Size(max = 100)
    @Column(name = "central_bank_ind", length = 100)
    private String centralBankInd;

    @Size(max = 100)
    @Column(name = "acct_foreign_financial_inst", length = 100)
    private String acctForeignFinancialInst;

    @Size(max = 100)
    @Column(name = "foreign_bank_acct_oper_1", length = 100)
    private String foreignBankAcctOper1;

    @Size(max = 100)
    @Column(name = "foreign_bank_acct_oper_2", length = 100)
    private String foreignBankAcctOper2;

    @Size(max = 100)
    @Column(name = "foreign_bank_acct_oper_3", length = 100)
    private String foreignBankAcctOper3;

    @Size(max = 100)
    @Column(name = "number_people_own", length = 100)
    private String numberPeopleOwn;

    @Size(max = 100)
    @Column(name = "proprietary_acct_owned", length = 100)
    private String proprietaryAcctOwned;

    @Size(max = 100)
    @Column(name = "campo_34", length = 100)
    private String campo34;

    @Size(max = 100)
    @Column(name = "tel_1_transaction_code", length = 100)
    private String tel1TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_1_us_ind", length = 100)
    private String tel1UsInd;

    @Size(max = 100)
    @Column(name = "tel_1_type_id", length = 100)
    private String tel1TypeId;

    @Size(max = 100)
    @Column(name = "tel_1_number", length = 100)
    private String tel1Number;

    @Size(max = 100)
    @Column(name = "tel_1_extension", length = 100)
    private String tel1Extension;

    @Size(max = 100)
    @Column(name = "tel_2_transaction_code", length = 100)
    private String tel2TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_2_us_ind", length = 100)
    private String tel2UsInd;

    @Size(max = 100)
    @Column(name = "tel_2_type_id", length = 100)
    private String tel2TypeId;

    @Size(max = 100)
    @Column(name = "tel_2_number", length = 100)
    private String tel2Number;

    @Size(max = 100)
    @Column(name = "tel_2_extension", length = 100)
    private String tel2Extension;

    @Size(max = 100)
    @Column(name = "tel_3_transaction_code", length = 100)
    private String tel3TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_3_us_ind", length = 100)
    private String tel3UsInd;

    @Size(max = 100)
    @Column(name = "tel_3_type_id", length = 100)
    private String tel3TypeId;

    @Size(max = 100)
    @Column(name = "tel_3_number", length = 100)
    private String tel3Number;

    @Size(max = 100)
    @Column(name = "tel_3_extension", length = 100)
    private String tel3Extension;

    @Size(max = 100)
    @Column(name = "tel_4_transaction_code", length = 100)
    private String tel4TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_4_us_ind", length = 100)
    private String tel4UsInd;

    @Size(max = 100)
    @Column(name = "tel_4_type_id", length = 100)
    private String tel4TypeId;

    @Size(max = 100)
    @Column(name = "tel_4_number", length = 100)
    private String tel4Number;

    @Size(max = 100)
    @Column(name = "tel_4_extension", length = 100)
    private String tel4Extension;

    @Size(max = 100)
    @Column(name = "tel_5_transaction_code", length = 100)
    private String tel5TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_5_us_ind", length = 100)
    private String tel5UsInd;

    @Size(max = 100)
    @Column(name = "tel_5_type_id", length = 100)
    private String tel5TypeId;

    @Size(max = 100)
    @Column(name = "tel_5_number", length = 100)
    private String tel5Number;

    @Size(max = 100)
    @Column(name = "tel_5_extension", length = 100)
    private String tel5Extension;

    @Size(max = 100)
    @Column(name = "tel_6_transaction_code", length = 100)
    private String tel6TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_6_us_ind", length = 100)
    private String tel6UsInd;

    @Size(max = 100)
    @Column(name = "tel_6_type_id", length = 100)
    private String tel6TypeId;

    @Size(max = 100)
    @Column(name = "tel_6_number", length = 100)
    private String tel6Number;

    @Size(max = 100)
    @Column(name = "tel_6_extension", length = 100)
    private String tel6Extension;

    @Size(max = 100)
    @Column(name = "tel_7_transaction_code", length = 100)
    private String tel7TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_7_us_ind", length = 100)
    private String tel7UsInd;

    @Size(max = 100)
    @Column(name = "tel_7_type_id", length = 100)
    private String tel7TypeId;

    @Size(max = 100)
    @Column(name = "tel_7_number", length = 100)
    private String tel7Number;

    @Size(max = 100)
    @Column(name = "tel_7_extension", length = 100)
    private String tel7Extension;

    @Size(max = 100)
    @Column(name = "tel_8_transaction_code", length = 100)
    private String tel8TransactionCode;

    @Size(max = 100)
    @Column(name = "tel_8_us_ind", length = 100)
    private String tel8UsInd;

    @Size(max = 100)
    @Column(name = "tel_8_type_id", length = 100)
    private String tel8TypeId;

    @Size(max = 100)
    @Column(name = "tel_8_number", length = 100)
    private String tel8Number;

    @Size(max = 100)
    @Column(name = "tel_8_extension", length = 100)
    private String tel8Extension;

    @Size(max = 100)
    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Size(max = 100)
    @Column(name = "external_position_ind", length = 100)
    private String externalPositionInd;

    @Size(max = 100)
    @Column(name = "purge_eligible_ind", length = 100)
    private String purgeEligibleInd;

    @Size(max = 100)
    @Column(name = "advisory_acct_ind", length = 100)
    private String advisoryAcctInd;

    @Size(max = 100)
    @Column(name = "product_profile_code", length = 100)
    private String productProfileCode;

    @Column(name = "cents_per_share_discount")
    private Integer centsPerShareDiscount;

    @Size(max = 100)
    @Column(name = "campo_81", length = 100)
    private String campo81;

    @Column(name = "option_disclosure_date")
    private LocalDate optionDisclosureDate;

    @Size(max = 100)
    @Column(name = "campo_83", length = 100)
    private String campo83;

    @Size(max = 100)
    @Column(name = "country_acct_level_tax_residency", length = 100)
    private String countryAcctLevelTaxResidency;

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

    public String getRecordTransactionCode() {
        return recordTransactionCode;
    }

    public void setRecordTransactionCode(String recordTransactionCode) {
        this.recordTransactionCode = recordTransactionCode;
    }

    public String getNonUsDollarTrading() {
        return nonUsDollarTrading;
    }

    public void setNonUsDollarTrading(String nonUsDollarTrading) {
        this.nonUsDollarTrading = nonUsDollarTrading;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getIncomeCurrency() {
        return incomeCurrency;
    }

    public void setIncomeCurrency(String incomeCurrency) {
        this.incomeCurrency = incomeCurrency;
    }

    public String getStatementLanguage() {
        return statementLanguage;
    }

    public void setStatementLanguage(String statementLanguage) {
        this.statementLanguage = statementLanguage;
    }

    public String getStatementFormatCode() {
        return statementFormatCode;
    }

    public void setStatementFormatCode(String statementFormatCode) {
        this.statementFormatCode = statementFormatCode;
    }

    public String getMsrbStatementInd() {
        return msrbStatementInd;
    }

    public void setMsrbStatementInd(String msrbStatementInd) {
        this.msrbStatementInd = msrbStatementInd;
    }

    public String getCampo17() {
        return campo17;
    }

    public void setCampo17(String campo17) {
        this.campo17 = campo17;
    }

    public String getPep() {
        return pep;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }

    public String getFirstNamePep() {
        return firstNamePep;
    }

    public void setFirstNamePep(String firstNamePep) {
        this.firstNamePep = firstNamePep;
    }

    public String getLastNamePep() {
        return lastNamePep;
    }

    public void setLastNamePep(String lastNamePep) {
        this.lastNamePep = lastNamePep;
    }

    public String getSuffixPep() {
        return suffixPep;
    }

    public void setSuffixPep(String suffixPep) {
        this.suffixPep = suffixPep;
    }

    public String getPoliticalOfficeHeld() {
        return politicalOfficeHeld;
    }

    public void setPoliticalOfficeHeld(String politicalOfficeHeld) {
        this.politicalOfficeHeld = politicalOfficeHeld;
    }

    public String getCountryOfOffice() {
        return countryOfOffice;
    }

    public void setCountryOfOffice(String countryOfOffice) {
        this.countryOfOffice = countryOfOffice;
    }

    public String getForeignBankAccountInd() {
        return foreignBankAccountInd;
    }

    public void setForeignBankAccountInd(String foreignBankAccountInd) {
        this.foreignBankAccountInd = foreignBankAccountInd;
    }

    public LocalDate getForeignBankCertDate() {
        return foreignBankCertDate;
    }

    public void setForeignBankCertDate(LocalDate foreignBankCertDate) {
        this.foreignBankCertDate = foreignBankCertDate;
    }

    public LocalDate getForeignBankCertExpDate() {
        return foreignBankCertExpDate;
    }

    public void setForeignBankCertExpDate(LocalDate foreignBankCertExpDate) {
        this.foreignBankCertExpDate = foreignBankCertExpDate;
    }

    public String getCentralBankInd() {
        return centralBankInd;
    }

    public void setCentralBankInd(String centralBankInd) {
        this.centralBankInd = centralBankInd;
    }

    public String getAcctForeignFinancialInst() {
        return acctForeignFinancialInst;
    }

    public void setAcctForeignFinancialInst(String acctForeignFinancialInst) {
        this.acctForeignFinancialInst = acctForeignFinancialInst;
    }

    public String getForeignBankAcctOper1() {
        return foreignBankAcctOper1;
    }

    public void setForeignBankAcctOper1(String foreignBankAcctOper1) {
        this.foreignBankAcctOper1 = foreignBankAcctOper1;
    }

    public String getForeignBankAcctOper2() {
        return foreignBankAcctOper2;
    }

    public void setForeignBankAcctOper2(String foreignBankAcctOper2) {
        this.foreignBankAcctOper2 = foreignBankAcctOper2;
    }

    public String getForeignBankAcctOper3() {
        return foreignBankAcctOper3;
    }

    public void setForeignBankAcctOper3(String foreignBankAcctOper3) {
        this.foreignBankAcctOper3 = foreignBankAcctOper3;
    }

    public String getNumberPeopleOwn() {
        return numberPeopleOwn;
    }

    public void setNumberPeopleOwn(String numberPeopleOwn) {
        this.numberPeopleOwn = numberPeopleOwn;
    }

    public String getProprietaryAcctOwned() {
        return proprietaryAcctOwned;
    }

    public void setProprietaryAcctOwned(String proprietaryAcctOwned) {
        this.proprietaryAcctOwned = proprietaryAcctOwned;
    }

    public String getCampo34() {
        return campo34;
    }

    public void setCampo34(String campo34) {
        this.campo34 = campo34;
    }

    public String getTel1TransactionCode() {
        return tel1TransactionCode;
    }

    public void setTel1TransactionCode(String tel1TransactionCode) {
        this.tel1TransactionCode = tel1TransactionCode;
    }

    public String getTel1UsInd() {
        return tel1UsInd;
    }

    public void setTel1UsInd(String tel1UsInd) {
        this.tel1UsInd = tel1UsInd;
    }

    public String getTel1TypeId() {
        return tel1TypeId;
    }

    public void setTel1TypeId(String tel1TypeId) {
        this.tel1TypeId = tel1TypeId;
    }

    public String getTel1Number() {
        return tel1Number;
    }

    public void setTel1Number(String tel1Number) {
        this.tel1Number = tel1Number;
    }

    public String getTel1Extension() {
        return tel1Extension;
    }

    public void setTel1Extension(String tel1Extension) {
        this.tel1Extension = tel1Extension;
    }

    public String getTel2TransactionCode() {
        return tel2TransactionCode;
    }

    public void setTel2TransactionCode(String tel2TransactionCode) {
        this.tel2TransactionCode = tel2TransactionCode;
    }

    public String getTel2UsInd() {
        return tel2UsInd;
    }

    public void setTel2UsInd(String tel2UsInd) {
        this.tel2UsInd = tel2UsInd;
    }

    public String getTel2TypeId() {
        return tel2TypeId;
    }

    public void setTel2TypeId(String tel2TypeId) {
        this.tel2TypeId = tel2TypeId;
    }

    public String getTel2Number() {
        return tel2Number;
    }

    public void setTel2Number(String tel2Number) {
        this.tel2Number = tel2Number;
    }

    public String getTel2Extension() {
        return tel2Extension;
    }

    public void setTel2Extension(String tel2Extension) {
        this.tel2Extension = tel2Extension;
    }

    public String getTel3TransactionCode() {
        return tel3TransactionCode;
    }

    public void setTel3TransactionCode(String tel3TransactionCode) {
        this.tel3TransactionCode = tel3TransactionCode;
    }

    public String getTel3UsInd() {
        return tel3UsInd;
    }

    public void setTel3UsInd(String tel3UsInd) {
        this.tel3UsInd = tel3UsInd;
    }

    public String getTel3TypeId() {
        return tel3TypeId;
    }

    public void setTel3TypeId(String tel3TypeId) {
        this.tel3TypeId = tel3TypeId;
    }

    public String getTel3Number() {
        return tel3Number;
    }

    public void setTel3Number(String tel3Number) {
        this.tel3Number = tel3Number;
    }

    public String getTel3Extension() {
        return tel3Extension;
    }

    public void setTel3Extension(String tel3Extension) {
        this.tel3Extension = tel3Extension;
    }

    public String getTel4TransactionCode() {
        return tel4TransactionCode;
    }

    public void setTel4TransactionCode(String tel4TransactionCode) {
        this.tel4TransactionCode = tel4TransactionCode;
    }

    public String getTel4UsInd() {
        return tel4UsInd;
    }

    public void setTel4UsInd(String tel4UsInd) {
        this.tel4UsInd = tel4UsInd;
    }

    public String getTel4TypeId() {
        return tel4TypeId;
    }

    public void setTel4TypeId(String tel4TypeId) {
        this.tel4TypeId = tel4TypeId;
    }

    public String getTel4Number() {
        return tel4Number;
    }

    public void setTel4Number(String tel4Number) {
        this.tel4Number = tel4Number;
    }

    public String getTel4Extension() {
        return tel4Extension;
    }

    public void setTel4Extension(String tel4Extension) {
        this.tel4Extension = tel4Extension;
    }

    public String getTel5TransactionCode() {
        return tel5TransactionCode;
    }

    public void setTel5TransactionCode(String tel5TransactionCode) {
        this.tel5TransactionCode = tel5TransactionCode;
    }

    public String getTel5UsInd() {
        return tel5UsInd;
    }

    public void setTel5UsInd(String tel5UsInd) {
        this.tel5UsInd = tel5UsInd;
    }

    public String getTel5TypeId() {
        return tel5TypeId;
    }

    public void setTel5TypeId(String tel5TypeId) {
        this.tel5TypeId = tel5TypeId;
    }

    public String getTel5Number() {
        return tel5Number;
    }

    public void setTel5Number(String tel5Number) {
        this.tel5Number = tel5Number;
    }

    public String getTel5Extension() {
        return tel5Extension;
    }

    public void setTel5Extension(String tel5Extension) {
        this.tel5Extension = tel5Extension;
    }

    public String getTel6TransactionCode() {
        return tel6TransactionCode;
    }

    public void setTel6TransactionCode(String tel6TransactionCode) {
        this.tel6TransactionCode = tel6TransactionCode;
    }

    public String getTel6UsInd() {
        return tel6UsInd;
    }

    public void setTel6UsInd(String tel6UsInd) {
        this.tel6UsInd = tel6UsInd;
    }

    public String getTel6TypeId() {
        return tel6TypeId;
    }

    public void setTel6TypeId(String tel6TypeId) {
        this.tel6TypeId = tel6TypeId;
    }

    public String getTel6Number() {
        return tel6Number;
    }

    public void setTel6Number(String tel6Number) {
        this.tel6Number = tel6Number;
    }

    public String getTel6Extension() {
        return tel6Extension;
    }

    public void setTel6Extension(String tel6Extension) {
        this.tel6Extension = tel6Extension;
    }

    public String getTel7TransactionCode() {
        return tel7TransactionCode;
    }

    public void setTel7TransactionCode(String tel7TransactionCode) {
        this.tel7TransactionCode = tel7TransactionCode;
    }

    public String getTel7UsInd() {
        return tel7UsInd;
    }

    public void setTel7UsInd(String tel7UsInd) {
        this.tel7UsInd = tel7UsInd;
    }

    public String getTel7TypeId() {
        return tel7TypeId;
    }

    public void setTel7TypeId(String tel7TypeId) {
        this.tel7TypeId = tel7TypeId;
    }

    public String getTel7Number() {
        return tel7Number;
    }

    public void setTel7Number(String tel7Number) {
        this.tel7Number = tel7Number;
    }

    public String getTel7Extension() {
        return tel7Extension;
    }

    public void setTel7Extension(String tel7Extension) {
        this.tel7Extension = tel7Extension;
    }

    public String getTel8TransactionCode() {
        return tel8TransactionCode;
    }

    public void setTel8TransactionCode(String tel8TransactionCode) {
        this.tel8TransactionCode = tel8TransactionCode;
    }

    public String getTel8UsInd() {
        return tel8UsInd;
    }

    public void setTel8UsInd(String tel8UsInd) {
        this.tel8UsInd = tel8UsInd;
    }

    public String getTel8TypeId() {
        return tel8TypeId;
    }

    public void setTel8TypeId(String tel8TypeId) {
        this.tel8TypeId = tel8TypeId;
    }

    public String getTel8Number() {
        return tel8Number;
    }

    public void setTel8Number(String tel8Number) {
        this.tel8Number = tel8Number;
    }

    public String getTel8Extension() {
        return tel8Extension;
    }

    public void setTel8Extension(String tel8Extension) {
        this.tel8Extension = tel8Extension;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getExternalPositionInd() {
        return externalPositionInd;
    }

    public void setExternalPositionInd(String externalPositionInd) {
        this.externalPositionInd = externalPositionInd;
    }

    public String getPurgeEligibleInd() {
        return purgeEligibleInd;
    }

    public void setPurgeEligibleInd(String purgeEligibleInd) {
        this.purgeEligibleInd = purgeEligibleInd;
    }

    public String getAdvisoryAcctInd() {
        return advisoryAcctInd;
    }

    public void setAdvisoryAcctInd(String advisoryAcctInd) {
        this.advisoryAcctInd = advisoryAcctInd;
    }

    public String getProductProfileCode() {
        return productProfileCode;
    }

    public void setProductProfileCode(String productProfileCode) {
        this.productProfileCode = productProfileCode;
    }

    public Integer getCentsPerShareDiscount() {
        return centsPerShareDiscount;
    }

    public void setCentsPerShareDiscount(Integer centsPerShareDiscount) {
        this.centsPerShareDiscount = centsPerShareDiscount;
    }

    public String getCampo81() {
        return campo81;
    }

    public void setCampo81(String campo81) {
        this.campo81 = campo81;
    }

    public LocalDate getOptionDisclosureDate() {
        return optionDisclosureDate;
    }

    public void setOptionDisclosureDate(LocalDate optionDisclosureDate) {
        this.optionDisclosureDate = optionDisclosureDate;
    }

    public String getCampo83() {
        return campo83;
    }

    public void setCampo83(String campo83) {
        this.campo83 = campo83;
    }

    public String getCountryAcctLevelTaxResidency() {
        return countryAcctLevelTaxResidency;
    }

    public void setCountryAcctLevelTaxResidency(String countryAcctLevelTaxResidency) {
        this.countryAcctLevelTaxResidency = countryAcctLevelTaxResidency;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}