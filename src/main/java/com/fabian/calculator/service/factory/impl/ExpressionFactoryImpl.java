package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.AddExpression;
import com.fabian.calculator.model.DivideExpression;
import com.fabian.calculator.model.MultiplyExpression;
import com.fabian.calculator.model.SubtractExpression;
import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.model.core.OperandExpression;
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
        switch (token) {
            case SUM_SIGN: return new AddExpression();
            case MINUS_SIGN: return new SubtractExpression();
            case MULTI_SIGN: return new MultiplyExpression();
            case DIV_SIGN: return new DivideExpression();
            default: return new OperandExpression(BigDecimal.valueOf(Double.valueOf(token)));
        }
    }
}
