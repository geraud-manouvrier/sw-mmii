package cl.qande.mmii.app.util.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomThymeleafHelper {

    private static final String DEFAULT_SEP_DEC =".";
    private static final String DEFAULT_SEP_MIL ="";
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Para evitar que serialice como array numérico

    private CustomThymeleafHelper() {
        throw new IllegalStateException("Helper class");
    }





    private static String defaultFormat(BigDecimal number, int decimals) {
        return formatNumberWithDecimals(number, decimals, BigDecimal.ZERO, DEFAULT_SEP_DEC, DEFAULT_SEP_MIL);
    }
    private static String defaultFormat(BigDecimal number, int decimals, BigDecimal defaultValue) {
        return formatNumberWithDecimals(number, decimals, defaultValue, DEFAULT_SEP_DEC, DEFAULT_SEP_MIL);
    }

    private static String formatNumberWithDecimals(BigDecimal number, int decimals, BigDecimal defaultValue, String sepDec, String sepMil) {

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

    public static String formatRentWeb(BigDecimal number) {
        return defaultFormat(number, 4);
    }
    public static String formatMontoRepMaestrosWeb(BigDecimal number) {
        return defaultFormat(number, 4);
    }

    public static String formatRentRepMaestrosWeb(BigDecimal number) {
        return defaultFormat(number, 10);
    }
    public static String formatNumber(BigDecimal number, int decimals, BigDecimal defaultValue) {
        if (number==null && defaultValue==null) {
            return "";
        }
        return defaultFormat(number, decimals, defaultValue);
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
            CustomLog.getInstance().error("Error covietiendo Objeto a lista ["+lista+"]: "+e.getMessage(), false);
            return "[]"; // En caso de error, devuelve un array vacío
        }
    }


    public static List<String> getClassFields(Class<?> clazz) {
        if (clazz == null) {
            return Collections.emptyList(); // Si no se puede determinar la clase, devuelve una lista vacía
        }
        return streamInstanceFields(clazz)
                .map(Field::getName)
                .collect(Collectors.toList());
    }


    /** Predicado centralizado: solo campos de instancia y no serialVersionUID */
    private static final Predicate<Field> IS_INSTANCE_FIELD = f ->
            !Modifier.isStatic(f.getModifiers()) &&
                    !"serialVersionUID".equals(f.getName());

    /** Devuelve un Stream<Field> ya filtrado según IS_INSTANCE_FIELD */
    public static Stream<Field> streamInstanceFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(IS_INSTANCE_FIELD);
    }


}
