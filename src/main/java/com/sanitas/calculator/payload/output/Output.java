package com.sanitas.calculator.payload.output;

import com.sanitas.calculator.payload.input.Input;

/**
 * @autor FabianSR
 */
public final class Output {

    private Input input;
    private String evaluatedExpression;

    private Output() {
    }

    public Input getInput() {
        return input;
    }

    public String getEvaluatedExpression() {
        return evaluatedExpression;
    }

    public static OutputBuilder builder() {
        return new OutputBuilder();
    }

    /**
     * Builder Pattern
     * evaluatedExpresion cannot be change after that Output be build.
     * This DOES NOT PREVENT that its internal attribute (input) from
     * being accessed and its "expression" field from being modiefied
     * (using its setExpression method)
     */
    public static final class OutputBuilder {

        private Output output;

        private OutputBuilder() {
            output = new Output();
        }

        public OutputBuilder input(final Input in) {
            output.input = in;
            return this;
        }

        public OutputBuilder evaluation(final String expression) {
            output.evaluatedExpression = expression;
            return this;
        }

        public Output build() {
            return output;
        }
    }

    @Override
    public String toString() {
        return "Output -> {" + input +
                ", \"evaluatedExpression\":\"" + evaluatedExpression + '\"' +
                '}';
    }
}
