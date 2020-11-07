package com.sanitas.calculator.payload.input;

/**
 * @autor FabianSR
 */
public class Input {
    private String expression;
    public String getExpression() {
        return expression;
    }
    public void setExpression(final String expression) {
        this.expression = expression;
    }
    @Override
    public String toString() {
        return "Input -> {" +
                "\"expression\": \"" + expression + "\"" +
                '}';
    }
}
