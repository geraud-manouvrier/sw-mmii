package cl.qande.mmii.app.models.db.pershing.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "proceso_sfl", schema = "pershing")
public class ProcesoSfl {
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
    @Column(name = "process_stamp", nullable = false, length = 100)
    private String processStamp;

    @NotNull
    @Column(name = "start_timestamp", nullable = false)
    private Instant startTimestamp;

    @NotNull
    @Column(name = "last_step_timestamp", nullable = false)
    private Instant lastStepTimestamp;

    @NotNull
    @Column(name = "info_log", nullable = false)
    private String infoLog;

    @NotNull
    @Column(name = "id_estado_proceso_sfl", nullable = false)
    private Integer idEstadoProcesoSfl;

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

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

    public Instant getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Instant startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Instant getLastStepTimestamp() {
        return lastStepTimestamp;
    }

    public void setLastStepTimestamp(Instant lastStepTimestamp) {
        this.lastStepTimestamp = lastStepTimestamp;
    }

    public String getInfoLog() {
        return infoLog;
    }

    public void setInfoLog(String infoLog) {
        this.infoLog = infoLog;
    }

    public Integer getIdEstadoProcesoSfl() {
        return idEstadoProcesoSfl;
    }

    public void setIdEstadoProcesoSfl(Integer idEstadoProcesoSfl) {
        this.idEstadoProcesoSfl = idEstadoProcesoSfl;
    }

}