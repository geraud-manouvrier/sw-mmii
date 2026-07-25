package cl.qande.mmii.app.models.api.reportes_maestros;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente}
 */
@Getter
@Setter
@ToString
public class MaestroCuentasApiDto implements Serializable {
    @JsonProperty("custodian")
    @Size(max = 100)
    private String custodian;

    @JsonProperty("office-id")
    @Size(max = 100)
    private String officeId;

    @JsonProperty("client-id")
    @Size(max = 100)
    private String clientId;

    @JsonProperty("tipo-id")
    @Size(max = 100)
    private String tipoIdentificadorCliente;
    @JsonProperty("account-no")
    @Size(max = 100)
    private String accountNo;

    @JsonProperty("name")
    @Size(max = 100)
    private String name;

    @JsonProperty("process-date")
    private String processDate;



    public MaestroCuentasApiDto() {
    }

    public MaestroCuentasApiDto(
            String tipoIdentificadorCliente, String custodian, String clientId, String officeId, String accountNo, String name, String processDate) {
        this.custodian = custodian;
        this.clientId = clientId;
        this.officeId = officeId;
        this.accountNo = accountNo;
        this.name = name;
        this.processDate = processDate;
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaestroCuentasApiDto entity = (MaestroCuentasApiDto) o;
        return Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.processDate, entity.processDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custodian, clientId, tipoIdentificadorCliente, officeId, accountNo, name, processDate);
    }

}