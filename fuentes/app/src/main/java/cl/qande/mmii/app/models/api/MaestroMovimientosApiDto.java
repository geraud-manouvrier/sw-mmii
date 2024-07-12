package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento}
 */
public class MaestroMovimientosApiDto implements Serializable {
    @JsonProperty("custodian")
    @Size(max = 100)
    private String custodian;

    @JsonProperty("client-id")
    @Size(max = 100)
    private String clientId;


    @JsonProperty("tipo-id")
    @Size(max = 100)
    private String tipoIdentificadorCliente;
    @JsonProperty("office-id")
    @Size(max = 100)
    private String officeId;

    @JsonProperty("account-no")
    private String accountNo;

    @JsonProperty("name")
    @Size(max = 100)
    private String name;

    @JsonProperty("process-date")
    @Size(max = 100)
    private String processDate;

    @JsonProperty("trade-date")
    @Size(max = 100)
    private String tradeDate;

    @JsonProperty("settl-date")
    @Size(max = 100)
    private String settlementDate;

    @JsonProperty("activity")
    @Size(max = 100)
    private String activity;

    @JsonProperty("buy-sell")
    private String buySell;

    @JsonProperty("quantity")
    private BigDecimal quantity;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("comission")
    private BigDecimal comission;

    @JsonProperty("fees")
    private BigDecimal fees;

    @JsonProperty("net-amount")
    private BigDecimal netAmount;

    @JsonProperty("usde-net-amount")
    private BigDecimal usdeNetAmount;

    @JsonProperty("principal")
    private BigDecimal principal;

    @JsonProperty("cusip")
    private String cusip;

    @JsonProperty("currency")
    @Size(max = 1000)
    private String currency;

    @JsonProperty("fx-rate")
    private BigDecimal fxRate;

    @JsonProperty("cash-margin")
    @Size(max = 1000)
    private String cashMarginAccount;

    @JsonProperty("product-type")
    @Size(max = 100)
    private String productType;

    @JsonProperty("security-description")
    @Size(max = 100)
    private String securityDescription;

    @JsonProperty("activity-description")
    @Size(max = 100)
    private String activityDescription;

    @JsonProperty("source-code")
    private String sourceCode;

    @JsonProperty("nombre-sub-sub-tipo")
    @Size(max = 100)
    private String nombreSubSubTipoActivo;

    @JsonProperty("ingreso-egreso-producto")
    private Boolean ingresoEgreso;

    @JsonProperty("retiro")
    private BigDecimal retiro;

    @JsonProperty("recaudo")
    private BigDecimal recaudo;

    public MaestroMovimientosApiDto() {
    }

