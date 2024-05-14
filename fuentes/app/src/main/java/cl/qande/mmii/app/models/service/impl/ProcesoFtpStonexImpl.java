package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.stonex.dao.IProcesoFtpStonexDao;
import cl.qande.mmii.app.models.db.stonex.entity.ProcesoFtpStonex;
import cl.qande.mmii.app.models.service.IProcesoFtpStonexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoFtpStonexImpl implements IProcesoFtpStonexService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IProcesoFtpStonexDao procesoFtpDao;
    @Transactional
    @Override
    public ProcesoFtpStonex procesaFtp(String processDate, String processStamp, String message) {
        appConfig.customLog.info(message);
        return procesoFtpDao.procesaFtp(processDate, processStamp, message);
    }
    @Transactional
    @Override
    public void cierraProcesoFtp(String processDate, String processStamp, String message, int estado) {
        appConfig.customLog.info("Cerrando proceso FTP: "+message);
        procesoFtpDao.cambiaEstadoProceso(processDate, processStamp, message, estado);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean esHabil(String processDate) {
        return procesoFtpDao.esHabil(processDate);
    }
}
