package cl.qande.mmii.app.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.RectificacionMovimientosNoInformado}
 */
public class RectificacionMovimientosNoInformadoDto implements Serializable {
    private Long id;
    @Size(max = 100)
    private String custodian;
    @Size(max = 100)
    private String clientId;
    @Size(max = 100)
    private String name;
    private BigDecimal advisoryFeeAnual;
    @Size(max = 100)
    private String idCuentaCustodio;
    @Size(max = 100)
    private String processStamp;
    @Size(max = 100)
    private String processDate;
    private Boolean isLastInfo;
    @Size(max = 100)
    private String tipoReg;
    @Size(max = 100)
    private String officeId;
    private Integer accountNo;
    @Size(max = 100)
    private String tradeDate;
    @Size(max = 100)
    private String settlementDate;
    private Integer secNo;
    @Size(max = 100)
    private String activity;
    private String buySell;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal comission;
    private BigDecimal fees;
    private BigDecimal netAmount;
    private BigDecimal usdeNetAmount;
    private BigDecimal principal;
    private String cusip;
    private String symbol;
    private String isin;
    @Size(max = 1000)
    private String currency;
    private BigDecimal fxRate;
    private BigDecimal interest;
    @Size(max = 1000)
    private String currencyBase;
    @Size(max = 1000)
    private String cashMarginAccount;
    @Size(max = 100)
    private String productType;
    @Size(max = 100)
    private String securityDescription;
    @Size(max = 100)
    private String activityDescription;
    @Size(max = 100)
    private String activityCode;
    private String sourceCode;
    private String reporte;
    @Size(max = 100)
    private String description1;
    @Size(max = 100)
    private String description2;
    @Size(max = 100)
    private String description3;
    private String secType;
    @Size(max = 100)
    private String ticker;
    @Size(max = 100)
    private String idSubSubTipoActivo;
    @Size(max = 100)
    private String idSubTipoActivo;
    @Size(max = 100)
    private String idTipoActivo;
    @Size(max = 100)
    private String nombreSubSubTipoActivo;
    @Size(max = 100)
    private String secId;
    private Integer aplicaFlujoNeto;
    @NotNull
    @Size(max = 100)
    private String registradorUser;
    @NotNull
    private Instant registradorTimestamp;
    @Size(max = 100)
    private String modificadorUser;
    private Instant modificadorTimestamp;
    private Integer idEstadoRectificacion;

    public RectificacionMovimientosNoInformadoDto() {
    }

