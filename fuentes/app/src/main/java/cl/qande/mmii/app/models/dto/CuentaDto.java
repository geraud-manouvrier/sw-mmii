package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.sura.entity.Cuenta}
 */
public class CuentaDto implements Serializable {
    @Size(max = 100)
    private String idCuentaSura;
    @NotNull
    @Size(max = 100)
    private String idCuentaCustodio;
    @NotNull
    private String custodio;
    @NotNull
    private String modeloAsesoria;
    @NotNull
    private BigDecimal montoFondeo;
    @NotNull
    private String idContrato;
    private Integer codPaisAtencion;
    @Size(max = 100)
    private String descripcionObjetivo;
    @Size(max = 100)
    private String beneficiarios;

    public CuentaDto() {
    }

    public CuentaDto(String idCuentaSura, String idCuentaCustodio, String custodio, String modeloAsesoria, BigDecimal montoFondeo, String idContrato, Integer codPaisAtencion, String descripcionObjetivo, String beneficiarios) {
        this.idCuentaSura = idCuentaSura;
        this.idCuentaCustodio = idCuentaCustodio;
        this.custodio = custodio;
        this.modeloAsesoria = modeloAsesoria;
        this.montoFondeo = montoFondeo;
        this.idContrato = idContrato;
        this.codPaisAtencion = codPaisAtencion;
        this.descripcionObjetivo = descripcionObjetivo;
        this.beneficiarios = beneficiarios;
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

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getCodPaisAtencion() {
        return codPaisAtencion;
    }

    public void setCodPaisAtencion(Integer codPaisAtencion) {
        this.codPaisAtencion = codPaisAtencion;
    }

    public String getDescripcionObjetivo() {
        return descripcionObjetivo;
    }

    public void setDescripcionObjetivo(String descripcionObjetivo) {
        this.descripcionObjetivo = descripcionObjetivo;
    }

    public String getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(String beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaDto entity = (CuentaDto) o;
        return Objects.equals(this.idCuentaSura, entity.idCuentaSura) &&
                Objects.equals(this.idCuentaCustodio, entity.idCuentaCustodio) &&
                Objects.equals(this.custodio, entity.custodio) &&
                Objects.equals(this.modeloAsesoria, entity.modeloAsesoria) &&
                Objects.equals(this.montoFondeo, entity.montoFondeo) &&
                Objects.equals(this.idContrato, entity.idContrato) &&
                Objects.equals(this.codPaisAtencion, entity.codPaisAtencion) &&
                Objects.equals(this.descripcionObjetivo, entity.descripcionObjetivo) &&
                Objects.equals(this.beneficiarios, entity.beneficiarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuentaSura, idCuentaCustodio, custodio, modeloAsesoria, montoFondeo, idContrato, codPaisAtencion, descripcionObjetivo, beneficiarios);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idCuentaSura = " + idCuentaSura + ", " +
                "idCuentaCustodio = " + idCuentaCustodio + ", " +
                "custodio = " + custodio + ", " +
                "modeloAsesoria = " + modeloAsesoria + ", " +
                "montoFondeo = " + montoFondeo + ", " +
                "idContrato = " + idContrato + ", " +
                "codPaisAtencion = " + codPaisAtencion + ", " +
                "descripcionObjetivo = " + descripcionObjetivo + ", " +
                "beneficiarios = " + beneficiarios + ")";
    }
}