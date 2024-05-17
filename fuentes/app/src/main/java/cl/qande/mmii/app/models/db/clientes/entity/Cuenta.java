package cl.qande.mmii.app.models.db.clientes.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cuenta", schema = "clientes")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Size(max = 100)
    @NotNull
    @Column(name = "id_custodio", nullable = false, length = 100)
    private String idCustodio;

    @Size(max = 100)
    @NotNull
    @Column(name = "id_cuenta_custodio", nullable = false, length = 100)
    private String idCuentaCustodio;

    @NotNull
    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado = false;

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

}