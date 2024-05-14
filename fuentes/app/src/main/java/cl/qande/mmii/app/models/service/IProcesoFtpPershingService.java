package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.pershing.entity.ProcesoSfl;
import org.springframework.transaction.annotation.Transactional;

public interface IProcesoFtpPershingService {

    public ProcesoSfl procesaFtp(String processDate, String processStamp, String message);

    @Transactional
    public void cierraProcesoFtp(String processDate, String processStamp, String message, int estado);

    @Transactional(readOnly = true)
    boolean esHabil(String processDate);
}
