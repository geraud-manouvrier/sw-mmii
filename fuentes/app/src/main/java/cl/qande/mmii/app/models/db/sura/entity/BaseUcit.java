package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "base_ucit", schema = "sura")
public class BaseUcit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Debe ser valor númerico entero")
    @Column(name = "security_number", nullable = false)
    private Integer securityNumber;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "isin", nullable = false, length = 100)
    private String isin;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "sec_type", nullable = false, length = 100)
    private String secType;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(Integer securityNumber) {
        this.securityNumber = securityNumber;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "BaseUcit{" +
                "id=" + id +
                ", securityNumber=" + securityNumber +
                ", isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", secType='" + secType + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}