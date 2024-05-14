package cl.qande.mmii.app.models.db.core.entity;

public class EstadoPeticion {

    /*
    * TODO: Modificar para que:
    *   0 es OK
    *   1 es Warning
    *   2 es error
    *   4 es info
    * Pueden usarse códigos "miles": 1XXX, 2XXX, 3XXX, 4XXX.
    * Al signar código se asigna mtipo automático.
    * Crear métodos "setError", "setOk", etc. para encapsular
    */
    private Integer codigo;
    private String mensaje;
    private String detalle;

    private String tipo;

    public EstadoPeticion() {
    }

    public EstadoPeticion(Integer codigo, String mensaje, String detalle, String tipo) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public EstadoPeticion(Integer codigo, String mensaje, String detalle) {
        setEstadoPeticion(codigo, mensaje, detalle);
    }

    public void setEstadoPeticion(Integer codigo, String mensaje, String detalle) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
        switch (codigo/1000) {
            case 0:
                this.tipo   = "OK";
                break;
            case 1:
                this.tipo   = "WARNING";
                break;
            case 2:
                this.tipo   = "ERROR";
                break;
            case 3:
                this.tipo   = "INFO";
                break;
            default:
                this.tipo   = "ERROR";
        }
    }

    public void setEstadoOk(String mensaje, String detalle) {
        setEstadoPeticion(0, mensaje, detalle);
    }

    public void setEstadoOk(String mensaje) {
        setEstadoOk(mensaje, mensaje);
    }

    public void setEstadoWarning(String mensaje, String detalle) {
        setEstadoPeticion(1000, mensaje, detalle);
    }

    public void setEstadoWarning(String mensaje) {
        setEstadoWarning(mensaje, mensaje);
    }

    public void setEstadoError(String mensaje, String detalle) {
        setEstadoPeticion(2000, mensaje, detalle);
    }

    public void setEstadoError(String mensaje) {
        setEstadoError(mensaje, mensaje);
    }

    public void setEstadoInfo(String mensaje, String detalle) {
        setEstadoPeticion(3000, mensaje, detalle);
    }

    public void setEstadoInfo(String mensaje) {
        setEstadoInfo(mensaje, mensaje);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
