package com.mami.luv2codes.aopdemo;

import com.mami.luv2codes.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read Spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


        // get the bean from the Spring container


        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        theAccountDAO.addAccount();




        // call the business method

        context.close();

        // close th context


    }
}
