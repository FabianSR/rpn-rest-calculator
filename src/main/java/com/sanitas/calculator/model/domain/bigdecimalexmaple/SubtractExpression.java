package com.sanitas.calculator.model.domain.bigdecimalexmaple;

import com.sanitas.calculator.model.core.AbstractBinaryOperation;

import java.math.BigDecimal;

public class SubtractExpression extends AbstractBinaryOperation<BigDecimal> {
    @Override
    protected BigDecimal execute(final BigDecimal a, final BigDecimal b) { return a.subtract(b);}
}
