package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "par_source_code")
public class ParSourceCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "source_code_pershing", nullable = false, length = 100)
    private String sourceCodePershing;

    @Column(name = "signo_movimiento")
    private Integer signoMovimiento;

    @Size(max = 100)
    @NotNull
    @Column(name = "descripcion_movimiento", nullable = false, length = 100)
    private String descripcionMovimiento;

    @NotNull
    @Column(name = "aplica_flujo_neto", nullable = false)
    private Integer aplicaFlujoNeto;

    @Size(max = 1000)
    @Column(name = "observaciones_internas", length = 1000)
    private String observacionesInternas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCodePershing() {
        return sourceCodePershing;
    }

    public void setSourceCodePershing(String sourceCodePershing) {
        this.sourceCodePershing = sourceCodePershing;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
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

}