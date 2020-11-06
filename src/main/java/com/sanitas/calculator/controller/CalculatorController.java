package com.sanitas.calculator.controller;

import com.sanitas.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String calculate(final @RequestBody String in) {
        return calculatorService.process(in);
    }
}
