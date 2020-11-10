package com.sanitas.calculator.util;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExceptionsHandlerTest {

    private ExceptionsHandler exceptionsHandler;

    @Before
    public void setUp() {
        exceptionsHandler = new ExceptionsHandler();
    }

    @Test
    public void badRequest_withEmptyStackException_shouldReturnExpressionInNotComplete() {
        //Given
        //When
        final String result = exceptionsHandler.badRequest(new EmptyStackException());
        //Then
        assertThat(result, is(Constants.EXPRESSION_IS_NOT_COMPLETE));
    }

    @Test
    public void badRequest_withNumberFormatException_shouldReturnNonNumericOperand() {
        //Given
        //When
        final String result = exceptionsHandler.badRequest(new NumberFormatException());
        //Then
        assertThat(result, is(Constants.NOT_NUMERIC_OPERAND));
    }


    @Test
    public void internalErrorRequest_withRuntimeException_shouldReturnErrorString() {
        //Given
        //When
        final String result = exceptionsHandler.internalErrorRequest(new RuntimeException());
        //Then
        assertThat(result, is(Constants.ERROR));
    }
}
