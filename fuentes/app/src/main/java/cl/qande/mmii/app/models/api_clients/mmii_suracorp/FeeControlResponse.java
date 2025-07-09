package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class FeeControlResponse  {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("client-fee")
    private List<AccountFeeValidated> accountsFeesValidated;

    public FeeControlResponse() {
        this.accountsFeesValidated = new ArrayList<>();
    }

    public FeeControlResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.accountsFeesValidated = new ArrayList<>();
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

    public List<AccountFeeValidated> getAccountsFeesValidated() {
        return accountsFeesValidated;
    }

    public void setAccountsFeesValidated(List<AccountFeeValidated> accountsFeesValidated) {
        this.accountsFeesValidated = accountsFeesValidated;
    }

    @Override
    public String toString() {
        return "FeeControlResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", accountsFeesValidated=" + accountsFeesValidated +
                '}';
    }
}
