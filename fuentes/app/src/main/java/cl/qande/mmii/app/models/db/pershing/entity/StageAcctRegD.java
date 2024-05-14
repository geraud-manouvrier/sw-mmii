package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_acct_reg_d", schema = "stage_pershing")
public class StageAcctRegD {
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
    @Column(name = "addr_3_trx_code", length = 100)
    private String addr3TrxCode;

    @Size(max = 100)
    @Column(name = "addr_3_special_handling_ind", length = 100)
    private String addr3SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_3_delivery_id", length = 100)
    private String addr3DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_3_attention_line_prefix", length = 100)
    private String addr3AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_3_attention_line_detail", length = 100)
    private String addr3AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_3_line_1", length = 100)
    private String addr3Line1;

    @Size(max = 100)
    @Column(name = "addr_3_line_2", length = 100)
    private String addr3Line2;

    @Size(max = 100)
    @Column(name = "addr_3_line_3", length = 100)
    private String addr3Line3;

    @Size(max = 100)
    @Column(name = "addr_3_line_4", length = 100)
    private String addr3Line4;

    @Size(max = 100)
    @Column(name = "addr_3_city_state", length = 100)
    private String addr3CityState;

    @Size(max = 100)
    @Column(name = "addr_3_country_code", length = 100)
    private String addr3CountryCode;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_3_ind", length = 100)
    private String setAsMailAddr3Ind;

    @Size(max = 100)
    @Column(name = "campo_22", length = 100)
    private String campo22;

    @Size(max = 100)
    @Column(name = "addr_4_trx_code", length = 100)
    private String addr4TrxCode;

    @Size(max = 100)
    @Column(name = "addr_4_special_handling_ind", length = 100)
    private String addr4SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_4_delivery_id", length = 100)
    private String addr4DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_4_attention_line_prefix", length = 100)
    private String addr4AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_4_attention_line_detail", length = 100)
    private String addr4AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_4_line_1", length = 100)
    private String addr4Line1;

    @Size(max = 100)
    @Column(name = "addr_4_line_2", length = 100)
    private String addr4Line2;

    @Size(max = 100)
    @Column(name = "addr_4_line_3", length = 100)
    private String addr4Line3;

    @Size(max = 100)
    @Column(name = "addr_4_line_4", length = 100)
    private String addr4Line4;

    @Size(max = 100)
    @Column(name = "addr_4_city_state", length = 100)
    private String addr4CityState;

    @Size(max = 100)
    @Column(name = "addr_4_country_code", length = 100)
    private String addr4CountryCode;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_4_ind", length = 100)
    private String setAsMailAddr4Ind;

    @Size(max = 100)
    @Column(name = "campo_35", length = 100)
    private String campo35;

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

    public String getAddr3TrxCode() {
        return addr3TrxCode;
    }

    public void setAddr3TrxCode(String addr3TrxCode) {
        this.addr3TrxCode = addr3TrxCode;
    }

    public String getAddr3SpecialHandlingInd() {
        return addr3SpecialHandlingInd;
    }

    public void setAddr3SpecialHandlingInd(String addr3SpecialHandlingInd) {
        this.addr3SpecialHandlingInd = addr3SpecialHandlingInd;
    }

    public String getAddr3DeliveryId() {
        return addr3DeliveryId;
    }

    public void setAddr3DeliveryId(String addr3DeliveryId) {
        this.addr3DeliveryId = addr3DeliveryId;
    }

    public String getAddr3AttentionLinePrefix() {
        return addr3AttentionLinePrefix;
    }

    public void setAddr3AttentionLinePrefix(String addr3AttentionLinePrefix) {
        this.addr3AttentionLinePrefix = addr3AttentionLinePrefix;
    }

    public String getAddr3AttentionLineDetail() {
        return addr3AttentionLineDetail;
    }

    public void setAddr3AttentionLineDetail(String addr3AttentionLineDetail) {
        this.addr3AttentionLineDetail = addr3AttentionLineDetail;
    }

    public String getAddr3Line1() {
        return addr3Line1;
    }

    public void setAddr3Line1(String addr3Line1) {
        this.addr3Line1 = addr3Line1;
    }

