package qwertz.ast;

import qwertz.lib.Functions;
import qwertz.lib.UserDefinedFunction;

import java.util.List;

public class FunctionDefineStatement implements Statement {
    private final String name;
    private final List<String> argNames;
    private final Statement body;

    public FunctionDefineStatement(String name, List<String> argNames, Statement body) {
        this.name = name;
        this.argNames = argNames;
        this.body = body;
    }

    @Override
    public void execute() {
        Functions.set(name, new UserDefinedFunction(argNames, body));
    }

    @Override
    public String toString() {
        return "fun " + " name(" + argNames.toString() + ") " + body.toString();
    }
}
