package cl.qande.mmii.app.models.dto;

import cl.qande.mmii.app.models.db.clientes.entity.Cliente;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Cliente}
 */
public class ClienteDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String identificador;
    @NotNull
    @Size(max = 100)
    private String nombre;
    @NotNull
    private Integer idTipoIdentificador;
    private BigDecimal fee;


    public ClienteDto() {
    }

    public ClienteDto(Integer id, String identificador, String nombre, Integer idTipoIdentificador,
                      BigDecimal fee) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.idTipoIdentificador = idTipoIdentificador;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoIdentificador() {
        return idTipoIdentificador;
    }

    public void setIdTipoIdentificador(Integer idTipoIdentificador) {
        this.idTipoIdentificador = idTipoIdentificador;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto that = (ClienteDto) o;
        return Objects.equals(id, that.id) && Objects.equals(identificador, that.identificador) && Objects.equals(nombre, that.nombre) && Objects.equals(idTipoIdentificador, that.idTipoIdentificador) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador, nombre, idTipoIdentificador, fee);
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idTipoIdentificador=" + idTipoIdentificador +
                ", fee=" + fee +
                '}';
    }
}