    public String getAddr3Line2() {
        return addr3Line2;
    }

    public void setAddr3Line2(String addr3Line2) {
        this.addr3Line2 = addr3Line2;
    }

    public String getAddr3Line3() {
        return addr3Line3;
    }

    public void setAddr3Line3(String addr3Line3) {
        this.addr3Line3 = addr3Line3;
    }

    public String getAddr3Line4() {
        return addr3Line4;
    }

    public void setAddr3Line4(String addr3Line4) {
        this.addr3Line4 = addr3Line4;
    }

    public String getAddr3CityState() {
        return addr3CityState;
    }

    public void setAddr3CityState(String addr3CityState) {
        this.addr3CityState = addr3CityState;
    }

    public String getAddr3CountryCode() {
        return addr3CountryCode;
    }

    public void setAddr3CountryCode(String addr3CountryCode) {
        this.addr3CountryCode = addr3CountryCode;
    }

    public String getSetAsMailAddr3Ind() {
        return setAsMailAddr3Ind;
    }

    public void setSetAsMailAddr3Ind(String setAsMailAddr3Ind) {
        this.setAsMailAddr3Ind = setAsMailAddr3Ind;
    }

    public String getCampo22() {
        return campo22;
    }

    public void setCampo22(String campo22) {
        this.campo22 = campo22;
    }

    public String getAddr4TrxCode() {
        return addr4TrxCode;
    }

    public void setAddr4TrxCode(String addr4TrxCode) {
        this.addr4TrxCode = addr4TrxCode;
    }

    public String getAddr4SpecialHandlingInd() {
        return addr4SpecialHandlingInd;
    }

    public void setAddr4SpecialHandlingInd(String addr4SpecialHandlingInd) {
        this.addr4SpecialHandlingInd = addr4SpecialHandlingInd;
    }

    public String getAddr4DeliveryId() {
        return addr4DeliveryId;
    }

    public void setAddr4DeliveryId(String addr4DeliveryId) {
        this.addr4DeliveryId = addr4DeliveryId;
    }

    public String getAddr4AttentionLinePrefix() {
        return addr4AttentionLinePrefix;
    }

    public void setAddr4AttentionLinePrefix(String addr4AttentionLinePrefix) {
        this.addr4AttentionLinePrefix = addr4AttentionLinePrefix;
    }

    public String getAddr4AttentionLineDetail() {
        return addr4AttentionLineDetail;
    }

    public void setAddr4AttentionLineDetail(String addr4AttentionLineDetail) {
        this.addr4AttentionLineDetail = addr4AttentionLineDetail;
    }

    public String getAddr4Line1() {
        return addr4Line1;
    }

    public void setAddr4Line1(String addr4Line1) {
        this.addr4Line1 = addr4Line1;
    }

    public String getAddr4Line2() {
        return addr4Line2;
    }

    public void setAddr4Line2(String addr4Line2) {
        this.addr4Line2 = addr4Line2;
    }

    public String getAddr4Line3() {
        return addr4Line3;
    }

    public void setAddr4Line3(String addr4Line3) {
        this.addr4Line3 = addr4Line3;
    }

    public String getAddr4Line4() {
        return addr4Line4;
    }

    public void setAddr4Line4(String addr4Line4) {
        this.addr4Line4 = addr4Line4;
    }

    public String getAddr4CityState() {
        return addr4CityState;
    }

    public void setAddr4CityState(String addr4CityState) {
        this.addr4CityState = addr4CityState;
    }

    public String getAddr4CountryCode() {
        return addr4CountryCode;
    }

    public void setAddr4CountryCode(String addr4CountryCode) {
        this.addr4CountryCode = addr4CountryCode;
    }

    public String getSetAsMailAddr4Ind() {
        return setAsMailAddr4Ind;
    }

    public void setSetAsMailAddr4Ind(String setAsMailAddr4Ind) {
        this.setAsMailAddr4Ind = setAsMailAddr4Ind;
    }

    public String getCampo35() {
        return campo35;
    }

    public void setCampo35(String campo35) {
        this.campo35 = campo35;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}