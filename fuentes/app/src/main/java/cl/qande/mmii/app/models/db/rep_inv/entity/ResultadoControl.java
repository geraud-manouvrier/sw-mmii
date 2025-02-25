package cl.qande.mmii.app.models.db.rep_inv.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;

@Entity
@Immutable
@NamedNativeQuery(
        name = ResultadoControl.FIND_BY_PROCESS_DATE,
        query = "SELECT * FROM rep_inv.fn_control(:_process_date, :_exec_monthly, :_exec_daily)",
        resultClass = ResultadoControl.class
)
public class ResultadoControl implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_PROCESS_DATE     = "ResultadoControl.findByProcessDate";

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "id_control")
    private Integer idControl;

    @Column(name = "glosa_control", length = 1000)
    private String glosaControl;

    @Column(name = "descripcion_control", length = 1000)
    private String descripcionControl;

    @Column(name = "process_date", length = 100)
    private String processDate;

    @Column(name = "identificador", length = 100)
    private String identificador;

    @Column(name = "cant_reg")
    private Integer cantReg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
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

    @Override
    public String toString() {
        return "ResultadoControl{" +
                "id=" + id +
                ", idControl=" + idControl +
                ", glosaControl='" + glosaControl + '\'' +
                ", descripcionControl='" + descripcionControl + '\'' +
                ", processDate='" + processDate + '\'' +
                ", identificador='" + identificador + '\'' +
                ", cantReg=" + cantReg +
                '}';
    }
}
