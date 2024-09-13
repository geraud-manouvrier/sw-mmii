package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.*;

import java.util.Date;
import java.util.List;

public interface IEnrolamientoClientesService {

    //Cliente

    ClienteDto guardarCliente(ClienteDto clienteDto);

    //Cliente por id
    ClienteDto listarClientePorId(Integer id);

    List<ClienteMaestroDto> listaClienteMaestro();

    //Cuenta

    List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro(boolean soloHabilitados);

    List<ClienteCuentaMaestroDto> listarClienteCuentaMaestro();

    ClienteCuentaMaestroDto listarClienteCuentaMaestroPorIdCuenta(Integer idInternoCuenta);

    List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente);

    String listarCuentasPorIdCliente(Integer idCliente, String separador);

    CuentaDto guardarCuenta(CuentaDto cuentaDto);

    //Comisión Cuenta
    //Implementa con mapper los métodos del DAO de comisión cuenta
    ComisionCuentaDto guardarComisionCuenta(ComisionCuentaDto comisionCuentaDto);

    List<ComisionMaestroDto> listarComisionCuenta();

    ComisionMaestroDto listarComisionCuentaById(Long id);

    ComisionMaestroDto listarComisionCuentaByIdCuentaFechaInicioVigencia(Integer idCuenta, Date fechaInicioVigencia);

    List<ComisionMaestroDto> listarComisionCuentaByIdCuenta(Integer idCuenta);

    //TipoIdentificador
    List<TipoIdentificadorDto> listarTiposIdentificador();

}
