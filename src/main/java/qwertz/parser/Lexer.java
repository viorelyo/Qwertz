package qwertz.parser;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private static final String OPERATOR_CHARS = "+-*/()";
    private static final TokenType[] OPERATOR_TOKENS = {
        TokenType.PLUS, TokenType.MINUS,
        TokenType.STAR, TokenType.SLASH,
        TokenType.LPAREN, TokenType.RPAREN
    };

    private final String input;
    private final List<Token> tokens;
    private final int length;

    private int pos;

    public Lexer(String input) {
        this.input = input;
        this.length = input.length();

        this.tokens = new ArrayList<>();
    }

    public List<Token> tokenize() {
        while (pos < length) {
            final char current = peek(0);
            if (Character.isDigit(current))
                tokenizeNumber();
            else if (OPERATOR_CHARS.indexOf(current) != -1) {
                tokenizeOperator();
            }
            else {
                // White spaces
                next();
            }
        }
        return tokens;
    }

    private void tokenizeNumber() {
        final StringBuilder buffer = new StringBuilder();

        char current = peek(0);
        while (true) {
            // parse floating numbers
            if (current == '.') {
                if (buffer.indexOf(".") != -1)
                    throw new RuntimeException("Invalid float");
            }
            else if (!Character.isDigit(current)) {
                break;
            }
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.NUMBER, buffer.toString());
    }

    private void tokenizeOperator() {
        final int positionOfOperatorType = OPERATOR_CHARS.indexOf(peek(0));
        addToken(OPERATOR_TOKENS[positionOfOperatorType]);
        next();
    }

    private char next() {
        pos++;
        return peek(0);
    }

    private char peek(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= length)
            return '\0';
        return input.charAt(position);
    }

    private void addToken(TokenType type) {
        addToken(type, "");
    }

    private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}








