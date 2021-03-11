package com.mami.luv2codes;

import com.mami.luv2codes.config.SportSpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportSpringConfig.class);

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(swimCoach.getDailyWorkout());

        System.out.println(swimCoach.getDailyFortune());

        context.close();
    }
}
