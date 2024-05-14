package cl.qande.mmii.app.models.db.stonex.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stage_csh", schema = "stage_stonex")
public class StageCsh {
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
    @Column(name = "sub_no", nullable = false, length = 100)
    private String subNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_no", nullable = false, length = 100)
    private String acctNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_class", nullable = false, length = 100)
    private String acctClass;

    @Size(max = 100)
    @NotNull
    @Column(name = "acct_type", nullable = false, length = 100)
    private String acctType;

    @Size(max = 100)
    @NotNull
    @Column(name = "rep", nullable = false, length = 100)
    private String rep;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_no", nullable = false, length = 100)
    private String secNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "cusip", nullable = false, length = 100)
    private String cusip;

    @Size(max = 100)
    @NotNull
    @Column(name = "sec_type", nullable = false, length = 100)
    private String secType;

    @Size(max = 100)
    @NotNull
    @Column(name = "class", nullable = false, length = 100)
    private String classField;

    @Size(max = 100)
    @NotNull
    @Column(name = "symbol", nullable = false, length = 100)
    private String symbol;

    @Size(max = 100)
    @NotNull
    @Column(name = "mgn_code", nullable = false, length = 100)
    private String mgnCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "std_inst", nullable = false, length = 100)
    private String stdInst;

    @Size(max = 100)
    @NotNull
    @Column(name = "trade_cymd", nullable = false, length = 100)
    private String tradeCymd;

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
    @Column(name = "origin", nullable = false, length = 100)
    private String origin;

    @Size(max = 100)
    @NotNull
    @Column(name = "tran_id", nullable = false, length = 100)
    private String tranId;

    @Size(max = 100)
    @NotNull
    @Column(name = "control_no", nullable = false, length = 100)
    private String controlNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "big_qty", nullable = false, length = 100)
    private String bigQty;

    @Size(max = 100)
    @NotNull
    @Column(name = "source", nullable = false, length = 100)
    private String source;

    @Size(max = 100)
    @NotNull
    @Column(name = "purch_or_sale", nullable = false, length = 100)
    private String purchOrSale;

    @Size(max = 100)
    @NotNull
    @Column(name = "big_exch", nullable = false, length = 100)
    private String bigExch;

    @Size(max = 100)
    @NotNull
    @Column(name = "net_amt", nullable = false, length = 100)
    private String netAmt;

    @Size(max = 100)
    @NotNull
    @Column(name = "offset_acct", nullable = false, length = 100)
    private String offsetAcct;

    @Size(max = 100)
    @NotNull
    @Column(name = "offset_type", nullable = false, length = 100)
    private String offsetType;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_credit", nullable = false, length = 100)
    private String noCredit;

    @Size(max = 100)
    @NotNull
    @Column(name = "generic_user_field", nullable = false, length = 100)
    private String genericUserField;

    @Size(max = 100)
    @NotNull
    @Column(name = "tag_no", nullable = false, length = 100)
    private String tagNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "curr_seq", nullable = false, length = 100)
    private String currSeq;

    @Size(max = 100)
    @NotNull
    @Column(name = "broker_no", nullable = false, length = 100)
    private String brokerNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "noncustomer_sw", nullable = false, length = 100)
    private String noncustomerSw;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc1", nullable = false, length = 100)
    private String desc1;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc2", nullable = false, length = 100)
    private String desc2;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc3", nullable = false, length = 100)
    private String desc3;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc4", nullable = false, length = 100)
    private String desc4;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc5", nullable = false, length = 100)
    private String desc5;

    @Size(max = 100)
    @NotNull
    @Column(name = "desc6", nullable = false, length = 100)
    private String desc6;

    @Size(max = 100)
    @NotNull
    @Column(name = "mlp_code", nullable = false, length = 100)
    private String mlpCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "div_reinv", nullable = false, length = 100)
    private String divReinv;

    @Size(max = 100)
    @NotNull
    @Column(name = "bond_type", nullable = false, length = 100)
    private String bondType;

    @Size(max = 100)
    @NotNull
    @Column(name = "tax_id", nullable = false, length = 100)
    private String taxId;

    @Size(max = 100)
    @NotNull
    @Column(name = "program_no", nullable = false, length = 100)
    private String programNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "payment_curr_type", nullable = false, length = 100)
    private String paymentCurrType;

    @Size(max = 100)
    @NotNull
    @Column(name = "country_code", nullable = false, length = 100)
    private String countryCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "off_country_code", nullable = false, length = 100)
    private String offCountryCode;

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
    @Column(name = "rec_type", nullable = false, length = 100)
    private String recType;

    @Size(max = 100)
    @NotNull
    @Column(name = "batch_job", nullable = false, length = 100)
    private String batchJob;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_tms", nullable = false, length = 100)
    private String changeTms;

    @Size(max = 100)
    @NotNull
    @Column(name = "branch", nullable = false, length = 100)
    private String branch;

    @Size(max = 100)
    @NotNull
    @Column(name = "change_who_code", nullable = false, length = 100)
    private String changeWhoCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "csi_override", nullable = false, length = 100)
    private String csiOverride;

    @Size(max = 100)
    @NotNull
    @Column(name = "item_no", nullable = false, length = 100)
    private String itemNo;

    @Size(max = 100)
    @NotNull
    @Column(name = "trailer_rid", nullable = false, length = 100)
    private String trailerRid;

    @Size(max = 100)
    @NotNull
    @Column(name = "qty_paid_on", nullable = false, length = 100)
    private String qtyPaidOn;

    @Size(max = 100)
    @NotNull
    @Column(name = "cripple_ind", nullable = false, length = 100)
    private String crippleInd;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_rid", nullable = false, length = 100)
    private String internalRid;

    @Size(max = 100)
    @NotNull
    @Column(name = "payee_ben_code", nullable = false, length = 100)
    private String payeeBenCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "disburse_code", nullable = false, length = 100)
    private String disburseCode;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_uid", nullable = false, length = 100)
    private String internalUid;

    @Size(max = 100)
    @NotNull
    @Column(name = "internal_oid", nullable = false, length = 100)
    private String internalOid;

    @Size(max = 100)
    @NotNull
    @Column(name = "state_code", nullable = false, length = 100)
    private String stateCode;

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

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(String acctClass) {
        this.acctClass = acctClass;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getSecNo() {
        return secNo;
    }

    public void setSecNo(String secNo) {
        this.secNo = secNo;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMgnCode() {
        return mgnCode;
    }

    public void setMgnCode(String mgnCode) {
        this.mgnCode = mgnCode;
    }

    public String getStdInst() {
        return stdInst;
    }

    public void setStdInst(String stdInst) {
        this.stdInst = stdInst;
    }

    public String getTradeCymd() {
        return tradeCymd;
    }

    public void setTradeCymd(String tradeCymd) {
        this.tradeCymd = tradeCymd;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }

    public String getBigQty() {
        return bigQty;
    }

    public void setBigQty(String bigQty) {
        this.bigQty = bigQty;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPurchOrSale() {
        return purchOrSale;
    }

    public void setPurchOrSale(String purchOrSale) {
        this.purchOrSale = purchOrSale;
    }

    public String getBigExch() {
        return bigExch;
    }

    public void setBigExch(String bigExch) {
        this.bigExch = bigExch;
    }

    public String getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(String netAmt) {
        this.netAmt = netAmt;
    }

    public String getOffsetAcct() {
        return offsetAcct;
    }

    public void setOffsetAcct(String offsetAcct) {
        this.offsetAcct = offsetAcct;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }

    public String getNoCredit() {
        return noCredit;
    }

    public void setNoCredit(String noCredit) {
        this.noCredit = noCredit;
    }

    public String getGenericUserField() {
        return genericUserField;
    }

    public void setGenericUserField(String genericUserField) {
        this.genericUserField = genericUserField;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getCurrSeq() {
        return currSeq;
    }

    public void setCurrSeq(String currSeq) {
        this.currSeq = currSeq;
    }

    public String getBrokerNo() {
        return brokerNo;
    }

    public void setBrokerNo(String brokerNo) {
        this.brokerNo = brokerNo;
    }

    public String getNoncustomerSw() {
        return noncustomerSw;
    }

    public void setNoncustomerSw(String noncustomerSw) {
        this.noncustomerSw = noncustomerSw;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4;
    }

    public String getDesc5() {
        return desc5;
    }

    public void setDesc5(String desc5) {
        this.desc5 = desc5;
    }

    public String getDesc6() {
        return desc6;
    }

    public void setDesc6(String desc6) {
        this.desc6 = desc6;
    }

    public String getMlpCode() {
        return mlpCode;
    }

    public void setMlpCode(String mlpCode) {
        this.mlpCode = mlpCode;
    }

    public String getDivReinv() {
        return divReinv;
    }

    public void setDivReinv(String divReinv) {
        this.divReinv = divReinv;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getProgramNo() {
        return programNo;
    }

    public void setProgramNo(String programNo) {
        this.programNo = programNo;
    }

    public String getPaymentCurrType() {
        return paymentCurrType;
    }

    public void setPaymentCurrType(String paymentCurrType) {
        this.paymentCurrType = paymentCurrType;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOffCountryCode() {
        return offCountryCode;
    }

    public void setOffCountryCode(String offCountryCode) {
        this.offCountryCode = offCountryCode;
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

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public String getBatchJob() {
        return batchJob;
    }

    public void setBatchJob(String batchJob) {
        this.batchJob = batchJob;
    }

    public String getChangeTms() {
        return changeTms;
    }

    public void setChangeTms(String changeTms) {
        this.changeTms = changeTms;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getChangeWhoCode() {
        return changeWhoCode;
    }

    public void setChangeWhoCode(String changeWhoCode) {
        this.changeWhoCode = changeWhoCode;
    }

    public String getCsiOverride() {
        return csiOverride;
    }

    public void setCsiOverride(String csiOverride) {
        this.csiOverride = csiOverride;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getTrailerRid() {
        return trailerRid;
    }

    public void setTrailerRid(String trailerRid) {
        this.trailerRid = trailerRid;
    }

    public String getQtyPaidOn() {
        return qtyPaidOn;
    }

    public void setQtyPaidOn(String qtyPaidOn) {
        this.qtyPaidOn = qtyPaidOn;
    }

    public String getCrippleInd() {
        return crippleInd;
    }

    public void setCrippleInd(String crippleInd) {
        this.crippleInd = crippleInd;
    }

    public String getInternalRid() {
        return internalRid;
    }

    public void setInternalRid(String internalRid) {
        this.internalRid = internalRid;
    }

    public String getPayeeBenCode() {
        return payeeBenCode;
    }

    public void setPayeeBenCode(String payeeBenCode) {
        this.payeeBenCode = payeeBenCode;
    }

    public String getDisburseCode() {
        return disburseCode;
    }

    public void setDisburseCode(String disburseCode) {
        this.disburseCode = disburseCode;
    }

    public String getInternalUid() {
        return internalUid;
    }

    public void setInternalUid(String internalUid) {
        this.internalUid = internalUid;
    }

    public String getInternalOid() {
        return internalOid;
    }

    public void setInternalOid(String internalOid) {
        this.internalOid = internalOid;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

}