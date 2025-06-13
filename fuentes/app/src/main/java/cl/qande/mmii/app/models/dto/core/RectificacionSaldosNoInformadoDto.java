package cl.qande.mmii.app.models.dto.core;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.core.entity.RectificacionSaldosNoInformado}
 */
public class RectificacionSaldosNoInformadoDto implements Serializable {
    private Long id;
    @Size(max = 100)
    private String tipoReg;
    @Size(max = 100)
    private String custodian;
    @Size(max = 100)
    private String clientId;
    @Size(max = 100)
    private String firmNo;
    @Size(max = 100)
    private String subNo;
    @Size(max = 100)
    private String officeId;
    @Size(max = 100)
    private String repNo;
    @Size(max = 100)
    private String rep;
    @Size(max = 100)
    private String accountNo;
    @Size(max = 100)
    private String name;
    @Size(max = 100)
    private String processDate;
    @Size(max = 100)
    private String symbol;
    @Size(max = 100)
    private String cusip;
    @Size(max = 100)
    private String isin;
    @Size(max = 100)
    private String productType;
    @Size(max = 100)
    private String securityDescription;
    @Size(max = 1000)
    private String cashMarginAccount;
    private BigDecimal quantity;
    private BigDecimal marketPrice;
    @Size(max = 1000)
    private String currency;
    private BigDecimal marketValue;
    private BigDecimal fxRate;
    private BigDecimal usdeMarketValue;
    private Integer factor;
    private BigDecimal comisionDevengadaDiaria;
    private BigDecimal usdeMarketPrice;
    private Integer secNo;
    @Size(max = 100)
    private String desc1;
    @Size(max = 100)
    private String desc2;
    @Size(max = 100)
    private String desc3;
    @Size(max = 100)
    private String sedol;
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
    private BigDecimal advisoryFeeAnual;
    @Size(max = 100)
    private String processStamp;
    private Integer acctType;
    private Integer currencySequence;
    @NotNull
    @Size(max = 100)
    private String registradorUser;
    @NotNull
    private Instant registradorTimestamp;
    @Size(max = 100)
    private String modificadorUser;
    private Instant modificadorTimestamp;
    private Integer idEstadoRectificacion;

    public RectificacionSaldosNoInformadoDto() {
    }

