package cl.qande.mmii.app.util.mapper;

import cl.qande.mmii.app.models.db.pershing.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface EntityTransform {


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
