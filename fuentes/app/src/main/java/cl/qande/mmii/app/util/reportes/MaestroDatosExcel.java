package cl.qande.mmii.app.util.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosCliente;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosMovimiento;
import cl.qande.mmii.app.models.db.core.entity.VwReporteMaestroDatosSaldo;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
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
    private IReporteMaestroDatosService reporteMaestroDatosService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private ReportesMaestrosHelper reportesMaestrosHelper;

    private CellStyle usaDateStyle;

    public void generaReportesExcel(String processDate, String varianteReporte) throws QandeMmiiException {
        this.usaDateStyle   = null;
        appConfig.customLog.info("Iniciando generación de Reporte Excel para fecha : ["+processDate+"] variante ["+varianteReporte+"]");
        this.generaReporteClientes(processDate, varianteReporte);
        this.generaReporteMovimientos(processDate, varianteReporte);
        this.generaReporteSaldos(processDate, varianteReporte);
        appConfig.customLog.info("Generación reporte Excel finalizada");
    }

    public void generaReporteClientes(String processDate, String varianteReporte) throws QandeMmiiException {
        this.guardaExcel(this.reporteClientes(processDate, varianteReporte), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_CLIENTES, varianteReporte, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    public void generaReporteMovimientos(String processDate, String varianteReporte) throws QandeMmiiException {
        this.guardaExcel(this.reporteMovimientos(processDate, 0, varianteReporte), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_MOV_TRADE, varianteReporte, ReportesMaestrosHelper.EXTENSION_EXCEL));
        this.guardaExcel(this.reporteMovimientos(processDate, 1, varianteReporte), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_MOV_EYS, varianteReporte, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    public void generaReporteSaldos(String processDate, String varianteReporte) throws QandeMmiiException {
        this.guardaExcel(this.reporteSaldos(processDate, varianteReporte), reportesMaestrosHelper.generaNombreReporte(processDate, ReportesMaestrosHelper.REPORTE_SALDOS, varianteReporte, ReportesMaestrosHelper.EXTENSION_EXCEL));
    }

    private void guardaExcel(XSSFWorkbook reporteExcel, String nombreArchivo) throws QandeMmiiException {
        var dirReportes     = new File(appConfig.appConfigProperties.getReportesMaestrosFolder()).getAbsolutePath();
        String fileLocation = dirReportes + "/"+nombreArchivo;
        FileOutputStream outputStream;
        try {
            appConfig.customLog.info("Creando archivo en directorio...");
            outputStream = new FileOutputStream(fileLocation);
            appConfig.customLog.info("Escribiendo en disco...");
            reporteExcel.write(outputStream);
            appConfig.customLog.info("Cerrando archivo...");
            reporteExcel.close();
        } catch (FileNotFoundException e) {
            throw new QandeMmiiException(e, "Error al crear archivo excel");
        }catch (IOException e) {
            throw new QandeMmiiException(e, "Error al escribir/cerrar archivo excel archivo excel");
        }
    }

    private XSSFWorkbook reporteClientes(String processDate, String varianteReporte) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Clientes para fecha : ["+processDate+"] variante ["+varianteReporte+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoClientes(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        Sheet sheet = reporteExcel.createSheet("Datos Clientes");
        var reporteClientes = reporteMaestroDatosService.generaReporteClientes(processDate, varianteReporte);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        appConfig.customLog.info("Encabezados reporte Clientes generados; iniciando escritura de datos en excel.");
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
            this.addCell(dataRow, col++, fila.getContratosPa(), null);
            this.addCell(dataRow, col++, fila.getCashMarginAccount(), null);
            this.addCell(dataRow, col++, fila.getModeloRelacionamiento(), null);

            this.addCell(dataRow, col++, fila.getDebitCardIndicator(), null);
            this.addCell(dataRow, col++, reportesMaestrosHelper.excelValueAsDate(fila.getOpenDate(), ReportesMaestrosHelper.FORMATO_FECHA_BD), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getCloseDate(), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getParticipantType(), null);
            this.addCell(dataRow, col++, fila.getClientInvestmentProfile(), null);

            this.addCell(dataRow, col++, fila.getPortfolio(), null);
            this.addCell(dataRow, col++, fila.getTipoServicio(), null);
            this.addCell(dataRow, col++, fila.getAdvisoryFeeAnnualPct(), null);
            this.addCell(dataRow, col++, fila.getLastStatementDate(), this.usaDateStyle);
            this.addCell(dataRow, col++, fila.getMainAdvisor(), null);

            this.addCell(dataRow, col++, fila.getSecondaryAdvisor(), null);
            this.addCell(dataRow, col++, fila.getEmailMainAdvisor(), null);
            this.addCell(dataRow, col++, fila.getEmailSecondaryAdvisor(), null);
            this.addCell(dataRow, col++, fila.getTaxId(), null);
            this.addCell(dataRow, col++, fila.getLastActivityMonth(), this.usaDateStyle);

            this.addCell(dataRow, col++, fila.getInstitutionCode(), null);
            this.addCell(dataRow, col++, fila.getRestrictionCodeValue(), null);
            this.addCell(dataRow, col++, fila.getFondeo(), null);
            this.addCell(dataRow, col, fila.getMontoComprometido(), null);

        }
        appConfig.customLog.info("Datos agregados a excel Clientes.");
        return reporteExcel;
    }
    private XSSFWorkbook reporteMovimientos(String processDate, Integer aplicaFlujoNeto, String varianteReporte) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Movimientos para fecha : ["+processDate+"] variante ["+varianteReporte+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoMovimientos(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        String nombreHojaExcel;
        if (aplicaFlujoNeto == null) {
            nombreHojaExcel = "Movimientos de Entrada y Salida";
        } else if (aplicaFlujoNeto.equals(0)) {
            nombreHojaExcel = "Movimientos Trade";
        } else {
            nombreHojaExcel = "Movimientos";
        }
        Sheet sheet = reporteExcel.createSheet(nombreHojaExcel);
        var reporteMovimientos = reporteMaestroDatosService.generaReporteMovimientos(processDate, aplicaFlujoNeto, varianteReporte);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        appConfig.customLog.info("Encabezados reporte Movimientos generados; iniciando escritura de datos en excel.");
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

            this.addCell(dataRow, col++, fila.getReporte(), null);
            this.addCell(dataRow, col++, fila.getDescription1(), null);
            this.addCell(dataRow, col++, fila.getDescription2(), null);
            this.addCell(dataRow, col++, fila.getDescription3(), null);
            this.addCell(dataRow, col++, fila.getTicker(), null);

            this.addCell(dataRow, col++, fila.getIdSubSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getNombreSubSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getSecId(), null);

            this.addCell(dataRow, col, fila.getAplicaFlujoNeto(), null);

        }
        appConfig.customLog.info("Datos agregados a excel Movimientos.");
        return reporteExcel;
    }

    private XSSFWorkbook reporteSaldos(String processDate, String varianteReporte) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Saldos para fecha : ["+processDate+"] variante ["+varianteReporte+"]");
        String[] encabezado = reportesMaestrosHelper.encabezadoSaldos(ReportesMaestrosHelper.EXTENSION_EXCEL);
        this.usaDateStyle   = null;
        var reporteExcel = new XSSFWorkbook();
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        this.usaDateStyle = reporteExcel.createCellStyle();
        this.usaDateStyle.setDataFormat(createHelper.createDataFormat().getFormat(ReportesMaestrosHelper.FORMATO_FECHA_EXCEL));

        Sheet sheet = reporteExcel.createSheet("Saldos");
        var reporteSaldos = reporteMaestroDatosService.generaReporteSaldos(processDate, varianteReporte);

        int row = 0;
        Row header = sheet.createRow(row);
        for (int i = 0; i < encabezado.length; i++) {
            this.addCell(header, i, encabezado[i], null);
        }
        appConfig.customLog.info("Encabezados reporte Saldos generados; iniciando escritura de datos en excel.");
        for (VwReporteMaestroDatosSaldo fila : reporteSaldos) {
            row++;
            int col = 0;
            Row dataRow = sheet.createRow(row);
            this.addCell(dataRow, col++, fila.getCustodian(), null);
            this.addCell(dataRow, col++, fila.getClientId(), null);
            this.addCell(dataRow, col++, fila.getFirmNo(), null);
            this.addCell(dataRow, col++, fila.getSubNo(), null);
            this.addCell(dataRow, col++, fila.getOfficeId(), null);

            this.addCell(dataRow, col++, fila.getRepNo(), null);
            this.addCell(dataRow, col++, fila.getRep(), null);
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
            this.addCell(dataRow, col++, fila.getAdvisoryFeeAnual(), null);
            this.addCell(dataRow, col++, fila.getFactor(), null);
            this.addCell(dataRow, col++, fila.getComisionDevengadaDiaria(), null);

            this.addCell(dataRow, col++, fila.getUsdeMarketPrice(), null);
            this.addCell(dataRow, col++, fila.getSecNo(), null);
            this.addCell(dataRow, col++, fila.getDesc1(), null);
            this.addCell(dataRow, col++, fila.getDesc2(), null);
            this.addCell(dataRow, col++, fila.getDesc3(), null);

            this.addCell(dataRow, col++, fila.getSedol(), null);
            this.addCell(dataRow, col++, fila.getTicker(), null);
            this.addCell(dataRow, col++, fila.getIdSubSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdSubTipoActivo(), null);
            this.addCell(dataRow, col++, fila.getIdTipoActivo(), null);

            this.addCell(dataRow, col++, fila.getNombreSubSubTipoActivo(), null);
            this.addCell(dataRow, col, fila.getSecId(), null);

        }
        appConfig.customLog.info("Datos agregados a excel Saldos.");
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
