package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.service.factory.ExpressionFactory;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

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
        return evaluate(of(input.split(BLANK_STR)).map(s-> expressionFactory.getExpression(s)).collect(toList()));
    }

    private String evaluate(final List<Expression> parsedExpressions) {
        final Stack<Number> contextResults = new Stack<>();
        parsedExpressions.forEach(e -> e.interpret(contextResults));
        return contextResults.size()>1? Constants.EXPRESSION_IS_NOT_COMPLETE:contextResults.pop().toString();
    }
}
