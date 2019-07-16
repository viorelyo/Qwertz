package qwertz;

import qwertz.ast.Statement;
import qwertz.lib.Variables;
import qwertz.parser.Lexer;
import qwertz.parser.Parser;
import qwertz.parser.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String input = "word = (YOLO + 2)";
        final List<Token> tokenList = new Lexer(input).tokenize();
        for (Token token : tokenList) {
            System.out.println(token);
        }

        List<Statement> statements = new Parser(tokenList).parse();
        for (Statement st : statements) {
            System.out.println(st);
        }
        for (Statement st : statements) {
            st.execute();
        }
        System.out.printf("%s = %f", "word", Variables.get("word"));
//        System.out.printf("%s = %f", "word", Variables.get("word"));

    }
}
