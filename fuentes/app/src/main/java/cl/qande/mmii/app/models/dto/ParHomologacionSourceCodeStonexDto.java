package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.ParHomologacionSourceCodeStonex}
 */
public class ParHomologacionSourceCodeStonexDto implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String sourceCodeStonex;
    private Integer signoMovimiento;
    @Size(max = 1000)
    private String observacionesInternas;
    private Long idParSourceCode;

    public ParHomologacionSourceCodeStonexDto() {
    }

    public ParHomologacionSourceCodeStonexDto(Long id, String sourceCodeStonex, Integer signoMovimiento, String observacionesInternas, Long idParSourceCode) {
        this.id = id;
        this.sourceCodeStonex = sourceCodeStonex;
        this.signoMovimiento = signoMovimiento;
        this.observacionesInternas = observacionesInternas;
        this.idParSourceCode = idParSourceCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCodeStonex() {
        return sourceCodeStonex;
    }

    public void setSourceCodeStonex(String sourceCodeStonex) {
        this.sourceCodeStonex = sourceCodeStonex;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
    }

    public String getObservacionesInternas() {
        return observacionesInternas;
    }

    public void setObservacionesInternas(String observacionesInternas) {
        this.observacionesInternas = observacionesInternas;
    }

    public Long getIdParSourceCode() {
        return idParSourceCode;
    }

    public void setIdParSourceCode(Long idParSourceCode) {
        this.idParSourceCode = idParSourceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParHomologacionSourceCodeStonexDto entity = (ParHomologacionSourceCodeStonexDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.sourceCodeStonex, entity.sourceCodeStonex) &&
                Objects.equals(this.signoMovimiento, entity.signoMovimiento) &&
                Objects.equals(this.observacionesInternas, entity.observacionesInternas) &&
                Objects.equals(this.idParSourceCode, entity.idParSourceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceCodeStonex, signoMovimiento, observacionesInternas, idParSourceCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "sourceCodeStonex = " + sourceCodeStonex + ", " +
                "signoMovimiento = " + signoMovimiento + ", " +
                "observacionesInternas = " + observacionesInternas + ", " +
                "idParSourceCode = " + idParSourceCode + ")";
    }
}