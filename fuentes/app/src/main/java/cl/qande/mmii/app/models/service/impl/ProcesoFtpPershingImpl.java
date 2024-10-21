package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.pershing.dao.IProcesoSflDao;
import cl.qande.mmii.app.models.db.pershing.entity.ProcesoSfl;
import cl.qande.mmii.app.models.service.IProcesoFtpPershingService;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoFtpPershingImpl implements IProcesoFtpPershingService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IProcesoSflDao procesoSflDao;
    @Transactional
    @Override
    public ProcesoSfl procesaFtp(String processDate, String processStamp, String message) {
        CustomLog.getInstance().info(message);
        return procesoSflDao.procesaFtp(processDate, processStamp, message);
    }
    @Transactional
    @Override
    public void cierraProcesoFtp(String processDate, String processStamp, String message, int estado) {
        CustomLog.getInstance().info("Cerrando proceso FTP: "+message);
        procesoSflDao.cambiaEstadoProceso(processDate, processStamp, message, estado);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean esHabil(String processDate) {
        return procesoSflDao.esHabil(processDate);
    }
}
