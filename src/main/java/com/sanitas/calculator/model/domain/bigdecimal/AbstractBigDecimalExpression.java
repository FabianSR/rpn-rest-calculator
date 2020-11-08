package com.sanitas.calculator.model.domain.bigdecimal;

import com.sanitas.calculator.model.core.AbstractBinaryOperation;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL32;

public abstract class AbstractBigDecimalExpression extends AbstractBinaryOperation<BigDecimal> {

    private MathContext precision;

    protected AbstractBigDecimalExpression(final MathContext precision) {
        this.precision = precision;
    }

    /**
     * Default precision
     */
    protected AbstractBigDecimalExpression() {
        this(DECIMAL32);
    }

    MathContext getPrecision() {
        return precision;
    }


}
