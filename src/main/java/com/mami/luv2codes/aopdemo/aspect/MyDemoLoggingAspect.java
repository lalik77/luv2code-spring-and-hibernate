package com.mami.luv2codes.aopdemo.aspect;

import com.mami.luv2codes.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.mami.luv2codes.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
    public void addAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n =====>>> Execution @Before advice on method addAccountAdvice");


        //Display method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();

        System.out.println("Method :" + methodSignature);



        //Display method arguments

        Object[] args = joinPoint.getArgs();

        for (Object o : args) {
            System.out.println(o);

            if(o instanceof Account){
                Account theAcc=(Account)o;
                System.out.println("name:"+theAcc.getName());
                System.out.println(("level" + theAcc.getLevel()));
            }



        }



    }







}
