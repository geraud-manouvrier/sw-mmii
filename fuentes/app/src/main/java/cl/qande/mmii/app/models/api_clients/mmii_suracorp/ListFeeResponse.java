package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import cl.qande.mmii.app.models.api.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ListFeeResponse extends ApiResponse {

    private List<ClientFee> accountsFees;

    public ListFeeResponse() {
        this.accountsFees = new ArrayList<>();
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public ListFeeResponse(List<ClientFee> accountsFees) {
        this.accountsFees      = accountsFees;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }
}
