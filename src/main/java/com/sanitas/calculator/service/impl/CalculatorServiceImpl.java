package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.model.*;
import com.sanitas.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Long process(final String expression) {
        return evaluate(Stream.of(expression.split(" ")).map(this::getExpression).collect(Collectors.toList()));
    }

    private Expression getExpression(final String token){
        switch (token) {
            case "+": return new AddExpression();
            case "-": return new SubstractExpression();
            case "*": return new MultiplyExpression();
            case "/": return new DivideExpression();
            default: return new OperandExpression(Long.parseLong(token));
        }
    }

    private Long evaluate(List<Expression> parsedExpression) {
        final Stack<Long> contextResults = new Stack<>();
        parsedExpression.forEach(e->e.interpret(contextResults));
        return contextResults.pop();
    }
}
