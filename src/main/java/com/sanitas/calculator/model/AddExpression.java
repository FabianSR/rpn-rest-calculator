package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.AbstractBinaryOperation;

public class AddExpression extends AbstractBinaryOperation<Long> {
    @Override
    protected Long execute(final Long a, final Long b) { return a+b;}
}
