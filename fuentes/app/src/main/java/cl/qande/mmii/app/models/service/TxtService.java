package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.pershing.entity.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.helper.mapper.EntityTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class TxtService {

    public static final Charset SFL_CHARSET = StandardCharsets.ISO_8859_1;
    @Autowired
    private AppConfig appConfig;

    private List<String> readSflTxt(String fullPathFile) throws QandeMmiiException {
        List<String> result;

        try {
            result  = Files.readAllLines(Paths.get(fullPathFile), SFL_CHARSET);
            CustomLog.getInstance().info("Leído archivo TXT SFL ["+fullPathFile+"], se encontraron ["+result.size()+"] líneas.");
        }catch (Exception e) {
            throw new QandeMmiiException(e, "Error al leer TXT SFL: ["+e.getMessage()+"]");
        }
        return result;

    }

    public List<StageIsrcFile> processIsrcWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflIsrcToDb(idProceso, processDate, txtContent);
    }

    public List<StageIscaFile> processIscaWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflIscaToDb(idProceso, processDate, txtContent);
    }
    public List<StageGactFile> processGactWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflGactToDb(idProceso, processDate, txtContent);
    }
    public List<StageGcusFile> processGcusExpWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflGcusToDb(idProceso, processDate, txtContent);
    }
    public List<StageGmonFile> processGmonWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflGmonToDb(idProceso, processDate, txtContent);
    }

    public List<StageAcctFile> processAcctWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflAcctToDb(idProceso, processDate, txtContent);
    }

    public List<StageCaptFile> processCaptWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflCaptToDb(idProceso, processDate, txtContent);
    }

    public List<StageGtolFile> processGtolWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflGtolToDb(idProceso, processDate, txtContent);
    }

    public List<StagePotlFile> processPotlWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflPotlToDb(idProceso, processDate, txtContent);
    }

    public List<StagePtldFile> processPtldWithProcess(Long idProceso, String processDate, String fullPathFile) throws QandeMmiiException {
        var txtContent = readSflTxt(fullPathFile);
        return EntityTransform.getFromSflPtldToDb(idProceso, processDate, txtContent);
    }


}
