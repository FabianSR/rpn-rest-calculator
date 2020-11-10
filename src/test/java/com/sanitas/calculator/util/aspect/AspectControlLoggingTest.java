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

    private AspectLogging aspect;

    @Before
    public void setUp() {
        aspect = new AspectLogging();
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
}