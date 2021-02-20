package com.mami.luv2codes;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach() {
        System.out.println("No arg constructor called "  + "fortune service = " + fortuneService);
    }

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {

        return "Spend 30 minutes on batting practice";

    }

    public String getDailyFortune() {

        return fortuneService.getFortune();
    }
}
