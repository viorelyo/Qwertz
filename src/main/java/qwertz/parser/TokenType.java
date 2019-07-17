package qwertz.parser;

public enum  TokenType {
    //data types
    NUMBER,
    WORD,
    TEXT,

    //keywords
    PRINT,
    IF,
    ELSE,

    //operators
    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    LT,     // <
    GT,     // >

    //symbols
    LPAREN,     // (
    RPAREN,     // )

    EOF
}
