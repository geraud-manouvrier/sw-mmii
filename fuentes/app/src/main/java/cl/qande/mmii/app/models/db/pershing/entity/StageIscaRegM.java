package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_m", schema = "stage_pershing")
public class StageIscaRegM {
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
    @Column(name = "campo_5", length = 100)
    private String campo5;

    @Column(name = "first_call_date")
    private LocalDate firstCallDate;

    @Column(name = "first_call_price", precision = 45, scale = 20)
    private BigDecimal firstCallPrice;

    @Size(max = 100)
    @Column(name = "campo_8", length = 100)
    private String campo8;

    @Column(name = "second_call_date")
    private LocalDate secondCallDate;

    @Column(name = "second_call_price", precision = 45, scale = 20)
    private BigDecimal secondCallPrice;

    @Size(max = 100)
    @Column(name = "campo_11", length = 100)
    private String campo11;

    @Column(name = "third_call_date")
    private LocalDate thirdCallDate;

    @Column(name = "third_call_price", precision = 45, scale = 20)
    private BigDecimal thirdCallPrice;

    @Size(max = 100)
    @Column(name = "campo_14", length = 100)
    private String campo14;

    @Column(name = "fourth_call_date")
    private LocalDate fourthCallDate;

    @Column(name = "fourth_call_price", precision = 45, scale = 20)
    private BigDecimal fourthCallPrice;

    @Size(max = 100)
    @Column(name = "campo_17", length = 100)
    private String campo17;

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

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    public LocalDate getFirstCallDate() {
        return firstCallDate;
    }

    public void setFirstCallDate(LocalDate firstCallDate) {
        this.firstCallDate = firstCallDate;
    }

    public BigDecimal getFirstCallPrice() {
        return firstCallPrice;
    }

    public void setFirstCallPrice(BigDecimal firstCallPrice) {
        this.firstCallPrice = firstCallPrice;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public LocalDate getSecondCallDate() {
        return secondCallDate;
    }

    public void setSecondCallDate(LocalDate secondCallDate) {
        this.secondCallDate = secondCallDate;
    }

    public BigDecimal getSecondCallPrice() {
        return secondCallPrice;
    }

    public void setSecondCallPrice(BigDecimal secondCallPrice) {
        this.secondCallPrice = secondCallPrice;
    }

    public String getCampo11() {
        return campo11;
    }

    public void setCampo11(String campo11) {
        this.campo11 = campo11;
    }

    public LocalDate getThirdCallDate() {
        return thirdCallDate;
    }

    public void setThirdCallDate(LocalDate thirdCallDate) {
        this.thirdCallDate = thirdCallDate;
    }

    public BigDecimal getThirdCallPrice() {
        return thirdCallPrice;
    }

    public void setThirdCallPrice(BigDecimal thirdCallPrice) {
        this.thirdCallPrice = thirdCallPrice;
    }

    public String getCampo14() {
        return campo14;
    }

    public void setCampo14(String campo14) {
        this.campo14 = campo14;
    }

    public LocalDate getFourthCallDate() {
        return fourthCallDate;
    }

    public void setFourthCallDate(LocalDate fourthCallDate) {
        this.fourthCallDate = fourthCallDate;
    }

    public BigDecimal getFourthCallPrice() {
        return fourthCallPrice;
    }

    public void setFourthCallPrice(BigDecimal fourthCallPrice) {
        this.fourthCallPrice = fourthCallPrice;
    }

    public String getCampo17() {
        return campo17;
    }

    public void setCampo17(String campo17) {
        this.campo17 = campo17;
    }

    public String getEor() {
        return eor;
    }

    public void setEor(String eor) {
        this.eor = eor;
    }

}