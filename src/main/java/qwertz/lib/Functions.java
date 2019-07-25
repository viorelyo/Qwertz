package qwertz.lib;

import java.util.HashMap;
import java.util.Map;

public class Functions {
    private static final NumberValue ZERO = new NumberValue(0);
    private static final Map<String, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put("sin", args -> {
            if (args.length != 1)
                throw new RuntimeException("One arg expected");
            return new NumberValue(Math.sin(args[0].asNumber()));
        });
        functions.put("cos", args -> {
            if (args.length != 1)
                throw new RuntimeException("One arg expected");
            return new NumberValue(Math.cos(args[0].asNumber()));
        });
        functions.put("fancyPrint", args -> {
            for (Value arg : args) {
                System.out.print(arg.asString() + " ");
            }
            return ZERO;
        });
    }

    public static boolean exists(String key) {
        return functions.containsKey(key);
    }

    public static Function get(String key) {
        if (!exists(key))
            throw new RuntimeException("Unknown function " + key);
        return functions.get(key);
    }

    public static void set(String key, Function func) {
        functions.put(key, func);
    }
}
