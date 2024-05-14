package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "jobs_log")
public class JobsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "id_job", nullable = false)
    private Integer idJob;

    @NotNull
    @Column(name = "start_timestamp", nullable = false)
    private Timestamp startTimestamp;

    @Column(name = "end_timestamp")
    private Timestamp endTimestamp;

    @Size(max = 100)
    @NotNull
    @Column(name = "id_proceso", nullable = false, length = 100)
    private String idProceso;

    @Size(max = 100)
    @Column(name = "sub_id_proceso", length = 100)
    private String subIdProceso;

    @Size(max = 1000)
    @Column(name = "info", length = 1000)
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Timestamp endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getSubIdProceso() {
        return subIdProceso;
    }

    public void setSubIdProceso(String subIdProceso) {
        this.subIdProceso = subIdProceso;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}