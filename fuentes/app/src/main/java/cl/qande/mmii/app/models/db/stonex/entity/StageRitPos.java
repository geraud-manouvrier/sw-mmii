package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_rit_pos", schema = "stage_stonex")
public class StageRitPos {
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
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "t_or_s", nullable = false, length = 100)
    private String tOrS;

    @Size(max = 100)
    @NotNull
    @Column(name = "file_code", nullable = false, length = 100)
    private String fileCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "curr_seq", nullable = false, length = 100)
    private String currSeq;

    @Size(max = 100)
    @NotNull
    @Column(name = "type_code", nullable = false, length = 100)
    private String typeCode;

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
    @Column(name = "tran_cymd", nullable = false, length = 100)
    private String tranCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "asof_cymd", nullable = false, length = 100)
    private String asofCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "settle_cymd", nullable = false, length = 100)
    private String settleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "group_field", nullable = false, length = 100)
    private String groupField;

    @Size(max = 100)
    @NotNull
    @Column(name = "item", nullable = false, length = 100)
    private String item;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_qty", nullable = false, length = 100)
    private String bgnQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_val", nullable = false, length = 100)
    private String bgnVal;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_gross", nullable = false, length = 100)
    private String bgnGross;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_p_l", nullable = false, length = 100)
    private String bgnPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_int", nullable = false, length = 100)
    private String bgnInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_ur_p_l", nullable = false, length = 100)
    private String bgnUrPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "bgn_accr_int", nullable = false, length = 100)
    private String bgnAccrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_qty", nullable = false, length = 100)
    private String ystQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_val", nullable = false, length = 100)
    private String ystVal;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_gross", nullable = false, length = 100)
    private String ystGross;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_p_l", nullable = false, length = 100)
    private String ystPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_int", nullable = false, length = 100)
    private String ystInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_ur_p_l", nullable = false, length = 100)
    private String ystUrPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "yst_accr_int", nullable = false, length = 100)
    private String ystAccrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_qty", nullable = false, length = 100)
    private String tdyQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_val", nullable = false, length = 100)
    private String tdyVal;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_gross", nullable = false, length = 100)
    private String tdyGross;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_p_l", nullable = false, length = 100)
    private String tdyPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_int", nullable = false, length = 100)
    private String tdyInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_ur_p_l", nullable = false, length = 100)
    private String tdyUrPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "tdy_accr_int", nullable = false, length = 100)
    private String tdyAccrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_qty", nullable = false, length = 100)
    private String curQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_val", nullable = false, length = 100)
    private String curVal;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_gross", nullable = false, length = 100)
    private String curGross;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_p_l", nullable = false, length = 100)
    private String curPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_int", nullable = false, length = 100)
    private String curInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_ur_p_l", nullable = false, length = 100)
    private String curUrPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "cur_accr_int", nullable = false, length = 100)
    private String curAccrInt;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_price", nullable = false, length = 100)
    private String mktPrice;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_value", nullable = false, length = 100)
    private String mktValue;

    @Size(max = 100)
    @NotNull
    @Column(name = "last_active_cymd", nullable = false, length = 100)
    private String lastActiveCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_system", nullable = false, length = 100)
    private String subSystem;

    @Size(max = 100)
    @NotNull
    @Column(name = "beg_ur_p_l", nullable = false, length = 100)
    private String begUrPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "paydown_p_l", nullable = false, length = 100)
    private String paydownPL;

    @Size(max = 100)
    @NotNull
    @Column(name = "paydown", nullable = false, length = 100)
    private String paydown;

    @Size(max = 100)
    @NotNull
    @Column(name = "basis_pt_total", nullable = false, length = 100)
    private String basisPtTotal;

    @Size(max = 100)
    @NotNull
    @Column(name = "avg_days", nullable = false, length = 100)
    private String avgDays;

    @Size(max = 100)
    @NotNull
    @Column(name = "sort_group", nullable = false, length = 100)
    private String sortGroup;

    @Size(max = 100)
    @NotNull
    @Column(name = "sort_item", nullable = false, length = 100)
    private String sortItem;

    @Size(max = 100)
    @NotNull
    @Column(name = "maturity_cymd", nullable = false, length = 100)
    private String maturityCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "orig_mkt_price", nullable = false, length = 100)
    private String origMktPrice;

    @Size(max = 100)
    @NotNull
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "mark_prof_loss", nullable = false, length = 100)
    private String markProfLoss;

    @Size(max = 100)
    @NotNull
    @Column(name = "oldest_cymd", nullable = false, length = 100)
    private String oldestCymd;

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

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getTOrS() {
        return tOrS;
    }

    public void setTOrS(String tOrS) {
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