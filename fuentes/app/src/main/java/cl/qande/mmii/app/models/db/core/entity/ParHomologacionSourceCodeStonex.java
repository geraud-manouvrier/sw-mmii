package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "par_homologacion_source_code_stonex")
public class ParHomologacionSourceCodeStonex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "source_code_stonex", nullable = false, length = 100)
    private String sourceCodeStonex;

    @Column(name = "signo_movimiento")
    private Integer signoMovimiento;

    @Size(max = 1000)
    @Column(name = "observaciones_internas", length = 1000)
    private String observacionesInternas;

    @Column(name = "id_par_source_code")
    private Long idParSourceCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCodeStonex() {
        return sourceCodeStonex;
    }

    public void setSourceCodeStonex(String sourceCodeStonex) {
        this.sourceCodeStonex = sourceCodeStonex;
    }

    public Integer getSignoMovimiento() {
        return signoMovimiento;
    }

    public void setSignoMovimiento(Integer signoMovimiento) {
        this.signoMovimiento = signoMovimiento;
    }

    public String getObservacionesInternas() {
        return observacionesInternas;
    }

    public void setObservacionesInternas(String observacionesInternas) {
        this.observacionesInternas = observacionesInternas;
    }

    public Long getIdParSourceCode() {
        return idParSourceCode;
    }

    public void setIdParSourceCode(Long idParSourceCode) {
        this.idParSourceCode = idParSourceCode;
    }

}