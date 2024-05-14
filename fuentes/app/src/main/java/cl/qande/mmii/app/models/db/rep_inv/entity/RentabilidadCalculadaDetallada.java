package cl.qande.mmii.app.models.db.rep_inv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class RentabilidadCalculadaDetallada {
    @Id
    @Column(name = "row_id", nullable = false)
    private String rowId;

    @Size(max = 100)
    @NotNull
    @Column(name = "nivel", nullable = false, length = 100)
    private String nivel;

    @NotNull
    @Column(name = "sub_nivel", nullable = false)
    private Long subNivel;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @NotNull
    @Column(name = "process_date_as_date", nullable = false)
    private LocalDate processDateAsDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n1", length = 100)
    private String agregadorN1;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n2", length = 100)
    private String agregadorN2;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n3", length = 100)
    private String agregadorN3;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n4", length = 100)
    private String agregadorN4;

    @NotNull
    @Column(name = "saldo_dia")
    private BigDecimal saldoDia;

    @NotNull
    @Column(name = "abonos_dia")
    private BigDecimal abonosDia;

    @NotNull
    @Column(name = "retiros_dia")
    private BigDecimal retirosDia;

    @NotNull
    @Column(name = "dividendos_dia")
    private BigDecimal dividendosDia;

    @NotNull
    @Column(name = "saldo_dia_anterior")
    private BigDecimal saldoDiaAnterior;

    @NotNull
    @Column(name = "comision_devengada_dia")
    private BigDecimal comisionDevengadaDia;

    @NotNull
    @Column(name = "utilidad")
    private BigDecimal utilidad;

    @NotNull
    @Column(name = "rentabilidad")
    private BigDecimal rentabilidad;

    @NotNull
    @Column(name = "saldo_rentabilidad")
    private BigDecimal saldoRentabilidad;

    @NotNull
    @Column(name = "suma_saldo_rentabilidad")
    private BigDecimal sumaSaldoRentabilidad;

    @NotNull
    @Column(name = "suma_saldos_iniciales")
    private BigDecimal sumaSaldosIniciales;

    @NotNull
    @Column(name = "primer_dia_con_saldo")
    private Timestamp primerDiaConSaldo;

    @NotNull
    @Column(name = "ultimo_dia_con_saldo")
    private Timestamp ultimoDiaConSaldo;

    @NotNull
    @Column(name = "dias_con_saldo")
    private Integer diasConSaldo;

    @NotNull
    @Column(name = "rentabilidad_ponderada")
    private BigDecimal rentabilidadPonderada;

    @NotNull
    @Column(name = "rentabilidad_periodo_cl")
    private BigDecimal rentabilidadPeriodoCl;
    //Rentabilidades base 1
    @Column(name = "base1_fecha_desde")
    private LocalDate base1FechaDesde;
    @Column(name = "base1_fecha_hasta")
    private LocalDate base1FechaHasta;
    @Column(name = "base1_rentabilidad")
    private BigDecimal base1Rentabilidad;
    //Rentabilidades base 2
    @Column(name = "base2_fecha_desde")
    private LocalDate base2FechaDesde;
    @Column(name = "base2_fecha_hasta")
    private LocalDate base2FechaHasta;
    @Column(name = "base2_rentabilidad")
    private BigDecimal base2Rentabilidad;
    //Rentabilidades base 3
    @Column(name = "base3_fecha_desde")
    private LocalDate base3FechaDesde;
    @Column(name = "base3_fecha_hasta")
    private LocalDate base3FechaHasta;
    @Column(name = "base3_rentabilidad")
    private BigDecimal base3Rentabilidad;
    //Rentabilidades base 4
    @Column(name = "base4_fecha_desde")
    private LocalDate base4FechaDesde;
    @Column(name = "base4_fecha_hasta")
    private LocalDate base4FechaHasta;
    @Column(name = "base4_rentabilidad")
    private BigDecimal base4Rentabilidad;
    //Rentabilidades base 5
    @Column(name = "base5_fecha_desde")
    private LocalDate base5FechaDesde;
    @Column(name = "base5_fecha_hasta")
    private LocalDate base5FechaHasta;
    @Column(name = "base5_rentabilidad")
    private BigDecimal base5Rentabilidad;
    //Rentabilidades base 6
    @Column(name = "base6_fecha_desde")
    private LocalDate base6FechaDesde;
    @Column(name = "base6_fecha_hasta")
    private LocalDate base6FechaHasta;
    @Column(name = "base6_rentabilidad")
    private BigDecimal base6Rentabilidad;
    //Rentabilidades base 7
    @Column(name = "base7_fecha_desde")
    private LocalDate base7FechaDesde;
    @Column(name = "base7_fecha_hasta")
    private LocalDate base7FechaHasta;
    @Column(name = "base7_rentabilidad")
    private BigDecimal base7Rentabilidad;
    //Rentabilidades base 8
    @Column(name = "base8_fecha_desde")
    private LocalDate base8FechaDesde;
    @Column(name = "base8_fecha_hasta")
    private LocalDate base8FechaHasta;
    @Column(name = "base8_rentabilidad")
    private BigDecimal base8Rentabilidad;


    public String getRowId() {
        return rowId;
    }

    public String getNivel() {
        return nivel;
    }

    public String getProcessDate() {
        return processDate;
    }

    public LocalDate getProcessDateAsDate() {
        return processDateAsDate;
    }

    public String getAgregadorN1() {
        return agregadorN1;
    }

    public String getAgregadorN2() {
        return agregadorN2;
    }

    public String getAgregadorN3() {
        return agregadorN3;
    }

    public String getAgregadorN4() {
        return agregadorN4;
    }

    public BigDecimal getSaldoDia() {
        return saldoDia;
    }

    public BigDecimal getAbonosDia() {
        return abonosDia;
    }

    public BigDecimal getRetirosDia() {
        return retirosDia;
    }

    public BigDecimal getDividendosDia() {
        return dividendosDia;
    }

    public BigDecimal getSaldoDiaAnterior() {
        return saldoDiaAnterior;
    }

    public BigDecimal getComisionDevengadaDia() {
        return comisionDevengadaDia;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public BigDecimal getSumaSaldosIniciales() {
        return sumaSaldosIniciales;
    }

    public Timestamp getPrimerDiaConSaldo() {
        return primerDiaConSaldo;
    }

    public Timestamp getUltimoDiaConSaldo() {
        return ultimoDiaConSaldo;
    }

    public Integer getDiasConSaldo() {
        return diasConSaldo;
    }

    public BigDecimal getRentabilidad() {
        return rentabilidad;
    }

    public BigDecimal getSaldoRentabilidad() {
        return saldoRentabilidad;
    }

    public BigDecimal getSumaSaldoRentabilidad() {
        return sumaSaldoRentabilidad;
    }

    public BigDecimal getRentabilidadPonderada() {
        return rentabilidadPonderada;
    }

    public BigDecimal getRentabilidadPeriodoCl() {
        return rentabilidadPeriodoCl;
    }

    public LocalDate getBase1FechaDesde() {
        return base1FechaDesde;
    }

    public LocalDate getBase1FechaHasta() {
        return base1FechaHasta;
    }

    public BigDecimal getBase1Rentabilidad() {
        return base1Rentabilidad;
    }

    public LocalDate getBase2FechaDesde() {
        return base2FechaDesde;
    }

    public LocalDate getBase2FechaHasta() {
        return base2FechaHasta;
    }

    public BigDecimal getBase2Rentabilidad() {
        return base2Rentabilidad;
    }

    public LocalDate getBase3FechaDesde() {
        return base3FechaDesde;
    }

    public LocalDate getBase3FechaHasta() {
        return base3FechaHasta;
    }

    public BigDecimal getBase3Rentabilidad() {
        return base3Rentabilidad;
    }

    public LocalDate getBase4FechaDesde() {
        return base4FechaDesde;
    }

    public LocalDate getBase4FechaHasta() {
        return base4FechaHasta;
    }

    public BigDecimal getBase4Rentabilidad() {
        return base4Rentabilidad;
    }

    public LocalDate getBase5FechaDesde() {
        return base5FechaDesde;
    }

    public LocalDate getBase5FechaHasta() {
        return base5FechaHasta;
    }

    public BigDecimal getBase5Rentabilidad() {
        return base5Rentabilidad;
    }

    public LocalDate getBase6FechaDesde() {
        return base6FechaDesde;
    }

    public LocalDate getBase6FechaHasta() {
        return base6FechaHasta;
    }

    public BigDecimal getBase6Rentabilidad() {
        return base6Rentabilidad;
    }

    public LocalDate getBase7FechaDesde() {
        return base7FechaDesde;
    }

    public LocalDate getBase7FechaHasta() {
        return base7FechaHasta;
    }

    public BigDecimal getBase7Rentabilidad() {
        return base7Rentabilidad;
    }

    public LocalDate getBase8FechaDesde() {
        return base8FechaDesde;
    }

    public LocalDate getBase8FechaHasta() {
        return base8FechaHasta;
    }

    public BigDecimal getBase8Rentabilidad() {
        return base8Rentabilidad;
    }

    @Override
    public String toString() {
        return "RentabilidadCalculadaDetallada{" +
                "rowId='" + rowId + '\'' +
                ", nivel='" + nivel + '\'' +
                ", subNivel=" + subNivel +
                ", processDate='" + processDate + '\'' +
                ", processDateAsDate=" + processDateAsDate +
                ", agregadorN1='" + agregadorN1 + '\'' +
                ", agregadorN2='" + agregadorN2 + '\'' +
                ", agregadorN3='" + agregadorN3 + '\'' +
                ", agregadorN4='" + agregadorN4 + '\'' +
                ", saldoDia=" + saldoDia +
                ", abonosDia=" + abonosDia +
                ", retirosDia=" + retirosDia +
                ", dividendosDia=" + dividendosDia +
                ", saldoDiaAnterior=" + saldoDiaAnterior +
                ", comisionDevengadaDia=" + comisionDevengadaDia +
                ", utilidad=" + utilidad +
                ", rentabilidad=" + rentabilidad +
                ", saldoRentabilidad=" + saldoRentabilidad +
                ", sumaSaldoRentabilidad=" + sumaSaldoRentabilidad +
                ", sumaSaldosIniciales=" + sumaSaldosIniciales +
                ", primerDiaConSaldo=" + primerDiaConSaldo +
                ", ultimoDiaConSaldo=" + ultimoDiaConSaldo +
                ", diasConSaldo=" + diasConSaldo +
                ", rentabilidadPonderada=" + rentabilidadPonderada +
                ", rentabilidadPeriodoCl=" + rentabilidadPeriodoCl +
                ", base1FechaDesde=" + base1FechaDesde +
                ", base1FechaHasta=" + base1FechaHasta +
                ", base1Rentabilidad=" + base1Rentabilidad +
                ", base2FechaDesde=" + base2FechaDesde +
                ", base2FechaHasta=" + base2FechaHasta +
                ", base2Rentabilidad=" + base2Rentabilidad +
                ", base3FechaDesde=" + base3FechaDesde +
                ", base3FechaHasta=" + base3FechaHasta +
                ", base3Rentabilidad=" + base3Rentabilidad +
                ", base4FechaDesde=" + base4FechaDesde +
                ", base4FechaHasta=" + base4FechaHasta +
                ", base4Rentabilidad=" + base4Rentabilidad +
                ", base5FechaDesde=" + base5FechaDesde +
                ", base5FechaHasta=" + base5FechaHasta +
                ", base5Rentabilidad=" + base5Rentabilidad +
                ", base6FechaDesde=" + base6FechaDesde +
                ", base6FechaHasta=" + base6FechaHasta +
                ", base6Rentabilidad=" + base6Rentabilidad +
                ", base7FechaDesde=" + base7FechaDesde +
                ", base7FechaHasta=" + base7FechaHasta +
                ", base7Rentabilidad=" + base7Rentabilidad +
                ", base8FechaDesde=" + base8FechaDesde +
                ", base8FechaHasta=" + base8FechaHasta +
                ", base8Rentabilidad=" + base8Rentabilidad +
                '}';
    }

    public Long getSubNivel() {
        return subNivel;
    }

}
