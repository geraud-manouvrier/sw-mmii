package cl.qande.mmii.app.models.dto;

import cl.qande.mmii.app.models.db.clientes.entity.PersonaRelacionada;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link PersonaRelacionada}
 */
public class PersonaRelacionadaDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 100)
    private String identificador;
    @NotNull
    @Size(max = 100)
    private String nombre;
    @NotNull
    private Integer idTipoIdentificador;
    @NotNull
    private Integer idCliente;
    @NotNull
    private Boolean flagHabilitado;
    @NotNull
    private Instant creacionTs;
    @NotNull
    @Size(max = 100)
    private String creacionUser;
    private Instant modificacionTs;
    @Size(max = 100)
    private String modificacionUser;
    @Size(max = 100)
    private String idCargo;


    public PersonaRelacionadaDto() {
    }

    public PersonaRelacionadaDto(Integer id, String identificador, String nombre, Integer idTipoIdentificador, Integer idCliente, Boolean flagHabilitado, Instant creacionTs, String creacionUser, Instant modificacionTs, String modificacionUser,
                                 String idCargo) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.idTipoIdentificador = idTipoIdentificador;
        this.idCliente = idCliente;
        this.flagHabilitado = flagHabilitado;
        this.creacionTs = creacionTs;
        this.creacionUser = creacionUser;
        this.modificacionTs = modificacionTs;
        this.modificacionUser = modificacionUser;
        this.idCargo = idCargo;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getFlagHabilitado() {
        return flagHabilitado;
    }

    public void setFlagHabilitado(Boolean flagHabilitado) {
        this.flagHabilitado = flagHabilitado;
    }

    public Instant getCreacionTs() {
        return creacionTs;
    }

    public void setCreacionTs(Instant creacionTs) {
        this.creacionTs = creacionTs;
    }

    public String getCreacionUser() {
        return creacionUser;
    }

    public void setCreacionUser(String creacionUser) {
        this.creacionUser = creacionUser;
    }

    public Instant getModificacionTs() {
        return modificacionTs;
    }

    public void setModificacionTs(Instant modificacionTs) {
        this.modificacionTs = modificacionTs;
    }

    public String getModificacionUser() {
        return modificacionUser;
    }

    public void setModificacionUser(String modificacionUser) {
        this.modificacionUser = modificacionUser;
    }


        public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaRelacionadaDto that = (PersonaRelacionadaDto) o;
        return Objects.equals(id, that.id) && Objects.equals(identificador, that.identificador) && Objects.equals(nombre, that.nombre) && Objects.equals(idTipoIdentificador, that.idTipoIdentificador) && Objects.equals(idCliente, that.idCliente) && Objects.equals(flagHabilitado, that.flagHabilitado) && Objects.equals(creacionTs, that.creacionTs) && Objects.equals(creacionUser, that.creacionUser) && Objects.equals(modificacionTs, that.modificacionTs) && Objects.equals(modificacionUser, that.modificacionUser) && Objects.equals(idCargo, that.idCargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificador, nombre, idTipoIdentificador, idCliente, flagHabilitado, creacionTs, creacionUser, modificacionTs, modificacionUser, idCargo);
    }

    @Override
    public String toString() {
        return "PersonaRelacionadaDto{" +
                "id=" + id +
                ", identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idTipoIdentificador=" + idTipoIdentificador +
                ", idCliente=" + idCliente +
                ", flagHabilitado=" + flagHabilitado +
                ", creacionTs=" + creacionTs +
                ", creacionUser='" + creacionUser + '\'' +
                ", modificacionTs=" + modificacionTs +
                ", modificacionUser='" + modificacionUser + '\'' +
                ", idCargo='" + idCargo + '\'' +
                '}';
    }
}