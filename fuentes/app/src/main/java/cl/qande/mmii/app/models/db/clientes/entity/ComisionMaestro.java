package cl.qande.mmii.app.models.db.clientes.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_maestro_comision", schema = "clientes")
public class ComisionMaestro {
    @Id
    @Column(name = "row_id")
    private Long rowId;

    @Column(name = "id")
    private Long id;

    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @Column(name = "comision_diaria_saldo", precision = 45, scale = 20)
    private BigDecimal comisionDiariaSaldo;

    @Column(name = "fecha_inicio_vigencia")
    private Date fechaInicioVigencia;

    @Column(name = "log_fecha_creacion")
    private Date logFechaCreacion;

    @Size(max = 100)
    @Column(name = "log_usuario_creacion", length = 100)
    private String logUsuarioCreacion;

    @Column(name = "id_interno_cliente")
    private Integer idInternoCliente;

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

    @Column(name = "id_interno_cuenta")
    private Integer idInternoCuenta;

    @Size(max = 100)
    @Column(name = "id_custodio", length = 100)
    private String idCustodio;

    @Size(max = 100)
    @Column(name = "id_cuenta_custodio", length = 100)
    private String idCuentaCustodio;

    @Column(name = "habilitado")
    private Boolean habilitado;

    public Long getRowId() {
        return rowId;
    }

    public Long getId() {
        return id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public BigDecimal getComisionDiariaSaldo() {
        return comisionDiariaSaldo;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public Date getLogFechaCreacion() {
        return logFechaCreacion;
    }

    public String getLogUsuarioCreacion() {
        return logUsuarioCreacion;
    }

    public Integer getIdInternoCliente() {
        return idInternoCliente;
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

    public Integer getIdInternoCuenta() {
        return idInternoCuenta;
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