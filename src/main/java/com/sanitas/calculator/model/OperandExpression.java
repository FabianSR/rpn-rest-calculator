package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.Expression;

import java.util.Stack;

public class OperandExpression implements Expression {
    private Long value;

    public OperandExpression(final Long value){
        this.value=value;
    }
    @Override
    public void interpret(Stack<Long> context) {
        context.push(value);
    }
}
