package cl.qande.mmii.app.models.dto.clientes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.clientes.entity.Cuenta}
 */
public class CuentaDto implements Serializable {
    private Integer id;
    @NotNull
    private Integer idCliente;
    @NotNull
    @Size(max = 100)
    private String idCustodio;
    @NotNull
    @Size(max = 100)
    private String idCuentaCustodio;
    @NotNull
    private Boolean habilitado = false;
    @NotNull
    private BigDecimal fee;


    public CuentaDto() {
    }

    public CuentaDto(Integer id, Integer idCliente, String idCustodio, String idCuentaCustodio, Boolean habilitado,
                     BigDecimal fee) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCustodio = idCustodio;
        this.idCuentaCustodio = idCuentaCustodio;
        this.habilitado = habilitado;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCustodio() {
        return idCustodio;
    }

    public void setIdCustodio(String idCustodio) {
        this.idCustodio = idCustodio;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public void setIdCuentaCustodio(String idCuentaCustodio) {
        this.idCuentaCustodio = idCuentaCustodio;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaDto cuentaDto = (CuentaDto) o;
        return Objects.equals(id, cuentaDto.id) && Objects.equals(idCliente, cuentaDto.idCliente) && Objects.equals(idCustodio, cuentaDto.idCustodio) && Objects.equals(idCuentaCustodio, cuentaDto.idCuentaCustodio) && Objects.equals(habilitado, cuentaDto.habilitado) && Objects.equals(fee, cuentaDto.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCliente, idCustodio, idCuentaCustodio, habilitado, fee);
    }

    @Override
    public String toString() {
        return "CuentaDto{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idCustodio='" + idCustodio + '\'' +
                ", idCuentaCustodio='" + idCuentaCustodio + '\'' +
                ", habilitado=" + habilitado +
                ", fee=" + fee +
                '}';
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}