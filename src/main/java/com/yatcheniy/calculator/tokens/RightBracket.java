package com.yatcheniy.calculator.tokens;

public class RightBracket extends Bracket {
    @Override
    public BracketType getType() {
        return BracketType.CLOSE;
    }
}
