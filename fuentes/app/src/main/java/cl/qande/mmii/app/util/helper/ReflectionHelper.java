package cl.qande.mmii.app.util.helper;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReflectionHelper {

    private ReflectionHelper() {
        throw new IllegalStateException("Helper class");
    }


    public static List<Map<String, Object>> convertListToMap(List<?> lista) {
        if (lista == null || lista.isEmpty()) {
            return Collections.emptyList();
        }

        return lista.stream().map(ReflectionHelper::convertObjectToMap).collect(Collectors.toList());
    }

    private static Map<String, Object> convertObjectToMap(Object obj) {
        Map<String, Object> map = new LinkedHashMap<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                map.put(field.getName(), null); // Si hay error, pone null
            }
        }

        return map;
    }
}
