package com.mami.luv2codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    FortuneService fortuneService;


    public TennisCoach() {

        System.out.println( "inside no arg Constructor of TennisCoach");

    }


    @Override
    public String getDailyWorkout() {
        return " Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {

       return fortuneService.getFortune();

    }
}
