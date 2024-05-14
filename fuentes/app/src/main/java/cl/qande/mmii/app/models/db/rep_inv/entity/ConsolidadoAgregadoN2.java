package cl.qande.mmii.app.models.db.rep_inv.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "consolidado_agregado_n2", schema = "rep_inv")
public class ConsolidadoAgregadoN2 {
    @EmbeddedId
    private ConsolidadoAgregadoN2Id id;

    @Column(name = "process_date_as_date")
    private LocalDate processDateAsDate;

    @Column(name = "saldo_dia", precision = 45, scale = 20)
    private BigDecimal saldoDia;

    @Column(name = "abonos_dia", precision = 45, scale = 20)
    private BigDecimal abonosDia;

    @Column(name = "retiros_dia", precision = 45, scale = 20)
    private BigDecimal retirosDia;

    @Column(name = "dividendos_dia", precision = 45, scale = 20)
    private BigDecimal dividendosDia;

    @Column(name = "comision_devengada_dia", precision = 45, scale = 20)
    private BigDecimal comisionDevengadaDia;

    @Column(name = "saldo_dia_anterior", precision = 45, scale = 20)
    private BigDecimal saldoDiaAnterior;

    @Column(name = "utilidad", precision = 45, scale = 20)
    private BigDecimal utilidad;

    @Column(name = "rentabilidad", precision = 45, scale = 20)
    private BigDecimal rentabilidad;

    @Column(name = "saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal saldoRentabilidad;

    @Column(name = "rentabilidad_base_pitatoria", precision = 45, scale = 20)
    private BigDecimal rentabilidadBasePitatoria;

    public BigDecimal getRentabilidadBasePitatoria() {
        return rentabilidadBasePitatoria;
    }

    public void setRentabilidadBasePitatoria(BigDecimal rentabilidadBasePitatoria) {
        this.rentabilidadBasePitatoria = rentabilidadBasePitatoria;
    }

    public ConsolidadoAgregadoN2Id getId() {
        return id;
    }

    public void setId(ConsolidadoAgregadoN2Id id) {
        this.id = id;
    }

    public LocalDate getProcessDateAsDate() {
        return processDateAsDate;
    }

    public void setProcessDateAsDate(LocalDate processDateAsDate) {
        this.processDateAsDate = processDateAsDate;
    }

    public BigDecimal getSaldoDia() {
        return saldoDia;
    }

    public void setSaldoDia(BigDecimal saldoDia) {
        this.saldoDia = saldoDia;
    }

    public BigDecimal getAbonosDia() {
        return abonosDia;
    }

    public void setAbonosDia(BigDecimal abonosDia) {
        this.abonosDia = abonosDia;
    }

    public BigDecimal getRetirosDia() {
        return retirosDia;
    }

    public void setRetirosDia(BigDecimal retirosDia) {
        this.retirosDia = retirosDia;
    }

    public BigDecimal getDividendosDia() {
        return dividendosDia;
    }

    public void setDividendosDia(BigDecimal dividendosDia) {
        this.dividendosDia = dividendosDia;
    }

    public BigDecimal getComisionDevengadaDia() {
        return comisionDevengadaDia;
    }

    public void setComisionDevengadaDia(BigDecimal comisionDevengadaDia) {
        this.comisionDevengadaDia = comisionDevengadaDia;
    }

    public BigDecimal getSaldoDiaAnterior() {
        return saldoDiaAnterior;
    }

    public void setSaldoDiaAnterior(BigDecimal saldoDiaAnterior) {
        this.saldoDiaAnterior = saldoDiaAnterior;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public BigDecimal getRentabilidad() {
        return rentabilidad;
    }

    public void setRentabilidad(BigDecimal rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    public BigDecimal getSaldoRentabilidad() {
        return saldoRentabilidad;
    }

    public void setSaldoRentabilidad(BigDecimal saldoRentabilidad) {
        this.saldoRentabilidad = saldoRentabilidad;
    }

    @Override
    public String toString() {
        return "ConsolidadoAgregadoN2{" +
                "id=" + id +
                ", processDateAsDate=" + processDateAsDate +
                ", saldoDia=" + saldoDia +
                ", abonosDia=" + abonosDia +
                ", retirosDia=" + retirosDia +
                ", dividendosDia=" + dividendosDia +
                ", comisionDevengadaDia=" + comisionDevengadaDia +
                ", saldoDiaAnterior=" + saldoDiaAnterior +
                ", utilidad=" + utilidad +
                ", rentabilidad=" + rentabilidad +
                ", saldoRentabilidad=" + saldoRentabilidad +
                ", rentabilidadBasePitatoria=" + rentabilidadBasePitatoria +
                '}';
    }
}