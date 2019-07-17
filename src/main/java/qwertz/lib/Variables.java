package qwertz.lib;

import java.util.HashMap;
import java.util.Map;

public class Variables {
    private static final NumberValue ZERO = new NumberValue(0);
    private static final Map<String, Value> variables;

    static {
        variables = new HashMap<>();
        variables.put("PI", new NumberValue(Math.PI));
        variables.put("E", new NumberValue(Math.E));
        variables.put("YOLO", new NumberValue(42.0));
    }

    public static boolean exists(String key) {
        return variables.containsKey(key);
    }

    public static Value get(String key) {
        if (!exists(key))
            return ZERO;
        return variables.get(key);
    }

    public static void set(String key, Value value) {
        variables.put(key, value);
    }
}
