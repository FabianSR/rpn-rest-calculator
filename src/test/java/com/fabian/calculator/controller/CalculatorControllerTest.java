package com.fabian.calculator.controller;

import com.fabian.calculator.payload.input.Input;
import com.fabian.calculator.payload.output.Output;
import com.fabian.calculator.service.CalculatorService;
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
        when(calculatorService.process("2 3 +")).thenReturn("5");
        Input in = new Input();
        in.setExpression("2 3 +");
        //When
        Output result = calculatorController.calculate(in);
        //Then
        assertThat(result, notNullValue());
        assertThat(result.getExpression(), is(equalTo("5")));
        verify(calculatorService, times(1)).process("2 3 +");
    }
}
