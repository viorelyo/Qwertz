package qwertz.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Variables {
    private static Map<String, Value> variables;
    private static final Stack<Map<String, Value>> stack;

    static {
        stack = new Stack<>();
        variables = new HashMap<>();
        variables.put("PI", new NumberValue(Math.PI));
        variables.put("E", new NumberValue(Math.E));
        variables.put("YOLO", new NumberValue(42.0));
    }

    public static void push() {
        stack.push(new HashMap<>(variables));
    }

    public static void pop() {
        variables = stack.pop();
    }

    public static boolean exists(String key) {
        return variables.containsKey(key);
    }

    public static Value get(String key) {
        if (!exists(key))
            return NumberValue.ZERO;
        return variables.get(key);
    }

    public static void set(String key, Value value) {
        variables.put(key, value);
    }
}
