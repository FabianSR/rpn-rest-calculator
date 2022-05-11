package com.fabian.calculator.service.factory.impl;

import com.fabian.calculator.model.core.Expression;
import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.model.core.OperationExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;
import org.junit.Before;
import org.junit.Test;

import static com.fabian.calculator.util.Constants.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
        checkObjectInstance(SUM_SIGN, OperationExpression.class);
    }

    @Test
    public void getExpression_withMinuSign_shouldReturnSubtractExpression(){
        //Given
        //When
        //Then
        checkObjectInstance(MINUS_SIGN, OperationExpression.class);
    }

    @Test
    public void getExpression_withMultiSign_shouldReturnMultiplyExpression(){
        //Given
        //When
        //Then
        checkObjectInstance(MULTI_SIGN, OperationExpression.class);
    }

    @Test
    public void getExpression_withDivSign_shouldReturnDivideExpression(){
        //Given
        //When
        //Then
        checkObjectInstance(DIV_SIGN, OperationExpression.class);
    }

    @Test
    public void getExpression_withNumericCharacter_shouldReturnOperandExpression(){
        //Given
        //When
        //Then
        checkObjectInstance("7",OperandExpression.class);
    }

    private <T> void checkObjectInstance(final String sign, Class<T> clazz){
        assertThat(clazz.isInstance(expressionFactory.getExpression(sign)),is(true));
    }
}
