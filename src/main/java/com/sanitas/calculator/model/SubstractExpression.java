package com.sanitas.calculator.model;

import java.util.Stack;

public class SubstractExpression implements Expression{
    @Override
    public void interpret(Stack<Long> context) {
        Long tmp = context.pop();
        context.push(context.pop()-tmp);
    }
}