    @SuppressWarnings("squid:S00107")
    public MaestroMovimientosApiDto(String custodian, String clientId, String accountNo, String name, String processDate, String tradeDate, String settlementDate, String activity, String buySell, BigDecimal quantity, BigDecimal price, BigDecimal comission, BigDecimal fees, BigDecimal netAmount, BigDecimal usdeNetAmount, BigDecimal principal, String cusip, String currency, BigDecimal fxRate, String cashMarginAccount, String productType, String securityDescription, String activityDescription, String sourceCode, String nombreSubSubTipoActivo,
                                    String tipoIdentificadorCliente, String officeId, Boolean ingresoEgreso, BigDecimal retiro, BigDecimal recaudo) {
        this.custodian = custodian;
        this.clientId = clientId;
        this.accountNo = accountNo;
        this.name = name;
        this.processDate = processDate;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;
        this.activity = activity;
        this.buySell = buySell;
        this.quantity = quantity;
        this.price = price;
        this.comission = comission;
        this.fees = fees;
        this.netAmount = netAmount;
        this.usdeNetAmount = usdeNetAmount;
        this.principal = principal;
        this.cusip = cusip;
        this.currency = currency;
        this.fxRate = fxRate;
        this.cashMarginAccount = cashMarginAccount;
        this.productType = productType;
        this.securityDescription = securityDescription;
        this.activityDescription = activityDescription;
        this.sourceCode = sourceCode;
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
        this.officeId = officeId;
        this.ingresoEgreso = ingresoEgreso;
        this.retiro = retiro;
        this.recaudo = recaudo;
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

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getComission() {
        return comission;
    }

    public void setComission(BigDecimal comission) {
        this.comission = comission;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getUsdeNetAmount() {
        return usdeNetAmount;
    }

    public void setUsdeNetAmount(BigDecimal usdeNetAmount) {
        this.usdeNetAmount = usdeNetAmount;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public void setFxRate(BigDecimal fxRate) {
        this.fxRate = fxRate;
    }

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public void setCashMarginAccount(String cashMarginAccount) {
        this.cashMarginAccount = cashMarginAccount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getNombreSubSubTipoActivo() {
        return nombreSubSubTipoActivo;
    }

    public void setNombreSubSubTipoActivo(String nombreSubSubTipoActivo) {
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public Boolean getIngresoEgreso() {
        return ingresoEgreso;
    }

    public void setIngresoEgreso(Boolean ingresoEgreso) {
        this.ingresoEgreso = ingresoEgreso;
    }

    public BigDecimal getRetiro() {
        return retiro;
    }

    public void setRetiro(BigDecimal retiro) {
        this.retiro = retiro;
    }

    public BigDecimal getRecaudo() {
        return recaudo;
    }

    public void setRecaudo(BigDecimal recaudo) {
        this.recaudo = recaudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaestroMovimientosApiDto entity = (MaestroMovimientosApiDto) o;
        return Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.tipoIdentificadorCliente, entity.tipoIdentificadorCliente) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.tradeDate, entity.tradeDate) &&
                Objects.equals(this.settlementDate, entity.settlementDate) &&
                Objects.equals(this.activity, entity.activity) &&
                Objects.equals(this.buySell, entity.buySell) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.comission, entity.comission) &&
                Objects.equals(this.fees, entity.fees) &&
                Objects.equals(this.netAmount, entity.netAmount) &&
                Objects.equals(this.usdeNetAmount, entity.usdeNetAmount) &&
                Objects.equals(this.principal, entity.principal) &&
                Objects.equals(this.cusip, entity.cusip) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.fxRate, entity.fxRate) &&
                Objects.equals(this.cashMarginAccount, entity.cashMarginAccount) &&
                Objects.equals(this.productType, entity.productType) &&
                Objects.equals(this.securityDescription, entity.securityDescription) &&
                Objects.equals(this.activityDescription, entity.activityDescription) &&
                Objects.equals(this.sourceCode, entity.sourceCode) &&
                Objects.equals(this.nombreSubSubTipoActivo, entity.nombreSubSubTipoActivo) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.ingresoEgreso, entity.ingresoEgreso) &&
                Objects.equals(this.retiro, entity.retiro) &&
                Objects.equals(this.recaudo, entity.recaudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custodian, clientId, tipoIdentificadorCliente, accountNo, name, processDate, tradeDate, settlementDate, activity, buySell, quantity, price, comission, fees, netAmount, usdeNetAmount, principal, cusip, currency, fxRate, cashMarginAccount, productType, securityDescription, activityDescription, sourceCode, nombreSubSubTipoActivo, officeId, ingresoEgreso, retiro, recaudo);
    }

    @Override
    public String toString() {
        return "MaestroMovimientosApiDto{" +
                "custodian='" + custodian + '\'' +
                ", clientId='" + clientId + '\'' +
                ", tipoIdentificadorCliente='" + tipoIdentificadorCliente + '\'' +
                ", officeId='" + officeId + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", name='" + name + '\'' +
                ", processDate='" + processDate + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", settlementDate='" + settlementDate + '\'' +
                ", activity='" + activity + '\'' +
                ", buySell='" + buySell + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", comission=" + comission +
                ", fees=" + fees +
                ", netAmount=" + netAmount +
                ", usdeNetAmount=" + usdeNetAmount +
                ", principal=" + principal +
                ", cusip='" + cusip + '\'' +
                ", currency='" + currency + '\'' +
                ", fxRate=" + fxRate +
                ", cashMarginAccount='" + cashMarginAccount + '\'' +
                ", productType='" + productType + '\'' +
                ", securityDescription='" + securityDescription + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", nombreSubSubTipoActivo='" + nombreSubSubTipoActivo + '\'' +
                ", ingresoEgreso=" + ingresoEgreso +
                ", retiro=" + retiro +
                ", recaudo=" + recaudo +
                '}';
    }

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public void setTipoIdentificadorCliente(String tipoIdentificadorCliente) {
        this.tipoIdentificadorCliente = tipoIdentificadorCliente;
    }
}