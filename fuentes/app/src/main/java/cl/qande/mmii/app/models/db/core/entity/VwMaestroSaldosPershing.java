package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_maestro_saldos_pershing")
public class VwMaestroSaldosPershing {
    @EmbeddedId
    private VwMaestroSaldosPershingId id;

    @Size(max = 100)
    @Column(name = "tipo_reg", length = 100)
    private String tipoReg;

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
    @Column(name = "name", length = 100)
    private String name;

    @Size(max = 100)
    @Column(name = "product_type", length = 100)
    private String productType;

    @Size(max = 100)
    @Column(name = "security_description", length = 100)
    private String securityDescription;

    @Size(max = 100)
    @Column(name = "cash_margin_account", length = 100)
    private String cashMarginAccount;

    @Column(name = "market_price", precision = 45, scale = 20)
    private BigDecimal marketPrice;

    @Size(max = 100)
    @Column(name = "id_currency", length = 100)
    private String idCurrency;

    @Column(name = "market_value", precision = 45, scale = 20)
    private BigDecimal marketValue;

    @Column(name = "fx_rate", precision = 45, scale = 20)
    private BigDecimal fxRate;

    @Column(name = "usde_market_value", precision = 45, scale = 20)
    private BigDecimal usdeMarketValue;

    @Column(name = "advisory_fee_anual", precision = 45, scale = 20)
    private BigDecimal advisoryFeeAnual;

    @Column(name = "factor")
    private Integer factor;

    @Column(name = "comision_devengada_diaria", precision = 45, scale = 20)
    private BigDecimal comisionDevengadaDiaria;

    @Column(name = "usde_market_price", precision = 45, scale = 20)
    private BigDecimal usdeMarketPrice;

    @Column(name = "sec_no")
    private Integer secNo;

    @Column(name = "desc_1")
    @Type(type = "org.hibernate.type.TextType")
    private String desc1;

    @Column(name = "desc_2")
    @Type(type = "org.hibernate.type.TextType")
    private String desc2;

    @Column(name = "desc_3")
    @Type(type = "org.hibernate.type.TextType")
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

    @Size(max = 1000)
    @Column(name = "nombre_sub_sub_tipo_activo", length = 1000)
    private String nombreSubSubTipoActivo;

    @Size(max = 100)
    @Column(name = "sec_id", length = 100)
    private String secId;

    public VwMaestroSaldosPershingId getId() {
        return id;
    }

    public void setId(VwMaestroSaldosPershingId id) {
        this.id = id;
    }

    public String getTipoReg() {
        return tipoReg;
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

    public String getName() {
        return name;
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

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public String getIdCurrency() {
        return idCurrency;
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

    public BigDecimal getAdvisoryFeeAnual() {
        return advisoryFeeAnual;
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

    protected VwMaestroSaldosPershing() {
    }
}