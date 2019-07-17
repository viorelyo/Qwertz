package qwertz;

import qwertz.ast.Statement;
import qwertz.lib.Variables;
import qwertz.parser.Lexer;
import qwertz.parser.Parser;
import qwertz.parser.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // read from file
//        final String input = new String(Files.readAllBytes(Paths.get("program.txt")), "UTF-8");
        final String input = "yo = 5.5 * 2 - 1 + YOLO\n" +
                             "word = \"yay \" + \"nice\" \n" +
                             "печать \"yo\" \n" +
                             "print \"\n\" \n" +
                             "print word";

        final List<Token> tokenList = new Lexer(input).tokenize();
//        for (Token token : tokenList) {
//            System.out.println(token);
//        }
//
       List<Statement> statements = new Parser(tokenList).parse();
//        for (Statement st : statements) {
//            System.out.println(st);
//        }
        for (Statement st : statements) {
            st.execute();
        }

    }
}
