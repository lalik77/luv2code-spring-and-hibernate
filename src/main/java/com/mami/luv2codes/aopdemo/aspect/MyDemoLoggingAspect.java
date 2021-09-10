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

    @Pointcut("execution(* com.mami.luv2codes.aopdemo.dao.*.set*(..))")
    private void forSetter() {}

    @Pointcut("execution(* com.mami.luv2codes.aopdemo.dao.*.get*(..))")
    private void forGetter() {}

    // create combine expression

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    private void forDaoPackageNoGetterNoSetter() {}



    @Before("forDaoPackageNoGetterNoSetter()")
    public void addAccountAdvice() {

        System.out.println("\n =====>>> Execution @Before advice on method addAccountAdvice");
    }




    @Before("forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics (){

        System.out.println("\n =====>>> Execution Performing API Analytics");
    }


}
