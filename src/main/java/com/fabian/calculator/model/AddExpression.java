package com.fabian.calculator.model;

import java.math.BigDecimal;

public class AddExpression extends AbstractBigDecimalExpression {

    @Override
    protected BigDecimal execute(final BigDecimal a, final BigDecimal b) { return a.add(b,getPrecision());}
}
