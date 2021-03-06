package com.fabian.calculator.service.impl;

import com.fabian.calculator.util.Constants;
import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.service.factory.ExpressionFactory;
import com.fabian.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final ExpressionFactory expressionFactory;

    @Autowired
    public CalculatorServiceImpl(final ExpressionFactory expressionFactory){
        this.expressionFactory = expressionFactory;
    }

    /**
     * It parses the input string generating a list of expressions and evaluate them
     * @param input
     * @return
     */
    @Override
    public String process(final String input) {
        return evaluate(of(input.split(Constants.BLANK_STR)).map(s-> expressionFactory.getExpression(s)).collect(toList()));
    }

    /**
     * It takes the list of expressions built from the input string and applies
     * its interpret method from each of them, this applies the operation
     * (or takes the operand) and saves the result to a stack.
     * @param parsedExpressions
     * @return
     */
    private String evaluate(final List<Expression> parsedExpressions) {
        final Stack<Number> contextResults = new Stack<>();
        parsedExpressions.forEach(e -> e.interpret(contextResults));
        if(contextResults.size()>1) throw new EmptyStackException();
        return contextResults.pop().toString();
    }
}
