package qwertz.parser;

public enum  TokenType {
    NUMBER,
    WORD,
    TEXT,

    //keywords
    PRINT,

    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    LPAREN,     // (
    RPAREN,     // )
    EOF
}
