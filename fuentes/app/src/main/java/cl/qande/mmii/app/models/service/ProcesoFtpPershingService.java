package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.pershing.dao.IProcesoSflDao;
import cl.qande.mmii.app.models.db.pershing.entity.ProcesoSfl;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcesoFtpPershingService {

    private final IProcesoSflDao procesoSflDao;

    public ProcesoFtpPershingService(IProcesoSflDao procesoSflDao) {
        this.procesoSflDao = procesoSflDao;
    }

    @Transactional
    public ProcesoSfl procesaFtp(String processDate, String processStamp, String message) {
        CustomLog.getInstance().info(message);
        return procesoSflDao.procesaFtp(processDate, processStamp, message);
    }

    @Transactional
    public void cierraProcesoFtp(String processDate, String processStamp, String message, int estado) {
        CustomLog.getInstance().info("Cerrando proceso FTP: "+message);
        procesoSflDao.cambiaEstadoProceso(processDate, processStamp, message, estado);
    }

    @Transactional(readOnly = true)
    public boolean esHabil(String processDate) {
        return procesoSflDao.esHabil(processDate);
    }
}
