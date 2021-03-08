package com.mami.luv2codes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    FortuneService fortuneService;


    public TennisCoach() {

        System.out.println( ">>inside no arg Constructor of TennisCoach");

    }

    @PostConstruct
    private void doMyInit() {
        System.out.println(">>inside doMyInit");
    }

    @PreDestroy
    private void doMyDestroy() {
        System.out.println(">>inside doMyDestroy");
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
