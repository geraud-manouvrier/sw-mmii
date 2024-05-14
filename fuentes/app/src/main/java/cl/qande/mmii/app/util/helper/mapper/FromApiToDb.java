package cl.qande.mmii.app.util.helper.mapper;

import cl.qande.mmii.app.models.api.Perfil;
import cl.qande.mmii.app.models.db.sura.entity.Cliente;
import cl.qande.mmii.app.models.db.sura.entity.Contrato;
import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import cl.qande.mmii.app.util.helper.CalendarioHelper;

import java.text.ParseException;

public interface FromApiToDb {
    public static PerfilCuenta getPerfil(Perfil perfilApi, String idCuentaSura) {
        var calendarioHelper    = new CalendarioHelper();
        var perfilCuenta        = new PerfilCuenta();
        perfilCuenta.setIdPerfil(perfilApi.getId());
        perfilCuenta.setIdCuentaSura(idCuentaSura);
        perfilCuenta.setPortfolio(perfilApi.getPortfolio());
        perfilCuenta.setMontoComprometido(perfilApi.getMontoComprometido());
        perfilCuenta.setFechaVigencia(calendarioHelper.hoyConDesfaseDias(0));
        perfilCuenta.setHorizonteObjetivo(perfilApi.getHorizonteObjetivo());
        perfilCuenta.setExencionResponsabilidad(perfilApi.getExencionResponsabilidad());
        return perfilCuenta;
    }

    public static Cuenta getCuenta(cl.qande.mmii.app.models.api.Cuenta cuentaApi, String idContrato) {
        var cuenta = new Cuenta();
        cuenta.setIdCuentaSura(cuentaApi.getIdCuentaSura());
        cuenta.setIdCuentaCustodio(cuentaApi.getIdCuentaCustodio());
        cuenta.setCustodio(cuentaApi.getCustodio());
        cuenta.setModeloAsesoria(cuentaApi.getModeloAsesoria());
        cuenta.setMontoFondeo(cuentaApi.getMontoFondeo());
        cuenta.setIdContrato(idContrato);
        cuenta.setCodPaisAtencion(cuentaApi.getCodPaisAtencion());
        cuenta.setDescripcionObjetivo(cuentaApi.getDescripcionObjetivo());
        cuenta.setBeneficiarios(cuentaApi.getBeneficiarios());
        return cuenta;
    }

    public static Contrato getContrato(cl.qande.mmii.app.models.api.Contrato contratoApi, String idCliente) {
        var contrato = new Contrato();
        contrato.setId(contratoApi.getId());
        contrato.setTipoCuenta(contratoApi.getTipoCuenta());
        contrato.setTipoServicio(contratoApi.getTipoServicio());
        contrato.setTarifaNegociada(contratoApi.getTarifaNegociada());
        contrato.setIdCliente(idCliente);
        return contrato;
    }

    public static Cliente getCliente(cl.qande.mmii.app.models.api.Cliente clienteApi) throws ParseException {
        var calendarioHelper    = new CalendarioHelper();
        var cliente = new Cliente();
        cliente.setId(clienteApi.getId());
        cliente.setFechaNacimiento(calendarioHelper.convierteFechaStrToFormatoBd(clienteApi.getFechaNacimiento()));
        cliente.setNombre(clienteApi.getNombre());
        cliente.setCodPaisResidencia(clienteApi.getPaisResidencia());
        cliente.setMail(clienteApi.getMail());
        cliente.setAsesorPrincipal(clienteApi.getAsesorPrincipal());
        cliente.setAsesorSecundario(clienteApi.getAsesorSecundario());
        cliente.setMailAsesorPrincipal(clienteApi.getMailAsesorPrincipal());
        cliente.setMailAsesorSecundario(clienteApi.getMailAsesorSecundario());
        cliente.setCodPaisAtencion(clienteApi.getCodPaisAtencion());
        cliente.setResidenteFiscalUsa(clienteApi.getResidenteFiscalUsa());
        return cliente;
    }
}
