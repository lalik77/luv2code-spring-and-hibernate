package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.mami.luv2codes.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics (){

        System.out.println("\n =====>>> Execution Performing API Analytics");
    }
}
