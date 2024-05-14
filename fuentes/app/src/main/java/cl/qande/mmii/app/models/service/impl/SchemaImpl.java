package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.stonex.dao.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.exception.SchemaStonexException;
import cl.qande.mmii.app.models.service.CsvService;
import cl.qande.mmii.app.models.service.ISchemaService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchemaImpl implements ISchemaService {

    public static final String ACT_SCHEMA          = "act.txt";
    public static final String ACT_SUM_SCHEMA      = "act_sum.txt";
    public static final String ADJ_SCHEMA          = "adj.txt";
    public static final String ADM_SCHEMA          = "adm.txt";
    public static final String ADM_EXP_SCHEMA      = "adm_exp.txt";
    public static final String BAL_SCHEMA          = "bal.txt";
    public static final String BAL_ACT_SCHEMA   = "bal_actual.txt";
    public static final String CSH_SCHEMA          = "csh.txt";
    public static final String MMF_BAL_SCHEMA      = "mmf_bal.txt";
    public static final String ORD_SCHEMA          = "ord.txt";
    public static final String POS_SCHEMA          = "pos.txt";
    public static final String RAD_SCHEMA          = "rad.txt";
    public static final String REP_BRA_SCHEMA      = "rep_bra.txt";
    public static final String RIT_POS_SCHEMA      = "rit_pos.txt";
    public static final String RTE_SCHEMA          = "rte.txt";
    public static final String SEC_OSI_SCHEMA      = "sec_osi.txt";
    public static final String TAXL_SCHEMA         = "taxl.txt";
    public static final String TRD_OSI_SCHEMA      = "trd_osi.txt";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IStageActDao stageActDao;
    @Autowired
    private IStageActSumDao stageActSumDao;
    @Autowired
    private IStageAdmDao stageAdmDao;
    @Autowired
    private IStageAdmExpDao stageAdmExpDao;
    @Autowired
    private IStageBalDao stageBalDao;
    @Autowired
    private IStageBalActDao stageBalActDao;
    @Autowired
    private IStageCshDao stageCshDao;
    @Autowired
    private IStageMmfBalDao stageMmfBalDao;
    @Autowired
    private IStagePosDao stagePosDao;
    @Autowired
    private IStageRadDao stageRadDao;
    @Autowired
    private IStageRitPosDao stageRitPosDao;
    @Autowired
    private IStageTrdOsiDao stageTrdOsiDao;
    @Autowired
    private IStageSecOsiDao stageSecOsiDao;
    @Autowired
    private IStageRteDao stageRteDao;
    @Autowired
    private IStageTaxlDao stageTaxlDao;
    @Autowired IStageRepBraDao stageRepBraDao;
    @Autowired
    private CsvService csvService;
    @Autowired
    private IMaestroSchemaDao maestroSchemaDao;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Transactional
    @Override
    public void saveSchema(String processDate, String processStamp, String fullPathFile) throws QandeMmiiException {

        var schemaName = FilenameUtils.getName(fullPathFile);
        switch (schemaName) {
            case ACT_SCHEMA:
                stageActDao.saveAll(csvService.processActWithProcess(processStamp, processDate));
                break;
            case ACT_SUM_SCHEMA:
                stageActSumDao.saveAll(csvService.processActSumWithProcess(processStamp, processDate));
                break;
            case ADM_SCHEMA:
                stageAdmDao.saveAll(csvService.processAdmWithProcess(processStamp, processDate));
                break;
            case ADM_EXP_SCHEMA:
                stageAdmExpDao.saveAll(csvService.processAdmExpWithProcess(processStamp, processDate));
                break;
            case BAL_SCHEMA:
                stageBalDao.saveAll(csvService.processBalWithProcess(processStamp, processDate));
                break;
            case BAL_ACT_SCHEMA:
                stageBalActDao.saveAll(csvService.processBalActWithProcess(processStamp, processDate));
                break;
            case CSH_SCHEMA:
                stageCshDao.saveAll(csvService.processCshWithProcess(processStamp, processDate));
                break;
            case MMF_BAL_SCHEMA:
                stageMmfBalDao.saveAll(csvService.processMmfBalWithProcess(processStamp, processDate));
                break;
            case POS_SCHEMA:
                stagePosDao.saveAll(csvService.processPosWithProcess(processStamp, processDate));
                break;
            case RAD_SCHEMA:
                stageRadDao.saveAll(csvService.processRadWithProcess(processStamp, processDate));
                break;
            case RIT_POS_SCHEMA:
                stageRitPosDao.saveAll(csvService.processRitPosWithProcess(processStamp, processDate));
                break;
            case TRD_OSI_SCHEMA:
                stageTrdOsiDao.saveAll(csvService.processTrdOsiWithProcess(processStamp, processDate));
                break;
            case SEC_OSI_SCHEMA:
                stageSecOsiDao.saveAll(csvService.processSecOsiWithProcess(processStamp, processDate));
                break;
            case RTE_SCHEMA:
                stageRteDao.saveAll(csvService.processRteWithProcess(processStamp, processDate));
                break;
            case TAXL_SCHEMA:
                stageTaxlDao.saveAll(csvService.processTaxlWithProcess(processStamp, processDate));
                break;
            case REP_BRA_SCHEMA:
                stageRepBraDao.saveAll(csvService.processRepBraWithProcess(processStamp, processDate));
                break;
            default:
                Boolean flagGuardarEnBd   = isActiveGuardarEnBd(getSchemaIdByFilename(schemaName));
                if (Boolean.TRUE.equals(flagGuardarEnBd)) {
                    notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error guardando Schema, no implementado");
                    throw new SchemaStonexException("Schema definido para guardar, pero no implementado: ["+schemaName+"]", processDate, processStamp);
                } else {
                    if (Boolean.FALSE.equals(flagGuardarEnBd)) {
                        appConfig.customLog.info("Saltando schema [" + schemaName + "]. No configurado para guardar.");
                    } else {
                        appConfig.customLog.info("Saltando guardar schema ["+schemaName+"]. No registrado en maestro.");
                    }
                }
        }
    }

    @Transactional
    @Override
    public void procesaSchema(String processStamp, String schemaName) throws QandeMmiiException {
        switch (schemaName) {
            case ACT_SCHEMA:
                stageActDao.procesaSchema(processStamp);
                break;
            case ACT_SUM_SCHEMA:
                stageActSumDao.procesaSchema(processStamp);
                break;
            case ADM_SCHEMA:
                stageAdmDao.procesaSchema(processStamp);
                break;
            case ADM_EXP_SCHEMA:
                stageAdmExpDao.procesaSchema(processStamp);
                break;
            case BAL_SCHEMA:
                stageBalDao.procesaSchema(processStamp);
                break;
            case BAL_ACT_SCHEMA:
                stageBalActDao.procesaSchema(processStamp);
                break;
            case CSH_SCHEMA:
                stageCshDao.procesaSchema(processStamp);
                break;
            case MMF_BAL_SCHEMA:
                stageMmfBalDao.procesaSchema(processStamp);
                break;
            case POS_SCHEMA:
                stagePosDao.procesaSchema(processStamp);
                break;
            case RAD_SCHEMA:
                stageRadDao.procesaSchema(processStamp);
                break;
            case TRD_OSI_SCHEMA:
                stageTrdOsiDao.procesaSchema(processStamp);
                break;
            case SEC_OSI_SCHEMA:
                stageSecOsiDao.procesaSchema(processStamp);
                break;
            default:
                Boolean flagProcesarParseEnBd   = isActiveProcesaParseEnBd(getSchemaIdByFilename(schemaName));
                if (Boolean.TRUE.equals(flagProcesarParseEnBd)) {
                    notificacionEmail.notificarErrorProcesoSchemasStonex(processStamp, "Error procesando Schema, no implementado");
                    throw new SchemaStonexException("Schema definido para procesar, pero no implementado: ["+schemaName+"]", processStamp, processStamp);
                } else {
                    if (Boolean.FALSE.equals(flagProcesarParseEnBd)) {
                        appConfig.customLog.info("Saltando schema ["+schemaName+"]. No configurado para procesarse.");
                    } else {
                        appConfig.customLog.info("Saltando configurado schema ["+schemaName+"]. No registrado en maestro.");
                    }
                }
        }
    }

    public Boolean isActiveProcesaParseEnBd(String schemaId) {
        var schema  = maestroSchemaDao.findById(schemaId).orElse(null);
        if (schema != null) {
            return schema.getFlagProcesarParseEnBd();
        }
        return null;
    }
    public Boolean isActiveGuardarEnBd(String schemaId) {
        var schema  = maestroSchemaDao.findById(schemaId).orElse(null);
        if (schema != null) {
            return schema.getFlagGuardarEnBd();
        }
        return null;
    }

    public String getSchemaIdByFilename(String filename) {
        return maestroSchemaDao.findByFilename(filename).getId();
    }
}
