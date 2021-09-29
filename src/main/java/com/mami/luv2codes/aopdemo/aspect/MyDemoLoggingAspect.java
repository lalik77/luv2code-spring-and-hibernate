package com.mami.luv2codes.aopdemo.aspect;

import com.mami.luv2codes.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
