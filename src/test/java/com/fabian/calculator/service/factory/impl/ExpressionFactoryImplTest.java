package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.AddExpression;
import com.fabian.calculator.model.DivideExpression;
import com.fabian.calculator.model.MultiplyExpression;
import com.fabian.calculator.model.SubtractExpression;
import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;
import org.junit.Before;
import org.junit.Test;

import static com.fabian.calculator.util.Constants.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for integers (bigDecimal)
 */
public class ExpressionFactoryImplTest {

    private ExpressionFactory expressionFactory;

    @Before
    public void setUp(){
        expressionFactory = new ExpressionFactoryImpl();
    }

    @Test
    public void getExpression_withSumSign_shouldReturnAddExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectInstance(SUM_SIGN, AddExpression.class), is(true));
    }

    @Test
    public void getExpression_withMinuSign_shouldReturnSubtractExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectInstance(MINUS_SIGN, SubtractExpression.class),is(true));
    }

    @Test
    public void getExpression_withMultiSign_shouldReturnMultiplyExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectInstance(MULTI_SIGN, MultiplyExpression.class),is(true));
    }

    @Test
    public void getExpression_withDivSign_shouldReturnDivideExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectInstance(DIV_SIGN, DivideExpression.class),is(true));
    }

    @Test
    public void getExpression_withNumericCharacter_shouldReturnOperandExpression(){
        //Given
        //When
        //Then
        assertThat(isCorrectInstance("7", OperandExpression.class),is(true));

    }

    private <T> boolean isCorrectInstance(final String sign, Class<T> clazz) {
        return clazz.isInstance(expressionFactory.getExpression(sign));
    }
}
