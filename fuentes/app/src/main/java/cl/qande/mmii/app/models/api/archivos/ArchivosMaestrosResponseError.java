package cl.qande.mmii.app.models.api.archivos;

import cl.qande.mmii.app.models.api.ApiResponse;

public class ArchivosMaestrosResponseError extends ApiResponse {
    public ArchivosMaestrosResponseError(Integer code, String message) {
        super(code, message);
    }
}
