package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ListFeeRequest {

    private String processDate;
    private String custodian;
    private List<String> accountsList;

    public ListFeeRequest() {
        this.accountsList = new ArrayList<>();
    }

    public ListFeeRequest(String processDate, String custodian, List<String> accountsList) {
        this.processDate = processDate;
        this.custodian = custodian;
        this.accountsList = accountsList;
    }
}
