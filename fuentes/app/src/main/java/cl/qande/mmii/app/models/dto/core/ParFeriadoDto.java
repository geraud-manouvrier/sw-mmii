package cl.qande.mmii.app.models.dto.core;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.ParFeriado}
 */
public class ParFeriadoDto implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate id;
    @NotNull
    private Boolean esHabilPershing = false;
    @NotNull
    private Boolean esHabilStonex = false;
    @NotNull
    @Size(max = 100)
    private String observaciones;

    public ParFeriadoDto() {
    }

    public ParFeriadoDto(LocalDate id, Boolean esHabilPershing, Boolean esHabilStonex, String observaciones) {
        this.id = id;
        this.esHabilPershing = esHabilPershing;
        this.esHabilStonex = esHabilStonex;
        this.observaciones = observaciones;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParFeriadoDto entity = (ParFeriadoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.esHabilPershing, entity.esHabilPershing) &&
                Objects.equals(this.esHabilStonex, entity.esHabilStonex) &&
                Objects.equals(this.observaciones, entity.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, esHabilPershing, esHabilStonex, observaciones);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "esHabilPershing = " + esHabilPershing + ", " +
                "esHabilStonex = " + esHabilStonex + ", " +
                "observaciones = " + observaciones + ")";
    }
}