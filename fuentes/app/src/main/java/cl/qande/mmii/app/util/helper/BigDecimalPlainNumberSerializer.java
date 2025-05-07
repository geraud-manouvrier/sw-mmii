package cl.qande.mmii.app.util.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalPlainNumberSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            // Eliminar ceros innecesarios
            BigDecimal normalized = value.stripTrailingZeros();

            // Si la escala queda negativa, ajustamos a 0
            if (normalized.scale() < 0) {
                normalized = normalized.setScale(0);
            }

            // Convertimos a plain string para evitar notación científica, pero escribimos como número
            gen.writeNumber(new BigDecimal(normalized.toPlainString()));
        }
    }
}
