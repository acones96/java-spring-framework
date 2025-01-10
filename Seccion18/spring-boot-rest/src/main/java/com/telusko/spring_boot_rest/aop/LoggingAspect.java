package com.telusko.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/*
    Aspect (When-Conceptual) - @Aspect is the third key concept from the notes.
    Advice (What) - @Before is the second key concept from the notes.
    Pointcut (Where-Operational) - execution() is the first key concept from the notes.
    JoinPoint (When) - JoinPoint argument we call jp.getSignature().getName() to get the name of the method where is called.
*/

@Aspect // Call the method as an AOP
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // For execution, we need to name it: "execution(<return-type> <fully-qualified-class-name>.<method-name>(<parameter>))". We can indicate all (*) for each argument

//    @Before("execution(void com.telusko.spring_boot_rest.service.JobService.addJob())")
    @Before("execution(* com.telusko.spring_boot_rest.service.JobService.*(..))") // Run for all methods in service package before his execution
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    // Run for all methods in service package after finish his execution
    @After("execution(* com.telusko.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    // Run for all methods in service package only if there's an exception
    @AfterThrowing("execution(* com.telusko.spring_boot_rest.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues " + jp.getSignature().getName());
    }

    // Run for all methods in service package when it runs successfully
    @AfterReturning("execution(* com.telusko.spring_boot_rest.service.JobService.*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully " + jp.getSignature().getName());
    }
}
