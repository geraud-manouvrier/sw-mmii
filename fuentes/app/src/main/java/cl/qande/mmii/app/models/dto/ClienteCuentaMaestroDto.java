package cl.qande.mmii.app.models.dto;

import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestro;
import cl.qande.mmii.app.models.db.clientes.entity.ClienteCuentaMaestroId;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link ClienteCuentaMaestro}
 */
public class ClienteCuentaMaestroDto implements Serializable {
    private ClienteCuentaMaestroIdDto id;
    @Size(max = 100)
    private String identificadorCliente;
    @Size(max = 100)
    private String nombreCliente;
    private Integer idTipoIdentificadorCliente;
    @Size(max = 100)
    private String tipoIdentificadorCliente;
    @Size(max = 100)
    private String glosaIdentificadorCliente;
    @Size(max = 100)
    private String idCustodio;
    @Size(max = 100)
    private String idCuentaCustodio;
    private Boolean habilitado;

    public ClienteCuentaMaestroDto() {
    }

    public ClienteCuentaMaestroDto(ClienteCuentaMaestroIdDto id, String identificadorCliente, String nombreCliente, Integer idTipoIdentificadorCliente, String tipoIdentificadorCliente, String glosaIdentificadorCliente, String idCustodio, String idCuentaCustodio, Boolean habilitado) {
        this.id = id;
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.idTipoIdentificadorCliente = idTipoIdentificadorCliente;
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
        this.glosaIdentificadorCliente = glosaIdentificadorCliente;
        this.idCustodio = idCustodio;
        this.idCuentaCustodio = idCuentaCustodio;
        this.habilitado = habilitado;
    }

    public ClienteCuentaMaestroIdDto getId() {
        return id;
    }

    public void setId(ClienteCuentaMaestroIdDto id) {
        this.id = id;
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
        ClienteCuentaMaestroDto entity = (ClienteCuentaMaestroDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.identificadorCliente, entity.identificadorCliente) &&
                Objects.equals(this.nombreCliente, entity.nombreCliente) &&
                Objects.equals(this.idTipoIdentificadorCliente, entity.idTipoIdentificadorCliente) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.glosaIdentificadorCliente, entity.glosaIdentificadorCliente) &&
                Objects.equals(this.idCustodio, entity.idCustodio) &&
                Objects.equals(this.idCuentaCustodio, entity.idCuentaCustodio) &&
                Objects.equals(this.habilitado, entity.habilitado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificadorCliente, nombreCliente, idTipoIdentificadorCliente, tipoIdentificadorCliente, glosaIdentificadorCliente, idCustodio, idCuentaCustodio, habilitado);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "identificadorCliente = " + identificadorCliente + ", " +
                "nombreCliente = " + nombreCliente + ", " +
                "idTipoIdentificadorCliente = " + idTipoIdentificadorCliente + ", " +
                "tipoIdentificadorCliente = " + tipoIdentificadorCliente + ", " +
                "glosaIdentificadorCliente = " + glosaIdentificadorCliente + ", " +
                "idCustodio = " + idCustodio + ", " +
                "idCuentaCustodio = " + idCuentaCustodio + ", " +
                "habilitado = " + habilitado + ")";
    }

    /**
     * DTO for {@link ClienteCuentaMaestroId}
     */
    public static class ClienteCuentaMaestroIdDto implements Serializable {
        private Integer idInternoCliente;
        private Integer idInternoCuenta;

        public ClienteCuentaMaestroIdDto() {
        }

        public ClienteCuentaMaestroIdDto(Integer idInternoCliente, Integer idInternoCuenta) {
            this.idInternoCliente = idInternoCliente;
            this.idInternoCuenta = idInternoCuenta;
        }

        public Integer getIdInternoCliente() {
            return idInternoCliente;
        }

        public void setIdInternoCliente(Integer idInternoCliente) {
            this.idInternoCliente = idInternoCliente;
        }

        public Integer getIdInternoCuenta() {
            return idInternoCuenta;
        }

        public void setIdInternoCuenta(Integer idInternoCuenta) {
            this.idInternoCuenta = idInternoCuenta;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClienteCuentaMaestroIdDto entity = (ClienteCuentaMaestroIdDto) o;
            return Objects.equals(this.idInternoCliente, entity.idInternoCliente) &&
                    Objects.equals(this.idInternoCuenta, entity.idInternoCuenta);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idInternoCliente, idInternoCuenta);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "idInternoCliente = " + idInternoCliente + ", " +
                    "idInternoCuenta = " + idInternoCuenta + ")";
        }
    }
}