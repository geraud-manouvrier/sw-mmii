package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import cl.qande.mmii.app.models.api.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ListPortfolioResponse extends ApiResponse {

    private List<ClientPortfolio> accountsPortfolios;

    public ListPortfolioResponse() {
        this.accountsPortfolios = new ArrayList<>();
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public ListPortfolioResponse(List<ClientPortfolio> accountsPortfolios) {
        this.accountsPortfolios      = accountsPortfolios;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }
}
