package cl.qande.mmii.app.models.api.retornos;

import cl.qande.mmii.app.models.api.ApiResponse;

public class RetornosResponseError extends ApiResponse {

    public RetornosResponseError(Integer code, String message) {
        super(code, message);
    }
}
