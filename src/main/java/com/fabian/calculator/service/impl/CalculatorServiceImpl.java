package com.fabian.calculator.service.impl;

import com.fabian.calculator.service.CalculatorService;
import com.fabian.calculator.service.factory.ExpressionFactory;
import com.fabian.calculator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

import static java.util.stream.Stream.of;

/**
 * Calculator
 *
 * @autor FabianSR
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final ExpressionFactory expressionFactory;

    @Autowired
    public CalculatorServiceImpl(final ExpressionFactory expressionFactory) {
        this.expressionFactory = expressionFactory;
    }

    @Override
    public String evaluate(final String input) {
        return evaluate(input, new Stack<>());
    }

    /**
     * Separa la cadena de entrada en subcadenas con las que se construye un stream de expresiones (operaciones y operandos)
     * Cada expresión es interpretada, apilando el resultado según corresponda.
     *
     * @return
     */
    private String evaluate(final String input, final Stack<? extends Number> contextResults) {
        of(input.split(Constants.BLANK_STR)).map(s -> expressionFactory.getExpression(s)).forEach(e -> e.interpret(contextResults));
        return Optional.of(contextResults).filter(cr -> cr.size() == 1).map(Stack::pop).map(Number::toString).orElseThrow(EmptyStackException::new);
    }
}
