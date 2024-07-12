package cl.qande.mmii.app.models.db.core.entity;

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
@Table(name = "vw_cuentas_no_mapeadas_pershing")
public class VwCuentasNoMapeadasPershing {
    @EmbeddedId
    private VwCuentasNoMapeadasPershingId id;

    @Size(max = 100)
    @Column(name = "client_name", length = 100)
    private String clientName;

    public VwCuentasNoMapeadasPershingId getId() {
        return id;
    }

    public void setId(VwCuentasNoMapeadasPershingId id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    protected VwCuentasNoMapeadasPershing() {
    }
}