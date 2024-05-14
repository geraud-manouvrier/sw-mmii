package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "perfil_cuenta", schema = "sura")
public class PerfilCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil_cuenta", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "id_perfil", nullable = false)
    private String idPerfil;

    @NotNull
    @Column(name = "id_cuenta_sura", nullable = false)
    private String idCuentaSura;

    @NotNull
    @Column(name = "fecha_vigencia", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    private Date fechaVigencia;

    @Column(name = "portfolio", nullable = false)
    private String portfolio;

    @NotNull
    @Column(name = "monto_comprometido", nullable = false, precision = 45, scale = 20)
    private BigDecimal montoComprometido;

    @Size(max = 100)
    @Column(name = "horizonte_objetivo", length = 100)
    private String horizonteObjetivo;

    @Size(max = 100)
    @Column(name = "exencion_responsabilidad", length = 100)
    private String exencionResponsabilidad;

    public String getExencionResponsabilidad() {
        return exencionResponsabilidad;
    }

    public void setExencionResponsabilidad(String exencionResponsabilidad) {
        this.exencionResponsabilidad = exencionResponsabilidad;
    }

    public String getHorizonteObjetivo() {
        return horizonteObjetivo;
    }

    public void setHorizonteObjetivo(String horizonteObjetivo) {
        this.horizonteObjetivo = horizonteObjetivo;
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

    @Override
    public String toString() {
        return "PerfilCuenta{" +
                "id=" + id +
                ", idPerfil='" + idPerfil + '\'' +
                ", idCuentaSura='" + idCuentaSura + '\'' +
                ", fechaVigencia=" + fechaVigencia +
                ", portfolio='" + portfolio + '\'' +
                ", montoComprometido=" + montoComprometido +
                '}';
    }
}