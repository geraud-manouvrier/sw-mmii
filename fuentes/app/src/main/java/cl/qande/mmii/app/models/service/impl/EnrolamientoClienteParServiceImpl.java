package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.core.dao.IParPaisAtencionDao;
import cl.qande.mmii.app.models.db.core.entity.ParPaisAtencion;
import cl.qande.mmii.app.models.db.sura.dao.*;
import cl.qande.mmii.app.models.db.sura.entity.*;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolamientoClienteParServiceImpl implements IEnrolamientoClienteParService {
    @Autowired
    private ITipoCuentaDao tipoCuentaDao;
    @Autowired
    private ITipoServicioDao tipoServicioDao;
    @Autowired
    private IModeloAsesoriaDao modeloAsesoriaDao;
    @Autowired
    private IPerfilDao perfilDao;
    @Autowired
    private ICustodioDao custodioDao;
    @Autowired
    private IParPaisAtencionDao parPaisAtencionDao;

    @Override
    public List<TipoCuenta> listTipoCuenta() {
        return tipoCuentaDao.findAll();
    }
    @Override
    public TipoCuenta tipoCuentaById(String id) {
        return tipoCuentaDao.findById(id).orElse(null);
    }

    @Override
    public List<TipoServicio> listTipoServicio() {
        return tipoServicioDao.findAll();
    }
    @Override
    public TipoServicio tipoServicioById(String id) {
        return tipoServicioDao.findById(id).orElse(null);
    }

    @Override
    public List<ModeloAsesoria> listModeloAsesoria() {
        return modeloAsesoriaDao.findAll();
    }
    @Override
    public ModeloAsesoria modeloAsesoriaById(String id) {
        return modeloAsesoriaDao.findById(id).orElse(null);
    }

    @Override
    public List<Perfil> listPerfil() {
        return perfilDao.findAll();
    }
    @Override
    public Perfil perfilById(String id) {
        return perfilDao.findById(id).orElse(null);
    }
    @Override
    public List<Custodio> listCustodio() {
        return custodioDao.findAll();
    }
    @Override
    public Custodio custodioById(String id) {
        return custodioDao.findById(id).orElse(null);
    }

    @Override
    public boolean existPaisAtencion(Integer codPaisAtencion) {
        return (paisAtencionById(codPaisAtencion)!=null);
    }
    @Override
    public List<ParPaisAtencion> listaPaisAtencion() {
        return parPaisAtencionDao.listaPaisesOrdenada();
    }
    @Override
    public ParPaisAtencion paisAtencionById(Integer codPaisAtencion) {
        return parPaisAtencionDao.findById(codPaisAtencion).orElse(null);
    }
    @Override
    public List<ParPaisAtencion> listaPaisResidencia() {
        return parPaisAtencionDao.listaPaisesOrdenada();
    }
}
