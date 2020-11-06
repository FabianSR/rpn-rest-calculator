package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.AbstractBinaryOperation;

public class DivideExpression extends AbstractBinaryOperation<Long>{
    @Override
    protected Long execute(final Long a, final Long b) { return a/b;}
}
