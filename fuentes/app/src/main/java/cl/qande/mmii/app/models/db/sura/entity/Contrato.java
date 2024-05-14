package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "contrato", schema = "sura")
public class Contrato {
    @Id
    @Size(max = 100)
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @NotNull
    @Column(name = "tipo_cuenta", nullable = false)
    private String tipoCuenta;

    @NotNull
    @Column(name = "tipo_servicio", nullable = false)
    private String tipoServicio;

    @NotNull
    @Column(name = "tarifa_negociada", nullable = false, precision = 45, scale = 20)
    private BigDecimal tarifaNegociada;

    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private String idCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public BigDecimal getTarifaNegociada() {
        return tarifaNegociada;
    }

    public void setTarifaNegociada(BigDecimal tarifaNegociada) {
        this.tarifaNegociada = tarifaNegociada;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + id + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", tarifaNegociada=" + tarifaNegociada +
                ", idCliente='" + idCliente + '\'' +
                '}';
    }
}