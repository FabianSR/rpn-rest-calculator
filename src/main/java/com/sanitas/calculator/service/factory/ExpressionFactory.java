package com.sanitas.calculator.service.factory;

import com.sanitas.calculator.model.core.Expression;

/**
 * Factory Pattern
 * @autor FabianSR
 */
public interface ExpressionFactory<Q,T extends Number> {
    Expression<T> getExpression(final Q q);
}
