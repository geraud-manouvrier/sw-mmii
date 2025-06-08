package cl.qande.mmii.app.models.api.reportes_maestros;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosRelacionado}
 */
public class MaestroRelacionadosApiDto implements Serializable {
    @JsonProperty("custodian")
    @Size(max = 100)
    private String custodian;

    @JsonProperty("client-id")
    @Size(max = 100)
    private String clientId;

    @JsonProperty("account-no")
    @Size(max = 100)
    private String accountNo;

    @JsonProperty("tipo-id")
    @Size(max = 100)
    private String tipoIdentificadorCliente;

    @JsonProperty("office-id")
    @Size(max = 100)
    private String officeId;

    @JsonProperty("name")
    @Size(max = 100)
    private String name;

    @JsonProperty("id-relacionado")
    @Size(max = 100)
    private String identificadorRelacionado;

    @JsonProperty("nombre-relacionado")
    @Size(max = 100)
    private String nombreRelacionado;

    @JsonProperty("tipo-id-relacionado")
    @Size(max = 100)
    private String tipoIdentificadorRelacionado;

    @JsonProperty("cargo-id-relacionado")
    @Size(max = 100)
    private String idCargo;

    @JsonProperty("cargo-glosa-relacionado")
    @Size(max = 100)
    private String cargo;

    public MaestroRelacionadosApiDto() {
    }

    public MaestroRelacionadosApiDto(String custodian, String clientId, String accountNo, String tipoIdentificadorCliente, String officeId, String name, String identificadorRelacionado, String nombreRelacionado, String tipoIdentificadorRelacionado, String idCargo, String cargo) {
        this.custodian = custodian;
        this.clientId = clientId;
        this.accountNo = accountNo;
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
        this.officeId = officeId;
        this.name = name;
        this.identificadorRelacionado = identificadorRelacionado;
        this.nombreRelacionado = nombreRelacionado;
        this.tipoIdentificadorRelacionado = tipoIdentificadorRelacionado;
        this.idCargo = idCargo;
        this.cargo = cargo;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public void setTipoIdentificadorCliente(String tipoIdentificadorCliente) {
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificadorRelacionado() {
        return identificadorRelacionado;
    }

    public void setIdentificadorRelacionado(String identificadorRelacionado) {
        this.identificadorRelacionado = identificadorRelacionado;
    }

    public String getNombreRelacionado() {
        return nombreRelacionado;
    }

    public void setNombreRelacionado(String nombreRelacionado) {
        this.nombreRelacionado = nombreRelacionado;
    }

    public String getTipoIdentificadorRelacionado() {
        return tipoIdentificadorRelacionado;
    }

    public void setTipoIdentificadorRelacionado(String tipoIdentificadorRelacionado) {
        this.tipoIdentificadorRelacionado = tipoIdentificadorRelacionado;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaestroRelacionadosApiDto entity = (MaestroRelacionadosApiDto) o;
        return Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.identificadorRelacionado, entity.identificadorRelacionado) &&
                Objects.equals(this.nombreRelacionado, entity.nombreRelacionado) &&
                Objects.equals(this.tipoIdentificadorRelacionado, entity.tipoIdentificadorRelacionado) &&
                Objects.equals(this.idCargo, entity.idCargo) &&
                Objects.equals(this.cargo, entity.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custodian, clientId, accountNo, tipoIdentificadorCliente, officeId, name, identificadorRelacionado, nombreRelacionado, tipoIdentificadorRelacionado, idCargo, cargo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "custodian = " + custodian + ", " +
                "clientId = " + clientId + ", " +
                "accountNo = " + accountNo + ", " +
                "tipoIdentificadorCliente = " + tipoIdentificadorCliente + ", " +
                "officeId = " + officeId + ", " +
                "name = " + name + ", " +
                "identificadorRelacionado = " + identificadorRelacionado + ", " +
                "nombreRelacionado = " + nombreRelacionado + ", " +
                "tipoIdentificadorRelacionado = " + tipoIdentificadorRelacionado + ", " +
                "idCargo = " + idCargo + ", " +
                "cargo = " + cargo + ")";
    }
}