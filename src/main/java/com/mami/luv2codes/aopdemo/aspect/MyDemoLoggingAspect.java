package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

    @Before("execution( * add*(..))")
    public void addAccountAdvice() {

        System.out.println("\n =====>>> Execution @Before advice on method addAccount");
    }
}
