package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "proceso_ftp", schema = "stonex")
public class ProcesoFtpStonex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @NotNull
    @Column(name = "process_stamp", nullable = false)
    private String processStamp;

    @NotNull
    @Column(name = "start_timestamp", nullable = false)
    private Timestamp startTimestamp;

    @NotNull
    @Column(name = "last_step_timestamp", nullable = false)
    private Timestamp lastStepTimestamp;

    @NotNull
    @Column(name = "info_log", nullable = false)
    private String infoLog;

    @NotNull
    @Column(name = "id_estado_proceso_ftp", nullable = false)
    private Integer idEstadoProcesoFtp;

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

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getLastStepTimestamp() {
        return lastStepTimestamp;
    }

    public void setLastStepTimestamp(Timestamp lastStepTimestamp) {
        this.lastStepTimestamp = lastStepTimestamp;
    }

    public String getInfoLog() {
        return infoLog;
    }

    public void setInfoLog(String infoLog) {
        this.infoLog = infoLog;
    }

    public Integer getIdEstadoProcesoFtp() {
        return idEstadoProcesoFtp;
    }

    public void setIdEstadoProcesoFtp(Integer idEstadoProcesoFtp) {
        this.idEstadoProcesoFtp = idEstadoProcesoFtp;
    }
}