package cl.qande.mmii.app.models.db.clientes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "par_cargo", schema = "clientes")
public class ParCargo {
    @Id
    @Size(max = 100)
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Size(max = 100)
    @NotNull
    @Column(name = "glosa", nullable = false, length = 100)
    private String glosa;

    @NotNull
    @Column(name = "flag_habilitado_relacionado", nullable = false)
    private Boolean flagHabilitadoRelacionado = false;

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

}