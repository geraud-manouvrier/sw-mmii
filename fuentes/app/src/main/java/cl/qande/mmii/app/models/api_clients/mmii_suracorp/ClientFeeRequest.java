package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientFeeRequest {
    private String custodian;
    @JsonProperty("account-number")
    private String accountNumber;

    public ClientFeeRequest(String custodian, String accountNumber) {
        this.custodian = custodian;
        this.accountNumber = accountNumber;
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

    @Override
    public String toString() {
        return "FeeRequest{" +
                "custodian='" + custodian + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
