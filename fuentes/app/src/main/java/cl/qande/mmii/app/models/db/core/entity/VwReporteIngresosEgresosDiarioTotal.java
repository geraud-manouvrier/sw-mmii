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
@Table(name = "vw_reporte_ingresos_egresos_diario_total")
public class VwReporteIngresosEgresosDiarioTotal {

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

    @Column(name = "dia")
    private Date dia;

    @Column(name = "ingresos_total")
    private BigDecimal ingresosTotal;

    @Column(name = "gastos_total")
    private BigDecimal gastosTotal;

    @Column(name = "reconocimiento_adicional_bruto_total")
    private BigDecimal reconocimientoAdicionalBrutoTotal;

    @Column(name = "reconocimiento_adicional_iva_total")
    private BigDecimal reconocimientoAdicionalIvaTotal;

    @Column(name = "reconocimiento_adicional_neto_total")
    private BigDecimal reconocimientoAdicionalNetoTotal;

    @Column(name = "collect_on_behalf_of_bruto_total")
    private BigDecimal collectOnBehalfOfBrutoTotal;

    @Column(name = "collect_on_behalf_of_iva_total")
    private BigDecimal collectOnBehalfOfIvaTotal;

    @Column(name = "collect_on_behalf_of_neto_total")
    private BigDecimal collectOnBehalfOfNetoTotal;

    @Column(name = "aum_promedio_total")
    private BigDecimal aumPromedioTotal;

    @Column(name = "advisory_fee_promedio_total")
    private BigDecimal advisoryFeePromedioTotal;

    @Column(name = "margen_promedio_sura_total")
    private BigDecimal margenPromedioSuraTotal;

    public BigDecimal getMargenPromedioSuraTotal() {
        return margenPromedioSuraTotal;
    }

    public BigDecimal getAdvisoryFeePromedioTotal() {
        return advisoryFeePromedioTotal;
    }

    public BigDecimal getAumPromedioTotal() {
        return aumPromedioTotal;
    }

    public BigDecimal getCollectOnBehalfOfNetoTotal() {
        return collectOnBehalfOfNetoTotal;
    }

    public BigDecimal getCollectOnBehalfOfIvaTotal() {
        return collectOnBehalfOfIvaTotal;
    }

    public BigDecimal getCollectOnBehalfOfBrutoTotal() {
        return collectOnBehalfOfBrutoTotal;
    }

    public BigDecimal getReconocimientoAdicionalNetoTotal() {
        return reconocimientoAdicionalNetoTotal;
    }

    public BigDecimal getReconocimientoAdicionalIvaTotal() {
        return reconocimientoAdicionalIvaTotal;
    }

    public BigDecimal getReconocimientoAdicionalBrutoTotal() {
        return reconocimientoAdicionalBrutoTotal;
    }

    public BigDecimal getGastosTotal() {
        return gastosTotal;
    }

    public BigDecimal getIngresosTotal() {
        return ingresosTotal;
    }

    public Date getDia() {
        return dia;
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