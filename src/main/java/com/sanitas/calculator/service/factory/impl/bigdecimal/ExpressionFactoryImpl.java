package com.sanitas.calculator.service.factory.impl.bigdecimal;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.domain.bigdecimal.AddExpression;
import com.sanitas.calculator.model.domain.bigdecimal.DivideExpression;
import com.sanitas.calculator.model.domain.bigdecimal.MultiplyExpression;
import com.sanitas.calculator.model.domain.bigdecimal.SubtractExpression;
import com.sanitas.calculator.service.factory.ExpressionFactory;
import com.sanitas.calculator.model.core.OperandExpression;

import java.math.BigDecimal;

import static com.sanitas.calculator.util.Constants.*;

public class ExpressionFactoryImpl implements ExpressionFactory<String, BigDecimal>{

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
