package com.fabian.calculator.service.impl;


import com.fabian.calculator.model.core.OperandExpression;
import com.fabian.calculator.model.core.OperationExpression;
import com.fabian.calculator.service.factory.ExpressionFactory;
import com.fabian.calculator.util.Constants;
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
        IntStream.range(0, 10).boxed().forEach(s -> {
            when(expressionFactory.getExpression(s.toString())).thenReturn(new OperandExpression(Long.valueOf(s)));
        });
    }

    @Test
    public void evaluate_expressionAddWithOperands_shouldReturnResultEvaluation() {
        //Given
        OperationExpression<Long> addExpression = (a, b) -> a + b;
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(addExpression);
        //When
        String result = calculatorService.evaluate("2 3 +");
        //Then
        assertThat(result, is(equalTo("5")));
    }

    @Test
    public void evaluate_expressionactWithOperands_shouldReturnResultEvaluation() {
        //Given
        OperationExpression<Long> subtractExpression = (a, b) -> a - b;
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(subtractExpression);
        //When
        String result = calculatorService.evaluate("2 3 -");
        //Then
        assertThat(result, is(equalTo("-1")));
    }

    @Test
    public void evaluate_combinedAddAndSubtractExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        OperationExpression<Long> addExpression = (a, b) -> a + b;
        OperationExpression<Long> subtractExpression = (a, b) -> a - b;
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(addExpression);
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(subtractExpression);
        //When
        String result = calculatorService.evaluate("2 3 + 8 -");
        //Then
        assertThat(result, is(equalTo("-3")));
    }

    @Test
    public void evaluate_combinedExpressionWithOperands_shouldReturnResultEvaluation() {
        //Given
        // 2 3 + 8 - 5 2 + + -> (2+3-8)+(5+2)
        OperationExpression<Long> addExpression = (a, b) -> a + b;
        OperationExpression<Long> subtractExpression = (a, b) -> a - b;
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(addExpression);
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(subtractExpression);
        //When
        String result = calculatorService.evaluate("2 3 + 8 - 5 2 + +");
        //Then
        assertThat(result, is(equalTo("4")));
    }

    @Test(expected = EmptyStackException.class)
    public void evaluate_combinedExpressionWithIncorrectNumberOfOperations_shouldThrowEmptyStackException() {
        //Given
        OperationExpression<Long> addExpression = (a, b) -> a + b;
        OperationExpression<Long> subtractExpression = (a, b) -> a - b;
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(addExpression);
        when(expressionFactory.getExpression(Constants.MINUS_SIGN)).thenReturn(subtractExpression);
        //When //Then
        calculatorService.evaluate("2 3 + 8 - 5 2 + + +");
    }

    @Test(expected = NumberFormatException.class)
    public void evaluate_combinedExpressionWithIncorrectCharacters_shouldThrowNumberFormatException() {
        //Given
        when(expressionFactory.getExpression("?")).thenThrow(new NumberFormatException());
        //When //Then
        calculatorService.evaluate("2 ?");
    }

    @Test
    public void evaluate_expressionAddWithBigDecimalOperands_shouldReturnResultEvaluation() {
        //Given
        OperationExpression<BigDecimal> addExpression = (a, b) -> a.add(b);
        when(expressionFactory.getExpression(Constants.SUM_SIGN)).thenReturn(addExpression);
        when(expressionFactory.getExpression("2.0")).thenReturn(new OperandExpression(BigDecimal.valueOf(Double.valueOf("2.0"))));
        when(expressionFactory.getExpression("3")).thenReturn(new OperandExpression(BigDecimal.valueOf(Double.valueOf("3"))));
        //When
        String result = calculatorService.evaluate("2.0 3 +");
        //Then
        assertThat(result, is(equalTo("5.0")));
    }
}
