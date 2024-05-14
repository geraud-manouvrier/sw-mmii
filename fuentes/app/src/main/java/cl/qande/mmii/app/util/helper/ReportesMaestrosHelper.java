package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteMaestroDatosService;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.opencsv.ICSVWriter.*;

@Component
public class ReportesMaestrosHelper {

    public static final String EXTENSION_EXCEL      = "xlsx";
    public static final String EXTENSION_CSV        = "csv";
    public static final String REPORTE_CLIENTES     = "Datos_Clientes";
    public static final String REPORTE_SALDOS       = "Saldos_Clientes";
    public static final String REPORTE_MOV          = "Movimientos";
    public static final String REPORTE_MOV_TRADE    = "Trade_Activity";
    public static final String REPORTE_MOV_EYS      = "Movimientos_de_Entrada_y_Salida";
    public static final int FLUJO_NETO_TRADE        = 0;
    public static final int FLUJO_NETO_EYS          = 1;
    public static final String FORMATO_FECHA_BD    = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_EXCEL = "mm/dd/yyyy";
    public static final String FIELD_CUSTODIAN      = "Custodian";
    public static final String FIELD_CLIENT_ID      = "Client_ID";
    public static final String FIELD_OFFICE_ID      = "Office_ID";
    public static final String FIELD_ACCOUNT_NO      = "Account_No";
    public static final String FIELD_CASH_MARGIN_ACC      = "Cash/Margin_Account";
    public static final String FIELD_PROCESS_DATE      = "Process_Date";
    public static final String FIELD_SYMBOL      = "Symbol";
    public static final String FIELD_CUSIP      = "Cusip";
    public static final String FIELD_PRODUCT_TYPE      = "Product_Type";
    public static final String FIELD_SEC_DESCR      = "Security_Description";
    public static final String FIELD_QUANTITY      = "Quantity";
    public static final String FIELD_CURRENCY      = "Currency";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IReporteMaestroDatosService reporteMaestroDatosService;

    public String csvValue(Object cellValue) {
        String value;
        int scale  = 6;
        if (cellValue==null) {
            value="";
        } else {
            if (cellValue instanceof String) {
                value   = (String)cellValue;
            } else if (cellValue instanceof Double) {
                value   = String.valueOf(BigDecimal.valueOf(((Double)cellValue).doubleValue()).setScale(scale, RoundingMode.UP)).replace('.', ',');
            } else if (cellValue instanceof Integer) {
                value   = String.valueOf(cellValue);
            } else if (cellValue instanceof Date) {
                value   = String.valueOf((int) DateUtil.getExcelDate((Date)cellValue));
            } else if (cellValue instanceof BigDecimal) {
                value   = String.valueOf(((BigDecimal)cellValue).setScale(scale, RoundingMode.UP)).replace('.', ',');
            } else {
                value   = cellValue.toString();
            }
        }
        return value;
    }

    public String generaSufijoArchivo(String varianteReporte) {
        if (varianteReporte == null || varianteReporte.equals("")) {
            return "";
        }
        return reporteMaestroDatosService.sufijoArchivo(varianteReporte);
    }


    public Date excelValueAsDate(String originalValue, String formatIn) throws QandeMmiiException {
        if(originalValue == null || originalValue.equals("")) {
            return null;
        }
        try {
            return calendarioHelper.convierteFechaStrToDateWithFormat(originalValue, formatIn);
        } catch (ParseException e) {
            throw new QandeMmiiException(e, "Error al formatear fecha ["+originalValue+"] al formato ["+formatIn+"]: "+e.getMessage());
        }
    }

    public List<String> generaListaVariantes(boolean porPaises) {
        if (porPaises) {
            return reporteMaestroDatosService.listaVariantes();
        }
        var listaVariantes = new ArrayList<String>();
        listaVariantes.add(null);
        return listaVariantes;
    }

