package com.fabian.calculator.model;

import com.fabian.calculator.model.core.AbstractBinaryOperation;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL128;

public abstract class AbstractBigDecimalExpression extends AbstractBinaryOperation<BigDecimal> {

    private MathContext precision;

    protected AbstractBigDecimalExpression(final MathContext precision) {
        this.precision = precision;
    }

    /**
     * Default precision
     */
    protected AbstractBigDecimalExpression() {
        this(DECIMAL128);
    }

    MathContext getPrecision() {
        return precision;
    }


}
