package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.dto.reporte_inversiones.ReporteInversionesClienteDto;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@Service("v202404")
@Primary
public class PdfReporteInversionesService extends PdfPageEventHelper implements IPdfReporteInversionesService {

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private ArchivosHelper archivosHelper;

    private static final float WIDTH_PDF         = 1455;
    private static final float HEIGHT_PDF        = 820;
    private static final Rectangle SIZE_PDF = new RectangleReadOnly(WIDTH_PDF, HEIGHT_PDF);
    //Márgenes y paddings
    private static final float MAR_L = 36;
    private static final float MAR_R = 36;
    private static final float MAR_T = 65;
    private static final float MAR_B = 36;
    private static final float LEFT_MARGIN_PAGE_ONE = 55;
    private static final float LEFT_MARGIN_PAGE_TWO = 40;
    private static final float MARGIN_CLIENT_DATA    = 1050f;
    private static final float LEFT_TABLE_PADDING = 40f;
    private static final float VERT_PADDING_HEADER_CELL = 10f;
    private static final float VERT_PADDING_TEXT_CELL = 5f;
    //Logo 1 (Investment)
    private static final float HEIGHT_LOGO1 = 24;
    private static final float WIDTH_LOGO1 = 139.5f;
    public static final float POS_LOGO1_X = LEFT_MARGIN_PAGE_TWO;
    public static final float POS_LOGO1_Y = HEIGHT_PDF - HEIGHT_LOGO1;
    //Logo 2 (ícono SURA)
    private static final float HEIGHT_LOGO2 = 41.564f;
    private static final float WIDTH_LOGO2 = 120;
    public static final int POS_LOGO2_X = 1300;
    public static final int POS_LOGO2_Y = 730;
    //Barra azul horizontal
    public static final int WIDTH_HORIZBAR = 70;
    public static final int HEIGHT_HORIZBAR = 6;
    private static final float POS_HORIZBAR_X        = MARGIN_CLIENT_DATA;
    private static final float POS_HORIZBAR_Y        = 440;
    //Barras verticales grises (x2, encierran tabla de datos)
    private static final float WIDTH_VERTBAR         = 37;
    private static final float HEIGHT_VERTBAR        = 750;
    private static final float POS_VERTBAR1_X        = LEFT_MARGIN_PAGE_TWO;
    private static final float POS_VERTBAR1_Y        = 0;
    private static final float POS_VERTBAR2_X        = MARGIN_CLIENT_DATA-45;
    private static final float POS_VERTBAR2_Y        = POS_VERTBAR1_Y;
    //Tabla de datos
    private static final float POS_DATATABLE_X         = POS_VERTBAR1_X+WIDTH_VERTBAR;
    private static final float POS_DATATABLE_Y         = HEIGHT_VERTBAR;
    private static final float WIDTH_DATATABLE         = (POS_VERTBAR2_X-WIDTH_VERTBAR)-POS_VERTBAR1_X;
    private static final int WIDTH_DATATABLE_DATACOL    = 280;
    private static final int[] WIDTHS_DATATABLE_3COLS = {((int) WIDTH_DATATABLE-(WIDTH_DATATABLE_DATACOL+WIDTH_DATATABLE_DATACOL)), WIDTH_DATATABLE_DATACOL, WIDTH_DATATABLE_DATACOL};
    private static final int[] WIDTHS_DATATABLE_2COLS = {((int) WIDTH_DATATABLE-(WIDTH_DATATABLE_DATACOL+WIDTH_DATATABLE_DATACOL)), WIDTH_DATATABLE_DATACOL+ WIDTH_DATATABLE_DATACOL};
    //Imágenes de gráficos de rentabilidad
    private static final float POS_VERTBGGRAPH_X    = POS_DATATABLE_X;
    private static final float WIDTH_BARGRAPH         = WIDTH_DATATABLE;
    private static final float HEIGHT_BARGRAPH         = 250;
    private static final float WIDTH_LINEGRAPH         = WIDTH_DATATABLE;
    public static final String MSG_ERROR_NEW_FONT = "Error al inicializar fuente: ";
    private static final String ROBOTO_LIGHT_TTF = "Roboto-Light.ttf";
    private static final String ROBOTO_REGULAR_TTF = "Roboto-Regular.ttf";
    private static final String ROBOTO_THIN_TTF = "Roboto-Thin.ttf";

    //Varios
    private static final String FONT_ENCODING = BaseFont.IDENTITY_H;
    private static final boolean FONT_EMBEDDED = BaseFont.EMBEDDED;
    private static final float CHAR_SEP_NO = 0.0f;
    private static final float CHAR_SEP_1HALF = 1.5f;
    private static final float CHAR_SEP_3 = 3.0f;

    //No estáticos, auxiliares: Fuentes, colores, etc.
    private static Color colorLightBlack;
    private static Color colorBlack;
    private static Color colorWhite;
    private static Color colorGray;
    private static Color colorDarkGray;
    private static Color colorLightGray;
    private static Color colorCustomBlue;
    private static Color colorBlueLineChart;


