package qwertz.ast;

import qwertz.lib.Functions;
import qwertz.lib.Value;

import java.util.ArrayList;
import java.util.List;

public class FunctionalExpression implements Expression {
    private final String name;
    private final List<Expression> arguments;

    public FunctionalExpression(String name, List<Expression> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public FunctionalExpression(String name) {
        this.name = name;
        arguments = new ArrayList<>();
    }

    public void addArgument(Expression arg) {
        arguments.add(arg);
    }

    @Override
    public Value eval() {
        final int size = arguments.size();
        Value[] values = new Value[arguments.size()];

        for (int i = 0; i < size; i++) {
            values[i] = (arguments.get(i).eval());
        }
        return Functions.get(name).execute(values);
    }


    @Override
    public String toString() {
        return name + "(" + arguments.toString() + ")";
    }
}
