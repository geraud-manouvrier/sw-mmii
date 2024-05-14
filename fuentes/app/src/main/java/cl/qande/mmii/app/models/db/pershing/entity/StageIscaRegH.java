package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "stage_isca_reg_h", schema = "stage_pershing")
public class StageIscaRegH {
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

    @Column(name = "exchange_rate_denom_currency_usd", precision = 45, scale = 20)
    private BigDecimal exchangeRateDenomCurrencyUsd;

    @Size(max = 100)
    @Column(name = "underlying_cusip_1", length = 100)
    private String underlyingCusip1;

    @Size(max = 100)
    @Column(name = "campo_7", length = 100)
    private String campo7;

    @Column(name = "deliverable_unit_quantity_1")
    private Integer deliverableUnitQuantity1;

    @Size(max = 100)
    @Column(name = "underlying_cusip_2", length = 100)
    private String underlyingCusip2;

    @Size(max = 100)
    @Column(name = "campo_10", length = 100)
    private String campo10;

    @Column(name = "deliverable_unit_quantity_2")
    private Integer deliverableUnitQuantity2;

    @Size(max = 100)
    @Column(name = "underlying_cusip_3", length = 100)
    private String underlyingCusip3;

    @Size(max = 100)
    @Column(name = "campo_13", length = 100)
    private String campo13;

    @Column(name = "deliverable_unit_quantity_3")
    private Integer deliverableUnitQuantity3;

    @Size(max = 100)
    @Column(name = "underlying_cusip_4", length = 100)
    private String underlyingCusip4;

    @Size(max = 100)
    @Column(name = "campo_16", length = 100)
    private String campo16;

    @Column(name = "deliverable_unit_quantity_4")
    private Integer deliverableUnitQuantity4;

    @Size(max = 100)
    @Column(name = "annual_dividend_currency_code", length = 100)
    private String annualDividendCurrencyCode;

    @Column(name = "outstanding_shares", precision = 45, scale = 20)
    private BigDecimal outstandingShares;

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

    public BigDecimal getExchangeRateDenomCurrencyUsd() {
        return exchangeRateDenomCurrencyUsd;
    }

    public void setExchangeRateDenomCurrencyUsd(BigDecimal exchangeRateDenomCurrencyUsd) {
        this.exchangeRateDenomCurrencyUsd = exchangeRateDenomCurrencyUsd;
    }

    public String getUnderlyingCusip1() {
        return underlyingCusip1;
    }

    public void setUnderlyingCusip1(String underlyingCusip1) {
        this.underlyingCusip1 = underlyingCusip1;
    }

    public String getCampo7() {
        return campo7;
    }

    public void setCampo7(String campo7) {
        this.campo7 = campo7;
    }

    public Integer getDeliverableUnitQuantity1() {
        return deliverableUnitQuantity1;
    }

    public void setDeliverableUnitQuantity1(Integer deliverableUnitQuantity1) {
        this.deliverableUnitQuantity1 = deliverableUnitQuantity1;
    }

    public String getUnderlyingCusip2() {
        return underlyingCusip2;
    }

    public void setUnderlyingCusip2(String underlyingCusip2) {
        this.underlyingCusip2 = underlyingCusip2;
    }

    public String getCampo10() {
        return campo10;
    }

    public void setCampo10(String campo10) {
        this.campo10 = campo10;
    }

    public Integer getDeliverableUnitQuantity2() {
        return deliverableUnitQuantity2;
    }

    public void setDeliverableUnitQuantity2(Integer deliverableUnitQuantity2) {
        this.deliverableUnitQuantity2 = deliverableUnitQuantity2;
    }

    public String getUnderlyingCusip3() {
        return underlyingCusip3;
    }

    public void setUnderlyingCusip3(String underlyingCusip3) {
        this.underlyingCusip3 = underlyingCusip3;
    }

    public String getCampo13() {
        return campo13;
    }

    public void setCampo13(String campo13) {
        this.campo13 = campo13;
    }

    public Integer getDeliverableUnitQuantity3() {
        return deliverableUnitQuantity3;
    }

    public void setDeliverableUnitQuantity3(Integer deliverableUnitQuantity3) {
        this.deliverableUnitQuantity3 = deliverableUnitQuantity3;
    }

    public String getUnderlyingCusip4() {
        return underlyingCusip4;
    }

    public void setUnderlyingCusip4(String underlyingCusip4) {
        this.underlyingCusip4 = underlyingCusip4;
    }

    public String getCampo16() {
        return campo16;
    }

    public void setCampo16(String campo16) {
        this.campo16 = campo16;
    }

    public Integer getDeliverableUnitQuantity4() {
        return deliverableUnitQuantity4;
    }

    public void setDeliverableUnitQuantity4(Integer deliverableUnitQuantity4) {
        this.deliverableUnitQuantity4 = deliverableUnitQuantity4;
    }

    public String getAnnualDividendCurrencyCode() {
        return annualDividendCurrencyCode;
    }

    public void setAnnualDividendCurrencyCode(String annualDividendCurrencyCode) {
        this.annualDividendCurrencyCode = annualDividendCurrencyCode;
    }

    public BigDecimal getOutstandingShares() {
        return outstandingShares;
    }

    public void setOutstandingShares(BigDecimal outstandingShares) {
        this.outstandingShares = outstandingShares;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}