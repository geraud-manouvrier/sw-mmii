package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_reporte_diferencias_fee")
@NamedNativeQuery(
        name = VwReporteDiferenciasFee.FIND_BY_PROCESS_DATE,
        query = "SELECT * FROM public.vw_reporte_diferencias_fee",
        resultClass = VwReporteDiferenciasFee.class
)public class VwReporteDiferenciasFee implements Serializable {
    public static final String FIND_BY_PROCESS_DATE = "VwReporteDiferenciasFee.findByProcessDate";

    public static List<VwReporteDiferenciasFee> findByProcessDate(EntityManager entityManager) {
        return entityManager.createNamedQuery(FIND_BY_PROCESS_DATE, VwReporteDiferenciasFee.class)
                .getResultList();
    }

    @Id
    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Id
    @Column(name = "custodian", nullable = false)
    private String custodian;

    @Id
    @Column(name = "account_no", nullable = false)
    private String accountNo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ingreso_egreso_efectivo", nullable = false, precision = 20, scale = 6)
    private BigDecimal ingresoEgresoEfectivo;

    @Column(name = "glosa", nullable = false)
    private String glosa;

    @Column(name = "monto_min", nullable = false, precision = 20, scale = 6)
    private BigDecimal montoMin;

    @Column(name = "monto_max", nullable = false, precision = 20, scale = 6)
    private BigDecimal montoMax;

    /** annual_fee * 100 */
    @Column(name = "fee_seg", nullable = false, precision = 10, scale = 4)
    private BigDecimal feeSeg;

    @Column(name = "fee_cte", nullable = false, precision = 10, scale = 4)
    private BigDecimal feeCte;

    @Column(name = "flag_fee", nullable = false)
    private Boolean flagFee;

    public String getClientId() {
        return clientId;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getIngresoEgresoEfectivo() {
        return ingresoEgresoEfectivo;
    }

    public String getGlosa() {
        return glosa;
    }

    public BigDecimal getMontoMin() {
        return montoMin;
    }

    public BigDecimal getMontoMax() {
        return montoMax;
    }

    public BigDecimal getFeeSeg() {
        return feeSeg;
    }

    public BigDecimal getFeeCte() {
        return feeCte;
    }

    public Boolean getFlagFee() {
        return flagFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VwReporteDiferenciasFee that = (VwReporteDiferenciasFee) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(custodian, that.custodian) && Objects.equals(accountNo, that.accountNo) && Objects.equals(nombre, that.nombre) && Objects.equals(ingresoEgresoEfectivo, that.ingresoEgresoEfectivo) && Objects.equals(glosa, that.glosa) && Objects.equals(montoMin, that.montoMin) && Objects.equals(montoMax, that.montoMax) && Objects.equals(feeSeg, that.feeSeg) && Objects.equals(feeCte, that.feeCte) && Objects.equals(flagFee, that.flagFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, custodian, accountNo, nombre, ingresoEgresoEfectivo, glosa, montoMin, montoMax, feeSeg, feeCte, flagFee);
    }

    @Override
    public String toString() {
        return "VwReporteDiferenciasFee{" +
                "clientId='" + clientId + '\'' +
                ", custodian='" + custodian + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", saldoDia=" + ingresoEgresoEfectivo +
                ", glosa='" + glosa + '\'' +
                ", montoMin=" + montoMin +
                ", montoMax=" + montoMax +
                ", feeSeg=" + feeSeg +
                ", feeCte=" + feeCte +
                ", flagFee=" + flagFee +
                '}';
    }
}