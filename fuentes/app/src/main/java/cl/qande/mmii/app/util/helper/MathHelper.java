package cl.qande.mmii.app.util.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathHelper {

    public static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final int MAX_DECIMALES = 15;


    private MathHelper() {
        throw new IllegalStateException("Utility class");
    }
    public static BigDecimal redondeaDecimal(BigDecimal originalValue, int decimales) {
        if (originalValue==null) {
            return null;
        }
        var tempValue    = originalValue;
        for (int i=MAX_DECIMALES; i>=decimales; i--) {
            tempValue   = tempValue.setScale(i, DEFAULT_ROUNDING_MODE);
        }
        return tempValue;
    }
    public static Double redondeaDecimal(Double originalValue, int decimales) {
        if (originalValue==null) {
            return null;
        }
        return redondeaDecimal(BigDecimal.valueOf(originalValue), decimales).doubleValue();
    }

    public static BigDecimal max(BigDecimal[] values) {
        BigDecimal maxValue = values[0];
        for (BigDecimal value : values) {
            if (value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static BigDecimal min(BigDecimal[] values) {
        BigDecimal minValue = values[0];
        for (BigDecimal value : values) {
            if (value.compareTo(minValue) < 0) {
                minValue = value;
            }
        }
        return minValue;
    }
}
