package com.mami.luv2codes.aopdemo;

import com.mami.luv2codes.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        //read Spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from the Spring container

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);


        List<Account> theAcc = theAccountDAO.findAccounts();

        System.out.println("\n\nMain program : AfterReturningDemoApp");

        System.out.println(theAcc);


        context.close();

        // close th context


    }
}
