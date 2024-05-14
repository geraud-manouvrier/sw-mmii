package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;

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
@Table(name = "vw_reporte_maestro_datos_saldos")
public class VwReporteMaestroDatosSaldo {
    @Id
    @Column(name = "row_id")
    private Long rowId;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Column(name = "firm_no")
    private String firmNo;

    @Column(name = "sub_no")
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

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "cusip")
    private String cusip;

    @Column(name = "isin")
    private String isin;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "security_description")
    private String securityDescription;

    @Size(max = 1000)
    @Column(name = "cash_margin_account", length = 1000)
    private String cashMarginAccount;

    @Column(name = "quantity", precision = 45, scale = 20)
    private BigDecimal quantity;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Size(max = 1000)
    @Column(name = "currency", length = 1000)
    private String currency;

    @Column(name = "market_value", precision = 45, scale = 20)
    private BigDecimal marketValue;

    @Column(name = "fx_rate", precision = 45, scale = 20)
    private BigDecimal fxRate;

    @Column(name = "usde_market_value")
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

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Column(name = "acct_type")
    private Integer acctType;

    @Column(name = "currency_sequence")
    private Integer currencySequence;

    @Column(name = "id_reg")
    private Long idReg;

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

    public String getFirmNo() {
        return firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getRepNo() {
        return repNo;
    }

    public String getRep() {
        return rep;
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

    public String getSymbol() {
        return symbol;
    }

    public String getCusip() {
        return cusip;
    }

    public String getIsin() {
        return isin;
    }

    public String getProductType() {
        return productType;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public String getCashMarginAccount() {
        return cashMarginAccount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public BigDecimal getFxRate() {
        return fxRate;
    }

    public BigDecimal getUsdeMarketValue() {
        return usdeMarketValue;
    }

    public Integer getFactor() {
        return factor;
    }

    public BigDecimal getComisionDevengadaDiaria() {
        return comisionDevengadaDiaria;
    }

    public BigDecimal getUsdeMarketPrice() {
        return usdeMarketPrice;
    }

    public Integer getSecNo() {
        return secNo;
    }

    public String getDesc1() {
        return desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public String getSedol() {
        return sedol;
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

    public String getSecId() {
        return secId;
    }

    public BigDecimal getAdvisoryFeeAnual() {
        return advisoryFeeAnual;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public Integer getAcctType() {
        return acctType;
    }

    public Integer getCurrencySequence() {
        return currencySequence;
    }

}