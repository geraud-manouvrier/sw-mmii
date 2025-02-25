package cl.qande.mmii.app.util.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CustomThymeleafHelper {

    private static final String DEFAULT_SEP_DEC =".";
    private static final String DEFAULT_SEP_MIL =",";
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Para evitar que serialice como array numérico

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

    public static String convertListToJson(List<?> lista) {
        try {
            return objectMapper.writeValueAsString(ReflectionHelper.convertListToMap(lista));
        } catch (JsonProcessingException e) {
            CustomLog.getInstance().error("Error covietiendo Objeto a lista ["+lista+"]: "+e.getMessage());
            return "[]"; // En caso de error, devuelve un array vacío
        }
    }


    public static List<String> getClassFields(Class<?> clazz) {
        if (clazz == null) {
            return Collections.emptyList(); // Si no se puede determinar la clase, devuelve una lista vacía
        }
        return Arrays.stream(clazz.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList());
    }


}
