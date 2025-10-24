package cl.qande.mmii.app.models.api.retornos;

import cl.qande.mmii.app.util.helper.BigDecimalPlainNumberSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

public class RetornoCuenta {

    @JsonProperty("account-no")
    private String accountNo;
    @JsonProperty("rent-dia")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rentDia;
    @JsonProperty("rent-1m")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rent1m;
    @JsonProperty("rent-3m")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rent3m;
    @JsonProperty("rent-12m")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rent12m;
    @JsonProperty("rent-ytd")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rentYtd;
    @JsonProperty("rent-inicio")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rentInicio;
    @JsonProperty("rent-12m-anualizada")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rent12mAnualizada;
    @JsonProperty("rent-ytd-anualizada")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rentYtdAnualizada;
    @JsonProperty("rent-inicio-anualizada")
    @JsonSerialize(using = BigDecimalPlainNumberSerializer.class)
    private BigDecimal rentInicioAnualizada;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getRentDia() {
        return rentDia;
    }

    public void setRentDia(BigDecimal rentDia) {
        this.rentDia = rentDia;
    }

    public BigDecimal getRent1m() {
        return rent1m;
    }

    public void setRent1m(BigDecimal rent1m) {
        this.rent1m = rent1m;
    }

    public BigDecimal getRent3m() {
        return rent3m;
    }

    public void setRent3m(BigDecimal rent3m) {
        this.rent3m = rent3m;
    }

    public BigDecimal getRent12m() {
        return rent12m;
    }

    public void setRent12m(BigDecimal rent12m) {
        this.rent12m = rent12m;
    }

    public BigDecimal getRentYtd() {
        return rentYtd;
    }

    public void setRentYtd(BigDecimal rentYtd) {
        this.rentYtd = rentYtd;
    }

    public BigDecimal getRentInicio() {
        return rentInicio;
    }

    public void setRentInicio(BigDecimal rentInicio) {
        this.rentInicio = rentInicio;
    }

    public BigDecimal getRent12mAnualizada() {
        return rent12mAnualizada;
    }

    public void setRent12mAnualizada(BigDecimal rent12mAnualizada) {
        this.rent12mAnualizada = rent12mAnualizada;
    }

    public BigDecimal getRentYtdAnualizada() {
        return rentYtdAnualizada;
    }

    public void setRentYtdAnualizada(BigDecimal rentYtdAnualizada) {
        this.rentYtdAnualizada = rentYtdAnualizada;
    }

    public BigDecimal getRentInicioAnualizada() {
        return rentInicioAnualizada;
    }

    public void setRentInicioAnualizada(BigDecimal rentInicioAnualizada) {
        this.rentInicioAnualizada = rentInicioAnualizada;
    }
}
