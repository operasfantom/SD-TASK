package com.yatcheniy.calculator.tokens;

public interface Token {
    TokenType getToken();

    enum TokenType {
        BRACKET,
        NUMBER,
        OPERATION
    }
}
