package cl.qande.mmii.app.models.api;

import java.util.List;

public class ApiResponseErrorClientes extends ApiResponse {

    private List<Cliente> clientesError;

    public ApiResponseErrorClientes() {
    }

    public ApiResponseErrorClientes(Integer code, String message, List<Cliente> clientesError) {
        this.setCode(code);
        this.setMessage(message);
        this.clientesError = clientesError;
    }


    public List<Cliente> getClientesError() {
        return clientesError;
    }

    public void setClientesError(List<Cliente> clientesError) {
        this.clientesError = clientesError;
    }
}
