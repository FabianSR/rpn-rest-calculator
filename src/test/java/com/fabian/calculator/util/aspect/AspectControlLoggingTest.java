package com.fabian.calculator.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    public void controlEntryAndExistBusinessMethods_withCorrestJoinPointProcces_shoulResturnCorrectResponse() throws Throwable {
        //Given
        when(joinPoint.proceed()).thenReturn("test");
        //When
        Object result = aspect.controlEntryAndExistBusinessMethods(joinPoint);
        //Then
        assertThat(result, is(not(nullValue())));
        assertThat(result instanceof String, is(true));
        assertThat(result, is(equalTo("test")));
    }
}