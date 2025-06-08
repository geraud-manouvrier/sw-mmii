package cl.qande.mmii.app.models.db.clientes.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "persona_relacionada", schema = "clientes")
public class PersonaRelacionada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "identificador", nullable = false, length = 100)
    private String identificador;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Column(name = "id_tipo_identificador", nullable = false)
    private Integer idTipoIdentificador;

    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @NotNull
    @Column(name = "flag_habilitado", nullable = false)
    private Boolean flagHabilitado = false;

    @NotNull
    @Column(name = "creacion_ts", nullable = false)
    private Instant creacionTs;

    @Size(max = 100)
    @NotNull
    @Column(name = "creacion_user", nullable = false, length = 100)
    private String creacionUser;

    @Column(name = "modificacion_ts")
    private Instant modificacionTs;

    @Size(max = 100)
    @Column(name = "modificacion_user", length = 100)
    private String modificacionUser;

    @Size(max = 100)
    @Column(name = "id_cargo", length = 100)
    private String idCargo;

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
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

}