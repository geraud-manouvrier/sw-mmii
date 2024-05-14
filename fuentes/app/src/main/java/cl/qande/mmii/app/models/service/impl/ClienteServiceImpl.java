package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.sura.dao.IClienteDao;
import cl.qande.mmii.app.models.db.sura.entity.Cliente;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.service.IClienteService;
import cl.qande.mmii.app.models.service.IEnrolamientoClienteParService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IEnrolamientoClienteParService enrolamientoClienteParService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public void save(Cliente cliente) {
        if (cliente.getResidenteFiscalUsa().equals("")) {
            cliente.setResidenteFiscalUsa(null);
        }
        clienteDao.save(cliente);
    }
    @Override
    public void save(ClienteDto clienteDto) {
        clienteDao.save(clienteMapper.toEntity(clienteDto));
    }
    @Override
    public ClienteDto clienteById(String id) {
        return clienteMapper.toDto((clienteDao.findById(id).orElse(null)));
    }
    @Override
    public List<Cliente> listaClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(Cliente cliente) {
        return (
                hasValidCodPaisAtencion(cliente.getCodPaisAtencion())
                && hasValidResidenteFiscalUsa(cliente.getResidenteFiscalUsa())
                && cliente.getFechaNacimiento()!=null
                && ( ! cliente.getCodPaisResidencia().isBlank() )
                && hasValidCodPaisResidencia(cliente.getCodPaisResidencia())
                );
    }
    @Override
    @Transactional(readOnly = true)
    public boolean isValid(ClienteDto clienteDto) {
        Assert.isTrue(hasValidCodPaisAtencion(clienteDto.getCodPaisAtencion()), "Cod. Pais atención no válido");
        Assert.isTrue(hasValidResidenteFiscalUsa(clienteDto.getResidenteFiscalUsa()), "Res. fiscal no válido.");
        Assert.notNull(clienteDto.getFechaNacimiento(), "Fecha nacimiento no puede ser vacía");
        Assert.isTrue(( hasValidCodPaisResidencia(clienteDto.getCodPaisResidencia()) ), "Cod. pais residencia no válido");

        return true;
    }
    @Override
    public boolean hasValidCodPaisAtencion(Integer codPaisAtencion) {
        return ( codPaisAtencion!=null && enrolamientoClienteParService.existPaisAtencion(codPaisAtencion) );
    }

    @Override
    public boolean hasValidCodPaisResidencia(String codPaisResidencia) {
        return ( codPaisResidencia!=null && ( !codPaisResidencia.isBlank()) );
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasValidResidenteFiscalUsa(String residenteFiscalUsa) {
        return ( residenteFiscalUsa==null || residenteFiscalUsa.isBlank() || residenteFiscalUsa.equals("Y") || residenteFiscalUsa.equals("N") );
    }
}
