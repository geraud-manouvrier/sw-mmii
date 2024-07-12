package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.clientes.entity.ParFeeSegmento}
 */
public class ParFeeSegmentoDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String glosa;
    @NotNull
    private BigDecimal montoMin;
    @NotNull
    private BigDecimal montoMax;
    @NotNull
    private BigDecimal annualFee;
    @NotNull
    private BigDecimal tasaProteccion;
    @NotNull
    private BigDecimal tasaSuracorp;
    @Size(max = 100)
    private String modificacionUsuario;
    private Instant modificacionTimestamp;

    public ParFeeSegmentoDto() {
    }

    @SuppressWarnings("squid:S00107")
    public ParFeeSegmentoDto(Integer id, String glosa, BigDecimal montoMin, BigDecimal montoMax, BigDecimal annualFee, BigDecimal tasaProteccion, BigDecimal tasaSuracorp, String modificacionUsuario, Instant modificacionTimestamp) {
        this.id = id;
        this.glosa = glosa;
        this.montoMin = montoMin;
        this.montoMax = montoMax;
        this.annualFee = annualFee;
        this.tasaProteccion = tasaProteccion;
        this.tasaSuracorp = tasaSuracorp;
        this.modificacionUsuario = modificacionUsuario;
        this.modificacionTimestamp = modificacionTimestamp;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParFeeSegmentoDto entity = (ParFeeSegmentoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.glosa, entity.glosa) &&
                Objects.equals(this.montoMin, entity.montoMin) &&
                Objects.equals(this.montoMax, entity.montoMax) &&
                Objects.equals(this.annualFee, entity.annualFee) &&
                Objects.equals(this.tasaProteccion, entity.tasaProteccion) &&
                Objects.equals(this.tasaSuracorp, entity.tasaSuracorp) &&
                Objects.equals(this.modificacionUsuario, entity.modificacionUsuario) &&
                Objects.equals(this.modificacionTimestamp, entity.modificacionTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, glosa, montoMin, montoMax, annualFee, tasaProteccion, tasaSuracorp, modificacionUsuario, modificacionTimestamp);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "glosa = " + glosa + ", " +
                "montoMin = " + montoMin + ", " +
                "montoMax = " + montoMax + ", " +
                "annualFee = " + annualFee + ", " +
                "tasaProteccion = " + tasaProteccion + ", " +
                "tasaSuracorp = " + tasaSuracorp + ", " +
                "modificacionUsuario = " + modificacionUsuario + ", " +
                "modificacionTimestamp = " + modificacionTimestamp + ")";
    }
}