    private java.awt.Font barGraphFont() {
        return new java.awt.Font(this.getRutaBaseArtifacts()+ "/" + ROBOTO_LIGHT_TTF, java.awt.Font.BOLD, 25);
    }
    private String getFullPathDir(String processDate) {
        return this.getRutaBasePdf() + "/" + processDate.substring(0,6)+"/";
    }
    private String getRutaBasePdf() {
        return appConfig.appConfigProperties.getReporteInversionesFolder();
    }
    private String getRutaBaseArtifacts() {
        return appConfig.appConfigProperties.getRootFolder()+"/artifacts/reporte-inversiones";
    }

    private static void initializeColors() throws QandeMmiiException {
        try {
            if (colorLightBlack ==null) {
                colorLightBlack = new Color(22, 22, 24);
            }
            if (colorBlack ==null) {
                colorBlack = Color.BLACK;
            }
            if (colorWhite ==null) {
                colorWhite = Color.WHITE;
            }
            if (colorGray ==null) {
                colorGray = new Color(214,218,222);
            }
            if (colorCustomBlue ==null) {
                colorCustomBlue = new Color(10, 44, 206);
            }
            if (colorDarkGray ==null) {
                colorDarkGray = new Color(152,162,172);
            }
            if (colorLightGray ==null) {
                colorLightGray = new Color(191, 191, 191);
            }
            if (colorBlueLineChart ==null) {
                colorBlueLineChart = new Color(73,96,205, 255);
            }
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error al inicializar paleta de colores de PDF Reporte Inversiones: "+e.getMessage());
        }
    }
    private BaseFont robotoRegular() throws QandeMmiiException {
        try {
            return BaseFont.createFont(this.getRutaBaseArtifacts() + "/" + ROBOTO_REGULAR_TTF, FONT_ENCODING, FONT_EMBEDDED);
        } catch (IOException e) {
            throw new QandeMmiiException(e, MSG_ERROR_NEW_FONT+e.getMessage());
        }
    }
    private BaseFont robotoThin() throws QandeMmiiException {
        try {
            return BaseFont.createFont(this.getRutaBaseArtifacts() + "/" + ROBOTO_THIN_TTF, FONT_ENCODING, FONT_EMBEDDED);
        } catch (IOException e) {
            throw new QandeMmiiException(e, MSG_ERROR_NEW_FONT +e.getMessage());
        }
    }
    private BaseFont robotoBold() throws QandeMmiiException {
        try {
            return BaseFont.createFont(this.getRutaBaseArtifacts() + "/" + ROBOTO_LIGHT_TTF, FONT_ENCODING, FONT_EMBEDDED);
        } catch (IOException e) {
            throw new QandeMmiiException(e, MSG_ERROR_NEW_FONT+e.getMessage());
        }
    }
    private Font textCellFont() throws QandeMmiiException {
        var textCellFont = new Font(robotoBold(), 14, Font.BOLD);
        textCellFont.setColor(colorBlack);
        return textCellFont;
    }
    private Font headerCellFont() throws QandeMmiiException {
        var headerCellFont = new Font(robotoBold(), 14);
        headerCellFont.setColor(colorGray);
        return headerCellFont;
    }
    private Font disclaimerCellFont() throws QandeMmiiException {
        var disclaimerCellFont = new Font(robotoBold(), 11);
        disclaimerCellFont.setColor(colorBlack);
        return disclaimerCellFont;
    }

    private String getDateAsStringReporte(String processDate) {
        return processDate.substring(6, 8)+"."+processDate.substring(4, 6)+"."+processDate.substring(0, 4);
    }
    private String getNumberAsPercentageString(BigDecimal number, int numDecimals) {
        if (number==null) {
            return "";
        }
        return CustomThymeleafHelper.formatNumberWithDecimals(number, numDecimals, BigDecimal.ZERO)+"%";
    }
    private String getNumberAsString(BigDecimal number, int numDecimals) {
        if (number==null) {
            return "";
        }
        return CustomThymeleafHelper.formatNumberWithDecimals(number, numDecimals, BigDecimal.ZERO);
    }

    private void addTextToCanvas(PdfContentByte canvas, String text, float x, float y) {
        var textToShow  = text;
        if (textToShow == null) {
            textToShow="";
        }
        canvas.beginText();
        canvas.setTextMatrix(x, y);
        canvas.showText(textToShow);
        canvas.endText();
    }

    private void addDownToUpTextToCanvas(PdfContentByte canvas, String text, float x, float y) {
        var textToShow  = text;
        if (textToShow == null) {
            textToShow="";
        }
        canvas.beginText();
        canvas.setTextMatrix(0, 1, -1, 0, x, y);
        canvas.showText(textToShow);
        canvas.endText();
    }
    private void addImageToDocument(Document document, String path, float x, float y, float width, float height) throws IOException, DocumentException {
        Image image = Image.getInstance(path);
        image.scaleAbsolute(width, height);
        image.setAbsolutePosition(x, y);
        document.add(image);
    }
    private void setDefaultFontColor(PdfContentByte canvas) {
        canvas.setColorFill(colorLightBlack);
    }

