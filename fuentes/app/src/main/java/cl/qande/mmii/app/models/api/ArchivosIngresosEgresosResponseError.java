package cl.qande.mmii.app.models.api;

public class ArchivosIngresosEgresosResponseError extends ApiResponse {
    public ArchivosIngresosEgresosResponseError(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ArchivosIngresosEgresosResponseError() {
        this.setCode(-1);
        this.setMessage("Error listando archivos Ingresos Egresos");
    }
}
