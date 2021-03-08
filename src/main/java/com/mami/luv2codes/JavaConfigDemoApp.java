package com.mami.luv2codes;

import com.mami.luv2codes.config.SportSpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportSpringConfig.class);

        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);

        tennisCoach.getDailyFortune();

        context.close();
    }
}
