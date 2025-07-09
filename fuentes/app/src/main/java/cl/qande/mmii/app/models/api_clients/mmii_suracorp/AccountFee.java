package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AccountFee {
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("fee")
    private BigDecimal fee;

    public AccountFee(String accountNumber, BigDecimal fee) {
        this.accountNumber = accountNumber;
        this.fee = fee;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "AccountFee{" +
                ", accountNumber='" + accountNumber + '\'' +
                ", fee=" + fee +
                '}';
    }
}
