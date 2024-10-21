package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.pershing.dao.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.exception.SchemaStonexException;
import cl.qande.mmii.app.models.exception.SflPershingException;
import cl.qande.mmii.app.models.service.ISflService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.TxtService;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SflImpl implements ISflService {

    public static final String ISRC_SFL_EXT          = "ISRC";
    public static final String ISCA_SFL_EXT          = "ISCA";
    public static final String GACT_SFL_EXT          = "GACT";
    public static final String GCUS_SFL_EXT          = "GCUS";
    public static final String GMON_SFL_EXT          = "GMON";
    public static final String ACCT_SFL_EXT          = "ACCT";
    public static final String CAPT_SFL_EXT          = "CAPT";
    public static final String GTOL_SFL_EXT          = "GTOL";
    public static final String POTL_SFL_EXT          = "POTL";
    public static final String PTLD_SFL_EXT          = "PTLD";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IStageIsrcFileDao stageIsrcFileDao;
    @Autowired
    private IStageIscaFileDao stageIscaFileDao;
    @Autowired
    private IStageGactFileDao stageGactFileDao;
    @Autowired
    private IStageGcusFileDao stageGcusFileDao;
    @Autowired
    private IStageGmonFileDao stageGmonFileDao;
    @Autowired
    private IStageAcctFileDao stageAcctFileDao;
    @Autowired
    private IStageCaptFileDao stageCaptFileDao;
    @Autowired
    private IStageGtolFileDao stageGtolFileDao;
    @Autowired
    private IStagePotlFileDao stagePotlFileDao;
    @Autowired
    private IStagePtldFileDao stagePtldFileDao;
    @Autowired
    private TxtService txtService;
    @Autowired
    private IMaestroSflDao maestroSflDao;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Transactional
    @Override
    public void saveSfl(Long idProceso, String processDate, String processStamp, String fullPathFile, String idSfl) throws QandeMmiiException {

        switch (idSfl) {
            case ISRC_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageIsrcFileDao.saveAll(txtService.processIsrcWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageIsrcFileDao.parseSfl(idProceso);
                break;
            case ISCA_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageIscaFileDao.saveAll(txtService.processIscaWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageIscaFileDao.parseSfl(idProceso);
                break;
            case GACT_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageGactFileDao.saveAll(txtService.processGactWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageGactFileDao.parseSfl(idProceso);
                break;
            case GCUS_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageGcusFileDao.saveAll(txtService.processGcusExpWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageGcusFileDao.parseSfl(idProceso);
                break;
            case GMON_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageGmonFileDao.saveAll(txtService.processGmonWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageGmonFileDao.parseSfl(idProceso);
                break;
            case ACCT_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageAcctFileDao.saveAll(txtService.processAcctWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Iniciando parse Sfl [" + idSfl + "]...");
                stageAcctFileDao.parseSfl(idProceso);
                break;
            case CAPT_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageCaptFileDao.saveAll(txtService.processCaptWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Parse para Sfl [" + idSfl + "] no implementado. SFL solamente guardado en tabla stage inicial.");
                break;
            case GTOL_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stageGtolFileDao.saveAll(txtService.processGtolWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Parse para Sfl [" + idSfl + "] no implementado. SFL solamente guardado en tabla stage inicial.");
                break;
            case POTL_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stagePotlFileDao.saveAll(txtService.processPotlWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Parse para Sfl [" + idSfl + "] no implementado. SFL solamente guardado en tabla stage inicial.");
                break;
            case PTLD_SFL_EXT:
                CustomLog.getInstance().info("Guardando Sfl [" + idSfl + "]...");
                stagePtldFileDao.saveAll(txtService.processPtldWithProcess(idProceso, processDate, fullPathFile));
                CustomLog.getInstance().info("Parse para Sfl [" + idSfl + "] no implementado. SFL solamente guardado en tabla stage inicial.");
                break;
            default:
                Boolean flagGuardarEnBd   = isActiveGuardarEnBd(idSfl);
                if (Boolean.TRUE.equals(flagGuardarEnBd)) {
                    notificacionEmail.notificarErrorProcesoSflFtpPershing(processDate, "Error guardando Sfl, no implementado");
                    throw new SchemaStonexException("Sfl definido para guardar, pero no implementado: ["+idSfl+"]", processDate, processStamp);
                } else {
                    if (Boolean.FALSE.equals(flagGuardarEnBd)) {
                        CustomLog.getInstance().info("Saltando Sfl guardado y parse [" + idSfl + "]. No configurado para guardar.");
                    } else {
                        CustomLog.getInstance().info("Saltando Sfl guardado y parse ["+idSfl+"]. No registrado en maestro.");
                    }
                }
        }
        CustomLog.getInstance().info("Finalizado guardado y parse Sfl [" + idSfl + "]...");
    }

    @Transactional
    @Override
    public void procesaSfl(Long idProceso, String processDate, String processStamp, String fullPathFile, String idSfl) throws QandeMmiiException {
        switch (idSfl) {
            case ISRC_SFL_EXT:
                stageIsrcFileDao.procesaSfl(idProceso);
                break;
            case ISCA_SFL_EXT:
                stageIscaFileDao.procesaSfl(idProceso);
                break;
            case GACT_SFL_EXT:
                stageGactFileDao.procesaSfl(idProceso);
                break;
            case GCUS_SFL_EXT:
                stageGcusFileDao.procesaSfl(idProceso);
                break;
            case GMON_SFL_EXT:
                stageGmonFileDao.procesaSfl(idProceso);
                break;
            case ACCT_SFL_EXT:
                stageAcctFileDao.procesaSfl(idProceso);
                break;
            default:
                Boolean flagProcesarParseEnBd   = isActiveProcesaParseEnBd(idSfl);
                if (Boolean.TRUE.equals(flagProcesarParseEnBd)) {
                    notificacionEmail.notificarErrorProcesoSflFtpPershing(processStamp, "Error procesando Sfl, no implementado");
                    throw new SflPershingException("Sfl definido para procesar, pero no implementado: ["+idSfl+"] ", fullPathFile);
                } else {
                    if (Boolean.FALSE.equals(flagProcesarParseEnBd)) {
                        CustomLog.getInstance().info("Saltando Sfl ["+idSfl+"]. No configurado para procesarse.");
                    } else {
                        CustomLog.getInstance().info("Saltando configurado Sfl ["+idSfl+"]. No registrado en maestro.");
                    }
                }
        }
    }

    public Boolean isActiveProcesaParseEnBd(String sflId) {
        var sfl  = maestroSflDao.findById(sflId).orElse(null);
        if (sfl != null) {
            return sfl.getFlagProcesarParseEnBd();
        }
        return null;
    }
    public Boolean isActiveGuardarEnBd(String sflId) {
        var sfl  = maestroSflDao.findById(sflId).orElse(null);
        if (sfl != null) {
            return sfl.getFlagGuardarEnBd();
        }
        return null;
    }
}
