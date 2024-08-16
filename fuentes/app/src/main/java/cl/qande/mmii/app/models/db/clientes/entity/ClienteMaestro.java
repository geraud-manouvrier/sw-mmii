package cl.qande.mmii.app.models.db.clientes.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_maestro_clientes", schema = "clientes")
public class ClienteMaestro {
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 100)
    @Column(name = "identificador", length = 100)
    private String identificador;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "id_tipo_identificador")
    private Integer idTipoIdentificador;

    @Size(max = 100)
    @Column(name = "tipo_identificador", length = 100)
    private String tipoIdentificador;

    @Size(max = 100)
    @Column(name = "glosa_identificador", length = 100)
    private String glosaIdentificador;

    @Column(name = "habilitado")
    private Boolean habilitado;

    @Size(max = 100)
    @Column(name = "lista_cuentas", length = 100)
    private String listaCuentas;

    public Integer getId() {
        return id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdTipoIdentificador() {
        return idTipoIdentificador;
    }

    public String getTipoIdentificador() {
        return tipoIdentificador;
    }

    public String getGlosaIdentificador() {
        return glosaIdentificador;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public String getListaCuentas() {
        return listaCuentas;
    }

}