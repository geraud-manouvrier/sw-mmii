package cl.qande.mmii.app.models.api.reportes_maestros;

import cl.qande.mmii.app.models.api.ApiResponse;

public class ReporteMaestrosResponseError extends ApiResponse {

    public ReporteMaestrosResponseError(Integer code, String message) {
        super(code, message);
    }
}
