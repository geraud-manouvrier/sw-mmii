package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_mmf_bal", schema = "stage_stonex")
public class StageMmfBal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "process_stamp", nullable = false, length = 100)
    private String processStamp;

    @Size(max = 100)
    @NotNull
    @Column(name = "ba_reccode", nullable = false, length = 100)
    private String baReccode;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 100)
    private String acctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_no", nullable = false, length = 100)
    private String secNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "balance", nullable = false, length = 100)
    private String balance;

    @Size(max = 100)
    @NotNull
    @Column(name = "trades", nullable = false, length = 100)
    private String trades;

    @Size(max = 100)
    @NotNull
    @Column(name = "accrue_div", nullable = false, length = 100)
    private String accrueDiv;

    @Size(max = 100)
    @NotNull
    @Column(name = "accrue_paid", nullable = false, length = 100)
    private String accruePaid;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_active_cymd", nullable = false, length = 100)
    private String lastActiveCymd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessStamp() {
        return processStamp;
    }

    public void setProcessStamp(String processStamp) {
        this.processStamp = processStamp;
    }

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