package com.sanitas.calculator.service.factory.impl.integer;

import com.sanitas.calculator.service.factory.ExpressionFactory;
import com.sanitas.calculator.model.core.OperandExpression;
import com.sanitas.calculator.model.domain.integer.*;
import static com.sanitas.calculator.util.Constants.*;

import com.sanitas.calculator.service.factory.impl.integer.ExpressionFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for integers (long)
 */
public class ExpressionFactoryImplTest {

    private ExpressionFactory expressionFactory;

    @Before
    public void setUp(){
        expressionFactory = new ExpressionFactoryImpl();
    }

    @Test
    public void getExpression_withSumSign_shouldRestunAddExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectIntance(SUM_SIGN, AddExpression.class), is(true));
    }

    @Test
    public void getExpression_withMinuSign_shouldRestunSubtractExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectIntance(MINUS_SIGN, SubtractExpression.class),is(true));

    }
    @Test
    public void getExpression_withNumericCharacter_shouldRestunOperandExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectIntance("7", OperandExpression.class),is(true));

    }

    private <T> boolean isCorrectIntance(final String sign, Class<T> clazz) {
        return clazz.isInstance(expressionFactory.getExpression(sign));
    }
}
