package cl.qande.mmii.app.util.helper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class CustomThymeleafHelper {

    private static final String DEFAULT_SEP_DEC =".";
    private static final String DEFAULT_SEP_MIL =",";

    private CustomThymeleafHelper() {
        throw new IllegalStateException("Helper class");
    }
    public static String formatNumberWithDecimals(BigDecimal number, int decimals, BigDecimal defaultValue) {
        return formatNumberWithDecimals(number, decimals, defaultValue, DEFAULT_SEP_DEC, DEFAULT_SEP_MIL);
    }
    public static String formatNumberWithDecimals(BigDecimal number, int decimals, BigDecimal defaultValue, String sepDec) {
        return formatNumberWithDecimals(number, decimals, defaultValue, sepDec, DEFAULT_SEP_MIL);
    }
    public static String formatNumberWithDecimals(BigDecimal number, int decimals, BigDecimal defaultValue, String sepDec, String sepMil) {

        String ceroDecimal = "0".repeat(decimals);
        var valueMask   = "#".concat(sepMil).concat("###");
        if (decimals>0) {
            valueMask   = valueMask.concat(sepDec);
        }
        var numberToReturn  = number;

        if (number == null) {
            numberToReturn  = defaultValue;
        }else if (number.abs().compareTo(BigDecimal.ONE) < 0) {
            valueMask   = "0".concat(sepDec);
        }
        if ( numberToReturn.compareTo(BigDecimal.ZERO) == 0 ) {
            return (decimals==0) ? "0" : "0".concat(sepDec).concat(ceroDecimal);
        }
        valueMask   = valueMask.concat(ceroDecimal);
        BigDecimal valorRedondeado  = MathHelper.redondeaDecimal(numberToReturn, decimals);

        DecimalFormat decimalFormat = new DecimalFormat(valueMask, new DecimalFormatSymbols(Locale.ENGLISH));
        decimalFormat.setRoundingMode(MathHelper.DEFAULT_ROUNDING_MODE);
        return decimalFormat.format(valorRedondeado);
    }
    public static String formatNumberDefault(BigDecimal number) {
        return formatNumberWithDecimals(number, 4, BigDecimal.ZERO, DEFAULT_SEP_DEC, DEFAULT_SEP_MIL);
    }
    public static String formatMontoRepInvWeb(BigDecimal number) {
        return formatNumberWithDecimals(number, 4, BigDecimal.ZERO, DEFAULT_SEP_DEC, "");
    }

    public static String formatRentRepInvWeb(BigDecimal number) {
        return formatNumberWithDecimals(number, 10, BigDecimal.ZERO, DEFAULT_SEP_DEC, "");
    }
    public static String formatMontoRepMaestrosWeb(BigDecimal number) {
        return formatNumberWithDecimals(number, 4, BigDecimal.ZERO, DEFAULT_SEP_DEC, "");
    }

    public static String formatRentRepMaestrosWeb(BigDecimal number) {
        return formatNumberWithDecimals(number, 10, BigDecimal.ZERO, DEFAULT_SEP_DEC, "");
    }

    public static String formatFechaRepMaestrosWeb(String fechaAsYmd) {
        if (fechaAsYmd == null || fechaAsYmd.isBlank()) {
            return "";
        }
        var valuetoReturn   = fechaAsYmd.replace("-", "");
        if (valuetoReturn.length() == 8) {
            //Formato MM/DD/YYYY
            return valuetoReturn.substring(4, 6).concat("/").concat(valuetoReturn.substring(6, 8)).concat("/").concat(valuetoReturn.substring(0, 4));
        }
        return fechaAsYmd;
    }
    public static String formatFechaRepMaestrosWeb(LocalDate fechaAsYmd) {
        CalendarioHelper calendarioHelper = new CalendarioHelper();
        return calendarioHelper.convierteDateToStringWithFormat(CalendarioHelper.dateFromLocalDate(fechaAsYmd), CalendarioHelper.FORMATO_HTML);
    }


}
