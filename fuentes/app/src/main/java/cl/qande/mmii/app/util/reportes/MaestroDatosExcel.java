package cl.qande.mmii.app.util.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.ReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.helper.ReportesMaestrosHelper;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class MaestroDatosExcel {


    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ReporteMaestroDatosService reporteMaestroDatosService;
    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;

    private CellStyle usaDateStyle;

    public void generaReportesExcel(String processDate) throws QandeMmiiException {
        this.usaDateStyle   = null;
        CustomLog.getInstance().info("Iniciando generación de Reporte Excel para fecha : ["+processDate+"]");
        this.generaReporteClientes(processDate);
        this.generaReporteMovimientos(processDate);
        this.generaReporteSaldos(processDate);
        CustomLog.getInstance().info("Generación reporte Excel finalizada");
    }

    public void generaReporteClientes(String processDate) throws QandeMmiiException {
        this.guardaExcel(this.reporteClientes(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_CLIENTES, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    public void generaReporteMovimientos(String processDate) throws QandeMmiiException {
        this.guardaExcel(this.reporteMovimientos(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_MOV, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    public void generaReporteSaldos(String processDate) throws QandeMmiiException {
        this.guardaExcel(this.reporteSaldos(processDate), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_SALDOS, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    private void guardaExcel(XSSFWorkbook reporteExcel, String nombreArchivo) throws QandeMmiiException {
        var dirReportes     = new File(appConfig.appConfigProperties.getReportesMaestrosFolder()).getAbsolutePath();
        String fileLocation = dirReportes + "/"+nombreArchivo;
        FileOutputStream outputStream;
        try {
            CustomLog.getInstance().info("Creando archivo en directorio...");
            outputStream = new FileOutputStream(fileLocation);
            CustomLog.getInstance().info("Escribiendo en disco...");
            reporteExcel.write(outputStream);
            CustomLog.getInstance().info("Cerrando archivo...");
            reporteExcel.close();
        } catch (FileNotFoundException e) {
            throw new QandeMmiiException(e, "Error al crear archivo excel");
        }catch (IOException e) {
            throw new QandeMmiiException(e, "Error al escribir/cerrar archivo excel archivo excel");
        }
    }

    private XSSFWorkbook reporteClientes(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Clientes para fecha : ["+processDate+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoClientes(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        Sheet sheet = reporteExcel.createSheet("Datos Clientes");
        var reporteClientes = reporteMaestroDatosService.generaReporteClientes(processDate);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        CustomLog.getInstance().info("Encabezados reporte Clientes generados; iniciando escritura de datos en excel.");
        for (VwReporteMaestroDatosCliente fila : reporteClientes) {
            row++;
            int col = 0;
            Row dataRow = sheet.createRow(row);
            this.addCell(dataRow, col++, fila.getCustodian(), null);
            this.addCell(dataRow, col++, fila.getClientId(), null);
            this.addCell(dataRow, col++, fila.getFirmNo(), null);
            this.addCell(dataRow, col++, fila.getSubNo(), null);
            this.addCell(dataRow, col++, fila.getRepNo(), null);


            this.addCell(dataRow, col++, fila.getOfficeId(), null);
            this.addCell(dataRow, col++, fila.getAccountNo(), null);
            this.addCell(dataRow, col++, fila.getName(), null);
            this.addCell(dataRow, col++, fila.getFullName(), null);
            this.addCell(dataRow, col++, fila.getAddress(), null);

            this.addCell(dataRow, col++, fila.getShortName(), null);
            this.addCell(dataRow, col++, fila.getDateOfBirth(), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getAcctStatusValue(), null);
            this.addCell(dataRow, col++, fila.getEmail(), null);
            this.addCell(dataRow, col++, fila.getCountryCodeValue(), null);

            this.addCell(dataRow, col++, fila.getCountry(), null);
            this.addCell(dataRow, col++, fila.getW8Date(), null);
            this.addCell(dataRow, col++, fila.getW9Date(), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getW8StatusValue(), null);
            this.addCell(dataRow, col++, fila.getW9StatusValue(), null);

            this.addCell(dataRow, col++, fila.getDiscrTradingCodeValue(), null);
            this.addCell(dataRow, col++, fila.getAccountType(), null);

            this.addCell(dataRow, col++, fila.getCashMarginAccount(), null);


            this.addCell(dataRow, col++, fila.getDebitCardIndicator(), null);
            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getOpenDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getCloseDate(), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getParticipantType(), null);





            this.addCell(dataRow, col++, fila.getLastStatementDate(), this.usaDateStyle);





            this.addCell(dataRow, col++, fila.getTaxId(), null);







        }
        CustomLog.getInstance().info("Datos agregados a excel Clientes.");
        return reporteExcel;
    }
    private XSSFWorkbook reporteMovimientos(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Movimientos para fecha : ["+processDate+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoMovimientos(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        String nombreHojaExcel  = "Movimientos";
        Sheet sheet = reporteExcel.createSheet(nombreHojaExcel);
        var reporteMovimientos = reporteMaestroDatosService.generaReporteMovimientos(processDate);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        CustomLog.getInstance().info("Encabezados reporte Movimientos generados; iniciando escritura de datos en excel.");
        for (VwReporteMaestroDatosMovimiento fila : reporteMovimientos) {
            row++;
            int col = 0;
            Row dataRow = sheet.createRow(row);
            this.addCell(dataRow, col++, fila.getCustodian(), null);
            this.addCell(dataRow, col++, fila.getClientId(), null);
            this.addCell(dataRow, col++, fila.getOfficeId(), null);
            this.addCell(dataRow, col++, fila.getAccountNo(), null);
            this.addCell(dataRow, col++, fila.getName(), null);

            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getProcessDate(), "yyyyMMdd"), this.usaDateStyle);
            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getTradeDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD), this.usaDateStyle);
            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getSettlementDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getActivity(), null);
            this.addCell(dataRow, col++, fila.getBuySell(), null);

            this.addCell(dataRow, col++, fila.getQuantity(), null);
            this.addCell(dataRow, col++, fila.getPrice(), null);
            this.addCell(dataRow, col++, fila.getComission(), null);
            this.addCell(dataRow, col++, fila.getFees(), null);
            this.addCell(dataRow, col++, fila.getNetAmount(), null);

            this.addCell(dataRow, col++, fila.getUsdeNetAmount(), null);
            this.addCell(dataRow, col++, fila.getPrincipal(), null);
            this.addCell(dataRow, col++, fila.getCusip(), null);
            this.addCell(dataRow, col++, fila.getSymbol(), null);
            this.addCell(dataRow, col++, fila.getIsin(), null);

            this.addCell(dataRow, col++, fila.getCurrency(), null);
            this.addCell(dataRow, col++, fila.getFxRate(), null);
            this.addCell(dataRow, col++, fila.getInterest(), null);
            this.addCell(dataRow, col++, fila.getCurrencyBase(), null);
            this.addCell(dataRow, col++, fila.getCashMarginAccount(), null);

            this.addCell(dataRow, col++, fila.getProductType(), null);
            this.addCell(dataRow, col++, fila.getSecurityDescription(), null);
            this.addCell(dataRow, col++, fila.getActivityDescription(), null);
            this.addCell(dataRow, col++, fila.getActivityCode(), null);
            this.addCell(dataRow, col++, fila.getSourceCode(), null);

            this.addCell(dataRow, col++, fila.getDescription1(), null);
            this.addCell(dataRow, col++, fila.getDescription2(), null);
            this.addCell(dataRow, col++, fila.getDescription3(), null);
            this.addCell(dataRow, col++, fila.getTicker(), null);

            this.addCell(dataRow, col++, fila.getIdSubSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getNombreSubSubTipoActivo(), null);

            this.addCell(dataRow, col, fila.getAplicaFlujoNeto(), null);

        }
        CustomLog.getInstance().info("Datos agregados a excel Movimientos.");
        return reporteExcel;
    }

    private XSSFWorkbook reporteSaldos(String processDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Iniciando generación de Reporte Saldos para fecha : ["+processDate+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoSaldos(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        Sheet sheet = reporteExcel.createSheet("Saldos");
        var reporteSaldos = reporteMaestroDatosService.generaReporteSaldos(processDate);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        CustomLog.getInstance().info("Encabezados reporte Saldos generados; iniciando escritura de datos en excel.");
        for (VwReporteMaestroDatosSaldo fila : reporteSaldos) {
            row++;
            int col = 0;
            Row dataRow = sheet.createRow(row);
            this.addCell(dataRow, col++, fila.getCustodian(), null);
            this.addCell(dataRow, col++, fila.getClientId(), null);
            this.addCell(dataRow, col++, fila.getOfficeId(), null);

            this.addCell(dataRow, col++, fila.getAccountNo(), null);
            this.addCell(dataRow, col++, fila.getName(), null);
            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getProcessDate(), "yyyyMMdd"), this.usaDateStyle);

            this.addCell(dataRow, col++, fila.getSymbol(), null);
            this.addCell(dataRow, col++, fila.getCusip(), null);
            this.addCell(dataRow, col++, fila.getIsin(), null);
            this.addCell(dataRow, col++, fila.getProductType(), null);
            this.addCell(dataRow, col++, fila.getSecurityDescription(), null);

            this.addCell(dataRow, col++, fila.getCashMarginAccount(), null);
            this.addCell(dataRow, col++, fila.getQuantity(), null);
            this.addCell(dataRow, col++, fila.getMarketPrice(), null);
            this.addCell(dataRow, col++, fila.getCurrency(), null);
            this.addCell(dataRow, col++, fila.getMarketValue(), null);

            this.addCell(dataRow, col++, fila.getFxRate(), null);
            this.addCell(dataRow, col++, fila.getUsdeMarketValue(), null);
            this.addCell(dataRow, col++, fila.getComisionDevengadaDiaria(), null);

            this.addCell(dataRow, col++, fila.getUsdeMarketPrice(), null);

            this.addCell(dataRow, col++, fila.getIdSubSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdTipoActivo(), null);

            this.addCell(dataRow, col++, fila.getNombreSubSubTipoActivo(), null);

        }
        CustomLog.getInstance().info("Datos agregados a excel Saldos.");
        return reporteExcel;
    }


    private void addCell(Row row, int column, Object cellValue, CellStyle customStyle) {
        var newCell = row.createCell(column);
        if (cellValue==null) {
            newCell.setCellValue("");
        } else {
            if (cellValue instanceof String) {
                newCell.setCellValue((String)cellValue);
            } else if (cellValue instanceof Double) {
                newCell.setCellValue((Double)cellValue);
            } else if (cellValue instanceof Integer) {
                newCell.setCellValue((Integer)cellValue);
            } else if (cellValue instanceof Date) {
                newCell.setCellValue((Date)cellValue);
            } else if (cellValue instanceof BigDecimal) {
                newCell.setCellValue(Double.valueOf(((BigDecimal)cellValue).doubleValue()));
            } else {
                newCell.setCellValue(cellValue.toString());
            }
        }

        if (customStyle!=null) {
            newCell.setCellStyle(customStyle);
        }
    }

}
