package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_acct_reg_c", schema = "stage_pershing")
public class StageAcctRegC {
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
    @Column(name = "addr_1_trx_code", length = 100)
    private String addr1TrxCode;

    @Size(max = 100)
    @Column(name = "addr_1_special_handling_ind", length = 100)
    private String addr1SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_1_delivery_id", length = 100)
    private String addr1DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_1_attention_line_prefix", length = 100)
    private String addr1AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_1_attention_line_detail", length = 100)
    private String addr1AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_1_line_1", length = 100)
    private String addr1Line1;

    @Size(max = 100)
    @Column(name = "addr_1_line_2", length = 100)
    private String addr1Line2;

    @Size(max = 100)
    @Column(name = "addr_1_line_3", length = 100)
    private String addr1Line3;

    @Size(max = 100)
    @Column(name = "addr_1_line_4", length = 100)
    private String addr1Line4;

    @Size(max = 100)
    @Column(name = "addr_1_city_state", length = 100)
    private String addr1CityState;

    @Size(max = 100)
    @Column(name = "addr_1_country_code", length = 100)
    private String addr1CountryCode;

    @Size(max = 100)
    @Column(name = "campo_21", length = 100)
    private String campo21;

    @Size(max = 100)
    @Column(name = "campo_22", length = 100)
    private String campo22;

    @Size(max = 100)
    @Column(name = "campo_23", length = 100)
    private String campo23;

    @Size(max = 100)
    @Column(name = "campo_24", length = 100)
    private String campo24;

    @Size(max = 100)
    @Column(name = "campo_25", length = 100)
    private String campo25;

    @Size(max = 100)
    @Column(name = "campo_26", length = 100)
    private String campo26;

    @Size(max = 100)
    @Column(name = "campo_27", length = 100)
    private String campo27;

    @Size(max = 100)
    @Column(name = "campo_28", length = 100)
    private String campo28;

    @Size(max = 100)
    @Column(name = "campo_29", length = 100)
    private String campo29;

    @Size(max = 100)
    @Column(name = "campo_30", length = 100)
    private String campo30;

    @Size(max = 100)
    @Column(name = "addr_2_trx_code", length = 100)
    private String addr2TrxCode;

    @Size(max = 100)
    @Column(name = "addr_2_special_handling_ind", length = 100)
    private String addr2SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_2_delivery_id", length = 100)
    private String addr2DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_2_attention_line_prefix", length = 100)
    private String addr2AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_2_attention_line_detail", length = 100)
    private String addr2AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_2_line_1", length = 100)
    private String addr2Line1;

    @Size(max = 100)
    @Column(name = "addr_2_line_2", length = 100)
    private String addr2Line2;

    @Size(max = 100)
    @Column(name = "addr_2_line_3", length = 100)
    private String addr2Line3;

    @Size(max = 100)
    @Column(name = "addr_2_line_4", length = 100)
    private String addr2Line4;

    @Size(max = 100)
    @Column(name = "addr_2_city_state", length = 100)
    private String addr2CityState;

    @Size(max = 100)
    @Column(name = "addr_2_country_code", length = 100)
    private String addr2CountryCode;

    @Size(max = 100)
    @Column(name = "account_description", length = 100)
    private String accountDescription;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_2_ind", length = 100)
    private String setAsMailAddr2Ind;

    @Size(max = 100)
    @Column(name = "campo_44", length = 100)
    private String campo44;

    @Column(name = "principal_billing_allocation_pct", precision = 45, scale = 20)
    private BigDecimal principalBillingAllocationPct;

    @Size(max = 100)
    @Column(name = "campo_46", length = 100)
    private String campo46;

    @Size(max = 100)
    @Column(name = "seasonal_addr_id_1", length = 100)
    private String seasonalAddrId1;

    @Column(name = "from_date_1")
    private LocalDate fromDate1;

    @Column(name = "to_date_1")
    private LocalDate toDate1;

    @Size(max = 100)
    @Column(name = "seasonal_addr_id_2", length = 100)
    private String seasonalAddrId2;

    @Column(name = "from_date_2")
    private LocalDate fromDate2;

    @Column(name = "to_date_2")
    private LocalDate toDate2;

