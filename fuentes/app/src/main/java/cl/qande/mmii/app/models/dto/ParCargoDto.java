package cl.qande.mmii.app.models.dto;

import cl.qande.mmii.app.models.db.clientes.entity.ParCargo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link ParCargo}
 */
public class ParCargoDto implements Serializable {
    @Size(max = 100)
    private String id;
    @NotNull
    @Size(max = 100)
    private String glosa;
    @NotNull
    private Boolean flagHabilitadoRelacionado = false;

    public ParCargoDto() {
    }

    public ParCargoDto(String id, String glosa, Boolean flagHabilitadoRelacionado) {
        this.id = id;
        this.glosa = glosa;
        this.flagHabilitadoRelacionado = flagHabilitadoRelacionado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public Boolean getFlagHabilitadoRelacionado() {
        return flagHabilitadoRelacionado;
    }

    public void setFlagHabilitadoRelacionado(Boolean flagHabilitadoRelacionado) {
        this.flagHabilitadoRelacionado = flagHabilitadoRelacionado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParCargoDto entity = (ParCargoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.glosa, entity.glosa) &&
                Objects.equals(this.flagHabilitadoRelacionado, entity.flagHabilitadoRelacionado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, glosa, flagHabilitadoRelacionado);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "glosa = " + glosa + ", " +
                "flagHabilitadoRelacionado = " + flagHabilitadoRelacionado + ")";
    }
}