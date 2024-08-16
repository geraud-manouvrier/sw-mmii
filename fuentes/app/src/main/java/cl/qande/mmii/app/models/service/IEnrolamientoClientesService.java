package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.ClienteMaestroDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.TipoIdentificadorDto;

import java.util.List;

public interface IEnrolamientoClientesService {

    //Cliente

    ClienteDto guardarCliente(ClienteDto clienteDto);

    //Cliente por id
    ClienteDto listarClientePorId(Integer id);

    List<ClienteMaestroDto> listaClienteMaestro();

    //Cuenta

    List<CuentaDto> listarCuentasPorIdCliente(Integer idCliente);

    String listarCuentasPorIdCliente(Integer idCliente, String separador);

    CuentaDto guardarCuenta(CuentaDto cuentaDto);

    //TipoIdentificador
    List<TipoIdentificadorDto> listarTiposIdentificador();

}
