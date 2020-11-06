package com.sanitas.calculator.service.impl;


import com.sanitas.calculator.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class CalculatorServiceImplTest {


    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void evaluate_expressionAddWithOperands_souldReturnResultEvaluation() {
        //Given
        //When
        String result = calculatorService.evaluate("2+3");
        //Then
        //TO-DO
        assertThat(result, nullValue());
    }
}
