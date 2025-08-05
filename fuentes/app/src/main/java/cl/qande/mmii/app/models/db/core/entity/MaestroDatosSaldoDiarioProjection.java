package cl.qande.mmii.app.models.db.core.entity;

import java.math.BigDecimal;

public interface MaestroDatosSaldoDiarioProjection {
    String getProcessDate();
    String    getClientName();
    String    getAccountNumber();
    BigDecimal getSaldoDiario();
}
