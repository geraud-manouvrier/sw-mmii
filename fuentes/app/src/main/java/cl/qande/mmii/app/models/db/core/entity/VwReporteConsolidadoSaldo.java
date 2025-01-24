package cl.qande.mmii.app.models.db.core.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "vw_reporte_consolidado_saldos")
@NamedNativeQuery(
        name = VwReporteConsolidadoSaldo.FIND_ALL,
        query = "SELECT * FROM public.vw_reporte_consolidado_saldos",
        resultClass = VwReporteConsolidadoSaldo.class
)
public class VwReporteConsolidadoSaldo {

    public static final String FIND_ALL = "VwReporteConsolidadoSaldo.findAll";

    @Id
    @Size(max = 100)
    @Column(name = "periodo", length = 100)
    private String periodo;

    @Size(max = 100)
    @Column(name = "agnio", length = 100)
    private String agnio;

    @Column(name = "clients")
    private Integer clients;

    @Column(name = "accounts")
    private Integer accounts;

    @Column(name = "accounts_without_client")
    private Integer accountsWithoutClient;

    @Column(name = "usde_market_value", precision = 45, scale = 20)
    private BigDecimal usdeMarketValue;

    @Column(name = "ingreso_proteccion", precision = 45, scale = 20)
    private BigDecimal ingresoProteccion;

    public String getPeriodo() {
        return periodo;
    }

    public String getAgnio() {
        return agnio;
    }

    public Integer getClients() {
        return clients;
    }

    public Integer getAccounts() {
        return accounts;
    }

    public Integer getAccountsWithoutClient() {
        return accountsWithoutClient;
    }

    public BigDecimal getUsdeMarketValue() {
        return usdeMarketValue;
    }

    public BigDecimal getIngresoProteccion() {
        return ingresoProteccion;
    }

    protected VwReporteConsolidadoSaldo() {
    }
}