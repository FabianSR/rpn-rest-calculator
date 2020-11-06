package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.core.ExpressionFactory;
import com.sanitas.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sanitas.calculator.util.Constants.BLANK_STR;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final ExpressionFactory expressionFactory;

    @Autowired
    public CalculatorServiceImpl(final ExpressionFactory expressionFactory){
        this.expressionFactory = expressionFactory;
    }
    @Override
    public String process(final String input) {
        return evaluate(Stream.of(input.split(BLANK_STR)).map(s-> expressionFactory.getExpresion(s)).collect(Collectors.toList()));
    }

    private String evaluate(final List<Expression> parsedExpression) {
        final Stack<Long> contextResults = new Stack<>();
        parsedExpression.forEach(e -> e.interpret(contextResults));
        return contextResults.pop().toString();
    }
}
