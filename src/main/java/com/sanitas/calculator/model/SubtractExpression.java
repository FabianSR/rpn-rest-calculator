package com.sanitas.calculator.model;

public class SubtractExpression extends AbstractBinaryOperation{
    @Override
    protected Long execute(final Long a, final Long b) { return a-b;}
}
