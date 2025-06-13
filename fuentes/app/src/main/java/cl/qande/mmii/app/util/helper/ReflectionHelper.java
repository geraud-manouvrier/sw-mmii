package cl.qande.mmii.app.util.helper;

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

        CustomThymeleafHelper.streamInstanceFields(obj.getClass())
                .peek(f -> f.setAccessible(true))
                .forEach(f -> {
                    try {
                        map.put(f.getName(), f.get(obj));
                    } catch (IllegalAccessException e) {
                        map.put(f.getName(), null);
                    }
                });

        return map;
    }
}
