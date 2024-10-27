package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.db.clientes.dao.*;
import cl.qande.mmii.app.models.dto.*;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.helper.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnrolamientoClientesService {


    //DAOs
    private final ITipoIdentificadorDao tipoIdentificadorDao;
    private final IClienteDao clienteDao;
    private final ICuentaDao cuentaDao;
    private final IComisionCuentaDao comisionCuentaDao;
    private final IComisionMaestroDao comisionMaestroDao;
    private final IClienteCuentaMaestroDao clienteCuentaMaestroDao;
    private final IPersonaRelacionadaDao personaRelacionadaDao;
    //Mappers
    private final CuentaMapper cuentaMapper;
    private final TipoIdentificadorMapper tipoIdentificadorMapper;
    private final ClienteMapper clienteMapper;
    private final ClienteMaestroMapper clienteMaestroMapper;
    private final ComisionCuentaMapper comisionCuentaMapper;
    private final ClienteCuentaMaestroMapper clienteCuentaMaestroMapper;
    private final ComisionMaestroMapper comisionMaestroMapper;
    private final PersonaRelacionadaMapper personaRelacionadaMapper;

    @Autowired
    public EnrolamientoClientesService(ITipoIdentificadorDao tipoIdentificadorDao, IClienteDao clienteDao, ICuentaDao cuentaDao, IComisionCuentaDao comisionCuentaDao, IComisionMaestroDao comisionMaestroDao, IClienteCuentaMaestroDao clienteCuentaMaestroDao, IPersonaRelacionadaDao personaRelacionadaDao, CuentaMapper cuentaMapper, TipoIdentificadorMapper tipoIdentificadorMapper, ClienteMapper clienteMapper, ClienteMaestroMapper clienteMaestroMapper, ComisionCuentaMapper comisionCuentaMapper, ClienteCuentaMaestroMapper clienteCuentaMaestroMapper, ComisionMaestroMapper comisionMaestroMapper, PersonaRelacionadaMapper personaRelacionadaMapper) {
        this.tipoIdentificadorDao = tipoIdentificadorDao;
        this.clienteDao = clienteDao;
        this.cuentaDao = cuentaDao;
        this.comisionCuentaDao = comisionCuentaDao;
        this.comisionMaestroDao = comisionMaestroDao;
        this.clienteCuentaMaestroDao = clienteCuentaMaestroDao;
        this.personaRelacionadaDao = personaRelacionadaDao;
        this.cuentaMapper = cuentaMapper;
        this.tipoIdentificadorMapper = tipoIdentificadorMapper;
        this.clienteMapper = clienteMapper;
        this.clienteMaestroMapper = clienteMaestroMapper;
        this.comisionCuentaMapper = comisionCuentaMapper;
        this.clienteCuentaMaestroMapper = clienteCuentaMaestroMapper;
        this.comisionMaestroMapper = comisionMaestroMapper;
        this.personaRelacionadaMapper = personaRelacionadaMapper;
    }

    @Transactional
    public void guardarCliente(ClienteDto clienteDto, List<PersonaRelacionadaDto> personasRelacionadas, String cuenta, boolean esClienteNuevo, String user) {

        var clienteGuardado = this.guardarCliente(clienteDto);
        CustomLog.getInstance().info("Guardado Cliente ID  ["+clienteDto.toString()+"] ");
        boolean esNit   = this.tipoIdentificadorById(clienteGuardado.getIdTipoIdentificador()).getFlagTieneRelacionados().equals(Boolean.TRUE);
        if (esClienteNuevo) {
            var cuentaDto   = this.guardarCuentaDeCliente(clienteGuardado.getId(), cuenta);
            CustomLog.getInstance().info("Guardada Cuenta Cliente ID  ["+cuentaDto+"] ");
        }
        //Guardamos personas relacioandas
        if ( esNit &&  ( !personasRelacionadas.isEmpty() ) ) {
            this.guardarRelacionados(personasRelacionadas, clienteGuardado.getId(), user);
            CustomLog.getInstance().info("Guardadas Personas Relacionadas  ["+personasRelacionadas+"] ");
        } else {
            this.cambiaFlagHabilitadoRelacionado(clienteGuardado.getId(), user, false);
            CustomLog.getInstance().info("Inhabilitadas Personas Relacionadas  para Cliente ["+clienteDto+"] ");
        }
    }



    //Cliente
    @Transactional
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        return clienteMapper.toDto(clienteDao.save(clienteMapper.toEntity(clienteDto)));
    }
    @Transactional(readOnly = true)
    public ClienteDto listarClientePorId(Integer id) {
        return clienteMapper.toDto(clienteDao.listarClientePorId(id).orElse(null));
    }
    @Transactional(readOnly = true)
    public List<ClienteMaestroDto> listaClienteMaestro() {
        return clienteMaestroMapper.toDto(clienteDao.listarClientesMaestros());
    }
    @Transactional(readOnly = true)
    public List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro(boolean soloHabilitados) {
        if (soloHabilitados)
            return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findById_IdInternoClienteIsNotNullAndId_IdInternoCuentaIsNotNullAndHabilitadoIsTrue());
        return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findAll());
    }
    @Transactional(readOnly = true)
    public List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro() {
        return this.listarClienteCuentaMaestro(true);
    }
    @Transactional(readOnly = true)
    public ClienteCuentaMaestroDto listarClienteCuentaMaestroPorIdCuenta(Integer idInternoCuenta) {
        return clienteCuentaMaestroMapper.toDto(clienteCuentaMaestroDao.findById_IdInternoCuenta(idInternoCuenta));
    }


    //Cuenta
    @Transactional(readOnly = true)
    public List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente) {
        return cuentaMapper.toDto(cuentaDao.findByIdCliente(idCliente));
    }
    @Transactional(readOnly = true)
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
    @Transactional
    public CuentaDto guardarCuenta(CuentaDto cuentaDto) {
        return cuentaMapper.toDto(cuentaDao.save(cuentaMapper.toEntity(cuentaDto)));
    }
    @Transactional
    public CuentaDto guardarCuentaDeCliente(Integer idCliente, String cuenta) {
        var cuentaDto = new CuentaDto();
        cuentaDto.setIdCliente(idCliente);
        cuentaDto.setIdCuentaCustodio(cuenta);
        cuentaDto.setIdCustodio("pershing");
        cuentaDto.setHabilitado(true);
        return this.guardarCuenta(cuentaDto);
    }

    //Comisión Cuenta
    @Transactional
    public ComisionCuentaDto guardarComisionCuenta(ComisionCuentaDto comisionCuentaDto) {
        return comisionCuentaMapper.toDto(comisionCuentaDao.save(comisionCuentaMapper.toEntity(comisionCuentaDto)));
    }
    @Transactional(readOnly = true)
    public List<ComisionMaestroDto> listarComisionCuenta() {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findAll());
    }
    @Transactional(readOnly = true)
    public ComisionMaestroDto listarComisionCuentaById(Long id) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findById(id).orElse(null));
    }
    @Transactional(readOnly = true)
    public ComisionMaestroDto listarComisionCuentaByIdCuentaFechaInicioVigencia(Integer idCuenta, Date fechaInicioVigencia) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findByIdCuentaAndFechaInicioVigencia(idCuenta, fechaInicioVigencia).orElse(null));
    }
    @Transactional(readOnly = true)
    public List<ComisionMaestroDto> listarComisionCuentaByIdCuenta(Integer idCuenta) {
        return comisionMaestroMapper.toDto(comisionMaestroDao.findByIdCuenta(idCuenta));
    }

    //Persona Relacionada
    @Transactional
    public PersonaRelacionadaDto guardarRelacionado(PersonaRelacionadaDto personaRelacionadaDto, String usuario) {
        var ahora                   = Instant.now();
        var relacionadoExistente    = this.relacionadoPorIdentificador(personaRelacionadaDto.getIdentificador(), personaRelacionadaDto.getIdCliente());
        if (relacionadoExistente != null) {
            personaRelacionadaDto.setId(relacionadoExistente.getId());
            personaRelacionadaDto.setCreacionUser(relacionadoExistente.getCreacionUser());
            personaRelacionadaDto.setCreacionTs(relacionadoExistente.getCreacionTs());
        }
        if (personaRelacionadaDto.getId()==null || personaRelacionadaDto.getId()<0) {
            personaRelacionadaDto.setCreacionUser(usuario);
            personaRelacionadaDto.setCreacionTs(ahora);
        }
        personaRelacionadaDto.setModificacionUser(usuario);
        personaRelacionadaDto.setModificacionTs(ahora);
        return personaRelacionadaMapper.toDto(personaRelacionadaDao.save(personaRelacionadaMapper.toEntity(personaRelacionadaDto)));
    }


    @Transactional
    public List<PersonaRelacionadaDto> guardarRelacionados(List<PersonaRelacionadaDto> listaPersonasRelacionadasDto, Integer idCliente, String usuario) {
        this.cambiaFlagHabilitadoRelacionados(idCliente, false, usuario);
        List<PersonaRelacionadaDto> registrosGuardados  = new ArrayList<>();
        for (PersonaRelacionadaDto persona : listaPersonasRelacionadasDto) {
            CustomLog.getInstance().info("Persona relacioandas: ["+persona+"]");
            persona.setIdCliente(idCliente);
            persona.setFlagHabilitado(true);
            registrosGuardados.add(this.guardarRelacionado(persona, usuario));
        }
        return registrosGuardados;
    }
    @Transactional
    public void cambiaFlagHabilitadoRelacionado(Integer idCliente, String usuario, boolean newFlag) {
        CustomLog.getInstance().info("Cambiando a flag ["+newFlag+"] Personas relacionadas: ["+idCliente+"]");
        var relacionadosDelCliente  = this.listarRelacionadosPorIdCliente(idCliente, !newFlag);
        for (var personaRelacionadaDto : relacionadosDelCliente ) {
            personaRelacionadaDto.setFlagHabilitado(newFlag);
            this.guardarRelacionado(personaRelacionadaDto, usuario);
        }
    }
    @Transactional(readOnly = true)
    public PersonaRelacionadaDto relacionadoPorIdentificador(String id, Integer idCliente) {
        return personaRelacionadaMapper.toDto(personaRelacionadaDao.findByIdentificadorAndIdCliente(id, idCliente).orElse(null));
    }
    @Transactional(readOnly = true)
    public List<PersonaRelacionadaDto> listarRelacionadosPorIdCliente (Integer id, boolean flagHabilitado) {
        return personaRelacionadaMapper.toDto(personaRelacionadaDao.listarRelacionadosPorIdCliente(id, flagHabilitado));
    }
    @Transactional
    public void cambiaFlagHabilitadoRelacionados(Integer idCliente, boolean newFlag, String user) {
        personaRelacionadaDao.cambiaFlagHabilitadoRelacionadosPorIdCliente(idCliente, newFlag, Instant.now(), user);
    }



    //TipoIdentificador
    @Transactional(readOnly = true)
    public List<TipoIdentificadorDto> listarTiposIdentificador() {
        return tipoIdentificadorMapper.toDto(tipoIdentificadorDao.findAllByOrderByTipoIdentificadorAsc());
    }
    @Transactional(readOnly = true)
    public TipoIdentificadorDto tipoIdentificadorById(Integer id) {
        return tipoIdentificadorMapper.toDto(tipoIdentificadorDao.findById(id).orElse(null));
    }



}
