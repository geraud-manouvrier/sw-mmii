package cl.qande.mmii.app.models.api;

public class RetornosResponseError extends ApiResponse {

    public RetornosResponseError(Integer code, String message) {
        super(code, message);
    }
}
