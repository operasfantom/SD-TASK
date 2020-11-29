package com.yatcheniy.calculator.tokens;

public abstract class Bracket implements Token {

    public abstract BracketType getType();

    public TokenType getToken() {
        return TokenType.BRACKET;
    }

    public enum BracketType {
        OPEN,
        CLOSE
    }
}
