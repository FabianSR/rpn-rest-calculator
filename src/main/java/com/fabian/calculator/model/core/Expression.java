package com.fabian.calculator.model.core;

import java.util.Stack;

/**
 * @autor FabianSR
 * @param <T>
 */
public interface Expression<T extends Number> {
    void interpret(final Stack<T> context);
}
