package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.model.core.OperationExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;

import java.math.BigDecimal;

import static com.fabian.calculator.util.Constants.*;

/**
 * Factory pattern
 * Concrete factory for BigDecimal
 *
 * @autor FabianSR
 */
public class ExpressionFactoryImpl implements ExpressionFactory<String, BigDecimal> {

    @Override
    public Expression<BigDecimal> getExpression(final String token) {
        return switch (token) {
            case SUM_SIGN -> (OperationExpression<BigDecimal>) (a, b) -> a.add(b);
            case MINUS_SIGN -> (OperationExpression<BigDecimal>) (a, b) -> a.subtract(b);
            case MULTI_SIGN -> (OperationExpression<BigDecimal>) (a, b) -> a.multiply(b);
            case DIV_SIGN -> (OperationExpression<BigDecimal>) (a, b) -> a.divide(b);
            default -> new OperandExpression(BigDecimal.valueOf(Double.valueOf(token)));
        };
    }
}
