package com.yatcheniy.calculator.tokenizer.state;

import com.yatcheniy.calculator.tokenizer.Tokenizer;
import com.yatcheniy.calculator.tokens.NumberToken;

import static java.lang.Character.isDigit;

class NumberState implements State {
    private int number = 0;

    @Override
    public void process(Tokenizer tokenizer, char c) {
        if (isDigit(c)) {
            number *= 10;
            number += (c - '0');
        } else {
            tokenizer.getTokens().add(new NumberToken(number));
            tokenizer.setState(new SymbolState());
            tokenizer.process(c);
        }
    }

    @Override
    public void finish(Tokenizer tokenizer) {
        tokenizer.getTokens().add(new NumberToken(number));
    }
}
