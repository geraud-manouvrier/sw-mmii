package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_acct_reg_e", schema = "stage_pershing")
public class StageAcctRegE {
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
    @Column(name = "addr_5_trx_code", length = 100)
    private String addr5TrxCode;

    @Size(max = 100)
    @Column(name = "addr_5_special_handling_ind", length = 100)
    private String addr5SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_5_delivery_id", length = 100)
    private String addr5DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_5_attention_line_prefix", length = 100)
    private String addr5AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_5_attention_line_detail", length = 100)
    private String addr5AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_5_line_1", length = 100)
    private String addr5Line1;

    @Size(max = 100)
    @Column(name = "addr_5_line_2", length = 100)
    private String addr5Line2;

    @Size(max = 100)
    @Column(name = "addr_5_line_3", length = 100)
    private String addr5Line3;

    @Size(max = 100)
    @Column(name = "addr_5_line_4", length = 100)
    private String addr5Line4;

    @Size(max = 100)
    @Column(name = "addr_5_city_state", length = 100)
    private String addr5CityState;

    @Size(max = 100)
    @Column(name = "addr_5_country_code", length = 100)
    private String addr5CountryCode;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_5_ind", length = 100)
    private String setAsMailAddr5Ind;

    @Size(max = 100)
    @Column(name = "campo_22", length = 100)
    private String campo22;

    @Size(max = 100)
    @Column(name = "addr_6_trx_code", length = 100)
    private String addr6TrxCode;

    @Size(max = 100)
    @Column(name = "addr_6_special_handling_ind", length = 100)
    private String addr6SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_6_delivery_id", length = 100)
    private String addr6DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_6_attention_line_prefix", length = 100)
    private String addr6AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_6_attention_line_detail", length = 100)
    private String addr6AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_6_line_1", length = 100)
    private String addr6Line1;

    @Size(max = 100)
    @Column(name = "addr_6_line_2", length = 100)
    private String addr6Line2;

    @Size(max = 100)
    @Column(name = "addr_6_line_3", length = 100)
    private String addr6Line3;

    @Size(max = 100)
    @Column(name = "addr_6_line_4", length = 100)
    private String addr6Line4;

    @Size(max = 100)
    @Column(name = "addr_6_city_state", length = 100)
    private String addr6CityState;

    @Size(max = 100)
    @Column(name = "addr_6_country_code", length = 100)
    private String addr6CountryCode;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_6_ind", length = 100)
    private String setAsMailAddr6Ind;

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

    public String getAddr5TrxCode() {
        return addr5TrxCode;
    }

    public void setAddr5TrxCode(String addr5TrxCode) {
        this.addr5TrxCode = addr5TrxCode;
    }

    public String getAddr5SpecialHandlingInd() {
        return addr5SpecialHandlingInd;
    }

    public void setAddr5SpecialHandlingInd(String addr5SpecialHandlingInd) {
        this.addr5SpecialHandlingInd = addr5SpecialHandlingInd;
    }

    public String getAddr5DeliveryId() {
        return addr5DeliveryId;
    }

    public void setAddr5DeliveryId(String addr5DeliveryId) {
        this.addr5DeliveryId = addr5DeliveryId;
    }

    public String getAddr5AttentionLinePrefix() {
        return addr5AttentionLinePrefix;
    }

    public void setAddr5AttentionLinePrefix(String addr5AttentionLinePrefix) {
        this.addr5AttentionLinePrefix = addr5AttentionLinePrefix;
    }

    public String getAddr5AttentionLineDetail() {
        return addr5AttentionLineDetail;
    }

    public void setAddr5AttentionLineDetail(String addr5AttentionLineDetail) {
        this.addr5AttentionLineDetail = addr5AttentionLineDetail;
    }

    public String getAddr5Line1() {
        return addr5Line1;
    }

    public void setAddr5Line1(String addr5Line1) {
        this.addr5Line1 = addr5Line1;
    }

