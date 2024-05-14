package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.dao.IReporteMaestroDatosClientesDao;
import cl.qande.mmii.app.models.db.core.entity.UniversoClienteProjection;
import cl.qande.mmii.app.models.db.core.entity.UniversoCuentaProjection;
import cl.qande.mmii.app.models.db.rep_inv.dao.*;
import cl.qande.mmii.app.models.db.rep_inv.entity.*;
import cl.qande.mmii.app.models.db.sura.dao.IClienteDao;
import cl.qande.mmii.app.models.db.sura.dao.IContratoDao;
import cl.qande.mmii.app.models.db.sura.dao.ICuentaDao;
import cl.qande.mmii.app.models.db.sura.dao.IPerfilCuentaDao;
import cl.qande.mmii.app.models.db.sura.entity.Cuenta;
import cl.qande.mmii.app.models.db.sura.entity.PerfilCuenta;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.ContratoDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.PerfilCuentaDto;
import cl.qande.mmii.app.models.dto.reporte_inversiones.ReporteInversionesClienteDto;
import cl.qande.mmii.app.models.service.IReporteInversionesService;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.mapper.ClienteMapper;
import cl.qande.mmii.app.util.helper.mapper.ContratoMapper;
import cl.qande.mmii.app.util.helper.mapper.CuentaMapper;
import cl.qande.mmii.app.util.helper.mapper.PerfilCuentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReporteInversionesImpl implements IReporteInversionesService {

    @Autowired
    private IRentabilidadCalculadaDetalladaDao rentabilidadCalculadaDetalladaDao;
    @Autowired
    private IRentabilidadCalculadaDao rentabilidadCalculadaDao;
    @Autowired
    private IVwBaseConsolidadoDao vwBaseConsolidadoDao;
    @Autowired
    private IConsolidadoAgregadoN1Dao consolidadoAgregadoN1Dao;
    @Autowired
    private IConsolidadoAgregadoN2Dao consolidadoAgregadoN2Dao;
    @Autowired
    private IReporteMaestroDatosClientesDao reporteMaestroDatosClientesDao;
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IContratoDao contratoDao;
    @Autowired
    private ICuentaDao cuentaDao;
    @Autowired
    private IPerfilCuentaDao perfilCuentaDao;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ContratoMapper contratoMapper;
    @Autowired
    private CuentaMapper cuentaMapper;
    @Autowired
    private PerfilCuentaMapper perfilCuentaMapper;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ArchivosHelper archivosHelper;
    @Autowired
    private CalendarioHelper calendarioHelper;


    @Override
    public List<RentabilidadCalculadaDetallada> calculaRentabilidadDetallada(String agregadorN1, String agregadorN2, String agregadorN3, String agregadorN4, String fechaDesde, String fechaHasta) {
        if (agregadorN2 != null && agregadorN2.isBlank()) {
            agregadorN2 = null;
        }
        if (agregadorN3 != null && agregadorN3.isBlank()) {
            agregadorN3 = null;
        }
        if (agregadorN4 != null && agregadorN4.isBlank()) {
            agregadorN4 = null;
        }
        return rentabilidadCalculadaDetalladaDao.calculaRentabilidadDetallada(agregadorN1, agregadorN2, agregadorN3, agregadorN4, fechaDesde, fechaHasta);
    }


    @Override
    public List<RentabilidadCalculada> calculaRentabilidad(String agregadorN1, String agregadorN2, String agregadorN3, String agregadorN4, String startProcessDate, String endProcessDate, boolean todosNiveles) {
        if (agregadorN2 != null && agregadorN2.isBlank()) {
            agregadorN2 = null;
        }
        if (agregadorN3 != null && agregadorN3.isBlank()) {
            agregadorN3 = null;
        }
        if (agregadorN4 != null && agregadorN4.isBlank()) {
            agregadorN4 = null;
        }
        return rentabilidadCalculadaDao.calculaRentabilidad(agregadorN1, agregadorN2, agregadorN3, agregadorN4, startProcessDate, endProcessDate, todosNiveles);
    }


    @Override
    public List<RentabilidadCalculada> rentabilidadAnualBase100(String agregadorN1, String endProcessDate) {
        String starProcessDate = calendarioHelper.convierteDateToStringWithFormat(calendarioHelper.makeDateFromParts(Integer.valueOf(endProcessDate.substring(0, 4)), Integer.valueOf(endProcessDate.substring(4, 6))-12, 1), "yyyyMMdd");
        return this.calculaRentabilidad(agregadorN1, null, null, null, starProcessDate, endProcessDate, false);
    }

    @Override
    public List<VwBaseConsolidado> listaBaseConsolidadaPorClienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber) {
        if (accountNumber != null && accountNumber.isBlank()) {
            accountNumber = null;
    }
        return vwBaseConsolidadoDao.listaBaseConsolidadaPorClienteCuenta(fechaDesde, fechaHasta, clientId, accountNumber);
    }
    @Override
    public List<ConsolidadoAgregadoN1> listaConsolidadoAgregadoPorcliente(String fechaDesde, String fechaHasta, String clientId) {
        return consolidadoAgregadoN1Dao.listaConsolidadoAgregado(fechaDesde, fechaHasta, clientId);
    }

    @Override
    public List<ConsolidadoAgregadoN2> listaConsolidadoAgregadoPorclienteCuenta(String fechaDesde, String fechaHasta, String clientId, String accountNumber) {
        if (accountNumber != null && accountNumber.isBlank()) {
            accountNumber = null;
        }
        return consolidadoAgregadoN2Dao.listaConsolidadoAgregado(fechaDesde, fechaHasta, clientId, accountNumber);
    }

    @Override
    public List<UniversoClienteProjection> listaUniversoClientes(String processDate) {
        return reporteMaestroDatosClientesDao.listaUniversoClientes(processDate);
    }
    @Override
    public List<UniversoCuentaProjection> listaUniversoCuentas(String processDate) {
        return reporteMaestroDatosClientesDao.listaUniversoCuentas(processDate);
    }

    @Override
    public List<String> listaBaseClientes() {
        return vwBaseConsolidadoDao.listaClientes();
    }
    @Override
    public List<String> listaBaseCuentas() {
        return vwBaseConsolidadoDao.listaCuentas();
    }


    @Override
    public ClienteDto getCliente(String clientId) {
        var clienteBd=clienteDao.findById(clientId).orElse(null);
        if(clienteBd!=null) {
            return clienteMapper.toDto(clienteBd);
        }
        return null;
    }

    @Override
    public List<ContratoDto> getContratos(String clientId) {
        var contratoBd=contratoDao.findByIdCliente(clientId);
        if(contratoBd!=null) {
            return contratoMapper.toDto(contratoBd);
        }
        return Collections.emptyList();
    }

    @Override
    public List<CuentaDto> getCuentasPorCliente(String clientId) {
        var listaContratos=contratoDao.findByIdCliente(clientId);
        List<Cuenta> listaCuentasBd=new ArrayList<>();
        for (var contrato : listaContratos) {
            var cuentas= cuentaDao.findByIdContrato(contrato.getId());
            listaCuentasBd.addAll(cuentas);
        }
        return cuentaMapper.toDto(listaCuentasBd);
    }

    @Override
    public List<CuentaDto> getCuentasPorContrato(String idContrato) {
        return cuentaMapper.toDto(cuentaDao.findByIdContrato(idContrato));
    }

    @Override
    public List<PerfilCuentaDto> getCuentasPerfilPorCliente(String clientId) {
        var listaContratos=contratoDao.findByIdCliente(clientId);
        List<Cuenta> listaCuentasBd=new ArrayList<>();
        List<PerfilCuenta> perfilCuentaBd=new ArrayList<>();
        for (var contrato : listaContratos) {
            var cuentas= cuentaDao.findByIdContrato(contrato.getId());
            listaCuentasBd.addAll(cuentas);
        }
        for(var cuentaBd : listaCuentasBd) {
            var listaPerfilCuentaBd=perfilCuentaDao.findFirstByIdCuentaSuraOrderByFechaVigenciaDesc(cuentaBd.getIdCuentaSura());
            perfilCuentaBd.add(listaPerfilCuentaBd);
        }
        return perfilCuentaMapper.toDto(perfilCuentaBd);
    }

    @Override
    public PerfilCuentaDto getCuentaPerfilPorCuenta(String idInternoCuenta) {
        var listaPerfilCuentaBd=perfilCuentaDao.findFirstByIdCuentaSuraOrderByFechaVigenciaDesc(idInternoCuenta);
        return perfilCuentaMapper.toDto(listaPerfilCuentaBd);
    }

    @Override
    public ReporteInversionesClienteDto generaReporteInversionesCliente(String idCliente, String processDate) {
        var clienteDto	= this.getCliente(idCliente);
        var listaContratosDto	= this.getContratos(idCliente);

        ReporteInversionesClienteDto reporteInversionesClienteDto = new ReporteInversionesClienteDto(idCliente, processDate);
        var rentabilidadCliente	= this.calculaRentabilidad(idCliente, null, null, null, processDate, processDate, false);
        var rentabilidadAnualBase100Cliente	= this.rentabilidadAnualBase100(idCliente, processDate);

        if ( (rentabilidadCliente!=null) && ( ! rentabilidadCliente.isEmpty()) ) {
            var rentabilidadClienteDto	= rentabilidadCliente.get(0);
            if (! rentabilidadClienteDto.getNivel().equals("N1")) {
                appConfig.customLog.error("La rentabilidad obtenida para el Cliente no es agregada por idCliente [" + idCliente+"] y fecha ["+processDate+"]: ["+rentabilidadClienteDto+"]");
                return reporteInversionesClienteDto;
            }
            reporteInversionesClienteDto.initialize(clienteDto, rentabilidadClienteDto, rentabilidadAnualBase100Cliente);
            for (var contratoDto : listaContratosDto) {
                var listaCuentasDto	= this.getCuentasPorContrato(contratoDto.getId());
                for (var cuentaDto : listaCuentasDto) {
                    var perfilCuentaDto	= this.getCuentaPerfilPorCuenta(cuentaDto.getIdCuentaSura());
                    if (perfilCuentaDto!=null) {
                        var agregador2	= cuentaDto.getCustodio().toUpperCase().concat("||").concat(cuentaDto.getIdCuentaCustodio());
                        var rentabilidadCuentas	= this.calculaRentabilidad(idCliente, agregador2, null, null, processDate, processDate, false);
                        if ( (rentabilidadCuentas!=null) && ( ! rentabilidadCuentas.isEmpty()) ) {
                            reporteInversionesClienteDto.addDatosCuenta(contratoDto, cuentaDto, perfilCuentaDto, rentabilidadCuentas.get(0));
                        } else {
                            appConfig.customLog.error("No hay rentabilidades de cuenta para agregadorN1-agregadorN2-processDate: [" + idCliente + " - " + agregador2 + " - " + processDate+"]");
                        }
                    } else {
                        appConfig.customLog.error("No hay PerfilCuenta Vigente para id cuenta: " + cuentaDto.getIdCuentaSura());
                    }
                }
            }
        } else {
            appConfig.customLog.error("No hay rentabilidad de Cliente para cliente [" + idCliente+"] y fecha ["+processDate+"]");
        }

        return reporteInversionesClienteDto;
    }

    @Override
    public String preCalculoDiarioRentabilidad(String startProcessDate, String endProcessDate) {
        return rentabilidadCalculadaDao.preCalculoDiario(startProcessDate, endProcessDate);
    }
}
