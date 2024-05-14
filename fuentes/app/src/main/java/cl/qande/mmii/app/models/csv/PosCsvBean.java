package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class PosCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "control_no")private String controlNo;
    @CsvBindByName(column = "seq_no")private String seqNo;
    @CsvBindByName(column = "ioex")private String ioex;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "currency_sequence")private String currencySequence;
    @CsvBindByName(column = "trade_cymd")private String tradeCymd;
    @CsvBindByName(column = "settle_cymd")private String settleCymd;
    @CsvBindByName(column = "asof_cymd")private String asofCymd;
    @CsvBindByName(column = "sum_sec_type")private String sumSecType;
    @CsvBindByName(column = "source")private String source;
    @CsvBindByName(column = "purchase_prx")private String purchasePrx;
    @CsvBindByName(column = "cash_amt")private String cashAmt;
    @CsvBindByName(column = "chk_today_amt")private String chkTodayAmt;
    @CsvBindByName(column = "quantity")private String quantity;
    @CsvBindByName(column = "seg_qty")private String segQty;
    @CsvBindByName(column = "leg_qty")private String legQty;
    @CsvBindByName(column = "skf_qty")private String skfQty;
    @CsvBindByName(column = "skc_qty")private String skcQty;
    @CsvBindByName(column = "trf_qty")private String trfQty;
    @CsvBindByName(column = "pboo_qty")private String pbooQty;
    @CsvBindByName(column = "dtoo_qty")private String dtooQty;
    @CsvBindByName(column = "doc_qty")private String docQty;
    @CsvBindByName(column = "trf_cymd")private String trfCymd;
    @CsvBindByName(column = "buy_or_sell")private String buyOrSell;
    @CsvBindByName(column = "market_prx")private String marketPrx;
    @CsvBindByName(column = "too_qty")private String tooQty;
    @CsvBindByName(column = "mkt_value_amt")private String mktValueAmt;
    @CsvBindByName(column = "usd_equivalent")private String usdEquivalent;
    @CsvBindByName(column = "seg_reinv_qty")private String segReinvQty;
    @CsvBindByName(column = "adjust_sw")private String adjustSw;
    @CsvBindByName(column = "reinvest_sw")private String reinvestSw;
    @CsvBindByName(column = "free_credit_sw")private String freeCreditSw;
    @CsvBindByName(column = "usd_mkt_prx")private String usdMktPrx;

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