    @Size(max = 100)
    @Column(name = "seasonal_addr_id_3", length = 100)
    private String seasonalAddrId3;

    @Column(name = "from_date_3")
    private LocalDate fromDate3;

    @Column(name = "to_date_3")
    private LocalDate toDate3;

    @Size(max = 100)
    @Column(name = "cost_basis_acct_system", length = 100)
    private String costBasisAcctSystem;

    @Size(max = 100)
    @Column(name = "disposition_method_mutual_funds", length = 100)
    private String dispositionMethodMutualFunds;

    @Size(max = 100)
    @Column(name = "disposition_method_other", length = 100)
    private String dispositionMethodOther;

    @Size(max = 100)
    @Column(name = "disposition_method_stocks", length = 100)
    private String dispositionMethodStocks;

    @Size(max = 100)
    @Column(name = "campo_60", length = 100)
    private String campo60;

    @Size(max = 100)
    @Column(name = "amortize_taxable_premium_bonds", length = 100)
    private String amortizeTaxablePremiumBonds;

    @Size(max = 100)
    @Column(name = "accrue_market_disc_based_on", length = 100)
    private String accrueMarketDiscBasedOn;

    @Size(max = 100)
    @Column(name = "accrue_market_disc_income", length = 100)
    private String accrueMarketDiscIncome;

    @Size(max = 100)
    @Column(name = "campo_64", length = 100)
    private String campo64;

    @Size(max = 100)
    @Column(name = "campo_65", length = 100)
    private String campo65;

    @Size(max = 100)
    @Column(name = "campo_66", length = 100)
    private String campo66;

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

    public String getAddr1TrxCode() {
        return addr1TrxCode;
    }

    public void setAddr1TrxCode(String addr1TrxCode) {
        this.addr1TrxCode = addr1TrxCode;
    }

    public String getAddr1SpecialHandlingInd() {
        return addr1SpecialHandlingInd;
    }

    public void setAddr1SpecialHandlingInd(String addr1SpecialHandlingInd) {
        this.addr1SpecialHandlingInd = addr1SpecialHandlingInd;
    }

    public String getAddr1DeliveryId() {
        return addr1DeliveryId;
    }

    public void setAddr1DeliveryId(String addr1DeliveryId) {
        this.addr1DeliveryId = addr1DeliveryId;
    }

    public String getAddr1AttentionLinePrefix() {
        return addr1AttentionLinePrefix;
    }

    public void setAddr1AttentionLinePrefix(String addr1AttentionLinePrefix) {
        this.addr1AttentionLinePrefix = addr1AttentionLinePrefix;
    }

    public String getAddr1AttentionLineDetail() {
        return addr1AttentionLineDetail;
    }

    public void setAddr1AttentionLineDetail(String addr1AttentionLineDetail) {
        this.addr1AttentionLineDetail = addr1AttentionLineDetail;
    }

    public String getAddr1Line1() {
        return addr1Line1;
    }

    public void setAddr1Line1(String addr1Line1) {
        this.addr1Line1 = addr1Line1;
    }

    public String getAddr1Line2() {
        return addr1Line2;
    }

    public void setAddr1Line2(String addr1Line2) {
        this.addr1Line2 = addr1Line2;
    }

    public String getAddr1Line3() {
        return addr1Line3;
    }

    public void setAddr1Line3(String addr1Line3) {
        this.addr1Line3 = addr1Line3;
    }

    public String getAddr1Line4() {
        return addr1Line4;
    }

    public void setAddr1Line4(String addr1Line4) {
        this.addr1Line4 = addr1Line4;
    }

    public String getAddr1CityState() {
        return addr1CityState;
    }

    public void setAddr1CityState(String addr1CityState) {
        this.addr1CityState = addr1CityState;
    }

    public String getAddr1CountryCode() {
        return addr1CountryCode;
    }

    public void setAddr1CountryCode(String addr1CountryCode) {
        this.addr1CountryCode = addr1CountryCode;
    }

    public String getCampo21() {
        return campo21;
    }

    public void setCampo21(String campo21) {
        this.campo21 = campo21;
    }

    public String getCampo22() {
        return campo22;
    }

