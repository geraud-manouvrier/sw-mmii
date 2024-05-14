package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_pos", schema = "stage_stonex")
public class StagePos {
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
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

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
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_no", nullable = false, length = 100)
    private String controlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "seq_no", nullable = false, length = 100)
    private String seqNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "ioex", nullable = false, length = 100)
    private String ioex;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "firm_no", nullable = false, length = 100)
    private String firmNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "currency_sequence", nullable = false, length = 100)
    private String currencySequence;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_cymd", nullable = false, length = 100)
    private String tradeCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "settle_cymd", nullable = false, length = 100)
    private String settleCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "asof_cymd", nullable = false, length = 100)
    private String asofCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "sum_sec_type", nullable = false, length = 100)
    private String sumSecType;

    @Size(max = 100)
    @NotNull
    @Column(name = "source", nullable = false, length = 100)
    private String source;

    @Size(max = 100)
    @NotNull
    @Column(name = "purchase_prx", nullable = false, length = 100)
    private String purchasePrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "cash_amt", nullable = false, length = 100)
    private String cashAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "chk_today_amt", nullable = false, length = 100)
    private String chkTodayAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "quantity", nullable = false, length = 100)
    private String quantity;

    @Size(max = 100)
    @NotNull
    @Column(name = "seg_qty", nullable = false, length = 100)
    private String segQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "leg_qty", nullable = false, length = 100)
    private String legQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "skf_qty", nullable = false, length = 100)
    private String skfQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "skc_qty", nullable = false, length = 100)
    private String skcQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "trf_qty", nullable = false, length = 100)
    private String trfQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "pboo_qty", nullable = false, length = 100)
    private String pbooQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "dtoo_qty", nullable = false, length = 100)
    private String dtooQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "doc_qty", nullable = false, length = 100)
    private String docQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "trf_cymd", nullable = false, length = 100)
    private String trfCymd;

    @Size(max = 100)
    @NotNull
    @Column(name = "buy_or_sell", nullable = false, length = 100)
    private String buyOrSell;

    @Size(max = 100)
    @NotNull
    @Column(name = "market_prx", nullable = false, length = 100)
    private String marketPrx;

    @Size(max = 100)
    @NotNull
    @Column(name = "too_qty", nullable = false, length = 100)
    private String tooQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "mkt_value_amt", nullable = false, length = 100)
    private String mktValueAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "usd_equivalent", nullable = false, length = 100)
    private String usdEquivalent;

    @Size(max = 100)
    @NotNull
    @Column(name = "seg_reinv_qty", nullable = false, length = 100)
    private String segReinvQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "adjust_sw", nullable = false, length = 100)
    private String adjustSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "reinvest_sw", nullable = false, length = 100)
    private String reinvestSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "free_credit_sw", nullable = false, length = 100)
    private String freeCreditSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "usd_mkt_prx", nullable = false, length = 100)
    private String usdMktPrx;

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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
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

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getIoex() {
        return ioex;
    }

    public void setIoex(String ioex) {
        this.ioex = ioex;
    }

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(String firmNo) {
        this.firmNo = firmNo;
    }

    public String getCurrencySequence() {
        return currencySequence;
    }

    public void setCurrencySequence(String currencySequence) {
        this.currencySequence = currencySequence;
    }

    public String getTradeCymd() {
        return tradeCymd;
    }

    public void setTradeCymd(String tradeCymd) {
        this.tradeCymd = tradeCymd;
    }

    public String getSettleCymd() {
        return settleCymd;
    }

    public void setSettleCymd(String settleCymd) {
        this.settleCymd = settleCymd;
    }

    public String getAsofCymd() {
        return asofCymd;
    }

    public void setAsofCymd(String asofCymd) {
        this.asofCymd = asofCymd;
    }

    public String getSumSecType() {
        return sumSecType;
    }

    public void setSumSecType(String sumSecType) {
        this.sumSecType = sumSecType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPurchasePrx() {
        return purchasePrx;
    }

    public void setPurchasePrx(String purchasePrx) {
        this.purchasePrx = purchasePrx;
    }

    public String getCashAmt() {
        return cashAmt;
    }

    public void setCashAmt(String cashAmt) {
        this.cashAmt = cashAmt;
    }

    public String getChkTodayAmt() {
        return chkTodayAmt;
    }

    public void setChkTodayAmt(String chkTodayAmt) {
        this.chkTodayAmt = chkTodayAmt;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSegQty() {
        return segQty;
    }

    public void setSegQty(String segQty) {
        this.segQty = segQty;
    }

    public String getLegQty() {
        return legQty;
    }

    public void setLegQty(String legQty) {
        this.legQty = legQty;
    }

    public String getSkfQty() {
        return skfQty;
    }

    public void setSkfQty(String skfQty) {
        this.skfQty = skfQty;
    }

    public String getSkcQty() {
        return skcQty;
    }

    public void setSkcQty(String skcQty) {
        this.skcQty = skcQty;
    }

    public String getTrfQty() {
        return trfQty;
    }

    public void setTrfQty(String trfQty) {
        this.trfQty = trfQty;
    }

    public String getPbooQty() {
        return pbooQty;
    }

    public void setPbooQty(String pbooQty) {
        this.pbooQty = pbooQty;
    }

    public String getDtooQty() {
        return dtooQty;
    }

    public void setDtooQty(String dtooQty) {
        this.dtooQty = dtooQty;
    }

    public String getDocQty() {
        return docQty;
    }

    public void setDocQty(String docQty) {
        this.docQty = docQty;
    }

    public String getTrfCymd() {
        return trfCymd;
    }

    public void setTrfCymd(String trfCymd) {
        this.trfCymd = trfCymd;
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    public String getMarketPrx() {
        return marketPrx;
    }

    public void setMarketPrx(String marketPrx) {
        this.marketPrx = marketPrx;
    }

    public String getTooQty() {
        return tooQty;
    }

    public void setTooQty(String tooQty) {
        this.tooQty = tooQty;
    }

    public String getMktValueAmt() {
        return mktValueAmt;
    }

    public void setMktValueAmt(String mktValueAmt) {
        this.mktValueAmt = mktValueAmt;
    }

    public String getUsdEquivalent() {
        return usdEquivalent;
    }

    public void setUsdEquivalent(String usdEquivalent) {
        this.usdEquivalent = usdEquivalent;
    }

    public String getSegReinvQty() {
        return segReinvQty;
    }

    public void setSegReinvQty(String segReinvQty) {
        this.segReinvQty = segReinvQty;
    }

    public String getAdjustSw() {
        return adjustSw;
    }

    public void setAdjustSw(String adjustSw) {
        this.adjustSw = adjustSw;
    }

    public String getReinvestSw() {
        return reinvestSw;
    }

    public void setReinvestSw(String reinvestSw) {
        this.reinvestSw = reinvestSw;
    }

    public String getFreeCreditSw() {
        return freeCreditSw;
    }

    public void setFreeCreditSw(String freeCreditSw) {
        this.freeCreditSw = freeCreditSw;
    }

    public String getUsdMktPrx() {
        return usdMktPrx;
    }

    public void setUsdMktPrx(String usdMktPrx) {
        this.usdMktPrx = usdMktPrx;
    }

}