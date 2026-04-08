package cl.qande.mmii.app.models.dto.core;

import java.io.Serializable;

public class FechasRecaudosFromMaestroMovDto implements Serializable {

    private String clientId;
    private String accountNo;
    private String firstMovDate;
    private String lastMovDate;

    public FechasRecaudosFromMaestroMovDto(String clientId, String accountNo, String firstMovDate, String lastMovDate) {
        this.clientId = clientId;
        this.accountNo = accountNo;
        this.firstMovDate = firstMovDate;
        this.lastMovDate = lastMovDate;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getFirstMovDate() {
        return firstMovDate;
    }

    public String getLastMovDate() {
        return lastMovDate;
    }
}
