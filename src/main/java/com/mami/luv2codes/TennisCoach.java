package com.mami.luv2codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    FortuneService fortuneService;


    public TennisCoach() {

        System.out.println( "inside no arg Constructor of TennisCoach");

    }


    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter method of TennisCoach");
        this.fortuneService = fortuneService;
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
