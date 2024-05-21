package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_reporte_maestro_datos_movimientos")
public class VwReporteMaestroDatosMovimiento {
    @Id
    @Column(name = "row_id")
    private Long rowId;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Column(name = "account_no")
    private String accountNo;

    @Size(max = 100)
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "trade_date", length = 100)
    private String tradeDate;

    @Size(max = 100)
    @Column(name = "settlement_date", length = 100)
    private String settlementDate;

    @Size(max = 100)
    @Column(name = "activity", length = 100)
    private String activity;

    @Column(name = "buy_sell")
    private String buySell;

    @Column(name = "quantity", precision = 45, scale = 20)
    private BigDecimal quantity;

    @Column(name = "price", precision = 45, scale = 20)
    private BigDecimal price;

    @Column(name = "comission", precision = 45, scale = 20)
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

    @Size(max = 100)
    @Column(name = "description1", length = 100)
    private String description1;

    @Size(max = 100)
    @Column(name = "description2", length = 100)
    private String description2;

    @Size(max = 100)
    @Column(name = "description3", length = 100)
    private String description3;

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

    @Column(name = "aplica_flujo_neto")
    private Integer aplicaFlujoNeto;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Size(max = 100)
    @Column(name = "id_cuenta_custodio", length = 100)
    private String idCuentaCustodio;

    @Column(name = "id_reg")
    private Long idReg;
    @Column(name = "src_vw")
    @Type(type = "org.hibernate.type.TextType")
    private String srcVw;

    @Column(name = "ingreso_egreso")
    private Boolean ingresoEgreso;

    @Column(name = "retiro", precision = 45, scale = 20)
    private BigDecimal retiro;

    @Column(name = "recaudo", precision = 45, scale = 20)
    private BigDecimal recaudo;

    @Size(max = 100)
    @Column(name = "tipo_identificador_cliente", length = 100)
    private String tipoIdentificadorCliente;

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public String getSrcVw() {
        return srcVw;
    }

    public Boolean getIngresoEgreso() {
        return ingresoEgreso;
    }

    public BigDecimal getRetiro() {
        return retiro;
    }

    public BigDecimal getRecaudo() {
        return recaudo;
    }

    public Long getIdReg() {
        return idReg;
    }

    public Long getRowId() {
        return rowId;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public String getActivity() {
        return activity;
    }

    public String getBuySell() {
        return buySell;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getComission() {
        return comission;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public BigDecimal getUsdeNetAmount() {
        return usdeNetAmount;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public String getCusip() {
        return cusip;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getIsin() {
        return isin;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public String getProductType() {
        return productType;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getDescription3() {
        return description3;
    }

    public String getTicker() {
        return ticker;
    }

    public String getIdSubSubTipoActivo() {
        return idSubSubTipoActivo;
    }

    public String getIdSubTipoActivo() {
        return idSubTipoActivo;
    }

    public String getIdTipoActivo() {
        return idTipoActivo;
    }

    public String getNombreSubSubTipoActivo() {
        return nombreSubSubTipoActivo;
    }

    public Integer getAplicaFlujoNeto() {
        return aplicaFlujoNeto;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getIdCuentaCustodio() {
        return idCuentaCustodio;
    }

}