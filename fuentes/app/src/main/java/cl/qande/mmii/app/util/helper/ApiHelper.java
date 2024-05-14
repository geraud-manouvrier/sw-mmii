package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppApiProperties;
import cl.qande.mmii.app.models.api.Cliente;
import cl.qande.mmii.app.models.api.Contrato;
import cl.qande.mmii.app.models.api.Cuenta;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.*;
import cl.qande.mmii.app.util.helper.mapper.FromApiToDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiHelper {

    @Autowired
    private IParametroCoreService parametroCoreService;
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IContratoService contratoService;
    @Autowired
    private ICuentaService cuentaService;
    @Autowired
    private IPerfilCuentaService perfilCuentaService;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private AppApiProperties appApiProperties;

    public void validateApiKey(String apiKey, String idAppCliente) throws QandeMmiiException {
        appConfig.customLog.info("Validando Api Key Cliente ["+idAppCliente+"]: ["+apiKey+"]");
        var paramApiKey = parametroCoreService.valorParametroCore("api.api_key",idAppCliente);
        if (paramApiKey==null || ! paramApiKey.equals(apiKey)) {
            appConfig.customLog.error("Error Api Key Cliente ["+idAppCliente+"]: ["+apiKey+"]");
            throw new QandeMmiiException("Api Key inválido");
        }
    }
    public boolean isEnabledApiArchivos() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledArchivos() );
    }
    public boolean isEnabledApiClientes() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledClientes() );
    }
    public boolean isEnabledApiContratos() {
        return ( appApiProperties.isEnabledGlobal() && appApiProperties.isEnabledContratos() );
    }


    public boolean creaCliente(Cliente clienteApi) {
        boolean estadoCreacion  = true;
        try {
            appConfig.customLog.info("Guardando Cliente ["+clienteApi.toString()+"]");
            var clienteDb   = FromApiToDb.getCliente(clienteApi);
            if (clienteService.isValid(clienteDb)) {
                clienteService.save(clienteDb);
                appConfig.customLog.info("Cliente guardado, iniciando guardado contratos...");
                for(Contrato contrato : clienteApi.getContratos()) {
                    if (! this.creaContrato(contrato, clienteApi.getId())) {
                        estadoCreacion  = false;
                    }
                }
            } else {
                appConfig.customLog.error("Cliente con errores, no guardado ["+clienteDb+"]");
                estadoCreacion  = false;
            }
        } catch (Exception e) {
            appConfig.customLog.error("Error en procesar Cliente ["+e.getMessage()+"]");
            estadoCreacion  = false;
        }
        return estadoCreacion;
    }
    public boolean creaContrato(Contrato contrato, String idCliente) {
        boolean estadoCreacion  = true;
        var contratoDb=FromApiToDb.getContrato(contrato, idCliente);
        if (contratoService.isValid(contratoDb)) {
            appConfig.customLog.info("Guardando Contrato ["+contratoDb.toString()+"]");
            contratoService.save(contratoDb);
            appConfig.customLog.info("Contrato guardado ["+contratoDb.toString()+"]");
        } else {
            appConfig.customLog.error("Contrato con errores, no guardado ["+contratoDb+"]");
            estadoCreacion  = false;
        }
        for(Cuenta cuenta : contrato.getCuentas()) {
            appConfig.customLog.info("Procesando cuenta ["+cuenta.toString()+"]");
            var cuentaDb    = FromApiToDb.getCuenta(cuenta, contrato.getId());
            if (cuentaService.isValid(cuentaDb)) {
                appConfig.customLog.info("Guardando Cuenta ["+cuentaDb.toString()+"]");
                cuentaService.save(cuentaDb);
                appConfig.customLog.info("Cuenta guardada ["+cuentaDb.toString()+"]");
            } else {
                appConfig.customLog.error("Cuenta con errores, no guardada ["+cuentaDb+"]");
                estadoCreacion  = false;
            }
            var perfilDb    = FromApiToDb.getPerfil(cuenta.getPerfil(), cuenta.getIdCuentaSura());
            if (perfilCuentaService.isValid(perfilDb)) {
                appConfig.customLog.info("Guardando Perfil ["+perfilDb.toString()+"]");
                perfilCuentaService.add(perfilDb);
                appConfig.customLog.info("Perfil guardado ["+perfilDb.toString()+"]");
            } else {
                appConfig.customLog.error("Perfil con errores, no guardado ["+perfilDb+"]");
                estadoCreacion  = false;
            }
            appConfig.customLog.info("Cuenta procesada ["+cuenta.toString()+"]");
        }
        return estadoCreacion;
    }
}
