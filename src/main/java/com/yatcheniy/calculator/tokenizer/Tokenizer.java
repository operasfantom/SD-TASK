package com.yatcheniy.calculator.tokenizer;

import com.yatcheniy.calculator.tokenizer.state.EofState;
import com.yatcheniy.calculator.tokenizer.state.State;
import com.yatcheniy.calculator.tokenizer.state.SymbolState;
import com.yatcheniy.calculator.tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final List<Token> tokens;
    private State state;

    public Tokenizer() {
        this.state = new SymbolState();
        this.tokens = new ArrayList<>();
    }


    public void process(char c) {
        state.process(this, c);
    }

    public void tokenize(String input) {
        for (int i = 0; i < input.length(); i++) {
            process(input.charAt(i));
        }

        state.finish(this);
        state = new EofState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
