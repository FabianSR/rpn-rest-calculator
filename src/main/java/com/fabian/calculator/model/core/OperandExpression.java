package com.fabian.calculator.model.core;

import java.util.Stack;

/**
 * @author FabianSR
 * @param <T>
 */
public class OperandExpression<T extends Number> implements Expression<T> {
    private T value;

    public OperandExpression(final T value) {
        this.value = value;
    }

    @Override
    public void interpret(Stack<T> context) {
        context.push(value);
    }
}
