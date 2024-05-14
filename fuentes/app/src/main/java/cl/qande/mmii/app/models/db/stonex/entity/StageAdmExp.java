package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_adm_exp", schema = "stage_stonex")
public class StageAdmExp {
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
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "inv_time_horizon", nullable = false, length = 100)
    private String invTimeHorizon;

    @Size(max = 100)
    @NotNull
    @Column(name = "inv_time_horizon_2", nullable = false, length = 100)
    private String invTimeHorizon2;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_ind", nullable = false, length = 100)
    private String liqNeedInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_dol_pct", nullable = false, length = 100)
    private String liqNeedDolPct;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_timefrm", nullable = false, length = 100)
    private String liqNeedTimefrm;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_dol_pct_2", nullable = false, length = 100)
    private String liqNeedDolPct2;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_timefrm_2", nullable = false, length = 100)
    private String liqNeedTimefrm2;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_dol_pct_3", nullable = false, length = 100)
    private String liqNeedDolPct3;

    @Size(max = 100)
    @NotNull
    @Column(name = "liq_need_timefrm_3", nullable = false, length = 100)
    private String liqNeedTimefrm3;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_tms", nullable = false, length = 100)
    private String addTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "add_source_id", nullable = false, length = 100)
    private String addSourceId;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_tms", nullable = false, length = 100)
    private String changeTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_source_id", nullable = false, length = 100)
    private String changeSourceId;

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

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getInvTimeHorizon() {
        return invTimeHorizon;
    }

    public void setInvTimeHorizon(String invTimeHorizon) {
        this.invTimeHorizon = invTimeHorizon;
    }

    public String getInvTimeHorizon2() {
        return invTimeHorizon2;
    }

    public void setInvTimeHorizon2(String invTimeHorizon2) {
        this.invTimeHorizon2 = invTimeHorizon2;
    }

    public String getLiqNeedInd() {
        return liqNeedInd;
    }

    public void setLiqNeedInd(String liqNeedInd) {
        this.liqNeedInd = liqNeedInd;
    }

    public String getLiqNeedDolPct() {
        return liqNeedDolPct;
    }

    public void setLiqNeedDolPct(String liqNeedDolPct) {
        this.liqNeedDolPct = liqNeedDolPct;
    }

    public String getLiqNeedTimefrm() {
        return liqNeedTimefrm;
    }

    public void setLiqNeedTimefrm(String liqNeedTimefrm) {
        this.liqNeedTimefrm = liqNeedTimefrm;
    }

    public String getLiqNeedDolPct2() {
        return liqNeedDolPct2;
    }

    public void setLiqNeedDolPct2(String liqNeedDolPct2) {
        this.liqNeedDolPct2 = liqNeedDolPct2;
    }

    public String getLiqNeedTimefrm2() {
        return liqNeedTimefrm2;
    }

    public void setLiqNeedTimefrm2(String liqNeedTimefrm2) {
        this.liqNeedTimefrm2 = liqNeedTimefrm2;
    }

    public String getLiqNeedDolPct3() {
        return liqNeedDolPct3;
    }

    public void setLiqNeedDolPct3(String liqNeedDolPct3) {
        this.liqNeedDolPct3 = liqNeedDolPct3;
    }

    public String getLiqNeedTimefrm3() {
        return liqNeedTimefrm3;
    }

    public void setLiqNeedTimefrm3(String liqNeedTimefrm3) {
        this.liqNeedTimefrm3 = liqNeedTimefrm3;
    }

    public String getAddTms() {
        return addTms;
    }

    public void setAddTms(String addTms) {
        this.addTms = addTms;
    }

    public String getAddSourceId() {
        return addSourceId;
    }

    public void setAddSourceId(String addSourceId) {
        this.addSourceId = addSourceId;
    }

    public String getChangeTms() {
        return changeTms;
    }

    public void setChangeTms(String changeTms) {
        this.changeTms = changeTms;
    }

    public String getChangeSourceId() {
        return changeSourceId;
    }

    public void setChangeSourceId(String changeSourceId) {
        this.changeSourceId = changeSourceId;
    }

}