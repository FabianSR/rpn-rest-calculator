package com.sanitas.calculator;

import com.sanitas.calculator.service.factory.ExpressionFactory;
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
        return new com.sanitas.calculator.service.factory.impl.bigdecimal.ExpressionFactoryImpl();
    }
}