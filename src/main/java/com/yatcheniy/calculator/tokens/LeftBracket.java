package com.yatcheniy.calculator.tokens;

public class LeftBracket extends Bracket {
    @Override
    public BracketType getType() {
        return BracketType.OPEN;
    }
}
