package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class RitPosCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "t_or_s")private String tOrS;
    @CsvBindByName(column = "file_code")private String fileCode;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "curr_seq")private String currSeq;
    @CsvBindByName(column = "type_code")private String typeCode;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "tran_cymd")private String tranCymd;
    @CsvBindByName(column = "asof_cymd")private String asofCymd;
    @CsvBindByName(column = "settle_cymd")private String settleCymd;
    @CsvBindByName(column = "group")private String groupField;
    @CsvBindByName(column = "item")private String item;
    @CsvBindByName(column = "bgn_qty")private String bgnQty;
    @CsvBindByName(column = "bgn_val")private String bgnVal;
    @CsvBindByName(column = "bgn_gross")private String bgnGross;
    @CsvBindByName(column = "bgn_p_l")private String bgnPL;
    @CsvBindByName(column = "bgn_int")private String bgnInt;
    @CsvBindByName(column = "bgn_ur_p_l")private String bgnUrPL;
    @CsvBindByName(column = "bgn_accr_int")private String bgnAccrInt;
    @CsvBindByName(column = "yst_qty")private String ystQty;
    @CsvBindByName(column = "yst_val")private String ystVal;
    @CsvBindByName(column = "yst_gross")private String ystGross;
    @CsvBindByName(column = "yst_p_l")private String ystPL;
    @CsvBindByName(column = "yst_int")private String ystInt;
    @CsvBindByName(column = "yst_ur_p_l")private String ystUrPL;
    @CsvBindByName(column = "yst_accr_int")private String ystAccrInt;
    @CsvBindByName(column = "tdy_qty")private String tdyQty;
    @CsvBindByName(column = "tdy_val")private String tdyVal;
    @CsvBindByName(column = "tdy_gross")private String tdyGross;
    @CsvBindByName(column = "tdy_p_l")private String tdyPL;
    @CsvBindByName(column = "tdy_int")private String tdyInt;
    @CsvBindByName(column = "tdy_ur_p_l")private String tdyUrPL;
    @CsvBindByName(column = "tdy_accr_int")private String tdyAccrInt;
    @CsvBindByName(column = "cur_qty")private String curQty;
    @CsvBindByName(column = "cur_val")private String curVal;
    @CsvBindByName(column = "cur_gross")private String curGross;
    @CsvBindByName(column = "cur_p_l")private String curPL;
    @CsvBindByName(column = "cur_int")private String curInt;
    @CsvBindByName(column = "cur_ur_p_l")private String curUrPL;
    @CsvBindByName(column = "cur_accr_int")private String curAccrInt;
    @CsvBindByName(column = "mkt_price")private String mktPrice;
    @CsvBindByName(column = "mkt_value")private String mktValue;
    @CsvBindByName(column = "last_active_cymd")private String lastActiveCymd;
    @CsvBindByName(column = "sub_system")private String subSystem;
    @CsvBindByName(column = "beg_ur_p_l")private String begUrPL;
    @CsvBindByName(column = "paydown_p_l")private String paydownPL;
    @CsvBindByName(column = "paydown")private String paydown;
    @CsvBindByName(column = "basis_pt_total")private String basisPtTotal;
    @CsvBindByName(column = "avg_days")private String avgDays;
    @CsvBindByName(column = "sort_group")private String sortGroup;
    @CsvBindByName(column = "sort_item")private String sortItem;
    @CsvBindByName(column = "maturity_cymd")private String maturityCymd;
    @CsvBindByName(column = "orig_mkt_price")private String origMktPrice;
    @CsvBindByName(column = "cusip")private String cusip;
    @CsvBindByName(column = "symbol")private String symbol;
    @CsvBindByName(column = "mark_prof_loss")private String markProfLoss;
    @CsvBindByName(column = "oldest_cymd")private String oldestCymd;

    public String getBaReccode() {
        return baReccode;
    }

    public void setBaReccode(String baReccode) {
        this.baReccode = baReccode;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String gettOrS() {
        return tOrS;
    }

    public void settOrS(String tOrS) {
        this.tOrS = tOrS;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getCurrSeq() {
        return currSeq;
    }

    public void setCurrSeq(String currSeq) {
        this.currSeq = currSeq;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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

    public String getTranCymd() {
        return tranCymd;
    }

    public void setTranCymd(String tranCymd) {
        this.tranCymd = tranCymd;
    }

    public String getAsofCymd() {
        return asofCymd;
    }

    public void setAsofCymd(String asofCymd) {
        this.asofCymd = asofCymd;
    }

    public String getSettleCymd() {
        return settleCymd;
    }

    public void setSettleCymd(String settleCymd) {
        this.settleCymd = settleCymd;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBgnQty() {
        return bgnQty;
    }

    public void setBgnQty(String bgnQty) {
        this.bgnQty = bgnQty;
    }

    public String getBgnVal() {
        return bgnVal;
    }

    public void setBgnVal(String bgnVal) {
        this.bgnVal = bgnVal;
    }

    public String getBgnGross() {
        return bgnGross;
    }

    public void setBgnGross(String bgnGross) {
        this.bgnGross = bgnGross;
    }

    public String getBgnPL() {
        return bgnPL;
    }

    public void setBgnPL(String bgnPL) {
        this.bgnPL = bgnPL;
    }

    public String getBgnInt() {
        return bgnInt;
    }

    public void setBgnInt(String bgnInt) {
        this.bgnInt = bgnInt;
    }

    public String getBgnUrPL() {
        return bgnUrPL;
    }

    public void setBgnUrPL(String bgnUrPL) {
        this.bgnUrPL = bgnUrPL;
    }

    public String getBgnAccrInt() {
        return bgnAccrInt;
    }

    public void setBgnAccrInt(String bgnAccrInt) {
        this.bgnAccrInt = bgnAccrInt;
    }

    public String getYstQty() {
        return ystQty;
    }

    public void setYstQty(String ystQty) {
        this.ystQty = ystQty;
    }

    public String getYstVal() {
        return ystVal;
    }

    public void setYstVal(String ystVal) {
        this.ystVal = ystVal;
    }

    public String getYstGross() {
        return ystGross;
    }

    public void setYstGross(String ystGross) {
        this.ystGross = ystGross;
    }

    public String getYstPL() {
        return ystPL;
    }

    public void setYstPL(String ystPL) {
        this.ystPL = ystPL;
    }

    public String getYstInt() {
        return ystInt;
    }

    public void setYstInt(String ystInt) {
        this.ystInt = ystInt;
    }

    public String getYstUrPL() {
        return ystUrPL;
    }

    public void setYstUrPL(String ystUrPL) {
        this.ystUrPL = ystUrPL;
    }

    public String getYstAccrInt() {
        return ystAccrInt;
    }

    public void setYstAccrInt(String ystAccrInt) {
        this.ystAccrInt = ystAccrInt;
    }

    public String getTdyQty() {
        return tdyQty;
    }

    public void setTdyQty(String tdyQty) {
        this.tdyQty = tdyQty;
    }

    public String getTdyVal() {
        return tdyVal;
    }

    public void setTdyVal(String tdyVal) {
        this.tdyVal = tdyVal;
    }

    public String getTdyGross() {
        return tdyGross;
    }

    public void setTdyGross(String tdyGross) {
        this.tdyGross = tdyGross;
    }

    public String getTdyPL() {
        return tdyPL;
    }

    public void setTdyPL(String tdyPL) {
        this.tdyPL = tdyPL;
    }

    public String getTdyInt() {
        return tdyInt;
    }

    public void setTdyInt(String tdyInt) {
        this.tdyInt = tdyInt;
    }

    public String getTdyUrPL() {
        return tdyUrPL;
    }

    public void setTdyUrPL(String tdyUrPL) {
        this.tdyUrPL = tdyUrPL;
    }

    public String getTdyAccrInt() {
        return tdyAccrInt;
    }

    public void setTdyAccrInt(String tdyAccrInt) {
        this.tdyAccrInt = tdyAccrInt;
    }

    public String getCurQty() {
        return curQty;
    }

    public void setCurQty(String curQty) {
        this.curQty = curQty;
    }

    public String getCurVal() {
        return curVal;
    }

    public void setCurVal(String curVal) {
        this.curVal = curVal;
    }

    public String getCurGross() {
        return curGross;
    }

    public void setCurGross(String curGross) {
        this.curGross = curGross;
    }

    public String getCurPL() {
        return curPL;
    }

    public void setCurPL(String curPL) {
        this.curPL = curPL;
    }

    public String getCurInt() {
        return curInt;
    }

    public void setCurInt(String curInt) {
        this.curInt = curInt;
    }

    public String getCurUrPL() {
        return curUrPL;
    }

    public void setCurUrPL(String curUrPL) {
        this.curUrPL = curUrPL;
    }

    public String getCurAccrInt() {
        return curAccrInt;
    }

    public void setCurAccrInt(String curAccrInt) {
        this.curAccrInt = curAccrInt;
    }

    public String getMktPrice() {
        return mktPrice;
    }

    public void setMktPrice(String mktPrice) {
        this.mktPrice = mktPrice;
    }

    public String getMktValue() {
        return mktValue;
    }

    public void setMktValue(String mktValue) {
        this.mktValue = mktValue;
    }

    public String getLastActiveCymd() {
        return lastActiveCymd;
    }

    public void setLastActiveCymd(String lastActiveCymd) {
        this.lastActiveCymd = lastActiveCymd;
    }

    public String getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public String getBegUrPL() {
        return begUrPL;
    }

    public void setBegUrPL(String begUrPL) {
        this.begUrPL = begUrPL;
    }

    public String getPaydownPL() {
        return paydownPL;
    }

    public void setPaydownPL(String paydownPL) {
        this.paydownPL = paydownPL;
    }

    public String getPaydown() {
        return paydown;
    }

    public void setPaydown(String paydown) {
        this.paydown = paydown;
    }

    public String getBasisPtTotal() {
        return basisPtTotal;
    }

    public void setBasisPtTotal(String basisPtTotal) {
        this.basisPtTotal = basisPtTotal;
    }

    public String getAvgDays() {
        return avgDays;
    }

    public void setAvgDays(String avgDays) {
        this.avgDays = avgDays;
    }

    public String getSortGroup() {
        return sortGroup;
    }

    public void setSortGroup(String sortGroup) {
        this.sortGroup = sortGroup;
    }

    public String getSortItem() {
        return sortItem;
    }

    public void setSortItem(String sortItem) {
        this.sortItem = sortItem;
    }

    public String getMaturityCymd() {
        return maturityCymd;
    }

    public void setMaturityCymd(String maturityCymd) {
        this.maturityCymd = maturityCymd;
    }

    public String getOrigMktPrice() {
        return origMktPrice;
    }

    public void setOrigMktPrice(String origMktPrice) {
        this.origMktPrice = origMktPrice;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMarkProfLoss() {
        return markProfLoss;
    }

    public void setMarkProfLoss(String markProfLoss) {
        this.markProfLoss = markProfLoss;
    }

    public String getOldestCymd() {
        return oldestCymd;
    }

    public void setOldestCymd(String oldestCymd) {
        this.oldestCymd = oldestCymd;
    }
}
