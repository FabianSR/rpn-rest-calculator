package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

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
        when(calculatorService.process(anyString())).thenReturn("5");
        //When
        String result = calculatorController.calculate("2 3 +");
        //Then
        assertThat(result, is(equalTo("5")));
        verify(calculatorService, times(1)).process("2 3 +");
    }
}
