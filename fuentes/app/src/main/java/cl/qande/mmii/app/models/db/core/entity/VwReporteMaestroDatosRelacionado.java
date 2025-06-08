package cl.qande.mmii.app.models.db.core.entity;

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
@Table(name = "vw_reporte_maestro_datos_relacionados")
public class VwReporteMaestroDatosRelacionado {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "id_interno_cliente")
    private Integer idInternoCliente;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Size(max = 100)
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Size(max = 100)
    @Column(name = "tipo_identificador_cliente", length = 100)
    private String tipoIdentificadorCliente;

    @Size(max = 100)
    @Column(name = "glosa_identificador_cliente", length = 100)
    private String glosaIdentificadorCliente;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "id_relacionado")
    private Integer idRelacionado;

    @Size(max = 100)
    @Column(name = "identificador_relacionado", length = 100)
    private String identificadorRelacionado;

    @Size(max = 100)
    @Column(name = "nombre_relacionado", length = 100)
    private String nombreRelacionado;

    @Size(max = 100)
    @Column(name = "tipo_identificador_relacionado", length = 100)
    private String tipoIdentificadorRelacionado;

    @Size(max = 100)
    @Column(name = "glosa_tipo_identificador_relacionado", length = 100)
    private String glosaTipoIdentificadorRelacionado;

    @Size(max = 100)
    @Column(name = "id_cargo", length = 100)
    private String idCargo;

    @Size(max = 100)
    @Column(name = "cargo", length = 100)
    private String cargo;

    public Long getId() {
        return id;
    }

    public String getProcessDate() {
        return processDate;
    }

    public Integer getIdInternoCliente() {
        return idInternoCliente;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public String getGlosaIdentificadorCliente() {
        return glosaIdentificadorCliente;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getName() {
        return name;
    }

    public Integer getIdRelacionado() {
        return idRelacionado;
    }

    public String getIdentificadorRelacionado() {
        return identificadorRelacionado;
    }

    public String getNombreRelacionado() {
        return nombreRelacionado;
    }

    public String getTipoIdentificadorRelacionado() {
        return tipoIdentificadorRelacionado;
    }

    public String getGlosaTipoIdentificadorRelacionado() {
        return glosaTipoIdentificadorRelacionado;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public String getCargo() {
        return cargo;
    }

}