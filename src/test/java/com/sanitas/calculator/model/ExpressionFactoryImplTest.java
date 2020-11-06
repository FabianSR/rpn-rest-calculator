package com.sanitas.calculator.model;

import com.sanitas.calculator.model.core.ExpressionFactory;
import com.sanitas.calculator.util.Constants;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExpressionFactoryImplTest {

    private ExpressionFactory expressionFactory;

    @Before
    public void setUp(){
        expressionFactory = new ExpressionFactoryImpl<>();
    }

    @Test
    public void getExpresion_withSumSign_shouldRestunAddExpression(){
        //Given
        //When
        //Then
        assertThat(expressionFactory.getExpresion(Constants.SUM_SIGN) instanceof AddExpression,is(true));

    }
    @Test
    public void getExpresion_withMinuSign_shouldRestunSubtractExpression(){
        //Given
        //When
        //Then
        assertThat(expressionFactory.getExpresion(Constants.MINUS_SIGN) instanceof SubtractExpression,is(true));

    }
    @Test
    public void getExpresion_withMultiSign_shouldRestunMultiExpression(){
        //Given
        //When
        //Then
        assertThat(expressionFactory.getExpresion(Constants.MULTI_SIGN) instanceof MultiplyExpression,is(true));

    }
    @Test
    public void getExpresion_withDivSign_shouldRestunDivideExpression(){
        //Given
        //When
        //Then
        assertThat(expressionFactory.getExpresion(Constants.DIV_SIGN) instanceof DivideExpression,is(true));

    }
}
