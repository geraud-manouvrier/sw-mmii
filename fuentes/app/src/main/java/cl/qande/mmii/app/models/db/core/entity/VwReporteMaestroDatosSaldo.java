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

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

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

    @Column(name = "comision_devengada_diaria", precision = 45, scale = 20)
    private BigDecimal comisionDevengadaDiaria;

    @Column(name = "usde_market_price", precision = 45, scale = 20)
    private BigDecimal usdeMarketPrice;

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
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

    @Column(name = "id_reg")
    private Long idReg;
    @Column(name = "total_usde_market_value", precision = 45, scale = 20)
    private BigDecimal totalUsdeMarketValue;

    @Column(name = "ingreso_proteccion", precision = 45, scale = 20)
    private BigDecimal ingresoProteccion;

    @Column(name = "annual_fee", precision = 45, scale = 20)
    private BigDecimal annualFee;

    @Column(name = "tasa_proteccion", precision = 45, scale = 20)
    private BigDecimal tasaProteccion;

    @Column(name = "tasa_suracorp", precision = 45, scale = 20)
    private BigDecimal tasaSuracorp;

    @Column(name = "fee_diario", precision = 45, scale = 20)
    private BigDecimal feeDiario;

    @Column(name = "fee_diario_proteccion", precision = 45, scale = 20)
    private BigDecimal feeDiarioProteccion;

    @Column(name = "fee_diario_sura_corp", precision = 45, scale = 20)
    private BigDecimal feeDiarioSuraCorp;

    @Size(max = 100)
    @Column(name = "tipo_identificador_cliente", length = 100)
    private String tipoIdentificadorCliente;

    public String getTipoIdentificadorCliente() {
        return tipoIdentificadorCliente;
    }

    public BigDecimal getTotalUsdeMarketValue() {
        return totalUsdeMarketValue;
    }

    public BigDecimal getIngresoProteccion() {
        return ingresoProteccion;
    }

    public BigDecimal getAnnualFee() {
        return annualFee;
    }

    public BigDecimal getTasaProteccion() {
        return tasaProteccion;
    }

    public BigDecimal getTasaSuracorp() {
        return tasaSuracorp;
    }

    public BigDecimal getFeeDiario() {
        return feeDiario;
    }

    public BigDecimal getFeeDiarioProteccion() {
        return feeDiarioProteccion;
    }

    public BigDecimal getFeeDiarioSuraCorp() {
        return feeDiarioSuraCorp;
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

    public String getOfficeId() {
        return officeId;
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

    public BigDecimal getComisionDevengadaDiaria() {
        return comisionDevengadaDiaria;
    }

    public BigDecimal getUsdeMarketPrice() {
        return usdeMarketPrice;
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

    public String getTipoReg() {
        return tipoReg;
    }


}