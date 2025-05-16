package cl.qande.mmii.app.models.api.reportes_maestros;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link VwReporteMaestroDatosSaldo}
 */
public class MaestroSaldosApiDto implements Serializable {
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
    @Size(max = 100)
    private String processDate;

    @JsonProperty("cusip")
    private String cusip;

    @JsonProperty("security-description")
    private String securityDescription;

    @JsonProperty("quantity")
    private BigDecimal quantity;

    @JsonProperty("mkt-price")
    private BigDecimal marketPrice;

    @JsonProperty("currency")
    @Size(max = 1000)
    private String currency;

    @JsonProperty("mkt-value")
    private BigDecimal marketValue;

    @JsonProperty("fx-rate")
    private BigDecimal fxRate;

    @JsonProperty("usde-mkt-value")
    private BigDecimal usdeMarketValue;

    @JsonProperty("usde-mkt-price")
    private BigDecimal usdeMarketPrice;

    @JsonProperty("nombre-sub-sub-tipo")
    @Size(max = 100)
    private String nombreSubSubTipoActivo;

    @JsonProperty("fee-anual")
    private BigDecimal annualFee;

    @JsonProperty("fee-proteccion")
    private BigDecimal tasaProteccion;

    @JsonProperty("fee-proteccion-diario")
    private BigDecimal feeDiarioProteccion;

    @JsonProperty("ingreso-proteccion")
    private BigDecimal ingresoProteccion;

    public MaestroSaldosApiDto() {
    }

    @SuppressWarnings("squid:S00107")
    public MaestroSaldosApiDto(String custodian, String clientId, String officeId,
                               String tipoIdentificadorCliente, String accountNo, String name, String processDate, String cusip, String securityDescription, BigDecimal quantity, BigDecimal marketPrice, String currency, BigDecimal marketValue, BigDecimal fxRate, BigDecimal usdeMarketValue, BigDecimal usdeMarketPrice, String nombreSubSubTipoActivo, BigDecimal ingresoProteccion, BigDecimal annualFee, BigDecimal tasaProteccion, BigDecimal feeDiarioProteccion) {
        this.custodian = custodian;
        this.clientId = clientId;
        this.officeId = officeId;
        this.accountNo = accountNo;
        this.name = name;
        this.processDate = processDate;
        this.cusip = cusip;
        this.securityDescription = securityDescription;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.currency = currency;
        this.marketValue = marketValue;
        this.fxRate = fxRate;
        this.usdeMarketValue = usdeMarketValue;
        this.usdeMarketPrice = usdeMarketPrice;
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
        this.ingresoProteccion = ingresoProteccion;
        this.annualFee = annualFee;
        this.tasaProteccion = tasaProteccion;
        this.feeDiarioProteccion = feeDiarioProteccion;
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
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

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public void setFxRate(BigDecimal fxRate) {
        this.fxRate = fxRate;
    }

    public BigDecimal getUsdeMarketValue() {
        return usdeMarketValue;
    }

    public void setUsdeMarketValue(BigDecimal usdeMarketValue) {
        this.usdeMarketValue = usdeMarketValue;
    }

    public BigDecimal getUsdeMarketPrice() {
        return usdeMarketPrice;
    }

    public void setUsdeMarketPrice(BigDecimal usdeMarketPrice) {
        this.usdeMarketPrice = usdeMarketPrice;
    }

    public String getNombreSubSubTipoActivo() {
        return nombreSubSubTipoActivo;
    }

    public void setNombreSubSubTipoActivo(String nombreSubSubTipoActivo) {
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
    }

    public BigDecimal getIngresoProteccion() {
        return ingresoProteccion;
    }

    public void setIngresoProteccion(BigDecimal ingresoProteccion) {
        this.ingresoProteccion = ingresoProteccion;
    }

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(BigDecimal annualFee) {
        this.annualFee = annualFee;
    }

    public BigDecimal getTasaProteccion() {
        return tasaProteccion;
    }

    public void setTasaProteccion(BigDecimal tasaProteccion) {
        this.tasaProteccion = tasaProteccion;
    }

    public BigDecimal getFeeDiarioProteccion() {
        return feeDiarioProteccion;
    }

    public void setFeeDiarioProteccion(BigDecimal feeDiarioProteccion) {
        this.feeDiarioProteccion = feeDiarioProteccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaestroSaldosApiDto entity = (MaestroSaldosApiDto) o;
        return Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.cusip, entity.cusip) &&
                Objects.equals(this.securityDescription, entity.securityDescription) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.marketPrice, entity.marketPrice) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.marketValue, entity.marketValue) &&
                Objects.equals(this.fxRate, entity.fxRate) &&
                Objects.equals(this.usdeMarketValue, entity.usdeMarketValue) &&
                Objects.equals(this.usdeMarketPrice, entity.usdeMarketPrice) &&
                Objects.equals(this.nombreSubSubTipoActivo, entity.nombreSubSubTipoActivo) &&
                Objects.equals(this.ingresoProteccion, entity.ingresoProteccion) &&
                Objects.equals(this.annualFee, entity.annualFee) &&
                Objects.equals(this.tasaProteccion, entity.tasaProteccion) &&
                Objects.equals(this.feeDiarioProteccion, entity.feeDiarioProteccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custodian, clientId, tipoIdentificadorCliente, officeId, accountNo, name, processDate, cusip, securityDescription, quantity, marketPrice, currency, marketValue, fxRate, usdeMarketValue, usdeMarketPrice, nombreSubSubTipoActivo, ingresoProteccion, annualFee, tasaProteccion, feeDiarioProteccion);
    }

    @Override
    public String toString() {
        return "MaestroSaldosApiDto{" +
                "custodian='" + custodian + '\'' +
                ", officeId='" + officeId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", tipoIdentificadorCliente='" + tipoIdentificadorCliente + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", name='" + name + '\'' +
                ", processDate='" + processDate + '\'' +
                ", cusip='" + cusip + '\'' +
                ", securityDescription='" + securityDescription + '\'' +
                ", quantity=" + quantity +
                ", marketPrice=" + marketPrice +
                ", currency='" + currency + '\'' +
                ", marketValue=" + marketValue +
                ", fxRate=" + fxRate +
                ", usdeMarketValue=" + usdeMarketValue +
                ", usdeMarketPrice=" + usdeMarketPrice +
                ", nombreSubSubTipoActivo='" + nombreSubSubTipoActivo + '\'' +
                ", annualFee=" + annualFee +
                ", tasaProteccion=" + tasaProteccion +
                ", feeDiarioProteccion=" + feeDiarioProteccion +
                ", ingresoProteccion=" + ingresoProteccion +
                '}';
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public void setTipoIdentificadorCliente(String tipoIdentificadorCliente) {
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
    }
}