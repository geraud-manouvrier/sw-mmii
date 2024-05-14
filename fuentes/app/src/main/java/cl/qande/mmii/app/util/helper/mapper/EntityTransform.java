package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.csv.*;
import cl.qande.mmii.app.models.db.pershing.entity.*;
import cl.qande.mmii.app.models.db.stonex.entity.*;
import cl.qande.mmii.app.util.helper.CsvBean;

import java.util.ArrayList;
import java.util.List;

public interface EntityTransform {

    public static final String FAKE_PROCESS_STAMP  = "";

    public static StageAct getFromFileToDb(ActCsvBean csvEntity) {
        var dbEntity  = new StageAct();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setOldAcctNo(csvEntity.getOldAcctNo());
        dbEntity.setZip(csvEntity.getZip());
        dbEntity.setZipPlus4(csvEntity.getZipPlus4());
        dbEntity.setForeignZip(csvEntity.getForeignZip());
        dbEntity.setNamelines(csvEntity.getNamelines());
        dbEntity.setNameLine1(csvEntity.getNameLine1());
        dbEntity.setNameLine2(csvEntity.getNameLine2());
        dbEntity.setNameLine3(csvEntity.getNameLine3());
        dbEntity.setNameLine4(csvEntity.getNameLine4());
        dbEntity.setNameLine5(csvEntity.getNameLine5());
        dbEntity.setNameLine6(csvEntity.getNameLine6());
        dbEntity.setKey1(csvEntity.getKey1());
        dbEntity.setKey2(csvEntity.getKey2());
        dbEntity.setKey3(csvEntity.getKey3());
        dbEntity.setKey4(csvEntity.getKey4());
        dbEntity.setKey5(csvEntity.getKey5());
        dbEntity.setHomePhone(csvEntity.getHomePhone());
        dbEntity.setWorkPhone(csvEntity.getWorkPhone());
        dbEntity.setAltPhone(csvEntity.getAltPhone());
        dbEntity.setStateCode(csvEntity.getStateCode());
        dbEntity.setCountryCode(csvEntity.getCountryCode());
        dbEntity.setProvinceCode(csvEntity.getProvinceCode());
        dbEntity.setWithholdCntry(csvEntity.getWithholdCntry());
        dbEntity.setNoAutoCancelSw(csvEntity.getNoAutoCancelSw());
        dbEntity.setNoidWithholdCode(csvEntity.getNoidWithholdCode());
        dbEntity.setTaxIdFormat(csvEntity.getTaxIdFormat());
        dbEntity.setW8MailingCy(csvEntity.getW8MailingCy());
        dbEntity.setTaxId(csvEntity.getTaxId());
        dbEntity.setLastActivityCym(csvEntity.getLastActivityCym());
        dbEntity.setOpenCymd(csvEntity.getOpenCymd());
        dbEntity.setChangeCymd(csvEntity.getChangeCymd());
        dbEntity.setCashSi1(csvEntity.getCashSi1());
        dbEntity.setCashSi2(csvEntity.getCashSi2());
        dbEntity.setMarginSi1(csvEntity.getMarginSi1());
        dbEntity.setMarginSi2(csvEntity.getMarginSi2());
        dbEntity.setDividenSi(csvEntity.getDividenSi());
        dbEntity.setSecondCashSi(csvEntity.getSecondCashSi());
        dbEntity.setWithholdSw(csvEntity.getWithholdSw());
        dbEntity.setW9RequestStatus(csvEntity.getW9RequestStatus());
        dbEntity.setW8RequestStatus(csvEntity.getW8RequestStatus());
        dbEntity.setTefraExemptSw(csvEntity.getTefraExemptSw());
        dbEntity.setPrincipalCode(csvEntity.getPrincipalCode());
        dbEntity.setF1001Status(csvEntity.getF1001Status());
        dbEntity.setInstCode(csvEntity.getInstCode());
        dbEntity.setNyTaxSw(csvEntity.getNyTaxSw());
        dbEntity.setInvObj(csvEntity.getInvObj());
        dbEntity.setClassField(csvEntity.getClassField());
        dbEntity.setNetworkEligFl(csvEntity.getNetworkEligFl());
        dbEntity.setMisc7(csvEntity.getMisc7());
        dbEntity.setCma(csvEntity.getCma());
        dbEntity.setViolCode(csvEntity.getViolCode());
        dbEntity.setHistCode(csvEntity.getHistCode());
        dbEntity.setDirectorSw(csvEntity.getDirectorSw());
        dbEntity.setProxyDisclCode(csvEntity.getProxyDisclCode());
        dbEntity.setDiscrTradingCode(csvEntity.getDiscrTradingCode());
        dbEntity.setOptnIOCode(csvEntity.getOptnIOCode());
        dbEntity.setAvgPrice(csvEntity.getAvgPrice());
        dbEntity.setMisc1(csvEntity.getMisc1());
        dbEntity.setMisc2(csvEntity.getMisc2());
        dbEntity.setMisc3(csvEntity.getMisc3());
        dbEntity.setMisc4(csvEntity.getMisc4());
        dbEntity.setMisc5(csvEntity.getMisc5());
        dbEntity.setMisc6(csvEntity.getMisc6());
        dbEntity.setSweepCode(csvEntity.getSweepCode());
        dbEntity.setMmfInitPurchSw(csvEntity.getMmfInitPurchSw());
        dbEntity.setCashDivSw(csvEntity.getCashDivSw());
        dbEntity.setMmfCashOnly(csvEntity.getMmfCashOnly());
        dbEntity.setMargIntRate(csvEntity.getMargIntRate());
        dbEntity.setMargIntChg(csvEntity.getMargIntChg());
        dbEntity.setSegregationSw(csvEntity.getSegregationSw());
        dbEntity.setCreditIntCode(csvEntity.getCreditIntCode());
        dbEntity.setOptionLossLimit(csvEntity.getOptionLossLimit());
        dbEntity.setErisaCode(csvEntity.getErisaCode());
        dbEntity.setCredIntNopostSw(csvEntity.getCredIntNopostSw());
        dbEntity.setForeignSi1(csvEntity.getForeignSi1());
        dbEntity.setForeignSi2(csvEntity.getForeignSi2());
        dbEntity.setStkDiscount(csvEntity.getStkDiscount());
        dbEntity.setBndDiscount(csvEntity.getBndDiscount());
        dbEntity.setOptDiscount(csvEntity.getOptDiscount());
        dbEntity.setConfirmCopy(csvEntity.getConfirmCopy());
        dbEntity.setReverseRep(csvEntity.getReverseRep());
        dbEntity.setAcatTermFeeSw(csvEntity.getAcatTermFeeSw());
        dbEntity.setWithholdCymd(csvEntity.getWithholdCymd());
        dbEntity.setLastStmtCym(csvEntity.getLastStmtCym());
        dbEntity.setMano(csvEntity.getMano());
        dbEntity.setManox(csvEntity.getManox());
        dbEntity.setRestrictionCymd(csvEntity.getRestrictionCymd());
        dbEntity.setMstBrkr(csvEntity.getMstBrkr());
        dbEntity.setCompanyMergeCode(csvEntity.getCompanyMergeCode());
        dbEntity.setRestrictionCode(csvEntity.getRestrictionCode());
        dbEntity.setNoJournalInd(csvEntity.getNoJournalInd());
        dbEntity.setMmfScvcFeeSw(csvEntity.getMmfScvcFeeSw());
        dbEntity.setExclMailLine1Sw(csvEntity.getExclMailLine1Sw());
        dbEntity.setExclMailLine2Sw(csvEntity.getExclMailLine2Sw());
        dbEntity.setExclMailLine3Sw(csvEntity.getExclMailLine3Sw());
        dbEntity.setUseCode1Sw(csvEntity.getUseCode1Sw());
        dbEntity.setDownloadCode(csvEntity.getDownloadCode());
        dbEntity.setInstOverrideSw(csvEntity.getInstOverrideSw());
        dbEntity.setRemicCmoSw(csvEntity.getRemicCmoSw());
        dbEntity.setAccountDocCat(csvEntity.getAccountDocCat());
        dbEntity.setDocTranLvl(csvEntity.getDocTranLvl());
        dbEntity.setPrimeBrokerCode(csvEntity.getPrimeBrokerCode());
        dbEntity.setCollLoanAcSw(csvEntity.getCollLoanAcSw());
        dbEntity.setAcctTypeInd(csvEntity.getAcctTypeInd());
        dbEntity.setTaxWithholdingRt(csvEntity.getTaxWithholdingRt());
        dbEntity.setTaxWithholdingCd(csvEntity.getTaxWithholdingCd());
        dbEntity.setFaxPhone(csvEntity.getFaxPhone());
        dbEntity.setRestBalance(csvEntity.getRestBalance());
        dbEntity.setBarCode(csvEntity.getBarCode());
        dbEntity.setBarCodeChk(csvEntity.getBarCodeChk());
        dbEntity.setManagementGroup(csvEntity.getManagementGroup());
        dbEntity.setReinLabelSentSw(csvEntity.getReinLabelSentSw());
        dbEntity.setDivertCode(csvEntity.getDivertCode());
        dbEntity.setPrevPrinTrdsSw(csvEntity.getPrevPrinTrdsSw());
        dbEntity.setTpaNumber(csvEntity.getTpaNumber());
        dbEntity.setCarRt(csvEntity.getCarRt());
        dbEntity.setProductClass(csvEntity.getProductClass());
        dbEntity.setCmtaNo(csvEntity.getCmtaNo());
        dbEntity.setUpdTerm(csvEntity.getUpdTerm());
        dbEntity.setDlrFirmNo(csvEntity.getDlrFirmNo());
        dbEntity.setDlrBrokerNo(csvEntity.getDlrBrokerNo());
        dbEntity.setLrate(csvEntity.getLrate());
        dbEntity.setSellComm(csvEntity.getSellComm());
        dbEntity.setBrate(csvEntity.getBrate());
        dbEntity.setBuyComm(csvEntity.getBuyComm());
        dbEntity.setNsccNo(csvEntity.getNsccNo());
        dbEntity.setDtcFboCode(csvEntity.getDtcFboCode());
        dbEntity.setNasdaqFirmNo(csvEntity.getNasdaqFirmNo());
        dbEntity.setDlrNasdaqSym(csvEntity.getDlrNasdaqSym());
        dbEntity.setIdcfm(csvEntity.getIdcfm());
        dbEntity.setGenericUserField(csvEntity.getGenericUserField());
        dbEntity.setNoCfmCode(csvEntity.getNoCfmCode());
        dbEntity.setFlipExch(csvEntity.getFlipExch());
        dbEntity.setCorrClear(csvEntity.getCorrClear());
        dbEntity.setStkCommSched(csvEntity.getStkCommSched());
        dbEntity.setBndCommSched(csvEntity.getBndCommSched());
        dbEntity.setOptCommSched(csvEntity.getOptCommSched());
        dbEntity.setPostageAmt(csvEntity.getPostageAmt());
        dbEntity.setMuniCnsPart(csvEntity.getMuniCnsPart());
        dbEntity.setNonCustomerSw(csvEntity.getNonCustomerSw());
        dbEntity.setNasdaqSym(csvEntity.getNasdaqSym());
        dbEntity.setPurgeInd(csvEntity.getPurgeInd());
        dbEntity.setBillBypass(csvEntity.getBillBypass());
        dbEntity.setOrderOnly(csvEntity.getOrderOnly());
        dbEntity.setIraTermCymd(csvEntity.getIraTermCymd());
        dbEntity.setReinvestCode(csvEntity.getReinvestCode());
        dbEntity.setCashDrOvrd(csvEntity.getCashDrOvrd());
        dbEntity.setTermReason(csvEntity.getTermReason());
        dbEntity.setIrsNameLine1(csvEntity.getIrsNameLine1());
        dbEntity.setIrsNameLine2(csvEntity.getIrsNameLine2());
        dbEntity.setNccFirmNo(csvEntity.getNccFirmNo());
        dbEntity.setAchInc(csvEntity.getAchInc());
        dbEntity.setAchCr(csvEntity.getAchCr());
        dbEntity.setAchDr(csvEntity.getAchDr());
        dbEntity.setOutsideMmf(csvEntity.getOutsideMmf());
        dbEntity.setRepB4Acats(csvEntity.getRepB4Acats());
        dbEntity.setF121StatusCode(csvEntity.getF121StatusCode());
        dbEntity.setGsccFirmNo(csvEntity.getGsccFirmNo());
        dbEntity.setGsccNo(csvEntity.getGsccNo());
        dbEntity.setMbsccFirmNo(csvEntity.getMbsccFirmNo());
        dbEntity.setMbsccNo(csvEntity.getMbsccNo());
        dbEntity.setEmpClassCode(csvEntity.getEmpClassCode());
        dbEntity.setLastReviewCode(csvEntity.getLastReviewCode());
        dbEntity.setLastReviewCymd(csvEntity.getLastReviewCymd());
        dbEntity.setDocRestrictCode(csvEntity.getDocRestrictCode());
        dbEntity.setDocRestrictCymd(csvEntity.getDocRestrictCymd());
        dbEntity.setGroupNo(csvEntity.getGroupNo());
        dbEntity.setActForm1(csvEntity.getActForm1());
        dbEntity.setActForm2(csvEntity.getActForm2());
        dbEntity.setActForm3(csvEntity.getActForm3());
        dbEntity.setActForm4(csvEntity.getActForm4());
        dbEntity.setActForm5(csvEntity.getActForm5());
        dbEntity.setActForm6(csvEntity.getActForm6());
        dbEntity.setActForm7(csvEntity.getActForm7());
        dbEntity.setActForm8(csvEntity.getActForm8());
        dbEntity.setActForm9(csvEntity.getActForm9());
        dbEntity.setActForm10(csvEntity.getActForm10());
        dbEntity.setActForm11(csvEntity.getActForm11());
        dbEntity.setNoRebate(csvEntity.getNoRebate());
        dbEntity.setAlternateState(csvEntity.getAlternateState());
        dbEntity.setCity(csvEntity.getCity());
        dbEntity.setNav(csvEntity.getNav());
        dbEntity.setNavrSw(csvEntity.getNavrSw());
        dbEntity.setWrapPlan(csvEntity.getWrapPlan());
        dbEntity.setMmfSecNo(csvEntity.getMmfSecNo());
        dbEntity.setMmfSellFirst(csvEntity.getMmfSellFirst());
        dbEntity.setAcatsAutoValid(csvEntity.getAcatsAutoValid());
        dbEntity.setBrrEligible(csvEntity.getBrrEligible());
        dbEntity.setRepoRequest(csvEntity.getRepoRequest());
        dbEntity.setBranch(csvEntity.getBranch());
        dbEntity.setBranchB4Acats(csvEntity.getBranchB4Acats());
        dbEntity.setReverseBranch(csvEntity.getReverseBranch());
        dbEntity.setDsExemptSw(csvEntity.getDsExemptSw());
        dbEntity.setAcctStatus(csvEntity.getAcctStatus());
        dbEntity.setCommOverride(csvEntity.getCommOverride());
        dbEntity.setBoltInd(csvEntity.getBoltInd());
        dbEntity.setInvestorCode(csvEntity.getInvestorCode());
        dbEntity.setIpoEligible(csvEntity.getIpoEligible());
        dbEntity.setChangeSource(csvEntity.getChangeSource());
        dbEntity.setChangeSourceId(csvEntity.getChangeSourceId());
        dbEntity.setStRegExempt(csvEntity.getStRegExempt());
        dbEntity.setNoTranFeeInd(csvEntity.getNoTranFeeInd());
        dbEntity.setAcctAvgPriceInd(csvEntity.getAcctAvgPriceInd());
        dbEntity.setPreventStockLoanInd(csvEntity.getPreventStockLoanInd());
        dbEntity.setAccessDeliverInd(csvEntity.getAccessDeliverInd());
        dbEntity.setSocialCode(csvEntity.getSocialCode());
        dbEntity.setDfltCrncyType(csvEntity.getDfltCrncyType());
        dbEntity.setInstAcctInd(csvEntity.getInstAcctInd());
        dbEntity.setInvestorOptionCode(csvEntity.getInvestorOptionCode());
        dbEntity.setMgnTierSchedCode(csvEntity.getMgnTierSchedCode());
        dbEntity.setNaturalPersonCode(csvEntity.getNaturalPersonCode());
        dbEntity.setMultiCurrInd(csvEntity.getMultiCurrInd());
        dbEntity.setActCmpRvwInd(csvEntity.getActCmpRvwInd());
        dbEntity.setActMstInd(csvEntity.getActMstInd());

        return dbEntity; }

