package com.sanitas.calculator.controller;

import com.sanitas.calculator.payload.input.Input;
import com.sanitas.calculator.payload.output.Output;
import com.sanitas.calculator.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.*;
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
    public void calculate_expressionAddWithOperands_shouldReturnResultEvaluation() {
        //Given
        Input in = new Input();
        in.setExpression("2 3 +");
        when(calculatorService.process(anyString())).thenReturn("5");
        //When
        Output result = calculatorController.calculate(in);
        //Then
        assertThat(result, notNullValue());
        assertThat(result.getEvaluatedExpression(), is(equalTo("5")));
        verify(calculatorService, times(1)).process("2 3 +");
    }
}
