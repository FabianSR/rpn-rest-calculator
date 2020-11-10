package com.sanitas.calculator.service.factory.impl;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.AddExpression;
import com.sanitas.calculator.model.SubtractExpression;
import com.sanitas.calculator.service.factory.ExpressionFactory;
import com.sanitas.calculator.model.core.OperandExpression;

import java.math.BigDecimal;

import static com.sanitas.calculator.util.Constants.*;

/**
 * Factory pattern
 * Concrete factory for BigDecimal
 * @autor FabianSR
 */
public class ExpressionFactoryImpl implements ExpressionFactory<String, BigDecimal>{

    @Override
    public Expression<BigDecimal> getExpression(final String token) {
        switch (token) {
            case SUM_SIGN: return new AddExpression();
            case MINUS_SIGN: return new SubtractExpression();
            default: return new OperandExpression(BigDecimal.valueOf(Double.valueOf(token)));
        }
    }
}
