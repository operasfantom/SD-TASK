package com.yatcheniy.calculator.visitors;

import com.yatcheniy.calculator.tokens.Bracket;
import com.yatcheniy.calculator.tokens.NumberToken;
import com.yatcheniy.calculator.tokens.Operation;

import java.util.Stack;

public class CalculatorVisitor implements TokenVisitor {

    private final Stack<Integer> stack = new Stack<>();

    @Override
    public void visit(Bracket token) {
        throw new IllegalStateException("Calculated state can't contains brackets");
    }

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getN());
    }

    @Override
    public void visit(Operation token) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Operation must apply two elements");
        }
        int b = stack.pop();
        int a = stack.pop();

        int result = token.apply(a, b);
        stack.add(result);
    }

    public int getResult() {
        return stack.pop();
    }

}
