package com.sanitas.calculator.payload.output;

import com.sanitas.calculator.payload.Payload;

public final class Output extends Payload {

    public Output() {
    }

    public Output(final String expression) {
        this.setExpression(expression);
    }
    @Override
    public String toString() {
        return "Output{" +
                super.toString() +
                '}';
    }
}
