package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import java.util.List;

public class ListFeeRequest extends ListAccountRequest {

    public ListFeeRequest() {
        super();
    }

    public ListFeeRequest(String processDate, String custodian, List<String> accountsList) {
        super(processDate, custodian, accountsList);
    }
}
