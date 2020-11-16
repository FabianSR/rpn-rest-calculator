package com.fabian.calculator.payload;

public abstract class Payload {

    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(final String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "expression='" + expression;
    }
}
