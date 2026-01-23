package cl.qande.mmii.app.util.helper;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
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

        var fields = CustomThymeleafHelper
                .streamInstanceFields(obj.getClass())
                .collect(java.util.stream.Collectors.toList());
        if (!fields.isEmpty()) {
            for (Field f : fields) {
                try {
                    f.setAccessible(true);
                    map.put(f.getName(), f.get(obj));
                } catch (Exception e) {
                    map.put(f.getName(), null);
                }
            }
            return map;
        }
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(obj.getClass(), Object.class).getPropertyDescriptors()) {
                var read = pd.getReadMethod();
                String name = pd.getName();
                if ( (read == null) || (isIgnoredMethod(name)) ) continue;

                try {
                    read.setAccessible(true);
                    Object value = read.invoke(obj);
                    map.put(name, value);
                } catch (Exception e) {
                    map.put(name, null);
                }
            }
        } catch (IntrospectionException e) {
            // si no se puede introspectar, deja map vacío
        }

        return map;
    }

    private static boolean isIgnoredMethod(String methodName) {
        return "class".equals(methodName) ||
               "decoratedClass".equals(methodName) ||
               "target".equals(methodName) ||
               "targetClass".equals(methodName) ||
               "projectionAsString".equals(methodName) ||
               "serialVersionUID".equals(methodName);
    }
}