    private String generaGraficosBarras(ReporteInversionesClienteDto reporteInversionesClienteDto, float widthImg, float heightImg) throws QandeMmiiException {
        appConfig.customLog.info("Generando Bar Chart: " + reporteInversionesClienteDto.getIdCliente());
        int factorTamanio = 3;

        BigDecimal factorEscalaGrafico  = BigDecimal.valueOf(1.1);

        String fullPathImgBars  = this.getFullPathDir(reporteInversionesClienteDto.getProcessDate()) + reporteInversionesClienteDto.getNombreGraficoBarras();
        var rentabilidades  = reporteInversionesClienteDto.getRentabilidadCliente();

        DefaultCategoryDataset datasetBar = new DefaultCategoryDataset();

        BigDecimal[] values = {rentabilidades.getBase2Rentabilidad(), rentabilidades.getBase3Rentabilidad(), rentabilidades.getBase4Rentabilidad(), rentabilidades.getBase5Rentabilidad()};
        var maxValue    = MathHelper.max(values);
        var maxScale       = maxValue.multiply(factorEscalaGrafico);
        var minValue    = MathHelper.min(values);
        if(minValue.compareTo(BigDecimal.ZERO) > 0) {
            minValue = BigDecimal.ZERO;
        }
        var minScale       = minValue.multiply(factorEscalaGrafico);

        String nombreSerie = "Rentabilidad";
        datasetBar.addValue(values[0], nombreSerie, "1 Mes");
        datasetBar.addValue(values[1], nombreSerie, "3 Meses");
        datasetBar.addValue(values[2], nombreSerie, "YTD");
        datasetBar.addValue(values[3], nombreSerie, "12 Meses");

        JFreeChart barChart = ChartFactory.createBarChart(
                null, null, null,
                datasetBar, PlotOrientation.HORIZONTAL,
                false, true, false
        );

        AxisSpace space = new AxisSpace();
        space.setTop( 20+(10d*factorTamanio));
        space.setBottom(20+(10d*factorTamanio));
        space.setLeft(100+(25d*factorTamanio));
        space.setRight(140+(10d*factorTamanio));

        var plot            = (CategoryPlot) barChart.getPlot();
        var rangeAxis       = (NumberAxis) plot.getRangeAxis();
        var domainAxis      = plot.getDomainAxis();
        var axisStroke      = new BasicStroke(5.0f);
        var renderer        = new BarRenderer();
        var position        = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0);
        var gradientPaint   = new GradientPaint(0.0f, 0.0f, colorGray, 0.0f, 100.0f, colorDarkGray, false);

        barChart.setAntiAlias(true);
        barChart.setBackgroundPaint(null);
        barChart.setBackgroundImageAlpha(0.0f);

