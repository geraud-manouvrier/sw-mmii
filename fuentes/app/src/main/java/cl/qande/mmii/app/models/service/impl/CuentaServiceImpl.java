package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.sura.dao.ICuentaDao;
import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import cl.qande.mmii.app.models.service.ICuentaService;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaDao cuentaDao;
    @Autowired
    private IEnrolamientoClienteParService enrolamientoClienteParService;

    @Override
    public Cuenta cuentaById(String id) {
        return cuentaDao.findById(id).orElse(null);
    }
    @Override
    public List<Cuenta> listaCuentas() {
        return cuentaDao.findAll();
    }
    @Override
    @Transactional
    public void save(Cuenta cuenta) {
        if (cuenta.getBeneficiarios().equals("")) {
            cuenta.setBeneficiarios(null);
        }
        cuentaDao.save(cuenta);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(Cuenta cuenta) {
        return ( this.hasValidCustodio(cuenta) && this.hasValidModeloAsesoria(cuenta) && this.hasValidCuentaCustodio(cuenta) && hasValidCodPaisAtencion(cuenta.getCodPaisAtencion()) && this.hasValidBeneficiarios(cuenta.getBeneficiarios()) );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidCustodio(Cuenta cuenta) {
        return ( enrolamientoClienteParService.custodioById(cuenta.getCustodio())!=null );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidModeloAsesoria(Cuenta cuenta) {
        return ( enrolamientoClienteParService.modeloAsesoriaById(cuenta.getModeloAsesoria())!=null );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidCuentaCustodio(Cuenta cuenta) {
        var cuentaAlmacenada    = cuentaDao.findCuentaByIdCuentaCustodioAndCustodio(cuenta.getIdCuentaCustodio(), cuenta.getCustodio());
        return (cuentaAlmacenada==null || cuentaAlmacenada.getIdCuentaSura().equals(cuenta.getIdCuentaSura()));
    }
    @Override
    public boolean hasValidCodPaisAtencion(Integer codPaisAtencion) {
        return (codPaisAtencion==null || enrolamientoClienteParService.existPaisAtencion(codPaisAtencion));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidBeneficiarios(String beneficiarios) {
        return ( beneficiarios==null || beneficiarios.equals("Y") || beneficiarios.equals("N") );
    }
}
