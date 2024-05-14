package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class Contrato {

    private String id;
    @JsonProperty("tipo-cuenta")
    private String tipoCuenta;
    @JsonProperty("tipo-servicio")
    private String tipoServicio;
    @JsonProperty("tarifa-negociada")
    private BigDecimal tarifaNegociada;
    private List<Cuenta> cuentas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public BigDecimal getTarifaNegociada() {
        return tarifaNegociada;
    }

    public void setTarifaNegociada(BigDecimal tarifaNegociada) {
        this.tarifaNegociada = tarifaNegociada;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + id + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", tarifaNegociada=" + tarifaNegociada +
                ", cuentas=" + cuentas +
                '}';
    }
}
