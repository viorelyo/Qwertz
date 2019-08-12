package qwertz.ast;

import qwertz.lib.Value;
import qwertz.lib.Variables;

public class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.exists(name))
            throw new RuntimeException("Constant doesn't exist");
        return Variables.get(name);
    }

    @Override
    public String toString() {
        return String.format("%s", name, Variables.get(name));
    }
}
