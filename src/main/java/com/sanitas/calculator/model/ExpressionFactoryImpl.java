package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.core.ExpressionFactory;

import static com.sanitas.calculator.util.Constants.*;

public class ExpressionFactoryImpl implements ExpressionFactory<String,Long>{

    @Override
    public Expression getExpresion(final String token) {
        switch (token) {
            case SUM_SIGN: return new AddExpression();
            case MINUS_SIGN: return new SubtractExpression();
            case MULTI_SIGN: return new MultiplyExpression();
            case DIV_SIGN: return new DivideExpression();
            default: return new OperandExpression(Long.parseLong(token));
        }
    }
}
