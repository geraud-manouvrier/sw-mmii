package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class ListAccountRequest {

    private String processDate;
    private String custodian;
    private List<String> accountsList;

    protected ListAccountRequest() {
        this.accountsList = new ArrayList<>();
    }

    protected ListAccountRequest(String processDate, String custodian, List<String> accountsList) {
        this.processDate = processDate;
        this.custodian = custodian;
        this.accountsList = accountsList;
    }
}
