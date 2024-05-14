package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.sura.dao.IContratoDao;
import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import cl.qande.mmii.app.models.service.IContratoService;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContratoServiceImpl implements IContratoService {

    @Autowired
    private IContratoDao contratoDao;
    @Autowired
    private IEnrolamientoClienteParService enrolamientoClienteParService;

    @Override
    @Transactional
    public void save(Contrato contrato) {
        contratoDao.save(contrato);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(Contrato contrato) {
        return ( this.hasValidTipoCuenta(contrato) && this.hasValidTipoServicio(contrato) && this.hasValidIdCliente(contrato));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidTipoCuenta(Contrato contrato) {
        return ( enrolamientoClienteParService.tipoCuentaById(contrato.getTipoCuenta())!=null );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidTipoServicio(Contrato contrato) {
        return ( enrolamientoClienteParService.tipoServicioById(contrato.getTipoServicio())!=null );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidIdCliente(Contrato contrato) {
        var contratoAlmacenado  = contratoDao.findById(contrato.getId()).orElse(null);
        return (contratoAlmacenado==null || contratoAlmacenado.getIdCliente().equals(contrato.getIdCliente()));
    }
}
