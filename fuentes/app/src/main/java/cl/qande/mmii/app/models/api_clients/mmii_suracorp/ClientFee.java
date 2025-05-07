package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ClientFee {
    private String custodian;
    @JsonProperty("account-number")
    private String accountNumber;
    private BigDecimal fee;

    public ClientFee(String custodian, String accountNumber, BigDecimal fee) {
        this.custodian      = custodian;
        this.accountNumber  = accountNumber;
        this.fee            = fee;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
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
        return "ClientFee{" +
                "custodian='" + custodian + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", fee=" + fee +
                '}';
    }
}
