package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.mami.luv2codes.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics (JoinPoint joinPoint){

        System.out.println("\n =====>>> Execution Performing API Analytics");


        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method : " + methodSignature);
    }
}
