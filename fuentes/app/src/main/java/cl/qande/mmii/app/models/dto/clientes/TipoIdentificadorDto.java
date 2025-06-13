package cl.qande.mmii.app.models.dto.clientes;

import cl.qande.mmii.app.models.db.clientes.entity.TipoIdentificador;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link TipoIdentificador}
 */
public class TipoIdentificadorDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String tipoIdentificador;
    @NotNull
    @Size(max = 100)
    private String glosaIdentificador;
    @NotNull
    private Boolean habilitado = false;
    private Boolean flagTieneRelacionados;

    public TipoIdentificadorDto() {
    }

    public TipoIdentificadorDto(Integer id, String tipoIdentificador, String glosaIdentificador, Boolean habilitado,
                                Boolean flagTieneRelacionados) {
        this.id = id;
        this.tipoIdentificador = tipoIdentificador;
        this.glosaIdentificador = glosaIdentificador;
        this.habilitado = habilitado;
        this.flagTieneRelacionados = flagTieneRelacionados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoIdentificador() {
        return tipoIdentificador;
    }

    public void setTipoIdentificador(String tipoIdentificador) {
        this.tipoIdentificador = tipoIdentificador;
    }

    public String getGlosaIdentificador() {
        return glosaIdentificador;
    }

    public void setGlosaIdentificador(String glosaIdentificador) {
        this.glosaIdentificador = glosaIdentificador;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Boolean getFlagTieneRelacionados() {
        return flagTieneRelacionados;
    }

    public void setFlagTieneRelacionados(Boolean flagTieneRelacionados) {
        this.flagTieneRelacionados = flagTieneRelacionados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoIdentificadorDto entity = (TipoIdentificadorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipoIdentificador, entity.tipoIdentificador) &&
                Objects.equals(this.glosaIdentificador, entity.glosaIdentificador) &&
                Objects.equals(this.habilitado, entity.habilitado) &&
                Objects.equals(this.flagTieneRelacionados, entity.flagTieneRelacionados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoIdentificador, glosaIdentificador, habilitado, flagTieneRelacionados);
    }

    @Override
    public String toString() {
        return "TipoIdentificadorDto{" +
                "id=" + id +
                ", tipoIdentificador='" + tipoIdentificador + '\'' +
                ", glosaIdentificador='" + glosaIdentificador + '\'' +
                ", habilitado=" + habilitado +
                ", flagTieneRelacionados=" + flagTieneRelacionados +
                '}';
    }
}