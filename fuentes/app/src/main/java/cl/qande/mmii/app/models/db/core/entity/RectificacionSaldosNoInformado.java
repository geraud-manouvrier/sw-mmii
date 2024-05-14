package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "rectificacion_saldos_no_informados")
public class RectificacionSaldosNoInformado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Size(max = 100)
    @Column(name = "firm_no", length = 100)
    private String firmNo;

    @Size(max = 100)
    @Column(name = "sub_no", length = 100)
    private String subNo;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Size(max = 100)
    @Column(name = "rep_no", length = 100)
    private String repNo;

    @Size(max = 100)
    @Column(name = "rep", length = 100)
    private String rep;

    @Size(max = 100)
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "symbol", length = 100)
    private String symbol;

    @Size(max = 100)
    @Column(name = "cusip", length = 100)
    private String cusip;

    @Size(max = 100)
    @Column(name = "isin", length = 100)
    private String isin;

    @Size(max = 100)
    @Column(name = "product_type", length = 100)
    private String productType;

    @Size(max = 100)
    @Column(name = "security_description", length = 100)
    private String securityDescription;

    @Size(max = 1000)
    @Column(name = "cash_margin_account", length = 1000)
    private String cashMarginAccount;

    @Column(name = "quantity", precision = 45, scale = 20)
    private BigDecimal quantity;

    @Column(name = "market_price", precision = 45, scale = 20)
    private BigDecimal marketPrice;

    @Size(max = 1000)
    @Column(name = "currency", length = 1000)
    private String currency;

    @Column(name = "market_value", precision = 45, scale = 20)
    private BigDecimal marketValue;

    @Column(name = "fx_rate", precision = 45, scale = 20)
    private BigDecimal fxRate;

    @Column(name = "usde_market_value", precision = 45, scale = 20)
    private BigDecimal usdeMarketValue;

    @Column(name = "factor")
    private Integer factor;

    @Column(name = "comision_devengada_diaria", precision = 45, scale = 20)
    private BigDecimal comisionDevengadaDiaria;

    @Column(name = "usde_market_price", precision = 45, scale = 20)
    private BigDecimal usdeMarketPrice;

    @Column(name = "sec_no")
    private Integer secNo;

    @Size(max = 100)
    @Column(name = "desc_1", length = 100)
    private String desc1;

    @Size(max = 100)
    @Column(name = "desc_2", length = 100)
    private String desc2;

    @Size(max = 100)
    @Column(name = "desc_3", length = 100)
    private String desc3;

    @Size(max = 100)
    @Column(name = "sedol", length = 100)
    private String sedol;

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

    @Column(name = "advisory_fee_anual", precision = 45, scale = 20)
    private BigDecimal advisoryFeeAnual;

    @Size(max = 100)
    @Column(name = "process_stamp", length = 100)
    private String processStamp;

    @Column(name = "acct_type")
    private Integer acctType;

    @Column(name = "currency_sequence")
    private Integer currencySequence;

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

}