package cl.qande.mmii.app.models.db.clientes.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "par_fee_segmento", schema = "clientes")
public class ParFeeSegmento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "glosa", nullable = false, length = 100)
    private String glosa;

    @NotNull
    @Column(name = "monto_min", nullable = false, precision = 45, scale = 20)
    private BigDecimal montoMin;

    @NotNull
    @Column(name = "monto_max", nullable = false, precision = 45, scale = 20)
    private BigDecimal montoMax;

    @NotNull
    @Column(name = "annual_fee", nullable = false, precision = 45, scale = 20)
    private BigDecimal annualFee;

    @NotNull
    @Column(name = "tasa_proteccion", nullable = false, precision = 45, scale = 20)
    private BigDecimal tasaProteccion;

    @NotNull
    @Column(name = "tasa_suracorp", nullable = false, precision = 45, scale = 20)
    private BigDecimal tasaSuracorp;

    @Column(name = "fee_diario", insertable = false, updatable = false, precision = 45, scale = 20)
    private BigDecimal feeDiario;

    @Column(name = "fee_diario_proteccion", insertable = false, updatable = false, precision = 45, scale = 20)
    private BigDecimal feeDiarioProteccion;

    @Column(name = "fee_diario_sura_corp", insertable = false, updatable = false, precision = 45, scale = 20)
    private BigDecimal feeDiarioSuraCorp;

    @Size(max = 100)
    @Column(name = "modificacion_usuario", length = 100)
    private String modificacionUsuario;

    @Column(name = "modificacion_timestamp")
    private Instant modificacionTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public BigDecimal getMontoMin() {
        return montoMin;
    }

    public void setMontoMin(BigDecimal montoMin) {
        this.montoMin = montoMin;
    }

    public BigDecimal getMontoMax() {
        return montoMax;
    }

    public void setMontoMax(BigDecimal montoMax) {
        this.montoMax = montoMax;
    }

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public BigDecimal getTasaProteccion() {
        return tasaProteccion;
    }

    public void setTasaProteccion(BigDecimal tasaProteccion) {
        this.tasaProteccion = tasaProteccion;
    }

    public BigDecimal getTasaSuracorp() {
        return tasaSuracorp;
    }

    public void setTasaSuracorp(BigDecimal tasaSuracorp) {
        this.tasaSuracorp = tasaSuracorp;
    }

    public BigDecimal getFeeDiario() {
        return feeDiario;
    }

    public void setFeeDiario(BigDecimal feeDiario) {
        this.feeDiario = feeDiario;
    }

    public BigDecimal getFeeDiarioProteccion() {
        return feeDiarioProteccion;
    }

    public void setFeeDiarioProteccion(BigDecimal feeDiarioProteccion) {
        this.feeDiarioProteccion = feeDiarioProteccion;
    }

    public BigDecimal getFeeDiarioSuraCorp() {
        return feeDiarioSuraCorp;
    }

    public void setFeeDiarioSuraCorp(BigDecimal feeDiarioSuraCorp) {
        this.feeDiarioSuraCorp = feeDiarioSuraCorp;
    }

    public String getModificacionUsuario() {
        return modificacionUsuario;
    }

    public void setModificacionUsuario(String modificacionUsuario) {
        this.modificacionUsuario = modificacionUsuario;
    }

    public Instant getModificacionTimestamp() {
        return modificacionTimestamp;
    }

    public void setModificacionTimestamp(Instant modificacionTimestamp) {
        this.modificacionTimestamp = modificacionTimestamp;
    }

}