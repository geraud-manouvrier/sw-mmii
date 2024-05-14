package cl.qande.mmii.app.util.reportes;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.OficinaStonex;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteIngresosEgresosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.ReportesIngresosEgresosHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class IngresosEgresosDiarioExcel {


    @Autowired
    private AppConfig appConfig;
    @Autowired
    private IReporteIngresosEgresosService reporteIngresosEgresosService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private ReportesIngresosEgresosHelper reportesIngresosEgresosHelper;

    private CellStyle numericStyle;
    private CellStyle percentStyle;
    private List<CellStyle> headerFirstRowStyle= new ArrayList<>();
    private List<CellStyle> headerSecondRowStyle= new ArrayList<>();
    private List<CellStyle> headerThirdRowStyle= new ArrayList<>();
    private List<CellStyle> headerFourthRowStyle= new ArrayList<>();

    private static final String CUSTODIO_STONEX    = "STONEX";

    public void generaReportesExcel(Date processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando generación de Reporte Diario I/E para fecha :"+processDate);
        this.generaReporteDiario(CUSTODIO_STONEX, processDate);
        appConfig.customLog.info("Generación Reporte Diario I/E finalizada");
    }

    public void generaReporteDiario(String custodio, Date dateTo) throws QandeMmiiException {
        this.guardaExcel(this.reporteDiario(custodio, dateTo), reportesIngresosEgresosHelper.generaNombreReporteDiario(dateTo));
    }

    private void initCellStyles(Workbook reporteExcel) {


        numericStyle =null;
        percentStyle =null;
        headerFirstRowStyle= new ArrayList<>();
        headerSecondRowStyle= new ArrayList<>();
        headerThirdRowStyle= new ArrayList<>();
        headerFourthRowStyle= new ArrayList<>();

        this.numericStyle = dataStyleNumber(reporteExcel);
        this.percentStyle = dataStylePercent(reporteExcel);

        int grupoValores=1;
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores++));
        this.headerFirstRowStyle.add(firstHeaderStyle(reporteExcel, grupoValores));
        grupoValores=1;
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores++));
        this.headerSecondRowStyle.add(secondHeaderStyle(reporteExcel, grupoValores));
        grupoValores=1;
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores++));
        this.headerThirdRowStyle.add(thirdHeaderStyle(reporteExcel, grupoValores));
        grupoValores=1;
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores++));
        this.headerFourthRowStyle.add(fourthHeaderStyle(reporteExcel, grupoValores));
    }
    private CellStyle dataStyleNumber(Workbook reporteExcel) {
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setDataFormat(createHelper.createDataFormat().getFormat("#,##0.00"));
        return excelStyle;
    }

    private CellStyle dataStylePercent(Workbook reporteExcel) {
        CreationHelper createHelper = reporteExcel.getCreationHelper();
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.00%"));
        return excelStyle;
    }

    private CellStyle firstHeaderStyle(Workbook reporteExcel, int grupoValores) {
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setFillForegroundColor(reportesIngresosEgresosHelper.headerColor(1, grupoValores));
        excelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        excelStyle.setAlignment(HorizontalAlignment.CENTER);
        reportesIngresosEgresosHelper.setHeaderFont(reporteExcel, 1, grupoValores);
        return excelStyle;
    }

    private CellStyle secondHeaderStyle(Workbook reporteExcel, int grupoValores) {
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setFillForegroundColor(reportesIngresosEgresosHelper.headerColor(2, grupoValores));
        excelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        excelStyle.setAlignment(HorizontalAlignment.CENTER);
        reportesIngresosEgresosHelper.setHeaderFont(reporteExcel, 2, grupoValores);
        return excelStyle;
    }

    private CellStyle thirdHeaderStyle(Workbook reporteExcel, int grupoValores) {
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setFillForegroundColor(reportesIngresosEgresosHelper.headerColor(3, grupoValores));
        excelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        excelStyle.setAlignment(HorizontalAlignment.CENTER);
        reportesIngresosEgresosHelper.setHeaderFont(reporteExcel, 3, grupoValores);
        return excelStyle;
    }

    private CellStyle fourthHeaderStyle(Workbook reporteExcel, int grupoValores) {
        var excelStyle = reporteExcel.createCellStyle();
        excelStyle.setFillForegroundColor(reportesIngresosEgresosHelper.headerColor(4, grupoValores));
        excelStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        excelStyle.setAlignment(HorizontalAlignment.CENTER);
        reportesIngresosEgresosHelper.setHeaderFont(reporteExcel, 4, grupoValores);
        if (grupoValores<=4) {
            CreationHelper createHelper = reporteExcel.getCreationHelper();
            excelStyle.setDataFormat(createHelper.createDataFormat().getFormat("0%"));
        }
        return excelStyle;
    }

    private void guardaExcel(Workbook reporteExcel, String nombreArchivo) throws QandeMmiiException {
        var dirReportes     = new File(appConfig.appConfigProperties.getReportesIngresosegresosFolder()).getAbsolutePath();
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
    private Workbook reporteDiario(String custodio, Date dateTo) {
        appConfig.customLog.info("Iniciando generación de Reporte Diario ["+custodio+"] para fecha :["+dateTo+"]");
        String[] encabezadoPrincipal = reportesIngresosEgresosHelper.encabezadoPrincipalReporte();
        String[] encabezadoOficinas = reporteIngresosEgresosService.listaOficinas(custodio, dateTo);
        List<OficinaStonex> listaOficinas   = new ArrayList<>();
        for (var oficina : encabezadoOficinas) {
            listaOficinas.add(reporteIngresosEgresosService.getOficina(oficina));
        }
        var reporteExcel = new XSSFWorkbook();
        this.initCellStyles(reporteExcel);

        String nombreHojaExcel  = "Ingresos y gastos";

        Sheet sheet = reporteExcel.createSheet(nombreHojaExcel);
        var reporteDiario = reporteIngresosEgresosService.reporteDiario(custodio, dateTo);

        int desfaseInicial  = 2;
        int row = 0;
        int col = desfaseInicial;

        int cantOficinas    = encabezadoOficinas.length;
        Row headerFirstRow = sheet.createRow(row++);
        Row headerSecondRow = sheet.createRow(row++);
        Row headerThirdRow = sheet.createRow(row++);
        Row headerFourthRow = sheet.createRow(row++);
        for (int i = 0; i < encabezadoPrincipal.length; i++) {
            reportesIngresosEgresosHelper.addCell(headerFirstRow, col, encabezadoPrincipal[i], this.headerFirstRowStyle.get(i));
            for (int j = 0; j < cantOficinas; j++) {
                var fourthRowValue  = reportesIngresosEgresosHelper.fourthRowValue(listaOficinas, i+1, j);
                reportesIngresosEgresosHelper.addCell(headerSecondRow, col, reporteIngresosEgresosService.nombreOficina(encabezadoOficinas[j]), this.headerSecondRowStyle.get(i));
                switch (i) {
                    case 2:
                    case 3:
                        sheet.addMergedRegion(new CellRangeAddress(headerSecondRow.getRowNum(), headerSecondRow.getRowNum(), headerSecondRow.getLastCellNum()-1, headerSecondRow.getLastCellNum()-1+2));
                        reportesIngresosEgresosHelper.addCell(headerThirdRow, col, "BRUTO", this.headerThirdRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerFourthRow, col++, fourthRowValue[0].setScale(4), this.headerFourthRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerThirdRow, col, "IVA", this.headerThirdRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerFourthRow, col++, fourthRowValue[1].setScale(4), this.headerFourthRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerThirdRow, col, "NETO", this.headerThirdRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerFourthRow, col, ((fourthRowValue[0].setScale(4)).doubleValue()*100)+"% + IVA", this.headerFourthRowStyle.get(i));
                        break;
                    default:
                        reportesIngresosEgresosHelper.addCell(headerThirdRow, col, encabezadoOficinas[j], this.headerThirdRowStyle.get(i));
                        reportesIngresosEgresosHelper.addCell(headerFourthRow, col, fourthRowValue[0], this.headerFourthRowStyle.get(i));
                        break;
                }
                col=headerThirdRow.getLastCellNum();
            }
            switch (i) {
                case 2:
                case 3:
                    sheet.addMergedRegion(new CellRangeAddress(headerFirstRow.getRowNum(), headerFirstRow.getRowNum(), headerFirstRow.getLastCellNum()-1, headerFirstRow.getLastCellNum()+(cantOficinas*3)-2));
                    break;
                default:
                    reportesIngresosEgresosHelper.addCell(headerSecondRow, col, "Total", this.headerSecondRowStyle.get(i));
                    reportesIngresosEgresosHelper.addCell(headerThirdRow, col, "", this.headerThirdRowStyle.get(i));
                    reportesIngresosEgresosHelper.addCell(headerFourthRow, col, "", this.headerFourthRowStyle.get(i));
                    col++;
                    sheet.addMergedRegion(new CellRangeAddress(headerFirstRow.getRowNum(), headerFirstRow.getRowNum(), headerFirstRow.getLastCellNum()-1, headerFirstRow.getLastCellNum()+cantOficinas-1));
                    break;
            }
            appConfig.customLog.info("Agregando cierre de columna");
        }
        sheet.addMergedRegion(new CellRangeAddress(headerThirdRow.getRowNum(), headerFourthRow.getRowNum(), 0, headerThirdRow.getFirstCellNum()-1));
        reportesIngresosEgresosHelper.addCell(headerThirdRow, 0, "Período/País", null);
        appConfig.customLog.info("Encabezados Principal para reporte I/E generados.");

        Integer anioActual  = -1;
        Integer diaActual   = -1;
        Row dataRow = null;
        int numOficina  = 1;



        for (var fila : reporteDiario) {
            appConfig.customLog.info("Procesando fila ID ["+fila.getRowId()+"]");


            if ( ! diaActual.equals(fila.getDesde()) ) {
                dataRow = sheet.createRow(row++);
                anioActual  = fila.getAnio();
                diaActual   = fila.getDesde();
                numOficina=1;
                var totales = reporteIngresosEgresosService.totalReporteDiarioByCustodioAndPeriodo(custodio, anioActual, fila.getMes(), diaActual);

                reportesIngresosEgresosHelper.addCell(dataRow, 0, fila.getDesde(), null);
                reportesIngresosEgresosHelper.addCell(dataRow, 1, calendarioHelper.nombreMes(fila.getMes(), "ES"), null);

                reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(0, 1, desfaseInicial, cantOficinas), totales.getIngresosTotal(), this.numericStyle);
                reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(0, 2, desfaseInicial, cantOficinas), totales.getGastosTotal(), this.numericStyle);


                reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(0, 5, desfaseInicial, cantOficinas), totales.getAumPromedioTotal(), this.numericStyle);
                reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(0, 6, desfaseInicial, cantOficinas), totales.getAdvisoryFeePromedioTotal(), this.percentStyle);
                reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(0, 7, desfaseInicial, cantOficinas), totales.getMargenPromedioSuraTotal(), this.percentStyle);

            }



            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 1, desfaseInicial, cantOficinas), fila.getIngresos(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 2, desfaseInicial, cantOficinas), fila.getDistributionFee(), this.numericStyle);

            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 3, desfaseInicial, cantOficinas), fila.getReconocimientoAdicionalBruto(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 3, desfaseInicial, cantOficinas)+1, fila.getReconocimientoAdicionalIva(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 3, desfaseInicial, cantOficinas)+2, fila.getReconocimientoAdicionalNeto(), this.numericStyle);

            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 4, desfaseInicial, cantOficinas), fila.getCollectOnBehalfOfBruto(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 4, desfaseInicial, cantOficinas)+1, fila.getCollectOnBehalfOfIva(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 4, desfaseInicial, cantOficinas)+2, fila.getCollectOnBehalfOfNeto(), this.numericStyle);

            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 5, desfaseInicial, cantOficinas), fila.getAumPromedio(), this.numericStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 6, desfaseInicial, cantOficinas), fila.getAdvisoryFeePromedio(), this.percentStyle);
            reportesIngresosEgresosHelper.addCell(dataRow, reportesIngresosEgresosHelper.calculaColumna(numOficina, 7, desfaseInicial, cantOficinas), fila.getMargenPromedioSura(), this.percentStyle);


            numOficina++;

        }
        appConfig.customLog.info("Datos agregados a excel I/E.");
        return reporteExcel;
    }
}
