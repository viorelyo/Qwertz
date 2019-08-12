package qwertz.ast;

import qwertz.lib.*;

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

        final Function function = Functions.get(name);
        if (function instanceof UserDefinedFunction) {
            final UserDefinedFunction userDefinedFunction = (UserDefinedFunction) function;
            if (size != userDefinedFunction.getArgsCount())
                throw new RuntimeException("Args count mismatch");

            Variables.push();
            for (int i = 0; i < size; i++) {
                Variables.set(userDefinedFunction.getArgsName(i), values[i]);
            }
            final Value result = userDefinedFunction.execute(values);
            Variables.pop();
            return result;
        }

        return function.execute(values);
    }


    @Override
    public String toString() {
        return name + "(" + arguments.toString() + ")";
    }
}
