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

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {



    @Around("execution(* com.mami.luv2codes.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAspect(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print out method we are advising on

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @Around  on method: " + method);


        // get begin timestamp

        long begin = System.currentTimeMillis();

        // now lets execute the method

        Object result = theProceedingJoinPoint.proceed();
;
        // get end timestamp

        long end = System.currentTimeMillis();

        //compute duration and display it

        long duration = end - begin;

        System.out.println("\n======> Duration :" + duration / 1000.0 + " seconds");

        return result;


    }

    @After("execution(* com.mami.luv2codes.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJp) {

        String method = theJp.getSignature().toShortString();
        System.out.println("\n======> Executing @After (finally) on method: " + method);

    }


    @AfterThrowing(
            pointcut = "execution(* com.mami.luv2codes.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc
    ) {

        //print out which method we are advising on

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterThrowing on method: " + method);


        // log the exception

        System.out.println("\n=======>> The exception is :" + theExc);


    }





    @AfterReturning(
            pointcut = "execution(* com.mami.luv2codes.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJP,
            List<Account> result    )
    {
        String method = theJP.getSignature().toShortString();
        System.out.println("\n======> Executing @AfterReturning on method: " + method);

        convertAccountNamesToUppercase(result);

        System.out.println("====> result is : " + result);

        // les's post-process the data - let's modify it

        // converts account names to uppercase






    }

    private void convertAccountNamesToUppercase(List<Account> result) {

        //loop through accounts

        for(Account tmp : result) {

            //get uppercase version of name
            String theUpperName = tmp.getName().toUpperCase();

            //update the name on the acc
            tmp.setName(theUpperName);

        }


    }

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
