package cl.qande.mmii.app.models.csv;

import cl.qande.mmii.app.util.helper.CsvBean;
import com.opencsv.bean.CsvBindByName;

public class RadCsvBean extends CsvBean {
    @CsvBindByName(column = "ba_reccode")private String baReccode;
    @CsvBindByName(column = "firm_no")private String firmNo;
    @CsvBindByName(column = "sub_no")private String subNo;
    @CsvBindByName(column = "acct_no")private String acctNo;
    @CsvBindByName(column = "acct_class")private String acctClass;
    @CsvBindByName(column = "acct_type")private String acctType;
    @CsvBindByName(column = "rep")private String rep;
    @CsvBindByName(column = "sec_no")private String secNo;
    @CsvBindByName(column = "cusip")private String cusip;
    @CsvBindByName(column = "sec_type")private String secType;
    @CsvBindByName(column = "class")private String classField;
    @CsvBindByName(column = "symbol")private String symbol;
    @CsvBindByName(column = "mgn_code")private String mgnCode;
    @CsvBindByName(column = "std_inst")private String stdInst;
    @CsvBindByName(column = "trade_cymd")private String tradeCymd;
    @CsvBindByName(column = "asof_cymd")private String asofCymd;
    @CsvBindByName(column = "settle_cymd")private String settleCymd;
    @CsvBindByName(column = "origin")private String origin;
    @CsvBindByName(column = "tran_id")private String tranId;
    @CsvBindByName(column = "control_no")private String controlNo;
    @CsvBindByName(column = "big_qty")private String bigQty;
    @CsvBindByName(column = "big_prx")private String bigPrx;
    @CsvBindByName(column = "purch_or_sale")private String purchOrSale;
    @CsvBindByName(column = "big_exch")private String bigExch;
    @CsvBindByName(column = "net_amt")private String netAmt;
    @CsvBindByName(column = "offset_acct")private String offsetAcct;
    @CsvBindByName(column = "offset_type")private String offsetType;
    @CsvBindByName(column = "no_credit")private String noCredit;
    @CsvBindByName(column = "generic_user_field")private String genericUserField;
    @CsvBindByName(column = "tag_no")private String tagNo;
    @CsvBindByName(column = "foreign_curr")private String foreignCurr;
    @CsvBindByName(column = "broker_no")private String brokerNo;
    @CsvBindByName(column = "noncustomer_sw")private String noncustomerSw;
    @CsvBindByName(column = "desc1")private String desc1;
    @CsvBindByName(column = "desc2")private String desc2;
    @CsvBindByName(column = "desc3")private String desc3;
    @CsvBindByName(column = "desc4")private String desc4;
    @CsvBindByName(column = "desc5")private String desc5;
    @CsvBindByName(column = "desc6")private String desc6;
    @CsvBindByName(column = "mlp_code")private String mlpCode;
    @CsvBindByName(column = "div_reinv")private String divReinv;
    @CsvBindByName(column = "bond_type")private String bondType;
    @CsvBindByName(column = "tax_id")private String taxId;
    @CsvBindByName(column = "sec_class")private String secClass;
    @CsvBindByName(column = "program_no")private String programNo;
    @CsvBindByName(column = "cust_off_box_type")private String custOffBoxType;
    @CsvBindByName(column = "orig_offset")private String origOffset;
    @CsvBindByName(column = "unique_seq")private String uniqueSeq;
    @CsvBindByName(column = "country_code")private String countryCode;
    @CsvBindByName(column = "off_country_code")private String offCountryCode;
    @CsvBindByName(column = "adjust_sw")private String adjustSw;
    @CsvBindByName(column = "reinvest_sw")private String reinvestSw;
    @CsvBindByName(column = "free_credit_sw")private String freeCreditSw;
    @CsvBindByName(column = "source")private String source;
    @CsvBindByName(column = "rec_type")private String recType;
    @CsvBindByName(column = "new_sec_type_code")private String newSecTypeCode;
    @CsvBindByName(column = "sort_group_code")private String sortGroupCode;
    @CsvBindByName(column = "sort_alpha_key")private String sortAlphaKey;
    @CsvBindByName(column = "change_who_code")private String changeWhoCode;
    @CsvBindByName(column = "repo_contract_id")private String repoContractId;
    @CsvBindByName(column = "repo_collateral_id")private String repoCollateralId;
    @CsvBindByName(column = "branch")private String branch;
    @CsvBindByName(column = "market_prx")private String marketPrx;
    @CsvBindByName(column = "trade_factor")private String tradeFactor;
    @CsvBindByName(column = "unit_qty")private String unitQty;
    @CsvBindByName(column = "trailer_rid")private String trailerRid;
    @CsvBindByName(column = "qty_paid_on")private String qtyPaidOn;
    @CsvBindByName(column = "cripple_ind")private String crippleInd;
    @CsvBindByName(column = "as_of_mkt_val_amt")private String asOfMktValAmt;
    @CsvBindByName(column = "internal_rid")private String internalRid;
    @CsvBindByName(column = "beneficary_type")private String beneficaryType;
    @CsvBindByName(column = "jazz_offset_acct_no")private String jazzOffsetAcctNo;
    @CsvBindByName(column = "jazz_offset_type")private String jazzOffsetType;
    @CsvBindByName(column = "internal_uid")private String internalUid;
    @CsvBindByName(column = "internal_oid")private String internalOid;
    @CsvBindByName(column = "jazz_tran_id")private String jazzTranId;
    @CsvBindByName(column = "internal_aid")private String internalAid;

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

