package cl.qande.mmii.app.models.api_clients.mmii_suracorp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountFeeValidated {
    @JsonProperty("custodian")
    private String custodian;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("fee")
    private BigDecimal fee;
    @JsonProperty("status")
    private String status;
    @JsonProperty("feeContract")
    private BigDecimal feeContract;
    //Campos a poblar después de obtener salida

    private String name;
    private BigDecimal saldoDiario;

    public AccountFeeValidated() {
    }

    public AccountFeeValidated(String custodian, String accountNumber, BigDecimal fee) {
        this.custodian = custodian;
        this.accountNumber = accountNumber;
        this.fee = fee;
    }

    public AccountFeeValidated(String custodian, String accountNumber, BigDecimal fee, String status, BigDecimal feeContract) {
        this.custodian = custodian;
        this.accountNumber = accountNumber;
        this.fee = fee;
        this.status = status;
        this.feeContract = feeContract;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFeeContract() {
        return feeContract;
    }

    public void setFeeContract(BigDecimal feeContract) {
        this.feeContract = feeContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSaldoDiario() {
        return saldoDiario;
    }

    public void setSaldoDiario(BigDecimal saldoDiario) {
        this.saldoDiario = saldoDiario;
    }

    @Override
    public String toString() {
        return "AccountFeeValidated{" +
                "custodian='" + custodian + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", fee=" + fee +
                ", status='" + status + '\'' +
                ", feeContract=" + feeContract +
                ", name='" + name + '\'' +
                ", saldoDiario=" + saldoDiario +
                '}';
    }
}
