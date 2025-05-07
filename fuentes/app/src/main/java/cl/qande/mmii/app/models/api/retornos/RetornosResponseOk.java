package cl.qande.mmii.app.models.api.retornos;

import cl.qande.mmii.app.models.api.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RetornosResponseOk extends ApiResponse {

    @JsonProperty("lista-retornos")
    private List<RetornoCuenta> retornoCuentas;

    public RetornosResponseOk(List<RetornoCuenta> retornoCuentas) {
        this.retornoCuentas = retornoCuentas;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public RetornosResponseOk() {
        this.retornoCuentas = new ArrayList<>();
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }



    public List<RetornoCuenta> getRetornoCuentas() {
        return retornoCuentas;
    }

    public void setRetornoCuentas(List<RetornoCuenta> retornoCuentas) {
        this.retornoCuentas = retornoCuentas;
    }
}
