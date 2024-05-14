package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "ingresos_egresos")
public class IngresosEgresos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "custodian", nullable = false, length = 100)
    private String custodian;

    @Size(max = 100)
    @NotNull
    @Column(name = "office_id", nullable = false, length = 100)
    private String officeId;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "distribution_fee_percent", precision = 45, scale = 20)
    private BigDecimal distributionFeePercent;

    @Column(name = "reconocimiento_adicional_percent", precision = 45, scale = 20)
    private BigDecimal reconocimientoAdicionalPercent;

    @Column(name = "collect_on_behalf_of_percent", precision = 45, scale = 20)
    private BigDecimal collectOnBehalfOfPercent;

    @Column(name = "iva_percent", precision = 45, scale = 20)
    private BigDecimal ivaPercent;

    @Column(name = "ingresos", precision = 45, scale = 20)
    private BigDecimal ingresos;

    @Column(name = "distribution_fee", precision = 45, scale = 20)
    private BigDecimal distributionFee;

    @Column(name = "reconocimiento_adicional_bruto", precision = 45, scale = 20)
    private BigDecimal reconocimientoAdicionalBruto;

    @Column(name = "reconocimiento_adicional_iva", precision = 45, scale = 20)
    private BigDecimal reconocimientoAdicionalIva;

    @Column(name = "reconocimiento_adicional_neto", precision = 45, scale = 20)
    private BigDecimal reconocimientoAdicionalNeto;

    @Column(name = "collect_on_behalf_of_bruto", precision = 45, scale = 20)
    private BigDecimal collectOnBehalfOfBruto;

    @Column(name = "collect_on_behalf_of_iva", precision = 45, scale = 20)
    private BigDecimal collectOnBehalfOfIva;

    @Column(name = "collect_on_behalf_of_neto", precision = 45, scale = 20)
    private BigDecimal collectOnBehalfOfNeto;

    @Column(name = "aum_dia", precision = 45, scale = 20)
    private BigDecimal aumDia;

    @Column(name = "advisory_fee_dia", precision = 45, scale = 20)
    private BigDecimal advisoryFeeDia;

    @Column(name = "margen_promedio_sura", precision = 45, scale = 20)
    private BigDecimal margenPromedioSura;

    @NotNull
    @Column(name = "cant_reg", nullable = false)
    private Integer cantReg;

    @NotNull
    @Column(name = "calc_stamp", nullable = false)
    private Instant calcStamp;

    public Instant getCalcStamp() {
        return calcStamp;
    }

    public void setCalcStamp(Instant calcStamp) {
        this.calcStamp = calcStamp;
    }

    public Integer getCantReg() {
        return cantReg;
    }

    public void setCantReg(Integer cantReg) {
        this.cantReg = cantReg;
    }

    public BigDecimal getMargenPromedioSura() {
        return margenPromedioSura;
    }

    public void setMargenPromedioSura(BigDecimal margenPromedioSura) {
        this.margenPromedioSura = margenPromedioSura;
    }

    public BigDecimal getAdvisoryFeeDia() {
        return advisoryFeeDia;
    }

    public void setAdvisoryFeeDia(BigDecimal advisoryFeeDia) {
        this.advisoryFeeDia = advisoryFeeDia;
    }

    public BigDecimal getAumDia() {
        return aumDia;
    }

    public void setAumDia(BigDecimal aumDia) {
        this.aumDia = aumDia;
    }

    public BigDecimal getCollectOnBehalfOfNeto() {
        return collectOnBehalfOfNeto;
    }

    public void setCollectOnBehalfOfNeto(BigDecimal collectOnBehalfOfNeto) {
        this.collectOnBehalfOfNeto = collectOnBehalfOfNeto;
    }

    public BigDecimal getCollectOnBehalfOfIva() {
        return collectOnBehalfOfIva;
    }

    public void setCollectOnBehalfOfIva(BigDecimal collectOnBehalfOfIva) {
        this.collectOnBehalfOfIva = collectOnBehalfOfIva;
    }

    public BigDecimal getCollectOnBehalfOfBruto() {
        return collectOnBehalfOfBruto;
    }

    public void setCollectOnBehalfOfBruto(BigDecimal collectOnBehalfOfBruto) {
        this.collectOnBehalfOfBruto = collectOnBehalfOfBruto;
    }

    public BigDecimal getReconocimientoAdicionalNeto() {
        return reconocimientoAdicionalNeto;
    }

    public void setReconocimientoAdicionalNeto(BigDecimal reconocimientoAdicionalNeto) {
        this.reconocimientoAdicionalNeto = reconocimientoAdicionalNeto;
    }

    public BigDecimal getReconocimientoAdicionalIva() {
        return reconocimientoAdicionalIva;
    }

    public void setReconocimientoAdicionalIva(BigDecimal reconocimientoAdicionalIva) {
        this.reconocimientoAdicionalIva = reconocimientoAdicionalIva;
    }

    public BigDecimal getReconocimientoAdicionalBruto() {
        return reconocimientoAdicionalBruto;
    }

    public void setReconocimientoAdicionalBruto(BigDecimal reconocimientoAdicionalBruto) {
        this.reconocimientoAdicionalBruto = reconocimientoAdicionalBruto;
    }

    public BigDecimal getDistributionFee() {
        return distributionFee;
    }

    public void setDistributionFee(BigDecimal distributionFee) {
        this.distributionFee = distributionFee;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    public BigDecimal getIvaPercent() {
        return ivaPercent;
    }

    public void setIvaPercent(BigDecimal ivaPercent) {
        this.ivaPercent = ivaPercent;
    }

    public BigDecimal getCollectOnBehalfOfPercent() {
        return collectOnBehalfOfPercent;
    }

    public void setCollectOnBehalfOfPercent(BigDecimal collectOnBehalfOfPercent) {
        this.collectOnBehalfOfPercent = collectOnBehalfOfPercent;
    }

    public BigDecimal getReconocimientoAdicionalPercent() {
        return reconocimientoAdicionalPercent;
    }

    public void setReconocimientoAdicionalPercent(BigDecimal reconocimientoAdicionalPercent) {
        this.reconocimientoAdicionalPercent = reconocimientoAdicionalPercent;
    }

    public BigDecimal getDistributionFeePercent() {
        return distributionFeePercent;
    }

    public void setDistributionFeePercent(BigDecimal distributionFeePercent) {
        this.distributionFeePercent = distributionFeePercent;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}