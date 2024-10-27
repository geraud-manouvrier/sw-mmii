package cl.qande.mmii.app.models.db.clientes.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_identificador", schema = "clientes")
public class TipoIdentificador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "tipo_identificador", nullable = false, length = 100)
    private String tipoIdentificador;

    @Size(max = 100)
    @NotNull
    @Column(name = "glosa_identificador", nullable = false, length = 100)
    private String glosaIdentificador;

    @NotNull
    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado = false;

    @Column(name = "flag_tiene_relacionados")
    private Boolean flagTieneRelacionados;

    public Boolean getFlagTieneRelacionados() {
        return flagTieneRelacionados;
    }

    public void setFlagTieneRelacionados(Boolean flagTieneRelacionados) {
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

}