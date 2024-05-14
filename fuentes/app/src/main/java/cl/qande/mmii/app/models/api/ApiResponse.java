package cl.qande.mmii.app.models.api;

public class ApiResponse {

    private Integer code;
    private String message;

    public ApiResponse() {
        this.code=-1;
        this.message="Error consumiendo API";
    }

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