    public String getBigPrx() {
        return bigPrx;
    }

    public void setBigPrx(String bigPrx) {
        this.bigPrx = bigPrx;
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

    public String getForeignCurr() {
        return foreignCurr;
    }

    public void setForeignCurr(String foreignCurr) {
        this.foreignCurr = foreignCurr;
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

    public String getSecClass() {
        return secClass;
    }

    public void setSecClass(String secClass) {
        this.secClass = secClass;
    }

    public String getProgramNo() {
        return programNo;
    }

    public void setProgramNo(String programNo) {
        this.programNo = programNo;
    }

    public String getCustOffBoxType() {
        return custOffBoxType;
    }

    public void setCustOffBoxType(String custOffBoxType) {
        this.custOffBoxType = custOffBoxType;
    }

    public String getOrigOffset() {
        return origOffset;
    }

    public void setOrigOffset(String origOffset) {
        this.origOffset = origOffset;
    }

    public String getUniqueSeq() {
        return uniqueSeq;
    }

    public void setUniqueSeq(String uniqueSeq) {
        this.uniqueSeq = uniqueSeq;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public String getNewSecTypeCode() {
        return newSecTypeCode;
    }

    public void setNewSecTypeCode(String newSecTypeCode) {
        this.newSecTypeCode = newSecTypeCode;
    }

    public String getSortGroupCode() {
        return sortGroupCode;
    }

    public void setSortGroupCode(String sortGroupCode) {
        this.sortGroupCode = sortGroupCode;
    }

    public String getSortAlphaKey() {
        return sortAlphaKey;
    }

    public void setSortAlphaKey(String sortAlphaKey) {
        this.sortAlphaKey = sortAlphaKey;
    }

    public String getChangeWhoCode() {
        return changeWhoCode;
    }

    public void setChangeWhoCode(String changeWhoCode) {
        this.changeWhoCode = changeWhoCode;
    }

    public String getRepoContractId() {
        return repoContractId;
    }

    public void setRepoContractId(String repoContractId) {
        this.repoContractId = repoContractId;
    }

    public String getRepoCollateralId() {
        return repoCollateralId;
    }

    public void setRepoCollateralId(String repoCollateralId) {
        this.repoCollateralId = repoCollateralId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMarketPrx() {
        return marketPrx;
    }

    public void setMarketPrx(String marketPrx) {
        this.marketPrx = marketPrx;
    }

    public String getTradeFactor() {
        return tradeFactor;
    }

    public void setTradeFactor(String tradeFactor) {
        this.tradeFactor = tradeFactor;
    }

    public String getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(String unitQty) {
        this.unitQty = unitQty;
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

    public String getAsOfMktValAmt() {
        return asOfMktValAmt;
    }

    public void setAsOfMktValAmt(String asOfMktValAmt) {
        this.asOfMktValAmt = asOfMktValAmt;
    }

    public String getInternalRid() {
        return internalRid;
    }

    public void setInternalRid(String internalRid) {
        this.internalRid = internalRid;
    }

    public String getBeneficaryType() {
        return beneficaryType;
    }

    public void setBeneficaryType(String beneficaryType) {
        this.beneficaryType = beneficaryType;
    }

    public String getJazzOffsetAcctNo() {
        return jazzOffsetAcctNo;
    }

    public void setJazzOffsetAcctNo(String jazzOffsetAcctNo) {
        this.jazzOffsetAcctNo = jazzOffsetAcctNo;
    }

    public String getJazzOffsetType() {
        return jazzOffsetType;
    }

    public void setJazzOffsetType(String jazzOffsetType) {
        this.jazzOffsetType = jazzOffsetType;
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

    public String getJazzTranId() {
        return jazzTranId;
    }

    public void setJazzTranId(String jazzTranId) {
        this.jazzTranId = jazzTranId;
    }

    public String getInternalAid() {
        return internalAid;
    }

    public void setInternalAid(String internalAid) {
        this.internalAid = internalAid;
    }
}
