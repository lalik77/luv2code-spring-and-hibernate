package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {


    @Pointcut("execution( * com.mami.luv2codes.aopdemo.dao.*.* (..))")
    private void forDaoPackage() {

    }

    @Before("forDaoPackage()")
    public void addAccountAdvice() {

        System.out.println("\n =====>>> Execution @Before advice on method addAccount");
    }
}
