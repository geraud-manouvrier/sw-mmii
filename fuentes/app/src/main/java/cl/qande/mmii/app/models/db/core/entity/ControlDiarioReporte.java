package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "control_diario_reporte")
public class ControlDiarioReporte {
    @Id
    @Column(name = "id_reporte")
    private Long idReporte;

    @Column(name = "correlativo_diario")
    private Integer correlativoDiario;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "timestamp_control")
    private Instant timestampControl;

    @Column(name = "timestamp_registro")
    private Instant timestampRegistro;

    @Column(name = "id_control")
    private Integer idControl;

    @Size(max = 1000)
    @Column(name = "glosa_control", length = 1000)
    private String glosaControl;

    @Size(max = 1000)
    @Column(name = "descripcion_control", length = 1000)
    private String descripcionControl;

    @Size(max = 100)
    @Column(name = "identificador", length = 100)
    private String identificador;

    @Column(name = "cant_reg")
    private Integer cantReg;

    @Size(max = 30)
    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "id_segmentacion")
    private Integer idSegmentacion;

    @Column(name = "cod_pais_atencion")
    private Integer codPaisAtencion;

    @Size(max = 100)
    @Column(name = "modelo_asesoria", length = 100)
    private String modeloAsesoria;

    @Size(max = 100)
    @Column(name = "variante", length = 100)
    private String variante;

    public Long getIdReporte() {
        return idReporte;
    }

    public Integer getCorrelativoDiario() {
        return correlativoDiario;
    }

    public String getProcessDate() {
        return processDate;
    }

    public Instant getTimestampControl() {
        return timestampControl;
    }

    public Instant getTimestampRegistro() {
        return timestampRegistro;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public String getGlosaControl() {
        return glosaControl;
    }

    public String getDescripcionControl() {
        return descripcionControl;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Integer getCantReg() {
        return cantReg;
    }

    public String getUsername() {
        return username;
    }

    public Integer getIdSegmentacion() {
        return idSegmentacion;
    }

    public Integer getCodPaisAtencion() {
        return codPaisAtencion;
    }

    public String getModeloAsesoria() {
        return modeloAsesoria;
    }

    public String getVariante() {
        return variante;
    }

    protected ControlDiarioReporte() {
    }
}