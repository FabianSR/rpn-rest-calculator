package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.core.ExpressionFactory;
import org.springframework.stereotype.Component;

import static com.sanitas.calculator.util.Constants.*;

@Component
public class ExpressionFactoryImpl<String> implements ExpressionFactory{

    @Override
    public <T> Expression getExpresion(final T token) {
        switch (token.toString()) {
            case SUM_SIGN: return new AddExpression();
            case MINUS_SIGN: return new SubtractExpression();
            case MULTI_SIGN: return new MultiplyExpression();
            case DIV_SIGN: return new DivideExpression();
            default: return new OperandExpression(Long.parseLong(token.toString()));
        }
    }
}
