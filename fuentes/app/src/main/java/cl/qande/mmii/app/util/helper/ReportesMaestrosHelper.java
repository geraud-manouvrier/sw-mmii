package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.opencsv.ICSVWriter.*;

@Component
public class ReportesMaestrosHelper {

    private static final Charset CHARSET_ISO_88591 = StandardCharsets.ISO_8859_1;
    public static final String EXTENSION_EXCEL      = "xlsx";
    public static final String EXTENSION_CSV        = "csv";
    public static final String REPORTE_CLIENTES     = "MaestroCuentas";
    public static final String REPORTE_SALDOS       = "MaestroSaldos";
    public static final String REPORTE_MOV          = "MaestroMovimientos";
    public static final String REPORTE_REL          = "MaestroRelacionados";
    public static final String FORMATO_FECHA_BD    = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_EXCEL = "mm/dd/yyyy";
    private static final String FIELD_CUSTODIAN      = "custodian";
    private static final String FIELD_CLIENT_ID      = "client_id";
    private static final String FIELD_TIPO_CLIENT_ID      = "tipo_id";
    private static final String FIELD_TIPO_CLIENT_GLOSA      = "glosa_tipo_id";
    private static final String FIELD_CLIENT_NAME      = "name";
    private static final String FIELD_OFFICE_ID      = "office_id";
    private static final String FIELD_ACCOUNT_NO      = "account_no";
    private static final String FIELD_CASH_MARGIN_ACC      = "cash_margin_account";
    private static final String FIELD_PROCESS_DATE      = "process_date";
    private static final String FIELD_CUSIP      = "cusip";
    private static final String FIELD_PRODUCT_TYPE      = "product_type";
    private static final String FIELD_SEC_DESCR      = "security_description";
    private static final String FIELD_QUANTITY      = "quantity";
    private static final String FIELD_CURRENCY      = "currency";
    private static final String FIELD_MARKET_VALUE = "market_value";
    private static final String FIELD_MARKET_PRICE = "market_price";
    private static final String FIELD_FX_RATE = "fx_rate";
    private static final String FIELD_USDE_MARKET_VALUE = "usde_market_value";
    private static final String FIELD_USDE_MARKET_PRICE = "usde_market_price";
    private static final String FIELD_NOMBRE_SUB_SUB_TIPO = "nombre_sub_sub_tipo";
    private static final String FIELD_FEE_ANUAL = "fee_anual";
    private static final String FIELD_FEE_PROTECCION = "fee_proteccion";
    private static final String FIELD_FEE_PROTECCION_DIARIO = "fee_proteccion_diario";
    private static final String FIELD_INGRESO_PROTECCION = "ingreso_proteccion";
    private static final String FIELD_TRADE_DATE = "trade_date";
    private static final String FIELD_SETTLEMENT_DATE = "settlement_date";
    private static final String FIELD_ACTIVITY = "activity";
    private static final String FIELD_BUY_SELL = "buy_sell";
    private static final String FIELD_PRICE = "price";
    private static final String FIELD_COMMISSION = "commission";
    private static final String FIELD_FEES = "fees";
    private static final String FIELD_NET_AMOUNT = "net_amount";
    private static final String FIELD_USDE_NET_AMOUNT = "usde_net_amount";
    private static final String FIELD_PRINCIPAL = "principal";
    private static final String FIELD_ACTIVITY_DESCRIPTION = "activity_description";
    private static final String FIELD_INGRESO_EGRESO_PRODUCTO = "ingreso_egreso_producto";
    private static final String FIELD_SOURCE_CODE = "source_code";
    private static final String FIELD_RETIRO = "retiro";
    private static final String FIELD_RECAUDO = "recaudo";
    private static final String FIELD_REL_ID = "id_relacionado";
    private static final String FIELD_REL_NOMBRE = "nombre_relacionado";
    private static final String FIELD_REL_TIPO_ID = "tipo_id_relacionado";
    private static final String FIELD_REL_TIPO_ID_GLOSA = "glosa_tipo_id_relacionado";
    private static final String FIELD_REL_CARGO_ID = "id_cargo_relacionado";
    private static final String FIELD_REL_CARGO_GLOSA = "glosa_cargo_relacionado";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;

