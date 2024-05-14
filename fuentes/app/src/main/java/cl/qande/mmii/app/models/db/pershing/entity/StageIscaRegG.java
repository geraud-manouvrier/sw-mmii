package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "stage_isca_reg_g", schema = "stage_pershing")
public class StageIscaRegG {
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

    @Column(name = "delta", precision = 45, scale = 20)
    private BigDecimal delta;

    @Size(max = 100)
    @Column(name = "delta_sign", length = 100)
    private String deltaSign;

    @Size(max = 100)
    @Column(name = "delta_value_presence_ind", length = 100)
    private String deltaValuePresenceInd;

    @Size(max = 100)
    @Column(name = "campo_8", length = 100)
    private String campo8;

    @Size(max = 100)
    @Column(name = "isin_code", length = 100)
    private String isinCode;

    @Size(max = 100)
    @Column(name = "issuer_identifier", length = 100)
    private String issuerIdentifier;

    @Size(max = 100)
    @Column(name = "campo_11", length = 100)
    private String campo11;

    @Size(max = 100)
    @Column(name = "campo_12", length = 100)
    private String campo12;

    @Size(max = 100)
    @Column(name = "symbol_of_the_underlying_security", length = 100)
    private String symbolOfTheUnderlyingSecurity;

    @Size(max = 100)
    @Column(name = "asset_type", length = 100)
    private String assetType;

    @Size(max = 100)
    @Column(name = "asset_subtype", length = 100)
    private String assetSubtype;

    @Size(max = 100)
    @Column(name = "asset_subsubtype", length = 100)
    private String assetSubsubtype;

    @Column(name = "payment_day_delays")
    private Integer paymentDayDelays;

    @Size(max = 100)
    @Column(name = "campo_18", length = 100)
    private String campo18;

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

    public BigDecimal getDelta() {
        return delta;
    }

    public void setDelta(BigDecimal delta) {
        this.delta = delta;
    }

    public String getDeltaSign() {
        return deltaSign;
    }

    public void setDeltaSign(String deltaSign) {
        this.deltaSign = deltaSign;
    }

    public String getDeltaValuePresenceInd() {
        return deltaValuePresenceInd;
    }

    public void setDeltaValuePresenceInd(String deltaValuePresenceInd) {
        this.deltaValuePresenceInd = deltaValuePresenceInd;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public String getIssuerIdentifier() {
        return issuerIdentifier;
    }

    public void setIssuerIdentifier(String issuerIdentifier) {
        this.issuerIdentifier = issuerIdentifier;
    }

    public String getCampo11() {
        return campo11;
    }

    public void setCampo11(String campo11) {
        this.campo11 = campo11;
    }

    public String getCampo12() {
        return campo12;
    }

    public void setCampo12(String campo12) {
        this.campo12 = campo12;
    }

    public String getSymbolOfTheUnderlyingSecurity() {
        return symbolOfTheUnderlyingSecurity;
    }

    public void setSymbolOfTheUnderlyingSecurity(String symbolOfTheUnderlyingSecurity) {
        this.symbolOfTheUnderlyingSecurity = symbolOfTheUnderlyingSecurity;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetSubtype() {
        return assetSubtype;
    }

    public void setAssetSubtype(String assetSubtype) {
        this.assetSubtype = assetSubtype;
    }

    public String getAssetSubsubtype() {
        return assetSubsubtype;
    }

    public void setAssetSubsubtype(String assetSubsubtype) {
        this.assetSubsubtype = assetSubsubtype;
    }

    public Integer getPaymentDayDelays() {
        return paymentDayDelays;
    }

    public void setPaymentDayDelays(Integer paymentDayDelays) {
        this.paymentDayDelays = paymentDayDelays;
    }

    public String getCampo18() {
        return campo18;
    }

    public void setCampo18(String campo18) {
        this.campo18 = campo18;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}