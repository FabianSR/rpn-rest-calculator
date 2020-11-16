package com.fabian.calculator;

import com.fabian.calculator.service.factory.ExpressionFactory;
import com.fabian.calculator.service.factory.impl.ExpressionFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfig {

    /**
     * Change factory instance for operations in other
     * domains
     * @return
     */
    @Bean
    public ExpressionFactory getExpressionFactory() {
        return new ExpressionFactoryImpl();
    }
}