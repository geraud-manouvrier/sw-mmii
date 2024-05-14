package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICuentaService {

    Cuenta cuentaById(String id);

    List<Cuenta> listaCuentas();

    @Transactional
    void save(Cuenta cuenta);
    boolean isValid(Cuenta cuenta);

    boolean hasValidCustodio(Cuenta cuenta);
    boolean hasValidModeloAsesoria(Cuenta cuenta);

    boolean hasValidCuentaCustodio(Cuenta cuenta);

    @Transactional(readOnly = true)
    boolean hasValidCodPaisAtencion(Integer codPaisAtencion);

    @Transactional(readOnly = true)
    boolean hasValidBeneficiarios(String beneficiarios);
}
