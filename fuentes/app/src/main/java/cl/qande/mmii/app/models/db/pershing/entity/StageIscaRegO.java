package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_o", schema = "stage_pershing")
public class StageIscaRegO {
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

    @Column(name = "oas_treasury_rate", precision = 45, scale = 20)
    private BigDecimal oasTreasuryRate;

    @Size(max = 100)
    @Column(name = "oas_treasury_rate_sign", length = 100)
    private String oasTreasuryRateSign;

    @Column(name = "oas_treasury_effective_date")
    private LocalDate oasTreasuryEffectiveDate;

    @Column(name = "minimum_piece", precision = 45, scale = 20)
    private BigDecimal minimumPiece;

    @Column(name = "minimum_increment", precision = 45, scale = 20)
    private BigDecimal minimumIncrement;

    @Column(name = "issue_date_security")
    private LocalDate issueDateSecurity;

    @Size(max = 100)
    @Column(name = "campo_11", length = 100)
    private String campo11;

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

    public BigDecimal getOasTreasuryRate() {
        return oasTreasuryRate;
    }

    public void setOasTreasuryRate(BigDecimal oasTreasuryRate) {
        this.oasTreasuryRate = oasTreasuryRate;
    }

    public String getOasTreasuryRateSign() {
        return oasTreasuryRateSign;
    }

    public void setOasTreasuryRateSign(String oasTreasuryRateSign) {
        this.oasTreasuryRateSign = oasTreasuryRateSign;
    }

    public LocalDate getOasTreasuryEffectiveDate() {
        return oasTreasuryEffectiveDate;
    }

    public void setOasTreasuryEffectiveDate(LocalDate oasTreasuryEffectiveDate) {
        this.oasTreasuryEffectiveDate = oasTreasuryEffectiveDate;
    }

    public BigDecimal getMinimumPiece() {
        return minimumPiece;
    }

    public void setMinimumPiece(BigDecimal minimumPiece) {
        this.minimumPiece = minimumPiece;
    }

    public BigDecimal getMinimumIncrement() {
        return minimumIncrement;
    }

    public void setMinimumIncrement(BigDecimal minimumIncrement) {
        this.minimumIncrement = minimumIncrement;
    }

    public LocalDate getIssueDateSecurity() {
        return issueDateSecurity;
    }

    public void setIssueDateSecurity(LocalDate issueDateSecurity) {
        this.issueDateSecurity = issueDateSecurity;
    }

    public String getCampo11() {
        return campo11;
    }

    public void setCampo11(String campo11) {
        this.campo11 = campo11;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}