package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "oficina_stonex")
public class OficinaStonex {
    @Id
    @Size(max = 100)
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "distribution_fee_percent", precision = 45, scale = 20)
    private BigDecimal distributionFeePercent;

    @Column(name = "reconocimiento_adicional_percent", precision = 45, scale = 20)
    private BigDecimal reconocimientoAdicionalPercent;

    @Column(name = "iva_percent", precision = 45, scale = 40)
    private BigDecimal ivaPercent;

    @Column(name = "collect_on_behalf_of_percent", precision = 45, scale = 20)
    private BigDecimal collectOnBehalfOfPercent;

    public BigDecimal getCollectOnBehalfOfPercent() {
        return collectOnBehalfOfPercent;
    }

    public void setCollectOnBehalfOfPercent(BigDecimal collectOnBehalfOfPercent) {
        this.collectOnBehalfOfPercent = collectOnBehalfOfPercent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getDistributionFeePercent() {
        return distributionFeePercent;
    }

    public void setDistributionFeePercent(BigDecimal distributionFeePercent) {
        this.distributionFeePercent = distributionFeePercent;
    }

    public BigDecimal getReconocimientoAdicionalPercent() {
        return reconocimientoAdicionalPercent;
    }

    public void setReconocimientoAdicionalPercent(BigDecimal reconocimientoAdicionalPercent) {
        this.reconocimientoAdicionalPercent = reconocimientoAdicionalPercent;
    }

    public BigDecimal getIvaPercent() {
        return ivaPercent;
    }

    public void setIvaPercent(BigDecimal ivaPercent) {
        this.ivaPercent = ivaPercent;
    }

}