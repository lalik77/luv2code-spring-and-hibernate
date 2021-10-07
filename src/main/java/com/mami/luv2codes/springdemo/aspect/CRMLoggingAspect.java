package com.mami.luv2codes.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {


    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations

    @Pointcut("execution(* com.mami.luv2codes.springdemo.controller.*.*(..))")
    private void forControllerPackge(){

    }

    @Pointcut("execution(* com.mami.luv2codes.springdemo.service.*.*(..))")
    private void forServicePackge(){

    }


    @Pointcut("execution(* com.mami.luv2codes.springdemo.dao.*.*(..))")
    private void forDaoPackge(){

    }

    //combine pointcut expression

    @Pointcut("forControllerPackge() || forDaoPackge() || forServicePackge()")
    private void forAppFlow() {

    }


    //add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        //display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> @Before : calling method :" + method);

        //display the args to the method

    }



    //Add @AfterReturning advice

    public void method(){

    }
}
