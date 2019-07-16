package qwertz.ast;

import qwertz.lib.Variables;

public class ConstantExpression implements Expression {
    private final String name;

    public ConstantExpression(String name) {
        this.name = name;
    }

    @Override
    public double eval() {
        if (!Variables.exists(name))
            throw new RuntimeException("Constant doesn't exist");
        return Variables.get(name);
    }

    @Override
    public String toString() {
        return String.format("%s", name, Variables.get(name));
    }
}
