package qwertz;

import qwertz.ast.Expression;
import qwertz.parser.Lexer;
import qwertz.parser.Parser;
import qwertz.parser.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String input = "(YOLO + 2)";
        final List<Token> tokenList = new Lexer(input).tokenize();
        for (Token token : tokenList) {
            System.out.println(token);
        }

        List<Expression> expressions = new Parser(tokenList).parse();
        for (Expression expr : expressions) {
            System.out.println(expr + " = " + expr.eval());
        }
    }
}
