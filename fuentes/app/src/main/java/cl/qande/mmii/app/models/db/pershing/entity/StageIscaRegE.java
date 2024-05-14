package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "stage_isca_reg_e", schema = "stage_pershing")
public class StageIscaRegE {
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
    @Column(name = "record_indicator", length = 100)
    private String recordIndicator;

    @Column(name = "record_id_sequence_number")
    private Integer recordIdSequenceNumber;

    @Size(max = 100)
    @Column(name = "cusip_number", length = 100)
    private String cusipNumber;

    @Size(max = 100)
    @Column(name = "campo_4", length = 100)
    private String campo4;

    @Column(name = "exp_first_call_price", precision = 45, scale = 20)
    private BigDecimal expFirstCallPrice;

    @Column(name = "exp_first_par_call_price", precision = 45, scale = 20)
    private BigDecimal expFirstParCallPrice;

    @Column(name = "exp_put_price", precision = 45, scale = 20)
    private BigDecimal expPutPrice;

    @Column(name = "exp_second_premium_call_price", precision = 45, scale = 20)
    private BigDecimal expSecondPremiumCallPrice;

    @Size(max = 100)
    @Column(name = "name_issuer_security", length = 100)
    private String nameIssuerSecurity;

    @Size(max = 100)
    @Column(name = "issuing_currency", length = 100)
    private String issuingCurrency;

    @Size(max = 100)
    @Column(name = "globally_locked_sec_ind", length = 100)
    private String globallyLockedSecInd;

    @Size(max = 100)
    @Column(name = "globally_locked_reason_code", length = 100)
    private String globallyLockedReasonCode;

    @Size(max = 100)
    @Column(name = "spac_ind", length = 100)
    private String spacInd;

    @Size(max = 100)
    @Column(name = "campo_14", length = 100)
    private String campo14;

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

    public String getRecordIndicator() {
        return recordIndicator;
    }

    public void setRecordIndicator(String recordIndicator) {
        this.recordIndicator = recordIndicator;
    }

    public Integer getRecordIdSequenceNumber() {
        return recordIdSequenceNumber;
    }

    public void setRecordIdSequenceNumber(Integer recordIdSequenceNumber) {
        this.recordIdSequenceNumber = recordIdSequenceNumber;
    }

    public String getCusipNumber() {
        return cusipNumber;
    }

    public void setCusipNumber(String cusipNumber) {
        this.cusipNumber = cusipNumber;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public BigDecimal getExpFirstCallPrice() {
        return expFirstCallPrice;
    }

    public void setExpFirstCallPrice(BigDecimal expFirstCallPrice) {
        this.expFirstCallPrice = expFirstCallPrice;
    }

    public BigDecimal getExpFirstParCallPrice() {
        return expFirstParCallPrice;
    }

    public void setExpFirstParCallPrice(BigDecimal expFirstParCallPrice) {
        this.expFirstParCallPrice = expFirstParCallPrice;
    }

    public BigDecimal getExpPutPrice() {
        return expPutPrice;
    }

    public void setExpPutPrice(BigDecimal expPutPrice) {
        this.expPutPrice = expPutPrice;
    }

    public BigDecimal getExpSecondPremiumCallPrice() {
        return expSecondPremiumCallPrice;
    }

    public void setExpSecondPremiumCallPrice(BigDecimal expSecondPremiumCallPrice) {
        this.expSecondPremiumCallPrice = expSecondPremiumCallPrice;
    }

    public String getNameIssuerSecurity() {
        return nameIssuerSecurity;
    }

    public void setNameIssuerSecurity(String nameIssuerSecurity) {
        this.nameIssuerSecurity = nameIssuerSecurity;
    }

    public String getIssuingCurrency() {
        return issuingCurrency;
    }

    public void setIssuingCurrency(String issuingCurrency) {
        this.issuingCurrency = issuingCurrency;
    }

    public String getGloballyLockedSecInd() {
        return globallyLockedSecInd;
    }

    public void setGloballyLockedSecInd(String globallyLockedSecInd) {
        this.globallyLockedSecInd = globallyLockedSecInd;
    }

    public String getGloballyLockedReasonCode() {
        return globallyLockedReasonCode;
    }

    public void setGloballyLockedReasonCode(String globallyLockedReasonCode) {
        this.globallyLockedReasonCode = globallyLockedReasonCode;
    }

    public String getSpacInd() {
        return spacInd;
    }

    public void setSpacInd(String spacInd) {
        this.spacInd = spacInd;
    }

    public String getCampo14() {
        return campo14;
    }

    public void setCampo14(String campo14) {
        this.campo14 = campo14;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}