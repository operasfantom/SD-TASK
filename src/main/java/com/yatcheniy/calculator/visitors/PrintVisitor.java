package com.yatcheniy.calculator.visitors;

import com.yatcheniy.calculator.tokens.Bracket;
import com.yatcheniy.calculator.tokens.NumberToken;
import com.yatcheniy.calculator.tokens.Operation;

public class PrintVisitor implements TokenVisitor {

    @Override
    public void visit(Bracket token) {
        System.out.print(token + " ");
    }

    @Override
    public void visit(NumberToken token) {
        System.out.printf("%s ", token);
    }

    @Override
    public void visit(Operation token) {
        System.out.printf("%s ", token);
    }

}
