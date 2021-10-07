package com.mami.luv2codes.aopdemo;

import com.mami.luv2codes.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        //read Spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the Spring container

    TrafficFortuneService fortuneService =
            context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain program: AroundDemoApp");
        myLogger.info("Calling get fortune");

        boolean tripwire = true;
        String data = fortuneService.getFortune(tripwire);



        myLogger.info("\nMy fortune is :" + data);

        myLogger.info("Finished");

        // close th context
        context.close();




    }
}
