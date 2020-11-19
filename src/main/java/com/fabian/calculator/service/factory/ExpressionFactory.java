package com.fabian.calculator.service.factory;

import com.fabian.calculator.model.core.Expression;

/**
 * Factory Pattern
 * @autor FabianSR
 */
public interface ExpressionFactory<Q,T extends Number> {
    Expression<T> getExpression(final Q q);
}
