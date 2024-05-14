package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContratoRequest {
    @JsonProperty("id-cliente")
    private String idCliente;
    @JsonProperty("contrato")
    private Contrato contrato;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "ContratoRequest{" +
                "idCliente='" + idCliente + '\'' +
                ", contrato=" + contrato +
                '}';
    }
}
