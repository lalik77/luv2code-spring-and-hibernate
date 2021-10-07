package com.mami.luv2codes.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;
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

        //get the arguments
        Object[] args = theJoinPoint.getArgs();

        //loop thru and display args

        for(Object o : args) {
            myLogger.info("====>argument: " + o);
        }



    }



    //Add @AfterReturning advice

    @AfterReturning (
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {


        //display method we are returning from
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> @AfterReturning : from method :" + method);


        //display data returned

        myLogger.info("=====> result :" + theResult);

    }
}
