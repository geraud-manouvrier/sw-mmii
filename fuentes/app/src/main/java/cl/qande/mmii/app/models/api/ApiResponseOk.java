package cl.qande.mmii.app.models.api;

public class ApiResponseOk extends ApiResponse {

    public ApiResponseOk() {
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }
}
