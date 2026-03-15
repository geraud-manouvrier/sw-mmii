package cl.qande.mmii.app.models.dto.core;

import java.math.BigDecimal;

public class SaldoCuentaResumenDto {

    private BigDecimal sumUsdeMarketValue;
    private String accountNo;

    public SaldoCuentaResumenDto(BigDecimal sumUsdeMarketValue, String accountNo) {
        this.sumUsdeMarketValue = sumUsdeMarketValue;
        this.accountNo = accountNo;
    }

    public BigDecimal getSumUsdeMarketValue() {
        return sumUsdeMarketValue;
    }

    public String getAccountNo() {
        return accountNo;
    }
}