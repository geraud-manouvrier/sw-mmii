package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_reporte_ingresos_egresos_mensual")
public class VwReporteIngresosEgresosMensual {


    @Id
    @Column(name = "row_id")
    private Long rowId;

    @Column(name = "group_id")
    private Long groupId;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "desde")
    private Integer desde;

    @Column(name = "hasta")
    private Integer hasta;

    @Size(max = 100)
    @Column(name = "office_id", length = 100)
    private String officeId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "ingresos")
    private BigDecimal ingresos;

    @Column(name = "distribution_fee")
    private BigDecimal distributionFee;

    @Column(name = "reconocimiento_adicional_bruto")
    private BigDecimal reconocimientoAdicionalBruto;

    @Column(name = "reconocimiento_adicional_iva")
    private BigDecimal reconocimientoAdicionalIva;

    @Column(name = "reconocimiento_adicional_neto")
    private BigDecimal reconocimientoAdicionalNeto;

    @Column(name = "collect_on_behalf_of_bruto")
    private BigDecimal collectOnBehalfOfBruto;

    @Column(name = "collect_on_behalf_of_iva")
    private BigDecimal collectOnBehalfOfIva;

    @Column(name = "collect_on_behalf_of_neto")
    private BigDecimal collectOnBehalfOfNeto;

    @Column(name = "aum_promedio")
    private BigDecimal aumPromedio;

    @Column(name = "advisory_fee_promedio")
    private BigDecimal advisoryFeePromedio;

    @Column(name = "margen_promedio_sura")
    private BigDecimal margenPromedioSura;

    @Column(name = "cant_reg")
    private Long cantReg;

    public Long getCantReg() {
        return cantReg;
    }

    public BigDecimal getMargenPromedioSura() {
        return margenPromedioSura;
    }

    public BigDecimal getAdvisoryFeePromedio() {
        return advisoryFeePromedio;
    }

    public BigDecimal getAumPromedio() {
        return aumPromedio;
    }

    public BigDecimal getCollectOnBehalfOfNeto() {
        return collectOnBehalfOfNeto;
    }

    public BigDecimal getCollectOnBehalfOfIva() {
        return collectOnBehalfOfIva;
    }

    public BigDecimal getCollectOnBehalfOfBruto() {
        return collectOnBehalfOfBruto;
    }

    public BigDecimal getReconocimientoAdicionalNeto() {
        return reconocimientoAdicionalNeto;
    }

    public BigDecimal getReconocimientoAdicionalIva() {
        return reconocimientoAdicionalIva;
    }

    public BigDecimal getReconocimientoAdicionalBruto() {
        return reconocimientoAdicionalBruto;
    }

    public BigDecimal getDistributionFee() {
        return distributionFee;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public String getOfficeId() {
        return officeId;
    }

    public Integer getHasta() {
        return hasta;
    }

    public Integer getDesde() {
        return desde;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getCustodian() {
        return custodian;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getRowId() {
        return rowId;
    }
}