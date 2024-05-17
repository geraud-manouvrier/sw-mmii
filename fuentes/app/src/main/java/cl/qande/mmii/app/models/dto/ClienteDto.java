package cl.qande.mmii.app.models.dto;

import cl.qande.mmii.app.models.db.clientes.entity.Cliente;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

    public ClienteDto() {
    }

    public ClienteDto(Integer id, String identificador, String nombre, Integer idTipoIdentificador) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.idTipoIdentificador = idTipoIdentificador;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto entity = (ClienteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.identificador, entity.identificador) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.idTipoIdentificador, entity.idTipoIdentificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador, nombre, idTipoIdentificador);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "identificador = " + identificador + ", " +
                "nombre = " + nombre + ", " +
                "idTipoIdentificador = " + idTipoIdentificador + ")";
    }
}