    public RectificacionMovimientosNoInformadoDto(Long id, String custodian, String clientId, String name, BigDecimal advisoryFeeAnual, String idCuentaCustodio, String processStamp, String processDate, Boolean isLastInfo, String tipoReg, String officeId, Integer accountNo, String tradeDate, String settlementDate, Integer secNo, String activity, String buySell, BigDecimal quantity, BigDecimal price, BigDecimal comission, BigDecimal fees, BigDecimal netAmount, BigDecimal usdeNetAmount, BigDecimal principal, String cusip, String symbol, String isin, String currency, BigDecimal fxRate, BigDecimal interest, String currencyBase, String cashMarginAccount, String productType, String securityDescription, String activityDescription, String activityCode, String sourceCode, String reporte, String description1, String description2, String description3, String secType, String ticker, String idSubSubTipoActivo, String idSubTipoActivo, String idTipoActivo, String nombreSubSubTipoActivo, String secId, Integer aplicaFlujoNeto, String registradorUser, Instant registradorTimestamp, String modificadorUser, Instant modificadorTimestamp, Integer idEstadoRectificacion) {
        this.id = id;
        this.custodian = custodian;
        this.clientId = clientId;
        this.name = name;
        this.advisoryFeeAnual = advisoryFeeAnual;
        this.idCuentaCustodio = idCuentaCustodio;
        this.processStamp = processStamp;
        this.processDate = processDate;
        this.isLastInfo = isLastInfo;
        this.tipoReg = tipoReg;
        this.officeId = officeId;
        this.accountNo = accountNo;
        this.tradeDate = tradeDate;
        this.settlementDate = settlementDate;
        this.secNo = secNo;
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
        this.symbol = symbol;
        this.isin = isin;
        this.currency = currency;
        this.fxRate = fxRate;
        this.interest = interest;
        this.currencyBase = currencyBase;
        this.cashMarginAccount = cashMarginAccount;
        this.productType = productType;
        this.securityDescription = securityDescription;
        this.activityDescription = activityDescription;
        this.activityCode = activityCode;
        this.sourceCode = sourceCode;
        this.reporte = reporte;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.secType = secType;
        this.ticker = ticker;
        this.idSubSubTipoActivo = idSubSubTipoActivo;
        this.idSubTipoActivo = idSubTipoActivo;
        this.idTipoActivo = idTipoActivo;
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
        this.secId = secId;
        this.aplicaFlujoNeto = aplicaFlujoNeto;
        this.registradorUser = registradorUser;
        this.registradorTimestamp = registradorTimestamp;
        this.modificadorUser = modificadorUser;
        this.modificadorTimestamp = modificadorTimestamp;
        this.idEstadoRectificacion = idEstadoRectificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAdvisoryFeeAnual() {
        return advisoryFeeAnual;
    }

    public void setAdvisoryFeeAnual(BigDecimal advisoryFeeAnual) {
        this.advisoryFeeAnual = advisoryFeeAnual;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

    public void setIdCuentaCustodio(String idCuentaCustodio) {
        this.idCuentaCustodio = idCuentaCustodio;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Boolean getIsLastInfo() {
        return isLastInfo;
    }

    public void setIsLastInfo(Boolean isLastInfo) {
        this.isLastInfo = isLastInfo;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public void setTipoReg(String tipoReg) {
        this.tipoReg = tipoReg;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
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

    public Integer getSecNo() {
        return secNo;
    }

    public void setSecNo(Integer secNo) {
        this.secNo = secNo;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
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

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public void setCurrencyBase(String currencyBase) {
        this.currencyBase = currencyBase;
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

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIdSubSubTipoActivo() {
        return idSubSubTipoActivo;
    }

    public void setIdSubSubTipoActivo(String idSubSubTipoActivo) {
        this.idSubSubTipoActivo = idSubSubTipoActivo;
    }

    public String getIdSubTipoActivo() {
        return idSubTipoActivo;
    }

    public void setIdSubTipoActivo(String idSubTipoActivo) {
        this.idSubTipoActivo = idSubTipoActivo;
    }

    public String getIdTipoActivo() {
        return idTipoActivo;
    }

    public void setIdTipoActivo(String idTipoActivo) {
        this.idTipoActivo = idTipoActivo;
    }

    public String getNombreSubSubTipoActivo() {
        return nombreSubSubTipoActivo;
    }

    public void setNombreSubSubTipoActivo(String nombreSubSubTipoActivo) {
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public Integer getAplicaFlujoNeto() {
        return aplicaFlujoNeto;
    }

    public void setAplicaFlujoNeto(Integer aplicaFlujoNeto) {
        this.aplicaFlujoNeto = aplicaFlujoNeto;
    }

    public String getRegistradorUser() {
        return registradorUser;
    }

    public void setRegistradorUser(String registradorUser) {
        this.registradorUser = registradorUser;
    }

    public Instant getRegistradorTimestamp() {
        return registradorTimestamp;
    }

    public void setRegistradorTimestamp(Instant registradorTimestamp) {
        this.registradorTimestamp = registradorTimestamp;
    }

    public String getModificadorUser() {
        return modificadorUser;
    }

    public void setModificadorUser(String modificadorUser) {
        this.modificadorUser = modificadorUser;
    }

    public Instant getModificadorTimestamp() {
        return modificadorTimestamp;
    }

    public void setModificadorTimestamp(Instant modificadorTimestamp) {
        this.modificadorTimestamp = modificadorTimestamp;
    }

    public Integer getIdEstadoRectificacion() {
        return idEstadoRectificacion;
    }

    public void setIdEstadoRectificacion(Integer idEstadoRectificacion) {
        this.idEstadoRectificacion = idEstadoRectificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectificacionMovimientosNoInformadoDto entity = (RectificacionMovimientosNoInformadoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.advisoryFeeAnual, entity.advisoryFeeAnual) &&
                Objects.equals(this.idCuentaCustodio, entity.idCuentaCustodio) &&
                Objects.equals(this.processStamp, entity.processStamp) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.isLastInfo, entity.isLastInfo) &&
                Objects.equals(this.tipoReg, entity.tipoReg) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.tradeDate, entity.tradeDate) &&
                Objects.equals(this.settlementDate, entity.settlementDate) &&
                Objects.equals(this.secNo, entity.secNo) &&
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
                Objects.equals(this.symbol, entity.symbol) &&
                Objects.equals(this.isin, entity.isin) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.fxRate, entity.fxRate) &&
                Objects.equals(this.interest, entity.interest) &&
                Objects.equals(this.currencyBase, entity.currencyBase) &&
                Objects.equals(this.cashMarginAccount, entity.cashMarginAccount) &&
                Objects.equals(this.productType, entity.productType) &&
                Objects.equals(this.securityDescription, entity.securityDescription) &&
                Objects.equals(this.activityDescription, entity.activityDescription) &&
                Objects.equals(this.activityCode, entity.activityCode) &&
                Objects.equals(this.sourceCode, entity.sourceCode) &&
                Objects.equals(this.reporte, entity.reporte) &&
                Objects.equals(this.description1, entity.description1) &&
                Objects.equals(this.description2, entity.description2) &&
                Objects.equals(this.description3, entity.description3) &&
                Objects.equals(this.secType, entity.secType) &&
                Objects.equals(this.ticker, entity.ticker) &&
                Objects.equals(this.idSubSubTipoActivo, entity.idSubSubTipoActivo) &&
                Objects.equals(this.idSubTipoActivo, entity.idSubTipoActivo) &&
                Objects.equals(this.idTipoActivo, entity.idTipoActivo) &&
                Objects.equals(this.nombreSubSubTipoActivo, entity.nombreSubSubTipoActivo) &&
                Objects.equals(this.secId, entity.secId) &&
                Objects.equals(this.aplicaFlujoNeto, entity.aplicaFlujoNeto) &&
                Objects.equals(this.registradorUser, entity.registradorUser) &&
                Objects.equals(this.registradorTimestamp, entity.registradorTimestamp) &&
                Objects.equals(this.modificadorUser, entity.modificadorUser) &&
                Objects.equals(this.modificadorTimestamp, entity.modificadorTimestamp) &&
                Objects.equals(this.idEstadoRectificacion, entity.idEstadoRectificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custodian, clientId, name, advisoryFeeAnual, idCuentaCustodio, processStamp, processDate, isLastInfo, tipoReg, officeId, accountNo, tradeDate, settlementDate, secNo, activity, buySell, quantity, price, comission, fees, netAmount, usdeNetAmount, principal, cusip, symbol, isin, currency, fxRate, interest, currencyBase, cashMarginAccount, productType, securityDescription, activityDescription, activityCode, sourceCode, reporte, description1, description2, description3, secType, ticker, idSubSubTipoActivo, idSubTipoActivo, idTipoActivo, nombreSubSubTipoActivo, secId, aplicaFlujoNeto, registradorUser, registradorTimestamp, modificadorUser, modificadorTimestamp, idEstadoRectificacion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "custodian = " + custodian + ", " +
                "clientId = " + clientId + ", " +
                "name = " + name + ", " +
                "advisoryFeeAnual = " + advisoryFeeAnual + ", " +
                "idCuentaCustodio = " + idCuentaCustodio + ", " +
                "processStamp = " + processStamp + ", " +
                "processDate = " + processDate + ", " +
                "isLastInfo = " + isLastInfo + ", " +
                "tipoReg = " + tipoReg + ", " +
                "officeId = " + officeId + ", " +
                "accountNo = " + accountNo + ", " +
                "tradeDate = " + tradeDate + ", " +
                "settlementDate = " + settlementDate + ", " +
                "secNo = " + secNo + ", " +
                "activity = " + activity + ", " +
                "buySell = " + buySell + ", " +
                "quantity = " + quantity + ", " +
                "price = " + price + ", " +
                "comission = " + comission + ", " +
                "fees = " + fees + ", " +
                "netAmount = " + netAmount + ", " +
                "usdeNetAmount = " + usdeNetAmount + ", " +
                "principal = " + principal + ", " +
                "cusip = " + cusip + ", " +
                "symbol = " + symbol + ", " +
                "isin = " + isin + ", " +
                "currency = " + currency + ", " +
                "fxRate = " + fxRate + ", " +
                "interest = " + interest + ", " +
                "currencyBase = " + currencyBase + ", " +
                "cashMarginAccount = " + cashMarginAccount + ", " +
                "productType = " + productType + ", " +
                "securityDescription = " + securityDescription + ", " +
                "activityDescription = " + activityDescription + ", " +
                "activityCode = " + activityCode + ", " +
                "sourceCode = " + sourceCode + ", " +
                "reporte = " + reporte + ", " +
                "description1 = " + description1 + ", " +
                "description2 = " + description2 + ", " +
                "description3 = " + description3 + ", " +
                "secType = " + secType + ", " +
                "ticker = " + ticker + ", " +
                "idSubSubTipoActivo = " + idSubSubTipoActivo + ", " +
                "idSubTipoActivo = " + idSubTipoActivo + ", " +
                "idTipoActivo = " + idTipoActivo + ", " +
                "nombreSubSubTipoActivo = " + nombreSubSubTipoActivo + ", " +
                "secId = " + secId + ", " +
                "aplicaFlujoNeto = " + aplicaFlujoNeto + ", " +
                "registradorUser = " + registradorUser + ", " +
                "registradorTimestamp = " + registradorTimestamp + ", " +
                "modificadorUser = " + modificadorUser + ", " +
                "modificadorTimestamp = " + modificadorTimestamp + ", " +
                "idEstadoRectificacion = " + idEstadoRectificacion + ")";
    }
}