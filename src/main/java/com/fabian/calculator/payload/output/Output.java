package com.fabian.calculator.payload.output;

import com.fabian.calculator.payload.Payload;

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
