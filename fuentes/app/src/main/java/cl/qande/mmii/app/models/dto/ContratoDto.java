package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.sura.entity.Contrato}
 */
public class ContratoDto implements Serializable {
    @Size(max = 100)
    private String id;
    @NotNull
    private String tipoCuenta;
    @NotNull
    private String tipoServicio;
    @NotNull
    private BigDecimal tarifaNegociada;
    @NotNull
    private String idCliente;

    public ContratoDto() {
    }

    public ContratoDto(String id, String tipoCuenta, String tipoServicio, BigDecimal tarifaNegociada, String idCliente) {
        this.id = id;
        this.tipoCuenta = tipoCuenta;
        this.tipoServicio = tipoServicio;
        this.tarifaNegociada = tarifaNegociada;
        this.idCliente = idCliente;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratoDto entity = (ContratoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipoCuenta, entity.tipoCuenta) &&
                Objects.equals(this.tipoServicio, entity.tipoServicio) &&
                Objects.equals(this.tarifaNegociada, entity.tarifaNegociada) &&
                Objects.equals(this.idCliente, entity.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoCuenta, tipoServicio, tarifaNegociada, idCliente);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipoCuenta = " + tipoCuenta + ", " +
                "tipoServicio = " + tipoServicio + ", " +
                "tarifaNegociada = " + tarifaNegociada + ", " +
                "idCliente = " + idCliente + ")";
    }
}