package qwertz.ast;

public class UnaryExpression implements Expression {
    private final Expression expr;
    private final char operation;

    public UnaryExpression(char operation, Expression expr) {
        this.operation = operation;
        this.expr = expr;
    }

    @Override
    public double eval() {
        switch (operation)
        {
            case '+':
                return expr.eval();
            case '-':
                return -expr.eval();
            default:
                return expr.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("%c%s", operation, expr);
    }
}
