package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_l", schema = "stage_pershing")
public class StageIscaRegL {
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

    @Size(max = 100)
    @Column(name = "primary_idc_mkt_exch", length = 100)
    private String primaryIdcMktExch;

    @Size(max = 100)
    @Column(name = "primary_mkt_exch_trading_status", length = 100)
    private String primaryMktExchTradingStatus;

    @Size(max = 100)
    @Column(name = "primary_mkt_symbol", length = 100)
    private String primaryMktSymbol;

    @Column(name = "primary_mkt_exch_effective_date")
    private LocalDate primaryMktExchEffectiveDate;

    @Size(max = 100)
    @Column(name = "primary_mkt_status_code", length = 100)
    private String primaryMktStatusCode;

    @Size(max = 100)
    @Column(name = "secondary_idc_mkt_exch", length = 100)
    private String secondaryIdcMktExch;

    @Size(max = 100)
    @Column(name = "secondary_mkt_exch_trading_status", length = 100)
    private String secondaryMktExchTradingStatus;

    @Size(max = 100)
    @Column(name = "secondary_mkt_symbol", length = 100)
    private String secondaryMktSymbol;

    @Column(name = "secondary_mkt_exch_effective_date")
    private LocalDate secondaryMktExchEffectiveDate;

    @Size(max = 100)
    @Column(name = "secondary_mkt_status_code", length = 100)
    private String secondaryMktStatusCode;

    @Size(max = 100)
    @Column(name = "tick_size_pilot_group", length = 100)
    private String tickSizePilotGroup;

    @Column(name = "tick_size_effective_date")
    private LocalDate tickSizeEffectiveDate;

    @Column(name = "tick_size_change_date")
    private LocalDate tickSizeChangeDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "oas_libor_rate", precision = 45, scale = 20)
    private BigDecimal oasLiborRate;

    @Size(max = 100)
    @Column(name = "oas_libor_rate_sign", length = 100)
    private String oasLiborRateSign;

    @Size(max = 100)
    @Column(name = "campo_21", length = 100)
    private String campo21;

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

    public String getPrimaryIdcMktExch() {
        return primaryIdcMktExch;
    }

    public void setPrimaryIdcMktExch(String primaryIdcMktExch) {
        this.primaryIdcMktExch = primaryIdcMktExch;
    }

    public String getPrimaryMktExchTradingStatus() {
        return primaryMktExchTradingStatus;
    }

    public void setPrimaryMktExchTradingStatus(String primaryMktExchTradingStatus) {
        this.primaryMktExchTradingStatus = primaryMktExchTradingStatus;
    }

    public String getPrimaryMktSymbol() {
        return primaryMktSymbol;
    }

    public void setPrimaryMktSymbol(String primaryMktSymbol) {
        this.primaryMktSymbol = primaryMktSymbol;
    }

    public LocalDate getPrimaryMktExchEffectiveDate() {
        return primaryMktExchEffectiveDate;
    }

    public void setPrimaryMktExchEffectiveDate(LocalDate primaryMktExchEffectiveDate) {
        this.primaryMktExchEffectiveDate = primaryMktExchEffectiveDate;
    }

    public String getPrimaryMktStatusCode() {
        return primaryMktStatusCode;
    }

    public void setPrimaryMktStatusCode(String primaryMktStatusCode) {
        this.primaryMktStatusCode = primaryMktStatusCode;
    }

    public String getSecondaryIdcMktExch() {
        return secondaryIdcMktExch;
    }

    public void setSecondaryIdcMktExch(String secondaryIdcMktExch) {
        this.secondaryIdcMktExch = secondaryIdcMktExch;
    }

    public String getSecondaryMktExchTradingStatus() {
        return secondaryMktExchTradingStatus;
    }

    public void setSecondaryMktExchTradingStatus(String secondaryMktExchTradingStatus) {
        this.secondaryMktExchTradingStatus = secondaryMktExchTradingStatus;
    }

    public String getSecondaryMktSymbol() {
        return secondaryMktSymbol;
    }

    public void setSecondaryMktSymbol(String secondaryMktSymbol) {
        this.secondaryMktSymbol = secondaryMktSymbol;
    }

    public LocalDate getSecondaryMktExchEffectiveDate() {
        return secondaryMktExchEffectiveDate;
    }

    public void setSecondaryMktExchEffectiveDate(LocalDate secondaryMktExchEffectiveDate) {
        this.secondaryMktExchEffectiveDate = secondaryMktExchEffectiveDate;
    }

    public String getSecondaryMktStatusCode() {
        return secondaryMktStatusCode;
    }

    public void setSecondaryMktStatusCode(String secondaryMktStatusCode) {
        this.secondaryMktStatusCode = secondaryMktStatusCode;
    }

    public String getTickSizePilotGroup() {
        return tickSizePilotGroup;
    }

    public void setTickSizePilotGroup(String tickSizePilotGroup) {
        this.tickSizePilotGroup = tickSizePilotGroup;
    }

    public LocalDate getTickSizeEffectiveDate() {
        return tickSizeEffectiveDate;
    }

    public void setTickSizeEffectiveDate(LocalDate tickSizeEffectiveDate) {
        this.tickSizeEffectiveDate = tickSizeEffectiveDate;
    }

    public LocalDate getTickSizeChangeDate() {
        return tickSizeChangeDate;
    }

    public void setTickSizeChangeDate(LocalDate tickSizeChangeDate) {
        this.tickSizeChangeDate = tickSizeChangeDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public BigDecimal getOasLiborRate() {
        return oasLiborRate;
    }

    public void setOasLiborRate(BigDecimal oasLiborRate) {
        this.oasLiborRate = oasLiborRate;
    }

    public String getOasLiborRateSign() {
        return oasLiborRateSign;
    }

    public void setOasLiborRateSign(String oasLiborRateSign) {
        this.oasLiborRateSign = oasLiborRateSign;
    }

    public String getCampo21() {
        return campo21;
    }

    public void setCampo21(String campo21) {
        this.campo21 = campo21;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}