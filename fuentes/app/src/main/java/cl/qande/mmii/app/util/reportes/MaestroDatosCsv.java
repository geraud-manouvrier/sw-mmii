package cl.qande.mmii.app.util.reportes;

import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosRelacionado;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import cl.qande.mmii.app.util.mapper.ReportesMaestrosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MaestroDatosCsv {
    private final ReporteMaestroDatosService reporteMaestroDatosService;
    private final ReportesMaestrosHelper reportesMaestrosHelper;
    private final ReportesMaestrosMapper reportesMaestrosMapper;

    @Autowired
    public MaestroDatosCsv(ReporteMaestroDatosService reporteMaestroDatosService, ReportesMaestrosHelper reportesMaestrosHelper, ReportesMaestrosMapper reportesMaestrosMapper) {
        this.reporteMaestroDatosService = reporteMaestroDatosService;
        this.reportesMaestrosHelper = reportesMaestrosHelper;
        this.reportesMaestrosMapper = reportesMaestrosMapper;
    }

    public void generaReportesCsv(String processDate, boolean generarClientes, boolean generarMovimientos, boolean generarSaldos, boolean generarRelacionados) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte CSV para fecha : ["+processDate+"]");
        if (generarClientes)
            this.generaReporteClientes(processDate);
        if (generarMovimientos)
            this.generaReporteMovimientos(processDate);
        if (generarSaldos)
            this.generaReporteSaldos(processDate);
        if (generarRelacionados)
            this.generaReporteRelacionados(processDate);
        CustomLog.getInstance().info("Generación reporte CSV finalizada");
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

    public void generaReporteRelacionados(String processDate) throws QandeMmiiException {
        reportesMaestrosHelper.guardaArchivoCsv(this.contenidoCsvReporteRelacionados(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_REL, ReportesMaestrosHelper.EXTENSION_CSV));
    }


    private ArrayList<String[]> contenidoCsvReporteClientes(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Clientes CSV para fecha : ["+processDate+"]");

        var dataReporteClientes	= reporteMaestroDatosService.generaReporteClientes(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoClientes(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosCliente fila: dataReporteClientes) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        CustomLog.getInstance().info("Datos CSV Clientes generados");
        return reporteCsv;
    }

    private ArrayList<String[]> contenidoCsvReporteSaldos(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Saldos CSV para fecha : ["+processDate+"]");

        var dataReporteSaldos	= reporteMaestroDatosService.generaReporteSaldos(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoSaldos(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosSaldo fila: dataReporteSaldos) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        CustomLog.getInstance().info("Datos CSV Saldos generados");
        return reporteCsv;
    }

    private ArrayList<String[]> contenidoCsvReporteRelacionados(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Relacionados CSV para fecha : ["+processDate+"]");

        var dataReporteRelacionados	= reporteMaestroDatosService.generaReporteRelacionados(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoRelacionados(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosRelacionado fila: dataReporteRelacionados) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        CustomLog.getInstance().info("Datos CSV Relacionados generados");
        return reporteCsv;
    }

    private ArrayList<String[]> contenidoCsvReporteMovimientos(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Movimientos CSV para fecha : ["+processDate+"]");

        var dataReporteMovimientos	= reporteMaestroDatosService.generaReporteMovimientos(processDate);
        var reporteCsv          = new ArrayList<String[]>();
        reporteCsv.add(reportesMaestrosHelper.encabezadoMovimientos(ReportesMaestrosHelper.EXTENSION_CSV));

        for(VwReporteMaestroDatosMovimiento fila: dataReporteMovimientos) {
            var dataRow = reportesMaestrosMapper.getFromDbToCsvLine(fila);
            reporteCsv.add(dataRow.toArray(new String[dataRow.size()]));
        }
        CustomLog.getInstance().info("Datos CSV Movimientos generados");
        return reporteCsv;
    }

}
