package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import cl.qande.mmii.app.models.api.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientFeeResponse extends ApiResponse {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("client-fee")
    private ClientFee clientFee;

    public ClientFee getClientFee() {
        return clientFee;
    }

    public void setClientFee(ClientFee clientFee) {
        this.clientFee = clientFee;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ClientFeeResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", clientFee=" + clientFee +
                '}';
    }
}
