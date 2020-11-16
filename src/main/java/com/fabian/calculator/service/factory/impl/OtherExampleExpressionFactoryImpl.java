package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.core.AbstractBinaryOperation;
import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;

import static com.fabian.calculator.util.Constants.*;

public class OtherExampleExpressionFactoryImpl implements ExpressionFactory<String, Long> {

    @Override
    public Expression<Long> getExpression(final String token) {
        switch (token) {
            case SUM_SIGN: return new AddExpression();
            case MINUS_SIGN: return new SubtractExpression();
            case MULTI_SIGN: return new MultiplyExpression();
            case DIV_SIGN: return new DivideExpression();
            default: return new OperandExpression(Long.valueOf(token));
        }
    }
}

class AddExpression extends AbstractBinaryOperation<Long> {
    protected Long execute(Long a, Long b) { return a + b; }
}
class SubtractExpression extends AbstractBinaryOperation<Long> {
    protected Long execute(Long a, Long b) { return a - b; }
}
class MultiplyExpression extends AbstractBinaryOperation<Long> {
    protected Long execute(Long a, Long b) { return a * b; }
}
class DivideExpression extends AbstractBinaryOperation<Long> {
    protected Long execute(Long a, Long b) { return a / b; }
}