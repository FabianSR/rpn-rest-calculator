package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.mockito.MockitoAnnotations;

public class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculate_expressionAddWithOperands_souldReturnResultEvaluation() {
        //Given
        when(calculatorService.evaluate(anyString())).thenReturn("5");
        //When
        String result = calculatorController.calculate("2+3");
        //Then
        assertThat(result, is(equalTo("5")));
        verify(calculatorService, times(1)).evaluate("2+3");
    }
}
