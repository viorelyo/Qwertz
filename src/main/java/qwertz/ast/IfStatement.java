package qwertz.ast;

public class IfStatement implements Statement {
    private final Expression expression;
    private final Statement ifStatement;
    private final Statement elseStatement;

    public IfStatement(Expression expression, Statement ifStatement, Statement elseStatement) {
        this.expression = expression;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void execute() {
        final double result = expression.eval().asNumber();
        if (result != 0) {
            ifStatement.execute();
        }
        else if (elseStatement != null) {
            elseStatement.execute();
        }
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("if ")
                .append(expression)
                .append(' ')
                .append(ifStatement.toString());
        if (elseStatement != null) {
            result.append("\nelse ").append(elseStatement);
        }
        return result.toString();
    }
}
