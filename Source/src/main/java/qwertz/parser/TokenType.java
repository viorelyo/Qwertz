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
    WHILE,
    FOR,
    DO,
    BREAK,
    CONTINUE,
    FUN,
    RETURN,

    //operators
    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    EQEQ,   // ==
    LT,     // <
    GT,     // >
    LTEQ,
    GTEQ,
    EXCL,   // !
    EXCLEQ, // !=

    //bitwise operators
    BAR,        // |  (bitwise or)
    BARBAR,     // || (or)
    AMP,        // &  (bitwise and)
    AMPAMP,     // && (and)

    //symbols
    LPAREN,     // (
    RPAREN,     // )
    LBRACE,     // {
    RBRACE,     // }
    LBRACKET,   // [
    RBRACKET,   // ]
    COLON,      // :
    COMMA,      // ,

    EOF
}
