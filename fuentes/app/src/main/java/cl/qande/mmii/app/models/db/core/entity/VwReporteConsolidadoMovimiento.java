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
@Table(name = "vw_reporte_consolidado_movimientos")
@NamedNativeQuery(
        name = VwReporteConsolidadoMovimiento.FIND_ALL,
        query = "SELECT * FROM public.vw_reporte_consolidado_movimientos",
        resultClass = VwReporteConsolidadoMovimiento.class
)
public class VwReporteConsolidadoMovimiento {

    public static final String FIND_ALL = "VwReporteConsolidadoMovimiento.findAll";

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

    @Column(name = "usde_net_amount", precision = 45, scale = 20)
    private BigDecimal usdeNetAmount;

    @Column(name = "retiro", precision = 45, scale = 20)
    private BigDecimal retiro;

    @Column(name = "recaudo", precision = 45, scale = 20)
    private BigDecimal recaudo;

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

    public BigDecimal getUsdeNetAmount() {
        return usdeNetAmount;
    }

    public BigDecimal getRetiro() {
        return retiro;
    }

    public BigDecimal getRecaudo() {
        return recaudo;
    }

    protected VwReporteConsolidadoMovimiento() {
    }
}