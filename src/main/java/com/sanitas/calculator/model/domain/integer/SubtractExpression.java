package com.sanitas.calculator.model.domain.integer;

import com.sanitas.calculator.model.core.AbstractBinaryOperation;

public class SubtractExpression extends AbstractBinaryOperation<Long> {
    @Override
    protected Long execute(final Long a, final Long b) { return a-b;}
}
