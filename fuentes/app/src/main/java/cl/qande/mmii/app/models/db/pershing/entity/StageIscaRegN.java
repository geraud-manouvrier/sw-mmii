package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stage_isca_reg_n", schema = "stage_pershing")
public class StageIscaRegN {
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

    @Column(name = "effective_date_rate_1")
    private LocalDate effectiveDateRate1;

    @Column(name = "coupon_interest_rate_1", precision = 45, scale = 20)
    private BigDecimal couponInterestRate1;

    @Size(max = 100)
    @Column(name = "campo_8", length = 100)
    private String campo8;

    @Column(name = "effective_date_rate_2")
    private LocalDate effectiveDateRate2;

    @Column(name = "coupon_interest_rate_2", precision = 45, scale = 20)
    private BigDecimal couponInterestRate2;

    @Size(max = 100)
    @Column(name = "campo_11", length = 100)
    private String campo11;

    @Column(name = "effective_date_rate_3")
    private LocalDate effectiveDateRate3;

    @Column(name = "coupon_interest_rate_3", precision = 45, scale = 20)
    private BigDecimal couponInterestRate3;

    @Size(max = 100)
    @Column(name = "campo_14", length = 100)
    private String campo14;

    @Column(name = "effective_date_rate_4")
    private LocalDate effectiveDateRate4;

    @Column(name = "coupon_interest_rate_4", precision = 45, scale = 20)
    private BigDecimal couponInterestRate4;

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

    public LocalDate getEffectiveDateRate1() {
        return effectiveDateRate1;
    }

    public void setEffectiveDateRate1(LocalDate effectiveDateRate1) {
        this.effectiveDateRate1 = effectiveDateRate1;
    }

    public BigDecimal getCouponInterestRate1() {
        return couponInterestRate1;
    }

    public void setCouponInterestRate1(BigDecimal couponInterestRate1) {
        this.couponInterestRate1 = couponInterestRate1;
    }

    public String getCampo8() {
        return campo8;
    }

    public void setCampo8(String campo8) {
        this.campo8 = campo8;
    }

    public LocalDate getEffectiveDateRate2() {
        return effectiveDateRate2;
    }

    public void setEffectiveDateRate2(LocalDate effectiveDateRate2) {
        this.effectiveDateRate2 = effectiveDateRate2;
    }

    public BigDecimal getCouponInterestRate2() {
        return couponInterestRate2;
    }

    public void setCouponInterestRate2(BigDecimal couponInterestRate2) {
        this.couponInterestRate2 = couponInterestRate2;
    }

    public String getCampo11() {
        return campo11;
    }

    public void setCampo11(String campo11) {
        this.campo11 = campo11;
    }

    public LocalDate getEffectiveDateRate3() {
        return effectiveDateRate3;
    }

    public void setEffectiveDateRate3(LocalDate effectiveDateRate3) {
        this.effectiveDateRate3 = effectiveDateRate3;
    }

    public BigDecimal getCouponInterestRate3() {
        return couponInterestRate3;
    }

    public void setCouponInterestRate3(BigDecimal couponInterestRate3) {
        this.couponInterestRate3 = couponInterestRate3;
    }

    public String getCampo14() {
        return campo14;
    }

    public void setCampo14(String campo14) {
        this.campo14 = campo14;
    }

    public LocalDate getEffectiveDateRate4() {
        return effectiveDateRate4;
    }

    public void setEffectiveDateRate4(LocalDate effectiveDateRate4) {
        this.effectiveDateRate4 = effectiveDateRate4;
    }

    public BigDecimal getCouponInterestRate4() {
        return couponInterestRate4;
    }

    public void setCouponInterestRate4(BigDecimal couponInterestRate4) {
        this.couponInterestRate4 = couponInterestRate4;
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