package qwertz.ast;

public class WhileStatement implements Statement {
    private final Expression condition;
    private final Statement statement;

    public WhileStatement(Expression condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void execute() {
        while (condition.eval().asDouble() != 0) {
            statement.execute();
        }
    }

    @Override
    public String toString() {
        return "while " + condition + " " + statement;
    }
}
