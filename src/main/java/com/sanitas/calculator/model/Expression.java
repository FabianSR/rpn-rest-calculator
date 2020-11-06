package com.sanitas.calculator.model;

import java.util.Stack;

public interface Expression {
    void interpret(final Stack<Long> context);
}
