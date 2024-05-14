package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta}
 */
public class PerfilCuentaDto implements Serializable {
    private Long id;
    @NotNull
    private String idPerfil;
    @NotNull
    private String idCuentaSura;
    @NotNull
    private Date fechaVigencia;
    private String portfolio;
    @NotNull
    private BigDecimal montoComprometido;
    @Size(max = 100)
    private String horizonteObjetivo;
    @Size(max = 100)
    private String exencionResponsabilidad;

    public PerfilCuentaDto() {
    }

    public PerfilCuentaDto(Long id, String idPerfil, String idCuentaSura, Date fechaVigencia, String portfolio, BigDecimal montoComprometido, String horizonteObjetivo, String exencionResponsabilidad) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.idCuentaSura = idCuentaSura;
        this.fechaVigencia = fechaVigencia;
        this.portfolio = portfolio;
        this.montoComprometido = montoComprometido;
        this.horizonteObjetivo = horizonteObjetivo;
        this.exencionResponsabilidad = exencionResponsabilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdCuentaSura() {
        return idCuentaSura;
    }

    public void setIdCuentaSura(String idCuentaSura) {
        this.idCuentaSura = idCuentaSura;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public BigDecimal getMontoComprometido() {
        return montoComprometido;
    }

    public void setMontoComprometido(BigDecimal montoComprometido) {
        this.montoComprometido = montoComprometido;
    }

    public String getHorizonteObjetivo() {
        return horizonteObjetivo;
    }

    public void setHorizonteObjetivo(String horizonteObjetivo) {
        this.horizonteObjetivo = horizonteObjetivo;
    }

    public String getExencionResponsabilidad() {
        return exencionResponsabilidad;
    }

    public void setExencionResponsabilidad(String exencionResponsabilidad) {
        this.exencionResponsabilidad = exencionResponsabilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilCuentaDto entity = (PerfilCuentaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idPerfil, entity.idPerfil) &&
                Objects.equals(this.idCuentaSura, entity.idCuentaSura) &&
                Objects.equals(this.fechaVigencia, entity.fechaVigencia) &&
                Objects.equals(this.portfolio, entity.portfolio) &&
                Objects.equals(this.montoComprometido, entity.montoComprometido) &&
                Objects.equals(this.horizonteObjetivo, entity.horizonteObjetivo) &&
                Objects.equals(this.exencionResponsabilidad, entity.exencionResponsabilidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPerfil, idCuentaSura, fechaVigencia, portfolio, montoComprometido, horizonteObjetivo, exencionResponsabilidad);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idPerfil = " + idPerfil + ", " +
                "idCuentaSura = " + idCuentaSura + ", " +
                "fechaVigencia = " + fechaVigencia + ", " +
                "portfolio = " + portfolio + ", " +
                "montoComprometido = " + montoComprometido + ", " +
                "horizonteObjetivo = " + horizonteObjetivo + ", " +
                "exencionResponsabilidad = " + exencionResponsabilidad + ")";
    }
}