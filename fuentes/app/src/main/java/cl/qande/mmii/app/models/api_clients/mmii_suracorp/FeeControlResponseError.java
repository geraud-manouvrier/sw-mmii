package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeeControlResponseError {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;

    public FeeControlResponseError() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FeeControlResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
