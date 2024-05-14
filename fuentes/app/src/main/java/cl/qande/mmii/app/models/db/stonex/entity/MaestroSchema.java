package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "maestro_schema", schema = "stonex")
public class MaestroSchema {
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

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

}