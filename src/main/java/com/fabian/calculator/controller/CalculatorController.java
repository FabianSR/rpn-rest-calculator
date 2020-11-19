package com.fabian.calculator.controller;

import com.fabian.calculator.payload.output.Output;
import com.fabian.calculator.service.CalculatorService;
import com.fabian.calculator.payload.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @autor FabianSR
 */
@RestController
@RequestMapping(value="/calculator")
public class CalculatorController {

    private static final String VERSION="/v1";

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(final CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value = VERSION+"/evaluation", method = POST)
    public Output calculate(final @RequestBody Input input){
        return new Output(calculatorService.process(input.getExpression().trim()));
    }
}
