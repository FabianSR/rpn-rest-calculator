package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.Expression;

import java.util.Stack;

public class OperandExpression<T extends Number> implements Expression<T> {
    private T value;
    public OperandExpression(final T value) {this.value = value;
    }
    @Override
    public void interpret(Stack<T> context) {
        context.push(value);
    }
}
