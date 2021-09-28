package com.mami.luv2codes.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

    @Before("com.mami.luv2codes.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void logToCloudAsync (JoinPoint joinPoint){

        System.out.println("\n =====>>> Logging to Cloud in async fashion");

        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();

        System.out.println("Method in MyCloudAsyncAspect class " + methodSignature);

    }
}