    public void setCampo22(String campo22) {
        this.campo22 = campo22;
    }

    public String getCampo23() {
        return campo23;
    }

    public void setCampo23(String campo23) {
        this.campo23 = campo23;
    }

    public String getCampo24() {
        return campo24;
    }

    public void setCampo24(String campo24) {
        this.campo24 = campo24;
    }

    public String getCampo25() {
        return campo25;
    }

    public void setCampo25(String campo25) {
        this.campo25 = campo25;
    }

    public String getCampo26() {
        return campo26;
    }

    public void setCampo26(String campo26) {
        this.campo26 = campo26;
    }

    public String getCampo27() {
        return campo27;
    }

    public void setCampo27(String campo27) {
        this.campo27 = campo27;
    }

    public String getCampo28() {
        return campo28;
    }

    public void setCampo28(String campo28) {
        this.campo28 = campo28;
    }

    public String getCampo29() {
        return campo29;
    }

    public void setCampo29(String campo29) {
        this.campo29 = campo29;
    }

    public String getCampo30() {
        return campo30;
    }

    public void setCampo30(String campo30) {
        this.campo30 = campo30;
    }

    public String getAddr2TrxCode() {
        return addr2TrxCode;
    }

    public void setAddr2TrxCode(String addr2TrxCode) {
        this.addr2TrxCode = addr2TrxCode;
    }

    public String getAddr2SpecialHandlingInd() {
        return addr2SpecialHandlingInd;
    }

    public void setAddr2SpecialHandlingInd(String addr2SpecialHandlingInd) {
        this.addr2SpecialHandlingInd = addr2SpecialHandlingInd;
    }

    public String getAddr2DeliveryId() {
        return addr2DeliveryId;
    }

    public void setAddr2DeliveryId(String addr2DeliveryId) {
        this.addr2DeliveryId = addr2DeliveryId;
    }

    public String getAddr2AttentionLinePrefix() {
        return addr2AttentionLinePrefix;
    }

    public void setAddr2AttentionLinePrefix(String addr2AttentionLinePrefix) {
        this.addr2AttentionLinePrefix = addr2AttentionLinePrefix;
    }

    public String getAddr2AttentionLineDetail() {
        return addr2AttentionLineDetail;
    }

    public void setAddr2AttentionLineDetail(String addr2AttentionLineDetail) {
        this.addr2AttentionLineDetail = addr2AttentionLineDetail;
    }

    public String getAddr2Line1() {
        return addr2Line1;
    }

    public void setAddr2Line1(String addr2Line1) {
        this.addr2Line1 = addr2Line1;
    }

    public String getAddr2Line2() {
        return addr2Line2;
    }

    public void setAddr2Line2(String addr2Line2) {
        this.addr2Line2 = addr2Line2;
    }

    public String getAddr2Line3() {
        return addr2Line3;
    }

    public void setAddr2Line3(String addr2Line3) {
        this.addr2Line3 = addr2Line3;
    }

    public String getAddr2Line4() {
        return addr2Line4;
    }

    public void setAddr2Line4(String addr2Line4) {
        this.addr2Line4 = addr2Line4;
    }

    public String getAddr2CityState() {
        return addr2CityState;
    }

    public void setAddr2CityState(String addr2CityState) {
        this.addr2CityState = addr2CityState;
    }

    public String getAddr2CountryCode() {
        return addr2CountryCode;
    }

