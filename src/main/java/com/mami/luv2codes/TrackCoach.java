package com.mami.luv2codes;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Run a hard 5k";

    }

    public String getdailyFortune() {
        return "Just do it " + fortuneService.getFortune();
    }
}