    public String csvValue(Object cellValue) {
        String value;
        int scale  = 4;
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
                value = String.valueOf(((BigDecimal) cellValue).setScale(scale, RoundingMode.UP)).replace('.', ',');
            } else if (cellValue instanceof Boolean) {
                value   = ((Boolean)cellValue) ? "VERDADERO" : "FALSO";
            } else {
                value   = cellValue.toString();
            }
        }
        return value;
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

    public String[] encabezadoClientes(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        return new String[]{
                FIELD_PROCESS_DATE, FIELD_CUSTODIAN, FIELD_CLIENT_ID, FIELD_TIPO_CLIENT_ID, FIELD_OFFICE_ID,
            FIELD_ACCOUNT_NO, FIELD_CLIENT_NAME
        };
    }

    public String[] encabezadoSaldos(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        return new String[]{
            FIELD_CUSTODIAN, FIELD_OFFICE_ID, FIELD_TIPO_CLIENT_ID, FIELD_CLIENT_ID,
            FIELD_ACCOUNT_NO, FIELD_CLIENT_NAME, FIELD_PROCESS_DATE, FIELD_CUSIP,
            FIELD_SEC_DESCR, FIELD_QUANTITY, FIELD_MARKET_PRICE, FIELD_CURRENCY,
            FIELD_MARKET_VALUE, FIELD_FX_RATE, FIELD_USDE_MARKET_VALUE, FIELD_USDE_MARKET_PRICE,
            FIELD_NOMBRE_SUB_SUB_TIPO, FIELD_FEE_ANUAL, FIELD_FEE_PROTECCION, FIELD_FEE_PROTECCION_DIARIO,
            FIELD_INGRESO_PROTECCION
        };
    }

    public String[] encabezadoRelacionados(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        return new String[]{
            FIELD_PROCESS_DATE, FIELD_CUSTODIAN, FIELD_CLIENT_ID, FIELD_ACCOUNT_NO, FIELD_TIPO_CLIENT_ID,
            FIELD_TIPO_CLIENT_GLOSA, FIELD_OFFICE_ID, FIELD_CLIENT_NAME, FIELD_REL_ID, FIELD_REL_NOMBRE,
            FIELD_REL_TIPO_ID, FIELD_REL_TIPO_ID_GLOSA, FIELD_REL_CARGO_ID, FIELD_REL_CARGO_GLOSA
        };
    }

    public String[] encabezadoMovimientos(String tipoArchivo) throws QandeMmiiException {
        isValidTipoArchivo(tipoArchivo, true);
        return new String[]{
            FIELD_CUSTODIAN, FIELD_TIPO_CLIENT_ID, FIELD_CLIENT_ID, FIELD_OFFICE_ID,
            FIELD_ACCOUNT_NO, FIELD_CLIENT_NAME, FIELD_PROCESS_DATE, FIELD_TRADE_DATE,
            FIELD_SETTLEMENT_DATE, FIELD_ACTIVITY, FIELD_BUY_SELL, FIELD_QUANTITY,
            FIELD_PRICE, FIELD_COMMISSION, FIELD_FEES, FIELD_NET_AMOUNT,
            FIELD_USDE_NET_AMOUNT, FIELD_PRINCIPAL, FIELD_CUSIP, FIELD_CURRENCY,
            FIELD_FX_RATE, FIELD_CASH_MARGIN_ACC, FIELD_PRODUCT_TYPE, FIELD_SEC_DESCR,
            FIELD_ACTIVITY_DESCRIPTION, FIELD_SOURCE_CODE, FIELD_NOMBRE_SUB_SUB_TIPO, FIELD_INGRESO_EGRESO_PRODUCTO,
            FIELD_RETIRO, FIELD_RECAUDO
        };

    }


    public void guardaArchivoCsv(List<String[]> contenidoCsv, String nombreArchivo) throws QandeMmiiException {

        var dirReportes     = new File(appConfig.appConfigProperties.getReportesMaestrosFolder()).getAbsolutePath();
        String fileLocation = dirReportes + "/"+nombreArchivo;

        CSVWriter writer;
        try {
            CustomLog.getInstance().info("Creando archivo CSV en directorio...");
            writer = new CSVWriter(new FileWriter(fileLocation, CHARSET_ISO_88591), ';', DEFAULT_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER, DEFAULT_LINE_END);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al crear archivo CSV");
        }

        CustomLog.getInstance().info("Escribiendo en disco...");
        writer.writeAll(contenidoCsv, false);

        try {
            CustomLog.getInstance().info("Cerrando archivo CSV...");
            writer.close();
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al cerrar archivo CSV");
        }
    }

    public String generaNombreReporte(String processDate, String tipoReporte, String tipoArchivo) throws QandeMmiiException {
        String extension;
        String nombreBase;
        String nombreArchivo;
        isValidTipoArchivo(tipoArchivo, true);
        isValidTipoReporte(tipoReporte, true);
        extension   = "."+tipoArchivo;
        nombreBase   = "-"+tipoReporte;
        nombreArchivo   = processDate+nombreBase+extension;
        return nombreArchivo;
    }

    private boolean isValidTipoReporte(String tipoReporte, boolean throwException) throws QandeMmiiException {
        if ( (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_CLIENTES)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_SALDOS)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_MOV)) ||
                (tipoReporte.equals(ReportesMaestrosHelper.REPORTE_REL))
        ) {
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
