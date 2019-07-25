package qwertz.parser;

import qwertz.ast.FunctionalExpression;
import qwertz.ast.Statement;

public class FunctionStatement implements Statement {
    private final FunctionalExpression function;

    public FunctionStatement(FunctionalExpression function) {
        this.function = function;
    }

    @Override
    public void execute() {
        function.eval();
    }

    @Override
    public String toString() {
        return function.toString();
    }
}
