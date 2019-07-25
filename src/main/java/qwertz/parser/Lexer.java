package qwertz.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    private static final String OPERATOR_CHARS = "+-*/(){}=<>!&|:,";

    private static final Map<String, TokenType> OPERATORS;
    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put("+", TokenType.PLUS);
        OPERATORS.put("-", TokenType.MINUS);
        OPERATORS.put("*", TokenType.STAR);
        OPERATORS.put("/", TokenType.SLASH);
        OPERATORS.put("(", TokenType.LPAREN);
        OPERATORS.put(")", TokenType.RPAREN);
        OPERATORS.put("{", TokenType.LBRACE);
        OPERATORS.put("}", TokenType.RBRACE);
        OPERATORS.put("=", TokenType.EQ);
        OPERATORS.put("<", TokenType.LT);
        OPERATORS.put(">", TokenType.GT);
        OPERATORS.put(":", TokenType.COLON);
        OPERATORS.put(",", TokenType.COMMA);

        OPERATORS.put("!", TokenType.EXCL);
        OPERATORS.put("&", TokenType.AMP);
        OPERATORS.put("|", TokenType.BAR);

        OPERATORS.put("==", TokenType.EQEQ);
        OPERATORS.put("!=", TokenType.EXCLEQ);
        OPERATORS.put("<=", TokenType.LTEQ);
        OPERATORS.put(">=", TokenType.GTEQ);

        OPERATORS.put("&&", TokenType.AMPAMP);
        OPERATORS.put("||", TokenType.BARBAR);
    }

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
        else if (word.equals("while") || word.equals("câtTimp") || word.equals("während") || word.equals("пока")) {
            addToken(TokenType.WHILE);
        }
        else if (word.equals("for") || word.equals("pentru") || word.equals("für") || word.equals("для")) {
            addToken(TokenType.FOR);
        }
        else if (word.equals("do") || word.equals("execută") || word.equals("tue") || word.equals("делай")) {
            addToken(TokenType.DO);
        }
        else if (word.equals("break") || word.equals("oprește") || word.equals("brechen") || word.equals("стопэ")) {
            addToken(TokenType.BREAK);
        }
        else if (word.equals("continue") || word.equals("continuă") || word.equals("fortsetzen") || word.equals("Продолжить")) {
            addToken(TokenType.CONTINUE);
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
        char current = peek(0);
        if (current == '/') {
            if (peek(1) == '/') {
                next();
                next();
                tokenizeComment();
                return;
            }
            else if (peek(1) == '*') {
                next();
                next();
                tokenizeMultilineComment();
                return;
            }
        }

        final StringBuilder buffer = new StringBuilder();
        while (true) {
            final String text = buffer.toString();
            if (!OPERATORS.containsKey(text + current) && !text.isEmpty()) {
                addToken(OPERATORS.get(text));
                return;
            }
            buffer.append(current);
            current = next();
        }
    }

    private void tokenizeComment() {
        char current = peek(0);
        while ("\r\n\0".indexOf(current) == -1) {
            current = next();
        }
    }

    private void tokenizeMultilineComment() {
        char current = peek(0);
        while (true) {
            if (current == '\0')
                throw new RuntimeException("Missing closing tag");
            if (current == '*' && peek(1) == '/')
                break;
            current = next();
        }
        next();     // skip *
        next();     // skip /
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








