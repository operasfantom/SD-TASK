package com.yatcheniy.calculator.tokens;

import java.util.function.BiFunction;

public class Operation implements Token {

    private final int priority;
    private final BiFunction<Integer, Integer, Integer> operation;
    private final String textOperation;

    private Operation(int priority, BiFunction<Integer, Integer, Integer> operation, String textOperation) {
        this.priority = priority;
        this.operation = operation;
        this.textOperation = textOperation;
    }

    public static Operation plus() {
        return new Operation(0, (x, y) -> x + y, "+");
    }

    public static Operation minus() {
        return new Operation(0, (x, y) -> x - y, "-");
    }

    public static Operation mul() {
        return new Operation(1, (x, y) -> x * y, "*");
    }

    public static Operation div() {
        return new Operation(1, (x, y) -> x / y, "/");
    }

    public String toString() {
        return textOperation;
    }

    public int getPriority() {
        return priority;
    }

    public Integer apply(int a, int b) {
        return operation.apply(a, b);
    }

    public TokenType getToken() {
        return TokenType.OPERATION;
    }

}
