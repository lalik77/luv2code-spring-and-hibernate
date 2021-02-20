package com.mami.luv2codes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CricketCoach cricketCoach = classPathXmlApplicationContext.getBean("cricketCoach", CricketCoach.class);

        System.out.println(cricketCoach.getDailyFortune() + "\n email = " + cricketCoach.getEmail() +  "\n Team =  " + cricketCoach.getTeam() + " \n Best regards -)");

        classPathXmlApplicationContext.close();
    }
}
