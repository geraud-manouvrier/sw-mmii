package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IParametroDao;
import cl.qande.mmii.app.models.db.core.entity.Parametro;
import cl.qande.mmii.app.models.service.IParametroCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametroCoreServiceImpl implements IParametroCoreService {

    @Autowired
    private IParametroDao parametroDao;
    @Override
    @Transactional(readOnly = true)
    public String valorParametroCore(String idParametro, String subIdParametro) {
        var parametroCore=parametroDao.findByIdParametroAndAndSubIdParametro(idParametro, subIdParametro);
        if (parametroCore==null) {
            return null;
        } else {
            return parametroCore.getValorParametro();
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<Parametro> listaParametroCore(String idParametro) {
        return parametroDao.findByIdParametro(idParametro);
    }
    @Override
    @Transactional(readOnly = true)
    public Parametro parametroCore(String idParametro, String subIdParametro) {
        return parametroDao.findByIdParametroAndSubIdParametro(idParametro, subIdParametro);
    }
}
