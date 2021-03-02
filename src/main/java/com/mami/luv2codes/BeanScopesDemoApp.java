package com.mami.luv2codes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopesDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        Coach myCoach = ctx.getBean("trackCoach", Coach.class);

        Coach alphaCoach = ctx.getBean("trackCoach", Coach.class);

        System.out.println(myCoach == alphaCoach);

        ctx.close();

    }
}
