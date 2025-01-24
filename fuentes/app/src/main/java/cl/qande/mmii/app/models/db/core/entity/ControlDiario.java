package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "control_diario")
public class ControlDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "correlativo_diario", nullable = false)
    private Integer correlativoDiario;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @NotNull
    @Column(name = "timestamp_control", nullable = false)
    private Timestamp timestampControl;

    @NotNull
    @Column(name = "timestamp_registro", nullable = false)
    private Timestamp timestampRegistro;

    @NotNull
    @Column(name = "id_control", nullable = false)
    private Integer idControl;

    @Size(max = 1000)
    @NotNull
    @Column(name = "glosa_control", nullable = false, length = 1000)
    private String glosaControl;

    @Size(max = 1000)
    @NotNull
    @Column(name = "descripcion_control", nullable = false, length = 1000)
    private String descripcionControl;

    @Size(max = 100)
    @NotNull
    @Column(name = "identificador", nullable = false, length = 100)
    private String identificador;

    @NotNull
    @Column(name = "cant_reg", nullable = false)
    private Integer cantReg;

    @Size(max = 30)
    @NotNull
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCorrelativoDiario() {
        return correlativoDiario;
    }

    public void setCorrelativoDiario(Integer correlativoDiario) {
        this.correlativoDiario = correlativoDiario;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Timestamp getTimestampControl() {
        return timestampControl;
    }

    public void setTimestampControl(Timestamp timestampControl) {
        this.timestampControl = timestampControl;
    }

    public Timestamp getTimestampRegistro() {
        return timestampRegistro;
    }

    public void setTimestampRegistro(Timestamp timestampRegistro) {
        this.timestampRegistro = timestampRegistro;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public String getGlosaControl() {
        return glosaControl;
    }

    public void setGlosaControl(String glosaControl) {
        this.glosaControl = glosaControl;
    }

    public String getDescripcionControl() {
        return descripcionControl;
    }

    public void setDescripcionControl(String descripcionControl) {
        this.descripcionControl = descripcionControl;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCantReg() {
        return cantReg;
    }

    public void setCantReg(Integer cantReg) {
        this.cantReg = cantReg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ControlDiario{" +
                "id=" + id +
                ", correlativoDiario=" + correlativoDiario +
                ", processDate='" + processDate + '\'' +
                ", timestampControl=" + timestampControl +
                ", timestampRegistro=" + timestampRegistro +
                ", idControl=" + idControl +
                ", glosaControl='" + glosaControl + '\'' +
                ", descripcionControl='" + descripcionControl + '\'' +
                ", identificador='" + identificador + '\'' +
                ", cantReg=" + cantReg +
                ", username='" + username + '\'' +
                '}';
    }
}