package qwertz.ast;

import qwertz.lib.NumberValue;
import qwertz.lib.Value;

public class UnaryExpression implements Expression {
    private final Expression expr;
    private final char operation;

    public UnaryExpression(char operation, Expression expr) {
        this.operation = operation;
        this.expr = expr;
    }

    @Override
    public Value eval() {
        switch (operation)
        {
            case '+':
                return new NumberValue(expr.eval().asNumber());
            case '-':
                return new NumberValue(-expr.eval().asNumber());
            default:
                return expr.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("%c%s", operation, expr);
    }
}
