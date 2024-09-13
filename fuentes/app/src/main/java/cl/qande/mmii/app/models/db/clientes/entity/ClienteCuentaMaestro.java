package cl.qande.mmii.app.models.db.clientes.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_maestro_clientes_cuentas", schema = "clientes")
public class ClienteCuentaMaestro {
    @EmbeddedId
    private ClienteCuentaMaestroId id;

    @Size(max = 100)
    @Column(name = "identificador_cliente", length = 100)
    private String identificadorCliente;

    @Size(max = 100)
    @Column(name = "nombre_cliente", length = 100)
    private String nombreCliente;

    @Column(name = "id_tipo_identificador_cliente")
    private Integer idTipoIdentificadorCliente;

    @Size(max = 100)
    @Column(name = "tipo_identificador_cliente", length = 100)
    private String tipoIdentificadorCliente;

    @Size(max = 100)
    @Column(name = "glosa_identificador_cliente", length = 100)
    private String glosaIdentificadorCliente;

    @Size(max = 100)
    @Column(name = "id_custodio", length = 100)
    private String idCustodio;

    @Size(max = 100)
    @Column(name = "id_cuenta_custodio", length = 100)
    private String idCuentaCustodio;

    @Column(name = "habilitado")
    private Boolean habilitado;

    public ClienteCuentaMaestroId getId() {
        return id;
    }

    public void setId(ClienteCuentaMaestroId id) {
        this.id = id;
    }

    public String getIdentificadorCliente() {
        return identificadorCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Integer getIdTipoIdentificadorCliente() {
        return idTipoIdentificadorCliente;
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public String getGlosaIdentificadorCliente() {
        return glosaIdentificadorCliente;
    }

    public String getIdCustodio() {
        return idCustodio;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }


}