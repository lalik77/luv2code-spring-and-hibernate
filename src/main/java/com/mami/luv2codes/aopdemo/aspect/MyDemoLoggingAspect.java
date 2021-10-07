package com.mami.luv2codes.aopdemo.aspect;

import com.mami.luv2codes.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

    private Logger mylogger = Logger.getLogger(getClass().getName());



    @Around("execution(* com.mami.luv2codes.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAspect(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print out method we are advising on

        String method = theProceedingJoinPoint.getSignature().toShortString();
        mylogger.info("\n======> Executing @Around  on method: " + method);


        // get begin timestamp

        long begin = System.currentTimeMillis();

        // now lets execute the method

        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {

            //log the exception
            mylogger.warning(e.getMessage());

            // rethrow the exception

            throw e;

        }



;
        // get end timestamp

        long end = System.currentTimeMillis();

        //compute duration and display it

        long duration = end - begin;

        mylogger.info("\n======> Duration :" + duration / 1000.0 + " seconds");

        return result;


    }





}
