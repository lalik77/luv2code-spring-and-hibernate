package com.mami.luv2codes.aopdemo;

import com.mami.luv2codes.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        //read Spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the Spring container

    TrafficFortuneService fortuneService =
            context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain program: AroundDemoApp");
        System.out.println("Calling get fortune");

        String data = fortuneService.getFortune();

        System.out.println("\nMy fortne is :" + data);

        System.out.println("Finished");





        context.close();

        // close th context


    }
}
