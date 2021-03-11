package com.mami.luv2codes;

public class SwimCoach {

  FortuneService fortuneService;

    public SwimCoach() {
    }

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {

        return "Swim 1000 meters as warm up";

    }

    public String getDailyFortune() {

        return fortuneService.getFortune();

    }
}
