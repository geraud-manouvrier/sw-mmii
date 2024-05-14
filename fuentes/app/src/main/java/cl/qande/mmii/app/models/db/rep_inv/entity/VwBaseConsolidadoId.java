package cl.qande.mmii.app.models.db.rep_inv.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VwBaseConsolidadoId implements Serializable {
    private static final long serialVersionUID = 2950988815829368159L;
    @Size(max = 100)
    @Column(name = "process_date", length = 100)
    private String processDate;

    @Size(max = 100)
    @Column(name = "client_id", length = 100)
    private String clientId;

    @Size(max = 100)
    @Column(name = "custodian", length = 100)
    private String custodian;

    @Size(max = 100)
    @Column(name = "account_no", length = 100)
    private String accountNo;

    @Size(max = 100)
    @Column(name = "cusip", length = 100)
    private String cusip;

    @Size(max = 100)
    @Column(name = "isin", length = 100)
    private String isin;

    @Size(max = 100)
    @Column(name = "symbol", length = 100)
    private String symbol;

    @Size(max = 100)
    @Column(name = "id_tipo_activo", length = 100)
    private String idTipoActivo;

    @Size(max = 100)
    @Column(name = "id_sub_tipo_activo", length = 100)
    private String idSubTipoActivo;

    @Size(max = 100)
    @Column(name = "id_sub_sub_tipo_activo", length = 100)
    private String idSubSubTipoActivo;

    @Size(max = 100)
    @Column(name = "currency", length = 100)
    private String currency;

    public String getProcessDate() {
        return processDate;
    }

    public String getClientId() {
        return clientId;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getCusip() {
        return cusip;
    }

    public String getIsin() {
        return isin;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getIdTipoActivo() {
        return idTipoActivo;
    }

    public String getIdSubTipoActivo() {
        return idSubTipoActivo;
    }

    public String getIdSubSubTipoActivo() {
        return idSubSubTipoActivo;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwBaseConsolidadoId entity = (VwBaseConsolidadoId) o;
        return Objects.equals(this.symbol, entity.symbol) &&
                Objects.equals(this.cusip, entity.cusip) &&
                Objects.equals(this.clientId, entity.clientId) &&
                Objects.equals(this.custodian, entity.custodian) &&
                Objects.equals(this.idTipoActivo, entity.idTipoActivo) &&
                Objects.equals(this.idSubTipoActivo, entity.idSubTipoActivo) &&
                Objects.equals(this.processDate, entity.processDate) &&
                Objects.equals(this.accountNo, entity.accountNo) &&
                Objects.equals(this.idSubSubTipoActivo, entity.idSubSubTipoActivo) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.isin, entity.isin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, cusip, clientId, custodian, idTipoActivo, idSubTipoActivo, processDate, accountNo, idSubSubTipoActivo, currency, isin);
    }

    @Override
    public String toString() {
        return "VwBaseConsolidadoId{" +
                "processDate='" + processDate + '\'' +
                ", clientId='" + clientId + '\'' +
                ", custodian='" + custodian + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", cusip='" + cusip + '\'' +
                ", isin='" + isin + '\'' +
                ", symbol='" + symbol + '\'' +
                ", idTipoActivo='" + idTipoActivo + '\'' +
                ", idSubTipoActivo='" + idSubTipoActivo + '\'' +
                ", idSubSubTipoActivo='" + idSubSubTipoActivo + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}