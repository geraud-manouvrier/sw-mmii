package cl.qande.mmii.app.models.db.rep_inv.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsolidadoAgregadoN2Id implements Serializable {
    private static final long serialVersionUID = 6444312527466916633L;
    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n1", nullable = false, length = 100)
    private String agregadorN1;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n2", nullable = false, length = 100)
    private String agregadorN2;

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getAgregadorN1() {
        return agregadorN1;
    }

    public void setAgregadorN1(String agregadorN1) {
        this.agregadorN1 = agregadorN1;
    }

    public String getAgregadorN2() {
        return agregadorN2;
    }

    public void setAgregadorN2(String agregadorN2) {
        this.agregadorN2 = agregadorN2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsolidadoAgregadoN2Id entity = (ConsolidadoAgregadoN2Id) o;
        return Objects.equals(this.agregadorN1, entity.agregadorN1) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.agregadorN2, entity.agregadorN2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agregadorN1, processDate, agregadorN2);
    }

    @Override
    public String toString() {
        return "ConsolidadoAgregadoN2Id{" +
                "processDate='" + processDate + '\'' +
                ", agregadorN1='" + agregadorN1 + '\'' +
                ", agregadorN2='" + agregadorN2 + '\'' +
                '}';
    }
}