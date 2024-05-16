package cl.qande.mmii.app.util.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import cl.qande.mmii.app.util.helper.mapper.ReportesMaestrosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MaestroDatosCsv {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IReporteMaestroDatosService reporteMaestroDatosService;

    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;
    @Autowired
    private ReportesMaestrosMapper reportesMaestrosMapper;

    public void generaReportesCsv(String processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte CSV para fecha : ["+processDate+"]");
        this.generaReporteClientes(processDate);
        this.generaReporteMovimientos(processDate);
        this.generaReporteSaldos(processDate);
        appConfig.customLog.info("Generación reporte CSV finalizada");
    }
    public void generaReporteClientes(String processDate) throws QandeMmiiException {
        reportesMaestrosHelper.guardaArchivoCsv(this.contenidoCsvReporteClientes(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_CLIENTES, ReportesMaestrosHelper.EXTENSION_CSV));
    }

    public void generaReporteMovimientos(String processDate) throws QandeMmiiException {
        reportesMaestrosHelper.guardaArchivoCsv(this.contenidoCsvReporteMovimientos(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_MOV, ReportesMaestrosHelper.EXTENSION_CSV));

    }

    public void generaReporteSaldos(String processDate) throws QandeMmiiException {
        reportesMaestrosHelper.guardaArchivoCsv(this.contenidoCsvReporteSaldos(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_SALDOS, ReportesMaestrosHelper.EXTENSION_CSV));
    }
    private ArrayList<String[]> contenidoCsvReporteClientes(String processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Clientes CSV para fecha : ["+processDate+"]");

        var dataReporteClientes	= reporteMaestroDatosService.generaReporteClientes(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoClientes(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosCliente fila: dataReporteClientes) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        appConfig.customLog.info("Datos CSV Clientes generados");
        return reporteCsv;
    }

    private ArrayList<String[]> contenidoCsvReporteSaldos(String processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Saldos CSV para fecha : ["+processDate+"]");

        var dataReporteSaldos	= reporteMaestroDatosService.generaReporteSaldos(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoSaldos(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosSaldo fila: dataReporteSaldos) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        appConfig.customLog.info("Datos CSV Saldos generados");
        return reporteCsv;
    }

    private ArrayList<String[]> contenidoCsvReporteMovimientos(String processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Movimientos CSV para fecha : ["+processDate+"]");

        var dataReporteMovimientos	= reporteMaestroDatosService.generaReporteMovimientos(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoMovimientos(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosMovimiento fila: dataReporteMovimientos) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        appConfig.customLog.info("Datos CSV Movimientos generados");
        return reporteCsv;
    }

}
