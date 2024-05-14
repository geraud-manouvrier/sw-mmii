package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class MmfBalCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "balance")private String balance;
    @CsvBindByName(column = "trades")private String trades;
    @CsvBindByName(column = "accrue_div")private String accrueDiv;
    @CsvBindByName(column = "accrue_paid")private String accruePaid;
    @CsvBindByName(column = "last_active_cymd")private String lastActiveCymd;

    public String getBaReccode() {
        return baReccode;
    }

    public void setBaReccode(String baReccode) {
        this.baReccode = baReccode;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTrades() {
        return trades;
    }

    public void setTrades(String trades) {
        this.trades = trades;
    }

    public String getAccrueDiv() {
        return accrueDiv;
    }

    public void setAccrueDiv(String accrueDiv) {
        this.accrueDiv = accrueDiv;
    }

    public String getAccruePaid() {
        return accruePaid;
    }

    public void setAccruePaid(String accruePaid) {
        this.accruePaid = accruePaid;
    }

    public String getLastActiveCymd() {
        return lastActiveCymd;
    }

    public void setLastActiveCymd(String lastActiveCymd) {
        this.lastActiveCymd = lastActiveCymd;
    }
}
