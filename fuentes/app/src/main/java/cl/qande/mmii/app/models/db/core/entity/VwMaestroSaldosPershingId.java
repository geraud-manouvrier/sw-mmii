package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class VwMaestroSaldosPershingId implements Serializable {
    private static final long serialVersionUID = -2769423995524870540L;
    @Size(max = 100)
    @Column(name = "custodian")
    private String custodian;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Column(name = "account_no")
    @Type(type = "org.hibernate.type.TextType")
    private String accountNo;

    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "symbol", length = 100)
    private String symbol;

    @Size(max = 100)
    @Column(name = "cusip", length = 100)
    private String cusip;

    @Size(max = 100)
    @Column(name = "isin_code", length = 100)
    private String isinCode;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Size(max = 1000)
    @Column(name = "currency", length = 1000)
    private String currency;

    public String getCustodian() {
        return custodian;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCusip() {
        return cusip;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwMaestroSaldosPershingId entity = (VwMaestroSaldosPershingId) o;
        return Objects.equals(this.symbol, entity.symbol) &&
                Objects.equals(this.cusip, entity.cusip) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.isinCode, entity.isinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, cusip, clientId, quantity, custodian, accountNo, processDate, currency, isinCode);
    }

}