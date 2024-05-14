package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.exception.QandeMmiiException;

public interface ISflService {

    public void saveSfl(Long idProceso, String processDate, String processStamp, String fullPathFile, String idSfl) throws QandeMmiiException;

    public void procesaSfl(Long idProceso, String processDate, String processStamp, String fullPathFile, String idSfl) throws QandeMmiiException;

    public Boolean isActiveProcesaParseEnBd(String sflId);
    public Boolean isActiveGuardarEnBd(String sflId);
}