    public void setAddr2CountryCode(String addr2CountryCode) {
        this.addr2CountryCode = addr2CountryCode;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public String getSetAsMailAddr2Ind() {
        return setAsMailAddr2Ind;
    }

    public void setSetAsMailAddr2Ind(String setAsMailAddr2Ind) {
        this.setAsMailAddr2Ind = setAsMailAddr2Ind;
    }

    public String getCampo44() {
        return campo44;
    }

    public void setCampo44(String campo44) {
        this.campo44 = campo44;
    }

    public BigDecimal getPrincipalBillingAllocationPct() {
        return principalBillingAllocationPct;
    }

    public void setPrincipalBillingAllocationPct(BigDecimal principalBillingAllocationPct) {
        this.principalBillingAllocationPct = principalBillingAllocationPct;
    }

    public String getCampo46() {
        return campo46;
    }

    public void setCampo46(String campo46) {
        this.campo46 = campo46;
    }

    public String getSeasonalAddrId1() {
        return seasonalAddrId1;
    }

    public void setSeasonalAddrId1(String seasonalAddrId1) {
        this.seasonalAddrId1 = seasonalAddrId1;
    }

    public LocalDate getFromDate1() {
        return fromDate1;
    }

    public void setFromDate1(LocalDate fromDate1) {
        this.fromDate1 = fromDate1;
    }

    public LocalDate getToDate1() {
        return toDate1;
    }

    public void setToDate1(LocalDate toDate1) {
        this.toDate1 = toDate1;
    }

    public String getSeasonalAddrId2() {
        return seasonalAddrId2;
    }

    public void setSeasonalAddrId2(String seasonalAddrId2) {
        this.seasonalAddrId2 = seasonalAddrId2;
    }

    public LocalDate getFromDate2() {
        return fromDate2;
    }

    public void setFromDate2(LocalDate fromDate2) {
        this.fromDate2 = fromDate2;
    }

    public LocalDate getToDate2() {
        return toDate2;
    }

    public void setToDate2(LocalDate toDate2) {
        this.toDate2 = toDate2;
    }

    public String getSeasonalAddrId3() {
        return seasonalAddrId3;
    }

    public void setSeasonalAddrId3(String seasonalAddrId3) {
        this.seasonalAddrId3 = seasonalAddrId3;
    }

    public LocalDate getFromDate3() {
        return fromDate3;
    }

    public void setFromDate3(LocalDate fromDate3) {
        this.fromDate3 = fromDate3;
    }

    public LocalDate getToDate3() {
        return toDate3;
    }

    public void setToDate3(LocalDate toDate3) {
        this.toDate3 = toDate3;
    }

    public String getCostBasisAcctSystem() {
        return costBasisAcctSystem;
    }

    public void setCostBasisAcctSystem(String costBasisAcctSystem) {
        this.costBasisAcctSystem = costBasisAcctSystem;
    }

    public String getDispositionMethodMutualFunds() {
        return dispositionMethodMutualFunds;
    }

    public void setDispositionMethodMutualFunds(String dispositionMethodMutualFunds) {
        this.dispositionMethodMutualFunds = dispositionMethodMutualFunds;
    }

    public String getDispositionMethodOther() {
        return dispositionMethodOther;
    }

    public void setDispositionMethodOther(String dispositionMethodOther) {
        this.dispositionMethodOther = dispositionMethodOther;
    }

    public String getDispositionMethodStocks() {
        return dispositionMethodStocks;
    }

    public void setDispositionMethodStocks(String dispositionMethodStocks) {
        this.dispositionMethodStocks = dispositionMethodStocks;
    }

    public String getCampo60() {
        return campo60;
    }

    public void setCampo60(String campo60) {
        this.campo60 = campo60;
    }

    public String getAmortizeTaxablePremiumBonds() {
        return amortizeTaxablePremiumBonds;
    }

    public void setAmortizeTaxablePremiumBonds(String amortizeTaxablePremiumBonds) {
        this.amortizeTaxablePremiumBonds = amortizeTaxablePremiumBonds;
    }

    public String getAccrueMarketDiscBasedOn() {
        return accrueMarketDiscBasedOn;
    }

    public void setAccrueMarketDiscBasedOn(String accrueMarketDiscBasedOn) {
        this.accrueMarketDiscBasedOn = accrueMarketDiscBasedOn;
    }

    public String getAccrueMarketDiscIncome() {
        return accrueMarketDiscIncome;
    }

    public void setAccrueMarketDiscIncome(String accrueMarketDiscIncome) {
        this.accrueMarketDiscIncome = accrueMarketDiscIncome;
    }

    public String getCampo64() {
        return campo64;
    }

    public void setCampo64(String campo64) {
        this.campo64 = campo64;
    }

    public String getCampo65() {
        return campo65;
    }

    public void setCampo65(String campo65) {
        this.campo65 = campo65;
    }

    public String getCampo66() {
        return campo66;
    }

    public void setCampo66(String campo66) {
        this.campo66 = campo66;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}