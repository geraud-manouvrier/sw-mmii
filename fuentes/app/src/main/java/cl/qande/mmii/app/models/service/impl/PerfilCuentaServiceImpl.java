package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.sura.dao.ICuentaDao;
import cl.qande.mmii.app.models.db.sura.dao.IPerfilCuentaDao;
import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import cl.qande.mmii.app.models.service.IPerfilCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilCuentaServiceImpl implements IPerfilCuentaService {

    @Autowired
    private IPerfilCuentaDao perfilCuentaDao;
    @Autowired
    private ICuentaDao cuentaDao;
    @Autowired
    private IEnrolamientoClienteParService enrolamientoClienteParService;

    @Override
    public PerfilCuenta perfilCuentaById(Long id) {
        return perfilCuentaDao.findById(id).orElse(null);
    }
    @Override
    public List<PerfilCuenta> listaPerfilCuenta() {
        return perfilCuentaDao.findAll();
    }
    @Override
    @Transactional
    public void add(PerfilCuenta perfilCuenta) {
        if (perfilCuenta.getExencionResponsabilidad().equals("")) {
            perfilCuenta.setExencionResponsabilidad(null);
        }
        perfilCuentaDao.save(perfilCuenta);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(PerfilCuenta perfilCuenta) {
        return ( this.hasValidIdPerfil(perfilCuenta) && this.hasValidExencionResponsabilidad(perfilCuenta.getExencionResponsabilidad()) && (cuentaDao.findById(perfilCuenta.getIdCuentaSura()).orElse(null) != null) );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidIdPerfil(PerfilCuenta perfilCuenta) {
        return ( enrolamientoClienteParService.perfilById(perfilCuenta.getIdPerfil())!=null );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidExencionResponsabilidad(String extensionsResponsabilidad) {
        return ( extensionsResponsabilidad ==null || extensionsResponsabilidad.equals("Y") || extensionsResponsabilidad.equals("N") );
    }

}
