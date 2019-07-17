package qwertz.parser;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private static final String OPERATOR_CHARS = "+-*/()=<>";
    private static final TokenType[] OPERATOR_TOKENS = {
        TokenType.PLUS, TokenType.MINUS,
        TokenType.STAR, TokenType.SLASH,
        TokenType.LPAREN, TokenType.RPAREN,
        TokenType.EQ, TokenType.LT, TokenType.GT
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
            else if (Character.isLetter(current))
                tokenizeWord();
            else if (current =='"') {
                tokenizeText();
            }
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

    private void tokenizeText() {
        next();     // skip opening - "
        final StringBuilder buffer = new StringBuilder();

        char current = peek(0);
        while (true) {
            // process strings skips i.e.: " \" hello\" ", \n, etc.
            if (current == '\\') {
                current = next();
                switch (current) {
                    case '"':
                        current = next();
                        buffer.append('"');
                        continue;
                    case 'n':
                        current = next();
                        buffer.append('\n');
                        continue;
                    case 't':
                        current = next();
                        buffer.append('\t');
                        continue;
                }
                buffer.append('\\');
                continue;
            }
            if (current == '"') {
                break;
            }
            buffer.append(current);
            current = next();
        }
        next();     // skip closing - "

        addToken(TokenType.TEXT, buffer.toString());
    }

    /**
     * Multilanguage support for keywords
     */
    private void tokenizeWord() {
        final StringBuilder buffer = new StringBuilder();

        char current = peek(0);
        while (true) {
            if (!Character.isLetterOrDigit(current) && (current != '_' && (current != '$'))) {
                break;
            }
            buffer.append(current);
            current = next();
        }

        final String word = buffer.toString();
        if (word.equals("print") || word.equals("afișează") || word.equals("drücke") || word.equals("печать"))
        {
            addToken(TokenType.PRINT);
        }
        else if (word.equals("if") || word.equals("dacă") || word.equals("falls") || word.equals("если")) {
            addToken(TokenType.IF);
        }
        else if (word.equals("else") || word.equals("altfel") || word.equals("sonst") || word.equals("иначе")) {
            addToken(TokenType.ELSE);
        }
        else {
            addToken(TokenType.WORD, buffer.toString());
        }
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








