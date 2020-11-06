package com.sanitas.calculator.model;

import java.util.Stack;

public class AddExpression implements Expression{
    @Override
    public void interpret(Stack<Long> context) {
         context.push(context.pop()+context.pop());
    }
}
