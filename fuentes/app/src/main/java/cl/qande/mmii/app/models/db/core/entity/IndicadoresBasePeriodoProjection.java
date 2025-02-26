package cl.qande.mmii.app.models.db.core.entity;

import java.math.BigDecimal;

public interface IndicadoresBasePeriodoProjection {
    Integer getPeriodo();
    Integer getAgnio();
    Integer getMes();
    BigDecimal getComdevper();
    BigDecimal getComdevmargen();
    BigDecimal getAummargen();
    BigDecimal getFlujoneto();
    BigDecimal getFeepromedioreal();
    BigDecimal getFeepromediomargen();
    Integer getClientes();
    Integer getCuentas();
    Integer getDiasperiodo();
    String getFirstprocessdate();
    String getLastprocessdate();
}
