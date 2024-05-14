package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import org.springframework.transaction.annotation.Transactional;

public interface IContratoService {

    void save(Contrato contrato);
    boolean isValid(Contrato contrato);
    boolean hasValidTipoCuenta(Contrato contrato);
    boolean hasValidTipoServicio(Contrato contrato);

    @Transactional(readOnly = true)
    boolean hasValidIdCliente(Contrato contrato);
}
