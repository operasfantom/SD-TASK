package com.yatcheniy.calculator.visitors;

import com.yatcheniy.calculator.tokens.Bracket;
import com.yatcheniy.calculator.tokens.NumberToken;
import com.yatcheniy.calculator.tokens.Operation;
import com.yatcheniy.calculator.tokens.Token;

import java.util.List;

public interface TokenVisitor {
    void visit(Bracket token);

    void visit(NumberToken token);

    void visit(Operation token);

    default void iterateOverTokens(List<Token> tokens) {
        for (Token t : tokens) {
            switch (t.getToken()) {
                case BRACKET:
                    visit((Bracket) t);
                    break;
                case NUMBER:
                    visit((NumberToken) t);
                    break;
                case OPERATION:
                    visit((Operation) t);
                    break;
                default:
                    throw new IllegalStateException("Unrecognized token type:" + t.getToken());
            }
        }

    }
}