    public static StageActSum getFromFileToDb(ActSumCsvBean csvEntity) {
        var dbEntity  = new StageActSum();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setAcctBal(csvEntity.getAcctBal());
        dbEntity.setTotalMv(csvEntity.getTotalMv());
        dbEntity.setMoneyMarketBal(csvEntity.getMoneyMarketBal());
        dbEntity.setTotalAv(csvEntity.getTotalAv());
        dbEntity.setFundAvailAmt(csvEntity.getFundAvailAmt());
        dbEntity.setCashBal(csvEntity.getCashBal());
        dbEntity.setType1Mv(csvEntity.getType1Mv());
        dbEntity.setFedCall(csvEntity.getFedCall());
        dbEntity.setUsdEq(csvEntity.getUsdEq());
        dbEntity.setForeignMv(csvEntity.getForeignMv());
        dbEntity.setMaintCall(csvEntity.getMaintCall());
        dbEntity.setTotalCv(csvEntity.getTotalCv());
        dbEntity.setType2Lmv(csvEntity.getType2Lmv());
        dbEntity.setDrIntAmt(csvEntity.getDrIntAmt());
        dbEntity.setMarginBal(csvEntity.getMarginBal());
        dbEntity.setType2Smv(csvEntity.getType2Smv());
        dbEntity.setMtdDbInt(csvEntity.getMtdDbInt());
        dbEntity.setOtherBal(csvEntity.getOtherBal());
        dbEntity.setOtherMmv(csvEntity.getOtherMmv());
        dbEntity.setEquityPct(csvEntity.getEquityPct());
        dbEntity.setDivInt(csvEntity.getDivInt());
        dbEntity.setOtherCmv(csvEntity.getOtherCmv());
        dbEntity.setEquityAmt(csvEntity.getEquityAmt());
        dbEntity.setType1Ca(csvEntity.getType1Ca());
        dbEntity.setCashAvail(csvEntity.getCashAvail());
        dbEntity.setSmaBal(csvEntity.getSmaBal());
        dbEntity.setMgnSecT1(csvEntity.getMgnSecT1());
        dbEntity.setBuyPower(csvEntity.getBuyPower());

        return dbEntity;
    }

    public static StageAdm getFromFileToDb(AdmCsvBean csvEntity) {
        var dbEntity  = new StageAdm();

        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setBdayCymd(csvEntity.getBdayCymd());
        dbEntity.setSex(csvEntity.getSex());
        dbEntity.setEmployerName(csvEntity.getEmployerName());
        dbEntity.setEmployerAddr(csvEntity.getEmployerAddr());
        dbEntity.setEmployerCity(csvEntity.getEmployerCity());
        dbEntity.setEmployerState(csvEntity.getEmployerState());
        dbEntity.setEmployerZip(csvEntity.getEmployerZip());
        dbEntity.setEmployerZip4(csvEntity.getEmployerZip4());
        dbEntity.setBusinessNature(csvEntity.getBusinessNature());
        dbEntity.setOccupation(csvEntity.getOccupation());
        dbEntity.setYearsEmployed(csvEntity.getYearsEmployed());
        dbEntity.setSpseBdayCymd(csvEntity.getSpseBdayCymd());
        dbEntity.setSpseEmpName(csvEntity.getSpseEmpName());
        dbEntity.setSpseEmpAddr(csvEntity.getSpseEmpAddr());
        dbEntity.setSpseEmpCity(csvEntity.getSpseEmpCity());
        dbEntity.setSpseEmpState(csvEntity.getSpseEmpState());
        dbEntity.setSpseEmpZip(csvEntity.getSpseEmpZip());
        dbEntity.setSpseEmpZip4(csvEntity.getSpseEmpZip4());
        dbEntity.setSpseBusNature(csvEntity.getSpseBusNature());
        dbEntity.setSpseOccupation(csvEntity.getSpseOccupation());
        dbEntity.setSpseYrsEmploy(csvEntity.getSpseYrsEmploy());
        dbEntity.setSpseNetIncome(csvEntity.getSpseNetIncome());
        dbEntity.setSpseBusPhone(csvEntity.getSpseBusPhone());
        dbEntity.setMaritalStatus(csvEntity.getMaritalStatus());
        dbEntity.setHomeOwnRent(csvEntity.getHomeOwnRent());
        dbEntity.setDependents(csvEntity.getDependents());
        dbEntity.setTaxBracket(csvEntity.getTaxBracket());
        dbEntity.setAdmReferences(csvEntity.getAdmReferences());
        dbEntity.setAcctAcquired(csvEntity.getAcctAcquired());
        dbEntity.setNetIncome(csvEntity.getNetIncome());
        dbEntity.setLiqNet(csvEntity.getLiqNet());
        dbEntity.setInvestExpStk(csvEntity.getInvestExpStk());
        dbEntity.setInvestExpOpt(csvEntity.getInvestExpOpt());
        dbEntity.setInvestExpMmf(csvEntity.getInvestExpMmf());
        dbEntity.setInvestExpAnn(csvEntity.getInvestExpAnn());
        dbEntity.setInitialTrans(csvEntity.getInitialTrans());
        dbEntity.setPlanInvestAmt(csvEntity.getPlanInvestAmt());
        dbEntity.setNetWorth(csvEntity.getNetWorth());
        dbEntity.setClientMet(csvEntity.getClientMet());
        dbEntity.setCorpOfficer(csvEntity.getCorpOfficer());
        dbEntity.setEduLevel(csvEntity.getEduLevel());
        dbEntity.setRetired(csvEntity.getRetired());
        dbEntity.setPolicyOwner(csvEntity.getPolicyOwner());
        dbEntity.setUpdateWho(csvEntity.getUpdateWho());
        dbEntity.setUpdateTerm(csvEntity.getUpdateTerm());
        dbEntity.setUpdateCymd(csvEntity.getUpdateCymd());
        dbEntity.setAddCymd(csvEntity.getAddCymd());
        dbEntity.setNote1(csvEntity.getNote1());
        dbEntity.setNote2(csvEntity.getNote2());
        dbEntity.setNote3(csvEntity.getNote3());
        dbEntity.setNote4(csvEntity.getNote4());
        dbEntity.setNote5(csvEntity.getNote5());
        dbEntity.setNote6(csvEntity.getNote6());
        dbEntity.setBdateEstimated(csvEntity.getBdateEstimated());
        dbEntity.setEmailAddr(csvEntity.getEmailAddr());
        dbEntity.setRiskTolerance(csvEntity.getRiskTolerance());
        dbEntity.setOptionObjective(csvEntity.getOptionObjective());
        dbEntity.setFirstOptTrdCymd(csvEntity.getFirstOptTrdCymd());
        dbEntity.setOptProspectCymd(csvEntity.getOptProspectCymd());
        dbEntity.setLiqNetWorth(csvEntity.getLiqNetWorth());
        dbEntity.setEmailAddr2(csvEntity.getEmailAddr2());
        dbEntity.setControlCusip1(csvEntity.getControlCusip1());
        dbEntity.setControlCusip2(csvEntity.getControlCusip2());
        dbEntity.setControlCusip3(csvEntity.getControlCusip3());
        dbEntity.setSecObj1(csvEntity.getSecObj1());
        dbEntity.setSecObj2(csvEntity.getSecObj2());
        dbEntity.setSecObj3(csvEntity.getSecObj3());
        dbEntity.setSecObj4(csvEntity.getSecObj4());
        dbEntity.setShowDiscountSw(csvEntity.getShowDiscountSw());
        dbEntity.setConfTrailer(csvEntity.getConfTrailer());
        dbEntity.setPerfRpt(csvEntity.getPerfRpt());
        dbEntity.setInvestExpBond(csvEntity.getInvestExpBond());

        return dbEntity;}

    public static StageAdmExp getFromFileToDb(AdmExpCsvBean csvEntity) {
        var dbEntity  = new StageAdmExp();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setInvTimeHorizon(csvEntity.getInvTimeHorizon());
        dbEntity.setInvTimeHorizon2(csvEntity.getInvTimeHorizon2());
        dbEntity.setLiqNeedInd(csvEntity.getLiqNeedInd());
        dbEntity.setLiqNeedDolPct(csvEntity.getLiqNeedDolPct());
        dbEntity.setLiqNeedTimefrm(csvEntity.getLiqNeedTimefrm());
        dbEntity.setLiqNeedDolPct2(csvEntity.getLiqNeedDolPct2());
        dbEntity.setLiqNeedTimefrm2(csvEntity.getLiqNeedTimefrm2());
        dbEntity.setLiqNeedDolPct3(csvEntity.getLiqNeedDolPct3());
        dbEntity.setLiqNeedTimefrm3(csvEntity.getLiqNeedTimefrm3());
        dbEntity.setAddTms(csvEntity.getAddTms());
        dbEntity.setAddSourceId(csvEntity.getAddSourceId());
        dbEntity.setChangeTms(csvEntity.getChangeTms());
        dbEntity.setChangeSourceId(csvEntity.getChangeSourceId());

        return dbEntity; }

