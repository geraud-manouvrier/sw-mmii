package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.core.dao.IParametroDao;
import cl.qande.mmii.app.models.db.core.entity.Parametro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametroCoreService {

    private final  IParametroDao parametroDao;

    public ParametroCoreService(IParametroDao parametroDao) {
        this.parametroDao = parametroDao;
    }

    @Transactional(readOnly = true)
    public String valorParametroCore(String idParametro, String subIdParametro) {
        var parametroCore=parametroDao.findByIdParametroAndAndSubIdParametro(idParametro, subIdParametro);
        if (parametroCore==null) {
            return null;
        } else {
            return parametroCore.getValorParametro();
        }
    }

    @Transactional(readOnly = true)
    public List<Parametro> listaParametroCore(String idParametro) {
        return parametroDao.findByIdParametro(idParametro);
    }

    @Transactional(readOnly = true)
    public Parametro parametroCore(String idParametro, String subIdParametro) {
        return parametroDao.findByIdParametroAndSubIdParametro(idParametro, subIdParametro);
    }
}
