package com.yatcheniy.calculator.tokenizer.state;

import com.yatcheniy.calculator.tokenizer.Tokenizer;
import com.yatcheniy.calculator.tokens.LeftBracket;
import com.yatcheniy.calculator.tokens.Operation;
import com.yatcheniy.calculator.tokens.RightBracket;

import static java.lang.Character.isDigit;

public class SymbolState implements State {
    @Override
    public void process(Tokenizer tokenizer, char c) {
        switch (c) {
            case '(':
                tokenizer.getTokens().add(new LeftBracket());
                return;
            case ')':
                tokenizer.getTokens().add(new RightBracket());
                return;
            case '+':
                tokenizer.getTokens().add(Operation.plus());
                return;
            case '-':
                tokenizer.getTokens().add(Operation.minus());
                return;
            case '/':
                tokenizer.getTokens().add(Operation.div());
                return;
            case '*':
                tokenizer.getTokens().add(Operation.mul());
                return;
        }

        if (Character.isWhitespace(c)) {
            return;
        }

        if (isDigit(c)) {
            tokenizer.setState(new NumberState());
            tokenizer.process(c);
            return;
        }

        throw new IllegalStateException("Unrecognized character: " + c);
    }

}
