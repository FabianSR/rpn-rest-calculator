package com.fabian.calculator.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.EmptyStackException;

import static com.fabian.calculator.util.Constants.*;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({EmptyStackException.class, NumberFormatException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String badRequest(Exception e) {
        Logger.getLoggerInstance().trace(e);
        return e instanceof EmptyStackException ? EXPRESSION_IS_NOT_COMPLETE : NOT_NUMERIC_OPERAND;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalErrorRequest(Exception e) {
        Logger.getLoggerInstance().trace(e);
        return ERROR;
    }

}