    public String getAddr5Line2() {
        return addr5Line2;
    }

    public void setAddr5Line2(String addr5Line2) {
        this.addr5Line2 = addr5Line2;
    }

    public String getAddr5Line3() {
        return addr5Line3;
    }

    public void setAddr5Line3(String addr5Line3) {
        this.addr5Line3 = addr5Line3;
    }

    public String getAddr5Line4() {
        return addr5Line4;
    }

    public void setAddr5Line4(String addr5Line4) {
        this.addr5Line4 = addr5Line4;
    }

    public String getAddr5CityState() {
        return addr5CityState;
    }

    public void setAddr5CityState(String addr5CityState) {
        this.addr5CityState = addr5CityState;
    }

    public String getAddr5CountryCode() {
        return addr5CountryCode;
    }

    public void setAddr5CountryCode(String addr5CountryCode) {
        this.addr5CountryCode = addr5CountryCode;
    }

    public String getSetAsMailAddr5Ind() {
        return setAsMailAddr5Ind;
    }

    public void setSetAsMailAddr5Ind(String setAsMailAddr5Ind) {
        this.setAsMailAddr5Ind = setAsMailAddr5Ind;
    }

    public String getCampo22() {
        return campo22;
    }

    public void setCampo22(String campo22) {
        this.campo22 = campo22;
    }

    public String getAddr6TrxCode() {
        return addr6TrxCode;
    }

    public void setAddr6TrxCode(String addr6TrxCode) {
        this.addr6TrxCode = addr6TrxCode;
    }

    public String getAddr6SpecialHandlingInd() {
        return addr6SpecialHandlingInd;
    }

    public void setAddr6SpecialHandlingInd(String addr6SpecialHandlingInd) {
        this.addr6SpecialHandlingInd = addr6SpecialHandlingInd;
    }

    public String getAddr6DeliveryId() {
        return addr6DeliveryId;
    }

    public void setAddr6DeliveryId(String addr6DeliveryId) {
        this.addr6DeliveryId = addr6DeliveryId;
    }

    public String getAddr6AttentionLinePrefix() {
        return addr6AttentionLinePrefix;
    }

    public void setAddr6AttentionLinePrefix(String addr6AttentionLinePrefix) {
        this.addr6AttentionLinePrefix = addr6AttentionLinePrefix;
    }

    public String getAddr6AttentionLineDetail() {
        return addr6AttentionLineDetail;
    }

    public void setAddr6AttentionLineDetail(String addr6AttentionLineDetail) {
        this.addr6AttentionLineDetail = addr6AttentionLineDetail;
    }

    public String getAddr6Line1() {
        return addr6Line1;
    }

    public void setAddr6Line1(String addr6Line1) {
        this.addr6Line1 = addr6Line1;
    }

    public String getAddr6Line2() {
        return addr6Line2;
    }

    public void setAddr6Line2(String addr6Line2) {
        this.addr6Line2 = addr6Line2;
    }

    public String getAddr6Line3() {
        return addr6Line3;
    }

    public void setAddr6Line3(String addr6Line3) {
        this.addr6Line3 = addr6Line3;
    }

    public String getAddr6Line4() {
        return addr6Line4;
    }

    public void setAddr6Line4(String addr6Line4) {
        this.addr6Line4 = addr6Line4;
    }

    public String getAddr6CityState() {
        return addr6CityState;
    }

    public void setAddr6CityState(String addr6CityState) {
        this.addr6CityState = addr6CityState;
    }

    public String getAddr6CountryCode() {
        return addr6CountryCode;
    }

    public void setAddr6CountryCode(String addr6CountryCode) {
        this.addr6CountryCode = addr6CountryCode;
    }

    public String getSetAsMailAddr6Ind() {
        return setAsMailAddr6Ind;
    }

    public void setSetAsMailAddr6Ind(String setAsMailAddr6Ind) {
        this.setAsMailAddr6Ind = setAsMailAddr6Ind;
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