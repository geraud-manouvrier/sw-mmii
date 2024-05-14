package cl.qande.mmii.app.models.db.rep_inv.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsolidadoAgregadoN1Id implements Serializable {
    private static final long serialVersionUID = 8190273233330283719L;
    @Size(max = 100)
    @NotNull
    @Column(name = "process_date", nullable = false, length = 100)
    private String processDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "agregador_n1", nullable = false, length = 100)
    private String agregadorN1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsolidadoAgregadoN1Id entity = (ConsolidadoAgregadoN1Id) o;
        return Objects.equals(this.agregadorN1, entity.agregadorN1) &&
                Objects.equals(this.processDate, entity.processDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agregadorN1, processDate);
    }

    @Override
    public String toString() {
        return "ConsolidadoAgregadoN1Id{" +
                "processDate='" + processDate + '\'' +
                ", agregadorN1='" + agregadorN1 + '\'' +
                '}';
    }
}