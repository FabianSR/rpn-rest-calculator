package com.fabian.calculator.service.impl;


import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.util.Constants;
import com.fabian.calculator.model.AddExpression;
import com.fabian.calculator.model.SubtractExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
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
            when(expressionFactory.getExpression(s.toString())).thenReturn( new OperandExpression(BigDecimal.valueOf(s)));
        });
    }

    @Test
    public void evaluate_expressionAddWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn( new AddExpression());
        //When
        String result = calculatorService.process("2 3 +");
        //Then
        assertThat(result, is(equalTo("5")));
    }

    @Test
    public void evaluate_expressionactWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When
        String result = calculatorService.process("2 3 -");
        //Then
        assertThat(result, is(equalTo("-1")));
    }

    @Test
    public void evaluate_combinedAddAndSubtractExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When
        String result = calculatorService.process("2 3 + 8 -");
        //Then
        assertThat(result, is(equalTo("-3")));
    }

    @Test
    public void evaluate_combinedExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        // 2 3 + 8 - 5 2 + + -> (2+3-8)+(5+2)
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
         //When
        String result = calculatorService.process("2 3 + 8 - 5 2 + +");
        //Then
        assertThat(result, is(equalTo("4")));
    }

    @Test(expected= EmptyStackException.class)
    public void evaluate_combinedExpressionWithIncorrectNumberOfOperations_shouldThrowEmptyStackException() {
        //Given
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When //Then
        calculatorService.process("2 3 + 8 - 5 2 + + +");
    }

    @Test(expected= NullPointerException.class)
    public void evaluate_combinedExpressionWithIncorrectCharacters_shouldThrowNullPointerException() {
        //Given
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(new AddExpression());
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(new SubtractExpression());
        //When //Then
        calculatorService.process("2 ?");
    }
}
