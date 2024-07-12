package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VwCuentasNoMapeadasPershingId implements Serializable {
    private static final long serialVersionUID = -6156472972238641238L;
    @Size(max = 100)
    @Column(name = "source", length = 100)
    private String source;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "account_no")
    private String accountNo;

    public String getSource() {
        return source;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwCuentasNoMapeadasPershingId entity = (VwCuentasNoMapeadasPershingId) o;
        return Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.source, entity.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processDate, accountNo, source);
    }

}