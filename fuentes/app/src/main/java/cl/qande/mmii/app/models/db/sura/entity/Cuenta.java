package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta", schema = "sura")
public class Cuenta {
    @Id
    @Size(max = 100)
    @Column(name = "id_cuenta_sura", nullable = false, length = 100)
    private String idCuentaSura;

    @Size(max = 100)
    @NotNull
    @Column(name = "id_cuenta_custodio", nullable = false, length = 100)
    private String idCuentaCustodio;

    @NotNull
    @Column(name = "custodio", nullable = false)
    private String custodio;

    @NotNull
    @Column(name = "modelo_asesoria", nullable = false)
    private String modeloAsesoria;

    @NotNull
    @Column(name = "monto_fondeo", nullable = false, precision = 45, scale = 20)
    private BigDecimal montoFondeo;

    @NotNull
    @Column(name = "id_contrato", nullable = false)
    private String idContrato;

    @Column(name = "cod_pais_atencion")
    private Integer codPaisAtencion;

    @Size(max = 100)
    @Column(name = "descripcion_objetivo", length = 100)
    private String descripcionObjetivo;

    @Size(max = 100)
    @Column(name = "beneficiarios", length = 100)
    private String beneficiarios;

    public String getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(String beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public String getDescripcionObjetivo() {
        return descripcionObjetivo;
    }

    public void setDescripcionObjetivo(String descripcionObjetivo) {
        this.descripcionObjetivo = descripcionObjetivo;
    }

    public Integer getCodPaisAtencion() {
        return codPaisAtencion;
    }

    public void setCodPaisAtencion(Integer codPaisAtencion) {
        this.codPaisAtencion = codPaisAtencion;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public String getIdCuentaSura() {
        return idCuentaSura;
    }

    public void setIdCuentaSura(String idCuentaSura) {
        this.idCuentaSura = idCuentaSura;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public void setIdCuentaCustodio(String idCuentaCustodio) {
        this.idCuentaCustodio = idCuentaCustodio;
    }

    public String getCustodio() {
        return custodio;
    }

    public void setCustodio(String custodio) {
        this.custodio = custodio;
    }

    public String getModeloAsesoria() {
        return modeloAsesoria;
    }

    public void setModeloAsesoria(String modeloAsesoria) {
        this.modeloAsesoria = modeloAsesoria;
    }

    public BigDecimal getMontoFondeo() {
        return montoFondeo;
    }

    public void setMontoFondeo(BigDecimal montoFondeo) {
        this.montoFondeo = montoFondeo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuentaSura='" + idCuentaSura + '\'' +
                ", idCuentaCustodio='" + idCuentaCustodio + '\'' +
                ", custodio='" + custodio + '\'' +
                ", modeloAsesoria='" + modeloAsesoria + '\'' +
                ", montoFondeo=" + montoFondeo +
                ", idContrato='" + idContrato + '\'' +
                '}';
    }
}