package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "par_feriado", schema = "public")
public class ParFeriado {
    @Id
    @Column(name = "dia", nullable = false)
    private LocalDate id;

    @NotNull
    @Column(name = "es_habil_pershing", nullable = false)
    private Boolean esHabilPershing = false;

    @NotNull
    @Column(name = "es_habil_stonex", nullable = false)
    private Boolean esHabilStonex = false;

    @Size(max = 100)
    @NotNull
    @Column(name = "observaciones", nullable = false, length = 100)
    private String observaciones;

    public LocalDate getId() {
        return id;
    }

    public void setId(LocalDate id) {
        this.id = id;
    }

    public Boolean getEsHabilPershing() {
        return esHabilPershing;
    }

    public void setEsHabilPershing(Boolean esHabilPershing) {
        this.esHabilPershing = esHabilPershing;
    }

    public Boolean getEsHabilStonex() {
        return esHabilStonex;
    }

    public void setEsHabilStonex(Boolean esHabilStonex) {
        this.esHabilStonex = esHabilStonex;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}