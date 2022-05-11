package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.model.core.OperationExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;

import static com.fabian.calculator.util.Constants.*;

public class OtherExampleExpressionFactoryImpl implements ExpressionFactory<String, Long> {

    @Override
    public Expression<Long> getExpression(final String token) {
        return switch (token) {
            case SUM_SIGN -> (OperationExpression<Long>) (a, b) -> a + b;
            case MINUS_SIGN -> (OperationExpression<Long>) (a, b) -> a - b;
            case MULTI_SIGN -> (OperationExpression<Long>) (a, b) -> a * b;
            case DIV_SIGN -> (OperationExpression<Long>) (a, b) -> a / b;
            default -> new OperandExpression(Long.valueOf(token));
        };
    }
}