package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.clientes.dao.IClienteDao;
import cl.qande.mmii.app.models.db.clientes.dao.ICuentaDao;
import cl.qande.mmii.app.models.db.clientes.dao.ITipoIdentificadorDao;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.TipoIdentificadorDto;
import cl.qande.mmii.app.models.service.IEnrolamientoClientesService;
import cl.qande.mmii.app.util.helper.mapper.ClienteMapper;
import cl.qande.mmii.app.util.helper.mapper.CuentaMapper;
import cl.qande.mmii.app.util.helper.mapper.TipoIdentificadorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolamientoClientesServiceImpl implements IEnrolamientoClientesService {
    @Autowired
    private ITipoIdentificadorDao tipoIdentificadorDao;
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private ICuentaDao cuentaDao;
    @Autowired
    private CuentaMapper cuentaMapper;
    @Autowired
    private TipoIdentificadorMapper tipoIdentificadorMapper;
    @Autowired
    private ClienteMapper clienteMapper;

    //Cliente
    @Override
    public List<ClienteDto> listarClientes() {
        return clienteMapper.toDto(clienteDao.findAll());
    }
    @Override
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        return clienteMapper.toDto(clienteDao.save(clienteMapper.toEntity(clienteDto)));
    }
    @Override
    public ClienteDto listarClientePorId(Integer id) {
        return clienteMapper.toDto(clienteDao.findById(id).orElse(null));
    }
    @Override
    public ClienteDto listarClientePorIdentificador(String identificador) {
        return clienteMapper.toDto(clienteDao.findByIdentificador(identificador).orElse(null));
    }


    //Cuenta
    @Override
    public List<CuentaDto> listarCuentas() {
        return cuentaMapper.toDto(cuentaDao.findAll());
    }
    @Override
    public List<CuentaDto> listarCuentasPorIdCuentaCustodio(String idCuentaCustodio) {
        return cuentaMapper.toDto(cuentaDao.findByIdCuentaCustodio(idCuentaCustodio));
    }
    @Override
    public List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente) {
        return cuentaMapper.toDto(cuentaDao.findByIdCliente(idCliente));
    }
    @Override
    public CuentaDto guardarCuenta(CuentaDto cuentaDto) {
        return cuentaMapper.toDto(cuentaDao.save(cuentaMapper.toEntity(cuentaDto)));
    }

    //TipoIdentificador
    @Override
    public List<TipoIdentificadorDto> listarTiposIdentificador() {
        return tipoIdentificadorMapper.toDto(tipoIdentificadorDao.findAll());
    }
    @Override
    public TipoIdentificadorDto listarTipoIdentificadorPorId(Integer id) {
        return tipoIdentificadorMapper.toDto(tipoIdentificadorDao.findById(id).orElse(null));
    }

}
