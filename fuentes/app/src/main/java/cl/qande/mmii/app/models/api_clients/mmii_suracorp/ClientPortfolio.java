package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientPortfolio {
    private String custodian;
    @JsonProperty("account-number")
    private String accountNumber;
    private String portfolio;

    public ClientPortfolio() {
        // Constructor vacío requerido por Jackson
    }

    public ClientPortfolio(String custodian, String accountNumber, String portfolio) {
        this.custodian      = custodian;
        this.accountNumber  = accountNumber;
        this.portfolio      = portfolio;
    }


}
