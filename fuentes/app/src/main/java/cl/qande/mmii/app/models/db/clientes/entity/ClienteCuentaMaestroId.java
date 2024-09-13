package cl.qande.mmii.app.models.db.clientes.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClienteCuentaMaestroId implements Serializable {
    private static final long serialVersionUID = 207130239121852480L;
    @Column(name = "id_interno_cliente")
    private Integer idInternoCliente;

    @Column(name = "id_interno_cuenta")
    private Integer idInternoCuenta;

    public Integer getIdInternoCliente() {
        return idInternoCliente;
    }

    public Integer getIdInternoCuenta() {
        return idInternoCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClienteCuentaMaestroId entity = (ClienteCuentaMaestroId) o;
        return Objects.equals(this.idInternoCliente, entity.idInternoCliente) &&
                Objects.equals(this.idInternoCuenta, entity.idInternoCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInternoCliente, idInternoCuenta);
    }

}