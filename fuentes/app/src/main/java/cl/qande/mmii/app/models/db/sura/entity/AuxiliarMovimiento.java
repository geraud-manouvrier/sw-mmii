package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "auxiliar_movimiento", schema = "sura")
public class AuxiliarMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "codigo_stonex", nullable = false, length = 100)
    private String codigoStonex;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "codigo_pershing", nullable = false, length = 100)
    private String codigoPershing;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "descripcion_movimiento", nullable = false, length = 100)
    private String descripcionMovimiento;

    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "aplica_flujo_neto", nullable = false)
    private Integer aplicaFlujoNeto;

    @Size(max = 1000, message = "Debe ser máximo largo 1000")
    @Column(name = "observaciones_internas", length = 1000)
    private String observacionesInternas;

    @Column(name = "signo_movimiento")
    private Integer signoMovimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoStonex() {
        return codigoStonex;
    }

    public void setCodigoStonex(String codigoStonex) {
        this.codigoStonex = codigoStonex;
    }

    public String getCodigoPershing() {
        return codigoPershing;
    }

    public void setCodigoPershing(String codigoPershing) {
        this.codigoPershing = codigoPershing;
    }

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public Integer getAplicaFlujoNeto() {
        return aplicaFlujoNeto;
    }

    public void setAplicaFlujoNeto(Integer aplicaFlujoNeto) {
        this.aplicaFlujoNeto = aplicaFlujoNeto;
    }

    public String getObservacionesInternas() {
        return observacionesInternas;
    }

    public void setObservacionesInternas(String observacionesInternas) {
        this.observacionesInternas = observacionesInternas;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
    }

    @Override
    public String toString() {
        return "AuxiliarMovimiento{" +
                "id=" + id +
                ", codigoStonex='" + codigoStonex + '\'' +
                ", codigoPershing='" + codigoPershing + '\'' +
                ", descripcionMovimiento='" + descripcionMovimiento + '\'' +
                ", aplicaFlujoNeto=" + aplicaFlujoNeto +
                ", observacionesInternas='" + observacionesInternas + '\'' +
                ", signoMovimiento=" + signoMovimiento +
                '}';
    }
}