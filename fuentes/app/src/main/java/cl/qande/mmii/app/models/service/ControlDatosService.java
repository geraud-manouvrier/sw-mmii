package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.ICuentasNoMapeadasPershingDao;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlDatosService {

    private final ICuentasNoMapeadasPershingDao cuentasNoMapeadasPershingDao;

    @Autowired
    public ControlDatosService(ICuentasNoMapeadasPershingDao cuentasNoMapeadasPershingDao) {
        this.cuentasNoMapeadasPershingDao = cuentasNoMapeadasPershingDao;
    }

    public List<VwCuentasNoMapeadasPershingProjection> listaCuentasNoMapeadas(String processDate) {
        return cuentasNoMapeadasPershingDao.listaCuentasNoMapeadasByProcessDate(processDate);
    }
}