        plot.setFixedRangeAxisSpace(space);
        plot.setBackgroundPaint(null);
        plot.setOutlineVisible(false);
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);

        rangeAxis.setTickMarksVisible(false);
        rangeAxis.setTickLabelsVisible(false);
        rangeAxis.setRange(minScale.doubleValue(), maxScale.doubleValue());
        rangeAxis.setTickLabelFont(this.barGraphFont());
        rangeAxis.setVisible(false);

        domainAxis.setLabelFont(this.barGraphFont());
        domainAxis.setTickLabelFont(this.barGraphFont());
        domainAxis.setAxisLineStroke(axisStroke);
        domainAxis.setTickMarksVisible(false);


        renderer.setMaximumBarWidth(0.1);
        renderer.setDefaultItemLabelPaint(colorLightBlack);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("  {2}%", new DecimalFormat("0.00")));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(this.barGraphFont());
        renderer.setDefaultPositiveItemLabelPosition(position);
        renderer.setSeriesPaint(0, gradientPaint);

        plot.setRenderer(renderer);

        try {
            ChartUtils.saveChartAsPNG(new File(fullPathImgBars), barChart, (int) widthImg*factorTamanio, (int) heightImg*factorTamanio);
            appConfig.customLog.info("Finalizado Bar Chart: " + reporteInversionesClienteDto.getIdCliente() + " en: " + fullPathImgBars);
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error occurred while saving the Bar Chart: " + e.getMessage());
        }
        return fullPathImgBars;
    }
    private String generaGraficosLineas(ReporteInversionesClienteDto reporteInversionesClienteDto, float widthImg, float heightImg) throws QandeMmiiException {
        appConfig.customLog.info("Generando Line Chart: " + reporteInversionesClienteDto.getIdCliente());
        int factorTamanio = 3;

        String fullPathImgLines = this.getFullPathDir(reporteInversionesClienteDto.getProcessDate()) + reporteInversionesClienteDto.getNombreGraficoLineas();
        BigDecimal yOffset = BigDecimal.valueOf(-0.2);

        TimeSeries serieRentabilidad = new TimeSeries("Rentabilidad");
        TimeSeries seriesSombra = new TimeSeries("Rentabilidad2");
        TimeSeries seriesMargen = new TimeSeries("Rentabilidad3");

        BigDecimal max = BigDecimal.valueOf(-1000);
        BigDecimal min = BigDecimal.valueOf(1000);
        BigDecimal base= BigDecimal.valueOf(100);
        for (var point : reporteInversionesClienteDto.getRentabilidadAnualBase100()) {
            var currentVal = base.multiply(point.getRentabilidad().add(BigDecimal.ONE));
            var periodVal  = new Day(point.getProcessDateAsDate().getDayOfMonth(), point.getProcessDateAsDate().getMonthValue(), point.getProcessDateAsDate().getYear());
            if (currentVal.compareTo(max) > 0) {
                max = currentVal;
            }
            if (currentVal.compareTo(min) < 0) {
                min = currentVal;
            }
            serieRentabilidad.add( periodVal, currentVal );
            seriesSombra.add( periodVal, currentVal.add(yOffset) );
            seriesMargen.add( periodVal, currentVal.add(yOffset.multiply(BigDecimal.valueOf(-1))) );
        }
        TimeSeriesCollection datasetLine = new TimeSeriesCollection();
        datasetLine.addSeries(serieRentabilidad);
        datasetLine.addSeries(seriesSombra);
        datasetLine.addSeries(seriesMargen);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM - yy   ", AppConfig.LOCALE_CL);

        AxisSpace space = new AxisSpace();
        space.setBottom(140+(10d*factorTamanio));
        space.setTop(10+(10d*factorTamanio));
        space.setLeft(20+(25d*factorTamanio));
        space.setRight(20+(10d*factorTamanio));

        JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
                null, null, null,
                datasetLine,
                false, true, false
        );
        lineChart.setAntiAlias(true);
        lineChart.setBackgroundPaint(null);
        lineChart.setBackgroundImageAlpha(0.0f);

        var linePlot        = (XYPlot) lineChart.getPlot();
        var lineRangeAxis   = (NumberAxis) linePlot.getRangeAxis();
        var lineDomainAxis  = (DateAxis) linePlot.getDomainAxis();
        var rango           = this.getRangeLineChart(min, max);
        var axisStroke      = new BasicStroke(5.0f);
        var renderer        = new XYLineAndShapeRenderer();

        linePlot.setBackgroundPaint(null);
        linePlot.setDomainGridlinesVisible(false);
        linePlot.setRangeGridlinesVisible(false);
        linePlot.setOutlineVisible(false);
        linePlot.setFixedDomainAxisSpace(space);

        lineRangeAxis.setRange(rango[0].doubleValue(), rango[1].doubleValue());
        lineRangeAxis.setTickUnit(new NumberTickUnit(5));
        lineRangeAxis.setTickLabelFont(this.barGraphFont());
        lineRangeAxis.setAxisLineStroke(axisStroke);

        lineDomainAxis.setLabelFont(this.barGraphFont());
        lineDomainAxis.setTickLabelFont(this.barGraphFont());
        lineDomainAxis.setVerticalTickLabels(true);
        lineDomainAxis.setDateFormatOverride(dateFormat);
        lineDomainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 15, dateFormat));
        lineDomainAxis.setTickMarkPosition(DateTickMarkPosition.START);
        lineDomainAxis.setTickMarksVisible(true);
        lineDomainAxis.setTickMarkInsideLength(0.0f);
        lineDomainAxis.setTickMarkOutsideLength(5.0f);
        lineDomainAxis.setTickMarkStroke(axisStroke);
        lineDomainAxis.setAxisLineStroke(axisStroke);
        lineDomainAxis.setLabelLocation(AxisLabelLocation.LOW_END);
        lineDomainAxis.setLabelInsets(new RectangleInsets(60, 60, 60, 60));

        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesFilled(0, false);
        renderer.setSeriesPaint(0, colorBlueLineChart);
        renderer.setSeriesOutlinePaint(0, colorBlueLineChart);
        renderer.setSeriesStroke(0, axisStroke);
        renderer.setSeriesVisible(0, true);

        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesFilled(1, false);
        renderer.setSeriesPaint(1, colorWhite);
        renderer.setSeriesOutlinePaint(1, colorWhite);
        renderer.setSeriesStroke(1, axisStroke);
        renderer.setSeriesVisible(1, true);

        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesShapesFilled(2, false);
        renderer.setSeriesPaint(2, colorBlack);
        renderer.setSeriesOutlinePaint(2, colorBlack);
        renderer.setSeriesStroke(2, axisStroke);
        renderer.setSeriesVisible(2, true);

        linePlot.setRenderer(renderer);

        try {
            ChartUtils.saveChartAsPNG(new File(fullPathImgLines), lineChart, (int) widthImg*factorTamanio, (int) heightImg*factorTamanio);
            appConfig.customLog.info("Finalizado Line Chart: " + reporteInversionesClienteDto.getIdCliente() + " en: " + fullPathImgLines);
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error occurred while saving the Line Chart: " + e.getMessage());
        }
        return fullPathImgLines;
    }

    private BigDecimal[] getRangeLineChart(BigDecimal min, BigDecimal max) {
        int factor = 5;
        //calcula el múltiplo de 5 inmediatamente menor a min
        BigDecimal min5 = min.divide(BigDecimal.valueOf(factor), 0, RoundingMode.DOWN).multiply(BigDecimal.valueOf(factor));
        //calcula el múltiplo de 5 inmediatamente mayor a max
        BigDecimal max5 = max.divide(BigDecimal.valueOf(factor), 0, RoundingMode.UP).multiply(BigDecimal.valueOf(factor));
        return new BigDecimal[]{min5.add(BigDecimal.valueOf(-factor)), max5.add(BigDecimal.valueOf(factor))};
    }

    private void generaPortada (PdfWriter writer, Document document, ReporteInversionesClienteDto reporteInversionesClienteDto) throws QandeMmiiException {

        try {
            addImageToDocument(document, this.getRutaBaseArtifacts()+"/informe_inversiones-fondo_portada-v1.png", 0, 0, WIDTH_PDF, HEIGHT_PDF);
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error agregando imagen de fondo"+e.getMessage());
        }
        PdfContentByte canvas = writer.getDirectContent();
        this.setDefaultFontColor(canvas);

        canvas.setCharacterSpacing(CHAR_SEP_3);
        canvas.setFontAndSize(robotoRegular(), 18);
        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getNombreCliente().toUpperCase(), LEFT_MARGIN_PAGE_ONE, 593);

        canvas.setCharacterSpacing(CHAR_SEP_1HALF);
        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getNombreAsesor(), LEFT_MARGIN_PAGE_ONE, 480);

        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getMailAsesor(), LEFT_MARGIN_PAGE_ONE, 450);

        canvas.setFontAndSize(robotoBold(), 32);
        addTextToCanvas(canvas, getDateAsStringReporte(reporteInversionesClienteDto.getProcessDate()), LEFT_MARGIN_PAGE_ONE, 350);

        canvas.setCharacterSpacing(CHAR_SEP_NO);
        canvas.setFontAndSize(robotoRegular(), 44);
        addTextToCanvas(canvas, "Informe", LEFT_MARGIN_PAGE_ONE, 230);
        addTextToCanvas(canvas, "Patrimonial", LEFT_MARGIN_PAGE_ONE, 170);

        try {
            addImageToDocument(document, this.getRutaBaseArtifacts()+"/barra1.png", LEFT_MARGIN_PAGE_ONE, 315, WIDTH_HORIZBAR, HEIGHT_HORIZBAR);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error agregando imagenes auxiliares portada: "+e.getMessage());
        }
        document.newPage();
    }

    private void newCustomPage(PdfWriter writer, Document document, ReporteInversionesClienteDto reporteInversionesClienteDto) throws QandeMmiiException {

        document.newPage();
        PdfContentByte canvas = writer.getDirectContent();
        this.setDefaultFontColor(canvas);

        canvas.setFontAndSize(robotoBold(), 16);
        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getNombreCliente(), MARGIN_CLIENT_DATA, 390);
        canvas.setFontAndSize(robotoThin(), 16);
        addTextToCanvas(canvas, "ID: "+reporteInversionesClienteDto.getIdCliente(), MARGIN_CLIENT_DATA, 370);
        canvas.setFontAndSize(robotoRegular(), 14);
        addTextToCanvas(canvas, "Mail: "+reporteInversionesClienteDto.getDatosCliente().getMailCliente(), MARGIN_CLIENT_DATA, 310);
        addTextToCanvas(canvas, "Residente fiscal en Estados", MARGIN_CLIENT_DATA, 220);
        addTextToCanvas(canvas, "Unidos", MARGIN_CLIENT_DATA, 200);
        canvas.setFontAndSize(robotoBold(), 14);
        canvas.setColorFill(colorCustomBlue);
        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getResidenteFiscalUsa(), MARGIN_CLIENT_DATA, 180);

        setDefaultFontColor(canvas);
        canvas.setFontAndSize(robotoRegular(), 14);
        addTextToCanvas(canvas, "País de ciudadanía", MARGIN_CLIENT_DATA, 140);
        canvas.setFontAndSize(robotoBold(), 14);
        canvas.setColorFill(colorCustomBlue);
        addTextToCanvas(canvas, reporteInversionesClienteDto.getDatosCliente().getPaisCiudadania(), MARGIN_CLIENT_DATA, 120);


    }

    private PdfPTable generaHojaCuentas(PdfWriter writer, Document document, ReporteInversionesClienteDto reporteInversionesClienteDto) throws QandeMmiiException {

        this.newCustomPage(writer, document, reporteInversionesClienteDto);
        var tiene2col = (reporteInversionesClienteDto.getDatosCuentas().size()>=2);
        PdfPTable table;
        if (tiene2col)
            table = customPdfTable(3);
        else
            table = customPdfTable(2);

        int colspan = table.getNumberOfColumns();

        table.addCell(headerCell("OBJETIVOS FINANCIEROS", Element.ALIGN_LEFT));
        table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(0).getAccountNo(), Element.ALIGN_CENTER));
        if (tiene2col)
            table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(1).getAccountNo(), Element.ALIGN_CENTER));

        var textCellFont= this.textCellFont();
        table.addCell(tittleCell("Descripción objetivo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getDescripcionObjetivo(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getDescripcionObjetivo(), textCellFont));
        table.addCell(tittleCell("Horizonte objetivo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getHorizonteObjetivo(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getHorizonteObjetivo(), textCellFont));
        table.addCell(tittleCell("Perfil de inversión"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getPerfilInversion(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getPerfilInversion(), textCellFont));
        table.addCell(tittleCell("Gestión delegada a SURA"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getPortafolio(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getPortafolio(), textCellFont));
        table.addCell(tittleCell("Excención de Responsabilidad"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getExencionResponsabilidad(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getExencionResponsabilidad(), textCellFont));
        table.addCell(tittleCell("Tipo de Cuenta"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getTipoCuenta(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getTipoCuenta(), textCellFont));
        table.addCell(tittleCell("Designación de beneficiarios"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getBeneficiarios(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getBeneficiarios(), textCellFont));
        table.addCell(tittleCell("Custodio"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getCustodio(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getCustodio(), textCellFont));
        table.addCell(tittleCell("N° de Cuenta"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getAccountNo(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getAccountNo(), textCellFont));
        table.addCell(tittleCell("Advisory Fee anual"));
        table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(0).getAdvisoryFee(), 4), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(1).getAdvisoryFee(), 4), textCellFont));
        table.addCell(new Paragraph("", textCellFont));
        table.addCell(new Paragraph("", textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph("", textCellFont));


        table.addCell(headerCell("MOVIMIENTOS REALIZADOS EN EL PERIODO", Element.ALIGN_LEFT));
        table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(0).getAccountNo(), Element.ALIGN_CENTER));
        if (tiene2col)
            table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(1).getAccountNo(), Element.ALIGN_CENTER));


        table.addCell(tittleCell("Monto inicio periodo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getDescripcionObjetivo(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getDescripcionObjetivo(), textCellFont));
        table.addCell(tittleCell("Abonos realizados durante el periodo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getHorizonteObjetivo(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getHorizonteObjetivo(), textCellFont));
        table.addCell(tittleCell("Retiros realizados durante el periodo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getPerfilInversion(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getPerfilInversion(), textCellFont));
        table.addCell(tittleCell("Utilidad o Pérdida del periodo (incluye todos los costos)"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getPortafolio(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getPortafolio(), textCellFont));
        table.addCell(tittleCell("Monto cierre del periodo"));
        table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(0).getExencionResponsabilidad(), textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(reporteInversionesClienteDto.getDatosCuentas().get(1).getExencionResponsabilidad(), textCellFont));

        table.addCell(disclaimerCell("Saldos representados en USD. En caso de existir instrumentos en otra denominación, se muestran en USDE, es decir, en su equivalencia a USD", colspan));
        table.addCell(disclaimerCell("Solo se muestra la cuenta conjunta al titular", colspan));
        table.addCell(disclaimerCell(" ", colspan));


        table.addCell(headerCell("COMISIÓN POR ASESORÍA SURA US", Element.ALIGN_LEFT));
        table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(0).getAccountNo(), Element.ALIGN_CENTER));
        if (tiene2col)
            table.addCell(headerCell(reporteInversionesClienteDto.getDatosCuentas().get(1).getAccountNo(), Element.ALIGN_CENTER));

        table.addCell(tittleCell("Tasa anual de cobro"));
        table.addCell(new Paragraph(getNumberAsPercentageString(reporteInversionesClienteDto.getDatosCuentas().get(0).getTasaAnualCobro(), 2)+" (promedio ponderado)", textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(getNumberAsPercentageString(reporteInversionesClienteDto.getDatosCuentas().get(1).getTasaAnualCobro(), 2)+" (promedio ponderado)", textCellFont));
        table.addCell(tittleCell("Comisión devengada en el periodo (USD)"));
        table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(0).getComisionDevengadaPeriodo(), 0)+" (suma de los devengos)", textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(1).getComisionDevengadaPeriodo(), 0)+" (suma de los devengos)", textCellFont));
        table.addCell(tittleCell("Comisión efectivamente pagada en el periodo (USD)"));
        table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(0).getComisionPagadaPeriodo(), 0)+" (suma de los cobros efectivos)", textCellFont));
        if (tiene2col)
            table.addCell(new Paragraph(getNumberAsString(reporteInversionesClienteDto.getDatosCuentas().get(1).getComisionPagadaPeriodo(), 0)+" (suma de los cobros efectivos)", textCellFont));

        table.writeSelectedRows(0, -1, POS_DATATABLE_X, POS_DATATABLE_Y, writer.getDirectContent());
        table.flushContent();

        return table;
    }

    private PdfPTable generaHojaRentabilidades(PdfWriter writer, Document document, ReporteInversionesClienteDto reporteInversionesClienteDto) throws QandeMmiiException {

        this.newCustomPage(writer, document, reporteInversionesClienteDto);

        PdfPTable table;

        table       = customPdfTable(2);
        int colspan = table.getNumberOfColumns();

        table.addCell(headerCell("DESEMPEÑO DE INVERSIONES", Element.ALIGN_LEFT, colspan));

        var textCellFont= this.textCellFont();
        var rentabilidades = reporteInversionesClienteDto.getRentabilidadCliente();
        table.addCell(tittleCell("Desde inicio de operaciones a cierre del periodo"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase1Rentabilidad(), 2), textCellFont));
        table.addCell(tittleCell("1 mes"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase2Rentabilidad(), 2), textCellFont));
        table.addCell(tittleCell("3 meses"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase3Rentabilidad(), 2), textCellFont));
        table.addCell(tittleCell("Acumulado del año"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase4Rentabilidad(), 2), textCellFont));
        table.addCell(tittleCell("12 meses"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase5Rentabilidad(), 2), textCellFont));
        table.addCell(tittleCell("Desde apertura de cuenta"));
        table.addCell(new Paragraph(getNumberAsPercentageString(rentabilidades.getBase6Rentabilidad(), 2), textCellFont));

        table.addCell(new Paragraph(" ", textCellFont));
        table.addCell(new Paragraph(" ", textCellFont));

        table.addCell(headerCell("GRÁFICO DE RENTABILIDAD ACUMULADA BASE 100 DE 12 MESES", Element.ALIGN_LEFT, colspan));


        var yPos    = table.writeSelectedRows(0, -1, POS_DATATABLE_X, POS_DATATABLE_Y, writer.getDirectContent());
        table.flushContent();

        var rutaGraficoBarras   = this.generaGraficosBarras(reporteInversionesClienteDto, WIDTH_BARGRAPH, HEIGHT_BARGRAPH);


        try {
            addImageToDocument(document, this.getRutaBaseArtifacts()+"/background-graphics.png", POS_VERTBGGRAPH_X, yPos-HEIGHT_BARGRAPH, WIDTH_BARGRAPH, HEIGHT_BARGRAPH);
            addImageToDocument(document, rutaGraficoBarras, POS_VERTBGGRAPH_X, yPos-HEIGHT_BARGRAPH, WIDTH_BARGRAPH, HEIGHT_BARGRAPH);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error agregando imagenes gráfico barras: "+e.getMessage());
        }

        table.addCell(headerCell("GRÁFICO DE RENTABILIDAD ACUMULADA BASE 100 DE 12 MESES", Element.ALIGN_LEFT, colspan));

        yPos    = table.writeSelectedRows(0, -1, POS_DATATABLE_X, yPos-HEIGHT_BARGRAPH, writer.getDirectContent());
        table.flushContent();

        var rutaGraficoLineas   = this.generaGraficosLineas(reporteInversionesClienteDto, WIDTH_LINEGRAPH, yPos);

        try {
            addImageToDocument(document, this.getRutaBaseArtifacts()+"/background-graphics.png", POS_VERTBGGRAPH_X, 0, WIDTH_LINEGRAPH, yPos);
            addImageToDocument(document, rutaGraficoLineas, POS_VERTBGGRAPH_X, 0, WIDTH_BARGRAPH, yPos);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error agregando imagenes gráfico líneas: "+e.getMessage());
        }

        return table;

    }

    private PdfPCell tittleCell(String text) throws QandeMmiiException {
        PdfPCell tittleCell = new PdfPCell(new Paragraph(text, textCellFont()));
        tittleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        tittleCell.setPaddingLeft(LEFT_TABLE_PADDING);
        tittleCell.setPaddingTop(VERT_PADDING_TEXT_CELL);
        tittleCell.setPaddingBottom(VERT_PADDING_TEXT_CELL);
        tittleCell.setBorder(Rectangle.TOP+Rectangle.BOTTOM+Rectangle.LEFT);
        tittleCell.setBorderColor(colorLightGray);
        return tittleCell;
    }


    private PdfPCell disclaimerCell(String text, int colspan) throws QandeMmiiException {
        PdfPCell disclaimerCell = new PdfPCell(new Paragraph(text, disclaimerCellFont()));
        disclaimerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        disclaimerCell.setPaddingLeft(LEFT_TABLE_PADDING);
        disclaimerCell.setPaddingTop(VERT_PADDING_TEXT_CELL);
        disclaimerCell.setPaddingBottom(VERT_PADDING_TEXT_CELL);
        disclaimerCell.setBorder(Rectangle.NO_BORDER);
        disclaimerCell.setColspan(colspan);
        return disclaimerCell;
    }


    private PdfPCell headerCell(String text, int horizontalAlignment, int colspan) throws QandeMmiiException {
        PdfPCell headerCell = new PdfPCell(new Paragraph(text, headerCellFont()));
        headerCell.setHorizontalAlignment(horizontalAlignment);
        headerCell.setPaddingLeft(LEFT_TABLE_PADDING);
        headerCell.setPaddingTop(VERT_PADDING_HEADER_CELL);
        headerCell.setPaddingBottom(VERT_PADDING_HEADER_CELL);
        headerCell.setBorder(Rectangle.BOX);
        headerCell.setBorderColor(colorBlack);
        headerCell.setColspan(colspan);
        headerCell.setBackgroundColor(colorBlack);
        return headerCell;
    }

    private PdfPTable customPdfTable(int numberOfColumns) throws QandeMmiiException {
        PdfPTable table;
        switch (numberOfColumns) {
            case 2:
                table = new PdfPTable(WIDTHS_DATATABLE_2COLS.length);
                table.setWidths(WIDTHS_DATATABLE_2COLS);
                break;
            case 3:
                table = new PdfPTable(WIDTHS_DATATABLE_3COLS.length);
                table.setWidths(WIDTHS_DATATABLE_3COLS);
                break;
            default:
                throw new QandeMmiiException("Número de columnas no soportado: "+numberOfColumns);
        }
        table.setTotalWidth(WIDTH_DATATABLE);
        table.setSpacingBefore(0);
        table.setSpacingAfter(0);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setPaddingLeft(LEFT_TABLE_PADDING);
        table.getDefaultCell().setPaddingTop(VERT_PADDING_TEXT_CELL);
        table.getDefaultCell().setPaddingBottom(VERT_PADDING_TEXT_CELL);
        table.getDefaultCell().setBorder(Rectangle.TOP+Rectangle.BOTTOM);
        table.getDefaultCell().setBorderColor(colorLightGray);
        return table;
    }

    private PdfPCell headerCell(String text, int horizontalAlignment) throws QandeMmiiException {
        return headerCell(text, horizontalAlignment, 1);
    }
    private void lazyInitialization() throws QandeMmiiException {
        initializeColors();
    }

    @Override
    public String generaPdfCliente(ReporteInversionesClienteDto reporteInversionesClienteDto) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando Generación PDF para cliente ID [: " + reporteInversionesClienteDto.getIdCliente()+"] y processDate: "+reporteInversionesClienteDto.getProcessDate());
        String nombreArchivo    = reporteInversionesClienteDto.getNombreArchivo();
        String fullPathDir      = this.getFullPathDir(reporteInversionesClienteDto.getProcessDate());
        String fullPathPdf      = fullPathDir.concat(nombreArchivo);
        PdfWriter writer;
        this.lazyInitialization();

        archivosHelper.creaDirectorioReporteInversiones(fullPathDir);

        Document document   = new Document(SIZE_PDF, MAR_L, MAR_R, MAR_T, MAR_B);
        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(fullPathPdf));
        } catch (FileNotFoundException e) {
            throw new QandeMmiiException(e, "Archivo pdf no pudo ser creado ["+fullPathPdf+"]: "+e.getMessage());
        }
        writer.setPageEvent(this);
        document.open();

        this.generaPortada(writer, document, reporteInversionesClienteDto);
        this.generaHojaCuentas(writer, document, reporteInversionesClienteDto);
        this.generaHojaRentabilidades(writer, document, reporteInversionesClienteDto);

        document.close();
        writer.close();
        appConfig.customLog.info("Finalizado Generación PDF para cliente ID [: " + reporteInversionesClienteDto.getIdCliente()+"] y processDate: "+reporteInversionesClienteDto.getProcessDate());
        return fullPathPdf;
    }

    @Override
    @SuppressWarnings("squid:S00112")
    public void onEndPage(PdfWriter writer, Document document) {

        var numberOfPage = document.getPageNumber();
        if(numberOfPage>1) {
            try {
                addImageToDocument(document, this.getRutaBaseArtifacts()+"/investment-textbox.png", POS_LOGO1_X, POS_LOGO1_Y, WIDTH_LOGO1, HEIGHT_LOGO1);
                addImageToDocument(document, this.getRutaBaseArtifacts()+"/logo-suracorp.png", POS_LOGO2_X, POS_LOGO2_Y, WIDTH_LOGO2, HEIGHT_LOGO2);
                addImageToDocument(document, this.getRutaBaseArtifacts()+"/barra1.png", POS_HORIZBAR_X, POS_HORIZBAR_Y, WIDTH_HORIZBAR, HEIGHT_HORIZBAR);
                addImageToDocument(document, this.getRutaBaseArtifacts()+"/barra2.png", POS_VERTBAR1_X, POS_VERTBAR1_Y, WIDTH_VERTBAR, HEIGHT_VERTBAR);
                addImageToDocument(document, this.getRutaBaseArtifacts()+"/barra2.png", POS_VERTBAR2_X, POS_VERTBAR2_Y, WIDTH_VERTBAR, HEIGHT_VERTBAR);
            } catch (IOException e) {
                throw new RuntimeException("Error agregando imagenes auxiliares hoja cuentas: "+e.getMessage(), e.getCause());
            }
            PdfContentByte canvas = writer.getDirectContent();

            setDefaultFontColor(canvas);
            canvas.setColorFill(colorDarkGray);
            try {
                canvas.setFontAndSize(robotoBold(), 10);
            } catch (QandeMmiiException e) {
                throw new RuntimeException("Error agregando fuente Roboto Bold a nueva hoja: "+e.getMessage(), e.getCause());
            }
            canvas.setCharacterSpacing(CHAR_SEP_3);
            addDownToUpTextToCanvas(canvas, "INFORME PATRIMONIAL", 1428, 60);
            try {
                canvas.setFontAndSize(robotoBold(), 12);
            } catch (QandeMmiiException e) {
                throw new RuntimeException("Error agregando fuente Roboto Bold a nueva hoja: "+e.getMessage(), e.getCause());
            }
            canvas.setCharacterSpacing(CHAR_SEP_NO);
            addTextToCanvas(canvas, numberOfPage+".", 1420, 30);
        }

    }

}
