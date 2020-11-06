package com.sanitas.calculator.service.impl;


import com.sanitas.calculator.model.*;
import com.sanitas.calculator.model.core.Expression;
import com.sanitas.calculator.model.core.ExpressionFactory;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.util.Constants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.IntStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

public class CalculatorServiceImplTest {

    @Mock
    private ExpressionFactory expressionFactory;

    @InjectMocks
    private CalculatorServiceImpl calculatorService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        IntStream.range(0,10).boxed().forEach(s->{
            when(expressionFactory.getExpresion(s.toString())).thenReturn( new OperandExpression(Long.parseLong(s.toString())));
        });
    }

    @Test
    public void evaluate_expressionAddWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpresion(Constants.SUM_SIGN)).thenReturn( new AddExpression());
        //When
        Long result = calculatorService.process("2 3 +");
        //Then
        assertThat(result, is(equalTo(5l)));
    }

    @Test
    public void evaluate_expressionactWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpresion(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When
        Long result = calculatorService.process("2 3 -");
        //Then
        assertThat(result, is(equalTo(-1l)));
    }

    @Test
    public void evaluate_expressionMultiplyWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpresion(Constants.MULTI_SIGN)).thenReturn(new MultiplyExpression());
        //When
        Long result = calculatorService.process("2 3 *");
        //Then
        assertThat(result, is(equalTo(6l)));
    }

    @Test
    public void evaluate_expressionDivideWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpresion(Constants.DIV_SIGN)).thenReturn(new DivideExpression());
        //When
        Long result = calculatorService.process("2 3 /");
        //Then
        assertThat(result, is(equalTo(0l)));
    }

    @Test
    public void evaluate_combinedAddAndSubtractExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpresion(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpresion(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When
        Long result = calculatorService.process("2 3 + 8 -");
        //Then
        assertThat(result, is(equalTo(-3l)));
    }

    @Test
    public void evaluate_combinedExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        // 2 3 + 8 - 5 2 * * -> (2+3-8)*(5*2)
        when(expressionFactory.getExpresion(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpresion(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        when(expressionFactory.getExpresion(Constants.MULTI_SIGN)).thenReturn(new MultiplyExpression());
        //When
        Long result = calculatorService.process("2 3 + 8 - 5 2 * *");
        //Then
        assertThat(result, is(equalTo(-30l)));
    }
}
