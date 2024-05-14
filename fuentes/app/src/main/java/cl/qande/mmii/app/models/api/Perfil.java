package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Perfil {
    private String id;
    private String portfolio;

    @JsonProperty("monto-comprometido")
    private BigDecimal montoComprometido;
    @JsonProperty("horizonte-objetivo")
    private String horizonteObjetivo;
    @JsonProperty("exencion-responsabilidad")
    private String exencionResponsabilidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public BigDecimal getMontoComprometido() {
        return montoComprometido;
    }

    public void setMontoComprometido(BigDecimal montoComprometido) {
        this.montoComprometido = montoComprometido;
    }

    public String getHorizonteObjetivo() {
        return horizonteObjetivo;
    }

    public void setHorizonteObjetivo(String horizonteObjetivo) {
        this.horizonteObjetivo = horizonteObjetivo;
    }

    public String getExencionResponsabilidad() {
        return exencionResponsabilidad;
    }

    public void setExencionResponsabilidad(String exencionResponsabilidad) {
        this.exencionResponsabilidad = exencionResponsabilidad;
    }


    @Override
    public String toString() {
        return "Perfil{" +
                "id='" + id + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", montoComprometido=" + montoComprometido +
                ", horizonteObjetivo='" + horizonteObjetivo + '\'' +
                ", exencionResponsabilidad='" + exencionResponsabilidad + '\'' +
                '}';
    }
}
