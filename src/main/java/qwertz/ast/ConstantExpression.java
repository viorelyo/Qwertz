package qwertz.ast;

import qwertz.lib.Constants;

public class ConstantExpression implements Expression {
    private final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public double eval() {
        if (!Constants.exists(name))
            throw new RuntimeException("Constant doesn't exist");
        return Constants.get(name);
    }

    @Override
    public String toString() {
        return String.format("%s", name, Constants.get(name));
    }
}