    public String[] encabezadoClientes(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        if (tipoArchivo.equals(ReportesMaestrosHelper.EXTENSION_CSV)) {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID,
                    FIELD_OFFICE_ID, FIELD_ACCOUNT_NO, "Name",
                    "Date_of_Birth", "Account_Status", "Email",
                    "Country", "W8_Date", "W9_Date", "W8_Status", "W9_Status",
                    "Account_Type", FIELD_CASH_MARGIN_ACC, "Modelo_de_Relacionamiento",
                    "Debit_Card_Indicator", "Open_Date", "Close_Date", "Participant_Type", "Client_Investment_Profile",
                    "Advisory_Fee_Annual_Pct", "Last_Statement_Date", "Main_Advisor",
                    "Secondary_Advisor", "Email_Main_Advisor", "Email_Secondary_Advisor"
            };
        } else {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID, "Firm No", "Sub No", "Rep No",
                    FIELD_OFFICE_ID, FIELD_ACCOUNT_NO, "Name", "Full Name", "Address",
                    "Short_Name", "Date_of_Birth", "Account_Status", "Email", "Country-StoneX",
                    "Country", "W8_Date", "W9_Date", "W8_Status", "W9_Status",
                    "Discr Trading (Code)", "Account_Type", "Contratos Power Automate.Tipo Cuenta-PA", FIELD_CASH_MARGIN_ACC, "Modelo_de_Relacionamiento",
                    "Debit_Card_Indicator", "Open_Date", "Close_Date", "Participant_Type", "Client_Investment_Profile",
                    "Portfolio", "Tipo de Servicio", "Advisory_Fee_Annual_Pct", "Last_Statement_Date", "Main_Advisor",
                    "Secondary_Advisor", "Email_Main_Advisor", "Email_Secondary_Advisor", "Tax ID", "Last Activity Month",
                    "Institution (Code)", "Restriction Type", "Fondeo", "Monto Comprometido"
            };
        }
    }

    public String[] encabezadoSaldos(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        if (tipoArchivo.equals(ReportesMaestrosHelper.EXTENSION_CSV)) {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID, FIELD_OFFICE_ID,
                    "REP", FIELD_ACCOUNT_NO, "Name", FIELD_PROCESS_DATE,
                    FIELD_SYMBOL, FIELD_CUSIP, "ISIN", FIELD_PRODUCT_TYPE, FIELD_SEC_DESCR,
                    FIELD_CASH_MARGIN_ACC, FIELD_QUANTITY, "Market_Price", FIELD_CURRENCY, "Market_Value",
                    "Fx_Rate", "USDE_Market_Value", "Advisory_Fee_Annual_Pct", "Factor", "Comision_Devengada_Diaria",
                    "USDE_Market_Price"
            };
        } else {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID, "Firm No", "Sub No", FIELD_OFFICE_ID,
                    "Rep No", "REP", FIELD_ACCOUNT_NO, "Name", FIELD_PROCESS_DATE,
                    FIELD_SYMBOL, FIELD_CUSIP, "ISIN", FIELD_PRODUCT_TYPE, FIELD_SEC_DESCR,
                    FIELD_CASH_MARGIN_ACC, FIELD_QUANTITY, "Market_Price", FIELD_CURRENCY, "Market_Value",
                    "FX_Rate", "USDE_Market_Value", "Advisory_Fee_(Annual_%)", "Factor", "Comision_Devengada_Diaria",
                    "USDE_Market_Price", "Sec No", "Description 1", "Description 2", "Description 3",
                    "SEDOL", "Builder.Ticker", "Builder.IdSubSubTipoActivo", "Builder.IdSubTipoActivo", "Builder.IdTipoActivo",
                    "Builder.NombreSubSubTipoActivo", "Builder.SecId.1"
            };
        }
    }

    public String[] encabezadoMovimientos(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        if (tipoArchivo.equals(ReportesMaestrosHelper.EXTENSION_CSV)) {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID, FIELD_OFFICE_ID, FIELD_ACCOUNT_NO, "Name",
                    FIELD_PROCESS_DATE, "Trade_Date", "Settlement_Date", "Activity", "Buy/Sell",
                    FIELD_QUANTITY, "Price", "Commission", "Fees", "Net_Amount",
                    "USDE_Net_Amount", "Principal", FIELD_CUSIP, FIELD_SYMBOL, "ISIN",
                    FIELD_CURRENCY, "Fx_Rate", "Interest", "Currency_Base", FIELD_CASH_MARGIN_ACC,
                    FIELD_PRODUCT_TYPE, FIELD_SEC_DESCR, "Activity_Description", "Activity_Code"
            };
        } else {
            return new String[]{
                    FIELD_CUSTODIAN, FIELD_CLIENT_ID, FIELD_OFFICE_ID, FIELD_ACCOUNT_NO, "Name",
                    FIELD_PROCESS_DATE, "Trade_Date", "Settlement_Date", "Activity", "Buy/Sell",
                    FIELD_QUANTITY, "Price", "Commission", "Fees", "Net_Amount",
                    "USDE_Net_Amount", "Principal", FIELD_CUSIP, FIELD_SYMBOL, "ISIN",
                    FIELD_CURRENCY, "Fx_Rate", "Interest", "Currency_Base", FIELD_CASH_MARGIN_ACC,
                    FIELD_PRODUCT_TYPE, FIELD_SEC_DESCR, "Activity_Description", "Activity_Code", "Source Code",
                    "Reporte", "Description 1", "Description 2", "Description 3", "Builder.Ticker",
                    "Builder.IdSubSubTipoActivo", "Builder.IdSubTipoActivo", "Builder.IdTipoActivo", "Builder.NombreSubSubTipoActivo", "Builder.SecId.1",
                    "Aux Movimientos.Aplica Flujo Neto"};
        }

    }


    public void guardaArchivoCsv(List<String[]> contenidoCsv, String nombreArchivo) throws QandeMmiiException {

        var dirReportes     = new File(appConfig.appConfigProperties.getReportesMaestrosFolder()).getAbsolutePath();
        String fileLocation = dirReportes + "/"+nombreArchivo;

        CSVWriter writer;
        try {
            appConfig.customLog.info("Creando archivo CSV en directorio...");
            writer = new CSVWriter(new FileWriter(fileLocation, StandardCharsets.ISO_8859_1), ';', DEFAULT_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER, DEFAULT_LINE_END);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al crear archivo CSV");
        }

        appConfig.customLog.info("Escribiendo en disco...");
        writer.writeAll(contenidoCsv, false);

        try {
            appConfig.customLog.info("Cerrando archivo CSV...");
            writer.close();
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al cerrar archivo CSV");
        }
    }

    public String generaNombreReporte(String processDate, String tipoReporte, String varianteReporte, String tipoArchivo) throws QandeMmiiException {
        String extension;
        String nombreBase;
        String nombreArchivo;
        isValidTipoArchivo(tipoArchivo, true);
        isValidTipoReporte(tipoReporte, true);
        extension   = "."+tipoArchivo;
        nombreBase   = "-"+tipoReporte;
        nombreArchivo   = processDate+nombreBase+generaSufijoArchivo(varianteReporte)+extension;
        return nombreArchivo;
    }

    private boolean isValidTipoReporte(String tipoReporte, boolean throwException) throws QandeMmiiException {
        if ( (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_CLIENTES)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_SALDOS)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_MOV)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_MOV_TRADE)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_MOV_EYS))) {
            return true;
        }
        if (throwException) {
            throw new QandeMmiiException("Error en el tipo de Reporte Maestro a generar: ["+tipoReporte+"] no permitida.");
        }
        return false;
    }

    private boolean isValidTipoArchivo(String tipoArchivo, boolean throwException) throws QandeMmiiException {
        if ( (tipoArchivo.equals(ReportesMaestrosHelper.EXTENSION_EXCEL)) || (tipoArchivo.equals(ReportesMaestrosHelper.EXTENSION_CSV)) ) {
            return true;
        }
        if (throwException) {
            throw new QandeMmiiException("Error en la extensión a usar del Reporte Maestro: ["+tipoArchivo+"] no permitida.");
        }
        return false;
    }

    public Integer valueNotNull(BigDecimal originalValue) {
        if (originalValue==null) {
            return null;
        }
        return MathHelper.redondeaDecimal(originalValue, 0).toBigInteger().intValue();
    }
}
