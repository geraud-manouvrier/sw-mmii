package cl.qande.mmii.app.models.api;

import java.util.List;

public class ApiResponseErrorContratos extends ApiResponse {

    private List<Contrato> contratosError;

    public ApiResponseErrorContratos() {
    }

    public ApiResponseErrorContratos(Integer code, String message, List<Contrato> contratosError) {
        this.setCode(code);
        this.setMessage(message);
        this.contratosError = contratosError;
    }


    public List<Contrato> getContratosError() {
        return contratosError;
    }

    public void setContratosError(List<Contrato> contratosError) {
        this.contratosError = contratosError;
    }
}
