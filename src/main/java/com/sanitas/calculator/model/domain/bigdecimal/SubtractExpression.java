package com.sanitas.calculator.model.domain.bigdecimal;

import java.math.BigDecimal;

public class SubtractExpression extends AbstractBigDecimalExpression {
    @Override
    protected BigDecimal execute(final BigDecimal a, final BigDecimal b) { return a.subtract(b,getPrecision());}
}
