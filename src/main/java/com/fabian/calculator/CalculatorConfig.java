package com.fabian.calculator;

import com.fabian.calculator.service.factory.ExpressionFactory;
import com.fabian.calculator.service.factory.impl.ExpressionFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FabianSR
 */
@Configuration
public class CalculatorConfig {

    /**
     * Change factory instance for operations in other
     * domains
     * @return
     */
    @Bean
    public ExpressionFactory getExpressionFactory() {
        //Test to change to new com.fabian.calculator.service.factory.impl.OtherExampleExpressionFactoryImpl.OtherExampleExpressionFactoryImpl();
        //It is very fun, you will see that to apply the SOLID principles works!!!
        return new ExpressionFactoryImpl();

    }
}