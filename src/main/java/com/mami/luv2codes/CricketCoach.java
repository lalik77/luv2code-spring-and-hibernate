package com.mami.luv2codes;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    public CricketCoach() {

        System.out.println("Inside no arg constructor CricketCoach.class");
    }

    public void setFortuneService(FortuneService fortuneService) {

        System.out.println("Inside setter method CricketCoach.class");

        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    public String getdailyFortune() {
        return fortuneService.getFortune();
    }
}
