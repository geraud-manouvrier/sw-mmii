package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Cuenta {

    @JsonProperty("id-cuenta-sura")
    private String idCuentaSura;
    @JsonProperty("id-cuenta-custodio")
    private String idCuentaCustodio;
    private String custodio;
    @JsonProperty("modelo-asesoria")
    private String modeloAsesoria;
    @JsonProperty("monto-fondeo")
    private BigDecimal montoFondeo;
    private Perfil perfil;
    @JsonProperty("cod-pais-atencion")
    private Integer codPaisAtencion;
    @JsonProperty("descripcion-objetivo")
    private String descripcionObjetivo;
    @JsonProperty("beneficiarios")
    private String beneficiarios;

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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
    public String toString() {
        return "Cuenta{" +
                "idCuentaSura='" + idCuentaSura + '\'' +
                ", idCuentaCustodio='" + idCuentaCustodio + '\'' +
                ", custodio='" + custodio + '\'' +
                ", modeloAsesoria='" + modeloAsesoria + '\'' +
                ", montoFondeo=" + montoFondeo +
                ", perfil=" + perfil +
                ", codPaisAtencion=" + codPaisAtencion +
                ", descripcionObjetivo='" + descripcionObjetivo + '\'' +
                ", beneficiarios='" + beneficiarios + '\'' +
                '}';
    }

}
