package cl.qande.mmii.app.models.dto.clientes;

import cl.qande.mmii.app.models.db.clientes.entity.ComisionMaestro;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link ComisionMaestro}
 */
public class ComisionMaestroDto implements Serializable {
    private Long rowId;
    private Long id;
    private Integer idCuenta;
    private BigDecimal comisionDiariaSaldo;
    private Date fechaInicioVigencia;
    private Date logFechaCreacion;
    @Size(max = 100)
    private String logUsuarioCreacion;
    private Integer idInternoCliente;
    @Size(max = 100)
    private String identificadorCliente;
    @Size(max = 100)
    private String nombreCliente;
    private Integer idTipoIdentificadorCliente;
    @Size(max = 100)
    private String tipoIdentificadorCliente;
    @Size(max = 100)
    private String glosaIdentificadorCliente;
    private Integer idInternoCuenta;
    @Size(max = 100)
    private String idCustodio;
    @Size(max = 100)
    private String idCuentaCustodio;
    private Boolean habilitado;

    public ComisionMaestroDto() {
    }

    public ComisionMaestroDto(Long rowId, Long id, Integer idCuenta, BigDecimal comisionDiariaSaldo, Date fechaInicioVigencia, Date logFechaCreacion, String logUsuarioCreacion, Integer idInternoCliente, String identificadorCliente, String nombreCliente, Integer idTipoIdentificadorCliente, String tipoIdentificadorCliente, String glosaIdentificadorCliente, Integer idInternoCuenta, String idCustodio, String idCuentaCustodio, Boolean habilitado) {
        this.rowId = rowId;
        this.id = id;
        this.idCuenta = idCuenta;
        this.comisionDiariaSaldo = comisionDiariaSaldo;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.logFechaCreacion = logFechaCreacion;
        this.logUsuarioCreacion = logUsuarioCreacion;
        this.idInternoCliente = idInternoCliente;
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.idTipoIdentificadorCliente = idTipoIdentificadorCliente;
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
        this.glosaIdentificadorCliente = glosaIdentificadorCliente;
        this.idInternoCuenta = idInternoCuenta;
        this.idCustodio = idCustodio;
        this.idCuentaCustodio = idCuentaCustodio;
        this.habilitado = habilitado;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public BigDecimal getComisionDiariaSaldo() {
        return comisionDiariaSaldo;
    }

    public void setComisionDiariaSaldo(BigDecimal comisionDiariaSaldo) {
        this.comisionDiariaSaldo = comisionDiariaSaldo;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getLogFechaCreacion() {
        return logFechaCreacion;
    }

    public void setLogFechaCreacion(Date logFechaCreacion) {
        this.logFechaCreacion = logFechaCreacion;
    }

    public String getLogUsuarioCreacion() {
        return logUsuarioCreacion;
    }

    public void setLogUsuarioCreacion(String logUsuarioCreacion) {
        this.logUsuarioCreacion = logUsuarioCreacion;
    }

    public Integer getIdInternoCliente() {
        return idInternoCliente;
    }

    public void setIdInternoCliente(Integer idInternoCliente) {
        this.idInternoCliente = idInternoCliente;
    }

    public String getIdentificadorCliente() {
        return identificadorCliente;
    }

    public void setIdentificadorCliente(String identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdTipoIdentificadorCliente() {
        return idTipoIdentificadorCliente;
    }

    public void setIdTipoIdentificadorCliente(Integer idTipoIdentificadorCliente) {
        this.idTipoIdentificadorCliente = idTipoIdentificadorCliente;
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public void setTipoIdentificadorCliente(String tipoIdentificadorCliente) {
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
    }

    public String getGlosaIdentificadorCliente() {
        return glosaIdentificadorCliente;
    }

    public void setGlosaIdentificadorCliente(String glosaIdentificadorCliente) {
        this.glosaIdentificadorCliente = glosaIdentificadorCliente;
    }

    public Integer getIdInternoCuenta() {
        return idInternoCuenta;
    }

    public void setIdInternoCuenta(Integer idInternoCuenta) {
        this.idInternoCuenta = idInternoCuenta;
    }

    public String getIdCustodio() {
        return idCustodio;
    }

    public void setIdCustodio(String idCustodio) {
        this.idCustodio = idCustodio;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public void setIdCuentaCustodio(String idCuentaCustodio) {
        this.idCuentaCustodio = idCuentaCustodio;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComisionMaestroDto entity = (ComisionMaestroDto) o;
        return Objects.equals(this.rowId, entity.rowId) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idCuenta, entity.idCuenta) &&
                Objects.equals(this.comisionDiariaSaldo, entity.comisionDiariaSaldo) &&
                Objects.equals(this.fechaInicioVigencia, entity.fechaInicioVigencia) &&
                Objects.equals(this.logFechaCreacion, entity.logFechaCreacion) &&
                Objects.equals(this.logUsuarioCreacion, entity.logUsuarioCreacion) &&
                Objects.equals(this.idInternoCliente, entity.idInternoCliente) &&
                Objects.equals(this.identificadorCliente, entity.identificadorCliente) &&
                Objects.equals(this.nombreCliente, entity.nombreCliente) &&
                Objects.equals(this.idTipoIdentificadorCliente, entity.idTipoIdentificadorCliente) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.glosaIdentificadorCliente, entity.glosaIdentificadorCliente) &&
                Objects.equals(this.idInternoCuenta, entity.idInternoCuenta) &&
                Objects.equals(this.idCustodio, entity.idCustodio) &&
                Objects.equals(this.idCuentaCustodio, entity.idCuentaCustodio) &&
                Objects.equals(this.habilitado, entity.habilitado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId, id, idCuenta, comisionDiariaSaldo, fechaInicioVigencia, logFechaCreacion, logUsuarioCreacion, idInternoCliente, identificadorCliente, nombreCliente, idTipoIdentificadorCliente, tipoIdentificadorCliente, glosaIdentificadorCliente, idInternoCuenta, idCustodio, idCuentaCustodio, habilitado);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "rowId = " + rowId + ", " +
                "id = " + id + ", " +
                "idCuenta = " + idCuenta + ", " +
                "comisionDiariaSaldo = " + comisionDiariaSaldo + ", " +
                "fechaInicioVigencia = " + fechaInicioVigencia + ", " +
                "logFechaCreacion = " + logFechaCreacion + ", " +
                "logUsuarioCreacion = " + logUsuarioCreacion + ", " +
                "idInternoCliente = " + idInternoCliente + ", " +
                "identificadorCliente = " + identificadorCliente + ", " +
                "nombreCliente = " + nombreCliente + ", " +
                "idTipoIdentificadorCliente = " + idTipoIdentificadorCliente + ", " +
                "tipoIdentificadorCliente = " + tipoIdentificadorCliente + ", " +
                "glosaIdentificadorCliente = " + glosaIdentificadorCliente + ", " +
                "idInternoCuenta = " + idInternoCuenta + ", " +
                "idCustodio = " + idCustodio + ", " +
                "idCuentaCustodio = " + idCuentaCustodio + ", " +
                "habilitado = " + habilitado + ")";
    }
}