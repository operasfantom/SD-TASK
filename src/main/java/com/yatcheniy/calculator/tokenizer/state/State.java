package com.yatcheniy.calculator.tokenizer.state;

import com.yatcheniy.calculator.tokenizer.Tokenizer;

public interface State {

    default void process(Tokenizer tokenizer, char c) {
        throw new IllegalStateException("Not implemented");
    }

    default void finish(Tokenizer tokenizer) {
    }
}

