package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import java.util.List;

public class ListPortfolioRequest extends ListAccountRequest {

    public ListPortfolioRequest() {
        super();
    }

    public ListPortfolioRequest(String processDate, String custodian, List<String> accountsList) {
        super(processDate, custodian, accountsList);
    }
}
