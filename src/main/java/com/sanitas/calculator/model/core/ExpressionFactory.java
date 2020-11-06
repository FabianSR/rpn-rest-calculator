package com.sanitas.calculator.model.core;

/**
 * Factory Pattern
 * @autor FabianSR
 */
public interface ExpressionFactory {
    <T> Expression getExpresion(final T t);
}
