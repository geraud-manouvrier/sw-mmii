package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.models.db.clientes.dao.*;
import cl.qande.mmii.app.models.dto.*;
import cl.qande.mmii.app.models.service.IEnrolamientoClientesService;
import cl.qande.mmii.app.util.helper.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrolamientoClientesServiceImpl implements IEnrolamientoClientesService {
    //DAOs
    private final ITipoIdentificadorDao tipoIdentificadorDao;
    private final IClienteDao clienteDao;
    private final ICuentaDao cuentaDao;
    private final IComisionCuentaDao comisionCuentaDao;
    private final IComisionMaestroDao comisionMaestroDao;
    private final IClienteCuentaMaestroDao clienteCuentaMaestroDao;
    //Mappers
    private final CuentaMapper cuentaMapper;
    private final TipoIdentificadorMapper tipoIdentificadorMapper;
    private final ClienteMapper clienteMapper;
    private final ClienteMaestroMapper clienteMaestroMapper;
    private final ComisionCuentaMapper comisionCuentaMapper;
    private final ClienteCuentaMaestroMapper clienteCuentaMaestroMapper;
    private final ComisionMaestroMapper comisionMaestroMapper;

    @Autowired
    public EnrolamientoClientesServiceImpl(ITipoIdentificadorDao tipoIdentificadorDao, IClienteDao clienteDao, ICuentaDao cuentaDao, IComisionCuentaDao comisionCuentaDao, IComisionMaestroDao comisionMaestroDao, IClienteCuentaMaestroDao clienteCuentaMaestroDao, CuentaMapper cuentaMapper, TipoIdentificadorMapper tipoIdentificadorMapper, ClienteMapper clienteMapper, ClienteMaestroMapper clienteMaestroMapper, ComisionCuentaMapper comisionCuentaMapper, ClienteCuentaMaestroMapper clienteCuentaMaestroMapper, ComisionMaestroMapper comisionMaestroMapper) {
        this.tipoIdentificadorDao = tipoIdentificadorDao;
        this.clienteDao = clienteDao;
        this.cuentaDao = cuentaDao;
        this.comisionCuentaDao = comisionCuentaDao;
        this.comisionMaestroDao = comisionMaestroDao;
        this.clienteCuentaMaestroDao = clienteCuentaMaestroDao;
        this.cuentaMapper = cuentaMapper;
        this.tipoIdentificadorMapper = tipoIdentificadorMapper;
        this.clienteMapper = clienteMapper;
        this.clienteMaestroMapper = clienteMaestroMapper;
        this.comisionCuentaMapper = comisionCuentaMapper;
        this.clienteCuentaMaestroMapper = clienteCuentaMaestroMapper;
        this.comisionMaestroMapper = comisionMaestroMapper;
    }


    //Cliente
    @Override
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        return clienteMapper.toDto(clienteDao.save(clienteMapper.toEntity(clienteDto)));
    }
    @Override
    public ClienteDto listarClientePorId(Integer id) {
        return clienteMapper.toDto(clienteDao.listarClientePorId(id).orElse(null));
    }
    @Override
    public List<ClienteMaestroDto> listaClienteMaestro() {
        return clienteMaestroMapper.toDto(clienteDao.listarClientesMaestros());
    }
    @Override
    public List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro(boolean soloHabilitados) {
        if (soloHabilitados)
            return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findById_IdInternoClienteIsNotNullAndId_IdInternoCuentaIsNotNullAndHabilitadoIsTrue());
        return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findAll());
    }
    @Override
    public List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro() {
        return listarClienteCuentaMaestro(true);
    }
    @Override
    public ClienteCuentaMaestroDto listarClienteCuentaMaestroPorIdCuenta(Integer idInternoCuenta) {
        return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findById_IdInternoCuenta(idInternoCuenta));
    }


    //Cuenta
    @Override
    public List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente) {
        return cuentaMapper.toDto(cuentaDao.findByIdCliente(idCliente));
    }
    @Override
    public String listarCuentasPorIdCliente(Integer idCliente, String separador) {
        var listaCuentasAsList = this.listarCuentasPorIdCliente(idCliente);
        if (listaCuentasAsList==null || listaCuentasAsList.isEmpty())
            return "";
        StringBuilder listaCuentas = new StringBuilder();
        for (var cuenta : listaCuentasAsList) {
            listaCuentas.append(cuenta.getIdCuentaCustodio()).append(separador);
        }
        //Elimina el último separador
        return listaCuentas.substring(0, listaCuentas.length() - separador.length());
    }
    @Override
    public CuentaDto guardarCuenta(CuentaDto cuentaDto) {
        return cuentaMapper.toDto(cuentaDao.save(cuentaMapper.toEntity(cuentaDto)));
    }

    //Comisión Cuenta
    @Override
    public ComisionCuentaDto guardarComisionCuenta(ComisionCuentaDto comisionCuentaDto) {
        return comisionCuentaMapper.toDto(comisionCuentaDao.save(comisionCuentaMapper.toEntity(comisionCuentaDto)));
    }
    @Override
    public List<ComisionMaestroDto> listarComisionCuenta() {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findAll());
    }
    @Override
    public ComisionMaestroDto listarComisionCuentaById(Long id) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findById(id).orElse(null));
    }
    @Override
    public ComisionMaestroDto listarComisionCuentaByIdCuentaFechaInicioVigencia(Integer idCuenta, Date fechaInicioVigencia) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findByIdCuentaAndFechaInicioVigencia(idCuenta, fechaInicioVigencia).orElse(null));
    }
    @Override
    public List<ComisionMaestroDto> listarComisionCuentaByIdCuenta(Integer idCuenta) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findByIdCuenta(idCuenta));
    }


    //TipoIdentificador
    @Override
    public List<TipoIdentificadorDto> listarTiposIdentificador() {
        return tipoIdentificadorMapper.toDto(tipoIdentificadorDao.findAll());
    }

}
