package qwertz;

import qwertz.ast.Statement;
import qwertz.parser.Lexer;
import qwertz.parser.Parser;
import qwertz.parser.Token;
import qwertz.utils.SourceLoader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0)
        {
            final String input = SourceLoader.readSource(args[0]);

            final List<Token> tokens = new Lexer(input).tokenize();
            final Parser parser = new Parser(tokens);
            final Statement parsedProgram = parser.parse();
            parsedProgram.execute();
        }
        else {
            System.out.println("Wrong usage: qwertz <filename>.qwz");
        }
    }
}
