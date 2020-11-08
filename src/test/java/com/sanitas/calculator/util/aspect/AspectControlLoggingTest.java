package com.sanitas.calculator.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.EmptyStackException;

import static com.sanitas.calculator.util.Constants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AspectControlLoggingTest {

    @Mock
    private ProceedingJoinPoint joinPoint;

    private AspectControlLogging aspect;

    @Before
    public void setUp() {
        aspect = new AspectControlLogging();
        MockitoAnnotations.initMocks(this);
        when(joinPoint.getSignature()).thenReturn(mock(Signature.class));
        final Object[] arrayArg = {new Object()};
        when(joinPoint.getArgs()).thenReturn(arrayArg);
    }

    @Test
    public void controlEntryAndExistBusinessAndControllerMethods_withCorrestJoinPointProcces_shoulResturnCorrectResponse() throws Throwable {
        //Given
        when(joinPoint.proceed()).thenReturn("test");
        //When
        Object result = aspect.controlEntryAndExistBusinessAndControllerMethods(joinPoint);
        //Then
        assertThat(result, is(not(nullValue())));
        assertThat(result instanceof String, is(true));
        assertThat(result, is(equalTo("test")));
    }

    @Test
    public void controlEntryAndExistBusinessAndControllerMethods_withJoinPointProcessThrowingEmptyStackException_shoulResturnErrorResponse() throws Throwable {
        //Given
        when(joinPoint.proceed()).thenThrow(new EmptyStackException());
        //When
        Object result = aspect.controlEntryAndExistBusinessAndControllerMethods(joinPoint);
        //Then
        assertThat(result, is(not(nullValue())));
        assertThat(result instanceof String, is(true));
        assertThat(result, is(equalTo(EXPRESSION_IS_NOT_COMPLETE)));
    }

    @Test
    public void controlEntryAndExistBusinessAndControllerMethods_withJoinPointProccesThrowingNumberFormatException_shouldReturnErrorResponse() throws Throwable {
        //Given
        when(joinPoint.proceed()).thenThrow(new NumberFormatException());
        //When
        Object result = aspect.controlEntryAndExistBusinessAndControllerMethods(joinPoint);
        //Then
        assertThat(result, is(not(nullValue())));
        assertThat(result instanceof String, is(true));
        assertThat(result, is(equalTo(NOT_NUMERIC_OPERAND)));
    }

    @Test
    public void controlEntryAndExistBusinessAndControllerMethods_withJoinPointProccesThrowingSomeRuntimeException_shouldReturnErrorResponse() throws Throwable {
        //Given
        when(joinPoint.proceed()).thenThrow(new RuntimeException());
        //When
        Object result = aspect.controlEntryAndExistBusinessAndControllerMethods(joinPoint);
        //Then
        assertThat(result, is(not(nullValue())));
        assertThat(result instanceof String, is(true));
        assertThat(result, is(equalTo(ERROR)));
    }
}