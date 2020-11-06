package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.Expression;

import java.util.Stack;

/**
 * Template Method parttern
 * @autor FabianSR
 */
public abstract class AbstractBinaryOperation implements Expression {

    /**
     * This pulls the two operands (from the stack) on which the operator will execute.
     * The second operand is unstacked first and then the first,
     * since there are operations that do not fulfill the commutative property.
     * The result that could be used as an operand if there is a composition
     * of operations is saved on the same stack.
     * @param context
     */
    @Override
    public final void interpret(Stack<Long> context) {
        Long tmp = context.pop();
        context.push(execute(context.pop(),tmp));
    }

    /**
     * Applies the operator corresponding to the operands' a 'and 'b'.
     * Each concrete implementation corresponds to an operation.
     */
    protected abstract Long execute(final Long a, final Long b);
}
