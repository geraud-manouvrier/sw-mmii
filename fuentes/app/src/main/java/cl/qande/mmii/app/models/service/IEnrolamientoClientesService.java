package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.TipoIdentificadorDto;

import java.util.List;

public interface IEnrolamientoClientesService {

    //Cliente
    List<ClienteDto> listarClientes();

    ClienteDto guardarCliente(ClienteDto clienteDto);

    //Cliente por id
    ClienteDto listarClientePorId(Integer id);

    ClienteDto listarClientePorIdentificador(String identificador);

    //Cuenta
    List<CuentaDto> listarCuentas();

    List<CuentaDto> listarCuentasPorIdCuentaCustodio(String idCuentaCustodio);

    List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente);

    CuentaDto guardarCuenta(CuentaDto cuentaDto);

    //TipoIdentificador
    List<TipoIdentificadorDto> listarTiposIdentificador();

    TipoIdentificadorDto listarTipoIdentificadorPorId(Integer id);
}
