package com.fabian.calculator.util.aspect;

import com.fabian.calculator.util.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

/**
 * @autor FabianSR
 */
@Component
@Aspect
public class AspectLogging {

    @Around("execution(* com.fabian.calculator.service.impl.*.*(..))")
    public Object controlEntryAndExistBusinessMethods(final ProceedingJoinPoint joinPoint) throws Throwable{
        return printLog("business method : %s; input : %s ; response: %s", joinPoint);
    }

    @Around("execution(* com.fabian.calculator.service.factory.impl.*.*(..))")
    public Object printFabricationMethdos(final ProceedingJoinPoint joinPoint) throws Throwable {
        return printLog("fabrication method: %s input token : %s ; instance created: %s", joinPoint);
    }

    private Object printLog(final String message, final ProceedingJoinPoint joinPoint) throws Throwable {
        final Object response = joinPoint.proceed();
        Logger.getLoggerInstance().trace(String.format(message, joinPoint.getSignature().getName(), asList(joinPoint.getArgs()).stream().map(Object::toString).collect(joining()), response));
        return response;
    }
}