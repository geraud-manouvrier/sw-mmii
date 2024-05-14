package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_acct_reg_f", schema = "stage_pershing")
public class StageAcctRegF {
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
    @Column(name = "addr_7_trx_code", length = 100)
    private String addr7TrxCode;

    @Size(max = 100)
    @Column(name = "addr_7_special_handling_ind", length = 100)
    private String addr7SpecialHandlingInd;

    @Size(max = 100)
    @Column(name = "addr_7_delivery_id", length = 100)
    private String addr7DeliveryId;

    @Size(max = 100)
    @Column(name = "addr_7_attention_line_prefix", length = 100)
    private String addr7AttentionLinePrefix;

    @Size(max = 100)
    @Column(name = "addr_7_attention_line_detail", length = 100)
    private String addr7AttentionLineDetail;

    @Size(max = 100)
    @Column(name = "addr_7_line_1", length = 100)
    private String addr7Line1;

    @Size(max = 100)
    @Column(name = "addr_7_line_2", length = 100)
    private String addr7Line2;

    @Size(max = 100)
    @Column(name = "addr_7_line_3", length = 100)
    private String addr7Line3;

    @Size(max = 100)
    @Column(name = "addr_7_line_4", length = 100)
    private String addr7Line4;

    @Size(max = 100)
    @Column(name = "addr_7_city_state", length = 100)
    private String addr7CityState;

    @Size(max = 100)
    @Column(name = "addr_7_country_code", length = 100)
    private String addr7CountryCode;

    @Size(max = 100)
    @Column(name = "set_as_mail_addr_7_ind", length = 100)
    private String setAsMailAddr7Ind;

    @Size(max = 100)
    @Column(name = "campo_22", length = 100)
    private String campo22;

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

    public String getAddr7TrxCode() {
        return addr7TrxCode;
    }

    public void setAddr7TrxCode(String addr7TrxCode) {
        this.addr7TrxCode = addr7TrxCode;
    }

    public String getAddr7SpecialHandlingInd() {
        return addr7SpecialHandlingInd;
    }

    public void setAddr7SpecialHandlingInd(String addr7SpecialHandlingInd) {
        this.addr7SpecialHandlingInd = addr7SpecialHandlingInd;
    }

    public String getAddr7DeliveryId() {
        return addr7DeliveryId;
    }

    public void setAddr7DeliveryId(String addr7DeliveryId) {
        this.addr7DeliveryId = addr7DeliveryId;
    }

    public String getAddr7AttentionLinePrefix() {
        return addr7AttentionLinePrefix;
    }

    public void setAddr7AttentionLinePrefix(String addr7AttentionLinePrefix) {
        this.addr7AttentionLinePrefix = addr7AttentionLinePrefix;
    }

    public String getAddr7AttentionLineDetail() {
        return addr7AttentionLineDetail;
    }

    public void setAddr7AttentionLineDetail(String addr7AttentionLineDetail) {
        this.addr7AttentionLineDetail = addr7AttentionLineDetail;
    }

    public String getAddr7Line1() {
        return addr7Line1;
    }

    public void setAddr7Line1(String addr7Line1) {
        this.addr7Line1 = addr7Line1;
    }

    public String getAddr7Line2() {
        return addr7Line2;
    }

    public void setAddr7Line2(String addr7Line2) {
        this.addr7Line2 = addr7Line2;
    }

    public String getAddr7Line3() {
        return addr7Line3;
    }

    public void setAddr7Line3(String addr7Line3) {
        this.addr7Line3 = addr7Line3;
    }

    public String getAddr7Line4() {
        return addr7Line4;
    }

    public void setAddr7Line4(String addr7Line4) {
        this.addr7Line4 = addr7Line4;
    }

    public String getAddr7CityState() {
        return addr7CityState;
    }

    public void setAddr7CityState(String addr7CityState) {
        this.addr7CityState = addr7CityState;
    }

    public String getAddr7CountryCode() {
        return addr7CountryCode;
    }

    public void setAddr7CountryCode(String addr7CountryCode) {
        this.addr7CountryCode = addr7CountryCode;
    }

    public String getSetAsMailAddr7Ind() {
        return setAsMailAddr7Ind;
    }

    public void setSetAsMailAddr7Ind(String setAsMailAddr7Ind) {
        this.setAsMailAddr7Ind = setAsMailAddr7Ind;
    }

    public String getCampo22() {
        return campo22;
    }

    public void setCampo22(String campo22) {
        this.campo22 = campo22;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}