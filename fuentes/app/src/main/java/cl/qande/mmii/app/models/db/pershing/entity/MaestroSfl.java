package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "maestro_sfl", schema = "pershing")
public class MaestroSfl {
    @Id
    @Size(max = 100)
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @NotNull
    @Column(name = "flag_guardar_en_bd", nullable = false)
    private Boolean flagGuardarEnBd = false;

    @NotNull
    @Column(name = "flag_procesar_parse_en_bd", nullable = false)
    private Boolean flagProcesarParseEnBd = false;

    @Size(max = 100)
    @NotNull
    @Column(name = "filename", nullable = false, length = 100)
    private String filename;

    @NotNull
    @Column(name = "flag_replicar_data", nullable = false)
    private Boolean flagReplicarData = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getFlagGuardarEnBd() {
        return flagGuardarEnBd;
    }

    public void setFlagGuardarEnBd(Boolean flagGuardarEnBd) {
        this.flagGuardarEnBd = flagGuardarEnBd;
    }

    public Boolean getFlagProcesarParseEnBd() {
        return flagProcesarParseEnBd;
    }

    public void setFlagProcesarParseEnBd(Boolean flagProcesarParseEnBd) {
        this.flagProcesarParseEnBd = flagProcesarParseEnBd;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getFlagReplicarData() {
        return flagReplicarData;
    }

    public void setFlagReplicarData(Boolean flagReplicarData) {
        this.flagReplicarData = flagReplicarData;
    }

}