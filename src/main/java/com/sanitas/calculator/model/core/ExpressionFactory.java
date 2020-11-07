package com.sanitas.calculator.model.core;

/**
 * Factory Pattern
 * @autor FabianSR
 */
public interface ExpressionFactory<Q,T extends Number> {
    Expression<T> getExpression(final Q q);
}
