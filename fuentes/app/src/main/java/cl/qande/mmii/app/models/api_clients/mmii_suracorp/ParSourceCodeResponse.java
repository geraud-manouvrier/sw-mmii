package cl.qande.mmii.app.models.api_clients.mmii_suracorp;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParSourceCodeResponse {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("listaParSourceCode")
    private List<ParSourceCode> listaParSourceCode;


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

    public List<ParSourceCode> getListaParSourceCode() {
        return listaParSourceCode;
    }

    public void setListaParSourceCode(List<ParSourceCode> listaParSourceCode) {
        this.listaParSourceCode = listaParSourceCode;
    }

    @Override
    public String toString() {
        return "ParSourceCodeResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", listaParSourceCode=" + listaParSourceCode +
                '}';
    }
}
