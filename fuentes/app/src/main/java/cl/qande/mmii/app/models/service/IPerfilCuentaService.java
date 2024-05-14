package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPerfilCuentaService {
    PerfilCuenta perfilCuentaById(Long id);

    List<PerfilCuenta> listaPerfilCuenta();

    @Transactional
    void add(PerfilCuenta perfilCuenta);

    boolean hasValidIdPerfil(PerfilCuenta perfilCuenta);
    boolean isValid(PerfilCuenta perfilCuenta);

    @Transactional(readOnly = true)
    boolean hasValidExencionResponsabilidad(String extensionsResponsabilidad);
}
