package com.yatcheniy.calculator;

import com.yatcheniy.calculator.tokenizer.Tokenizer;
import com.yatcheniy.calculator.visitors.CalculatorVisitor;
import com.yatcheniy.calculator.visitors.ParserVisitor;
import com.yatcheniy.calculator.visitors.PrintVisitor;
import com.yatcheniy.calculator.visitors.TokenVisitor;

public class Calculator {
    public static void main(String[] args) {
        var input = String.join("", args);

        var tokenizer = new Tokenizer();
        tokenizer.tokenize(input);


        var parserVisitor = new ParserVisitor();
        parserVisitor.iterateOverTokens(tokenizer.getTokens());
        var polishTokens = parserVisitor.getParsedTokens();

        TokenVisitor printVisitor = new PrintVisitor();
        printVisitor.iterateOverTokens(polishTokens);

        var calculatorVisitors = new CalculatorVisitor();
        calculatorVisitors.iterateOverTokens(polishTokens);
        System.out.println();
        System.out.println(calculatorVisitors.getResult());

    }
}
