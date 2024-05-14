package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class AdmExpCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "inv_time_horizon")private String invTimeHorizon;
    @CsvBindByName(column = "inv_time_horizon_2")private String invTimeHorizon2;
    @CsvBindByName(column = "liq_need_ind")private String liqNeedInd;
    @CsvBindByName(column = "liq_need_dol_pct")private String liqNeedDolPct;
    @CsvBindByName(column = "liq_need_timefrm")private String liqNeedTimefrm;
    @CsvBindByName(column = "liq_need_dol_pct_2")private String liqNeedDolPct2;
    @CsvBindByName(column = "liq_need_timefrm_2")private String liqNeedTimefrm2;
    @CsvBindByName(column = "liq_need_dol_pct_3")private String liqNeedDolPct3;
    @CsvBindByName(column = "liq_need_timefrm_3")private String liqNeedTimefrm3;
    @CsvBindByName(column = "add_tms")private String addTms;
    @CsvBindByName(column = "add_source_id")private String addSourceId;
    @CsvBindByName(column = "change_tms")private String changeTms;
    @CsvBindByName(column = "change_source_id")private String changeSourceId;

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
