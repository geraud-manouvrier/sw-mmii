package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class FeeControlRequest {

    @JsonProperty("custodian")
    private String custodian;
    @JsonProperty("accountsFees")
    private List<AccountFee> accountsFees;

    public FeeControlRequest() {
        this.accountsFees = new ArrayList<>();
    }

    public FeeControlRequest(String custodian, List<AccountFee> accountsFees) {
        this.custodian = custodian;
        this.accountsFees = accountsFees;
    }

    public List<AccountFee> getAccountsFees() {
        return accountsFees;
    }

    public void setAccountsFees(List<AccountFee> accountsFees) {
        this.accountsFees = accountsFees;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    @Override
    public String toString() {
        return "FeeControlRequest{" +
                "custodian='" + custodian + '\'' +
                ", accountsFees=" + accountsFees +
                '}';
    }
}
