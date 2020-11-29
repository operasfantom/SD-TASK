package com.yatcheniy.calculator.visitors;

import com.yatcheniy.calculator.tokens.Bracket;
import com.yatcheniy.calculator.tokens.NumberToken;
import com.yatcheniy.calculator.tokens.Operation;
import com.yatcheniy.calculator.tokens.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {

    private final Stack<Token> operations = new Stack<>();
    private final List<Token> numbers = new ArrayList<>();

    @Override
    public void visit(Bracket token) {
        switch (token.getType()) {
            case OPEN:
                operations.add(token);
                break;
            case CLOSE:
                while (!operations.isEmpty()) {
                    var lastToken = operations.peek();
                    if (lastToken instanceof Bracket) {
                        var lastBracket = (Bracket) lastToken;
                        if (lastBracket.getType() == Bracket.BracketType.OPEN) {
                            operations.pop();
                            break;
                        }
                    }
                    if (lastToken instanceof Operation) {
                        numbers.add(lastToken);
                        operations.pop();
                        continue;
                    }
                    throw new IllegalStateException("Wrong order");
                }
                break;
        }
    }

    @Override
    public void visit(NumberToken token) {
        numbers.add(token);
    }

    @Override
    public void visit(Operation token) {
        while (!operations.isEmpty()) {
            var lastToken = operations.peek();
            if (lastToken instanceof Operation) {
                var lastOperation = (Operation) lastToken;
                if (token.getPriority() <= lastOperation.getPriority()) {
                    numbers.add(lastToken);
                    operations.pop();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        operations.add(token);
    }

    public List<Token> getParsedTokens() {
        while (!operations.isEmpty()) {
            var lastToken = operations.peek();
            if (lastToken instanceof Operation) {
                numbers.add(lastToken);
                operations.pop();
            } else {
                throw new IllegalStateException("No matching closing bracket");
            }
        }
        return numbers;
    }
}
