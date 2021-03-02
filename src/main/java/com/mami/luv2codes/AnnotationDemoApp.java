package com.mami.luv2codes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Coach thatSillyCoach = context.getBean("thatSillyCoach", Coach.class);

        System.out.println(thatSillyCoach.getDailyWorkout());

        context.close();
    }
}
