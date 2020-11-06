package com.sanitas.calculator.model;

public class DivideExpression extends AbstractBinaryOperation{
    @Override
    protected Long execute(final Long a, final Long b) { return a/b;}
}
