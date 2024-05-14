package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.exception.QandeMmiiException;

public interface ISchemaService {

    public void saveSchema(String processDate, String processStamp, String fullPathFile) throws QandeMmiiException;

    public void procesaSchema(String processStamp, String schemaName) throws QandeMmiiException;

    public Boolean isActiveProcesaParseEnBd(String schemaId);
    public Boolean isActiveGuardarEnBd(String schemaId);
}
