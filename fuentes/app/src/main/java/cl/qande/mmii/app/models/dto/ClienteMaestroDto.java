package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.clientes.entity.ClienteMaestro}
 */
public class ClienteMaestroDto implements Serializable {
    private Integer id;
    @Size(max = 100)
    private String identificador;
    @Size(max = 100)
    private String nombre;
    private Integer idTipoIdentificador;
    @Size(max = 100)
    private String tipoIdentificador;
    @Size(max = 100)
    private String glosaIdentificador;
    private Boolean habilitado;
    @Size(max = 100)
    private String listaCuentas;

    public ClienteMaestroDto() {
    }

    @SuppressWarnings("squid:S00107")
    public ClienteMaestroDto(Integer id, String identificador, String nombre, Integer idTipoIdentificador, String tipoIdentificador, String glosaIdentificador, Boolean habilitado, String listaCuentas) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.idTipoIdentificador = idTipoIdentificador;
        this.tipoIdentificador = tipoIdentificador;
        this.glosaIdentificador = glosaIdentificador;
        this.habilitado = habilitado;
        this.listaCuentas = listaCuentas;
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

    public String getTipoIdentificador() {
        return tipoIdentificador;
    }

    public void setTipoIdentificador(String tipoIdentificador) {
        this.tipoIdentificador = tipoIdentificador;
    }

    public String getGlosaIdentificador() {
        return glosaIdentificador;
    }

    public void setGlosaIdentificador(String glosaIdentificador) {
        this.glosaIdentificador = glosaIdentificador;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(String listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteMaestroDto entity = (ClienteMaestroDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.identificador, entity.identificador) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.idTipoIdentificador, entity.idTipoIdentificador) &&
                Objects.equals(this.tipoIdentificador, entity.tipoIdentificador) &&
                Objects.equals(this.glosaIdentificador, entity.glosaIdentificador) &&
                Objects.equals(this.habilitado, entity.habilitado) &&
                Objects.equals(this.listaCuentas, entity.listaCuentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador, nombre, idTipoIdentificador, tipoIdentificador, glosaIdentificador, habilitado, listaCuentas);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "identificador = " + identificador + ", " +
                "nombre = " + nombre + ", " +
                "idTipoIdentificador = " + idTipoIdentificador + ", " +
                "tipoIdentificador = " + tipoIdentificador + ", " +
                "glosaIdentificador = " + glosaIdentificador + ", " +
                "habilitado = " + habilitado + ", " +
                "listaCuentas = " + listaCuentas + ")";
    }
}