package com.mami.luv2codes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        BaseballCoach baseballCoach = ctx.getBean("baseballCoach", BaseballCoach.class);

        System.out.println(baseballCoach.getDailyWorkout());

        System.out.println(baseballCoach.getdailyFortune());


        TrackCoach trackCoach = ctx.getBean("trackCoach",TrackCoach.class);

        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getdailyFortune());



       // FortuneService fortuneService = ctx.getBean("myFortuneService",FortuneService.class);

        //System.out.println(fortuneService.getFortune());

        ( (ClassPathXmlApplicationContext )ctx).close();




    }
}
