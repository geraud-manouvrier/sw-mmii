package cl.qande.mmii.app.models.db.rep_inv.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rentabilidad_calculada", schema = "rep_inv")
public class RentabilidadCalculada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n1", nullable = false, length = 100)
    private String agregadorN1;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n2", nullable = false, length = 100)
    private String agregadorN2;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n3", nullable = false, length = 100)
    private String agregadorN3;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n4", nullable = false, length = 100)
    private String agregadorN4;

    @Size(max = 100)
    @NotNull
    @Column(name = "row_id", nullable = false, length = 100)
    private String rowId;

    @Size(max = 100)
    @Column(name = "nivel", length = 100)
    private String nivel;

    @Column(name = "sub_nivel")
    private Long subNivel;

    @Column(name = "process_date_as_date")
    private LocalDate processDateAsDate;

    @Column(name = "saldo_dia_anterior", precision = 45, scale = 20)
    private BigDecimal saldoDiaAnterior;

    @Column(name = "abonos_dia", precision = 45, scale = 20)
    private BigDecimal abonosDia;

    @Column(name = "retiros_dia", precision = 45, scale = 20)
    private BigDecimal retirosDia;

    @Column(name = "dividendos_dia", precision = 45, scale = 20)
    private BigDecimal dividendosDia;

    @Column(name = "saldo_dia", precision = 45, scale = 20)
    private BigDecimal saldoDia;

    @Column(name = "comision_devengada_dia", precision = 45, scale = 20)
    private BigDecimal comisionDevengadaDia;

    @Column(name = "utilidad", precision = 45, scale = 20)
    private BigDecimal utilidad;

    @Column(name = "rentabilidad", precision = 45, scale = 20)
    private BigDecimal rentabilidad;

    @Column(name = "rentabilidad_base_pitatoria", precision = 45, scale = 20)
    private BigDecimal rentabilidadBasePitatoria;

    @Column(name = "saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal saldoRentabilidad;

    @Column(name = "base1_start_date")
    private LocalDate base1StartDate;

    @Column(name = "base1_fecha_desde")
    private LocalDate base1FechaDesde;

    @Column(name = "base1_fecha_hasta")
    private LocalDate base1FechaHasta;

    @Column(name = "base1_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base1Rentabilidad;

    @Column(name = "base1_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base1RentabilidadAnualizada;

    @Column(name = "base1_dias_con_saldo")
    private Integer base1DiasConSaldo;

    @Column(name = "base1_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base1SumaSaldosIniciales;

    @Column(name = "base1_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base1SumaSaldoRentabilidad;

    @Column(name = "base1_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base1RentabilidadPonderadaCl;

    @Column(name = "base1_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base1RentabilidadPeriodoCl;

    @Column(name = "base1_cant_reg")
    private Integer base1CantReg;

    @Column(name = "base2_start_date")
    private LocalDate base2StartDate;

    @Column(name = "base2_fecha_desde")
    private LocalDate base2FechaDesde;

    @Column(name = "base2_fecha_hasta")
    private LocalDate base2FechaHasta;

    @Column(name = "base2_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base2Rentabilidad;

    @Column(name = "base2_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base2RentabilidadAnualizada;

    @Column(name = "base2_dias_con_saldo")
    private Integer base2DiasConSaldo;

    @Column(name = "base2_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base2SumaSaldosIniciales;

    @Column(name = "base2_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base2SumaSaldoRentabilidad;

    @Column(name = "base2_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base2RentabilidadPonderadaCl;

    @Column(name = "base2_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base2RentabilidadPeriodoCl;

    @Column(name = "base2_cant_reg")
    private Integer base2CantReg;

    @Column(name = "base3_start_date")
    private LocalDate base3StartDate;

    @Column(name = "base3_fecha_desde")
    private LocalDate base3FechaDesde;

    @Column(name = "base3_fecha_hasta")
    private LocalDate base3FechaHasta;

    @Column(name = "base3_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base3Rentabilidad;

    @Column(name = "base3_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base3RentabilidadAnualizada;

    @Column(name = "base3_dias_con_saldo")
    private Integer base3DiasConSaldo;

    @Column(name = "base3_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base3SumaSaldosIniciales;

    @Column(name = "base3_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base3SumaSaldoRentabilidad;

    @Column(name = "base3_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base3RentabilidadPonderadaCl;

    @Column(name = "base3_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base3RentabilidadPeriodoCl;

    @Column(name = "base3_cant_reg")
    private Integer base3CantReg;

    @Column(name = "base4_start_date")
    private LocalDate base4StartDate;

    @Column(name = "base4_fecha_desde")
    private LocalDate base4FechaDesde;

    @Column(name = "base4_fecha_hasta")
    private LocalDate base4FechaHasta;

    @Column(name = "base4_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base4Rentabilidad;

    @Column(name = "base4_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base4RentabilidadAnualizada;

    @Column(name = "base4_dias_con_saldo")
    private Integer base4DiasConSaldo;

    @Column(name = "base4_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base4SumaSaldosIniciales;

    @Column(name = "base4_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base4SumaSaldoRentabilidad;

    @Column(name = "base4_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base4RentabilidadPonderadaCl;

    @Column(name = "base4_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base4RentabilidadPeriodoCl;

    @Column(name = "base4_cant_reg")
    private Integer base4CantReg;

    @Column(name = "base5_start_date")
    private LocalDate base5StartDate;

    @Column(name = "base5_fecha_desde")
    private LocalDate base5FechaDesde;

    @Column(name = "base5_fecha_hasta")
    private LocalDate base5FechaHasta;

    @Column(name = "base5_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base5Rentabilidad;

    @Column(name = "base5_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base5RentabilidadAnualizada;

    @Column(name = "base5_dias_con_saldo")
    private Integer base5DiasConSaldo;

    @Column(name = "base5_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base5SumaSaldosIniciales;

    @Column(name = "base5_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base5SumaSaldoRentabilidad;

    @Column(name = "base5_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base5RentabilidadPonderadaCl;

    @Column(name = "base5_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base5RentabilidadPeriodoCl;

    @Column(name = "base5_cant_reg")
    private Integer base5CantReg;

    @Column(name = "base6_start_date")
    private LocalDate base6StartDate;

    @Column(name = "base6_fecha_desde")
    private LocalDate base6FechaDesde;

    @Column(name = "base6_fecha_hasta")
    private LocalDate base6FechaHasta;

    @Column(name = "base6_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base6Rentabilidad;

    @Column(name = "base6_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base6RentabilidadAnualizada;

    @Column(name = "base6_dias_con_saldo")
    private Integer base6DiasConSaldo;

    @Column(name = "base6_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base6SumaSaldosIniciales;

    @Column(name = "base6_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base6SumaSaldoRentabilidad;

    @Column(name = "base6_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base6RentabilidadPonderadaCl;

    @Column(name = "base6_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base6RentabilidadPeriodoCl;

    @Column(name = "base6_cant_reg")
    private Integer base6CantReg;

    @Column(name = "base7_start_date")
    private LocalDate base7StartDate;

    @Column(name = "base7_fecha_desde")
    private LocalDate base7FechaDesde;

    @Column(name = "base7_fecha_hasta")
    private LocalDate base7FechaHasta;

    @Column(name = "base7_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base7Rentabilidad;

    @Column(name = "base7_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base7RentabilidadAnualizada;

    @Column(name = "base7_dias_con_saldo")
    private Integer base7DiasConSaldo;

    @Column(name = "base7_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base7SumaSaldosIniciales;

    @Column(name = "base7_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base7SumaSaldoRentabilidad;

    @Column(name = "base7_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base7RentabilidadPonderadaCl;

    @Column(name = "base7_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base7RentabilidadPeriodoCl;

    @Column(name = "base7_cant_reg")
    private Integer base7CantReg;

    @Column(name = "base8_start_date")
    private LocalDate base8StartDate;

    @Column(name = "base8_fecha_desde")
    private LocalDate base8FechaDesde;

    @Column(name = "base8_fecha_hasta")
    private LocalDate base8FechaHasta;

    @Column(name = "base8_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base8Rentabilidad;

    @Column(name = "base8_rentabilidad_anualizada", precision = 45, scale = 20)
    private BigDecimal base8RentabilidadAnualizada;

    @Column(name = "base8_dias_con_saldo")
    private Integer base8DiasConSaldo;

    @Column(name = "base8_suma_saldos_iniciales", precision = 45, scale = 20)
    private BigDecimal base8SumaSaldosIniciales;

    @Column(name = "base8_suma_saldo_rentabilidad", precision = 45, scale = 20)
    private BigDecimal base8SumaSaldoRentabilidad;

    @Column(name = "base8_rentabilidad_ponderada_cl", precision = 45, scale = 20)
    private BigDecimal base8RentabilidadPonderadaCl;

    @Column(name = "base8_rentabilidad_periodo_cl", precision = 45, scale = 20)
    private BigDecimal base8RentabilidadPeriodoCl;

    @Column(name = "base8_cant_reg")
    private Integer base8CantReg;

    public BigDecimal getBase1RentabilidadAnualizada() {
        return base1RentabilidadAnualizada;
    }

    public void setBase1RentabilidadAnualizada(BigDecimal base1RentabilidadAnualizada) {
        this.base1RentabilidadAnualizada = base1RentabilidadAnualizada;
    }

    public BigDecimal getBase2RentabilidadAnualizada() {
        return base2RentabilidadAnualizada;
    }

    public void setBase2RentabilidadAnualizada(BigDecimal base2RentabilidadAnualizada) {
        this.base2RentabilidadAnualizada = base2RentabilidadAnualizada;
    }

    public BigDecimal getBase3RentabilidadAnualizada() {
        return base3RentabilidadAnualizada;
    }

    public void setBase3RentabilidadAnualizada(BigDecimal base3RentabilidadAnualizada) {
        this.base3RentabilidadAnualizada = base3RentabilidadAnualizada;
    }

    public BigDecimal getBase4RentabilidadAnualizada() {
        return base4RentabilidadAnualizada;
    }

    public void setBase4RentabilidadAnualizada(BigDecimal base4RentabilidadAnualizada) {
        this.base4RentabilidadAnualizada = base4RentabilidadAnualizada;
    }

    public BigDecimal getBase5RentabilidadAnualizada() {
        return base5RentabilidadAnualizada;
    }

    public void setBase5RentabilidadAnualizada(BigDecimal base5RentabilidadAnualizada) {
        this.base5RentabilidadAnualizada = base5RentabilidadAnualizada;
    }

    public BigDecimal getBase6RentabilidadAnualizada() {
        return base6RentabilidadAnualizada;
    }

    public void setBase6RentabilidadAnualizada(BigDecimal base6RentabilidadAnualizada) {
        this.base6RentabilidadAnualizada = base6RentabilidadAnualizada;
    }

    public BigDecimal getBase7RentabilidadAnualizada() {
        return base7RentabilidadAnualizada;
    }

    public void setBase7RentabilidadAnualizada(BigDecimal base7RentabilidadAnualizada) {
        this.base7RentabilidadAnualizada = base7RentabilidadAnualizada;
    }

    public BigDecimal getBase8RentabilidadAnualizada() {
        return base8RentabilidadAnualizada;
    }

    public void setBase8RentabilidadAnualizada(BigDecimal base8RentabilidadAnualizada) {
        this.base8RentabilidadAnualizada = base8RentabilidadAnualizada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getAgregadorN1() {
        return agregadorN1;
    }

    public void setAgregadorN1(String agregadorN1) {
        this.agregadorN1 = agregadorN1;
    }

    public String getAgregadorN2() {
        return agregadorN2;
    }

    public void setAgregadorN2(String agregadorN2) {
        this.agregadorN2 = agregadorN2;
    }

    public String getAgregadorN3() {
        return agregadorN3;
    }

    public void setAgregadorN3(String agregadorN3) {
        this.agregadorN3 = agregadorN3;
    }

    public String getAgregadorN4() {
        return agregadorN4;
    }

    public void setAgregadorN4(String agregadorN4) {
        this.agregadorN4 = agregadorN4;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Long getSubNivel() {
        return subNivel;
    }

    public void setSubNivel(Long subNivel) {
        this.subNivel = subNivel;
    }

    public LocalDate getProcessDateAsDate() {
        return processDateAsDate;
    }

    public void setProcessDateAsDate(LocalDate processDateAsDate) {
        this.processDateAsDate = processDateAsDate;
    }

    public BigDecimal getSaldoDiaAnterior() {
        return saldoDiaAnterior;
    }

    public void setSaldoDiaAnterior(BigDecimal saldoDiaAnterior) {
        this.saldoDiaAnterior = saldoDiaAnterior;
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

    public BigDecimal getSaldoDia() {
        return saldoDia;
    }

    public void setSaldoDia(BigDecimal saldoDia) {
        this.saldoDia = saldoDia;
    }

    public BigDecimal getComisionDevengadaDia() {
        return comisionDevengadaDia;
    }

    public void setComisionDevengadaDia(BigDecimal comisionDevengadaDia) {
        this.comisionDevengadaDia = comisionDevengadaDia;
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

    public BigDecimal getRentabilidadBasePitatoria() {
        return rentabilidadBasePitatoria;
    }

    public void setRentabilidadBasePitatoria(BigDecimal rentabilidadBasePitatoria) {
        this.rentabilidadBasePitatoria = rentabilidadBasePitatoria;
    }

    public BigDecimal getSaldoRentabilidad() {
        return saldoRentabilidad;
    }

    public void setSaldoRentabilidad(BigDecimal saldoRentabilidad) {
        this.saldoRentabilidad = saldoRentabilidad;
    }

    public LocalDate getBase1StartDate() {
        return base1StartDate;
    }

    public void setBase1StartDate(LocalDate base1StartDate) {
        this.base1StartDate = base1StartDate;
    }

    public LocalDate getBase1FechaDesde() {
        return base1FechaDesde;
    }

    public void setBase1FechaDesde(LocalDate base1FechaDesde) {
        this.base1FechaDesde = base1FechaDesde;
    }

    public LocalDate getBase1FechaHasta() {
        return base1FechaHasta;
    }

    public void setBase1FechaHasta(LocalDate base1FechaHasta) {
        this.base1FechaHasta = base1FechaHasta;
    }

    public BigDecimal getBase1Rentabilidad() {
        return base1Rentabilidad;
    }

    public void setBase1Rentabilidad(BigDecimal base1Rentabilidad) {
        this.base1Rentabilidad = base1Rentabilidad;
    }

    public Integer getBase1DiasConSaldo() {
        return base1DiasConSaldo;
    }

    public void setBase1DiasConSaldo(Integer base1DiasConSaldo) {
        this.base1DiasConSaldo = base1DiasConSaldo;
    }

    public BigDecimal getBase1SumaSaldosIniciales() {
        return base1SumaSaldosIniciales;
    }

    public void setBase1SumaSaldosIniciales(BigDecimal base1SumaSaldosIniciales) {
        this.base1SumaSaldosIniciales = base1SumaSaldosIniciales;
    }

    public BigDecimal getBase1SumaSaldoRentabilidad() {
        return base1SumaSaldoRentabilidad;
    }

    public void setBase1SumaSaldoRentabilidad(BigDecimal base1SumaSaldoRentabilidad) {
        this.base1SumaSaldoRentabilidad = base1SumaSaldoRentabilidad;
    }

    public BigDecimal getBase1RentabilidadPonderadaCl() {
        return base1RentabilidadPonderadaCl;
    }

    public void setBase1RentabilidadPonderadaCl(BigDecimal base1RentabilidadPonderadaCl) {
        this.base1RentabilidadPonderadaCl = base1RentabilidadPonderadaCl;
    }

    public BigDecimal getBase1RentabilidadPeriodoCl() {
        return base1RentabilidadPeriodoCl;
    }

    public void setBase1RentabilidadPeriodoCl(BigDecimal base1RentabilidadPeriodoCl) {
        this.base1RentabilidadPeriodoCl = base1RentabilidadPeriodoCl;
    }

    public Integer getBase1CantReg() {
        return base1CantReg;
    }

    public void setBase1CantReg(Integer base1CantReg) {
        this.base1CantReg = base1CantReg;
    }

    public LocalDate getBase2StartDate() {
        return base2StartDate;
    }

    public void setBase2StartDate(LocalDate base2StartDate) {
        this.base2StartDate = base2StartDate;
    }

    public LocalDate getBase2FechaDesde() {
        return base2FechaDesde;
    }

    public void setBase2FechaDesde(LocalDate base2FechaDesde) {
        this.base2FechaDesde = base2FechaDesde;
    }

    public LocalDate getBase2FechaHasta() {
        return base2FechaHasta;
    }

    public void setBase2FechaHasta(LocalDate base2FechaHasta) {
        this.base2FechaHasta = base2FechaHasta;
    }

    public BigDecimal getBase2Rentabilidad() {
        return base2Rentabilidad;
    }

    public void setBase2Rentabilidad(BigDecimal base2Rentabilidad) {
        this.base2Rentabilidad = base2Rentabilidad;
    }

    public Integer getBase2DiasConSaldo() {
        return base2DiasConSaldo;
    }

    public void setBase2DiasConSaldo(Integer base2DiasConSaldo) {
        this.base2DiasConSaldo = base2DiasConSaldo;
    }

    public BigDecimal getBase2SumaSaldosIniciales() {
        return base2SumaSaldosIniciales;
    }

    public void setBase2SumaSaldosIniciales(BigDecimal base2SumaSaldosIniciales) {
        this.base2SumaSaldosIniciales = base2SumaSaldosIniciales;
    }

    public BigDecimal getBase2SumaSaldoRentabilidad() {
        return base2SumaSaldoRentabilidad;
    }

    public void setBase2SumaSaldoRentabilidad(BigDecimal base2SumaSaldoRentabilidad) {
        this.base2SumaSaldoRentabilidad = base2SumaSaldoRentabilidad;
    }

    public BigDecimal getBase2RentabilidadPonderadaCl() {
        return base2RentabilidadPonderadaCl;
    }

    public void setBase2RentabilidadPonderadaCl(BigDecimal base2RentabilidadPonderadaCl) {
        this.base2RentabilidadPonderadaCl = base2RentabilidadPonderadaCl;
    }

    public BigDecimal getBase2RentabilidadPeriodoCl() {
        return base2RentabilidadPeriodoCl;
    }

    public void setBase2RentabilidadPeriodoCl(BigDecimal base2RentabilidadPeriodoCl) {
        this.base2RentabilidadPeriodoCl = base2RentabilidadPeriodoCl;
    }

    public Integer getBase2CantReg() {
        return base2CantReg;
    }

    public void setBase2CantReg(Integer base2CantReg) {
        this.base2CantReg = base2CantReg;
    }

    public LocalDate getBase3StartDate() {
        return base3StartDate;
    }

    public void setBase3StartDate(LocalDate base3StartDate) {
        this.base3StartDate = base3StartDate;
    }

    public LocalDate getBase3FechaDesde() {
        return base3FechaDesde;
    }

    public void setBase3FechaDesde(LocalDate base3FechaDesde) {
        this.base3FechaDesde = base3FechaDesde;
    }

    public LocalDate getBase3FechaHasta() {
        return base3FechaHasta;
    }

    public void setBase3FechaHasta(LocalDate base3FechaHasta) {
        this.base3FechaHasta = base3FechaHasta;
    }

    public BigDecimal getBase3Rentabilidad() {
        return base3Rentabilidad;
    }

    public void setBase3Rentabilidad(BigDecimal base3Rentabilidad) {
        this.base3Rentabilidad = base3Rentabilidad;
    }

    public Integer getBase3DiasConSaldo() {
        return base3DiasConSaldo;
    }

    public void setBase3DiasConSaldo(Integer base3DiasConSaldo) {
        this.base3DiasConSaldo = base3DiasConSaldo;
    }

    public BigDecimal getBase3SumaSaldosIniciales() {
        return base3SumaSaldosIniciales;
    }

    public void setBase3SumaSaldosIniciales(BigDecimal base3SumaSaldosIniciales) {
        this.base3SumaSaldosIniciales = base3SumaSaldosIniciales;
    }

    public BigDecimal getBase3SumaSaldoRentabilidad() {
        return base3SumaSaldoRentabilidad;
    }

    public void setBase3SumaSaldoRentabilidad(BigDecimal base3SumaSaldoRentabilidad) {
        this.base3SumaSaldoRentabilidad = base3SumaSaldoRentabilidad;
    }

    public BigDecimal getBase3RentabilidadPonderadaCl() {
        return base3RentabilidadPonderadaCl;
    }

    public void setBase3RentabilidadPonderadaCl(BigDecimal base3RentabilidadPonderadaCl) {
        this.base3RentabilidadPonderadaCl = base3RentabilidadPonderadaCl;
    }

    public BigDecimal getBase3RentabilidadPeriodoCl() {
        return base3RentabilidadPeriodoCl;
    }

    public void setBase3RentabilidadPeriodoCl(BigDecimal base3RentabilidadPeriodoCl) {
        this.base3RentabilidadPeriodoCl = base3RentabilidadPeriodoCl;
    }

    public Integer getBase3CantReg() {
        return base3CantReg;
    }

    public void setBase3CantReg(Integer base3CantReg) {
        this.base3CantReg = base3CantReg;
    }

    public LocalDate getBase4StartDate() {
        return base4StartDate;
    }

    public void setBase4StartDate(LocalDate base4StartDate) {
        this.base4StartDate = base4StartDate;
    }

    public LocalDate getBase4FechaDesde() {
        return base4FechaDesde;
    }

    public void setBase4FechaDesde(LocalDate base4FechaDesde) {
        this.base4FechaDesde = base4FechaDesde;
    }

    public LocalDate getBase4FechaHasta() {
        return base4FechaHasta;
    }

    public void setBase4FechaHasta(LocalDate base4FechaHasta) {
        this.base4FechaHasta = base4FechaHasta;
    }

    public BigDecimal getBase4Rentabilidad() {
        return base4Rentabilidad;
    }

    public void setBase4Rentabilidad(BigDecimal base4Rentabilidad) {
        this.base4Rentabilidad = base4Rentabilidad;
    }

    public Integer getBase4DiasConSaldo() {
        return base4DiasConSaldo;
    }

    public void setBase4DiasConSaldo(Integer base4DiasConSaldo) {
        this.base4DiasConSaldo = base4DiasConSaldo;
    }

    public BigDecimal getBase4SumaSaldosIniciales() {
        return base4SumaSaldosIniciales;
    }

    public void setBase4SumaSaldosIniciales(BigDecimal base4SumaSaldosIniciales) {
        this.base4SumaSaldosIniciales = base4SumaSaldosIniciales;
    }

    public BigDecimal getBase4SumaSaldoRentabilidad() {
        return base4SumaSaldoRentabilidad;
    }

    public void setBase4SumaSaldoRentabilidad(BigDecimal base4SumaSaldoRentabilidad) {
        this.base4SumaSaldoRentabilidad = base4SumaSaldoRentabilidad;
    }

    public BigDecimal getBase4RentabilidadPonderadaCl() {
        return base4RentabilidadPonderadaCl;
    }

    public void setBase4RentabilidadPonderadaCl(BigDecimal base4RentabilidadPonderadaCl) {
        this.base4RentabilidadPonderadaCl = base4RentabilidadPonderadaCl;
    }

    public BigDecimal getBase4RentabilidadPeriodoCl() {
        return base4RentabilidadPeriodoCl;
    }

    public void setBase4RentabilidadPeriodoCl(BigDecimal base4RentabilidadPeriodoCl) {
        this.base4RentabilidadPeriodoCl = base4RentabilidadPeriodoCl;
    }

    public Integer getBase4CantReg() {
        return base4CantReg;
    }

    public void setBase4CantReg(Integer base4CantReg) {
        this.base4CantReg = base4CantReg;
    }

    public LocalDate getBase5StartDate() {
        return base5StartDate;
    }

    public void setBase5StartDate(LocalDate base5StartDate) {
        this.base5StartDate = base5StartDate;
    }

    public LocalDate getBase5FechaDesde() {
        return base5FechaDesde;
    }

    public void setBase5FechaDesde(LocalDate base5FechaDesde) {
        this.base5FechaDesde = base5FechaDesde;
    }

    public LocalDate getBase5FechaHasta() {
        return base5FechaHasta;
    }

    public void setBase5FechaHasta(LocalDate base5FechaHasta) {
        this.base5FechaHasta = base5FechaHasta;
    }

    public BigDecimal getBase5Rentabilidad() {
        return base5Rentabilidad;
    }

    public void setBase5Rentabilidad(BigDecimal base5Rentabilidad) {
        this.base5Rentabilidad = base5Rentabilidad;
    }

    public Integer getBase5DiasConSaldo() {
        return base5DiasConSaldo;
    }

    public void setBase5DiasConSaldo(Integer base5DiasConSaldo) {
        this.base5DiasConSaldo = base5DiasConSaldo;
    }

    public BigDecimal getBase5SumaSaldosIniciales() {
        return base5SumaSaldosIniciales;
    }

    public void setBase5SumaSaldosIniciales(BigDecimal base5SumaSaldosIniciales) {
        this.base5SumaSaldosIniciales = base5SumaSaldosIniciales;
    }

    public BigDecimal getBase5SumaSaldoRentabilidad() {
        return base5SumaSaldoRentabilidad;
    }

    public void setBase5SumaSaldoRentabilidad(BigDecimal base5SumaSaldoRentabilidad) {
        this.base5SumaSaldoRentabilidad = base5SumaSaldoRentabilidad;
    }

    public BigDecimal getBase5RentabilidadPonderadaCl() {
        return base5RentabilidadPonderadaCl;
    }

    public void setBase5RentabilidadPonderadaCl(BigDecimal base5RentabilidadPonderadaCl) {
        this.base5RentabilidadPonderadaCl = base5RentabilidadPonderadaCl;
    }

    public BigDecimal getBase5RentabilidadPeriodoCl() {
        return base5RentabilidadPeriodoCl;
    }

    public void setBase5RentabilidadPeriodoCl(BigDecimal base5RentabilidadPeriodoCl) {
        this.base5RentabilidadPeriodoCl = base5RentabilidadPeriodoCl;
    }

    public Integer getBase5CantReg() {
        return base5CantReg;
    }

    public void setBase5CantReg(Integer base5CantReg) {
        this.base5CantReg = base5CantReg;
    }

    public LocalDate getBase6StartDate() {
        return base6StartDate;
    }

    public void setBase6StartDate(LocalDate base6StartDate) {
        this.base6StartDate = base6StartDate;
    }

    public LocalDate getBase6FechaDesde() {
        return base6FechaDesde;
    }

    public void setBase6FechaDesde(LocalDate base6FechaDesde) {
        this.base6FechaDesde = base6FechaDesde;
    }

    public LocalDate getBase6FechaHasta() {
        return base6FechaHasta;
    }

    public void setBase6FechaHasta(LocalDate base6FechaHasta) {
        this.base6FechaHasta = base6FechaHasta;
    }

    public BigDecimal getBase6Rentabilidad() {
        return base6Rentabilidad;
    }

    public void setBase6Rentabilidad(BigDecimal base6Rentabilidad) {
        this.base6Rentabilidad = base6Rentabilidad;
    }

    public Integer getBase6DiasConSaldo() {
        return base6DiasConSaldo;
    }

    public void setBase6DiasConSaldo(Integer base6DiasConSaldo) {
        this.base6DiasConSaldo = base6DiasConSaldo;
    }

    public BigDecimal getBase6SumaSaldosIniciales() {
        return base6SumaSaldosIniciales;
    }

    public void setBase6SumaSaldosIniciales(BigDecimal base6SumaSaldosIniciales) {
        this.base6SumaSaldosIniciales = base6SumaSaldosIniciales;
    }

    public BigDecimal getBase6SumaSaldoRentabilidad() {
        return base6SumaSaldoRentabilidad;
    }

    public void setBase6SumaSaldoRentabilidad(BigDecimal base6SumaSaldoRentabilidad) {
        this.base6SumaSaldoRentabilidad = base6SumaSaldoRentabilidad;
    }

    public BigDecimal getBase6RentabilidadPonderadaCl() {
        return base6RentabilidadPonderadaCl;
    }

    public void setBase6RentabilidadPonderadaCl(BigDecimal base6RentabilidadPonderadaCl) {
        this.base6RentabilidadPonderadaCl = base6RentabilidadPonderadaCl;
    }

    public BigDecimal getBase6RentabilidadPeriodoCl() {
        return base6RentabilidadPeriodoCl;
    }

    public void setBase6RentabilidadPeriodoCl(BigDecimal base6RentabilidadPeriodoCl) {
        this.base6RentabilidadPeriodoCl = base6RentabilidadPeriodoCl;
    }

    public Integer getBase6CantReg() {
        return base6CantReg;
    }

    public void setBase6CantReg(Integer base6CantReg) {
        this.base6CantReg = base6CantReg;
    }

    public LocalDate getBase7StartDate() {
        return base7StartDate;
    }

    public void setBase7StartDate(LocalDate base7StartDate) {
        this.base7StartDate = base7StartDate;
    }

    public LocalDate getBase7FechaDesde() {
        return base7FechaDesde;
    }

    public void setBase7FechaDesde(LocalDate base7FechaDesde) {
        this.base7FechaDesde = base7FechaDesde;
    }

    public LocalDate getBase7FechaHasta() {
        return base7FechaHasta;
    }

    public void setBase7FechaHasta(LocalDate base7FechaHasta) {
        this.base7FechaHasta = base7FechaHasta;
    }

    public BigDecimal getBase7Rentabilidad() {
        return base7Rentabilidad;
    }

    public void setBase7Rentabilidad(BigDecimal base7Rentabilidad) {
        this.base7Rentabilidad = base7Rentabilidad;
    }

    public Integer getBase7DiasConSaldo() {
        return base7DiasConSaldo;
    }

    public void setBase7DiasConSaldo(Integer base7DiasConSaldo) {
        this.base7DiasConSaldo = base7DiasConSaldo;
    }

    public BigDecimal getBase7SumaSaldosIniciales() {
        return base7SumaSaldosIniciales;
    }

    public void setBase7SumaSaldosIniciales(BigDecimal base7SumaSaldosIniciales) {
        this.base7SumaSaldosIniciales = base7SumaSaldosIniciales;
    }

    public BigDecimal getBase7SumaSaldoRentabilidad() {
        return base7SumaSaldoRentabilidad;
    }

    public void setBase7SumaSaldoRentabilidad(BigDecimal base7SumaSaldoRentabilidad) {
        this.base7SumaSaldoRentabilidad = base7SumaSaldoRentabilidad;
    }

    public BigDecimal getBase7RentabilidadPonderadaCl() {
        return base7RentabilidadPonderadaCl;
    }

    public void setBase7RentabilidadPonderadaCl(BigDecimal base7RentabilidadPonderadaCl) {
        this.base7RentabilidadPonderadaCl = base7RentabilidadPonderadaCl;
    }

    public BigDecimal getBase7RentabilidadPeriodoCl() {
        return base7RentabilidadPeriodoCl;
    }

    public void setBase7RentabilidadPeriodoCl(BigDecimal base7RentabilidadPeriodoCl) {
        this.base7RentabilidadPeriodoCl = base7RentabilidadPeriodoCl;
    }

    public Integer getBase7CantReg() {
        return base7CantReg;
    }

    public void setBase7CantReg(Integer base7CantReg) {
        this.base7CantReg = base7CantReg;
    }

    public LocalDate getBase8StartDate() {
        return base8StartDate;
    }

    public void setBase8StartDate(LocalDate base8StartDate) {
        this.base8StartDate = base8StartDate;
    }

    public LocalDate getBase8FechaDesde() {
        return base8FechaDesde;
    }

    public void setBase8FechaDesde(LocalDate base8FechaDesde) {
        this.base8FechaDesde = base8FechaDesde;
    }

    public LocalDate getBase8FechaHasta() {
        return base8FechaHasta;
    }

    public void setBase8FechaHasta(LocalDate base8FechaHasta) {
        this.base8FechaHasta = base8FechaHasta;
    }

    public BigDecimal getBase8Rentabilidad() {
        return base8Rentabilidad;
    }

    public void setBase8Rentabilidad(BigDecimal base8Rentabilidad) {
        this.base8Rentabilidad = base8Rentabilidad;
    }

    public Integer getBase8DiasConSaldo() {
        return base8DiasConSaldo;
    }

    public void setBase8DiasConSaldo(Integer base8DiasConSaldo) {
        this.base8DiasConSaldo = base8DiasConSaldo;
    }

    public BigDecimal getBase8SumaSaldosIniciales() {
        return base8SumaSaldosIniciales;
    }

    public void setBase8SumaSaldosIniciales(BigDecimal base8SumaSaldosIniciales) {
        this.base8SumaSaldosIniciales = base8SumaSaldosIniciales;
    }

    public BigDecimal getBase8SumaSaldoRentabilidad() {
        return base8SumaSaldoRentabilidad;
    }

    public void setBase8SumaSaldoRentabilidad(BigDecimal base8SumaSaldoRentabilidad) {
        this.base8SumaSaldoRentabilidad = base8SumaSaldoRentabilidad;
    }

    public BigDecimal getBase8RentabilidadPonderadaCl() {
        return base8RentabilidadPonderadaCl;
    }

    public void setBase8RentabilidadPonderadaCl(BigDecimal base8RentabilidadPonderadaCl) {
        this.base8RentabilidadPonderadaCl = base8RentabilidadPonderadaCl;
    }

    public BigDecimal getBase8RentabilidadPeriodoCl() {
        return base8RentabilidadPeriodoCl;
    }

    public void setBase8RentabilidadPeriodoCl(BigDecimal base8RentabilidadPeriodoCl) {
        this.base8RentabilidadPeriodoCl = base8RentabilidadPeriodoCl;
    }

    public Integer getBase8CantReg() {
        return base8CantReg;
    }

    public void setBase8CantReg(Integer base8CantReg) {
        this.base8CantReg = base8CantReg;
    }

    @Override
    public String toString() {
        return "RentabilidadCalculada{" +
                "id=" + id +
                ", processDate='" + processDate + '\'' +
                ", agregadorN1='" + agregadorN1 + '\'' +
                ", agregadorN2='" + agregadorN2 + '\'' +
                ", agregadorN3='" + agregadorN3 + '\'' +
                ", agregadorN4='" + agregadorN4 + '\'' +
                ", rowId='" + rowId + '\'' +
                ", nivel='" + nivel + '\'' +
                ", subNivel=" + subNivel +
                ", processDateAsDate=" + processDateAsDate +
                ", saldoDiaAnterior=" + saldoDiaAnterior +
                ", abonosDia=" + abonosDia +
                ", retirosDia=" + retirosDia +
                ", dividendosDia=" + dividendosDia +
                ", saldoDia=" + saldoDia +
                ", comisionDevengadaDia=" + comisionDevengadaDia +
                ", utilidad=" + utilidad +
                ", rentabilidad=" + rentabilidad +
                ", rentabilidadBasePitatoria=" + rentabilidadBasePitatoria +
                ", saldoRentabilidad=" + saldoRentabilidad +
                ", base1StartDate=" + base1StartDate +
                ", base1FechaDesde=" + base1FechaDesde +
                ", base1FechaHasta=" + base1FechaHasta +
                ", base1Rentabilidad=" + base1Rentabilidad +
                ", base1RentabilidadAnualizada=" + base1RentabilidadAnualizada +
                ", base1DiasConSaldo=" + base1DiasConSaldo +
                ", base1SumaSaldosIniciales=" + base1SumaSaldosIniciales +
                ", base1SumaSaldoRentabilidad=" + base1SumaSaldoRentabilidad +
                ", base1RentabilidadPonderadaCl=" + base1RentabilidadPonderadaCl +
                ", base1RentabilidadPeriodoCl=" + base1RentabilidadPeriodoCl +
                ", base1CantReg=" + base1CantReg +
                ", base2StartDate=" + base2StartDate +
                ", base2FechaDesde=" + base2FechaDesde +
                ", base2FechaHasta=" + base2FechaHasta +
                ", base2Rentabilidad=" + base2Rentabilidad +
                ", base2RentabilidadAnualizada=" + base2RentabilidadAnualizada +
                ", base2DiasConSaldo=" + base2DiasConSaldo +
                ", base2SumaSaldosIniciales=" + base2SumaSaldosIniciales +
                ", base2SumaSaldoRentabilidad=" + base2SumaSaldoRentabilidad +
                ", base2RentabilidadPonderadaCl=" + base2RentabilidadPonderadaCl +
                ", base2RentabilidadPeriodoCl=" + base2RentabilidadPeriodoCl +
                ", base2CantReg=" + base2CantReg +
                ", base3StartDate=" + base3StartDate +
                ", base3FechaDesde=" + base3FechaDesde +
                ", base3FechaHasta=" + base3FechaHasta +
                ", base3Rentabilidad=" + base3Rentabilidad +
                ", base3RentabilidadAnualizada=" + base3RentabilidadAnualizada +
                ", base3DiasConSaldo=" + base3DiasConSaldo +
                ", base3SumaSaldosIniciales=" + base3SumaSaldosIniciales +
                ", base3SumaSaldoRentabilidad=" + base3SumaSaldoRentabilidad +
                ", base3RentabilidadPonderadaCl=" + base3RentabilidadPonderadaCl +
                ", base3RentabilidadPeriodoCl=" + base3RentabilidadPeriodoCl +
                ", base3CantReg=" + base3CantReg +
                ", base4StartDate=" + base4StartDate +
                ", base4FechaDesde=" + base4FechaDesde +
                ", base4FechaHasta=" + base4FechaHasta +
                ", base4Rentabilidad=" + base4Rentabilidad +
                ", base4RentabilidadAnualizada=" + base4RentabilidadAnualizada +
                ", base4DiasConSaldo=" + base4DiasConSaldo +
                ", base4SumaSaldosIniciales=" + base4SumaSaldosIniciales +
                ", base4SumaSaldoRentabilidad=" + base4SumaSaldoRentabilidad +
                ", base4RentabilidadPonderadaCl=" + base4RentabilidadPonderadaCl +
                ", base4RentabilidadPeriodoCl=" + base4RentabilidadPeriodoCl +
                ", base4CantReg=" + base4CantReg +
                ", base5StartDate=" + base5StartDate +
                ", base5FechaDesde=" + base5FechaDesde +
                ", base5FechaHasta=" + base5FechaHasta +
                ", base5Rentabilidad=" + base5Rentabilidad +
                ", base5RentabilidadAnualizada=" + base5RentabilidadAnualizada +
                ", base5DiasConSaldo=" + base5DiasConSaldo +
                ", base5SumaSaldosIniciales=" + base5SumaSaldosIniciales +
                ", base5SumaSaldoRentabilidad=" + base5SumaSaldoRentabilidad +
                ", base5RentabilidadPonderadaCl=" + base5RentabilidadPonderadaCl +
                ", base5RentabilidadPeriodoCl=" + base5RentabilidadPeriodoCl +
                ", base5CantReg=" + base5CantReg +
                ", base6StartDate=" + base6StartDate +
                ", base6FechaDesde=" + base6FechaDesde +
                ", base6FechaHasta=" + base6FechaHasta +
                ", base6Rentabilidad=" + base6Rentabilidad +
                ", base6RentabilidadAnualizada=" + base6RentabilidadAnualizada +
                ", base6DiasConSaldo=" + base6DiasConSaldo +
                ", base6SumaSaldosIniciales=" + base6SumaSaldosIniciales +
                ", base6SumaSaldoRentabilidad=" + base6SumaSaldoRentabilidad +
                ", base6RentabilidadPonderadaCl=" + base6RentabilidadPonderadaCl +
                ", base6RentabilidadPeriodoCl=" + base6RentabilidadPeriodoCl +
                ", base6CantReg=" + base6CantReg +
                ", base7StartDate=" + base7StartDate +
                ", base7FechaDesde=" + base7FechaDesde +
                ", base7FechaHasta=" + base7FechaHasta +
                ", base7Rentabilidad=" + base7Rentabilidad +
                ", base7RentabilidadAnualizada=" + base7RentabilidadAnualizada +
                ", base7DiasConSaldo=" + base7DiasConSaldo +
                ", base7SumaSaldosIniciales=" + base7SumaSaldosIniciales +
                ", base7SumaSaldoRentabilidad=" + base7SumaSaldoRentabilidad +
                ", base7RentabilidadPonderadaCl=" + base7RentabilidadPonderadaCl +
                ", base7RentabilidadPeriodoCl=" + base7RentabilidadPeriodoCl +
                ", base7CantReg=" + base7CantReg +
                ", base8StartDate=" + base8StartDate +
                ", base8FechaDesde=" + base8FechaDesde +
                ", base8FechaHasta=" + base8FechaHasta +
                ", base8Rentabilidad=" + base8Rentabilidad +
                ", base8RentabilidadAnualizada=" + base8RentabilidadAnualizada +
                ", base8DiasConSaldo=" + base8DiasConSaldo +
                ", base8SumaSaldosIniciales=" + base8SumaSaldosIniciales +
                ", base8SumaSaldoRentabilidad=" + base8SumaSaldoRentabilidad +
                ", base8RentabilidadPonderadaCl=" + base8RentabilidadPonderadaCl +
                ", base8RentabilidadPeriodoCl=" + base8RentabilidadPeriodoCl +
                ", base8CantReg=" + base8CantReg +
                '}';
    }
}