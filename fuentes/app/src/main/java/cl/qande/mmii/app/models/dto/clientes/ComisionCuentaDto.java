package cl.qande.mmii.app.models.dto.clientes;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.clientes.entity.ComisionCuenta}
 */
public class ComisionCuentaDto implements Serializable {
    private Long id;
    @NotNull
    private Integer idCuenta;
    private BigDecimal comisionDiariaSaldo;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioVigencia;
    private Instant logFechaCreacion;
    @Size(max = 100)
    private String logUsuarioCreacion;


    public ComisionCuentaDto() {
    }

    public ComisionCuentaDto(Long id, Integer idCuenta, BigDecimal comisionDiariaSaldo, Date fechaInicioVigencia,
                             Instant logFechaCreacion,
                             String logUsuarioCreacion) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.comisionDiariaSaldo = comisionDiariaSaldo;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.logFechaCreacion = logFechaCreacion;
        this.logUsuarioCreacion = logUsuarioCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public BigDecimal getComisionDiariaSaldo() {
        return comisionDiariaSaldo;
    }

    public void setComisionDiariaSaldo(BigDecimal comisionDiariaSaldo) {
        this.comisionDiariaSaldo = comisionDiariaSaldo;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComisionCuentaDto entity = (ComisionCuentaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idCuenta, entity.idCuenta) &&
                Objects.equals(this.comisionDiariaSaldo, entity.comisionDiariaSaldo) &&
                Objects.equals(this.fechaInicioVigencia, entity.fechaInicioVigencia) &&
                Objects.equals(this.logFechaCreacion, entity.logFechaCreacion) &&
                Objects.equals(this.logUsuarioCreacion, entity.logUsuarioCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCuenta, comisionDiariaSaldo, fechaInicioVigencia, logFechaCreacion,logUsuarioCreacion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idCuenta = " + idCuenta + ", " +
                "comisionDiariaSaldo = " + comisionDiariaSaldo + ", " +
                "fechaInicioVigencia = " + fechaInicioVigencia + ")" +
                "logFechaCreacion = " + logFechaCreacion + ")" +
                "logUsuarioCreacion = " + logUsuarioCreacion + ")";
    }

    public Instant getLogFechaCreacion() {
        return logFechaCreacion;
    }

    public void setLogFechaCreacion(Instant logFechaCreacion) {
        this.logFechaCreacion = logFechaCreacion;
    }

    public String getLogUsuarioCreacion() {
        return logUsuarioCreacion;
    }

    public void setLogUsuarioCreacion(String logUsuarioCreacion) {
        this.logUsuarioCreacion = logUsuarioCreacion;
    }
}