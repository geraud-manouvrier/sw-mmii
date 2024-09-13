package cl.qande.mmii.app.models.db.clientes.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "comision_cuenta", schema = "clientes")
public class ComisionCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;

    @Column(name = "comision_diaria_saldo", precision = 45, scale = 20)
    private BigDecimal comisionDiariaSaldo;

    @NotNull
    @Column(name = "fecha_inicio_vigencia", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioVigencia;

    @Column(name = "log_fecha_creacion")
    private Instant logFechaCreacion;

    @Size(max = 100)
    @Column(name = "log_usuario_creacion", length = 100)
    private String logUsuarioCreacion;

    public String getLogUsuarioCreacion() {
        return logUsuarioCreacion;
    }

    public void setLogUsuarioCreacion(String logUsuarioCreacion) {
        this.logUsuarioCreacion = logUsuarioCreacion;
    }

    public Instant getLogFechaCreacion() {
        return logFechaCreacion;
    }

    public void setLogFechaCreacion(Instant logFechaCreacion) {
        this.logFechaCreacion = logFechaCreacion;
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

}