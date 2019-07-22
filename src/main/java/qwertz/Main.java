package qwertz;

import qwertz.ast.Statement;
import qwertz.lib.Variables;
import qwertz.parser.Lexer;
import qwertz.parser.Parser;
import qwertz.parser.Token;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        // read from file
        final String input = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("program.txt").toURI())), "UTF-8");

        final List<Token> tokenList = new Lexer(input).tokenize();
//        for (Token token : tokenList) {
//            System.out.println(token);
//        }
//
       final Statement program = new Parser(tokenList).parse();
       System.out.println(program.toString());
       program.execute();
    }
}
