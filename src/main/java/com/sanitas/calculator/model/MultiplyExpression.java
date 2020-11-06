package com.sanitas.calculator.model;

public class MultiplyExpression extends AbstractBinaryOperation{
    @Override
    protected Long execute(final Long a, final Long b) { return a*b;}
}
