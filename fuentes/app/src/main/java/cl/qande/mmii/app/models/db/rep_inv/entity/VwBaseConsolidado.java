package cl.qande.mmii.app.models.db.rep_inv.entity;

import org.hibernate.annotations.Immutable;

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
@Table(name = "vw_base_consolidado", schema = "rep_inv")
public class VwBaseConsolidado {
    @EmbeddedId
    private VwBaseConsolidadoId id;

    @Column(name = "saldo_dia", precision = 45, scale = 20)
    private BigDecimal saldoDia;

    @Column(name = "dividendos_dia", precision = 45, scale = 20)
    private BigDecimal dividendosDia;

    @Column(name = "abonos_dia", precision = 45, scale = 20)
    private BigDecimal abonosDia;

    @Column(name = "retiros_dia", precision = 45, scale = 20)
    private BigDecimal retirosDia;

    @Column(name = "comision_devengada", precision = 45, scale = 20)
    private BigDecimal comisionDevengada;

    @Size(max = 100)
    @Column(name = "security_description")
    private String securityDescription;

    @Size(max = 100)
    @Column(name = "activity_description", length = 100)
    private String activityDescription;

    public String getActivityDescription() {
        return activityDescription;
    }

    public String getSecurityDescription() {
        return securityDescription;
    }

    public VwBaseConsolidadoId getId() {
        return id;
    }

    public void setId(VwBaseConsolidadoId id) {
        this.id = id;
    }

    public BigDecimal getSaldoDia() {
        return saldoDia;
    }

    public BigDecimal getDividendosDia() {
        return dividendosDia;
    }

    public BigDecimal getAbonosDia() {
        return abonosDia;
    }

    public BigDecimal getRetirosDia() {
        return retirosDia;
    }

    public BigDecimal getComisionDevengada() {
        return comisionDevengada;
    }

    protected VwBaseConsolidado() {
    }

    public void setSaldoDia(BigDecimal saldoDia) {
        this.saldoDia = saldoDia;
    }

    public void setDividendosDia(BigDecimal dividendosDia) {
        this.dividendosDia = dividendosDia;
    }

    public void setAbonosDia(BigDecimal abonosDia) {
        this.abonosDia = abonosDia;
    }

    public void setRetirosDia(BigDecimal retirosDia) {
        this.retirosDia = retirosDia;
    }

    public void setComisionDevengada(BigDecimal comisionDevengada) {
        this.comisionDevengada = comisionDevengada;
    }

    public void setSecurityDescription(String securityDescription) {
        this.securityDescription = securityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    @Override
    public String toString() {
        return "VwBaseConsolidado{" +
                "id=" + id +
                ", saldoDia=" + saldoDia +
                ", dividendosDia=" + dividendosDia +
                ", abonosDia=" + abonosDia +
                ", retirosDia=" + retirosDia +
                ", comisionDevengada=" + comisionDevengada +
                ", securityDescription='" + securityDescription + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                '}';
    }
}