package cl.qande.mmii.app.models.api_clients.mmii_suracorp;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ParSourceCode {
    @JsonProperty("id")
    private Long id;
    @NotNull
    @Size(max = 100)
    @JsonProperty("sourceCodePershing")
    private String sourceCodePershing;
    @JsonProperty("signoMovimiento")
    private Integer signoMovimiento;
    @NotNull
    @Size(max = 100)
    @JsonProperty("descripcionMovimiento")
    private String descripcionMovimiento;
    @NotNull
    @JsonProperty("aplicaFlujoNeto")
    private Integer aplicaFlujoNeto;
    @Size(max = 1000)
    @JsonProperty("observacionesInternas")
    private String observacionesInternas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(max = 100) String getSourceCodePershing() {
        return sourceCodePershing;
    }

    public void setSourceCodePershing(@NotNull @Size(max = 100) String sourceCodePershing) {
        this.sourceCodePershing = sourceCodePershing;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
    }

    public @NotNull @Size(max = 100) String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(@NotNull @Size(max = 100) String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public @NotNull Integer getAplicaFlujoNeto() {
        return aplicaFlujoNeto;
    }

    public void setAplicaFlujoNeto(@NotNull Integer aplicaFlujoNeto) {
        this.aplicaFlujoNeto = aplicaFlujoNeto;
    }

    public @Size(max = 1000) String getObservacionesInternas() {
        return observacionesInternas;
    }

    public void setObservacionesInternas(@Size(max = 1000) String observacionesInternas) {
        this.observacionesInternas = observacionesInternas;
    }

    @Override
    public String toString() {
        return "ParSourceCode{" +
                "id=" + id +
                ", sourceCodePershing='" + sourceCodePershing + '\'' +
                ", signoMovimiento=" + signoMovimiento +
                ", descripcionMovimiento='" + descripcionMovimiento + '\'' +
                ", aplicaFlujoNeto=" + aplicaFlujoNeto +
                ", observacionesInternas='" + observacionesInternas + '\'' +
                '}';
    }
}