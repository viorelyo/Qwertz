package qwertz.lib;

public class NumberValue implements Value {
    public static final NumberValue ZERO = new NumberValue(0);
    private final double value;

    public NumberValue(double value) {
        this.value = value;
    }

    public NumberValue(boolean value) {
        this.value = value ? 1 : 0;
    }

    @Override
    public double asNumber() {
        return value;
    }

    @Override
    public String asString() {
        return Double.toString(value);
    }

    @Override
    public String toString() {
        return asString();
    }
}