    public static StageBal getFromFileToDb(BalCsvBean csvEntity) {
        var dbEntity  = new StageBal();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setCrncyType(csvEntity.getCrncyType());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setLastSeqNo(csvEntity.getLastSeqNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setLongMktValueAmt(csvEntity.getLongMktValueAmt());
        dbEntity.setShrtMktValueAmt(csvEntity.getShrtMktValueAmt());
        dbEntity.setDividendBalAmt(csvEntity.getDividendBalAmt());
        dbEntity.setCashRcvdAmt(csvEntity.getCashRcvdAmt());
        dbEntity.setChkTodayAmt(csvEntity.getChkTodayAmt());
        dbEntity.setFreeCredMiscDeb(csvEntity.getFreeCredMiscDeb());
        dbEntity.setPendMatAmt(csvEntity.getPendMatAmt());
        dbEntity.setAcctBalAmt(csvEntity.getAcctBalAmt());
        dbEntity.setTradeActivity(csvEntity.getTradeActivity());
        dbEntity.setCashActivity(csvEntity.getCashActivity());
        dbEntity.setStockActivity(csvEntity.getStockActivity());
        dbEntity.setOtherActivity(csvEntity.getOtherActivity());
        dbEntity.setMfpInd(csvEntity.getMfpInd());
        dbEntity.setMfpValueAmt(csvEntity.getMfpValueAmt());
        dbEntity.setAipValueAmt(csvEntity.getAipValueAmt());
        dbEntity.setWithHeldAmt(csvEntity.getWithHeldAmt());
        dbEntity.setMmCode(csvEntity.getMmCode());
        dbEntity.setMktValueAmt(csvEntity.getMktValueAmt());
        dbEntity.setDailyCrInt(csvEntity.getDailyCrInt());
        dbEntity.setMtdCrInt(csvEntity.getMtdCrInt());
        dbEntity.setProjSdAmt(csvEntity.getProjSdAmt());
        dbEntity.setYesterdayChecks(csvEntity.getYesterdayChecks());
        dbEntity.setFrozenAmt(csvEntity.getFrozenAmt());
        dbEntity.setAchTodayAmt(csvEntity.getAchTodayAmt());
        dbEntity.setAchIncTodayAmt(csvEntity.getAchIncTodayAmt());
        dbEntity.setAchDistSw(csvEntity.getAchDistSw());
        dbEntity.setCashMgnMktVal(csvEntity.getCashMgnMktVal());
        dbEntity.setCashMgnCashAv(csvEntity.getCashMgnCashAv());
        dbEntity.setProjSdFreeAmt(csvEntity.getProjSdFreeAmt());
        dbEntity.setCashAvailPrvAmt(csvEntity.getCashAvailPrvAmt());
        dbEntity.setSmaChangePrvAmt(csvEntity.getSmaChangePrvAmt());
        dbEntity.setEquityAmt(csvEntity.getEquityAmt());
        dbEntity.setCashAvailAmt(csvEntity.getCashAvailAmt());
        dbEntity.setBuyPwrAmt(csvEntity.getBuyPwrAmt());
        dbEntity.setFedCallAmt(csvEntity.getFedCallAmt());
        dbEntity.setAccumFedAmt(csvEntity.getAccumFedAmt());
        dbEntity.setMaintCallAmt(csvEntity.getMaintCallAmt());
        dbEntity.setSmaChangeAmt(csvEntity.getSmaChangeAmt());
        dbEntity.setSmaBalAmt(csvEntity.getSmaBalAmt());
        dbEntity.setDailyInt2Amt(csvEntity.getDailyInt2Amt());
        dbEntity.setMtdInt2Amt(csvEntity.getMtdInt2Amt());
        dbEntity.setOptnReqAmt(csvEntity.getOptnReqAmt());
        dbEntity.setOptnMktLossAmt(csvEntity.getOptnMktLossAmt());
        dbEntity.setPercentEqty(csvEntity.getPercentEqty());
        dbEntity.setPriceErr(csvEntity.getPriceErr());
        dbEntity.setNeedMrgAgrmt(csvEntity.getNeedMrgAgrmt());
        dbEntity.setOplevErr(csvEntity.getOplevErr());
        dbEntity.setPctcapSw(csvEntity.getPctcapSw());
        dbEntity.setAmmoEntity(csvEntity.getAmmoEntity());
        dbEntity.setBopmvEqty(csvEntity.getBopmvEqty());
        dbEntity.setShrtLiqValueAmt(csvEntity.getShrtLiqValueAmt());
        dbEntity.setLongLiqValueAmt(csvEntity.getLongLiqValueAmt());
        dbEntity.setUsdEquivalent(csvEntity.getUsdEquivalent());
        dbEntity.setCurrencyFactor(csvEntity.getCurrencyFactor());
        dbEntity.setExcEquOvr50Amt(csvEntity.getExcEquOvr50Amt());
        dbEntity.setOptnAddtlReqAmt(csvEntity.getOptnAddtlReqAmt());
        dbEntity.setExchCall(csvEntity.getExchCall());
        dbEntity.setAccumFedPrev(csvEntity.getAccumFedPrev());
        dbEntity.setSmaOrCallPrev(csvEntity.getSmaOrCallPrev());
        dbEntity.setMaintPrev(csvEntity.getMaintPrev());
        dbEntity.setMarvInd(csvEntity.getMarvInd());
        dbEntity.setMgnSweepAmt(csvEntity.getMgnSweepAmt());
        dbEntity.setAvailCrCode(csvEntity.getAvailCrCode());
        dbEntity.setAvailCrAmt(csvEntity.getAvailCrAmt());

        return dbEntity; }

    public static StageBalAct getFromFileToDb(BalActCsvBean csvEntity) {
        var dbEntity  = new StageBalAct();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setCurrencySequence(csvEntity.getCurrencySequence());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setBuyPwrAmt(csvEntity.getBuyPwrAmt());
        dbEntity.setCashAvailAmt(csvEntity.getCashAvailAmt());
        dbEntity.setCashMgnCashAv(csvEntity.getCashMgnCashAv());
        dbEntity.setEquityAmt(csvEntity.getEquityAmt());
        dbEntity.setDivIntAmt(csvEntity.getDivIntAmt());
        dbEntity.setMktValAmt(csvEntity.getMktValAmt());
        dbEntity.setTradeDtBal(csvEntity.getTradeDtBal());
        dbEntity.setSettleDtBal(csvEntity.getSettleDtBal());
        dbEntity.setLongMktValueAmt(csvEntity.getLongMktValueAmt());
        dbEntity.setShrtMktValueAmt(csvEntity.getShrtMktValueAmt());
        dbEntity.setFedCallAmt(csvEntity.getFedCallAmt());
        dbEntity.setAccumFedAmt(csvEntity.getAccumFedAmt());
        dbEntity.setAccumFedPrev(csvEntity.getAccumFedPrev());
        dbEntity.setMaintCallAmt(csvEntity.getMaintCallAmt());
        dbEntity.setMaintPrev(csvEntity.getMaintPrev());
        dbEntity.setSmaChangeAmt(csvEntity.getSmaChangeAmt());
        dbEntity.setSmaChangePrvAmt(csvEntity.getSmaChangePrvAmt());
        dbEntity.setSmaBalAmt(csvEntity.getSmaBalAmt());
        dbEntity.setSmaOrCallPrev(csvEntity.getSmaOrCallPrev());
        dbEntity.setCurrencyFactor(csvEntity.getCurrencyFactor());
        dbEntity.setFreeCredMiscDeb(csvEntity.getFreeCredMiscDeb());
        dbEntity.setDlyCreditInt(csvEntity.getDlyCreditInt());
        dbEntity.setMtdCreditInt(csvEntity.getMtdCreditInt());
        dbEntity.setMtdMgnInt(csvEntity.getMtdMgnInt());
        dbEntity.setExchCall(csvEntity.getExchCall());
        dbEntity.setPercentEqty(csvEntity.getPercentEqty());
        dbEntity.setMoneyMktBal(csvEntity.getMoneyMktBal());
        dbEntity.setCashFreeCr(csvEntity.getCashFreeCr());
        dbEntity.setBalLongSd(csvEntity.getBalLongSd());
        dbEntity.setBalShortSd(csvEntity.getBalShortSd());
        dbEntity.setBalShortTd(csvEntity.getBalShortTd());
        dbEntity.setBalLongTd(csvEntity.getBalLongTd());
        dbEntity.setOptReq(csvEntity.getOptReq());
        dbEntity.setFedCallPrev(csvEntity.getFedCallPrev());
        dbEntity.setCashFreeCrPrev(csvEntity.getCashFreeCrPrev());
        dbEntity.setDailyIntPrev(csvEntity.getDailyIntPrev());
        dbEntity.setMtdIntPrev(csvEntity.getMtdIntPrev());
        dbEntity.setBalPctEqtyPrev(csvEntity.getBalPctEqtyPrev());
        dbEntity.setOptValLong(csvEntity.getOptValLong());
        dbEntity.setOptValShort(csvEntity.getOptValShort());
        dbEntity.setCurrCode(csvEntity.getCurrCode());
        dbEntity.setAdjBal(csvEntity.getAdjBal());
        dbEntity.setAvailCrAmt(csvEntity.getAvailCrAmt());

        return dbEntity; }

    public static StageCsh getFromFileToDb(CshCsvBean csvEntity) {
        var dbEntity  = new StageCsh();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setAcctClass(csvEntity.getAcctClass());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setSecType(csvEntity.getSecType());
        dbEntity.setClassField(csvEntity.getClassField());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setMgnCode(csvEntity.getMgnCode());
        dbEntity.setStdInst(csvEntity.getStdInst());
        dbEntity.setTradeCymd(csvEntity.getTradeCymd());
        dbEntity.setAsofCymd(csvEntity.getAsofCymd());
        dbEntity.setSettleCymd(csvEntity.getSettleCymd());
        dbEntity.setOrigin(csvEntity.getOrigin());
        dbEntity.setTranId(csvEntity.getTranId());
        dbEntity.setControlNo(csvEntity.getControlNo());
        dbEntity.setBigQty(csvEntity.getBigQty());
        dbEntity.setSource(csvEntity.getSource());
        dbEntity.setPurchOrSale(csvEntity.getPurchOrSale());
        dbEntity.setBigExch(csvEntity.getBigExch());
        dbEntity.setNetAmt(csvEntity.getNetAmt());
        dbEntity.setOffsetAcct(csvEntity.getOffsetAcct());
        dbEntity.setOffsetType(csvEntity.getOffsetType());
        dbEntity.setNoCredit(csvEntity.getNoCredit());
        dbEntity.setGenericUserField(csvEntity.getGenericUserField());
        dbEntity.setTagNo(csvEntity.getTagNo());
        dbEntity.setCurrSeq(csvEntity.getCurrSeq());
        dbEntity.setBrokerNo(csvEntity.getBrokerNo());
        dbEntity.setNoncustomerSw(csvEntity.getNoncustomerSw());
        dbEntity.setDesc1(csvEntity.getDesc1());
        dbEntity.setDesc2(csvEntity.getDesc2());
        dbEntity.setDesc3(csvEntity.getDesc3());
        dbEntity.setDesc4(csvEntity.getDesc4());
        dbEntity.setDesc5(csvEntity.getDesc5());
        dbEntity.setDesc6(csvEntity.getDesc6());
        dbEntity.setMlpCode(csvEntity.getMlpCode());
        dbEntity.setDivReinv(csvEntity.getDivReinv());
        dbEntity.setBondType(csvEntity.getBondType());
        dbEntity.setTaxId(csvEntity.getTaxId());
        dbEntity.setProgramNo(csvEntity.getProgramNo());
        dbEntity.setPaymentCurrType(csvEntity.getPaymentCurrType());
        dbEntity.setCountryCode(csvEntity.getCountryCode());
        dbEntity.setOffCountryCode(csvEntity.getOffCountryCode());
        dbEntity.setAdjustSw(csvEntity.getAdjustSw());
        dbEntity.setReinvestSw(csvEntity.getReinvestSw());
        dbEntity.setFreeCreditSw(csvEntity.getFreeCreditSw());
        dbEntity.setRecType(csvEntity.getRecType());
        dbEntity.setBatchJob(csvEntity.getBatchJob());
        dbEntity.setChangeTms(csvEntity.getChangeTms());
        dbEntity.setBranch(csvEntity.getBranch());
        dbEntity.setChangeWhoCode(csvEntity.getChangeWhoCode());
        dbEntity.setCsiOverride(csvEntity.getCsiOverride());
        dbEntity.setItemNo(csvEntity.getItemNo());
        dbEntity.setTrailerRid(csvEntity.getTrailerRid());
        dbEntity.setQtyPaidOn(csvEntity.getQtyPaidOn());
        dbEntity.setCrippleInd(csvEntity.getCrippleInd());
        dbEntity.setInternalRid(csvEntity.getInternalRid());
        dbEntity.setPayeeBenCode(csvEntity.getPayeeBenCode());
        dbEntity.setDisburseCode(csvEntity.getDisburseCode());
        dbEntity.setInternalUid(csvEntity.getInternalUid());
        dbEntity.setInternalOid(csvEntity.getInternalOid());
        dbEntity.setStateCode(csvEntity.getStateCode());

        return dbEntity; }

    public static StageMmfBal getFromFileToDb(MmfBalCsvBean csvEntity) {
        var dbEntity  = new StageMmfBal();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setBalance(csvEntity.getBalance());
        dbEntity.setTrades(csvEntity.getTrades());
        dbEntity.setAccrueDiv(csvEntity.getAccrueDiv());
        dbEntity.setAccruePaid(csvEntity.getAccruePaid());
        dbEntity.setLastActiveCymd(csvEntity.getLastActiveCymd());

        return dbEntity; }

    public static StagePos getFromFileToDb(PosCsvBean csvEntity) {
        var dbEntity  = new StagePos();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setControlNo(csvEntity.getControlNo());
        dbEntity.setSeqNo(csvEntity.getSeqNo());
        dbEntity.setIoex(csvEntity.getIoex());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setCurrencySequence(csvEntity.getCurrencySequence());
        dbEntity.setTradeCymd(csvEntity.getTradeCymd());
        dbEntity.setSettleCymd(csvEntity.getSettleCymd());
        dbEntity.setAsofCymd(csvEntity.getAsofCymd());
        dbEntity.setSumSecType(csvEntity.getSumSecType());
        dbEntity.setSource(csvEntity.getSource());
        dbEntity.setPurchasePrx(csvEntity.getPurchasePrx());
        dbEntity.setCashAmt(csvEntity.getCashAmt());
        dbEntity.setChkTodayAmt(csvEntity.getChkTodayAmt());
        dbEntity.setQuantity(csvEntity.getQuantity());
        dbEntity.setSegQty(csvEntity.getSegQty());
        dbEntity.setLegQty(csvEntity.getLegQty());
        dbEntity.setSkfQty(csvEntity.getSkfQty());
        dbEntity.setSkcQty(csvEntity.getSkcQty());
        dbEntity.setTrfQty(csvEntity.getTrfQty());
        dbEntity.setPbooQty(csvEntity.getPbooQty());
        dbEntity.setDtooQty(csvEntity.getDtooQty());
        dbEntity.setDocQty(csvEntity.getDocQty());
        dbEntity.setTrfCymd(csvEntity.getTrfCymd());
        dbEntity.setBuyOrSell(csvEntity.getBuyOrSell());
        dbEntity.setMarketPrx(csvEntity.getMarketPrx());
        dbEntity.setTooQty(csvEntity.getTooQty());
        dbEntity.setMktValueAmt(csvEntity.getMktValueAmt());
        dbEntity.setUsdEquivalent(csvEntity.getUsdEquivalent());
        dbEntity.setSegReinvQty(csvEntity.getSegReinvQty());
        dbEntity.setAdjustSw(csvEntity.getAdjustSw());
        dbEntity.setReinvestSw(csvEntity.getReinvestSw());
        dbEntity.setFreeCreditSw(csvEntity.getFreeCreditSw());
        dbEntity.setUsdMktPrx(csvEntity.getUsdMktPrx());

        return dbEntity; }


    public static StageRad getFromFileToDb(RadCsvBean csvEntity) {
        var dbEntity  = new StageRad();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setAcctClass(csvEntity.getAcctClass());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setSecType(csvEntity.getSecType());
        dbEntity.setClassField(csvEntity.getClassField());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setMgnCode(csvEntity.getMgnCode());
        dbEntity.setStdInst(csvEntity.getStdInst());
        dbEntity.setTradeCymd(csvEntity.getTradeCymd());
        dbEntity.setAsofCymd(csvEntity.getAsofCymd());
        dbEntity.setSettleCymd(csvEntity.getSettleCymd());
        dbEntity.setOrigin(csvEntity.getOrigin());
        dbEntity.setTranId(csvEntity.getTranId());
        dbEntity.setControlNo(csvEntity.getControlNo());
        dbEntity.setBigQty(csvEntity.getBigQty());
        dbEntity.setBigPrx(csvEntity.getBigPrx());
        dbEntity.setPurchOrSale(csvEntity.getPurchOrSale());
        dbEntity.setBigExch(csvEntity.getBigExch());
        dbEntity.setNetAmt(csvEntity.getNetAmt());
        dbEntity.setOffsetAcct(csvEntity.getOffsetAcct());
        dbEntity.setOffsetType(csvEntity.getOffsetType());
        dbEntity.setNoCredit(csvEntity.getNoCredit());
        dbEntity.setGenericUserField(csvEntity.getGenericUserField());
        dbEntity.setTagNo(csvEntity.getTagNo());
        dbEntity.setForeignCurr(csvEntity.getForeignCurr());
        dbEntity.setBrokerNo(csvEntity.getBrokerNo());
        dbEntity.setNoncustomerSw(csvEntity.getNoncustomerSw());
        dbEntity.setDesc1(csvEntity.getDesc1());
        dbEntity.setDesc2(csvEntity.getDesc2());
        dbEntity.setDesc3(csvEntity.getDesc3());
        dbEntity.setDesc4(csvEntity.getDesc4());
        dbEntity.setDesc5(csvEntity.getDesc5());
        dbEntity.setDesc6(csvEntity.getDesc6());
        dbEntity.setMlpCode(csvEntity.getMlpCode());
        dbEntity.setDivReinv(csvEntity.getDivReinv());
        dbEntity.setBondType(csvEntity.getBondType());
        dbEntity.setTaxId(csvEntity.getTaxId());
        dbEntity.setSecClass(csvEntity.getSecClass());
        dbEntity.setProgramNo(csvEntity.getProgramNo());
        dbEntity.setCustOffBoxType(csvEntity.getCustOffBoxType());
        dbEntity.setOrigOffset(csvEntity.getOrigOffset());
        dbEntity.setUniqueSeq(csvEntity.getUniqueSeq());
        dbEntity.setCountryCode(csvEntity.getCountryCode());
        dbEntity.setOffCountryCode(csvEntity.getOffCountryCode());
        dbEntity.setAdjustSw(csvEntity.getAdjustSw());
        dbEntity.setReinvestSw(csvEntity.getReinvestSw());
        dbEntity.setFreeCreditSw(csvEntity.getFreeCreditSw());
        dbEntity.setSource(csvEntity.getSource());
        dbEntity.setRecType(csvEntity.getRecType());
        dbEntity.setNewSecTypeCode(csvEntity.getNewSecTypeCode());
        dbEntity.setSortGroupCode(csvEntity.getSortGroupCode());
        dbEntity.setSortAlphaKey(csvEntity.getSortAlphaKey());
        dbEntity.setChangeWhoCode(csvEntity.getChangeWhoCode());
        dbEntity.setRepoContractId(csvEntity.getRepoContractId());
        dbEntity.setRepoCollateralId(csvEntity.getRepoCollateralId());
        dbEntity.setBranch(csvEntity.getBranch());
        dbEntity.setMarketPrx(csvEntity.getMarketPrx());
        dbEntity.setTradeFactor(csvEntity.getTradeFactor());
        dbEntity.setUnitQty(csvEntity.getUnitQty());
        dbEntity.setTrailerRid(csvEntity.getTrailerRid());
        dbEntity.setQtyPaidOn(csvEntity.getQtyPaidOn());
        dbEntity.setCrippleInd(csvEntity.getCrippleInd());
        dbEntity.setAsOfMktValAmt(csvEntity.getAsOfMktValAmt());
        dbEntity.setInternalRid(csvEntity.getInternalRid());
        dbEntity.setBeneficaryType(csvEntity.getBeneficaryType());
        dbEntity.setJazzOffsetAcctNo(csvEntity.getJazzOffsetAcctNo());
        dbEntity.setJazzOffsetType(csvEntity.getJazzOffsetType());
        dbEntity.setInternalUid(csvEntity.getInternalUid());
        dbEntity.setInternalOid(csvEntity.getInternalOid());
        dbEntity.setJazzTranId(csvEntity.getJazzTranId());
        dbEntity.setInternalAid(csvEntity.getInternalAid());

        return dbEntity; }

    public static StageTrdOsi getFromFileToDb(TrdOsiCsvBean csvEntity) {
        var dbEntity  = new StageTrdOsi();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setAcctClassCode(csvEntity.getAcctClassCode());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setRep(csvEntity.getRep());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setSecType(csvEntity.getSecType());
        dbEntity.setClassCode(csvEntity.getClassCode());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setMgnCode(csvEntity.getMgnCode());
        dbEntity.setStdInstrucCode(csvEntity.getStdInstrucCode());
        dbEntity.setTradeCymd(csvEntity.getTradeCymd());
        dbEntity.setAsofCymd(csvEntity.getAsofCymd());
        dbEntity.setSettleCymd(csvEntity.getSettleCymd());
        dbEntity.setOriginCode(csvEntity.getOriginCode());
        dbEntity.setTranId(csvEntity.getTranId());
        dbEntity.setControlNo(csvEntity.getControlNo());
        dbEntity.setBigQty(csvEntity.getBigQty());
        dbEntity.setBigPrx(csvEntity.getBigPrx());
        dbEntity.setBuySellInd(csvEntity.getBuySellInd());
        dbEntity.setBigExchType(csvEntity.getBigExchType());
        dbEntity.setNetAmt(csvEntity.getNetAmt());
        dbEntity.setOffsetAcctNo(csvEntity.getOffsetAcctNo());
        dbEntity.setOffsetType(csvEntity.getOffsetType());
        dbEntity.setGenericUserFieldType(csvEntity.getGenericUserFieldType());
        dbEntity.setTagNo(csvEntity.getTagNo());
        dbEntity.setCrncyType(csvEntity.getCrncyType());
        dbEntity.setBrokerNo(csvEntity.getBrokerNo());
        dbEntity.setNoncustomerInd(csvEntity.getNoncustomerInd());
        dbEntity.setDesc1(csvEntity.getDesc1());
        dbEntity.setDesc2(csvEntity.getDesc2());
        dbEntity.setDesc3(csvEntity.getDesc3());
        dbEntity.setDesc4(csvEntity.getDesc4());
        dbEntity.setDesc5(csvEntity.getDesc5());
        dbEntity.setDesc6(csvEntity.getDesc6());
        dbEntity.setMlpInd(csvEntity.getMlpInd());
        dbEntity.setFirmCapacityCode(csvEntity.getFirmCapacityCode());
        dbEntity.setDivReinvestCode(csvEntity.getDivReinvestCode());
        dbEntity.setMuniCbCode(csvEntity.getMuniCbCode());
        dbEntity.setBondClassCode(csvEntity.getBondClassCode());
        dbEntity.setCouponRate(csvEntity.getCouponRate());
        dbEntity.setConvFactor(csvEntity.getConvFactor());
        dbEntity.setTtoInd(csvEntity.getTtoInd());
        dbEntity.setTtoRep(csvEntity.getTtoRep());
        dbEntity.setStateCode(csvEntity.getStateCode());
        dbEntity.setTaxId(csvEntity.getTaxId());
        dbEntity.setOrderNo(csvEntity.getOrderNo());
        dbEntity.setLimitMarketInd(csvEntity.getLimitMarketInd());
        dbEntity.setReportedTrdPrx(csvEntity.getReportedTrdPrx());
        dbEntity.setPriceFactor(csvEntity.getPriceFactor());
        dbEntity.setBasisPrx(csvEntity.getBasisPrx());
        dbEntity.setBasisYieldPct(csvEntity.getBasisYieldPct());
        dbEntity.setHandFigInd(csvEntity.getHandFigInd());
        dbEntity.setUseNetAmtInd(csvEntity.getUseNetAmtInd());
        dbEntity.setPrincipalAmt(csvEntity.getPrincipalAmt());
        dbEntity.setInterestAmt(csvEntity.getInterestAmt());
        dbEntity.setSecFeeAmt(csvEntity.getSecFeeAmt());
        dbEntity.setCommAmt(csvEntity.getCommAmt());
        dbEntity.setGrossCommPct(csvEntity.getGrossCommPct());
        dbEntity.setGrossPcntInd(csvEntity.getGrossPcntInd());
        dbEntity.setConcessionAmt(csvEntity.getConcessionAmt());
        dbEntity.setHandleFeeAmt(csvEntity.getHandleFeeAmt());
        dbEntity.setLalCommAmt(csvEntity.getLalCommAmt());
        dbEntity.setEquivDiscPct(csvEntity.getEquivDiscPct());
        dbEntity.setCommDiscCode(csvEntity.getCommDiscCode());
        dbEntity.setDiscRate(csvEntity.getDiscRate());
        dbEntity.setTotalOrdQty(csvEntity.getTotalOrdQty());
        dbEntity.setTotalOrdCommAmt(csvEntity.getTotalOrdCommAmt());
        dbEntity.setPostageAmt(csvEntity.getPostageAmt());
        dbEntity.setSecClassCode(csvEntity.getSecClassCode());
        dbEntity.setCancelInd(csvEntity.getCancelInd());
        dbEntity.setRebillInd(csvEntity.getRebillInd());
        dbEntity.setCancelReasonType(csvEntity.getCancelReasonType());
        dbEntity.setSpclTypeCode(csvEntity.getSpclTypeCode());
        dbEntity.setSpclTypeCode2(csvEntity.getSpclTypeCode2());
        dbEntity.setSpclTypeCode3(csvEntity.getSpclTypeCode3());
        dbEntity.setConfirmNote(csvEntity.getConfirmNote());
        dbEntity.setSyndicateInd(csvEntity.getSyndicateInd());
        dbEntity.setExecutionTime(csvEntity.getExecutionTime());
        dbEntity.setCommSchedNo(csvEntity.getCommSchedNo());
        dbEntity.setEuroclearId(csvEntity.getEuroclearId());
        dbEntity.setProductType(csvEntity.getProductType());
        dbEntity.setOrderSrceCode(csvEntity.getOrderSrceCode());
        dbEntity.setDealerNo(csvEntity.getDealerNo());
        dbEntity.setNasdaqSymbol(csvEntity.getNasdaqSymbol());
        dbEntity.setNccContraBrkrNo(csvEntity.getNccContraBrkrNo());
        dbEntity.setOddLotDiffCode(csvEntity.getOddLotDiffCode());
        dbEntity.setAutoExchCode(csvEntity.getAutoExchCode());
        dbEntity.setOccInd(csvEntity.getOccInd());
        dbEntity.setAutoTradeCode(csvEntity.getAutoTradeCode());
        dbEntity.setAtdUniqueKey(csvEntity.getAtdUniqueKey());
        dbEntity.setProgramNo(csvEntity.getProgramNo());
        dbEntity.setNetFeeAmt(csvEntity.getNetFeeAmt());
        dbEntity.setTrdExecTms(csvEntity.getTrdExecTms());
        dbEntity.setAdjInd(csvEntity.getAdjInd());
        dbEntity.setReinvestInd(csvEntity.getReinvestInd());
        dbEntity.setFreeCreditInd(csvEntity.getFreeCreditInd());
        dbEntity.setExecCount(csvEntity.getExecCount());
        dbEntity.setTaxLotInd(csvEntity.getTaxLotInd());
        dbEntity.setOriginatorId(csvEntity.getOriginatorId());
        dbEntity.setTtoSubNo(csvEntity.getTtoSubNo());
        dbEntity.setTtoBranch(csvEntity.getTtoBranch());
        dbEntity.setInternetOrderInd(csvEntity.getInternetOrderInd());
        dbEntity.setFrgnExchInd(csvEntity.getFrgnExchInd());
        dbEntity.setYieldOvrdInd(csvEntity.getYieldOvrdInd());
        dbEntity.setPrimeBrkrCode(csvEntity.getPrimeBrkrCode());
        dbEntity.setAvgPriceInd(csvEntity.getAvgPriceInd());
        dbEntity.setInstId(csvEntity.getInstId());
        dbEntity.setYieldToMatRate(csvEntity.getYieldToMatRate());
        dbEntity.setMaturityCymd(csvEntity.getMaturityCymd());
        dbEntity.setNewSecType(csvEntity.getNewSecType());
        dbEntity.setSortGroupCode(csvEntity.getSortGroupCode());
        dbEntity.setSortAlphaKey(csvEntity.getSortAlphaKey());
        dbEntity.setBranch(csvEntity.getBranch());
        dbEntity.setReptAvgTrdPrx(csvEntity.getReptAvgTrdPrx());
        dbEntity.setSecVarRateCode(csvEntity.getSecVarRateCode());
        dbEntity.setSkipHandleInd(csvEntity.getSkipHandleInd());
        dbEntity.setContraSubNo(csvEntity.getContraSubNo());
        dbEntity.setMemoInvIntAmt(csvEntity.getMemoInvIntAmt());
        dbEntity.setInternalUid(csvEntity.getInternalUid());
        dbEntity.setInternalRid(csvEntity.getInternalRid());
        dbEntity.setTrailerRid(csvEntity.getTrailerRid());
        dbEntity.setInternalAid(csvEntity.getInternalAid());
        dbEntity.setInternalOid(csvEntity.getInternalOid());
        dbEntity.setPfdIntAmt(csvEntity.getPfdIntAmt());
        dbEntity.setTpdInd(csvEntity.getTpdInd());
        dbEntity.setAppTypeCode(csvEntity.getAppTypeCode());
        dbEntity.setSpclTypeNewCode(csvEntity.getSpclTypeNewCode());
        dbEntity.setSpclTypeNewCode2(csvEntity.getSpclTypeNewCode2());
        dbEntity.setSpclTypeNewCode3(csvEntity.getSpclTypeNewCode3());
        dbEntity.setSpclTypeNewCode4(csvEntity.getSpclTypeNewCode4());
        dbEntity.setSpclTypeNewCode5(csvEntity.getSpclTypeNewCode5());
        dbEntity.setSecFeeAmtInd(csvEntity.getSecFeeAmtInd());
        dbEntity.setLalAmtInd(csvEntity.getLalAmtInd());
        dbEntity.setBasisInd(csvEntity.getBasisInd());
        dbEntity.setFactorInd(csvEntity.getFactorInd());
        dbEntity.setHandleAmtInd(csvEntity.getHandleAmtInd());
        dbEntity.setExpGrossInd(csvEntity.getExpGrossInd());
        dbEntity.setCommCpsInd(csvEntity.getCommCpsInd());
        dbEntity.setCommDiscInd(csvEntity.getCommDiscInd());
        dbEntity.setPostageAmtInd(csvEntity.getPostageAmtInd());
        dbEntity.setStateTax2AmtInd(csvEntity.getStateTax2AmtInd());
        dbEntity.setSortAcctNo(csvEntity.getSortAcctNo());
        dbEntity.setWireCode(csvEntity.getWireCode());
        dbEntity.setWireSeqNo(csvEntity.getWireSeqNo());
        dbEntity.setCrippleInd(csvEntity.getCrippleInd());
        dbEntity.setFullCommAmt(csvEntity.getFullCommAmt());
        dbEntity.setTotalFullOrdCommAmt(csvEntity.getTotalFullOrdCommAmt());
        dbEntity.setAccrUnitIntQty(csvEntity.getAccrUnitIntQty());
        dbEntity.setEstParValueAmt(csvEntity.getEstParValueAmt());
        dbEntity.setCurrentYldAmt(csvEntity.getCurrentYldAmt());
        dbEntity.setEstLongTermYldRate(csvEntity.getEstLongTermYldRate());
        dbEntity.setAsofMktValueAmt(csvEntity.getAsofMktValueAmt());
        dbEntity.setPayoutCode(csvEntity.getPayoutCode());
        dbEntity.setNsccCtrlId(csvEntity.getNsccCtrlId());
        dbEntity.setTmktExpPrx(csvEntity.getTmktExpPrx());
        dbEntity.setTstExpPrx(csvEntity.getTstExpPrx());
        dbEntity.setShortSaleReviewCode(csvEntity.getShortSaleReviewCode());
        dbEntity.setInvestorCode(csvEntity.getInvestorCode());
        dbEntity.setOatsOtcExchCode(csvEntity.getOatsOtcExchCode());
        dbEntity.setSpclTypeCode4(csvEntity.getSpclTypeCode4());
        dbEntity.setSpclTypeCode5(csvEntity.getSpclTypeCode5());
        dbEntity.setTtrailerInd(csvEntity.getTtrailerInd());
        dbEntity.setCurrentVaryRate(csvEntity.getCurrentVaryRate());
        dbEntity.setMultExchInd(csvEntity.getMultExchInd());
        dbEntity.setTawayMarket(csvEntity.getTawayMarket());
        dbEntity.setPptOverrideInd(csvEntity.getPptOverrideInd());
        dbEntity.setInputSrceCode(csvEntity.getInputSrceCode());
        dbEntity.setPutCallInd(csvEntity.getPutCallInd());
        dbEntity.setOsiUlSymbol(csvEntity.getOsiUlSymbol());
        dbEntity.setExpireCymd(csvEntity.getExpireCymd());
        dbEntity.setSecStrikePrx(csvEntity.getSecStrikePrx());
        dbEntity.setMultCapacityInd(csvEntity.getMultCapacityInd());
        dbEntity.setRepoHoldInd(csvEntity.getRepoHoldInd());
        dbEntity.setTraceSymbol(csvEntity.getTraceSymbol());
        dbEntity.setAcctMktValueAmt(csvEntity.getAcctMktValueAmt());
        dbEntity.setOptionRegFeeAmt(csvEntity.getOptionRegFeeAmt());
        dbEntity.setNetworkMatrixCode(csvEntity.getNetworkMatrixCode());
        dbEntity.setMarginCode(csvEntity.getMarginCode());
        dbEntity.setLargeTrderId(csvEntity.getLargeTrderId());
        dbEntity.setNonListedCode(csvEntity.getNonListedCode());
        dbEntity.setMinPrxVarCode(csvEntity.getMinPrxVarCode());
        dbEntity.setTbasisFeatCode(csvEntity.getTbasisFeatCode());
        dbEntity.setTbasisFeatCymd(csvEntity.getTbasisFeatCymd());
        dbEntity.setTbasisFeatPrice(csvEntity.getTbasisFeatPrice());
        dbEntity.setTbasisFeatCode2(csvEntity.getTbasisFeatCode2());
        dbEntity.setTbasisFeatCymd2(csvEntity.getTbasisFeatCymd2());
        dbEntity.setTbasisYield2(csvEntity.getTbasisYield2());
        dbEntity.setTbasisFeatPrice2(csvEntity.getTbasisFeatPrice2());
        dbEntity.setTenterFirmMpid(csvEntity.getTenterFirmMpid());
        dbEntity.setExchCode(csvEntity.getExchCode());
        dbEntity.setPfdIntNotInclAmt(csvEntity.getPfdIntNotInclAmt());
        dbEntity.setRebalanceInd(csvEntity.getRebalanceInd());
        dbEntity.setTraceReportInd(csvEntity.getTraceReportInd());
        dbEntity.setTraceModCode(csvEntity.getTraceModCode());
        dbEntity.setTraceModCode2(csvEntity.getTraceModCode2());
        dbEntity.setTraceModCode3(csvEntity.getTraceModCode3());
        dbEntity.setTraceModCode4(csvEntity.getTraceModCode4());
        dbEntity.setAlBreakptLvl(csvEntity.getAlBreakptLvl());
        dbEntity.setEmbeddCommDisc(csvEntity.getEmbeddCommDisc());
        dbEntity.setEmbeddCommDiscCode(csvEntity.getEmbeddCommDiscCode());
        dbEntity.setTransInd(csvEntity.getTransInd());
        dbEntity.setTradeFee(csvEntity.getTradeFee());
        dbEntity.setUsdConvRate(csvEntity.getUsdConvRate());
        dbEntity.setUsdEquivalent(csvEntity.getUsdEquivalent());
        dbEntity.setCxExchRate(csvEntity.getCxExchRate());
        dbEntity.setCxInd(csvEntity.getCxInd());
        dbEntity.setPrevailMktPrx(csvEntity.getPrevailMktPrx());
        dbEntity.setMarkUpdnAmt(csvEntity.getMarkUpdnAmt());
        dbEntity.setMarkUpdnAmtInd(csvEntity.getMarkUpdnAmtInd());
        dbEntity.setMarkUpdnPct(csvEntity.getMarkUpdnPct());
        dbEntity.setMarkUpdnPctInd(csvEntity.getMarkUpdnPctInd());
        dbEntity.setExecTimestamp(csvEntity.getExecTimestamp());
        dbEntity.setPriorRefPointTs(csvEntity.getPriorRefPointTs());
        dbEntity.setOatsAssocOrdInd(csvEntity.getOatsAssocOrdInd());
        dbEntity.setWaterfallLevel(csvEntity.getWaterfallLevel());
        dbEntity.setCatReportInd(csvEntity.getCatReportInd());

        return dbEntity; }

    public static StageRitPos getFromFileToDb(RitPosCsvBean csvEntity) {
        var dbEntity  = new StageRitPos();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setTOrS(csvEntity.gettOrS());
        dbEntity.setFileCode(csvEntity.getFileCode());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setCurrSeq(csvEntity.getCurrSeq());
        dbEntity.setTypeCode(csvEntity.getTypeCode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setTranCymd(csvEntity.getTranCymd());
        dbEntity.setAsofCymd(csvEntity.getAsofCymd());
        dbEntity.setSettleCymd(csvEntity.getSettleCymd());
        dbEntity.setGroupField(csvEntity.getGroupField());
        dbEntity.setItem(csvEntity.getItem());
        dbEntity.setBgnQty(csvEntity.getBgnQty());
        dbEntity.setBgnVal(csvEntity.getBgnVal());
        dbEntity.setBgnGross(csvEntity.getBgnGross());
        dbEntity.setBgnPL(csvEntity.getBgnPL());
        dbEntity.setBgnInt(csvEntity.getBgnInt());
        dbEntity.setBgnUrPL(csvEntity.getBgnUrPL());
        dbEntity.setBgnAccrInt(csvEntity.getBgnAccrInt());
        dbEntity.setYstQty(csvEntity.getYstQty());
        dbEntity.setYstVal(csvEntity.getYstVal());
        dbEntity.setYstGross(csvEntity.getYstGross());
        dbEntity.setYstPL(csvEntity.getYstPL());
        dbEntity.setYstInt(csvEntity.getYstInt());
        dbEntity.setYstUrPL(csvEntity.getYstUrPL());
        dbEntity.setYstAccrInt(csvEntity.getYstAccrInt());
        dbEntity.setTdyQty(csvEntity.getTdyQty());
        dbEntity.setTdyVal(csvEntity.getTdyVal());
        dbEntity.setTdyGross(csvEntity.getTdyGross());
        dbEntity.setTdyPL(csvEntity.getTdyPL());
        dbEntity.setTdyInt(csvEntity.getTdyInt());
        dbEntity.setTdyUrPL(csvEntity.getTdyUrPL());
        dbEntity.setTdyAccrInt(csvEntity.getTdyAccrInt());
        dbEntity.setCurQty(csvEntity.getCurQty());
        dbEntity.setCurVal(csvEntity.getCurVal());
        dbEntity.setCurGross(csvEntity.getCurGross());
        dbEntity.setCurPL(csvEntity.getCurPL());
        dbEntity.setCurInt(csvEntity.getCurInt());
        dbEntity.setCurUrPL(csvEntity.getCurUrPL());
        dbEntity.setCurAccrInt(csvEntity.getCurAccrInt());
        dbEntity.setMktPrice(csvEntity.getMktPrice());
        dbEntity.setMktValue(csvEntity.getMktValue());
        dbEntity.setLastActiveCymd(csvEntity.getLastActiveCymd());
        dbEntity.setSubSystem(csvEntity.getSubSystem());
        dbEntity.setBegUrPL(csvEntity.getBegUrPL());
        dbEntity.setPaydownPL(csvEntity.getPaydownPL());
        dbEntity.setPaydown(csvEntity.getPaydown());
        dbEntity.setBasisPtTotal(csvEntity.getBasisPtTotal());
        dbEntity.setAvgDays(csvEntity.getAvgDays());
        dbEntity.setSortGroup(csvEntity.getSortGroup());
        dbEntity.setSortItem(csvEntity.getSortItem());
        dbEntity.setMaturityCymd(csvEntity.getMaturityCymd());
        dbEntity.setOrigMktPrice(csvEntity.getOrigMktPrice());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setMarkProfLoss(csvEntity.getMarkProfLoss());
        dbEntity.setOldestCymd(csvEntity.getOldestCymd());

        return dbEntity; }

    public static StageSecOsi getFromFileToDb(SecOsiCsvBean csvEntity) {
        var dbEntity  = new StageSecOsi();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setAlphaKey(csvEntity.getAlphaKey());
        dbEntity.setAlphaKey2(csvEntity.getAlphaKey2());
        dbEntity.setAlphaKey5(csvEntity.getAlphaKey5());
        dbEntity.setDesc1(csvEntity.getDesc1());
        dbEntity.setDesc2(csvEntity.getDesc2());
        dbEntity.setDesc3(csvEntity.getDesc3());
        dbEntity.setSecType(csvEntity.getSecType());
        dbEntity.setLastClosePrx(csvEntity.getLastClosePrx());
        dbEntity.setPrxChangeCymd(csvEntity.getPrxChangeCymd());
        dbEntity.setPrxChangeTerm(csvEntity.getPrxChangeTerm());
        dbEntity.setMonthEndPrx(csvEntity.getMonthEndPrx());
        dbEntity.setMonthEndPrxCymd(csvEntity.getMonthEndPrxCymd());
        dbEntity.setMonthEndTerm(csvEntity.getMonthEndTerm());
        dbEntity.setYearEndPrx(csvEntity.getYearEndPrx());
        dbEntity.setYearEndCymd(csvEntity.getYearEndCymd());
        dbEntity.setEoyPrxTerm(csvEntity.getEoyPrxTerm());
        dbEntity.setDescChangeCymd(csvEntity.getDescChangeCymd());
        dbEntity.setChangeTerm(csvEntity.getChangeTerm());
        dbEntity.setAddCymd(csvEntity.getAddCymd());
        dbEntity.setAddTerm(csvEntity.getAddTerm());
        dbEntity.setNoCusipInd(csvEntity.getNoCusipInd());
        dbEntity.setExpSymbolDesc(csvEntity.getExpSymbolDesc());
        dbEntity.setMinPrxVarCode(csvEntity.getMinPrxVarCode());
        dbEntity.setAnnualDivRate(csvEntity.getAnnualDivRate());
        dbEntity.setDrsEligCode(csvEntity.getDrsEligCode());
        dbEntity.setDayCountCode(csvEntity.getDayCountCode());
        dbEntity.setCatchupInd(csvEntity.getCatchupInd());
        dbEntity.setArbConvFactor(csvEntity.getArbConvFactor());
        dbEntity.setIndustryGrpNo(csvEntity.getIndustryGrpNo());
        dbEntity.setRoundLotQty(csvEntity.getRoundLotQty());
        dbEntity.setOatsOtcExchCode(csvEntity.getOatsOtcExchCode());
        dbEntity.setEarningsPerShrAmt(csvEntity.getEarningsPerShrAmt());
        dbEntity.setSecNote(csvEntity.getSecNote());
        dbEntity.setSecNote2(csvEntity.getSecNote2());
        dbEntity.setMullerCymd(csvEntity.getMullerCymd());
        dbEntity.setMullerQty(csvEntity.getMullerQty());
        dbEntity.setNonListedCode(csvEntity.getNonListedCode());
        dbEntity.setFedTaxCode(csvEntity.getFedTaxCode());
        dbEntity.setBondFactor(csvEntity.getBondFactor());
        dbEntity.setSandpCode(csvEntity.getSandpCode());
        dbEntity.setCallBondsCode(csvEntity.getCallBondsCode());
        dbEntity.setDayCalcCode(csvEntity.getDayCalcCode());
        dbEntity.setBondTypeCode(csvEntity.getBondTypeCode());
        dbEntity.setFeatureCymd(csvEntity.getFeatureCymd());
        dbEntity.setFeaturePrx(csvEntity.getFeaturePrx());
        dbEntity.setFeatureCymd2(csvEntity.getFeatureCymd2());
        dbEntity.setFeaturePrx2(csvEntity.getFeaturePrx2());
        dbEntity.setPutCymd(csvEntity.getPutCymd());
        dbEntity.setPrefCymd(csvEntity.getPrefCymd());
        dbEntity.setPutPrx(csvEntity.getPutPrx());
        dbEntity.setPrerefundPrx(csvEntity.getPrerefundPrx());
        dbEntity.setStateCode(csvEntity.getStateCode());
        dbEntity.setIntPmtCymd(csvEntity.getIntPmtCymd());
        dbEntity.setMaturityExpCymd(csvEntity.getMaturityExpCymd());
        dbEntity.setCouponRate(csvEntity.getCouponRate());
        dbEntity.setFirstCpnCymd(csvEntity.getFirstCpnCymd());
        dbEntity.setIntAccrualCymd(csvEntity.getIntAccrualCymd());
        dbEntity.setKisInd(csvEntity.getKisInd());
        dbEntity.setKisCymd(csvEntity.getKisCymd());
        dbEntity.setPrcCymd(csvEntity.getPrcCymd());
        dbEntity.setFrcCymd(csvEntity.getFrcCymd());
        dbEntity.setFactorCymd(csvEntity.getFactorCymd());
        dbEntity.setCurrentFactor(csvEntity.getCurrentFactor());
        dbEntity.setPrevFactor(csvEntity.getPrevFactor());
        dbEntity.setIssueDiscCode(csvEntity.getIssueDiscCode());
        dbEntity.setPutNotifyDays(csvEntity.getPutNotifyDays());
        dbEntity.setSkipKennyInd(csvEntity.getSkipKennyInd());
        dbEntity.setYearEndRptCode(csvEntity.getYearEndRptCode());
        dbEntity.setCmoAgentCode(csvEntity.getCmoAgentCode());
        dbEntity.setBondSubCode(csvEntity.getBondSubCode());
        dbEntity.setSpecificPoolCode(csvEntity.getSpecificPoolCode());
        dbEntity.setRannUpdSrcInd(csvEntity.getRannUpdSrcInd());
        dbEntity.setRannUpdCymd(csvEntity.getRannUpdCymd());
        dbEntity.setLastFriMeCymd(csvEntity.getLastFriMeCymd());
        dbEntity.setLastFriMePrx(csvEntity.getLastFriMePrx());
        dbEntity.setIpoPrx(csvEntity.getIpoPrx());
        dbEntity.setTaxQualInd(csvEntity.getTaxQualInd());
        dbEntity.setForeignSedolNo(csvEntity.getForeignSedolNo());
        dbEntity.setTypeClassCode(csvEntity.getTypeClassCode());
        dbEntity.setUitAccruedAmt(csvEntity.getUitAccruedAmt());
        dbEntity.setExpireCymd(csvEntity.getExpireCymd());
        dbEntity.setOptnCode(csvEntity.getOptnCode());
        dbEntity.setUnderlyingSecNo(csvEntity.getUnderlyingSecNo());
        dbEntity.setStrikePrx(csvEntity.getStrikePrx());
        dbEntity.setWholeConvFactor(csvEntity.getWholeConvFactor());
        dbEntity.setDecConvFactor(csvEntity.getDecConvFactor());
        dbEntity.setUnderlyingOptSecNo(csvEntity.getUnderlyingOptSecNo());
        dbEntity.setCapIntervalNo(csvEntity.getCapIntervalNo());
        dbEntity.setDtcFracCusip(csvEntity.getDtcFracCusip());
        dbEntity.setCcsCode(csvEntity.getCcsCode());
        dbEntity.setNccCode(csvEntity.getNccCode());
        dbEntity.setHandFigInd(csvEntity.getHandFigInd());
        dbEntity.setFlatCode(csvEntity.getFlatCode());
        dbEntity.setDivPayFreqCode(csvEntity.getDivPayFreqCode());
        dbEntity.setRgstCode(csvEntity.getRgstCode());
        dbEntity.setDtcChillDepositInd(csvEntity.getDtcChillDepositInd());
        dbEntity.setDtcChillInd(csvEntity.getDtcChillInd());
        dbEntity.setDtcChillWtInd(csvEntity.getDtcChillWtInd());
        dbEntity.setDtcChillDoInd(csvEntity.getDtcChillDoInd());
        dbEntity.setDtcChillPledgeInd(csvEntity.getDtcChillPledgeInd());
        dbEntity.setDtcChillSegInd(csvEntity.getDtcChillSegInd());
        dbEntity.setDtcFrozenInd(csvEntity.getDtcFrozenInd());
        dbEntity.setForeignCode(csvEntity.getForeignCode());
        dbEntity.setMstrLimitPartnerInd(csvEntity.getMstrLimitPartnerInd());
        dbEntity.setNraExemptInd(csvEntity.getNraExemptInd());
        dbEntity.setDtcFedFundInd(csvEntity.getDtcFedFundInd());
        dbEntity.setMarginCode(csvEntity.getMarginCode());
        dbEntity.setProsEndCymd(csvEntity.getProsEndCymd());
        dbEntity.setUnitQty(csvEntity.getUnitQty());
        dbEntity.setMbsccCode(csvEntity.getMbsccCode());
        dbEntity.setReinvestEligInd(csvEntity.getReinvestEligInd());
        dbEntity.setBidPrx(csvEntity.getBidPrx());
        dbEntity.setAskPrx(csvEntity.getAskPrx());
        dbEntity.setCrncyCode(csvEntity.getCrncyCode());
        dbEntity.setCrncyType(csvEntity.getCrncyType());
        dbEntity.setEuroclrId(csvEntity.getEuroclrId());
        dbEntity.setReissueCymd(csvEntity.getReissueCymd());
        dbEntity.setLastDivRate(csvEntity.getLastDivRate());
        dbEntity.setLastDivCymd(csvEntity.getLastDivCymd());
        dbEntity.setDivPaymentsQty(csvEntity.getDivPaymentsQty());
        dbEntity.setCrncySecNo(csvEntity.getCrncySecNo());
        dbEntity.setCountryCode(csvEntity.getCountryCode());
        dbEntity.setDeferedSalesInd(csvEntity.getDeferedSalesInd());
        dbEntity.setGovProcCode(csvEntity.getGovProcCode());
        dbEntity.setBuildBondInd(csvEntity.getBuildBondInd());
        dbEntity.setFundCode(csvEntity.getFundCode());
        dbEntity.setMoodysCode(csvEntity.getMoodysCode());
        dbEntity.setMfShareClassId(csvEntity.getMfShareClassId());
        dbEntity.setVariableRate(csvEntity.getVariableRate());
        dbEntity.setNewSecCode(csvEntity.getNewSecCode());
        dbEntity.setSortGroupCode(csvEntity.getSortGroupCode());
        dbEntity.setSortAlphaKey(csvEntity.getSortAlphaKey());
        dbEntity.setBondRegCode(csvEntity.getBondRegCode());
        dbEntity.setCallFrequencyCode(csvEntity.getCallFrequencyCode());
        dbEntity.setEscrowCode(csvEntity.getEscrowCode());
        dbEntity.setInsuredStatusCode(csvEntity.getInsuredStatusCode());
        dbEntity.setIntPaymentCode(csvEntity.getIntPaymentCode());
        dbEntity.setPartialRedeemCode(csvEntity.getPartialRedeemCode());
        dbEntity.setPutFrequencyCode(csvEntity.getPutFrequencyCode());
        dbEntity.setAdjustableRateCode(csvEntity.getAdjustableRateCode());
        dbEntity.setConvFactorCode(csvEntity.getConvFactorCode());
        dbEntity.setZeroCouponCode(csvEntity.getZeroCouponCode());
        dbEntity.setGuaranteeCode(csvEntity.getGuaranteeCode());
        dbEntity.setNyPostNo(csvEntity.getNyPostNo());
        dbEntity.setNonTransferInd(csvEntity.getNonTransferInd());
        dbEntity.setPutOrCallInd(csvEntity.getPutOrCallInd());
        dbEntity.setOsiUlSymbol(csvEntity.getOsiUlSymbol());
        dbEntity.setExpirationCymd(csvEntity.getExpirationCymd());
        dbEntity.setStrikePrxExp(csvEntity.getStrikePrxExp());
        dbEntity.setTaxlotCoverCymd(csvEntity.getTaxlotCoverCymd());
        dbEntity.setDes2ChangeTerm(csvEntity.getDes2ChangeTerm());

        return dbEntity; }

    public static StageRte getFromFileToDb(RteCsvBean csvEntity) {
        var dbEntity  = new StageRte();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setSymbol(csvEntity.getSymbol());
        dbEntity.setCusip(csvEntity.getCusip());
        dbEntity.setExch1(csvEntity.getExch1());
        dbEntity.setQty1(csvEntity.getQty1());
        dbEntity.setExch2(csvEntity.getExch2());
        dbEntity.setQty2(csvEntity.getQty2());
        dbEntity.setExch3(csvEntity.getExch3());
        dbEntity.setQty3(csvEntity.getQty3());
        dbEntity.setExch4(csvEntity.getExch4());
        dbEntity.setQty4(csvEntity.getQty4());
        dbEntity.setExch5(csvEntity.getExch5());
        dbEntity.setQty5(csvEntity.getQty5());
        dbEntity.setSpecial1(csvEntity.getSpecial1());
        dbEntity.setSpecial2(csvEntity.getSpecial2());
        dbEntity.setSpecial3(csvEntity.getSpecial3());
        dbEntity.setSpecial4(csvEntity.getSpecial4());
        dbEntity.setSpecial5(csvEntity.getSpecial5());
        dbEntity.setTradingRegion(csvEntity.getTradingRegion());
        dbEntity.setPrxSecno(csvEntity.getPrxSecno());
        dbEntity.setPrx(csvEntity.getPrx());
        dbEntity.setPrxCymd(csvEntity.getPrxCymd());
        dbEntity.setPrxInit(csvEntity.getPrxInit());
        dbEntity.setMePrx(csvEntity.getMePrx());
        dbEntity.setMePrxCymd(csvEntity.getMePrxCymd());
        dbEntity.setMePrxInit(csvEntity.getMePrxInit());
        dbEntity.setYePrx(csvEntity.getYePrx());
        dbEntity.setYePrxCymd(csvEntity.getYePrxCymd());
        dbEntity.setYePrxInit(csvEntity.getYePrxInit());
        dbEntity.setChgCymd(csvEntity.getChgCymd());
        dbEntity.setChgInit(csvEntity.getChgInit());
        dbEntity.setFundDealer(csvEntity.getFundDealer());
        dbEntity.setOid(csvEntity.getOid());
        dbEntity.setMoneyAvailSw(csvEntity.getMoneyAvailSw());
        dbEntity.setTrfAgent(csvEntity.getTrfAgent());
        dbEntity.setTrfFee(csvEntity.getTrfFee());
        dbEntity.setTrfState(csvEntity.getTrfState());
        dbEntity.setManualTrf(csvEntity.getManualTrf());
        dbEntity.setNoLoan(csvEntity.getNoLoan());
        dbEntity.setNoAlloc(csvEntity.getNoAlloc());
        dbEntity.setMgnCode(csvEntity.getMgnCode());
        dbEntity.setNrm(csvEntity.getNrm());
        dbEntity.setAutoAppInd(csvEntity.getAutoAppInd());
        dbEntity.setNoTrades(csvEntity.getNoTrades());
        dbEntity.setSyndSymbol(csvEntity.getSyndSymbol());
        dbEntity.setNote(csvEntity.getNote());
        dbEntity.setEstMaturityCymd(csvEntity.getEstMaturityCymd());
        dbEntity.setReorgAppInd(csvEntity.getReorgAppInd());
        dbEntity.setMarketMaker(csvEntity.getMarketMaker());
        dbEntity.setSpecialist(csvEntity.getSpecialist());
        dbEntity.setDirectorSw(csvEntity.getDirectorSw());
        dbEntity.setNoPrintMsrb(csvEntity.getNoPrintMsrb());
        dbEntity.setNoPrintYtm(csvEntity.getNoPrintYtm());
        dbEntity.setController(csvEntity.getController());
        dbEntity.setUserPrx(csvEntity.getUserPrx());
        dbEntity.setProductCode(csvEntity.getProductCode());
        dbEntity.setMfLoc(csvEntity.getMfLoc());
        dbEntity.setBoxType(csvEntity.getBoxType());
        dbEntity.setFsCode(csvEntity.getFsCode());
        dbEntity.setMfboCode(csvEntity.getMfboCode());
        dbEntity.setCurYld(csvEntity.getCurYld());
        dbEntity.setCurYldCymd(csvEntity.getCurYldCymd());
        dbEntity.setEffectiveYld(csvEntity.getEffectiveYld());
        dbEntity.setEffectiveYldCymd(csvEntity.getEffectiveYldCymd());
        dbEntity.setCashDrOverride(csvEntity.getCashDrOverride());
        dbEntity.setDivReinv(csvEntity.getDivReinv());
        dbEntity.setCashFundAcct(csvEntity.getCashFundAcct());
        dbEntity.setCashLoc(csvEntity.getCashLoc());
        dbEntity.setReinvFundAcct(csvEntity.getReinvFundAcct());
        dbEntity.setReinvLoc(csvEntity.getReinvLoc());
        dbEntity.setSdivInd(csvEntity.getSdivInd());
        dbEntity.setBuildDivwsCymd(csvEntity.getBuildDivwsCymd());
        dbEntity.setReinAPrchSw(csvEntity.getReinAPrchSw());
        dbEntity.setLpLoc(csvEntity.getLpLoc());
        dbEntity.setNoFrac(csvEntity.getNoFrac());
        dbEntity.setRteCusip(csvEntity.getRteCusip());
        dbEntity.setNetLevel1(csvEntity.getNetLevel1());
        dbEntity.setNetLevel2(csvEntity.getNetLevel2());
        dbEntity.setNetLevel3(csvEntity.getNetLevel3());
        dbEntity.setNetLevel4(csvEntity.getNetLevel4());
        dbEntity.setXrefOldSecNo(csvEntity.getXrefOldSecNo());
        dbEntity.setXrefNewSecNo(csvEntity.getXrefNewSecNo());
        dbEntity.setBondSubtype(csvEntity.getBondSubtype());
        dbEntity.setFirstTradeCymd(csvEntity.getFirstTradeCymd());
        dbEntity.setPurchOnlySw(csvEntity.getPurchOnlySw());
        dbEntity.setIndGrp(csvEntity.getIndGrp());
        dbEntity.setLvl3RegOverride(csvEntity.getLvl3RegOverride());
        dbEntity.setResearchCode(csvEntity.getResearchCode());
        dbEntity.setNetOrGross(csvEntity.getNetOrGross());
        dbEntity.setSlsCredit(csvEntity.getSlsCredit());
        dbEntity.setVenderPrxReq(csvEntity.getVenderPrxReq());
        dbEntity.setSdCode(csvEntity.getSdCode());
        dbEntity.setIpo1stStlCymd(csvEntity.getIpo1stStlCymd());
        dbEntity.setIpoEndPnltCymd(csvEntity.getIpoEndPnltCymd());
        dbEntity.setQrIo(csvEntity.getQrIo());
        dbEntity.setAcctLvl3Override(csvEntity.getAcctLvl3Override());
        dbEntity.setMfiCode(csvEntity.getMfiCode());
        dbEntity.setOptPositionLimit(csvEntity.getOptPositionLimit());
        dbEntity.setMfCommSw(csvEntity.getMfCommSw());
        dbEntity.setNavrSw(csvEntity.getNavrSw());
        dbEntity.setRotationalRoute(csvEntity.getRotationalRoute());
        dbEntity.setEvd(csvEntity.getEvd());
        dbEntity.setEvs(csvEntity.getEvs());
        dbEntity.setEvm(csvEntity.getEvm());
        dbEntity.setMfNoProspectus(csvEntity.getMfNoProspectus());
        dbEntity.setSecType(csvEntity.getSecType());
        dbEntity.setNewSecType(csvEntity.getNewSecType());
        dbEntity.setDivChgCymd(csvEntity.getDivChgCymd());
        dbEntity.setDivChgInit(csvEntity.getDivChgInit());
        dbEntity.setEstAnnDiv(csvEntity.getEstAnnDiv());
        dbEntity.setFeatures(csvEntity.getFeatures());
        dbEntity.setGics(csvEntity.getGics());
        dbEntity.setNaics(csvEntity.getNaics());
        dbEntity.setOidType(csvEntity.getOidType());
        dbEntity.setTradingStatus(csvEntity.getTradingStatus());
        dbEntity.setUnitSize(csvEntity.getUnitSize());
        dbEntity.setUitWrapInd(csvEntity.getUitWrapInd());
        dbEntity.setWhenIssueDisCode(csvEntity.getWhenIssueDisCode());
        dbEntity.setActionOvrdText(csvEntity.getActionOvrdText());
        dbEntity.setActionOvrdText2(csvEntity.getActionOvrdText2());
        dbEntity.setCorpactWhoCode(csvEntity.getCorpactWhoCode());
        dbEntity.setCorpactCymd(csvEntity.getCorpactCymd());
        dbEntity.setWhenIssuePrx(csvEntity.getWhenIssuePrx());
        dbEntity.setWhenIssueWhoCode(csvEntity.getWhenIssueWhoCode());
        dbEntity.setWhenIssueCymd(csvEntity.getWhenIssueCymd());
        dbEntity.setProspectusEndCymd(csvEntity.getProspectusEndCymd());
        dbEntity.setDivPayMmdd(csvEntity.getDivPayMmdd());
        dbEntity.setSplcDivPayMmdd(csvEntity.getSplcDivPayMmdd());
        dbEntity.setSplcDivFreqCode(csvEntity.getSplcDivFreqCode());
        dbEntity.setChangeTerm(csvEntity.getChangeTerm());
        dbEntity.setChangeSourceId(csvEntity.getChangeSourceId());
        dbEntity.setChangeSource(csvEntity.getChangeSource());
        dbEntity.setPfdSecCpnRate(csvEntity.getPfdSecCpnRate());
        dbEntity.setEffMatCymd(csvEntity.getEffMatCymd());
        dbEntity.setPropProdInd(csvEntity.getPropProdInd());
        dbEntity.setSellAgmtInd(csvEntity.getSellAgmtInd());
        dbEntity.setSecEx(csvEntity.getSecEx());
        dbEntity.setWrap(csvEntity.getWrap());
        dbEntity.setAcretAmortOvrdCd(csvEntity.getAcretAmortOvrdCd());
        dbEntity.setQualDivInd(csvEntity.getQualDivInd());
        dbEntity.setAccesDlvrOrvrInd(csvEntity.getAccesDlvrOrvrInd());
        dbEntity.setFirmProductCode(csvEntity.getFirmProductCode());
        dbEntity.setFracShrLiqInd(csvEntity.getFracShrLiqInd());
        dbEntity.setEuroCalInd(csvEntity.getEuroCalInd());
        dbEntity.setSubIssueOvrdCd(csvEntity.getSubIssueOvrdCd());
        dbEntity.setCpdOvrdInd(csvEntity.getCpdOvrdInd());
        dbEntity.setEtfAddlMarginPct(csvEntity.getEtfAddlMarginPct());
        dbEntity.setFirmSecGroupCd(csvEntity.getFirmSecGroupCd());
        dbEntity.setTaxlotOvrdCoverCymd(csvEntity.getTaxlotOvrdCoverCymd());
        dbEntity.setMutFundPostageInd(csvEntity.getMutFundPostageInd());
        dbEntity.setTrailStopInd(csvEntity.getTrailStopInd());
        dbEntity.setTrailStopWho(csvEntity.getTrailStopWho());
        dbEntity.setTrailStopCymd(csvEntity.getTrailStopCymd());
        dbEntity.setWave10Id(csvEntity.getWave10Id());
        dbEntity.setSettleDateOvrdCode(csvEntity.getSettleDateOvrdCode());
        dbEntity.setSchkInd(csvEntity.getSchkInd());
        dbEntity.setAipEligInd(csvEntity.getAipEligInd());
        dbEntity.setAvgcInd(csvEntity.getAvgcInd());
        dbEntity.setSensitiveCode(csvEntity.getSensitiveCode());
        dbEntity.setMgnOvrdCode(csvEntity.getMgnOvrdCode());
        dbEntity.setFatcaOvrdCode(csvEntity.getFatcaOvrdCode());
        dbEntity.setPrefAccruedInd(csvEntity.getPrefAccruedInd());
        dbEntity.setRevManRate(csvEntity.getRevManRate());

        return dbEntity; }

    public static StageTaxl getFromFileToDb(TaxlCsvBean csvEntity) {
        var dbEntity  = new StageTaxl();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setAcctNo(csvEntity.getAcctNo());
        dbEntity.setSecNo(csvEntity.getSecNo());
        dbEntity.setOpenTaxLotId(csvEntity.getOpenTaxLotId());
        dbEntity.setCloseTaxLotId(csvEntity.getCloseTaxLotId());
        dbEntity.setOpenCloseInd(csvEntity.getOpenCloseInd());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setAddTms(csvEntity.getAddTms());
        dbEntity.setAddUserId(csvEntity.getAddUserId());
        dbEntity.setAddWhoCode(csvEntity.getAddWhoCode());
        dbEntity.setAddTerm(csvEntity.getAddTerm());
        dbEntity.setChangeUserTms(csvEntity.getChangeUserTms());
        dbEntity.setChangeSysTms(csvEntity.getChangeSysTms());
        dbEntity.setChangeUserWhoCode(csvEntity.getChangeUserWhoCode());
        dbEntity.setChangeUserTerm(csvEntity.getChangeUserTerm());
        dbEntity.setChangeUserId(csvEntity.getChangeUserId());
        dbEntity.setChangeSysJobId(csvEntity.getChangeSysJobId());
        dbEntity.setChangeSysProgrmId(csvEntity.getChangeSysProgrmId());
        dbEntity.setTaxLotQty(csvEntity.getTaxLotQty());
        dbEntity.setHeldAwayInd(csvEntity.getHeldAwayInd());
        dbEntity.setRepoTranInd(csvEntity.getRepoTranInd());
        dbEntity.setRepoReverseInd(csvEntity.getRepoReverseInd());
        dbEntity.setLevel4Ind(csvEntity.getLevel4Ind());
        dbEntity.setAnnuityPstnInd(csvEntity.getAnnuityPstnInd());
        dbEntity.setAcatCbrsInd(csvEntity.getAcatCbrsInd());
        dbEntity.setAcctType(csvEntity.getAcctType());
        dbEntity.setControlNo(csvEntity.getControlNo());
        dbEntity.setApplyPrincipalUitInd(csvEntity.getApplyPrincipalUitInd());
        dbEntity.setApplyPrincipalMlpInd(csvEntity.getApplyPrincipalMlpInd());
        dbEntity.setApplyLiquidationInd(csvEntity.getApplyLiquidationInd());
        dbEntity.setApplyFactorInd(csvEntity.getApplyFactorInd());
        dbEntity.setApplyOidInd(csvEntity.getApplyOidInd());
        dbEntity.setOptnProceedAmt(csvEntity.getOptnProceedAmt());
        dbEntity.setPaydownAmt(csvEntity.getPaydownAmt());
        dbEntity.setLiquidationAmt(csvEntity.getLiquidationAmt());
        dbEntity.setOidAccruedAmt(csvEntity.getOidAccruedAmt());
        dbEntity.setCrncyType(csvEntity.getCrncyType());
        dbEntity.setAutoTradeCode(csvEntity.getAutoTradeCode());
        dbEntity.setYieldRate(csvEntity.getYieldRate());
        dbEntity.setYieldCode(csvEntity.getYieldCode());
        dbEntity.setYieldOvrdCode(csvEntity.getYieldOvrdCode());
        dbEntity.setOidYieldMaturityRate(csvEntity.getOidYieldMaturityRate());
        dbEntity.setAddlUserDesc(csvEntity.getAddlUserDesc());
        dbEntity.setOrderNo(csvEntity.getOrderNo());
        dbEntity.setAnnuityContractId(csvEntity.getAnnuityContractId());
        dbEntity.setAdjBasisInd(csvEntity.getAdjBasisInd());
        dbEntity.setOpenCymd(csvEntity.getOpenCymd());
        dbEntity.setOpenSrceCode(csvEntity.getOpenSrceCode());
        dbEntity.setLastActivSrceCode(csvEntity.getLastActivSrceCode());
        dbEntity.setLastActivSrceCodeAdjSw(csvEntity.getLastActivSrceCodeAdjSw());
        dbEntity.setOpenEntryFrozenInd(csvEntity.getOpenEntryFrozenInd());
        dbEntity.setOpenSrceCodeAdjInd(csvEntity.getOpenSrceCodeAdjInd());
        dbEntity.setNoOpenCostInd(csvEntity.getNoOpenCostInd());
        dbEntity.setOpenCostAmt(csvEntity.getOpenCostAmt());
        dbEntity.setNoOpenPriceInd(csvEntity.getNoOpenPriceInd());
        dbEntity.setOpenPrx(csvEntity.getOpenPrx());
        dbEntity.setNoOpenFactorInd(csvEntity.getNoOpenFactorInd());
        dbEntity.setOpenFactor(csvEntity.getOpenFactor());
        dbEntity.setPendDistInd(csvEntity.getPendDistInd());
        dbEntity.setOpenAdjCostAmt(csvEntity.getOpenAdjCostAmt());
        dbEntity.setOpenMktAmt(csvEntity.getOpenMktAmt());
        dbEntity.setUnrealizedGainLossAmt(csvEntity.getUnrealizedGainLossAmt());
        dbEntity.setOpenGainLossTermInd(csvEntity.getOpenGainLossTermInd());
        dbEntity.setDailyAccretionRate(csvEntity.getDailyAccretionRate());
        dbEntity.setDailyAmortRate(csvEntity.getDailyAmortRate());
        dbEntity.setOpenSettleCymd(csvEntity.getOpenSettleCymd());
        dbEntity.setCloseCymd(csvEntity.getCloseCymd());
        dbEntity.setCloseSrceCode(csvEntity.getCloseSrceCode());
        dbEntity.setCloseAdjSrceCodeInd(csvEntity.getCloseAdjSrceCodeInd());
        dbEntity.setDescField(csvEntity.getDescField());
        dbEntity.setNoCloseCostInd(csvEntity.getNoCloseCostInd());
        dbEntity.setCloseCostAmt(csvEntity.getCloseCostAmt());
        dbEntity.setNoClosePriceInd(csvEntity.getNoClosePriceInd());
        dbEntity.setClosePrx(csvEntity.getClosePrx());
        dbEntity.setNoCloseFactorInd(csvEntity.getNoCloseFactorInd());
        dbEntity.setCloseFactor(csvEntity.getCloseFactor());
        dbEntity.setCloseAdjCostAmt(csvEntity.getCloseAdjCostAmt());
        dbEntity.setNoStkRecPosInd(csvEntity.getNoStkRecPosInd());
        dbEntity.setSaleByTaxLotInd(csvEntity.getSaleByTaxLotInd());
        dbEntity.setBoxCymd(csvEntity.getBoxCymd());
        dbEntity.setSuppressTaxLotInd(csvEntity.getSuppressTaxLotInd());
        dbEntity.setRealizedGainLossAmt(csvEntity.getRealizedGainLossAmt());
        dbEntity.setCloseGainLossTermCode(csvEntity.getCloseGainLossTermCode());
        dbEntity.setCloseEntryFrozenInd(csvEntity.getCloseEntryFrozenInd());
        dbEntity.setCloseSettleCymd(csvEntity.getCloseSettleCymd());
        dbEntity.setUserXrefId(csvEntity.getUserXrefId());
        dbEntity.setAddTransCymd(csvEntity.getAddTransCymd());
        dbEntity.setAddJobId(csvEntity.getAddJobId());
        dbEntity.setDeMinimisInd(csvEntity.getDeMinimisInd());
        dbEntity.setOidErrorInd(csvEntity.getOidErrorInd());
        dbEntity.setAmortAmt(csvEntity.getAmortAmt());
        dbEntity.setSysChgTranCymd(csvEntity.getSysChgTranCymd());
        dbEntity.setUserChgTranCymd(csvEntity.getUserChgTranCymd());
        dbEntity.setMktYldMatRate(csvEntity.getMktYldMatRate());
        dbEntity.setMktDiffId(csvEntity.getMktDiffId());
        dbEntity.setAcquisitionAccretedAmt(csvEntity.getAcquisitionAccretedAmt());
        dbEntity.setTaxLotId(csvEntity.getTaxLotId());
        dbEntity.setPrevInd(csvEntity.getPrevInd());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setAdjGainLossAmt(csvEntity.getAdjGainLossAmt());
        dbEntity.setAdjPrx(csvEntity.getAdjPrx());
        dbEntity.setCostAllocCode(csvEntity.getCostAllocCode());
        dbEntity.setAvgPrx(csvEntity.getAvgPrx());
        dbEntity.setWashSaleAmt(csvEntity.getWashSaleAmt());
        dbEntity.setUndstLtrmCapAmt(csvEntity.getUndstLtrmCapAmt());
        dbEntity.setTaxLotCoverInd(csvEntity.getTaxLotCoverInd());
        dbEntity.setTaxLotXferCymd(csvEntity.getTaxLotXferCymd());
        dbEntity.setCbrsDlvrCtrlNo(csvEntity.getCbrsDlvrCtrlNo());
        dbEntity.setCbrsRecvCtrlNo(csvEntity.getCbrsRecvCtrlNo());
        dbEntity.setCbrsAltCtrlNo(csvEntity.getCbrsAltCtrlNo());
        dbEntity.setRecvCbrsParticNo(csvEntity.getRecvCbrsParticNo());
        dbEntity.setDlvrCbrsParticNo(csvEntity.getDlvrCbrsParticNo());
        dbEntity.setCertNo(csvEntity.getCertNo());
        dbEntity.setGainLossAmtKnownInd(csvEntity.getGainLossAmtKnownInd());
        dbEntity.setTaxLotOpenXferCode(csvEntity.getTaxLotOpenXferCode());
        dbEntity.setTaxLotOpenFmvAmt(csvEntity.getTaxLotOpenFmvAmt());
        dbEntity.setOpenWashSaleCymd(csvEntity.getOpenWashSaleCymd());
        dbEntity.setTaxLotCloseXferCode(csvEntity.getTaxLotCloseXferCode());
        dbEntity.setTaxLotCloseFmvAmt(csvEntity.getTaxLotCloseFmvAmt());
        dbEntity.setCloseWashSaleCymd(csvEntity.getCloseWashSaleCymd());
        dbEntity.setAtdUniqueKey(csvEntity.getAtdUniqueKey());
        dbEntity.setStlossToLtlossAmt(csvEntity.getStlossToLtlossAmt());
        dbEntity.setTaxlAvgCostCode(csvEntity.getTaxlAvgCostCode());
        dbEntity.setTaxlDrpInd(csvEntity.getTaxlDrpInd());
        dbEntity.setOpenAvgCostAmt(csvEntity.getOpenAvgCostAmt());
        dbEntity.setClosDisallowLossAmt(csvEntity.getClosDisallowLossAmt());
        dbEntity.setNoOrigOpenCostInd(csvEntity.getNoOrigOpenCostInd());
        dbEntity.setClosOrigOpenCostAmt(csvEntity.getClosOrigOpenCostAmt());
        dbEntity.setClosOptProcAmt(csvEntity.getClosOptProcAmt());
        dbEntity.setClosFirmLvl4Ind(csvEntity.getClosFirmLvl4Ind());
        dbEntity.setHoldStartCymd(csvEntity.getHoldStartCymd());
        dbEntity.setHoldingPeriodDays(csvEntity.getHoldingPeriodDays());
        dbEntity.setFromAcctNoJnl(csvEntity.getFromAcctNoJnl());
        dbEntity.setToAcctNoJnl(csvEntity.getToAcctNoJnl());
        dbEntity.setCbSetupInd(csvEntity.getCbSetupInd());
        dbEntity.setXchgRateFmv(csvEntity.getXchgRateFmv());
        dbEntity.setAdjIssuePrx(csvEntity.getAdjIssuePrx());
        dbEntity.setAcqPremAmt(csvEntity.getAcqPremAmt());
        dbEntity.setMktDiscAmt(csvEntity.getMktDiscAmt());
        dbEntity.setMktDiscCalcCode(csvEntity.getMktDiscCalcCode());
        dbEntity.setOidTaxableInd(csvEntity.getOidTaxableInd());
        dbEntity.setPremAmortInd(csvEntity.getPremAmortInd());
        dbEntity.setMktDiscAccretInd(csvEntity.getMktDiscAccretInd());
        dbEntity.setSpotRateInd(csvEntity.getSpotRateInd());
        dbEntity.setAcatAdjCostAmt(csvEntity.getAcatAdjCostAmt());
        dbEntity.setAcatChangeCymd(csvEntity.getAcatChangeCymd());
        dbEntity.setCalcToCymd(csvEntity.getCalcToCymd());
        dbEntity.setMktDiscDailyRate(csvEntity.getMktDiscDailyRate());
        dbEntity.setAcqPremDailyRate(csvEntity.getAcqPremDailyRate());
        dbEntity.setCorpActionCode(csvEntity.getCorpActionCode());
        dbEntity.setNoDebtCostInd(csvEntity.getNoDebtCostInd());
        dbEntity.setDebtCostAmt(csvEntity.getDebtCostAmt());
        dbEntity.setDeflationAdjAmt(csvEntity.getDeflationAdjAmt());
        dbEntity.setCpdiNetAdjAmt(csvEntity.getCpdiNetAdjAmt());
        dbEntity.setNqsiDailyRate(csvEntity.getNqsiDailyRate());
        dbEntity.setNqsiTotAmt(csvEntity.getNqsiTotAmt());
        dbEntity.setOrigYield(csvEntity.getOrigYield());
        dbEntity.setPurchYield(csvEntity.getPurchYield());
        dbEntity.setInclusionFrac(csvEntity.getInclusionFrac());

        return dbEntity; }

    public static StageRepBra getFromFileToDb(RepBraCsvBean csvEntity) {
        var dbEntity  = new StageRepBra();
        dbEntity.setProcessStamp(FAKE_PROCESS_STAMP);
        dbEntity.setBaReccode(csvEntity.getBaReccode());
        dbEntity.setSubNo(csvEntity.getSubNo());
        dbEntity.setRepBraCd(csvEntity.getRepBraCd());
        dbEntity.setFirmNo(csvEntity.getFirmNo());
        dbEntity.setEmployeeNo(csvEntity.getEmployeeNo());
        dbEntity.setEmployeeCode(csvEntity.getEmployeeCode());
        dbEntity.setRepBraNameDesc(csvEntity.getRepBraNameDesc());
        dbEntity.setHomePhoneNo(csvEntity.getHomePhoneNo());
        dbEntity.setBusPhoneNo(csvEntity.getBusPhoneNo());
        dbEntity.setConvRep(csvEntity.getConvRep());
        dbEntity.setDepartment(csvEntity.getDepartment());
        dbEntity.setRegion(csvEntity.getRegion());
        dbEntity.setClassField(csvEntity.getClassField());
        dbEntity.setCashDrGl(csvEntity.getCashDrGl());
        dbEntity.setCashDrOvrd(csvEntity.getCashDrOvrd());
        dbEntity.setRegCymd(csvEntity.getRegCymd());
        dbEntity.setPayGroup(csvEntity.getPayGroup());
        dbEntity.setPrtOnCnfrms(csvEntity.getPrtOnCnfrms());
        dbEntity.setPayTerm(csvEntity.getPayTerm());
        dbEntity.setDocRemotePrtSw(csvEntity.getDocRemotePrtSw());
        dbEntity.setField3x5Sets(csvEntity.getField3x5Sets());
        dbEntity.setQtrlyFeeExempt(csvEntity.getQtrlyFeeExempt());
        dbEntity.setMatcallRptSeq(csvEntity.getMatcallRptSeq());
        dbEntity.setDistrAgentCode(csvEntity.getDistrAgentCode());
        dbEntity.setDistrAgentNo(csvEntity.getDistrAgentNo());
        dbEntity.setFieldAgentNo(csvEntity.getFieldAgentNo());
        dbEntity.setGeneralAgentCode(csvEntity.getGeneralAgentCode());
        dbEntity.setGeneralAgentNo(csvEntity.getGeneralAgentNo());
        dbEntity.setRegtMode(csvEntity.getRegtMode());
        dbEntity.setLinkNo(csvEntity.getLinkNo());
        dbEntity.setIsOwnBranchSw(csvEntity.getIsOwnBranchSw());
        dbEntity.setRepBraChgCymd(csvEntity.getRepBraChgCymd());
        dbEntity.setMlMgrSw(csvEntity.getMlMgrSw());
        dbEntity.setInternalGroupNo(csvEntity.getInternalGroupNo());
        dbEntity.setGroupNo(csvEntity.getGroupNo());
        dbEntity.setSendBookInd(csvEntity.getSendBookInd());
        dbEntity.setSendCustInd(csvEntity.getSendCustInd());
        dbEntity.setSendMonyInd(csvEntity.getSendMonyInd());
        dbEntity.setSendPosiInd(csvEntity.getSendPosiInd());
        dbEntity.setSendClosInd(csvEntity.getSendClosInd());
        dbEntity.setBqController(csvEntity.getBqController());
        dbEntity.setBqSession(csvEntity.getBqSession());
        dbEntity.setBqExecMsg(csvEntity.getBqExecMsg());
        dbEntity.setStartCym(csvEntity.getStartCym());
        dbEntity.setStatementLine1(csvEntity.getStatementLine1());
        dbEntity.setStatementLine2(csvEntity.getStatementLine2());
        dbEntity.setStatementLine3(csvEntity.getStatementLine3());
        dbEntity.setRegularPay(csvEntity.getRegularPay());
        dbEntity.setBonusPay(csvEntity.getBonusPay());
        dbEntity.setTotalComm(csvEntity.getTotalComm());
        dbEntity.setBonusComm(csvEntity.getBonusComm());
        dbEntity.setTodayRegularPay(csvEntity.getTodayRegularPay());
        dbEntity.setTodayBonusPay(csvEntity.getTodayBonusPay());
        dbEntity.setTodayTotalComm(csvEntity.getTodayTotalComm());
        dbEntity.setTodayBonusComm(csvEntity.getTodayBonusComm());
        dbEntity.setCommissionLimit(csvEntity.getCommissionLimit());
        dbEntity.setCommEquityLimit(csvEntity.getCommEquityLimit());
        dbEntity.setPctLossLimit(csvEntity.getPctLossLimit());
        dbEntity.setTradesLimit(csvEntity.getTradesLimit());
        dbEntity.setStkSched(csvEntity.getStkSched());
        dbEntity.setBndSched(csvEntity.getBndSched());
        dbEntity.setOptSched(csvEntity.getOptSched());
        dbEntity.setFutSched(csvEntity.getFutSched());
        dbEntity.setPrinterDest(csvEntity.getPrinterDest());
        dbEntity.setAlternatePrinter1(csvEntity.getAlternatePrinter1());
        dbEntity.setAlternatePrinter2(csvEntity.getAlternatePrinter2());
        dbEntity.setAlternatePrinter3(csvEntity.getAlternatePrinter3());
        dbEntity.setPostageAmt(csvEntity.getPostageAmt());
        dbEntity.setNoPostage(csvEntity.getNoPostage());
        dbEntity.setDownloadPos(csvEntity.getDownloadPos());
        dbEntity.setLedgerBreakRep(csvEntity.getLedgerBreakRep());
        dbEntity.setJournalApprSw(csvEntity.getJournalApprSw());
        dbEntity.setAddrLine1(csvEntity.getAddrLine1());
        dbEntity.setAddrLine2(csvEntity.getAddrLine2());
        dbEntity.setAddrLine3(csvEntity.getAddrLine3());
        dbEntity.setAddrLine4(csvEntity.getAddrLine4());
        dbEntity.setSplitRep1(csvEntity.getSplitRep1());
        dbEntity.setSplitPct1(csvEntity.getSplitPct1());
        dbEntity.setSplitRep2(csvEntity.getSplitRep2());
        dbEntity.setSplitPct2(csvEntity.getSplitPct2());
        dbEntity.setSplitRep3(csvEntity.getSplitRep3());
        dbEntity.setSplitPct3(csvEntity.getSplitPct3());
        dbEntity.setSplitRep4(csvEntity.getSplitRep4());
        dbEntity.setSplitPct4(csvEntity.getSplitPct4());
        dbEntity.setSplitRep5(csvEntity.getSplitRep5());
        dbEntity.setSplitPct5(csvEntity.getSplitPct5());
        dbEntity.setSplitRep6(csvEntity.getSplitRep6());
        dbEntity.setSplitPct6(csvEntity.getSplitPct6());
        dbEntity.setSplitRep7(csvEntity.getSplitRep7());
        dbEntity.setSplitPct7(csvEntity.getSplitPct7());
        dbEntity.setSplitRep8(csvEntity.getSplitRep8());
        dbEntity.setSplitPct8(csvEntity.getSplitPct8());
        dbEntity.setSplitRep9(csvEntity.getSplitRep9());
        dbEntity.setSplitPct9(csvEntity.getSplitPct9());
        dbEntity.setSplitRep10(csvEntity.getSplitRep10());
        dbEntity.setSplitPct10(csvEntity.getSplitPct10());
        dbEntity.setRegtLevel1(csvEntity.getRegtLevel1());
        dbEntity.setRegtCharge1(csvEntity.getRegtCharge1());
        dbEntity.setRegtLevel2(csvEntity.getRegtLevel2());
        dbEntity.setRegtCharge2(csvEntity.getRegtCharge2());
        dbEntity.setRegtLevel3(csvEntity.getRegtLevel3());
        dbEntity.setRegtCharge3(csvEntity.getRegtCharge3());
        dbEntity.setRegtLevel4(csvEntity.getRegtLevel4());
        dbEntity.setRegtCharge4(csvEntity.getRegtCharge4());
        dbEntity.setConvOffice(csvEntity.getConvOffice());
        dbEntity.setPostageOvrd(csvEntity.getPostageOvrd());
        dbEntity.setRepReccode(csvEntity.getRepReccode());

        return dbEntity; }





    public static List<StageAct> getFromSchemaActToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageAct> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageAct dbEntity    = EntityTransform.getFromFileToDb((ActCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageActSum> getFromSchemaActSumToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageActSum> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageActSum dbEntity    = EntityTransform.getFromFileToDb((ActSumCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageAdm> getFromSchemaAdmToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageAdm> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageAdm dbEntity    = EntityTransform.getFromFileToDb((AdmCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageAdmExp> getFromSchemaAdmExpToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageAdmExp> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageAdmExp dbEntity    = EntityTransform.getFromFileToDb((AdmExpCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageBal> getFromSchemaBalToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageBal> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageBal dbEntity    = EntityTransform.getFromFileToDb((BalCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageBalAct> getFromSchemaBalActToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageBalAct> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageBalAct dbEntity    = EntityTransform.getFromFileToDb((BalActCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageCsh> getFromSchemaCshToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageCsh> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageCsh dbEntity    = EntityTransform.getFromFileToDb((CshCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageMmfBal> getFromSchemaMmfBalToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageMmfBal> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageMmfBal dbEntity    = EntityTransform.getFromFileToDb((MmfBalCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StagePos> getFromSchemaPosToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StagePos> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StagePos dbEntity    = EntityTransform.getFromFileToDb((PosCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageRad> getFromSchemaRadToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageRad> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageRad dbEntity    = EntityTransform.getFromFileToDb((RadCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageTrdOsi> getFromSchemaTrdOsiToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageTrdOsi> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageTrdOsi dbEntity    = EntityTransform.getFromFileToDb((TrdOsiCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageRitPos> getFromSchemaRitPosToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageRitPos> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageRitPos dbEntity    = EntityTransform.getFromFileToDb((RitPosCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }
    public static List<StageSecOsi> getFromSchemaSecOsiToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageSecOsi> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageSecOsi dbEntity    = EntityTransform.getFromFileToDb((SecOsiCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageRte> getFromSchemaRteToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageRte> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageRte dbEntity    = EntityTransform.getFromFileToDb((RteCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageTaxl> getFromSchemaTaxlToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageTaxl> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageTaxl dbEntity    = EntityTransform.getFromFileToDb((TaxlCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageRepBra> getFromSchemaRepBraToDb(List<CsvBean> csvEntities, String proceesStamp) {
        List<StageRepBra> dbEntities  = new ArrayList<>();
        for (CsvBean csvEntity : csvEntities) {
            StageRepBra dbEntity    = EntityTransform.getFromFileToDb((RepBraCsvBean)csvEntity);
            dbEntity.setProcessStamp(proceesStamp);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }



    public static List<StageIsrcFile> getFromSflIsrcToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageIsrcFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageIsrcFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageIscaFile> getFromSflIscaToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageIscaFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageIscaFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageGactFile> getFromSflGactToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageGactFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageGactFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageGcusFile> getFromSflGcusToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageGcusFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageGcusFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageGmonFile> getFromSflGmonToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageGmonFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageGmonFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageAcctFile> getFromSflAcctToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageAcctFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageAcctFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageCaptFile> getFromSflCaptToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageCaptFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageCaptFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StageGtolFile> getFromSflGtolToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StageGtolFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StageGtolFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StagePotlFile> getFromSflPotlToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StagePotlFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StagePotlFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

    public static List<StagePtldFile> getFromSflPtldToDb(Long idProceso, String processDate, List<String> sflTxtContent) {
        List<StagePtldFile> dbEntities  = new ArrayList<>();
        for (String linea : sflTxtContent) {
            var dbEntity  = new StagePtldFile();
            dbEntity.setIdProceso(idProceso);
            dbEntity.setProcessDate(processDate);
            dbEntity.setLinea(linea);
            dbEntities.add(dbEntity);
        }
        return dbEntities;
    }

}
