package cl.qande.mmii.app.models.dto.core;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.ParSourceCode}
 */
public class ParSourceCodeDto implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String sourceCodePershing;
    private Integer signoMovimiento;
    @NotNull
    @Size(max = 100)
    private String descripcionMovimiento;
    @NotNull
    private Integer aplicaFlujoNeto;
    @Size(max = 1000)
    private String observacionesInternas;

    public ParSourceCodeDto() {
    }

    public ParSourceCodeDto(Long id, String sourceCodePershing, Integer signoMovimiento, String descripcionMovimiento, Integer aplicaFlujoNeto, String observacionesInternas) {
        this.id = id;
        this.sourceCodePershing = sourceCodePershing;
        this.signoMovimiento = signoMovimiento;
        this.descripcionMovimiento = descripcionMovimiento;
        this.aplicaFlujoNeto = aplicaFlujoNeto;
        this.observacionesInternas = observacionesInternas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCodePershing() {
        return sourceCodePershing;
    }

    public void setSourceCodePershing(String sourceCodePershing) {
        this.sourceCodePershing = sourceCodePershing;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public Integer getAplicaFlujoNeto() {
        return aplicaFlujoNeto;
    }

    public void setAplicaFlujoNeto(Integer aplicaFlujoNeto) {
        this.aplicaFlujoNeto = aplicaFlujoNeto;
    }

    public String getObservacionesInternas() {
        return observacionesInternas;
    }

    public void setObservacionesInternas(String observacionesInternas) {
        this.observacionesInternas = observacionesInternas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParSourceCodeDto entity = (ParSourceCodeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.sourceCodePershing, entity.sourceCodePershing) &&
                Objects.equals(this.signoMovimiento, entity.signoMovimiento) &&
                Objects.equals(this.descripcionMovimiento, entity.descripcionMovimiento) &&
                Objects.equals(this.aplicaFlujoNeto, entity.aplicaFlujoNeto) &&
                Objects.equals(this.observacionesInternas, entity.observacionesInternas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceCodePershing, signoMovimiento, descripcionMovimiento, aplicaFlujoNeto, observacionesInternas);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "sourceCodePershing = " + sourceCodePershing + ", " +
                "signoMovimiento = " + signoMovimiento + ", " +
                "descripcionMovimiento = " + descripcionMovimiento + ", " +
                "aplicaFlujoNeto = " + aplicaFlujoNeto + ", " +
                "observacionesInternas = " + observacionesInternas + ")";
    }
}