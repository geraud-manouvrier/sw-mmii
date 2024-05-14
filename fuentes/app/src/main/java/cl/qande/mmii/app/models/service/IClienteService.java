package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.sura.entity.Cliente;
import cl.qande.mmii.app.models.dto.ClienteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClienteService {

    @Transactional
    void save(Cliente cliente);

    @Transactional
    void save(ClienteDto clienteDto);

    @Transactional(readOnly = true)
    ClienteDto clienteById(String id);

    @Transactional(readOnly = true)
    List<Cliente> listaClientes();

    @Transactional(readOnly = true)
    boolean isValid(Cliente cliente);

    @Transactional(readOnly = true)
    boolean isValid(ClienteDto clienteDto);

    @Transactional(readOnly = true)
    boolean hasValidCodPaisAtencion(Integer codPaisAtencion);

    boolean hasValidCodPaisResidencia(String codPaisResidencia);

    @Transactional(readOnly = true)
    boolean hasValidResidenteFiscalUsa(String residenteFiscalUsa);
}
