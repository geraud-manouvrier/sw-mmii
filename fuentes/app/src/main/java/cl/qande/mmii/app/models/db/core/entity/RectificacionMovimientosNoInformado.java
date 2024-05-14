package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "rectificacion_movimientos_no_informados")
public class RectificacionMovimientosNoInformado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "advisory_fee_anual", precision = 45, scale = 20)
    private BigDecimal advisoryFeeAnual;

    @Size(max = 100)
    @Column(name = "id_cuenta_custodio", length = 100)
    private String idCuentaCustodio;

    @Size(max = 100)
    @Column(name = "process_stamp", length = 100)
    private String processStamp;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "is_last_info")
    private Boolean isLastInfo;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Column(name = "account_no")
    private Integer accountNo;

    @Size(max = 100)
    @Column(name = "trade_date", length = 100)
    private String tradeDate;

    @Size(max = 100)
    @Column(name = "settlement_date", length = 100)
    private String settlementDate;

    @Column(name = "sec_no")
    private Integer secNo;

    @Size(max = 100)
    @Column(name = "activity", length = 100)
    private String activity;

    @Column(name = "buy_sell")
    private String buySell;

    @Column(name = "quantity", precision = 45, scale = 20)
    private BigDecimal quantity;

    @Column(name = "price", precision = 45, scale = 20)
    private BigDecimal price;

    @Column(name = "comission")
    private BigDecimal comission;

    @Column(name = "fees", precision = 45, scale = 20)
    private BigDecimal fees;

    @Column(name = "net_amount", precision = 45, scale = 20)
    private BigDecimal netAmount;

    @Column(name = "usde_net_amount")
    private BigDecimal usdeNetAmount;

    @Column(name = "principal", precision = 45, scale = 20)
    private BigDecimal principal;

    @Column(name = "cusip")
    private String cusip;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "isin")
    private String isin;

    @Size(max = 1000)
    @Column(name = "currency", length = 1000)
    private String currency;

    @Column(name = "fx_rate")
    private BigDecimal fxRate;

    @Column(name = "interest")
    private BigDecimal interest;

    @Size(max = 1000)
    @Column(name = "currency_base", length = 1000)
    private String currencyBase;

    @Size(max = 1000)
    @Column(name = "cash_margin_account", length = 1000)
    private String cashMarginAccount;

    @Size(max = 100)
    @Column(name = "product_type", length = 100)
    private String productType;

    @Size(max = 100)
    @Column(name = "security_description", length = 100)
    private String securityDescription;

    @Size(max = 100)
    @Column(name = "activity_description", length = 100)
    private String activityDescription;

    @Size(max = 100)
    @Column(name = "activity_code", length = 100)
    private String activityCode;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "reporte")
    private String reporte;

    @Size(max = 100)
    @Column(name = "description1", length = 100)
    private String description1;

    @Size(max = 100)
    @Column(name = "description2", length = 100)
    private String description2;

    @Size(max = 100)
    @Column(name = "description3", length = 100)
    private String description3;

    @Column(name = "sec_type")
    private String secType;

    @Size(max = 100)
    @Column(name = "ticker", length = 100)
    private String ticker;

    @Size(max = 100)
    @Column(name = "id_sub_sub_tipo_activo", length = 100)
    private String idSubSubTipoActivo;

    @Size(max = 100)
    @Column(name = "id_sub_tipo_activo", length = 100)
    private String idSubTipoActivo;

    @Size(max = 100)
    @Column(name = "id_tipo_activo", length = 100)
    private String idTipoActivo;

    @Size(max = 100)
    @Column(name = "nombre_sub_sub_tipo_activo", length = 100)
    private String nombreSubSubTipoActivo;

    @Size(max = 100)
    @Column(name = "sec_id", length = 100)
    private String secId;

    @Column(name = "aplica_flujo_neto")
    private Integer aplicaFlujoNeto;

    @Size(max = 100)
    @NotNull
    @Column(name = "registrador_user", nullable = false, length = 100)
    private String registradorUser;

    @NotNull
    @Column(name = "registrador_timestamp", nullable = false)
    private Instant registradorTimestamp;

    @Size(max = 100)
    @Column(name = "modificador_user", length = 100)
    private String modificadorUser;

    @Column(name = "modificador_timestamp")
    private Instant modificadorTimestamp;

    @Column(name = "id_estado_rectificacion")
    private Integer idEstadoRectificacion;

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

}