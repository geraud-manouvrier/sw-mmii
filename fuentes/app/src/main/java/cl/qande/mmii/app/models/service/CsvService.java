package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.FtpStonexProperties;
import cl.qande.mmii.app.models.csv.*;
import cl.qande.mmii.app.models.db.stonex.entity.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.impl.SchemaImpl;
import cl.qande.mmii.app.util.helper.CsvBean;
import cl.qande.mmii.app.util.helper.CsvHelper;
import cl.qande.mmii.app.util.helper.mapper.EntityTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private FtpStonexProperties ftpStonexProperties;

    private List<CsvBean> processCsv(String processStamp, String csvFile, String processDate, Class clazz) throws QandeMmiiException {
        Path path = Paths.get(ftpStonexProperties.getWorkPath()+processDate+processStamp).resolve(csvFile).toAbsolutePath();
        CsvHelper csvHelper = new CsvHelper();
        try {
            return csvHelper.processCsvBean(path, clazz);
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error al procesar CSV Bean: ["+e.getMessage()+"]");
        }
    }

    public List<StageAct> processActWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvAct = processCsv(processStamp, SchemaImpl.ACT_SCHEMA, processDate, ActCsvBean.class);
        return EntityTransform.getFromSchemaActToDb(csvAct, processStamp);
    }

    public List<StageActSum> processActSumWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvActSum = processCsv(processStamp, SchemaImpl.ACT_SUM_SCHEMA, processDate, ActSumCsvBean.class);
        return EntityTransform.getFromSchemaActSumToDb(csvActSum, processStamp);
    }
    public List<StageAdm> processAdmWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvAdm = processCsv(processStamp, SchemaImpl.ADM_SCHEMA, processDate, AdmCsvBean.class);
        return EntityTransform.getFromSchemaAdmToDb(csvAdm, processStamp);
    }
    public List<StageAdmExp> processAdmExpWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvAdmExp = processCsv(processStamp, SchemaImpl.ADM_EXP_SCHEMA, processDate, AdmExpCsvBean.class);
        return EntityTransform.getFromSchemaAdmExpToDb(csvAdmExp, processStamp);
    }
    public List<StageBal> processBalWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvBal = processCsv(processStamp, SchemaImpl.BAL_SCHEMA, processDate, BalCsvBean.class);
        return EntityTransform.getFromSchemaBalToDb(csvBal, processStamp);
    }
    public List<StageBalAct> processBalActWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvBalAct = processCsv(processStamp, SchemaImpl.BAL_ACT_SCHEMA, processDate, BalActCsvBean.class);
        return EntityTransform.getFromSchemaBalActToDb(csvBalAct, processStamp);
    }
    public List<StageCsh> processCshWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvCsh = processCsv(processStamp, SchemaImpl.CSH_SCHEMA, processDate, CshCsvBean.class);
        return EntityTransform.getFromSchemaCshToDb(csvCsh, processStamp);
    }
    public List<StageMmfBal> processMmfBalWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvMmfBal = processCsv(processStamp, SchemaImpl.MMF_BAL_SCHEMA, processDate, MmfBalCsvBean.class);
        return EntityTransform.getFromSchemaMmfBalToDb(csvMmfBal, processStamp);
    }
    public List<StagePos> processPosWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvPos = processCsv(processStamp, SchemaImpl.POS_SCHEMA, processDate, PosCsvBean.class);
        return EntityTransform.getFromSchemaPosToDb(csvPos, processStamp);
    }
    public List<StageRad> processRadWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvRad = processCsv(processStamp, SchemaImpl.RAD_SCHEMA, processDate, RadCsvBean.class);
        return EntityTransform.getFromSchemaRadToDb(csvRad, processStamp);
    }
    public List<StageRitPos> processRitPosWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvRitPos = processCsv(processStamp, SchemaImpl.RIT_POS_SCHEMA, processDate, RitPosCsvBean.class);
        return EntityTransform.getFromSchemaRitPosToDb(csvRitPos, processStamp);
    }
    public List<StageTrdOsi> processTrdOsiWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvTrdOsi = processCsv(processStamp, SchemaImpl.TRD_OSI_SCHEMA, processDate, TrdOsiCsvBean.class);
        return EntityTransform.getFromSchemaTrdOsiToDb(csvTrdOsi, processStamp);
    }
    public List<StageTaxl> processTaxlWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvTaxl = processCsv(processStamp, SchemaImpl.TAXL_SCHEMA, processDate, TaxlCsvBean.class);
        return EntityTransform.getFromSchemaTaxlToDb(csvTaxl, processStamp);
    }

    public List<StageRte> processRteWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvRte = processCsv(processStamp, SchemaImpl.RTE_SCHEMA, processDate, RteCsvBean.class);
        return EntityTransform.getFromSchemaRteToDb(csvRte, processStamp);
    }

    public List<StageSecOsi> processSecOsiWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvSecOsi = processCsv(processStamp, SchemaImpl.SEC_OSI_SCHEMA, processDate, SecOsiCsvBean.class);
        return EntityTransform.getFromSchemaSecOsiToDb(csvSecOsi, processStamp);
    }

    public List<StageRepBra> processRepBraWithProcess(String processStamp, String processDate) throws QandeMmiiException {
        var csvRepBra = processCsv(processStamp, SchemaImpl.REP_BRA_SCHEMA, processDate, RepBraCsvBean.class);
        return EntityTransform.getFromSchemaRepBraToDb(csvRepBra, processStamp);
    }


}
