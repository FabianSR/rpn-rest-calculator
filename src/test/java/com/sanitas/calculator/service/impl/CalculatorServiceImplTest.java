package com.sanitas.calculator.service.impl;


import com.sanitas.calculator.service.CalculatorService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void evaluate_expressionAddWithOperands_shouldReturnResultEvaluation() {
        //Given
        //When
        Long result = calculatorService.process("2 3 +");
        //Then
        assertThat(result, is(equalTo(5l)));
    }

    @Test
    public void evaluate_expressionactWithOperands_shouldReturnResultEvaluation() {
        //Given
        //When
        Long result = calculatorService.process("2 3 -");
        //Then
        assertThat(result, is(equalTo(-1l)));
    }

    @Test
    public void evaluate_expressionMultiplyWithOperands_shouldReturnResultEvaluation() {
        //Given
        //When
        Long result = calculatorService.process("2 3 *");
        //Then
        //TO-DO
        assertThat(result, is(equalTo(6l)));
    }

    @Test
    public void evaluate_expressionDivideWithOperands_shouldReturnResultEvaluation() {
        //Given
        //When
        Long result = calculatorService.process("2 3 /");
        //Then
        //TO-DO
        assertThat(result, is(equalTo(0l)));
    }

    @Test
    public void evaluate_combinedAddAndSubtractExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        //When
        Long result = calculatorService.process("2 3 + 8 -");
        //Then
        //TO-DO
        assertThat(result, is(equalTo(-3l)));
    }

    @Test
    public void evaluate_combinedExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        // 2 3 + 8 - 5 2 * * -> (2+3-8)*(5*2)
        //When
        Long result = calculatorService.process("2 3 + 8 - 5 2 * *");
        //Then
        //TO-DO
        assertThat(result, is(equalTo(-30l)));
    }
}