    @SuppressWarnings("squid:S00107")
    public RectificacionSaldosNoInformadoDto(Long id, String tipoReg, String custodian, String clientId, String firmNo, String subNo, String officeId, String repNo, String rep, String accountNo, String name, String processDate, String symbol, String cusip, String isin, String productType, String securityDescription, String cashMarginAccount, BigDecimal quantity, BigDecimal marketPrice, String currency, BigDecimal marketValue, BigDecimal fxRate, BigDecimal usdeMarketValue, Integer factor, BigDecimal comisionDevengadaDiaria, BigDecimal usdeMarketPrice, Integer secNo, String desc1, String desc2, String desc3, String sedol, String ticker, String idSubSubTipoActivo, String idSubTipoActivo, String idTipoActivo, String nombreSubSubTipoActivo, String secId, BigDecimal advisoryFeeAnual, String processStamp, Integer acctType, Integer currencySequence, String registradorUser, Instant registradorTimestamp, String modificadorUser, Instant modificadorTimestamp, Integer idEstadoRectificacion) {
        this.id = id;
        this.tipoReg = tipoReg;
        this.custodian = custodian;
        this.clientId = clientId;
        this.firmNo = firmNo;
        this.subNo = subNo;
        this.officeId = officeId;
        this.repNo = repNo;
        this.rep = rep;
        this.accountNo = accountNo;
        this.name = name;
        this.processDate = processDate;
        this.symbol = symbol;
        this.cusip = cusip;
        this.isin = isin;
        this.productType = productType;
        this.securityDescription = securityDescription;
        this.cashMarginAccount = cashMarginAccount;
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.currency = currency;
        this.marketValue = marketValue;
        this.fxRate = fxRate;
        this.usdeMarketValue = usdeMarketValue;
        this.factor = factor;
        this.comisionDevengadaDiaria = comisionDevengadaDiaria;
        this.usdeMarketPrice = usdeMarketPrice;
        this.secNo = secNo;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.sedol = sedol;
        this.ticker = ticker;
        this.idSubSubTipoActivo = idSubSubTipoActivo;
        this.idSubTipoActivo = idSubTipoActivo;
        this.idTipoActivo = idTipoActivo;
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
        this.secId = secId;
        this.advisoryFeeAnual = advisoryFeeAnual;
        this.processStamp = processStamp;
        this.acctType = acctType;
        this.currencySequence = currencySequence;
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

    public String getTipoReg() {
        return tipoReg;
    }

    public void setTipoReg(String tipoReg) {
        this.tipoReg = tipoReg;
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

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getRepNo() {
        return repNo;
    }

    public void setRepNo(String repNo) {
        this.repNo = repNo;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
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

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public void setCashMarginAccount(String cashMarginAccount) {
        this.cashMarginAccount = cashMarginAccount;
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

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public BigDecimal getComisionDevengadaDiaria() {
        return comisionDevengadaDiaria;
    }

    public void setComisionDevengadaDiaria(BigDecimal comisionDevengadaDiaria) {
        this.comisionDevengadaDiaria = comisionDevengadaDiaria;
    }

    public BigDecimal getUsdeMarketPrice() {
        return usdeMarketPrice;
    }

    public void setUsdeMarketPrice(BigDecimal usdeMarketPrice) {
        this.usdeMarketPrice = usdeMarketPrice;
    }

    public Integer getSecNo() {
        return secNo;
    }

    public void setSecNo(Integer secNo) {
        this.secNo = secNo;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getSedol() {
        return sedol;
    }

    public void setSedol(String sedol) {
        this.sedol = sedol;
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

    public BigDecimal getAdvisoryFeeAnual() {
        return advisoryFeeAnual;
    }

    public void setAdvisoryFeeAnual(BigDecimal advisoryFeeAnual) {
        this.advisoryFeeAnual = advisoryFeeAnual;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

    public Integer getAcctType() {
        return acctType;
    }

    public void setAcctType(Integer acctType) {
        this.acctType = acctType;
    }

    public Integer getCurrencySequence() {
        return currencySequence;
    }

    public void setCurrencySequence(Integer currencySequence) {
        this.currencySequence = currencySequence;
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
        RectificacionSaldosNoInformadoDto entity = (RectificacionSaldosNoInformadoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tipoReg, entity.tipoReg) &&
                Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.firmNo, entity.firmNo) &&
                Objects.equals(this.subNo, entity.subNo) &&
                Objects.equals(this.officeId, entity.officeId) &&
                Objects.equals(this.repNo, entity.repNo) &&
                Objects.equals(this.rep, entity.rep) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.symbol, entity.symbol) &&
                Objects.equals(this.cusip, entity.cusip) &&
                Objects.equals(this.isin, entity.isin) &&
                Objects.equals(this.productType, entity.productType) &&
                Objects.equals(this.securityDescription, entity.securityDescription) &&
                Objects.equals(this.cashMarginAccount, entity.cashMarginAccount) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.marketPrice, entity.marketPrice) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.marketValue, entity.marketValue) &&
                Objects.equals(this.fxRate, entity.fxRate) &&
                Objects.equals(this.usdeMarketValue, entity.usdeMarketValue) &&
                Objects.equals(this.factor, entity.factor) &&
                Objects.equals(this.comisionDevengadaDiaria, entity.comisionDevengadaDiaria) &&
                Objects.equals(this.usdeMarketPrice, entity.usdeMarketPrice) &&
                Objects.equals(this.secNo, entity.secNo) &&
                Objects.equals(this.desc1, entity.desc1) &&
                Objects.equals(this.desc2, entity.desc2) &&
                Objects.equals(this.desc3, entity.desc3) &&
                Objects.equals(this.sedol, entity.sedol) &&
                Objects.equals(this.ticker, entity.ticker) &&
                Objects.equals(this.idSubSubTipoActivo, entity.idSubSubTipoActivo) &&
                Objects.equals(this.idSubTipoActivo, entity.idSubTipoActivo) &&
                Objects.equals(this.idTipoActivo, entity.idTipoActivo) &&
                Objects.equals(this.nombreSubSubTipoActivo, entity.nombreSubSubTipoActivo) &&
                Objects.equals(this.secId, entity.secId) &&
                Objects.equals(this.advisoryFeeAnual, entity.advisoryFeeAnual) &&
                Objects.equals(this.processStamp, entity.processStamp) &&
                Objects.equals(this.acctType, entity.acctType) &&
                Objects.equals(this.currencySequence, entity.currencySequence) &&
                Objects.equals(this.registradorUser, entity.registradorUser) &&
                Objects.equals(this.registradorTimestamp, entity.registradorTimestamp) &&
                Objects.equals(this.modificadorUser, entity.modificadorUser) &&
                Objects.equals(this.modificadorTimestamp, entity.modificadorTimestamp) &&
                Objects.equals(this.idEstadoRectificacion, entity.idEstadoRectificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoReg, custodian, clientId, firmNo, subNo, officeId, repNo, rep, accountNo, name, processDate, symbol, cusip, isin, productType, securityDescription, cashMarginAccount, quantity, marketPrice, currency, marketValue, fxRate, usdeMarketValue, factor, comisionDevengadaDiaria, usdeMarketPrice, secNo, desc1, desc2, desc3, sedol, ticker, idSubSubTipoActivo, idSubTipoActivo, idTipoActivo, nombreSubSubTipoActivo, secId, advisoryFeeAnual, processStamp, acctType, currencySequence, registradorUser, registradorTimestamp, modificadorUser, modificadorTimestamp, idEstadoRectificacion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tipoReg = " + tipoReg + ", " +
                "custodian = " + custodian + ", " +
                "clientId = " + clientId + ", " +
                "firmNo = " + firmNo + ", " +
                "subNo = " + subNo + ", " +
                "officeId = " + officeId + ", " +
                "repNo = " + repNo + ", " +
                "rep = " + rep + ", " +
                "accountNo = " + accountNo + ", " +
                "name = " + name + ", " +
                "processDate = " + processDate + ", " +
                "symbol = " + symbol + ", " +
                "cusip = " + cusip + ", " +
                "isin = " + isin + ", " +
                "productType = " + productType + ", " +
                "securityDescription = " + securityDescription + ", " +
                "cashMarginAccount = " + cashMarginAccount + ", " +
                "quantity = " + quantity + ", " +
                "marketPrice = " + marketPrice + ", " +
                "currency = " + currency + ", " +
                "marketValue = " + marketValue + ", " +
                "fxRate = " + fxRate + ", " +
                "usdeMarketValue = " + usdeMarketValue + ", " +
                "factor = " + factor + ", " +
                "comisionDevengadaDiaria = " + comisionDevengadaDiaria + ", " +
                "usdeMarketPrice = " + usdeMarketPrice + ", " +
                "secNo = " + secNo + ", " +
                "desc1 = " + desc1 + ", " +
                "desc2 = " + desc2 + ", " +
                "desc3 = " + desc3 + ", " +
                "sedol = " + sedol + ", " +
                "ticker = " + ticker + ", " +
                "idSubSubTipoActivo = " + idSubSubTipoActivo + ", " +
                "idSubTipoActivo = " + idSubTipoActivo + ", " +
                "idTipoActivo = " + idTipoActivo + ", " +
                "nombreSubSubTipoActivo = " + nombreSubSubTipoActivo + ", " +
                "secId = " + secId + ", " +
                "advisoryFeeAnual = " + advisoryFeeAnual + ", " +
                "processStamp = " + processStamp + ", " +
                "acctType = " + acctType + ", " +
                "currencySequence = " + currencySequence + ", " +
                "registradorUser = " + registradorUser + ", " +
                "registradorTimestamp = " + registradorTimestamp + ", " +
                "modificadorUser = " + modificadorUser + ", " +
                "modificadorTimestamp = " + modificadorTimestamp + ", " +
                "idEstadoRectificacion = " + idEstadoRectificacion + ")";
    }
}